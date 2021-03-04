package com.thisissadeghi.player.domain.model.base


/**
 * Created by Ali Sadeghi
 * on 27,Feb,2021
 */

inline fun <T, R> UseCaseResult<T>.doOnSuccess(func: (result: T) -> R): UseCaseResult<T> {
    if (this is SuccessResult) {
        func.invoke(data)
    }
    return this
}


fun <T, R> UseCaseResult<T>.doOnError(func: (error: ErrorEntity) -> R): UseCaseResult<T> {
    if (this is ErrorResult) {
        func.invoke(error)
    }
    return this
}