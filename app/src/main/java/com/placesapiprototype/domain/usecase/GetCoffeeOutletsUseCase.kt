package com.placesapiprototype.domain.usecase

import com.placesapiprototype.data.RepositoryImpl
import com.placesapiprototype.data.RequestResult
import com.placesapiprototype.data.model.ResponseBase

class GetCoffeeOutletsUseCase(
    private val placesRepository: RepositoryImpl
) {

    suspend fun execute(): RequestResult<ResponseBase> {
        lateinit var outlets: RequestResult<ResponseBase>
        placesRepository.getLocalCoffeeOutlete().let { placesEntity ->
            outlets = placesEntity
        }
        return outlets
    }

}