package com.ackee.retrofitexceptionsmapping.di

import com.ackee.retrofitexceptionsmapping.data.RecipesRepositoryImpl
import com.ackee.retrofitexceptionsmapping.data.RemoteRecipesDataSource
import com.ackee.retrofitexceptionsmapping.data.api.RetrofitRecipesDataSource
import com.ackee.retrofitexceptionsmapping.domain.RecipesRepository

val remoteRecipesDataSource: RemoteRecipesDataSource by lazy {
    RetrofitRecipesDataSource(recipesApiDescription)
}

val recipesRepository: RecipesRepository by lazy {
    RecipesRepositoryImpl(remoteRecipesDataSource)
}