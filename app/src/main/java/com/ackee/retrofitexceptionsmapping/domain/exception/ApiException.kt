package com.ackee.retrofitexceptionsmapping.domain.exception

data class ApiException(val statusCode: String) : Exception()