package com.example.newsapi.presentation.viewmodel.di

import com.example.newsapi.data.model.repository.dataSource.dataSourceImpl.NewsReportDataSourceImpl
import com.example.newsapi.data.model.repository.dataSource.dataSourceImpl.NewsRepositoryImpl
import com.example.newsapi.domain.usecase.repoitory.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Singleton
@Provides

    fun provideNewsRepository(newsReportDataSourceImpl: NewsReportDataSourceImpl):NewsRepository
    {
          return NewsRepositoryImpl(newsReportDataSourceImpl)
    }
}