@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.xModalS
import android.R
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.TextUtils
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.URLSpan
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.ViewPropertyAnimator
import android.view.Window
import android.view.WindowManager
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.ScrollView
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
open class X_MODAL_TYPE (
    open var title: String? = null,
    open var content: String? = null,
    open var contentAlign: String? = null,
    open var cancelText: String? = null,
    open var cancelBgColor: String? = null,
    open var cancelColor: String? = null,
    open var confirmText: String? = null,
    open var confirmBgColor: String? = null,
    open var confirmColor: String? = null,
    open var linkFontColor: String? = null,
    open var radius: Number? = null,
    open var confirmIcon: String? = null,
    open var cancelIcon: String? = null,
    open var titleColor: String? = null,
    open var contentColor: String? = null,
    open var isSplitBtn: Boolean? = true,
    open var contentBgColor: String? = null,
    open var maskBgColor: String? = null,
    open var confirm: (() -> Unit)? = null,
    open var cancel: (() -> Unit)? = null,
    open var close: (() -> Unit)? = null,
    open var clickLink: ((href: String) -> Unit)? = null,
    open var isBlurMask: Boolean? = true,
    open var height: Number? = null,
    open var width: Number? = null,
    open var clickMaskClose: Boolean? = true,
    open var showCancel: Boolean? = true,
) : UTSObject()
open class X_MODAL_TYPE_PRIVATE (
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var content: String,
    @JsonNotNull
    open var contentAlign: String,
    @JsonNotNull
    open var cancelText: String,
    @JsonNotNull
    open var cancelBgColor: String,
    @JsonNotNull
    open var cancelColor: String,
    @JsonNotNull
    open var titleColor: String,
    @JsonNotNull
    open var contentColor: String,
    @JsonNotNull
    open var confirmText: String,
    @JsonNotNull
    open var confirmBgColor: String,
    @JsonNotNull
    open var confirmColor: String,
    @JsonNotNull
    open var linkFontColor: String,
    @JsonNotNull
    open var radius: Number,
    @JsonNotNull
    open var confirmIcon: String,
    @JsonNotNull
    open var cancelIcon: String,
    @JsonNotNull
    open var isSplitBtn: Boolean = false,
    @JsonNotNull
    open var contentBgColor: String,
    @JsonNotNull
    open var maskBgColor: String,
    open var confirm: () -> Unit,
    open var cancel: () -> Unit,
    open var close: () -> Unit,
    open var clickLink: (href: String) -> Unit,
    @JsonNotNull
    open var isBlurMask: Boolean = false,
    @JsonNotNull
    open var height: Number,
    @JsonNotNull
    open var width: Number,
    @JsonNotNull
    open var clickMaskClose: Boolean = false,
    @JsonNotNull
    open var showCancel: Boolean = false,
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
val defaultConfig = X_MODAL_TYPE_PRIVATE(title = "提醒", content = "", contentAlign = "center", cancelText = "取消", cancelColor = "#333", cancelBgColor = "#f5f5f5", confirmText = "确认", confirmBgColor = "#0579FF", confirmColor = "#FFF", titleColor = "#000000", contentColor = "#333333", linkFontColor = "rgb(5, 121, 255)", radius = 16, confirmIcon = "", cancelIcon = "", isSplitBtn = true, contentBgColor = "#fff", maskBgColor = "rgba(0,0,0,0.6)", confirm = fun(){}, cancel = fun(){}, close = fun(){}, clickLink = fun(href: String){}, isBlurMask = true, height = 80, width = 320, clickMaskClose = true, showCancel = true)
val configCover = fun(opts: X_MODAL_TYPE): X_MODAL_TYPE_PRIVATE {
    var title = if (opts.title == null) {
        defaultConfig.title
    } else {
        opts.title!!
    }
    var content = if (opts.content == null) {
        defaultConfig.content
    } else {
        opts.content!!
    }
    var cancelText = if (opts.cancelText == null) {
        defaultConfig.cancelText
    } else {
        opts.cancelText!!
    }
    var cancelBgColor = if (opts.cancelBgColor == null) {
        defaultConfig.cancelBgColor
    } else {
        opts.cancelBgColor!!
    }
    var cancelColor = if (opts.cancelColor == null) {
        defaultConfig.cancelColor
    } else {
        opts.cancelColor!!
    }
    var confirmText = if (opts.confirmText == null) {
        defaultConfig.confirmText
    } else {
        opts.confirmText!!
    }
    var confirmBgColor = if (opts.confirmBgColor == null) {
        defaultConfig.confirmBgColor
    } else {
        opts.confirmBgColor!!
    }
    var confirmColor = if (opts.confirmColor == null) {
        defaultConfig.confirmColor
    } else {
        opts.confirmColor!!
    }
    var radius = if (opts.radius == null) {
        defaultConfig.radius
    } else {
        opts.radius!!
    }
    var confirmIcon = if (opts.confirmIcon == null) {
        defaultConfig.confirmIcon
    } else {
        opts.confirmIcon!!
    }
    var cancelIcon = if (opts.cancelIcon == null) {
        defaultConfig.cancelIcon
    } else {
        opts.cancelIcon!!
    }
    var contentBgColor = if (opts.contentBgColor == null) {
        defaultConfig.contentBgColor
    } else {
        opts.contentBgColor!!
    }
    var maskBgColor = if (opts.maskBgColor == null) {
        defaultConfig.maskBgColor
    } else {
        opts.maskBgColor!!
    }
    var confirm = if (opts.confirm == null) {
        defaultConfig.confirm
    } else {
        opts.confirm!!
    }
    var cancel = if (opts.cancel == null) {
        defaultConfig.cancel
    } else {
        opts.cancel!!
    }
    var close = if (opts.close == null) {
        defaultConfig.close
    } else {
        opts.close!!
    }
    var height = if (opts.height == null) {
        defaultConfig.height
    } else {
        opts.height!!
    }
    var width = if (opts.width == null) {
        defaultConfig.width
    } else {
        opts.width!!
    }
    var titleColor = if (opts.titleColor == null) {
        defaultConfig.titleColor
    } else {
        opts.titleColor!!
    }
    var contentColor = if (opts.contentColor == null) {
        defaultConfig.contentColor
    } else {
        opts.contentColor!!
    }
    var contentAlign = if (opts.contentAlign == null) {
        defaultConfig.contentAlign
    } else {
        opts.contentAlign!!
    }
    var clickLink = if (opts.clickLink == null) {
        defaultConfig.clickLink
    } else {
        opts.clickLink!!
    }
    var linkFontColor = if (opts.linkFontColor == null) {
        defaultConfig.linkFontColor
    } else {
        opts.linkFontColor!!
    }
    var clickMaskClose = if (opts.clickMaskClose == null) {
        defaultConfig.clickMaskClose
    } else {
        opts.clickMaskClose!!
    }
    var showCancel = if (opts.showCancel == null) {
        defaultConfig.showCancel
    } else {
        opts.showCancel!!
    }
    var isBlurMask = if (opts.isBlurMask == null) {
        defaultConfig.isBlurMask
    } else {
        opts.isBlurMask!!
    }
    var isSplitBtn = if (opts.isSplitBtn == null) {
        defaultConfig.isSplitBtn
    } else {
        opts.isSplitBtn!!
    }
    return X_MODAL_TYPE_PRIVATE(title = title, content = content, cancelText = cancelText, cancelBgColor = cancelBgColor, cancelColor = cancelColor, confirmText = confirmText, confirmBgColor = confirmBgColor, confirmColor = confirmColor, linkFontColor = linkFontColor, radius = radius, confirmIcon = confirmIcon, cancelIcon = cancelIcon, isSplitBtn = isSplitBtn, contentBgColor = contentBgColor, maskBgColor = maskBgColor, confirm = confirm, cancel = cancel, close = close, clickLink = clickLink, isBlurMask = isBlurMask, height = height, width = width, clickMaskClose = clickMaskClose, showCancel = showCancel, titleColor = titleColor, contentColor = contentColor, contentAlign = contentAlign)
}
var masker: RelativeLayout? = null
var contentDom: LinearLayout? = null
var maskDomId: Number = 586
var tid: Number = 0
var isClsoing = false
fun px2dp(n: Number): Number {
    val mets = UTSAndroid.getAppContext()!!.resources!!.getDisplayMetrics()
    return mets.density * n
}
var dialogModal: FullScreenDialogFragment? = null
open class FullScreenDialogFragment : Dialog {
    private var mContext: Context
    private var opts: X_MODAL_TYPE
    constructor(context: Context, optsOwer: X_MODAL_TYPE) : super(context, R.style.Theme_Translucent_NoTitleBar_Fullscreen) {
        this.mContext = context
        this.opts = optsOwer
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
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
        _createModalView(this.getContext(), this.window!!.decorView!! as ViewGroup, this.opts)
    }
    override fun dismiss() {
        super.dismiss()
        contentDom = null
        isClsoing = false
        dialogModal = null
    }
}
fun close(call: () -> Unit, isClose: Boolean) {
    UTSAndroid.getDispatcher("main").async(fun(_) {
        if (!isClose) {
            return
        }
        var mk = masker
        if (mk != null) {
            clearTimeout(tid)
            try {
                var s0 = 0.toFloat()
                var s1 = 0.toFloat()
                val maskAni = mk.animate() as ViewPropertyAnimator
                maskAni.alpha(s1).setDuration(300).setInterpolator(AccelerateDecelerateInterpolator()).start()
                if (contentDom != null) {
                    var ani = contentDom!!.animate() as ViewPropertyAnimator
                    ani.alpha(s0).scaleX(s1).scaleY(s1).setDuration(300).setInterpolator(AccelerateDecelerateInterpolator()).start()
                    tid = setTimeout(fun() {
                        isClsoing = false
                        dialogModal?.dismiss()
                    }, 300)
                } else {
                    isClsoing = false
                    dialogModal?.dismiss()
                }
            }
            catch (e: Throwable) {}
            call()
        }
    }
        , null)
}
fun rgbToColorNumber(rgba: RGBA): Int {
    return Color.argb((rgba.a * 255).toInt(), rgba!!.r.toInt(), rgba!!.g.toInt(), rgba!!.b.toInt())
}
fun _clickLinksRender(contextText: TextView, config: X_MODAL_TYPE_PRIVATE) {
    val spanned = Html.fromHtml(config.content, Html.FROM_HTML_MODE_LEGACY)
    val spannableString = SpannableString(spanned)
    fun addLinksClick() {
        val urlSpans = spanned.getSpans(0, spanned.length, URLSpan::class.java)
        for(item in resolveUTSKeyIterator(urlSpans)){
            val urlSpan = item as URLSpan
            val start = spanned.getSpanStart(urlSpan)
            val end = spanned.getSpanEnd(urlSpan)
            open class clickableSpan : ClickableSpan {
                constructor() : super() {}
                override fun onClick(wv: View) {
                    val url: String = urlSpan.getURL()
                    config.clickLink(url)
                    console.log(url)
                }
                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.setColor(rgbToColorNumber(hexToRgb(config.linkFontColor)!!))
                    ds.setUnderlineText(true)
                }
            }
            spannableString.setSpan(clickableSpan(), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            spannableString.removeSpan(urlSpan)
        }
    }
    addLinksClick()
    contextText.setText(spannableString)
    contextText.setMovementMethod(LinkMovementMethod())
}
fun _createModalView(context: Context, decorView: ViewGroup, opts: X_MODAL_TYPE) {
    var config = configCover(opts)
    var titleHeight: Number = 60
    var contentHeight = config.height
    var width = config.width
    var height = config.height
    if (isClsoing) {
        return
    }
    var maskBgColorRgb = rgbToColorNumber(hexToRgb(config.maskBgColor)!!)
    var cancelColorRgb = rgbToColorNumber(hexToRgb(config.cancelColor)!!)
    var cancelBgColorRgb = rgbToColorNumber(hexToRgb(config.cancelBgColor)!!)
    var confirmBgColorRgb = rgbToColorNumber(hexToRgb(config.confirmBgColor)!!)
    var confirmColorRgb = rgbToColorNumber(hexToRgb(config.confirmColor)!!)
    var contentBgColorRgb = rgbToColorNumber(hexToRgb(config.contentBgColor)!!)
    var contentColorColorRgb = rgbToColorNumber(hexToRgb(config.contentColor)!!)
    var titleColorColorRgb = rgbToColorNumber(hexToRgb(config.titleColor)!!)
    var maskerDom = RelativeLayout(context)
    var maskerDomLayrPrams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    maskerDom.setLayoutParams(maskerDomLayrPrams)
    maskerDom.setBackgroundColor(maskBgColorRgb)
    maskerDom.setGravity(Gravity.CENTER)
    maskerDom.setId(maskDomId.toInt())
    maskerDom.setAlpha(0.toFloat())
    var container = LinearLayout(context)
    contentDom = container
    container.setOrientation(LinearLayout.VERTICAL)
    container.setGravity(Gravity.CENTER)
    var bg = GradientDrawable()
    bg.setColor(contentBgColorRgb)
    bg.setCornerRadius(px2dp(16).toFloat())
    container.setClipToOutline(true)
    container.setBackground(bg)
    var wpx = px2dp(config.width).toInt()
    container.setLayoutParams(LinearLayout.LayoutParams(wpx, ViewGroup.LayoutParams.WRAP_CONTENT))
    var defaultNumScale = 0.toFloat()
    container.setAlpha(defaultNumScale)
    container.setScaleX(defaultNumScale)
    container.setScaleY(defaultNumScale)
    var titleDiv = TextView(context)
    var titleDivheight = px2dp(titleHeight).toInt()
    titleDiv.setLayoutParams(LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, titleDivheight))
    titleDiv.setGravity(Gravity.CENTER)
    titleDiv.setTextSize(18.0.toFloat())
    titleDiv.setTextColor(titleColorColorRgb)
    titleDiv.setText(config.title)
    var content = ScrollView(context)
    var contentDivheight = px2dp(contentHeight).toInt()
    content.setLayoutParams(LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, contentDivheight))
    var contextText = TextView(context)
    if (config.contentAlign == "center") {
        contextText.setLayoutParams(LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        contextText.setGravity(Gravity.CENTER)
        contextText.setMinHeight(contentDivheight)
    } else {
        contextText.setLayoutParams(LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
    }
    contextText.setTextSize(15.0.toFloat())
    contextText.setTextColor(contentColorColorRgb)
    _clickLinksRender(contextText, config)
    var contentPadding = px2dp(16).toInt()
    contextText.setPadding(contentPadding, 0, contentPadding, 0)
    var footerDiv = LinearLayout(context)
    footerDiv.setOrientation(LinearLayout.HORIZONTAL)
    footerDiv.setLayoutParams(LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
    var footerDivPadding = px2dp(16).toInt()
    if (config.isSplitBtn) {
        footerDiv.setPadding(footerDivPadding, footerDivPadding, contentPadding, footerDivPadding)
    } else {
        footerDiv.setPadding(0, footerDivPadding, 0, 0)
    }
    var btnheight = px2dp(50).toInt()
    var cancelBtnBG = GradientDrawable()
    cancelBtnBG.setColor(cancelBgColorRgb)
    if (config.isSplitBtn) {
        cancelBtnBG.setCornerRadius(px2dp(50).toFloat())
    }
    var confirmBtnBG = GradientDrawable()
    confirmBtnBG.setColor(confirmBgColorRgb)
    if (config.isSplitBtn) {
        confirmBtnBG.setCornerRadius(px2dp(50).toFloat())
    }
    var cancelDiv = TextView(context)
    cancelDiv.setLayoutParams(LinearLayout.LayoutParams(0, btnheight, 1.toFloat()))
    cancelDiv.setTextSize(16.0.toFloat())
    cancelDiv.setTextColor(cancelColorRgb)
    cancelDiv.setGravity(Gravity.CENTER)
    cancelDiv.setBackground(cancelBtnBG)
    if (config.showCancel) {
        if (config.cancelIcon != "") {
            var assetManager = context!!.getAssets()
            var typeface = Typeface.createFromAsset(assetManager, "remixicon.ttf")
            cancelDiv.setTypeface(typeface)
            if (!TextUtils.isEmpty(config.cancelIcon)) {
                var codePoint = Integer.parseInt(config.cancelIcon, 16)
                var charArray = Character.toChars(codePoint)
                var text = String(charArray)
                var str = if (config.cancelText != "") {
                    (" " + config.cancelText)
                } else {
                    config.cancelText
                }
                cancelDiv.setText(text + str)
            }
        } else {
            cancelDiv.setText(config.cancelText)
        }
    }
    var confirmDiv = TextView(context)
    confirmDiv.setLayoutParams(LinearLayout.LayoutParams(0, btnheight, 1.toFloat()))
    confirmDiv.setTextSize(16.0.toFloat())
    confirmDiv.setTextColor(confirmColorRgb)
    confirmDiv.setGravity(Gravity.CENTER)
    confirmDiv.setBackground(confirmBtnBG)
    if (config.confirmIcon != "") {
        var assetManager = context!!.getAssets()
        var typeface = Typeface.createFromAsset(assetManager, "remixicon.ttf")
        confirmDiv.setTypeface(typeface)
        if (!TextUtils.isEmpty(config.confirmIcon)) {
            var codePoint = Integer.parseInt(config.confirmIcon, 16)
            var charArray = Character.toChars(codePoint)
            var text = String(charArray)
            var str = if (config.confirmText != "") {
                (" " + config.confirmText)
            } else {
                config.confirmText
            }
            confirmDiv.setText(text + str)
        }
    } else {
        confirmDiv.setText(config.confirmText)
    }
    var confirmDivPadding = px2dp(16).toInt()
    var spaceDiv = TextView(context)
    spaceDiv.setLayoutParams(LinearLayout.LayoutParams(confirmDivPadding, btnheight))
    open class MaskerDomClickListsner : View.OnTouchListener {
        open var firstX: Number = 0
        open var firstY: Number = 0
        open var type = ""
        constructor(type: String) : super() {
            this.type = type
        }
        override fun onTouch(view: View, event: MotionEvent): Boolean {
            var action = event.getAction()
            var t = this
            if (action == MotionEvent.ACTION_DOWN) {
                this.firstX = event.getX()
                this.firstY = event.getY()
            }
            if (action == MotionEvent.ACTION_UP) {
                if (event.getDownTime() - event.getEventTime() < 300) {
                    if (Math.abs(event.getX() - this.firstX) < 10 && Math.abs(event.getY() - this.firstY) < 10 && !isClsoing) {
                        isClsoing = true
                        close(fun(){
                            if (t.type == "cancel") {
                                config.cancel()
                                config.close()
                            }
                            if (t.type == "confirm") {
                                config.confirm()
                                config.close()
                            }
                            if (t.type == "mask") {
                                config.close()
                            }
                        }
                            , (t.type == "mask" && config.clickMaskClose) || t.type != "mask")
                    }
                }
            }
            return true
        }
    }
    maskerDom.setOnTouchListener(MaskerDomClickListsner("mask"))
    open class containerDomClickListsner : View.OnTouchListener {
        constructor() : super() {}
        override fun onTouch(view: View, event: MotionEvent): Boolean {
            return true
        }
    }
    container.setOnTouchListener(containerDomClickListsner())
    cancelDiv.setOnTouchListener(MaskerDomClickListsner("cancel"))
    confirmDiv.setOnTouchListener(MaskerDomClickListsner("confirm"))
    if (config.showCancel) {
        footerDiv.addView(cancelDiv)
    }
    if (config.isSplitBtn && config.showCancel) {
        footerDiv.addView(spaceDiv)
    }
    footerDiv.addView(confirmDiv)
    content.addView(contextText)
    container.addView(titleDiv)
    container.addView(content)
    container.addView(footerDiv)
    maskerDom.addView(container)
    decorView.addView(maskerDom!!)
    try {
        var s0 = 0.toFloat()
        var s1 = 1.toFloat()
        container.setAlpha(s0)
        container.setScaleX(s0)
        container.setScaleY(s0)
        val maskAni = maskerDom.animate() as ViewPropertyAnimator
        maskAni.alpha(s1).setDuration(350).setInterpolator(AccelerateDecelerateInterpolator()).start()
        var ani = container.animate() as ViewPropertyAnimator
        ani.alpha(s1).scaleX(s1).scaleY(s1).setDuration(350).setInterpolator(AccelerateDecelerateInterpolator()).start()
    }
    catch (e: Throwable) {
        console.error(e)
    }
    masker = maskerDom
}
fun _showModal_(opts: X_MODAL_TYPE) {
    UTSAndroid.getDispatcher("main").async(fun(_) {
        dialogModal = FullScreenDialogFragment(UTSAndroid.getUniActivity()!!, opts)
        dialogModal?.show()
    }
        , null)
}
fun showModal(opts: X_MODAL_TYPE) {
    dialogModal?.dismiss()
    val pages = getCurrentPages()
    if (pages.length > 0) {
        val page = pages[pages.length - 1].vm!!
        val instance = page.`$`
        if (page.`$isReady`) {
            _showModal_(opts)
        }
        onUnload(fun(){
            close(fun(){}, true)
        }, instance)
    } else {
        _showModal_(opts)
    }
}
