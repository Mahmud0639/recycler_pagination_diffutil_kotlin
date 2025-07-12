package com.manuni.hello_world.recyclerview

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.manuni.hello_world.databinding.ActivityRecyclerBinding
import com.manuni.hello_world.recyclerview.interface_listeners.ItemClick
import kotlinx.coroutines.launch

class JuiceActivity : AppCompatActivity(),ItemClick {
    private lateinit var binding: ActivityRecyclerBinding

    private lateinit var juiceViewModel: JuiceViewModel


    private var tempPageNumber = 1
    private val PER_PAGE_DATA = 10

    private lateinit var juiceAdapter: JuiceAdapter
    private val items: ArrayList<JuiceModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility = View.VISIBLE

        juiceViewModel = ViewModelProvider(this)[JuiceViewModel::class.java]


        juiceViewModel.isLoading.observe(this) { loading ->
            binding.swipeRefresh.isRefreshing = loading
        }

        binding.swipeRefresh.post {
            juiceViewModel.loadJuiceData(tempPageNumber)
        }

        binding.swipeRefresh.setOnRefreshListener {
            tempPageNumber = 1
            juiceViewModel.loadJuiceData(tempPageNumber)
        }




        juiceAdapter = JuiceAdapter(items,this)
        binding.recyclerView.adapter = juiceAdapter



//        juiceAdapter.setOnItemClickListener {
//            //here we will get "it" that means JuiceModel class object
//            Toast.makeText(this,"${it.juiceName} clicked.",Toast.LENGTH_SHORT).show()
//        }

        juiceAdapter.setOnUpdateClickListener {
            Toast.makeText(this,"${it.id} update clicked.",Toast.LENGTH_SHORT).show()
        }


        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.recyclerView.setHasFixedSize(true)

        binding.recyclerView.addOnScrollListener(object : OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (dy > 0) {
                    //  binding.swipeRefresh.isRefreshing = true
                    recyclerView.layoutManager?.let {
                        val lm = it as LinearLayoutManager
                        val totalCount = lm.itemCount

                        if (!binding.swipeRefresh.isRefreshing && totalCount == lm.findLastVisibleItemPosition() + 1 && (totalCount % PER_PAGE_DATA) == 0) {
                            tempPageNumber++

                            Toast.makeText(
                                this@JuiceActivity,
                                "Page No. $tempPageNumber",
                                Toast.LENGTH_SHORT
                            ).show()

                            juiceViewModel.loadJuiceData(tempPageNumber)
                        }
                    }
                }


            }
        })

        lifecycleScope.launch {


            juiceViewModel.listJuice.observe(this@JuiceActivity) { juiceItems ->
                if (tempPageNumber == 1) {
                    items.clear()
                }

//                items.addAll(juiceItems)
//
//                juiceAdapter.notifyDataSetChanged()

                val mItems = items.clone() as ArrayList<JuiceModel>
                mItems.addAll(juiceItems)
                juiceAdapter.updateJuiceItems(mItems)

                binding.progressBar.visibility = View.GONE
                binding.swipeRefresh.isRefreshing = false
            }
        }


//
//        juiceAdapter.setOnUpdateClickListener {
//            Toast.makeText(this,"${it.juiceName}",Toast.LENGTH_SHORT).show()
//        }
//
//        juiceAdapter.setOnDeleteClickListener {
//            Toast.makeText(this,"${it.juiceName}",Toast.LENGTH_SHORT).show()
//        }

    }

    override fun onItemClickListener(position: Int) {
        Toast.makeText(this@JuiceActivity,"Clicked $position",Toast.LENGTH_SHORT).show()
    }

