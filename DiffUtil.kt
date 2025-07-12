package com.manuni.hello_world.recyclerview

import androidx.recyclerview.widget.DiffUtil

class JuiceDiffUtil(private var itemsOld: ArrayList<JuiceModel>, private var itemsNew: ArrayList<JuiceModel>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return itemsOld.size
    }

    override fun getNewListSize(): Int {
        return itemsNew.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return itemsOld[oldItemPosition].id == itemsNew[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val itemOld:JuiceModel = itemsOld[oldItemPosition]
        val itemNew:JuiceModel = itemsNew[newItemPosition]

       // return  itemOld == itemNew

        return itemOld.juiceName == itemNew.juiceName && itemOld.ingredientsOne == itemNew.ingredientsOne
                && itemOld.ingredientsTwo == itemNew.ingredientsTwo && itemOld.ingredientsThree == itemNew.ingredientsThree
                && itemOld.ingredientsFour == itemNew.ingredientsFour && itemOld.price == itemNew.price
    }
}