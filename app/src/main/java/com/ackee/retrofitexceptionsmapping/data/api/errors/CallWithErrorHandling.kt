package com.ackee.retrofitexceptionsmapping.data.api.errors

import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

internal class CallWithErrorHandling(
    private val delegate: Call<Any>
) : Call<Any> by delegate {

    override fun enqueue(callback: Callback<Any>) {
        delegate.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.isSuccessful) {
                    callback.onResponse(call, response)
                } else {
                    callback.onFailure(call, mapToDomainException(HttpException(response)))
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                callback.onFailure(call, mapToDomainException(t))
            }
        })
    }

    override fun clone() = CallWithErrorHandling(delegate.clone())
}