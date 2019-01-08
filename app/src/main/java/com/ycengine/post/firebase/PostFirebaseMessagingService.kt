package com.ycengine.post.firebase

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.ycengine.post.R
import com.ycengine.post.common.Constants
import com.ycengine.post.main.PostActivity
import com.ycengine.post.util.SPUtil
import timber.log.Timber

class PostFirebaseMessagingService : FirebaseMessagingService() {

    /**
     * YCNOTE : FCM(Firebase Cloud Messaging)
     *
     * FirebaseInstanceIdService is deprecated.
     * this is new on firebase-messaging:17.1.0
     *
     * 앱이 재설치되거나 유효기간이 만료되면 자동으로 토큰을 새로 생성해 줍니다.
     */
    override fun onNewToken(token: String?) {
        Timber.e("new Token: $token")

        token?.let {
            SPUtil.setSharedPreference(this, Constants.SP_PUSH_ID, it)
        }
    }

    /**
     * this method will be triggered every time there is new FCM Message.
     */
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Timber.e("From: ${remoteMessage.from}")

        remoteMessage.notification?.let {
            Timber.e("Notification Message Body: ${it.body}")
            sendNotification(it.body)
        }
    }

    private fun sendNotification(body: String?) {
        val intent = Intent(this, PostActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            putExtra("Notification", body)
        }

        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        val notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val notificationBuilder = NotificationCompat.Builder(this,"Notification")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Push Notification FCM")
            .setContentText(body)
            .setAutoCancel(true)
            .setSound(notificationSound)
            .setContentIntent(pendingIntent)

        val notificationManager: NotificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, notificationBuilder.build())
    }
}