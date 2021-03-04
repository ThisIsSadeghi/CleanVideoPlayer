package com.thisissadeghi.player.data.mapper.video

import com.thisissadeghi.player.data.mapper.base.ModelListMapper
import com.thisissadeghi.player.data.model.video.RemoteVideoModel
import com.thisissadeghi.player.domain.model.video.Video
import javax.inject.Inject

/**
 * Created by Ali Sadeghi
 * on 05,Mar,2021
 */
class RemoteVideoListToEntityMapper @Inject constructor(mapper: RemoteVideoModelToEntityMapper) :
    ModelListMapper<RemoteVideoModel, Video>(mapper)