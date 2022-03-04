package com.zaelani.moviedbapp.core.data.source.remote.network

import com.zaelani.moviedbapp.core.data.source.remote.response.movie.MoviesResponse
import com.zaelani.moviedbapp.core.data.source.remote.response.tvshow.TvShowsResponse
import com.zaelani.moviedbapp.core.utils.NetworkInfo.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String = API_KEY
    ): MoviesResponse

    @GET("discover/tv")
    suspend fun getTvShows(
        @Query("api_key") apiKey: String = API_KEY
    ): TvShowsResponse
}