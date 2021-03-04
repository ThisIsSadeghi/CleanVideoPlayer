package com.thisissadeghi.player.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.thisissadeghi.player.databinding.FragmentHomeBinding
import com.thisissadeghi.player.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by viewModels()
    private val TAG = "HomeFragment"

    private val videosAdapter: VideosAdapter by lazy {
        VideosAdapter { video ->
            Log.d(TAG, video.toString())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            rvVideos.layoutManager = LinearLayoutManager(context)
            rvVideos.adapter = videosAdapter
        }

        viewModel.apply {
            getVideos()

            videos.observe(viewLifecycleOwner, { list ->
                videosAdapter.submitList(list)
            })
        }
    }
}