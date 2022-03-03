package com.zaelani.moviedbapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,

    val title : String,

    val releaseDate : String,

    val voteAverage: Double,

    val overview : String,

    val popularity: Double,

    val posterPath : String,

    var isFav: Boolean
): Parcelable
