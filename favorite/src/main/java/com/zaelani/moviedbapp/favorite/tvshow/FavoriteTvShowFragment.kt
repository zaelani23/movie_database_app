package com.zaelani.moviedbapp.favorite.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zaelani.moviedbapp.core.ui.TvShowAdapter
import com.zaelani.moviedbapp.databinding.FragmentTvShowBinding
import com.zaelani.moviedbapp.detail.tvshow.TvShowDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteTvShowFragment : Fragment() {

    private val favoriteTvShowViewModel: FavoriteTvShowViewModel by viewModel()
    private lateinit var tvShowAdapter: TvShowAdapter

    private var _fragmentTvShowBinding: FragmentTvShowBinding? = null
    private val fragmentTvShowBinding get() = _fragmentTvShowBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (activity != null) {
            tvShowAdapter = TvShowAdapter()
            tvShowAdapter.onItemClick = {selectedData ->
                val moveIntent = Intent(requireActivity(), TvShowDetailActivity::class.java)
                moveIntent.putExtra(TvShowDetailActivity.EXTRA_TV_SHOW_ID, selectedData.id)
                startActivity(moveIntent)
            }

            favoriteTvShowViewModel.favTvShows.observe(viewLifecycleOwner) { tvShows ->
                fragmentTvShowBinding.viewEmpty.root.visibility =
                    if (tvShows.isNotEmpty()) View.GONE else View.VISIBLE
                tvShowAdapter.setData(tvShows)
            }

            with(fragmentTvShowBinding.rvTvShow){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    override fun onResume() {
        super.onResume()
        favoriteTvShowViewModel.favTvShows.observe(viewLifecycleOwner) { tvShows ->
            fragmentTvShowBinding.viewEmpty.root.visibility =
                if (tvShows.isNotEmpty()) View.GONE else View.VISIBLE
            tvShowAdapter.setData(tvShows)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentTvShowBinding = null
    }
}