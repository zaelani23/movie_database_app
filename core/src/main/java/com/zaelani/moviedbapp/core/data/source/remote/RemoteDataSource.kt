package com.zaelani.moviedbapp.core.data.source.remote

import com.zaelani.moviedbapp.core.data.source.remote.network.ApiResponse
import com.zaelani.moviedbapp.core.data.source.remote.network.ApiService
import com.zaelani.moviedbapp.core.data.source.remote.response.movie.MovieResponse
import com.zaelani.moviedbapp.core.data.source.remote.response.tvshow.TvShowResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    fun getMovies(): Flow<ApiResponse<List<MovieResponse>>>{
        return flow {
            try {
                val response = apiService.getMovies()
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(dataArray))
                }else{
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getTvShows(): Flow<ApiResponse<List<TvShowResponse>>>{
        return flow {
            try {
                val response = apiService.getTvShows()
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(dataArray))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}