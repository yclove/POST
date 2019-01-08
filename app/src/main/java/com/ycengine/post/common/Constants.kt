package com.ycengine.post.common

import com.ycengine.post.BuildConfig

object Constants {

    const val DEBUG = true
    const val DEBUG_REQUEST = true
    const val DEBUG_DATABASE = true

    var STAMP_COUNT = 0
    var RIGHT_COUNT = 0

    // Exception
    const val INVALID_DATA   = "1"
    const val SW_UPDATE_NEEDED = "0100"
    const val SW_UPDATE_SUPPORT = "0101"
    const val NOT_FOUND_USER = "0111"
    const val ROOTING_DETECTED  = "rooting detected"

    // Common
    const val SERVICE_CHAR_SET = "UTF-8"
    const val SERVICE_TAG = "POST"
    const val SERVICE_PACKAGE = "com.melodigm.post"
    const val SERVICE_EMAIL = "service@melodigm.com"
    const val SERVICE_IMAGE_FILE_PATH = "/DCIM/Camera"
    const val SERVICE_MAX_IMAGE_SIZE = 800
    const val SERVICE_POST_FILE_NAME = "Post.png"
    const val SERVICE_INTRO_FILE_PATH = "PostIntro"
    const val SERVICE_MUSIC_FILE_PATH = "PostMusic"
    const val SERVICE_SHARE_FILE_PATH = "PostShare"
    const val SERVICE_SHARE_FILE_NAME = "PostShare.png"
    const val SERVICE_VOICE_FILE_PATH = "PostVoice"
    const val SERVICE_VOICE_FILE_NAME = "PostVoice.mp4"
    const val SERVICE_CABINET_IMAGE_PATH = "PostCabinet"
    const val SERVICE_CABINET_IMAGE_NAME = "PostCabinet.png"
    const val STROKE_WIDTH = 10.0f
    const val TEXT_VIEW_SPACING = 3f
    const val GLIDE_THUMBNAIL = 0.1f

    // CUSTOM SCHEME
    const val SERVICE_SCHEME = "melodigm"
    const val SERVICE_SCHEME_HOST = "post"
    const val KAKAOLINK_SCHEME_HOST = "kakaolink"

    // TIMEOUT
    const val TIMEOUT_HTTP_CONNECTION = 30000
    const val TIMEOUT_HTTP_SOCKET = 30000
    const val TIMEOUT_BACK_KEY = 2000
    const val TIMEOUT_GESTURE_DISTANCE = 200
    const val TIMEOUT_GESTURE_VELOCITY = 300

    // DIALOG TYPE
    const val DIALOG_TYPE_CHOICE_PICTURE = 1
    const val DIALOG_TYPE_CHOICE_YEAR = 2
    const val DIALOG_TYPE_CONFIRM = 3
    const val DIALOG_TYPE_INFO = 4
    const val DIALOG_TYPE_PLAY_ALL = 5
    const val DIALOG_TYPE_NOTIFY = 6
    const val DIALOG_TYPE_PLAYER_ADD = 7
    const val DIALOG_TYPE_SHARE = 8
    const val DIALOG_TYPE_NOTICE = 9
    const val DIALOG_TYPE_NOTICE_CLOSE = 10
    const val DIALOG_TYPE_PLAYER_SORT = 11
    const val DIALOG_TYPE_STAMP_FILTER = 12
    const val DIALOG_TYPE_STAMP_REQUIRED = 13
    const val DIALOG_TYPE_POPULAR = 14
    const val DIALOG_TYPE_PLAYER_TIMER = 15
    const val DIALOG_TYPE_LOCATION_SERVICE = 16
    const val DIALOG_TYPE_STORY_SORT = 17
    const val DIALOG_TYPE_STORY_TYPE = 18
    const val DIALOG_TYPE_UPDATE_NEED = 19
    const val DIALOG_TYPE_UPDATE_SUPPORT = 20
    const val DIALOG_TYPE_RADIO_TITLE = 21
    const val DIALOG_TYPE_RADIO_ON_AIR = 22
    const val DIALOG_TYPE_RADIO_ON_AIR_CLOSE = 23
    const val DIALOG_TYPE_NOT_FOUND_USER = 24
    const val DIALOG_TYPE_NEWS_AGENCY = 25

    // HEADER TYPE
    const val HEADER_TYPE_MENU = 1
    const val HEADER_TYPE_BACK_HOME_CHECK = 2
    const val HEADER_TYPE_BACK_HOME = 3
    const val HEADER_TYPE_CLOSE = 4
    const val HEADER_TYPE_MENU_POPULAR = 5

