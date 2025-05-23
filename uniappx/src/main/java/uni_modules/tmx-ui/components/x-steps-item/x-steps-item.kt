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
open class GenUniModulesTmxUiComponentsXStepsItemXStepsItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            var parent: XStepsComponentPublicInstance? = null
            try {
                parent = this.`$parent` as XStepsComponentPublicInstance
            }
             catch (e: Throwable) {}
            if (parent != null) {
                parent.addItem(CHIDREN_ITEM1(id = this.id as String, ele = this))
            }
            var t = this
            var ele = this.`$refs`["xStepsItemHTextVBox"] as UniElement?
            if (ele == null) {
                return
            }
            if (this.resizeObserver == null) {
                this.resizeObserver = UniResizeObserver(fun(entries: UTSArray<UniResizeObserverEntry>){
                    entries.forEach(fun(entry){
                        if (entry.target == ele) {
                            t.eleMinHeight = ele.getBoundingClientRect().height
                        }
                    }
                    )
                }
                )
            }
            this.resizeObserver!!.observe(ele!!)
        }
        , __ins)
        onUpdated(fun() {}, __ins)
        onBeforeUnmount(fun() {
            var parent: XStepsComponentPublicInstance? = null
            try {
                parent = this.`$parent` as XStepsComponentPublicInstance
            }
             catch (e: Throwable) {}
            if (parent != null) {
                parent!!.delItem(this.id as String)
            }
            this.resizeObserver?.disconnect()
        }
        , __ins)
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        return createElementVNode("view", utsMapOf("onClick" to _ctx.itemClick, "class" to normalizeClass(utsArrayOf(
            if (_ctx.xsetpsvertical) {
                "xStepsItemV"
            } else {
                "xStepsItemH"
            }
        )), "style" to normalizeStyle(utsMapOf("height" to if (_ctx.xsetpsvertical) {
            _ctx.eleMinHeight + "px"
        } else {
            "auto"
        }
        ))), utsArrayOf(
            if (isTrue(!_ctx.xsetpsvertical)) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "xStepsItemH_border", "style" to normalizeStyle(utsMapOf("marginBottom" to "5px"))), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "xStepsItemH_border_l", "style" to normalizeStyle(utsMapOf("backgroundColor" to if (_ctx.indexIdx == 0) {
                        "transparent"
                    } else {
                        _ctx._linearColor
                    }))), null, 4),
                    createElementVNode("view", utsMapOf("class" to "xStepsItemH_border_h"), utsArrayOf(
                        createVNode(_component_x_icon, utsMapOf("color" to _ctx._linearColor, "font-size" to _ctx._iconSize, "name" to if (_ctx.active) {
                            _ctx._activeIcon
                        } else {
                            _ctx._icon
                        }), null, 8, utsArrayOf(
                            "color",
                            "font-size",
                            "name"
                        ))
                    )),
                    createElementVNode("view", utsMapOf("class" to "xStepsItemH_border_r", "style" to normalizeStyle(utsMapOf("backgroundColor" to if (_ctx.indexIdx == _ctx.list.length - 1) {
                        "transparent"
                    } else {
                        _ctx._linearColor
                    }))), null, 4)
                ), 4)
            } else {
                createElementVNode("view", utsMapOf("key" to 1, "class" to "xStepsItemV_border_box"), utsArrayOf(
                    createVNode(_component_x_icon, utsMapOf("color" to _ctx._linearColor, "font-size" to _ctx._iconSize, "name" to if (_ctx.active) {
                        _ctx._activeIcon
                    } else {
                        _ctx._icon
                    }
                    ), null, 8, utsArrayOf(
                        "color",
                        "font-size",
                        "name"
                    ))
                ))
            }
            ,
            createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                if (_ctx.xsetpsvertical) {
                    "xStepsItemHTextV"
                } else {
                    "xStepsItemHText"
                }
            ))), utsArrayOf(
                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "100%")), "ref" to "xStepsItemHTextVBox"), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "default", GenUniModulesTmxUiComponentsXStepsItemXStepsItemSlotDataDefault(active = _ctx.active), fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "xStepsText", "style" to normalizeStyle(utsMapOf("textAlign" to if (_ctx.xsetpsvertical) {
                                "left"
                            } else {
                                "center"
                            }
                            , "marginBottom" to "2px", "fontWeight" to "bold", "color" to _ctx._color, "fontSize" to _ctx._labelSize))), toDisplayString(_ctx._label), 5),
                            createElementVNode("text", utsMapOf("class" to "xStepsText", "style" to normalizeStyle(utsMapOf("textAlign" to if (_ctx.xsetpsvertical) {
                                "left"
                            } else {
                                "center"
                            }
                            , "color" to _ctx._linearColor, "fontSize" to _ctx._descSize))), toDisplayString(_ctx._desc), 5)
                        )
                    }
                    ),
                    if (isTrue(_ctx.xsetpsvertical)) {
                        createElementVNode("view", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("height" to "16px"))), null, 4)
                    } else {
                        createCommentVNode("v-if", true)
                    }
                ), 4)
            ), 2),
            if (isTrue(_ctx.xsetpsvertical)) {
                createElementVNode("view", utsMapOf("key" to 2, "class" to "xStepsVSlider", "style" to normalizeStyle(utsMapOf("top" to _ctx._iconSize, "backgroundColor" to if (_ctx.indexIdx == _ctx.list.length - 1) {
                    "transparent"
                } else {
                    _ctx._linearColor
                }))), null, 4)
            } else {
                createCommentVNode("v-if", true)
            }
        ), 14, utsArrayOf(
            "onClick"
        ))
    }
    open var xsetpsIcon: String by `$inject`
    open var xsetpsActiveIcon: String by `$inject`
    open var xsetpsiconSize: String by `$inject`
    open var xsetpslabelSize: String by `$inject`
    open var xsetpsdescSize: String by `$inject`
    open var xsetpsactiveColor: String by `$inject`
    open var xsetpscolor: String by `$inject`
    open var xsetpsvertical: Boolean by `$inject`
    open var xsetpsdisabled: Boolean by `$inject`
    open var label: String by `$props`
    open var desc: String by `$props`
    open var color: String by `$props`
    open var activeColor: String by `$props`
    open var icon: String by `$props`
    open var activeIcon: String by `$props`
    open var iconSize: String by `$props`
    open var labelSize: String by `$props`
    open var descSize: String by `$props`
    open var id: Any? by `$data`
    open var list: UTSArray<String> by `$data`
    open var active: Boolean by `$data`
    open var resizeObserver: UniResizeObserver? by `$data`
    open var eleMinHeight: Number by `$data`
    open var _label: String by `$data`
    open var _desc: String by `$data`
    open var indexIdx: Number by `$data`
    open var _align: String by `$data`
    open var _linearColor: String by `$data`
    open var _color: String by `$data`
    open var _icon: String by `$data`
    open var _activeIcon: String by `$data`
    open var _iconSize: String by `$data`
    open var _labelSize: String by `$data`
    open var _descSize: String by `$data`
    open var _disabled: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("id" to ("xStepsItemH-" + getUid()), "list" to utsArrayOf<String>(), "active" to false, "resizeObserver" to null as UniResizeObserver?, "eleMinHeight" to 20, "_label" to computed<String>(fun(): String {
            return this.label
        }
        ), "_desc" to computed<String>(fun(): String {
            return this.desc
        }
        ), "indexIdx" to computed<Number>(fun(): Number {
            var index = this.list.findIndex(fun(el: String): Boolean {
                return el == this.id
            }
            )
            return index
        }
        ), "_align" to computed<String>(fun(): String {
            return "center"
        }
        ), "_linearColor" to computed<String>(fun(): String {
            var ac = this.activeColor
            if (ac == "") {
                ac = this.xsetpsactiveColor
            }
            if (ac == "") {
                ac = xConfig.color
            }
            if (this.active) {
                return getDefaultColor(ac)
            }
            return "#afafaf"
        }
        ), "_color" to computed<String>(fun(): String {
            var ac = this.activeColor
            if (ac == "") {
                ac = this.xsetpsactiveColor
            }
            if (ac == "") {
                ac = xConfig.color
            }
            if (this.active) {
                return getDefaultColor(ac)
            }
            var unac = this.color
            if (unac == "") {
                unac = this.xsetpscolor
            }
            if (xConfig.dark == "dark") {
                return "#FFFFFF"
            }
            return getDefaultColor(unac)
        }
        ), "_icon" to computed<String>(fun(): String {
            if (this.icon == "") {
                return this.xsetpsIcon
            }
            return this.icon
        }
        ), "_activeIcon" to computed<String>(fun(): String {
            if (this.activeIcon == "") {
                return this.xsetpsActiveIcon
            }
            return this.activeIcon
        }
        ), "_iconSize" to computed<String>(fun(): String {
            var fontSize = checkIsCssUnit(this.iconSize, xConfig.unit)
            if (this.iconSize == "") {
                fontSize = checkIsCssUnit(this.xsetpsiconSize, xConfig.unit)
            }
            if (xConfig.fontScale == 1) {
                return fontSize
            }
            var sizeNumber = parseInt(fontSize)
            if (isNaN(sizeNumber)) {
                sizeNumber = 14
            }
            return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
        }
        ), "_labelSize" to computed<String>(fun(): String {
            var fontSize = checkIsCssUnit(this.labelSize, xConfig.unit)
            if (this.xsetpslabelSize != "") {
                fontSize = checkIsCssUnit(this.xsetpslabelSize, xConfig.unit)
            }
            if (xConfig.fontScale == 1) {
                return fontSize
            }
            var sizeNumber = parseInt(fontSize)
            if (isNaN(sizeNumber)) {
                sizeNumber = 14
            }
            return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
        }
        ), "_descSize" to computed<String>(fun(): String {
            var fontSize = checkIsCssUnit(this.descSize, xConfig.unit)
            if (this.xsetpsdescSize != "") {
                fontSize = checkIsCssUnit(this.xsetpsdescSize, xConfig.unit)
            }
            if (xConfig.fontScale == 1) {
                return fontSize
            }
            var sizeNumber = parseInt(fontSize)
            if (isNaN(sizeNumber)) {
                sizeNumber = 14
            }
            return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.xsetpsdisabled
        }
        ))
    }
    open var setList = ::gen_setList_fn
    open fun gen_setList_fn(items: UTSArray<String>) {
        this.list = items
    }
    open var setActive = ::gen_setActive_fn
    open fun gen_setActive_fn(isActive: Boolean) {
        this.active = isActive
    }
    open var itemClick = ::gen_itemClick_fn
    open fun gen_itemClick_fn() {
        this.`$emit`("click", this.indexIdx, this.active)
        if (!this._disabled) {
            var parent: XStepsComponentPublicInstance? = null
            try {
                parent = this.`$parent` as XStepsComponentPublicInstance
            }
             catch (e: Throwable) {}
            if (parent != null) {
                parent.addChange(this.id as String)
            }
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
                return utsMapOf("xStepsVSlider" to padStyleMapOf(utsMapOf("width" to 1, "height" to "100%", "position" to "absolute", "left" to 16, "zIndex" to 0)), "xStepsItemH" to padStyleMapOf(utsMapOf("flex" to 1, "display" to "flex", "flexDirection" to "column", "justifyContent" to "flex-start")), "xStepsItemV" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "stretch", "justifyContent" to "flex-start")), "xStepsItemV_border" to padStyleMapOf(utsMapOf("height" to "100%", "width" to 1, "backgroundImage" to "none", "backgroundColor" to "#FF0000", "position" to "absolute", "zIndex" to 1, "left" to 0, "top" to 3)), "xStepsItemV_border_box" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "flex-start", "justifyContent" to "center", "width" to 32, "zIndex" to 2)), "xStepsItemHTextV" to padStyleMapOf(utsMapOf("display" to "flex", "flex" to 1, "paddingRight" to 12)), "xStepsItemHText" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center", "flexWrap" to "wrap", "flex" to 1, "paddingTop" to 0, "paddingRight" to 5, "paddingBottom" to 0, "paddingLeft" to 5)), "xStepsItemH_border" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "xStepsItemH_border_h" to padStyleMapOf(utsMapOf("paddingTop" to 0, "paddingRight" to 5, "paddingBottom" to 0, "paddingLeft" to 5)), "xStepsItemH_border_l" to padStyleMapOf(utsMapOf("flex" to 1, "height" to 1)), "xStepsItemH_border_r" to padStyleMapOf(utsMapOf("flex" to 1, "height" to 1)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf("xsetpsIcon" to utsMapOf("type" to "String", "default" to "checkbox-blank-circle-fill"), "xsetpsActiveIcon" to utsMapOf("type" to "String", "default" to "checkbox-circle-fill"), "xsetpsiconSize" to utsMapOf("type" to "String", "default" to "11"), "xsetpslabelSize" to utsMapOf("type" to "String", "default" to "14"), "xsetpsdescSize" to utsMapOf("type" to "String", "default" to "12"), "xsetpsactiveColor" to utsMapOf("type" to "String", "default" to ""), "xsetpscolor" to utsMapOf("type" to "String", "default" to ""), "xsetpsvertical" to utsMapOf("type" to "Boolean", "default" to false), "xsetpsdisabled" to utsMapOf("type" to "Boolean", "default" to true))
        var emits: Map<String, Any?> = utsMapOf("click" to null)
        var props = normalizePropsOptions(utsMapOf("label" to utsMapOf("type" to "String", "default" to ""), "desc" to utsMapOf("type" to "String", "default" to ""), "color" to utsMapOf("type" to "String", "default" to ""), "activeColor" to utsMapOf("type" to "String", "default" to ""), "icon" to utsMapOf("type" to "String", "default" to ""), "activeIcon" to utsMapOf("type" to "String", "default" to ""), "iconSize" to utsMapOf("type" to "String", "default" to ""), "labelSize" to utsMapOf("type" to "String", "default" to ""), "descSize" to utsMapOf("type" to "String", "default" to "")))
        var propsNeedCastKeys = utsArrayOf(
            "label",
            "desc",
            "color",
            "activeColor",
            "icon",
            "activeIcon",
            "iconSize",
            "labelSize",
            "descSize"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
