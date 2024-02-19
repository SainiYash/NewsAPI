package com.example.newsapi.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapi.data.model.APIResponse
import com.example.newsapi.data.model.util.Resource
import com.example.newsapi.domain.usecase.repoitory.GetNewsHeadlineUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    private val app: Application,
    private val getHeadlineUseCase: GetNewsHeadlineUseCase
): AndroidViewModel(app) {
    val newsHeadLine : MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadLine(country:String,page:Int) = viewModelScope.launch(Dispatchers.IO) {

        newsHeadLine.postValue(Resource.Loading())
        try{
            if(isNetworkAvailable(app)) {
                val apiResult = getHeadlineUseCase.execute(country, page)
                newsHeadLine.postValue(apiResult)
            }else{
                    newsHeadLine.postValue(Resource.Error("Internet is not available"))
                }

            }catch (e:Exception){
                newsHeadLine.postValue(Resource.Error(e.message.toString()))
            }

    }

    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }


}


