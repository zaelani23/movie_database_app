package com.zaelani.moviedbapp.core.data.source.local

import com.zaelani.moviedbapp.core.data.source.local.entity.MovieEntity
import com.zaelani.moviedbapp.core.data.source.local.entity.TvShowEntity
import com.zaelani.moviedbapp.core.data.source.local.room.MovieDBAppDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDBAppDao: MovieDBAppDao)  {

    fun getAllMovie(): Flow<List<MovieEntity>> = movieDBAppDao.getAllMovie()

    fun getAllTvShow(): Flow<List<TvShowEntity>> = movieDBAppDao.getAllTvShow()

    fun getFavMovies(): Flow<List<MovieEntity>> = movieDBAppDao.getFavMovies()

    fun getFavTvShows(): Flow<List<TvShowEntity>> = movieDBAppDao.getFavTvShows()

    suspend fun insertMovies(movies: List<MovieEntity>) = movieDBAppDao.insertMovies(movies)

    suspend fun insertTvShows(tvShows: List<TvShowEntity>) = movieDBAppDao.insertTvShows(tvShows)

    fun getDetailMovie(id: Int): Flow<MovieEntity> = movieDBAppDao.getDetailMovie(id)

    fun getDetailTvShow(id: Int): Flow<TvShowEntity> = movieDBAppDao.getDetailTvShow(id)

    fun updateFavoriteMovie(movie: MovieEntity, newState: Boolean){
        movie.isFav = newState
        movieDBAppDao.updateFavoriteMovie(movie)
    }

    fun updateFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean){
        tvShow.isFav = newState
        movieDBAppDao.updateFavoriteTvShow(tvShow)
    }
}