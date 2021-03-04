package com.placesapiprototype.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.placesapiprototype.Util
import com.placesapiprototype.data.RequestResult
import com.placesapiprototype.domain.usecase.GetCoffeeOutletsUseCase
import com.placesapiprototype.presentation.MainViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class MainViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val mainCoroutineRule = MainCoroutineRule()

    private var mockGetCoffeeOutletsUseCase: GetCoffeeOutletsUseCase = mockk()
    private lateinit var viewModel: MainViewModel

    @Test
    fun verifyErrorMessageIsSetWhenResultIsError() {
        mainCoroutineRule.runBlockingTest {
            val result = RequestResult.error<Exception>(Exception("There was a problem"))
            // given
            coEvery { mockGetCoffeeOutletsUseCase.execute("", "") } returns result

            // when
            viewModel = MainViewModel(
                searchCoffeeOutletsUseCase = mockGetCoffeeOutletsUseCase
            )
            viewModel.refreshLocalCoffeeOutlets()
            // then
            Assert.assertEquals(true, viewModel.errorMessages?.getOrAwaitValue()?.isNotEmpty())
        }
    }

    @Test
    fun verifyVenuesLiveDataIsNotEmptyWhenResultIsSuccess() {
        mainCoroutineRule.runBlockingTest {
            val result = RequestResult.success(Util.getDummyResponseBase())
            // given
            coEvery { mockGetCoffeeOutletsUseCase.execute("", "") } returns result

            // when
            viewModel = MainViewModel(
                searchCoffeeOutletsUseCase = mockGetCoffeeOutletsUseCase
            )
            viewModel.refreshLocalCoffeeOutlets()
            // then
            Assert.assertEquals(true, viewModel.coffeeOutlets?.getOrAwaitValue()?.isNotEmpty())
        }
    }

}