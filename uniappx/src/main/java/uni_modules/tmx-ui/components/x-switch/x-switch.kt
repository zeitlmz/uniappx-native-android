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
open class GenUniModulesTmxUiComponentsXSwitchXSwitch : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.opened = this.modelValue
            this.getNodes()
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newvalue: Boolean) {
            if (newvalue != this.opened) {
                this.opened = newvalue
            }
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        return _cE("view", _uM("onClick" to _ctx.onClick, "id" to _ctx.id, "class" to "xSwitch", "ref" to "xSwitch", "style" to _nS(_uM("height" to _ctx._size, "width" to _ctx._sizeWidth, "backgroundColor" to _ctx._bgColor, "borderRadius" to _ctx._round))), _uA(
            _cE("view", _uM("class" to _nC(_uA(
                _uA(
                    if (_ctx._disabled) {
                        "xSwitchDisabled"
                    } else {
                        ""
                    }
                    ,
                    if (_ctx.opened) {
                        "xSwitchBgOn"
                    } else {
                        "xSwitchOff"
                    }
                ),
                "xSwitchBg"
            )), "style" to _nS(_uM("backgroundColor" to _ctx._activeBgColor, "borderRadius" to _ctx._round, "transition-timing-function" to _ctx._animationFun))), null, 6),
            _cE("view", _uM("class" to _nC(_uA(
                _uA(
                    if (_ctx._disabled) {
                        "xSwitchDisabled"
                    } else {
                        ""
                    }
                ),
                "xSwitchWrap"
            )), "style" to _nS(_uM("left" to (_ctx._space + "px"), "top" to (_ctx._space + "px"), "width" to (_ctx._contentWidth + "px"), "height" to (_ctx._contentHeight + "px"), "borderRadius" to _ctx._round))), _uA(
                if (_ctx._label.length == 2) {
                    _cE("view", _uM("key" to 0, "class" to "xSwitchText"), _uA(
                        _cE("text", _uM("class" to "xSwitchTextLeft", "style" to _nS(_uM("fontSize" to _ctx._fontSize))), _tD(if (!_ctx.opened) {
                            ""
                        } else {
                            _ctx._label[0]
                        }), 5),
                        _cE("text", _uM("class" to "xSwitchTextRight", "style" to _nS(_uM("fontSize" to _ctx._fontSize))), _tD(if (_ctx.opened) {
                            ""
                        } else {
                            _ctx._label[1]
                        }), 5)
                    ))
                } else {
                    _cC("v-if", true)
                }
                ,
                _cE("view", _uM("class" to "xSwitchBtn", "style" to _nS(_uM("width" to (_ctx._contentHeight + "px"), "height" to (_ctx._contentHeight + "px"), "transform" to ("translateX(" + (if (_ctx.opened) {
                    _ctx._maxLeftPos
                } else {
                    0
                }
                ) + "px)"), "backgroundColor" to _ctx._btnColor, "borderRadius" to _ctx._round, "transition-timing-function" to _ctx._animationFun))), _uA(
                    if (isTrue(_ctx._loading)) {
                        _cV(_component_x_icon, _uM("key" to 0, "spin" to true, "font-size" to "13", "name" to "loader-line", "color" to _ctx._activeBgColor), null, 8, _uA(
                            "color"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    if (isTrue(!_ctx._loading)) {
                        _cE("view", _uM("key" to 1, "class" to _nC(_uA(
                            if (_ctx.opened) {
                                "xSwitchIconOn"
                            } else {
                                "xSwitchIconOff"
                            },
                            "xSwitchIcon"
                        ))), _uA(
                            if ((if (_ctx.opened) {
                                _ctx._activeIcon
                            } else {
                                _ctx._icon
                            }) != "") {
                                _cV(_component_x_icon, _uM("key" to 0, "font-size" to (_ctx._contentHeight * 0.6).toString(10), "color" to if (_ctx.opened) {
                                    _ctx._activeBgColor
                                } else {
                                    _ctx._bgColor
                                }, "name" to if (_ctx.opened) {
                                    _ctx._activeIcon
                                } else {
                                    _ctx._icon
                                }), null, 8, _uA(
                                    "font-size",
                                    "color",
                                    "name"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        ), 2)
                    } else {
                        _cC("v-if", true)
                    }
                ), 4)
            ), 6)
        ), 12, _uA(
            "onClick",
            "id"
        ))
    }
    open var color: String by `$props`
    open var bgColor: String by `$props`
    open var darkBgColor: String by `$props`
    open var btnColor: String by `$props`
    open var size: String by `$props`
    open var space: Number by `$props`
    open var modelValue: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var loading: Boolean by `$props`
    open var label: UTSArray<String> by `$props`
    open var round: String by `$props`
    open var activeIcon: String by `$props`
    open var icon: String by `$props`
    open var id: String by `$data`
    open var boxwidth: Number by `$data`
    open var boxheight: Number by `$data`
    open var opened: Boolean by `$data`
    open var _activeIcon: String by `$data`
    open var _icon: String by `$data`
    open var _round: String by `$data`
    open var _bgColor: String by `$data`
    open var _activeBgColor: String by `$data`
    open var _btnColor: String by `$data`
    open var _size: String by `$data`
    open var _fontSize: String by `$data`
    open var _sizeWidth: String by `$data`
    open var _space: Number by `$data`
    open var _contentWidth: Number by `$data`
    open var _contentHeight: Number by `$data`
    open var _maxLeftPos: Number by `$data`
    open var _label: UTSArray<String> by `$data`
    open var _loading: Boolean by `$data`
    open var _disabled: Boolean by `$data`
    open var _animationFun: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("id" to ("xSwitch" + getUid()) as String, "boxwidth" to 0, "boxheight" to 0, "opened" to false, "_activeIcon" to computed<String>(fun(): String {
            return this.activeIcon
        }
        ), "_icon" to computed<String>(fun(): String {
            return this.icon
        }
        ), "_round" to computed<String>(fun(): String {
            if (this.round == "") {
                return checkIsCssUnit(xConfig.switchRadius, xConfig.unit)
            }
            return checkIsCssUnit(this.round, xConfig.unit)
        }
        ), "_bgColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                if (this.darkBgColor != "") {
                    return this.darkBgColor
                }
                return xConfig.inputDarkColor
            }
            return getDefaultColor(this.bgColor)
        }
        ), "_activeBgColor" to computed<String>(fun(): String {
            if (this.color == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.color)
        }
        ), "_btnColor" to computed<String>(fun(): String {
            return getDefaultColor(this.btnColor)
        }
        ), "_size" to computed<String>(fun(): String {
            if (this.size == "small") {
                return "22px"
            }
            if (this.size == "large") {
                return "38px"
            }
            return "32px"
        }
        ), "_fontSize" to computed<String>(fun(): String {
            if (this.size == "small") {
                return "10px"
            }
            if (this.size == "large") {
                return "12px"
            }
            return "11px"
        }
        ), "_sizeWidth" to computed<String>(fun(): String {
            if (this.size == "small") {
                return "44px"
            }
            if (this.size == "large") {
                return "76px"
            }
            return "64px"
        }
        ), "_space" to computed<Number>(fun(): Number {
            return this.space
        }
        ), "_contentWidth" to computed<Number>(fun(): Number {
            return this.boxwidth - this._space * 2
        }
        ), "_contentHeight" to computed<Number>(fun(): Number {
            return this.boxheight - this._space * 2
        }
        ), "_maxLeftPos" to computed<Number>(fun(): Number {
            return this._contentWidth - this._contentHeight
        }
        ), "_label" to computed<UTSArray<String>>(fun(): UTSArray<String> {
            return this.label
        }
        ), "_loading" to computed<Boolean>(fun(): Boolean {
            return this.loading
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ), "_animationFun" to computed<String>(fun(): String {
            return xConfig.animationFun
        }
        ))
    }
    open var onClick = ::gen_onClick_fn
    open fun gen_onClick_fn() {
        this.`$emit`("click", this.opened)
        if (this._loading || this._disabled) {
            return
        }
        this.opened = !this.opened
        this.`$emit`("update:modelValue", this.opened)
        this.`$nextTick`(fun(){
            this.`$emit`("change", this.opened)
        }
        )
    }
    open var getNodes = ::gen_getNodes_fn
    open fun gen_getNodes_fn() {
        var width = parseInt(this._sizeWidth)
        var height = parseInt(this._size)
        this.boxwidth = width
        this.boxheight = height
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xSwitchIcon" to _pS(_uM("transitionProperty" to "transform,opacity", "transitionTimingFunction" to "ease-in", "transitionDuration" to "250ms", "width" to "100%", "height" to "100%", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "xSwitchDisabled" to _pS(_uM("opacity" to 0.7)), "xSwitchTextLeft" to _pS(_uM("color" to "#FFFFFF")), "xSwitchTextRight" to _pS(_uM("color" to "#acacac")), "xSwitch" to _pS(_uM("height" to "32rpx", "position" to "relative")), "xSwitchBg" to _pS(_uM("width" to "100%", "height" to "100%", "transitionDuration" to "350ms", "transitionProperty" to "opacity,transform")), "xSwitchBgOn" to _pS(_uM("opacity" to 1, "transform" to "scale(1)")), "xSwitchOff" to _pS(_uM("opacity" to 0, "transform" to "scale(0.9)")), "xSwitchWrap" to _pS(_uM("position" to "absolute")), "xSwitchText" to _pS(_uM("width" to "100%", "height" to "100%", "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to 0, "paddingRight" to "12%", "paddingBottom" to 0, "paddingLeft" to "12%", "boxSizing" to "border-box")), "xSwitchBtn" to _pS(_uM("position" to "absolute", "transitionDuration" to "350ms", "left" to 0, "top" to 0, "transitionProperty" to "transform", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "@TRANSITION" to _uM("xSwitchIcon" to _uM("property" to "transform,opacity", "timingFunction" to "ease-in", "duration" to "250ms"), "xSwitchBg" to _uM("duration" to "350ms", "property" to "opacity,transform"), "xSwitchBtn" to _uM("duration" to "350ms", "property" to "transform")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "click" to null, "update:modelValue" to null)
        var props = _nP(_uM("color" to _uM("type" to "String", "default" to ""), "bgColor" to _uM("type" to "String", "default" to "info"), "darkBgColor" to _uM("type" to "String", "default" to ""), "btnColor" to _uM("type" to "String", "default" to "white"), "size" to _uM("type" to "String", "default" to "normal"), "space" to _uM("type" to "Number", "default" to 2), "modelValue" to _uM("type" to "Boolean", "default" to false), "disabled" to _uM("type" to "Boolean", "default" to false), "loading" to _uM("type" to "Boolean", "default" to false), "label" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA()
        }
        , "validator" to fun(kVal: UTSArray<String>): Boolean {
            if (!UTSArray.isArray(kVal)) {
                return false
            }
            if (kVal.length == 0) {
                return true
            }
            if (kVal.length != 2) {
                console.error("x:必须长度为2")
                return false
            }
            return true
        }
        ), "round" to _uM("type" to "String", "default" to ""), "activeIcon" to _uM("type" to "String", "default" to ""), "icon" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "color",
            "bgColor",
            "darkBgColor",
            "btnColor",
            "size",
            "space",
            "modelValue",
            "disabled",
            "loading",
            "label",
            "round",
            "activeIcon",
            "icon"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
