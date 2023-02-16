package com.example.msanewmusicui.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.msanewmusicui.core.domain.usecase.AnimeUseCase

class HomeViewModel(animeUseCase: AnimeUseCase) : ViewModel() {

    val anime = animeUseCase.getAllAnime().asLiveData()

}