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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalJourneyIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop
        }
        , __ins)
        onResize(fun(_: OnResizeOptions) {
            uni__emit("onResize", fun() {})
        }
        , __ins)
        onLoad(fun(_: OnLoadOptions) {}, __ins)
        onPageHide(fun() {
            uni__emit("onHide", fun() {})
        }
        , __ins)
        onReady(fun() {
            uni__emit("onReady", fun() {})
            xProvitae.pageReady = true
        }
        , __ins)
        onPageShow(fun() {
            uni__emit("onShow", fun() {})
        }
        , __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesPersonalJourneyIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalJourneyIndex
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val globalData = inject("globalData") as GlobalDataType
            val selectedDate = ref<String>(formatDate(Date(), "yyyy-MM-dd"))
            val showDatePicker = ref<Boolean>(false)
            val orderList = ref(utsArrayOf<ORDER_ITEM_INFO>())
            var scrollDirection = "down"
            val isfresh = ref<Boolean>(false)
            val bottomFresh = ref<Boolean>(false)
            val clickDate = fun(){
                showDatePicker.value = false
                setTimeout(fun(){
                    showDatePicker.value = true
                }
                , 100)
            }
            val hisQuery = fun(){
                console.log("点击时间查询selectedDate=", selectedDate.value)
                val date = if (selectedDate.value != null) {
                    selectedDate.value
                } else {
                    formatDate(Date(), "yyyy-MM-dd")
                }
                console.log("点击时间查询date=", date)
                getOrderIntercityHistory(date).then(fun(res: Response){
                    if (res.data != null && res.code == 200) {
                        orderList.value = utsArrayOf()
                        val result = res.data as UTSArray<UTSJSONObject>
                        if (result.length > 0) {
                            result.forEach(fun(item){
                                orderList.value.push(JSON.parse<ORDER_ITEM_INFO>(JSON.stringify(item)) as ORDER_ITEM_INFO)
                            }
                            )
                        }
                    }
                    if (scrollDirection == "down") {
                        isfresh.value = false
                    } else {
                        bottomFresh.value = false
                    }
                }
                )
            }
            val onScrollDirection = fun(type: String){
                scrollDirection = type
            }
            val topLoad = fun(){
                console.log("下拉刷新")
                hisQuery()
            }
            val bottomLoad = fun(){
                console.log("触底刷新")
                hisQuery()
            }
            onMounted(fun(){
                hisQuery()
            }
            )
            return fun(): Any? {
                val _component_mc_date_picker = resolveEasyComponent("mc-date-picker", GenComponentsMcDatePickerIndexClass)
                val _component_x_divider = resolveEasyComponent("x-divider", GenUniModulesTmxUiComponentsXDividerXDividerClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_empty = resolveEasyComponent("x-empty", GenUniModulesTmxUiComponentsXEmptyXEmptyClass)
                val _component_x_pull_refresh = resolveEasyComponent("x-pull-refresh", GenUniModulesTmxUiComponentsXPullRefreshXPullRefreshClass)
                val _component_template = resolveComponent("template")
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createVNode(_component_mc_base_container, utsMapOf("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to false, "title" to "历史行程"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("style" to normalizeStyle("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        createElementVNode("view", utsMapOf("class" to "home-bg"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "top-bg"))
                        )),
                        createElementVNode("view", utsMapOf("class" to "container"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "date-selector", "onClick" to clickDate), utsArrayOf(
                                createVNode(_component_mc_date_picker, utsMapOf("modelValue" to unref(selectedDate), "onUpdate:modelValue" to fun(`$event`: String){
                                    trySetRefValue(selectedDate, `$event`)
                                }
                                , "onChange" to hisQuery, "show" to unref(showDatePicker)), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "left-box"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "text"), toDisplayString(if (unref(selectedDate) != "") {
                                                unref(selectedDate)
                                            } else {
                                                "请选择日期"
                                            }
                                            ), 1)
                                        ))
                                    )
                                }
                                ), "_" to 1), 8, utsArrayOf(
                                    "modelValue",
                                    "show"
                                )),
                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-date.png")), null, 8, utsArrayOf(
                                    "src"
                                ))
                            )),
                            createElementVNode("view", utsMapOf("class" to "order-list"), utsArrayOf(
                                createVNode(_component_template, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createVNode(_component_x_pull_refresh, utsMapOf("modelValue" to unref(isfresh), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                            trySetRefValue(isfresh, `$event`)
                                        }
                                        , "show-scrollbar" to false, "onScrollDirection" to onScrollDirection, "model-bottom-status" to unref(bottomFresh), "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                            trySetRefValue(bottomFresh, `$event`)
                                        }
                                        , "onRefresh" to topLoad, "onBottomRefresh" to bottomLoad, "height" to ((unref(screenHeight) - unref(globalData).safeAreaBottom - unref(statusBarHeight) - 150) + "px")), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createElementVNode(Fragment, null, RenderHelpers.renderList(unref(orderList), fun(item, index, __index, _cached): Any {
                                                    return createVNode(_component_x_sheet, utsMapOf("height" to "140", "isLink" to true, "key" to index, "url" to ("/pages/personal/journey/order-detail?orderPid=" + item.id)), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return utsArrayOf(
                                                            createElementVNode("view", utsMapOf("class" to "order-header"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "tag-text"), toDisplayString(if (item.shareWholeType == 1) {
                                                                    "独享"
                                                                } else {
                                                                    "拼车"
                                                                }
                                                                ), 1),
                                                                createElementVNode("text", utsMapOf("class" to "divider"), "|"),
                                                                createElementVNode("text", utsMapOf("class" to "order-time"), toDisplayString(item.scheduledDate) + " " + toDisplayString(item.scheduledStartTime), 1)
                                                            )),
                                                            createVNode(_component_x_divider, utsMapOf("lineWidth" to "2")),
                                                            createElementVNode("view", utsMapOf("class" to "order-item"), utsArrayOf(
                                                                createElementVNode("view", utsMapOf("class" to "order-route"), utsArrayOf(
                                                                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex-direction" to "row", "justify-content" to "space-between"))), utsArrayOf(
                                                                        createElementVNode("text", utsMapOf("class" to "city"), toDisplayString(item.startCityName), 1),
                                                                        createElementVNode("image", utsMapOf("class" to "arrow", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-single-right.png")), null, 8, utsArrayOf(
                                                                            "src"
                                                                        )),
                                                                        createElementVNode("text", utsMapOf("class" to "city"), toDisplayString(item.endCityName), 1)
                                                                    ), 4),
                                                                    createElementVNode("view", utsMapOf("class" to "order-detail", "style" to normalizeStyle(utsMapOf("flex-direction" to "row", "justify-content" to "space-between"))), utsArrayOf(
                                                                        createElementVNode("text", utsMapOf("class" to "detail-text"), toDisplayString(item.linesGroupName), 1),
                                                                        createElementVNode("text", utsMapOf("class" to "divider"), "|"),
                                                                        createElementVNode("text", utsMapOf("class" to "detail-text"), "包含"),
                                                                        createElementVNode("text", utsMapOf("class" to "order-num"), toDisplayString(item.orderCount), 1),
                                                                        createElementVNode("text", utsMapOf("class" to "detail-text"), "笔订单")
                                                                    ), 4)
                                                                )),
                                                                createElementVNode("view", null, utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "price"), "¥ " + toDisplayString(item.totalPrice), 1)
                                                                ))
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 2), 1032, utsArrayOf(
                                                        "url"
                                                    ))
                                                }
                                                ), 128),
                                                if (unref(orderList).length <= 0) {
                                                    createVNode(_component_x_empty, utsMapOf("key" to 0, "loading" to false, "empty" to true, "showBtn" to false))
                                                } else {
                                                    createCommentVNode("v-if", true)
                                                }
                                            )
                                        }
                                        ), "_" to 1), 8, utsArrayOf(
                                            "modelValue",
                                            "model-bottom-status",
                                            "height"
                                        ))
                                    )
                                }
                                ), "_" to 1))
                            ))
                        ))
                    )
                }
                ), "_" to 1))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ), utsArrayOf(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("container" to padStyleMapOf(utsMapOf("width" to "100%", "position" to "relative", "marginTop" to 20, "height" to "100%")), "home-bg" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1, "height" to "100%")), "top-bg" to utsMapOf(".home-bg " to utsMapOf("height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)")), "date-selector" to padStyleMapOf(utsMapOf("backgroundColor" to "#FFFFFF", "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#f0f0f0", "marginTop" to 30, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "width" to "100%", "height" to 50)), "left-box" to utsMapOf(".date-selector " to utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "marginLeft" to 30, "width" to "100%")), "text" to utsMapOf(".date-selector .left-box " to utsMapOf("fontWeight" to "400", "fontSize" to 18, "color" to "#000000")), "text-btn" to utsMapOf(".date-selector .left-box " to utsMapOf("fontWeight" to "400", "fontSize" to 18, "color" to "#000000")), "icon" to utsMapOf(".date-selector " to utsMapOf("width" to 15, "height" to 15, "marginRight" to 30)), "order-list" to padStyleMapOf(utsMapOf("marginTop" to 10, "height" to "100%")), "order-header" to utsMapOf(".order-list " to utsMapOf("display" to "flex", "flexDirection" to "row", "marginBottom" to 10)), "tag-text" to utsMapOf(".order-list .order-header " to utsMapOf("fontSize" to 14, "color" to "#C70000", "fontWeight" to "bold")), "divider" to utsMapOf(".order-list .order-header " to utsMapOf("fontSize" to 14, "color" to "#CCCCCC", "marginTop" to 0, "marginRight" to 8, "marginBottom" to 0, "marginLeft" to 8), ".order-list .order-item .order-detail " to utsMapOf("fontSize" to 14, "color" to "#CCCCCC", "marginTop" to 0, "marginRight" to 8, "marginBottom" to 0, "marginLeft" to 8)), "order-time" to utsMapOf(".order-list .order-header " to utsMapOf("fontSize" to 14)), "order-item" to utsMapOf(".order-list " to utsMapOf("paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "order-route" to utsMapOf(".order-list .order-item " to utsMapOf("display" to "flex", "alignItems" to "center", "marginTop" to 7)), "city" to utsMapOf(".order-list .order-item .order-route " to utsMapOf("fontSize" to "30rpx", "color" to "#333333", "fontWeight" to "bold")), "arrow" to utsMapOf(".order-list .order-item .order-route " to utsMapOf("marginTop" to 3, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "width" to 30, "height" to 10)), "order-detail" to utsMapOf(".order-list .order-item " to utsMapOf("marginTop" to 10)), "detail-text" to utsMapOf(".order-list .order-item .order-detail " to utsMapOf("fontSize" to "25rpx", "color" to "#666666")), "order-num" to utsMapOf(".order-list .order-item .order-detail " to utsMapOf("color" to "#C78300")), "price" to utsMapOf(".order-list .order-item " to utsMapOf("fontSize" to "28rpx", "color" to "#FF3B30", "fontWeight" to "bold", "marginLeft" to "auto")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
