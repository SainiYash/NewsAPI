package com.example.newsapi.data.model.repository.dataSource.dataSourceImpl

import com.example.newsapi.data.model.APIResponse
import com.example.newsapi.data.model.Article
import com.example.newsapi.data.model.util.Resource
import com.example.newsapi.domain.usecase.repoitory.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newReportDataSource: NewReportDataSource
):NewsRepository {
    override suspend fun getNewsHeadline(country : String, page:Int): Resource<APIResponse> {
      return responseToSource(newReportDataSource.getHeadlines(country,page))
    }

    private fun responseToSource(response: Response<APIResponse>):Resource<APIResponse>
    {
        if(response.isSuccessful){
            response.body()?.let{result->
                return Resource.Success(result)

            }
        }
        return Resource.Error(response.message())
    }


    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun savedNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}