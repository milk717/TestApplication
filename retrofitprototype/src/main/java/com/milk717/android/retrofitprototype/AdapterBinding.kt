package com.milk717.android.retrofitprototype

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:items")
fun setItemList(recyclerView: RecyclerView, itemList: List<Item>?){
    itemList?.let{
        (recyclerView.adapter as TempAdapter).submitList(itemList)
    }
}