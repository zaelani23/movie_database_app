package com.zaelani.moviedbapp.core.domain.repository

import com.zaelani.moviedbapp.core.data.Resource
import com.zaelani.moviedbapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getAllMovie(): Flow<Resource<List<Movie>>>
    fun getFavMovies(): Flow<List<Movie>>
    fun getDetailMovie(id: Int): Flow<Movie>
    fun updateFavoriteMovie(movie: Movie, state: Boolean)
}