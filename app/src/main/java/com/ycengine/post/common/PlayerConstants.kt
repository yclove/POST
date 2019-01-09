package com.ycengine.post.common

import android.os.Handler
import com.ycengine.post.data.model.OstDataItem

object PlayerConstants {

    //List of Songs
    @JvmField var SONGS_LIST: ArrayList<OstDataItem> = arrayListOf()
    //song number which is playing right now from SONGS_LIST
    @JvmField var SONG_NUMBER = 0
    //song is playing or paused
    @JvmField var SONG_PAUSED = true
    //song changed (next, previous)
    @JvmField var SONG_CHANGED = false
    @JvmField var SONG_RADIO = false
    @JvmField var SONG_ON_AIR = false
    @JvmField var SONG_ON_AIR_POI: String? = null
    //handler for song changed(next, previous) defined in service(SongService)
    @JvmField var SONG_CHANGE_HANDLER: Handler? = null
    //handler for song play/pause defined in service(SongService)
    @JvmField var PLAY_PAUSE_HANDLER: Handler? = null
    //handler for showing song progress defined in Activities(MainActivity, AudioPlayerActivity)
    @JvmField var PROGRESSBAR_HANDLER: Handler? = null

    @JvmField var MPS_REPEAT = 0
    @JvmField var MPS_RANDOM = 0

    @JvmField var PLAYER_TIMER = false
    @JvmField var PLAYER_TIMER_START_TIME: Long = 0

    @JvmField var MOBILE_NETWORK = false
}