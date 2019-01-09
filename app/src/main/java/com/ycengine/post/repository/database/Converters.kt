package com.ycengine.post.repository.database

import android.arch.persistence.room.TypeConverter
import com.ycengine.post.data.model.DownloadStatus
import timber.log.Timber
import java.util.*

class Converters {

    companion object {
        @TypeConverter
        @JvmStatic
        fun fromTimestamp(value: Long?): Date? {
            return if (value == null) null else Date(value)
        }

        @TypeConverter
        @JvmStatic
        fun dateToTimestamp(date: Date?): Long? {
            return date?.time
        }

        @TypeConverter
        @JvmStatic
        fun fromString(value: String?) : DownloadStatus {
            if (value == null) {
                return DownloadStatus.UNKNOWN
            }

            return try {
                DownloadStatus.valueOf(value)
            } catch (e: Exception) {
                Timber.w(e)
                DownloadStatus.UNKNOWN
            }
        }

        @TypeConverter
        @JvmStatic
        fun fromDownloadState(value: DownloadStatus) : String {
            return value.name
        }
    }
}