package com.ycengine.post.repository.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.ycengine.post.data.model.ColorModel
import com.ycengine.post.data.model.HashPopKeywordModel
import com.ycengine.post.data.model.MusPopKeywordModel
import com.ycengine.post.data.model.PostPopKeywordModel

@Dao
interface PostDao {

    /**
     * YCNOTE : ROOM
     *
     * Return 값이 LiveData 이라면 비동기 List 라면 동기처리
     */

    // tblColor
    @Insert(onConflict = REPLACE)
    fun insertColors(colors: List<ColorModel>)

    @Query("SELECT * FROM tblColor ORDER BY sortOrder ASC")
    fun getPostColor() : LiveData<List<ColorModel>>

    @Query("DELETE FROM tblColor")
    fun deletePostColor()

    // tblHashPopKeyword
    @Insert(onConflict = REPLACE)
    fun insertHashPopKeyword(colors: List<HashPopKeywordModel>)

    @Query("SELECT * FROM tblHashPopKeyword")
    fun getHashPopKeyword() : LiveData<List<HashPopKeywordModel>>

    @Query("DELETE FROM tblHashPopKeyword")
    fun deleteHashPopKeyword()

    // tblPostPopKeyword
    @Insert(onConflict = REPLACE)
    fun insertPostPopKeyword(colors: List<PostPopKeywordModel>)

    @Query("SELECT * FROM tblPostPopKeyword")
    fun getPostPopKeyword() : LiveData<List<PostPopKeywordModel>>

    @Query("DELETE FROM tblPostPopKeyword")
    fun deletePostPopKeyword()

    // tblMusPopKeyword
    @Insert(onConflict = REPLACE)
    fun insertMusPopKeyword(colors: List<MusPopKeywordModel>)

    @Query("SELECT * FROM tblMusPopKeyword")
    fun getMusPopKeyword() : LiveData<List<MusPopKeywordModel>>

    @Query("DELETE FROM tblMusPopKeyword")
    fun deleteMusPopKeyword()

    /*
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDownloadContents(vararg downloadContents : Download)

    @Query("SELECT contentsNo, '' as titleName, '' as contentType, '' as authors, '' as thumbnail, sum(1) as volumeCount, sum(downloadLength) as diskSpace FROM download WHERE userId = :userId GROUP BY contentsNo")
    fun getDownloadContentsList(userId: String) : DataSource.Factory<Int, ContentsDownload>

    @Query("SELECT * FROM download WHERE userId = :userId AND contentsNo = :contentsNo AND volumeNo = :volumeNo")
    fun getDownload(userId: String, contentsNo: Long, volumeNo: Int) : Download?

    @Query("SELECT * FROM download WHERE userId = :userId AND contentsNo = :contentsNo AND volumeNo = :volumeNo AND requestId = :requestId")
    fun getDownloadForRequest(userId: String, contentsNo: Long, volumeNo: Int, requestId: Long) : Download?

    @Query("SELECT * FROM download WHERE userId = :userId AND contentsNo = :contentsNo AND status = :status LIMIT 1")
    fun getDownloadWithStatus(userId: String, contentsNo: Long, status: DownloadStatus) : LiveData<Download>

    @Query("SELECT * FROM download WHERE userId = :userId AND contentsNo = :contentsNo AND requestId = :requestId AND status = 'PENDING'")
    fun getPendingDownloadList(userId: String, contentsNo: Long, requestId: Long) : List<Download>

    @Query("SELECT * FROM download WHERE userId = :userId AND contentsNo = :contentsNo AND status != :exclusionStatus")
    fun getDownloadListWithExclusionStatus(userId: String, contentsNo: Long, exclusionStatus: DownloadStatus) : LiveData<List<Download>>

    @Query("SELECT * FROM download WHERE userId = :userId AND contentsNo = :contentsNo AND volumeNo >= :volumeMin AND volumeNo <= :volumeMax")
    fun getDownloadWithVolumeRange(userId: String, contentsNo: Long, volumeMin: Int, volumeMax: Int) : List<Download>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEndVolumeModel(vararg volumes: VolumeModel)

    @Query("SELECT * FROM VolumeModel WHERE userId = :userId AND contentsNo = :contentsNo AND volumeNo < :volumeNo order by volumeNo desc limit :limit")
    fun getEndVolumeWithLastVolumeNoOrder(userId: String, contentsNo: Long, volumeNo: Int, limit: Int = 30) : List<VolumeModel>

    @Query("SELECT * FROM VolumeModel WHERE userId = :userId AND contentsNo = :contentsNo AND volumeNo > :volumeNo order by volumeNo asc limit :limit")
    fun getEndVolumeWithFirstVolumeNoOrder(userId: String, contentsNo: Long, volumeNo: Int, limit: Int = 30) : List<VolumeModel>

    @Query("SELECT * FROM VolumeModel WHERE userId = :userId AND contentsNo = :contentsNo AND availableRight is not null AND volumeNo < :volumeNo order by volumeNo desc limit :limit")
    fun getEndRightsVolumeWithLastVolumeNoOrder(userId: String, contentsNo: Long, volumeNo: Int, limit: Int = 30) : List<VolumeModel>

    @Query("SELECT * FROM VolumeModel WHERE userId = :userId AND contentsNo = :contentsNo AND availableRight is not null AND volumeNo > :volumeNo order by volumeNo asc limit :limit")
    fun getEndRightsVolumeWithFirstVolumeNoOrder(userId: String, contentsNo: Long, volumeNo: Int, limit: Int = 30) : List<VolumeModel>

    @Query("SELECT VolumeModel.*, status, downloadLength, contentLength FROM Download LEFT JOIN VolumeModel ON Download.userId = VolumeModel.userId AND Download.contentsNo = VolumeModel.contentsNo AND Download.volumeNo = VolumeModel.volumeNo WHERE Download.requestId = :requestId ORDER BY Download.volumeNo ASC")
    fun getVolumesWithDownloadStatus(requestId: Long) : List<DownloadVolume>

    @Query("DELETE FROM VolumeModel WHERE userId = :userId AND contentsNo = :contentsNo AND volumeNo = :volumeNo")
    fun deleteEndVolumeModel(userId: String, contentsNo: Long, volumeNo: Int)
    */
}