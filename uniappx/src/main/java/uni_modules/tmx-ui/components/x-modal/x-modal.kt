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
open class GenUniModulesTmxUiComponentsXModalXModal : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            var t = this
            fun oninitready() {
                var sys = uni_getWindowInfo()
                t._width = sys.windowWidth
                t._height = sys.windowHeight
                t.windtop = sys.windowTop
                if (t._show) {
                    t.showAlert()
                }
            }
            oninitready()
        }
        , __ins)
        onBeforeUnmount(fun() {
            if (this.xani != null) {
                this.xani!!.stop()
                this.xani = null
            }
            clearTimeout(this.tid)
            clearTimeout(this.tid2)
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
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
        val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass)
        return createElementVNode("view", null, utsArrayOf(
            createElementVNode("view", utsMapOf("onClick" to _ctx.openDrawer), utsArrayOf(
                renderSlot(_ctx.`$slots`, "trigger")
            ), 8, utsArrayOf(
                "onClick"
            )),
            if (isTrue(_ctx.showOverflay)) {
                createElementVNode("view", utsMapOf("key" to 0, "onClick" to _ctx.onClickOverflowy, "onTouchmove" to _ctx.maskerMove, "ref" to "xDrawerWrap", "id" to _ctx.id, "class" to "xDrawerWrap xDrawerWrap_center", "style" to normalizeStyle(utsArrayOf(
                    utsMapOf("top" to (_ctx.windtop + "px"), "zIndex" to _ctx.zIndex, "width" to "100%", "height" to _ctx.__height, "transition-timing-function" to _ctx._animationFun),
                    _ctx._customStyle
                ))), utsArrayOf(
                    createElementVNode("view", utsMapOf("onClick" to withModifiers(fun(){}, utsArrayOf(
                        "stop"
                    )), "ref" to "xDrawerWrapContent", "class" to "xDrawerWrapContent xDrawerWrapContent_center", "id" to _ctx.wrapId, "style" to normalizeStyle(utsMapOf("width" to _ctx._c_width, "height" to _ctx._c_height, "maxWidth" to "750px", "borderRadius" to _ctx._round, "maxHeight" to if (_ctx._maxHeight != "") {
                        _ctx._maxHeight
                    } else {
                        "100%"
                    }, "backgroundColor" to _ctx._bgColor, "transition-timing-function" to "cubic-bezier(0.07, 0.82, 0.17, 1.20)"))), utsArrayOf(
                        createElementVNode("view", utsMapOf("ref" to "xModalWrapBox", "class" to "xModalWrapBox", "style" to normalizeStyle(utsMapOf("borderRadius" to _ctx._round))), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "xDrawerXclose"), utsArrayOf(
                                if (isTrue(_ctx._showClose)) {
                                    createVNode(_component_x_icon, utsMapOf("key" to 0, "onClick" to _ctx.closeAlert, "color" to _ctx.closeColor, "dark-color" to _ctx.closeDarkColor, "font-size" to "21", "name" to _ctx._closeIcon), null, 8, utsArrayOf(
                                        "onClick",
                                        "color",
                                        "dark-color",
                                        "name"
                                    ))
                                } else {
                                    createCommentVNode("v-if", true)
                                }
                            )),
                            createElementVNode("view", null, utsArrayOf(
                                if (isTrue(_ctx._showTitle)) {
                                    createElementVNode("view", utsMapOf("key" to 0, "class" to "xDrawerTitleBox"), utsArrayOf(
                                        renderSlot(_ctx.`$slots`, "title", UTSJSONObject(), fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createVNode(_component_x_text, utsMapOf("font-size" to "17", "class" to "xDrawertitleBoxTitle"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        toDisplayString(_ctx._title)
                                                    )
                                                }), "_" to 1))
                                            )
                                        })
                                    ))
                                } else {
                                    createCommentVNode("v-if", true)
                                }
                            )),
                            if (isTrue(!_ctx._disabledScroll)) {
                                createElementVNode("scroll-view", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("flex" to "1")), "scroll-y" to true, "rebound" to false), utsArrayOf(
                                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("padding" to _ctx._contentPadding))), utsArrayOf(
                                        renderSlot(_ctx.`$slots`, "default")
                                    ), 4)
                                ), 4)
                            } else {
                                createCommentVNode("v-if", true)
                            },
                            if (isTrue(_ctx._disabledScroll)) {
                                createElementVNode("view", utsMapOf("key" to 1, "style" to normalizeStyle(utsMapOf("flex" to "1", "padding" to _ctx._contentPadding))), utsArrayOf(
                                    renderSlot(_ctx.`$slots`, "default")
                                ), 4)
                            } else {
                                createCommentVNode("v-if", true)
                            },
                            if (isTrue(_ctx.showFooter)) {
                                createElementVNode("view", utsMapOf("key" to 2, "class" to "xDrawerFooter", "style" to normalizeStyle(utsMapOf("backgroundColor" to _ctx._bgColor))), utsArrayOf(
                                    renderSlot(_ctx.`$slots`, "footer", UTSJSONObject(), fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            if (isTrue(_ctx._showCancel)) {
                                                createVNode(_component_x_button, utsMapOf("key" to 0, "disabled" to _ctx.isLoading, "color" to _ctx._btnColor, "onClick" to _ctx.cancelEvt, "skin" to "thin", "width" to "0px", "block" to true, "style" to normalizeStyle(utsMapOf("margin-right" to "16px", "flex" to "1"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        toDisplayString(_ctx._cancelText)
                                                    )
                                                }), "_" to 1), 8, utsArrayOf(
                                                    "disabled",
                                                    "color",
                                                    "onClick",
                                                    "style"
                                                ))
                                            } else {
                                                createCommentVNode("v-if", true)
                                            },
                                            createVNode(_component_x_button, utsMapOf("loading" to _ctx.isLoading, "color" to _ctx._btnColor, "onClick" to _ctx.confirmEvt, "width" to "0px", "block" to true, "style" to normalizeStyle(utsMapOf("flex" to "1"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    toDisplayString(_ctx._confirmText)
                                                )
                                            }), "_" to 1), 8, utsArrayOf(
                                                "loading",
                                                "color",
                                                "onClick",
                                                "style"
                                            ))
                                        )
                                    })
                                ), 4)
                            } else {
                                createCommentVNode("v-if", true)
                            }
                        ), 4)
                    ), 12, utsArrayOf(
                        "onClick",
                        "id"
                    ))
                ), 44, utsArrayOf(
                    "onClick",
                    "onTouchmove",
                    "id"
                ))
            } else {
                createCommentVNode("v-if", true)
            }
        ))
    }
    open var customStyle: String by `$props`
    open var title: String by `$props`
    open var showFooter: Boolean by `$props`
    open var showTitle: Boolean by `$props`
    open var showClose: Boolean by `$props`
    open var showCancel: Boolean by `$props`
    open var overlayClick: Boolean by `$props`
    open var show: Boolean by `$props`
    open var duration: Number by `$props`
    open var watiDuration: Number by `$props`
    open var cancelText: String by `$props`
    open var confirmText: String by `$props`
    open var round: String by `$props`
    open var width: String by `$props`
    open var height: String by `$props`
    open var maxHeight: String by `$props`
    open var disabledScroll: Boolean by `$props`
    open var bgColor: String by `$props`
    open var darkBgColor: String by `$props`
    open var zIndex: String by `$props`
    open var contentPadding: String by `$props`
    open var btnColor: String by `$props`
    open var beforeClose: callbackType1 by `$props`
    open var closeColor: String by `$props`
    open var closeDarkColor: String by `$props`
    open var _width: Number by `$data`
    open var _height: Number by `$data`
    open var showOverflay: Boolean by `$data`
    open var element: UniElement? by `$data`
    open var elementWrap: UniElement? by `$data`
    open var actioning: Boolean by `$data`
    open var status: String by `$data`
    open var id: Any? by `$data`
    open var wrapId: Any? by `$data`
    open var first: Boolean by `$data`
    open var tid: Number by `$data`
    open var tid2: Number by `$data`
    open var windtop: Number by `$data`
    open var xani: xAnimate? by `$data`
    open var isOpenedDefault: Boolean by `$data`
    open var isLoading: Boolean by `$data`
    open var _customStyle: String by `$data`
    open var _show: Boolean by `$data`
    open var _disabledScroll: Boolean by `$data`
    open var _showClose: Boolean by `$data`
    open var _duration: Number by `$data`
    open var _title: String by `$data`
    open var _showTitle: Boolean by `$data`
    open var _round: String by `$data`
    open var _c_width: String by `$data`
    open var _c_height: String by `$data`
    open var _showFooter: Boolean by `$data`
    open var _maxHeight: String by `$data`
    open var _contentPadding: String by `$data`
    open var _showCancel: Boolean by `$data`
    open var _cancelText: String by `$data`
    open var _confirmText: String by `$data`
    open var _animationFun: String by `$data`
    open var __height: String by `$data`
    open var _bgColor: String by `$data`
    open var _btnColor: String by `$data`
    open var _closeIcon: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("_width" to 0, "_height" to 0, "showOverflay" to false, "element" to null as UniElement?, "elementWrap" to null as UniElement?, "actioning" to false, "status" to "", "id" to ("xModal" + getUid()), "wrapId" to ("xModal" + getUid()), "first" to true, "tid" to 0, "tid2" to 34, "windtop" to 0, "xani" to null as xAnimate?, "isOpenedDefault" to false, "isLoading" to false, "_customStyle" to computed<String>(fun(): String {
            return this.customStyle
        }
        ), "_show" to computed<Boolean>(fun(): Boolean {
            return this.show
        }
        ), "_disabledScroll" to computed<Boolean>(fun(): Boolean {
            return this.disabledScroll || this._c_height == "auto"
        }
        ), "_showClose" to computed<Boolean>(fun(): Boolean {
            return this.showClose
        }
        ), "_duration" to computed<Number>(fun(): Number {
            return this.duration
        }
        ), "_title" to computed<String>(fun(): String {
            return this.title
        }
        ), "_showTitle" to computed<Boolean>(fun(): Boolean {
            return this.showTitle
        }
        ), "_round" to computed<String>(fun(): String {
            if (this.round == "") {
                return checkIsCssUnit(xConfig.modalRadius, xConfig.unit)
            }
            return checkIsCssUnit(this.round, xConfig.unit)
        }
        ), "_c_width" to computed<String>(fun(): String {
            return checkIsCssUnit(this.width, xConfig.unit)
        }
        ), "_c_height" to computed<String>(fun(): String {
            return checkIsCssUnit(this.height, xConfig.unit)
        }
        ), "_showFooter" to computed<Boolean>(fun(): Boolean {
            return this.showFooter
        }
        ), "_maxHeight" to computed<String>(fun(): String {
            return checkIsCssUnit(this.maxHeight, xConfig.unit)
        }
        ), "_contentPadding" to computed<String>(fun(): String {
            return "0px " + checkIsCssUnit(this.contentPadding, xConfig.unit)
        }
        ), "_showCancel" to computed<Boolean>(fun(): Boolean {
            return this.showCancel
        }
        ), "_cancelText" to computed<String>(fun(): String {
            return this.cancelText
        }
        ), "_confirmText" to computed<String>(fun(): String {
            return this.confirmText
        }
        ), "_animationFun" to computed<String>(fun(): String {
            return xConfig.animationFun
        }
        ), "__height" to computed<String>(fun(): String {
            var h = "100%"
            return h
        }
        ), "_bgColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                if (this.darkBgColor != "") {
                    return getDefaultColor(this.darkBgColor)
                }
                return getDefaultColor(xConfig.sheetDarkColor)
            }
            return getDefaultColor(this.bgColor)
        }
        ), "_btnColor" to computed<String>(fun(): String {
            if (this.btnColor == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.btnColor)
        }
        ), "_closeIcon" to computed<String>(fun(): String {
            return xConfig.closeIcon
        }
        ))
    }
    open var overflayMoveTouch = ::gen_overflayMoveTouch_fn
    open fun gen_overflayMoveTouch_fn(evt: TouchEvent) {
        evt.preventDefault()
    }
    open var cancelEvt = ::gen_cancelEvt_fn
    open fun gen_cancelEvt_fn() {
        this.`$emit`("cancel")
        this.closeAlert()
    }
    open var confirmEvt = ::gen_confirmEvt_fn
    open fun gen_confirmEvt_fn(): UTSPromise<Any> {
        return wrapUTSPromise(suspend w@{
                this.isLoading = true
                var isCanClose = await(this.beforeClose())
                this.isLoading = false
                if (!isCanClose) {
                    return@w UTSPromise.resolve(true)
                }
                this.`$emit`("confirm")
                this.closeAlert()
                return@w UTSPromise.resolve(false)
        })
    }
    open var onClickOverflowy = ::gen_onClickOverflowy_fn
    open fun gen_onClickOverflowy_fn(evt: Event) {
        evt.stopPropagation()
        this.`$emit`("click")
        if (this.isLoading) {
            return
        }
        if (!this.overlayClick) {
            var el = this.`$refs`["xModalWrapBox"] as UniElement?
            if (this.xani != null) {
                this.xani!!.stop()
                this.xani = null
            }
            if (el != null) {
                var t = this
                t.xani = xAnimate(el!!, XANIMATE_OPIONS(duration = 100, isDescPlay = true))
                t.xani!!.attr("scale", "1", "0.95", false).attr("scale", "0.95", "1.05", false).attr("scale", "1.05", "1", false).play()
            }
            return
        }
        this.closeAlert()
    }
    open var closeAlert = ::gen_closeAlert_fn
    open fun gen_closeAlert_fn() {
        if (this.actioning) {
            return
        }
        if (this.status == "close") {
            return
        }
        this.status = "close"
        this.`$emit`("beforeClose")
        this.setStyleAni()
    }
    open var showAlert = ::gen_showAlert_fn
    open fun gen_showAlert_fn() {
        if (this.actioning) {
            return
        }
        if (this.status == "open") {
            return
        }
        this.showOverflay = true
        this.status = "open"
        this.`$emit`("beforeOpen")
        this.setStyleAni()
    }
    open var setStyleAni = ::gen_setStyleAni_fn
    open fun gen_setStyleAni_fn() {
        var t = this
        if (this.status == "open") {
            var watiDuration: Number = 60
            this.showOverflay = true
            clearTimeout(this.tid)
            this.tid = setTimeout(fun() {
                t.element = t.`$refs`["xDrawerWrap"] as UniElement
                t.elementWrap = t.`$refs`["xDrawerWrapContent"] as UniElement
                if (t.element == null || t.elementWrap == null) {
                    return
                }
                t.element!!.style.setProperty("transition-duration", t._duration.toString(10) + "ms")
                t.elementWrap!!.style.setProperty("transition-duration", t._duration.toString(10) + "ms")
                t.element!!.style.setProperty("opacity", "1")
                t.elementWrap!!.style.setProperty("transform", "scale(1)")
                t.elementWrap!!.style.setProperty("opacity", "1")
                t.onEnd()
            }, watiDuration)
        } else if (t.status == "close") {
            t.element!!.style.setProperty("transition-duration", t._duration.toString(10) + "ms")
            t.elementWrap!!.style.setProperty("transition-duration", t._duration.toString(10) + "ms")
            t.element!!.style.setProperty("opacity", 0)
            t.elementWrap!!.style.setProperty("transform", "scale(0.64)")
            t.elementWrap!!.style.setProperty("opacity", 0)
            t.onEnd()
        }
    }
    open var openDrawer = ::gen_openDrawer_fn
    open fun gen_openDrawer_fn() {
        this.showAlert()
    }
    open var onEnd = ::gen_onEnd_fn
    open fun gen_onEnd_fn() {
        val _this = this
        try {
            if (_this.actioning) {
                return
            }
            _this.actioning = true
            this.tid2 = setTimeout(fun() {
                if (_this.status == "close") {
                    _this.showOverflay = false
                    _this.`$emit`("close")
                    _this.`$emit`("update:show", false)
                } else {
                    _this.`$emit`("open")
                }
                nextTick(fun(){
                    _this.actioning = false
                }
                )
            }
            , _this._duration + 5)
        }
         catch (e: Throwable) {
            console.error("动画结束执行出现意外。", e)
            _this.showOverflay = false
        }
    }
    open var maskerMove = ::gen_maskerMove_fn
    open fun gen_maskerMove_fn(evt: UniTouchEvent) {}
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xModalWrapBox" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "height" to "100%", "width" to "100%", "position" to "relative")), "xDrawerFooter" to padStyleMapOf(utsMapOf("width" to "100%", "paddingTop" to 20, "paddingRight" to 16, "paddingBottom" to 16, "paddingLeft" to 16, "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "display" to "flex")), "xDrawerXclose" to padStyleMapOf(utsMapOf("position" to "absolute", "right" to 12, "top" to 6, "zIndex" to 100)), "xDrawertitleBoxTitle" to padStyleMapOf(utsMapOf("fontSize" to 16)), "xDrawerTitleBox" to padStyleMapOf(utsMapOf("height" to 60, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "xDrawertitleBox" to padStyleMapOf(utsMapOf("maxWidth" to 350, "overflow" to "hidden", "lines" to 1, "textOverflow" to "ellipsis", "fontSize" to 14)), "xDrawerWrap_center" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center")), "xDrawerWrapContent" to padStyleMapOf(utsMapOf("transitionDuration" to "350ms", "transitionProperty" to "transform,opacity", "display" to "flex", "flexDirection" to "column")), "xDrawerWrapContent_center" to padStyleMapOf(utsMapOf("transform" to "scale(0.64)", "opacity" to 0)), "xDrawerWrap" to padStyleMapOf(utsMapOf("backgroundImage" to "none", "backgroundColor" to "rgba(0,0,0,0.4)", "opacity" to 0, "position" to "fixed", "left" to 0, "top" to 0, "transitionDuration" to "350ms", "transitionProperty" to "opacity")), "@TRANSITION" to utsMapOf("xDrawerWrapContent" to utsMapOf("duration" to "350ms", "property" to "transform,opacity"), "xDrawerWrap" to utsMapOf("duration" to "350ms", "property" to "opacity")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("click" to null, "close" to null, "open" to null, "beforeOpen" to null, "beforeClose" to null, "update:show" to null, "cancel" to null, "confirm" to null)
        var props = normalizePropsOptions(utsMapOf("customStyle" to utsMapOf("type" to "String", "default" to ""), "title" to utsMapOf("type" to "String", "default" to "标题"), "showFooter" to utsMapOf("type" to "Boolean", "default" to true), "showTitle" to utsMapOf("type" to "Boolean", "default" to true), "showClose" to utsMapOf("type" to "Boolean", "default" to false), "showCancel" to utsMapOf("type" to "Boolean", "default" to true), "overlayClick" to utsMapOf("type" to "Boolean", "default" to true), "show" to utsMapOf("type" to "Boolean", "default" to false), "duration" to utsMapOf("type" to "Number", "default" to 300), "watiDuration" to utsMapOf("type" to "Number", "default" to 120), "cancelText" to utsMapOf("type" to "String", "default" to "取消"), "confirmText" to utsMapOf("type" to "String", "default" to "确认"), "round" to utsMapOf("type" to "String", "default" to ""), "width" to utsMapOf("type" to "String", "default" to "84%"), "height" to utsMapOf("type" to "String", "default" to "240px"), "maxHeight" to utsMapOf("type" to "String", "default" to "80%"), "disabledScroll" to utsMapOf("type" to "Boolean", "default" to false), "bgColor" to utsMapOf("type" to "String", "default" to "white"), "darkBgColor" to utsMapOf("type" to "String", "default" to ""), "zIndex" to utsMapOf("type" to "String", "default" to "1105"), "contentPadding" to utsMapOf("type" to "String", "default" to "16"), "btnColor" to utsMapOf("type" to "String", "default" to ""), "beforeClose" to utsMapOf("type" to "Function", "default" to fun(): UTSPromise<Boolean> {
            return UTSPromise.resolve(true)
        }
        ), "closeColor" to utsMapOf("type" to "String", "default" to "#e6e6e6"), "closeDarkColor" to utsMapOf("type" to "String", "default" to "#545454")))
        var propsNeedCastKeys = utsArrayOf(
            "customStyle",
            "title",
            "showFooter",
            "showTitle",
            "showClose",
            "showCancel",
            "overlayClick",
            "show",
            "duration",
            "watiDuration",
            "cancelText",
            "confirmText",
            "round",
            "width",
            "height",
            "maxHeight",
            "disabledScroll",
            "bgColor",
            "darkBgColor",
            "zIndex",
            "contentPadding",
            "btnColor",
            "beforeClose",
            "closeColor",
            "closeDarkColor"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
