package com.grandtask.core.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.grandtask.utils.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Query("SELECT * FROM ArticleDB")
    fun getArticles():List<ArticleDB>

    @Insert
    fun insertAllArticles(article:List<ArticleDB>)
}