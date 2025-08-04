@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.mcKeepalive
import android.R
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PixelFormat
import android.net.Uri
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.provider.Settings
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.unicloud.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
val supportForeground = fun(): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
}
val hasBackgroundPermission = fun(context: Context): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        return Settings.canDrawOverlays(context)
    }
    return true
}
val requestBackgroundPermission = fun(context: Context): Unit {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (!Settings.canDrawOverlays(context)) {
            val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
            intent.setData(Uri.parse("package:" + context.getPackageName()))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}
open class FloatingWindowManager {
    private var windowManager: WindowManager? = null
    private var floatingView: View? = null
    private var isShowing: Boolean = false
    private constructor(){}
    public open fun showFloatingWindow(context: Context): Unit {
        if (this.isShowing || !hasBackgroundPermission(context)) {
            return
        }
        try {
            this.windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            this.floatingView = this.createFloatingView(context)
            val params = WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            } else {
                WindowManager.LayoutParams.TYPE_PHONE
            }
                , WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN, PixelFormat.TRANSLUCENT)
            params.gravity = Gravity.TOP or Gravity.START
            params.x = 0
            params.y = 100
            this.windowManager!!.addView(this.floatingView, params)
            this.isShowing = true
        }
        catch (e: Throwable) {
            console.error("显示悬浮窗失败: " + e.message)
        }
    }
    public open fun hideFloatingWindow(): Unit {
        if (!this.isShowing || this.windowManager == null || this.floatingView == null) {
            return
        }
        try {
            this.windowManager!!.removeView(this.floatingView)
            this.floatingView = null
            this.isShowing = false
        }
        catch (e: Throwable) {
            console.error("隐藏悬浮窗失败: " + e.message)
        }
    }
    private fun createFloatingView(context: Context): View {
        val layout = LinearLayout(context)
        layout.setOrientation(LinearLayout.VERTICAL)
        layout.setBackgroundColor(Color.parseColor("#80000000"))
        layout.setPadding(20, 15, 20, 15)
        val imageView = ImageView(context)
        imageView.setImageResource(R.drawable.ic_menu_rotate)
        imageView.setScaleType(ImageView.ScaleType.CENTER)
        imageView.setColorFilter(Color.WHITE)
        val textView = TextView(context)
        textView.setText("接单中...")
        textView.setTextColor(Color.WHITE)
        textView.setTextSize(12.toFloat())
        textView.setGravity(Gravity.CENTER)
        layout.addView(imageView)
        layout.addView(textView)
        return layout as View
    }
    companion object {
        private var instance: FloatingWindowManager? = null
        public fun getInstance(): FloatingWindowManager {
            if (FloatingWindowManager.instance == null) {
                FloatingWindowManager.instance = FloatingWindowManager()
            }
            return FloatingWindowManager.instance!!
        }
    }
}
open class Keepalive : Service {
    private var floatingWindowManager: FloatingWindowManager
    constructor() : super() {
        this.floatingWindowManager = FloatingWindowManager.getInstance()
    }
    override fun onBind(intent: Intent): IBinder {
        return Binder() as IBinder
    }
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        this.setNotificationAndForeground()
        this.showFloatingWindow()
        console.log("启动后台服务")
        return Service.START_STICKY
    }
    override fun onDestroy(): Unit {
        super.onDestroy()
        this.floatingWindowManager.hideFloatingWindow()
    }
    private fun setNotificationAndForeground(): Unit {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val CHANNEL_ID: String = "KeepaliveService"
            val context = UTSAndroid.getAppContext()
            if (context == null) {
                console.error("Context is null")
                return
            }
            val notificationChannel = NotificationChannel(CHANNEL_ID, "保活服务", NotificationManager.IMPORTANCE_LOW)
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC)
            notificationChannel.setShowBadge(false)
            notificationChannel.enableLights(false)
            notificationChannel.enableVibration(false)
            val notificationService = context.getSystemService(Context.NOTIFICATION_SERVICE)
            if (notificationService != null) {
                val notificationManager = notificationService as NotificationManager
                notificationManager.createNotificationChannel(notificationChannel)
            }
            val notificationBuilder = Notification.Builder(context, CHANNEL_ID).setAutoCancel(false).setOngoing(true).setContentTitle("每橙车主").setContentText("正在后台运行").setSmallIcon(R.drawable.ic_menu_rotate).setPriority(Notification.PRIORITY_LOW)
            val notification = notificationBuilder.build()
            super.startForeground(1001, notification)
        }
    }
    private fun showFloatingWindow(): Unit {
        val context = UTSAndroid.getAppContext()
        if (context != null) {
            this.floatingWindowManager.showFloatingWindow(context)
        }
    }
}
val startKeepaliveService = fun(): Unit {
    val context = UTSAndroid.getAppContext()
    if (context == null) {
        console.error("Context is null")
        return
    }
    val intent = Intent(context, Keepalive::class.java)
    context.startService(intent)
}
val stopKeepaliveService = fun(): Unit {
    val context = UTSAndroid.getAppContext()
    if (context == null) {
        console.error("Context is null")
        return
    }
    val intent = Intent(context, Keepalive::class.java)
    context.stopService(intent)
}
val checkAndRequestPermissions = fun(): Unit {
    val context = UTSAndroid.getAppContext()
    if (context == null) {
        console.error("Context is null")
        return
    }
    requestBackgroundPermission(context)
}
