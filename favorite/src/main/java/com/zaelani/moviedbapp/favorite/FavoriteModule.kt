package com.zaelani.moviedbapp.favorite

import com.zaelani.moviedbapp.favorite.movie.FavoriteMovieViewModel
import com.zaelani.moviedbapp.favorite.tvshow.FavoriteTvShowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ FavoriteMovieViewModel(get()) }
    viewModel{ FavoriteTvShowViewModel(get()) }
}
