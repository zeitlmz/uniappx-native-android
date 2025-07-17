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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.switchTab as uni_switchTab
open class GenUniModulesTmxUiComponentsXCellXCell : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
        return createElementVNode("view", utsMapOf("onClick" to _ctx.clickLisent, "hover-start-time" to if (_ctx._isLinksHover) {
            50
        } else {
            0
        }
        , "hover-stay-time" to if (_ctx._isLinksHover) {
            100
        } else {
            0
        }
        , "hover-class" to if (_ctx._isLinksHover) {
            "cellHover"
        } else {
            ""
        }
        , "class" to "xCell", "style" to normalizeStyle(utsMapOf("backgroundColor" to _ctx._color, "borderRadius" to if (_ctx._allAttr.card == true) {
            _ctx._cardRadius
        } else {
            "0px"
        }
        , "minHeight" to _ctx._minHeight, "padding" to _ctx._padding, "margin" to if (_ctx._allAttr.card) {
            _ctx._margin
        } else {
            "0px"
        }
        , "borderBottom" to if (_ctx._allAttr.bottom && !_ctx._allAttr.card && !_ctx.bottomBorderInsert) {
            "1px solid " + _ctx._bottomBorderColor
        } else {
            "none"
        }
        ))), utsArrayOf(
            if (isTrue(_ctx._icon)) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "xCellAvatar", "style" to normalizeStyle(utsMapOf("width" to _ctx._leftSize, "height" to _ctx._leftSize, "borderRadius" to _ctx._avatarRound))), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "avatar", utsMapOf("icon" to _ctx._icon), fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createVNode(_component_x_icon, utsMapOf("color" to _ctx._allAttr.iconColor, "font-size" to _ctx._iconSize, "name" to _ctx._icon), null, 8, utsArrayOf(
                                "color",
                                "font-size",
                                "name"
                            ))
                        )
                    })
                ), 4)
            } else {
                createCommentVNode("v-if", true)
            }
            ,
            createElementVNode("view", utsMapOf("class" to "xCellWrap", "style" to normalizeStyle(utsMapOf("borderBottom" to if (_ctx._allAttr.bottom && !_ctx._allAttr.card && _ctx.bottomBorderInsert) {
                "1px solid " + _ctx._bottomBorderColor
            } else {
                "none"
            }
            ))), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "center"), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "default", UTSJSONObject(), fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "title", "style" to normalizeStyle(utsMapOf("color" to _ctx._titleColor, "fontSize" to _ctx._titleSize))), toDisplayString(_ctx._allAttr.title), 5)
                        )
                    }
                    ),
                    renderSlot(_ctx.`$slots`, "desc", utsMapOf("desc" to _ctx._allAttr.desc), fun(): UTSArray<Any> {
                        return utsArrayOf(
                            if (_ctx._allAttr.desc != "") {
                                createVNode(_component_x_text, utsMapOf("key" to 0, "font-size" to "12", "color" to "#bfbfbf", "dark-color" to "#bfbfbf", "class" to "desc"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        toDisplayString(_ctx._allAttr.desc)
                                    )
                                }), "_" to 1))
                            } else {
                                createCommentVNode("v-if", true)
                            }
                        )
                    }
                    )
                )),
                createElementVNode("view", utsMapOf("class" to "xcellRight"), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "label", utsMapOf("label" to _ctx._allAttr.label), fun(): UTSArray<Any> {
                        return utsArrayOf(
                            if (_ctx._allAttr.label != "") {
                                createElementVNode("text", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("color" to _ctx._allAttr.labelColor, "fontSize" to _ctx._rightLableSize, "width" to _ctx._rightWidth)), "class" to "rightLabel"), toDisplayString(_ctx._allAttr.label), 5)
                            } else {
                                createCommentVNode("v-if", true)
                            }
                        )
                    }
                    ),
                    renderSlot(_ctx.`$slots`, "right"),
                    if (isTrue(_ctx._allAttr.url != "" || _ctx._allAttr.link)) {
                        createVNode(_component_x_icon, utsMapOf("key" to 0, "dark-color" to _ctx.linkDarkColor, "color" to _ctx.linkColor, "font-size" to "20", "name" to "arrow-right-s-line"), null, 8, utsArrayOf(
                            "dark-color",
                            "color"
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    }
                ))
            ), 4)
        ), 12, utsArrayOf(
            "onClick",
            "hover-start-time",
            "hover-stay-time",
            "hover-class"
        ))
    }
    open var icon: String by `$props`
    open var avatarRound: String by `$props`
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var iconColor: String by `$props`
    open var title: String by `$props`
    open var titleColor: String by `$props`
    open var darkTitleColor: String by `$props`
    open var titleSize: String by `$props`
    open var iconSize: String by `$props`
    open var label: String by `$props`
    open var labelColor: String by `$props`
    open var labelSize: String by `$props`
    open var desc: String by `$props`
    open var showBottomBorder: Boolean by `$props`
    open var bottomBorderInsert: Boolean by `$props`
    open var bottomBorderColor: String by `$props`
    open var link: Boolean by `$props`
    open var linkColor: String by `$props`
    open var linkDarkColor: String by `$props`
    open var url: String by `$props`
    open var card: Boolean by `$props`
    open var round: String by `$props`
    open var leftSize: String by `$props`
    open var minHeight: String by `$props`
    open var disabled: Boolean by `$props`
    open var padding: UTSArray<String> by `$props`
    open var margin: UTSArray<String> by `$props`
    open var rightWidth: String by `$props`
    open var _padding: String by `$data`
    open var _margin: String by `$data`
    open var _disabled: Boolean by `$data`
    open var _color: String by `$data`
    open var _titleColor: String by `$data`
    open var _leftSize: String by `$data`
    open var _rightWidth: String by `$data`
    open var _avatarRound: String by `$data`
    open var _minHeight: String by `$data`
    open var _bottomBorderColor: String by `$data`
    open var _icon: String by `$data`
    open var _allAttr: xCellItemType by `$data`
    open var _cardRadius: String by `$data`
    open var _titleSize: String by `$data`
    open var _iconSize: String by `$data`
    open var _rightLableSize: String by `$data`
    open var _isLinksHover: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("_padding" to computed<String>(fun(): String {
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
        ), "_margin" to computed<String>(fun(): String {
            if (this.margin.length == 0) {
                var par = fillArrayCssValue(xConfig.cellMargin)
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
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ), "_color" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                if (this.darkColor != "") {
                    return getDefaultColor(this.darkColor)
                }
                return getDefaultColor(xConfig.sheetDarkColor)
            }
            return getDefaultColor(this.color)
        }
        ), "_titleColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                if (this.darkTitleColor != "") {
                    return getDefaultColor(this.darkTitleColor)
                }
                return "#ffffff"
            }
            return getDefaultColor(this.titleColor)
        }
        ), "_leftSize" to computed<String>(fun(): String {
            return checkIsCssUnit(this.leftSize, xConfig.unit)
        }
        ), "_rightWidth" to computed<String>(fun(): String {
            return checkIsCssUnit(this.rightWidth, xConfig.unit)
        }
        ), "_avatarRound" to computed<String>(fun(): String {
            return checkIsCssUnit(this.avatarRound, xConfig.unit)
        }
        ), "_minHeight" to computed<String>(fun(): String {
            return checkIsCssUnit(this.minHeight, xConfig.unit)
        }
        ), "_bottomBorderColor" to computed<String>(fun(): String {
            if (this.bottomBorderColor != "") {
                return getDefaultColor(this.bottomBorderColor)
            }
            if (xConfig.dark == "dark") {
                return xConfig.borderDarkColor
            }
            return "#f5f5f5"
        }
        ), "_icon" to computed<String>(fun(): String {
            return this.icon
        }
        ), "_allAttr" to computed<xCellItemType>(fun(): xCellItemType {
            var iconColor = this.iconColor
            if (iconColor == "") {
                iconColor = xConfig.color
            }
            var p = xCellItemType(icon = this.icon, title = this.title, desc = this.desc, label = this.label, bottom = this.showBottomBorder, link = this.link, url = this.url, iconColor = getDefaultColor(iconColor), labelColor = getDefaultColor(this.labelColor), card = this.card)
            return p
        }
        ), "_cardRadius" to computed<String>(fun(): String {
            if (this.round == "") {
                return checkIsCssUnit(xConfig.inputRadius, xConfig.unit)
            }
            return checkIsCssUnit(xConfig.cellRadius, xConfig.unit)
        }
        ), "_titleSize" to computed<String>(fun(): String {
            var fontSize = checkIsCssUnit(this.titleSize, xConfig.unit)
            if (xConfig.fontScale == 1) {
                return fontSize
            }
            var sizeNumber = parseInt(fontSize)
            if (isNaN(sizeNumber)) {
                sizeNumber = 16
            }
            return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
        }
        ), "_iconSize" to computed<String>(fun(): String {
            var fontSize = checkIsCssUnit(this.iconSize, xConfig.unit)
            if (xConfig.fontScale == 1) {
                return fontSize
            }
            var sizeNumber = parseInt(fontSize)
            if (isNaN(sizeNumber)) {
                sizeNumber = 17
            }
            return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
        }
        ), "_rightLableSize" to computed<String>(fun(): String {
            var fontSize = checkIsCssUnit(this.labelSize, xConfig.unit)
            if (xConfig.fontScale == 1) {
                return fontSize
            }
            var sizeNumber = parseInt(fontSize)
            if (isNaN(sizeNumber)) {
                sizeNumber = 13
            }
            return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
        }
        ), "_isLinksHover" to computed<Boolean>(fun(): Boolean {
            return this.link
        }
        ))
    }
    open var clickLisent = ::gen_clickLisent_fn
    open fun gen_clickLisent_fn() {
        this.`$emit`("click")
        if (this.url != "" && !this._disabled) {
            uni_navigateTo(NavigateToOptions(url = this.url, fail = fun(_) {
                uni_switchTab(SwitchTabOptions(url = this.url))
            }
            ))
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
                return utsMapOf("cellHover" to padStyleMapOf(utsMapOf("opacity" to 0.9)), "xCell" to padStyleMapOf(utsMapOf("paddingTop" to 12, "paddingRight" to 0, "paddingBottom" to 12, "paddingLeft" to 0, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "xCellWrap" to padStyleMapOf(utsMapOf("flex" to 1, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "height" to "100%", "paddingTop" to 12, "paddingRight" to 0, "paddingBottom" to 12, "paddingLeft" to 0)), "title" to padStyleMapOf(utsMapOf("lines" to 2, "textOverflow" to "ellipsis", "flex" to 1, "flexShrink" to 0, "lineHeight" to 1.7)), "desc" to padStyleMapOf(utsMapOf("fontSize" to 12, "paddingTop" to 2)), "xCellAvatar" to padStyleMapOf(utsMapOf("marginRight" to 10, "display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center", "flexShrink" to 0, "overflow" to "hidden")), "center" to padStyleMapOf(utsMapOf("flex" to 1)), "xcellRight" to padStyleMapOf(utsMapOf("paddingLeft" to 16, "flexDirection" to "row", "justifyContent" to "flex-end", "alignItems" to "center")), "rightLabel" to padStyleMapOf(utsMapOf("lines" to 1, "textOverflow" to "ellipsis", "fontSize" to 12, "textAlign" to "right")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("click" to null)
        var props = normalizePropsOptions(utsMapOf("icon" to utsMapOf("type" to "String", "default" to ""), "avatarRound" to utsMapOf("type" to "String", "default" to "8"), "color" to utsMapOf("type" to "String", "default" to "white"), "darkColor" to utsMapOf("type" to "String", "default" to ""), "iconColor" to utsMapOf("type" to "String", "default" to ""), "title" to utsMapOf("type" to "String", "default" to "标题"), "titleColor" to utsMapOf("type" to "String", "default" to "black"), "darkTitleColor" to utsMapOf("type" to "String", "default" to "white"), "titleSize" to utsMapOf("type" to "String", "default" to "16"), "iconSize" to utsMapOf("type" to "String", "default" to "24"), "label" to utsMapOf("type" to "String", "default" to ""), "labelColor" to utsMapOf("type" to "String", "default" to "#bfbfbf"), "labelSize" to utsMapOf("type" to "String", "default" to "13"), "desc" to utsMapOf("type" to "String", "default" to ""), "showBottomBorder" to utsMapOf("type" to "Boolean", "default" to true), "bottomBorderInsert" to utsMapOf("type" to "Boolean", "default" to false), "bottomBorderColor" to utsMapOf("type" to "String", "default" to ""), "link" to utsMapOf("type" to "Boolean", "default" to true), "linkColor" to utsMapOf("type" to "String", "default" to "#bfbfbf"), "linkDarkColor" to utsMapOf("type" to "String", "default" to "#bfbfbf"), "url" to utsMapOf("type" to "String", "default" to ""), "card" to utsMapOf("type" to "Boolean", "default" to true), "round" to utsMapOf("type" to "String", "default" to ""), "leftSize" to utsMapOf("type" to "String", "default" to "32"), "minHeight" to utsMapOf("type" to "String", "default" to "55"), "disabled" to utsMapOf("type" to "Boolean", "default" to false), "padding" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>("12", "0")
        }
        ), "margin" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "rightWidth" to utsMapOf("type" to "String", "default" to "100")))
        var propsNeedCastKeys = utsArrayOf(
            "icon",
            "avatarRound",
            "color",
            "darkColor",
            "iconColor",
            "title",
            "titleColor",
            "darkTitleColor",
            "titleSize",
            "iconSize",
            "label",
            "labelColor",
            "labelSize",
            "desc",
            "showBottomBorder",
            "bottomBorderInsert",
            "bottomBorderColor",
            "link",
            "linkColor",
            "linkDarkColor",
            "url",
            "card",
            "round",
            "leftSize",
            "minHeight",
            "disabled",
            "padding",
            "margin",
            "rightWidth"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
