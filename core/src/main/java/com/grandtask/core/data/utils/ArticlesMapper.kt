package com.grandtask.core.data.utils

import com.grandtask.core.data.database.ArticleDB
import com.grandtask.utils.Article

object ArticlesMapper {
    fun mapToArticles(articlesDB:List<ArticleDB>):List<Article>{
        val size:Int = articlesDB.size
        val articles:ArrayList<Article> = ArrayList()
        var articleDB:ArticleDB
        (0 until size).forEach {
            articleDB = articlesDB[it]
            articles.add(Article(articleDB.title,articleDB.body,articleDB.image))
        }
        return articles
    }
    fun mapToArticlesDB(articles:List<Article>):List<ArticleDB>{
        val size:Int = articles.size
        val articlesDB:ArrayList<ArticleDB> = ArrayList()
        var article:Article
        (0 until size).forEach {
            article = articles[it]
            articlesDB.add(ArticleDB(it,article.title,article.body,article.thumbnailImage))
        }
        return articlesDB
    }
}