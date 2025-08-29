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
open class GenUniModulesTmxUiComponentsXLoadingXLoading : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        return _cE("view", _uM("class" to "xLoading", "style" to _nS(_uM("flex-direction" to if (_ctx.vertical) {
            "column"
        } else {
            "row"
        }
        ))), _uA(
            _cV(_component_x_icon, _uM("font-size" to _ctx._iconSize, "color" to _ctx._color, "name" to _ctx._icon, "spin" to true), null, 8, _uA(
                "font-size",
                "color",
                "name"
            )),
            if (isTrue(!_ctx._hideText)) {
                _cE("text", _uM("key" to 0, "style" to _nS(_uM("font-size" to _ctx._textSize, "color" to _ctx._textColor, "marginLeft" to if (_ctx.vertical) {
                    "0px"
                } else {
                    "5px"
                }, "marginTop" to if (_ctx.vertical) {
                    "8px"
                } else {
                    "0px"
                }, "lineHeight" to "1.1"))), _uA(
                    renderSlot(_ctx.`$slots`, "default", UTSJSONObject(), fun(): UTSArray<Any> {
                        return _uA(
                            _tD(_ctx._label)
                        )
                    })
                ), 4)
            } else {
                _cC("v-if", true)
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
    open var label: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var _label: String by `$data`
    open var _icon: String by `$data`
    open var _hideText: Boolean by `$data`
    open var _color: String by `$data`
    open var _textColor: String by `$data`
    open var _textSize: String by `$data`
    open var _iconSize: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "_label" to computed<String>(fun(): String {
            if (this.label == "") {
                return this!!.i18n.t("tmui4x.xloading.label")
            }
            return this.label
        }
        ), "_icon" to computed<String>(fun(): String {
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
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xLoading" to _pS(_uM("display" to "flex", "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("color" to _uM("type" to "String", "default" to "#8b8b8b"), "textColor" to _uM("type" to "String", "default" to "#8b8b8b"), "textSize" to _uM("type" to "String", "default" to "12"), "iconSize" to _uM("type" to "String", "default" to "21"), "vertical" to _uM("type" to "Boolean", "default" to true), "icon" to _uM("type" to "String", "default" to "loader-line"), "hideText" to _uM("type" to "Boolean", "default" to false), "label" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "color",
            "textColor",
            "textSize",
            "iconSize",
            "vertical",
            "icon",
            "hideText",
            "label"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
