package com.milk717.android.roomdbexample.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.milk717.android.roomdbexample.data.model.Memo
import com.milk717.android.roomdbexample.databinding.ItemMemoBinding


class MemoAdapter : ListAdapter<Memo, MemoAdapter.ViewHolder>(MemoDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(private val binding: ItemMemoBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Memo){
            binding.item = item
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMemoBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}
class MemoDiffUtil : DiffUtil.ItemCallback<Memo>(){
    //이전 항목과 동일한지 동일성 테스트를 함. 보통 고유값을 갖는 id로 비교를 한다.
    override fun areItemsTheSame(oldItem: Memo, newItem: Memo): Boolean {
       return oldItem.id == newItem.id
    }

    //동등성 검사를 함. 모든 필드를 검사한다.
    override fun areContentsTheSame(oldItem: Memo, newItem: Memo): Boolean {
        return oldItem == newItem
    }
}