    // DIALOG MSG
    const val DIALOG_APP_CLOSE = 9999
    const val DIALOG_EXCEPTION_NON = -1
    const val DIALOG_EXCEPTION_REQUEST = -2
    const val DIALOG_EXCEPTION_POST = -3
    const val DIALOG_EXCEPTION_UPDATE_NEED = -4
    const val DIALOG_EXCEPTION_UPDATE_SUPPORT = -5
    const val DIALOG_EXCEPTION_NETWORK = -6
    const val DIALOG_EXCEPTION_IMAGE_UPLOAD = -7

    // RESULT
    const val RESULT_SUCCESS = 1000
    const val RESULT_FAIL = 1001

    // 트위터 Key - dev@melodigm.com
    const val TWITTER_KEY = "omwuXGYJKEvJZi3YbvblSCTWA"
    const val TWITTER_SECRET = "pdaZjBrI5vzcFgbE5dPFbvVTFreFJULIkr0R4On35yfCLEdwjf"

    // 인스타그램 KEY - melodigm_dev
    const val INSTAGRAM_CLIENT_ID = "df263e531daa44feb7acde4cec3c9079"
    const val INSTAGRAM_CLIENT_SECRET = "0d4454d2e98d422faa6124f80dc50bb4"
    const val INSTAGRAM_CALLBACK_URL = "postinstagram://connect"

    // POST Security Key
    const val POST_SECRET_KEY = "feb6e0bfcbc93744df2048f9e30b92e74102bdc231b7"
    const val POST_ACCESS_KEY = "90585bea"

    // HEADER
    const val HEADER_CONTENT_TYPE_FORM = "application/x-www-form-urlencoded"
    const val HEADER_CONTENT_TYPE_MULTIPART = "multipart/form-data"
    const val HEADER_DEVICE_TYPE = "AH01"

