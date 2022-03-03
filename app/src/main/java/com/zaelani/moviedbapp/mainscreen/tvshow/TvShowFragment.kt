package com.zaelani.moviedbapp.mainscreen.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zaelani.moviedbapp.R
import com.zaelani.moviedbapp.core.data.Resource
import com.zaelani.moviedbapp.core.ui.TvShowAdapter
import com.zaelani.moviedbapp.databinding.FragmentTvShowBinding
import com.zaelani.moviedbapp.detail.tvshow.TvShowDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class TvShowFragment : Fragment() {

    private val tvShowViewModel: TvShowViewModel by viewModel()

    private var _fragmentTvShowBinding: FragmentTvShowBinding? = null
    val fragmentTvShowBinding get() = _fragmentTvShowBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (activity != null) {
            val tvShowAdapter = TvShowAdapter()
            tvShowAdapter.onItemClick = {selectedData ->
                val moveIntent = Intent(requireActivity(), TvShowDetailActivity::class.java)
                moveIntent.putExtra(TvShowDetailActivity.EXTRA_TV_SHOW_ID, selectedData.id)
                startActivity(moveIntent)
            }

            tvShowViewModel.tvShows.observe(viewLifecycleOwner) { tvShows ->
                if (tvShows != null) {
                    when (tvShows) {
                        is com.zaelani.moviedbapp.core.data.Resource.Loading -> showProgressBar(true)
                        is com.zaelani.moviedbapp.core.data.Resource.Success -> {
                            showProgressBar(false)
                            tvShowAdapter.setData(tvShows.data)
                            tvShowAdapter.notifyDataSetChanged()
                        }
                        is com.zaelani.moviedbapp.core.data.Resource.Error -> {
                            showProgressBar(false)
                            fragmentTvShowBinding.viewError.root.visibility = View.VISIBLE
                            fragmentTvShowBinding.viewError.tvError.text =
                                tvShows.message ?: getString(R.string.str_something_wrong)
                        }
                    }
                }
            }

            with(fragmentTvShowBinding.rvTvShow){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentTvShowBinding = null
    }

    private fun showProgressBar(state: Boolean) {
        fragmentTvShowBinding.progressBar.visibility = if (state) View.VISIBLE else View.GONE
    }
}