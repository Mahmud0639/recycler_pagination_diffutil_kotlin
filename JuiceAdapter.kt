package com.manuni.hello_world.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.manuni.hello_world.databinding.JuiceItemsBinding


class JuiceAdapter(var items: ArrayList<JuiceModel>):RecyclerView.Adapter<JuiceAdapter.JuiceViewHolder>() {

    private lateinit var onItemClick: ((JuiceModel)->Unit)

    private lateinit var onUpdateClick: (JuiceModel)->Unit

    fun setOnItemClickListener(action: (JuiceModel)->Unit){
        onItemClick = action
    }

    fun setOnUpdateClickListener(action: (JuiceModel) -> Unit){
        onUpdateClick = action
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JuiceViewHolder {
        val binding: JuiceItemsBinding = JuiceItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return JuiceViewHolder(binding)

    }

    override fun onBindViewHolder(holder: JuiceViewHolder, position: Int) {
        val item = items[position]
        val binding = holder.binding


        binding.juiceName.text = item.juiceName
        binding.ingredients.text = item.ingredientsOne + item.ingredientsTwo + item.ingredientsThree + item.ingredientsFour
        binding.price.text = item.price
    }

    fun updateJuiceItems(newItems: ArrayList<JuiceModel>){
        val oldItems = ArrayList(this.items)
        val juiceDiff = JuiceDiffUtil(oldItems,newItems)
        val diffResult = DiffUtil.calculateDiff(juiceDiff)
        this.items.clear()
        this.items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }


    inner class JuiceViewHolder(var binding: JuiceItemsBinding):ViewHolder(binding.root){
        //click listener type of work
        init {
//            binding.root.setOnClickListener {
//                onItemClick(items[adapterPosition])
//            }

            binding.update.setOnClickListener {
                onUpdateClick(items[adapterPosition])//ekhane amra JuiceModel object pathassi tai items[adapterPosition]) use koresi
            }

//            binding.root.setOnClickListener{
//                itemListener.onItemClickListener(adapterPosition)//ekhane int pathassi tai only adapterPosition
//            }

        }
    }
}