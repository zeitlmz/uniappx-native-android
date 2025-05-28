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
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenUniModulesTmxUiComponentsXPickerSelectedXPickerSelected : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.nowValue = this.idsToxPickerSelectedListyTypeAr(this.modelValue)
            this.updateModelStr()
            this.yanchiDuration = if (this._lazyContent) {
                false
            } else {
                true
            }
            var t = this
            t.isRefresh = this.refresh
            if (t.isRefresh) {
                t.`$emit`("refresh")
            }
        }
        , __ins)
        onBeforeUnmount(fun() {
            clearTimeout(this.tid)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newvalue: UTSArray<Any>) {
            if (newvalue.join("") == this.nowValue.join("")) {
                return
            }
            this.nowValue = this.idsToxPickerSelectedListyTypeAr(this.modelValue)
            this.updateModelStr()
        }
        )
        this.`$watch`(fun(): Any? {
            return this._list
        }
        , fun() {
            this.nowValue = this.idsToxPickerSelectedListyTypeAr(this.modelValue)
            this.updateModelStr()
        }
        )
        this.`$watch`(fun(): Any? {
            return this.modelShow
        }
        , fun(newValue: Boolean) {
            if (newValue == this.show) {
                return
            }
            this.show = newValue
        }
        )
        this.`$watch`(fun(): Any? {
            return this.refresh
        }
        , fun(newValue: Boolean) {
            this.isRefresh = newValue
        }
        )
        this.`$watch`(fun(): Any? {
            return this.bottomRefresh
        }
        , fun(newValue: Boolean) {
            this.isBootomIsRefresh = newValue
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass)
        val _component_x_loading = resolveEasyComponent("x-loading", GenUniModulesTmxUiComponentsXLoadingXLoadingClass)
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
        val _component_x_pull_refresh = resolveEasyComponent("x-pull-refresh", GenUniModulesTmxUiComponentsXPullRefreshXPullRefreshClass)
        val _component_x_empty = resolveEasyComponent("x-empty", GenUniModulesTmxUiComponentsXEmptyXEmptyClass)
        val _component_x_drawer = resolveEasyComponent("x-drawer", GenUniModulesTmxUiComponentsXDrawerXDrawerClass)
        return createElementVNode("view", null, utsArrayOf(
            createElementVNode("view", utsMapOf("onClick" to _ctx.openShow), utsArrayOf(
                renderSlot(_ctx.`$slots`, "default")
            ), 8, utsArrayOf(
                "onClick"
            )),
            createVNode(_component_x_drawer, utsMapOf("cancel-text" to _ctx.cancelText, "confirm-text" to _ctx.confirmText, "zIndex" to _ctx.zIndex, "onOpen" to _ctx.onOpen, "widthCoverCenter" to true, "watiDuration" to _ctx.duration, "contentMargin" to "0px", "disabledScroll" to true, "title" to _ctx.title, "onClose" to _ctx.onClose, "onConfirm" to _ctx.onConfirm, "onCancel" to _ctx.onCancel, "showFooter" to true, "show" to _ctx.show, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.show = `$event`
            }
            , "show-close" to _ctx.showClose, "size" to "80%"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "xPickerSlectedIwrap"), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "xPickerSlectedInputBox", "style" to normalizeStyle(utsMapOf("backgroundColor" to _ctx._inputBgColor))), utsArrayOf(
                            createElementVNode("input", utsMapOf("placeholder" to "请输入关键词", "style" to normalizeStyle(utsMapOf("color" to _ctx._inputColor)), "onInput" to _ctx.inpuEvent, "onConfirm" to _ctx.inputConfirm, "value" to _ctx.searchKey, "class" to "xPickerSlectedInput"), null, 44, utsArrayOf(
                                "onInput",
                                "onConfirm",
                                "value"
                            )),
                            if (_ctx.searchKey.length > 0) {
                                createElementVNode("view", utsMapOf("key" to 0, "onClick" to _ctx.clearSearchKey, "class" to "clearClick"), utsArrayOf(
                                    createVNode(_component_x_icon, utsMapOf("font-size" to "24", "name" to "close-circle-fill", "color" to "#d1d1d1"))
                                ), 8, utsArrayOf(
                                    "onClick"
                                ))
                            } else {
                                createCommentVNode("v-if", true)
                            }
                        ), 4),
                        createVNode(_component_x_button, utsMapOf("width" to "80", "onClick" to _ctx.inputConfirm, "color" to _ctx._color, "height" to "44", "round" to "0"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                "搜索"
                            )
                        }
                        ), "_" to 1), 8, utsArrayOf(
                            "onClick",
                            "color"
                        ))
                    )),
                    createElementVNode("view", utsMapOf("class" to "xPickerSlectedWrap"), utsArrayOf(
                        if (isTrue(!_ctx.yanchiDuration)) {
                            createVNode(_component_x_loading, utsMapOf("key" to 0))
                        } else {
                            createCommentVNode("v-if", true)
                        }
                        ,
                        if (isTrue(_ctx._list.length > 0 && _ctx.yanchiDuration)) {
                            createElementVNode("view", utsMapOf("key" to 1, "style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
                                if (isTrue(_ctx._list.length > 0 && _ctx.yanchiDuration)) {
                                    createVNode(_component_x_pull_refresh, utsMapOf("key" to 0, "disabled-bottom" to _ctx._disabledBottom, "disabled-pull" to _ctx._disabledPull, "onRefresh" to _ctx.loadRefres, "onBottomRefresh" to _ctx.bottomLoadRefres, "modelValue" to _ctx.isRefresh, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                        _ctx.isRefresh = `$event`
                                    }, "model-bottom-status" to _ctx.isBootomIsRefresh, "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                        _ctx.isBootomIsRefresh = `$event`
                                    }, "mode" to "listview", "height" to "100%"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx._renderListData, fun(item, index, __index, _cached): Any {
                                                return createElementVNode("list-item", utsMapOf("onClick" to fun(){
                                                    _ctx.onclik(item)
                                                }, "type" to index, "key" to index, "class" to normalizeClass(utsArrayOf(
                                                    "xPickerSlectedItem",
                                                    utsArrayOf(
                                                        if (_ctx.isSelected(item)) {
                                                            "xPickerSlectedWrapOn"
                                                        } else {
                                                            ""
                                                        }
                                                    )
                                                )), "style" to normalizeStyle(utsMapOf("height" to _ctx._itemHeight))), utsArrayOf(
                                                    createElementVNode("view", utsMapOf("class" to "xPickerSlectedItemWrap", "style" to normalizeStyle(utsMapOf("border-bottom" to ("1px solid " + _ctx._borderColor), "margin" to "0 16px"))), utsArrayOf(
                                                        createElementVNode("view", utsMapOf("class" to "xPickerSlectedItemText"), utsArrayOf(
                                                            renderSlot(_ctx.`$slots`, "item", GenUniModulesTmxUiComponentsXPickerSelectedXPickerSelectedSlotDataItem(item = item.item), fun(): UTSArray<Any> {
                                                                return utsArrayOf(
                                                                    createVNode(_component_x_text, utsMapOf("color" to if (_ctx.isSelected(item)) {
                                                                        _ctx._color
                                                                    } else {
                                                                        if (_ctx._isDark) {
                                                                            "white"
                                                                        } else {
                                                                            "#888"
                                                                        }
                                                                    }, "font-size" to "16", "line-height" to "1.2", "lines" to 2), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                        return utsArrayOf(
                                                                            toDisplayString(item.title)
                                                                        )
                                                                    }), "_" to 2), 1032, utsArrayOf(
                                                                        "color"
                                                                    ))
                                                                )
                                                            })
                                                        )),
                                                        createVNode(_component_x_icon, utsMapOf("color" to if (_ctx.isSelected(item)) {
                                                            _ctx._color
                                                        } else {
                                                            "#e6e6e6"
                                                        }, "font-size" to "28", "name" to if (_ctx.isSelected(item)) {
                                                            "checkbox-circle-fill"
                                                        } else {
                                                            "checkbox-blank-circle-line"
                                                        }), null, 8, utsArrayOf(
                                                            "color",
                                                            "name"
                                                        ))
                                                    ), 4)
                                                ), 14, utsArrayOf(
                                                    "onClick",
                                                    "type"
                                                ))
                                            }), 128)
                                        )
                                    }), "_" to 3), 8, utsArrayOf(
                                        "disabled-bottom",
                                        "disabled-pull",
                                        "onRefresh",
                                        "onBottomRefresh",
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "model-bottom-status",
                                        "onUpdate:modelBottomStatus"
                                    ))
                                } else {
                                    createCommentVNode("v-if", true)
                                }
                            ), 4)
                        } else {
                            createCommentVNode("v-if", true)
                        }
                        ,
                        if (isTrue(_ctx._list.length > 0 && _ctx.yanchiDuration)) {
                            createElementVNode("view", utsMapOf("key" to 2, "class" to "xPickerSlectedFooter"), utsArrayOf(
                                createVNode(_component_x_text, utsMapOf("class" to "xPickerSlectedFooterBtnText", "style" to normalizeStyle(utsMapOf("text-align" to "center")), "color" to _ctx._color, "font-size" to "14"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        " 已选择" + toDisplayString(_ctx.nowValue.length) + "项 "
                                    )
                                }), "_" to 1), 8, utsArrayOf(
                                    "style",
                                    "color"
                                )),
                                createElementVNode("view", utsMapOf("class" to "xPickerSlectedFooterBtn"), utsArrayOf(
                                    if (isTrue(!_ctx._isRadioMode)) {
                                        createVNode(_component_x_text, utsMapOf("key" to 0, "class" to "xPickerSlectedFooterBtnText", "onClick" to _ctx.clearAll, "color" to "#666", "font-size" to "14"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                " 清空选择 "
                                            )
                                        }), "_" to 1), 8, utsArrayOf(
                                            "onClick"
                                        ))
                                    } else {
                                        createCommentVNode("v-if", true)
                                    },
                                    if (isTrue(_ctx._isRadioMode)) {
                                        createVNode(_component_x_text, utsMapOf("key" to 1, "class" to "xPickerSlectedFooterBtnText", "color" to "#666", "font-size" to "14"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                " 当前为单选模式 "
                                            )
                                        }), "_" to 1))
                                    } else {
                                        createCommentVNode("v-if", true)
                                    },
                                    if (isTrue(_ctx.multiple)) {
                                        createVNode(_component_x_text, utsMapOf("key" to 2, "style" to normalizeStyle(utsMapOf("margin-left" to "24px")), "class" to "xPickerSlectedFooterBtnText", "onClick" to _ctx.selectedAll, "color" to _ctx._color, "font-size" to "14"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                " 选择所有 "
                                            )
                                        }), "_" to 1), 8, utsArrayOf(
                                            "style",
                                            "onClick",
                                            "color"
                                        ))
                                    } else {
                                        createCommentVNode("v-if", true)
                                    }
                                ))
                            ))
                        } else {
                            createCommentVNode("v-if", true)
                        }
                        ,
                        if (_ctx._list.length == 0) {
                            createVNode(_component_x_empty, utsMapOf("key" to 3, "show-btn" to false, "loading" to false, "empty" to true))
                        } else {
                            createCommentVNode("v-if", true)
                        }
                    ))
                )
            }
            ), "_" to 3), 8, utsArrayOf(
                "cancel-text",
                "confirm-text",
                "zIndex",
                "onOpen",
                "watiDuration",
                "title",
                "onClose",
                "onConfirm",
                "onCancel",
                "show",
                "onUpdate:show",
                "show-close"
            ))
        ))
    }
    open var modelValue: UTSArray<Any> by `$props`
    open var modelShow: Boolean by `$props`
    open var modelStr: UTSArray<String> by `$props`
    open var title: String by `$props`
    open var cancelText: String by `$props`
    open var confirmText: String by `$props`
    open var filterKey: String by `$props`
    open var labelKey: String by `$props`
    open var idKey: String by `$props`
    open var list: UTSArray<UTSJSONObject> by `$props`
    open var localSearch: Boolean by `$props`
    open var multiple: Boolean by `$props`
    open var isRadioMode: Boolean by `$props`
    open var lazyContent: Boolean by `$props`
    open var lazyDuration: Number by `$props`
    open var itemHeight: String by `$props`
    open var zIndex: Number by `$props`
    open var showClose: Boolean by `$props`
    open var refresh: Boolean
        @JvmName("getRefresh0")
        get() {
            return this.`$props`["refresh"] as Boolean
        }
        @JvmName("setRefresh0")
        set(value) {
            this.`$props`["refresh"] = value
        }
    open var bottomRefresh: Boolean by `$props`
    open var disabledPull: Boolean by `$props`
    open var disabledBottom: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var show: Boolean by `$data`
    open var nowValue: UTSArray<xPickerSelectedListyType> by `$data`
    open var searchList: UTSArray<xPickerSelectedListyType> by `$data`
    open var searchKey: String by `$data`
    open var duration: Number by `$data`
    open var yanchiDuration: Boolean by `$data`
    open var tid: Number by `$data`
    open var isRefresh: Boolean
        @JvmName("getIsRefresh1")
        get() {
            return this.`$data`["isRefresh"] as Boolean
        }
        @JvmName("setIsRefresh1")
        set(value) {
            this.`$data`["isRefresh"] = value
        }
    open var isBootomIsRefresh: Boolean by `$data`
    open var _disabled: Boolean by `$data`
    open var _isRadioMode: Boolean by `$data`
    open var _disabledPull: Boolean by `$data`
    open var _disabledBottom: Boolean by `$data`
    open var _itemHeight: String by `$data`
    open var _lazyContent: Boolean by `$data`
    open var _renderListData: UTSArray<xPickerSelectedListyType> by `$data`
    open var _list: UTSArray<xPickerSelectedListyType> by `$data`
    open var _color: String by `$data`
    open var _isDark: Boolean by `$data`
    open var _borderColor: String by `$data`
    open var _inputBgColor: String by `$data`
    open var _inputColor: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("show" to false, "nowValue" to utsArrayOf<xPickerSelectedListyType>(), "searchList" to utsArrayOf<xPickerSelectedListyType>(), "searchKey" to "", "duration" to 60, "yanchiDuration" to false, "tid" to 100, "isRefresh" to false, "isBootomIsRefresh" to false, "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ), "_isRadioMode" to computed<Boolean>(fun(): Boolean {
            return this.isRadioMode
        }
        ), "_disabledPull" to computed<Boolean>(fun(): Boolean {
            return this.disabledPull
        }
        ), "_disabledBottom" to computed<Boolean>(fun(): Boolean {
            return this.disabledBottom
        }
        ), "_itemHeight" to computed<String>(fun(): String {
            return checkIsCssUnit(this.itemHeight, xConfig.unit)
        }
        ), "_lazyContent" to computed<Boolean>(fun(): Boolean {
            return this.lazyContent
        }
        ), "_renderListData" to computed<UTSArray<xPickerSelectedListyType>>(fun(): UTSArray<xPickerSelectedListyType> {
            if (this.searchList.length > 0 && this.localSearch) {
                return this.searchList
            }
            return this._list
        }
        ), "_list" to computed<UTSArray<xPickerSelectedListyType>>(fun(): UTSArray<xPickerSelectedListyType> {
            return this.list!!.map(fun(el: UTSJSONObject): xPickerSelectedListyType {
                return xPickerSelectedListyType(id = el.getAny(this.idKey)!!, title = el.getString(this.labelKey)!!, item = el)
            }
            )
        }
        ), "_color" to computed<String>(fun(): String {
            return getDefaultColor(xConfig.color)
        }
        ), "_isDark" to computed<Boolean>(fun(): Boolean {
            return xConfig.dark == "dark"
        }
        ), "_borderColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                return xConfig.borderDarkColor
            }
            return "#f5f5f5"
        }
        ), "_inputBgColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                return xConfig.inputDarkColor
            }
            return "#f5f5f5"
        }
        ), "_inputColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                return "#fff"
            }
            return "#333"
        }
        ))
    }
    open var updateModelStr = ::gen_updateModelStr_fn
    open fun gen_updateModelStr_fn() {
        var strs = this.nowValue.map(fun(el): String {
            return el.title
        }
        )
        this.`$emit`("update:modelStr", strs)
    }
    open var onclik = ::gen_onclik_fn
    open fun gen_onclik_fn(item: xPickerSelectedListyType) {
        if (!this.multiple) {
            var index = this.nowValue.findIndex(fun(el): Boolean {
                return el.id == item.id
            })
            if (this._isRadioMode) {
                this.nowValue = (utsArrayOf<xPickerSelectedListyType>(item))
            } else {
                this.nowValue = if (index > -1) {
                    (utsArrayOf<xPickerSelectedListyType>())
                } else {
                    (utsArrayOf<xPickerSelectedListyType>(item))
                }
            }
        } else {
            var index = this.nowValue.findIndex(fun(el): Boolean {
                return el.id == item.id
            }
            )
            if (index > -1) {
                this.nowValue.splice(index, 1)
            } else {
                this.nowValue.push(item)
            }
        }
    }
    open var isSelected = ::gen_isSelected_fn
    open fun gen_isSelected_fn(item: xPickerSelectedListyType): Boolean {
        var index = this.nowValue.findIndex(fun(el): Boolean {
            return el.id == item.id
        }
        )
        return index > -1
    }
    open var inpuEvent = ::gen_inpuEvent_fn
    open fun gen_inpuEvent_fn(evt: UniInputEvent) {
        this.searchKey = evt.detail.value
        if (this.searchKey.trim() == "") {
            this.inputConfirm()
        }
    }
    open var clearSearchKey = ::gen_clearSearchKey_fn
    open fun gen_clearSearchKey_fn() {
        this.searchKey = ""
        this.inputConfirm()
    }
    open var inputConfirm = ::gen_inputConfirm_fn
    open fun gen_inputConfirm_fn() {
        if (this.localSearch) {
            this.searchList = utsArrayOf<xPickerSelectedListyType>()
            var t = this
            var templist = this._list.filter(fun(el): Boolean {
                return el.title.indexOf(t.searchKey.trim()) > -1
            }
            )
            this.searchList = templist.slice(0)
            if (this.searchList.length == 0) {
                uni_showToast(ShowToastOptions(title = "没有结果", icon = "none"))
            }
            return
        }
        this.`$emit`("search", this.searchKey.trim())
    }
    open var openShow = ::gen_openShow_fn
    open fun gen_openShow_fn() {
        if (this._disabled) {
            return
        }
        this.show = true
        this.`$emit`("update:modelShow", true)
        this.`$emit`("open")
    }
    open var onClose = ::gen_onClose_fn
    open fun gen_onClose_fn() {
        this.`$emit`("update:modelShow", false)
        if (this._lazyContent) {
            this.yanchiDuration = false
        }
    }
    open var onOpen = ::gen_onOpen_fn
    open fun gen_onOpen_fn() {
        var t = this
        this.tid = setTimeout(fun() {
            t.yanchiDuration = true
        }
        , this.lazyDuration)
    }
    open var onCancel = ::gen_onCancel_fn
    open fun gen_onCancel_fn() {
        this.`$emit`("cancel")
        this.nowValue = this.idsToxPickerSelectedListyTypeAr(this.modelValue)
        this.updateModelStr()
    }
    open var idsToxPickerSelectedListyTypeAr = ::gen_idsToxPickerSelectedListyTypeAr_fn
    open fun gen_idsToxPickerSelectedListyTypeAr_fn(ids: UTSArray<Any>): UTSArray<xPickerSelectedListyType> {
        if (this.list.length == 0) {
            return utsArrayOf<xPickerSelectedListyType>()
        }
        var fts = this.list!!.filter(fun(el: UTSJSONObject): Boolean {
            return ids.includes(el.getAny(this.idKey)!!)
        }
        ) as UTSArray<UTSJSONObject>
        var templist = fts!!.map(fun(el: UTSJSONObject): xPickerSelectedListyType {
            return xPickerSelectedListyType(id = el.getAny(this.idKey)!!, title = el.getString(this.labelKey)!!, item = el)
        }
        )
        return templist.slice(0)
    }
    open var onConfirm = ::gen_onConfirm_fn
    open fun gen_onConfirm_fn() {
        var ids = this.nowValue.map(fun(el): Any {
            return el.id
        }
        )
        var fts = this.nowValue!!.filter(fun(el: xPickerSelectedListyType): Boolean {
            return ids.includes(el.id)
        }
        )
        var strs = fts.map(fun(el: xPickerSelectedListyType): String {
            return el.title
        }
        )
        this.`$emit`("confirm", ids, strs)
        this.`$emit`("update:modelValue", ids)
        this.updateModelStr()
    }
    open var clearAll = ::gen_clearAll_fn
    open fun gen_clearAll_fn() {
        this.nowValue = utsArrayOf<xPickerSelectedListyType>()
        console.log(this.nowValue)
    }
    open var selectedAll = ::gen_selectedAll_fn
    open fun gen_selectedAll_fn() {
        var temp = this._list.slice(0)
        if (this._list.length > 0) {
            if (this.multiple) {
                this.nowValue = temp
            } else {
                this.nowValue = utsArrayOf<xPickerSelectedListyType>(temp[0])
            }
        }
    }
    open var loadRefres = ::gen_loadRefres_fn
    open fun gen_loadRefres_fn() {
        this.`$emit`("update:refresh", true)
        this.`$emit`("refresh")
    }
    open var bottomLoadRefres = ::gen_bottomLoadRefres_fn
    open fun gen_bottomLoadRefres_fn() {
        this.`$emit`("update:bottomRefresh", true)
        this.`$emit`("bottomRefresh")
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xPickerSlectedFooterBtn" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end")), "xPickerSlectedFooter" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to 12, "paddingRight" to 16, "paddingBottom" to 12, "paddingLeft" to 16)), "xPickerSlectedInputBox" to padStyleMapOf(utsMapOf("height" to "100%", "flex" to 1, "position" to "relative", "display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end")), "clearClick" to padStyleMapOf(utsMapOf("paddingTop" to 0, "paddingRight" to 16, "paddingBottom" to 0, "paddingLeft" to 16, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "flexDirection" to "row")), "xPickerSlectedIwrap" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "height" to 44, "borderTopLeftRadius" to 44, "borderTopRightRadius" to 44, "borderBottomRightRadius" to 44, "borderBottomLeftRadius" to 44, "marginTop" to 0, "marginRight" to 16, "marginBottom" to 16, "marginLeft" to 16)), "xPickerSlectedInput" to padStyleMapOf(utsMapOf("height" to "100%", "flex" to 1, "paddingTop" to 0, "paddingRight" to 16, "paddingBottom" to 0, "paddingLeft" to 16)), "xPickerSlectedItemWrap" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center", "height" to "100%")), "xPickerSlectedItemText" to padStyleMapOf(utsMapOf("flex" to 1)), "xPickerSlectedWrap" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "flex" to 1)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("bottomRefresh" to null, "refresh" to null, "search" to null, "confirm" to null, "cancel" to null, "open" to null, "update:modelShow" to null, "update:modelStr" to null, "update:bottomRefresh" to null, "update:refresh" to null, "update:modelValue" to null)
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<Any> {
            return utsArrayOf<Any>()
        }
        ), "modelShow" to utsMapOf("type" to "Boolean", "default" to false), "modelStr" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "title" to utsMapOf("type" to "String", "default" to "请选择"), "cancelText" to utsMapOf("type" to "String", "default" to "取消"), "confirmText" to utsMapOf("type" to "String", "default" to "确认"), "filterKey" to utsMapOf("type" to "String", "default" to "text"), "labelKey" to utsMapOf("type" to "String", "default" to "text"), "idKey" to utsMapOf("type" to "String", "default" to "id"), "list" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<UTSJSONObject> {
            return utsArrayOf<UTSJSONObject>()
        }
        ), "localSearch" to utsMapOf("type" to "Boolean", "default" to true), "multiple" to utsMapOf("type" to "Boolean", "default" to true), "isRadioMode" to utsMapOf("type" to "Boolean", "default" to false), "lazyContent" to utsMapOf("type" to "Boolean", "default" to false), "lazyDuration" to utsMapOf("type" to "Number", "default" to 100), "itemHeight" to utsMapOf("type" to "String", "default" to "50"), "zIndex" to utsMapOf("type" to "Number", "default" to 1100), "showClose" to utsMapOf("type" to "Boolean", "default" to false), "refresh" to utsMapOf("type" to "Boolean", "default" to false), "bottomRefresh" to utsMapOf("type" to "Boolean", "default" to false), "disabledPull" to utsMapOf("type" to "Boolean", "default" to true), "disabledBottom" to utsMapOf("type" to "Boolean", "default" to true), "disabled" to utsMapOf("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = utsArrayOf(
            "modelValue",
            "modelShow",
            "modelStr",
            "title",
            "cancelText",
            "confirmText",
            "filterKey",
            "labelKey",
            "idKey",
            "list",
            "localSearch",
            "multiple",
            "isRadioMode",
            "lazyContent",
            "lazyDuration",
            "itemHeight",
            "zIndex",
            "showClose",
            "refresh",
            "bottomRefresh",
            "disabledPull",
            "disabledBottom",
            "disabled"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
