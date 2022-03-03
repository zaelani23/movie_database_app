package com.zaelani.moviedbapp.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tv_show_entities")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "firstAirDate")
    val firstAirDate: String,

    @ColumnInfo(name = "voteAverage")
    val voteAverage: Double,

    @ColumnInfo(name = "overview")
    val overview : String,

    @ColumnInfo(name = "popularity")
    val popularity: Double,

    @ColumnInfo(name = "posterPath")
    val posterPath: String? = null,

    @ColumnInfo(name = "isFav")
    var isFav: Boolean = false
)
