package com.ackee.retrofitexceptionsmapping.data.api

import com.ackee.retrofitexceptionsmapping.domain.entity.Recipe
import com.ackee.retrofitexceptionsmapping.domain.entity.RecipeId
import com.squareup.moshi.JsonClass
import kotlin.time.minutes

@JsonClass(generateAdapter = true)
class ApiRecipe(
    val id: String,
    val name: String,
    val duration: Int,
    val score: Double
)

fun ApiRecipe.toRecipe(): Recipe {
    return Recipe(
        id = RecipeId(id),
        name = name,
        score = score,
        duration = duration.minutes
    )
}