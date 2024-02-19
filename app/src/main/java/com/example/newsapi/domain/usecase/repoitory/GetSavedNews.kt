package com.example.newsapi.domain.usecase.repoitory

import com.example.newsapi.data.model.Article
import kotlinx.coroutines.flow.Flow

class GetSavedNews(private val newsRepository: NewsRepository) {

     fun execute(): Flow<List<Article>>{
         return newsRepository.getSavedNews()
     }
}