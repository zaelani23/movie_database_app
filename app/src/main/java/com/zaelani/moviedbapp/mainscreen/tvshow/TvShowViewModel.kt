package com.zaelani.moviedbapp.mainscreen.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.zaelani.moviedbapp.core.domain.usecase.tvshow.TvShowUseCase

class TvShowViewModel(tvShowUseCase: TvShowUseCase): ViewModel() {
    val tvShows = tvShowUseCase.getAllTvShow().asLiveData()
}