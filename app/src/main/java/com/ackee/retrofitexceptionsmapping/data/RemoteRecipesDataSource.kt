package com.ackee.retrofitexceptionsmapping.data

import com.ackee.retrofitexceptionsmapping.domain.entity.Recipe
import com.ackee.retrofitexceptionsmapping.domain.entity.RecipeId

interface RemoteRecipesDataSource {

    suspend fun recipes(): List<Recipe>

    suspend fun recipe(id: RecipeId): Recipe
}