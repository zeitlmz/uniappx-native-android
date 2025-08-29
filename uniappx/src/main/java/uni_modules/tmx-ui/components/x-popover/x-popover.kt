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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenUniModulesTmxUiComponentsXPopoverXPopover : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            var t = this
            var sys = uni_getWindowInfo()
            this._width = sys.windowWidth
            this._height = sys.windowHeight
            this.windtop = 0
            if (this.modelValue) {
                t.isGeiNodeInfoOk = false
                t.showPro = true
                t.status = "open"
                t.openProWrap()
            }
        }
        , __ins)
        onBeforeUnmount(fun() {
            clearTimeout(this.tid)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.keyName
        }
        , fun() {
            this.`$nextTick`(fun(){
                this.getNodes()
            }
            )
        }
        )
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newval: Boolean) {
            if (this.showPro == newval || this.status == "playing") {
                return
            }
            if (newval) {
                this.isGeiNodeInfoOk = false
                this.showPro = true
                this.status = "open"
                this.openProWrap()
            } else {
                this.closeProWrap()
            }
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", _uM("class" to "xPopover", "ref" to "xPopover"), _uA(
            _cE("view", _uM("id" to _ctx.id, "onClick" to _ctx.openAlert, "style" to _nS(_uM("flex" to "1"))), _uA(
                renderSlot(_ctx.`$slots`, "default")
            ), 12, _uA(
                "id",
                "onClick"
            )),
            if (isTrue(_ctx.showPro)) {
                _cE("view", _uM("key" to 0, "onClick" to _ctx.closeProWrap, "onTouchmove" to _ctx.closeProWrap, "zz" to "", "class" to "xPopoverMasker", "style" to _nS(_uM("width" to "100%", "height" to _ctx.__height, "opacity" to if (_ctx.showquerinnode) {
                    1
                } else {
                    0
                }, "backgroundColor" to _ctx._maskBgColor))), _uA(
                    _cE("view", _uM("onClick" to withModifiers(_ctx.contentWrapClick, _uA(
                        "stop"
                    )), "onTransitionend" to _ctx.onEnd, "onTouchmove" to withModifiers(fun(){}, _uA(
                        "stop"
                    )), "ref" to "xPopoverWrap", "id" to _ctx.menuiId, "class" to "xPopoverWrap", "style" to _nS(_uA(
                        _ctx.xPopoverWrapPos,
                        _uM("transition-timing-function" to _ctx._animationFun)
                    ))), _uA(
                        if (isTrue((_ctx.nowPos == "bc" || _ctx.nowPos == "bl" || _ctx.nowPos == "br") && _ctx.showTriangle)) {
                            _cE("view", _uM("key" to 0, "class" to _nC("xPopoverUp_" + _ctx.nowPos), "style" to _nS(_uM("padding" to ("0px " + _ctx._round)))), _uA(
                                _cE("view", _uM("class" to "xPopoverUp", "style" to _nS(_uM("border-bottom-color" to _ctx._triangleColor))), null, 4)
                            ), 6)
                        } else {
                            _cC("v-if", true)
                        },
                        _cE("view", _uM("style" to _nS(_uM("borderRadius" to _ctx._round))), _uA(
                            renderSlot(_ctx.`$slots`, "menu")
                        ), 4),
                        if (isTrue((_ctx.nowPos == "tc" || _ctx.nowPos == "tl" || _ctx.nowPos == "tr") && _ctx.showTriangle)) {
                            _cE("view", _uM("key" to 1, "class" to _nC("xPopoverUp_" + _ctx.nowPos), "style" to _nS(_uM("padding" to ("0px " + _ctx._round)))), _uA(
                                _cE("view", _uM("class" to "xPopoverBp", "style" to _nS(_uM("border-bottom-color" to _ctx._triangleColor))), null, 4)
                            ), 6)
                        } else {
                            _cC("v-if", true)
                        }
                    ), 44, _uA(
                        "onClick",
                        "onTransitionend",
                        "onTouchmove",
                        "id"
                    ))
                ), 44, _uA(
                    "onClick",
                    "onTouchmove"
                ))
            } else {
                _cC("v-if", true)
            }
        ), 512)
    }
    open var position: String by `$props`
    open var keyName: Number by `$props`
    open var modelValue: Boolean by `$props`
    open var isClickClose: Boolean by `$props`
    open var round: String by `$props`
    open var maskBgColor: String by `$props`
    open var showTriangle: Boolean by `$props`
    open var triangleColor: String by `$props`
    open var triangleDarkColor: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var id: Any? by `$data`
    open var menuiId: Any? by `$data`
    open var _width: Number by `$data`
    open var _height: Number by `$data`
    open var trrigerNodeInfo: NODE_INFO? by `$data`
    open var menuNodeInfo: NODE_INFO? by `$data`
    open var showPro: Boolean by `$data`
    open var status: String by `$data`
    open var isGeiNodeInfoOk: Boolean by `$data`
    open var tid: Number by `$data`
    open var windtop: Number by `$data`
    open var showquerinnode: Boolean by `$data`
    open var nowPos: xPopopverPosType by `$data`
    open var _maskBgColor: String by `$data`
    open var _triangleColor: String by `$data`
    open var xPopoverWrapPos: String by `$data`
    open var _animationFun: String by `$data`
    open var __height: String by `$data`
    open var _round: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "id" to ("xPopover" + getUid()), "menuiId" to ("xPopoverMenu" + getUid()), "_width" to 0, "_height" to 0, "trrigerNodeInfo" to null as NODE_INFO?, "menuNodeInfo" to null as NODE_INFO?, "showPro" to false, "status" to "open" as String, "isGeiNodeInfoOk" to false, "tid" to 0, "windtop" to 0, "showquerinnode" to false, "nowPos" to "bc" as xPopopverPosType, "_maskBgColor" to computed<String>(fun(): String {
            return this.maskBgColor
        }
        ), "_triangleColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                if (this.triangleDarkColor == "") {
                    return getDefaultColor(xConfig.sheetDarkColor)
                }
                return getDefaultColor(this.triangleDarkColor)
            }
            return getDefaultColor(this.triangleColor)
        }
        ), "xPopoverWrapPos" to computed<String>(fun(): String {
            if (this.trrigerNodeInfo == null) {
                return ""
            }
            val sys = uni_getWindowInfo()
            var tl = this.trrigerNodeInfo!!.left as Number
            var tr = this.trrigerNodeInfo!!.right as Number
            var tw = this.trrigerNodeInfo!!.width as Number
            var mw = this.menuNodeInfo!!.width as Number
            var mh = this.menuNodeInfo!!.height as Number + 8
            var mb = this.menuNodeInfo!!.bottom as Number
            var tb = this.trrigerNodeInfo!!.bottom as Number
            var tp = this.trrigerNodeInfo!!.top as Number
            var nopos = this.position
            fun getStyleCss(pos: String): String {
                if (pos == "bc") {
                    var left = tl - (mw - tw) / 2
                    var top = tb + 10
                    return "left:" + left + "px;top:" + top + "px;transform-origin: 50% 0px;"
                } else if (pos == "br") {
                    var left = tr - mw
                    var top = tb + 10
                    return "left:" + left + "px;top:" + top + "px;transform-origin: 100% 0px;"
                } else if (pos == "bl") {
                    var left = tl
                    var top = tb + 10
                    return "left:" + left + "px;top:" + top + "px;transform-origin: 0px 0px;"
                } else if (pos == "tc") {
                    var left = tl - (mw - tw) / 2
                    var top = tp - mh - 10
                    return "left:" + left + "px;top:" + top + "px;transform-origin: 50% 200%;"
                } else if (pos == "tl") {
                    var left = tl
                    var top = tp - mh - 10
                    return "left:" + left + "px;top:" + top + "px;transform-origin: 0% 200%;"
                } else if (pos == "tr") {
                    var left = tr - mw
                    var top = tp - mh - 10
                    return "left:" + left + "px;top:" + top + "px;transform-origin: 100% 200%;"
                }
                return ""
            }
            var poscss = ""
            when (this.position) {
                "bc" -> 
                    {
                        val diffb = sys.windowHeight - tb
                        val difft = tp - sys.windowTop
                        if (diffb < mh && difft >= diffb && diffb < mh) {
                            nopos = "tc"
                        }
                        poscss = getStyleCss(nopos)
                    }
                "br" -> 
                    {
                        val diffb = sys.windowHeight - tb
                        val difft = tp - sys.windowTop
                        val diffr = sys.windowWidth - tr
                        if (diffb < mh && difft >= diffb && diffb < mh) {
                            nopos = "tr"
                        }
                        poscss = getStyleCss(nopos)
                    }
                "bl" -> 
                    {
                        val diffb = sys.windowHeight - tb
                        val difft = tp - sys.windowTop
                        if (diffb < mh && difft >= diffb && diffb < mh) {
                            nopos = "tl"
                        }
                        poscss = getStyleCss(nopos)
                    }
                "tc" -> 
                    {
                        val diffb = sys.windowHeight - tb
                        val difft = tp - sys.windowTop
                        if (diffb > mh && difft <= diffb && difft < mh) {
                            nopos = "bc"
                        }
                        poscss = getStyleCss(nopos)
                    }
                "tr" -> 
                    {
                        val diffb = sys.windowHeight - tb
                        val difft = tp - sys.windowTop
                        if (diffb > mh && difft <= diffb && difft < mh) {
                            nopos = "br"
                        }
                        poscss = getStyleCss(nopos)
                    }
                "tl" -> 
                    {
                        val diffb = sys.windowHeight - tb
                        val difft = tp - sys.windowTop
                        if (diffb > mh && difft <= diffb && difft < mh) {
                            nopos = "bl"
                        }
                        poscss = getStyleCss(nopos)
                    }
            }
            this.nowPos = nopos
            return poscss
        }
        ), "_animationFun" to computed<String>(fun(): String {
            return "cubic-bezier(0.07, 0.82, 0.17, 1.20)"
        }
        ), "__height" to computed<String>(fun(): String {
            var h = "100%"
            return h
        }
        ), "_round" to computed<String>(fun(): String {
            return checkIsCssUnit(this.round, xConfig.unit)
        }
        ))
    }
    open var contentWrapClick = ::gen_contentWrapClick_fn
    open fun gen_contentWrapClick_fn(evt: UniPointerEvent) {
        if (this.isClickClose) {
            this.closeProWrap()
        }
    }
    open var onEnd = ::gen_onEnd_fn
    open fun gen_onEnd_fn() {
        if (this.status == "close") {
            this.showPro = false
            this.`$emit`("update:modelValue", false)
        }
        this.status = "compeleted"
    }
    open var openAlert = ::gen_openAlert_fn
    open fun gen_openAlert_fn() {
        var t = this
        if (this.status == "playing") {
            return
        }
        this.isGeiNodeInfoOk = false
        this.showPro = true
        this.`$emit`("update:modelValue", true)
        this.status = "open"
        t.openProWrap()
        var currentPage = getCurrentPages()[getCurrentPages().length - 1]
        currentPage.setPageStyle(object : UTSJSONObject() {
            var disableScroll = true
        })
    }
    open var mskerTouch = ::gen_mskerTouch_fn
    open fun gen_mskerTouch_fn(evt: UniTouchEvent) {
        evt.stopPropagation()
        evt.preventDefault()
    }
    open var openProWrap = ::gen_openProWrap_fn
    open fun gen_openProWrap_fn() {
        this.status = "playing"
        var _this = this
        _this.showquerinnode = false
        this.getNodes().then(fun(){
            var ele = _this.`$refs`["xPopoverWrap"] as UniElement
            if (ele == null) {
                return
            }
            ele.style.setProperty("transition-duration", "0ms")
            ele.style.setProperty("transform", "scale(0)")
            ele.style.setProperty("opacity", 0)
            setTimeout(fun() {
                ele.style.setProperty("transition-duration", "300ms")
                ele.style.setProperty("transform", "scale(1)")
                ele.style.setProperty("opacity", 1)
                _this.showquerinnode = true
            }
            , 25)
        }
        )
    }
    open var closeProWrap = ::gen_closeProWrap_fn
    open fun gen_closeProWrap_fn() {
        if (this.status == "close") {
            return
        }
        this.status = "close"
        try {
            var el = this.`$refs`["xPopoverWrap"] as Element?
            if (el == null) {
                return
            }
            el.style.setProperty("transition-duration", "300ms")
            el.style.setProperty("transform", "scale(0.64)")
            el.style.setProperty("opacity", "0")
        }
         catch (e: Throwable) {
            console.error(e)
        }
    }
    open var getNodes = ::gen_getNodes_fn
    open fun gen_getNodes_fn(): UTSPromise<Boolean> {
        var _this = this
        var triele = _this.`$refs`["xPopover"] as UniElement
        var delay: Number = 0
        return UTSPromise(fun(res, _reject){
            if (triele == null) {
                res(true)
                return
            }
            setTimeout(fun() {
                triele.getBoundingClientRectAsync()?.then(fun(ret: DOMRect){
                    var nodeinfo = ret
                    var trinode = NODE_INFO(left = nodeinfo.left!!, width = nodeinfo.width!!, height = nodeinfo.height!!, bottom = nodeinfo.bottom!!, right = nodeinfo.right!!, top = nodeinfo.top!!)
                    if (!_this.showPro) {
                        _this.trrigerNodeInfo = trinode
                        res(true)
                        return
                    }
                    var delayTImeout: Number = 30
                    setTimeout(fun() {
                        var ele = _this.`$refs`["xPopoverWrap"] as UniElement
                        if (ele == null) {
                            return
                        }
                        ele!!.getBoundingClientRectAsync()?.then(fun(rect2: DOMRect){
                            nodeinfo = rect2
                            _this.trrigerNodeInfo = trinode
                            _this.menuNodeInfo = NODE_INFO(left = nodeinfo.left!!, width = nodeinfo.width!!, height = nodeinfo.height!!, bottom = nodeinfo.bottom!!, right = nodeinfo.right!!, top = nodeinfo.top!!)
                            res(true)
                        }
                        )
                    }
                    , delayTImeout)
                }
                )
            }
            , delay)
        }
        )
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xPopoverUp" to _pS(_uM("width" to 0, "height" to 0, "borderLeftWidth" to 10, "borderLeftStyle" to "solid", "borderLeftColor" to "rgba(0,0,0,0)", "borderRightWidth" to 10, "borderRightStyle" to "solid", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomWidth" to 10, "borderBottomStyle" to "solid", "transform" to "rotate(0deg)")), "xPopoverBp" to _pS(_uM("width" to 0, "height" to 0, "borderLeftWidth" to 10, "borderLeftStyle" to "solid", "borderLeftColor" to "rgba(0,0,0,0)", "borderRightWidth" to 10, "borderRightStyle" to "solid", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomWidth" to 10, "borderBottomStyle" to "solid", "transform" to "rotate(180deg)")), "xPopoverUp_bc" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "flex-end")), "xPopoverUp_bl" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "flex-end")), "xPopoverUp_br" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end", "alignItems" to "flex-end")), "xPopoverUp_tc" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "flex-end")), "xPopoverUp_tl" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "flex-end")), "xPopoverUp_tr" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end", "alignItems" to "flex-end")), "xPopover" to _pS(_uM("display" to "flex", "flexDirection" to "row")), "xPopoverMasker" to _pS(_uM("position" to "fixed", "zIndex" to 100, "left" to 0, "top" to 0)), "xPopoverWrap" to _pS(_uM("position" to "absolute", "transitionProperty" to "transform,opacity", "transitionTimingFunction" to "cubic-bezier(0.07,0.82,0.17,1.2)", "transform" to "scale(1)", "transitionDuration" to "300ms", "opacity" to 0)), "@TRANSITION" to _uM("xPopoverWrap" to _uM("property" to "transform,opacity", "timingFunction" to "cubic-bezier(0.07,0.82,0.17,1.2)", "duration" to "300ms")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null)
        var props = _nP(_uM("position" to _uM("type" to "String", "default" to "bc"), "keyName" to _uM("type" to "Number", "default" to 0), "modelValue" to _uM("type" to "Boolean", "default" to false), "isClickClose" to _uM("type" to "Boolean", "default" to true), "round" to _uM("type" to "String", "default" to "16"), "maskBgColor" to _uM("type" to "String", "default" to "rgba(0,0,0,0)"), "showTriangle" to _uM("type" to "Boolean", "default" to false), "triangleColor" to _uM("type" to "String", "default" to "white"), "triangleDarkColor" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "position",
            "keyName",
            "modelValue",
            "isClickClose",
            "round",
            "maskBgColor",
            "showTriangle",
            "triangleColor",
            "triangleDarkColor"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
