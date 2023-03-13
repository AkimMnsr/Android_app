package com.example.kdo.repository

import com.example.kdo.bo.Article
import com.example.kdo.dao.DAOFactory
import com.example.kdo.dao.DAOType

object ArticleRepository {

    private var articleDao = DAOFactory().getDAO(DAOType.MEMORY)

    fun getArticle(id: Long): Article? =
         articleDao.selectById(id)

    fun getAll () : List<Article> =
        articleDao.getAll()

    fun deleteAll () =
        articleDao.deleteAll()

    fun deleteArticle (id:Long) {
        articleDao.deleteById(id)
    }

}