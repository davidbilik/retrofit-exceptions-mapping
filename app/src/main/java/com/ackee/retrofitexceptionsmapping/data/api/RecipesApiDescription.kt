package com.ackee.retrofitexceptionsmapping.data.api

import retrofit2.http.GET

interface RecipesApiDescription {

    @GET("recipes")
    suspend fun recipes(): List<ApiRecipe>

    @GET("recipes/{recipeId}")
    suspend fun recipeDetail(recipeId: String): ApiRecipe
}