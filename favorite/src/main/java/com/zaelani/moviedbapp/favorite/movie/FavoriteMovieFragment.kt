package com.zaelani.moviedbapp.favorite.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zaelani.moviedbapp.core.ui.MovieAdapter
import com.zaelani.moviedbapp.databinding.FragmentMovieBinding
import com.zaelani.moviedbapp.detail.movie.MovieDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteMovieFragment : Fragment() {

    private val favoriteMovieViewModel: FavoriteMovieViewModel by viewModel()
    private lateinit var movieAdapter: MovieAdapter

    private var _fragmentMovieBinding: FragmentMovieBinding? = null
    private val fragmentMovieBinding get() = _fragmentMovieBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (activity != null) {
            movieAdapter = MovieAdapter()
            movieAdapter.onItemClick = {selectedData ->
                val moveIntent = Intent(requireActivity(), MovieDetailActivity::class.java)
                moveIntent.putExtra(MovieDetailActivity.EXTRA_MOVIE_ID, selectedData.id)
                startActivity(moveIntent)
            }

            favoriteMovieViewModel.favMovies.observe(viewLifecycleOwner) { movies ->
                fragmentMovieBinding.viewEmpty.root.visibility =
                    if (movies.isNotEmpty()) View.GONE else View.VISIBLE
                movieAdapter.setData(movies)
            }

            with(fragmentMovieBinding.rvMovie){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    override fun onResume() {
        super.onResume()
        favoriteMovieViewModel.favMovies.observe(viewLifecycleOwner) { movies ->
            fragmentMovieBinding.viewEmpty.root.visibility =
                if (movies.isNotEmpty()) View.GONE else View.VISIBLE
            movieAdapter.setData(movies)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentMovieBinding = null
    }
}