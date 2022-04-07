package com.milk717.android.roomdbexample

import com.milk717.android.roomdbexample.data.repository.MemoRepository
import org.koin.dsl.module

val appModule = module{
    single{ MemoRepository() }      //앱이 실행되는 동안 계속 유지되는 싱글톤 객체
}