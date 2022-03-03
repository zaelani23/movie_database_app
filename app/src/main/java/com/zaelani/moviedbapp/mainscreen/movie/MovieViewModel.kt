package com.zaelani.moviedbapp.mainscreen.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.zaelani.moviedbapp.core.domain.usecase.movie.MovieUseCase

class MovieViewModel(movieUseCase: MovieUseCase): ViewModel() {
    val movies = movieUseCase.getAllMovie().asLiveData()
}