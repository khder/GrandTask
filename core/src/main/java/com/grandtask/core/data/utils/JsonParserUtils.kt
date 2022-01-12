package com.grandtask.core.data.utils

import com.grandtask.core.data.models.Article
import org.json.JSONArray
import org.json.JSONObject

object JsonParserUtils {
    fun parseJson(json:String):List<Article>{
        val children:JSONArray = JSONObject(json)
            .getJSONObject("data").getJSONArray("children")
        val length :Int = children.length()
        val articles:ArrayList<Article> = ArrayList()
        (0 until length).forEach {
            val article :JSONObject = children.getJSONObject(it).getJSONObject("data")
            articles.add(Article(article.getString("title"),
            article.getString("selftext"),article.getString("thumbnail")))
        }
        return articles
    }
}