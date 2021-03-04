package com.thisissadeghi.player.data.di

import com.thisissadeghi.player.data.repository.VideoRepositoryImpl
import com.thisissadeghi.player.domain.repository.VideoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Ali Sadeghi
 * on 26,Feb,2021
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindVideoRepository(repository: VideoRepositoryImpl): VideoRepository

}