package com.thisissadeghi.player.data.source.video

import com.thisissadeghi.player.data.mapper.video.RemoteVideoListToEntityMapper
import com.thisissadeghi.player.data.mapper.video.RemoteVideoModelToEntityMapper
import com.thisissadeghi.player.data.remote.APIService
import com.thisissadeghi.player.domain.model.base.SuccessResult
import com.thisissadeghi.player.domain.model.base.UseCaseResult
import com.thisissadeghi.player.domain.model.video.Video
import javax.inject.Inject

/**
 * Created by Ali Sadeghi
 * on 05,Mar,2021
 */
class VideoRemoteDataSourceImpl @Inject constructor(
    private val apiService: APIService,
    private val remoteVideoModelToEntityMapper: RemoteVideoModelToEntityMapper,
    private val remoteVideoListToEntityMapper: RemoteVideoListToEntityMapper
) : VideoRemoteDataSource {
    override suspend fun getVideos(): UseCaseResult<List<Video>> {
        return SuccessResult(remoteVideoListToEntityMapper.map(apiService.getVideos()))
    }

    override suspend fun getVideoDetails(videoId: Int): UseCaseResult<Video> {
        return SuccessResult(remoteVideoModelToEntityMapper.map(apiService.getVideoDetail(videoId)))
    }
}