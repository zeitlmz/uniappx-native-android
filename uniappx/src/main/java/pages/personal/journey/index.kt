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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalJourneyIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop
            uni__emit("onPageScroll", e.scrollTop)
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
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
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
            val orderList = ref(_uA<ORDER_ITEM_INFO>())
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
                        orderList.value = _uA()
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
                return _cV(_component_mc_base_container, _uM("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to false, "title" to "历史行程"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("style" to _nS("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        _cE("view", _uM("class" to "home-bg"), _uA(
                            _cE("view", _uM("class" to "top-bg"))
                        )),
                        _cE("view", _uM("class" to "container"), _uA(
                            _cE("view", _uM("class" to "date-selector", "onClick" to clickDate), _uA(
                                _cV(_component_mc_date_picker, _uM("modelValue" to unref(selectedDate), "onUpdate:modelValue" to fun(`$event`: String){
                                    trySetRefValue(selectedDate, `$event`)
                                }
                                , "onChange" to hisQuery, "show" to unref(showDatePicker)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", _uM("class" to "left-box"), _uA(
                                            _cE("text", _uM("class" to "text"), _tD(if (unref(selectedDate) != "") {
                                                unref(selectedDate)
                                            } else {
                                                "请选择日期"
                                            }
                                            ), 1)
                                        ))
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "modelValue",
                                    "show"
                                )),
                                _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-date.png")), null, 8, _uA(
                                    "src"
                                ))
                            )),
                            _cE("view", _uM("class" to "order-list"), _uA(
                                _cV(_component_template, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cV(_component_x_pull_refresh, _uM("modelValue" to unref(isfresh), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                            trySetRefValue(isfresh, `$event`)
                                        }
                                        , "show-scrollbar" to false, "onScrollDirection" to onScrollDirection, "model-bottom-status" to unref(bottomFresh), "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                            trySetRefValue(bottomFresh, `$event`)
                                        }
                                        , "onRefresh" to topLoad, "onBottomRefresh" to bottomLoad, "height" to ((unref(screenHeight) - unref(globalData).safeAreaBottom - unref(statusBarHeight) - 150) + "px")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE(Fragment, null, RenderHelpers.renderList(unref(orderList), fun(item, index, __index, _cached): Any {
                                                    return _cV(_component_x_sheet, _uM("height" to "140", "isLink" to true, "key" to index, "url" to ("/pages/personal/journey/order-detail?orderPid=" + item.id)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _cE("view", _uM("class" to "order-header"), _uA(
                                                                _cE("text", _uM("class" to "tag-text"), _tD(if (item.shareWholeType == 1) {
                                                                    "独享"
                                                                } else {
                                                                    "拼车"
                                                                }
                                                                ), 1),
                                                                _cE("text", _uM("class" to "divider"), "|"),
                                                                _cE("text", _uM("class" to "order-time"), _tD(item.scheduledDate) + " " + _tD(item.scheduledStartTime), 1)
                                                            )),
                                                            _cV(_component_x_divider, _uM("lineWidth" to "2")),
                                                            _cE("view", _uM("class" to "order-item"), _uA(
                                                                _cE("view", _uM("class" to "order-route"), _uA(
                                                                    _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "justify-content" to "space-between"))), _uA(
                                                                        _cE("text", _uM("class" to "city"), _tD(item.startCityName), 1),
                                                                        _cE("image", _uM("class" to "arrow", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-single-right.png")), null, 8, _uA(
                                                                            "src"
                                                                        )),
                                                                        _cE("text", _uM("class" to "city"), _tD(item.endCityName), 1)
                                                                    ), 4),
                                                                    _cE("view", _uM("class" to "order-detail", "style" to _nS(_uM("flex-direction" to "row", "justify-content" to "space-between"))), _uA(
                                                                        _cE("text", _uM("class" to "detail-text"), _tD(item.linesGroupName), 1),
                                                                        _cE("text", _uM("class" to "divider"), "|"),
                                                                        _cE("text", _uM("class" to "detail-text"), "包含"),
                                                                        _cE("text", _uM("class" to "order-num"), _tD(item.orderCount), 1),
                                                                        _cE("text", _uM("class" to "detail-text"), "笔订单")
                                                                    ), 4)
                                                                )),
                                                                _cE("view", null, _uA(
                                                                    _cE("text", _uM("class" to "price"), "¥ " + _tD(item.totalPrice), 1)
                                                                ))
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 2), 1032, _uA(
                                                        "url"
                                                    ))
                                                }
                                                ), 128),
                                                if (unref(orderList).length <= 0) {
                                                    _cV(_component_x_empty, _uM("key" to 0, "loading" to false, "empty" to true, "showBtn" to false))
                                                } else {
                                                    _cC("v-if", true)
                                                }
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
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
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("container" to _pS(_uM("width" to "100%", "position" to "relative", "marginTop" to 20, "height" to "100%")), "home-bg" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1, "height" to "100%")), "top-bg" to _uM(".home-bg " to _uM("height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)")), "date-selector" to _pS(_uM("backgroundColor" to "#FFFFFF", "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#f0f0f0", "marginTop" to 30, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "width" to "100%", "height" to 50)), "left-box" to _uM(".date-selector " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "marginLeft" to 30, "width" to "100%")), "text" to _uM(".date-selector .left-box " to _uM("fontWeight" to "400", "fontSize" to 18, "color" to "#000000")), "text-btn" to _uM(".date-selector .left-box " to _uM("fontWeight" to "400", "fontSize" to 18, "color" to "#000000")), "icon" to _uM(".date-selector " to _uM("width" to 15, "height" to 15, "marginRight" to 30)), "order-list" to _pS(_uM("marginTop" to 10, "height" to "100%")), "order-header" to _uM(".order-list " to _uM("display" to "flex", "flexDirection" to "row", "marginBottom" to 10)), "tag-text" to _uM(".order-list .order-header " to _uM("fontSize" to 14, "color" to "#C70000", "fontWeight" to "bold")), "divider" to _uM(".order-list .order-header " to _uM("fontSize" to 14, "color" to "#CCCCCC", "marginTop" to 0, "marginRight" to 8, "marginBottom" to 0, "marginLeft" to 8), ".order-list .order-item .order-detail " to _uM("fontSize" to 14, "color" to "#CCCCCC", "marginTop" to 0, "marginRight" to 8, "marginBottom" to 0, "marginLeft" to 8)), "order-time" to _uM(".order-list .order-header " to _uM("fontSize" to 14)), "order-item" to _uM(".order-list " to _uM("paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "order-route" to _uM(".order-list .order-item " to _uM("display" to "flex", "alignItems" to "center", "marginTop" to 7)), "city" to _uM(".order-list .order-item .order-route " to _uM("fontSize" to "30rpx", "color" to "#333333", "fontWeight" to "bold")), "arrow" to _uM(".order-list .order-item .order-route " to _uM("marginTop" to 3, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "width" to 30, "height" to 10)), "order-detail" to _uM(".order-list .order-item " to _uM("marginTop" to 10)), "detail-text" to _uM(".order-list .order-item .order-detail " to _uM("fontSize" to "25rpx", "color" to "#666666")), "order-num" to _uM(".order-list .order-item .order-detail " to _uM("color" to "#C78300")), "price" to _uM(".order-list .order-item " to _uM("fontSize" to "28rpx", "color" to "#FF3B30", "fontWeight" to "bold", "marginLeft" to "auto")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
