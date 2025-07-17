@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI09580B7
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
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
open class GenUniModulesTmxUiComponentsXFingerXFinger : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.el = this.`$refs`[this.id] as UniElement
            uni_createSelectorQuery().`in`(this).select(".finger").boundingClientRect().exec(fun(ret){
                var nodeinfo = ret[0] as NodeInfo
                this.left = nodeinfo.left as Number
                this.top = nodeinfo.top as Number
            }
            )
            var t = this
            this.getRectBox(fun(rect){
                t.parentRect = rect
            }
            )
        }
        , __ins)
        onBeforeUnmount(fun() {
            clearTimeout(this.tid)
        }
        , __ins)
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return createElementVNode("view", utsMapOf("id" to _ctx.id, "ref" to _ctx.id, "class" to "finger", "onTouchstart" to _ctx.mStart, "onTouchmove" to _ctx.mMove, "onTouchend" to _ctx.mEnd, "onTouchcancel" to _ctx.mCancel), utsArrayOf(
            renderSlot(_ctx.`$slots`, "default", GenUniModulesTmxUiComponentsXFingerXFingerSlotDataDefault(x = _ctx.mX, y = _ctx.mY, type = _ctx.eventName))
        ), 40, utsArrayOf(
            "id",
            "onTouchstart",
            "onTouchmove",
            "onTouchend",
            "onTouchcancel"
        ))
    }
    open var swiperDiff: Number by `$props`
    open var dbClickDiff: Number by `$props`
    open var clickDiff: Number by `$props`
    open var longDiff: Number by `$props`
    open var disabled: Boolean by `$props`
    open var isMouseDown: Boolean by `$data`
    open var wheelScale: Number by `$data`
    open var wheelDelta: Number by `$data`
    open var dubleTime: Number by `$data`
    open var tid: Number by `$data`
    open var _x: Number by `$data`
    open var _y: Number by `$data`
    open var _start_x: Number by `$data`
    open var _start_y: Number by `$data`
    open var eventName: String by `$data`
    open var mX: Number by `$data`
    open var mY: Number by `$data`
    open var swipeDirection: String by `$data`
    open var el: Element? by `$data`
    open var left: Number by `$data`
    open var top: Number by `$data`
    open var id: Any? by `$data`
    open var zoomFactor: Number by `$data`
    open var zoomFactorAb: Number by `$data`
    open var pinchStartLen: Number by `$data`
    open var scale: Number by `$data`
    open var angle: Number by `$data`
    open var pinth_x: Number by `$data`
    open var pinth_y: Number by `$data`
    open var preV: CHECKPOINT_XY by `$data`
    open var parentRect: DRect by `$data`
    open var _disabled: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("isMouseDown" to false, "wheelScale" to 1, "wheelDelta" to 0.1, "dubleTime" to 0, "tid" to 56, "_x" to 0, "_y" to 0, "_start_x" to 0, "_start_y" to 0, "eventName" to "", "mX" to 0, "mY" to 0, "swipeDirection" to "", "el" to null as Element?, "left" to 0, "top" to 0, "id" to ("xFinGer" + getUid()), "zoomFactor" to 0.55, "zoomFactorAb" to 0.03, "pinchStartLen" to 0, "scale" to 0, "angle" to 0, "pinth_x" to 0, "pinth_y" to 0, "preV" to CHECKPOINT_XY(x = null, y = null), "parentRect" to DRect(left = 0, right = 0, top = 0, bottom = 0, width = 0, height = 0), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ))
    }
    open var getLen = ::gen_getLen_fn
    open fun gen_getLen_fn(v: CHECKPOINT_XY): Number {
        if (v.x == null || v.y == null) {
            return 0
        }
        return Math.hypot(v.x!!, v.y!!)
    }
    open var dot = ::gen_dot_fn
    open fun gen_dot_fn(v1: CHECKPOINT_XY, v2: CHECKPOINT_XY): Number {
        if (v1.x == null || v1.y == null || v2.x == null || v2.y == null) {
            return 0
        }
        return v1.x!! * v2.x!! + v1.y!! * v2.y!!
    }
    open var getRectBox = ::gen_getRectBox_fn
    open fun gen_getRectBox_fn(call: (rect: DRect) -> Unit) {
        var ele = this.`$refs`[this.id] as UniElement
        var rectBox = DRect(left = 0, right = 0, top = 0, bottom = 0, width = 0, height = 0)
        var erct = ele.getBoundingClientRect()
        rectBox = DRect(left = erct.left, right = erct.right, top = erct.top, bottom = erct.bottom, width = erct.width, height = erct.height)
        call(rectBox)
    }
    open var getAngle = ::gen_getAngle_fn
    open fun gen_getAngle_fn(v1: CHECKPOINT_XY, v2: CHECKPOINT_XY): Number {
        var mr = this.getLen(v1) * this.getLen(v2)
        if (mr === 0) {
            return 0
        }
        var r = this.dot(v1, v2) / mr
        if (r > 1) {
            r = 1
        }
        var jd = Math.acos(r)
        jd = jd * ((180 as Number) / Math.PI)
        return (jd + 360) % 360
    }
    open var cross = ::gen_cross_fn
    open fun gen_cross_fn(v1: CHECKPOINT_XY, v2: CHECKPOINT_XY): Number {
        if (v1.x == null || v1.y == null || v2.x == null || v2.y == null) {
            return 0
        }
        return v1.x!! * v2.y!! - v2.x!! * v1.y!!
    }
    open var getRotateAngle = ::gen_getRotateAngle_fn
    open fun gen_getRotateAngle_fn(v1: CHECKPOINT_XY, v2: CHECKPOINT_XY): Number {
        var angle = this.getAngle(v1, v2)
        if (this.cross(v1, v2) > 0) {
            angle *= -1
        }
        return angle * 180 / Math.PI
    }
    open var mStart = ::gen_mStart_fn
    open fun gen_mStart_fn(evt: UniTouchEvent) {
        if (this._disabled) {
            return
        }
        var el = this.el!!
        var event = evt.changedTouches[0]
        var _this = this
        clearTimeout(_this.tid)
        var rectBox = _this.parentRect
        _this._x = event.clientX - rectBox.left
        _this._y = event.clientY - rectBox.top
        _this._start_x = event.clientX - rectBox.left - _this.mX
        _this._start_y = event.clientY - rectBox.top - _this.mY
        _this.swipeDirection = ""
        _this.`$emit`("start", object : UTSJSONObject() {
            var x = _this._start_x
            var y = _this._start_y
            var type = "start"
            var width = rectBox.width
            var height = rectBox.height
        })
        _this.eventName = "start"
        var difftime = Date().getTime() - _this.dubleTime
        if (difftime > 0 && difftime <= _this.dbClickDiff) {
            _this.`$emit`("doubleClick", object : UTSJSONObject() {
                var x = _this._start_x
                var y = _this._start_y
                var type = "doubleClick"
                var width = rectBox.width
                var height = rectBox.height
            })
            _this.eventName = "doubleClick"
        }
        _this.dubleTime = Date().getTime()
        if (evt.changedTouches.length >= 2) {
            _this.pinth_x = evt.touches[0].pageX
            _this.pinth_y = evt.touches[0].pageY
            var otx = evt.touches[1].pageX
            var oty = evt.touches[1].pageY
            var preV = CHECKPOINT_XY(x = otx - _this.pinth_x, y = oty - _this.pinth_y)
            _this.preV = preV
            _this.pinchStartLen = _this.getLen(preV)
        }
        _this.tid = setTimeout(fun() {
            _this.`$emit`("longPress", object : UTSJSONObject() {
                var x = _this._start_x
                var y = _this._start_y
                var type = "longPress"
                var width = rectBox.width
                var height = rectBox.height
            })
            _this.eventName = "longPress"
        }
        , _this.longDiff)
    }
    open var mMove = ::gen_mMove_fn
    open fun gen_mMove_fn(evt: UniTouchEvent) {
        if (this._disabled) {
            return
        }
        var event = evt.changedTouches[0]
        var el = this.el!!
        var rectBox = this.parentRect
        var x = event.clientX - rectBox.left
        var y = event.clientY - rectBox.top
        var deltaX = Math.abs(x - this._x)
        var deltaY = Math.abs(y - this._y)
        this.mX = Math.max(0, Math.min(rectBox.width, x)) - this._start_x
        this.mY = Math.max(0, Math.min(rectBox.height, y)) - this._start_y
        if (deltaX > deltaY && deltaX > this.swiperDiff) {
            this.swipeDirection = if ((this._x > x)) {
                "left"
            } else {
                "right"
            }
        } else if (deltaY > deltaX && deltaY > this.swiperDiff) {
            this.swipeDirection = if ((this._y < y)) {
                "down"
            } else {
                "up"
            }
        }
        if (this.swipeDirection != "") {
            this.`$emit`("swiper", let {
                object : UTSJSONObject() {
                    var x = it.mX
                    var y = it.mY
                    var diffX = deltaX
                    var diffY = deltaY
                    var direction = it.swipeDirection
                    var type = "swiper"
                    var width = rectBox.width
                    var height = rectBox.height
                }
            })
            this.eventName = "swiper"
        }
        this.`$emit`("move", let {
            object : UTSJSONObject() {
                var x = it.mX
                var y = it.mY
                var type = "move"
                var width = rectBox.width
                var height = rectBox.height
            }
        })
        this.eventName = "move"
        clearTimeout(this.tid)
        if (evt.changedTouches.length >= 2) {
            var currentX = evt.touches[0].pageX
            var currentY = evt.touches[0].pageY
            var otx = evt.touches[1].pageX
            var oty = evt.touches[1].pageY
            var v = CHECKPOINT_XY(x = otx - currentX, y = oty - currentY)
            if (this.preV.x != null) {
                var nowLenPitch = this.getLen(v)
                if (this.pinchStartLen > 0) {
                    var temsc = (nowLenPitch / this.pinchStartLen)
                    val deltaScale = (temsc - 1) * this.zoomFactor + this.scale
                    this.scale = Math.max(deltaScale, 0.1)
                    this.`$emit`("pinch", let {
                        object : UTSJSONObject() {
                            var x = currentX
                            var y = currentY
                            var x1 = otx
                            var y2 = oty
                            var type = "pinch"
                            var width = rectBox.width
                            var height = rectBox.height
                            var len = nowLenPitch
                            var scale = it.scale
                        }
                    })
                }
                var testjd = this.getRotateAngle(v, this.preV)
                this.angle = Math.floor((testjd - 1) * this.zoomFactorAb) + this.angle
                this.pinchStartLen = nowLenPitch
                this.`$emit`("rotate", let {
                    object : UTSJSONObject() {
                        var x = currentX
                        var y = currentY
                        var x1 = otx
                        var y2 = oty
                        var type = "rotate"
                        var width = rectBox.width
                        var height = rectBox.height
                        var len = nowLenPitch
                        var angle = it.angle
                    }
                })
            }
            this.preV = v
        }
    }
    open var mEnd = ::gen_mEnd_fn
    open fun gen_mEnd_fn(evt: UniTouchEvent) {
        clearTimeout(this.tid)
        var _this = this
        this.getRectBox(fun(rect: DRect){
            _this.parentRect = rect
        }
        )
        if (this._disabled) {
            return
        }
        var event = evt.changedTouches[0]
        var el = this.el!!
        var rectBox = this.parentRect
        var x = event.clientX - rectBox.left
        var y = event.clientY - rectBox.top
        this.mX = Math.max(0, Math.min(rectBox.width, x)) - this._start_x
        this.mY = Math.max(0, Math.min(rectBox.height, y)) - this._start_y
        this.`$emit`("end", let {
            object : UTSJSONObject() {
                var x = it.mX
                var y = it.mY
                var type = "end"
                var width = rectBox.width
                var height = rectBox.height
            }
        })
        this.eventName = "end"
        if (Date().getTime() - this.dubleTime > this.clickDiff) {
            this.`$emit`("click", let {
                object : UTSJSONObject() {
                    var x = it.mX
                    var y = it.mY
                    var type = "click"
                    var width = rectBox.width
                    var height = rectBox.height
                }
            })
            this.eventName = "click"
        }
        this.preV = CHECKPOINT_XY(x = 0, y = 0)
        this.pinchStartLen = 0
    }
    open var mCancel = ::gen_mCancel_fn
    open fun gen_mCancel_fn(evt: UniTouchEvent) {
        clearTimeout(this.tid)
        var _this = this
        this.getRectBox(fun(rect: DRect){
            _this.parentRect = rect
        }
        )
        if (this._disabled) {
            return
        }
        var event = evt.changedTouches[0]
        var el = this.el!!
        var rectBox = this.parentRect
        var x = event.clientX - rectBox.left
        var y = event.clientY - rectBox.top
        this.mX = Math.max(0, Math.min(rectBox.width, x)) - this._start_x
        this.mY = Math.max(0, Math.min(rectBox.height, y)) - this._start_y
        this.`$emit`("cancel", let {
            object : UTSJSONObject() {
                var x = it.mX
                var y = it.mY
                var type = "end"
                var width = rectBox.width
                var height = rectBox.height
            }
        })
        this.eventName = "cancel"
        this.preV = CHECKPOINT_XY(x = 0, y = 0)
        this.pinchStartLen = 0
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("start" to null, "move" to null, "end" to null, "cancel" to null, "doubleClick" to null, "longPress" to null, "swiper" to null, "click" to null, "pinch" to null, "rotate" to null)
        var props = normalizePropsOptions(utsMapOf("swiperDiff" to utsMapOf("type" to "Number", "default" to 50), "dbClickDiff" to utsMapOf("type" to "Number", "default" to 300), "clickDiff" to utsMapOf("type" to "Number", "default" to 50), "longDiff" to utsMapOf("type" to "Number", "default" to 800), "disabled" to utsMapOf("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = utsArrayOf(
            "swiperDiff",
            "dbClickDiff",
            "clickDiff",
            "longDiff",
            "disabled"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
