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
open class GenPagesPersonalMonthsDataIndex : BasePage {
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
                    var series = _uA(
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
                                    var colorStops = _uA(
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
            val incomeOptData = OptionsData(colorStr = "rgba(54, 153, 255, 1)", gradientColor = "rgba(54, 153, 255, 0)", xAxisDataVal = _uA(), seriesData = _uA())
            val incomeOpts = ref<String>(JSON.stringify(initOpts(incomeOptData, "income")))
            val completeOrderOptData = OptionsData(colorStr = "rgba(93, 166, 83, 1)", gradientColor = "rgba(93, 166, 83, 0)", xAxisDataVal = _uA(), seriesData = _uA())
            val completeOrderOpts = ref<String>(JSON.stringify(initOpts(completeOrderOptData, "ordernum")))
            val querySummaryData = fun(){
                console.log("querySummaryData===", currentDate.value)
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
                getDriverIncomeLineChart(currentDate.value).then(fun(res: Response){
                    val xAxisDataVal: UTSArray<String> = _uA()
                    val seriesData: UTSArray<Number> = _uA()
                    val resData = res.data as UTSArray<UTSJSONObject>
                    resData.forEach(fun(item){
                        val name = item.getString("name")
                        val value = item.getString("value")
                        xAxisDataVal.push(if (name != null && name != "") {
                            name
                        } else {
                            ""
                        }
                        )
                        seriesData.push(if (value != null) {
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
                    val xAxisDataVal: UTSArray<String> = _uA()
                    val seriesData: UTSArray<Number> = _uA()
                    val resData = res.data as UTSArray<UTSJSONObject>
                    resData.forEach(fun(item){
                        val name = item.getString("name")
                        val value = item.getString("value")
                        xAxisDataVal.push(if (name != null && name != "") {
                            name
                        } else {
                            ""
                        }
                        )
                        seriesData.push(if (value != null) {
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
                return _cV(_component_mc_base_container, _uM("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to true, "title" to "月度数据", "title-color" to "#ffffff"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("style" to _nS("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        _cE("view", _uM("class" to "home-bg", "height" to ("" + (unref(screenHeight) + unref(statusBarHeight) + unref(globalData).safeAreaBottom + 20 + 100) + "px")), _uA(
                            _cE("image", _uM("class" to "bg-image", "style" to _nS(_uM("position" to "absolute", "pointer-events" to "none")), "fadeShow" to true, "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-order-detail-back.png")), null, 12, _uA(
                                "src"
                            ))
                        ), 8, _uA(
                            "height"
                        )),
                        _cE("view", _uM("class" to "container", "style" to _nS("height: " + (unref(screenHeight) + unref(statusBarHeight) + unref(globalData).safeAreaBottom + 100) + "px;")), _uA(
                            _cE("view", _uM("class" to "date-picker-container"), _uA(
                                _cV(_component_mc_date_picker_selector, _uM("modelValue" to unref(currentDate), "onUpdate:modelValue" to fun(`$event`: String){
                                    trySetRefValue(currentDate, `$event`)
                                }
                                , "onChange" to fun(){
                                    queryAllData()
                                }
                                ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", _uM("class" to "date-picker-content"), _uA(
                                            _cE("text", _uM("class" to "date-text"), _tD(if (unref(currentDate) != "") {
                                                unref(currentDate)
                                            } else {
                                                "选择月份"
                                            }
                                            ), 1),
                                            _cE("image", _uM("class" to "date-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-date.png")), null, 8, _uA(
                                                "src"
                                            ))
                                        ))
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "modelValue",
                                    "onChange"
                                ))
                            )),
                            _cE("view", _uM("class" to "data-list"), _uA(
                                _cE("view", _uM("class" to "data-item", "style" to _nS("width: " + (unref(screenWidth) + 150) + "px;")), _uA(
                                    _cE("view", _uM("class" to "data-item-header"), _uA(
                                        _cE("view", _uM("class" to "header-left"), _uA(
                                            _cE("view", _uM("class" to "lines")),
                                            _cE("text", _uM("class" to "text"), "月度数据汇总")
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "data-item-body", "style" to _nS(_uM("height" to "490rpx", "flex-direction" to "column"))), _uA(
                                        _cV(_component_x_sheet, _uM("dark-color" to "#dcdcdc", "style" to _nS(_uM("height" to "100%", "width" to "100%")), "padding" to _uA(
                                            "0",
                                            "10"
                                        )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "summary-body", "style" to _nS(_uM("height" to "490rpx", "flex-direction" to "column", "z-index" to "1", "width" to "100%"))), _uA(
                                                    _cE("view", _uM("class" to "top-bg", "style" to _nS(_uM("width" to "100%"))), null, 4),
                                                    _cE("view", _uM("class" to "summary-row", "style" to _nS(_uM("flex-direction" to "row", "width" to "100%", "background-color" to "transparent"))), _uA(
                                                        _cE("view", _uM("class" to "summary-item", "style" to _nS(_uM("flex-direction" to "row"))), _uA(
                                                            _cE("image", _uM("style" to _nS(_uM("width" to "60rpx", "height" to "60rpx")), "src" to "/static/icons/icon-month-data-rank.png"), null, 4),
                                                            _cE("view", _uM("class" to "ml-5"), _uA(
                                                                _cE("text", _uM("class" to "item-label", "style" to _nS(_uM("font-size" to "26rpx", "font-weight" to "bold"))), "单量排行", 4),
                                                                _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "align-items" to "center"))), _uA(
                                                                    _cE("view", null, _uA(
                                                                        _cE("text", _uM("class" to "item-value", "style" to _nS(_uM("font-size" to "34rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), _tD(if (unref(summaryData).orderRankNumber < 1) {
                                                                            "-"
                                                                        } else {
                                                                            unref(summaryData).orderRankNumber
                                                                        }
                                                                        ), 5)
                                                                    )),
                                                                    _cE("view", _uM("style" to _nS(_uM("margin-top" to "7rpx"))), _uA(
                                                                        _cE("text", _uM("class" to "item-value", "style" to _nS(_uM("font-size" to "20rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), "名", 4)
                                                                    ), 4)
                                                                ), 4)
                                                            ))
                                                        ), 4),
                                                        _cE("view", _uM("class" to "summary-item", "style" to _nS(_uM("margin-left" to "130rpx", "flex-direction" to "row"))), _uA(
                                                            _cE("image", _uM("style" to _nS(_uM("width" to "60rpx", "height" to "60rpx")), "src" to "/static/icons/icon-month-data-order.png"), null, 4),
                                                            _cE("view", _uM("class" to "ml-5"), _uA(
                                                                _cE("text", _uM("class" to "item-label", "style" to _nS(_uM("font-size" to "26rpx", "font-weight" to "bold"))), "完单量/投诉量", 4),
                                                                _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "align-items" to "center"))), _uA(
                                                                    _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row"))), _uA(
                                                                        _cE("text", _uM("class" to "item-value", "style" to _nS(_uM("font-size" to "34rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), _tD(unref(summaryData).completeOrderCount) + "/", 5),
                                                                        _cE("text", _uM("class" to "item-value", "style" to _nS(_uM("font-size" to "34rpx", "font-weight" to "bold", "color" to "red"))), _tD(unref(summaryData).complainCount), 5)
                                                                    ), 4),
                                                                    _cE("view", _uM("style" to _nS(_uM("margin-top" to "7rpx"))), _uA(
                                                                        _cE("text", _uM("class" to "item-value", "style" to _nS(_uM("font-size" to "20rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), "单", 4)
                                                                    ), 4)
                                                                ), 4)
                                                            ))
                                                        ), 4)
                                                    ), 4),
                                                    _cE("view", _uM("class" to "summary-row", "style" to _nS(_uM("flex-direction" to "row", "width" to "100%", "background-color" to "transparent"))), _uA(
                                                        _cE("view", _uM("class" to "summary-item", "style" to _nS(_uM("flex-direction" to "row"))), _uA(
                                                            _cE("image", _uM("style" to _nS(_uM("width" to "60rpx", "height" to "60rpx")), "src" to "/static/icons/icon-month-data-order.png"), null, 4),
                                                            _cE("view", _uM("class" to "ml-5"), _uA(
                                                                _cE("text", _uM("class" to "item-label", "style" to _nS(_uM("font-size" to "26rpx", "font-weight" to "bold"))), "出车天数", 4),
                                                                _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "align-items" to "center"))), _uA(
                                                                    _cE("view", null, _uA(
                                                                        _cE("text", _uM("class" to "item-value", "style" to _nS(_uM("font-size" to "34rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), _tD(unref(summaryData).outCarDays), 5)
                                                                    )),
                                                                    _cE("view", _uM("style" to _nS(_uM("margin-top" to "7rpx"))), _uA(
                                                                        _cE("text", _uM("class" to "item-value", "style" to _nS(_uM("font-size" to "20rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), "天", 4)
                                                                    ), 4)
                                                                ), 4)
                                                            ))
                                                        ), 4),
                                                        _cE("view", _uM("class" to "summary-item", "style" to _nS(_uM("margin-left" to "130rpx", "flex-direction" to "row"))), _uA(
                                                            _cE("image", _uM("style" to _nS(_uM("width" to "60rpx", "height" to "60rpx")), "src" to "/static/icons/icon-month-data-order.png"), null, 4),
                                                            _cE("view", _uM("class" to "ml-5"), _uA(
                                                                _cE("text", _uM("class" to "item-label", "style" to _nS(_uM("font-size" to "26rpx", "font-weight" to "bold"))), "班次", 4),
                                                                _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "align-items" to "center"))), _uA(
                                                                    _cE("view", null, _uA(
                                                                        _cE("text", _uM("class" to "item-value", "style" to _nS(_uM("font-size" to "34rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), _tD(unref(summaryData).tripCount), 5)
                                                                    ))
                                                                ), 4)
                                                            ))
                                                        ), 4)
                                                    ), 4),
                                                    _cV(_component_x_divider, _uM("lineWidth" to "0.5", "color" to "#BECEEC")),
                                                    _cE("view", _uM("class" to "summary-row", "style" to _nS(_uM("background-color" to "transparent", "flex-direction" to "row", "justify-content" to "space-between"))), _uA(
                                                        _cE("view", _uM("class" to "summary-item", "style" to _nS(_uM("flex-direction" to "column"))), _uA(
                                                            _cE("text", _uM("class" to "item-label", "style" to _nS(_uM("text-align" to "center", "font-size" to "26rpx", "font-weight" to "bold"))), "营业流水", 4),
                                                            _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "align-items" to "center", "justify-content" to "center"))), _uA(
                                                                _cE("view", _uM("style" to _nS(_uM("align-items" to "center"))), _uA(
                                                                    _cE("text", _uM("class" to "item-value", "style" to _nS(_uM("font-size" to "34rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), _tD(unref(summaryData).revenueAmount), 5)
                                                                ), 4),
                                                                _cE("view", _uM("style" to _nS(_uM("margin-top" to "7rpx"))), _uA(
                                                                    _cE("text", _uM("class" to "item-value", "style" to _nS(_uM("font-size" to "20rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), "元", 4)
                                                                ), 4)
                                                            ), 4)
                                                        ), 4),
                                                        _cE("view", _uM("class" to "summary-item", "style" to _nS(_uM("flex-direction" to "column"))), _uA(
                                                            _cE("text", _uM("class" to "item-label", "style" to _nS(_uM("text-align" to "center", "font-size" to "26rpx", "font-weight" to "bold"))), "实际收入", 4),
                                                            _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "align-items" to "center", "justify-content" to "center"))), _uA(
                                                                _cE("view", null, _uA(
                                                                    _cE("text", _uM("class" to "item-value", "style" to _nS(_uM("text-align" to "center", "font-size" to "34rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), _tD(unref(summaryData).realTotalIncome), 5)
                                                                )),
                                                                _cE("view", _uM("style" to _nS(_uM("margin-top" to "7rpx"))), _uA(
                                                                    _cE("text", _uM("class" to "item-value", "style" to _nS(_uM("text-align" to "center", "font-size" to "20rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), "元", 4)
                                                                ), 4)
                                                            ), 4),
                                                            _cE("view", _uM("class" to "footer-triangle", "style" to _nS(_uM("text-align" to "center", "margin-left" to "17rpx"))), null, 4)
                                                        ), 4),
                                                        _cE("view", _uM("class" to "summary-item", "style" to _nS(_uM("flex-direction" to "column"))), _uA(
                                                            _cE("text", _uM("class" to "item-label", "style" to _nS(_uM("text-align" to "center", "font-size" to "26rpx", "font-weight" to "bold"))), "活动奖励", 4),
                                                            _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "align-items" to "center", "justify-content" to "center"))), _uA(
                                                                _cE("view", null, _uA(
                                                                    _cE("text", _uM("class" to "item-value", "style" to _nS(_uM("font-size" to "34rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), _tD(unref(summaryData).activityReward), 5)
                                                                )),
                                                                _cE("view", _uM("style" to _nS(_uM("margin-top" to "7rpx"))), _uA(
                                                                    _cE("text", _uM("class" to "item-value", "style" to _nS(_uM("font-size" to "20rpx", "font-weight" to "bold", "color" to "#5D7AB6"))), "元", 4)
                                                                ), 4)
                                                            ), 4)
                                                        ), 4)
                                                    ), 4),
                                                    _cE("view", _uM("class" to "summary-footer", "style" to _nS(_uM("height" to "70rpx", "margin-top" to "-30rpx"))), _uA(
                                                        _cE("view", _uM("class" to "footer-item", "style" to _nS(_uM("flex-direction" to "row", "justify-content" to "center"))), _uA(
                                                            _cE("text", _uM("class" to "footer-value"), "完单收益 " + _tD(" " + unref(summaryData).realCompleteOrderIncome) + "元 + 违约金收益 " + _tD(" " + unref(summaryData).realDefaultOrderIncome) + "元", 1)
                                                        ), 4)
                                                    ), 4)
                                                ), 4)
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "style"
                                        ))
                                    ), 4)
                                ), 4),
                                _cE("view", _uM("class" to "data-item", "style" to _nS("width: " + (unref(screenWidth) + 150) + "px; ")), _uA(
                                    _cE("view", _uM("class" to "data-item-header"), _uA(
                                        _cE("view", _uM("class" to "header-left"), _uA(
                                            _cE("view", _uM("class" to "lines")),
                                            _cE("text", _uM("class" to "text"), "实际收入")
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "data-item-body"), _uA(
                                        _cV(_component_x_sheet, _uM("dark-color" to "#dcdcdc", "height" to "400rpx", "style" to _nS(_uM("width" to "100%"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cV(_component_x_echart, _uM("onInit" to oninit, "opts" to unref(incomeOpts)), null, 8, _uA(
                                                    "opts"
                                                ))
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "style"
                                        ))
                                    ))
                                ), 4),
                                _cE("view", _uM("class" to "data-item", "style" to _nS("width: " + (unref(screenWidth) + 150) + "px;")), _uA(
                                    _cE("view", _uM("class" to "data-item-header"), _uA(
                                        _cE("view", _uM("class" to "header-left"), _uA(
                                            _cE("view", _uM("class" to "lines")),
                                            _cE("text", _uM("class" to "text"), "完单数量")
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "data-item-body"), _uA(
                                        _cV(_component_x_sheet, _uM("dark-color" to "#dcdcdc", "height" to "400rpx", "style" to _nS(_uM("width" to "100%"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cV(_component_x_echart, _uM("onInit" to oninit, "opts" to unref(completeOrderOpts)), null, 8, _uA(
                                                    "opts"
                                                ))
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
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
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("container" to _pS(_uM("width" to "100%", "position" to "relative", "paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "marginTop" to 20, "height" to "100%", "flexDirection" to "column", "alignItems" to "center")), "home-bg" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1, "overflow" to "hidden", "height" to "100%")), "bg-image" to _uM(".home-bg " to _uM("width" to "100%", "height" to "100%", "position" to "absolute", "top" to 0, "left" to 0)), "date-picker-container" to _pS(_uM("marginTop" to "50rpx", "marginBottom" to "30rpx", "width" to "690rpx", "borderTopLeftRadius" to "31rpx", "borderTopRightRadius" to "31rpx", "borderBottomRightRadius" to "31rpx", "borderBottomLeftRadius" to "31rpx", "backgroundColor" to "#809BD0")), "date-picker-content" to _uM(".date-picker-container " to _uM("flexDirection" to "row", "alignItems" to "center", "flexWrap" to "wrap", "justifyContent" to "space-between", "backgroundColor" to "rgba(255,255,255,0.1)", "borderTopLeftRadius" to "8rpx", "borderTopRightRadius" to "8rpx", "borderBottomRightRadius" to "8rpx", "borderBottomLeftRadius" to "8rpx", "paddingTop" to "15rpx", "paddingRight" to "20rpx", "paddingBottom" to "15rpx", "paddingLeft" to "20rpx")), "date-text" to _uM(".date-picker-container .date-picker-content " to _uM("color" to "#F5F7FA", "fontSize" to "32rpx", "fontWeight" to "bold")), "date-icon" to _uM(".date-picker-container .date-picker-content " to _uM("width" to "32rpx", "height" to "32rpx", "marginLeft" to "20rpx")), "top-bg" to _uM(".summary-body " to _uM("position" to "absolute", "height" to "90%", "zIndex" to -100, "width" to "100%", "top" to 0, "left" to 0, "backgroundImage" to "linear-gradient(to bottom, #FFFFFF, #D4E2FC)")), "summary-row" to _pS(_uM("paddingTop" to "30rpx", "paddingRight" to "40rpx", "paddingBottom" to "30rpx", "paddingLeft" to "40rpx", "marginTop" to 0, "marginRight" to "40rpx", "marginBottom" to 0, "marginLeft" to "40rpx", "backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "16rpx", "borderTopRightRadius" to "16rpx", "borderBottomRightRadius" to "16rpx", "borderBottomLeftRadius" to "16rpx")), "summary-footer" to _pS(_uM("width" to "100%", "height" to "80rpx", "backgroundColor" to "#85A5E4", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "borderBottomLeftRadius" to "16rpx", "borderBottomRightRadius" to "16rpx")), "footer-item" to _uM(".summary-footer " to _uM("flexDirection" to "column", "alignItems" to "center", "marginBottom" to "5rpx")), "footer-label" to _uM(".summary-footer .footer-item " to _uM("fontSize" to "26rpx", "color" to "rgba(255,255,255,0.7)", "marginBottom" to "4rpx")), "footer-value" to _uM(".summary-footer .footer-item " to _uM("fontSize" to "28rpx", "color" to "rgba(255,255,255,0.7)", "fontWeight" to "bold")), "footer-triangle" to _pS(_uM("width" to 0, "height" to 0, "borderLeftWidth" to "33rpx", "borderLeftStyle" to "solid", "borderLeftColor" to "rgba(0,0,0,0)", "borderRightWidth" to "33rpx", "borderRightStyle" to "solid", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomWidth" to "33rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#85A5E4")), "data-list" to _pS(_uM("marginTop" to "20rpx", "width" to "100%", "flex" to 1)), "data-item" to _uM(".data-list " to _uM("width" to "100%", "marginBottom" to "35rpx", "marginLeft" to "13.5rpx")), "data-item-header" to _uM(".data-list .data-item " to _uM("width" to "100%", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "marginBottom" to "19rpx")), "header-left" to _uM(".data-list .data-item .data-item-header " to _uM("flexDirection" to "row", "alignItems" to "center")), "lines" to _uM(".data-list .data-item .data-item-header .header-left " to _uM("width" to "8rpx", "height" to "37rpx", "backgroundImage" to "none", "backgroundColor" to "#F5F7FA", "borderTopLeftRadius" to "4rpx", "borderTopRightRadius" to "4rpx", "borderBottomRightRadius" to "4rpx", "borderBottomLeftRadius" to "4rpx")), "text" to _uM(".data-list .data-item .data-item-header .header-left " to _uM("fontSize" to "36rpx", "color" to "#F5F7FA", "marginLeft" to "22rpx", "fontWeight" to "bold")), "data-item-body" to _uM(".data-list .data-item " to _uM("width" to "700rpx", "height" to "400rpx", "borderTopLeftRadius" to "16rpx", "borderTopRightRadius" to "16rpx", "borderBottomRightRadius" to "16rpx", "borderBottomLeftRadius" to "16rpx", "overflow" to "hidden")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
