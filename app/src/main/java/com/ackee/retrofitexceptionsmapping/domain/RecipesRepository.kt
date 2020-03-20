package com.ackee.retrofitexceptionsmapping.domain

import com.ackee.retrofitexceptionsmapping.domain.entity.Recipe
import com.ackee.retrofitexceptionsmapping.domain.entity.RecipeId

interface RecipesRepository {

    suspend fun getRecipes(): List<Recipe>

    suspend fun recipe(id: RecipeId): Recipe
}