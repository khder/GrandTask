package com.grandtask.core.data.repositories

import android.content.Context
import android.util.Log
import com.grandtask.core.data.database.ArticleDao
import com.grandtask.core.data.network.ApiHelper
import com.grandtask.core.data.utils.ArticlesMapper
import com.grandtask.core.data.utils.JsonParserUtils
import com.grandtask.utils.Article
import com.grandtask.utils.Resource
import kotlinx.coroutines.flow.onEach
import okhttp3.ResponseBody
import retrofit2.Response
import android.net.NetworkInfo

import androidx.core.content.ContextCompat.getSystemService

import android.net.ConnectivityManager
import androidx.core.content.ContextCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


class RedditNewsRepository(private val apiHelper:ApiHelper,
                           private val articleDao: ArticleDao,
                           private val appContext: Context) {
      fun getArticles():Resource<List<Article>>{
        var resource:Resource<List<Article>> = getArticlesFromDB()
         if(resource.data?.isEmpty() == true){
            if(appContext.isNetworkConnected()){
                resource = getArticlesFromNetwork()
                resource.data?.let {
                    cashArticles(it)
                }
            }else{
                resource = Resource.error(null,"Please,Check Network Connection")
            }
         }
         return resource
     }

    private fun cashArticles(articles:List<Article>){
        articleDao.insertAllArticles(ArticlesMapper.mapToArticlesDB(articles))
    }

    private fun getArticlesFromNetwork():Resource<List<Article>>{
        val response: Response<String>
        try {
            response = apiHelper.getArticles().execute()
        } catch (t: Throwable) {
            return Resource.error(null,t.message!!)
        }

        if (!response.isSuccessful) {
            return Resource.error(null,"Error Happened")
        } else {
            if (response.body() == null) {
                return Resource.error(null,"Error Happened")
            }
        }
        return Resource.success(JsonParserUtils.parseJson(response.body().toString()?:""))
    }

    private fun getArticlesFromDB():Resource<List<Article>>{
        var resource:Resource<List<Article>>?=null
            articleDao.getArticles().let {
                resource = Resource.success(ArticlesMapper.mapToArticles(it))
            }
        return resource?: Resource.error(null,"Error")
    }
}

private fun Context.isNetworkConnected(): Boolean {
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    val activeNetworkInfo = connectivityManager!!.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}
