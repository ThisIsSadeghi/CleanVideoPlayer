package com.thisissadeghi.player.data.remote

import com.thisissadeghi.player.data.model.video.RemoteVideoModel
import retrofit2.http.GET

/**
 * Created by Ali Sadeghi
 * on 26,Feb,2021
 */
interface APIService {

    @GET("contents")
    suspend fun getVideos(): List<RemoteVideoModel>
}