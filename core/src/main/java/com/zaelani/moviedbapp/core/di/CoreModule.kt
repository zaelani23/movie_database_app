package com.zaelani.moviedbapp.core.di

import androidx.room.Room
import com.zaelani.moviedbapp.core.data.MovieRepository
import com.zaelani.moviedbapp.core.data.TvShowRepository
import com.zaelani.moviedbapp.core.data.source.local.LocalDataSource
import com.zaelani.moviedbapp.core.data.source.local.room.MovieAppDatabase
import com.zaelani.moviedbapp.core.data.source.remote.RemoteDataSource
import com.zaelani.moviedbapp.core.data.source.remote.network.ApiService
import com.zaelani.moviedbapp.core.domain.repository.IMovieRepository
import com.zaelani.moviedbapp.core.domain.repository.ITvShowRepository
import com.zaelani.moviedbapp.core.utils.AppExecutors
import com.zaelani.moviedbapp.core.utils.NetworkInfo.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<MovieAppDatabase>().movieDBAppDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            MovieAppDatabase::class.java, "moviedb.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IMovieRepository>{
        MovieRepository(
            get(),
            get(),
            get()
        )
    }
    single<ITvShowRepository>{
        TvShowRepository(
            get(),
            get(),
            get()
        )
    }
}
