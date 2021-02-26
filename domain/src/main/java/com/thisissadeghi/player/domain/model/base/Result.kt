package com.thisissadeghi.player.domain.model.base

sealed class Result<out T: Any?>

class SuccessResult<out T: Any>(val data: T) : Result<T>()
class ErrorResult(val error: ErrorEntity) : Result<Nothing>()
