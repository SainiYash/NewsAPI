package com.example.newsapi.domain.usecase.repoitory

import com.example.newsapi.data.model.Article

class SaveNewUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) =newsRepository.savedNews(article)
}