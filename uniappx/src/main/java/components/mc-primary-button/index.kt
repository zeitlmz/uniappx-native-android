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
open class GenComponentsMcPrimaryButtonIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var disabled: Boolean by `$props`
    open var span: Number by `$props`
    open var iconPath: String by `$props`
    open var iconSize: String by `$props`
    open var fontSize: String by `$props`
    open var height: String by `$props`
    open var marginRight: String by `$props`
    open var linearColors: UTSArray<String> by `$props`
    open var bgColor: String by `$props`
    open var color: String by `$props`
    open var borderRadius: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsMcPrimaryButtonIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsMcPrimaryButtonIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val props = __props
            val isPressed = ref<Boolean>(false)
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val click = fun(){
                emit("click")
            }
            val customStyle = computed(fun(): UTSJSONObject {
                val customStyle: UTSJSONObject = object : UTSJSONObject() {
                    var fontSize = props.fontSize
                    var height = props.height
                    var lineHeight = props.height
                    var marginRight = props.marginRight
                }
                if (props.span > 0) {
                    customStyle["flex"] = props.span
                }
                if (props.bgColor != "") {
                    customStyle["backgroundColor"] = props.bgColor
                } else if (props.linearColors.length > 0) {
                    customStyle["backgroundImage"] = "linear-gradient(to right, " + props.linearColors.join(", ") + ")"
                } else {
                    customStyle["backgroundImage"] = "linear-gradient(to right, " + globalData.theme.primaryLinearColors.join(", ") + ")"
                }
                if (props.color != "") {
                    customStyle["color"] = props.color
                } else {
                    customStyle["color"] = globalData.theme.primaryFontColor
                }
                if (props.borderRadius != "") {
                    customStyle["borderRadius"] = props.borderRadius
                } else {
                    customStyle["borderRadius"] = globalData.theme.buttonRadius
                }
                return customStyle
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("disabled" to _ctx.disabled, "class" to _nC(_uA(
                    "primary-btn transition",
                    _uM("active" to unref(isPressed))
                )), "onTouchstart" to withModifiers(fun(){
                    isPressed.value = true
                }
                , _uA(
                    "stop"
                )), "onTouchend" to withModifiers(fun(){
                    isPressed.value = false
                }
                , _uA(
                    "stop"
                )), "style" to _nS(unref(customStyle)), "onClick" to withModifiers(click, _uA(
                    "stop"
                ))), _uA(
                    if (_ctx.iconPath != "") {
                        _cE("image", _uM("key" to 0, "style" to _nS(_uM("width" to _ctx.iconSize)), "src" to _ctx.iconPath, "mode" to "widthFix"), null, 12, _uA(
                            "src"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("text", _uM("style" to _nS(_uM("color" to unref(customStyle)["color"]))), _uA(
                        renderSlot(_ctx.`$slots`, "default")
                    ), 4)
                ), 46, _uA(
                    "disabled",
                    "onTouchstart",
                    "onTouchend"
                ))
            }
        }
        var name = "mc-primary-button"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("primary-btn" to _pS(_uM("paddingTop" to 0, "paddingRight" to "20rpx", "paddingBottom" to 0, "paddingLeft" to "20rpx", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "boxSizing" to "border-box", "fontWeight" to "400", "boxShadow" to "0rpx 2rpx 5rpx 0rpx rgba(89, 119, 177, 0.2)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM("disabled" to _uM("type" to "Boolean", "default" to false), "span" to _uM("type" to "Number", "default" to 1), "iconPath" to _uM("type" to "String", "default" to ""), "iconSize" to _uM("type" to "String", "default" to "28rpx"), "fontSize" to _uM("type" to "String", "default" to "30rpx"), "height" to _uM("type" to "String", "default" to "80rpx"), "marginRight" to _uM("type" to "String", "default" to "0"), "linearColors" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA()
        }
        ), "bgColor" to _uM("type" to "String", "default" to ""), "color" to _uM("type" to "String", "default" to ""), "borderRadius" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "disabled",
            "span",
            "iconPath",
            "iconSize",
            "fontSize",
            "height",
            "marginRight",
            "linearColors",
            "bgColor",
            "color",
            "borderRadius"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
