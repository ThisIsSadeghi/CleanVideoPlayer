package com.thisissadeghi.player.domain.model.base

/**
 * The base class for storing errors.
 *
 * @constructor Create empty Error entity
 */
data class ErrorEntity(
        val originalError: Throwable? = null,
        val errorCode: Int = 0,
        val errorMessage: String = ""
)
