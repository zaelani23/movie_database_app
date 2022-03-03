package com.zaelani.moviedbapp.detail.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.zaelani.moviedbapp.core.domain.model.Movie
import com.zaelani.moviedbapp.core.domain.usecase.movie.MovieUseCase

class MovieDetailViewModel(private val movieUseCase: MovieUseCase): ViewModel() {
    fun getMovieDetail(id: Int) =
        movieUseCase.getDetailMovie(id).asLiveData()

    fun updateFavoriteMovie(movie: Movie, state: Boolean) =
        movieUseCase.updateFavoriteMovie(movie, state)
}