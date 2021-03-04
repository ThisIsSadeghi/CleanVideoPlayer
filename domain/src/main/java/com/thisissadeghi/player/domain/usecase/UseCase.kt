package com.thisissadeghi.player.domain.usecase


/**
 * The base UseCase class
 * Every UseCases must be inherited from this class.
 *
 * @param param The input which is consumed in this class
 * @param T The return value which is produced from this class
 * @constructor There is no need to pass eny parameter to the constructor
 */
interface UseCase<in param, out T : Any> {

    /**
     * The primary function which must be implemented in every UseCases and execute in ViewModels
     *
     * @param param The input of the useCase
     * @return T The result of the useCase
     */
    suspend fun invoke(param: param? = null): T

}
