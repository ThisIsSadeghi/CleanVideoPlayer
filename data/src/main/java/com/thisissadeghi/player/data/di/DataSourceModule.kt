package com.thisissadeghi.player.data.di

import com.thisissadeghi.player.data.source.video.VideoRemoteDataSource
import com.thisissadeghi.player.data.source.video.VideoRemoteDataSourceImpl
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
abstract class DataSourceModule {

    @Binds
    abstract fun bindVideoRemoteDataSource(dataSource: VideoRemoteDataSourceImpl): VideoRemoteDataSource
}