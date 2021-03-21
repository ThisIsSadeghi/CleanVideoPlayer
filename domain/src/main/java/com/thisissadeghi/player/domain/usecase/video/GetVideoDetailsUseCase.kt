package com.thisissadeghi.player.domain.usecase.video

import com.thisissadeghi.player.domain.model.base.UseCaseResult
import com.thisissadeghi.player.domain.model.video.Video
import com.thisissadeghi.player.domain.repository.VideoRepository
import com.thisissadeghi.player.domain.usecase.UseCase
import javax.inject.Inject

/**
 * Created by Ali Sadeghi
 * on 15,Mar,2021
 */
class GetVideoDetailsUseCase @Inject constructor(
    private val videoRepository: VideoRepository
) : UseCase<Int, UseCaseResult<Video>> {
    override suspend fun invoke(param: Int?): UseCaseResult<Video> {
        return videoRepository.getVideoDetails(param ?: 0)
    }
}