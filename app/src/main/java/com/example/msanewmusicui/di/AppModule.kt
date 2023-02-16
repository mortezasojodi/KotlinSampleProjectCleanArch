package com.example.msanewmusicui.di

import com.example.msanewmusicui.Home.HomeViewModel
import com.example.msanewmusicui.core.domain.usecase.AnimeInteractor
import com.example.msanewmusicui.core.domain.usecase.AnimeUseCase
import org.koin.dsl.module

import org.koin.androidx.viewmodel.dsl.viewModel

val useCaseModule = module {
    factory<AnimeUseCase> { AnimeInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }

}