package com.placesapiprototype.domain.usecase

import ResponseBase
import com.placesapiprototype.data.RepositoryImpl
import com.placesapiprototype.data.RequestResult

class GetCoffeeOutletsUseCase(
    private val placesRepository: RepositoryImpl
) {

        suspend fun execute(): RequestResult<ResponseBase> {

        lateinit var outlets: RequestResult<ResponseBase>

        placesRepository.getLocalCoffeeOutlete()?.let { placesEntity ->
            outlets = placesEntity
        }

        return outlets
    }

}