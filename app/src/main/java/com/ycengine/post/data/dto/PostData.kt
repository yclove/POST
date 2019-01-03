package com.ycengine.post.data.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostData(
    val POST_TYPE: String = "",
    val KWD: String = "",
    val EMOTICON: String = "",
    val POST_PST_TYPE: String = "",
    val AGE_ZONE: String = "",
    val RADIO_PATH: String = "",
    val BG_PIC_PATH: String = "",
    val BG_USER_PATH: String = "",
    val BG_MAP_PATH: String = "",
    val POI: String = "",
    val POST_SUBJ: String = "",
    val POST_CONT: String = "",
    val COLOR: String = "",
    val COLOR_HEX: String = "",
    val PLACE: String = "",
    val OST_REG_YN: String = "",
    val REG_DATE: String = "",
    val LIKE_CNT: Int = 0,
    val OST_CNT: Int = 0,
    val DCRE_CNT: Int = 0,
    val LIKE_TOGGLE_YN: String = "",
    val UAI: String = "",
    val DCRE_TOGGLE_YN: String = "",
    val OTI: String = "",
    val SSI: String = "",
    val TITLE_ALBUM_PATH: String = "",
    val TITLE_ARTI_NM: String = "",
    val TITLE_SONG_NM: String = "",
    val RADIO_RUNTIME: Int = 0
): Parcelable
/*
private SeekBar mSeekbar = null;
private LetterSpacingTextView tvRadioPlay = null;
private ImageView ivRadioPlay = null;
private LetterSpacingTextView tvRadioPlayDuration = null;
private ParallaxImageView ivRoot = null;
private LinearLayout llPostLikeBtn = null;
*
* */