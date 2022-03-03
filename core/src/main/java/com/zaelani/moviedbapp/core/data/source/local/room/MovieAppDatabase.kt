package com.zaelani.moviedbapp.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zaelani.moviedbapp.core.data.source.local.entity.MovieEntity
import com.zaelani.moviedbapp.core.data.source.local.entity.TvShowEntity

@Database(
    entities = [com.zaelani.moviedbapp.core.data.source.local.entity.MovieEntity::class, com.zaelani.moviedbapp.core.data.source.local.entity.TvShowEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieAppDatabase : RoomDatabase(){
    abstract fun movieDBAppDao(): com.zaelani.moviedbapp.core.data.source.local.room.MovieDBAppDao
}