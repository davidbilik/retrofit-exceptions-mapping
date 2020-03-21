package com.ackee.retrofitexceptionsmapping.data.api.errors

import retrofit2.HttpException

abstract class HttpExceptionMapper(protected val callArguments: List<String>) {

    abstract fun map(httpException: HttpException): Exception?
}