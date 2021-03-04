package com.thisissadeghi.player.domain.usecase.video

import com.thisissadeghi.player.domain.model.base.UseCaseResult
import com.thisissadeghi.player.domain.model.video.Video
import com.thisissadeghi.player.domain.repository.VideoRepository
import com.thisissadeghi.player.domain.usecase.UseCase
import javax.inject.Inject

/**
 * Created by Ali Sadeghi
 * on 05,Mar,2021
 */
class GetVideosUseCase @Inject constructor(
    private val videoRepository: VideoRepository
) : UseCase<Unit, UseCaseResult<List<Video>>> {
    override suspend fun invoke(param: Unit?): UseCaseResult<List<Video>> {
        return videoRepository.getVideos()
    }
}