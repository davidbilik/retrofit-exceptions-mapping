package com.ackee.retrofitexceptionsmapping.data.api

import com.ackee.retrofitexceptionsmapping.domain.entity.Recipe
import com.ackee.retrofitexceptionsmapping.domain.entity.RecipeId


interface RemoteRecipesDataSource {

    suspend fun recipes(): List<Recipe>

    suspend fun recipe(id: RecipeId): Recipe
}

class RetrofitRecipesDataSource(
    private val recipesApiDescription: RecipesApiDescription
) : RemoteRecipesDataSource {

    override suspend fun recipes(): List<Recipe> {
        return recipesApiDescription.recipes().map { it.toRecipe() }
    }

    override suspend fun recipe(id: RecipeId): Recipe {
        return recipesApiDescription.recipeDetail(id.value).let {
            it.toRecipe()
        }
    }

}