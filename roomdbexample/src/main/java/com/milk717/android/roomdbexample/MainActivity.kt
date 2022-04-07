package com.milk717.android.roomdbexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.milk717.android.roomdbexample.data.adapter.MemoAdapter
import com.milk717.android.roomdbexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        binding.recyclerView.adapter = MemoAdapter()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}