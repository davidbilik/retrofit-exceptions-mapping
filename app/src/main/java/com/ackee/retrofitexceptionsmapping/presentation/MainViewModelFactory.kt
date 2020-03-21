package com.ackee.retrofitexceptionsmapping.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ackee.retrofitexceptionsmapping.domain.RecipesRepository

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val repository: RecipesRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}