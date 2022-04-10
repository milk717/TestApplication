package com.milk717.android.koinexample

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel : BaseViewModel(), KoinComponent {
    private val context: Context by inject()
    companion object{
        const val EVENT_START = 22212
    }

    val text = MutableLiveData("")
    val textRes = MutableLiveData("")

    fun onTextBtnClick(){
        textRes.value = text.value
        Toast.makeText(context,"클릭",Toast.LENGTH_SHORT).show()
        viewEvent(EVENT_START)
    }
}