package com.zaelani.moviedbapp.core.domain.usecase.movie

import com.zaelani.moviedbapp.core.domain.model.Movie
import com.zaelani.moviedbapp.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository): MovieUseCase {

    override fun getAllMovie() = movieRepository.getAllMovie()

    override fun getFavMovies() = movieRepository.getFavMovies()

    override fun getDetailMovie(id: Int) = movieRepository.getDetailMovie(id)

    override fun updateFavoriteMovie(movie: Movie, state: Boolean) =
        movieRepository.updateFavoriteMovie(movie, state)
}