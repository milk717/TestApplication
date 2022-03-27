package com.milk717.android.retrofitprototype

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface BookSearchHttpService{
    @GET("/v1/search/book.json")
    fun getSearchResult(
        @Query("query") title: String,
        @Query("display") display: Int,
        @Query("start") start: Int,
        @Header("X-Naver-Client-Id") clientId: String,
        @Header("X-Naver-Client-Secret") clientSecret: String,
    ): Call<SearchResult>
}