package com.zaelani.moviedbapp.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zaelani.moviedbapp.core.data.source.local.entity.MovieEntity
import com.zaelani.moviedbapp.core.data.source.local.entity.TvShowEntity

@Database(
    entities = [MovieEntity::class, TvShowEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieAppDatabase : RoomDatabase(){
    abstract fun movieDBAppDao(): MovieDBAppDao
}