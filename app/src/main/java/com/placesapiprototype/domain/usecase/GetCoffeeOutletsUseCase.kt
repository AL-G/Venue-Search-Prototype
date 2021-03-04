package com.placesapiprototype.domain.usecase

import com.placesapiprototype.data.Repository
import com.placesapiprototype.data.RequestResult
import com.placesapiprototype.data.model.ResponseBase

class GetCoffeeOutletsUseCase(
    private val placesRepository: Repository
) {

    suspend fun execute(lat: String, long: String): RequestResult<ResponseBase> {
        lateinit var outlets: RequestResult<ResponseBase>
        placesRepository.getLocalCoffeeOutlete("""${lat},${long}""").let { placesEntity ->
            if (placesEntity != null) {
                outlets = placesEntity
            }
        }
        return outlets
    }

}