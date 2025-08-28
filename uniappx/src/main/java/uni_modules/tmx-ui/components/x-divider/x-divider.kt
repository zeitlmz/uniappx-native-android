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
open class GenUniModulesTmxUiComponentsXDividerXDivider : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", _uM("class" to "xDivider", "style" to _nS(_uM("height" to if (_ctx._vertical) {
            _ctx._height
        } else {
            "auto"
        }
        , "border-left" to if (_ctx._vertical) {
            "" + _ctx._lineWidth + " " + _ctx._model + " " + _ctx._color
        } else {
            "none"
        }
        ))), _uA(
            if (isTrue(!_ctx._vertical)) {
                _cE("view", _uM("key" to 0, "class" to "xDividerLeft", "style" to _nS(_uM("flex" to if (_ctx.align == "left") {
                    1
                } else {
                    6
                }, "border-bottom" to ("" + _ctx._lineWidth + " " + _ctx._model + " " + _ctx._color)))), null, 4)
            } else {
                _cC("v-if", true)
            }
            ,
            renderSlot(_ctx.`$slots`, "default", UTSJSONObject(), fun(): UTSArray<Any> {
                return _uA(
                    if (isTrue(_ctx._label != "" && !_ctx._vertical)) {
                        _cE("text", _uM("key" to 0, "class" to "xDividerText", "style" to _nS(_uM("color" to _ctx._labelColor, "fontSize" to _ctx._fontSize))), _tD(_ctx._label), 5)
                    } else {
                        _cC("v-if", true)
                    }
                )
            }
            ),
            if (isTrue(!_ctx._vertical)) {
                _cE("view", _uM("key" to 1, "class" to "xDividerRight", "style" to _nS(_uM("flex" to if (_ctx.align == "right") {
                    1
                } else {
                    6
                }, "border-bottom" to ("" + _ctx._lineWidth + " " + _ctx._model + " " + _ctx._color)))), null, 4)
            } else {
                _cC("v-if", true)
            }
        ), 4)
    }
    open var align: String by `$props`
    open var label: String by `$props`
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var lineWidth: String by `$props`
    open var height: String by `$props`
    open var labelColor: String by `$props`
    open var model: String by `$props`
    open var fontSize: String by `$props`
    open var vertical: Boolean by `$props`
    open var _label: String by `$data`
    open var _lineWidth: String by `$data`
    open var _fontSize: String by `$data`
    open var _height: String by `$data`
    open var _color: String by `$data`
    open var _model: String by `$data`
    open var _labelColor: String by `$data`
    open var _vertical: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("_label" to computed<String>(fun(): String {
            return this.label
        }
        ), "_lineWidth" to computed<String>(fun(): String {
            return checkIsCssUnit(this.lineWidth, xConfig.unit)
        }
        ), "_fontSize" to computed<String>(fun(): String {
            return checkIsCssUnit(this.fontSize, xConfig.unit)
        }
        ), "_height" to computed<String>(fun(): String {
            return checkIsCssUnit(this.height, xConfig.unit)
        }
        ), "_color" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                if (this.darkColor != "") {
                    return getDefaultColor(this.darkColor)
                }
                return xConfig.borderDarkColor
            }
            return getDefaultColor(this.color)
        }
        ), "_model" to computed<String>(fun(): String {
            return this.model
        }
        ), "_labelColor" to computed<String>(fun(): String {
            return getDefaultColor(this.labelColor)
        }
        ), "_vertical" to computed<Boolean>(fun(): Boolean {
            return this.vertical
        }
        ))
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xDivider" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between")), "xDividerText" to _pS(_uM("paddingTop" to 0, "paddingRight" to "24rpx", "paddingBottom" to 0, "paddingLeft" to "24rpx")), "xDividerLeft" to _pS(_uM("flex" to 6)), "xDividerRight" to _pS(_uM("flex" to 6)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("align" to _uM("type" to "String", "default" to "center"), "label" to _uM("type" to "String", "default" to ""), "color" to _uM("type" to "String", "default" to "#f5f5f5"), "darkColor" to _uM("type" to "String", "default" to ""), "lineWidth" to _uM("type" to "String", "default" to "1"), "height" to _uM("type" to "String", "default" to "10"), "labelColor" to _uM("type" to "String", "default" to "#a2a2a2"), "model" to _uM("type" to "String", "default" to "solid"), "fontSize" to _uM("type" to "String", "default" to "11"), "vertical" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "align",
            "label",
            "color",
            "darkColor",
            "lineWidth",
            "height",
            "labelColor",
            "model",
            "fontSize",
            "vertical"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
