package com.thisissadeghi.player.data.mapper.base

/**
 * Created by Ali Sadeghi
 * on 04,Mar,2021
 */
interface Mapper<in I, out O> {
    fun map(input: I): O
}
