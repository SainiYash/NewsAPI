package com.example.newsapi.domain.usecase.repoitory

import com.example.newsapi.data.model.APIResponse
import com.example.newsapi.data.model.util.Resource

class GetSearchedUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery:String): Resource<APIResponse>
    {
        return newsRepository.getSearchedNews(searchQuery)
    }
}