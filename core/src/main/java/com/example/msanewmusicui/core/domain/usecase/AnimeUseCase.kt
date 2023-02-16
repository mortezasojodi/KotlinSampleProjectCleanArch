package com.example.msanewmusicui.core.domain.usecase

import com.example.msanewmusicui.core.data.Resource
import com.example.msanewmusicui.core.domain.model.Anime

import kotlinx.coroutines.flow.Flow

interface AnimeUseCase {
    fun getAllAnime(): Flow<Resource<List<Anime>>>
    fun getFavoriteAnime(): Flow<List<Anime>>
    fun setFavoriteAnime(anime: Anime, state: Boolean)
}