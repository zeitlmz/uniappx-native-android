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
open class GenUniModulesTmxUiComponentsXLoadingXLoading : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        return createElementVNode("view", utsMapOf("class" to "xLoading", "style" to normalizeStyle(utsMapOf("flex-direction" to if (_ctx.vertical) {
            "column"
        } else {
            "row"
        }
        ))), utsArrayOf(
            createVNode(_component_x_icon, utsMapOf("font-size" to _ctx._iconSize, "color" to _ctx._color, "name" to _ctx._icon, "spin" to true), null, 8, utsArrayOf(
                "font-size",
                "color",
                "name"
            )),
            if (isTrue(!_ctx._hideText)) {
                createElementVNode("text", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("font-size" to _ctx._textSize, "color" to _ctx._textColor, "marginLeft" to if (_ctx.vertical) {
                    "0px"
                } else {
                    "5px"
                }, "marginTop" to if (_ctx.vertical) {
                    "8px"
                } else {
                    "0px"
                }, "lineHeight" to "1.1"))), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "default", UTSJSONObject(), fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "加载中..."
                        )
                    })
                ), 4)
            } else {
                createCommentVNode("v-if", true)
            }
        ), 4)
    }
    open var color: String by `$props`
    open var textColor: String by `$props`
    open var textSize: String by `$props`
    open var iconSize: String by `$props`
    open var vertical: Boolean by `$props`
    open var icon: String by `$props`
    open var hideText: Boolean by `$props`
    open var _icon: String by `$data`
    open var _hideText: Boolean by `$data`
    open var _color: String by `$data`
    open var _textColor: String by `$data`
    open var _textSize: String by `$data`
    open var _iconSize: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("_icon" to computed<String>(fun(): String {
            return this.icon
        }
        ), "_hideText" to computed<Boolean>(fun(): Boolean {
            return this.hideText
        }
        ), "_color" to computed<String>(fun(): String {
            return getDefaultColor(this.color)
        }
        ), "_textColor" to computed<String>(fun(): String {
            return getDefaultColor(this.textColor)
        }
        ), "_textSize" to computed<String>(fun(): String {
            return checkIsCssUnit(this.textSize, xConfig.unit)
        }
        ), "_iconSize" to computed<String>(fun(): String {
            return checkIsCssUnit(this.iconSize, xConfig.unit)
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
                return utsMapOf("xLoading" to padStyleMapOf(utsMapOf("display" to "flex", "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf("color" to utsMapOf("type" to "String", "default" to "#8b8b8b"), "textColor" to utsMapOf("type" to "String", "default" to "#8b8b8b"), "textSize" to utsMapOf("type" to "String", "default" to "12"), "iconSize" to utsMapOf("type" to "String", "default" to "21"), "vertical" to utsMapOf("type" to "Boolean", "default" to true), "icon" to utsMapOf("type" to "String", "default" to "loader-line"), "hideText" to utsMapOf("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = utsArrayOf(
            "color",
            "textColor",
            "textSize",
            "iconSize",
            "vertical",
            "icon",
            "hideText"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
