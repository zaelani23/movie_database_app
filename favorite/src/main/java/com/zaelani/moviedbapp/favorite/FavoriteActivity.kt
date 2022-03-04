package com.zaelani.moviedbapp.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zaelani.moviedbapp.databinding.ActivityFavoriteBinding
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private var _activityFavoriteBinding: ActivityFavoriteBinding? = null
    private val activityFavoriteBinding get() = _activityFavoriteBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)
        loadKoinModules(viewModelModule)
        supportActionBar?.title = getString(R.string.title_favorite)
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
        unloadKoinModules(viewModelModule)
        _activityFavoriteBinding = null
    }
}