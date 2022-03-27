package com.milk717.android.retrofitprototype

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.milk717.android.retrofitprototype.databinding.ActivityMainBinding
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        setupAdapter()
        basicRetrofit()
    }

    private fun basicRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://openapi.naver.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder()
                .addInterceptor(createLoggingInterceptor())
                .build())
            .build()
        val service = retrofit.create(BookSearchHttpService::class.java)

        service.getSearchResult("title",10,1,"OQbJ1ug1wpU0zkxTsPp5","mI2ktPwALV").enqueue(object :
            Callback<SearchResult> {
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                if(response.isSuccessful){
                    viewModel.itemList.value = response.body()!!.items
                } else{
                    Toast.makeText(applicationContext,"실패", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                Toast.makeText(applicationContext,"실패", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupAdapter() {
        //binding.recyclerView.adapter = SearchResultAdapter()
        binding.recyclerView.adapter = TempAdapter()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}