//    private fun loadItems():ArrayList<JuiceModel>{
//        return arrayListOf(
//            JuiceModel(
//                "Mint Lemonade",
//                "Chilled Soda",
//                "Mint Leaves",
//                "Black Salt",
//                "Lemon",
//                "$35"
//            ),
//
//            JuiceModel(
//                "Tamarind Cooler",
//                "Cold Water",
//                "Tamarind Pulp",
//                "Jaggery",
//                "Cumin Powder",
//                "$40"
//            ),
//
//            JuiceModel(
//                "Rose Shorbot",
//                "Chilled Milk",
//                "Rose Syrup",
//                "Sugar",
//                "Ice Cubes",
//                "$38"
//            ),
//
//            JuiceModel(
//                "Cucumber Mint",
//                "Cold Water",
//                "Cucumber Juice",
//                "Mint Extract",
//                "Salt",
//                "$42"
//            ),
//
//            JuiceModel(
//                "Orange Fizz",
//                "Soda Water",
//                "Orange Juice",
//                "Sugar Syrup",
//                "Lemon Zest",
//                "$45"
//            ),
//
//            JuiceModel(
//                "Ginger Lemonade",
//                "Chilled Water",
//                "Ginger Juice",
//                "Lemon Juice",
//                "Honey",
//                "$37"
//            ),
//
//            JuiceModel(
//                "Aam Panna",
//                "Cold Water",
//                "Raw Mango Pulp",
//                "Cumin Powder",
//                "Mint Leaves",
//                "$43"
//            ),
//
//            JuiceModel(
//                "Kokum Shorbot",
//                "Chilled Water",
//                "Kokum Syrup",
//                "Sugar",
//                "Salt",
//                "$41"
//            ),
//
//            JuiceModel(
//                "Watermelon Splash",
//                "Chilled Watermelon Juice",
//                "Mint",
//                "Lemon Juice",
//                "Sugar",
//                "$39"
//            ),
//
//            JuiceModel(
//                "Pineapple Ginger",
//                "Cold Water",
//                "Pineapple Juice",
//                "Ginger Extract",
//                "Salt",
//                "$44"
//            ),
//
//            JuiceModel(
//                "Mint Lemonade",
//                "Chilled Soda",
//                "Mint Leaves",
//                "Black Salt",
//                "Lemon",
//                "$35"
//            ),
//            JuiceModel(
//                "Tropical Mango",
//                "Mango Pulp",
//                "Coconut Water",
//                "Lime Juice",
//                "Ice Cubes",
//                "$40"
//            ),
//            JuiceModel(
//                "Berry Blast",
//                "Mixed Berries",
//                "Yogurt",
//                "Honey",
//                "Mint",
//                "$45"
//            ),
//            JuiceModel(
//                "Watermelon Cooler",
//                "Watermelon",
//                "Mint",
//                "Lemon Juice",
//                "Crushed Ice",
//                "$30"
//            ),
//            JuiceModel(
//                "Pineapple Punch",
//                "Pineapple Juice",
//                "Orange Juice",
//                "Ginger",
//                "Soda",
//                "$38"
//            ),
//            JuiceModel(
//                "Apple Ginger Fizz",
//                "Apple Juice",
//                "Ginger",
//                "Soda",
//                "Lime",
//                "$42"
//            ),
//            JuiceModel(
//                "Orange Carrot Zing",
//                "Orange Juice",
//                "Carrot Juice",
//                "Lemon",
//                "Honey",
//                "$37"
//            ),
//            JuiceModel(
//                "Cucumber Mint",
//                "Cucumber",
//                "Mint",
//                "Lemon",
//                "Soda",
//                "$33"
//            ),
//            JuiceModel(
//                "Kiwi Cooler",
//                "Kiwi",
//                "Lime",
//                "Honey",
//                "Ice Cubes",
//                "$39"
//            ),
//            JuiceModel(
//                "Lichi Splash",
//                "Lychee Juice",
//                "Mint",
//                "Lime Juice",
//                "Soda",
//                "$36"
//            ),
//            JuiceModel(
//                "Pomegranate Fizz",
//                "Pomegranate Juice",
//                "Lemon Juice",
//                "Soda",
//                "Mint",
//                "$43"
//            ),
//            JuiceModel(
//                "Strawberry Shake",
//                "Strawberries",
//                "Milk",
//                "Sugar",
//                "Ice Cream",
//                "$50"
//            ),
//            JuiceModel(
//                "Banana Smoothie",
//                "Banana",
//                "Milk",
//                "Honey",
//                "Ice Cubes",
//                "$34"
//            ),
//            JuiceModel(
//                "Avocado Delight",
//                "Avocado",
//                "Milk",
//                "Honey",
//                "Vanilla",
//                "$55"
//            ),
//            JuiceModel(
//                "Green Detox",
//                "Spinach",
//                "Cucumber",
//                "Green Apple",
//                "Lemon",
//                "$48"
//            ),
//            JuiceModel(
//                "Grapefruit Refresher",
//                "Grapefruit Juice",
//                "Mint",
//                "Lime",
//                "Honey",
//                "$41"
//            ),
//            JuiceModel(
//                "Peach Passion",
//                "Peach Juice",
//                "Lime",
//                "Ginger",
//                "Soda",
//                "$39"
//            ),
//            JuiceModel(
//                "Coconut Crush",
//                "Coconut Water",
//                "Pineapple Juice",
//                "Mint",
//                "Lime",
//                "$44"
//            ),
//            JuiceModel(
//                "Blueberry Yogurt",
//                "Blueberries",
//                "Yogurt",
//                "Honey",
//                "Mint Leaves",
//                "$46"
//            ),
//            JuiceModel(
//                "Cherry Sparkle",
//                "Cherry Juice",
//                "Soda",
//                "Lemon Juice",
//                "Ice",
//                "$38"
//            ),
//
//            )
//
//
//    }

    //E:\android_projects\app\src\main\java\com\manuni\hello_world\recyclerview>
}