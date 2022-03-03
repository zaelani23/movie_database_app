package com.zaelani.moviedbapp.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zaelani.moviedbapp.R
import com.zaelani.moviedbapp.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private var _activityFavoriteBinding: ActivityFavoriteBinding? = null
    val activityFavoriteBinding get() = _activityFavoriteBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)
        supportActionBar?.title = "Favorite"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val sectionsPagerAdapter = FavoriteSectionsPagerAdapter(this, supportFragmentManager)
        activityFavoriteBinding.favViewPager.adapter = sectionsPagerAdapter
        activityFavoriteBinding.favTabs.setupWithViewPager(activityFavoriteBinding.favViewPager)
        supportActionBar?.elevation = 0f
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _activityFavoriteBinding = null
    }
}