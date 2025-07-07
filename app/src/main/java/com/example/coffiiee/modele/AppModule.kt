package com.example.coffiiee.modele


import com.example.coffiiee.viewModel.CoffeeViewModel
import com.example.coffiiee.viewModel.CupSizeViewModel
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