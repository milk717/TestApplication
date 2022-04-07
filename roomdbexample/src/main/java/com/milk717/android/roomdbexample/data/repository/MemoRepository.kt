package com.milk717.android.roomdbexample.data.repository

import com.milk717.android.roomdbexample.GlobalApplication
import com.milk717.android.roomdbexample.data.model.Memo

class MemoRepository {
    private val appDBInstance = GlobalApplication.appDataBaseInstance.memoDao()

    fun getAllMemo() = appDBInstance.getAllMemo()
    fun insertMemo(memo: Memo) = appDBInstance.insertMemo(memo)
    fun deleteMemo(memo: Memo) = appDBInstance.deleteMemo(memo)
    fun deleteMemoById(id: Long) = appDBInstance.deleteMemoById(id)
}