package com.example.msanewmusicui.core.domain.usecase

import com.example.msanewmusicui.core.data.Resource
import com.example.msanewmusicui.core.domain.model.Anime
import com.example.msanewmusicui.core.domain.repository.IAnimeRepository
import kotlinx.coroutines.flow.Flow

class AnimeInteractor(private val animeRepository: IAnimeRepository): AnimeUseCase {
    override fun getAllAnime(): Flow<Resource<List<Anime>>> {
        return animeRepository.getAllAnime()
    }

    override fun getFavoriteAnime(): Flow<List<Anime>> {
        return animeRepository.getFavoriteAnime()
    }

    override fun setFavoriteAnime(anime: Anime, state: Boolean) {
        return animeRepository.setFavoriteAnime(anime, state)
    }
}