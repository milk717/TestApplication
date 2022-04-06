package com.milk717.android.roomdbexample.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//Room 라이브러리가 Entity 어노테이션이 적용된 클래스를 찾아 table로 변환함
@Entity(tableName = "memo")
data class Memo(
    var memo: String,
){
    //@PrimaryKey 사용해서 기본키 명시 autoGenerate 사용해서 자동 증가 옵션 추가
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}