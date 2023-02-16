package com.example.msanewmusicui.core.data

import com.example.msanewmusicui.core.data.source.local.LocalDataSource
import com.example.msanewmusicui.core.data.source.remote.RemoteDataSource
import com.example.msanewmusicui.core.data.source.remote.network.ApiResponse
import com.example.msanewmusicui.core.data.source.remote.response.AnimeResponse
import com.example.msanewmusicui.core.domain.model.Anime
import com.example.msanewmusicui.core.domain.repository.IAnimeRepository
import com.example.msanewmusicui.core.utils.AppExecutors
import com.example.msanewmusicui.core.utils.DataMapper
import kotlinx.coroutines.flow.*


class AnimeRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IAnimeRepository {

    override fun getAllAnime(): Flow<Resource<List<Anime>>> =
        object : NetworkBoundResource<List<Anime>, List<AnimeResponse>>() {
            override fun loadFromDB(): Flow<List<Anime>> {
                return localDataSource.getAllAnime().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Anime>?): Boolean {
                return true// data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<AnimeResponse>>> {
                return remoteDataSource.getAllAnime()
            }

            override suspend fun saveCallResult(data: List<AnimeResponse>) {
                val animeList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertAnime(animeList)
            }
        }.asFlow()

    override fun getFavoriteAnime(): Flow<List<Anime>> {
        return localDataSource.getFavoriteAnime().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteAnime(anime: Anime, state: Boolean) {
        val animeEntity = DataMapper.mapDomainToEntity(anime)
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteAnime(animeEntity, state)
        }
    }
}