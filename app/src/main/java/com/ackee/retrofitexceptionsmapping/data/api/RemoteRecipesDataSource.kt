package com.ackee.retrofitexceptionsmapping.data.api

import com.ackee.retrofitexceptionsmapping.data.RemoteRecipesDataSource
import com.ackee.retrofitexceptionsmapping.domain.entity.Recipe
import com.ackee.retrofitexceptionsmapping.domain.entity.RecipeId

class RetrofitRecipesDataSource(
    private val recipesApiDescription: RecipesApiDescription
) : RemoteRecipesDataSource {

    override suspend fun recipes(): List<Recipe> {
        return recipesApiDescription.recipes().map { it.toRecipe() }
    }

    override suspend fun recipe(id: RecipeId): Recipe {
        return try {
            recipesApiDescription.recipeDetail(id.value).let {
                it.toRecipe()
            }
        } catch (apiException: ApiException) {
            throw if (apiException.statusCode == "404") {
                RecipeNotFoundException(id)
            } else {
                apiException
            }
        }
    }
}