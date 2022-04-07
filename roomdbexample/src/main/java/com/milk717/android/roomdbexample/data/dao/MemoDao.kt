package com.milk717.android.roomdbexample.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.milk717.android.roomdbexample.data.model.Memo

@Dao
interface MemoDao {
    @Query("select * from memo")    //괄호 안 SQL 문법
    fun getAllMemo(): List<Memo>

    @Insert(onConflict = REPLACE)   //REPLACE 설정 시 동일한 키를 가진 값이 입력됐을 때 UPDATE 쿼리로 실행됨
    fun insertMemo(memo: Memo)

    @Delete
    fun deleteMemo(memo: Memo)

    @Query("DELETE FROM memo WHERE id = :id")   //'id' 에 해당하는 메모를 삭제해라
    fun deleteMemoById(id: Long)
}