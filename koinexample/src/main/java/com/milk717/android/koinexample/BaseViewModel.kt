package com.milk717.android.koinexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val viewEvent = MutableLiveData<Event<Any>>()
    fun viewEvent(content: Any){
        viewEvent.value = Event(content)
    }
}