    // Request Code
    const val REQUEST_CABINET_TYPE = "CABINET_TYPE"
    const val REQUEST_CABINET_TYPE_PUT = "PUT"
    const val REQUEST_CABINET_TYPE_PLAY = "PLAY"
    const val REQUEST_TYPE_POST = "AA01"        // 사연
    const val REQUEST_TYPE_TODAY = "AA02"     // TODAY
    const val REQUEST_TYPE_RADIO = "AA03"     // 라디오
    const val REQUEST_DISP_TYPE_PUBLIC = "AB01"       // 공개
    const val REQUEST_DISP_TYPE_PRIVATE = "AB02"     // 나만
    const val REQUEST_DISP_TYPE_FRIEND = "AB03"       // 친구
    const val REQUEST_DISP_TYPE_DELETE = "AB04"       // 삭제
    const val REQUEST_DISP_TYPE_NOTIFY = "AB05"      // 신고
    const val REQUEST_DISP_TYPE_RESET = "AB06"         // 초기화
    const val REQUEST_FILE_USE_TYPE_POST_BACK = "AC01"    // 포스트배경사진
    const val REQUEST_FILE_USE_TYPE_VOICE = "AC02"             // 음성사연
    const val REQUEST_FILE_USE_TYPE_USER_BACK = "AC03"   // 유저배경사진
    const val REQUEST_FILE_USE_TYPE_MAP_BACK = "AC04"   // 지도배경사진
    const val REQUEST_REG_PLAC_TYPE_POST = "AE01"         // 포스트
    const val REQUEST_REG_PLAC_TYPE_STORAGE = "AE02"  // 보관함
    const val REQUEST_REG_PLAC_TYPE_OST = "AE03"           // OST
    const val REQUEST_REG_PLAC_TYPE_ALBUM = "AE04"      // 앨범
    const val REQUEST_REG_PLAC_TYPE_MUSIC = "AE05"      // 음원
    const val REQUEST_DCRE_TARGET_TYPE_POST = "AJ01"      // POST
    const val REQUEST_DCRE_TARGET_TYPE_OST = "AJ02"      // OST
    const val REQUEST_ACCOUNT_AUTH_TYPE_EMAIL = "AD01"            // 이메일
    const val REQUEST_ACCOUNT_AUTH_TYPE_APP_ID = "AD02"           // 앱ID
    const val REQUEST_ACCOUNT_AUTH_TYPE_FACEBOOK = "AD03"      // Facebook
    const val REQUEST_ACCOUNT_AUTH_TYPE_TWITTER = "AD04"          // Twitter
    const val REQUEST_ACCOUNT_AUTH_TYPE_INSTAGRAM = "AD05"      // Instagram
    const val REQUEST_ACCOUNT_AUTH_TYPE_NAVER_LINE = "AD06"      // 네이버 라인
    const val REQUEST_DCRE_RESN_CODE_AK01 = "AK01"    // 부적절한 홍보/광고 게시물
    const val REQUEST_DCRE_RESN_CODE_AK02 = "AK02"    // 음란 또는 청소년에게 부적합한 내용
    const val REQUEST_DCRE_RESN_CODE_AK03 = "AK03"    // 명예훼손/사생활 침해 및 저작권 침해 등
    const val REQUEST_POST_PST_TYPE_LEFT = "BF01"         // 왼쪽 정렬
    const val REQUEST_POST_PST_TYPE_CENTER = "BF02"    // 중앙 정렬
    const val REQUEST_POST_PST_TYPE_RIGHT = "BF03"      // 오른쪽 정렬
    const val REQUEST_POINT_TYPE_STAMP = "AX01"           // 우표
    const val REQUEST_TRANS_TYPE_ALL = "ALL"           // 전체
    const val REQUEST_TRANS_TYPE_KEEP = "BG"           // 적립
    const val REQUEST_TRANS_TYPE_USE = "BH"           // 소비
    const val REQUEST_PLAY_CYCLE_TYPE_START = "AL01"           // 시작
    const val REQUEST_PLAY_CYCLE_TYPE_PAYMENT = "AL02"     // 과금
    const val REQUEST_PLAY_CYCLE_TYPE_END = "AL03"              // 완료
    const val REQUEST_ACTION_DIVN_TYPE_POST = "AW01" // 포스트활동
    const val REQUEST_ACTION_DIVN_TYPE_OST = "AW02" // 음원활동
    const val REQUEST_ACTION_DIVN_TYPE_PAYMENT = "AW03" // 상품구매활동
    const val REQUEST_ACTION_DIVN_TYPE_SHARE = "AW04" // 소셜공유활동
    const val REQUEST_ACTION_TYPE_IMAGE = "BL01" // 이미지저장
    const val REQUEST_ACTION_TYPE_FACEBOOK = "BL02" // 페이스북
    const val REQUEST_ACTION_TYPE_TWITTER = "BL03" // 트위터
    const val REQUEST_ACTION_TYPE_INSTAGRAM = "BL04" // 인스타그램
    const val REQUEST_ACTION_TYPE_KAKAOTALK = "BL05" // 카카오톡
    const val REQUEST_ACTION_TYPE_LINE = "BL06" // 라인
    const val REQUEST_ACTION_PLAC_TYPE_PAYMENT = "BK01" // 상품구매내역
    const val REQUEST_ACTION_PLAC_TYPE_ICON = "BK02" // 아이콘등록내역
    const val REQUEST_ACTION_PLAC_TYPE_POST = "BK03" // 포스트
    const val REQUEST_ACTION_PLAC_TYPE_OST = "BK04" // OST
    const val REQUEST_ACTION_PLAC_TYPE_PLAYLIST = "BK05" // 음원재생내역

