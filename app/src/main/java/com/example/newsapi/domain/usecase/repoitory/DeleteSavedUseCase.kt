package com.example.newsapi.domain.usecase.repoitory

import com.example.newsapi.data.model.Article

class DeleteSavedUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) =newsRepository.deleteNews(article)
}