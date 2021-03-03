package com.placesapiprototype.data

import ResponseBase
import com.placesapiprototype.data.RequestResult.Companion.error
import com.placesapiprototype.data.remote.RemoteDataSource

class RepositoryImpl(private val remoteDataSource: RemoteDataSource) : Repository
{

    override suspend fun getLocalCoffeeOutlete(): RequestResult<ResponseBase>? {
        var page = 1
        var result:RequestResult<ResponseBase>
        //val mutableBeers: MutableList<BeerApi> = mutableListOf()

//        val allBeers: List<BeerLocalModel> = beersCacheDataSource.beers
//        if (allBeers.isNotEmpty()) return Result.success(LocalToEntityMapper.map(allBeers))

        do {
            //page = getPageToCheckBeers(page, mutableBeers.isNotEmpty(), mutableBeers.size)

            remoteDataSource.getLocalCoffeeOutlets().let { requesstResultResponseBase ->
                if (requesstResultResponseBase.resultType == ResultType.SUCCESS) {
//                    resultListBeerResponse.data?.let {
//                        mutableBeers.addAll(resultListBeerResponse.data)
//                    }
                }

                result = if (requesstResultResponseBase.resultType == ResultType.SUCCESS ){
                    RequestResult.success(requesstResultResponseBase.data)
                } else {
                    RequestResult.success(requesstResultResponseBase.data)
                }
            }
        } while (result?.resultType != error<Error>().resultType && page != -1)

        // if (result?.resultType == ResultType.SUCCESS) beersCacheDataSource.beers = ApiToLocalModelMapper.map(mutableBeers.toList())

        return result
    }

}