package com.thisissadeghi.player.data.model.video
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json
import com.thisissadeghi.player.data.model.base.RemoteModel


/**
 * Created by Ali Sadeghi
 * on 05,Mar,2021
 */

@JsonClass(generateAdapter = true)
data class RemoteVideoModel(
    @Json(name = "id")
    var id: Int? = null,
    @Json(name = "title")
    var title: String? = null,
    @Json(name = "url")
    var url: String? = null
) : RemoteModel
