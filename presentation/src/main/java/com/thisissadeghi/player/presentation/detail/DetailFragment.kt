package com.thisissadeghi.player.presentation.detail

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.sadeghirad.androidcore.ext.*
import com.thisissadeghi.player.R
import com.thisissadeghi.player.databinding.FragmentDetailBinding
import com.thisissadeghi.player.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Ali Sadeghi
 * on 05,Mar,2021
 */
@AndroidEntryPoint
class DetailFragment : BaseFragment<DetailViewModel, FragmentDetailBinding>() {
    override val viewModel: DetailViewModel by viewModels()

    val args: DetailFragmentArgs by navArgs()
    private var localPlayer: SimpleExoPlayer? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            getVideoDetails(args.videoId)

            videoDetail.observe(viewLifecycleOwner, { detail ->
                binding?.tvTitle?.text = detail.title

                initPlayer(detail.url)
            })
        }

        binding?.player?.findViewById<ImageButton>(R.id.exo_fullscreen)?.setOnClickListener {
            handleFullScreenClicked()
        }
    }

    override fun onStop() {
        super.onStop()
        localPlayer?.playWhenReady = false
    }

    override fun onResume() {
        super.onResume()
        localPlayer?.playWhenReady = true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        localPlayer?.apply {
            playWhenReady = false
            release()
        }
    }

    private fun initPlayer(url: String) {
        context ?: return
        SimpleExoPlayer.Builder(requireContext()).build().also {
            localPlayer = it
            binding?.player?.player = localPlayer

            localPlayer?.setMediaItem(
                MediaItem
                    .Builder()
                    .setUri(url)
                    .build()
            )
            localPlayer?.prepare()
            localPlayer?.play()
            localPlayer?.addListener(object : Player.EventListener {

                override fun onPlaybackStateChanged(state: Int) {
                    super.onPlaybackStateChanged(state)
                    when (state) {
                        Player.STATE_BUFFERING -> {
                            binding?.prg?.makeVisible()
                        }
                        else -> {
                            binding?.prg?.makeGone()
                        }
                    }
                }

                override fun onPlayerError(error: ExoPlaybackException) {
                    super.onPlayerError(error)
                    showMessage(error.message ?: getString(R.string.unknown_error))
                }
            })
        }
    }

    private fun handleFullScreenClicked() {
        if (isPortrait()) {
            hideSystemUI()
            rotateScreenToLandscape()

            binding?.player?.let { player ->
                player.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
                player.makeHeightAndWidthMatchParent()
            }
        } else {
            showSystemUI()
            rotateScreenToPortrait()

            binding?.player?.let { player ->
                player.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
                player.setHeightDP(200)
            }
        }
    }

}