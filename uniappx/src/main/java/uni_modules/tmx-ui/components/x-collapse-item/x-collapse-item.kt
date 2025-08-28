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
open class GenUniModulesTmxUiComponentsXCollapseItemXCollapseItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.list = this.xCollapseDefaultName as UTSArray<String>
            val parent = this.getParent() as XCollapseComponentPublicInstance?
            if (parent != null) {
                parent!!.addItem(CHIDREN_ITEM(id = this.name, ele = this))
            }
            if (this._isActive) {
                this.getNodes()
            }
            var t = this
            var ele = this.`$refs`["xCollapseItemContent"] as UniElement
            if (ele == null) {
                return
            }
            if (this.resizeObserver == null) {
                this.resizeObserver = UniResizeObserver(fun(entries: UTSArray<UniResizeObserverEntry>){
                    entries.forEach(fun(entry){
                        if (entry.target == ele) {
                            if (t._isActive) {
                                t.getNodes()
                            }
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
            val parent = this.getParent() as XCollapseComponentPublicInstance?
            if (parent != null) {
                parent!!.delItem(this.name)
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
        val _component_x_divider = resolveEasyComponent("x-divider", GenUniModulesTmxUiComponentsXDividerXDividerClass)
        return _cE("view", _uM("class" to "xCollapseItemBox", "style" to _nS(_uM("background" to _ctx._color))), _uA(
            _cE("view", _uM("onClick" to _ctx.itemClick, "class" to "xCollapseItem", "style" to _nS(_uM("opacity" to if (_ctx._disabled) {
                0.5
            } else {
                1
            }
            ))), _uA(
                _cE("view", _uM("class" to "xCollapseItemBoxLeft"), _uA(
                    if (isTrue(_ctx._leftIcon)) {
                        _cV(_component_x_icon, _uM("key" to 0, "font-size" to _ctx._titleFontSize, "name" to _ctx._leftIcon, "color" to if (_ctx._isActive) {
                            _ctx._activeColor
                        } else {
                            _ctx._titleColor
                        }, "style" to _nS(_uM("margin-right" to "12px"))), null, 8, _uA(
                            "font-size",
                            "name",
                            "color",
                            "style"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    renderSlot(_ctx.`$slots`, "left", _uM("status" to _ctx.opened)),
                    _cE("view", _uM("class" to "xCollapseItemBoxTextBox", "style" to _nS(_uM("height" to _ctx._titleHeight))), _uA(
                        _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                            renderSlot(_ctx.`$slots`, "title", _uM("status" to _ctx.opened), fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("text", _uM("class" to "xCollapseItemBoxText", "style" to _nS(_ctx._textMap)), _tD(_ctx._title), 5)
                                )
                            }
                            )
                        ), 4)
                    ), 4)
                )),
                _cE("view", _uM("class" to "xCollapseItemBoxRight"), _uA(
                    renderSlot(_ctx.`$slots`, "right", _uM("status" to _ctx.opened)),
                    _cV(_component_x_icon, _uM("color" to if (_ctx._isActive) {
                        _ctx._activeColor
                    } else {
                        "#bfbfbf"
                    }
                    , "style" to _nS(_uM("margin-left" to "12px")), "name" to if (_ctx.opened) {
                        "arrow-down-s-line"
                    } else {
                        "arrow-right-s-line"
                    }
                    ), null, 8, _uA(
                        "color",
                        "style",
                        "name"
                    ))
                ))
            ), 12, _uA(
                "onClick"
            )),
            _cE("view", _uM("class" to "xCollapseItemWrap", "style" to _nS(_uM("height" to if (_ctx.opened) {
                (_ctx.itemHeight + "px")
            } else {
                "0rpx"
            }
            ))), _uA(
                _cE("view", _uM("class" to "xCollapseItemContent", "ref" to "xCollapseItemContent"), _uA(
                    renderSlot(_ctx.`$slots`, "default")
                ), 512)
            ), 4),
            if (isTrue(_ctx.showBottomLine)) {
                _cV(_component_x_divider, _uM("key" to 0))
            } else {
                _cC("v-if", true)
            }
        ), 4)
    }
    open var xCollapseDefaultName: UTSArray<Any?> by `$inject`
    open var name: String by `$props`
    open var showBottomLine: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var titleFontSize: String by `$props`
    open var titleColor: String by `$props`
    open var darkTitleColor: String by `$props`
    open var activeColor: String by `$props`
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var leftIcon: String by `$props`
    open var title: String by `$props`
    open var titleHeight: String by `$props`
    open var titleLines: Number by `$props`
    open var itemHeight: Number by `$data`
    open var opened: Boolean by `$data`
    open var id: Any? by `$data`
    open var list: UTSArray<String> by `$data`
    open var resizeObserver: UniResizeObserver? by `$data`
    open var _disabled: Boolean by `$data`
    open var _titleFontSize: String by `$data`
    open var _titleHeight: String by `$data`
    open var _titleColor: String by `$data`
    open var _activeColor: String by `$data`
    open var _color: String by `$data`
    open var _leftIcon: String by `$data`
    open var _title: String by `$data`
    open var _isActive: Boolean by `$data`
    open var _textMap: Map<String, String> by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("itemHeight" to 0, "opened" to false, "id" to ("xCollapseItem-" + getUid()), "list" to _uA<String>(), "resizeObserver" to null as UniResizeObserver?, "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ), "_titleFontSize" to computed<String>(fun(): String {
            var fontSize = checkIsCssUnit(this.titleFontSize, xConfig.unit)
            if (xConfig.fontScale == 1) {
                return fontSize
            }
            var sizeNumber = parseInt(fontSize)
            if (isNaN(sizeNumber)) {
                sizeNumber = 16
            }
            return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
        }
        ), "_titleHeight" to computed<String>(fun(): String {
            return checkIsCssUnit(this.titleHeight, xConfig.unit)
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
        ), "_activeColor" to computed<String>(fun(): String {
            if (this.activeColor == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.activeColor)
        }
        ), "_color" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                if (this.darkColor != "") {
                    return getDefaultColor(this.darkColor)
                }
                return xConfig.sheetDarkColor
            }
            return getDefaultColor(this.color)
        }
        ), "_leftIcon" to computed<String>(fun(): String {
            return this.leftIcon
        }
        ), "_title" to computed<String>(fun(): String {
            return this.title
        }
        ), "_isActive" to computed<Boolean>(fun(): Boolean {
            return this.list.includes(this.name)
        }
        ), "_textMap" to computed<Map<String, String>>(fun(): Map<String, String> {
            var styleMap = Map<String, String>()
            styleMap.set("fontSize", this._titleFontSize)
            styleMap.set("color", if (this._isActive) {
                this._activeColor
            } else {
                this._titleColor
            }
            )
            styleMap.set("lines", this.titleLines.toString(10))
            return styleMap
        }
        ))
    }
    open var getParent = ::gen_getParent_fn
    open fun gen_getParent_fn(): Any? {
        var parent: XCollapseComponentPublicInstance? = null
        try {
            parent = this.`$parent` as XCollapseComponentPublicInstance
        }
         catch (e: Throwable) {}
        return parent
    }
    open var setList = ::gen_setList_fn
    open fun gen_setList_fn(items: UTSArray<String>) {
        this.list = items
        this.getNodes()
    }
    open var itemClick = ::gen_itemClick_fn
    open fun gen_itemClick_fn() {
        this.`$emit`("click", this.name, !this.opened)
        if (!this._disabled) {
            var parent: XCollapseComponentPublicInstance? = null
            try {
                parent = this.`$parent` as XCollapseComponentPublicInstance
            }
             catch (e: Throwable) {}
            if (parent != null) {
                parent.addChange(this.name)
            }
        }
    }
    open var getNodes = ::gen_getNodes_fn
    open fun gen_getNodes_fn() {
        var _this = this
        var ele = this.`$refs`["xCollapseItemContent"] as UniElement?
        if (ele == null) {
            return
        }
        ele.getBoundingClientRectAsync()?.then(fun(rect: DOMRect){
            _this.itemHeight = rect.height
            if (_this._isActive) {
                _this.open()
            } else {
                _this.close()
            }
        }
        )
    }
    open var open = ::gen_open_fn
    open fun gen_open_fn() {
        this.opened = true
    }
    open var close = ::gen_close_fn
    open fun gen_close_fn() {
        this.opened = false
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xCollapseItemBoxTextBox" to _pS(_uM("flex" to 1, "display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center")), "xCollapseItemBoxText" to _pS(_uM("textOverflow" to "ellipsis")), "xCollapseItemContent" to _pS(_uM("paddingTop" to 12, "paddingRight" to "0rpx", "paddingBottom" to 12, "paddingLeft" to "0rpx")), "xCollapseItemBoxLeft" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center", "flex" to 1)), "xCollapseItemBoxRight" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end", "alignItems" to "center")), "xCollapseItemBox" to _pS(_uM("paddingTop" to 0, "paddingRight" to 12, "paddingBottom" to 0, "paddingLeft" to 12)), "xCollapseItem" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "xCollapseItemWrap" to _pS(_uM("display" to "flex", "flexDirection" to "column", "transitionProperty" to "height", "transitionDuration" to "350ms", "transitionTimingFunction" to "cubic-bezier(0.18,0.89,0.32,1)", "overflow" to "hidden")), "@TRANSITION" to _uM("xCollapseItemWrap" to _uM("property" to "height", "duration" to "350ms", "timingFunction" to "cubic-bezier(0.18,0.89,0.32,1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM("xCollapseDefaultName" to _uM("type" to "Array", "default" to _uA<String>()))
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM("name" to _uM("type" to "String", "default" to "", "required" to true), "showBottomLine" to _uM("type" to "Boolean", "default" to true), "disabled" to _uM("type" to "Boolean", "default" to false), "titleFontSize" to _uM("type" to "String", "default" to "16px"), "titleColor" to _uM("type" to "String", "default" to "#333333"), "darkTitleColor" to _uM("type" to "String", "default" to ""), "activeColor" to _uM("type" to "String", "default" to ""), "color" to _uM("type" to "String", "default" to "white"), "darkColor" to _uM("type" to "String", "default" to ""), "leftIcon" to _uM("type" to "String", "default" to ""), "title" to _uM("type" to "String", "default" to ""), "titleHeight" to _uM("type" to "String", "default" to "55"), "titleLines" to _uM("type" to "Number", "default" to 1)))
        var propsNeedCastKeys = _uA(
            "name",
            "showBottomLine",
            "disabled",
            "titleFontSize",
            "titleColor",
            "darkTitleColor",
            "activeColor",
            "color",
            "darkColor",
            "leftIcon",
            "title",
            "titleHeight",
            "titleLines"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
