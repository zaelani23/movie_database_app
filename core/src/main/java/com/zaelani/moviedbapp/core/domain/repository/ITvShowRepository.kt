package com.zaelani.moviedbapp.core.domain.repository

import com.zaelani.moviedbapp.core.data.Resource
import com.zaelani.moviedbapp.core.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface ITvShowRepository {
    fun getAllTvShow(): Flow<Resource<List<TvShow>>>
    fun getFavTvShows(): Flow<List<TvShow>>
    fun getDetailTvShow(id: Int): Flow<TvShow>
    fun updateFavoriteTvShow(tvShow: TvShow, state: Boolean)
}