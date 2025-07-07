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
open class GenUniModulesTmxUiComponentsXPickerItemXPickerItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            var t = this
            this.pushDeepCount(this.parentIndex)
            t.setNowCurrentIndex(false)
        }
        , __ins)
        onBeforeUnmount(fun() {
            clearTimeout(this.tid)
            clearTimeout(this.tid2)
            clearTimeout(this.tid3)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.list
        }
        , fun() {
            var t = this
            t.setNowCurrentIndex(true)
        }
        )
        this.`$watch`(fun(): Any? {
            return this.selectedIndex
        }
        , fun(newvaluse: UTSArray<String>) {
            var t = this
            t.setNowCurrentIndex(false)
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
        val _component_picker_view_column = resolveComponent("picker-view-column")
        val _component_picker_view = resolveComponent("picker-view")
        val _component_x_picker_item = resolveEasyComponent("x-picker-item", GenUniModulesTmxUiComponentsXPickerItemXPickerItemClass)
        return createElementVNode("view", null, utsArrayOf(
            if (_ctx._unitsName != "") {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "xPickerViewUnit"), utsArrayOf(
                    createVNode(_component_x_text, utsMapOf("font-size" to _ctx.unitsFontSize, "class" to "xPickerViewUnitText"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            toDisplayString(_ctx._unitsName)
                        )
                    }), "_" to 1), 8, utsArrayOf(
                        "font-size"
                    ))
                ))
            } else {
                createCommentVNode("v-if", true)
            }
            ,
            createElementVNode("view", utsMapOf("class" to "xPickerView"), utsArrayOf(
                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("padding" to "0 2.5px"))), utsArrayOf(
                    createVNode(_component_picker_view, utsMapOf("value" to _ctx.nowCurrentIndex, "onChange" to _ctx.onChange, "style" to normalizeStyle(utsMapOf("height" to "250px", "width" to ((_ctx._wrapWight - 5) + "px"))), "mask-style" to ("" + _ctx._maskStyle), "mask-bottom-style" to _ctx._maskStyle, "mask-top-style" to _ctx._maskStyle, "indicator-class" to if (_ctx._isDark) {
                        "indicatorClassDark"
                    } else {
                        "indicatorClassLight"
                    }
                    , "indicator-style" to ("height:50px;backgroundColor:" + (if (_ctx._isDark) {
                        "rgba(255,255,255,0.05)"
                    } else {
                        "rgba(0,0,0,0.05)"
                    }
                    ) + ";border-radius:10px")), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createVNode(_component_picker_view_column, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx._list, fun(item, index, __index, _cached): Any {
                                        return createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("height" to "50px")), "key" to index, "class" to "xPickerViewWrapCoumn"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "xPickerViewWrapCoumnText", "style" to normalizeStyle(utsMapOf("fontSize" to _ctx._fontSize, "lineHeight" to 1.1, "fontWeight" to if (_ctx.nowCurrentIndex[0] == index) {
                                                "bold"
                                            } else {
                                                "inherit"
                                            }
                                            , "opacity" to if (item.disabled) {
                                                0.4
                                            } else {
                                                if (_ctx.nowCurrentIndex[0] == index) {
                                                    1
                                                } else {
                                                    0.6
                                                }
                                            }
                                            , "color" to if (_ctx._isDark) {
                                                "rgba(255,255,255,0.8)"
                                            } else {
                                                "#000000"
                                            }
                                            ))), toDisplayString(item.title), 5)
                                        ), 4)
                                    }
                                    ), 128)
                                )
                            }
                            ), "_" to 1))
                        )
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "value",
                        "onChange",
                        "style",
                        "mask-style",
                        "mask-bottom-style",
                        "mask-top-style",
                        "indicator-class",
                        "indicator-style"
                    ))
                ), 4),
                if (_ctx._nowChildren.length > 0) {
                    createVNode(_component_x_picker_item, utsMapOf("key" to 0, "onCountChange" to _ctx.pushDeepCount, "font-size" to _ctx.fontSize, "cellUnits" to _ctx._cellUnits, "onChangeDeep" to _ctx.change, "selectedIndex" to _ctx._selectedIndex, "wrapWight" to _ctx._wrapWight, "parentIndex" to (_ctx._parentIndex + 1), "list" to _ctx._nowChildren, "cell-height" to _ctx._cellHeight), null, 8, utsArrayOf(
                        "onCountChange",
                        "font-size",
                        "cellUnits",
                        "onChangeDeep",
                        "selectedIndex",
                        "wrapWight",
                        "parentIndex",
                        "list",
                        "cell-height"
                    ))
                } else {
                    createCommentVNode("v-if", true)
                }
            ))
        ))
    }
    open var cellHeight: String by `$props`
    open var duration: Number by `$props`
    open var list: UTSArray<X_PICKER_X_ITEM> by `$props`
    open var wrapWight: Number by `$props`
    open var parentIndex: Number by `$props`
    open var selectedIndex: UTSArray<Number> by `$props`
    open var cellUnits: UTSArray<String> by `$props`
    open var unitsFontSize: String by `$props`
    open var fontSize: String by `$props`
    open var boxHeight: Number by `$data`
    open var id: String by `$data`
    open var nowCurrentIndex: UTSArray<Number> by `$data`
    open var tid: Number by `$data`
    open var tid2: Number by `$data`
    open var tid3: Number by `$data`
    open var _fontSize: String by `$data`
    open var _parentIndex: Number by `$data`
    open var _cellHeight: String by `$data`
    open var _boxHeight: Number by `$data`
    open var _totalHeight: Number by `$data`
    open var _wrapWight: Number by `$data`
    open var _selectedIndex: UTSArray<Number> by `$data`
    open var _unitsName: String by `$data`
    open var _cellUnits: UTSArray<String> by `$data`
    open var dataList: UTSArray<X_PICKER_X_ITEM> by `$data`
    open var _list: UTSArray<X_PICKER_X_ITEM> by `$data`
    open var _nowChildren: UTSArray<X_PICKER_X_ITEM> by `$data`
    open var _isDark: Boolean by `$data`
    open var _maskStyle: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("boxHeight" to 0, "id" to ("xPickerItem-" + getUid()) as String, "nowCurrentIndex" to utsArrayOf(
            0
        ), "tid" to 0, "tid2" to 0, "tid3" to 3, "_fontSize" to computed<String>(fun(): String {
            var fontSize = checkIsCssUnit(this.fontSize, xConfig.unit)
            if (xConfig.fontScale == 1) {
                return fontSize
            }
            var sizeNumber = parseInt(fontSize)
            if (isNaN(sizeNumber)) {
                sizeNumber = 16
            }
            return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(this.fontSize)
        }
        ), "_parentIndex" to computed<Number>(fun(): Number {
            return this.parentIndex
        }
        ), "_cellHeight" to computed<String>(fun(): String {
            return checkIsCssUnit(this.cellHeight, xConfig.unit)
        }
        ), "_boxHeight" to computed<Number>(fun(): Number {
            var p = parseInt(this.cellHeight)
            if (this.cellHeight.lastIndexOf("rpx") > -1) {
                p = rpx2px(p)
            }
            return p
        }
        ), "_totalHeight" to computed<Number>(fun(): Number {
            return (Math.max(1, this._list.length) + 4) * this._boxHeight
        }
        ), "_wrapWight" to computed<Number>(fun(): Number {
            return this.wrapWight
        }
        ), "_selectedIndex" to computed<UTSArray<Number>>(fun(): UTSArray<Number> {
            return this.selectedIndex
        }
        ), "_unitsName" to computed<String>(fun(): String {
            if (this.cellUnits.length == 0) {
                return ""
            }
            if (this.cellUnits.length < this._parentIndex) {
                return ""
            }
            return this.cellUnits[this._parentIndex]!! as String
        }
        ), "_cellUnits" to computed<UTSArray<String>>(fun(): UTSArray<String> {
            return this.cellUnits as UTSArray<String>
        }
        ), "dataList" to computed<UTSArray<X_PICKER_X_ITEM>>(fun(): UTSArray<X_PICKER_X_ITEM> {
            return this.list.slice(0)
        }
        ), "_list" to computed<UTSArray<X_PICKER_X_ITEM>>(fun(): UTSArray<X_PICKER_X_ITEM> {
            return this.list.slice(0)
        }
        ), "_nowChildren" to computed<UTSArray<X_PICKER_X_ITEM>>(fun(): UTSArray<X_PICKER_X_ITEM> {
            var index = Math.max(0, Math.min(this.nowCurrentIndex[0], this._list.length - 1))
            if (this._list.length == 0 && index > this._list.length - 1) {
                return utsArrayOf<X_PICKER_X_ITEM>()
            }
            var item = this._list[index]
            return item.children
        }
        ), "_isDark" to computed<Boolean>(fun(): Boolean {
            return xConfig.dark == "dark"
        }
        ), "_maskStyle" to computed<String>(fun(): String {
            if (this._isDark) {
                return "background-image:linear-gradient(180deg,rgba(0, 0, 0, 0),rgba(0, 0, 0, 0)),linear-gradient(0deg, rgba(0, 0, 0, 0),rgba(0, 0, 0, 0))"
            }
            return "background-image:linear-gradient(180deg,rgba(255,255,255,0),rgba(255,255,255,0)),linear-gradient(0deg, rgba(255,255,255,0),rgba(255,255,255,0))"
        }
        ))
    }
    open var setNowCurrentIndex = ::gen_setNowCurrentIndex_fn
    open fun gen_setNowCurrentIndex_fn(isTmChange: Boolean) {
        var t = this
        clearTimeout(this.tid3)
        t.nowCurrentIndex = utsArrayOf<Number>(t.getIndexByid())
        if (isTmChange) {
            t.mchange(t.nowCurrentIndex)
        }
    }
    open var getIndexByid = ::gen_getIndexByid_fn
    open fun gen_getIndexByid_fn(): Number {
        var index: Number = 0
        if (this._selectedIndex.length == 0) {
            return index
        }
        if (this.parentIndex > this._selectedIndex.length) {
            return index
        }
        index = this._selectedIndex[this.parentIndex]
        index = Math.max(0, Math.min(index, this._list.length - 1))
        return index
    }
    open var getIdByindex = ::gen_getIdByindex_fn
    open fun gen_getIdByindex_fn(): String? {
        var id = null
        if (this._list.length == 0) {
            return id
        }
        if (this.nowCurrentIndex.length == 0) {
            return id
        }
        var index = Math.max(0, Math.min(this.nowCurrentIndex[0], this._list.length - 1))
        return this._list[index].id
    }
    open var mchange = ::gen_mchange_fn
    open fun gen_mchange_fn(indexs: UTSArray<Number>) {
        var index = indexs[0]
        var parentIndex = this.parentIndex
        var ids = this._selectedIndex.slice(0)
        if (parentIndex <= ids.length - 1) {
            ids.splice(parentIndex, 1, index)
        } else {
            run {
                var i: Number = 0
                while(i < this.parentIndex){
                    ids.push(0)
                    i++
                }
            }
            ids.push(index)
        }
        this.`$emit`("changeDeep", ids)
    }
    open var change = ::gen_change_fn
    open fun gen_change_fn(s: UTSArray<Number>) {
        this.`$emit`("changeDeep", s)
    }
    open var pushDeepCount = ::gen_pushDeepCount_fn
    open fun gen_pushDeepCount_fn(n: Number) {
        this.`$emit`("countChange", n)
    }
    open var onChange = ::gen_onChange_fn
    open fun gen_onChange_fn(event: UniPickerViewChangeEvent) {
        if (event.detail.value.length == 0 || this._list.length == 0) {
            return
        }
        var indexs = event.detail.value!!
        if (indexs.join("") == this.nowCurrentIndex.join("")) {
            return
        }
        var index = indexs[0]
        index = Math.max(0, Math.min(index, this._list.length - 1))
        var item = this._list[index]
        if (item.disabled) {
            index = if (this.nowCurrentIndex[0] > index) {
                index + 1
            } else {
                index - 1
            }
            index = Math.max(this._list.length, index)
            index = Math.min(0, index)
            indexs = utsArrayOf(
                index
            )
        }
        this.nowCurrentIndex = indexs
        this.mchange(indexs)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xPickerViewUnit" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "paddingTop" to 8, "paddingRight" to 8, "paddingBottom" to 8, "paddingLeft" to 8)), "xPickerViewUnitText" to padStyleMapOf(utsMapOf("fontSize" to 12, "color" to "#888888", "fontWeight" to "bold")), "xPickerViewWrapCoumnText" to padStyleMapOf(utsMapOf("marginTop" to 0, "marginRight" to 6, "marginBottom" to 0, "marginLeft" to 6, "width" to "100%", "textAlign" to "center")), "xPickerView" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row")), "xPickerViewWrap" to padStyleMapOf(utsMapOf("position" to "relative")), "xPickerContent" to padStyleMapOf(utsMapOf("position" to "absolute", "left" to 0, "top" to 0, "width" to "100%", "zIndex" to 5, "transitionDuration" to "350ms", "transitionProperty" to "left,right,top,bottom", "transitionTimingFunction" to "cubic-bezier(0,0.55,0.45,1)")), "xPickerMasker" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "pointerEvents" to "none", "height" to "100%", "width" to "100%", "top" to 0, "left" to 0, "position" to "absolute")), "xPickErBar" to padStyleMapOf(utsMapOf("backgroundColor" to "#f5f5f5", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "marginTop" to 0, "marginRight" to 3, "marginBottom" to 0, "marginLeft" to 3, "flex" to 1)), "xPickerViewWrapCoumn" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center")), "@TRANSITION" to utsMapOf("xPickerContent" to utsMapOf("duration" to "350ms", "property" to "left,right,top,bottom", "timingFunction" to "cubic-bezier(0,0.55,0.45,1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("changeDeep" to null, "countChange" to null)
        var props = normalizePropsOptions(utsMapOf("cellHeight" to utsMapOf("type" to "String", "default" to "60"), "duration" to utsMapOf("type" to "Number", "default" to 350), "list" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<X_PICKER_X_ITEM> {
            return utsArrayOf<X_PICKER_X_ITEM>()
        }
        ), "wrapWight" to utsMapOf("type" to "Number", "default" to 0), "parentIndex" to utsMapOf("type" to "Number", "default" to 0), "selectedIndex" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<Number> {
            return utsArrayOf<Number>()
        }
        ), "cellUnits" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "unitsFontSize" to utsMapOf("type" to "String", "default" to "12"), "fontSize" to utsMapOf("type" to "String", "default" to "15")))
        var propsNeedCastKeys = utsArrayOf(
            "cellHeight",
            "duration",
            "list",
            "wrapWight",
            "parentIndex",
            "selectedIndex",
            "cellUnits",
            "unitsFontSize",
            "fontSize"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
