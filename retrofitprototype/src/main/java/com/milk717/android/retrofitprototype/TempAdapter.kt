package com.milk717.android.retrofitprototype

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.milk717.android.retrofitprototype.TempAdapter.ViewHolder.Companion.diffUtil
import com.milk717.android.retrofitprototype.databinding.ItemBookSearchBinding

class TempAdapter : ListAdapter<Item, TempAdapter.ViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempAdapter.ViewHolder {
        val binding: ItemBookSearchBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_book_search,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TempAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemBookSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            val diffUtil = object : DiffUtil.ItemCallback<Item>() {
                override fun areItemsTheSame(
                    oldItem: Item,
                    newItem: Item
                ) =
                    oldItem == newItem


                override fun areContentsTheSame(
                    oldItem: Item,
                    newItem: Item
                ) =
                    oldItem.title == newItem.title

            }
        }
    }
}