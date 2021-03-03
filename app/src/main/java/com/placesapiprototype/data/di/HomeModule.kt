package com.placesapiprototype.data.di

import androidx.appcompat.widget.AppCompatImageView
import com.placesapiprototype.domain.usecase.GetCoffeeOutletsUseCase
import com.placesapiprototype.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    factory { GetCoffeeOutletsUseCase() }
    viewModel {
        MainViewModel(
            searchCoffeeOutletsUseCase = get()
        )
    }
}