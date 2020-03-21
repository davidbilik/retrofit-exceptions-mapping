package com.ackee.retrofitexceptionsmapping.di

import com.ackee.retrofitexceptionsmapping.presentation.MainViewModelFactory

val viewModelsFactory: MainViewModelFactory by lazy {
    MainViewModelFactory(recipesRepository)
}