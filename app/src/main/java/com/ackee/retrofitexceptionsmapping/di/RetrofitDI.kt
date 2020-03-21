package com.ackee.retrofitexceptionsmapping.di

import com.ackee.retrofitexceptionsmapping.data.api.RecipesApiDescription
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val okHttpClient by lazy {
    OkHttpClient.Builder()
        .addNetworkInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()
}

val recipesApiDescription: RecipesApiDescription by lazy {
    Retrofit.Builder()
        .baseUrl("https://cookbook.ack.ee/api/v1/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(RecipesApiDescription::class.java)
}