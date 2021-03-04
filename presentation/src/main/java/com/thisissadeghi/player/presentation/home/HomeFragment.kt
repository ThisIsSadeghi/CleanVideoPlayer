package com.thisissadeghi.player.presentation.home

import androidx.fragment.app.viewModels
import com.thisissadeghi.player.databinding.FragmentHomeBinding
import com.thisissadeghi.player.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by viewModels()

}