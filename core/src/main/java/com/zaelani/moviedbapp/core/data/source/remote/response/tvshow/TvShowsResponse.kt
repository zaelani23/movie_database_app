package com.zaelani.moviedbapp.core.data.source.remote.response.tvshow

import com.google.gson.annotations.SerializedName

data class TvShowsResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<TvShowResponse>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
