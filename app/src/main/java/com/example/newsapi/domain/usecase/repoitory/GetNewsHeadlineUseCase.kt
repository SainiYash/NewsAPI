package com.example.newsapi.domain.usecase.repoitory

import com.example.newsapi.data.model.APIResponse
import com.example.newsapi.data.model.util.Resource

class GetNewsHeadlineUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country : String, page:Int): Resource<APIResponse>{
        return newsRepository.getNewsHeadline(country, page)
    }
}