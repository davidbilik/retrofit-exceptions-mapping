package com.ackee.retrofitexceptionsmapping.data.api.errors

import com.ackee.retrofitexceptionsmapping.domain.entity.RecipeId
import com.ackee.retrofitexceptionsmapping.domain.exception.RecipeNotFoundException
import retrofit2.HttpException

class RecipeDetailExceptionMapper(arguments: List<String>) : HttpExceptionMapper(arguments) {

    override fun map(httpException: HttpException): Exception? {
        return if (httpException.code() == 404) {
            RecipeNotFoundException(RecipeId(callArguments.first()))
        } else {
            null
        }
    }
}