package com.manuni.hello_world.recyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JuiceViewModel : ViewModel() {

    private val _listJuice = MutableLiveData<List<JuiceModel>>()
    val listJuice: LiveData<List<JuiceModel>> get() = _listJuice

//    init {
//        loadJuiceData()
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

    fun loadJuiceData(count: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _listJuice.postValue(loadItems(count))
        }
    }

    private fun loadItems(page: Int): ArrayList<JuiceModel> {

        return if(page == 1) {

            arrayListOf(

                JuiceModel(
                    "Mint Lemonade - page 1",
                    "Chilled Soda",
                    "Mint Leaves",
                    "Black Salt",
                    "Lemon",
                    "$35"
                ),

                JuiceModel(
                    "Tamarind Cooler - page 1",
                    "Cold Water",
                    "Tamarind Pulp",
                    "Jaggery",
                    "Cumin Powder",
                    "$40"
                ),

                JuiceModel(
                    "Rose Shorbot - page 1",
                    "Chilled Milk",
                    "Rose Syrup",
                    "Sugar",
                    "Ice Cubes",
                    "$38"
                ),

                JuiceModel(
                    "Cucumber Mint - page 1",
                    "Cold Water",
                    "Cucumber Juice",
                    "Mint Extract",
                    "Salt",
                    "$42"
                ),

                JuiceModel(
                    "Orange Fizz - page 1",
                    "Soda Water",
                    "Orange Juice",
                    "Sugar Syrup",
                    "Lemon Zest",
                    "$45"
                ),

                JuiceModel(
                    "Ginger Lemonade - page 1",
                    "Chilled Water",
                    "Ginger Juice",
                    "Lemon Juice",
                    "Honey",
                    "$37"
                ),

                JuiceModel(
                    "Aam Panna - page 1",
                    "Cold Water",
                    "Raw Mango Pulp",
                    "Cumin Powder",
                    "Mint Leaves",
                    "$43"
                ),

                JuiceModel(
                    "Kokum Shorbot - page 1",
                    "Chilled Water",
                    "Kokum Syrup",
                    "Sugar",
                    "Salt",
                    "$41"
                ),

                JuiceModel(
                    "Watermelon Splash - page 1",
                    "Chilled Watermelon Juice",
                    "Mint",
                    "Lemon Juice",
                    "Sugar",
                    "$39"
                ),

                JuiceModel(
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
                    "Mint Lemonade - page 2",
                    "Chilled Soda",
                    "Mint Leaves",
                    "Black Salt",
                    "Lemon",
                    "$35"
                ),
                JuiceModel(
                    "Tropical Mango - page 2",
                    "Mango Pulp",
                    "Coconut Water",
                    "Lime Juice",
                    "Ice Cubes",
                    "$40"
                ),
                JuiceModel(
                    "Berry Blast - page 2",
                    "Mixed Berries",
                    "Yogurt",
                    "Honey",
                    "Mint",
                    "$45"
                ),
                JuiceModel(
                    "Watermelon Cooler - page 2",
                    "Watermelon",
                    "Mint",
                    "Lemon Juice",
                    "Crushed Ice",
                    "$30"
                ),
                JuiceModel(
                    "Pineapple Punch - page 2",
                    "Pineapple Juice",
                    "Orange Juice",
                    "Ginger",
                    "Soda",
                    "$38"
                ),
                JuiceModel(
                    "Apple Ginger Fizz - page 2",
                    "Apple Juice",
                    "Ginger",
                    "Soda",
                    "Lime",
                    "$42"
                ),
                JuiceModel(
                    "Orange Carrot Zing - page 2",
                    "Orange Juice",
                    "Carrot Juice",
                    "Lemon",
                    "Honey",
                    "$37"
                ),
                JuiceModel(
                    "Cucumber Mint - page 2",
                    "Cucumber",
                    "Mint",
                    "Lemon",
                    "Soda",
                    "$33"
                ),
                JuiceModel(
                    "Kiwi Cooler - page 2",
                    "Kiwi",
                    "Lime",
                    "Honey",
                    "Ice Cubes",
                    "$39"
                ),
                JuiceModel(
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
                    "Pomegranate Fizz - page 3",
                    "Pomegranate Juice",
                    "Lemon Juice",
                    "Soda",
                    "Mint",
                    "$43"
                ),
                JuiceModel(
                    "Strawberry Shake - page 3",
                    "Strawberries",
                    "Milk",
                    "Sugar",
                    "Ice Cream",
                    "$50"
                ),
                JuiceModel(
                    "Banana Smoothie - page 3",
                    "Banana",
                    "Milk",
                    "Honey",
                    "Ice Cubes",
                    "$34"
                ),
                JuiceModel(
                    "Avocado Delight - page 3",
                    "Avocado",
                    "Milk",
                    "Honey",
                    "Vanilla",
                    "$55"
                ),
                JuiceModel(
                    "Green Detox - page 3",
                    "Spinach",
                    "Cucumber",
                    "Green Apple",
                    "Lemon",
                    "$48"
                ),
                JuiceModel(
                    "Grapefruit Refresher - page 3",
                    "Grapefruit Juice",
                    "Mint",
                    "Lime",
                    "Honey",
                    "$41"
                ),
                JuiceModel(
                    "Peach Passion - page 3",
                    "Peach Juice",
                    "Lime",
                    "Ginger",
                    "Soda",
                    "$39"
                ),
                JuiceModel(
                    "Coconut Crush - page 3",
                    "Coconut Water",
                    "Pineapple Juice",
                    "Mint",
                    "Lime",
                    "$44"
                ),
                JuiceModel(
                    "Blueberry Yogurt - page 3",
                    "Blueberries",
                    "Yogurt",
                    "Honey",
                    "Mint Leaves",
                    "$46"
                ),
                JuiceModel(
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
                    "Banana Smoothie - page 4",
                    "Banana",
                    "Milk",
                    "Honey",
                    "Ice Cubes",
                    "$34"
                ),
                JuiceModel(
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