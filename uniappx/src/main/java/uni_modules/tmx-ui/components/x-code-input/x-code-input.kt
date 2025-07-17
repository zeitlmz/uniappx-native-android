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
open class GenUniModulesTmxUiComponentsXCodeInputXCodeInput : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this._autoFocus = this.autoFocus
        }
        , __ins)
        onBeforeUnmount(fun() {
            clearTimeout(this.tid)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newval: String) {
            if (newval == this.inputvalue) {
                return
            }
            this.inputvalue = newval
            var len = newval.split("").length
            if (len == this._maxLength) {
                this.`$emit`("confirm", this.inputvalue)
            }
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_skeleton = resolveEasyComponent("x-skeleton", GenUniModulesTmxUiComponentsXSkeletonXSkeletonClass)
        return createElementVNode("view", utsMapOf("onClick" to _ctx.onClick, "class" to "xCodeInput"), utsArrayOf(
            if (isTrue(_ctx.useSysKeyborad)) {
                createElementVNode("input", utsMapOf("key" to 0, "onFocus" to _ctx.onFocus, "focus" to _ctx._autoFocus, "adjust-position" to false, "style" to normalizeStyle(utsMapOf("width" to "100%", "height" to _ctx._height)), "onConfirm" to _ctx.onconfirm, "onInput" to utsArrayOf(
                    _ctx.inputEvent,
                    fun(`$event`: InputEvent){
                        _ctx.inputvalue = `$event`.detail.value
                    }
                ), "modelValue" to _ctx.inputvalue, "onBlur" to _ctx.blur, "auto-focus" to _ctx._autoFocus, "class" to "xCodeInputInput", "type" to "number"), null, 44, utsArrayOf(
                    "onFocus",
                    "focus",
                    "onConfirm",
                    "onInput",
                    "modelValue",
                    "onBlur",
                    "auto-focus"
                ))
            } else {
                createCommentVNode("v-if", true)
            }
            ,
            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx._maxLength, fun(_, index, __index, _cached): Any {
                return createElementVNode("view", utsMapOf("class" to "xCodeInputItem", "style" to normalizeStyle(utsMapOf("borderRadius" to _ctx._round, "border" to ("2px solid " + _ctx.borderColorAc(index)), "backgroundColor" to if (_ctx.skin == "fill") {
                    _ctx._bgcolor
                } else {
                    "transparent"
                }
                , "width" to _ctx._width, "height" to _ctx._height, "marginRight" to if ((index == _ctx._maxLength - 1)) {
                    "0px"
                } else {
                    _ctx._gutter
                }
                )), "key" to index), utsArrayOf(
                    if (isTrue(_ctx.showNumber)) {
                        createElementVNode("text", utsMapOf("key" to 0, "class" to normalizeClass(utsArrayOf(
                            utsArrayOf(
                                if ((index <= _ctx.inputvalue.length)) {
                                    "xCodeInputItemTextOn"
                                } else {
                                    "xCodeInputItemTextOff"
                                }
                            ),
                            "xCodeInputItemText"
                        )), "style" to normalizeStyle(utsMapOf("fontWeight" to "bold", "color" to _ctx._fontColor, "fontSize" to _ctx._fontSize))), toDisplayString(_ctx.getValue(index)), 7)
                    } else {
                        if (_ctx.getValue(index) != "") {
                            createElementVNode("view", utsMapOf("key" to 1, "class" to normalizeClass(utsArrayOf(
                                utsArrayOf(
                                    if ((index <= _ctx.inputvalue.length)) {
                                        "xCodeInputItemTextOn"
                                    } else {
                                        "xCodeInputItemTextOff"
                                    }
                                ),
                                "xCodeInputItemText"
                            )), "style" to normalizeStyle(utsMapOf("backgroundColor" to _ctx._fontColor, "width" to "34rpx", "height" to "34rpx", "borderRadius" to "17rpx"))), null, 6)
                        } else {
                            createCommentVNode("v-if", true)
                        }
                    }
                    ,
                    if (isTrue((index <= _ctx.inputvalue.length) && _ctx.getValue(index) == "" && _ctx.placeShape == "round")) {
                        createVNode(_component_x_skeleton, utsMapOf("key" to 2, "height" to "5", "width" to "5", "color" to _ctx._borderColor, "dark-color" to _ctx._borderColor), null, 8, utsArrayOf(
                            "color",
                            "dark-color"
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    }
                    ,
                    if (isTrue((index <= _ctx.inputvalue.length) && _ctx.getValue(index) == "" && _ctx.placeShape == "line")) {
                        createVNode(_component_x_skeleton, utsMapOf("key" to 3, "height" to "2", "width" to "33%", "color" to _ctx._borderColor, "dark-color" to _ctx._borderColor), null, 8, utsArrayOf(
                            "color",
                            "dark-color"
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    }
                ), 4)
            }
            ), 128)
        ), 8, utsArrayOf(
            "onClick"
        ))
    }
    open var showNumber: Boolean by `$props`
    open var autoFocus: Boolean by `$props`
    open var useSysKeyborad: Boolean by `$props`
    open var modelValue: String by `$props`
    open var maxlength: Number by `$props`
    open var gutter: String by `$props`
    open var width: String by `$props`
    open var height: String by `$props`
    open var fontColor: String by `$props`
    open var darkFontColor: String by `$props`
    open var fontSize: String by `$props`
    open var round: String by `$props`
    open var bgColor: String by `$props`
    open var darkBgColor: String by `$props`
    open var borderColor: String by `$props`
    open var darkBorderColor: String by `$props`
    open var unBorderColor: String by `$props`
    open var unDarkBorderColor: String by `$props`
    open var skin: String by `$props`
    open var placeShape: String by `$props`
    open var _autoFocus: Boolean by `$data`
    open var inputvalue: String by `$data`
    open var tid: Number by `$data`
    open var _fontColor: String by `$data`
    open var _borderColor: String by `$data`
    open var _unborderColor: String by `$data`
    open var _bgcolor: String by `$data`
    open var _fontSize: String by `$data`
    open var _maxLength: Number by `$data`
    open var _round: String by `$data`
    open var _gutter: String by `$data`
    open var _width: String by `$data`
    open var _height: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("_autoFocus" to false, "inputvalue" to "", "tid" to 0, "_fontColor" to computed<String>(fun(): String {
            var fontcolor = if (this.fontColor == "") {
                xConfig.color
            } else {
                this.fontColor
            }
            var darkFontcolor = if (this.darkFontColor == "") {
                fontcolor
            } else {
                this.darkFontColor
            }
            if (xConfig.dark == "dark") {
                return getDefaultColor(darkFontcolor)
            }
            return getDefaultColor(fontcolor)
        }
        ), "_borderColor" to computed<String>(fun(): String {
            var outLineColor = if (this.borderColor == "") {
                xConfig.color
            } else {
                this.borderColor
            }
            var darkOutlineColor = if (this.darkBorderColor == "") {
                this._fontColor
            } else {
                this.darkBorderColor
            }
            if (xConfig.dark == "dark") {
                return getDefaultColor(darkOutlineColor)
            }
            return getDefaultColor(outLineColor)
        }
        ), "_unborderColor" to computed<String>(fun(): String {
            var unBorderColor = if (this.unBorderColor == "") {
                this._fontColor
            } else {
                this.unBorderColor
            }
            var unDarkBorderColor = if (this.unDarkBorderColor == "") {
                this._fontColor
            } else {
                this.unDarkBorderColor
            }
            if (xConfig.dark == "dark") {
                return getDefaultColor(unDarkBorderColor)
            }
            return getDefaultColor(unBorderColor)
        }
        ), "_bgcolor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                return getDefaultColor(this.darkBgColor)
            }
            return getDefaultColor(this.bgColor)
        }
        ), "_fontSize" to computed<String>(fun(): String {
            var fontSize = checkIsCssUnit(this.fontSize, xConfig.unit)
            if (xConfig.fontScale == 1) {
                return fontSize
            }
            var sizeNumber = parseInt(fontSize)
            if (isNaN(sizeNumber)) {
                sizeNumber = 21
            }
            return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
        }
        ), "_maxLength" to computed<Number>(fun(): Number {
            return this.maxlength
        }
        ), "_round" to computed<String>(fun(): String {
            return checkIsCssUnit(this.round, xConfig.unit)
        }
        ), "_gutter" to computed<String>(fun(): String {
            return checkIsCssUnit(this.gutter, xConfig.unit)
        }
        ), "_width" to computed<String>(fun(): String {
            return checkIsCssUnit(this.width, xConfig.unit)
        }
        ), "_height" to computed<String>(fun(): String {
            return checkIsCssUnit(this.height, xConfig.unit)
        }
        ))
    }
    open var inputEvent = ::gen_inputEvent_fn
    open fun gen_inputEvent_fn(evt: UniInputEvent): String {
        var value = evt.detail.value
        var len = value.split("").length
        if (len > this._maxLength) {
            this.inputvalue = value
            var t = this
            clearTimeout(t.tid)
            t.tid = setTimeout(fun() {
                t.inputvalue = value.substring(0, this._maxLength)
            }
            , 100)
            return this.inputvalue
        }
        this.inputvalue = value
        this.`$emit`("update:modelValue", this.inputvalue)
        if (len == this._maxLength) {
            this.`$nextTick`(fun(){
                this.`$emit`("confirm", this.inputvalue)
                this._autoFocus = false
            }
            )
        }
        this.`$emit`("change", this.inputvalue)
        return this.inputvalue
    }
    open var onClick = ::gen_onClick_fn
    open fun gen_onClick_fn() {
        this.`$emit`("click", this.inputvalue)
        this._autoFocus = true
    }
    open var getValue = ::gen_getValue_fn
    open fun gen_getValue_fn(index: Number): String {
        if (index > this.inputvalue.length - 1) {
            return ""
        }
        return this.inputvalue.split("")[index]
    }
    open var onconfirm = ::gen_onconfirm_fn
    open fun gen_onconfirm_fn() {
        this.`$emit`("update:modelValue", this.inputvalue)
        this.`$nextTick`(fun(){
            this.`$emit`("confirm", this.inputvalue)
        }
        )
        this._autoFocus = false
    }
    open var borderColorAc = ::gen_borderColorAc_fn
    open fun gen_borderColorAc_fn(index: Number): String {
        var isActive = this.inputvalue.split("").length >= index
        if (!isActive) {
            if (this.skin == "fill") {
                return "transparent"
            }
        }
        return if (isActive) {
            this._borderColor
        } else {
            this._unborderColor
        }
    }
    open var blur = ::gen_blur_fn
    open fun gen_blur_fn() {
        this._autoFocus = false
    }
    open var onFocus = ::gen_onFocus_fn
    open fun gen_onFocus_fn() {
        var len = this.inputvalue.split("").length
        if (len > this._maxLength) {
            this.inputvalue = this.inputvalue.substring(0, this._maxLength)
        }
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xCodeInputItemText" to padStyleMapOf(utsMapOf("transitionProperty" to "transform,opacity", "transitionDuration" to "250ms", "transitionTimingFunction" to "linear", "transitionDelay" to "50ms")), "xCodeInputItemTextOn" to padStyleMapOf(utsMapOf("transform" to "scale(1)", "opacity" to 1)), "xCodeInputItemTextOff" to padStyleMapOf(utsMapOf("transform" to "scale(0)", "opacity" to 0)), "xCodeInputItem" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "transitionProperty" to "backgroundColor,borderColor", "transitionDuration" to "250ms", "transitionTimingFunction" to "linear")), "xCodeInput" to padStyleMapOf(utsMapOf("position" to "relative", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "xCodeInputInput" to padStyleMapOf(utsMapOf("opacity" to 0, "position" to "absolute", "left" to -1000, "top" to -1000, "zIndex" to -1)), "@TRANSITION" to utsMapOf("xCodeInputItemText" to utsMapOf("property" to "transform,opacity", "duration" to "250ms", "timingFunction" to "linear", "delay" to "50ms"), "xCodeInputItem" to utsMapOf("property" to "backgroundColor,borderColor", "duration" to "250ms", "timingFunction" to "linear")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("click" to null, "confirm" to null, "change" to null, "update:modelValue" to null)
        var props = normalizePropsOptions(utsMapOf("showNumber" to utsMapOf("type" to "Boolean", "default" to true), "autoFocus" to utsMapOf("type" to "Boolean", "default" to false), "useSysKeyborad" to utsMapOf("type" to "Boolean", "default" to true), "modelValue" to utsMapOf("type" to "String", "default" to ""), "maxlength" to utsMapOf("type" to "Number", "default" to 4), "gutter" to utsMapOf("type" to "String", "default" to "8"), "width" to utsMapOf("type" to "String", "default" to "50"), "height" to utsMapOf("type" to "String", "default" to "50"), "fontColor" to utsMapOf("type" to "String", "default" to ""), "darkFontColor" to utsMapOf("type" to "String", "default" to ""), "fontSize" to utsMapOf("type" to "String", "default" to "21"), "round" to utsMapOf("type" to "String", "default" to "8"), "bgColor" to utsMapOf("type" to "String", "default" to "#f0f0f0"), "darkBgColor" to utsMapOf("type" to "String", "default" to "#272727"), "borderColor" to utsMapOf("type" to "String", "default" to ""), "darkBorderColor" to utsMapOf("type" to "String", "default" to ""), "unBorderColor" to utsMapOf("type" to "String", "default" to "#e3e3e3"), "unDarkBorderColor" to utsMapOf("type" to "String", "default" to "#2c2b2c"), "skin" to utsMapOf("type" to "String", "default" to "outline"), "placeShape" to utsMapOf("type" to "String", "default" to "round")))
        var propsNeedCastKeys = utsArrayOf(
            "showNumber",
            "autoFocus",
            "useSysKeyborad",
            "modelValue",
            "maxlength",
            "gutter",
            "width",
            "height",
            "fontColor",
            "darkFontColor",
            "fontSize",
            "round",
            "bgColor",
            "darkBgColor",
            "borderColor",
            "darkBorderColor",
            "unBorderColor",
            "unDarkBorderColor",
            "skin",
            "placeShape"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
