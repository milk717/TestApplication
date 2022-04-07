package com.milk717.android.roomdbexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.milk717.android.roomdbexample.util.Event

open class BaseViewModel : ViewModel() {
    val viewEvent = MutableLiveData<Event<Any>>()
    fun viewEvent(content: Any){
        viewEvent.value = Event(content)
    }
}