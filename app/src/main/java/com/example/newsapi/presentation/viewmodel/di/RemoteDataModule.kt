package com.example.newsapi.presentation.viewmodel.di

import com.example.newsapi.data.model.api.NewsAPIServices
import com.example.newsapi.data.model.repository.dataSource.dataSourceImpl.NewsReportDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsAPIServices: NewsAPIServices)
    : NewsReportDataSourceImpl{
        return NewsReportDataSourceImpl(newsAPIServices)
    }


}