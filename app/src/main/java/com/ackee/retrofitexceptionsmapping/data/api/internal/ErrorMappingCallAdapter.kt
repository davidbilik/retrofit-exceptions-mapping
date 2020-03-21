package com.ackee.retrofitexceptionsmapping.data.api.internal

import retrofit2.Call
import retrofit2.CallAdapter

internal class ErrorsCallAdapter(
    private val delegateAdapter: CallAdapter<Any, Call<*>>
) : CallAdapter<Any, Call<*>> by delegateAdapter {

    override fun adapt(call: Call<Any>): Call<*> {
        return delegateAdapter.adapt(CallWithErrorHandling(call))
    }
}

