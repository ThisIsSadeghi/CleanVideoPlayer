package com.thisissadeghi.player.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.thisissadeghi.player.domain.model.base.doOnError
import com.thisissadeghi.player.domain.model.base.doOnSuccess
import com.thisissadeghi.player.domain.model.video.Video
import com.thisissadeghi.player.domain.usecase.video.GetVideoDetailsUseCase
import com.thisissadeghi.player.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Ali Sadeghi
 * on 05,Mar,2021
 */
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getVideoDetailsUseCase: GetVideoDetailsUseCase
) : BaseViewModel() {

    private val _videoDetail = MutableLiveData<Video>()
    val videoDetail: LiveData<Video>
        get() = _videoDetail

    fun getVideoDetails(videoId: Int) {
        showProgressbar()

        viewModelScope.launch {
            getVideoDetailsUseCase.invoke(videoId)
                .doOnSuccess { result ->
                    _videoDetail.value = result
                    hideProgressbar()
                }
                .doOnError { error ->
                    showErrorMessage(error)
                    hideProgressbar()
                }
        }

    }
}