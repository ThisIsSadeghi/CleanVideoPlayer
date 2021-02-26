package com.thisissadeghi.player.data

import com.thisissadeghi.player.domain.model.base.ErrorEntity
import com.thisissadeghi.player.domain.model.base.ErrorResult

class ErrorHandler {

    fun handleException(throwable: Throwable) : ErrorResult {
        return ErrorResult(ErrorEntity(throwable))
    }

}
