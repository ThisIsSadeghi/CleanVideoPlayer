package com.thisissadeghi.player.data.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.thisissadeghi.player.data.BuildConfig
import com.thisissadeghi.player.data.remote.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Ali Sadeghi
 * on 26,Feb,2021
 */

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val TIME_OUT = 60L
    private val BASE_URL = "https://my-json-server.typicode.com/ThisIsSadeghi/CleanVideoPlayer/"

    @Provides
    @Singleton
    fun providesRetrofit(
        moshiConverterFactory: MoshiConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(moshiConverterFactory)
            .client(okHttpClient)
            .build()
    }


    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        if (BuildConfig.DEBUG)
            client.addNetworkInterceptor(interceptor)

        return client.build()
    }

    @Provides
    fun providesMoshiConverterFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create(
            Moshi.Builder().add(Date::class.java, Rfc3339DateJsonAdapter()).build()
        )

    }

    @Provides
    fun provideService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }
}