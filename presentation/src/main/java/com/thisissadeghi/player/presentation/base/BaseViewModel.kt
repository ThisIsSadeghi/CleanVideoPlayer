package com.thisissadeghi.player.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thisissadeghi.player.domain.model.base.ErrorEntity
import com.thisissadeghi.player.presentation.util.SingleEvent

/**
 * Created by Ali Sadeghi
 * on 04,Mar,2021
 */
open class BaseViewModel : ViewModel() {
    val showProgress = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<SingleEvent<String>>()

    fun showProgressbar() {
        showProgress.value = true
    }

    fun hideProgressbar() {
        showProgress.value = false
    }

    fun showErrorMessage(error: ErrorEntity) {
        hideProgressbar()
        errorMessage.value = SingleEvent(error.errorMessage)
    }
}