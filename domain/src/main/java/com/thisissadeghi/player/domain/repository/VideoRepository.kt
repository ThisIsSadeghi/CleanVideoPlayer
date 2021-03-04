package com.thisissadeghi.player.domain.repository

import com.thisissadeghi.player.domain.model.base.UseCaseResult
import com.thisissadeghi.player.domain.model.video.Video

/**
 * Created by Ali Sadeghi
 * on 05,Mar,2021
 */
interface VideoRepository {

    suspend fun getVideos(): UseCaseResult<List<Video>>
    
}