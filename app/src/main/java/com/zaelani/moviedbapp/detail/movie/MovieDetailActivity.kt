package com.zaelani.moviedbapp.detail.movie

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.zaelani.moviedbapp.R
import com.zaelani.moviedbapp.core.domain.model.Movie
import com.zaelani.moviedbapp.core.utils.NetworkInfo.IMAGE_URL
import com.zaelani.moviedbapp.databinding.ActivityMovieDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailActivity : AppCompatActivity() {

    private val movieDetailViewModel: MovieDetailViewModel by viewModel()

    private var _activityMovieDetailBinding: ActivityMovieDetailBinding? = null
    private val activityMovieDetailBinding get() = _activityMovieDetailBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityMovieDetailBinding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(activityMovieDetailBinding.root)
        supportActionBar?.title = getString(R.string.title_movie_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movieId = intent.getIntExtra(EXTRA_MOVIE_ID, 0)

        movieDetailViewModel.getMovieDetail(movieId).observe(this) { movie ->
            populatesMovie(movie)
        }
    }

    private fun populatesMovie(movie: Movie) {
        with(activityMovieDetailBinding.detailContent){
            textTitle.text = movie.title
            textRelease.text = movie.releaseDate
            textMovieOverview.text = movie.overview
            textMovieScore.text = getString(R.string.str_user_score, movie.voteAverage.toString())
            textMoviePopularity.text = getString(R.string.str_popularity, movie.popularity.toString())
            Glide.with(activityMovieDetailBinding.detailContent.root)
                .load(IMAGE_URL + movie.posterPath)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster)

            var statusFavorite = movie.isFav
            setStatusFavorite(statusFavorite)

            btnFavMovie.setOnClickListener{
                statusFavorite = !statusFavorite
                movieDetailViewModel.updateFavoriteMovie(movie, statusFavorite)
                setStatusFavorite(statusFavorite)
                Toast.makeText(
                    this@MovieDetailActivity,
                    "Berhasil!",
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        with(activityMovieDetailBinding.detailContent) {
            if (statusFavorite) {
                val favIcon: Drawable? =
                    ResourcesCompat.getDrawable(resources,R.drawable.ic_delete_forever_24, theme)
                btnFavMovie.setCompoundDrawablesWithIntrinsicBounds(favIcon, null, null, null)
                btnFavMovie.text = getString(R.string.str_delete_favorite)
            } else {
                val favIcon: Drawable? =
                    ResourcesCompat.getDrawable(resources,R.drawable.ic_favorite_24, theme)
                btnFavMovie.setCompoundDrawablesWithIntrinsicBounds(favIcon, null, null, null)
                btnFavMovie.text = getString(R.string.str_add_favorite)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _activityMovieDetailBinding = null
    }

    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"
    }
}