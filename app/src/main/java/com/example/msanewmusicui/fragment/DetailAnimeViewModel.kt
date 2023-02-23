package com.example.msanewmusicui.fragment

import androidx.lifecycle.ViewModel
import com.example.msanewmusicui.core.domain.model.Anime
import com.example.msanewmusicui.core.domain.usecase.AnimeUseCase

class DetailAnimeViewModel(private val animeUseCase: AnimeUseCase) : ViewModel() {

    fun setFavoriteAnime(anime: Anime, newStatus: Boolean) =
        animeUseCase.setFavoriteAnime(anime, newStatus)

}