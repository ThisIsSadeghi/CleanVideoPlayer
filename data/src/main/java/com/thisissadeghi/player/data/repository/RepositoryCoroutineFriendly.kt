package com.thisissadeghi.player.data.repository

import com.thisissadeghi.player.data.ErrorHandler
import com.thisissadeghi.player.domain.model.base.UseCaseResult
import kotlinx.coroutines.*

open class RepositoryCoroutineFriendly {

    suspend fun <T> runCommand(func: suspend () -> UseCaseResult<T>): UseCaseResult<T> {

        return supervisorScope {
            return@supervisorScope try {
                func.invoke()
            } catch (exception : Exception) {
                ErrorHandler().handleException(exception)
            }
        }

    }
}