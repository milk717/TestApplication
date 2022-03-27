package com.milk717.android.retrofitprototype

import okhttp3.internal.platform.Platform
import okhttp3.logging.HttpLoggingInterceptor

fun createLoggingInterceptor() : HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor { message ->
        if (!message.contains("�")) {
            Platform.get().log(message)
        }
    }

    interceptor.level = HttpLoggingInterceptor.Level.BODY

    return interceptor
}