package com.example.newsapi.domain.usecase.repoitory

import androidx.lifecycle.LiveData
import com.example.newsapi.data.model.APIResponse
import com.example.newsapi.data.model.Article
import com.example.newsapi.data.model.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadline(country : String, page:Int): Resource<APIResponse>

    suspend fun getSearchedNews(searchQuery:String):Resource<APIResponse>

    suspend fun savedNews(article: Article)

    suspend fun deleteNews(article: Article)

    fun getSavedNews(): Flow<List<Article>>
}