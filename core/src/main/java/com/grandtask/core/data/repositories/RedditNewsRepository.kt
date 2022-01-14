package com.grandtask.core.data.repositories

import android.util.Log
import com.grandtask.core.data.network.ApiHelper
import com.grandtask.core.data.utils.JsonParserUtils
import com.grandtask.utils.Article
import com.grandtask.utils.Resource
import okhttp3.ResponseBody
import retrofit2.Response

class RedditNewsRepository(private val apiHelper:ApiHelper) {
     fun getArticles():Resource<List<Article>>{
        val response: Response<String>
        try {
            response = apiHelper.getArticles().execute()
        } catch (t: Throwable) {
            return Resource.error(null,t.message!!)
        }

//        if (!response.isSuccessful) {
//            return Resource.error(null,"Error Happened")
//        } else {
//            if (response.body() == null) {
//                return Resource.error(null,"Error Happened")
//            }
//        }
        return Resource.success(JsonParserUtils.parseJson(response.body().toString()?:""))
    }
}