package com.milk717.android.retrofitprototype

import androidx.lifecycle.MutableLiveData

class SearchViewModel : BaseViewModel() {
    val dummyList = listOf(
        Item("책 제목",
            "링크",
            "이미지",
            "작가",
            "가격",
            "할인",
            "출판사",
            "출판날짜",
            "isbn",
            "설명입니다아아ㅏㅏㅏㅏㅏ아아ㅏㅇ"),
        Item("제목",
            "link",
            "image",
            "author",
            "price",
            "discount",
            "publisher",
            "pub_date",
            "isbn",
            "This is description!!")
    )

    val itemList = MutableLiveData<List<Item>>()
}