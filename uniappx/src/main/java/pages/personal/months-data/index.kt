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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import uts.sdk.modules.mcAmapNavPlus.checkLocationPermission
import uts.sdk.modules.mcAmapNavPlus.init
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalMonthsDataIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalMonthsDataIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalMonthsDataIndex
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val globalData = inject("globalData") as GlobalDataType
            val bgSrc = resBaseUrl + "/static/icons/icon-order-detail-back.png"
            val bgImg = ref<String>(bgSrc)
            val currentDate = ref<String>(formatDate(Date(), "yyyy-MM"))
            val summaryData = ref<SummaryData>(SummaryData(orderRankNumber = 0, outCarDays = 0, revenueAmount = "0", realTotalIncome = "0", realCompleteOrderIncome = "0", realDefaultOrderIncome = "0", completeOrderCount = 0, complainCount = 0, tripCount = 0, activityReward = "0"))
            val oninit = fun(){}
            val xAxisData = getDaysInMonth(Date().getFullYear(), Date().getMonth() + 1)
            val initOpts = fun(optData: OptionsData, type: String): UTSJSONObject {
                return object : UTSJSONObject() {
                    var tooltip = object : UTSJSONObject() {
                        var trigger = "axis"
                        var axisPointer = object : UTSJSONObject() {
                            var type = "shadow"
                        }
                        var backgroundColor = "#fff"
                        var borderColor = "#000"
                        var borderWidth: Number = 1
                        var textStyle = object : UTSJSONObject() {
                            var color = "#000"
                            var fontSize: Number = 12
                        }
                    }
                    var xAxis = object : UTSJSONObject() {
                        var type = "category"
                        var boundaryGap = false
                        var data = optData.xAxisDataVal
                    }
                    var yAxis = object : UTSJSONObject() {
                        var type = "value"
                        var name = if (type == "income") {
                            "（元）"
                        } else {
                            ""
                        }
                    }
                    var grid = object : UTSJSONObject() {
                        var top = "30rpx"
                        var left = "33rpx"
                        var right = (if (optData.xAxisDataVal.length > 30 || optData.xAxisDataVal.length == 28) {
                            35
                        } else {
                            20
                        }
                        ) + "rpx"
                        var height = "100rpx"
                    }
                    var series = utsArrayOf(
                        object : UTSJSONObject() {
                            var data = optData.seriesData
                            var type = "line"
                            var lineStyle = object : UTSJSONObject() {
                                var color = optData.colorStr
                            }
                            var symbol = "circle"
                            var symbolSize: Number = 6
                            var itemStyle = object : UTSJSONObject() {
                                var normal = object : UTSJSONObject() {
                                    var color = optData.colorStr
                                }
                            }
                            var areaStyle = object : UTSJSONObject() {
                                var color = object : UTSJSONObject() {
                                    var type = "linear"
                                    var x: Number = 0
                                    var y: Number = 0
                                    var x2: Number = 0
                                    var y2: Number = 1
                                    var colorStops = utsArrayOf(
                                        object : UTSJSONObject() {
                                            var offset: Number = 0
                                            var color = optData.colorStr
                                        },
                                        object : UTSJSONObject() {
                                            var offset: Number = 1
                                            var color = optData.gradientColor
                                        }
                                    )
                                    var global = false
                                }
                            }
                        }
                    )
                }
            }
            val incomeOptData = OptionsData(colorStr = "rgba(54, 153, 255, 1)", gradientColor = "rgba(54, 153, 255, 0)", xAxisDataVal = utsArrayOf(), seriesData = utsArrayOf())
            val incomeOpts = ref<String>(JSON.stringify(initOpts(incomeOptData, "income")))
            val completeOrderOptData = OptionsData(colorStr = "rgba(93, 166, 83, 1)", gradientColor = "rgba(93, 166, 83, 0)", xAxisDataVal = utsArrayOf(), seriesData = utsArrayOf())
            val completeOrderOpts = ref<String>(JSON.stringify(initOpts(completeOrderOptData, "ordernum")))
            val getDate = fun(reassignedDate: String): String {
                var date = reassignedDate
                if (date == "") {
                    date = formatDate(Date(), "yyyy-MM")
                }
                return date.substring(0, 7)
            }
            val querySummaryData = fun(){
                getDriverMonthDataSummary(currentDate.value).then(fun(res: Response){
                    if (res.code == 200) {
                        val data = res.data as UTSJSONObject
                        summaryData.value = JSON.parseObject<SummaryData>(JSON.stringify(data))!!
                        console.log("summaryData===", summaryData.value)
                    }
                }
                )
            }
            val queryIncome = fun(){
                getDriverIncomeLineChart(getDate(currentDate.value)).then(fun(res: Response){
                    val xAxisDataVal: UTSArray<String> = utsArrayOf()
                    val seriesData: UTSArray<Number> = utsArrayOf()
                    val resData = res.data as UTSArray<UTSJSONObject>
                    resData.forEach(fun(item){
                        val name = item.getString("name")
                        val value = item.getString("value")
                        xAxisDataVal.add(if (name != null && name != "") {
                            name
                        } else {
                            ""
                        }
                        )
                        seriesData.add(if (value != null) {
                            parseFloat(value)
                        } else {
                            0
                        }
                        )
                    }
                    )
                    incomeOptData.xAxisDataVal = xAxisDataVal
                    incomeOptData.seriesData = seriesData
                    incomeOpts.value = JSON.stringify(initOpts(incomeOptData, "income"))
                }
                )
            }
            val queryCompleteOrder = fun(){
                getDriverCompleteOrderLineChart(currentDate.value).then(fun(res: Response){
                    val xAxisDataVal: UTSArray<String> = utsArrayOf()
                    val seriesData: UTSArray<Number> = utsArrayOf()
                    val resData = res.data as UTSArray<UTSJSONObject>
                    resData.forEach(fun(item){
                        val name = item.getString("name")
                        val value = item.getString("value")
                        xAxisDataVal.add(if (name != null && name != "") {
                            name
                        } else {
                            ""
                        }
                        )
                        seriesData.add(if (value != null) {
                            parseFloat(value)
                        } else {
                            0
                        }
                        )
                    }
                    )
                    completeOrderOptData.xAxisDataVal = xAxisDataVal
                    completeOrderOptData.seriesData = seriesData
                    completeOrderOpts.value = JSON.stringify(initOpts(completeOrderOptData, "ordernum"))
                }
                )
            }
            val queryAllData = fun(){
                querySummaryData()
                queryIncome()
                queryCompleteOrder()
            }
            val init = fun(){
                queryAllData()
                setTimeout(fun(){
                    bgImg.value = bgSrc
                }
                , 100)
            }
            onReady(fun(){
                init()
            }
            )
            return fun(): Any? {
                val _component_mc_date_picker_selector = resolveEasyComponent("mc-date-picker-selector", GenComponentsMcDatePickerSelectorIndexClass)
                val _component_x_divider = resolveEasyComponent("x-divider", GenUniModulesTmxUiComponentsXDividerXDividerClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_echart = resolveEasyComponent("x-echart", GenUniModulesTmxUiComponentsXEchartXEchartClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createVNode(_component_mc_base_container, utsMapOf("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to true, "title" to "月度数据", "title-color" to "#ffffff"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("style" to normalizeStyle("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        createElementVNode("view", utsMapOf("class" to "home-bg", "height" to ("" + (unref(screenHeight) + unref(statusBarHeight) + unref(globalData).safeAreaBottom + 20 + 100) + "px")), utsArrayOf(
                            createElementVNode("image", utsMapOf("class" to "bg-image", "style" to normalizeStyle(utsMapOf("position" to "absolute", "pointer-events" to "none")), "fadeShow" to true, "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-order-detail-back.png")), null, 12, utsArrayOf(
                                "src"
                            ))
                        ), 8, utsArrayOf(
                            "height"
                        )),
                        createElementVNode("view", utsMapOf("class" to "container", "style" to normalizeStyle("height: " + (unref(screenHeight) + unref(statusBarHeight) + unref(globalData).safeAreaBottom + 100) + "px;")), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "date-picker-container"), utsArrayOf(
                                createVNode(_component_mc_date_picker_selector, utsMapOf("modelValue" to unref(currentDate), "onUpdate:modelValue" to fun(`$event`: String){
                                    trySetRefValue(currentDate, `$event`)
                                }
                                , "onChange" to fun(){
                                    queryAllData()
                                }
                                ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "date-picker-content"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "date-text"), toDisplayString(if (unref(currentDate) != "") {
                                                unref(currentDate)
                                            } else {
                                                "选择月份"
                                            }
                                            ), 1),
                                            createElementVNode("image", utsMapOf("class" to "date-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-date.png")), null, 8, utsArrayOf(
                                                "src"
                                            ))
                                        ))
                                    )
                                }
                                ), "_" to 1), 8, utsArrayOf(
                                    "modelValue",
                                    "onChange"
                                ))
                            )),
                            createElementVNode("view", utsMapOf("class" to "data-list"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "data-item", "style" to normalizeStyle("width: " + (unref(screenWidth) + 150) + "px;")), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "data-item-header"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "header-left"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "lines")),
                                            createElementVNode("text", utsMapOf("class" to "text"), "月度数据汇总")
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "data-item-body", "style" to normalizeStyle(utsMapOf("height" to "490rpx", "flex-direction" to "column"))), utsArrayOf(
                                        createVNode(_component_x_sheet, utsMapOf("dark-color" to "#dcdcdc", "style" to normalizeStyle(utsMapOf("height" to "100%", "width" to "100%"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "summary-body", "style" to normalizeStyle(utsMapOf("height" to "490rpx", "flex-direction" to "column", "margin-left" to "-35px", "z-index" to "1"))), utsArrayOf(
                                                    createElementVNode("view", utsMapOf("class" to "top-bg", "style" to normalizeStyle(utsMapOf("width" to "100%"))), null, 4),
                                                    createElementVNode("view", utsMapOf("class" to "summary-row", "style" to normalizeStyle(utsMapOf("flex-direction" to "row", "width" to "100%", "background-color" to "transparent"))), utsArrayOf(
                                                        createElementVNode("view", utsMapOf("class" to "summary-item", "style" to normalizeStyle(utsMapOf("flex-direction" to "row"))), utsArrayOf(
                                                            createElementVNode("image", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "60rpx", "height" to "60rpx")), "src" to "/static/icons/icon-month-data-rank.png"), null, 4),
                                                            createElementVNode("view", utsMapOf("class" to "ml-5"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "item-label", "style" to normalizeStyle(utsMapOf("font-size" to "26rpx", "font-weight" to "bold"))), "单量排行", 4),
                                                                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex-direction" to "row", "align-items" to "center"))), utsArrayOf(
                                                                    createElementVNode("view", null, utsArrayOf(
                                                                        createElementVNode("text", utsMapOf("class" to "item-value", "style" to normalizeStyle(utsMapOf("font-size" to "34rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), toDisplayString(if (unref(summaryData).orderRankNumber < 1) {
                                                                            "-"
                                                                        } else {
                                                                            unref(summaryData).orderRankNumber
                                                                        }
                                                                        ), 5)
                                                                    )),
                                                                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("margin-top" to "7rpx"))), utsArrayOf(
                                                                        createElementVNode("text", utsMapOf("class" to "item-value", "style" to normalizeStyle(utsMapOf("font-size" to "20rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), "名", 4)
                                                                    ), 4)
                                                                ), 4)
                                                            ))
                                                        ), 4),
                                                        createElementVNode("view", utsMapOf("class" to "summary-item", "style" to normalizeStyle(utsMapOf("margin-left" to "130rpx", "flex-direction" to "row"))), utsArrayOf(
                                                            createElementVNode("image", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "60rpx", "height" to "60rpx")), "src" to "/static/icons/icon-month-data-order.png"), null, 4),
                                                            createElementVNode("view", utsMapOf("class" to "ml-5"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "item-label", "style" to normalizeStyle(utsMapOf("font-size" to "26rpx", "font-weight" to "bold"))), "完单量/投诉量", 4),
                                                                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex-direction" to "row", "align-items" to "center"))), utsArrayOf(
                                                                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex-direction" to "row"))), utsArrayOf(
                                                                        createElementVNode("text", utsMapOf("class" to "item-value", "style" to normalizeStyle(utsMapOf("font-size" to "34rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), toDisplayString(unref(summaryData).completeOrderCount) + "/", 5),
                                                                        createElementVNode("text", utsMapOf("class" to "item-value", "style" to normalizeStyle(utsMapOf("font-size" to "34rpx", "font-weight" to "bold", "color" to "red"))), toDisplayString(unref(summaryData).complainCount), 5)
                                                                    ), 4),
                                                                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("margin-top" to "7rpx"))), utsArrayOf(
                                                                        createElementVNode("text", utsMapOf("class" to "item-value", "style" to normalizeStyle(utsMapOf("font-size" to "20rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), "单", 4)
                                                                    ), 4)
                                                                ), 4)
                                                            ))
                                                        ), 4)
                                                    ), 4),
                                                    createElementVNode("view", utsMapOf("class" to "summary-row", "style" to normalizeStyle(utsMapOf("flex-direction" to "row", "width" to "100%", "background-color" to "transparent"))), utsArrayOf(
                                                        createElementVNode("view", utsMapOf("class" to "summary-item", "style" to normalizeStyle(utsMapOf("flex-direction" to "row"))), utsArrayOf(
                                                            createElementVNode("image", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "60rpx", "height" to "60rpx")), "src" to "/static/icons/icon-month-data-order.png"), null, 4),
                                                            createElementVNode("view", utsMapOf("class" to "ml-5"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "item-label", "style" to normalizeStyle(utsMapOf("font-size" to "26rpx", "font-weight" to "bold"))), "出车天数", 4),
                                                                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex-direction" to "row", "align-items" to "center"))), utsArrayOf(
                                                                    createElementVNode("view", null, utsArrayOf(
                                                                        createElementVNode("text", utsMapOf("class" to "item-value", "style" to normalizeStyle(utsMapOf("font-size" to "34rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), toDisplayString(unref(summaryData).outCarDays), 5)
                                                                    )),
                                                                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("margin-top" to "7rpx"))), utsArrayOf(
                                                                        createElementVNode("text", utsMapOf("class" to "item-value", "style" to normalizeStyle(utsMapOf("font-size" to "20rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), "天", 4)
                                                                    ), 4)
                                                                ), 4)
                                                            ))
                                                        ), 4),
                                                        createElementVNode("view", utsMapOf("class" to "summary-item", "style" to normalizeStyle(utsMapOf("margin-left" to "130rpx", "flex-direction" to "row"))), utsArrayOf(
                                                            createElementVNode("image", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "60rpx", "height" to "60rpx")), "src" to "/static/icons/icon-month-data-order.png"), null, 4),
                                                            createElementVNode("view", utsMapOf("class" to "ml-5"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "item-label", "style" to normalizeStyle(utsMapOf("font-size" to "26rpx", "font-weight" to "bold"))), "班次", 4),
                                                                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex-direction" to "row", "align-items" to "center"))), utsArrayOf(
                                                                    createElementVNode("view", null, utsArrayOf(
                                                                        createElementVNode("text", utsMapOf("class" to "item-value", "style" to normalizeStyle(utsMapOf("font-size" to "34rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), toDisplayString(unref(summaryData).tripCount), 5)
                                                                    ))
                                                                ), 4)
                                                            ))
                                                        ), 4)
                                                    ), 4),
                                                    createVNode(_component_x_divider, utsMapOf("lineWidth" to "0.5", "color" to "#BECEEC")),
                                                    createElementVNode("view", utsMapOf("class" to "summary-row", "style" to normalizeStyle(utsMapOf("background-color" to "transparent", "flex-direction" to "row", "justify-content" to "space-between"))), utsArrayOf(
                                                        createElementVNode("view", utsMapOf("class" to "summary-item", "style" to normalizeStyle(utsMapOf("flex-direction" to "column"))), utsArrayOf(
                                                            createElementVNode("text", utsMapOf("class" to "item-label", "style" to normalizeStyle(utsMapOf("text-align" to "center", "font-size" to "26rpx", "font-weight" to "bold"))), "营业流水", 4),
                                                            createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex-direction" to "row", "align-items" to "center", "justify-content" to "center"))), utsArrayOf(
                                                                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("align-items" to "center"))), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "item-value", "style" to normalizeStyle(utsMapOf("font-size" to "34rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), toDisplayString(unref(summaryData).revenueAmount), 5)
                                                                ), 4),
                                                                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("margin-top" to "7rpx"))), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "item-value", "style" to normalizeStyle(utsMapOf("font-size" to "20rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), "元", 4)
                                                                ), 4)
                                                            ), 4)
                                                        ), 4),
                                                        createElementVNode("view", utsMapOf("class" to "summary-item", "style" to normalizeStyle(utsMapOf("flex-direction" to "column"))), utsArrayOf(
                                                            createElementVNode("text", utsMapOf("class" to "item-label", "style" to normalizeStyle(utsMapOf("text-align" to "center", "font-size" to "26rpx", "font-weight" to "bold"))), "实际收入", 4),
                                                            createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex-direction" to "row", "align-items" to "center", "justify-content" to "center"))), utsArrayOf(
                                                                createElementVNode("view", null, utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "item-value", "style" to normalizeStyle(utsMapOf("text-align" to "center", "font-size" to "34rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), toDisplayString(unref(summaryData).realTotalIncome), 5)
                                                                )),
                                                                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("margin-top" to "7rpx"))), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "item-value", "style" to normalizeStyle(utsMapOf("text-align" to "center", "font-size" to "20rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), "元", 4)
                                                                ), 4)
                                                            ), 4),
                                                            createElementVNode("view", utsMapOf("class" to "footer-triangle", "style" to normalizeStyle(utsMapOf("text-align" to "center", "margin-left" to "17rpx"))), null, 4)
                                                        ), 4),
                                                        createElementVNode("view", utsMapOf("class" to "summary-item", "style" to normalizeStyle(utsMapOf("flex-direction" to "column"))), utsArrayOf(
                                                            createElementVNode("text", utsMapOf("class" to "item-label", "style" to normalizeStyle(utsMapOf("text-align" to "center", "font-size" to "26rpx", "font-weight" to "bold"))), "活动奖励", 4),
                                                            createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex-direction" to "row", "align-items" to "center", "justify-content" to "center"))), utsArrayOf(
                                                                createElementVNode("view", null, utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "item-value", "style" to normalizeStyle(utsMapOf("font-size" to "34rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), toDisplayString(unref(summaryData).activityReward), 5)
                                                                )),
                                                                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("margin-top" to "7rpx"))), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "item-value", "style" to normalizeStyle(utsMapOf("font-size" to "20rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), "元", 4)
                                                                ), 4)
                                                            ), 4)
                                                        ), 4)
                                                    ), 4),
                                                    createElementVNode("view", utsMapOf("class" to "summary-footer", "style" to normalizeStyle(utsMapOf("height" to "70rpx", "margin-top" to "-30rpx"))), utsArrayOf(
                                                        createElementVNode("view", utsMapOf("class" to "footer-item", "style" to normalizeStyle(utsMapOf("flex-direction" to "row", "justify-content" to "center"))), utsArrayOf(
                                                            createElementVNode("text", utsMapOf("class" to "footer-value"), "完单收益 " + toDisplayString(" " + unref(summaryData).realCompleteOrderIncome) + "元 + 违约金收益 " + toDisplayString(" " + unref(summaryData).realDefaultOrderIncome) + "元", 1)
                                                        ), 4)
                                                    ), 4)
                                                ), 4)
                                            )
                                        }
                                        ), "_" to 1), 8, utsArrayOf(
                                            "style"
                                        ))
                                    ), 4)
                                ), 4),
                                createElementVNode("view", utsMapOf("class" to "data-item", "style" to normalizeStyle("width: " + (unref(screenWidth) + 150) + "px; ")), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "data-item-header"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "header-left"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "lines")),
                                            createElementVNode("text", utsMapOf("class" to "text"), "实际收入")
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "data-item-body"), utsArrayOf(
                                        createVNode(_component_x_sheet, utsMapOf("dark-color" to "#dcdcdc", "height" to "400rpx", "style" to normalizeStyle(utsMapOf("width" to "100%"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createVNode(_component_x_echart, utsMapOf("onInit" to oninit, "opts" to unref(incomeOpts)), null, 8, utsArrayOf(
                                                    "opts"
                                                ))
                                            )
                                        }
                                        ), "_" to 1), 8, utsArrayOf(
                                            "style"
                                        ))
                                    ))
                                ), 4),
                                createElementVNode("view", utsMapOf("class" to "data-item", "style" to normalizeStyle("width: " + (unref(screenWidth) + 150) + "px;")), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "data-item-header"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "header-left"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "lines")),
                                            createElementVNode("text", utsMapOf("class" to "text"), "完单数量")
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "data-item-body"), utsArrayOf(
                                        createVNode(_component_x_sheet, utsMapOf("dark-color" to "#dcdcdc", "height" to "400rpx", "style" to normalizeStyle(utsMapOf("width" to "100%"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createVNode(_component_x_echart, utsMapOf("onInit" to oninit, "opts" to unref(completeOrderOpts)), null, 8, utsArrayOf(
                                                    "opts"
                                                ))
                                            )
                                        }
                                        ), "_" to 1), 8, utsArrayOf(
                                            "style"
                                        ))
                                    ))
                                ), 4)
                            ))
                        ), 4)
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
                return utsMapOf("container" to padStyleMapOf(utsMapOf("width" to "100%", "position" to "relative", "paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "marginTop" to 20, "height" to "100%", "flexDirection" to "column", "alignItems" to "center")), "home-bg" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1, "overflow" to "hidden", "height" to "100%")), "bg-image" to utsMapOf(".home-bg " to utsMapOf("width" to "100%", "height" to "100%", "position" to "absolute", "top" to 0, "left" to 0)), "date-picker-container" to padStyleMapOf(utsMapOf("marginTop" to "50rpx", "marginBottom" to "30rpx", "width" to "690rpx", "borderTopLeftRadius" to "31rpx", "borderTopRightRadius" to "31rpx", "borderBottomRightRadius" to "31rpx", "borderBottomLeftRadius" to "31rpx", "backgroundColor" to "#809BD0")), "date-picker-content" to utsMapOf(".date-picker-container " to utsMapOf("flexDirection" to "row", "alignItems" to "center", "flexWrap" to "wrap", "justifyContent" to "space-between", "backgroundColor" to "rgba(255,255,255,0.1)", "borderTopLeftRadius" to "8rpx", "borderTopRightRadius" to "8rpx", "borderBottomRightRadius" to "8rpx", "borderBottomLeftRadius" to "8rpx", "paddingTop" to "15rpx", "paddingRight" to "20rpx", "paddingBottom" to "15rpx", "paddingLeft" to "20rpx")), "date-text" to utsMapOf(".date-picker-container .date-picker-content " to utsMapOf("color" to "#F5F7FA", "fontSize" to "32rpx", "fontWeight" to "bold")), "date-icon" to utsMapOf(".date-picker-container .date-picker-content " to utsMapOf("width" to "32rpx", "height" to "32rpx", "marginLeft" to "20rpx")), "top-bg" to utsMapOf(".summary-body " to utsMapOf("position" to "absolute", "height" to "90%", "zIndex" to -100, "width" to "100%", "top" to 0, "left" to 0, "backgroundImage" to "linear-gradient(to bottom, #FFFFFF, #D4E2FC)")), "summary-row" to padStyleMapOf(utsMapOf("paddingTop" to "30rpx", "paddingRight" to "40rpx", "paddingBottom" to "30rpx", "paddingLeft" to "40rpx", "marginTop" to 0, "marginRight" to "40rpx", "marginBottom" to 0, "marginLeft" to "40rpx", "backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "16rpx", "borderTopRightRadius" to "16rpx", "borderBottomRightRadius" to "16rpx", "borderBottomLeftRadius" to "16rpx")), "summary-footer" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "80rpx", "backgroundColor" to "#85A5E4", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "borderBottomLeftRadius" to "16rpx", "borderBottomRightRadius" to "16rpx")), "footer-item" to utsMapOf(".summary-footer " to utsMapOf("flexDirection" to "column", "alignItems" to "center", "marginBottom" to "5rpx")), "footer-label" to utsMapOf(".summary-footer .footer-item " to utsMapOf("fontSize" to "26rpx", "color" to "rgba(255,255,255,0.7)", "marginBottom" to "4rpx")), "footer-value" to utsMapOf(".summary-footer .footer-item " to utsMapOf("fontSize" to "28rpx", "color" to "rgba(255,255,255,0.7)", "fontWeight" to "bold")), "footer-triangle" to padStyleMapOf(utsMapOf("width" to 0, "height" to 0, "borderLeftWidth" to "33rpx", "borderLeftStyle" to "solid", "borderLeftColor" to "rgba(0,0,0,0)", "borderRightWidth" to "33rpx", "borderRightStyle" to "solid", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomWidth" to "33rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#85A5E4")), "data-list" to padStyleMapOf(utsMapOf("marginTop" to "20rpx", "width" to "100%", "flex" to 1)), "data-item" to utsMapOf(".data-list " to utsMapOf("width" to "100%", "marginBottom" to "35rpx", "marginLeft" to "13.5rpx")), "data-item-header" to utsMapOf(".data-list .data-item " to utsMapOf("width" to "100%", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "marginBottom" to "19rpx")), "header-left" to utsMapOf(".data-list .data-item .data-item-header " to utsMapOf("flexDirection" to "row", "alignItems" to "center")), "lines" to utsMapOf(".data-list .data-item .data-item-header .header-left " to utsMapOf("width" to "8rpx", "height" to "37rpx", "backgroundImage" to "none", "backgroundColor" to "#F5F7FA", "borderTopLeftRadius" to "4rpx", "borderTopRightRadius" to "4rpx", "borderBottomRightRadius" to "4rpx", "borderBottomLeftRadius" to "4rpx")), "text" to utsMapOf(".data-list .data-item .data-item-header .header-left " to utsMapOf("fontSize" to "36rpx", "color" to "#F5F7FA", "marginLeft" to "22rpx", "fontWeight" to "bold")), "data-item-body" to utsMapOf(".data-list .data-item " to utsMapOf("width" to "700rpx", "height" to "400rpx", "borderTopLeftRadius" to "16rpx", "borderTopRightRadius" to "16rpx", "borderBottomRightRadius" to "16rpx", "borderBottomLeftRadius" to "16rpx", "overflow" to "hidden")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
