package com.ycengine.post.repository.database

import com.ycengine.post.data.dto.ColorModel
import com.ycengine.post.data.dto.HashPopKeywordModel
import com.ycengine.post.data.dto.MusPopKeywordModel
import com.ycengine.post.data.dto.PostPopKeywordModel

class DatabaseRepository {
    private val postDao = PostDatabase.getInstance().getPostDao()

    fun clearPostData() {
        PostDatabase.getInstance().runInTransaction {
            postDao.deletePostColor()
            postDao.deleteHashPopKeyword()
            postDao.deletePostPopKeyword()
            postDao.deleteMusPopKeyword()
        }
    }

    // tblColor
    fun insertColors(colors: List<ColorModel>) {
        postDao.insertColors(colors)
    }

    fun getPostColor() : List<ColorModel> {
        return postDao.getPostColor()
    }

    // tblHashPopKeyword
    fun insertHashPopKeyword(keywords: List<HashPopKeywordModel>) {
        postDao.insertHashPopKeyword(keywords)
    }

    fun getHashPopKeyword() : List<HashPopKeywordModel> {
        return postDao.getHashPopKeyword()
    }

    // tblPostPopKeyword
    fun insertPostPopKeyword(keywords: List<PostPopKeywordModel>) {
        postDao.insertPostPopKeyword(keywords)
    }

    fun getPostPopKeyword() : List<PostPopKeywordModel> {
        return postDao.getPostPopKeyword()
    }

    // tblMusPopKeyword
    fun insertMusPopKeyword(keywords: List<MusPopKeywordModel>) {
        postDao.insertMusPopKeyword(keywords)
    }

    fun getMusPopKeyword() : List<MusPopKeywordModel> {
        return postDao.getMusPopKeyword()
    }
}