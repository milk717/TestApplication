package com.milk717.android.temproomdbexample.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database -> 데이터 베이스임을 표시
//entities = [여기에 아까 만든 entity 넣어주기]
//version = 1 -> entity 구조를 변경하게 됐을 때 이전 구조와 현재 구조 구분해주는 역할
//구조가 바뀌었는데 버전이 같다면 에러뜸. 처음 생성시 1
@Database(entities = [Memo::class], version = 2)
abstract class MemoDataBase: RoomDatabase() {
    abstract fun memoDao(): MemoDao

    //각 RoomDatabase 인스턴스는 리소스를 많이 소비하기 때문에 싱글톤으로 구현하는 것이 좋음
    companion object{
        private var instance: MemoDataBase? = null

        @Synchronized
        fun getInstance(context: Context): MemoDataBase?{
            if(instance == null){
                synchronized(MemoDataBase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MemoDataBase::class.java,
                        "memo3-database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance
        }
    }
}