package com.ycengine.post.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * YCNOTE : Parcelable vs Serializable
 *
 * Serializable 은 Java 만 아는 사람이라면 쉽게 알 수 있는 serialization 방법.
 * 그냥 Serializable 을 implementation 만 해주면, serialize 가 필요한 순간에 알아서 serialze 해주는 편리한 marker interface.
 *
 * 그러나, mobile 시대가 강림하면서 등장한 유망한 어린이(?) 가 있으니 그는 바로 Parcelable.
 * 이 녀석은 IPC ( Inter Process Communication ) 에 최적화된 녀석으로 Serialize 보다 속도가 빠르다.
 * 물론, 해야 하는 일은 Serialize 보다 훨씬 많다.
 * 직접 serialize 되어야 할 녀석들을 선별해서 그것을 쓰고 읽는 작업을 해주어야 한다.
 *
 * 그럼 왜 serialization 이 parcelable 보다 속도가 느릴까?
 * 그 이유는, serialization 은 reflection 방법을 사용하여 serialization 을 하는데, parcelable 은 프로그래머가 직접 바로 setting 을 해주기 때문에 빠른 것이다.
 * ( reflection 이 성능이슈를 야기할 수 있다는 것은 이미 알고 있을꺼라 생각한다.. )
 *
 * Serialization 도 그렇게 느리지는 않지만, Parcelable 이 훨씬 빠르다.
 * 정말 많은 뭉태기의 property 들이 한 클래스에 있는 경우는 드물겠지만, 그런 경우라면 Parcelable 의 성능이 훨씬 빠르다.
 */
@Parcelize
data class PostModel(
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