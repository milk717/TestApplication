package com.milk717.android.testapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.milk717.android.testapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.myEvent.observe(this) {
            Intent(this, SubActivity::class.java).apply {
                startActivity(this)
            }
        }

        viewModel.myEvent2.observe(this){
            Toast.makeText(this,"Using SingleLiveEvent!",Toast.LENGTH_SHORT).show()
        }

        viewModel.viewEvent.observe(this){
            it.getContentIfNotHandled()?.let{ event->
                when(event){
                    MainViewModel.EVENT_START -> {
                        Toast.makeText(this,"Using Event!!",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}