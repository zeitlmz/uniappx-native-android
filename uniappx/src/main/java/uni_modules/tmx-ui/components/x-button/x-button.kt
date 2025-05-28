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
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.reLaunch as uni_reLaunch
import io.dcloud.uniapp.extapi.redirectTo as uni_redirectTo
import io.dcloud.uniapp.extapi.switchTab as uni_switchTab
open class GenUniModulesTmxUiComponentsXButtonXButton : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onCreated(fun() {
            this.customStyles(false)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this._color
        }
        , fun() {
            this.customStyles(false)
        }
        )
        this.`$watch`(fun(): Any? {
            return this.color
        }
        , fun() {
            this.customStyles(false)
        }
        )
        this.`$watch`(fun(): Any? {
            return this.bgColor
        }
        , fun() {
            this.customStyles(false)
        }
        )
        this.`$watch`(fun(): Any? {
            return this.borderColor
        }
        , fun() {
            this.customStyles(false)
        }
        )
        this.`$watch`(fun(): Any? {
            return this.skin
        }
        , fun() {
            this.customStyles(false)
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        return createElementVNode("view", utsMapOf("onTouchcancel" to _ctx.touchCacel, "onTouchend" to _ctx.touchEnd, "onTouchstart" to _ctx.touchStart, "onClick" to _ctx.clickListen, "style" to normalizeStyle(_ctx._styleMap), "class" to normalizeClass(utsArrayOf(
            "parentButton",
            utsArrayOf(
                if (_ctx._disabled || _ctx._loading) {
                    "noDrag"
                } else {
                    ""
                }
            )
        ))), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                "xButton",
                if (_ctx._loading) {
                    "load"
                } else {
                    ""
                }
            ))), utsArrayOf(
                if (isTrue(_ctx._icon != "" && !_ctx._loading)) {
                    createVNode(_component_x_icon, utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("marginRight" to if (_ctx._iconBtn) {
                        "0px"
                    } else {
                        " 5px"
                    })), "font-size" to _ctx._iconSize, "color" to _ctx._set_font_color, "name" to _ctx._icon), null, 8, utsArrayOf(
                        "style",
                        "font-size",
                        "color",
                        "name"
                    ))
                } else {
                    createCommentVNode("v-if", true)
                }
                ,
                if (isTrue(_ctx._loading)) {
                    createVNode(_component_x_icon, utsMapOf("key" to 1, "color" to "white", "spin" to true, "name" to "loader-fill"))
                } else {
                    createCommentVNode("v-if", true)
                }
                ,
                if (isTrue(!_ctx._iconBtn)) {
                    createElementVNode("text", utsMapOf("key" to 2, "style" to normalizeStyle(utsMapOf("fontWeight" to _ctx._fontWeight, "color" to _ctx._set_font_color, "fontSize" to _ctx._fontSize, "lineHeight" to _ctx.lineHeight))), utsArrayOf(
                        renderSlot(_ctx.`$slots`, "default")
                    ), 4)
                } else {
                    createCommentVNode("v-if", true)
                }
            ), 2)
        ), 46, utsArrayOf(
            "onTouchcancel",
            "onTouchend",
            "onTouchstart",
            "onClick"
        ))
    }
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var bgColor: String by `$props`
    open var linearGradient: UTSArray<String> by `$props`
    open var fontColor: String by `$props`
    open var fontDarkColor: String by `$props`
    open var fontSize: String by `$props`
    open var round: String by `$props`
    open var border: Number by `$props`
    open var shadow: UTSArray<Number> by `$props`
    open var borderColor: String by `$props`
    open var skin: String by `$props`
    open var icon: String by `$props`
    open var iconBtn: Boolean by `$props`
    open var iconSize: String by `$props`
    open var size: String by `$props`
    open var url: String by `$props`
    open var navigateMode: String by `$props`
    open var disabled: Boolean by `$props`
    open var loading: Boolean by `$props`
    open var height: String by `$props`
    open var width: String by `$props`
    open var block: Boolean by `$props`
    open var formType: String by `$props`
    open var lineHeight: String by `$props`
    open var fontWeight: String by `$props`
    open var openType: String by `$props`
    open var lang: String by `$props`
    open var sessionFrom: String by `$props`
    open var sendMessageTitle: String by `$props`
    open var sendMessagePath: String by `$props`
    open var sendMessageImg: String by `$props`
    open var appParameter: String by `$props`
    open var showMessageCard: Boolean by `$props`
    open var phoneNumberNoQuotaToast: Boolean by `$props`
    open var _set_border_color: String by `$data`
    open var _set_background_color: String by `$data`
    open var _set_background_img: String by `$data`
    open var _set_font_color: String by `$data`
    open var _set_opacity: String by `$data`
    open var _isHover: Boolean by `$data`
    open var boxShadow: String by `$data`
    open var _fontWeight: String by `$data`
    open var _fontSize: String by `$data`
    open var _iconSize: String by `$data`
    open var _disabled: Boolean by `$data`
    open var _icon: String by `$data`
    open var _loading: Boolean by `$data`
    open var _radius: String by `$data`
    open var _border: String by `$data`
    open var _iconBtn: Boolean by `$data`
    open var _height: String by `$data`
    open var _width: String by `$data`
    open var _color: String by `$data`
    open var _shadow: UTSArray<Number> by `$data`
    open var _styleMap: Map<String, String> by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("_set_border_color" to "1px solid transparent", "_set_background_color" to "transparent", "_set_background_img" to "", "_set_font_color" to "#ffffff", "_set_opacity" to "1", "_isHover" to false, "boxShadow" to "0 0px 0px rgba(0,0,0,0)", "_fontWeight" to computed<String>(fun(): String {
            return this.fontWeight
        }
        ), "_fontSize" to computed<String>(fun(): String {
            var fontSize = this.fontSize
            if (fontSize == "") {
                if (this.size == "mini") {
                    fontSize = "12px"
                }
                if (this.size == "small") {
                    fontSize = "14px"
                }
                if (this.size == "normal") {
                    fontSize = "16px"
                }
                if (this.size == "large") {
                    fontSize = "18px"
                }
            }
            fontSize = checkIsCssUnit(fontSize, xConfig.unit)
            if (xConfig.fontScale == 1) {
                return fontSize
            }
            var sizeNumber = parseInt(fontSize)
            if (isNaN(sizeNumber)) {
                sizeNumber = 16
            }
            return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(this.fontSize)
        }
        ), "_iconSize" to computed<String>(fun(): String {
            if (this.iconSize != "") {
                var fontSize = checkIsCssUnit(this.iconSize, xConfig.unit)
                if (xConfig.fontScale == 1) {
                    return fontSize
                }
                var sizeNumber = parseInt(fontSize)
                if (isNaN(sizeNumber)) {
                    sizeNumber = 16
                }
                return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(this.fontSize)
            }
            return this._fontSize
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ), "_icon" to computed<String>(fun(): String {
            return this.icon
        }
        ), "_loading" to computed<Boolean>(fun(): Boolean {
            return this.loading
        }
        ), "_radius" to computed<String>(fun(): String {
            var radius = this.round
            if (radius == "") {
                radius = xConfig.buttonRadius
                if (this.size == "mini") {
                    radius = "6px"
                }
                if (this.size == "small") {
                    radius = "8px"
                }
            }
            return checkIsCssUnit(radius, xConfig.unit)
        }
        ), "_border" to computed<String>(fun(): String {
            return checkIsCssUnit(this.border.toString(10), xConfig.unit)
        }
        ), "_iconBtn" to computed<Boolean>(fun(): Boolean {
            return this.iconBtn
        }
        ), "_height" to computed<String>(fun(): String {
            if (this.height != "") {
                return checkIsCssUnit(this.height, xConfig.unit)
            }
            if (this.size == "mini") {
                return "24px"
            }
            if (this.size == "small") {
                return "32px"
            }
            if (this.size == "normal") {
                return "46px"
            }
            if (this.size == "large") {
                return "56px"
            }
            return checkIsCssUnit(if (this.height == "") {
                "44px"
            } else {
                this.height
            }
            , xConfig.unit)
        }
        ), "_width" to computed<String>(fun(): String {
            if (this.iconBtn) {
                return this._height
            }
            if (this.block) {
                return "100%"
            }
            if (this.width != "") {
                return checkIsCssUnit(this.width, xConfig.unit)
            }
            if (this.size == "mini") {
                return "46px"
            }
            if (this.size == "small") {
                return "60px"
            }
            if (this.size == "normal") {
                return "98px"
            }
            if (this.size == "large") {
                return "128px"
            }
            return checkIsCssUnit(this.width, xConfig.unit)
        }
        ), "_color" to computed<String>(fun(): String {
            var color = this.color
            if (xConfig.dark == "dark" && this.darkColor != "") {
                color = this.darkColor
            } else {
                if (color == "") {
                    color = xConfig.color
                }
            }
            return color
        }
        ), "_shadow" to computed<UTSArray<Number>>(fun(): UTSArray<Number> {
            if (this.shadow.length == 0) {
                return utsArrayOf<Number>(0, 0)
            }
            if (this.shadow.length == 1) {
                return utsArrayOf<Number>(this.shadow[0], this.shadow[0])
            }
            return this.shadow
        }
        ), "_styleMap" to computed<Map<String, String>>(fun(): Map<String, String> {
            var styleMap = Map<String, String>()
            styleMap.set("width", this._width)
            styleMap.set("height", this._height)
            styleMap.set("border", this._set_border_color)
            styleMap.set("backgroundColor", this._set_background_color)
            styleMap.set("backgroundImage", this._set_background_img)
            styleMap.set("borderRadius", this._radius)
            var opacity = "1"
            if (this._disabled || this._loading) {
                opacity = "0.5"
            }
            styleMap.set("opacity", opacity)
            return styleMap
        }
        ))
    }
    open var touchStart = ::gen_touchStart_fn
    open fun gen_touchStart_fn() {
        if (this._disabled || this._loading) {
            return
        }
        this.customStyles(true)
        this._isHover = true
    }
    open var touchCacel = ::gen_touchCacel_fn
    open fun gen_touchCacel_fn() {
        if (this._disabled || this._loading) {
            return
        }
        this.customStyles(false)
        this._isHover = false
    }
    open var touchEnd = ::gen_touchEnd_fn
    open fun gen_touchEnd_fn() {
        if (this._disabled || this._loading) {
            return
        }
        this.customStyles(false)
        this._isHover = false
    }
    open var formSubmit = ::gen_formSubmit_fn
    open fun gen_formSubmit_fn() {
        var pelement = this.findParent(this)
        if (pelement == null) {
            return
        }
        var parent: XFormComponentPublicInstance = pelement as XFormComponentPublicInstance
        parent.submit()
    }
    open var findParent = ::gen_findParent_fn
    open fun gen_findParent_fn(parent: VueComponent?): VueComponent? {
        if (parent == null) {
            return null
        }
        if (parent.`$parent` is XFormComponentPublicInstance) {
            return parent.`$parent`
        }
        var parents = this.findParent(parent.`$parent`)
        if (parents is XFormComponentPublicInstance) {
            return parents
        }
        return null
    }
    open var clickListen = ::gen_clickListen_fn
    open fun gen_clickListen_fn(e: UniPointerEvent) {
        if (!this._disabled && !this._loading) {
            this.`$emit`("click", e)
            if (this.formType == "form") {
                this.formSubmit()
            }
        }
        if (this._disabled == false && this.url != "" && this._loading == false) {
            if (this.navigateMode == "navigateTo") {
                uni_navigateTo(NavigateToOptions(url = this.url, fail = fun(error){
                    console.error(error)
                }))
            } else if (this.navigateMode == "redirectTo") {
                uni_redirectTo(RedirectToOptions(url = this.url, fail = fun(error){
                    console.error(error)
                }))
            } else if (this.navigateMode == "switchTab") {
                uni_switchTab(SwitchTabOptions(url = this.url, fail = fun(error){
                    console.error(error)
                }))
            } else if (this.navigateMode == "reLaunch") {
                uni_reLaunch(ReLaunchOptions(url = this.url, fail = fun(error){
                    console.error(error)
                }))
            } else if (this.navigateMode == "navigateBack") {
                uni_navigateBack(NavigateBackOptions(fail = fun(error){
                    console.error(error)
                }
                ))
            }
        }
    }
    open var customStyles = ::gen_customStyles_fn
    open fun gen_customStyles_fn(hover: Boolean) {
        var dePrimarycolor = getDefaultColor(xConfig.color)
        var color = getDefaultColor(this._color)
        var hoverColor = if (this.color == "info") {
            getDefaultColor(xConfig.color)
        } else {
            color
        }
        var colorInit: UTSJSONObject = getDefaultColorObj(color, hoverColor)
        var borderStyle = "solid"
        if (this.skin == "text") {
            colorInit = getTextColorObj(color, hoverColor, xConfig.dark == "dark")
        }
        if (this.skin == "thin") {
            colorInit = getThinColorObj(color, hoverColor, xConfig.dark == "dark")
        }
        if (this.skin == "outline" || this.skin == "dashed") {
            colorInit = getOutlineColorObj(color, hoverColor)
        }
        if (this.skin == "dashed") {
            borderStyle = "dashed"
        }
        var defaultObj: UTSJSONObject = colorInit.getJSON("default")!!
        var defaultActive: UTSJSONObject = colorInit.getJSON("active")!!
        var borderWidth = checkIsCssUnit(this.border.toString(10), "rpx")
        var dbordercolor = getDefaultColor(this.borderColor)
        var background = getDefaultColor(this.bgColor)
        var fontcolor = getDefaultColor(this.fontColor)
        var realColor = fontcolor
        var realBackground = background
        var realBackImg = ""
        var shadowX = this._shadow[0].toString(10)
        var shadowY = this._shadow[1].toString(10)
        if (shadowX != shadowX && this._shadow[0] != 0) {
            this.boxShadow = "0 " + shadowX + "px " + shadowY + "px " + (if (this._iconBtn) {
                "transparent"
            } else {
                defaultObj.getString("shadow")!!
            }
            )
        }
        this._set_border_color = "" + borderWidth + " " + borderStyle + " " + (if (dbordercolor == "") {
            defaultObj.getString("borderColor")!!
        } else {
            dbordercolor
        }
        )
        realBackground = if (background == "") {
            defaultObj.getString("background")!!
        } else {
            background
        }
        if (this.color == "info") {
            realColor = dePrimarycolor
        } else {
            realColor = if (fontcolor == "") {
                defaultObj.getString("fontColor")!!
            } else {
                fontcolor
            }
        }
        if (hover) {
            if (shadowX != shadowX && this._shadow[0] != 0) {
                this.boxShadow = "0 " + shadowX + "px " + shadowY + "px " + (if (this._iconBtn) {
                    "transparent"
                } else {
                    defaultActive.getString("shadow")!!
                }
                )
            }
            this._set_border_color = "" + borderWidth + " " + borderStyle + " " + (if (dbordercolor == "") {
                defaultActive.getString("borderColor")!!
            } else {
                dbordercolor
            }
            )
            realBackground = if (background == "") {
                defaultActive.getString("background")!!
            } else {
                background
            }
            realColor = if (fontcolor == "") {
                defaultActive.getString("fontColor")!!
            } else {
                fontcolor
            }
        }
        if (this.linearGradient.length > 0) {
            var dirs = this.linearGradient[0]
            if (this.linearGradient[0] == "top") {
                dirs = "to top"
            } else if (this.linearGradient[0] == "bottom") {
                dirs = "to bottom"
            } else if (this.linearGradient[0] == "left") {
                dirs = "to left"
            } else if (this.linearGradient[0] == "right") {
                dirs = "to right"
            }
            realBackground = ""
            realBackImg = "linear-gradient(" + dirs + "," + this.linearGradient[1] + "," + this.linearGradient[2] + ")"
        }
        if (this.fontDarkColor != "" && xConfig.dark == "dark") {
            realColor = getDefaultColor(this.fontDarkColor)
        }
        this._set_background_color = realBackground
        this._set_background_img = realBackImg
        this._set_font_color = realColor
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("parentButton" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "position" to "relative")), "xButton" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "width" to "100%", "height" to "100%")), "loadingMask" to padStyleMapOf(utsMapOf("position" to "absolute", "backgroundColor" to "rgba(200,200,200,0.6)", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "boxSizing" to "border-box", "width" to "100%", "height" to "100%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("click" to null, "getuserinfo" to null, "contact" to null, "getphonenumber" to null, "getrealtimephonenumber" to null, "error" to null, "opensetting" to null, "launchapp" to null, "chooseavatar" to null, "chooseaddress" to null, "chooseinvoicetitle" to null, "addgroupapp" to null, "subscribe" to null, "login" to null, "agreeprivacyauthorization" to null)
        var props = normalizePropsOptions(utsMapOf("color" to utsMapOf("type" to "String", "default" to ""), "darkColor" to utsMapOf("type" to "String", "default" to ""), "bgColor" to utsMapOf("type" to "String", "default" to ""), "linearGradient" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf()
        }
        ), "fontColor" to utsMapOf("type" to "String", "default" to ""), "fontDarkColor" to utsMapOf("type" to "String", "default" to ""), "fontSize" to utsMapOf("type" to "String", "default" to ""), "round" to utsMapOf("type" to "String", "default" to ""), "border" to utsMapOf("type" to "Number", "default" to 2), "shadow" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<Number> {
            return utsArrayOf<Number>()
        }
        ), "borderColor" to utsMapOf("type" to "String", "default" to ""), "skin" to utsMapOf("type" to "String", "default" to "default"), "icon" to utsMapOf("type" to "String", "default" to ""), "iconBtn" to utsMapOf("type" to "Boolean", "default" to false), "iconSize" to utsMapOf("type" to "String", "default" to ""), "size" to utsMapOf("type" to "String", "default" to "normal"), "url" to utsMapOf("type" to "String", "default" to ""), "navigateMode" to utsMapOf("type" to "String", "default" to "navigateTo"), "disabled" to utsMapOf("type" to "Boolean", "default" to false), "loading" to utsMapOf("type" to "Boolean", "default" to false), "height" to utsMapOf("type" to "String", "default" to ""), "width" to utsMapOf("type" to "String", "default" to ""), "block" to utsMapOf("type" to "Boolean", "default" to false), "formType" to utsMapOf("type" to "String", "default" to ""), "lineHeight" to utsMapOf("type" to "String", "default" to "1.4"), "fontWeight" to utsMapOf("type" to "String", "default" to "normal"), "openType" to utsMapOf("type" to "String", "default" to ""), "lang" to utsMapOf("type" to "String", "default" to "en"), "sessionFrom" to utsMapOf("type" to "String", "default" to ""), "sendMessageTitle" to utsMapOf("type" to "String", "default" to ""), "sendMessagePath" to utsMapOf("type" to "String", "default" to ""), "sendMessageImg" to utsMapOf("type" to "String", "default" to ""), "appParameter" to utsMapOf("type" to "String", "default" to ""), "showMessageCard" to utsMapOf("type" to "Boolean", "default" to false), "phoneNumberNoQuotaToast" to utsMapOf("type" to "Boolean", "default" to true)))
        var propsNeedCastKeys = utsArrayOf(
            "color",
            "darkColor",
            "bgColor",
            "linearGradient",
            "fontColor",
            "fontDarkColor",
            "fontSize",
            "round",
            "border",
            "shadow",
            "borderColor",
            "skin",
            "icon",
            "iconBtn",
            "iconSize",
            "size",
            "url",
            "navigateMode",
            "disabled",
            "loading",
            "height",
            "width",
            "block",
            "formType",
            "lineHeight",
            "fontWeight",
            "openType",
            "lang",
            "sessionFrom",
            "sendMessageTitle",
            "sendMessagePath",
            "sendMessageImg",
            "appParameter",
            "showMessageCard",
            "phoneNumberNoQuotaToast"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
