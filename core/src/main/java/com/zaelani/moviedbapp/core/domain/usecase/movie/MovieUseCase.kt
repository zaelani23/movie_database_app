package com.zaelani.moviedbapp.core.domain.usecase.movie

import com.zaelani.moviedbapp.core.data.Resource
import com.zaelani.moviedbapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovie(): Flow<Resource<List<Movie>>>
    fun getFavMovies(): Flow<List<Movie>>
    fun getDetailMovie(id: Int): Flow<Movie>
    fun updateFavoriteMovie(movie: Movie, state: Boolean)
}