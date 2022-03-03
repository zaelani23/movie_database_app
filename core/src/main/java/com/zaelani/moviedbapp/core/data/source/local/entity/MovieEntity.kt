package com.zaelani.moviedbapp.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_entities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title : String,

    @ColumnInfo(name = "releaseDate")
    val releaseDate : String,

    @ColumnInfo(name = "voteAverage")
    val voteAverage: Double,

    @ColumnInfo(name = "overview")
    val overview : String,

    @ColumnInfo(name = "popularity")
    val popularity: Double,

    @ColumnInfo(name = "posterPath")
    val posterPath : String,

    @ColumnInfo(name = "isFav")
    var isFav: Boolean = false
)
