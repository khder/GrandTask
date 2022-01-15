package com.grandtask.core.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleDB(@PrimaryKey val id:Int, val title:String, val body:String, val image:String)