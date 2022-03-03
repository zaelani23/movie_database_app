package com.zaelani.moviedbapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShow(
    val id: Int,

    val name: String,

    val firstAirDate: String,

    val voteAverage: Double,

    val overview : String,

    val popularity: Double,

    val posterPath: String? = null,

    var isFav: Boolean
): Parcelable