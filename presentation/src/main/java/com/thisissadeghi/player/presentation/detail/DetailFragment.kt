package com.thisissadeghi.player.presentation.detail

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.ImageButton
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.thisissadeghi.player.R
import com.thisissadeghi.player.databinding.FragmentDetailBinding
import com.thisissadeghi.player.presentation.base.BaseFragment
import com.thisissadeghi.player.presentation.util.ext.dp
import com.thisissadeghi.player.presentation.util.ext.makeGone
import com.thisissadeghi.player.presentation.util.ext.makeVisible
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
        val isPortrait =
            activity?.resources?.configuration?.orientation == Configuration.ORIENTATION_PORTRAIT

        if (isPortrait) {
            hideSystemUI()

            activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

            binding?.player?.let { player ->
                player.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
                player.layoutParams.apply {
                    height = ViewGroup.LayoutParams.MATCH_PARENT
                    width = ViewGroup.LayoutParams.MATCH_PARENT
                }.also {
                    player.layoutParams = it
                }

            }
        } else {
            showSystemUI()

            activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

            binding?.player?.let { player ->
                player.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
                player.layoutParams.apply {
                    height = 200.dp()
                    width = ViewGroup.LayoutParams.MATCH_PARENT
                }.also {
                    player.layoutParams = it
                }

            }
        }
    }

    private fun hideSystemUI() {

        requireActivity().window?.let { window ->

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.setDecorFitsSystemWindows(false)
                window.insetsController?.let { insetsController ->
                    insetsController.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                    insetsController.systemBarsBehavior =
                        WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                }
            } else {
                @Suppress("DEPRECATION")
                window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
            }
        }
    }

    private fun showSystemUI() {
        requireActivity().window?.let { window ->

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.setDecorFitsSystemWindows(true)
                window.insetsController?.show(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
            } else {
                @Suppress("DEPRECATION")
                requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
            }
        }
    }
}