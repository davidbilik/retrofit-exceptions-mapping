package com.ackee.retrofitexceptionsmapping.domain

sealed class AsyncState<out T> {

    object Loading : AsyncState<Nothing>()
    data class Error(val exception: Exception) : AsyncState<Nothing>()
    data class Loaded<T>(val data: T) : AsyncState<T>()
}