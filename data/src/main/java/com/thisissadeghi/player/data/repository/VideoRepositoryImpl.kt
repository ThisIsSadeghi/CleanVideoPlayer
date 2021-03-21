package com.thisissadeghi.player.data.repository

import com.thisissadeghi.player.data.source.video.VideoRemoteDataSource
import com.thisissadeghi.player.domain.model.base.UseCaseResult
import com.thisissadeghi.player.domain.model.video.Video
import com.thisissadeghi.player.domain.repository.VideoRepository
import javax.inject.Inject

/**
 * Created by Ali Sadeghi
 * on 05,Mar,2021
 */
class VideoRepositoryImpl @Inject constructor(private val videoRemoteDataSource: VideoRemoteDataSource) :
    VideoRepository, RepositoryCoroutineFriendly() {

    override suspend fun getVideos(): UseCaseResult<List<Video>> {
        return runCommand {
            videoRemoteDataSource.getVideos()
        }
    }

    override suspend fun getVideoDetails(videoId: Int): UseCaseResult<Video> {
        return runCommand {
            videoRemoteDataSource.getVideoDetails(videoId)
        }
    }
}