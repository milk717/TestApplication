package com.milk717.android.roomdbexample.data.adapter


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.milk717.android.roomdbexample.data.model.Memo


class MemoAdapter : ListAdapter<Memo, RecyclerView.ViewHolder>(MemoDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

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