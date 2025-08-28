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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenUniModulesTmxUiComponentsXActionModalXActionModal : VueComponent {
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
        val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass)
        return _cE("view", null, _uA(
            _cE("view", _uM("onClick" to _ctx.openDrawer), _uA(
                renderSlot(_ctx.`$slots`, "trigger", _uM("show" to _ctx.show))
            ), 8, _uA(
                "onClick"
            )),
            if (isTrue(_ctx.showOverflay)) {
                _cE("view", _uM("key" to 0, "onClick" to _ctx.onClickOverflowy, "onTouchmove" to _ctx.overTouch, "onTransitionend" to _ctx.onEnd, "id" to _ctx.id, "class" to "xActionModalWrap xActionModalWrap_bottom", "style" to _nS(_uA(
                    _uM("width" to "100%", "height" to _ctx.__height, "top" to (_ctx.windtop + "px"), "transition-timing-function" to _ctx._animationFun),
                    _ctx._customStyle
                ))), _uA(
                    _cE("view", _uM("onClick" to withModifiers(fun(){}, _uA(
                        "stop"
                    )), "class" to "xActionModalWrapContent xActionModalWrapContent_bottom", "id" to _ctx.wrapId, "style" to _nS(_uM("borderRadius" to _ctx._round, "maxHeight" to if (_ctx._maxHeight != "") {
                        _ctx._maxHeight
                    } else {
                        "100%"
                    }, "backgroundColor" to _ctx._bgColor, "transition-timing-function" to _ctx._animationFun))), _uA(
                        if (isTrue(_ctx._showClose)) {
                            _cV(_component_x_icon, _uM("key" to 0, "class" to "xActionModalXclose", "onClick" to _ctx.closeAlert, "color" to "#dcdcdc", "font-size" to "24", "name" to "close-circle-fill"), null, 8, _uA(
                                "onClick"
                            ))
                        } else {
                            _cC("v-if", true)
                        },
                        _cE("view", null, _uA(
                            if (isTrue(_ctx._showTitle)) {
                                _cE("view", _uM("key" to 0, "class" to "xActionModalTitleBox"), _uA(
                                    renderSlot(_ctx.`$slots`, "title", _uM("show" to _ctx.show), fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("text", _uM("class" to "xActionModaltitleBox"), _tD(_ctx._title), 1)
                                        )
                                    })
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        )),
                        _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1")), "scroll-y" to true, "rebound" to false), _uA(
                            renderSlot(_ctx.`$slots`, "default")
                        ), 4),
                        if (isTrue(_ctx._showConfirm)) {
                            _cE("view", _uM("key" to 1, "class" to "xActionModalFooter"), _uA(
                                renderSlot(_ctx.`$slots`, "footer", UTSJSONObject(), fun(): UTSArray<Any> {
                                    return _uA(
                                        _cV(_component_x_button, _uM("onClick" to _ctx.onConfirm, "block" to true, "color" to _ctx._btnColor, "round" to _ctx._round, "font-color" to _ctx._btnFontColor), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(_ctx._btnText)
                                            )
                                        }), "_" to 1), 8, _uA(
                                            "onClick",
                                            "color",
                                            "round",
                                            "font-color"
                                        ))
                                    )
                                })
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                    ), 12, _uA(
                        "onClick",
                        "id"
                    ))
                ), 44, _uA(
                    "onClick",
                    "onTouchmove",
                    "onTransitionend",
                    "id"
                ))
            } else {
                _cC("v-if", true)
            }
        ))
    }
    open var customStyle: String by `$props`
    open var title: String by `$props`
    open var showTitle: Boolean by `$props`
    open var showClose: Boolean by `$props`
    open var overlayClick: Boolean by `$props`
    open var show: Boolean by `$props`
    open var showConfirm: Boolean by `$props`
    open var duration: Number by `$props`
    open var round: String by `$props`
    open var maxHeight: String by `$props`
    open var bgColor: String by `$props`
    open var darkBgColor: String by `$props`
    open var btnColor: String by `$props`
    open var btnText: String by `$props`
    open var btnFontColor: String by `$props`
    open var watiDuration: Number by `$props`
    open var _width: Number by `$data`
    open var _height: Number by `$data`
    open var showOverflay: Boolean by `$data`
    open var element: Element? by `$data`
    open var elementWrap: Element? by `$data`
    open var actioning: Boolean by `$data`
    open var status: String by `$data`
    open var id: Any? by `$data`
    open var wrapId: Any? by `$data`
    open var tid: Number by `$data`
    open var windtop: Number by `$data`
    open var pageOninit: Boolean by `$data`
    open var isOpenedDefault: Boolean by `$data`
    open var _btnFontColor: String by `$data`
    open var _btnColor: String by `$data`
    open var _btnText: String by `$data`
    open var _customStyle: String by `$data`
    open var _show: Boolean by `$data`
    open var _showClose: Boolean by `$data`
    open var _duration: Number by `$data`
    open var _title: String by `$data`
    open var _showTitle: Boolean by `$data`
    open var _round: String by `$data`
    open var _bgColor: String by `$data`
    open var _maxHeight: String by `$data`
    open var _showConfirm: Boolean by `$data`
    open var _animationFun: String by `$data`
    open var __height: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("_width" to 0, "_height" to 0, "showOverflay" to false, "element" to null as Element?, "elementWrap" to null as Element?, "actioning" to false, "status" to "", "id" to ("xActionModal" + getUid()), "wrapId" to ("xActionModalWrap" + getUid()), "tid" to 0, "windtop" to 0, "pageOninit" to false, "isOpenedDefault" to false, "_btnFontColor" to computed<String>(fun(): String {
            return getDefaultColor(this.btnFontColor)
        }
        ), "_btnColor" to computed<String>(fun(): String {
            if (this.btnColor == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.btnColor)
        }
        ), "_btnText" to computed<String>(fun(): String {
            return this.btnText
        }
        ), "_customStyle" to computed<String>(fun(): String {
            return this.customStyle
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
        ), "_title" to computed<String>(fun(): String {
            return this.title
        }
        ), "_showTitle" to computed<Boolean>(fun(): Boolean {
            return this.showTitle
        }
        ), "_round" to computed<String>(fun(): String {
            var round = this.round
            if (round == "") {
                round = xConfig.drawerRadius
            }
            var radius = checkIsCssUnit(round, xConfig.unit)
            return "" + radius
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
        ), "_maxHeight" to computed<String>(fun(): String {
            if (this.maxHeight == "") {
                return "80%"
            }
            return checkIsCssUnit(this.maxHeight, xConfig.unit)
        }
        ), "_showConfirm" to computed<Boolean>(fun(): Boolean {
            return this.showConfirm
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
    open fun gen_overflayMoveTouch_fn(evt: TouchEvent) {
        evt.preventDefault()
    }
    open var onClickOverflowy = ::gen_onClickOverflowy_fn
    open fun gen_onClickOverflowy_fn(evt: Event) {
        evt.stopPropagation()
        this.`$emit`("click")
        if (!this.overlayClick) {
            return
        }
        this.closeAlert()
    }
    open var closeAlert = ::gen_closeAlert_fn
    open fun gen_closeAlert_fn() {
        if (this.actioning || this.status == "close") {
            return
        }
        this.actioning = true
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
        this.actioning = true
        this.status = "open"
        this.`$emit`("beforeOpen")
        this.setStyleAni()
    }
    open var setStyleAni = ::gen_setStyleAni_fn
    open fun gen_setStyleAni_fn() {
        var t = this
        try {
            var watiDuration: Number = 60
            if (this.status == "open") {
                this.showOverflay = true
                clearTimeout(this.tid)
                this.tid = setTimeout(fun() {
                    t.element = uni_getElementById(t.id as String) as Element
                    t.elementWrap = uni_getElementById(t.wrapId as String) as Element
                    if (t.element == null || t.elementWrap == null) {
                        return
                    }
                    t.element!!.style.setProperty("transition-duration", t._duration.toString(10) + "ms")
                    t.elementWrap!!.style.setProperty("transition-duration", t._duration.toString(10) + "ms")
                    t.element!!.style.setProperty("opacity", 1)
                    t.elementWrap!!.style.setProperty("transform", "translate(0%,-24rpx)")
                }, watiDuration)
            } else if (t.status == "close") {
                t.element!!.style.setProperty("transition-duration", t._duration.toString(10) + "ms")
                t.elementWrap!!.style.setProperty("transition-duration", t._duration.toString(10) + "ms")
                t.element!!.style.setProperty("opacity", 0)
                t.elementWrap!!.style.setProperty("transform", "translate(0%,100%)")
            }
        }
         catch (e: Throwable) {}
    }
    open var openDrawer = ::gen_openDrawer_fn
    open fun gen_openDrawer_fn() {
        this.showAlert()
    }
    open var onEnd = ::gen_onEnd_fn
    open fun gen_onEnd_fn() {
        this.actioning = false
        if (this.status == "close") {
            this.showOverflay = false
            this.`$emit`("close")
            this.`$emit`("update:show", false)
        } else {
            this.`$emit`("open")
        }
    }
    open var overTouch = ::gen_overTouch_fn
    open fun gen_overTouch_fn(evt: UniTouchEvent) {
        evt.stopPropagation()
    }
    open var onConfirm = ::gen_onConfirm_fn
    open fun gen_onConfirm_fn() {
        this.closeAlert()
        this.`$emit`("confirm")
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xActionModalItem" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "height" to 44, "marginBottom" to 1)), "xActionModalFooter" to _pS(_uM("marginTop" to 16, "marginRight" to 16, "marginBottom" to 16, "marginLeft" to 16)), "xActionModalFooterText" to _pS(_uM("fontSize" to 15, "color" to "#333333", "textAlign" to "center")), "xActionModalXclose" to _pS(_uM("position" to "absolute", "right" to 12, "top" to 11, "zIndex" to 100)), "xActionModalTitleBox" to _pS(_uM("height" to 44, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "marginBottom" to 4)), "xActionModaltitleBox" to _pS(_uM("maxWidth" to "350rpx", "overflow" to "hidden", "lines" to 1, "textOverflow" to "ellipsis", "fontSize" to 16, "color" to "#888888")), "xActionModalWrap_bottom" to _pS(_uM("display" to "flex", "flexDirection" to "column", "justifyContent" to "flex-end", "alignItems" to "center")), "xActionModalWrapContent" to _pS(_uM("transitionDuration" to "350ms", "transitionProperty" to "transform", "display" to "flex", "flexDirection" to "column", "marginTop" to 0, "marginRight" to 16, "marginBottom" to 0, "marginLeft" to 16, "maxWidth" to 500)), "xActionModalWrapContent_bottom" to _pS(_uM("transform" to "translate(0%, 100%)")), "xActionModalWrap" to _pS(_uM("backgroundColor" to "rgba(0,0,0,0.35)", "opacity" to 0, "position" to "fixed", "zIndex" to 1100, "left" to 0, "top" to 0, "transitionDuration" to "350ms", "transitionProperty" to "opacity")), "@TRANSITION" to _uM("xActionModalWrapContent" to _uM("duration" to "350ms", "property" to "transform"), "xActionModalWrap" to _uM("duration" to "350ms", "property" to "opacity")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("confirm" to null, "click" to null, "close" to null, "open" to null, "beforeOpen" to null, "beforeClose" to null, "update:show" to null)
        var props = _nP(_uM("customStyle" to _uM("type" to "String", "default" to ""), "title" to _uM("type" to "String", "default" to "标题"), "showTitle" to _uM("type" to "Boolean", "default" to true), "showClose" to _uM("type" to "Boolean", "default" to false), "overlayClick" to _uM("type" to "Boolean", "default" to true), "show" to _uM("type" to "Boolean", "default" to false), "showConfirm" to _uM("type" to "Boolean", "default" to true), "duration" to _uM("type" to "Number", "default" to 350), "round" to _uM("type" to "String", "default" to ""), "maxHeight" to _uM("type" to "String", "default" to ""), "bgColor" to _uM("type" to "String", "default" to "white"), "darkBgColor" to _uM("type" to "String", "default" to ""), "btnColor" to _uM("type" to "String", "default" to ""), "btnText" to _uM("type" to "String", "default" to "确认"), "btnFontColor" to _uM("type" to "String", "default" to ""), "watiDuration" to _uM("type" to "Number", "default" to 120)))
        var propsNeedCastKeys = _uA(
            "customStyle",
            "title",
            "showTitle",
            "showClose",
            "overlayClick",
            "show",
            "showConfirm",
            "duration",
            "round",
            "maxHeight",
            "bgColor",
            "darkBgColor",
            "btnColor",
            "btnText",
            "btnFontColor",
            "watiDuration"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
