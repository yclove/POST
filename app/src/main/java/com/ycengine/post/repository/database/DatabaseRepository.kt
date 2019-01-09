package com.ycengine.post.repository.database

import android.arch.lifecycle.LiveData
import com.ycengine.post.data.model.ColorModel
import com.ycengine.post.data.model.HashPopKeywordModel
import com.ycengine.post.data.model.MusPopKeywordModel
import com.ycengine.post.data.model.PostPopKeywordModel

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

    fun getPostColor() : LiveData<List<ColorModel>> {
        return postDao.getPostColor()
    }

    // tblHashPopKeyword
    fun insertHashPopKeyword(keywords: List<HashPopKeywordModel>) {
        postDao.insertHashPopKeyword(keywords)
    }

    fun getHashPopKeyword() : LiveData<List<HashPopKeywordModel>> {
        return postDao.getHashPopKeyword()
    }

    // tblPostPopKeyword
    fun insertPostPopKeyword(keywords: List<PostPopKeywordModel>) {
        postDao.insertPostPopKeyword(keywords)
    }

    fun getPostPopKeyword() : LiveData<List<PostPopKeywordModel>> {
        return postDao.getPostPopKeyword()
    }

    // tblMusPopKeyword
    fun insertMusPopKeyword(keywords: List<MusPopKeywordModel>) {
        postDao.insertMusPopKeyword(keywords)
    }

    fun getMusPopKeyword() : LiveData<List<MusPopKeywordModel>> {
        return postDao.getMusPopKeyword()
    }
}