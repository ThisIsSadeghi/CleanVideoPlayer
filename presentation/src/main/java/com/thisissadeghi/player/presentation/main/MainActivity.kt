package com.thisissadeghi.player.presentation.main

import androidx.activity.viewModels
import com.thisissadeghi.player.databinding.ActivityMainBinding
import com.thisissadeghi.player.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    override val viewModel: MainViewModel by viewModels()

}