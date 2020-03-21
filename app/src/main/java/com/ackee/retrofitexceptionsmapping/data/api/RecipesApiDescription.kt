package com.ackee.retrofitexceptionsmapping.data.api

import com.ackee.retrofitexceptionsmapping.data.api.errors.ExceptionsMapper
import com.ackee.retrofitexceptionsmapping.data.api.errors.RecipeDetailExceptionMapper
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipesApiDescription {

    @GET("recipes")
    suspend fun recipes(): List<ApiRecipe>

    @GET("recipes/{recipeId}")
    @ExceptionsMapper(value = RecipeDetailExceptionMapper::class)
    suspend fun recipeDetail(@Path("recipeId") recipeId: String): ApiRecipe
}