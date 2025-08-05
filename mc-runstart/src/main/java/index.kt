@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.mcRunstarter
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
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
open class SplashScreenOptions (
    @JsonNotNull
    open var duration: Number,
    @JsonNotNull
    open var width: Number,
    @JsonNotNull
    open var height: Number,
    open var hideCb: () -> Unit,
) : UTSObject()
var maskDomId: Number = 686
typealias HideCb = () -> Unit
var hideCb: HideCb? = null
var lastTime: Long = 0
fun hideSplashScreen() {
    val timeDiff = Date().getTime() - lastTime
    val time = 2000 - timeDiff
    console.log("timeDiff:", timeDiff)
    setTimeout(fun(){
        var decorView = UTSAndroid.getUniActivity()!!.window.decorView as ViewGroup
        var mk = decorView.findViewById<View>(maskDomId.toInt())
        if (mk != null) {
            decorView.removeView(mk)
        }
        hideCb?.invoke()
        console.log("隐藏启动图")
    }
        , if (time <= 0) {
            0
        } else {
            time
        }
    )
}
open class IntentRunable : Runnable {
    open var cb: () -> Unit
    constructor(cb: () -> Unit) : super() {
        this.cb = cb
    }
    override fun run() {
        this.cb()
    }
}
fun showSplashScreen(opts: SplashScreenOptions) {
    hideCb = opts.hideCb
    lastTime = Date().getTime().toLong()
    UTSAndroid.getDispatcher("io").async(fun(_) {
        UTSAndroid.getUniActivity()!!.runOnUiThread(IntentRunable(fun(){
            val context = UTSAndroid.getAppContext()!! as Context
            var win = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            var decorView = UTSAndroid.getUniActivity()!!.window.decorView as ViewGroup
            try {
                var mk = decorView.findViewById<View?>(maskDomId.toInt())
                if (mk != null) {
                    decorView.removeView(mk!!)
                }
            }
            catch (e: Throwable) {}
            var maskerDom = RelativeLayout(context)
            var maskerDomLayrPrams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            maskerDom.setLayoutParams(maskerDomLayrPrams)
            maskerDom.setBackgroundColor(Color.BLUE)
            maskerDom.setId(maskDomId.toInt())
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
            var img = ImageView(context)
            img.setImageBitmap(loadImageFromAssets("runstart.png"))
            img.setLayoutParams(FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
            img.setScaleType(ImageView.ScaleType.FIT_XY)
            img.setId(maskDomId.toInt())
            img.setBackgroundColor(Color.BLUE)
            decorView.addView(img!!)
            console.log("实现启动界面")
        }
        ))
    }
        , null)
}
