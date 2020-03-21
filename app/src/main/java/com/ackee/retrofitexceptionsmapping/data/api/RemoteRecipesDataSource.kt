package com.ackee.retrofitexceptionsmapping.data.api

import com.ackee.retrofitexceptionsmapping.domain.entity.Recipe
import com.ackee.retrofitexceptionsmapping.domain.entity.RecipeId
import com.ackee.retrofitexceptionsmapping.domain.exception.RecipeNotFoundException


interface RemoteRecipesDataSource {

    suspend fun recipes(): List<Recipe>

    suspend fun recipe(id: RecipeId): Recipe
}

class RetrofitRecipesDataSource(
    private val recipesApiDescription: RecipesApiDescription
) : RemoteRecipesDataSource {

    override suspend fun recipes(): List<Recipe> {
        return try {
            recipesApiDescription.recipes().map { it.toRecipe() }
        } catch (e: Exception) {
            throw mapToDomainException(e)
        }
    }

    override suspend fun recipe(id: RecipeId): Recipe {
        return try {
            recipesApiDescription.recipeDetail(id.value).let {
                it.toRecipe()
            }
        } catch (e: Exception) {
            throw mapToDomainException(e) {
                if (it.code() == 404) {
                    RecipeNotFoundException(id)
                } else {
                    null
                }
            }
        }
    }
}