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
import io.dcloud.uniapp.extapi.rpx2px as uni_rpx2px
open class GenUniModulesTmxUiComponentsXRateXRate : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.score = this.modelValue
            if (this.half) {
                this.setDefaultHalfStatus()
            }
        }
        , __ins)
        onBeforeMount(fun() {
            this.isWEBPC = this.isPcMouse()
        }
        , __ins)
        onBeforeUnmount(fun() {
            if (this.xani != null) {
                this.xani!!.stop()
                this.xani = null
            }
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newvalue: Number) {
            if (newvalue == this.score) {
                return
            }
            this.score = this.modelValue
            if (this.half) {
                this.setDefaultHalfStatus()
            }
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        return createElementVNode("view", utsMapOf("class" to "xRate", "style" to normalizeStyle(utsMapOf("opacity" to if (_ctx._disabled) {
            0.7
        } else {
            1
        }
        ))), utsArrayOf(
            createElementVNode("view", utsMapOf("ref" to "xRateWrap", "class" to "xRateWrap", "onTouchstart" to _ctx._msMStart, "onTouchmove" to _ctx._msMMove, "onTouchend" to _ctx._msMEnd), utsArrayOf(
                if (isTrue(!_ctx.half)) {
                    createElementVNode(Fragment, utsMapOf("key" to 0), RenderHelpers.renderList(_ctx._count, fun(index, __key, __index, _cached): Any {
                        return createElementVNode("view", utsMapOf("ref_for" to true, "ref" to ("rate-" + index), "key" to index), utsArrayOf(
                            createVNode(_component_x_icon, utsMapOf("onClick" to fun(){
                                _ctx.onClick(index)
                            }, "style" to normalizeStyle(utsMapOf("marginRight" to if (index == _ctx._count) {
                                "0rpx"
                            } else {
                                _ctx._space
                            })), "font-size" to _ctx._size, "color" to if (_ctx.isSelected(index)) {
                                _ctx._color
                            } else {
                                _ctx._unColor
                            }, "dark-color" to if (_ctx.isSelected(index)) {
                                _ctx._color
                            } else {
                                _ctx._unColor
                            }, "name" to if (_ctx.isSelected(index)) {
                                _ctx.icon
                            } else {
                                _ctx.unicon
                            }), null, 8, utsArrayOf(
                                "onClick",
                                "style",
                                "font-size",
                                "color",
                                "dark-color",
                                "name"
                            ))
                        ))
                    }), 128)
                } else {
                    createCommentVNode("v-if", true)
                }
                ,
                if (isTrue(_ctx.half)) {
                    createElementVNode(Fragment, utsMapOf("key" to 1), RenderHelpers.renderList(_ctx._count, fun(index, __key, __index, _cached): Any {
                        return createElementVNode("view", utsMapOf("ref_for" to true, "ref" to ("rate-" + index), "key" to index, "style" to normalizeStyle(utsMapOf("position" to "relative"))), utsArrayOf(
                            createVNode(_component_x_icon, utsMapOf("style" to normalizeStyle(utsMapOf("marginRight" to if (index == _ctx._count) {
                                "0rpx"
                            } else {
                                _ctx._space
                            }, "marginLeft" to if (index == 0) {
                                "0rpx"
                            } else {
                                _ctx._space
                            })), "font-size" to _ctx._size, "color" to if (_ctx.isSelected(index)) {
                                _ctx._color
                            } else {
                                _ctx._unColor
                            }, "dark-color" to if (_ctx.isSelected(index)) {
                                _ctx._color
                            } else {
                                _ctx._unColor
                            }, "name" to _ctx.isSelectedHalf(index)), null, 8, utsArrayOf(
                                "style",
                                "font-size",
                                "color",
                                "dark-color",
                                "name"
                            )),
                            createElementVNode("view", utsMapOf("onClick" to fun(){
                                _ctx.onClickHalf(index, 1)
                            }, "class" to "xRateLeft"), null, 8, utsArrayOf(
                                "onClick"
                            )),
                            createElementVNode("view", utsMapOf("onClick" to fun(){
                                _ctx.onClickHalf(index, 2)
                            }, "class" to "xRateRight"), null, 8, utsArrayOf(
                                "onClick"
                            ))
                        ), 4)
                    }), 128)
                } else {
                    createCommentVNode("v-if", true)
                }
            ), 40, utsArrayOf(
                "onTouchstart",
                "onTouchmove",
                "onTouchend"
            )),
            renderSlot(_ctx.`$slots`, "score", utsMapOf("score" to _ctx.score), fun(): UTSArray<Any> {
                return utsArrayOf(
                    if (isTrue(_ctx._showScore)) {
                        createElementVNode("text", utsMapOf("key" to 0, "class" to "xRateText", "style" to normalizeStyle(utsMapOf("color" to _ctx._color, "fontSize" to _ctx._fontSize))), toDisplayString(_ctx.score.toFixed(1)), 5)
                    } else {
                        createCommentVNode("v-if", true)
                    }
                )
            }
            )
        ), 4)
    }
    open var modelValue: Number by `$props`
    open var count: Number by `$props`
    open var color: String by `$props`
    open var unColor: String by `$props`
    open var darkUnColor: String by `$props`
    open var size: String by `$props`
    open var space: String by `$props`
    open var icon: String by `$props`
    open var unicon: String by `$props`
    open var readonly: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var showScore: Boolean by `$props`
    open var fontSize: String by `$props`
    open var half: Boolean by `$props`
    open var score: Number by `$data`
    open var xani: xAnimate? by `$data`
    open var clickStartIndex: Number by `$data`
    open var clickStartStatus: Number by `$data`
    open var isWEBPC: Boolean by `$data`
    open var _x: Number by `$data`
    open var _y: Number by `$data`
    open var _isMove: Boolean by `$data`
    open var _parentBounds: dDrect by `$data`
    open var _isWEBmoveSelecteIndex: Number by `$data`
    open var _disabled: Boolean by `$data`
    open var _readonly: Boolean by `$data`
    open var _count: Number by `$data`
    open var _size: String by `$data`
    open var _sizeUnUnit: Number by `$data`
    open var _fontSize: String by `$data`
    open var _space: String by `$data`
    open var _color: String by `$data`
    open var _unColor: String by `$data`
    open var _showScore: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("score" to 0, "xani" to null as xAnimate?, "clickStartIndex" to -1, "clickStartStatus" to 0, "isWEBPC" to false, "_x" to 0, "_y" to 0, "_isMove" to false, "_parentBounds" to dDrect(x = 0, y = 0, width = 0, height = 0, space = 0), "_isWEBmoveSelecteIndex" to -1, "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ), "_readonly" to computed<Boolean>(fun(): Boolean {
            return this.readonly
        }
        ), "_count" to computed<Number>(fun(): Number {
            return this.count
        }
        ), "_size" to computed<String>(fun(): String {
            return this.size
        }
        ), "_sizeUnUnit" to computed<Number>(fun(): Number {
            var fontSize = checkIsCssUnit(this.size, xConfig.unit)
            var sizeNumber = parseInt(fontSize)
            val unit = getUnit(fontSize)
            if (isNaN(sizeNumber)) {
                sizeNumber = 21
            }
            if (unit == "rpx") {
                sizeNumber = uni_rpx2px(sizeNumber)
            }
            return sizeNumber
        }
        ), "_fontSize" to computed<String>(fun(): String {
            var fontSize = checkIsCssUnit(this.fontSize, xConfig.unit)
            if (xConfig.fontScale == 1) {
                return fontSize
            }
            var sizeNumber = parseInt(fontSize)
            if (isNaN(sizeNumber)) {
                sizeNumber = 14
            }
            return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
        }
        ), "_space" to computed<String>(fun(): String {
            return checkIsCssUnit(this.space, xConfig.unit)
        }
        ), "_color" to computed<String>(fun(): String {
            if (this.color == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.color)
        }
        ), "_unColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                if (this.darkUnColor == "") {
                    return getDefaultColor(xConfig.inputDarkColor)
                } else {
                    return getDefaultColor(this.darkUnColor)
                }
            }
            return getDefaultColor(this.unColor)
        }
        ), "_showScore" to computed<Boolean>(fun(): Boolean {
            return this.showScore
        }
        ))
    }
    open var isPcMouse = ::gen_isPcMouse_fn
    open fun gen_isPcMouse_fn(): Boolean {
        var ispc = false
        return ispc
    }
    open var setDefaultHalfStatus = ::gen_setDefaultHalfStatus_fn
    open fun gen_setDefaultHalfStatus_fn() {
        if (this.score == 0) {
            return
        }
        this.clickStartIndex = this.score
        var fillCount = Math.ceil(this.score)
        this.clickStartStatus = if (this.score == (fillCount - 0.5)) {
            1
        } else {
            2
        }
    }
    open var isSelected = ::gen_isSelected_fn
    open fun gen_isSelected_fn(index: Number): Boolean {
        if (this.half) {
            return this.score >= index - 0.5
        }
        return this.score >= index
    }
    open var isSelectedHalf = ::gen_isSelectedHalf_fn
    open fun gen_isSelectedHalf_fn(index: Number): String {
        if (this.score > index) {
            return "star-fill"
        }
        if (this.score < index - 0.5) {
            return "star-line"
        }
        if (this.clickStartStatus == 1) {
            return "star-half-fill"
        }
        if (this.clickStartStatus == 2) {
            return "star-fill"
        }
        return "star-line"
    }
    open var onClickHalf = ::gen_onClickHalf_fn
    open fun gen_onClickHalf_fn(index: Number, type: Number) {
        if (this._readonly || this._disabled) {
            return
        }
        this.score = if (type == 1) {
            index - 0.5
        } else {
            index
        }
        this.clickStartStatus = type
        this.setUpdate(index)
    }
    open var onClick = ::gen_onClick_fn
    open fun gen_onClick_fn(index: Number) {
        if (this._readonly || this._disabled) {
            return
        }
        this.score = index
        this.setUpdate(index)
        this.clickStartIndex = index
    }
    open var setUpdate = ::gen_setUpdate_fn
    open fun gen_setUpdate_fn(index: Number) {
        this.`$emit`("update:modelValue", this.score)
        this.`$emit`("change", this.score)
        var el = this.`$refs`["rate-" + index.toString(10)]
        var eles = el as UTSArray<UniElement>
        if (this.xani != null) {
            this.xani!!.stop()
        }
        if (eles.length > 0) {
            this.xani = xAnimate(eles[0], XANIMATE_OPIONS(duration = 250, isDescPlay = true))
            this.xani!!.attr("scale", "1", "1.2", false)
            this.xani!!.attr("scale", "1.2", "1", false).play()
        }
    }
    open var _msMStart = ::gen__msMStart_fn
    open fun gen__msMStart_fn(evt: UniTouchEvent) {
        if (this._readonly || this._disabled || this.isWEBPC) {
            return
        }
        var ele = this.`$refs`["xRateWrap"] as UniElement?
        if (ele == null) {
            return
        }
        this._isMove = true
        if (evt.touches.length > 0) {
            this._x = evt.touches[0].clientX
            this._y = evt.touches[0].clientY
        }
        ele.getBoundingClientRectAsync()!!.then(fun(bounds){
            if (bounds != null) {
                this._parentBounds = dDrect(x = bounds.left, y = bounds.top, width = bounds.width, height = bounds.height, space = (bounds.width - this._count * this._sizeUnUnit) / (this._count - 1))
            }
        }
        )
    }
    open var _msMMove = ::gen__msMMove_fn
    open fun gen__msMMove_fn(evt: UniTouchEvent) {
        if (!this._isMove || this._readonly || this._disabled || this.isWEBPC) {
            return
        }
        if (evt.touches.length > 0) {
            var diffx = evt.touches[0].clientX - this._parentBounds.x
            val starWidth = this._sizeUnUnit + this._parentBounds.space
            var currentIndex = Math.ceil(diffx / starWidth)
            if (currentIndex < 1) {
                currentIndex = 1
            }
            if (currentIndex > this._count) {
                currentIndex = this._count
            }
            if (this.half) {
                val posInStar = diffx - (currentIndex - 1) * starWidth
                val isLeft = posInStar <= (this._sizeUnUnit / 2)
                this.score = if (isLeft) {
                    currentIndex - 0.5
                } else {
                    currentIndex
                }
                this.clickStartStatus = if (isLeft) {
                    1
                } else {
                    2
                }
            } else {
                this.score = currentIndex
            }
            this.clickStartIndex = currentIndex
            this._isWEBmoveSelecteIndex = currentIndex
            this.`$emit`("update:modelValue", this.score)
        }
    }
    open var _msMEnd = ::gen__msMEnd_fn
    open fun gen__msMEnd_fn(evt: UniTouchEvent) {
        this._isMove = false
        if (this._isWEBmoveSelecteIndex > 0 && !this._readonly && !this._disabled) {
            this.`$emit`("change", this.score)
            var el = this.`$refs`["rate-" + this._isWEBmoveSelecteIndex.toString(10)]
            var eles = el as UTSArray<UniElement>
            if (this.xani != null) {
                this.xani!!.stop()
            }
            if (eles.length > 0) {
                this.xani = xAnimate(eles[0], XANIMATE_OPIONS(duration = 250, isDescPlay = true))
                this.xani!!.attr("scale", "1", "1.2", false)
                this.xani!!.attr("scale", "1.2", "1", false).play()
            }
        }
        this._isWEBmoveSelecteIndex = -1
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xRateText" to padStyleMapOf(utsMapOf("marginLeft" to 10)), "xRateLeft" to padStyleMapOf(utsMapOf("position" to "absolute", "width" to "50%", "height" to "100%", "top" to 0, "left" to 0)), "xRateRight" to padStyleMapOf(utsMapOf("position" to "absolute", "width" to "50%", "height" to "100%", "top" to 0, "right" to 0)), "xRate" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "flex-start")), "xRateWrap" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "flex-start")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("change" to null, "update:modelValue" to null)
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "Number", "default" to 0), "count" to utsMapOf("type" to "Number", "default" to 5), "color" to utsMapOf("type" to "String", "default" to ""), "unColor" to utsMapOf("type" to "String", "default" to "#cacaca"), "darkUnColor" to utsMapOf("type" to "String", "default" to "#8b8b8b"), "size" to utsMapOf("type" to "String", "default" to "21"), "space" to utsMapOf("type" to "String", "default" to "4"), "icon" to utsMapOf("type" to "String", "default" to "star-fill"), "unicon" to utsMapOf("type" to "String", "default" to "star-line"), "readonly" to utsMapOf("type" to "Boolean", "default" to false), "disabled" to utsMapOf("type" to "Boolean", "default" to false), "showScore" to utsMapOf("type" to "Boolean", "default" to false), "fontSize" to utsMapOf("type" to "String", "default" to "14"), "half" to utsMapOf("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = utsArrayOf(
            "modelValue",
            "count",
            "color",
            "unColor",
            "darkUnColor",
            "size",
            "space",
            "icon",
            "unicon",
            "readonly",
            "disabled",
            "showScore",
            "fontSize",
            "half"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
