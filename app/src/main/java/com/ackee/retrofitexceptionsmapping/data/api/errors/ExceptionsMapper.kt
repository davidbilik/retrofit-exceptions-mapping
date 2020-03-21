package com.ackee.retrofitexceptionsmapping.data.api.errors

import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class ExceptionsMapper(val value: KClass<out HttpExceptionMapper>)