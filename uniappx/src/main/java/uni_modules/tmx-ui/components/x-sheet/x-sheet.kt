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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenUniModulesTmxUiComponentsXSheetXSheet : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        return createElementVNode("view", utsMapOf("onClick" to _ctx.onclick, "onTouchend" to _ctx.mend, "onTouchcancel" to _ctx.mendcel, "onTouchstart" to _ctx.mst, "class" to "xSheet", "style" to normalizeStyle(_ctx._styleMap)), utsArrayOf(
            if (isTrue(_ctx._loading)) {
                createElementVNode("view", utsMapOf("key" to 0, "onClick" to withModifiers(fun(){}, utsArrayOf(
                    "stop"
                )), "class" to "xSheetLoading", "style" to normalizeStyle(utsMapOf("borderRadius" to _ctx._round))), utsArrayOf(
                    createVNode(_component_x_icon, utsMapOf("spin" to true, "font-size" to "42", "name" to "loader-fill", "color" to _ctx._loadingColor), null, 8, utsArrayOf(
                        "color"
                    ))
                ), 12, utsArrayOf(
                    "onClick"
                ))
            } else {
                createCommentVNode("v-if", true)
            }
            ,
            renderSlot(_ctx.`$slots`, "default")
        ), 44, utsArrayOf(
            "onClick",
            "onTouchend",
            "onTouchcancel",
            "onTouchstart"
        ))
    }
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var followTheme: Boolean by `$props`
    open var hoverColor: String by `$props`
    open var url: String by `$props`
    open var linearGradient: UTSArray<String> by `$props`
    open var round: UTSArray<String> by `$props`
    open var border: UTSArray<String> by `$props`
    open var shadow: UTSArray<String> by `$props`
    open var borderColor: UTSArray<String> by `$props`
    open var darkBorderColor: UTSArray<String> by `$props`
    open var borderStyle: String by `$props`
    open var margin: UTSArray<String> by `$props`
    open var padding: UTSArray<String> by `$props`
    open var isLink: Boolean by `$props`
    open var loading: Boolean by `$props`
    open var height: String by `$props`
    open var width: String by `$props`
    open var isHover: Boolean by `$data`
    open var _color: String by `$data`
    open var _width: String by `$data`
    open var _height: String by `$data`
    open var _linearGradient: String by `$data`
    open var _round: String by `$data`
    open var _border: String by `$data`
    open var _borderColor: String by `$data`
    open var _margin: String by `$data`
    open var _padding: String by `$data`
    open var _shadow: String by `$data`
    open var _loading: Boolean by `$data`
    open var _loadingColor: String by `$data`
    open var _borderStyle: String by `$data`
    open var _styleMap: Map<String, String> by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("isHover" to false, "_color" to computed<String>(fun(): String {
            if (this.linearGradient.length > 0 || this.color == "transparent") {
                return "transparent"
            }
            var tcolor = this.color
            if (this.followTheme && xConfig.color != "") {
                tcolor = xConfig.color
            }
            if (this.isHover) {
                return if (this.hoverColor == "") {
                    colorAddDeepen(tcolor)
                } else {
                    getDefaultColor(this.hoverColor)
                }
            }
            var color = getDefaultColor(tcolor)
            if (xConfig.dark == "dark" && this.darkColor != "") {
                color = getDefaultColor(this.darkColor)
            }
            if (xConfig.dark == "dark" && this.darkColor == "") {
                if (isBlackAndWhite(color)) {
                    color = xConfig.sheetDarkColor
                } else {
                    color = setBgColorLightByDark(color)
                }
            }
            return color
        }
        ), "_width" to computed<String>(fun(): String {
            return checkIsCssUnit(this.width, xConfig.unit)
        }
        ), "_height" to computed<String>(fun(): String {
            return checkIsCssUnit(this.height, xConfig.unit)
        }
        ), "_linearGradient" to computed<String>(fun(): String {
            if (this.linearGradient.length == 0) {
                return ""
            }
            var dirs = this.linearGradient[0]
            if (dirs == "top") {
                dirs = "to top"
            } else if (dirs == "bottom") {
                dirs = "to bottom"
            } else if (dirs == "left") {
                dirs = "to left"
            } else if (dirs == "right") {
                dirs = "to right"
            }
            return "linear-gradient(" + dirs + "," + this.linearGradient[1] + "," + this.linearGradient[2] + ")"
        }
        ), "_round" to computed<String>(fun(): String {
            if (this.round.length == 0) {
                var par = fillArrayCssValueByround(xConfig.sheetRadius)
                if (par.length == 0) {
                    return "0px 0px 0px 0px"
                }
                return par.join(" ")
            }
            var ar: UTSArray<String> = fillArrayCssValueByround(this.round as UTSArray<String>)
            if (ar.length == 0) {
                return "0px 0px 0px 0px"
            }
            return ar.join(" ")
        }
        ), "_border" to computed<String>(fun(): String {
            var ar: UTSArray<String> = fillArrayCssValue(this.border as UTSArray<String>)
            if (ar.length == 0) {
                return "0px 0px 0px 0px"
            }
            return ar.join(" ")
        }
        ), "_borderColor" to computed<String>(fun(): String {
            var bordercolor = this.borderColor as UTSArray<String>
            if (xConfig.dark == "dark") {
                bordercolor = if (this.darkBorderColor.length == 0) {
                    xConfig.sheetDarkBorderColor
                } else {
                    this.darkBorderColor
                }
            }
            var ar: UTSArray<String> = fillArrayCssValueBycolor(bordercolor as UTSArray<String>)
            if (ar.length == 0) {
                return "transparent transparent transparent transparent"
            }
            return ar.join(" ")
        }
        ), "_margin" to computed<String>(fun(): String {
            if (this.margin.length == 0) {
                var par = fillArrayCssValue(xConfig.sheetMargin)
                if (par.length == 0) {
                    return "0px 0px 0px 0px"
                }
                return par.join(" ")
            }
            var ar: UTSArray<String> = fillArrayCssValue(this.margin as UTSArray<String>)
            if (ar.length == 0) {
                return "0px 0px 0px 0px"
            }
            return ar.join(" ")
        }
        ), "_padding" to computed<String>(fun(): String {
            if (this.padding.length == 0) {
                var par = fillArrayCssValue(xConfig.sheetPadding)
                if (par.length == 0) {
                    return "0px 0px 0px 0px"
                }
                return par.join(" ")
            }
            var ar: UTSArray<String> = fillArrayCssValue(this.padding as UTSArray<String>)
            if (ar.length == 0) {
                return "0px 0px 0px 0px"
            }
            return ar.join(" ")
        }
        ), "_shadow" to computed<String>(fun(): String {
            if (this.shadow.length != 3) {
                return "none"
            }
            return "0px " + checkIsCssUnit(this.shadow[0], xConfig.unit) + " " + checkIsCssUnit(this.shadow[1], xConfig.unit) + " " + this.shadow[2]
        }
        ), "_loading" to computed<Boolean>(fun(): Boolean {
            return this.loading
        }
        ), "_loadingColor" to computed<String>(fun(): String {
            return xConfig.color
        }
        ), "_borderStyle" to computed<String>(fun(): String {
            return this.borderStyle
        }
        ), "_styleMap" to computed<Map<String, String>>(fun(): Map<String, String> {
            var stylemap = Map<String, String>()
            stylemap.set("backgroundColor", this._color)
            stylemap.set("width", this._width)
            stylemap.set("height", this._height)
            stylemap.set("backgroundImage", this._linearGradient)
            stylemap.set("borderRadius", this._round)
            stylemap.set("borderWidth", this._border)
            stylemap.set("borderColor", this._borderColor)
            stylemap.set("margin", this._margin)
            stylemap.set("padding", this._padding)
            stylemap.set("boxShadow", this._shadow)
            stylemap.set("borderStyle", this._borderStyle)
            return stylemap
        }
        ))
    }
    open var onclick = ::gen_onclick_fn
    open fun gen_onclick_fn() {
        if (this.url != "") {
            uni_navigateTo(NavigateToOptions(url = this.url, fail = fun(error) {
                console.error(error)
            }
            ))
            return
        }
        this.`$emit`("click")
    }
    open var mst = ::gen_mst_fn
    open fun gen_mst_fn() {
        if (this.url != "" || this.isLink) {
            this.isHover = true
        }
    }
    open var mend = ::gen_mend_fn
    open fun gen_mend_fn() {
        if (this.url != "" || this.isLink) {
            this.isHover = false
        }
    }
    open var mendcel = ::gen_mendcel_fn
    open fun gen_mendcel_fn() {
        if (this.url != "" || this.isLink) {
            this.isHover = false
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
                return utsMapOf("xSheet" to padStyleMapOf(utsMapOf("position" to "relative")), "xSheetLoading" to padStyleMapOf(utsMapOf("position" to "absolute", "zIndex" to 2, "backgroundColor" to "rgba(60,60,60,0.5)", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "width" to "100%", "height" to "100%", "left" to 0, "top" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("click" to null)
        var props = normalizePropsOptions(utsMapOf("color" to utsMapOf("type" to "String", "default" to "white"), "darkColor" to utsMapOf("type" to "String", "default" to ""), "followTheme" to utsMapOf("type" to "Boolean", "default" to false), "hoverColor" to utsMapOf("type" to "String", "default" to ""), "url" to utsMapOf("type" to "String", "default" to ""), "linearGradient" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf()
        }
        , "validator" to fun(kVal: UTSArray<String>): Boolean {
            if (kVal.length == 0) {
                return true
            }
            if (kVal.length != 3) {
                console.error("x:渐变属性linearGradient可以为空数组，提供具体值是必须长度为3")
                return false
            }
            return true
        }
        ), "round" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf()
        }
        ), "border" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf()
        }
        ), "shadow" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "borderColor" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf()
        }
        ), "darkBorderColor" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf()
        }
        ), "borderStyle" to utsMapOf("type" to "String", "default" to "solid"), "margin" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "padding" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "isLink" to utsMapOf("type" to "Boolean", "default" to false), "loading" to utsMapOf("type" to "Boolean", "default" to false), "height" to utsMapOf("type" to "String", "default" to "auto"), "width" to utsMapOf("type" to "String", "default" to "auto")))
        var propsNeedCastKeys = utsArrayOf(
            "color",
            "darkColor",
            "followTheme",
            "hoverColor",
            "url",
            "linearGradient",
            "round",
            "border",
            "shadow",
            "borderColor",
            "darkBorderColor",
            "borderStyle",
            "margin",
            "padding",
            "isLink",
            "loading",
            "height",
            "width"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
