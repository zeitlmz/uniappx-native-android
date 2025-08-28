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
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import uts.sdk.modules.xModalS.showModal
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
            val allowDriverUpsertDriverPlan = ref(false)
            val isfresh = ref<Boolean>(false)
            val bottomFresh = ref<Boolean>(false)
            var scrollDirection = "down"
            val serviceLinesDistrictToCityList = ref(_uA<TripPlanInfo>())
            val showTopDate = ref(false)
            val date = ref<DateItem>(DateItem(dayOfWeek = "周五", monthDay = "04-21", date = "2025-04-21"))
            val dateList = ref(_uA<DateItem>())
            val toQueryLinesDistrictToCityList = fun(date: String){
                getServiceLinesDistrictToCityList(date).then(fun(res: Response){
                    serviceLinesDistrictToCityList.value = JSON.parseArray<TripPlanInfo>(JSON.stringify(res.data)) ?: _uA()
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
                    val dateListTemp = JSON.parseArray<DateItem>(JSON.stringify(res.data)) ?: _uA()
                    if (dateListTemp.length > 0) {
                        dateList.value = JSON.parseArray<DateItem>(JSON.stringify(res.data)) ?: _uA()
                        val initDate = dateListTemp[0]
                        date.value = initDate
                        toQueryLinesDistrictToCityList(initDate.date)
                    }
                }
                )
            }
            val toShare = fun(item: TripPlanInfo){
                val itemId = item.id as String
                val startDate = item.startDate as String
                val linesGroupName = item.linesGroupName
                val curDate = date.value.date
                val xcTime = curDate + " " + item.startTime
                router.push("/pages/other/scan-order/index?planId=" + itemId + "&date=" + curDate + "&linesGroupName=" + linesGroupName + "&xcTime=" + xcTime)
            }
            val toAdd = fun(){
                router.push("/pages/other/trip-plan/add/index?date=" + date.value.date)
            }
            val toEdit = fun(item: TripPlanInfo){
                val itemId = item.id
                val curDate = date.value.date
                router.push("/pages/other/trip-plan/add/index?id=" + itemId + "&date=" + curDate)
            }
            val toDel = fun(item: TripPlanInfo){
                showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u786E\u8BA4\u8981\u5220\u9664\u8BE5\u884C\u7A0B\u8BA1\u5212\u5417\uFF1F", confirmText = "确认", confirmBgColor = globalData.theme.primaryColor, showCancel = true, confirm = fun(){
                    console.log("todel==", item)
                    delDriverPlan(JSON.parse<UTSJSONObject>(JSON.stringify(item))!!).then(fun(res: Response){
                        if (res.code == 200) {
                            showToast("操作成功", "success")
                            init()
                        }
                    }
                    )
                }
                ))
            }
            val refreshServiceOperationSetting = fun(){
                getServiceOperationSetting().then(fun(res: Response){
                    if (res.code == 200 && res.data != null) {
                        val data = res.data as UTSJSONObject
                        console.log("getServiceOperationSetting data", data)
                        allowDriverUpsertDriverPlan.value = data["allowDriverUpsertDriverPlan"] as Boolean
                    }
                }
                )
            }
            val topLoad = fun(){
                console.log("下拉刷新")
                scrollDirection = "down"
                toQueryLinesDistrictToCityList(date.value.date)
                refreshServiceOperationSetting()
            }
            val bottomLoad = fun(){
                console.log("触底刷新")
                scrollDirection = "up"
                toQueryLinesDistrictToCityList(date.value.date)
            }
            val toDetail = fun(item: TripPlanInfo){
                router.push("/pages/other/trip-plan/detail/index?id=" + item.id + "&date=" + date.value.date)
            }
            onReady(fun(){
                init()
                refreshServiceOperationSetting()
            }
            )
            onPageShow(fun(){
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
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return _cV(_component_mc_base_container, _uM("title" to "行程计划", "showStatusBarPlaceholder" to false, "title-color" to "#ffffff", "navbar-is-place" to false, "staticTransparent" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "top-date-selector", "style" to _nS("padding-top: " + (unref(statusBarHeight) + 50) + "px;background-image: linear-gradient(to right, " + unref(globalData).theme.primaryLinearColors.join(",") + ");")), _uA(
                            _cE("scroll-view", _uM("show-scrollbar" to false, "direction" to "horizontal", "bounces" to false, "style" to _nS(_uA(
                                "width:" + (unref(screenWidth) - 60) + "px;",
                                _uM("padding" to "20rpx")
                            )), "class" to "flex-row flex-row-center-start"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(dateList), fun(item, __key, __index, _cached): Any {
                                    return _cE("view", _uM("class" to _nC(_uA(
                                        "date-item",
                                        _uM("actived" to (unref(date).date == item.date))
                                    )), "onClick" to fun(){
                                        datePickerClick(item)
                                    }
                                    , "key" to item.date), _uA(
                                        _cE("text", _uM("class" to "week-name", "style" to _nS("" + (if (unref(date).date == item.date) {
                                            "color:" + unref(globalData).theme.primaryColor + ";"
                                        } else {
                                            ""
                                        }
                                        ))), _tD(item.dayOfWeek), 5),
                                        _cE("text", _uM("class" to "date-value", "style" to _nS("" + (if (unref(date).date == item.date) {
                                            "color:" + unref(globalData).theme.primaryColor + ";"
                                        } else {
                                            ""
                                        }
                                        ))), _tD(item.monthDay), 5)
                                    ), 10, _uA(
                                        "onClick"
                                    ))
                                }
                                ), 128)
                            ), 4),
                            _cV(_component_mc_date_picker, _uM("modelValue" to unref(date).date, "onUpdate:modelValue" to fun(`$event`: String){
                                unref(date).date = `$event`
                            }
                            , "end-date" to "2099-12-31", "onChange" to datePickerModalClick), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "more-date"), _uA(
                                        _cE("text", _uM("class" to "text"), "更多"),
                                        _cE("text", _uM("class" to "text"), "日期"),
                                        _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-white-line-samll.png"), "mode" to "widthFix"), null, 8, _uA(
                                            "src"
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "modelValue",
                                "onUpdate:modelValue"
                            ))
                        ), 4),
                        _cV(_component_template, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_x_pull_refresh, _uM("height" to ("" + (unref(screenHeight) - unref(statusBarHeight) - 210 - unref(globalData).safeAreaBottom - 30) + "px"), "pullHeight" to 30, "disabled-bottom" to true, "show-scrollbar" to false, "modelValue" to unref(isfresh), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                    trySetRefValue(isfresh, `$event`)
                                }
                                , "model-bottom-status" to unref(bottomFresh), "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                    trySetRefValue(bottomFresh, `$event`)
                                }
                                , "onRefresh" to topLoad, "onBottomRefresh" to bottomLoad), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(unref(serviceLinesDistrictToCityList), fun(item, index, __index, _cached): Any {
                                            return _cV(_component_x_sheet, _uM("margin" to _uA(
                                                "15",
                                                "15",
                                                "15",
                                                "0"
                                            ), "key" to index, "padding" to _uA(
                                                "0"
                                            ), "round" to _uA(
                                                "20rpx"
                                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "setting-item"), _uA(
                                                        _cE("view", _uM("class" to "top-box"), _uA(
                                                            _cE("view", _uM("class" to "time"), _uA(
                                                                _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-clock-outline-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                    "src"
                                                                )),
                                                                _cE("text", _uM("class" to "value"), _tD(item.startTime), 1)
                                                            ))
                                                        )),
                                                        _cE("view", _uM("class" to "route-info", "onClick" to fun(){
                                                            toDetail(item)
                                                        }
                                                        ), _uA(
                                                            _cE("text", _uM("class" to "start-address"), _tD(item.startCityName), 1),
                                                            _cE("view", _uM("class" to "group-name"), _uA(
                                                                _cE("text", _uM("class" to "name", "style" to _nS("color: " + unref(globalData).theme.primaryColor + ";")), _tD(item.linesGroupName), 5),
                                                                _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-trip-car-filled.png"), "mode" to "heightFix"), null, 8, _uA(
                                                                    "src"
                                                                ))
                                                            )),
                                                            _cE("text", _uM("class" to "end-address"), _tD(item.endCityName), 1)
                                                        ), 8, _uA(
                                                            "onClick"
                                                        )),
                                                        _cE("view", _uM("class" to "btn-group"), _uA(
                                                            _cV(_component_mc_active_animation, _uM("class" to "btn border-r-1", "onClick" to fun(){
                                                                toShare(item)
                                                            }
                                                            ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-share-outline.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                        "src"
                                                                    )),
                                                                    _cE("text", _uM("class" to "text", "style" to _nS("color: " + unref(globalData).theme.primaryColor + ";")), "分享", 4)
                                                                )
                                                            }
                                                            ), "_" to 2), 1032, _uA(
                                                                "onClick"
                                                            )),
                                                            if (isTrue(unref(allowDriverUpsertDriverPlan))) {
                                                                _cV(_component_mc_active_animation, _uM("key" to 0, "class" to "btn border-r-1", "onClick" to fun(){
                                                                    toEdit(item)
                                                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                    return _uA(
                                                                        _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-edit-outline.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                            "src"
                                                                        )),
                                                                        _cE("text", _uM("class" to "text", "style" to _nS("color: " + unref(globalData).theme.primaryColor + ";")), "编辑", 4)
                                                                    )
                                                                }), "_" to 2), 1032, _uA(
                                                                    "onClick"
                                                                ))
                                                            } else {
                                                                _cC("v-if", true)
                                                            }
                                                            ,
                                                            if (isTrue(unref(allowDriverUpsertDriverPlan))) {
                                                                _cV(_component_mc_active_animation, _uM("key" to 1, "class" to "btn border-r-1", "onClick" to fun(){
                                                                    toDel(item)
                                                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                    return _uA(
                                                                        _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-delete-outline.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                            "src"
                                                                        )),
                                                                        _cE("text", _uM("class" to "text", "style" to _nS("color: " + unref(globalData).theme.primaryColor + ";")), "删除", 4)
                                                                    )
                                                                }), "_" to 2), 1032, _uA(
                                                                    "onClick"
                                                                ))
                                                            } else {
                                                                _cC("v-if", true)
                                                            }
                                                        ))
                                                    ))
                                                )
                                            }
                                            ), "_" to 2), 1024)
                                        }
                                        ), 128),
                                        if (unref(serviceLinesDistrictToCityList).length <= 0) {
                                            _cV(_component_x_empty, _uM("key" to 0, "loading" to false, "empty" to true, "showBtn" to false))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "height",
                                    "modelValue",
                                    "model-bottom-status"
                                ))
                            )
                        }
                        ), "_" to 1)),
                        if (isTrue(unref(allowDriverUpsertDriverPlan))) {
                            _cE("view", _uM("key" to 0, "class" to "btn-group-panel", "style" to _nS("padding-bottom: " + (unref(globalData).safeAreaBottom + 15) + "px;")), _uA(
                                _cV(_component_mc_primary_button, _uM("height" to "45px", "onClick" to toAdd), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "添加计划"
                                    )
                                }), "_" to 1))
                            ), 4)
                        } else {
                            _cC("v-if", true)
                        }
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
                return _uM("top-date-selector" to _pS(_uM("position" to "relative", "flexDirection" to "row", "alignItems" to "center")), "date-item" to _uM(".top-date-selector " to _uM("alignItems" to "center", "justifyContent" to "center", "paddingTop" to "20rpx", "paddingRight" to "12rpx", "paddingBottom" to "20rpx", "paddingLeft" to "12rpx"), ".top-date-selector .actived" to _uM("backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx")), "week-name" to _uM(".top-date-selector .date-item " to _uM("fontWeight" to "bold", "fontSize" to "24rpx", "color" to "#FFFFFF")), "date-value" to _uM(".top-date-selector .date-item " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#FFFFFF"), ".top-date-selector .date-item .actived" to _uM("color" to "#4F6A9F")), "more-date" to _uM(".top-date-selector " to _uM("paddingTop" to "10rpx", "paddingRight" to "25rpx", "paddingBottom" to "10rpx", "paddingLeft" to "25rpx", "alignItems" to "center", "boxShadow" to "-5rpx 0 1rpx 0 rgba(0, 0, 0, 0.1)")), "icon" to _uM(".top-date-selector .more-date " to _uM("width" to "16rpx", "height" to "10rpx"), ".setting-item .top-box .time " to _uM("width" to "22rpx", "height" to "22rpx", "marginRight" to "10rpx"), ".setting-item .route-info .group-name " to _uM("width" to "210rpx", "height" to "24rpx"), ".setting-item .btn-group .btn " to _uM("width" to "30rpx", "height" to "32rpx")), "text" to _uM(".top-date-selector .more-date " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#FFFFFF"), ".setting-item .btn-group .btn " to _uM("paddingLeft" to "16rpx", "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#536FA5")), "top-box" to _uM(".setting-item " to _uM("paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "36rpx", "paddingLeft" to "20rpx")), "time" to _uM(".setting-item .top-box " to _uM("flexDirection" to "row", "alignItems" to "center")), "value" to _uM(".setting-item .top-box .time " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000")), "route-info" to _uM(".setting-item " to _uM("marginTop" to 0, "marginRight" to "30rpx", "marginBottom" to 0, "marginLeft" to "30rpx", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "paddingBottom" to "30rpx", "borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#DADADA")), "start-address" to _uM(".setting-item .route-info " to _uM("fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000", "paddingRight" to "20rpx")), "end-address" to _uM(".setting-item .route-info " to _uM("fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000", "paddingLeft" to "20rpx")), "group-name" to _uM(".setting-item .route-info " to _uM("alignItems" to "center")), "name" to _uM(".setting-item .route-info .group-name " to _uM("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#5672AB", "paddingBottom" to "6rpx")), "btn-group" to _uM(".setting-item " to _uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to "25rpx", "paddingRight" to 0, "paddingBottom" to "25rpx", "paddingLeft" to 0)), "border-r-1" to _uM(".setting-item .btn-group " to _uM("borderRightWidth" to "1rpx", "borderRightStyle" to "solid", "borderRightColor" to "#DADADA")), "btn" to _uM(".setting-item .btn-group " to _uM("flex" to 1, "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "bottom-panel" to _pS(_uM("position" to "fixed", "left" to 0, "right" to 0, "paddingTop" to "30rpx", "paddingRight" to "30rpx", "paddingBottom" to "30rpx", "paddingLeft" to "30rpx", "flexDirection" to "row")), "btn-group-panel" to _pS(_uM("width" to "100%", "backgroundColor" to "#ffffff", "position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "paddingTop" to 15, "paddingLeft" to 15, "paddingRight" to 15, "flexDirection" to "row", "justifyContent" to "space-between")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
