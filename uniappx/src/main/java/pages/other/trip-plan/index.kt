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
open class GenPagesOtherTripPlanIndex : BasePage {
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
        var setup: (__props: GenPagesOtherTripPlanIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherTripPlanIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val router = uni_useKuxRouter()
            val isfresh = ref<Boolean>(false)
            val bottomFresh = ref<Boolean>(false)
            var scrollDirection = "down"
            val serviceLinesDistrictToCityList = ref(utsArrayOf<TripPlanInfo>())
            val showTopDate = ref(false)
            val date = ref<DateItem>(DateItem(dayOfWeek = "周五", monthDay = "04-21", date = "2025-04-21"))
            val dateList = ref(utsArrayOf<DateItem>())
            val toQueryLinesDistrictToCityList = fun(date: String){
                getServiceLinesDistrictToCityList(date).then(fun(res: Response){
                    serviceLinesDistrictToCityList.value = JSON.parseArray<TripPlanInfo>(JSON.stringify(res.data)) ?: utsArrayOf()
                    if (scrollDirection == "down") {
                        isfresh.value = false
                    } else {
                        bottomFresh.value = false
                    }
                }
                )
            }
            val datePickerClick = fun(kVal: DateItem){
                val newDate = JSON.parseObject<DateItem>(JSON.stringify(kVal))
                if (newDate != null) {
                    date.value = newDate
                }
                toQueryLinesDistrictToCityList(newDate!!.date)
            }
            val datePickerModalClick = fun(){
                toQueryLinesDistrictToCityList(date.value.date)
            }
            val init = fun(){
                searchDriverPlanDateList().then(fun(res: Response){
                    val dateListTemp = JSON.parseArray<DateItem>(JSON.stringify(res.data)) ?: utsArrayOf()
                    if (dateListTemp.length > 0) {
                        dateList.value = JSON.parseArray<DateItem>(JSON.stringify(res.data)) ?: utsArrayOf()
                        val initDate = dateListTemp[0]
                        date.value = initDate
                        toQueryLinesDistrictToCityList(initDate.date)
                    }
                }
                )
            }
            val toShare = fun(item: TripPlanInfo){
                val itemId = item.id as Number
                val startDate = item.startDate as String
                val linesGroupName = item.linesGroupName
                val curDate = date.value.date
                val xcTime = curDate + " " + item.startTime
                router.push("/pages/other/scan-order/index?planId=" + itemId + "&date=" + curDate + "&linesGroupName=" + linesGroupName + "&xcTime=" + xcTime)
            }
            val topLoad = fun(){
                console.log("下拉刷新")
                scrollDirection = "down"
                toQueryLinesDistrictToCityList(date.value.date)
            }
            val bottomLoad = fun(){
                console.log("触底刷新")
                scrollDirection = "up"
                toQueryLinesDistrictToCityList(date.value.date)
            }
            val toDetail = fun(item: TripPlanInfo){
                router.push("/pages/other/trip-plan/add/index?id=" + item.id + "&date=" + date.value.date)
            }
            onReady(fun(){
                init()
            }
            )
            return fun(): Any? {
                val _component_mc_date_picker = resolveEasyComponent("mc-date-picker", GenComponentsMcDatePickerIndexClass)
                val _component_mc_active_animation = resolveEasyComponent("mc-active-animation", GenComponentsMcActiveAnimationIndexClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_empty = resolveEasyComponent("x-empty", GenUniModulesTmxUiComponentsXEmptyXEmptyClass)
                val _component_x_pull_refresh = resolveEasyComponent("x-pull-refresh", GenUniModulesTmxUiComponentsXPullRefreshXPullRefreshClass)
                val _component_template = resolveComponent("template")
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createVNode(_component_mc_base_container, utsMapOf("title" to "行程计划", "showStatusBarPlaceholder" to false, "title-color" to "#ffffff", "navbar-is-place" to false, "staticTransparent" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "top-date-selector", "style" to normalizeStyle("padding-top: " + (unref(statusBarHeight) + 50) + "px;background-image: linear-gradient(to right, " + unref(globalData).theme.primaryLinearColors.join(",") + ");")), utsArrayOf(
                            createElementVNode("scroll-view", utsMapOf("show-scrollbar" to false, "direction" to "horizontal", "bounces" to false, "style" to normalizeStyle(utsArrayOf(
                                "width:" + (unref(screenWidth) - 60) + "px;",
                                utsMapOf("padding" to "20rpx")
                            )), "class" to "flex-row flex-row-center-start"), utsArrayOf(
                                createElementVNode(Fragment, null, RenderHelpers.renderList(unref(dateList), fun(item, __key, __index, _cached): Any {
                                    return createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                                        "date-item",
                                        utsMapOf("actived" to (unref(date).date == item.date))
                                    )), "onClick" to fun(){
                                        datePickerClick(item)
                                    }
                                        , "key" to item.date), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "week-name", "style" to normalizeStyle("" + (if (unref(date).date == item.date) {
                                            "color:" + unref(globalData).theme.primaryColor + ";"
                                        } else {
                                            ""
                                        }
                                                ))), toDisplayString(item.dayOfWeek), 5),
                                        createElementVNode("text", utsMapOf("class" to "date-value", "style" to normalizeStyle("" + (if (unref(date).date == item.date) {
                                            "color:" + unref(globalData).theme.primaryColor + ";"
                                        } else {
                                            ""
                                        }
                                                ))), toDisplayString(item.monthDay), 5)
                                    ), 10, utsArrayOf(
                                        "onClick"
                                    ))
                                }
                                ), 128)
                            ), 4),
                            createVNode(_component_mc_date_picker, utsMapOf("modelValue" to unref(date).date, "onUpdate:modelValue" to fun(`$event`: String){
                                unref(date).date = `$event`
                            }
                                , "end-date" to "2099-12-31", "onChange" to datePickerModalClick), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "more-date"), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "text"), "更多"),
                                        createElementVNode("text", utsMapOf("class" to "text"), "日期"),
                                        createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-white-line-samll.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                            "src"
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "modelValue",
                                "onUpdate:modelValue"
                            ))
                        ), 4),
                        createVNode(_component_template, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createVNode(_component_x_pull_refresh, utsMapOf("height" to ("" + (unref(screenHeight) - unref(statusBarHeight) - 210 - unref(globalData).safeAreaBottom) + "px"), "pullHeight" to 30, "disabled-bottom" to true, "show-scrollbar" to false, "modelValue" to unref(isfresh), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                    trySetRefValue(isfresh, `$event`)
                                }
                                    , "model-bottom-status" to unref(bottomFresh), "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                        trySetRefValue(bottomFresh, `$event`)
                                    }
                                    , "onRefresh" to topLoad, "onBottomRefresh" to bottomLoad), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode(Fragment, null, RenderHelpers.renderList(unref(serviceLinesDistrictToCityList), fun(item, index, __index, _cached): Any {
                                            return createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                                                "15",
                                                "15",
                                                "15",
                                                "0"
                                            ), "key" to index, "padding" to utsArrayOf(
                                                "0"
                                            ), "round" to utsArrayOf(
                                                "20rpx"
                                            )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("view", utsMapOf("class" to "setting-item"), utsArrayOf(
                                                        createElementVNode("view", utsMapOf("class" to "top-box"), utsArrayOf(
                                                            createElementVNode("view", utsMapOf("class" to "time"), utsArrayOf(
                                                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-clock-outline-small.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                                    "src"
                                                                )),
                                                                createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(item.startTime), 1)
                                                            ))
                                                        )),
                                                        createElementVNode("view", utsMapOf("class" to "route-info", "onClick" to fun(){
                                                            toDetail(item)
                                                        }
                                                        ), utsArrayOf(
                                                            createElementVNode("text", utsMapOf("class" to "start-address"), toDisplayString(item.startCityName), 1),
                                                            createElementVNode("view", utsMapOf("class" to "group-name"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "name", "style" to normalizeStyle("color: " + unref(globalData).theme.primaryColor + ";")), toDisplayString(item.linesGroupName), 5),
                                                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-trip-car-filled.png"), "mode" to "heightFix"), null, 8, utsArrayOf(
                                                                    "src"
                                                                ))
                                                            )),
                                                            createElementVNode("text", utsMapOf("class" to "end-address"), toDisplayString(item.endCityName), 1)
                                                        ), 8, utsArrayOf(
                                                            "onClick"
                                                        )),
                                                        createElementVNode("view", utsMapOf("class" to "btn-group"), utsArrayOf(
                                                            createVNode(_component_mc_active_animation, utsMapOf("class" to "btn border-r-1", "onClick" to fun(){
                                                                toShare(item)
                                                            }
                                                            ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return utsArrayOf(
                                                                    createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-share-outline.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                                        "src"
                                                                    )),
                                                                    createElementVNode("text", utsMapOf("class" to "text", "style" to normalizeStyle("color: " + unref(globalData).theme.primaryColor + ";")), "分享", 4)
                                                                )
                                                            }
                                                            ), "_" to 2), 1032, utsArrayOf(
                                                                "onClick"
                                                            ))
                                                        ))
                                                    ))
                                                )
                                            }
                                            ), "_" to 2), 1024)
                                        }
                                        ), 128),
                                        if (unref(serviceLinesDistrictToCityList).length <= 0) {
                                            createVNode(_component_x_empty, utsMapOf("key" to 0, "loading" to false, "empty" to true, "showBtn" to false))
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                    )
                                }
                                ), "_" to 1), 8, utsArrayOf(
                                    "height",
                                    "modelValue",
                                    "model-bottom-status"
                                ))
                            )
                        }
                        ), "_" to 1))
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
                return utsMapOf("top-date-selector" to padStyleMapOf(utsMapOf("position" to "relative", "flexDirection" to "row", "alignItems" to "center")), "date-item" to utsMapOf(".top-date-selector " to utsMapOf("alignItems" to "center", "justifyContent" to "center", "paddingTop" to "20rpx", "paddingRight" to "12rpx", "paddingBottom" to "20rpx", "paddingLeft" to "12rpx"), ".top-date-selector .actived" to utsMapOf("backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx")), "week-name" to utsMapOf(".top-date-selector .date-item " to utsMapOf("fontWeight" to "bold", "fontSize" to "24rpx", "color" to "#FFFFFF")), "date-value" to utsMapOf(".top-date-selector .date-item " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#FFFFFF"), ".top-date-selector .date-item .actived" to utsMapOf("color" to "#4F6A9F")), "more-date" to utsMapOf(".top-date-selector " to utsMapOf("paddingTop" to "10rpx", "paddingRight" to "25rpx", "paddingBottom" to "10rpx", "paddingLeft" to "25rpx", "alignItems" to "center", "boxShadow" to "-5rpx 0 1rpx 0 rgba(0, 0, 0, 0.1)")), "icon" to utsMapOf(".top-date-selector .more-date " to utsMapOf("width" to "16rpx", "height" to "10rpx"), ".setting-item .top-box .time " to utsMapOf("width" to "22rpx", "height" to "22rpx", "marginRight" to "10rpx"), ".setting-item .route-info .group-name " to utsMapOf("width" to "210rpx", "height" to "24rpx"), ".setting-item .btn-group .btn " to utsMapOf("width" to "30rpx", "height" to "32rpx")), "text" to utsMapOf(".top-date-selector .more-date " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#FFFFFF"), ".setting-item .btn-group .btn " to utsMapOf("paddingLeft" to "16rpx", "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#536FA5")), "top-box" to utsMapOf(".setting-item " to utsMapOf("paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "36rpx", "paddingLeft" to "20rpx")), "time" to utsMapOf(".setting-item .top-box " to utsMapOf("flexDirection" to "row", "alignItems" to "center")), "value" to utsMapOf(".setting-item .top-box .time " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000")), "route-info" to utsMapOf(".setting-item " to utsMapOf("marginTop" to 0, "marginRight" to "30rpx", "marginBottom" to 0, "marginLeft" to "30rpx", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "paddingBottom" to "30rpx", "borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#DADADA")), "start-address" to utsMapOf(".setting-item .route-info " to utsMapOf("fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000", "paddingRight" to "20rpx")), "end-address" to utsMapOf(".setting-item .route-info " to utsMapOf("fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000", "paddingLeft" to "20rpx")), "group-name" to utsMapOf(".setting-item .route-info " to utsMapOf("alignItems" to "center")), "name" to utsMapOf(".setting-item .route-info .group-name " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#5672AB", "paddingBottom" to "6rpx")), "btn-group" to utsMapOf(".setting-item " to utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to "25rpx", "paddingRight" to 0, "paddingBottom" to "25rpx", "paddingLeft" to 0)), "border-r-1" to utsMapOf(".setting-item .btn-group " to utsMapOf("borderRightWidth" to "1rpx", "borderRightStyle" to "solid", "borderRightColor" to "#DADADA")), "btn" to utsMapOf(".setting-item .btn-group " to utsMapOf("flex" to 1, "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "bottom-panel" to padStyleMapOf(utsMapOf("position" to "fixed", "left" to 0, "right" to 0, "paddingTop" to "30rpx", "paddingRight" to "30rpx", "paddingBottom" to "30rpx", "paddingLeft" to "30rpx", "flexDirection" to "row")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
