package com.milk717.android.retrofitprototype

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milk717.android.retrofitprototype.databinding.ItemBookSearchBinding

class SearchResultAdapter : RecyclerView.Adapter<SearchResultAdapter.SearchResultVieHolder>(){
    lateinit var searchResultList: List<Item>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultVieHolder {
        return SearchResultVieHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SearchResultVieHolder, position: Int) {
        holder.bind(searchResultList[position])
    }

    override fun getItemCount() = searchResultList.size

    class SearchResultVieHolder private constructor(val binding: ItemBookSearchBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Item){
            binding.item = item
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup) : SearchResultVieHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemBookSearchBinding.inflate(layoutInflater, parent, false)

                return SearchResultVieHolder(binding)
            }
        }
    }
}