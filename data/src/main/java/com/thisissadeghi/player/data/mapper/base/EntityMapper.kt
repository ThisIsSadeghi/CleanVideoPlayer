package com.thisissadeghi.player.data.mapper.base

import com.thisissadeghi.player.data.model.base.Model
import com.thisissadeghi.player.domain.model.base.Entity
/**
 * Created by Ali Sadeghi
 * on 04,Mar,2021
 */
interface EntityMapper<in I: Entity, out O: Model>: Mapper<I, O>
