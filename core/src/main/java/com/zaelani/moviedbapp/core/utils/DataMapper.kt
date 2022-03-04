package com.zaelani.moviedbapp.core.utils

import com.zaelani.moviedbapp.core.data.source.local.entity.MovieEntity
import com.zaelani.moviedbapp.core.data.source.local.entity.TvShowEntity
import com.zaelani.moviedbapp.core.data.source.remote.response.movie.MovieResponse
import com.zaelani.moviedbapp.core.data.source.remote.response.tvshow.TvShowResponse
import com.zaelani.moviedbapp.core.domain.model.Movie
import com.zaelani.moviedbapp.core.domain.model.TvShow

object DataMapper {
    fun mapMovieResponsesToEntities(input: List<MovieResponse>): List<MovieEntity>{
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                isFav = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapTvShowResponsesToEntities(input: List<TvShowResponse>): List<TvShowEntity>{
        val tvShowList = ArrayList<TvShowEntity>()
        input.map {
            val tvShow = TvShowEntity(
                id = it.id,
                name = it.name,
                firstAirDate = it.firstAirDate,
                voteAverage = it.voteAverage,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                isFav = false
            )
            tvShowList.add(tvShow)
        }
        return tvShowList
    }

    fun mapMovieEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                isFav = it.isFav
            )
        }

    fun mapTvShowEntitiesToDomain(input: List<TvShowEntity>): List<TvShow> =
        input.map {
            TvShow(
                id = it.id,
                name = it.name,
                firstAirDate = it.firstAirDate,
                voteAverage = it.voteAverage,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                isFav = it.isFav
            )
        }

    fun mapMovieDomainToEntity(input: Movie) =
        MovieEntity(
            id = input.id,
            title = input.title,
            releaseDate = input.releaseDate,
            voteAverage = input.voteAverage,
            overview = input.overview,
            popularity = input.popularity,
            posterPath = input.posterPath,
            isFav = input.isFav
        )

    fun mapTvShowDomainToEntity(input: TvShow) =
        TvShowEntity(
            id = input.id,
            name = input.name,
            firstAirDate = input.firstAirDate,
            voteAverage = input.voteAverage,
            overview = input.overview,
            popularity = input.popularity,
            posterPath = input.posterPath,
            isFav = input.isFav
        )

    fun mapMovieEntityToDomain(input: MovieEntity) = Movie(
        id = input.id,
        title = input.title,
        releaseDate = input.releaseDate,
        voteAverage = input.voteAverage,
        overview = input.overview,
        popularity = input.popularity,
        posterPath = input.posterPath,
        isFav = input.isFav
    )

    fun mapTvShowEntityToDomain(input: TvShowEntity) = TvShow(
        id = input.id,
        name = input.name,
        firstAirDate = input.firstAirDate,
        voteAverage = input.voteAverage,
        overview = input.overview,
        popularity = input.popularity,
        posterPath = input.posterPath,
        isFav = input.isFav
    )
}