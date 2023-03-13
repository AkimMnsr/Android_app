package com.example.kdo.dao

import com.example.kdo.bo.Article

interface ArticleDAO {

    fun selectById(id:Long): Article?
    fun getAll(): List<Article>
    fun deleteById(id:Long)
    fun deleteAll()
    fun insert (art: Article) : Article

}