    // Query Code
    const val QUERY_APP_VERSION = 9001
    const val QUERY_REGIST_USER = 9002
    const val QUERY_USER_INFO = 9003
    const val QUERY_UPDATE_USER_INFO = 9004
    const val QUERY_POST_DATA = 9005
    const val QUERY_POST_DATA_VIEW = 9006
    const val QUERY_WRITE_POST_DATA = 9007
    const val QUERY_CHOICE_PICTURE = 9008
    const val QUERY_CHOICE_CAMERA = 9009
    const val QUERY_LOCATION_CHANGE = 9010
    const val QUERY_LOCATION_SEARCH = 9011
    const val QUERY_OST_DATA = 9012
    const val QUERY_WRITE_OST_DATA = 9013
    const val QUERY_POST_LIKE = 9014
    const val QUERY_POST_DATA_UPDATE = 9015
    const val QUERY_OST_DATA_VIEW = 9016
    const val QUERY_POST_NOTIFY = 9017
    const val QUERY_POST_DELETE = 9018
    const val QUERY_SNS_ACCOUNT_SYNC = 9019
    const val QUERY_SNS_ACCOUNT_RESTORE = 9020
    const val QUERY_OST_TITLE = 9021
    const val QUERY_OST_DATA_UPDATE = 9022
    const val QUERY_OST_SEARCH = 9023
    const val QUERY_OST_RELATED = 9024
    const val QUERY_OST_RELATED_VIEW = 9025
    const val QUERY_OST_ADD_PLAY_LIST = 9026
    const val QUERY_OST_DOWNLOAD = 9027
    const val QUERY_CABINET_DATA = 9028
    const val QUERY_WRITE_CABINET = 9029
    const val QUERY_CABINET_DESC = 9030
    const val QUERY_ADD_CABINET = 9031
    const val QUERY_CROP_IMAGE = 9032
    const val QUERY_CABINET_SORT = 9033
    const val QUERY_SLIDE_MENU = 9034
    const val QUERY_NOTIFY_RESULT = 9035
    const val QUERY_LIKE_RESULT = 9036
    const val QUERY_INIT_INFO = 9037
    const val QUERY_INIT = 9038
    const val QUERY_OST_NOTIFY = 9039
    const val QUERY_OST_DELETE = 9040
    const val QUERY_OST_LIKE = 9041
    const val QUERY_POST_SORT = 9042
    const val QUERY_TIME_LINE = 9043
    const val QUERY_OST_REPLE = 9044
    const val QUERY_OST_REPLE_WRITE = 9045
    const val QUERY_OST_REPLE_DELETE = 9046
    const val QUERY_OST_REPLE_DELETE_RESULT = 9047
    const val QUERY_COLOR_RANDOM_IMAGE = 9048
    const val QUERY_CALENDAR = 9049
    const val QUERY_POST_DATA_MORE = 9050
    const val QUERY_CABINET_PLAY = 9051
    const val QUERY_PLAY_LIST_DELETE = 9052
    const val QUERY_MUSIC_SEARCH = 9053
    const val QUERY_STAMP_DATA = 9054
    const val QUERY_CABINET_DELETE = 9055
    const val QUERY_POST_DATA_ADD = 9056
    const val QUERY_NOTIFICATION_CENTER = 9057
    const val QUERY_PLAYER_TIMER = 9058
    const val QUERY_LOCATION_SERVICE_SETTING = 9059
    const val QUERY_AGREEMENT_DATA = 9060
    const val QUERY_STORY_SEARCH = 9061
    const val QUERY_STORY_RELATED = 9062
    const val QUERY_SNS_SHARE = 9063
    const val QUERY_MUSIC_PAYMENT = 9064
    const val QUERY_MUSIC_PAYMENT_FAILED = 9065
    const val QUERY_MUSIC_PATH = 9066
    const val QUERY_MUSIC_SECURITY = 9067
    const val QUERY_SEND_MAIL = 9068
    const val QUERY_SELECT_NOTIFICATION = 9069
    const val QUERY_UPDATE_NOTIFICATION = 9070
    const val QUERY_UPDATE_QUALITY = 9071
    const val QUERY_ACTION_LOG = 9072

    // COLOR
    const val COLOR_WHITE = -0x1
    const val COLOR_YELLOW = -0x100

    // JARVIS Server API
    var API_LASTEST_TIMESTAMP: Long = 0
    var API_UV_LOGGING = "N"
    const val API_RETRY_COUNT = 10
    const val API_INIT_LNG = 126.98955

    // 이용약관 / 개인정보 수집 및 이용 동의 / 위치정보이용약관 / 개인정보보호정책 API
    const val AGREEMENT_SERVICE = BuildConfig.SERVER_URL + "app0102v1.post"
    const val AGREEMENT_PRIVATE = BuildConfig.SERVER_URL + "app0103v1.post"
    const val AGREEMENT_LOCATION = BuildConfig.SERVER_URL + "app0104v1.post"
    const val AGREEMENT_SCHEME = BuildConfig.SERVER_URL + "app0105v1.post"

