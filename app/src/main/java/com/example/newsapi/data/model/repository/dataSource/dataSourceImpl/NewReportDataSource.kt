package com.example.newsapi.data.model.repository.dataSource.dataSourceImpl

import com.example.newsapi.data.model.APIResponse
import retrofit2.Response

interface NewReportDataSource {

    suspend fun getHeadlines(country : String, page:Int):Response<APIResponse>
}