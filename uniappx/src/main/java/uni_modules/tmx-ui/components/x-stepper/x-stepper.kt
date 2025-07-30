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
open class GenUniModulesTmxUiComponentsXStepperXStepper : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.setValue(this.modelValue, false)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newval: Number) {
            if (newval == this._value) {
                return
            }
            this.setValue(newval, false)
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        return createElementVNode("view", utsMapOf("class" to "xStepper", "style" to normalizeStyle(utsMapOf("width" to _ctx._width, "borderRadius" to _ctx._round))), utsArrayOf(
            if (isTrue((!_ctx.surDomDisabeld && _ctx.autoHideBtn) || !_ctx.autoHideBtn)) {
                createElementVNode("view", utsMapOf("key" to 0, "hover-start-time" to 20, "hover-stay-time" to 150, "hover-class" to if (_ctx.addDomDisabeld) {
                    ""
                } else {
                    "xStepperHoverbtn"
                }, "onClick" to _ctx.handleDecrement, "class" to "xStepperBtn", "style" to normalizeStyle(utsMapOf("backgroundColor" to _ctx._btnColor, "height" to _ctx._height, "width" to _ctx._btnWidth, "opacity" to if (_ctx.surDomDisabeld) {
                    0.6
                } else {
                    1
                }, "borderRadius" to if (_ctx._splitBtn) {
                    "50px"
                } else {
                    "0rpx"
                }))), utsArrayOf(
                    createVNode(_component_x_icon, utsMapOf("class" to "xStepperBtnBtn", "color" to _ctx._btnFontColor, "font-size" to _ctx._unFontSize, "name" to "subtract-line"), null, 8, utsArrayOf(
                        "color",
                        "font-size"
                    ))
                ), 12, utsArrayOf(
                    "hover-class",
                    "onClick"
                ))
            } else {
                createCommentVNode("v-if", true)
            }
            ,
            if (isTrue((!_ctx.surDomDisabeld && _ctx.autoHideBtn) || !_ctx.autoHideBtn)) {
                createElementVNode("input", utsMapOf("key" to 1, "always-embed" to true, "disabled" to (_ctx._disabledInput || _ctx._disabled), "onBlur" to _ctx.inputBlur, "onInput" to _ctx.handleInputChange, "value" to _ctx._input_value, "class" to "xStepperInput", "style" to normalizeStyle(utsArrayOf(
                    utsMapOf("backgroundColor" to if (_ctx._splitBtn) {
                        "transparent"
                    } else {
                        _ctx._btnColor
                    }, "height" to _ctx._height, "color" to _ctx._fontColor, "fontSize" to _ctx._fontSize),
                    _ctx._inputStyle
                )), "type" to if (_ctx.decimalLen > 0) {
                    "digit"
                } else {
                    "number"
                }), null, 44, utsArrayOf(
                    "disabled",
                    "onBlur",
                    "onInput",
                    "value",
                    "type"
                ))
            } else {
                createCommentVNode("v-if", true)
            }
            ,
            createElementVNode("view", utsMapOf("hover-start-time" to 20, "hover-stay-time" to 150, "hover-class" to if (_ctx.addDomDisabeld) {
                ""
            } else {
                "xStepperHoverbtn"
            }
            , "onClick" to _ctx.handleIncrement, "class" to "xStepperBtn", "style" to normalizeStyle(utsMapOf("backgroundColor" to _ctx._btnColor, "height" to _ctx._height, "width" to _ctx._btnWidth, "borderRadius" to if (_ctx._splitBtn) {
                "50px"
            } else {
                "0rpx"
            }
            ))), utsArrayOf(
                createVNode(_component_x_icon, utsMapOf("class" to "xStepperBtnBtn", "style" to normalizeStyle(utsMapOf("opacity" to if (_ctx.addDomDisabeld) {
                    0.6
                } else {
                    1
                }
                )), "color" to _ctx._btnFontColor, "font-size" to _ctx._unFontSize, "name" to "add-line"), null, 8, utsArrayOf(
                    "style",
                    "color",
                    "font-size"
                ))
            ), 12, utsArrayOf(
                "hover-class",
                "onClick"
            ))
        ), 4)
    }
    open var modelValue: Number by `$props`
    open var max: Number by `$props`
    open var width: String by `$props`
    open var min: Number by `$props`
    open var autoHideBtn: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var disabledInput: Boolean by `$props`
    open var step: Number by `$props`
    open var decimalLen: Number by `$props`
    open var btnColor: String by `$props`
    open var darkBtnColor: String by `$props`
    open var bgColor: String by `$props`
    open var inputStyle: String by `$props`
    open var darkBgColor: String by `$props`
    open var btnWidth: String by `$props`
    open var height: String by `$props`
    open var round: String by `$props`
    open var splitBtn: Boolean by `$props`
    open var btnFontColor: String by `$props`
    open var fontColor: String by `$props`
    open var fontSize: String by `$props`
    open var _value: Number by `$data`
    open var _input_value: String by `$data`
    open var addDomDisabeld: Boolean by `$data`
    open var surDomDisabeld: Boolean by `$data`
    open var _round: String by `$data`
    open var _width: String by `$data`
    open var _inputStyle: String by `$data`
    open var _fontSize: String by `$data`
    open var _unFontSize: String by `$data`
    open var _btnFontColor: String by `$data`
    open var _fontColor: String by `$data`
    open var _height: String by `$data`
    open var _btnWidth: String by `$data`
    open var _splitBtn: Boolean by `$data`
    open var _disabledInput: Boolean by `$data`
    open var _btnColor: String by `$data`
    open var _bgColor: String by `$data`
    open var _max: Number by `$data`
    open var _min: Number by `$data`
    open var _step: Number by `$data`
    open var _disabled: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("_value" to 0, "_input_value" to "", "addDomDisabeld" to false, "surDomDisabeld" to false, "_round" to computed<String>(fun(): String {
            if (this.round == "") {
                return checkIsCssUnit(xConfig.progressRadius, xConfig.unit)
            }
            return checkIsCssUnit(this.round, xConfig.unit)
        }
        ), "_width" to computed<String>(fun(): String {
            return checkIsCssUnit(this.width, xConfig.unit)
        }
        ), "_inputStyle" to computed<String>(fun(): String {
            return this.inputStyle
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
        ), "_unFontSize" to computed<String>(fun(): String {
            return this.fontSize
        }
        ), "_btnFontColor" to computed<String>(fun(): String {
            return getDefaultColor(this.btnFontColor)
        }
        ), "_fontColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                return "#ffffff"
            }
            return getDefaultColor(this.fontColor)
        }
        ), "_height" to computed<String>(fun(): String {
            return checkIsCssUnit(this.height, xConfig.unit)
        }
        ), "_btnWidth" to computed<String>(fun(): String {
            return checkIsCssUnit(this.btnWidth, xConfig.unit)
        }
        ), "_splitBtn" to computed<Boolean>(fun(): Boolean {
            return this.splitBtn
        }
        ), "_disabledInput" to computed<Boolean>(fun(): Boolean {
            return this.disabledInput
        }
        ), "_btnColor" to computed<String>(fun(): String {
            var color = getDefaultColor(this.btnColor)
            if (xConfig.dark == "dark") {
                if (this.darkBtnColor == "") {
                    color = xConfig.inputDarkColor
                } else {
                    color = getDefaultColor(this.darkBtnColor)
                }
            }
            return color
        }
        ), "_bgColor" to computed<String>(fun(): String {
            var color = getDefaultColor(this.bgColor)
            if (xConfig.dark == "dark") {
                if (this.darkBgColor == "") {
                    color = xConfig.inputDarkColor
                } else {
                    color = getDefaultColor(this.darkBgColor)
                }
            }
            return color
        }
        ), "_max" to computed<Number>(fun(): Number {
            return this.max
        }
        ), "_min" to computed<Number>(fun(): Number {
            return this.min
        }
        ), "_step" to computed<Number>(fun(): Number {
            return this.step
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ))
    }
    open var isInRange = ::gen_isInRange_fn
    open fun gen_isInRange_fn(value: Number): Boolean {
        return value >= this._min && value <= this._max
    }
    open var clampValue = ::gen_clampValue_fn
    open fun gen_clampValue_fn(value: Number): Number {
        return Math.min(Math.max(value, this._min), this._max)
    }
    open var getDecimalPlaces = ::gen_getDecimalPlaces_fn
    open fun gen_getDecimalPlaces_fn(): Number {
        return this.decimalLen
    }
    open var handleIncrement = ::gen_handleIncrement_fn
    open fun gen_handleIncrement_fn() {
        val newValue = Math.min(this._value + this._step, this.max)
        var kVal = this.clampValue(parseFloat(newValue.toFixed(this.decimalLen)))
        this.setValue(kVal, true)
    }
    open var handleDecrement = ::gen_handleDecrement_fn
    open fun gen_handleDecrement_fn() {
        val newValue = Math.max(this._value - this._step, this.min)
        var kVal = this.clampValue(parseFloat(newValue.toFixed(this.decimalLen)))
        this.setValue(kVal, true)
    }
    open var handleInputChange = ::gen_handleInputChange_fn
    open fun gen_handleInputChange_fn(event: UniInputEvent) {
        this._input_value = event.detail.value
    }
    open var getDien = ::gen_getDien_fn
    open fun gen_getDien_fn(str: String): String {
        var v1 = str.split(".")
        var result = v1[0]
        if (v1.length == 0) {
            result = "0."
            run {
                var i: Number = 0
                while(i < this.decimalLen){
                    result += "0"
                    i++
                }
            }
        } else if (v1.length == 1) {
            result = result + "."
            run {
                var i: Number = 0
                while(i < this.decimalLen){
                    result += "0"
                    i++
                }
            }
        } else {
            result = result + "." + v1[1].substring(0, this.decimalLen)
        }
        return result
    }
    open var inputBlur = ::gen_inputBlur_fn
    open fun gen_inputBlur_fn() {
        val inputValue = parseFloat(this._input_value)
        if (!isNaN(inputValue)) {
            var str = this.getDien(inputValue + "")
            var kVal = this.clampValue(parseFloat(str))
            this.setValue(kVal, true)
        } else {
            this.setValue(parseFloat(this._min.toFixed(this.decimalLen)), true)
        }
    }
    open var setValue = ::gen_setValue_fn
    open fun gen_setValue_fn(value: Number, isEmit: Boolean) {
        val clampedValue = this.clampValue(value)
        this._value = clampedValue
        this._input_value = this._value.toString(10)
        this.addDomDisabeld = this._value >= this.max
        this.surDomDisabeld = this._value <= this.min
        if (isEmit) {
            this.`$emit`("update:modelValue", clampedValue)
            this.`$emit`("change", clampedValue)
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
                return utsMapOf("xStepperBtnBtn" to padStyleMapOf(utsMapOf("pointerEvents" to "none")), "xStepperHoverbtn" to padStyleMapOf(utsMapOf("opacity" to 0.8)), "xStepper" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "overflow" to "hidden")), "xStepperInput" to padStyleMapOf(utsMapOf("flex" to 1, "marginTop" to 0, "marginRight" to 1, "marginBottom" to 0, "marginLeft" to 1, "paddingTop" to 0, "paddingRight" to 5, "paddingBottom" to 0, "paddingLeft" to 5, "textAlign" to "center")), "xStepperBtn" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("change" to null, "update:modelValue" to null)
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "Number", "default" to 0), "max" to utsMapOf("type" to "Number", "default" to 100), "width" to utsMapOf("type" to "String", "default" to "auto"), "min" to utsMapOf("type" to "Number", "default" to 0), "autoHideBtn" to utsMapOf("type" to "Boolean", "default" to false), "disabled" to utsMapOf("type" to "Boolean", "default" to false), "disabledInput" to utsMapOf("type" to "Boolean", "default" to false), "step" to utsMapOf("type" to "Number", "default" to 1), "decimalLen" to utsMapOf("type" to "Number", "default" to 0), "btnColor" to utsMapOf("type" to "String", "default" to "info"), "darkBtnColor" to utsMapOf("type" to "String", "default" to ""), "bgColor" to utsMapOf("type" to "String", "default" to "info"), "inputStyle" to utsMapOf("type" to "String", "default" to ""), "darkBgColor" to utsMapOf("type" to "String", "default" to ""), "btnWidth" to utsMapOf("type" to "String", "default" to "36"), "height" to utsMapOf("type" to "String", "default" to "36"), "round" to utsMapOf("type" to "String", "default" to "4"), "splitBtn" to utsMapOf("type" to "Boolean", "default" to false), "btnFontColor" to utsMapOf("type" to "String", "default" to "#333333"), "fontColor" to utsMapOf("type" to "String", "default" to "#333333"), "fontSize" to utsMapOf("type" to "String", "default" to "14")))
        var propsNeedCastKeys = utsArrayOf(
            "modelValue",
            "max",
            "width",
            "min",
            "autoHideBtn",
            "disabled",
            "disabledInput",
            "step",
            "decimalLen",
            "btnColor",
            "darkBtnColor",
            "bgColor",
            "inputStyle",
            "darkBgColor",
            "btnWidth",
            "height",
            "round",
            "splitBtn",
            "btnFontColor",
            "fontColor",
            "fontSize"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
