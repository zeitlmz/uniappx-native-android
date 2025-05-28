@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.xToastS
import android.R
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.View.MeasureSpec
import android.view.ViewGroup
import android.view.ViewPropertyAnimator
import android.view.Window
import android.view.WindowManager
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.framework.getCurrentPages
import io.dcloud.uniapp.framework.onUnload
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
open class XTOAST_TYPE (
    open var iconColor: String? = null,
    open var contentBgColor: String? = null,
    open var maskBgColor: String? = null,
    open var iconSize: Number? = null,
    open var iconCode: String? = null,
    @JsonNotNull
    open var title: String,
    open var titleSize: Number? = null,
    open var titleColor: String? = null,
    open var duration: Number? = null,
    open var close: (() -> Unit)? = null,
    open var size: Number? = null,
    open var maskDisableClik: Boolean? = true,
) : UTSObject()
open class XTOAST_TYPE_PRIVATE (
    @JsonNotNull
    open var iconColor: String,
    @JsonNotNull
    open var contentBgColor: String,
    @JsonNotNull
    open var maskBgColor: String,
    @JsonNotNull
    open var iconSize: Number,
    @JsonNotNull
    open var iconCode: String,
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var titleSize: Number,
    @JsonNotNull
    open var titleColor: String,
    @JsonNotNull
    open var duration: Number,
    open var close: () -> Unit,
    @JsonNotNull
    open var size: Number,
    @JsonNotNull
    open var maskDisableClik: Boolean = false,
) : UTSObject()
open class RGBA (
    @JsonNotNull
    open var r: Number,
    @JsonNotNull
    open var g: Number,
    @JsonNotNull
    open var b: Number,
    @JsonNotNull
    open var a: Number,
) : UTSObject()
fun hexToRgb(sColors: String): RGBA? {
    if (sColors == "") {
        return null
    }
    var reg = UTSRegExp("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3}|[A-Fa-f0-9]{8})\$", "")
    var sColor: String = sColors.toLowerCase()
    if (sColor != "" && reg.test(sColor)) {
        if (sColor.length == 4) {
            var sColorNew = "#"
            run {
                var i: Number = 1
                while(i < 4){
                    sColorNew += sColor.slice(i, i + 1).concat(sColor.slice(i, i + 1))
                    i += 1
                }
            }
            sColor = sColorNew
        }
        var sColorChange: UTSArray<Number> = utsArrayOf()
        sColorChange.push(parseInt(sColor.substring(1, 3), 16))
        sColorChange.push(parseInt(sColor.substring(3, 5), 16))
        sColorChange.push(parseInt(sColor.substring(5, 7), 16))
        if (sColor.length == 9) {
            sColorChange.push(parseInt(sColor.substring(7, 9), 16) / 255)
        }
        return RGBA(r = sColorChange[0], g = sColorChange[1], b = sColorChange[2], a = if (sColorChange.length == 4) {
            sColorChange[3]
        } else {
            1
        })
    } else if (UTSRegExp("^(rgb|RGB|rgba|RGBA)", "").test(sColor)) {
        var arr: UTSArray<String> = sColor.replace(UTSRegExp("(?:\\(|\\)|rgba|rgb|RGB|RGBA)*", "g"), "").split(",")
        var p: UTSArray<Number> = arr.map(fun(kVal: String): Number {
            return parseInt(kVal)
        }
        )
        if (p.length < 3) {
            return RGBA(r = 0, g = 0, b = 0, a = 1)
        }
        if (p.length == 3) {
            p.add(1)
        }
        return RGBA(r = p[0], g = p[1], b = p[2], a = if (arr.length == 3) {
            p[3]
        } else {
            parseFloat(arr[3])
        }
        )
    }
    return null
}
val defaultConfig = XTOAST_TYPE_PRIVATE(iconColor = "rgb(5,121,255)", contentBgColor = "rgba(255,255,255,1)", maskBgColor = "rgba(0,0,0,0.6)", iconSize = 52, iconCode = "F449", title = "", titleSize = 14, titleColor = "rgb(5,121,255)", duration = 2500, size = 130, close = fun(){}, maskDisableClik = true)
val defaultStatusIcon = Map<String, String>(utsArrayOf(
    utsArrayOf(
        "warn",
        "ECA1"
    ),
    utsArrayOf(
        "error",
        "EB97"
    ),
    utsArrayOf(
        "success",
        "EB79"
    ),
    utsArrayOf(
        "info",
        "F449"
    )
))
fun configCover(opts: XTOAST_TYPE): XTOAST_TYPE_PRIVATE {
    var iconColor = if (opts.iconColor != null) {
        opts.iconColor!!
    } else {
        defaultConfig.iconColor
    }
    var contentBgColor = if (opts.contentBgColor != null) {
        opts.contentBgColor!!
    } else {
        defaultConfig.contentBgColor
    }
    var maskBgColor = if (opts.maskBgColor != null) {
        opts.maskBgColor!!
    } else {
        defaultConfig.maskBgColor
    }
    var iconSize = if (opts.iconSize != null) {
        opts.iconSize!!
    } else {
        defaultConfig.iconSize
    }
    var iconCode: String = if (opts.iconCode != null) {
        opts.iconCode!!
    } else {
        defaultConfig.iconCode
    }
    if (defaultStatusIcon.has(iconCode)) {
        iconCode = defaultStatusIcon.get(iconCode)!!
    }
    var title = if (opts.title != null) {
        opts.title!!
    } else {
        defaultConfig.title
    }
    var titleSize = if (opts.titleSize != null) {
        opts.titleSize!!
    } else {
        defaultConfig.titleSize
    }
    var titleColor = if (opts.titleColor != null) {
        opts.titleColor!!
    } else {
        defaultConfig.titleColor
    }
    var duration = if (opts.duration != null) {
        opts.duration!!
    } else {
        defaultConfig.duration
    }
    var close = if (opts.close != null) {
        opts.close!!
    } else {
        defaultConfig.close
    }
    var size = if (opts.size != null) {
        opts.size!!
    } else {
        defaultConfig.size
    }
    var maskDisableClik = true
    maskDisableClik = if (opts.maskDisableClik == null) {
        defaultConfig.maskDisableClik
    } else {
        opts.maskDisableClik!!
    }
    return XTOAST_TYPE_PRIVATE(iconColor = iconColor, contentBgColor = contentBgColor, maskBgColor = maskBgColor, iconSize = iconSize, iconCode = iconCode, title = title, titleSize = titleSize, titleColor = titleColor, duration = duration, close = close, size = size, maskDisableClik = maskDisableClik)
}
var tid: Number? = 0
var maskDomId: Number = 588
open class MaxWidthLinearLayout : LinearLayout {
    private var mMaxWidth: Number = 300
    constructor(context: Context) : super(context) {}
    open fun setMaximumWidth(maxWidth: Int) {
        this.mMaxWidth = maxWidth
        this.requestLayout()
    }
    override fun onMeasure(reassignedWidthMeasureSpec: Int, heightMeasureSpec: Int) {
        var widthMeasureSpec = reassignedWidthMeasureSpec
        var widthSize = MeasureSpec.getSize(widthMeasureSpec)
        if (this.mMaxWidth > 0 && this.mMaxWidth < widthSize) {
            var widthMode = MeasureSpec.getMode(widthMeasureSpec)
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(this.mMaxWidth.toInt(), widthMode)
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}
var dialogModal: FullScreenDialogFragment? = null
open class FullScreenDialogFragment : Dialog {
    private var mContext: Context
    private var opts: XTOAST_TYPE? = null
    private var maskeDom: RelativeLayout? = null
    constructor(context: Context, optsOwer: XTOAST_TYPE?) : super(context, R.style.Theme_Translucent_NoTitleBar_Fullscreen) {
        this.mContext = context
        this.opts = optsOwer
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.setCancelable(false)
        this.maskeDom = _createToastView(this.getContext(), this.window!!.decorView!! as ViewGroup, this.opts)
        var window = this.getWindow()
        if (window != null) {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            window.setGravity(Gravity.CENTER)
            var decorView = window.getDecorView()
            var option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            decorView.setSystemUiVisibility(option)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.setStatusBarColor(Color.TRANSPARENT)
            window.setNavigationBarColor(Color.TRANSPARENT)
            window.setType(WindowManager.LayoutParams.TYPE_APPLICATION_PANEL)
        }
    }
    override fun dismiss() {
        super.dismiss()
        this.maskeDom = null
        if (this.opts != null) {
            var closeEvent = this.opts?.close ?: null
            if (closeEvent != null) {
                closeEvent()
            }
        }
        dialogModal = null
    }
}
fun px2dp(n: Number): Number {
    val mets = UTSAndroid.getAppContext()!!.resources!!.getDisplayMetrics()
    return mets.density * n
}
fun hideToast() {
    UTSAndroid.getDispatcher("main").async(fun(_) {
        dialogModal?.dismiss()
        if (tid != null) {
            clearTimeout(tid!!)
        }
    }
    )
}
fun __hideToast__(mainDialog: FullScreenDialogFragment?) {
    UTSAndroid.getDispatcher("main").async(fun(_) {
        mainDialog?.dismiss()
        if (tid != null) {
            clearTimeout(tid!!)
        }
    }
    )
}
fun _createToastView(context: Context, decorView: ViewGroup, opts: XTOAST_TYPE?): RelativeLayout {
    var realopts = if (opts == null) {
        (XTOAST_TYPE(title = ""))
    } else {
        opts!!
    }
    var config = configCover(realopts)
    var rmbgColor = hexToRgb(config.maskBgColor)
    var textColor = hexToRgb(config.iconColor)
    var wrapColor = hexToRgb(config.contentBgColor)
    var titleColorRgb = hexToRgb(config.titleColor)
    var mbgColor = if (rmbgColor == null) {
        Color.parseColor(config.maskBgColor)
    } else {
        Color.argb((rmbgColor!!.a * 255).toInt(), rmbgColor!!.r.toInt(), rmbgColor!!.g.toInt(), rmbgColor!!.b.toInt())
    }
    var fontColor = if (textColor == null) {
        Color.parseColor(config.iconColor)
    } else {
        Color.argb((textColor!!.a * 255).toInt(), textColor!!.r.toInt(), textColor!!.g.toInt(), textColor!!.b.toInt())
    }
    var contentColor = if (rmbgColor == null) {
        Color.parseColor(config.contentBgColor)
    } else {
        Color.argb((wrapColor!!.a * 255).toInt(), wrapColor!!.r.toInt(), wrapColor!!.g.toInt(), wrapColor!!.b.toInt())
    }
    var titleColor = if (titleColorRgb == null) {
        Color.parseColor(config.titleColor)
    } else {
        Color.argb((titleColorRgb!!.a * 255).toInt(), titleColorRgb!!.r.toInt(), titleColorRgb!!.g.toInt(), titleColorRgb!!.b.toInt())
    }
    var maskerDom = RelativeLayout(context)
    open class MaskerDomClickListsner : View.OnTouchListener {
        constructor() : super() {}
        override fun onTouch(view: View, event: MotionEvent): Boolean {
            return config.maskDisableClik
        }
    }
    maskerDom.setOnTouchListener(MaskerDomClickListsner())
    var maskerDomLayrPrams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    maskerDom.setLayoutParams(maskerDomLayrPrams)
    maskerDom.setBackgroundColor(mbgColor)
    maskerDom.setGravity(Gravity.CENTER)
    maskerDom.setId(maskDomId.toInt())
    var contentWrapDiv = MaxWidthLinearLayout(context)
    var bg = GradientDrawable()
    bg.setColor(contentColor)
    bg.setCornerRadius(px2dp(16).toFloat())
    contentWrapDiv.setBackground(bg)
    var wpx = px2dp(config.size).toInt()
    var contentWrapDivParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    val maxwidthbody = UTSAndroid.getAppContext()!!.resources!!.getDisplayMetrics().widthPixels
    contentWrapDiv.setMaximumWidth(Math.min((maxwidthbody - px2dp(80)), px2dp(320)).toInt())
    contentWrapDiv.setMinimumHeight(wpx)
    contentWrapDiv.setMinimumWidth(wpx)
    contentWrapDiv.setLayoutParams(contentWrapDivParams)
    if ((config.iconCode != "" && config.title != "") || (config.iconCode != "" && config.title == "")) {
        contentWrapDiv.setMinimumHeight(wpx)
    } else {
        wpx = px2dp(32 + config.titleSize).toInt()
        contentWrapDiv.setMinimumHeight(wpx)
    }
    var wpadingx = px2dp(16).toInt()
    contentWrapDiv.setPadding(wpadingx, wpadingx, wpadingx, wpadingx)
    contentWrapDiv.setGravity(Gravity.CENTER)
    contentWrapDiv.setOrientation(LinearLayout.VERTICAL)
    var iconDiv = TextView(context)
    iconDiv.setTextColor(fontColor)
    var assetManager = context!!.getAssets()
    var typeface = Typeface.createFromAsset(assetManager, "remixicon.ttf")
    iconDiv.setTypeface(typeface)
    iconDiv.setGravity(Gravity.CENTER)
    iconDiv.setTextSize(config.iconSize.toFloat())
    if (!TextUtils.isEmpty(config.iconCode) && config.iconCode != "") {
        var codePoint = Integer.parseInt(config.iconCode, 16)
        var charArray = Character.toChars(codePoint)
        var text = String(charArray)
        iconDiv.setText(text)
        contentWrapDiv.addView(iconDiv)
    }
    if (config.title != "") {
        var titleDiv = TextView(context)
        titleDiv.setText(config.title)
        titleDiv.setTextSize(config.titleSize.toFloat())
        titleDiv.setTextColor(titleColor)
        titleDiv.setGravity(Gravity.CENTER)
        contentWrapDiv.addView(titleDiv)
    }
    maskerDom.setAlpha(0.toFloat())
    maskerDom.addView(contentWrapDiv)
    decorView.addView(maskerDom!!)
    try {
        var s0 = 0.toFloat()
        var s1 = 1.toFloat()
        contentWrapDiv.setAlpha(s0)
        contentWrapDiv.setScaleX(s0)
        contentWrapDiv.setScaleY(s0)
        val maskAni = maskerDom.animate() as ViewPropertyAnimator
        maskAni.alpha(s1).setDuration(300).setInterpolator(AccelerateDecelerateInterpolator()).start()
        var ani = contentWrapDiv.animate() as ViewPropertyAnimator
        ani.alpha(s1).scaleX(s1).scaleY(s1).setDuration(300).setInterpolator(AccelerateDecelerateInterpolator()).start()
    }
     catch (e: Throwable) {}
    if (config.duration == 0) {
        return maskerDom
    }
    tid = setTimeout(fun() {
        tid = null
        __hideToast__(dialogModal)
    }
    , (config.duration + 300).toInt())
    return maskerDom
}
fun _showToast_(opts: XTOAST_TYPE?) {
    if (tid != null) {
        clearTimeout(tid!!)
    }
    UTSAndroid.getDispatcher("main").async(fun(_) {
        dialogModal = FullScreenDialogFragment(UTSAndroid.getUniActivity()!!, opts)
        dialogModal?.show()
    }
    )
}
fun showToast(opts: XTOAST_TYPE?) {
    dialogModal?.dismiss()
    val pages = getCurrentPages()
    if (pages.length > 0) {
        val page = pages[pages.length - 1].vm!!
        val instance = page.`$`
        if (page.`$isReady`) {
            _showToast_(opts)
        } else {
            hideToast()
        }
        onUnload(fun(){
            hideToast()
        }, instance)
    } else {
        _showToast_(opts)
    }
}
