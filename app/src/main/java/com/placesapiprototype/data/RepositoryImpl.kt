package com.placesapiprototype.data

import ResponseBase
import com.placesapiprototype.data.remote.RemoteDataSource

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : Repository {

    override suspend fun getLocalCoffeeOutlete(): RequestResult<ResponseBase>? {

        var result: RequestResult<ResponseBase>

        remoteDataSource.getLocalCoffeeOutlets().let { requesstResultResponseBase ->

            result = if (requesstResultResponseBase.resultType == ResultType.SUCCESS) {
                RequestResult.success(requesstResultResponseBase.data)
            } else {
                RequestResult.error<Exception>(Exception("There was a problem"))
            }
        }
        return result
    }
}