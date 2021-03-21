package com.thisissadeghi.player.data.remote

import com.thisissadeghi.player.data.model.video.RemoteVideoModel
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Ali Sadeghi
 * on 26,Feb,2021
 */
interface APIService {

    @GET("contents")
    suspend fun getVideos(): List<RemoteVideoModel>

    @GET("contents/{videoId}")
    suspend fun getVideoDetail(@Path("videoId") videoId: Int): RemoteVideoModel
}