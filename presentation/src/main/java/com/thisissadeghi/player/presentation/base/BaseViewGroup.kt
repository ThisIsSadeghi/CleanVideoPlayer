package com.thisissadeghi.player.presentation.base

import androidx.viewbinding.ViewBinding


/**
 * Created by Ali Sadeghi
 * on 04,Mar,2021
 */
interface BaseViewGroup<V : BaseViewModel, B : ViewBinding?> {
    val viewModel: V

    var binding: B
}