package com.milk717.android.roomdbexample

import androidx.lifecycle.MutableLiveData
import com.milk717.android.roomdbexample.data.repository.MemoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class HomeViewModel : BaseViewModel(), KoinComponent {
    private val memoRepository: MemoRepository by inject()

    companion object{
        const val EVENT_REGISTER_MEMO = 22212
    }
    val textInput = MutableLiveData("")

    fun onRegisterButtonClick(){
        viewEvent(EVENT_REGISTER_MEMO)
    }
}