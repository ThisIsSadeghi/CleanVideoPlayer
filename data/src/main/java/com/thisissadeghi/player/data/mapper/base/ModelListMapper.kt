package com.thisissadeghi.player.data.mapper.base

import com.thisissadeghi.player.data.model.base.Model
import com.thisissadeghi.player.domain.model.base.Entity
import javax.inject.Inject

/**
 * Created by Ali Sadeghi
 * on 04,Mar,2021
 */
open class ModelListMapper<in I : Model, out O : Entity> @Inject constructor(
    private val mapper: ModelMapper<I, O>
) : ListMapper<I, O> {

    override fun map(input: List<I>): List<O> =
        input.map {
            mapper.map(it)
        }

}
