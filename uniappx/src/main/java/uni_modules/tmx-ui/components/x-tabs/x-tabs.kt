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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
open class GenUniModulesTmxUiComponentsXTabsXTabs : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.nowActiveId = this.modelValue
            this.`$nextTick`(fun(){
                this.setActiveId(this.nowActiveId)
            }
            )
            uni__on("onResize", this.resizechange)
        }
        , __ins)
        onBeforeUnmount(fun() {
            uni__off("onResize", this.resizechange)
            clearTimeout(this.tid)
            clearTimeout(this.tid2)
            clearTimeout(this.tid3)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newValue: String) {
            if (newValue == this.nowActiveId || newValue == "") {
                return
            }
            this.setActiveId(newValue)
        }
        )
        this.`$watch`(fun(): Any? {
            return this.list
        }
        , fun() {
            var t = this
            clearTimeout(this.tid3)
            this.tid3 = setTimeout(fun() {
                t.setActiveId(t.nowActiveId)
            }
            , 50)
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_badge = resolveEasyComponent("x-badge", GenUniModulesTmxUiComponentsXBadgeXBadgeClass)
        val _component_tabs_item = resolveComponent("tabs-item")
        return createElementVNode("view", utsMapOf("class" to "xTabs", "ref" to "xTabs", "style" to normalizeStyle(utsMapOf("width" to _ctx._width, "borderRadius" to _ctx._round, "height" to _ctx._height, "backgroundColor" to _ctx._color))), utsArrayOf(
            createElementVNode("scroll-view", utsMapOf("scroll-left" to _ctx.tabsItemLeft, "scroll-with-animation" to true, "class" to "xTabsWrap", "show-scrollbar" to false, "style" to normalizeStyle(utsMapOf("justifyContent" to if (_ctx.tabasItemCenter) {
                "center"
            } else {
                "flex-start"
            }
            )), "direction" to "horizontal"), utsArrayOf(
                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx._list, fun(item, index, __index, _cached): Any {
                    return createElementVNode("view", utsMapOf("class" to "xTabsItem", "ref_for" to true, "ref" to "xTabsItem", "id" to (_ctx.id + index), "key" to index, "style" to normalizeStyle(utsArrayOf(
                        utsMapOf("width" to _ctx._itemWidth, "height" to "100%", "opacity" to if (item.disabled) {
                            "0.6"
                        } else {
                            1
                        }
                        ),
                        if (_ctx.nowActiveId == item.id) {
                            _ctx._itemActiveStyle
                        } else {
                            _ctx._itemStyle
                        }
                    )), "onClick" to fun(){
                        _ctx.itemClick(item, (_ctx.id + index), index)
                    }
                    ), utsArrayOf(
                        createVNode(_component_tabs_item, utsMapOf("id" to (_ctx.id + index), "onChange" to _ctx.tabsItemChange, "onDestory" to _ctx.tabsItemDestory, "style" to normalizeStyle(utsMapOf("with" to "100%"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                if (item.dotType != "") {
                                    createVNode(_component_x_badge, utsMapOf("key" to 0, "bg-color" to item.dotColor, "dot" to (item.dotType == "dot"), "label" to item.dotText), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode("view", utsMapOf("key" to index, "style" to normalizeStyle(utsMapOf("paddingLeft" to _ctx.titlePadding, "paddingRight" to _ctx.titlePadding))), utsArrayOf(
                                                renderSlot(_ctx.`$slots`, "default", GenUniModulesTmxUiComponentsXTabsXTabsSlotDataDefault(item = item, active = (_ctx.nowActiveId == item.id)), fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        createElementVNode("text", utsMapOf("class" to "xTabsWrapText", "style" to normalizeStyle(utsArrayOf(
                                                            utsMapOf("fontSize" to if (_ctx.nowActiveId == item.id) {
                                                                _ctx._activeFontSize
                                                            } else {
                                                                _ctx._fontSize
                                                            }, "color" to if (_ctx.nowActiveId == item.id) {
                                                                _ctx._activeTitleColor
                                                            } else {
                                                                _ctx._titleColor
                                                            }),
                                                            if (_ctx.nowActiveId == item.id) {
                                                                _ctx._textActiveStyle
                                                            } else {
                                                                _ctx._textStyle
                                                            }
                                                        ))), toDisplayString(item.title), 5)
                                                    )
                                                })
                                            ), 4)
                                        )
                                    }), "_" to 2), 1032, utsArrayOf(
                                        "bg-color",
                                        "dot",
                                        "label"
                                    ))
                                } else {
                                    createElementVNode("view", utsMapOf("key" to 1), utsArrayOf(
                                        renderSlot(_ctx.`$slots`, "default", GenUniModulesTmxUiComponentsXTabsXTabsSlotDataDefault(item = item, active = (_ctx.nowActiveId == item.id)), fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createElementVNode("text", utsMapOf("class" to "xTabsWrapText", "style" to normalizeStyle(utsMapOf("fontSize" to if (_ctx.nowActiveId == item.id) {
                                                    _ctx._activeFontSize
                                                } else {
                                                    _ctx._fontSize
                                                }
                                                , "color" to if (_ctx.nowActiveId == item.id) {
                                                    _ctx._activeTitleColor
                                                } else {
                                                    _ctx._titleColor
                                                }
                                                , "paddingLeft" to _ctx.titlePadding, "paddingRight" to _ctx.titlePadding))), toDisplayString(item.title), 5)
                                            )
                                        }
                                        )
                                    ))
                                }
                            )
                        }
                        ), "_" to 2), 1032, utsArrayOf(
                            "id",
                            "onChange",
                            "onDestory",
                            "style"
                        ))
                    ), 12, utsArrayOf(
                        "id",
                        "onClick"
                    ))
                }
                ), 128),
                createElementVNode("view", utsMapOf("class" to "xLineWrap", "style" to normalizeStyle(utsMapOf("width" to (_ctx.totalWidth + "px"), "height" to _ctx._lineHeight))), utsArrayOf(
                    if (isTrue(_ctx._showLine && !_ctx.first)) {
                        createElementVNode("view", utsMapOf("key" to 0, "onTransitionend" to _ctx.lineTranslateEnd, "class" to "xLine", "ref" to "xLine", "style" to normalizeStyle(utsArrayOf(
                            utsMapOf("transform" to ("translateX(" + _ctx.lineLeft + "px)"), "height" to _ctx._lineHeight, "width" to (_ctx.activeLineWidth + "px"), "borderRadius" to _ctx._lineHeight),
                            _ctx._lineColor
                        ))), null, 44, utsArrayOf(
                            "onTransitionend"
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    }
                ), 4)
            ), 12, utsArrayOf(
                "scroll-left"
            ))
        ), 4)
    }
    open var round: String by `$props`
    open var width: String by `$props`
    open var height: String by `$props`
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var activeTitleColor: String by `$props`
    open var titleColor: String by `$props`
    open var darkTitleColor: String by `$props`
    open var lineColor: String by `$props`
    open var lineGradient: UTSArray<String> by `$props`
    open var lineHeight: String by `$props`
    open var lineFull: Boolean by `$props`
    open var showLine: Boolean by `$props`
    open var list: UTSArray<TABS_ITEM_INFO> by `$props`
    open var modelValue: String by `$props`
    open var fontSize: String by `$props`
    open var activeFontSize: String by `$props`
    open var itemWidth: String by `$props`
    open var titlePadding: String by `$props`
    open var isItemCenter: Boolean by `$props`
    open var itemActiveStyle: String by `$props`
    open var itemStyle: String by `$props`
    open var textActiveStyle: String by `$props`
    open var textStyle: String by `$props`
    open var nowActiveId: String by `$data`
    open var id: String by `$data`
    open var lineLeft: Number by `$data`
    open var lineWidth: Number by `$data`
    open var activeLineWidth: Number by `$data`
    open var totalWidth: Number by `$data`
    open var scrollNowPosId: String by `$data`
    open var first: Boolean by `$data`
    open var isQueryOk: Boolean by `$data`
    open var tid: Number by `$data`
    open var tid2: Number by `$data`
    open var tid3: Number by `$data`
    open var tabsList: Map<String, NodeInfo> by `$data`
    open var tabsItemLeft: Number by `$data`
    open var tabasItemCenter: Boolean by `$data`
    open var _itemActiveStyle: String by `$data`
    open var _itemStyle: String by `$data`
    open var _textActiveStyle: String by `$data`
    open var _textStyle: String by `$data`
    open var _showLine: Boolean by `$data`
    open var _lineFull: Boolean by `$data`
    open var _fontSize: String by `$data`
    open var _itemWidth: String by `$data`
    open var _round: String by `$data`
    open var _activeFontSize: String by `$data`
    open var _lineHeight: String by `$data`
    open var _height: String by `$data`
    open var _width: String by `$data`
    open var _color: String by `$data`
    open var _activeTitleColor: String by `$data`
    open var _titleColor: String by `$data`
    open var _lineColor: Map<String, String> by `$data`
    open var _list: UTSArray<TABS_ITEM> by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("nowActiveId" to "", "id" to ("xTabsItem-" + getUid() + "-") as String, "lineLeft" to 0, "lineWidth" to 18, "activeLineWidth" to 18, "totalWidth" to 0, "scrollNowPosId" to "", "first" to true, "isQueryOk" to false, "tid" to 0, "tid2" to 12, "tid3" to 133, "tabsList" to Map<String, NodeInfo>(), "tabsItemLeft" to 0, "tabasItemCenter" to false, "_itemActiveStyle" to computed<String>(fun(): String {
            return this.itemActiveStyle
        }
        ), "_itemStyle" to computed<String>(fun(): String {
            return this.itemStyle
        }
        ), "_textActiveStyle" to computed<String>(fun(): String {
            return this.textActiveStyle
        }
        ), "_textStyle" to computed<String>(fun(): String {
            return this.textStyle
        }
        ), "_showLine" to computed<Boolean>(fun(): Boolean {
            return this.showLine
        }
        ), "_lineFull" to computed<Boolean>(fun(): Boolean {
            return this.lineFull
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
        ), "_itemWidth" to computed<String>(fun(): String {
            return checkIsCssUnit(this.itemWidth, xConfig.unit)
        }
        ), "_round" to computed<String>(fun(): String {
            return checkIsCssUnit(this.round, xConfig.unit)
        }
        ), "_activeFontSize" to computed<String>(fun(): String {
            return checkIsCssUnit(this.activeFontSize, xConfig.unit)
        }
        ), "_lineHeight" to computed<String>(fun(): String {
            return checkIsCssUnit(this.lineHeight, xConfig.unit)
        }
        ), "_height" to computed<String>(fun(): String {
            return checkIsCssUnit(this.height, xConfig.unit)
        }
        ), "_width" to computed<String>(fun(): String {
            return checkIsCssUnit(this.width, xConfig.unit)
        }
        ), "_color" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                if (this.darkColor != "") {
                    return getDefaultColor(this.darkColor)
                } else {
                    return getDefaultColor(xConfig.sheetDarkColor)
                }
            }
            return getDefaultColor(this.color)
        }
        ), "_activeTitleColor" to computed<String>(fun(): String {
            if (this.activeTitleColor == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.activeTitleColor)
        }
        ), "_titleColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                if (this.darkTitleColor != "") {
                    return getDefaultColor(this.darkTitleColor)
                } else {
                    return "#ffffff"
                }
            }
            return getDefaultColor(this.titleColor)
        }
        ), "_lineColor" to computed<Map<String, String>>(fun(): Map<String, String> {
            var colorstyleline = Map<String, String>()
            if (this.lineGradient.length == 3) {
                var dirs = this.lineGradient[0]
                if (this.lineGradient[0] == "top") {
                    dirs = "to top"
                } else if (this.lineGradient[0] == "bottom") {
                    dirs = "to bottom"
                } else if (this.lineGradient[0] == "left") {
                    dirs = "to left"
                } else if (this.lineGradient[0] == "right") {
                    dirs = "to right"
                }
                colorstyleline.set("backgroundImage", "linear-gradient(" + dirs + "," + this.lineGradient[1] + "," + this.lineGradient[2] + ")")
                return colorstyleline
            }
            if (this.lineColor == "") {
                colorstyleline.set("background-color", this._activeTitleColor)
                return colorstyleline
            }
            colorstyleline.set("background-color", this.lineColor)
            return colorstyleline
        }
        ), "_list" to computed<UTSArray<TABS_ITEM>>(fun(): UTSArray<TABS_ITEM> {
            var lits = utsArrayOf<TABS_ITEM>()
            this.list.forEach(fun(el: TABS_ITEM_INFO, index: Number){
                lits.push(TABS_ITEM(id = if (el.id == null) {
                    index.toString(10)
                } else {
                    el.id!! as String
                }
                , title = el.title, disabled = if (el.disabled == null) {
                    false
                } else {
                    el.disabled!! as Boolean
                }
                , dotType = if (el.dotType == null) {
                    ""
                } else {
                    el.dotType!! as String
                }
                , dotColor = if (el.dotColor == null) {
                    "red"
                } else {
                    getDefaultColor(el.dotColor!!)
                }
                , dotText = if (el.dotText == null) {
                    ""
                } else {
                    el.dotText!! as String
                }
                ))
            }
            )
            return lits
        }
        ))
    }
    open var resizechange = ::gen_resizechange_fn
    open fun gen_resizechange_fn() {
        this.setActiveId(this.nowActiveId)
    }
    open var setActiveId = ::gen_setActiveId_fn
    open fun gen_setActiveId_fn(newValue: String) {
        if (this._list.length == 0) {
            return
        }
        var index: Number = -1
        run {
            var i: Number = 0
            while(i < this._list.length){
                if (this._list[i].id == newValue) {
                    index = i
                    break
                }
                i++
            }
        }
        index = Math.max(0, index)
        var newval = this._list[index].id
        this.nowActiveId = newval
        if (index > -1) {
            this.getNodeInfo(this.id + index.toString(10))
        }
    }
    open var getNodeInfo = ::gen_getNodeInfo_fn
    open fun gen_getNodeInfo_fn(id: String) {
        if (this._list.length == 0) {
            return
        }
        var _this = this
        uni_createSelectorQuery().`in`(this).select(".xTabs").boundingClientRect(fun(ret){
            var parentNodeinfo = ret as NodeInfo
            try {
                uni_createSelectorQuery().`in`(this).selectAll(".xTabsItem").boundingClientRect().exec(fun(ret){
                    var allItems = ret[0] as UTSArray<NodeInfo>
                    var totalWidth: Number = 0
                    var totalNowWidth: Number = 0
                    var isNow = false
                    var nowNndex: Number = 0
                    allItems.forEach(fun(el: NodeInfo, index: Number){
                        totalWidth += el.width!!
                        if (id == el.id) {
                            isNow = true
                            nowNndex = index
                        }
                        if (!isNow) {
                            totalNowWidth += el.width!!
                        }
                    }
                    )
                    var realTargetlinewidth = allItems[nowNndex].width!!
                    if (_this._lineFull) {
                        _this.activeLineWidth = allItems[nowNndex].width!!
                    } else {
                        _this.activeLineWidth = allItems[nowNndex].width!! / 2
                        realTargetlinewidth = _this.lineWidth
                    }
                    var parentWidth = parentNodeinfo.width!!
                    var center = parentWidth / 2
                    _this.tabasItemCenter = (totalWidth - parentWidth) <= 0 && _this.isItemCenter
                    _this.tabsItemLeft = totalNowWidth - parentWidth + center + allItems[nowNndex].width!! / 2
                    _this.first = false
                    var totalNowWidths = totalNowWidth + (allItems[nowNndex].width!! - _this.activeLineWidth) / 2
                    _this.totalWidth = totalWidth
                    if (!_this._lineFull) {
                        _this.activeLineWidth = realTargetlinewidth
                        var etotalNowWidth = totalNowWidth + (allItems[nowNndex].width!! - realTargetlinewidth) / 2
                        _this.lineLeft = etotalNowWidth
                    } else {
                        _this.lineLeft = totalNowWidths
                    }
                    var idnex = Math.max(0, nowNndex)
                    _this.scrollNowPosId = allItems[idnex].id!!
                }
                )
            }
             catch (e: Throwable) {
                console.error("xTabs:没有找到对应的index id，请检查你的数据。")
            }
        }
        ).exec()
    }
    open var lineTranslateEnd = ::gen_lineTranslateEnd_fn
    open fun gen_lineTranslateEnd_fn() {}
    open var itemClick = ::gen_itemClick_fn
    open fun gen_itemClick_fn(item: TABS_ITEM, classid: String, index: Number) {
        if (item.disabled || this.nowActiveId == item.id) {
            return
        }
        this.nowActiveId = item.id
        this.`$emit`("update:modelValue", item.id)
        this.`$emit`("change", item, index)
        this.getNodeInfo(classid)
    }
    open var tabsItemChange = ::gen_tabsItemChange_fn
    open fun gen_tabsItemChange_fn(recnode: NodeInfo, rectId: String) {
        this.tabsList.set(rectId, recnode)
        this.calcTotalWidth()
    }
    open var tabsItemDestory = ::gen_tabsItemDestory_fn
    open fun gen_tabsItemDestory_fn(id: String) {
        this.tabsList.`delete`(id)
        this.calcTotalWidth()
    }
    open var calcTotalWidth = ::gen_calcTotalWidth_fn
    open fun gen_calcTotalWidth_fn() {
        var totalWidth: Number = 0
        this.tabsList.forEach(fun(item: NodeInfo, id: String){
            totalWidth += item.width!!
        }
        )
        this.totalWidth = totalWidth
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xTabs" to padStyleMapOf(utsMapOf("overflow" to "hidden")), "xTabsItem" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "flexWrap" to "nowrap", "justifyContent" to "center", "alignItems" to "center")), "xLineWrap" to padStyleMapOf(utsMapOf("position" to "absolute", "bottom" to 0)), "xLine" to padStyleMapOf(utsMapOf("width" to 20, "position" to "relative", "left" to 0, "transitionDuration" to "300ms", "transitionProperty" to "transform,width", "transitionTimingFunction" to "cubic-bezier(0,0.55,0.45,1)")), "xTabsWrap" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100%", "display" to "flex", "flexDirection" to "row", "flexWrap" to "nowrap")), "xTabsWrapText" to padStyleMapOf(utsMapOf("whiteSpace" to "nowrap")), "@TRANSITION" to utsMapOf("xLine" to utsMapOf("duration" to "300ms", "property" to "transform,width", "timingFunction" to "cubic-bezier(0,0.55,0.45,1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("change" to null, "update:modelValue" to null)
        var props = normalizePropsOptions(utsMapOf("round" to utsMapOf("type" to "String", "default" to "0"), "width" to utsMapOf("type" to "String", "default" to "auto"), "height" to utsMapOf("type" to "String", "default" to "44"), "color" to utsMapOf("type" to "String", "default" to "white"), "darkColor" to utsMapOf("type" to "String", "default" to ""), "activeTitleColor" to utsMapOf("type" to "String", "default" to ""), "titleColor" to utsMapOf("type" to "String", "default" to "#888888"), "darkTitleColor" to utsMapOf("type" to "String", "default" to "#cacaca"), "lineColor" to utsMapOf("type" to "String", "default" to ""), "lineGradient" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf()
        }
        ), "lineHeight" to utsMapOf("type" to "String", "default" to "2px"), "lineFull" to utsMapOf("type" to "Boolean", "default" to false), "showLine" to utsMapOf("type" to "Boolean", "default" to true), "list" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<TABS_ITEM_INFO> {
            return utsArrayOf<TABS_ITEM_INFO>()
        }
        ), "modelValue" to utsMapOf("type" to "String", "default" to "0"), "fontSize" to utsMapOf("type" to "String", "default" to "16"), "activeFontSize" to utsMapOf("type" to "String", "default" to "16"), "itemWidth" to utsMapOf("type" to "String", "default" to "auto"), "titlePadding" to utsMapOf("type" to "String", "default" to "12px"), "isItemCenter" to utsMapOf("type" to "Boolean", "default" to false), "itemActiveStyle" to utsMapOf("type" to "String", "default" to ""), "itemStyle" to utsMapOf("type" to "String", "default" to ""), "textActiveStyle" to utsMapOf("type" to "String", "default" to ""), "textStyle" to utsMapOf("type" to "String", "default" to "")))
        var propsNeedCastKeys = utsArrayOf(
            "round",
            "width",
            "height",
            "color",
            "darkColor",
            "activeTitleColor",
            "titleColor",
            "darkTitleColor",
            "lineColor",
            "lineGradient",
            "lineHeight",
            "lineFull",
            "showLine",
            "list",
            "modelValue",
            "fontSize",
            "activeFontSize",
            "itemWidth",
            "titlePadding",
            "isItemCenter",
            "itemActiveStyle",
            "itemStyle",
            "textActiveStyle",
            "textStyle"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf("tabsItem" to GenUniModulesTmxUiComponentsXTabsTabsItemClass)
    }
}
