package com.example.newsapi.presentation.viewmodel.di

import com.example.newsapi.domain.usecase.repoitory.GetNewsHeadlineUseCase
import com.example.newsapi.domain.usecase.repoitory.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Singleton
@Provides
    fun provideGetNewsheadlinesUseCase(newsRepository: NewsRepository):GetNewsHeadlineUseCase
    {
           return GetNewsHeadlineUseCase(newsRepository)
    }

}