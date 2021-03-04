package com.thisissadeghi.player.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.thisissadeghi.player.databinding.ItemVideoBinding
import com.thisissadeghi.player.domain.model.video.Video

/**
 * Created by Ali Sadeghi
 * on 04,Mar,2021
 */
class VideosAdapter(val listener: (Video) -> Unit) :
    ListAdapter<Video, VideosAdapter.VideoViewHolder>(TagDU()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            ItemVideoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class VideoViewHolder(private val mBinding: ItemVideoBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        fun bind(video: Video) {
            mBinding.txtTitle.text = video.title

            itemView.setOnClickListener {
                listener.invoke(video)
            }
        }

    }

    private class TagDU : DiffUtil.ItemCallback<Video>() {
        override fun areItemsTheSame(oldItem: Video, newItem: Video) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Video, newItem: Video) =
            oldItem == newItem
    }

    companion object {
        const val TAG = "TagAdapter"
    }
}