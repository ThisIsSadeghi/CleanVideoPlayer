package com.thisissadeghi.player.data.mapper.video

import com.thisissadeghi.player.data.mapper.base.ModelMapper
import com.thisissadeghi.player.data.model.video.RemoteVideoModel
import com.thisissadeghi.player.domain.model.video.Video
import javax.inject.Inject

/**
 * Created by Ali Sadeghi
 * on 05,Mar,2021
 */
class RemoteVideoModelToEntityMapper @Inject constructor() : ModelMapper<RemoteVideoModel, Video> {

    override fun map(input: RemoteVideoModel): Video {
        return Video(
            input.id ?: -1,
            input.title ?: "",
            input.url ?: ""
        )
    }
}