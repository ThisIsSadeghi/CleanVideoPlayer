package com.thisissadeghi.player.domain.model.base

sealed class UseCaseResult<out T: Any?>

class SuccessResult<out T: Any>(val data: T) : UseCaseResult<T>()
class ErrorResult(val error: ErrorEntity) : UseCaseResult<Nothing>()
