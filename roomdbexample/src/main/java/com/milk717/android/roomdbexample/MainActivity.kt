package com.milk717.android.roomdbexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.milk717.android.roomdbexample.data.adapter.MemoAdapter
import com.milk717.android.roomdbexample.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        setRecyclerView()
        setUpEvent()
    }

    private fun setUpEvent() {
        viewModel.viewEvent.observe(this){
            it.getContentIfNotHandled()?.let{event->
                when(event){
                    HomeViewModel.EVENT_REGISTER_MEMO->{
                        CoroutineScope(Dispatchers.Main).launch{

                        }
                    }
                }
            }
        }
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