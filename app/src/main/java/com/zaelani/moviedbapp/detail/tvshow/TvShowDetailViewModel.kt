package com.zaelani.moviedbapp.detail.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.zaelani.moviedbapp.core.domain.model.TvShow
import com.zaelani.moviedbapp.core.domain.usecase.tvshow.TvShowUseCase

class TvShowDetailViewModel(private val tvShowUseCase: TvShowUseCase): ViewModel() {
    fun getTvShowDetail(id: Int) =
        tvShowUseCase.getDetailTvShow(id).asLiveData()

    fun updateFavoriteTvShow(tvShow: TvShow, state: Boolean) =
        tvShowUseCase.updateFavoriteTvShow(tvShow, state)
}