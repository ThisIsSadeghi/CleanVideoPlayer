package com.thisissadeghi.player.data.mapper.base

import com.thisissadeghi.player.data.model.base.Model
import com.thisissadeghi.player.domain.model.base.Entity
import javax.inject.Inject

/**
 * Created by Ali Sadeghi
 * on 04,Mar,2021
 */
class EntityListMapper<in I : Entity, out O : Model> @Inject constructor(
    private val mapper: EntityMapper<I, O>
) : ListMapper<I, O> {

    override fun map(input: List<I>): List<O> =
        input.map {
            mapper.map(it)
        }


}
