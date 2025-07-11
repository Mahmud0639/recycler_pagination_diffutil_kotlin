package com.manuni.hello_world.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.manuni.hello_world.databinding.JuiceItemsBinding


class JuiceAdapter(var items: ArrayList<JuiceModel>):RecyclerView.Adapter<JuiceAdapter.JuiceViewHolder>() {


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
        val juiceDiff = JuiceDiffUtil(this.items,newItems)
        val diffResult = DiffUtil.calculateDiff(juiceDiff)
        this.items.clear()
        this.items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }


    inner class JuiceViewHolder(var binding: JuiceItemsBinding):ViewHolder(binding.root){
        //click listener type of work

    }
}