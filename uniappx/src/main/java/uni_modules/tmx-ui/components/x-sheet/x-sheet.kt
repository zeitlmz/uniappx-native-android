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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenUniModulesTmxUiComponentsXSheetXSheet : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        return _cE("view", _uM("onClick" to _ctx.onclick, "onTouchend" to _ctx.mend, "onTouchcancel" to _ctx.mendcel, "onTouchstart" to _ctx.mst, "class" to "xSheet", "style" to _nS(_ctx._styleMap)), _uA(
            if (isTrue(_ctx._loading)) {
                _cE("view", _uM("key" to 0, "onClick" to withModifiers(fun(){}, _uA(
                    "stop"
                )), "class" to "xSheetLoading", "style" to _nS(_uM("borderRadius" to _ctx._round))), _uA(
                    _cV(_component_x_icon, _uM("spin" to true, "font-size" to "42", "name" to "loader-fill", "color" to _ctx._loadingColor), null, 8, _uA(
                        "color"
                    ))
                ), 12, _uA(
                    "onClick"
                ))
            } else {
                _cC("v-if", true)
            }
            ,
            renderSlot(_ctx.`$slots`, "default")
        ), 44, _uA(
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
    open var i18n: Tmui4xI18nTml by `$data`
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
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "isHover" to false, "_color" to computed<String>(fun(): String {
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
            if (this._linearGradient != "") {
                stylemap.set("backgroundImage", this._linearGradient)
            }
            stylemap.set("borderRadius", this._round)
            stylemap.set("borderWidth", this._border)
            stylemap.set("borderColor", this._borderColor)
            stylemap.set("margin", this._margin)
            stylemap.set("padding", this._padding)
            if (this._shadow != "" && this._shadow != "none") {
                stylemap.set("boxShadow", this._shadow)
            }
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
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xSheet" to _pS(_uM("position" to "relative")), "xSheetLoading" to _pS(_uM("position" to "absolute", "zIndex" to 2, "backgroundColor" to "rgba(60,60,60,0.5)", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "width" to "100%", "height" to "100%", "left" to 0, "top" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM("color" to _uM("type" to "String", "default" to "white"), "darkColor" to _uM("type" to "String", "default" to ""), "followTheme" to _uM("type" to "Boolean", "default" to false), "hoverColor" to _uM("type" to "String", "default" to ""), "url" to _uM("type" to "String", "default" to ""), "linearGradient" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA()
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
        ), "round" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA()
        }
        ), "border" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA()
        }
        ), "shadow" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "borderColor" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA()
        }
        ), "darkBorderColor" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA()
        }
        ), "borderStyle" to _uM("type" to "String", "default" to "solid"), "margin" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "padding" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "isLink" to _uM("type" to "Boolean", "default" to false), "loading" to _uM("type" to "Boolean", "default" to false), "height" to _uM("type" to "String", "default" to "auto"), "width" to _uM("type" to "String", "default" to "auto")))
        var propsNeedCastKeys = _uA(
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
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
