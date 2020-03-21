package com.ackee.retrofitexceptionsmapping.data.api

import retrofit2.http.GET
import retrofit2.http.Path

interface RecipesApiDescription {

    @GET("recipes")
    suspend fun recipes(): List<ApiRecipe>

    @GET("recipes/{recipeId}")
    suspend fun recipeDetail(@Path("recipeId") recipeId: String): ApiRecipe
}