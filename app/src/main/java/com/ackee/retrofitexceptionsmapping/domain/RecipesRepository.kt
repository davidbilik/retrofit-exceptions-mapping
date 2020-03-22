package com.ackee.retrofitexceptionsmapping.domain

import com.ackee.retrofitexceptionsmapping.domain.entity.Recipe
import com.ackee.retrofitexceptionsmapping.domain.entity.RecipeId

interface RecipesRepository {

    suspend fun fetchRecipes(): List<Recipe>

    suspend fun fetchRecipe(id: RecipeId): Recipe
}