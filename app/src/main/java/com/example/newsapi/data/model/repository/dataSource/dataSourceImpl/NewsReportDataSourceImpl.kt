package com.example.newsapi.data.model.repository.dataSource.dataSourceImpl

import com.example.newsapi.data.model.APIResponse
import com.example.newsapi.data.model.api.NewsAPIServices
import retrofit2.Response

class NewsReportDataSourceImpl(
    private val newsAPIServices: NewsAPIServices,

):NewReportDataSource {
    override suspend fun getHeadlines(country : String, page:Int): Response<APIResponse> {
          return newsAPIServices.getHeadlines(country, page)
    }


}