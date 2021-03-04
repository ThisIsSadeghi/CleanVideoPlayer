package com.thisissadeghi.player.domain.model.video

import com.thisissadeghi.player.domain.model.base.Entity

/**
 * Created by Ali Sadeghi
 * on 05,Mar,2021
 */
data class Video(
    val id: Int,
    val title: String,
    val url: String
) : Entity
