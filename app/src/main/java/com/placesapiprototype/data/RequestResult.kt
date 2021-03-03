package com.placesapiprototype.data

import ResponseBase

data class RequestResult<out T>(
    var resultType: ResultType,
    val data: T? = null,
    val error: Exception? = null
) {

    companion object {
        fun <T> success(data: T?): RequestResult<T> {
            return RequestResult(ResultType.SUCCESS, data)
        }

        fun <T> error(error: Exception? = null): RequestResult<ResponseBase> {
            return RequestResult(ResultType.ERROR, error = error)
        }
    }
}