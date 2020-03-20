package com.ackee.retrofitexceptionsmapping.domain.entity

import kotlin.time.Duration

data class Recipe(
    val id: RecipeId,
    val name: String,
    val duration: Duration,
    val score: Double
)