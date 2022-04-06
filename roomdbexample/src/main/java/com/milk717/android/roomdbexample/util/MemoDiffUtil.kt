package com.milk717.android.roomdbexample.util

import androidx.recyclerview.widget.DiffUtil
import com.milk717.android.roomdbexample.data.model.Memo

class MemoDiffUtil(
    private val oldItem: List<Memo>,
    private val newItem: List<Memo>
) : DiffUtil.Callback(){
    override fun getOldListSize() = oldItem.size

    override fun getNewListSize() = newItem.size

    //이전 항목과 동일한지 동일성 테스트를 함. 보통 고유값을 갖는 id로 비교를 한다.
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItem[oldItemPosition]
        val newItem = newItem[newItemPosition]

        return oldItem.id == newItem.id
    }

    //동등성 검사를 함. 모든 필드를 검사한다.
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItem[oldItemPosition]
        val newItem = newItem[newItemPosition]

        return oldItem==newItem
    }
}