@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI09580B7
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
open class GenUniModulesTmxUiComponentsXIconXIcon : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onBeforeUnmount(fun() {
            this.isdestory = true
            clearTimeout(this.tid)
            this.xt.destroy()
        }
        , __ins)
        onMounted(fun() {
            this.loadFontByX()
            this.isdestory = false
            var t = this
            if (this._spin) {
                t.playSpin()
            } else {
                this.`$nextTick`(fun(){
                    this.setRadeg()
                }
                )
            }
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.spin
        }
        , fun() {
            if (this._spin) {
                this.playSpin()
            } else {
                this.xt.pause()
                this.xt.destroy()
            }
        }
        )
        this.`$watch`(fun(): Any? {
            return this.rotation
        }
        , fun() {
            if (this._spin) {
                return
            }
            this.setRadeg()
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return if (isTrue(!_ctx._isFileImg)) {
            createElementVNode("text", utsMapOf("key" to 0, "onClick" to _ctx.clickListen, "id" to _ctx.id, "ref" to "xIcons", "class" to normalizeClass(utsArrayOf(
                "face",
                utsArrayOf(
                    if (_ctx._spin) {
                        "faceSpinIcon"
                    } else {
                        ""
                    },
                    _ctx._mpcode
                )
            )), "style" to normalizeStyle(utsMapOf("font-family" to _ctx.fontFamily, "font-size" to _ctx._fontSize, "color" to _ctx._color, "width" to _ctx._fontSize, "height" to _ctx._fontSize, "lineHeight" to _ctx._fontSize))), toDisplayString(_ctx.iconName), 15, utsArrayOf(
                "onClick",
                "id"
            ))
        } else {
            createElementVNode("image", utsMapOf("key" to 1, "onClick" to _ctx.clickListen, "id" to _ctx.id, "ref" to "xIcons", "style" to normalizeStyle(utsMapOf("width" to _ctx._fontSize, "height" to _ctx._fontSize)), "src" to _ctx.iconName), null, 12, utsArrayOf(
                "onClick",
                "id",
                "src"
            ))
        }
    }
    open var name: String by `$props`
    open var fontSize: String by `$props`
    open var fontFamily: String by `$props`
    open var code: String by `$props`
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var spin: Boolean by `$props`
    open var rotation: Number by `$props`
    open var duration: Number by `$props`
    open var xIcon: Element? by `$data`
    open var refreshId: Number by `$data`
    open var id: Any? by `$data`
    open var element: Element? by `$data`
    open var rotationDeg: Number by `$data`
    open var isLoad: Boolean by `$data`
    open var isdestory: Boolean by `$data`
    open var status: String by `$data`
    open var tid: Number by `$data`
    open var xt: xTween by `$data`
    open var _iconName: String by `$data`
    open var _mpcode: String by `$data`
    open var iconName: String by `$data`
    open var _isFileImg: Boolean by `$data`
    open var _fontSize: String by `$data`
    open var _color: String by `$data`
    open var _spin: Boolean by `$data`
    open var _rotation: Number by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("xIcon" to null as Element?, "refreshId" to 1, "id" to ("xIconspin" + getUid()), "element" to null as Element?, "rotationDeg" to 0, "isLoad" to false, "isdestory" to false, "status" to "play", "tid" to 0, "xt" to xTween(), "_iconName" to computed<String>(fun(): String {
            return this.name
        }
        ), "_mpcode" to computed<String>(fun(): String {
            var cname = ""
            return cname
        }
        ), "iconName" to computed<String>(fun(): String {
            if (this._isFileImg) {
                return this.name
            }
            var texts = ""
            try {
                var codestr = ""
                if (this.code == "") {
                    codestr = fonts[this.name] as String
                } else {
                    codestr = this.code
                }
                var codePoint = Integer.parseInt(codestr, 16)
                var charArray = Character.toChars(codePoint)
                texts = String(charArray)
            }
             catch (e: Throwable) {
                console.error("xicon解析失败。", e)
            }
            return texts
        }
        ), "_isFileImg" to computed<Boolean>(fun(): Boolean {
            if (this.name.lastIndexOf(".") > -1 || this.name.indexOf("ftp:") > -1 || this.name.indexOf("https:") > -1 || this.name.indexOf("http:") > -1 || this.name.indexOf("data:image") > -1) {
                return true
            }
            return false
        }
        ), "_fontSize" to computed<String>(fun(): String {
            var fontSize = checkIsCssUnit(this.fontSize, xConfig.unit)
            if (xConfig.fontScale == 1) {
                return fontSize
            }
            var sizeNumber = parseInt(fontSize)
            if (isNaN(sizeNumber)) {
                sizeNumber = 16
            }
            return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
        }
        ), "_color" to computed<String>(fun(): String {
            var color = if (this.color == "") {
                "black"
            } else {
                this.color
            }
            if (xConfig.dark == "dark") {
                if (this.darkColor != "") {
                    color = this.darkColor!!
                    return getDefaultColor(color)
                }
                return setTextColorLightByDark(color)
            }
            return getDefaultColor(color)
        }
        ), "_spin" to computed<Boolean>(fun(): Boolean {
            return this.spin
        }
        ), "_rotation" to computed<Number>(fun(): Number {
            return this.rotation
        }
        ))
    }
    open var setRadeg = ::gen_setRadeg_fn
    open fun gen_setRadeg_fn() {
        try {
            this.element = this.`$refs`["xIcons"] as UniElement
            this.element!!.style.setProperty("transition-duration", this.duration.toString(10) + "ms")
            this.element!!.style.setProperty("transform", "rotate(" + this._rotation + "deg)")
        }
         catch (e: Throwable) {}
    }
    open var playSpin = ::gen_playSpin_fn
    open fun gen_playSpin_fn() {
        if (!this._spin || this.isdestory) {
            return
        }
        var element = this.`$refs`["xIcons"] as UniElement
        this.xt.pause()
        this.xt.destroy()
        this.xt.startRender()
        this.xt.addAnimate(xTweenAnimate(loop = -1, duration = this.duration, complete = fun(item: xTweenEventCallFunType){}, enter = fun(item: xTweenEventCallFunType){
            element!!.style.setProperty("transition-duration", "0ms")
            element!!.style.setProperty("transform", "rotate(" + 360 * item.progress + "deg)")
        }
        , pause = fun(item: xTweenEventCallFunType){}))
        this.xt.play()
    }
    open var clickListen = ::gen_clickListen_fn
    open fun gen_clickListen_fn() {
        this.`$emit`("click")
    }
    open var loadFontByX = ::gen_loadFontByX_fn
    open fun gen_loadFontByX_fn() {
        this.isLoad = true
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("face" to padStyleMapOf(utsMapOf("transitionProperty" to "transform", "transitionDuration" to "0ms", "transitionTimingFunction" to "linear", "transform" to "rotate(0deg)", "textAlign" to "center")), "@TRANSITION" to utsMapOf("face" to utsMapOf("property" to "transform", "duration" to "0ms", "timingFunction" to "linear")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("click" to null)
        var props = normalizePropsOptions(utsMapOf("name" to utsMapOf("type" to "String", "default" to "home-3-fill"), "fontSize" to utsMapOf("type" to "String", "default" to "16"), "fontFamily" to utsMapOf("type" to "String", "default" to "remixicon"), "code" to utsMapOf("type" to "String", "default" to ""), "color" to utsMapOf("type" to "String", "default" to "black"), "darkColor" to utsMapOf("type" to "String", "default" to ""), "spin" to utsMapOf("type" to "Boolean", "default" to false), "rotation" to utsMapOf("type" to "Number", "default" to 0), "duration" to utsMapOf("type" to "Number", "default" to 1500)))
        var propsNeedCastKeys = utsArrayOf(
            "name",
            "fontSize",
            "fontFamily",
            "code",
            "color",
            "darkColor",
            "spin",
            "rotation",
            "duration"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
