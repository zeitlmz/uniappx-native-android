@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI511F0A5
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenUniModulesTmxUiComponentsXOverlayXOverlay : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            var t = this
            fun oninitready() {
                var sys = uni_getWindowInfo()
                t._width = sys.windowWidth
                t._height = sys.windowHeight + 44
                if (t._show) {
                    t.showAlert()
                }
            }
            oninitready()
        }
        , __ins)
        onBeforeUnmount(fun() {
            this.tw.destroy()
            clearTimeout(this.tid)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.show
        }
        , fun(_newval: Boolean) {
            if (_newval) {
                this.showAlert()
            } else {
                this.closeAlert()
            }
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        return createElementVNode("view", null, utsArrayOf(
            createElementVNode("view", utsMapOf("onClick" to _ctx.openOverlay), utsArrayOf(
                renderSlot(_ctx.`$slots`, "trigger", utsMapOf("show" to _ctx.show))
            ), 8, utsArrayOf(
                "onClick"
            )),
            if (isTrue(_ctx.showOverflay)) {
                createElementVNode("view", utsMapOf("key" to 0, "id" to _ctx.id, "ref" to "xoverflay", "class" to "xoverflay", "style" to normalizeStyle(utsArrayOf(
                    utsMapOf("width" to "100%", "height" to _ctx.__height, "top" to (_ctx.windtop + "px"), "zIndex" to _ctx.zIndex)
                ))), utsArrayOf(
                    createElementVNode("view", utsMapOf("onClick" to withModifiers(_ctx.onClickOverflowy, utsArrayOf(
                        "stop"
                    )), "class" to normalizeClass(utsArrayOf(
                        utsArrayOf(
                            if (_ctx.status == "open") {
                                "xoverflayMaskShow"
                            } else {
                                ""
                            },
                            if (_ctx.status == "close") {
                                "xoverflayMaskHide"
                            } else {
                                ""
                            }
                        ),
                        "xoverflayWrapBoxContent"
                    )), "style" to normalizeStyle(_ctx._customStyle)), utsArrayOf(
                        createElementVNode("view", utsMapOf("ref" to "xoverflayWrapBox", "class" to normalizeClass(utsArrayOf(
                            utsArrayOf(
                                if (_ctx.status == "open") {
                                    "xoverflayShow"
                                } else {
                                    ""
                                },
                                if (_ctx.status == "close") {
                                    "xoverflayHide"
                                } else {
                                    ""
                                }
                            ),
                            "xoverflayWrapBox"
                        )), "onClick" to withModifiers(fun(){}, utsArrayOf(
                            "stop"
                        )), "style" to normalizeStyle(_ctx._customContentStyle)), utsArrayOf(
                            renderSlot(_ctx.`$slots`, "default"),
                            if (isTrue(_ctx._showClose)) {
                                createElementVNode("view", utsMapOf("key" to 0, "class" to "closeOverBtn"), utsArrayOf(
                                    createVNode(_component_x_icon, utsMapOf("onClick" to _ctx.closeAlert, "color" to "white", "font-size" to "38", "name" to "close-circle-fill"), null, 8, utsArrayOf(
                                        "onClick"
                                    ))
                                ))
                            } else {
                                createCommentVNode("v-if", true)
                            }
                        ), 14, utsArrayOf(
                            "onClick"
                        ))
                    ), 14, utsArrayOf(
                        "onClick"
                    ))
                ), 12, utsArrayOf(
                    "id"
                ))
            } else {
                createCommentVNode("v-if", true)
            }
        ))
    }
    open var customStyle: String by `$props`
    open var customContentStyle: String by `$props`
    open var showClose: Boolean by `$props`
    open var overlayClick: Boolean by `$props`
    open var disabledAni: Boolean by `$props`
    open var show: Boolean by `$props`
    open var duration: Number by `$props`
    open var watiDuration: Number by `$props`
    open var zIndex: Number by `$props`
    open var _width: Number by `$data`
    open var _height: Number by `$data`
    open var showOverflay: Boolean by `$data`
    open var element: Element? by `$data`
    open var actioning: Boolean by `$data`
    open var status: String by `$data`
    open var id: Any? by `$data`
    open var tid: Number by `$data`
    open var windtop: Number by `$data`
    open var isOpenedDefault: Boolean by `$data`
    open var xani: xAnimate? by `$data`
    open var tw: xTween by `$data`
    open var _customStyle: String by `$data`
    open var _customContentStyle: String by `$data`
    open var _show: Boolean by `$data`
    open var _showClose: Boolean by `$data`
    open var _duration: Number by `$data`
    open var _animationFun: String by `$data`
    open var __height: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("_width" to 0, "_height" to 0, "showOverflay" to false, "element" to null as Element?, "actioning" to false, "status" to "", "id" to ("xoverflay" + getUid()), "tid" to 0, "windtop" to 0, "isOpenedDefault" to false, "xani" to null as xAnimate?, "tw" to xTween(), "_customStyle" to computed<String>(fun(): String {
            return this.customStyle
        }
        ), "_customContentStyle" to computed<String>(fun(): String {
            return this.customContentStyle
        }
        ), "_show" to computed<Boolean>(fun(): Boolean {
            return this.show
        }
        ), "_showClose" to computed<Boolean>(fun(): Boolean {
            return this.showClose
        }
        ), "_duration" to computed<Number>(fun(): Number {
            return this.duration
        }
        ), "_animationFun" to computed<String>(fun(): String {
            return xConfig.animationFun
        }
        ), "__height" to computed<String>(fun(): String {
            var h = "100%"
            return h
        }
        ))
    }
    open var overflayMoveTouch = ::gen_overflayMoveTouch_fn
    open fun gen_overflayMoveTouch_fn(evt: UniTouchEvent) {
        evt.preventDefault()
    }
    open var onClickOverflowy = ::gen_onClickOverflowy_fn
    open fun gen_onClickOverflowy_fn() {
        this.`$emit`("click")
        if (!this.overlayClick) {
            if (!this.disabledAni) {
                var el = this.`$refs`["xoverflayWrapBox"] as UniElement?
                if (this.xani != null) {
                    this.xani!!.stop()
                }
                if (el != null) {
                    this.xani = xAnimate(el!!, XANIMATE_OPIONS(duration = 50, isDescPlay = true))
                    this.xani!!.attr("scale", "1", "0.95", false)
                    this.xani!!.attr("scale", "0.95", "1.05", false)
                    this.xani!!.attr("scale", "1.05", "1", false).play()
                }
            }
            return
        }
        this.closeAlert()
    }
    open var closeAlert = ::gen_closeAlert_fn
    open fun gen_closeAlert_fn() {
        var _this = this
        _this.tw.startRender()
        if (this.actioning) {
            return
        }
        if (this.status == "close") {
            return
        }
        this.actioning = true
        this.status = "close"
        this.`$emit`("beforeClose")
        var element = _this.`$refs`["xoverflay"] as UniElement
        var elementBody = _this.`$refs`["xoverflayWrapBox"] as UniElement
        _this.tw.stop()
        _this.tw.removeAnimate()
        _this.tw.addAnimate(xTweenAnimate(duration = _this.duration, ease = "linear", enter = fun(item: xTweenEventCallFunType){
            element.style.setProperty("background-color", "rgba(0,0,0," + Math.max(0, ((1 - item.progress) * 0.4)) + ")")
        }
        , complete = fun(item: xTweenEventCallFunType){
            element.style.setProperty("background-color", "rgba(0,0,0,0)")
        }
        ))
        _this.tw.addAnimate(xTweenAnimate(duration = _this.duration, ease = "tmxEase", enter = fun(item: xTweenEventCallFunType){
            elementBody.style.setProperty("opacity", "" + (1 - item.progress))
            elementBody.style.setProperty("transform", "scale(" + (1 - item.progress) + ")")
        }
        , complete = fun(item: xTweenEventCallFunType){
            _this.actioning = false
            _this.`$emit`("close")
            _this.`$emit`("update:show", false)
            _this.showOverflay = false
            _this.tw.destroy()
        }
        ))
        _this.tw.play()
    }
    open var showAlert = ::gen_showAlert_fn
    open fun gen_showAlert_fn() {
        var _this = this
        _this.tw.startRender()
        if (this.actioning) {
            return
        }
        if (this.status == "open") {
            return
        }
        this.showOverflay = true
        this.actioning = true
        this.status = "open"
        this.`$emit`("beforeOpen")
        clearTimeout(this.tid)
        this.tid = setTimeout(fun() {
            var element = _this.`$refs`["xoverflay"] as UniElement
            var elementBody = _this.`$refs`["xoverflayWrapBox"] as UniElement
            _this.tw.stop()
            _this.tw.removeAnimate()
            _this.tw.addAnimate(xTweenAnimate(duration = _this.duration, ease = "linear", enter = fun(item: xTweenEventCallFunType){
                element.style.setProperty("background-color", "rgba(0,0,0," + Math.min(0.4, item.progress) + ")")
            }
            , complete = fun(item: xTweenEventCallFunType){
                _this.actioning = false
                _this.`$emit`("open")
            }
            ))
            _this.tw.addAnimate(xTweenAnimate(duration = _this.duration, ease = "tmxEase", enter = fun(item: xTweenEventCallFunType){
                elementBody.style.setProperty("opacity", "" + item.progress)
                elementBody.style.setProperty("transform", "scale(" + item.progress + ")")
            }
            , complete = fun(item: xTweenEventCallFunType){
                elementBody.style.setProperty("opacity", "" + 1)
                elementBody.style.setProperty("transform", "scale(" + 1 + ")")
                _this.tw.destroy()
            }
            ))
            _this.tw.play()
        }
        , 50)
    }
    open var openOverlay = ::gen_openOverlay_fn
    open fun gen_openOverlay_fn() {
        this.showAlert()
    }
    open var wrapClick = ::gen_wrapClick_fn
    open fun gen_wrapClick_fn(evt: UniPointerEvent) {}
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xoverflayWrapBox" to padStyleMapOf(utsMapOf("pointerEvents" to "auto", "transform" to "scale(0)", "opacity" to 0)), "closeOverBtn" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "marginTop" to "32rpx", "zIndex" to 105, "opacity" to 0.7)), "xoverflayWrapBoxMasker" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100%", "left" to 0, "top" to 0, "position" to "absolute", "zIndex" to 1)), "xoverflayWrapBoxContent" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100%", "left" to 0, "top" to 0, "position" to "absolute", "zIndex" to 3)), "xoverflay" to padStyleMapOf(utsMapOf("backgroundColor" to "rgba(0,0,0,0)", "position" to "fixed", "left" to 0, "top" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("click" to null, "close" to null, "open" to null, "beforeOpen" to null, "beforeClose" to null, "update:show" to null)
        var props = normalizePropsOptions(utsMapOf("customStyle" to utsMapOf("type" to "String", "default" to ""), "customContentStyle" to utsMapOf("type" to "String", "default" to ""), "showClose" to utsMapOf("type" to "Boolean", "default" to false), "overlayClick" to utsMapOf("type" to "Boolean", "default" to true), "disabledAni" to utsMapOf("type" to "Boolean", "default" to false), "show" to utsMapOf("type" to "Boolean", "default" to false), "duration" to utsMapOf("type" to "Number", "default" to 300), "watiDuration" to utsMapOf("type" to "Number", "default" to 120), "zIndex" to utsMapOf("type" to "Number", "default" to 1100)))
        var propsNeedCastKeys = utsArrayOf(
            "customStyle",
            "customContentStyle",
            "showClose",
            "overlayClick",
            "disabledAni",
            "show",
            "duration",
            "watiDuration",
            "zIndex"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
