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
            clearTimeout(this.tid34)
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
        return _cE("view", null, _uA(
            _cE("view", _uM("onClick" to _ctx.openShow), _uA(
                renderSlot(_ctx.`$slots`, "default", _uM("label" to _ctx.nowvalueStr))
            ), 8, _uA(
                "onClick"
            )),
            _cV(_component_x_drawer, _uM("cancel-text" to _ctx._cancelText, "confirm-text" to _ctx._confirmText, "zIndex" to _ctx.zIndex, "onOpen" to _ctx.onOpen, "widthCoverCenter" to _ctx.widthCoverCenter, "watiDuration" to _ctx.duration, "contentMargin" to "0px", "disabledScroll" to true, "title" to _ctx._title, "onClose" to _ctx.onClose, "onConfirm" to _ctx.onConfirm, "onCancel" to _ctx.onCancel, "showFooter" to true, "show" to _ctx.show, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.show = `$event`
            }
            , "show-close" to _ctx.showClose, "size" to "80%"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                return _uA(
                    _cE("view", _uM("class" to "xPickerSlectedIwrap", "style" to _nS(_uM("height" to "44px", "borderRadius" to "44px"))), _uA(
                        _cE("view", _uM("class" to "xPickerSlectedInputBox", "style" to _nS(_uM("backgroundColor" to _ctx._inputBgColor))), _uA(
                            _cE("input", _uM("placeholder" to _ctx.i18n!!.t("tmui4x.pickerSelected.placeholder"), "style" to _nS(_uM("color" to _ctx._inputColor, "fontSize" to "16px")), "onInput" to _ctx.inpuEvent, "onConfirm" to _ctx.inputConfirm, "value" to _ctx.searchKey, "class" to "xPickerSlectedInput"), null, 44, _uA(
                                "placeholder",
                                "onInput",
                                "onConfirm",
                                "value"
                            )),
                            if (_ctx.searchKey.length > 0) {
                                _cE("view", _uM("key" to 0, "onClick" to _ctx.clearSearchKey, "class" to "clearClick"), _uA(
                                    _cV(_component_x_icon, _uM("font-size" to "24", "name" to "close-circle-fill", "color" to "#d1d1d1"))
                                ), 8, _uA(
                                    "onClick"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        ), 4),
                        _cV(_component_x_button, _uM("width" to "80", "onClick" to _ctx.inputConfirm, "color" to _ctx._color, "round" to "0", "height" to "44"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _tD(_ctx.i18n!!.t("tmui4x.pickerSelected.search"))
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "onClick",
                            "color"
                        ))
                    ), 4),
                    _cE("view", _uM("class" to "xPickerSlectedWrap"), _uA(
                        if (isTrue(!_ctx.yanchiDuration)) {
                            _cV(_component_x_loading, _uM("key" to 0))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue((_ctx._list.length > 0 && _ctx._renderListData.length > 0) && _ctx.yanchiDuration)) {
                            _cE("view", _uM("key" to 1, "style" to _nS(_uM("flex" to "1"))), _uA(
                                if (isTrue(_ctx._list.length > 0 && _ctx.yanchiDuration)) {
                                    _cV(_component_x_pull_refresh, _uM("key" to 0, "disabled-bottom" to _ctx._disabledBottom, "disabled-pull" to _ctx._disabledPull, "onRefresh" to _ctx.loadRefres, "onBottomRefresh" to _ctx.bottomLoadRefres, "modelValue" to _ctx.isRefresh, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                        _ctx.isRefresh = `$event`
                                    }, "model-bottom-status" to _ctx.isBootomIsRefresh, "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                        _ctx.isBootomIsRefresh = `$event`
                                    }, "mode" to "listview", "height" to "100%"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(_ctx._renderListData, fun(item, index, __index, _cached): Any {
                                                return _cE("list-item", _uM("onClick" to fun(){
                                                    _ctx.onclik(item)
                                                }, "type" to index, "key" to index, "class" to _nC(_uA(
                                                    "xPickerSlectedItem",
                                                    _uA(
                                                        if (_ctx.isSelected(item)) {
                                                            "xPickerSlectedWrapOn"
                                                        } else {
                                                            ""
                                                        }
                                                    )
                                                )), "style" to _nS(_uM("height" to _ctx._itemHeight))), _uA(
                                                    _cE("view", _uM("class" to "xPickerSlectedItemWrap", "style" to _nS(_uM("border-bottom" to ("1px solid " + _ctx._borderColor), "margin" to "0 16px"))), _uA(
                                                        _cE("view", _uM("class" to "xPickerSlectedItemText"), _uA(
                                                            renderSlot(_ctx.`$slots`, "item", GenUniModulesTmxUiComponentsXPickerSelectedXPickerSelectedSlotDataItem(item = item.item), fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _cV(_component_x_text, _uM("color" to if (_ctx.isSelected(item)) {
                                                                        _ctx._color
                                                                    } else {
                                                                        if (_ctx._isDark) {
                                                                            "white"
                                                                        } else {
                                                                            "#888"
                                                                        }
                                                                    }, "font-size" to "15", "line-height" to "1.2", "lines" to 2), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                        return _uA(
                                                                            _tD(item.title)
                                                                        )
                                                                    }), "_" to 2), 1032, _uA(
                                                                        "color"
                                                                    ))
                                                                )
                                                            })
                                                        )),
                                                        _cV(_component_x_icon, _uM("color" to if (_ctx.isSelected(item)) {
                                                            _ctx._color
                                                        } else {
                                                            "#e6e6e6"
                                                        }, "font-size" to "28", "name" to if (_ctx.isSelected(item)) {
                                                            "checkbox-circle-fill"
                                                        } else {
                                                            "checkbox-blank-circle-line"
                                                        }), null, 8, _uA(
                                                            "color",
                                                            "name"
                                                        ))
                                                    ), 4)
                                                ), 14, _uA(
                                                    "onClick",
                                                    "type"
                                                ))
                                            }), 128)
                                        )
                                    }), "_" to 3), 8, _uA(
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
                                    _cC("v-if", true)
                                }
                            ), 4)
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue(_ctx._list.length == 0 || _ctx._renderListData.length == 0)) {
                            _cE("view", _uM("key" to 2, "style" to _nS(_uM("flex" to "1"))), _uA(
                                _cV(_component_x_empty, _uM("show-btn" to false, "loading" to false, "empty" to true))
                            ), 4)
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue(_ctx._list.length > 0 && _ctx.yanchiDuration)) {
                            _cE("view", _uM("key" to 3, "class" to "xPickerSlectedFooter"), _uA(
                                _cV(_component_x_text, _uM("class" to "xPickerSlectedFooterBtnText", "style" to _nS(_uM("text-align" to "center")), "color" to _ctx._color, "font-size" to "14"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(_ctx.i18n!!.t("tmui4x.pickerSelected.selected", _ctx.nowValue.length))
                                    )
                                }), "_" to 1), 8, _uA(
                                    "style",
                                    "color"
                                )),
                                _cE("view", _uM("class" to "xPickerSlectedFooterBtn"), _uA(
                                    if (isTrue(!_ctx._isRadioMode)) {
                                        _cV(_component_x_text, _uM("key" to 0, "class" to "xPickerSlectedFooterBtnText", "onClick" to _ctx.clearAll, "color" to "#666", "font-size" to "14"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(_ctx.i18n!!.t("tmui4x.pickerSelected.claer"))
                                            )
                                        }), "_" to 1), 8, _uA(
                                            "onClick"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    },
                                    if (isTrue(_ctx._isRadioMode)) {
                                        _cV(_component_x_text, _uM("key" to 1, "class" to "xPickerSlectedFooterBtnText", "color" to "#666", "font-size" to "14"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(_ctx.i18n!!.t("tmui4x.pickerSelected.selectedMode"))
                                            )
                                        }), "_" to 1))
                                    } else {
                                        _cC("v-if", true)
                                    },
                                    if (isTrue(_ctx.multiple)) {
                                        _cV(_component_x_text, _uM("key" to 2, "style" to _nS(_uM("margin-left" to "24px")), "class" to "xPickerSlectedFooterBtnText", "onClick" to _ctx.selectedAll, "color" to _ctx._color, "font-size" to "14"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(_ctx.i18n!!.t("tmui4x.pickerSelected.selectedALl"))
                                            )
                                        }), "_" to 1), 8, _uA(
                                            "style",
                                            "onClick",
                                            "color"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                    ))
                )
            }
            ), "_" to 3), 8, _uA(
                "cancel-text",
                "confirm-text",
                "zIndex",
                "onOpen",
                "widthCoverCenter",
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
    open var widthCoverCenter: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var show: Boolean by `$data`
    open var nowValue: UTSArray<xPickerSelectedListyType> by `$data`
    open var searchList: UTSArray<xPickerSelectedListyType> by `$data`
    open var searchKey: String by `$data`
    open var duration: Number by `$data`
    open var yanchiDuration: Boolean by `$data`
    open var tid: Number by `$data`
    open var tid34: Number by `$data`
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
    open var nowvalueStr: String by `$data`
    open var _cancelText: String by `$data`
    open var _confirmText: String by `$data`
    open var _title: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "show" to false, "nowValue" to _uA<xPickerSelectedListyType>(), "searchList" to _uA<xPickerSelectedListyType>(), "searchKey" to "", "duration" to 60, "yanchiDuration" to false, "tid" to 100, "tid34" to 369, "isRefresh" to false, "isBootomIsRefresh" to false, "_disabled" to computed<Boolean>(fun(): Boolean {
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
            if (this.searchList.length >= 0 && this.localSearch && this.searchKey.length > 0) {
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
        ), "nowvalueStr" to computed<String>(fun(): String {
            return this.nowValue.map(fun(el): String {
                return el.title
            }
            ).join(",")
        }
        ), "_cancelText" to computed<String>(fun(): String {
            if (this.cancelText == "") {
                return this!!.i18n.t("tmui4x.cancel")
            }
            return this.cancelText
        }
        ), "_confirmText" to computed<String>(fun(): String {
            if (this.confirmText == "") {
                return this!!.i18n.t("tmui4x.confirm")
            }
            return this.confirmText
        }
        ), "_title" to computed<String>(fun(): String {
            if (this.title == "") {
                return this!!.i18n.t("tmui4x.pickerTitle")
            }
            return this.title
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
                this.nowValue = (_uA<xPickerSelectedListyType>(item))
            } else {
                this.nowValue = if (index > -1) {
                    (_uA<xPickerSelectedListyType>())
                } else {
                    (_uA<xPickerSelectedListyType>(item))
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
        clearTimeout(this.tid34)
        val _this = this
        this.tid34 = setTimeout(fun() {
            _this.inputConfirm()
        }
        , 250)
    }
    open var clearSearchKey = ::gen_clearSearchKey_fn
    open fun gen_clearSearchKey_fn() {
        this.searchKey = ""
        this.inputConfirm()
    }
    open var inputConfirm = ::gen_inputConfirm_fn
    open fun gen_inputConfirm_fn() {
        if (this.localSearch) {
            this.searchList = _uA<xPickerSelectedListyType>()
            var t = this
            var templist = this._list.filter(fun(el): Boolean {
                return el.title.indexOf(t.searchKey.trim()) > -1
            }
            )
            this.searchList = templist.slice(0)
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
            return _uA<xPickerSelectedListyType>()
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
        this.nowValue = _uA<xPickerSelectedListyType>()
        console.log(this.nowValue)
    }
    open var selectedAll = ::gen_selectedAll_fn
    open fun gen_selectedAll_fn() {
        var temp = this._list.slice(0)
        if (this._list.length > 0) {
            if (this.multiple) {
                this.nowValue = temp
            } else {
                this.nowValue = _uA<xPickerSelectedListyType>(temp[0])
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
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xPickerSlectedFooterBtn" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end")), "xPickerSlectedFooter" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to 12, "paddingRight" to 16, "paddingBottom" to 12, "paddingLeft" to 16)), "xPickerSlectedInputBox" to _pS(_uM("height" to "100%", "flex" to 1, "position" to "relative", "display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end")), "clearClick" to _pS(_uM("paddingTop" to 0, "paddingRight" to 16, "paddingBottom" to 0, "paddingLeft" to 16, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "flexDirection" to "row")), "xPickerSlectedIwrap" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "marginTop" to 0, "marginRight" to 16, "marginBottom" to 16, "marginLeft" to 16)), "xPickerSlectedInput" to _pS(_uM("height" to "100%", "flex" to 1, "paddingTop" to 0, "paddingRight" to 16, "paddingBottom" to 0, "paddingLeft" to 16)), "xPickerSlectedItemWrap" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center", "height" to "100%")), "xPickerSlectedItemText" to _pS(_uM("flex" to 1)), "xPickerSlectedWrap" to _pS(_uM("display" to "flex", "flexDirection" to "column", "flex" to 1)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("bottomRefresh" to null, "refresh" to null, "search" to null, "confirm" to null, "cancel" to null, "open" to null, "update:modelShow" to null, "update:modelStr" to null, "update:bottomRefresh" to null, "update:refresh" to null, "update:modelValue" to null)
        var props = _nP(_uM("modelValue" to _uM("type" to "Array", "default" to fun(): UTSArray<Any> {
            return _uA<Any>()
        }
        ), "modelShow" to _uM("type" to "Boolean", "default" to false), "modelStr" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "title" to _uM("type" to "String", "default" to ""), "cancelText" to _uM("type" to "String", "default" to ""), "confirmText" to _uM("type" to "String", "default" to ""), "filterKey" to _uM("type" to "String", "default" to "text"), "labelKey" to _uM("type" to "String", "default" to "text"), "idKey" to _uM("type" to "String", "default" to "id"), "list" to _uM("type" to "Array", "default" to fun(): UTSArray<UTSJSONObject> {
            return _uA<UTSJSONObject>()
        }
        ), "localSearch" to _uM("type" to "Boolean", "default" to true), "multiple" to _uM("type" to "Boolean", "default" to true), "isRadioMode" to _uM("type" to "Boolean", "default" to false), "lazyContent" to _uM("type" to "Boolean", "default" to false), "lazyDuration" to _uM("type" to "Number", "default" to 100), "itemHeight" to _uM("type" to "String", "default" to "50"), "zIndex" to _uM("type" to "Number", "default" to 1100), "showClose" to _uM("type" to "Boolean", "default" to false), "refresh" to _uM("type" to "Boolean", "default" to false), "bottomRefresh" to _uM("type" to "Boolean", "default" to false), "disabledPull" to _uM("type" to "Boolean", "default" to true), "disabledBottom" to _uM("type" to "Boolean", "default" to true), "disabled" to _uM("type" to "Boolean", "default" to false), "widthCoverCenter" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
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
            "disabled",
            "widthCoverCenter"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
