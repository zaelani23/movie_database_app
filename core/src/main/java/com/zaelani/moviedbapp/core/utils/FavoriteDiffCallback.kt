package com.zaelani.moviedbapp.core.utils

import androidx.recyclerview.widget.DiffUtil
import com.zaelani.moviedbapp.core.domain.model.Movie

class FavoriteDiffCallback(private val mOldFavoriteList: List<Movie>, private val mNewFavoriteList: List<Movie>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldFavoriteList.size
    }

    override fun getNewListSize(): Int {
        return mNewFavoriteList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldFavoriteList[oldItemPosition].id == mNewFavoriteList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldUser = mOldFavoriteList[oldItemPosition]
        val newUser = mOldFavoriteList[newItemPosition]
        return oldUser.id == newUser.id && oldUser.id == newUser.id
    }
}