package com.ycengine.post.common.base

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ycengine.post.R
import com.ycengine.post.common.Constants
import com.ycengine.post.common.PostException
import com.ycengine.post.widget.PostDialog

abstract class BaseActivity : AppCompatActivity() {

//    private var imageRequestManager: RequestManager? = null
    private var isFinish = false
    private var mPostException: PostException? = null
    private var mPostDialog: PostDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        imageRequestManager = Glide.with(this)
    }

    override fun onDestroy() {
        super.onDestroy()
//        imageRequestManager?.onDestroy()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
//        Glide.get(this).trimMemory(level)
    }

    override fun onLowMemory() {
        super.onLowMemory()
//        Glide.get(this).clearMemory()
    }

    fun createGlobalDialog(requestCode: Int, finish: Boolean): PostDialog? {
        this.isFinish = finish

        when (requestCode) {
            Constants.DIALOG_EXCEPTION_POST -> {
                if (mPostException?.code.equals(Constants.NOT_FOUND_USER, ignoreCase = true)) {
                    mPostDialog = PostDialog(this, Constants.DIALOG_TYPE_NOT_FOUND_USER, onGlobalClickListener, mPostException?.message)
                } else {
                    mPostDialog = PostDialog(this, Constants.DIALOG_TYPE_INFO, onGlobalClickListener, mPostException?.message)
                }
            }
            Constants.DIALOG_EXCEPTION_UPDATE_NEED -> {
                mPostDialog = PostDialog(this, Constants.DIALOG_TYPE_UPDATE_NEED, onGlobalClickListener)
            }
            Constants.DIALOG_EXCEPTION_UPDATE_SUPPORT -> {
                mPostDialog = PostDialog(this, Constants.DIALOG_TYPE_UPDATE_SUPPORT, onGlobalClickListener)
            }
            Constants.DIALOG_EXCEPTION_NETWORK -> {
                mPostDialog = PostDialog(this, Constants.DIALOG_TYPE_INFO, onGlobalClickListener, getString(R.string.exception_network))
            }
        }

        return mPostDialog
    }

    private val onGlobalClickListener = View.OnClickListener {
        val intent: Intent

        when (it.id) {
            // 안내 타입의 확인 onClick
            R.id.btnInfoConfirm -> {
                mPostDialog?.apply {
                    dismiss()
                }
                if (isFinish) finish()
            }
        }
    }
    /*
    public View.OnClickListener onGlobalClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;

            switch (v.getId()) {
                // 미등록 사용자 타입 확인 onClick
                case R.id.btnNotFoundUserConfirm:
                if (mPostDialog != null && mPostDialog.isShowing()) mPostDialog.dismiss(); mPostDialog = null;

                SPUtil.setSharedPreference(mContext, Constants.SP_USER_ID, "");
                SPUtil.setSharedPreference(mContext, Constants.SP_ACCOUNT_ID, "");
                SPUtil.setSharedPreference(mContext, Constants.SP_ACCOUNT_AUTH_TYPE, "");

                mdbHelper = new PostDatabases(mContext);
                mdbHelper.open();
                mdbHelper.deleteAllRecentSearchWords();
                mdbHelper.deleteAllOstPlayList();
                mdbHelper.close();

                File file = getDir(Constants.SERVICE_MUSIC_FILE_PATH, MODE_PRIVATE);
                DeviceUtil.removeFiles(file);

                intent = new Intent(mContext, PostActivity.class);
                intent.putExtra("HOME_NEWINTENT_MOVE", Constants.QUERY_REGIST_USER);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
                // 확인 타입의 확인 onClick
                case R.id.btnConfirmConfirm:
                if (mPostDialog != null && mPostDialog.isShowing()) mPostDialog.dismiss(); mPostDialog = null;
                SPUtil.setSharedPreference(mContext, Constants.SP_USE_DATA_NETWORK, true);
                break;
                // 안내 타입의 확인 onClick
                case R.id.btnInfoConfirm:
                if (mPostDialog != null) mPostDialog.dismiss();
                if (isFinish) finish();
                break;
                // 필수 업데이트 타입의 확인
                // 권장 업데이트 타입의 업데이트 onClick
                case R.id.btnUpdateNeedConfirm:
                case R.id.ivUpdateSupportUpdateBtn:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + Constants.SERVICE_PACKAGE));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                break;
                // 권장 업데이트 타입의 보기 onClick
                case R.id.btnUpdateSupportSee:
                DeviceUtil.showToast(mContext, "공지사항으로 이동");
                break;
                // RADIO ON AIR 해제 > 일시멈춤 onClick
                case R.id.btnOnAirPause:
                if (mPostDialog != null && mPostDialog.isShowing()) mPostDialog.dismiss(); mPostDialog = null;
                Controls.pauseControl(mContext);
                break;
                // RADIO ON AIR 해제 > 해제 onClick
                case R.id.btnOnAirCancel:
                if (mPostDialog != null && mPostDialog.isShowing()) mPostDialog.dismiss(); mPostDialog = null;
                intent = new Intent("com.melodigm.post.service.MusicService.LAUNCHER");
                intent.setPackage(Constants.SERVICE_PACKAGE);
                intent.putExtra(Constants.MPS_COMMAND, Constants.MPS_COMMAND_ON_AIR_CLEAR);
                startService(intent);
                break;
                // 이용권구매 onClick
                case R.id.llMenuBuyUseCoupon:
                case R.id.llBuyUseCoupon:
                case R.id.rlBuyUseCouponBtn:
                intent = new Intent(mContext, BuyUseCouponActivity.class);
                startActivity(intent);
                break;
            }
        }
    };*/
}