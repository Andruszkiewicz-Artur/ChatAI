package com.example.chatai.di

import android.app.Application
import com.example.chatai.data.remote.OpenAiApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideChatAiApi(app: Application): OpenAiApi {
        return Retrofit.Builder()
            .baseUrl("https://api.openai.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

}