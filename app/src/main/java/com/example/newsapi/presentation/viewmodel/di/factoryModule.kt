package com.example.newsapi.presentation.viewmodel.di

import android.app.Application
import com.example.newsapi.domain.usecase.repoitory.GetNewsHeadlineUseCase
import com.example.newsapi.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class factoryModule {
@Singleton
    @Provides
    fun provideNewsModleFactory(
        application: Application,
        getNewsHeadlineUseCase: GetNewsHeadlineUseCase
    ):NewsViewModelFactory
    {
        return NewsViewModelFactory(application,getNewsHeadlineUseCase)
    }
}