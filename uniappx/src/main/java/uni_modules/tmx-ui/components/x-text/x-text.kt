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
open class GenUniModulesTmxUiComponentsXTextXText : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return createElementVNode("text", utsMapOf("onClick" to _ctx.allClick, "style" to normalizeStyle(utsArrayOf(
            _ctx._styleMap,
            _ctx.___style
        )), "class" to normalizeClass(utsArrayOf(
            _ctx.___class,
            "xTextLines"
        )), "selectable" to _ctx.selectable), utsArrayOf(
            renderSlot(_ctx.`$slots`, "default", UTSJSONObject(), fun(): UTSArray<Any> {
                return utsArrayOf(
                    if (_ctx._label == "") {
                        createElementVNode("text", utsMapOf("key" to 0, "onClick" to _ctx.allClick, "style" to normalizeStyle(utsArrayOf(
                            _ctx._styleMap,
                            _ctx.___style
                        )), "class" to normalizeClass(utsArrayOf(
                            _ctx.___class,
                            "xTextLines"
                        )), "selectable" to _ctx.selectable), toDisplayString(_ctx._label), 15, utsArrayOf(
                            "onClick",
                            "selectable"
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    }
                )
            }
            ),
            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx._texts, fun(item, index, __index, _cached): Any {
                return createElementVNode("text", utsMapOf("onClick" to fun(){
                    _ctx.itemClick(item.text)
                }
                , "class" to normalizeClass(utsArrayOf(
                    _ctx.___class
                )), "selectable" to _ctx.selectable, "style" to normalizeStyle(utsArrayOf(
                    utsMapOf("color" to item.color, "lineHeight" to _ctx.lineHeight, "fontSize" to _ctx._fontSize),
                    if (item.isHeightLight) {
                        _ctx.heightLightStyle
                    } else {
                        utsMapOf<String, Any?>()
                    }
                    ,
                    _ctx.___style
                )), "key" to index), toDisplayString(item.text), 15, utsArrayOf(
                    "onClick",
                    "selectable"
                ))
            }
            ), 128)
        ), 14, utsArrayOf(
            "onClick",
            "selectable"
        ))
    }
    open var _style: String by `$props`
    open var _class: String by `$props`
    open var label: String by `$props`
    open var heightLight: UTSArray<String> by `$props`
    open var heightLightReg: UTSArray<String> by `$props`
    open var heightLightStyle: String by `$props`
    open var lines: Number by `$props`
    open var selectable: Boolean by `$props`
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var heightLightColor: String by `$props`
    open var lineHeight: String by `$props`
    open var fontSize: String by `$props`
    open var ___class: String by `$data`
    open var ___style: String by `$data`
    open var _fontSize: String by `$data`
    open var _color: String by `$data`
    open var _heightLightColor: String by `$data`
    open var _label: String by `$data`
    open var _texts: UTSArray<ITEMINFO> by `$data`
    open var _texts2: String by `$data`
    open var _styleMap: Map<String, String> by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("___class" to computed<String>(fun(): String {
            return this._class
        }
        ), "___style" to computed<String>(fun(): String {
            return this._style
        }
        ), "_fontSize" to computed<String>(fun(): String {
            var fontSize = checkIsCssUnit(this.fontSize, xConfig.unit)
            if (xConfig.fontScale == 1) {
                return fontSize
            }
            var sizeNumber = parseInt(fontSize)
            if (isNaN(sizeNumber)) {
                sizeNumber = 14
            }
            return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
        }
        ), "_color" to computed<String>(fun(): String {
            var color = this.color
            if (xConfig.dark == "dark") {
                if (this.darkColor != "") {
                    color = this.darkColor!!
                    return getDefaultColor(color)
                }
                return setTextColorLightByDark(color)
            }
            return getDefaultColor(this.color)
        }
        ), "_heightLightColor" to computed<String>(fun(): String {
            return getDefaultColor(this.heightLightColor)
        }
        ), "_label" to computed<String>(fun(): String {
            return this.label
        }
        ), "_texts" to computed<UTSArray<ITEMINFO>>(fun(): UTSArray<ITEMINFO> {
            if (this.label == "") {
                return utsArrayOf<ITEMINFO>()
            }
            var keywords = this.heightLight
            var albel = this.label
            if ((keywords.length == 0 && this.heightLightReg.length == 0) || albel.length == 0) {
                return utsArrayOf(
                    ITEMINFO(text = albel, color = this._color, isHeightLight = false)
                )
            }
            var regexxAr = utsArrayOf<String>()
            this.heightLightReg.forEach(fun(reg: String) {
                var regex = UTSRegExp(reg, "gi")
                var rulst = regex.exec(albel)
                while(rulst != null && UTSArray.isArray(rulst)){
                    if (UTSArray.isArray(rulst)) {
                        var str = rulst[0]!! as String
                        if (!regexxAr.includes(str)) {
                            regexxAr.push(str)
                        }
                    }
                    rulst = regex.exec(albel)
                }
            }
            )
            keywords = keywords.concat(regexxAr)
            keywords.forEach(fun(keyword: String) {
                var reg: UTSRegExp = UTSRegExp("[\\*]", "gi")
                var isFuhao = reg.test(keyword)
                var regex = UTSRegExp(if (isFuhao) {
                    ("\\" + keyword)
                } else {
                    keyword
                }
                , "gi")
                albel = albel.replace(regex, "~-<span>" + keyword + "</span>~-")
            }
            )
            var ps = albel.split("~-")
            var ar = utsArrayOf<ITEMINFO>()
            ps.forEach(fun(el: String){
                if (el.length > 0) {
                    var start = el.indexOf("<span>")
                    if (start > -1) {
                        var end = el.lastIndexOf("</span>")
                        ar.push(ITEMINFO(text = el.substring(start + 6, end), color = this._heightLightColor, isHeightLight = true))
                    } else {
                        ar.push(ITEMINFO(text = el, color = this._color, isHeightLight = false))
                    }
                }
            }
            )
            return ar
        }
        ), "_texts2" to computed<String>(fun(): String {
            var txt = ""
            run {
                var i: Number = 0
                while(i < this._texts.length){
                    var item = this._texts[i]
                    txt += "<a href=\"https://x-ui.com\" style=\"text-decoration:none;\"><span style=\"color:" + item.color + ";" + (if (item.isHeightLight) {
                        this.heightLightStyle
                    } else {
                        ""
                    }
                    ) + "\">" + item.text + "</span></a>"
                    i++
                }
            }
            return txt
        }
        ), "_styleMap" to computed<Map<String, String>>(fun(): Map<String, String> {
            var styleMap = Map<String, String>()
            if (this.lines > 0) {
                styleMap.set("lines", this.lines.toString(10))
            }
            styleMap.set("line-height", this.lineHeight)
            styleMap.set("font-size", this._fontSize)
            styleMap.set("color", this._color)
            return styleMap
        }
        ))
    }
    open var allClick = ::gen_allClick_fn
    open fun gen_allClick_fn() {
        this.`$emit`("click")
    }
    open var itemClick = ::gen_itemClick_fn
    open fun gen_itemClick_fn(str: String) {
        this.`$emit`("item-click", str)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xTextRegx" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "flexWrap" to "wrap")), "xTextLines" to padStyleMapOf(utsMapOf("textOverflow" to "ellipsis")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("click" to null, "item-click" to null)
        var props = normalizePropsOptions(utsMapOf("_style" to utsMapOf("type" to "String", "default" to ""), "_class" to utsMapOf("type" to "String", "default" to ""), "label" to utsMapOf("type" to "String", "default" to ""), "heightLight" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "heightLightReg" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "heightLightStyle" to utsMapOf("type" to "String", "default" to ""), "lines" to utsMapOf("type" to "Number", "default" to 0), "selectable" to utsMapOf("type" to "Boolean", "default" to false), "color" to utsMapOf("type" to "String", "default" to "#333333"), "darkColor" to utsMapOf("type" to "String", "default" to ""), "heightLightColor" to utsMapOf("type" to "String", "default" to "primary"), "lineHeight" to utsMapOf("type" to "String", "default" to "1.7"), "fontSize" to utsMapOf("type" to "String", "default" to "15px")))
        var propsNeedCastKeys = utsArrayOf(
            "_style",
            "_class",
            "label",
            "heightLight",
            "heightLightReg",
            "heightLightStyle",
            "lines",
            "selectable",
            "color",
            "darkColor",
            "heightLightColor",
            "lineHeight",
            "fontSize"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