    // Music Player Service
    const val MPS_COMMAND = "COMMAND"
    const val MPS_COMMAND_GET = "COMMAND_GET"
    const val MPS_COMMAND_SET = "COMMAND_SET"
    const val MPS_COMMAND_PUT = "COMMAND_PUT"
    const val MPS_COMMAND_ADD = "COMMAND_ADD"
    const val MPS_COMMAND_PLAY = "COMMAND_PLAY"
    const val MPS_COMMAND_PAUSE = "COMMAND_PAUSE"
    const val MPS_COMMAND_PREV = "COMMAND_PREV"
    const val MPS_COMMAND_NEXT = "COMMAND_NEXT"
    const val MPS_COMMAND_ON_AIR = "COMMAND_ON_AIR"
    const val MPS_COMMAND_ON_AIR_CLEAR = "COMMAND_ON_AIR_CLEAR"
    const val MPS_REPEAT_NO = 0
    const val MPS_REPEAT_ALL = 1
    const val MPS_REPEAT_ONE = 2
    const val MPS_RANDOM_NO = 0
    const val MPS_RANDOM_OK = 1
    const val NOTIFY_PREVIOUS = "com.melodigm.post.previous"
    const val NOTIFY_DELETE = "com.melodigm.post.delete"
    const val NOTIFY_PAUSE = "com.melodigm.post.pause"
    const val NOTIFY_PLAY = "com.melodigm.post.play"
    const val NOTIFY_NEXT = "com.melodigm.post.next"


    // SharedPreferences
    const val SP_INTRO_BG = "INTRO_BG"
    const val SP_USER_ID = "USER_ID"
    const val SP_USER_GENDER = "USER_GENDER"
    const val SP_USER_BIRTH_YEAR = "USER_BIRTH_YEAR"
    const val SP_PUSH_ID = "PUSH_ID"
    const val SP_PUSH_STATE = "PUSH_STATE"
    const val SP_LATEST_APP_VERSION = "LATEST_APP_VERSION"
    const val SP_USE_DATA_NETWORK = "USE_DATA_NETWORK"
    const val SP_USER_LAT = "USER_LAT"
    const val SP_USER_LNG = "USER_LNG"
    const val SP_ACCOUNT_ID = "ACCOUNT_ID"
    const val SP_ACCOUNT_AUTH_TYPE = "ACCOUNT_AUTH_TYPE"
    const val SP_MPS_POSITION = "MPS_POSITION"
    const val SP_MPS_REPEAT = "MPS_REPEAT"
    const val SP_MPS_RANDOM = "MPS_RANDOM"
    const val SP_ICI_LIKE = "ICI_LIKE"
    const val SP_COUNTRY_CODE = "COUNTRY_CODE"
    const val SP_PLAYER_TIMER = "PLAYER_TIMER"
    const val SP_PLAYER_STREAMING_QUALITY = "PLAYER_STREAMING_QUALITY"
    const val SP_PLAYER_LIST_ADD_POSITION = "PLAYER_LIST_ADD_POSITION"
    const val SP_PLAYER_DELETE_500_LIST = "PLAYER_DELETE_500_LIST"
    const val SP_PLAYER_FILE_SAVE = "PLAYER_FILE_SAVE"
    const val SP_PLAYER_DISPLAY_LOCK_SCREEN_ALBUM = "PLAYER_DISPLAY_LOCK_SCREEN_ALBUM"
    const val SP_NOTIFICATION_POST = "NOTIFICATION_POST"
    const val SP_NOTIFICATION_OST = "NOTIFICATION_OST"
    const val SP_NOTIFICATION_SERVICE = "NOTIFICATION_SERVICE"
    const val SP_NOTIFICATION_TODAY = "NOTIFICATION_TODAY"
    const val SP_BADGE_COUNT = "BADGE_COUNT"

    // Google Analytics
    const val GA_CATEGORY_MUSIC = "음원"
    const val GA_CATEGORY_SEARCH = "검색"
    const val GA_CATEGORY_SNS = "SNS"
    const val GA_CATEGORY_SHARE = "공유"

    const val GA_ACTION_MUSIC_LISTENING = "듣기"
    const val GA_ACTION_MUSIC_COMPLETION = "감상"
    const val GA_ACTION_SEARCH_MUSIC = "노래"
    const val GA_ACTION_SEARCH_OST = "OST"
    const val GA_ACTION_SEARCH_STORY = "사연"
    const val GA_ACTION_SNS_SYNC = "계정연동"
    const val GA_ACTION_SNS_RESTORE = "계정복원"
    const val GA_ACTION_SHARE_IMAGE = "이미지로 저장"
    const val GA_ACTION_SHARE_FACEBOOK = "페이스북"
    const val GA_ACTION_SHARE_TWITTER = "트위터"
    const val GA_ACTION_SHARE_INSTAGRAM = "인스타그램"
    const val GA_ACTION_SHARE_LINE = "라인"
    const val GA_ACTION_SHARE_KAKAOTALK = "카카오톡"
}
