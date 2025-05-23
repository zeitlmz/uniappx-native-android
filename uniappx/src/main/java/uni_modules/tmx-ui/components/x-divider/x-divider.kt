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
open class GenUniModulesTmxUiComponentsXDividerXDivider : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return createElementVNode("view", utsMapOf("class" to "xDivider", "style" to normalizeStyle(utsMapOf("height" to if (_ctx._vertical) {
            _ctx._height
        } else {
            "auto"
        }
        , "border-left" to if (_ctx._vertical) {
            "" + _ctx._lineWidth + " " + _ctx._model + " " + _ctx._color
        } else {
            "none"
        }
        ))), utsArrayOf(
            if (isTrue(!_ctx._vertical)) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "xDividerLeft", "style" to normalizeStyle(utsMapOf("flex" to if (_ctx.align == "left") {
                    1
                } else {
                    6
                }, "border-bottom" to ("" + _ctx._lineWidth + " " + _ctx._model + " " + _ctx._color)))), null, 4)
            } else {
                createCommentVNode("v-if", true)
            }
            ,
            renderSlot(_ctx.`$slots`, "default", UTSJSONObject(), fun(): UTSArray<Any> {
                return utsArrayOf(
                    if (isTrue(_ctx._label != "" && !_ctx._vertical)) {
                        createElementVNode("text", utsMapOf("key" to 0, "class" to "xDividerText", "style" to normalizeStyle(utsMapOf("color" to _ctx._labelColor, "fontSize" to _ctx._fontSize))), toDisplayString(_ctx._label), 5)
                    } else {
                        createCommentVNode("v-if", true)
                    }
                )
            }
            ),
            if (isTrue(!_ctx._vertical)) {
                createElementVNode("view", utsMapOf("key" to 1, "class" to "xDividerRight", "style" to normalizeStyle(utsMapOf("flex" to if (_ctx.align == "right") {
                    1
                } else {
                    6
                }, "border-bottom" to ("" + _ctx._lineWidth + " " + _ctx._model + " " + _ctx._color)))), null, 4)
            } else {
                createCommentVNode("v-if", true)
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
        return utsMapOf("_label" to computed<String>(fun(): String {
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
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xDivider" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between")), "xDividerText" to padStyleMapOf(utsMapOf("paddingTop" to 0, "paddingRight" to "24rpx", "paddingBottom" to 0, "paddingLeft" to "24rpx")), "xDividerLeft" to padStyleMapOf(utsMapOf("flex" to 6)), "xDividerRight" to padStyleMapOf(utsMapOf("flex" to 6)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf("align" to utsMapOf("type" to "String", "default" to "center"), "label" to utsMapOf("type" to "String", "default" to ""), "color" to utsMapOf("type" to "String", "default" to "#f5f5f5"), "darkColor" to utsMapOf("type" to "String", "default" to ""), "lineWidth" to utsMapOf("type" to "String", "default" to "1"), "height" to utsMapOf("type" to "String", "default" to "10"), "labelColor" to utsMapOf("type" to "String", "default" to "#a2a2a2"), "model" to utsMapOf("type" to "String", "default" to "solid"), "fontSize" to utsMapOf("type" to "String", "default" to "11"), "vertical" to utsMapOf("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = utsArrayOf(
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
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
