package com.ackee.retrofitexceptionsmapping.domain.exception

import com.ackee.retrofitexceptionsmapping.domain.entity.RecipeId

data class RecipeNotFoundException(val recipeId: RecipeId) : Exception()