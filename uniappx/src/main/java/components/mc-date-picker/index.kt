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
open class GenComponentsMcDatePickerIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.isShow = true
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.show
        }
        , fun(kVal: Boolean) {
            this.showDrawer = kVal
        }
        )
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(kVal: String) {
            this.date = kVal
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_calendar_view = resolveEasyComponent("x-calendar-view", GenUniModulesTmxUiComponentsXCalendarViewXCalendarViewClass)
        val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass)
        val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
        val _component_x_drawer = resolveEasyComponent("x-drawer", GenUniModulesTmxUiComponentsXDrawerXDrawerClass)
        return _cE(Fragment, null, _uA(
            _cE("view", _uM("onClick" to _ctx.openDatePicker), _uA(
                renderSlot(_ctx.`$slots`, "default")
            ), 8, _uA(
                "onClick"
            )),
            _cV(_component_x_drawer, _uM("content-margin" to "0px", "show" to _ctx.showDrawer, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.showDrawer = `$event`
            }
            , "bgColor" to "#ffffff", "show-title" to false, "size" to "560px"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                return _uA(
                    _cV(_component_x_sheet, _uM("height" to "100%", "padding" to _uA(
                        "0"
                    ), "margin" to _uA(
                        "0"
                    ), "linear-gradient" to _uA(
                        "bottom",
                        _ctx.globalData.theme.painColor,
                        "#ffffff"
                    )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cV(_component_x_sheet, _uM("color" to "transparent", "padding" to _uA(
                                "15"
                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("text", _uM("class" to "date-selector-title"), _tD(_ctx.title), 1),
                                    if (isTrue(_ctx.isShow)) {
                                        _cV(_component_x_calendar_view, _uM("key" to 0, "date-style" to _ctx.dateStyle, "disabledSwiper" to true, "start-date" to _ctx.startDate, "end-date" to _ctx.endDate, "disabled-days" to _ctx.disabledDays, "format" to _ctx.format, "modelValue" to _ctx.date, "onUpdate:modelValue" to fun(`$event`: String){
                                            _ctx.date = `$event`
                                        }), null, 8, _uA(
                                            "date-style",
                                            "start-date",
                                            "end-date",
                                            "disabled-days",
                                            "format",
                                            "modelValue",
                                            "onUpdate:modelValue"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    _cE("view", _uM("class" to "btn-group"), _uA(
                                        _cV(_component_x_button, _uM("onClick" to _ctx.onCancel, "skin" to "thin", "style" to _nS(_uM("flex" to "1", "margin-right" to "10px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                "取消"
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "onClick",
                                            "style"
                                        )),
                                        _cV(_component_x_button, _uM("onClick" to _ctx.onConfirm, "style" to _nS(_uM("flex" to "1"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                "确认"
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "onClick",
                                            "style"
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "linear-gradient"
                    ))
                )
            }
            ), "_" to 1), 8, _uA(
                "show",
                "onUpdate:show"
            ))
        ), 64)
    }
    open var globalData: GlobalDataType by `$inject`
    open var modelValue: String by `$props`
    open var show: Boolean
        @JvmName("getShow0")
        get() {
            return this.`$props`["show"] as Boolean
        }
        @JvmName("setShow0")
        set(value) {
            this.`$props`["show"] = value
        }
    open var startDate: String by `$props`
    open var endDate: String by `$props`
    open var disabledDays: UTSArray<String> by `$props`
    open var minDate: String by `$props`
    open var format: String by `$props`
    open var dateStyle: UTSArray<xCalendarDateStyle_type> by `$props`
    open var title: String by `$props`
    open var date: String by `$data`
    open var showDrawer: Boolean by `$data`
    open var isShow: Boolean
        @JvmName("getIsShow1")
        get() {
            return this.`$data`["isShow"] as Boolean
        }
        @JvmName("setIsShow1")
        set(value) {
            this.`$data`["isShow"] = value
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("date" to "", "showDrawer" to false, "isShow" to false)
    }
    open var change = ::gen_change_fn
    open fun gen_change_fn() {
        this.`$emit`("change", this.date)
    }
    open var onCancel = ::gen_onCancel_fn
    open fun gen_onCancel_fn() {
        this.showDrawer = false
        this.`$emit`("update:show", false)
    }
    open var onConfirm = ::gen_onConfirm_fn
    open fun gen_onConfirm_fn() {
        this.onCancel()
        this.`$emit`("update:modelValue", this.date)
        this.change()
    }
    open var openDatePicker = ::gen_openDatePicker_fn
    open fun gen_openDatePicker_fn() {
        this.showDrawer = true
        this.`$emit`("update:show", true)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("date-selector-title" to _pS(_uM("paddingTop" to 10, "paddingRight" to 0, "paddingBottom" to 10, "paddingLeft" to 0, "fontSize" to 18, "fontWeight" to "bold", "color" to "#000000", "textAlign" to "center")), "btn-group" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM("globalData" to _uM("type" to "Object"))
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "update:show" to null, "change" to null)
        var props = _nP(_uM("modelValue" to _uM("type" to "String", "default" to ""), "show" to _uM("type" to "Boolean", "default" to false), "startDate" to _uM("type" to "String", "default" to "2015-01-01"), "endDate" to _uM("type" to "String", "default" to formatDate(Date(), "yyyy-MM-dd")), "disabledDays" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA()
        }
        ), "minDate" to _uM("type" to "String", "default" to ""), "format" to _uM("type" to "String", "default" to "YYYY-MM-DD"), "dateStyle" to _uM("type" to "Array", "default" to fun(): UTSArray<xCalendarDateStyle_type> {
            return _uA()
        }
        ), "title" to _uM("type" to "String", "default" to "日期选择")))
        var propsNeedCastKeys = _uA(
            "modelValue",
            "show",
            "startDate",
            "endDate",
            "disabledDays",
            "minDate",
            "format",
            "dateStyle",
            "title"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
