package com.zaelani.moviedbapp.favorite.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.zaelani.moviedbapp.core.domain.usecase.tvshow.TvShowUseCase

class FavoriteTvShowViewModel(tvShowUseCase: TvShowUseCase): ViewModel() {
    val favTvShows = tvShowUseCase.getFavTvShows().asLiveData()
}