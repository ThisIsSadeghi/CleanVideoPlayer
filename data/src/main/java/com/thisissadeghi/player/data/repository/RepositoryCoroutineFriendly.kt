package com.thisissadeghi.player.data.repository

import com.thisissadeghi.player.data.ErrorHandler
import com.thisissadeghi.player.domain.model.base.ErrorEntity
import com.thisissadeghi.player.domain.model.base.ErrorResult
import com.thisissadeghi.player.domain.model.base.Result
import kotlinx.coroutines.*

open class RepositoryCoroutineFriendly {

    private val coroutineContext = Dispatchers.IO + SupervisorJob()


    suspend fun <T> runCommand(func: suspend () -> Result<T>): Result<T> {
        var result: Result<T> = ErrorResult(ErrorEntity())

        CoroutineExceptionHandler { _ , throwable ->
            result = ErrorHandler().handleException(throwable)
        }.let { exceptionHandler ->
            CoroutineScope(coroutineContext).launch(exceptionHandler) {
                result = func.invoke()
            }
        }
        return result
    }
}
