package com.ackee.retrofitexceptionsmapping.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ackee.retrofitexceptionsmapping.domain.AsyncState
import com.ackee.retrofitexceptionsmapping.domain.RecipesRepository
import com.ackee.retrofitexceptionsmapping.domain.entity.Recipe
import com.ackee.retrofitexceptionsmapping.domain.entity.RecipeId
import kotlinx.coroutines.launch

class MainViewModel(
    private val recipesRepository: RecipesRepository
) : ViewModel() {

    val recipesLoadingState = MutableLiveData<AsyncState<List<Recipe>>>()

    val recipeDetailLoadingState = MutableLiveData<AsyncState<Recipe>>()

    fun fetchRecipes() {
        recipesLoadingState.value = AsyncState.Loading
        viewModelScope.launch {
            try {
                recipesLoadingState.value = AsyncState.Loaded(recipesRepository.getRecipes())
            } catch (e: Exception) {
                recipesLoadingState.value = AsyncState.Error(e)
            }
        }
    }

    fun fetchRecipeDetail(id: String) {
        recipeDetailLoadingState.value = AsyncState.Loading
        viewModelScope.launch {
            try {
                recipeDetailLoadingState.value =
                    AsyncState.Loaded(recipesRepository.recipe(RecipeId(id)))
            } catch (e: Exception) {
                recipeDetailLoadingState.value = AsyncState.Error(e)
            }
        }
    }
}

