package com.zaelani.moviedbapp.favorite.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.zaelani.moviedbapp.core.domain.usecase.movie.MovieUseCase

class FavoriteMovieViewModel(movieUseCase: MovieUseCase): ViewModel() {
    val favMovies = movieUseCase.getFavMovies().asLiveData()
}