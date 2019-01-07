package com.ycengine.post.repository.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.ycengine.post.PostApplication
import com.ycengine.post.data.dto.ColorModel
import com.ycengine.post.data.dto.HashPopKeywordModel
import com.ycengine.post.data.dto.MusPopKeywordModel
import com.ycengine.post.data.dto.PostPopKeywordModel
import timber.log.Timber

@Database(entities = [ColorModel::class, HashPopKeywordModel::class, PostPopKeywordModel::class, MusPopKeywordModel::class], version = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class PostDatabase : RoomDatabase() {
    abstract fun getPostDao(): PostDao

    companion object {
        @Volatile private var INSTANCE: PostDatabase? = null

        fun getInstance() : PostDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(PostApplication.context).also {
                INSTANCE = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context.applicationContext, PostDatabase::class.java, "POST.db")
            .addCallback(object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    Timber.e("Database 생성")
                }
            })
            .build()
    }
}