package com.zaelani.moviedbapp.core.utils

import androidx.recyclerview.widget.DiffUtil

class FavoriteDiffCallback<T>(
    private val mOldFavoriteList: List<T>,
    private val mNewFavoriteList: List<T>
    ) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldFavoriteList.size
    }

    override fun getNewListSize(): Int {
        return mNewFavoriteList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldFav = mOldFavoriteList[oldItemPosition]
        val newFav = mNewFavoriteList[newItemPosition]
        return oldFav?.equals(newFav) ?: false
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldData = mOldFavoriteList[oldItemPosition]
        val newData = mOldFavoriteList[newItemPosition]
        return oldData?.equals(newData) ?: false
    }
}