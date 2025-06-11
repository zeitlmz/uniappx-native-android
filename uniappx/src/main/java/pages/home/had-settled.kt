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
import io.dcloud.uniapp.extapi.`$once` as uni__once
import uts.sdk.modules.jgJpush.JgUtil
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xToastS.XTOAST_TYPE
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import uts.sdk.modules.mcAmapNavPlus.checkLocationPermission
import uts.sdk.modules.mcAmapNavPlus.init
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import uts.sdk.modules.xModalS.showModal
import uts.sdk.modules.xToastS.showToast as showXToast
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesHomeHadSettled : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var onShow: () -> Unit
        get() {
            return unref(this.`$exposed`["onShow"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "onShow", value)
        }
    open var onHide: () -> Unit
        get() {
            return unref(this.`$exposed`["onHide"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "onHide", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesHomeHadSettled, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesHomeHadSettled
            val _cache = __ins.renderCache
            val app = getApp()
            var ws = Ws.init()
            val router = uni_useKuxRouter()
            val cacheUserInfo = ref<Any?>(null)
            val globalData = inject("globalData") as GlobalDataType
            val acitveTab = ref<String>("0")
            val acitveOrderType = ref<Number>(0)
            val showValidModal = ref<Boolean>(false)
            val startLocation = ref<Boolean>(false)
            val showAgreeLocationModal = ref<Boolean>(false)
            val tabs = utsArrayOf(
                TABS_ITEM_INFO(title = "首页")
            )
            val isInit = ref(false)
            val currentSwiper = ref<Number>(0)
            val onTabChange = fun(_: TABS_ITEM, index: Number){
                currentSwiper.value = index
            }
            val queryDate = ref<String>("")
            val dateRange = ref(utsArrayOf<String>("", ""))
            val disabledDates = ref(utsArrayOf<String>())
            val hadGetWeather = ref<WeatherData>(WeatherData(province = "", city = "", adcode = "", weather = "", temperature = "", winddirection = "", windpower = "", humidity = "", reporttime = "", temperature_float = 0, humidity_float = 0))
            val onLocation = fun(location: String){
                val locationInfo = JSON.parse<LocationInfo>(location)
                if (locationInfo != null) {
                    globalData.position = locationInfo
                    if (ws.getIsConnected()) {
                        ws?.send(WebSocketSendMessage(type = MessageType["LOCATION_SYNC"] as Number, content = object : UTSJSONObject() {
                            var region = locationInfo?.adcode ?: ""
                            var location = (locationInfo?.longitude?.toString(10) ?: "0") + "," + (locationInfo?.latitude?.toString(10) ?: "0")
                            var locationAddress = locationInfo?.address ?: ""
                        }))
                    }
                    if (hadGetWeather.value.temperature == "" && globalData.position.adcode != "" && globalData.position.adcode != null) {
                        getWeather(globalData.position.adcode).then(fun(res: UTSJSONObject){
                            hadGetWeather.value = res.getArray<WeatherData>("lives")?.get(0) as WeatherData
                        }
                        )
                    }
                }
            }
            val advList = utsArrayOf(
                ADV_ITEM(image = "/static/images/adv-driver-join-2.png", click = fun(index: Number){
                    console.log(index)
                }
                )
            )
            val homeGrid = utsArrayOf(
                GRID_FUNC_ITEM(icon = "/static/icons/icon-car-setting.png", text = "出车设置", click = fun(){
                    router.push("/pages/other/car-setting/index")
                }
                ),
                GRID_FUNC_ITEM(icon = "/static/icons/icon-car-manage.png", text = "车辆管理", click = fun(){
                    router.push("/pages/other/car-manage/index")
                }
                ),
                GRID_FUNC_ITEM(icon = "/static/icons/icon-route-manage.png", text = "线路管理", click = fun(){
                    router.push("/pages/other/line-manage/index")
                }
                ),
                GRID_FUNC_ITEM(icon = "/static/icons/icon-line-plan.png", text = "行程计划", click = fun(){
                    router.push("/pages/other/trip-plan/index")
                }
                )
            )
            val gridFuncs = utsArrayOf(
                GRID_FUNC_ITEM(icon = "/static/icons/icon-car.png", text = "租车购车", click = fun(){
                    console.log("租车购车")
                }
                ),
                GRID_FUNC_ITEM(icon = "/static/icons/icon-idcard.png", text = "证件代办", click = fun(){
                    console.log("证件代办")
                }
                ),
                GRID_FUNC_ITEM(icon = "/static/icons/icon-power.png", text = "充电站", click = fun(){
                    console.log("充电站")
                }
                ),
                GRID_FUNC_ITEM(icon = "/static/icons/icon-giveup.png", text = "加油站", click = fun(){
                    console.log("加油站")
                }
                ),
                GRID_FUNC_ITEM(icon = "/static/icons/icon-wc.png", text = "附近厕所", click = fun(){
                    console.log("附近厕所")
                }
                ),
                GRID_FUNC_ITEM(icon = "/static/icons/icon-service.png", text = "联系客服", click = fun(){
                    console.log("联系客服")
                }
                )
            )
            val getStatusClass = fun(status: Number): String {
                when (status) {
                    2 ->
                        return "processing"
                    1 ->
                        return "waiting"
                    0 ->
                        return "pending"
                    else ->
                        return ""
                }
            }
            val getStatusName = fun(status: Number): String {
                when (status) {
                    2 ->
                        return "进行中"
                    1 ->
                        return "接驾中"
                    0 ->
                        return "待出发"
                    else ->
                        return ""
                }
            }
            val showNavModal = ref<Boolean>(false)
            val toOrderDetail = fun(order: IntercityOrderSummaryInfo){
                val query: UTSJSONObject = object : UTSJSONObject() {
                    var planId = order.planId?.toString(10)
                    var summaryId = order.summaryId?.toString(10)
                    var orderStatus = order.status
                    var typeOfBoarding = order.typeOfBoarding
                    var queryDate = order.departureDate
                }
                router.push("/pages/other/order-detail/index?planId=" + query["planId"] + "&summaryId=" + query["summaryId"] + "&orderStatus=" + query["orderStatus"] + "&typeOfBoarding=" + query["typeOfBoarding"] + "&queryDate=" + query["queryDate"])
            }
            val handleStartPickup = fun(order: IntercityOrderSummaryInfo){
                if (!isLocationAgree()) {
                    showAgreeLocationModal.value = true
                    return
                }
                showLoading(XLOADINGS_TYPE(title = "正在出车中..."))
                ws?.sendAndOnErr(WebSocketSendMessage(type = MessageType["BEFORE_CHECK"] as Number), fun(data){
                    console.log("检车成功：", data)
                    restartListening(order.summaryId.toString(10)).then(fun(){
                        order.status = 1
                        toOrderDetail(order)
                    }
                    ).`finally`(fun(){
                        hideXloading()
                    }
                    )
                }
                    , fun(data){
                        hideXloading()
                    }
                )
            }
            val handleScanBoard = fun(order: IntercityOrderSummaryInfo){
                if (order.remainingSeats <= 0) {
                    return showToast("车辆已满座，无法继续下单", "error")
                }
                val query: UTSJSONObject = object : UTSJSONObject() {
                    var planId = order.planId.toString(10)
                    var linesGroupName = order.lineGroup
                    var xcTime = order.departureDate + " " + order.departureStartTime + ":00"
                    var date = if (acitveOrderType.value == 0) {
                        formatDate(Date(), "yyyy-MM-dd")
                    } else {
                        queryDate.value
                    }
                }
                console.log("扫码上车", query)
                router.push("/pages/other/scan-order/index?planId=" + query["planId"] + "&linesGroupName=" + query["linesGroupName"] + "&xcTime=" + query["xcTime"] + "&date=" + query["date"])
            }
            val todayOrderCount = ref(0)
            val otherOrderCount = ref(0)
            val orderList = ref(utsArrayOf<IntercityOrderSummaryInfo>())
            val otherOrderList = ref(utsArrayOf<IntercityOrderSummaryInfo>())
            val toPersonPage = fun(){
                router.push("/pages/personal/index")
            }
            val dateStyles = ref(utsArrayOf<xCalendarDateStyle_type>())
            val queryOrderList = fun(type: Number){
                console.log("查询订单列表:", ws?.getIsConnected())
                ws?.sendAndOn(WebSocketSendMessage(type = MessageType["QUERY_ORDER"] as Number, content = object : UTSJSONObject() {
                    var queryType = if (type == 0) {
                        OrderQueryType["TODAY"]
                    } else {
                        OrderQueryType["RESERVATION_LIST"]
                    }
                            as Number
                    var condition = if (type == 0) {
                        ""
                    } else {
                        queryDate.value
                    }
                }), fun(data){
                    val orderInfo = JSON.parse<QueryResponse<OrderSummary>>(data)
                    console.log("订单信息：", orderInfo)
                    todayOrderCount.value = orderInfo?.data?.todayOrderCount ?: 0
                    console.log("type：", type)
                    otherOrderCount.value = orderInfo?.data?.otherOrderCount ?: 0
                    if (orderInfo?.queryType == 0) {
                        orderList.value = orderInfo?.data?.intercityOrderSummaryInfos ?: utsArrayOf()
                    } else {
                        otherOrderList.value = orderInfo?.data?.intercityOrderSummaryInfos ?: utsArrayOf()
                    }
                }
                )
            }
            val queryCalendar = fun(){
                ws?.sendAndOn(WebSocketSendMessage(type = MessageType["QUERY_ORDER"] as Number, content = object : UTSJSONObject() {
                    var queryType = OrderQueryType["CALENDAR"] as Number
                }), fun(data){
                    val orderInfo = JSON.parse<QueryResponse<UTSArray<DateCountDTO>>>(data)
                    console.log("日历预约订单数量信息：", orderInfo?.data)
                    val dateStyleList: UTSArray<xCalendarDateStyle_type> = utsArrayOf()
                    val dateList: UTSArray<String> = utsArrayOf()
                    orderInfo?.data?.forEach(fun(item: DateCountDTO, index: Number, arr: UTSArray<DateCountDTO>){
                        dateList.push(item.date)
                        dateStyleList.push(xCalendarDateStyle_type(date = item.date, dot = true, dotColor = "orange", dotLabel = item.count))
                    }
                    )
                    dateStyles.value = dateStyleList
                    if (dateStyleList.length > 0) {
                        dateRange.value = utsArrayOf(
                            dateStyleList[0].date,
                            dateStyleList[dateStyleList.length - 1].date
                        )
                        queryDate.value = dateStyleList[0].date
                        if (dateStyleList.length > 1) {
                            disabledDates.value = getMissingDates(dateList)
                        }
                    } else {
                        val tomorrow = getTimePlusRangeFormat(Date(), "one-day", "yyyy-MM-dd")
                        dateRange.value = utsArrayOf(
                            tomorrow[1],
                            tomorrow[1]
                        )
                        queryDate.value = tomorrow[1]
                    }
                    setTimeout(fun(){
                        queryOrderList(1)
                    }
                        , 250)
                }
                )
            }
            val orderQuery = fun(){
                if (acitveOrderType.value == 0) {
                    queryOrderList(acitveOrderType.value)
                } else if (acitveOrderType.value == 1) {
                    queryCalendar()
                }
            }
            val onOrderTypeChange = fun(type: Number){
                acitveOrderType.value = type
                if (type == 1) {
                    queryCalendar()
                } else {
                    queryOrderList(type)
                }
            }
            val handleCancelPickup = fun(order: IntercityOrderSummaryInfo){
                console.log("取消接驾", order)
                showLoading(XLOADINGS_TYPE(title = "正在取消接驾..."))
                ws?.sendAndOnErr(WebSocketSendMessage(type = MessageType["CANCEL_CAR"] as Number), fun(data){
                    console.log("收车成功：", data)
                    showTips("取消接驾成功", "success")
                    hideXloading()
                    orderQuery()
                }
                    , fun(data){
                        hideXloading()
                    }
                )
            }
            val onHide = fun(){}
            val initWs = fun(){
                ws.setOpenCallback(fun(){
                    console.log("首页监听到连接打开事件=======")
                    isInit.value = true
                    orderQuery()
                    showTips("服务已连接", "success")
                }
                )
                ws?.on(MessageType["WARNING"] as Number, fun(data){
                    if (data != "") {
                        setTimeout(fun(){
                            showModal(X_MODAL_TYPE(title = "温馨提示", content = data?.toString(), confirmText = "知道了", showCancel = false, confirmBgColor = globalData.theme.primaryColor))
                        }
                            , 300)
                    }
                }
                )
                ws?.on(MessageType["NOT_AUTH"] as Number, fun(data){
                    clearAuth()
                    if (data != "") {
                        setTimeout(fun(){
                            showModal(X_MODAL_TYPE(title = "温馨提示", content = data?.toString(), confirmText = "知道了", showCancel = false, confirmBgColor = globalData.theme.primaryColor, close = fun(){
                                router.reLaunch("/pages/home/index")
                            }
                            ))
                        }
                            , 300)
                    }
                }
                )
                ws?.on(MessageType["FORCE_LOGOUT"] as Number, fun(data){
                    console.log("您的账号已在另一台设备登录，当前连接已断开：", data)
                    clearAuth()
                    showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u60A8\u7684\u8D26\u53F7\u5DF2\u5728\u53E6\u4E00\u53F0\u8BBE\u5907\u767B\u5F55\uFF0C\u5F53\u524D\u8FDE\u63A5\u5DF2\u65AD\u5F00", confirmText = "知道了", confirmBgColor = globalData.theme.primaryColor, showCancel = false, confirm = fun(){
                        router.reLaunch("/pages/home/index")
                    }
                    ))
                }
                )
                ws?.on(MessageType["ORDER_CANCEL"] as Number, fun(data){
                    console.log("您有一个订单已被取消：", data)
                    showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u60A8\u6709\u4E00\u4E2A\u8BA2\u5355\u5DF2\u88AB\u53D6\u6D88", confirmText = "知道了", confirmBgColor = globalData.theme.primaryColor, showCancel = false, confirm = fun(){
                        orderQuery()
                    }
                    ))
                    McAudio.play("/static/audio/order-cancel.mp3", false)
                }
                )
                ws?.on(MessageType["ORDER_ADD"] as Number, fun(data){
                    console.log("您有一个新的订单：", data)
                    orderQuery()
                    McAudio.play("/static/audio/new-order.mp3", false)
                }
                )
                ws?.on(MessageType["BIG_ORDER_FINISH"] as Number, fun(data){
                    console.log("因订单取消或调度，您当前订单已全部完成：", data)
                    showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u56E0\u8BA2\u5355\u53D6\u6D88\u6216\u8C03\u5EA6\uFF0C\u60A8\u5F53\u524D\u8BA2\u5355\u5DF2\u5168\u90E8\u5B8C\u6210", confirmText = "知道了", confirmBgColor = globalData.theme.primaryColor, showCancel = false, confirm = fun(){
                        orderQuery()
                    }
                    ))
                    McAudio.play("/static/audio/order-cancel.mp3", false)
                }
                )
                ws?.sendAndOn(WebSocketSendMessage(type = MessageType["QUERY_CAR_SETTING"] as Number, content = ""), fun(data){
                    val json = JSON.parse<UTSJSONObject>(data)
                    globalData.carSetting.closeReceiveOrderSwitch = json?.getBoolean("closeReceiveOrderSwitch") ?: true
                    globalData.carSetting.enableAIRouteStrategy = json?.getBoolean("enableAIRouteStrategy") ?: false
                    globalData.carSetting.routeStrategy = json?.getString("routeStrategy") ?: "OVERALL_OPTIMAL"
                }
                )
            }
            val onShow = fun(){
                initWs()
                if (isInit.value) {
                    orderQuery()
                }
                if (globalData.position.adcode != "" && globalData.position.adcode != null) {
                    getWeather(globalData.position.adcode).then(fun(res: UTSJSONObject){
                        hadGetWeather.value = res.getArray<WeatherData>("lives")?.get(0) as WeatherData
                    }
                    )
                }
            }
            __expose(utsMapOf("onShow" to onShow, "onHide" to onHide))
            val locationAgreeCancel = fun(){
                setTimeout(fun(){
                    showXToast(XTOAST_TYPE(title = "您已拒绝定位获取权限，将无法进行后面的业务", iconCode = "info", iconColor = "#ff8900", duration = 2500))
                }
                    , 250)
                setLocationGrantStatus("reject")
                uni__once("startLocation", fun(){
                    startLocation.value = true
                }
                )
            }
            val locationAgreeConfirm = fun(){
                checkLocationPermission(fun(all: Boolean){
                    if (all) {
                        console.log("同意权限=======", all)
                        startLocation.value = true
                        setLocationGrantStatus("agree")
                        onShow()
                    } else {
                        locationAgreeCancel()
                    }
                }
                )
            }
            val initJg = fun(){
                val jg = JgUtil()
                jg.init()
                setTimeout(fun(){
                    jg.getRegistrationID()
                    jg.getConnectionState()
                }
                    , 10000)
                app.globalData.jg = jg
            }
            val initMap = fun(){
                init(MAP_CONFIG["naviKey"] as String)
            }
            onMounted(fun(){
                isInit.value = true
                initJg()
                initMap()
                if (isLocationAgree()) {
                    locationAgreeConfirm()
                    onShow()
                } else if (!isLocationReject()) {
                    showAgreeLocationModal.value = true
                }
            }
            )
            return fun(): Any? {
                val _component_mc_amap_location = resolveEasyComponent("mc-amap-location", GenUniModulesMcAmapNavPlusComponentsMcAmapLocationMcAmapLocationClass)
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_x_tabs = resolveEasyComponent("x-tabs", GenUniModulesTmxUiComponentsXTabsXTabsClass)
                val _component_mc_active_animation = resolveEasyComponent("mc-active-animation", GenComponentsMcActiveAnimationIndexClass)
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                val _component_mc_pain_button = resolveEasyComponent("mc-pain-button", GenComponentsMcPainButtonIndexClass)
                val _component_template = resolveComponent("template")
                val _component_x_empty = resolveEasyComponent("x-empty", GenUniModulesTmxUiComponentsXEmptyXEmptyClass)
                val _component_mc_date_picker = resolveEasyComponent("mc-date-picker", GenComponentsMcDatePickerIndexClass)
                val _component_x_image = resolveEasyComponent("x-image", GenUniModulesTmxUiComponentsXImageXImageClass)
                val _component_x_swiper_item = resolveEasyComponent("x-swiper-item", GenUniModulesTmxUiComponentsXSwiperItemXSwiperItemClass)
                val _component_x_swiper = resolveEasyComponent("x-swiper", GenUniModulesTmxUiComponentsXSwiperXSwiperClass)
                val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
                return createElementVNode(Fragment, null, utsArrayOf(
                    if (isTrue(unref(startLocation))) {
                        createVNode(_component_mc_amap_location, utsMapOf("key" to 0, "onLocation" to onLocation))
                    } else {
                        createCommentVNode("v-if", true)
                    }
                    ,
                    createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsArrayOf(
                        utsMapOf("flex" to "1"),
                        "height: " + unref(screenHeight) + "px;background-color: #ffffff;"
                    )), "bounces" to false, "direction" to if (unref(currentSwiper) == 1) {
                        "none"
                    } else {
                        "vertical"
                    }
                        , "show-scrollbar" to false), utsArrayOf(
                        createElementVNode("view", utsMapOf("style" to normalizeStyle("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        createElementVNode("view", utsMapOf("class" to "home-bg"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "top-bg", "style" to normalizeStyle("background-image: linear-gradient(to bottom," + unref(globalData).theme.painColor2 + ", #FFFFFF);")), null, 4)
                        )),
                        createElementVNode("view", utsMapOf("class" to "header"), utsArrayOf(
                            createVNode(_component_x_tabs, utsMapOf("modelValue" to unref(acitveTab), "onUpdate:modelValue" to fun(`$event`: String){
                                trySetRefValue(acitveTab, `$event`)
                            }
                                , "onChange" to onTabChange, "line-full" to false, "line-height" to "3", "line-color" to "#000000", "color" to "#00000000", "list" to tabs), utsMapOf("default" to withScopedSlotCtx(fun(slotProps: GenUniModulesTmxUiComponentsXTabsXTabsSlotDataDefault): UTSArray<Any> {
                                val item = slotProps.item
                                val active = slotProps.active
                                return utsArrayOf(
                                    createVNode(_component_x_text, utsMapOf("style" to normalizeStyle(utsArrayOf(
                                        if (active) {
                                            "font-weight:bold;font-size:22;"
                                        } else {
                                            "font-size:16;font-weight:400;"
                                        }
                                        ,
                                        utsMapOf("padding" to "0 10px")
                                    ))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            toDisplayString(item.title)
                                        )
                                    }
                                    ), "_" to 2), 1032, utsArrayOf(
                                        "style"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "modelValue"
                            )),
                            createVNode(_component_mc_active_animation, utsMapOf("onClick" to toPersonPage, "class" to "avatar-box"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode("image", utsMapOf("class" to "avatar", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-default-avatar2.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                        "src"
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )),
                        createElementVNode("swiper", utsMapOf("current" to unref(currentSwiper), "disable-touch" to true), utsArrayOf(
                            createElementVNode("swiper-item", utsMapOf("style" to normalizeStyle(utsMapOf("height" to "auto")), "key" to "0"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "container"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "card", "style" to normalizeStyle(utsMapOf("margin-top" to "20px", "background" to "#00000000", "border" to "none", "box-shadow" to "none"))), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "card-header"), utsArrayOf(
                                            createVNode(_component_mc_active_animation, utsMapOf("class" to "left"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("image", utsMapOf("class" to "location-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("text", null, toDisplayString(unref(hadGetWeather).city), 1)
                                                )
                                            }
                                            ), "_" to 1)),
                                            createElementVNode("view", utsMapOf("class" to "right"), toDisplayString(unref(hadGetWeather)?.weather?.toString() + " " + unref(hadGetWeather)?.temperature?.toString()) + "℃ ", 1)
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "card-body"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "grid-func"), utsArrayOf(
                                                createElementVNode(Fragment, null, RenderHelpers.renderList(homeGrid, fun(item, index, __index, _cached): Any {
                                                    return createVNode(_component_mc_active_animation, utsMapOf("class" to "grid-item", "onClick" to fun(){
                                                        item.click?.invoke()
                                                    }
                                                    ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return utsArrayOf(
                                                            createElementVNode("image", utsMapOf("class" to "grid-icon", "src" to (unref(resBaseUrl) + item.icon), "key" to index, "mode" to "aspectFit"), null, 8, utsArrayOf(
                                                                "src"
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "grid-text"), utsArrayOf(
                                                                createElementVNode("text", null, toDisplayString(item.text), 1)
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 2), 1032, utsArrayOf(
                                                        "onClick"
                                                    ))
                                                }
                                                ), 64)
                                            ))
                                        ))
                                    ), 4),
                                    createElementVNode("view", utsMapOf("class" to "order-tab"), utsArrayOf(
                                        if (unref(acitveOrderType) == 0) {
                                            createElementVNode("image", utsMapOf("key" to 0, "class" to "bg-img-left", "src" to ("" + unref(resBaseUrl) + "/static/images/home-tab-bg-left.png")), null, 8, utsArrayOf(
                                                "src"
                                            ))
                                        } else {
                                            if (unref(acitveOrderType) == 1) {
                                                createElementVNode("image", utsMapOf("key" to 1, "class" to "bg-img-right", "src" to ("" + unref(resBaseUrl) + "/static/images/home-tab-bg-right.png")), null, 8, utsArrayOf(
                                                    "src"
                                                ))
                                            } else {
                                                createCommentVNode("v-if", true)
                                            }
                                        }
                                        ,
                                        if (unref(acitveOrderType) == 0) {
                                            createVNode(_component_mc_active_animation, utsMapOf("key" to 2, "class" to "active-tab-left", "style" to normalizeStyle("width:" + unref(screenWidth) / 2 + "px;")), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "text"), "当日订单(" + toDisplayString(unref(todayOrderCount)) + ")", 1),
                                                    createElementVNode("view", utsMapOf("class" to "active-line"))
                                                )
                                            }), "_" to 1), 8, utsArrayOf(
                                                "style"
                                            ))
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                        ,
                                        if (unref(acitveOrderType) == 1) {
                                            createVNode(_component_mc_active_animation, utsMapOf("key" to 3, "class" to "active-tab-right", "style" to normalizeStyle("width:" + unref(screenWidth) / 2 + "px;")), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "text"), "预约订单(" + toDisplayString(unref(otherOrderCount)) + ")", 1),
                                                    createElementVNode("view", utsMapOf("class" to "active-line"))
                                                )
                                            }), "_" to 1), 8, utsArrayOf(
                                                "style"
                                            ))
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                        ,
                                        createElementVNode("view", utsMapOf("class" to "tab-group"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("onClick" to fun(){
                                                onOrderTypeChange(0)
                                            }
                                                , "class" to "tab-item"), utsArrayOf(
                                                createElementVNode("text", utsMapOf("class" to "text"), "当日订单(" + toDisplayString(unref(todayOrderCount)) + ")", 1)
                                            ), 8, utsArrayOf(
                                                "onClick"
                                            )),
                                            createElementVNode("view", utsMapOf("onClick" to fun(){
                                                onOrderTypeChange(1)
                                            }
                                                , "class" to "tab-item"), utsArrayOf(
                                                createElementVNode("text", utsMapOf("class" to "text"), "预约订单(" + toDisplayString(unref(otherOrderCount)) + ")", 1)
                                            ), 8, utsArrayOf(
                                                "onClick"
                                            ))
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "order-box"), utsArrayOf(
                                        createElementVNode("swiper", utsMapOf("current" to unref(acitveOrderType), "disable-touch" to true), utsArrayOf(
                                            createElementVNode("swiper-item", null, utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "order-list"), utsArrayOf(
                                                    createElementVNode(Fragment, null, RenderHelpers.renderList(unref(orderList), fun(order, __key, __index, _cached): Any {
                                                        return createElementVNode("view", utsMapOf("class" to "order-item", "onClick" to fun(){
                                                            toOrderDetail(order)
                                                        }
                                                            , "key" to order.summaryId), utsArrayOf(
                                                            createElementVNode("view", utsMapOf("class" to "order-top"), utsArrayOf(
                                                                createElementVNode("view", utsMapOf("class" to "order-left"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to normalizeClass(utsArrayOf(
                                                                        "order-type",
                                                                        if (order.typeOfBoarding == 2) {
                                                                            "pinche"
                                                                        } else {
                                                                            "duxiang"
                                                                        }
                                                                    ))), toDisplayString(if (order.typeOfBoarding == 2) {
                                                                        "拼车"
                                                                    } else {
                                                                        "独享"
                                                                    }
                                                                    ), 3),
                                                                    createElementVNode("text", utsMapOf("class" to "order-time"), toDisplayString(order.departureDate) + " " + toDisplayString(order.departureStartTime), 1)
                                                                )),
                                                                createElementVNode("text", utsMapOf("class" to normalizeClass(utsArrayOf(
                                                                    "order-status",
                                                                    getStatusClass(order.status)
                                                                ))), toDisplayString(getStatusName(order.status)), 3)
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "divider-line")),
                                                            createElementVNode("view", utsMapOf("class" to "order-route"), utsArrayOf(
                                                                createElementVNode("view", utsMapOf("class" to "from-to"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "city"), toDisplayString(order.startCity), 1),
                                                                    createElementVNode("view", utsMapOf("class" to "path-container"), utsArrayOf(
                                                                        createElementVNode("image", utsMapOf("class" to "dashed-line", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-route-arrow-right.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                                            "src"
                                                                        ))
                                                                    )),
                                                                    createElementVNode("text", utsMapOf("class" to "city"), toDisplayString(order.endCity), 1)
                                                                )),
                                                                createElementVNode("view", utsMapOf("class" to "route-info"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "route-name"), toDisplayString(order.lineGroup), 1),
                                                                    createElementVNode("text", utsMapOf("class" to "route-divider"), "|"),
                                                                    createElementVNode("text", null, utsArrayOf(
                                                                        createElementVNode("text", utsMapOf("class" to "seat-info"), utsArrayOf(
                                                                            "余坐：",
                                                                            createElementVNode("text", utsMapOf("class" to "highlight"), toDisplayString(order.remainingSeats), 1)
                                                                        )),
                                                                        createElementVNode("text", utsMapOf("class" to "seat-info"), "位")
                                                                    )),
                                                                    createElementVNode("text", utsMapOf("class" to "route-divider"), "|"),
                                                                    if (order.orderCount > 0) {
                                                                        createElementVNode("text", utsMapOf("key" to 0), utsArrayOf(
                                                                            createElementVNode("text", utsMapOf("class" to "order-count"), utsArrayOf(
                                                                                "包含",
                                                                                createElementVNode("text", utsMapOf("class" to "highlight"), toDisplayString(order.orderCount), 1)
                                                                            )),
                                                                            createElementVNode("text", utsMapOf("class" to "order-count"), "笔订单")
                                                                        ))
                                                                    } else {
                                                                        createCommentVNode("v-if", true)
                                                                    }
                                                                )),
                                                                createVNode(_component_template, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                    return utsArrayOf(
                                                                        createElementVNode("view", utsMapOf("class" to "btn-group"), utsArrayOf(
                                                                            if (order.status == 0) {
                                                                                createVNode(_component_mc_primary_button, utsMapOf("key" to 0, "margin-right" to "10px", "onClick" to fun(){
                                                                                    handleStartPickup(order)
                                                                                }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return utsArrayOf(
                                                                                        "出发接驾"
                                                                                    )
                                                                                }), "_" to 2), 1032, utsArrayOf(
                                                                                    "onClick"
                                                                                ))
                                                                            } else {
                                                                                if (order.status == 1) {
                                                                                    createVNode(_component_mc_primary_button, utsMapOf("key" to 1, "margin-right" to "10px", "onClick" to fun(){
                                                                                        handleCancelPickup(order)
                                                                                    }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                        return utsArrayOf(
                                                                                            "取消接驾"
                                                                                        )
                                                                                    }), "_" to 2), 1032, utsArrayOf(
                                                                                        "onClick"
                                                                                    ))
                                                                                } else {
                                                                                    createCommentVNode("v-if", true)
                                                                                }
                                                                            }
                                                                            ,
                                                                            if (order.status != 2) {
                                                                                createVNode(_component_mc_pain_button, utsMapOf("key" to 2, "disabled" to (order.remainingSeats <= 0), "onClick" to fun(){
                                                                                    handleScanBoard(order)
                                                                                }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return utsArrayOf(
                                                                                        "扫码上车"
                                                                                    )
                                                                                }), "_" to 2), 1032, utsArrayOf(
                                                                                    "disabled",
                                                                                    "onClick"
                                                                                ))
                                                                            } else {
                                                                                createCommentVNode("v-if", true)
                                                                            }
                                                                        ))
                                                                    )
                                                                }
                                                                ), "_" to 2), 1024)
                                                            ))
                                                        ), 8, utsArrayOf(
                                                            "onClick"
                                                        ))
                                                    }
                                                    ), 128),
                                                    if (unref(todayOrderCount) == 0) {
                                                        createVNode(_component_x_empty, utsMapOf("key" to 0, "title" to "当前没有订单", "loading" to false, "empty" to true, "showBtn" to false))
                                                    } else {
                                                        createCommentVNode("v-if", true)
                                                    }
                                                ))
                                            )),
                                            createElementVNode("swiper-item", null, utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "order-list"), utsArrayOf(
                                                    if (unref(acitveOrderType) == 1) {
                                                        createVNode(_component_mc_active_animation, utsMapOf("key" to 0, "class" to "data-picker-box", "style" to normalizeStyle("background-color: " + unref(globalData).theme.painColor + ";")), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return utsArrayOf(
                                                                createVNode(_component_mc_date_picker, utsMapOf("modelValue" to unref(queryDate), "onUpdate:modelValue" to fun(`$event`: String){
                                                                    trySetRefValue(queryDate, `$event`)
                                                                }, "date-style" to unref(dateStyles), "start-date" to unref(dateRange)[0], "disabledDays" to unref(disabledDates), "end-date" to unref(dateRange)[1], "onChange" to fun(){
                                                                    queryOrderList(1)
                                                                }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                    return utsArrayOf(
                                                                        createElementVNode("view", utsMapOf("class" to "left-box", "style" to normalizeStyle("width: " + (unref(screenWidth) - 115) + "px;")), utsArrayOf(
                                                                            createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-date.png")), null, 8, utsArrayOf(
                                                                                "src"
                                                                            )),
                                                                            createElementVNode("text", utsMapOf("class" to "text"), toDisplayString(if (unref(queryDate) != "") {
                                                                                unref(queryDate)
                                                                            } else {
                                                                                "请选择日期"
                                                                            }), 1)
                                                                        ), 4)
                                                                    )
                                                                }), "_" to 1), 8, utsArrayOf(
                                                                    "modelValue",
                                                                    "date-style",
                                                                    "start-date",
                                                                    "disabledDays",
                                                                    "end-date",
                                                                    "onChange"
                                                                )),
                                                                createElementVNode("text", utsMapOf("onClick" to fun(){
                                                                    queryOrderList(1)
                                                                }, "class" to "text-btn"), "查询", 8, utsArrayOf(
                                                                    "onClick"
                                                                ))
                                                            )
                                                        }), "_" to 1), 8, utsArrayOf(
                                                            "style"
                                                        ))
                                                    } else {
                                                        createCommentVNode("v-if", true)
                                                    }
                                                    ,
                                                    createElementVNode(Fragment, null, RenderHelpers.renderList(unref(otherOrderList), fun(order, index, __index, _cached): Any {
                                                        return createElementVNode("view", utsMapOf("class" to "order-item", "key" to index, "onClick" to fun(){
                                                            toOrderDetail(order)
                                                        }
                                                        ), utsArrayOf(
                                                            createElementVNode("view", utsMapOf("class" to "order-top"), utsArrayOf(
                                                                createElementVNode("view", utsMapOf("class" to "order-left"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to normalizeClass(utsArrayOf(
                                                                        "order-type",
                                                                        if (order.typeOfBoarding == 2) {
                                                                            "pinche"
                                                                        } else {
                                                                            "duxiang"
                                                                        }
                                                                    ))), toDisplayString(if (order.typeOfBoarding == 2) {
                                                                        "拼车"
                                                                    } else {
                                                                        "独享"
                                                                    }
                                                                    ), 3),
                                                                    createElementVNode("text", utsMapOf("class" to "order-time"), toDisplayString(order.departureDate) + " " + toDisplayString(order.departureStartTime), 1)
                                                                )),
                                                                createElementVNode("text", utsMapOf("class" to normalizeClass(utsArrayOf(
                                                                    "order-status",
                                                                    getStatusClass(order.status)
                                                                ))), toDisplayString(getStatusName(order.status)), 3)
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "divider-line")),
                                                            createElementVNode("view", utsMapOf("class" to "order-route"), utsArrayOf(
                                                                createElementVNode("view", utsMapOf("class" to "from-to"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "city"), toDisplayString(order.startCity), 1),
                                                                    createElementVNode("view", utsMapOf("class" to "path-container"), utsArrayOf(
                                                                        createElementVNode("image", utsMapOf("class" to "dashed-line", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-route-arrow-right.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                                            "src"
                                                                        ))
                                                                    )),
                                                                    createElementVNode("text", utsMapOf("class" to "city"), toDisplayString(order.endCity), 1)
                                                                )),
                                                                createElementVNode("view", utsMapOf("class" to "route-info"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "route-name"), toDisplayString(order.lineGroup), 1),
                                                                    createElementVNode("text", utsMapOf("class" to "route-divider"), "|"),
                                                                    createElementVNode("text", null, utsArrayOf(
                                                                        createElementVNode("text", utsMapOf("class" to "seat-info"), utsArrayOf(
                                                                            "余坐：",
                                                                            createElementVNode("text", utsMapOf("class" to "highlight"), toDisplayString(order.remainingSeats), 1)
                                                                        )),
                                                                        createElementVNode("text", utsMapOf("class" to "seat-info"), "位")
                                                                    )),
                                                                    createElementVNode("text", utsMapOf("class" to "route-divider"), "|"),
                                                                    if (order.orderCount > 0) {
                                                                        createElementVNode("text", utsMapOf("key" to 0), utsArrayOf(
                                                                            createElementVNode("text", utsMapOf("class" to "order-count"), utsArrayOf(
                                                                                "包含",
                                                                                createElementVNode("text", utsMapOf("class" to "highlight"), toDisplayString(order.orderCount), 1)
                                                                            )),
                                                                            createElementVNode("text", utsMapOf("class" to "order-count"), "笔订单")
                                                                        ))
                                                                    } else {
                                                                        createCommentVNode("v-if", true)
                                                                    }
                                                                )),
                                                                if (isTrue(order.status == 0 && order.typeOfBoarding == 2)) {
                                                                    createElementVNode("view", utsMapOf("key" to 0, "class" to "btn-group"), utsArrayOf(
                                                                        createVNode(_component_mc_primary_button, utsMapOf("onClick" to fun(){
                                                                            handleScanBoard(order)
                                                                        }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                            return utsArrayOf(
                                                                                "扫码上车"
                                                                            )
                                                                        }), "_" to 2), 1032, utsArrayOf(
                                                                            "onClick"
                                                                        ))
                                                                    ))
                                                                } else {
                                                                    createCommentVNode("v-if", true)
                                                                }
                                                            ))
                                                        ), 8, utsArrayOf(
                                                            "onClick"
                                                        ))
                                                    }
                                                    ), 128),
                                                    if (unref(otherOrderList).length <= 0) {
                                                        createVNode(_component_x_empty, utsMapOf("key" to 1, "title" to "当前没有订单", "loading" to false, "empty" to true, "showBtn" to false))
                                                    } else {
                                                        createCommentVNode("v-if", true)
                                                    }
                                                ))
                                            ))
                                        ), 8, utsArrayOf(
                                            "current"
                                        ))
                                    ))
                                ))
                            ), 4),
                            createElementVNode("swiper-item", utsMapOf("style" to normalizeStyle(utsMapOf("height" to "auto")), "key" to "1"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "container", "style" to normalizeStyle(utsArrayOf(
                                    "width: " + (unref(screenWidth) - 30) + "px",
                                    utsMapOf("margin" to "20px 15px")
                                ))), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "card", "style" to normalizeStyle(utsMapOf("margin-bottom" to "20px"))), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "card-header"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "left"), utsArrayOf(
                                                createElementVNode("image", utsMapOf("class" to "location-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                )),
                                                createElementVNode("text", null, toDisplayString(unref(hadGetWeather)?.city), 1)
                                            )),
                                            createElementVNode("view", utsMapOf("class" to "right"), toDisplayString(unref(hadGetWeather)?.weather?.toString() + " " + unref(hadGetWeather)?.temperature?.toString()) + "℃ ", 1)
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "card-body"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "grid-func"), utsArrayOf(
                                                createElementVNode(Fragment, null, RenderHelpers.renderList(gridFuncs.slice(0, 3), fun(item, index, __index, _cached): Any {
                                                    return createVNode(_component_mc_active_animation, utsMapOf("class" to "grid-item", "onClick" to fun(){
                                                        item.click?.invoke()
                                                    }
                                                    ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return utsArrayOf(
                                                            createElementVNode("image", utsMapOf("class" to "grid-icon", "src" to (unref(resBaseUrl) + item.icon), "key" to index, "mode" to "aspectFit"), null, 8, utsArrayOf(
                                                                "src"
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "grid-text"), utsArrayOf(
                                                                createElementVNode("text", null, toDisplayString(item.text), 1)
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 2), 1032, utsArrayOf(
                                                        "onClick"
                                                    ))
                                                }
                                                ), 256)
                                            )),
                                            createElementVNode("view", utsMapOf("class" to "grid-func"), utsArrayOf(
                                                createElementVNode(Fragment, null, RenderHelpers.renderList(gridFuncs.slice(3, 6), fun(item, index, __index, _cached): Any {
                                                    return createVNode(_component_mc_active_animation, utsMapOf("class" to "grid-item", "onClick" to fun(){
                                                        item.click?.invoke()
                                                    }
                                                    ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return utsArrayOf(
                                                            createElementVNode("image", utsMapOf("class" to "grid-icon", "src" to (unref(resBaseUrl) + item.icon), "key" to index, "mode" to "aspectFit"), null, 8, utsArrayOf(
                                                                "src"
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "grid-text"), utsArrayOf(
                                                                createElementVNode("text", null, toDisplayString(item.text), 1)
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 2), 1032, utsArrayOf(
                                                        "onClick"
                                                    ))
                                                }
                                                ), 256)
                                            ))
                                        ))
                                    ), 4),
                                    createVNode(_component_x_swiper, utsMapOf("height" to "160", "autoPlay" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode(Fragment, null, RenderHelpers.renderList(advList, fun(item, index, __index, _cached): Any {
                                                return createVNode(_component_x_swiper_item, utsMapOf("order" to index, "key" to index, "onClick" to fun(){
                                                    item.click?.invoke(index)
                                                }
                                                ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        createVNode(_component_x_image, utsMapOf("width" to "100%", "model" to "widthFix", "src" to (unref(resBaseUrl) + item.image)), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
                                                    )
                                                }
                                                ), "_" to 2), 1032, utsArrayOf(
                                                    "order",
                                                    "onClick"
                                                ))
                                            }
                                            ), 64)
                                        )
                                    }
                                    ), "_" to 1))
                                ), 4)
                            ), 4)
                        ), 8, utsArrayOf(
                            "current"
                        ))
                    ), 12, utsArrayOf(
                        "direction"
                    )),
                    createVNode(_component_x_modal, utsMapOf("show" to unref(showAgreeLocationModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showAgreeLocationModal, `$event`)
                    }
                        , "bgColor" to "#ECF1F8", "cancel-text" to "拒绝", "overlay-click" to false, "onCancel" to locationAgreeCancel, "confirm-text" to "同意", "onConfirm" to locationAgreeConfirm, "show-title" to false, "height" to "450rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "location-agree-title"), "定位权限获取申请"),
                            createElementVNode("view", utsMapOf("class" to "desc"), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "pb-10"), "我们获取您的位置信息是用于匹配附近的订单、记录轨迹、规划导航路线。"),
                                createElementVNode("text", null, "如果您拒绝我们获取您的上述信息，将导致您无法作为驾驶员向乘客提供服务。")
                            ))
                        )
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "show"
                    ))
                ), 64)
            }
        }
        var name = "had-settled"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("container" to padStyleMapOf(utsMapOf("width" to "100%", "position" to "relative")), "home-bg" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1)), "top-bg" to utsMapOf(".home-bg " to utsMapOf("height" to 300, "width" to "100%")), "header" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to 10, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 23)), "avatar-box" to utsMapOf(".header " to utsMapOf("width" to 50, "height" to 50, "borderTopStyle" to "none", "borderRightStyle" to "none", "borderBottomStyle" to "none", "borderLeftStyle" to "none", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000")), "avatar" to utsMapOf(".header .avatar-box " to utsMapOf("width" to "100%", "height" to "100%")), "card" to padStyleMapOf(utsMapOf("width" to "100%", "backgroundColor" to "#ffffff", "boxShadow" to "0px 11px 35px 0px rgba(253, 214, 190, 0.23)", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FFFFFF", "borderRightColor" to "#FFFFFF", "borderBottomColor" to "#FFFFFF", "borderLeftColor" to "#FFFFFF", "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20)), "card-header" to utsMapOf(".card " to utsMapOf("paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "width" to "100%", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "marginBottom" to 10)), "left" to utsMapOf(".card .card-header " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "location-icon" to utsMapOf(".card .card-header .left " to utsMapOf("width" to 13, "height" to 15, "marginRight" to 5)), "arrow-icon" to utsMapOf(".card .card-header .left " to utsMapOf("width" to 8, "height" to 4, "marginLeft" to 5)), "features" to utsMapOf(".card .card-body " to utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to 20, "paddingRight" to 0, "paddingBottom" to 20, "paddingLeft" to 0)), "feature-item" to utsMapOf(".card .card-body .features " to utsMapOf("display" to "flex", "alignItems" to "center", "flex" to 1)), "feature-icon" to utsMapOf(".card .card-body .features .feature-item " to utsMapOf("width" to 28.5, "height" to 29.5, "marginBottom" to 10)), "feature-text" to utsMapOf(".card .card-body .features .feature-item " to utsMapOf("display" to "flex", "flexDirection" to "column", "fontSize" to 15)), "grid-func" to utsMapOf(".card .card-body " to utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to 20, "paddingRight" to 0, "paddingBottom" to 20, "paddingLeft" to 0)), "grid-item" to utsMapOf(".card .card-body .grid-func " to utsMapOf("display" to "flex", "alignItems" to "center", "flex" to 1)), "grid-icon" to utsMapOf(".card .card-body .grid-func .grid-item " to utsMapOf("width" to 35, "height" to 39, "marginBottom" to 10)), "grid-text" to utsMapOf(".card .card-body .grid-func .grid-item " to utsMapOf("display" to "flex", "flexDirection" to "column", "fontSize" to 15, "color" to "#141414")), "data-picker-box" to padStyleMapOf(utsMapOf("width" to "100%", "backgroundColor" to "#F4F7FD", "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "marginBottom" to 15)), "left-box" to utsMapOf(".data-picker-box " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "paddingTop" to 13, "paddingRight" to 15, "paddingBottom" to 13, "paddingLeft" to 15)), "icon" to utsMapOf(".data-picker-box .left-box " to utsMapOf("width" to 15, "height" to 15, "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10)), "text" to utsMapOf(".data-picker-box " to utsMapOf("fontWeight" to "400", "fontSize" to 15, "color" to "#000000"), ".order-tab .active-tab-left " to utsMapOf("color" to "#000000", "fontWeight" to "700", "fontSize" to 20, "textAlign" to "center"), ".order-tab .active-tab-right " to utsMapOf("color" to "#000000", "fontWeight" to "700", "fontSize" to 20, "textAlign" to "center"), ".order-tab .tab-item " to utsMapOf("fontSize" to 20, "color" to "#979DA4")), "text-btn" to utsMapOf(".data-picker-box " to utsMapOf("fontWeight" to "400", "fontSize" to 15, "color" to "#000000", "paddingLeft" to 25, "paddingRight" to 25, "borderLeftWidth" to 0.5, "borderLeftStyle" to "solid", "borderLeftColor" to "#D2D8E3")), "order-tab" to padStyleMapOf(utsMapOf("paddingTop" to 10, "paddingBottom" to 10, "backgroundColor" to "#FFFFFF", "position" to "relative")), "tab-group" to utsMapOf(".order-tab " to utsMapOf("display" to "flex", "flexDirection" to "row", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "boxShadow" to "0px -2.5px 5px 0px rgba(155, 177, 214, 0.23)")), "bg-img-left" to utsMapOf(".order-tab " to utsMapOf("position" to "absolute", "bottom" to 5, "zIndex" to 1, "width" to "58%", "height" to 76, "left" to -10)), "bg-img-right" to utsMapOf(".order-tab " to utsMapOf("position" to "absolute", "bottom" to 5, "zIndex" to 1, "width" to "58%", "height" to 76, "right" to -10)), "active-tab-left" to utsMapOf(".order-tab " to utsMapOf("position" to "absolute", "bottom" to 10, "paddingBottom" to 10, "zIndex" to 3, "left" to 0)), "active-tab-right" to utsMapOf(".order-tab " to utsMapOf("position" to "absolute", "bottom" to 10, "paddingBottom" to 10, "zIndex" to 3, "right" to 0)), "active-line" to utsMapOf(".order-tab " to utsMapOf("position" to "absolute", "bottom" to 0, "left" to "50%", "transform" to "translateX(-50%)", "width" to 60, "height" to 3, "backgroundColor" to "#000000", "borderTopLeftRadius" to 2, "borderTopRightRadius" to 2, "borderBottomRightRadius" to 2, "borderBottomLeftRadius" to 2)), "tab-item" to utsMapOf(".order-tab " to utsMapOf("flex" to 1, "textAlign" to "center", "paddingTop" to 18, "paddingRight" to 0, "paddingBottom" to 9, "paddingLeft" to 0, "position" to "relative", "display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center")), "order-box" to padStyleMapOf(utsMapOf("width" to "100%", "backgroundColor" to "#ffffff", "overflow" to "visible")), "order-list" to utsMapOf(".order-box " to utsMapOf("minHeight" to "800rpx", "paddingTop" to 5, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "backgroundColor" to "#FFFFFF")), "order-item" to utsMapOf(".order-box .order-list " to utsMapOf("backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "marginBottom" to 15, "boxShadow" to "0px 0px 20px 0px rgba(155, 153, 208, 0.35)", "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "marginBottom:last-child" to 5)), "order-top" to utsMapOf(".order-box .order-list .order-item " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "paddingBottom" to 10, "borderBottomWidth" to 0.5, "borderBottomStyle" to "solid", "borderBottomColor" to "#DADADA")), "divider-line" to utsMapOf(".order-box .order-list .order-item " to utsMapOf("height" to 1, "backgroundColor" to "#F5F5F5", "width" to "100%")), "order-left" to utsMapOf(".order-box .order-list .order-item " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "order-type" to utsMapOf(".order-box .order-list .order-item " to utsMapOf("paddingRight" to 8, "marginRight" to 8, "fontWeight" to "700", "fontSize" to 15, "borderRightWidth" to 0.5, "borderRightStyle" to "solid", "borderRightColor" to "#C8C8C8", "color" to "#C70000"), ".order-box .order-list .order-item .pinche" to utsMapOf("color" to "#C70000"), ".order-box .order-list .order-item .duxiang" to utsMapOf("color" to "#C78300")), "order-time" to utsMapOf(".order-box .order-list .order-item " to utsMapOf("fontSize" to 16, "color" to "#000000")), "order-status" to utsMapOf(".order-box .order-list .order-item " to utsMapOf("paddingTop" to 4, "paddingRight" to 15, "paddingBottom" to 4, "paddingLeft" to 15, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "fontSize" to 15, "color" to "#FFFFFF"), ".order-box .order-list .order-item .processing" to utsMapOf("backgroundColor" to "#89B06D"), ".order-box .order-list .order-item .waiting" to utsMapOf("backgroundColor" to "#64ADEF"), ".order-box .order-list .order-item .pending" to utsMapOf("backgroundColor" to "#84A1C3")), "order-route" to utsMapOf(".order-box .order-list .order-item " to utsMapOf("paddingTop" to 15)), "from-to" to utsMapOf(".order-box .order-list .order-item .order-route " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "marginBottom" to 15)), "city" to utsMapOf(".order-box .order-list .order-item .order-route .from-to " to utsMapOf("fontSize" to 18, "fontWeight" to "700", "color" to "#222222")), "path-container" to utsMapOf(".order-box .order-list .order-item .order-route .from-to " to utsMapOf("position" to "relative", "width" to 32, "height" to 20, "marginTop" to 0, "marginRight" to 12, "marginBottom" to 0, "marginLeft" to 12, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "dashed-line" to utsMapOf(".order-box .order-list .order-item .order-route .from-to .path-container " to utsMapOf("width" to 30, "height" to 10, "position" to "absolute")), "route-info" to utsMapOf(".order-box .order-list .order-item .order-route " to utsMapOf("paddingTop" to 0, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "marginBottom" to 20)), "route-name" to utsMapOf(".order-box .order-list .order-item .order-route .route-info " to utsMapOf("fontSize" to 16, "color" to "#7E7E7E")), "seat-info" to utsMapOf(".order-box .order-list .order-item .order-route .route-info " to utsMapOf("fontSize" to 16, "color" to "#7E7E7E")), "order-count" to utsMapOf(".order-box .order-list .order-item .order-route .route-info " to utsMapOf("fontSize" to 16, "color" to "#7E7E7E")), "route-divider" to utsMapOf(".order-box .order-list .order-item .order-route .route-info " to utsMapOf("marginTop" to 0, "marginRight" to 8, "marginBottom" to 0, "marginLeft" to 8, "color" to "#7E7E7E", "fontSize" to 16)), "highlight" to utsMapOf(".order-box .order-list .order-item .order-route .route-info " to utsMapOf("color" to "#C78300", "fontWeight" to "700", "fontSize" to 16)), "btn-group" to utsMapOf(".order-box .order-list .order-item .order-route " to utsMapOf("flexGrow" to 1, "width" to "100%", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between")), "location-agree-title" to padStyleMapOf(utsMapOf("textAlign" to "center", "width" to "100%", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
