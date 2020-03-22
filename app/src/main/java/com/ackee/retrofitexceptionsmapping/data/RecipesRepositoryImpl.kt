package com.ackee.retrofitexceptionsmapping.data

import com.ackee.retrofitexceptionsmapping.domain.RecipesRepository
import com.ackee.retrofitexceptionsmapping.domain.entity.Recipe
import com.ackee.retrofitexceptionsmapping.domain.entity.RecipeId

class RecipesRepositoryImpl(
    private val remoteRecipesDataSource: RemoteRecipesDataSource
) : RecipesRepository {

    override suspend fun fetchRecipes(): List<Recipe> {
        return remoteRecipesDataSource.recipes()
    }

    override suspend fun fetchRecipe(id: RecipeId): Recipe {
        return remoteRecipesDataSource.recipe(id)
    }
}