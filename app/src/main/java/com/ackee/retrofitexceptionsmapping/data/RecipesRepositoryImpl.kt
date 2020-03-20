package com.ackee.retrofitexceptionsmapping.data

import com.ackee.retrofitexceptionsmapping.data.api.RemoteRecipesDataSource
import com.ackee.retrofitexceptionsmapping.domain.RecipesRepository
import com.ackee.retrofitexceptionsmapping.domain.entity.Recipe
import com.ackee.retrofitexceptionsmapping.domain.entity.RecipeId

class RecipesRepositoryImpl(
    private val remoteRecipesDataSource: RemoteRecipesDataSource
) : RecipesRepository {

    override suspend fun getRecipes(): List<Recipe> {
        return remoteRecipesDataSource.recipes()
    }

    override suspend fun recipe(id: RecipeId): Recipe {
        return remoteRecipesDataSource.recipe(id)
    }
}