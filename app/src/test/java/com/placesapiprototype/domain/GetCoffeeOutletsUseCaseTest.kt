package com.placesapiprototype.domain

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.placesapiprototype.Util
import com.placesapiprototype.data.Repository
import com.placesapiprototype.data.RequestResult
import com.placesapiprototype.domain.usecase.GetCoffeeOutletsUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetCoffeeOutletsUseCaseTest {

    private val mockRepository: Repository = mock()
    private val getCoffeeOutletsUseCase = GetCoffeeOutletsUseCase(mockRepository)

    @Test
    fun verifyBusinessErrorWhenRepoMockReturnNetworkError() {
        runBlocking {
            given(mockRepository.getLocalCoffeeOutlets(""))
                .willReturn(RequestResult.error<Exception>(Exception("Generic exception")))

            val expectedResult = RequestResult.error<Exception>(Exception()).error
            val realResult = getCoffeeOutletsUseCase.execute("", "").error

            Assert.assertEquals(expectedResult is Exception, realResult is Exception)
        }
    }

    @Test
    fun verifyResultWhenRepoMockReturnSuccessState() {
        runBlocking {
            val result = RequestResult.success(Util.getDummyResponseBase())
            val base = RequestResult.success(result)

            given(mockRepository.getLocalCoffeeOutlets("")).willReturn(base.data)

            val expectedResult = RequestResult.success(base.data)
            val realResult = getCoffeeOutletsUseCase.execute("", "")

            Assert.assertEquals(expectedResult, realResult)
        }
    }


}