package com.ackee.retrofitexceptionsmapping.data.api.errors

import com.ackee.retrofitexceptionsmapping.domain.exception.ApiException
import com.ackee.retrofitexceptionsmapping.domain.exception.NoInternetException
import com.ackee.retrofitexceptionsmapping.domain.exception.UnexpectedException
import retrofit2.HttpException
import java.io.IOException

fun mapToDomainException(
    remoteException: Throwable,
    httpExceptionsMapper: (HttpException) -> Exception? = { null }
): Exception {
    return when (remoteException) {
        is IOException -> NoInternetException()
        is HttpException -> httpExceptionsMapper(remoteException) ?: ApiException(remoteException.code().toString())
        else -> UnexpectedException(remoteException)
    }
}