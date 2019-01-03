package com.ycengine.post.common

import android.os.Handler
import com.ycengine.post.data.dto.OstDataItem

object PlayerConstants {

    //List of Songs
    var SONGS_LIST: ArrayList<OstDataItem> = arrayListOf()
    //song number which is playing right now from SONGS_LIST
    var SONG_NUMBER = 0
    //song is playing or paused
    var SONG_PAUSED = true
    //song changed (next, previous)
    var SONG_CHANGED = false
    var SONG_RADIO = false
    var SONG_ON_AIR = false
    var SONG_ON_AIR_POI: String? = null
    //handler for song changed(next, previous) defined in service(SongService)
    var SONG_CHANGE_HANDLER: Handler? = null
    //handler for song play/pause defined in service(SongService)
    var PLAY_PAUSE_HANDLER: Handler? = null
    //handler for showing song progress defined in Activities(MainActivity, AudioPlayerActivity)
    var PROGRESSBAR_HANDLER: Handler? = null

    var MPS_REPEAT = 0
    var MPS_RANDOM = 0

    var PLAYER_TIMER = false
    var PLAYER_TIMER_START_TIME: Long = 0

    @JvmField var MOBILE_NETWORK = false
}