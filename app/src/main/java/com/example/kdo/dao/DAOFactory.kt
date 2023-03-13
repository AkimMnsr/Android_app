package com.example.kdo.dao

import com.example.kdo.dao.memory.ArticleDAOMemoryImpl

class DAOFactory {

    fun getDAO (type: DAOType): ArticleDAO {
        return when (type){
            DAOType.MEMORY->ArticleDAOMemoryImpl()
            DAOType.INTERNET->ArticleDAOMemoryImpl()
            DAOType.DB->ArticleDAOMemoryImpl()
        }
    }



}