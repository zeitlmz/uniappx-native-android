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
import io.dcloud.uniapp.extapi.`$on` as uni__on
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xToastS.XTOAST_TYPE
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import uts.sdk.modules.mcAmapNav.initKey
import uts.sdk.modules.mcAmapNav.checkLocationPermission
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
    open var onInit: () -> Unit
        get() {
            return unref(this.`$exposed`["onInit"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "onInit", value)
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
            val ins = getCurrentInstance()?.proxy
            val currentDeg = ref("0deg")
            val acitveTab = ref<String>("0")
            val acitveOrderType = ref<Number>(0)
            val showValidModal = ref<Boolean>(false)
            val startLocation = ref<Boolean>(false)
            val showAgreeLocationModal = ref<Boolean>(false)
            val defaultHeadImg = resBaseUrl + "/static/images/img-default-avatar3.png"
            val auditHeadImg = resBaseUrl + "/static/images/img-audit-avatar.png"
            val headImg = ref<String>(defaultHeadImg)
            val tabs = _uA(
                TABS_ITEM_INFO(title = "首页")
            )
            val isInit = ref(false)
            val currentSwiper = ref<Number>(0)
            val onTabChange = fun(_: TABS_ITEM, index: Number){
                currentSwiper.value = index
            }
            val queryDate = ref<String>("")
            val dateRange = ref(_uA<String>("", ""))
            val disabledDates = ref(_uA<String>())
            val hadGetWeather = ref<WeatherData>(WeatherData(province = "", city = "", adcode = "", weather = "", temperature = "", winddirection = "", windpower = "", humidity = "", reporttime = "", temperature_float = 0, humidity_float = 0))
            val advList = _uA(
                ADV_ITEM(image = "/static/images/adv-driver-join-2.png", click = fun(index: Number){
                    console.log(index)
                }
                )
            )
            val homeGrid = _uA(
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
            val gridFuncs = _uA(
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
                    var planId = order.planId?.toString()
                    var summaryId = order.summaryId?.toString()
                    var orderStatus = order.status
                    var typeOfBoarding = order.typeOfBoarding
                    var queryDate = order.departureDate
                }
                router.push("/pages/other/order-detail/index?planId=" + query["planId"] + "&summaryId=" + query["summaryId"] + "&orderStatus=" + query["orderStatus"] + "&typeOfBoarding=" + query["typeOfBoarding"] + "&queryDate=" + query["queryDate"])
            }
            val nowDate = ref<String>(formatDate(Date(), "yyyy-MM-dd"))
            val checkTimeBefore = fun(date1: String): Boolean {
                return isTimeBefore(date1, nowDate.value)
            }
            val carList = ref(_uA<CanChangeVehicleInfo>())
            val currentOrder = ref<IntercityOrderSummaryInfo?>(null)
            val selectCar = ref<CanChangeVehicleInfo?>(null)
            val showChangeCarDrawer = ref<Boolean>(false)
            val openChangeCarDrawer = fun(orderItem: IntercityOrderSummaryInfo): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        console.log("orderItem:", orderItem)
                        currentOrder.value = orderItem
                        getCanChangeVehicleList(orderItem.planId).then(fun(res: Response){
                            console.log("更换车辆列表：", res.data)
                            val data = JSON.parse<UTSArray<CanChangeVehicleInfo>>(JSON.stringify(res.data)) as UTSArray<CanChangeVehicleInfo>
                            carList.value = data
                        }
                        )
                        showChangeCarDrawer.value = true
                })
            }
            val handleStartPickup = fun(order: IntercityOrderSummaryInfo){
                showLoading(XLOADINGS_TYPE(title = "正在出车中..."))
                ws?.sendAndOnErr(WebSocketSendMessage(type = MessageType["BEFORE_CHECK"] as Number), fun(data){
                    console.log("检车成功：", data)
                    restartListening(order.summaryId.toString()).then(fun(){
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
            val changeCarEvt = fun(item: CanChangeVehicleInfo){
                selectCar.value = item
            }
            val onChangeCarCancel = fun(){
                currentOrder.value = null
                selectCar.value = null
                showChangeCarDrawer.value = false
            }
            val onChangeCarConfirm = fun(){
                showLoading(XLOADINGS_TYPE(title = "正在更换车辆..."))
                Ws.ws.sendAndOnErr(WebSocketSendMessage(type = MessageType["CHANGE_CAR"] as Number, content = object : UTSJSONObject() {
                    var planId = currentOrder.value?.planId
                    var vehicleId = selectCar.value?.id
                }), fun(data){
                    console.log("更换车辆成功：", data)
                    onChangeCarCancel()
                    showTips("更好车辆成功", "success")
                    hideXloading()
                }
                , fun(data){
                    showTips("更好车辆失败", "error")
                    hideXloading()
                }
                )
            }
            val handleScanBoard = fun(order: IntercityOrderSummaryInfo){
                if (order.remainingSeats <= 0) {
                    return showToast("车辆已满座，无法继续下单", "error")
                }
                val query: UTSJSONObject = object : UTSJSONObject() {
                    var planId = order.planId.toString()
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
            val orderList = ref(_uA<IntercityOrderSummaryInfo>())
            val otherOrderList = ref(_uA<IntercityOrderSummaryInfo>())
            val toPersonPage = fun(){
                router.push("/pages/personal/index")
            }
            val dateStyles = ref(_uA<xCalendarDateStyle_type>())
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
                    val res = JSON.parse<QueryResponse<Any>>(data)
                    console.log("首页查询订单信息==>", res)
                    if (res?.queryType == 0) {
                        val orderInfo = JSON.parse<QueryResponse<OrderSummary>>(data)
                        todayOrderCount.value = orderInfo?.data?.todayOrderCount ?: 0
                        otherOrderCount.value = orderInfo?.data?.otherOrderCount ?: 0
                        orderList.value = orderInfo?.data?.intercityOrderSummaryInfos ?: _uA()
                    } else if (res?.queryType == 1) {
                        val orderInfo = JSON.parse<QueryResponse<OrderSummary>>(data)
                        todayOrderCount.value = orderInfo?.data?.todayOrderCount ?: 0
                        otherOrderCount.value = orderInfo?.data?.otherOrderCount ?: 0
                        otherOrderList.value = orderInfo?.data?.intercityOrderSummaryInfos ?: _uA()
                    } else if (res?.queryType == 6) {
                        val resData = JSON.parse<QueryResponse<UTSArray<IntercityOrderReceiveInfo>>>(data)
                        console.log("orderReceiveQuery==>", resData)
                        uni__emit("orderReceiveList", resData?.data)
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
                    val dateStyleList: UTSArray<xCalendarDateStyle_type> = _uA()
                    val dateList: UTSArray<String> = _uA()
                    orderInfo?.data?.forEach(fun(item: DateCountDTO){
                        dateList.push(item.date)
                        dateStyleList.push(xCalendarDateStyle_type(date = item.date, dot = true, dotColor = "orange", dotLabel = item.count))
                    }
                    )
                    dateStyles.value = dateStyleList
                    if (dateStyleList.length > 0) {
                        dateRange.value = _uA(
                            dateStyleList[0].date,
                            dateStyleList[dateStyleList.length - 1].date
                        )
                        queryDate.value = dateStyleList[0].date
                        if (dateStyleList.length > 1) {
                            disabledDates.value = getMissingDates(dateList)
                        }
                    } else {
                        val tomorrow = getTimePlusRangeFormat(Date(), "one-day", "yyyy-MM-dd")
                        dateRange.value = _uA(
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
            val onLocation = fun(location: String){
                val locationInfo = JSON.parse<LocationInfo>(location)
                if (locationInfo != null) {
                    globalData.position = locationInfo
                    if (ws.getIsConnected()) {
                        ws?.send(WebSocketSendMessage(type = MessageType["LOCATION_SYNC"] as Number, content = object : UTSJSONObject() {
                            var region = locationInfo?.adcode ?: ""
                            var location = "" + (locationInfo?.longitude ?: "0") + "," + (locationInfo?.latitude ?: "0")
                            var locationAddress = locationInfo?.address ?: ""
                        }))
                    }
                    if (hadGetWeather.value.temperature == "" && globalData.position.adcode != "" && globalData.position.adcode != null) {
                        getWeather(globalData.position.adcode).then(fun(res: UTSJSONObject){
                            hadGetWeather.value = res.getArray<WeatherData>("lives")?.get(0) as WeatherData
                            orderQuery()
                        }
                        )
                    }
                }
            }
            val orderReceiveQuery = fun(){
                ws?.send(WebSocketSendMessage(type = MessageType["QUERY_ORDER"] as Number, content = object : UTSJSONObject() {
                    var queryType = OrderQueryType["ORDER_RECEIVE_LIST"] as Number
                }))
            }
            val initWs = fun(){
                ws.setOpenCallback(fun(){
                    console.log("首页监听到连接打开事件=======")
                    isInit.value = true
                    orderQuery()
                    orderReceiveQuery()
                    showTips("服务连接成功", "success")
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
                            showModal(X_MODAL_TYPE(title = "温馨提示", content = data?.toString(), confirmText = "知道了", showCancel = false, confirmBgColor = globalData.theme.primaryColor, confirm = fun(){
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
                    val res = JSON.parse<OrderCancelResponse>(data)
                    console.log("您有订单已被取消：", res)
                    var title = "您有一笔订单已被取消"
                    var audioPath = "/static/audio/order-cancel.mp3"
                    if (res?.mode == 1) {
                        title = "您有多笔订单已被取消"
                        audioPath = "/static/audio/order-cancel-multi.mp3"
                    }
                    showModal(X_MODAL_TYPE(title = "温馨提示", content = title, confirmText = "知道了", confirmBgColor = globalData.theme.primaryColor, showCancel = false, confirm = fun(){
                        orderQuery()
                    }
                    ))
                    McAudio.play(audioPath, false)
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
                }
                )
                ws?.sendAndOn(WebSocketSendMessage(type = MessageType["QUERY_CAR_SETTING"] as Number, content = ""), fun(data){
                    val json = JSON.parse<UTSJSONObject>(data)
                    globalData.carSetting.closeReceiveOrderSwitch = json?.getBoolean("closeReceiveOrderSwitch") ?: true
                    globalData.carSetting.enableAIRouteStrategy = json?.getBoolean("enableAIRouteStrategy") ?: false
                    globalData.carSetting.enableReceiveOrderConfirm = json?.getBoolean("enableReceiveOrderConfirm") ?: false
                    globalData.carSetting.routeStrategy = json?.getString("routeStrategy") ?: "OVERALL_OPTIMAL"
                }
                )
                ws?.on(MessageType["ORDER_NOTICE"] as Number, fun(data){
                    val resData = JSON.parse<IntercityOrderReceiveInfo>(data)
                    console.log("orderReceive==>", resData)
                    orderReceiveQuery()
                }
                )
            }
            var anmiInter: Number = 0
            val anmiInterval = fun(){
                if (anmiInter > 0) {
                    clearInterval(anmiInter)
                }
                anmiInter = setInterval(fun(){
                    nowDate.value = formatDate(Date(), "yyyy-MM-dd")
                    if (currentDeg.value == "0deg") {
                        currentDeg.value = "360deg"
                    } else {
                        currentDeg.value = "0deg"
                    }
                }
                , 7000)
            }
            fun gen_headImgInit_fn() {
                getHeadImg().then(fun(res: Response){
                    if (res.code == 200 && res.data != null) {
                        val data = res.data as UTSJSONObject
                        console.log("getHeadImg res =", res)
                        val status = data.getNumber("status") ?: -1
                        if (status == 1 || status == 2) {
                            if (data.getString("headImg") != null && data.getString("headImg") != "") {
                                headImg.value = data.getString("headImg")!!
                            } else {
                                headImg.value = defaultHeadImg
                            }
                        }
                        if (status == 0) {
                            headImg.value = auditHeadImg
                        }
                    }
                }
                ).`catch`(fun(err: Any?){
                    console.log("err===", err)
                }
                )
            }
            val headImgInit = ::gen_headImgInit_fn
            val onShow = fun(){
                console.log("home-onShow======")
                initWs()
                if (isInit.value) {
                    orderQuery()
                    orderReceiveQuery()
                    anmiInterval()
                }
                if (globalData.position.adcode != "" && globalData.position.adcode != null) {
                    getWeather(globalData.position.adcode).then(fun(res: UTSJSONObject){
                        hadGetWeather.value = res.getArray<WeatherData>("lives")?.get(0) as WeatherData
                    }
                    )
                }
                if (globalData.isLogin) {
                    setTimeout(fun(){
                        headImgInit()
                    }
                    , 200)
                }
            }
            val locationAgreeCancel = fun(){
                setTimeout(fun(){
                    showXToast(XTOAST_TYPE(title = "您已拒绝定位获取权限，将无法进行后面的业务", iconCode = "info", iconColor = "#ff8900", duration = 2500))
                }
                , 250)
            }
            val locationAgreeConfirm = fun(){
                checkLocationPermission(fun(all: Boolean){
                    if (all) {
                        console.log("同意权限=======", all)
                        startLocation.value = true
                        setLocationGrantStatus("agree")
                    } else {
                        locationAgreeCancel()
                    }
                }
                )
            }
            val handlePromotion = fun(){
                console.log("跳转推广页")
                router.push("/pages/personal/promotion/index")
            }
            val initMap = fun(){
                initKey(MAP_CONFIG["naviKey"] as String)
            }
            onMounted(fun(){
                initMap()
                uni__on("orderReceiveQuery", fun(){
                    orderReceiveQuery()
                }
                )
                anmiInterval()
                console.log("首页面渲染onMounted")
                if (isLocationAgree()) {
                    locationAgreeConfirm()
                } else {
                    showAgreeLocationModal.value = true
                }
            }
            )
            val onHide = fun(){
                if (anmiInter > 0) {
                    clearInterval(anmiInter)
                }
            }
            val onInit = fun(){}
            __expose(_uM("onShow" to onShow, "onHide" to onHide, "onInit" to onInit))
            return fun(): Any? {
                val _component_mc_amap_location = resolveEasyComponent("mc-amap-location", GenComponentsMcAmapLocationIndexClass)
                val _component_x_float_button = resolveEasyComponent("x-float-button", GenUniModulesTmxUiComponentsXFloatButtonXFloatButtonClass)
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_x_tabs = resolveEasyComponent("x-tabs", GenUniModulesTmxUiComponentsXTabsXTabsClass)
                val _component_mc_active_animation = resolveEasyComponent("mc-active-animation", GenComponentsMcActiveAnimationIndexClass)
                val _component_mc_pain_button = resolveEasyComponent("mc-pain-button", GenComponentsMcPainButtonIndexClass)
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                val _component_x_empty = resolveEasyComponent("x-empty", GenUniModulesTmxUiComponentsXEmptyXEmptyClass)
                val _component_mc_date_picker = resolveEasyComponent("mc-date-picker", GenComponentsMcDatePickerIndexClass)
                val _component_x_image = resolveEasyComponent("x-image", GenUniModulesTmxUiComponentsXImageXImageClass)
                val _component_x_swiper_item = resolveEasyComponent("x-swiper-item", GenUniModulesTmxUiComponentsXSwiperItemXSwiperItemClass)
                val _component_x_swiper = resolveEasyComponent("x-swiper", GenUniModulesTmxUiComponentsXSwiperXSwiperClass)
                val _component_x_overlay = resolveEasyComponent("x-overlay", GenUniModulesTmxUiComponentsXOverlayXOverlayClass)
                val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
                val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass)
                val _component_x_drawer = resolveEasyComponent("x-drawer", GenUniModulesTmxUiComponentsXDrawerXDrawerClass)
                val _component_mc_order_notice = resolveEasyComponent("mc-order-notice", GenComponentsMcOrderNoticeIndexClass)
                return _cE(Fragment, null, _uA(
                    if (isTrue(unref(startLocation))) {
                        _cV(_component_mc_amap_location, _uM("key" to 0, "onLocation" to onLocation))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cV(_component_x_float_button, _uM("onClick" to handlePromotion, "round" to "0", "bg-color" to "#00000000", "width" to "150rpx", "height" to "170rpx", "offset" to _uA(
                        -1,
                        unref(screenHeight) / 1.5
                    )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "flex flex-center inv-box", "style" to _nS(_uM("width" to "100%", "height" to "100%"))), _uA(
                                _cE("image", _uM("class" to "anime-box", "style" to _nS("transform: rotateY(" + unref(currentDeg) + ")"), "src" to "/static/icons/icon-inv-bg.png", "mode" to "widthFix"), null, 4),
                                _cE("image", _uM("class" to "btn", "src" to "/static/icons/icon-inv-btn.png", "mode" to "widthFix"))
                            ), 4)
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "offset"
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uA(
                        _uM("flex" to "1"),
                        "width: " + unref(screenWidth) + "px;height: " + unref(screenHeight) + "px;background-color: #ffffff;"
                    )), "bounces" to true, "direction" to if (unref(currentSwiper) == 1) {
                        "none"
                    } else {
                        "vertical"
                    }
                    , "show-scrollbar" to false), _uA(
                        _cE("view", _uM("style" to _nS("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        _cE("view", _uM("class" to "home-bg"), _uA(
                            _cE("view", _uM("class" to "top-bg", "style" to _nS("background-image: linear-gradient(to bottom," + unref(globalData).theme.painColor2 + ", #FFFFFF);")), null, 4)
                        )),
                        _cE("view", _uM("class" to "header"), _uA(
                            _cV(_component_x_tabs, _uM("modelValue" to unref(acitveTab), "onUpdate:modelValue" to fun(`$event`: String){
                                trySetRefValue(acitveTab, `$event`)
                            }
                            , "onChange" to onTabChange, "line-full" to false, "line-height" to "3", "line-color" to "#000000", "color" to "#00000000", "list" to tabs), _uM("default" to withScopedSlotCtx(fun(slotProps: GenUniModulesTmxUiComponentsXTabsXTabsSlotDataDefault): UTSArray<Any> {
                                val item = slotProps.item
                                val active = slotProps.active
                                return _uA(
                                    _cV(_component_x_text, _uM("style" to _nS(_uA(
                                        if (active) {
                                            "font-weight:bold;font-size:22;"
                                        } else {
                                            "font-size:16;font-weight:400;"
                                        }
                                        ,
                                        _uM("padding" to "0 10px")
                                    ))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(item.title)
                                        )
                                    }
                                    ), "_" to 2), 1032, _uA(
                                        "style"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "modelValue"
                            )),
                            _cV(_component_mc_active_animation, _uM("onClick" to toPersonPage, "class" to "avatar-box"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("image", _uM("class" to "avatar", "src" to unref(headImg)), null, 8, _uA(
                                        "src"
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )),
                        _cE("swiper", _uM("current" to unref(currentSwiper), "disable-touch" to true), _uA(
                            _cE("swiper-item", _uM("style" to _nS(_uM("height" to "auto")), "key" to "0"), _uA(
                                _cE("view", _uM("class" to "container"), _uA(
                                    _cE("view", _uM("class" to "card", "style" to _nS(_uM("margin-top" to "20px", "background" to "#00000000", "border" to "none", "box-shadow" to "none"))), _uA(
                                        _cE("view", _uM("class" to "card-header"), _uA(
                                            _cV(_component_mc_active_animation, _uM("class" to "left"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("image", _uM("class" to "location-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location.png"), "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    )),
                                                    _cE("text", null, _tD(unref(hadGetWeather).city), 1)
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cE("view", _uM("class" to "right"), _tD(unref(hadGetWeather)?.weather?.toString() + " " + unref(hadGetWeather)?.temperature?.toString()) + "℃ ", 1)
                                        )),
                                        _cE("view", _uM("class" to "card-body"), _uA(
                                            _cE("view", _uM("class" to "grid-func"), _uA(
                                                _cE(Fragment, null, RenderHelpers.renderList(homeGrid, fun(item, index, __index, _cached): Any {
                                                    return _cV(_component_mc_active_animation, _uM("class" to "grid-item", "onClick" to fun(){
                                                        item.click?.invoke()
                                                    }
                                                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _cE("image", _uM("class" to "grid-icon", "src" to (unref(resBaseUrl) + item.icon), "key" to index, "mode" to "aspectFit"), null, 8, _uA(
                                                                "src"
                                                            )),
                                                            _cE("view", _uM("class" to "grid-text"), _uA(
                                                                _cE("text", null, _tD(item.text), 1)
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 2), 1032, _uA(
                                                        "onClick"
                                                    ))
                                                }
                                                ), 64)
                                            ))
                                        ))
                                    ), 4),
                                    _cE("view", _uM("class" to "order-tab"), _uA(
                                        if (unref(acitveOrderType) == 0) {
                                            _cE("image", _uM("key" to 0, "class" to "bg-img-left", "src" to ("" + unref(resBaseUrl) + "/static/images/home-tab-bg-left.png")), null, 8, _uA(
                                                "src"
                                            ))
                                        } else {
                                            if (unref(acitveOrderType) == 1) {
                                                _cE("image", _uM("key" to 1, "class" to "bg-img-right", "src" to ("" + unref(resBaseUrl) + "/static/images/home-tab-bg-right.png")), null, 8, _uA(
                                                    "src"
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            }
                                        }
                                        ,
                                        if (unref(acitveOrderType) == 0) {
                                            _cV(_component_mc_active_animation, _uM("key" to 2, "class" to "active-tab-left", "style" to _nS("width:" + unref(screenWidth) / 2 + "px;")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("text", _uM("class" to "text"), "当日订单(" + _tD(unref(todayOrderCount)) + ")", 1),
                                                    _cE("view", _uM("class" to "active-line"))
                                                )
                                            }), "_" to 1), 8, _uA(
                                                "style"
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                        ,
                                        if (unref(acitveOrderType) == 1) {
                                            _cV(_component_mc_active_animation, _uM("key" to 3, "class" to "active-tab-right", "style" to _nS("width:" + unref(screenWidth) / 2 + "px;")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("text", _uM("class" to "text"), "预约订单(" + _tD(unref(otherOrderCount)) + ")", 1),
                                                    _cE("view", _uM("class" to "active-line"))
                                                )
                                            }), "_" to 1), 8, _uA(
                                                "style"
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                        ,
                                        _cE("view", _uM("class" to "tab-group"), _uA(
                                            _cE("view", _uM("onClick" to fun(){
                                                onOrderTypeChange(0)
                                            }
                                            , "class" to "tab-item"), _uA(
                                                _cE("text", _uM("class" to "text"), "当日订单(" + _tD(unref(todayOrderCount)) + ")", 1)
                                            ), 8, _uA(
                                                "onClick"
                                            )),
                                            _cE("view", _uM("onClick" to fun(){
                                                onOrderTypeChange(1)
                                            }
                                            , "class" to "tab-item"), _uA(
                                                _cE("text", _uM("class" to "text"), "预约订单(" + _tD(unref(otherOrderCount)) + ")", 1)
                                            ), 8, _uA(
                                                "onClick"
                                            ))
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "order-box"), _uA(
                                        _cE("swiper", _uM("current" to unref(acitveOrderType), "onChange" to fun(e: UniSwiperChangeEvent){
                                            return onOrderTypeChange(e.detail.current)
                                        }
                                        , "disable-touch" to false, "rebound" to ""), _uA(
                                            _cE("swiper-item", null, _uA(
                                                _cE("view", _uM("class" to "order-list"), _uA(
                                                    _cE(Fragment, null, RenderHelpers.renderList(unref(orderList), fun(order, __key, __index, _cached): Any {
                                                        return _cE("view", _uM("class" to "order-item", "onClick" to fun(){
                                                            toOrderDetail(order)
                                                        }
                                                        , "key" to order.summaryId), _uA(
                                                            _cE("view", _uM("class" to "order-top"), _uA(
                                                                _cE("view", _uM("class" to "order-left"), _uA(
                                                                    _cE("text", _uM("class" to _nC(_uA(
                                                                        "order-type",
                                                                        if (order.typeOfBoarding == 2) {
                                                                            "pinche"
                                                                        } else {
                                                                            "duxiang"
                                                                        }
                                                                    ))), _tD(if (order.typeOfBoarding == 2) {
                                                                        "拼车"
                                                                    } else {
                                                                        "独享"
                                                                    }
                                                                    ), 3),
                                                                    _cE("text", _uM("class" to "order-time"), _tD(order.departureDate) + " " + _tD(order.departureStartTime), 1)
                                                                )),
                                                                _cE("text", _uM("class" to _nC(_uA(
                                                                    "order-status",
                                                                    getStatusClass(order.status)
                                                                ))), _tD(getStatusName(order.status)), 3)
                                                            )),
                                                            _cE("view", _uM("class" to "divider-line")),
                                                            _cE("view", _uM("class" to "order-route"), _uA(
                                                                _cE("view", _uM("class" to "from-to"), _uA(
                                                                    _cE("text", _uM("class" to "city"), _tD(order.startCity), 1),
                                                                    _cE("view", _uM("class" to "path-container"), _uA(
                                                                        _cE("image", _uM("class" to "dashed-line", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-route-arrow-right.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                            "src"
                                                                        ))
                                                                    )),
                                                                    _cE("text", _uM("class" to "city"), _tD(order.endCity), 1)
                                                                )),
                                                                _cE("view", _uM("class" to "route-info"), _uA(
                                                                    _cE("text", _uM("class" to "route-name"), _tD(order.lineGroup), 1),
                                                                    _cE("text", _uM("class" to "route-divider"), "|"),
                                                                    _cE("text", null, _uA(
                                                                        _cE("text", _uM("class" to "seat-info"), _uA(
                                                                            "余坐：",
                                                                            _cE("text", _uM("class" to "highlight"), _tD(order.remainingSeats), 1)
                                                                        )),
                                                                        _cE("text", _uM("class" to "seat-info"), "位")
                                                                    )),
                                                                    _cE("text", _uM("class" to "route-divider"), "|"),
                                                                    if (order.orderCount > 0) {
                                                                        _cE("text", _uM("key" to 0), _uA(
                                                                            _cE("text", _uM("class" to "order-count"), _uA(
                                                                                "包含",
                                                                                _cE("text", _uM("class" to "highlight"), _tD(order.orderCount), 1)
                                                                            )),
                                                                            _cE("text", _uM("class" to "order-count"), "笔订单")
                                                                        ))
                                                                    } else {
                                                                        _cC("v-if", true)
                                                                    }
                                                                )),
                                                                _cE("view", null, _uA(
                                                                    _cE("view", _uM("class" to "btn-group"), _uA(
                                                                        if (order.status == 0) {
                                                                            _cV(_component_mc_pain_button, _uM("key" to 0, "bgColor" to "#fcf1f1", "color" to "#e57875", "margin-right" to "10px", "onClick" to fun(){
                                                                                openChangeCarDrawer(order)
                                                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                return _uA(
                                                                                    "更换车辆"
                                                                                )
                                                                            }), "_" to 2), 1032, _uA(
                                                                                "onClick"
                                                                            ))
                                                                        } else {
                                                                            _cC("v-if", true)
                                                                        }
                                                                        ,
                                                                        if (order.status == 0) {
                                                                            _cV(_component_mc_primary_button, _uM("key" to 1, "margin-right" to "10px", "onClick" to fun(){
                                                                                handleStartPickup(order)
                                                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                return _uA(
                                                                                    "出发接驾"
                                                                                )
                                                                            }), "_" to 2), 1032, _uA(
                                                                                "onClick"
                                                                            ))
                                                                        } else {
                                                                            if (order.status == 1) {
                                                                                _cV(_component_mc_primary_button, _uM("key" to 2, "margin-right" to "10px", "onClick" to fun(){
                                                                                    handleCancelPickup(order)
                                                                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return _uA(
                                                                                        "取消接驾"
                                                                                    )
                                                                                }), "_" to 2), 1032, _uA(
                                                                                    "onClick"
                                                                                ))
                                                                            } else {
                                                                                _cC("v-if", true)
                                                                            }
                                                                        }
                                                                        ,
                                                                        if (order.status != 2) {
                                                                            _cV(_component_mc_pain_button, _uM("key" to 3, "disabled" to (order.remainingSeats <= 0), "onClick" to fun(){
                                                                                handleScanBoard(order)
                                                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                return _uA(
                                                                                    "扫码上车"
                                                                                )
                                                                            }), "_" to 2), 1032, _uA(
                                                                                "disabled",
                                                                                "onClick"
                                                                            ))
                                                                        } else {
                                                                            _cC("v-if", true)
                                                                        }
                                                                    ))
                                                                ))
                                                            ))
                                                        ), 8, _uA(
                                                            "onClick"
                                                        ))
                                                    }
                                                    ), 128),
                                                    if (unref(todayOrderCount) == 0) {
                                                        _cV(_component_x_empty, _uM("key" to 0, "title" to "当前没有订单", "loading" to false, "empty" to true, "showBtn" to false))
                                                    } else {
                                                        _cC("v-if", true)
                                                    }
                                                ))
                                            )),
                                            _cE("swiper-item", null, _uA(
                                                _cE("view", _uM("class" to "order-list"), _uA(
                                                    if (unref(acitveOrderType) == 1) {
                                                        _cV(_component_mc_active_animation, _uM("key" to 0, "class" to "data-picker-box", "style" to _nS("background-color: " + unref(globalData).theme.painColor + ";")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                _cV(_component_mc_date_picker, _uM("modelValue" to unref(queryDate), "onUpdate:modelValue" to fun(`$event`: String){
                                                                    trySetRefValue(queryDate, `$event`)
                                                                }, "date-style" to unref(dateStyles), "start-date" to unref(dateRange)[0], "disabledDays" to unref(disabledDates), "end-date" to unref(dateRange)[1], "onChange" to fun(){
                                                                    queryOrderList(1)
                                                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                    return _uA(
                                                                        _cE("view", _uM("class" to "left-box", "style" to _nS("width: " + (unref(screenWidth) - 115) + "px;")), _uA(
                                                                            _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-date.png")), null, 8, _uA(
                                                                                "src"
                                                                            )),
                                                                            _cE("text", _uM("class" to "text"), _tD(if (unref(queryDate) != "") {
                                                                                unref(queryDate)
                                                                            } else {
                                                                                "请选择日期"
                                                                            }), 1)
                                                                        ), 4)
                                                                    )
                                                                }), "_" to 1), 8, _uA(
                                                                    "modelValue",
                                                                    "date-style",
                                                                    "start-date",
                                                                    "disabledDays",
                                                                    "end-date",
                                                                    "onChange"
                                                                )),
                                                                _cE("text", _uM("onClick" to fun(){
                                                                    queryOrderList(1)
                                                                }, "class" to "text-btn"), "查询", 8, _uA(
                                                                    "onClick"
                                                                ))
                                                            )
                                                        }), "_" to 1), 8, _uA(
                                                            "style"
                                                        ))
                                                    } else {
                                                        _cC("v-if", true)
                                                    }
                                                    ,
                                                    _cE(Fragment, null, RenderHelpers.renderList(unref(otherOrderList), fun(order, index, __index, _cached): Any {
                                                        return _cE("view", _uM("class" to "order-item", "key" to index, "onClick" to fun(){
                                                            toOrderDetail(order)
                                                        }
                                                        ), _uA(
                                                            _cE("view", _uM("class" to "order-top"), _uA(
                                                                _cE("view", _uM("class" to "order-left"), _uA(
                                                                    _cE("text", _uM("class" to _nC(_uA(
                                                                        "order-type",
                                                                        if (order.typeOfBoarding == 2) {
                                                                            "pinche"
                                                                        } else {
                                                                            "duxiang"
                                                                        }
                                                                    ))), _tD(if (order.typeOfBoarding == 2) {
                                                                        "拼车"
                                                                    } else {
                                                                        "独享"
                                                                    }
                                                                    ), 3),
                                                                    _cE("text", _uM("class" to "order-time"), _tD(order.departureDate) + " " + _tD(order.departureStartTime), 1)
                                                                )),
                                                                _cE("text", _uM("class" to _nC(_uA(
                                                                    "order-status",
                                                                    getStatusClass(order.status)
                                                                ))), _tD(getStatusName(order.status)), 3)
                                                            )),
                                                            _cE("view", _uM("class" to "divider-line")),
                                                            _cE("view", _uM("class" to "order-route"), _uA(
                                                                _cE("view", _uM("class" to "from-to"), _uA(
                                                                    _cE("text", _uM("class" to "city"), _tD(order.startCity), 1),
                                                                    _cE("view", _uM("class" to "path-container"), _uA(
                                                                        _cE("image", _uM("class" to "dashed-line", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-route-arrow-right.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                            "src"
                                                                        ))
                                                                    )),
                                                                    _cE("text", _uM("class" to "city"), _tD(order.endCity), 1)
                                                                )),
                                                                _cE("view", _uM("class" to "route-info"), _uA(
                                                                    _cE("text", _uM("class" to "route-name"), _tD(order.lineGroup), 1),
                                                                    _cE("text", _uM("class" to "route-divider"), "|"),
                                                                    _cE("text", null, _uA(
                                                                        _cE("text", _uM("class" to "seat-info"), _uA(
                                                                            "余坐：",
                                                                            _cE("text", _uM("class" to "highlight"), _tD(order.remainingSeats), 1)
                                                                        )),
                                                                        _cE("text", _uM("class" to "seat-info"), "位")
                                                                    )),
                                                                    _cE("text", _uM("class" to "route-divider"), "|"),
                                                                    if (order.orderCount > 0) {
                                                                        _cE("text", _uM("key" to 0), _uA(
                                                                            _cE("text", _uM("class" to "order-count"), _uA(
                                                                                "包含",
                                                                                _cE("text", _uM("class" to "highlight"), _tD(order.orderCount), 1)
                                                                            )),
                                                                            _cE("text", _uM("class" to "order-count"), "笔订单")
                                                                        ))
                                                                    } else {
                                                                        _cC("v-if", true)
                                                                    }
                                                                )),
                                                                if (isTrue(order.status == 0 && order.typeOfBoarding == 2)) {
                                                                    _cE("view", _uM("key" to 0), _uA(
                                                                        _cE("view", _uM("class" to "btn-group"), _uA(
                                                                            if (isTrue(order.status == 0 && checkTimeBefore(order.departureDate))) {
                                                                                _cV(_component_mc_primary_button, _uM("key" to 0, "margin-right" to "10px", "onClick" to fun(){
                                                                                    handleStartPickup(order)
                                                                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return _uA(
                                                                                        "出发接驾"
                                                                                    )
                                                                                }), "_" to 2), 1032, _uA(
                                                                                    "onClick"
                                                                                ))
                                                                            } else {
                                                                                if (isTrue(order.status == 1 && checkTimeBefore(order.departureDate))) {
                                                                                    _cV(_component_mc_primary_button, _uM("key" to 1, "margin-right" to "10px", "onClick" to fun(){
                                                                                        handleCancelPickup(order)
                                                                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                        return _uA(
                                                                                            "取消接驾"
                                                                                        )
                                                                                    }), "_" to 2), 1032, _uA(
                                                                                        "onClick"
                                                                                    ))
                                                                                } else {
                                                                                    _cC("v-if", true)
                                                                                }
                                                                            },
                                                                            _cV(_component_mc_primary_button, _uM("onClick" to fun(){
                                                                                handleScanBoard(order)
                                                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                return _uA(
                                                                                    "扫码上车"
                                                                                )
                                                                            }), "_" to 2), 1032, _uA(
                                                                                "onClick"
                                                                            ))
                                                                        ))
                                                                    ))
                                                                } else {
                                                                    _cC("v-if", true)
                                                                }
                                                            ))
                                                        ), 8, _uA(
                                                            "onClick"
                                                        ))
                                                    }
                                                    ), 128),
                                                    if (unref(otherOrderList).length <= 0) {
                                                        _cV(_component_x_empty, _uM("key" to 1, "title" to "当前没有订单", "loading" to false, "empty" to true, "showBtn" to false))
                                                    } else {
                                                        _cC("v-if", true)
                                                    }
                                                ))
                                            ))
                                        ), 40, _uA(
                                            "current",
                                            "onChange"
                                        ))
                                    ))
                                ))
                            ), 4),
                            _cE("swiper-item", _uM("style" to _nS(_uM("height" to "auto")), "key" to "1"), _uA(
                                _cE("view", _uM("class" to "container", "style" to _nS(_uA(
                                    "width: " + (unref(screenWidth) - 30) + "px",
                                    _uM("margin" to "20px 15px")
                                ))), _uA(
                                    _cE("view", _uM("class" to "card", "style" to _nS(_uM("margin-bottom" to "20px"))), _uA(
                                        _cE("view", _uM("class" to "card-header"), _uA(
                                            _cE("view", _uM("class" to "left"), _uA(
                                                _cE("image", _uM("class" to "location-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                )),
                                                _cE("text", null, _tD(unref(hadGetWeather)?.city), 1)
                                            )),
                                            _cE("view", _uM("class" to "right"), _tD(unref(hadGetWeather)?.weather?.toString() + " " + unref(hadGetWeather)?.temperature?.toString()) + "℃ ", 1)
                                        )),
                                        _cE("view", _uM("class" to "card-body"), _uA(
                                            _cE("view", _uM("class" to "grid-func"), _uA(
                                                _cE(Fragment, null, RenderHelpers.renderList(gridFuncs.slice(0, 3), fun(item, index, __index, _cached): Any {
                                                    return _cV(_component_mc_active_animation, _uM("class" to "grid-item", "onClick" to fun(){
                                                        item.click?.invoke()
                                                    }
                                                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _cE("image", _uM("class" to "grid-icon", "src" to (unref(resBaseUrl) + item.icon), "key" to index, "mode" to "aspectFit"), null, 8, _uA(
                                                                "src"
                                                            )),
                                                            _cE("view", _uM("class" to "grid-text"), _uA(
                                                                _cE("text", null, _tD(item.text), 1)
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 2), 1032, _uA(
                                                        "onClick"
                                                    ))
                                                }
                                                ), 256)
                                            )),
                                            _cE("view", _uM("class" to "grid-func"), _uA(
                                                _cE(Fragment, null, RenderHelpers.renderList(gridFuncs.slice(3, 6), fun(item, index, __index, _cached): Any {
                                                    return _cV(_component_mc_active_animation, _uM("class" to "grid-item", "onClick" to fun(){
                                                        item.click?.invoke()
                                                    }
                                                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _cE("image", _uM("class" to "grid-icon", "src" to (unref(resBaseUrl) + item.icon), "key" to index, "mode" to "aspectFit"), null, 8, _uA(
                                                                "src"
                                                            )),
                                                            _cE("view", _uM("class" to "grid-text"), _uA(
                                                                _cE("text", null, _tD(item.text), 1)
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 2), 1032, _uA(
                                                        "onClick"
                                                    ))
                                                }
                                                ), 256)
                                            ))
                                        ))
                                    ), 4),
                                    _cV(_component_x_swiper, _uM("height" to "160", "autoPlay" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(advList, fun(item, index, __index, _cached): Any {
                                                return _cV(_component_x_swiper_item, _uM("order" to index, "key" to index, "onClick" to fun(){
                                                    item.click?.invoke(index)
                                                }
                                                ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cV(_component_x_image, _uM("width" to "100%", "model" to "widthFix", "src" to (unref(resBaseUrl) + item.image)), null, 8, _uA(
                                                            "src"
                                                        ))
                                                    )
                                                }
                                                ), "_" to 2), 1032, _uA(
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
                        ), 8, _uA(
                            "current"
                        ))
                    ), 12, _uA(
                        "direction"
                    )),
                    _cV(_component_x_overlay, _uM("show" to unref(showValidModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showValidModal, `$event`)
                    }
                    , "show-close" to true, "z-index" to 100, "overlayClick" to false, "custom-style" to "display: flex;align-items: center;justify-content: center;"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("image", _uM("onClick" to handlePromotion, "src" to ("" + unref(resBaseUrl) + "/static/images/activity-promotion.png"), "mode" to "widthFix"), null, 8, _uA(
                                "src"
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    )),
                    _cV(_component_x_modal, _uM("show" to unref(showAgreeLocationModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showAgreeLocationModal, `$event`)
                    }
                    , "bgColor" to "#ECF1F8", "cancel-text" to "拒绝", "overlay-click" to false, "onCancel" to locationAgreeCancel, "confirm-text" to "同意", "onConfirm" to locationAgreeConfirm, "show-title" to false, "height" to "550rpx"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("text", _uM("class" to "location-agree-title"), "定位权限获取申请"),
                            _cE("view", _uM("class" to "desc"), _uA(
                                _cE("text", _uM("class" to "pb-10"), "我们获取您的位置信息是用于匹配附近的订单、记录轨迹、规划导航路线。"),
                                _cE("text", null, "如果您拒绝我们获取您的上述信息，将导致您无法作为驾驶员向乘客提供服务。"),
                                _cE("text", _uM("class" to "text-row blod"), "本APP提供了撤回系统权限的功能，具体路径:个人中心(登录后点击右上角)-设置-账户与安全-权限管理。")
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    )),
                    _cV(_component_x_drawer, _uM("content-margin" to "0", "show" to unref(showChangeCarDrawer), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showChangeCarDrawer, `$event`)
                    }
                    , "show-title" to false, "size" to "900rpx"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "", "style" to _nS("padding: 0 30rpx;background-image: linear-gradient(to bottom, " + unref(globalData).theme.painColor + ",'#ffffff')")), _uA(
                                _cE("text", _uM("class" to "change-car-title"), "可更换车辆列表"),
                                _cE("scroll-view", _uM("style" to _nS(_uM("height" to "650rpx"))), _uA(
                                    _cE("view", _uM("class" to "radio-btn-group"), _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(unref(carList), fun(item, __key, __index, _cached): Any {
                                            return _cE("view", _uM("class" to _nC(_uA(
                                                "radio-btn",
                                                _uM("actived" to (unref(selectCar)?.vehiclePlateNo == item.vehiclePlateNo))
                                            )), "key" to item.vehiclePlateNo, "onClick" to fun(){
                                                changeCarEvt(item)
                                            }
                                            , "style" to _nS("background-image: linear-gradient(to right, " + (if (unref(selectCar)?.vehiclePlateNo == item.vehiclePlateNo) {
                                                unref(globalData).theme.primaryLinearColors.join(", ")
                                            } else {
                                                _uA(
                                                    "#ffffff",
                                                    "#ffffff"
                                                ).join(", ")
                                            }
                                            ) + ")")), _uA(
                                                _cE("text", _uM("class" to "text", "style" to _nS("color: " + (if (unref(selectCar)?.vehiclePlateNo == item.vehiclePlateNo) {
                                                    "#ffffff"
                                                } else {
                                                    "#0000000"
                                                }
                                                ) + ";")), _tD(item.vehiclePlateNo), 5)
                                            ), 14, _uA(
                                                "onClick"
                                            ))
                                        }
                                        ), 128)
                                    )),
                                    if (unref(carList).length <= 0) {
                                        _cV(_component_x_empty, _uM("key" to 0, "title" to "当前没有可更换车辆", "loading" to false, "empty" to true, "showBtn" to false))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ), 4),
                                _cE("view", _uM("class" to "x-drawer-btn-group"), _uA(
                                    _cV(_component_x_button, _uM("onClick" to onChangeCarCancel, "skin" to "thin", "style" to _nS(_uM("flex" to "1", "margin-right" to "10px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "取消"
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "style"
                                    )),
                                    _cV(_component_x_button, _uM("onClick" to onChangeCarConfirm, "style" to _nS(_uM("flex" to "1"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "确认"
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "style"
                                    ))
                                ))
                            ), 4)
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    )),
                    _cV(_component_mc_order_notice)
                ), 64)
            }
        }
        var name = "had-settled"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("container" to _pS(_uM("width" to "100%", "position" to "relative")), "inv-box" to _pS(_uM("position" to "relative")), "anime-box" to _uM(".inv-box " to _uM("width" to "100%", "transitionProperty" to "transform", "transitionDuration" to "2s")), "btn" to _uM(".inv-box " to _uM("position" to "absolute", "bottom" to "20rpx", "width" to "70%")), "home-bg" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1)), "top-bg" to _uM(".home-bg " to _uM("height" to 300, "width" to "100%")), "header" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to 10, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 23)), "avatar-box" to _uM(".header " to _uM("width" to "90rpx", "height" to "90rpx", "borderTopStyle" to "none", "borderRightStyle" to "none", "borderBottomStyle" to "none", "borderLeftStyle" to "none", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "borderTopLeftRadius" to "45rpx", "borderTopRightRadius" to "45rpx", "borderBottomRightRadius" to "45rpx", "borderBottomLeftRadius" to "45rpx")), "avatar" to _uM(".header .avatar-box " to _uM("width" to "100%", "height" to "100%")), "card" to _pS(_uM("width" to "100%", "backgroundColor" to "#ffffff", "boxShadow" to "0px 11px 35px 0px rgba(253, 214, 190, 0.23)", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FFFFFF", "borderRightColor" to "#FFFFFF", "borderBottomColor" to "#FFFFFF", "borderLeftColor" to "#FFFFFF", "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20)), "card-header" to _uM(".card " to _uM("paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "width" to "100%", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "marginBottom" to 10)), "left" to _uM(".card .card-header " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "location-icon" to _uM(".card .card-header .left " to _uM("width" to 13, "height" to 15, "marginRight" to 5)), "arrow-icon" to _uM(".card .card-header .left " to _uM("width" to 8, "height" to 4, "marginLeft" to 5)), "features" to _uM(".card .card-body " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to 20, "paddingRight" to 0, "paddingBottom" to 20, "paddingLeft" to 0)), "feature-item" to _uM(".card .card-body .features " to _uM("display" to "flex", "alignItems" to "center", "flex" to 1)), "feature-icon" to _uM(".card .card-body .features .feature-item " to _uM("width" to 28.5, "height" to 29.5, "marginBottom" to 10)), "feature-text" to _uM(".card .card-body .features .feature-item " to _uM("display" to "flex", "flexDirection" to "column", "fontSize" to 15)), "grid-func" to _uM(".card .card-body " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to 20, "paddingRight" to 0, "paddingBottom" to 20, "paddingLeft" to 0)), "grid-item" to _uM(".card .card-body .grid-func " to _uM("display" to "flex", "alignItems" to "center", "flex" to 1)), "grid-icon" to _uM(".card .card-body .grid-func .grid-item " to _uM("width" to 35, "height" to 39, "marginBottom" to 10)), "grid-text" to _uM(".card .card-body .grid-func .grid-item " to _uM("display" to "flex", "flexDirection" to "column", "fontSize" to 15, "color" to "#141414")), "data-picker-box" to _pS(_uM("width" to "100%", "backgroundColor" to "#F4F7FD", "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "marginBottom" to 15)), "left-box" to _uM(".data-picker-box " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "paddingTop" to 13, "paddingRight" to 15, "paddingBottom" to 13, "paddingLeft" to 15)), "icon" to _uM(".data-picker-box .left-box " to _uM("width" to 15, "height" to 15, "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10)), "text" to _uM(".data-picker-box " to _uM("fontWeight" to "400", "fontSize" to 15, "color" to "#000000"), ".order-tab .active-tab-left " to _uM("color" to "#000000", "fontWeight" to "700", "fontSize" to "40rpx", "textAlign" to "center"), ".order-tab .active-tab-right " to _uM("color" to "#000000", "fontWeight" to "700", "fontSize" to "40rpx", "textAlign" to "center"), ".order-tab .tab-item " to _uM("fontSize" to "40rpx", "color" to "#979DA4"), ".radio-btn-group .radio-btn " to _uM("textAlign" to "center", "fontSize" to "34rpx")), "text-btn" to _uM(".data-picker-box " to _uM("fontWeight" to "400", "fontSize" to 15, "color" to "#000000", "paddingLeft" to 25, "paddingRight" to 25, "borderLeftWidth" to 0.5, "borderLeftStyle" to "solid", "borderLeftColor" to "#D2D8E3")), "order-tab" to _pS(_uM("paddingTop" to "20rpx", "paddingBottom" to "20rpx", "backgroundColor" to "#FFFFFF", "position" to "relative", "overflow" to "visible")), "tab-group" to _uM(".order-tab " to _uM("display" to "flex", "flexDirection" to "row", "borderTopLeftRadius" to "30rpx", "borderTopRightRadius" to "30rpx", "backgroundColor" to "#ffffff", "boxShadow" to "0 -5rpx 5rpx 0 rgba(155, 177, 214, 0.15)")), "bg-img-left" to _uM(".order-tab " to _uM("position" to "absolute", "bottom" to "10rpx", "zIndex" to 1, "width" to "58%", "height" to "152rpx", "left" to "-20rpx")), "bg-img-right" to _uM(".order-tab " to _uM("position" to "absolute", "bottom" to "10rpx", "zIndex" to 1, "width" to "58%", "height" to "152rpx", "right" to "-20rpx")), "active-tab-left" to _uM(".order-tab " to _uM("position" to "absolute", "bottom" to "20rpx", "paddingBottom" to "20rpx", "zIndex" to 3, "left" to 0)), "active-tab-right" to _uM(".order-tab " to _uM("position" to "absolute", "bottom" to "20rpx", "paddingBottom" to "20rpx", "zIndex" to 3, "right" to 0)), "active-line" to _uM(".order-tab " to _uM("position" to "absolute", "bottom" to 0, "left" to "50%", "transform" to "translateX(-50%)", "width" to "120rpx", "height" to "6rpx", "backgroundColor" to "#000000", "borderTopLeftRadius" to "4rpx", "borderTopRightRadius" to "4rpx", "borderBottomRightRadius" to "4rpx", "borderBottomLeftRadius" to "4rpx")), "tab-item" to _uM(".order-tab " to _uM("flex" to 1, "textAlign" to "center", "paddingTop" to "36rpx", "paddingRight" to 0, "paddingBottom" to "18rpx", "paddingLeft" to 0, "position" to "relative", "display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center")), "order-box" to _pS(_uM("width" to "100%", "backgroundColor" to "#ffffff", "overflow" to "visible")), "order-list" to _uM(".order-box " to _uM("minHeight" to "800rpx", "paddingTop" to "10rpx", "paddingRight" to "30rpx", "paddingBottom" to "30rpx", "paddingLeft" to "30rpx", "backgroundColor" to "#FFFFFF")), "order-item" to _uM(".order-box .order-list " to _uM("backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "30rpx", "borderTopRightRadius" to "30rpx", "borderBottomRightRadius" to "30rpx", "borderBottomLeftRadius" to "30rpx", "marginBottom" to "30rpx", "boxShadow" to "0rpx 0rpx 20rpx 0rpx rgba(155, 153, 208, 0.35)", "paddingTop" to "30rpx", "paddingRight" to "30rpx", "paddingBottom" to "30rpx", "paddingLeft" to "30rpx", "marginBottom:last-child" to "10rpx")), "order-top" to _uM(".order-box .order-list .order-item " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "paddingBottom" to "20rpx", "borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#DADADA")), "divider-line" to _uM(".order-box .order-list .order-item " to _uM("height" to "2rpx", "backgroundColor" to "#F5F5F5", "width" to "100%")), "order-left" to _uM(".order-box .order-list .order-item " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "order-type" to _uM(".order-box .order-list .order-item " to _uM("paddingRight" to "16rpx", "marginRight" to "16rpx", "fontWeight" to "700", "fontSize" to "30rpx", "borderRightWidth" to "1rpx", "borderRightStyle" to "solid", "borderRightColor" to "#C8C8C8", "color" to "#C70000"), ".order-box .order-list .order-item .pinche" to _uM("color" to "#C70000"), ".order-box .order-list .order-item .duxiang" to _uM("color" to "#C78300")), "order-time" to _uM(".order-box .order-list .order-item " to _uM("fontSize" to "32rpx", "color" to "#000000")), "order-status" to _uM(".order-box .order-list .order-item " to _uM("paddingTop" to "8rpx", "paddingRight" to "30rpx", "paddingBottom" to "8rpx", "paddingLeft" to "30rpx", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "fontSize" to "30rpx", "color" to "#FFFFFF"), ".order-box .order-list .order-item .processing" to _uM("backgroundColor" to "#89B06D"), ".order-box .order-list .order-item .waiting" to _uM("backgroundColor" to "#64ADEF"), ".order-box .order-list .order-item .pending" to _uM("backgroundColor" to "#84A1C3")), "order-route" to _uM(".order-box .order-list .order-item " to _uM("paddingTop" to "30rpx")), "from-to" to _uM(".order-box .order-list .order-item .order-route " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "marginBottom" to "30rpx")), "city" to _uM(".order-box .order-list .order-item .order-route .from-to " to _uM("fontSize" to "36rpx", "fontWeight" to "700", "color" to "#222222")), "path-container" to _uM(".order-box .order-list .order-item .order-route .from-to " to _uM("position" to "relative", "width" to "64rpx", "height" to "40rpx", "marginTop" to 0, "marginRight" to "24rpx", "marginBottom" to 0, "marginLeft" to "24rpx", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "dashed-line" to _uM(".order-box .order-list .order-item .order-route .from-to .path-container " to _uM("width" to "60rpx", "height" to "20rpx", "position" to "absolute")), "route-info" to _uM(".order-box .order-list .order-item .order-route " to _uM("paddingTop" to 0, "paddingRight" to "20rpx", "paddingBottom" to 0, "paddingLeft" to "20rpx", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "marginBottom" to "40rpx")), "route-name" to _uM(".order-box .order-list .order-item .order-route .route-info " to _uM("fontSize" to "32rpx", "color" to "#7E7E7E")), "seat-info" to _uM(".order-box .order-list .order-item .order-route .route-info " to _uM("fontSize" to "32rpx", "color" to "#7E7E7E")), "order-count" to _uM(".order-box .order-list .order-item .order-route .route-info " to _uM("fontSize" to "32rpx", "color" to "#7E7E7E")), "route-divider" to _uM(".order-box .order-list .order-item .order-route .route-info " to _uM("marginTop" to 0, "marginRight" to "16rpx", "marginBottom" to 0, "marginLeft" to "16rpx", "color" to "#7E7E7E", "fontSize" to "32rpx")), "highlight" to _uM(".order-box .order-list .order-item .order-route .route-info " to _uM("color" to "#C78300", "fontWeight" to "700", "fontSize" to "32rpx")), "btn-group" to _uM(".order-box .order-list .order-item .order-route " to _uM("flexGrow" to 1, "width" to "100%", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between")), "location-agree-title" to _pS(_uM("paddingTop" to "30rpx", "paddingRight" to 0, "paddingBottom" to "30rpx", "paddingLeft" to 0, "textAlign" to "center", "width" to "100%", "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "text-row" to _pS(_uM("paddingBottom" to "20rpx", "textIndent" to "30rpx")), "blod" to _pS(_uM("color" to "#FF0000")), "change-car-title" to _pS(_uM("textAlign" to "center", "width" to "100%", "marginTop" to "40rpx", "marginRight" to 0, "marginBottom" to "40rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "34rpx", "color" to "#000000")), "radio-btn" to _uM(".radio-btn-group " to _uM("paddingTop" to "30rpx", "paddingRight" to "60rpx", "paddingBottom" to "30rpx", "paddingLeft" to "60rpx", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "marginBottom" to "30rpx", "transitionProperty" to "backgroundImage,boxShadow", "transitionDuration" to "0.25s"), ".radio-btn-group .actived" to _uM("boxShadow" to "0rpx 5rpx 10rpx 0rpx rgba(89, 119, 177, 0.2)")), "x-drawer-btn-group" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between")), "@TRANSITION" to _uM("anime-box" to _uM("property" to "transform", "duration" to "2s"), "radio-btn" to _uM("property" to "backgroundImage,boxShadow", "duration" to "0.25s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
