@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.mcKeepalive
import android.R
import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.PixelFormat
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.provider.Settings
import android.util.TypedValue
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.app.NotificationCompat
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
import android.view.WindowManager.LayoutParams as WindowManagerLayoutParams
val supportForeground = fun(): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
}
val hasBackgroundPermission = fun(context: Context): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        return Settings.canDrawOverlays(context)
    }
    return true
}
fun loadImageFromAssets(fname: String): Bitmap? {
    var bitmap: Bitmap? = null
    try {
        var assetManager = UTSAndroid.getAppContext()!!.getAssets()
        var inputStream = assetManager.open(fname)
        bitmap = BitmapFactory.decodeStream(inputStream)
    }
    catch (e: Throwable) {}
    return bitmap
}
typealias ViewTouchType = (context: Context, view: View, event: MotionEvent) -> Boolean
typealias ViewClickType = (context: Context, view: View) -> Unit
typealias AnimatorUpdateType = (animation: ValueAnimator) -> Unit
open class MyAnimatorUpdateListener : AnimatorUpdateListener {
    private var func: AnimatorUpdateType
    constructor(func: AnimatorUpdateType) : super() {
        this.func = func
    }
    override fun onAnimationUpdate(animation: ValueAnimator): Unit {
        this.func(animation)
    }
}
open class MyOnTouchListener : OnTouchListener {
    private var func: ViewTouchType
    private var context: Context
    constructor(context: Context, func: ViewTouchType) : super() {
        this.func = func
        this.context = context
    }
    override fun onTouch(view: View, event: MotionEvent): Boolean {
        return this.func(this.context, view, event)
    }
}
open class FloatingWindowManager {
    private var windowManager: WindowManager? = null
    private var floatingView: LinearLayout? = null
    private var isShowing: Boolean = false
    private var layoutParams: WindowManagerLayoutParams? = null
    private var initialX: Int = 0
    private var initialY: Int = 0
    private var initialTouchX: Float = 0.0.toFloat()
    private var initialTouchY: Float = 0.0.toFloat()
    private var isDragging: Boolean = false
    private var clickStartTime: Long = 0
    private constructor(){}
    public open fun showFloatingWindow(context: Context): Unit {
        if (this.isShowing) {
            return
        }
        try {
            this.windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            this.floatingView = this.createFloatingView(context)
            this.layoutParams = WindowManagerLayoutParams(WindowManagerLayoutParams.WRAP_CONTENT, WindowManagerLayoutParams.WRAP_CONTENT, if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                WindowManagerLayoutParams.TYPE_APPLICATION_OVERLAY
            } else {
                WindowManagerLayoutParams.TYPE_PHONE
            }
                , WindowManagerLayoutParams.FLAG_NOT_FOCUSABLE or WindowManagerLayoutParams.FLAG_NOT_TOUCH_MODAL or WindowManagerLayoutParams.FLAG_LAYOUT_IN_SCREEN, PixelFormat.TRANSLUCENT)
            this.layoutParams!!.gravity = Gravity.TOP or Gravity.START
            this.layoutParams!!.x = 0.toInt()
            this.layoutParams!!.y = 100.toInt()
            this.windowManager!!.addView(this.floatingView!!, this.layoutParams!!)
            this.isShowing = true
            console.log("显示悬浮窗成功")
            this.animateFloatingViewEntry()
        }
        catch (e: Exception) {
            console.error("显示悬浮窗失败: " + e)
        }
    }
    public open fun hideFloatingWindow(): Unit {
        if (!this.isShowing || this.windowManager == null || this.floatingView == null) {
            return
        }
        try {
            this.windowManager!!.removeView(this.floatingView!!)
            this.floatingView = null
            this.isShowing = false
        }
        catch (e: Throwable) {
            console.error("隐藏悬浮窗失败: " + e.message)
        }
    }
    private fun createFloatingView(context: Context): LinearLayout {
        val layout = LinearLayout(context)
        layout.setOrientation(LinearLayout.HORIZONTAL)
        val backgroundDrawable = GradientDrawable()
        backgroundDrawable.setShape(GradientDrawable.RECTANGLE)
        backgroundDrawable.setCornerRadius(25.0.toFloat())
        backgroundDrawable.setColors(_uA(
            Color.parseColor("#5E7DB9"),
            Color.parseColor("#4A6295")
        ).toIntArray())
        backgroundDrawable.setAlpha(200.toInt())
        backgroundDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT)
        backgroundDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT)
        layout.setBackground(backgroundDrawable)
        layout.setElevation(8.0.toFloat())
        val paddingPx = this.dpToPx(context, 12)
        layout.setPadding(paddingPx.toInt(), paddingPx.toInt(), paddingPx.toInt(), paddingPx.toInt())
        val imageView = ImageView(context)
        imageView.setImageBitmap(loadImageFromAssets("logo.png")!!)
        imageView.setScaleType(ImageView.ScaleType.FIT_XY)
        console.log("imageView=>", imageView)
        val iconSize = this.dpToPx(context, 20).toInt()
        val iconParams = LinearLayout.LayoutParams(iconSize, iconSize)
        iconParams.setMarginEnd(this.dpToPx(context, 8).toInt())
        imageView.setLayoutParams(iconParams)
        val textView = TextView(context)
        textView.setText("接单中")
        textView.setTextColor(Color.WHITE)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14.0.toFloat())
        textView.setGravity(Gravity.CENTER_VERTICAL)
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD)
        layout.addView(imageView)
        layout.addView(textView)
        val handleTouch: ViewTouchType = fun(context: Context, view: View, event: MotionEvent): Boolean {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                if (this.layoutParams != null) {
                    this.initialX = this.layoutParams!!.x
                    this.initialY = this.layoutParams!!.y
                }
                this.initialTouchX = event.getRawX()
                this.initialTouchY = event.getRawY()
                this.isDragging = false
                this.clickStartTime = Date.now().toLong()
                return true
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                val diffX = event.getRawX() - this.initialTouchX
                val diffY = event.getRawY() - this.initialTouchY
                val dragThreshold = this.dpToPx(context, 10)
                if (!this.isDragging && (Math.abs(diffX) > dragThreshold || Math.abs(diffY) > dragThreshold)) {
                    this.isDragging = true
                }
                if (this.isDragging && this.layoutParams != null && this.windowManager != null) {
                    this.layoutParams!!.x = (this.initialX + Math.round(diffX)).toInt()
                    this.layoutParams!!.y = (this.initialY + Math.round(diffY)).toInt()
                    this.windowManager!!.updateViewLayout(view, this.layoutParams!!)
                }
                return true
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                console.log("点击悬浮窗")
                val clickDuration = Date.now() - this.clickStartTime
                if (!this.isDragging && clickDuration < 500) {
                    this.animateClickEffect(view)
                    setTimeout(fun(){
                        this.openApp(context)
                    }
                        , 150)
                    return true
                }
                this.performEdgeSnap(context)
                return !this.isDragging
            }
            return false
        }
        layout.setOnTouchListener(MyOnTouchListener(context, handleTouch))
        return layout
    }
    private fun dpToPx(context: Context, dp: Number): Number {
        val density = context.getResources().getDisplayMetrics().density
        return Math.round(dp * density)
    }
    private fun performEdgeSnap(context: Context): Unit {
        if (this.layoutParams == null || this.windowManager == null || this.floatingView == null) {
            return
        }
        val displayMetrics = context.getResources().getDisplayMetrics()
        val screenWidth = displayMetrics.widthPixels
        val viewWidth = this.floatingView!!.getWidth()
        val centerX = this.layoutParams!!.x + viewWidth / 2
        val currentX = this.layoutParams!!.x
        var targetX: Number
        if (centerX < screenWidth / 2) {
            targetX = 0
        } else {
            targetX = screenWidth - viewWidth
        }
        if (Math.abs(currentX - targetX) < 10) {
            return
        }
        this.animateToPosition(currentX, targetX)
    }
    private fun openApp(context: Context): Unit {
        try {
            val packageManager = context.getPackageManager()
            val launchIntent = packageManager.getLaunchIntentForPackage(context.getPackageName())
            if (launchIntent != null) {
                launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                context.startActivity(launchIntent)
            }
        }
        catch (e: Throwable) {
            console.error("打开应用失败: " + e.message)
        }
    }
    private fun animateFloatingViewEntry(): Unit {
        if (this.floatingView == null) {
            return
        }
        this.floatingView!!.setAlpha(0.0.toFloat())
        this.floatingView!!.setScaleX(0.5.toFloat())
        this.floatingView!!.setScaleY(0.5.toFloat())
        val alphaAnimator = ObjectAnimator.ofFloat(this.floatingView!!, "alpha", 0.0.toFloat(), 1.0.toFloat())
        alphaAnimator.setDuration(300.toLong())
        val scaleXAnimator = ObjectAnimator.ofFloat(this.floatingView!!, "scaleX", 0.5.toFloat(), 1.0.toFloat())
        scaleXAnimator.setDuration(300.toLong())
        val scaleYAnimator = ObjectAnimator.ofFloat(this.floatingView!!, "scaleY", 0.5.toFloat(), 1.0.toFloat())
        scaleYAnimator.setDuration(300)
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(_uA<Animator>(alphaAnimator, scaleXAnimator, scaleYAnimator))
        animatorSet.setInterpolator(DecelerateInterpolator())
        animatorSet.start()
    }
    private fun animateClickEffect(view: View): Unit {
        val scaleDownX = ObjectAnimator.ofFloat(view, "scaleX", 1.0.toFloat(), 0.9.toFloat())
        scaleDownX.setDuration(75.toLong())
        val scaleDownY = ObjectAnimator.ofFloat(view, "scaleY", 1.0.toFloat(), 0.9.toFloat())
        scaleDownY.setDuration(75.toLong())
        val scaleUpX = ObjectAnimator.ofFloat(view, "scaleX", 0.9.toFloat(), 1.0.toFloat())
        scaleUpX.setDuration(75.toLong())
        val scaleUpY = ObjectAnimator.ofFloat(view, "scaleY", 0.9.toFloat(), 1.0.toFloat())
        scaleUpY.setDuration(75.toLong())
        val animatorSet = AnimatorSet()
        animatorSet.play(scaleDownX).`with`(scaleDownY)
        animatorSet.play(scaleUpX).`with`(scaleUpY).after(scaleDownX)
        animatorSet.start()
    }
    private fun animateToPosition(fromX: Number, toX: Number): Unit {
        if (this.layoutParams == null || this.windowManager == null || this.floatingView == null) {
            return
        }
        val animator = ValueAnimator.ofInt(fromX.toInt(), toX.toInt())
        animator.setDuration(75.toLong())
        animator.setInterpolator(DecelerateInterpolator())
        val self = this
        animator.addUpdateListener(MyAnimatorUpdateListener(fun(animation: ValueAnimator){
            val animatedValue = animation.getAnimatedValue() as Number
            if (self.layoutParams != null && self.windowManager != null && self.floatingView != null) {
                self.layoutParams!!.x = animatedValue.toInt()
                self.windowManager!!.updateViewLayout(self.floatingView!!, self.layoutParams!!)
            }
        }
        ))
        animator.start()
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
        return Binder()
    }
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        this.showFloatingWindow()
        this.setNotificationAndForeground()
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
            val context = UTSAndroid.getAppContext()!!
            if (context == null) {
                console.error("Context is null")
                return
            }
            val notificationChannel = NotificationChannel(CHANNEL_ID, "保活服务", NotificationManager.IMPORTANCE_LOW)
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC)
            notificationChannel.setShowBadge(false)
            notificationChannel.enableLights(false)
            notificationChannel.setImportance(NotificationCompat.PRIORITY_HIGH)
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
