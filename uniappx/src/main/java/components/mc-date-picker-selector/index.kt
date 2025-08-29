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
open class GenComponentsMcDatePickerSelectorIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(kVal: String) {
            console.log("modelValue=", this.date)
            this.date = kVal
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_date_view = resolveEasyComponent("x-date-view", GenUniModulesTmxUiComponentsXDateViewXDateViewClass)
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
                                    _cE("text", _uM("class" to "title"), "月份选择"),
                                    _cV(_component_x_date_view, _uM("style" to _nS(_uM("height" to "700rpx")), "type" to "month", "modelValue" to _ctx.date, "onUpdate:modelValue" to fun(`$event`: String){
                                        _ctx.date = `$event`
                                    }
                                    , "title" to "月份选择", "format" to _ctx.format, "start" to _ctx.start, "end" to _ctx.end), null, 8, _uA(
                                        "style",
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "format",
                                        "start",
                                        "end"
                                    )),
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
    open var modelShow: Boolean by `$props`
    open var start: String by `$props`
    open var end: String? by `$props`
    open var format: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var date: Any? by `$data`
    open var showDrawer: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "date" to formatDate(Date(), "yyyy-MM"), "showDrawer" to false)
    }
    open var change = ::gen_change_fn
    open fun gen_change_fn() {
        this.`$emit`("change", this.date)
    }
    open var onCancel = ::gen_onCancel_fn
    open fun gen_onCancel_fn() {
        this.showDrawer = false
        this.`$emit`("update:modelShow", false)
    }
    open var onConfirm = ::gen_onConfirm_fn
    open fun gen_onConfirm_fn() {
        this.date = formatDate(createDate(this.date.toString()), "yyyy-MM")
        console.log("emDate=", this.date)
        this.onCancel()
        this.`$emit`("update:modelValue", this.date)
        this.change()
    }
    open var openDatePicker = ::gen_openDatePicker_fn
    open fun gen_openDatePicker_fn() {
        this.showDrawer = true
        this.`$emit`("update:modelShow", true)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("title" to _pS(_uM("paddingTop" to 10, "paddingRight" to 0, "paddingBottom" to 10, "paddingLeft" to 0, "fontSize" to 18, "fontWeight" to "bold", "color" to "#000000", "textAlign" to "center")), "btn-group" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "position" to "relative", "bottom" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM("globalData" to _uM("type" to "Object"))
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "update:modelShow" to null, "change" to null)
        var props = _nP(_uM("modelValue" to _uM("type" to "String", "default" to ""), "modelShow" to _uM("type" to "Boolean", "default" to true), "start" to _uM("type" to "String", "default" to "2023-01"), "end" to _uM("type" to "String"), "format" to _uM("type" to "String", "default" to "yyyy-MM")))
        var propsNeedCastKeys = _uA(
            "modelValue",
            "modelShow",
            "start",
            "format"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
