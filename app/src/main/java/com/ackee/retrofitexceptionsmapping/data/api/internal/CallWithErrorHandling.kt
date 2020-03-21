package com.ackee.retrofitexceptionsmapping.data.api.internal

import com.ackee.retrofitexceptionsmapping.data.api.errors.ExceptionsMapper
import com.ackee.retrofitexceptionsmapping.data.api.errors.HttpExceptionMapper
import com.ackee.retrofitexceptionsmapping.data.api.errors.mapToDomainException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Invocation
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
                    callback.onFailure(call, mapExceptionOfCall(call, HttpException(response)))
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                callback.onFailure(call, mapExceptionOfCall(call, t))
            }
        })
    }

    fun mapExceptionOfCall(call: Call<Any>, t: Throwable): Exception {
        val retrofitInvocation = call.request().tag(Invocation::class.java)
        val annotation = retrofitInvocation?.method()?.getAnnotation(
            ExceptionsMapper::class.java)
        val mapper = try {
            annotation?.value?.java?.constructors?.first()?.newInstance(retrofitInvocation.arguments()) as HttpExceptionMapper
        } catch (e: Exception) {
            null
        }
        return mapToDomainException(t, mapper)
    }

    override fun clone() = CallWithErrorHandling(delegate.clone())
}