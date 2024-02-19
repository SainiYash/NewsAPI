package com.example.newsapi.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapi.domain.usecase.repoitory.GetNewsHeadlineUseCase

class NewsViewModelFactory(
    private val app: Application,
    private val getHeadlineUseCase: GetNewsHeadlineUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
                app,
                getHeadlineUseCase
                ) as T
    }
}