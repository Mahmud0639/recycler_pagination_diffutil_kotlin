package com.manuni.hello_world.recyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class JuiceViewModel : ViewModel() {
    private var allItems = arrayListOf<JuiceModel>()
    private val _listJuice = MutableLiveData<ArrayList<JuiceModel>>()
    val listJuice: LiveData<ArrayList<JuiceModel>> get() = _listJuice


    val isLoading = MutableLiveData<Boolean>()




//    init {
//        loadJuiceData(1)
//    }


    /**
     * fun loadJuiceData() {
     *     viewModelScope.launch(Dispatchers.IO) {
     *         val juiceItems = loadItems()
     *
     *         // Switch to Main thread to update UI-related state
     *         withContext(Dispatchers.Main) {
     *             // Update LiveData (if you want to use value instead of postValue)
     *             _listJuice.value = juiceItems
     *
     *             // Example: show loading false
     *             // isLoading.value = false
     *
     *             // Example: show a Toast (if in ViewModel with context access)
     *             // Toast.makeText(context, "Loaded!", Toast.LENGTH_SHORT).show()
     *         }
     *     }
     * }
     *
     *
     */

//    fun loadJuiceData(count: Int) {
//
//        viewModelScope.launch{
//            isLoading.value = true
//            delay(3000)
//            _listJuice.value = loadItems(count)
//        }
//    }

    fun loadJuiceData(page: Int) {
        viewModelScope.launch {
            isLoading.value = true
            delay(3000)
            val newItems = loadItems(page)
            if (page == 1) allItems.clear()
            allItems.addAll(newItems)
            _listJuice.value = allItems
        }}

    private fun loadItems(page: Int): ArrayList<JuiceModel> {

        return if(page == 1) {
            arrayListOf(

                JuiceModel(
                    1,
                    "Mint Lemonade - page 1",
                    "Chilled Soda",
                    "Mint Leaves",
                    "Black Salt",
                    "Lemon",
                    "$35"
                ),

                JuiceModel(
                    2,
                    "Tamarind Cooler - page 1",
                    "Cold Water",
                    "Tamarind Pulp",
                    "Jaggery",
                    "Cumin Powder",
                    "$40"
                ),

                JuiceModel(
                    3,
                    "Rose Shorbot - page 1",
                    "Chilled Milk",
                    "Rose Syrup",
                    "Sugar",
                    "Ice Cubes",
                    "$38"
                ),

                JuiceModel(
                    4,
                    "Cucumber Mint - page 1",
                    "Cold Water",
                    "Cucumber Juice",
                    "Mint Extract",
                    "Salt",
                    "$42"
                ),

                JuiceModel(
                    5,
                    "Orange Fizz - page 1",
                    "Soda Water",
                    "Orange Juice",
                    "Sugar Syrup",
                    "Lemon Zest",
                    "$45"
                ),

                JuiceModel(
                    6,
                    "Ginger Lemonade - page 1",
                    "Chilled Water",
                    "Ginger Juice",
                    "Lemon Juice",
                    "Honey",
                    "$37"
                ),

                JuiceModel(
                    7,
                    "Aam Panna - page 1",
                    "Cold Water",
                    "Raw Mango Pulp",
                    "Cumin Powder",
                    "Mint Leaves",
                    "$43"
                ),

                JuiceModel(
                    8,
                    "Kokum Shorbot - page 1",
                    "Chilled Water",
                    "Kokum Syrup",
                    "Sugar",
                    "Salt",
                    "$41"
                ),

                JuiceModel(
                    9,
                    "Watermelon Splash - page 1",
                    "Chilled Watermelon Juice",
                    "Mint",
                    "Lemon Juice",
                    "Sugar",
                    "$39"
                ),

                JuiceModel(
                    10,
                    "Pineapple Ginger - page 1",
                    "Cold Water",
                    "Pineapple Juice",
                    "Ginger Extract",
                    "Salt",
                    "$44"
                )


            )

        } else if(page == 2) {
            arrayListOf(
                JuiceModel(
                    11,
                    "Salad pop - page 2",
                    "pip test",
                    "cold tots",
                    "tim lel",
                    "kol",
                    "$38"
                ),
                JuiceModel(
                    12,
                    "Tropical Mango - page 2",
                    "Mango Pulp",
                    "Coconut Water",
                    "Lime Juice",
                    "Ice Cubes",
                    "$40"
                ),
                JuiceModel(
                    13,
                    "Berry Blast - page 2",
                    "Mixed Berries",
                    "Yogurt",
                    "Honey",
                    "Mint",
                    "$45"
                ),
                JuiceModel(
                    14,
                    "Watermelon Cooler - page 2",
                    "Watermelon",
                    "Mint",
                    "Lemon Juice",
                    "Crushed Ice",
                    "$30"
                ),
                JuiceModel(
                    15,
                    "Pineapple Punch - page 2",
                    "Pineapple Juice",
                    "Orange Juice",
                    "Ginger",
                    "Soda",
                    "$38"
                ),
                JuiceModel(
                    16,
                    "Apple Ginger Fizz - page 2",
                    "Apple Juice",
                    "Ginger",
                    "Soda",
                    "Lime",
                    "$42"
                ),
                JuiceModel(
                    17,
                    "Orange Carrot Zing - page 2",
                    "Orange Juice",
                    "Carrot Juice",
                    "Lemon",
                    "Honey",
                    "$37"
                ),
                JuiceModel(
                    18,
                    "Cucumber Mint - page 2",
                    "Cucumber",
                    "Mint",
                    "Lemon",
                    "Soda",
                    "$33"
                ),
                JuiceModel(
                    19,
                    "Kiwi Cooler - page 2",
                    "Kiwi",
                    "Lime",
                    "Honey",
                    "Ice Cubes",
                    "$39"
                ),
                JuiceModel(
                    20,
                    "Lichi Splash - page 2",
                    "Lychee Juice",
                    "Mint",
                    "Lime Juice",
                    "Soda",
                    "$36"
                ),


                )
        } else if(page == 3) {
            arrayListOf(
                //////////////
                JuiceModel(
                    21,
                    "Pomegranate Fizz - page 3",
                    "Pomegranate Juice",
                    "Lemon Juice",
                    "Soda",
                    "Mint",
                    "$43"
                ),
                JuiceModel(
                    22,
                    "Strawberry Shake - page 3",
                    "Strawberries",
                    "Milk",
                    "Sugar",
                    "Ice Cream",
                    "$50"
                ),
                JuiceModel(
                    23,
                    "Banana Smoothie - page 3",
                    "Banana",
                    "Milk",
                    "Honey",
                    "Ice Cubes",
                    "$34"
                ),
                JuiceModel(
                    24,
                    "Avocado Delight - page 3",
                    "Avocado",
                    "Milk",
                    "Honey",
                    "Vanilla",
                    "$55"
                ),
                JuiceModel(
                    25,
                    "Green Detox - page 3",
                    "Spinach",
                    "Cucumber",
                    "Green Apple",
                    "Lemon",
                    "$48"
                ),
                JuiceModel(
                    26,
                    "Grapefruit Refresher - page 3",
                    "Grapefruit Juice",
                    "Mint",
                    "Lime",
                    "Honey",
                    "$41"
                ),
                JuiceModel(
                    27,
                    "Peach Passion - page 3",
                    "Peach Juice",
                    "Lime",
                    "Ginger",
                    "Soda",
                    "$39"
                ),
                JuiceModel(
                    28,
                    "Coconut Crush - page 3",
                    "Coconut Water",
                    "Pineapple Juice",
                    "Mint",
                    "Lime",
                    "$44"
                ),
                JuiceModel(
                    29,
                    "Blueberry Yogurt - page 3",
                    "Blueberries",
                    "Yogurt",
                    "Honey",
                    "Mint Leaves",
                    "$46"
                ),
                JuiceModel(
                    30,
                    "Cherry Sparkle - page 3",
                    "Cherry Juice",
                    "Soda",
                    "Lemon Juice",
                    "Ice",
                    "$38"
                )
            )
        } else if(page == 4) {
            arrayListOf(
                JuiceModel(
                    31,
                    "Banana Smoothie - page 4",
                    "Banana",
                    "Milk",
                    "Honey",
                    "Ice Cubes",
                    "$34"
                ),
                JuiceModel(
                    32,
                    "Avocado Delight - page 4",
                    "Avocado",
                    "Milk",
                    "Honey",
                    "Vanilla",
                    "$55"
                )
            )
        } else {
            return arrayListOf()
        }
//তাহলে শুধুমাত্র page == 1 হলে রিটার্ন করবে। কিন্তু page != 1 হলে কিছুই রিটার্ন করবে না।
//
//🔴 কিন্তু Kotlin বলে — যেহেতু তুমি বলেছো রিটার্ন করবে, তাহলে সব অবস্থায় (সব path এ) রিটার্ন করতে হবে।
//tai else block a empty arraylist deya hoyece mane kono kichu return korbei jehetu return type deya ache

    }
}