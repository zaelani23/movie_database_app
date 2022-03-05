package com.zaelani.moviedbapp.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zaelani.moviedbapp.core.R
import com.zaelani.moviedbapp.core.databinding.ItemsTvShowBinding
import com.zaelani.moviedbapp.core.domain.model.TvShow
import com.zaelani.moviedbapp.core.utils.FavoriteDiffCallback
import com.zaelani.moviedbapp.core.utils.NetworkInfo.IMAGE_URL

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.ListViewHolder>() {

    private var listData = ArrayList<TvShow>()
    var onItemClick: ((TvShow) -> Unit)? = null

    fun setData(newListData: List<TvShow>?) {
        if (newListData == null) return
        val diffCallback = FavoriteDiffCallback(this.listData, newListData)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listData.clear()
        this.listData.addAll(newListData)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowAdapter.ListViewHolder =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_tv_show, parent, false))

    override fun onBindViewHolder(holder: TvShowAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemsTvShowBinding.bind(itemView)
        fun bind(data: TvShow){
            with(binding){
                tvItemName.text = data.name
                tvItemRelease.text = itemView.resources.getString(R.string.str_release, data.firstAirDate)
                tvItemScore.text = itemView.resources.getString(
                    R.string.str_user_score,
                    data.voteAverage.toString()
                )
                Glide.with(itemView.context)
                    .load(IMAGE_URL + data.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}