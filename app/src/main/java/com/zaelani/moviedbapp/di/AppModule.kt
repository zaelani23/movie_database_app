package com.zaelani.moviedbapp.di

import com.zaelani.moviedbapp.core.domain.usecase.movie.MovieInteractor
import com.zaelani.moviedbapp.core.domain.usecase.movie.MovieUseCase
import com.zaelani.moviedbapp.core.domain.usecase.tvshow.TvShowInteractor
import com.zaelani.moviedbapp.core.domain.usecase.tvshow.TvShowUseCase
import com.zaelani.moviedbapp.detail.movie.MovieDetailViewModel
import com.zaelani.moviedbapp.detail.tvshow.TvShowDetailViewModel
import com.zaelani.moviedbapp.mainscreen.movie.MovieViewModel
import com.zaelani.moviedbapp.mainscreen.tvshow.TvShowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase>{MovieInteractor(get())}
    factory<TvShowUseCase>{TvShowInteractor(get())}
}

val viewModelModule = module {
    viewModel{ MovieViewModel(get()) }
    viewModel{ MovieDetailViewModel(get()) }

    viewModel{ TvShowViewModel(get()) }
    viewModel{ TvShowDetailViewModel(get()) }
}
