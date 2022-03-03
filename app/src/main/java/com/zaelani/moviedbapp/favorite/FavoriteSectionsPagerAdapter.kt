package com.zaelani.moviedbapp.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.zaelani.moviedbapp.R
import com.zaelani.moviedbapp.favorite.movie.FavoriteMovieFragment
import com.zaelani.moviedbapp.favorite.tvshow.FavoriteTvShowFragment

class FavoriteSectionsPagerAdapter(private val mContext: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavoriteMovieFragment()
            1 -> FavoriteTvShowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.str_movies, R.string.str_tv_show)
    }}