package com.example.msanewmusicui.core.data.source.local

import com.example.msanewmusicui.core.data.source.local.entity.AnimeEntity
import com.example.msanewmusicui.core.data.source.local.room.AnimeDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val animeDao: AnimeDao) {

    fun getAllAnime(): Flow<List<AnimeEntity>> {
        return  animeDao.getAllAnime();
    }

    fun getFavoriteAnime(): Flow<List<AnimeEntity>> {
        return  animeDao.getFavoriteAnime()
    }

    suspend fun insertAnime(animeList: List<AnimeEntity>)  {
        return animeDao.insertAnime(animeList);
    }

    fun setFavoriteAnime(anime: AnimeEntity, newState: Boolean) {
        anime.isFavorite = newState
        animeDao.updateFavoriteAnime(anime)
    }
}