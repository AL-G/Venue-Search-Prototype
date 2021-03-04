package com.placesapiprototype.data

import com.placesapiprototype.data.model.ResponseBase
import com.placesapiprototype.data.remote.RemoteDataSource

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : Repository {

    override suspend fun getLocalCoffeeOutlete(latLong: String): RequestResult<ResponseBase> {
        var result: RequestResult<ResponseBase>
        remoteDataSource.getLocalCoffeeOutlets(latLong).let { requesstResultResponseBase ->
            result = if (requesstResultResponseBase.resultType == ResultType.SUCCESS) {
                RequestResult.success(requesstResultResponseBase.data)
            } else {
                RequestResult.error<Exception>(Exception("There was a problem"))
            }
        }
        return result
    }
}