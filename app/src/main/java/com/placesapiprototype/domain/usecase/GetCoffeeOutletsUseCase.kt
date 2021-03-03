package com.placesapiprototype.domain.usecase

import ResponseBase
import com.placesapiprototype.data.Repository
import com.placesapiprototype.data.RepositoryImpl
import com.placesapiprototype.data.RequestResult
import com.placesapiprototype.data.ResultType

class GetCoffeeOutletsUseCase(
    private val placesRepository: RepositoryImpl
     ) {

//    suspend fun execute(): RequestResult<ResponseBase> {
//
//        lateinit var outlets: RequestResult<ResponseBase>
//
//        placesRepository.getLocalCoffeeOutlete()?.let { placesEntity ->
//            val resultType = placesEntity.resultType
//
//            outlets = placesEntity
////            if (resultType == ResultType.SUCCESS) {
////                outlets = RequestResult.success(placesEntity)
////            } else {
////                outlets = RequestResult.error(placesEntity)
////            }
//        }
//
//        return outlets
//    }
}