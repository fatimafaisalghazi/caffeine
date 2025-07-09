package com.example.coffiiee.di


import com.example.coffiiee.ui.viewModel.CoffeeViewModel
import com.example.coffiiee.ui.viewModel.CupSizeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.annotation.KoinReflectAPI
import org.koin.dsl.module

@OptIn(KoinReflectAPI::class)
val appModule = module {
    viewModel<CoffeeViewModel>()
    viewModel {
        CupSizeViewModel()
    }
}