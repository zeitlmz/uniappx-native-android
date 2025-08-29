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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenUniModulesTmxUiComponentsXFloatButtonXFloatButton : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.isReady = false
            var sys = uni_getWindowInfo()
            this.winWidth = sys.windowWidth
            this.winHeight = sys.windowHeight + 44
            var t = this
            this.getNodes().then(fun(){
                t.setProperty(t.offset[0], t.offset[1])
                t.isReady = true
            }
            )
            uni__on("onResize", this.onresizeOffsetXy)
        }
        , __ins)
        onBeforeUnmount(fun() {
            uni__off("onResize", this.onresizeOffsetXy)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.offset
        }
        , fun(newValue: UTSArray<Number>) {
            if (newValue.length == 2 && this.nowXy.join("") != newValue.join("")) {
                this.setProperty(newValue[0], newValue[1])
            }
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", null, _uA(
            _cE("view", _uM("id" to _ctx.id, "onTouchstart" to _ctx.mStart, "onTouchmove" to withModifiers(_ctx.mMove, _uA(
                "stop"
            )), "onTouchend" to _ctx.mEnd, "ref" to "xFloatButton", "style" to _nS(_uA(
                _uM("width" to (_ctx._width + "px"), "height" to (_ctx._height + "px"), "borderRadius" to _ctx._round, "zIndex" to (_ctx.zIndex + 1), "opacity" to if (_ctx.isReady) {
                    "1"
                } else {
                    "0"
                }
                ),
                _ctx._bgColor
            )), "class" to "xFloatButton"), _uA(
                renderSlot(_ctx.`$slots`, "default")
            ), 44, _uA(
                "id",
                "onTouchstart",
                "onTouchmove",
                "onTouchend"
            )),
            _cE("view", _uM("class" to "xFloatButtonBox", "style" to _nS(_uM("zIndex" to _ctx.zIndex))), null, 4)
        ))
    }
    open var duration: Number by `$props`
    open var threshold: Number by `$props`
    open var thresholdTop: Number by `$props`
    open var thresholdBottom: Number by `$props`
    open var round: String by `$props`
    open var offset: UTSArray<Number> by `$props`
    open var bgColor: String by `$props`
    open var width: String by `$props`
    open var height: String by `$props`
    open var adsorption: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var zIndex: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var id: String by `$data`
    open var _x: Number by `$data`
    open var _y: Number by `$data`
    open var winHeight: Number by `$data`
    open var winWidth: Number by `$data`
    open var nowXy: UTSArray<Number> by `$data`
    open var windtop: Number by `$data`
    open var isMoveing: Boolean by `$data`
    open var dateTime: Number by `$data`
    open var diffX: Number by `$data`
    open var _real_X: Number by `$data`
    open var _real_Y: Number by `$data`
    open var lastX: Number by `$data`
    open var lastY: Number by `$data`
    open var first: Boolean by `$data`
    open var longtimeid: Number by `$data`
    open var isReady: Boolean by `$data`
    open var _diffLen: Number by `$data`
    open var _round: String by `$data`
    open var _width: Number by `$data`
    open var _height: Number by `$data`
    open var _bgColor: Any by `$data`
    open var _disabled: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "id" to ("xFloatButtonId-" + getUid()) as String, "_x" to 0, "_y" to 0, "winHeight" to 0, "winWidth" to 0, "nowXy" to _uA<Number>(0, 0), "windtop" to 0, "isMoveing" to false, "dateTime" to 0, "diffX" to 0, "_real_X" to 0, "_real_Y" to 0, "lastX" to 0, "lastY" to 0, "first" to true, "longtimeid" to 22, "isReady" to false, "_diffLen" to computed<Number>(fun(): Number {
            var p = parseInt(this.width)
            if (this.width.lastIndexOf("rpx") > -1) {
                p = rpx2px(p)
            }
            return Math.floor(p)
        }
        ), "_round" to computed<String>(fun(): String {
            return checkIsCssUnit(this.round, xConfig.unit)
        }
        ), "_width" to computed<Number>(fun(): Number {
            var p = parseInt(this.width)
            if (this.width.lastIndexOf("rpx") > -1) {
                p = rpx2px(p)
            }
            return Math.floor(p)
        }
        ), "_height" to computed<Number>(fun(): Number {
            var p = parseInt(this.height)
            if (this.height.lastIndexOf("rpx") > -1) {
                p = rpx2px(p)
            }
            return Math.floor(p)
        }
        ), "_bgColor" to computed<Any>(fun(): Any {
            if (this.bgColor.indexOf("linear-gradient") > -1) {
                return _uO("backgroundImage" to this.bgColor)
            }
            var color = if (this.bgColor == "") {
                getDefaultColor(xConfig.color)
            } else {
                getDefaultColor(this.bgColor)
            }
            return object : UTSJSONObject() {
                var backgroundColor = color
            }
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ))
    }
    open var onresizeOffsetXy = ::gen_onresizeOffsetXy_fn
    open fun gen_onresizeOffsetXy_fn() {
        var t = this
        this.getNodes().then(fun(){
            t.setProperty(t.offset[0], t.offset[1])
        }
        )
    }
    open var getNodes = ::gen_getNodes_fn
    open fun gen_getNodes_fn(): UTSPromise<Boolean> {
        var t = this
        return UTSPromise(fun(res, rej){
            uni_createSelectorQuery().`in`(t).select(".xFloatButtonBox").boundingClientRect().exec(fun(nodes){
                var node = nodes[0] as NodeInfo
                t.winWidth = node.width!!
                t.winHeight = node.height!! - t.windtop
                res(true)
            }
            )
        }
        )
    }
    open var onClick = ::gen_onClick_fn
    open fun gen_onClick_fn() {
        this.`$emit`("click")
    }
    open var setProperty = ::gen_setProperty_fn
    open fun gen_setProperty_fn(reassignedX: Number, reassignedY: Number) {
        var x = reassignedX
        var y = reassignedY
        var node = this.`$refs`["xFloatButton"] as UniElement
        node.style.setProperty("transition-duration", if (this.first) {
            "0"
        } else {
            this.duration.toString(10) + "ms"
        }
        )
        if (x == -1 || x == -4) {
            x = this.winWidth - this._width - this.threshold
        } else if (x == -2 || x == -3) {
            x = this.threshold
        } else if (x == -5) {
            x = (this.winWidth - this._width) / 2
        }
        if (y == -1 || y == -2 || y == -5) {
            y = this.winHeight - this._height - this.thresholdBottom
        } else if (y == -3 || y == -4) {
            y = this.thresholdTop
        }
        x = Math.max(this.threshold, Math.min(this.winWidth - this._width - this.threshold, x))
        if (y > this.winHeight / 2) {
            y = Math.max(this.thresholdBottom, Math.min(this.winHeight - this._height - this.thresholdBottom, y))
        } else {
            y = Math.max(this.thresholdTop, Math.min(this.winHeight - this._height - this.thresholdTop, y))
        }
        node.style.setProperty("left", "" + x + "px")
        node.style.setProperty("top", "" + (y + this.windtop) + "px")
        this.nowXy = _uA(
            x,
            y
        )
        this.lastX = x
        this.lastY = y
        this.`$emit`("change", this.nowXy)
        this.first = false
    }
    open var eventTrasform_start = ::gen_eventTrasform_start_fn
    open fun gen_eventTrasform_start_fn(evt: POSITION_TYPE_XY) {
        this.isMoveing = true
        this.diffX = 0
        this.dateTime = Date().getTime()
        var node = this.`$refs`["xFloatButton"] as Element
        var leftpos = parseInt(node.style.getPropertyValue("left")!! as String)
        var toppos = parseInt(node.style.getPropertyValue("top")!! as String)
        this._x = evt.x - leftpos
        this._y = evt.y - toppos
        this._real_X = evt.x
        this._real_Y = evt.y
        node.style.setProperty("transition-duration", "0ms")
        var realx = Math.floor(evt.x - this._real_X)
        var realy = Math.floor(evt.y - this._real_Y)
        clearTimeout(this.longtimeid)
        var _this = this
        this.longtimeid = setTimeout(fun() {
            _this.`$emit`("longpress")
        }
        , 500)
    }
    open var eventTrasform_move = ::gen_eventTrasform_move_fn
    open fun gen_eventTrasform_move_fn(evt: POSITION_TYPE_XY) {
        clearTimeout(this.longtimeid)
        var x = evt.x - this._x
        var y = evt.y - this._y
        var diff_x = evt.x - this._real_X
        var diff_y = evt.y - this._real_Y
        this.diffX = Math.max(Math.abs(diff_x), Math.abs(diff_y))
        var node = this.`$refs`["xFloatButton"] as Element
        var maxX = this.winWidth - this._width
        var maxY = this.winHeight - this._height + this.windtop
        x = Math.max(Math.min(maxX, x), 0)
        y = Math.max(Math.min(maxY, y), 0)
        node.style.setProperty("left", "" + x + "px")
        node.style.setProperty("top", "" + y + "px")
        this.nowXy = _uA(
            x,
            y
        )
        this.`$emit`("change", _uA(
            x,
            y
        ))
    }
    open var eventTrasform_end = ::gen_eventTrasform_end_fn
    open fun gen_eventTrasform_end_fn(evt: POSITION_TYPE_XY) {
        this.isMoveing = false
        var node = this.`$refs`["xFloatButton"] as Element
        var x = evt.x - this._x
        var y = evt.y - this._y - this.windtop
        var maxX = this.winWidth - this._width
        var maxY = this.winHeight - this._height
        x = Math.max(Math.min(maxX, x), 0)
        y = Math.max(Math.min(maxY, y), 0)
        if (this.adsorption) {
            y = Math.max(Math.min(maxY - this.threshold, y), this.threshold)
            if (x >= (this.winWidth - this._width) / 2) {
                x = this.winWidth - this._width - this.threshold
            } else {
                x = this.threshold
            }
            this.nowXy = _uA(
                x,
                y
            )
            this.setProperty(x, y)
        }
        var diffTiff = Date().getTime() - this.dateTime
        var realx = Math.floor(evt.x - this._real_X)
        var realy = Math.floor(evt.y - this._real_Y)
        if (realx == 0 && realy == 0 && realx == realy) {
            if (diffTiff > 50 && diffTiff < 250) {
                this.onClick()
            }
        }
    }
    open var mStart = ::gen_mStart_fn
    open fun gen_mStart_fn(evt: TouchEvent) {
        if (this._disabled) {
            return
        }
        var x = evt.changedTouches[0].clientX
        var y = evt.changedTouches[0].clientY
        this._real_X = x
        this._real_Y = x
        this.eventTrasform_start(POSITION_TYPE_XY(x = x, y = y))
    }
    open var mMove = ::gen_mMove_fn
    open fun gen_mMove_fn(evt: TouchEvent) {
        if (this._disabled) {
            return
        }
        var x = evt.changedTouches[0].clientX
        var y = evt.changedTouches[0].clientY
        this.eventTrasform_move(POSITION_TYPE_XY(x = x, y = y))
    }
    open var mEnd = ::gen_mEnd_fn
    open fun gen_mEnd_fn(evt: TouchEvent) {
        if (this._disabled) {
            return
        }
        var x = evt.changedTouches[0].clientX
        var y = evt.changedTouches[0].clientY
        this.eventTrasform_end(POSITION_TYPE_XY(x = x, y = y))
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xFloatButtonBox" to _pS(_uM("pointerEvents" to "none", "width" to "100%", "height" to "100%", "backgroundColor" to "rgba(0,0,0,0)", "opacity" to 0, "position" to "fixed", "left" to 0, "top" to 0, "transform" to "translate(-100%, -100%)")), "xFloatButton" to _pS(_uM("transitionDuration" to "0ms", "transitionProperty" to "left,right,top,bottom", "transitionTimingFunction" to "cubic-bezier(0,0.55,0.45,1)", "top" to 0, "left" to 0, "position" to "fixed")), "@TRANSITION" to _uM("xFloatButton" to _uM("duration" to "0ms", "property" to "left,right,top,bottom", "timingFunction" to "cubic-bezier(0,0.55,0.45,1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null, "longpress" to null, "change" to null, "update:offset" to null)
        var props = _nP(_uM("duration" to _uM("type" to "Number", "default" to 650), "threshold" to _uM("type" to "Number", "default" to 12), "thresholdTop" to _uM("type" to "Number", "default" to 0), "thresholdBottom" to _uM("type" to "Number", "default" to 12), "round" to _uM("type" to "String", "default" to "64"), "offset" to _uM("type" to "Array", "default" to fun(): UTSArray<Number> {
            return _uA<Number>(-1, -1)
        }
        ), "bgColor" to _uM("type" to "String", "default" to ""), "width" to _uM("type" to "String", "default" to "50px"), "height" to _uM("type" to "String", "default" to "50px"), "adsorption" to _uM("type" to "Boolean", "default" to true), "disabled" to _uM("type" to "Boolean", "default" to false), "zIndex" to _uM("type" to "Number", "default" to 87)))
        var propsNeedCastKeys = _uA(
            "duration",
            "threshold",
            "thresholdTop",
            "thresholdBottom",
            "round",
            "offset",
            "bgColor",
            "width",
            "height",
            "adsorption",
            "disabled",
            "zIndex"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
