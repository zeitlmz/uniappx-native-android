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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
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
        return createElementVNode(Fragment, null, utsArrayOf(
            createElementVNode("view", utsMapOf("onClick" to _ctx.openDatePicker), utsArrayOf(
                renderSlot(_ctx.`$slots`, "default")
            ), 8, utsArrayOf(
                "onClick"
            )),
            createVNode(_component_x_drawer, utsMapOf("content-margin" to "0px", "show" to _ctx.showDrawer, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.showDrawer = `$event`
            }
            , "bgColor" to "#ffffff", "show-title" to false, "size" to "560px"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createVNode(_component_x_sheet, utsMapOf("height" to "100%", "padding" to utsArrayOf(
                        "0"
                    ), "margin" to utsArrayOf(
                        "0"
                    ), "linear-gradient" to utsArrayOf(
                        "bottom",
                        _ctx.globalData.theme.painColor,
                        "#ffffff"
                    )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createVNode(_component_x_sheet, utsMapOf("color" to "transparent", "padding" to utsArrayOf(
                                "15"
                            )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "title"), "月份选择"),
                                    createVNode(_component_x_date_view, utsMapOf("style" to normalizeStyle(utsMapOf("height" to "700rpx")), "type" to "month", "modelValue" to _ctx.date, "onUpdate:modelValue" to fun(`$event`: Any?){
                                        _ctx.date = `$event`
                                    }
                                    , "title" to "月份选择", "format" to _ctx.format, "start" to _ctx.start, "end" to _ctx.end), null, 8, utsArrayOf(
                                        "style",
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "format",
                                        "start",
                                        "end"
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "btn-group"), utsArrayOf(
                                        createVNode(_component_x_button, utsMapOf("onClick" to _ctx.onCancel, "skin" to "thin", "style" to normalizeStyle(utsMapOf("flex" to "1", "margin-right" to "10px"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                "取消"
                                            )
                                        }
                                        ), "_" to 1), 8, utsArrayOf(
                                            "onClick",
                                            "style"
                                        )),
                                        createVNode(_component_x_button, utsMapOf("onClick" to _ctx.onConfirm, "style" to normalizeStyle(utsMapOf("flex" to "1"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                "确认"
                                            )
                                        }
                                        ), "_" to 1), 8, utsArrayOf(
                                            "onClick",
                                            "style"
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "linear-gradient"
                    ))
                )
            }
            ), "_" to 1), 8, utsArrayOf(
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
    open var date: Any? by `$data`
    open var showDrawer: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("date" to formatDate(Date(), "yyyy-MM"), "showDrawer" to false)
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
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("title" to padStyleMapOf(utsMapOf("paddingTop" to 10, "paddingRight" to 0, "paddingBottom" to 10, "paddingLeft" to 0, "fontSize" to 18, "fontWeight" to "bold", "color" to "#000000", "textAlign" to "center")), "btn-group" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "position" to "relative", "bottom" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf("globalData" to utsMapOf("type" to "Object"))
        var emits: Map<String, Any?> = utsMapOf("update:modelValue" to null, "update:modelShow" to null, "change" to null)
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "String", "default" to ""), "modelShow" to utsMapOf("type" to "Boolean", "default" to true), "start" to utsMapOf("type" to "String", "default" to "2023-01"), "end" to utsMapOf("type" to "String"), "format" to utsMapOf("type" to "String", "default" to "yyyy-MM")))
        var propsNeedCastKeys = utsArrayOf(
            "modelValue",
            "modelShow",
            "start",
            "format"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
