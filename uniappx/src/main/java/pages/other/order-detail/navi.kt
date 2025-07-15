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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import io.dcloud.uniapp.extapi.makePhoneCall as uni_makePhoneCall
import io.dcloud.uniapp.extapi.reLaunch as uni_reLaunch
import uts.sdk.modules.xModalS.showModal
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
import uts.sdk.modules.xVibrateS.vibrator
open class GenPagesOtherOrderDetailNavi : BasePage {
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
        onReady(fun() {
            this.setMarker()
            onBackPress(fun(options: OnBackPressOptions): Boolean? {
                if (this.canBack) {
                    return false
                }
                showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u662F\u5426\u9000\u51FA\u5BFC\u822A\u754C\u9762", confirmText = "确认", confirmBgColor = this.globalData.theme.primaryColor, confirm = fun(){
                    this.navQuit(false)
                }
                ))
                return true
            }
            )
        }
        , __ins)
        onLoad(fun(query: OnLoadOptions) {
            console.log("query:", query)
            this.orderParams = JSON.parse<UTSJSONObject>(JSON.stringify(query)) ?: UTSJSONObject()
            uni__on("onSendData", this.onSendData)
            uni__on("syncNavInfo", this.syncNavInfo)
        }
        , __ins)
        onBeforeUnmount(fun() {
            uni__off("syncNavInfo", this.syncNavInfo)
            uni__off("onSendData", this.onSendData)
            hideXloading()
        }
        , __ins)
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_mc_amap_nav = resolveEasyComponent("mc-amap-nav", GenUniModulesMcAmapNavPlusComponentsMcAmapNavMcAmapNavClass)
        val _component_mc_drag_verify = resolveEasyComponent("mc-drag-verify", GenComponentsMcDragVerifyIndexClass)
        val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
        val _component_x_code_input = resolveEasyComponent("x-code-input", GenUniModulesTmxUiComponentsXCodeInputXCodeInputClass)
        val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
        val _component_x_keyboard_number = resolveEasyComponent("x-keyboard-number", GenUniModulesTmxUiComponentsXKeyboardNumberXKeyboardNumberClass)
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_mc_amap_nav, utsMapOf("style" to normalizeStyle("margin-top: " + (_ctx.statusBarHeight + 50) + "px;height:" + (_ctx.screenHeight - 230 - _ctx.globalData.safeAreaBottom - _ctx.statusBarHeight) + "px"), "ref" to "naviView", "onQuit" to fun(){
                _ctx.navQuit(false)
            }
            ), null, 8, utsArrayOf(
                "style",
                "onQuit"
            )),
            createVNode(_component_mc_base_container, utsMapOf("title" to "订单详情", "bg-color" to "#ffffff", "scroll" to false), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    if (isTrue(_ctx.showPanel)) {
                        createElementVNode("view", utsMapOf("key" to 0, "class" to "triping-panel", "style" to normalizeStyle("height: " + (180 + _ctx.globalData.safeAreaBottom) + "px;")), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "header flex-row flex-row-center-between"), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "current-step"), utsArrayOf(
                                    if (isTrue(_ctx.orderData.orderChains[_ctx.currentIndex]?.orderStatus == 3 || _ctx.orderData.orderChains[_ctx.currentIndex]?.waitingStatus == 0)) {
                                        createElementVNode("text", utsMapOf("key" to 0), "正在前往")
                                    } else {
                                        createElementVNode("text", utsMapOf("key" to 1), "已达到")
                                    },
                                    createElementVNode("text", utsMapOf("style" to normalizeStyle("color: #" + _ctx.orderData.orderChains[_ctx.currentIndex]?.pointColor + ";")), toDisplayString(_ctx.orderData.orderChains[_ctx.currentIndex]?.pointName), 5),
                                    createElementVNode("text", null, toDisplayString(if (_ctx.orderData.orderChains[_ctx.currentIndex]?.orderStatus == 3) {
                                        "目的地"
                                    } else {
                                        "上车点"
                                    }), 1)
                                )),
                                createElementVNode("view", utsMapOf("class" to "order-title flex-row"), utsArrayOf(
                                    createElementVNode("image", utsMapOf("class" to "order-icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-order-outline.png")), null, 8, utsArrayOf(
                                        "src"
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "flex-row"), utsArrayOf(
                                        createElementVNode("text", utsMapOf("style" to normalizeStyle("color:" + _ctx.globalData.theme.primaryColor)), toDisplayString(_ctx.currentIndex + 1), 5),
                                        createElementVNode("text", null, "/"),
                                        createElementVNode("text", utsMapOf("style" to normalizeStyle("color:" + _ctx.globalData.theme.primaryColor)), toDisplayString(_ctx.orderData.orderChains.length), 5),
                                        createElementVNode("text", null, "订单")
                                    ))
                                ))
                            )),
                            createElementVNode("view", utsMapOf("class" to "main-body flex-row flex-row-center-between"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "left-box"), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "address-info"), toDisplayString(_ctx.orderData.orderChains[_ctx.currentIndex].pointAddress), 1),
                                    createElementVNode("view", utsMapOf("class" to "flex-row"), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "text"), "距我"),
                                        createElementVNode("text", utsMapOf("class" to "text", "style" to normalizeStyle("font-weight: bold;color:" + _ctx.globalData.theme.primaryColor)), toDisplayString(_ctx.viaDistance), 5),
                                        createElementVNode("text", utsMapOf("class" to "split"), "|"),
                                        createElementVNode("text", utsMapOf("class" to "text"), "预计"),
                                        createElementVNode("text", utsMapOf("class" to "text", "style" to normalizeStyle("font-weight: bold;color:" + _ctx.globalData.theme.primaryColor)), toDisplayString(_ctx.viaTime), 5)
                                    ))
                                )),
                                createElementVNode("image", utsMapOf("class" to "call-phone", "onClick" to _ctx.callPhone, "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-call-phone-filled.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                    "onClick",
                                    "src"
                                ))
                            )),
                            createElementVNode("view", utsMapOf("class" to "footer", "style" to normalizeStyle("width: " + _ctx.screenWidth + "px;")), utsArrayOf(
                                if (isTrue(_ctx.orderData.orderChains[_ctx.currentIndex]?.orderStatus == 2 && _ctx.orderData.orderChains[_ctx.currentIndex]?.waitingStatus == 0)) {
                                    createVNode(_component_mc_drag_verify, utsMapOf("key" to 0, "ref" to "verify", "onSuccess" to _ctx.tryArrived, "linear-gradient" to _ctx.globalData.theme.primaryLinearColors, "bg-color" to "#E2EAFA", "verify-text" to "右滑确认到达乘客上车点", "completeText" to "已到达上车点", "verify-text-color" to "#ffffff", "img-icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-verify-arrow-right.png"), "round" to 20), null, 8, utsArrayOf(
                                        "onSuccess",
                                        "linear-gradient",
                                        "img-icon-path"
                                    ))
                                } else {
                                    if (isTrue(_ctx.orderData.orderChains[_ctx.currentIndex]?.orderStatus == 2 && _ctx.orderData.orderChains[_ctx.currentIndex]?.waitingStatus == 1)) {
                                        createVNode(_component_mc_drag_verify, utsMapOf("key" to 1, "ref" to "verify", "onSuccess" to _ctx.verifySuccess, "linear-gradient" to utsArrayOf(
                                            "#25B3EE",
                                            "#1F82C8"
                                        ), "bg-color" to "#CFEFFF", "verify-text" to "右滑确认乘客已上车", "completeText" to "乘客已上车", "verify-text-color" to "#ffffff", "img-icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-verify-arrow-right.png"), "round" to 20), null, 8, utsArrayOf(
                                            "onSuccess",
                                            "img-icon-path"
                                        ))
                                    } else {
                                        if (_ctx.orderData.orderChains[_ctx.currentIndex]?.orderStatus == 3) {
                                            createVNode(_component_mc_drag_verify, utsMapOf("key" to 2, "ref" to "verify", "onSuccess" to _ctx.validOrder, "linear-gradient" to utsArrayOf(
                                                "#44C791",
                                                "#28D07F"
                                            ), "bg-color" to "#D0F6E5", "verify-text" to "右滑确认行程已完成", "completeText" to "行程已完成", "verify-text-color" to "#ffffff", "img-icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-verify-arrow-right.png"), "round" to 20), null, 8, utsArrayOf(
                                                "onSuccess",
                                                "img-icon-path"
                                            ))
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                    }
                                }
                            ), 4)
                        ), 4)
                    } else {
                        createCommentVNode("v-if", true)
                    }
                )
            }
            ), "_" to 1)),
            createVNode(_component_x_modal, utsMapOf("show" to _ctx.showValidModal, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.showValidModal = `$event`
            }
            , "show-close" to "", "onClose" to _ctx.modalClose, "height" to "300rpx", "z-index" to "100", "title" to "请输入乘客手机尾号", "show-footer" to false, "overlayClick" to false), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createVNode(_component_x_code_input, utsMapOf("auto-focus" to "", "place-shape" to "line", "onClick" to fun(){
                        _ctx.showKey = true
                    }
                    , "onConfirm" to _ctx.validPhoneConfirm, "modelValue" to _ctx.phoneSuffix, "onUpdate:modelValue" to fun(`$event`: String){
                        _ctx.phoneSuffix = `$event`
                    }
                    , "useSysKeyborad" to false, "skin" to "fill"), null, 8, utsArrayOf(
                        "onClick",
                        "onConfirm",
                        "modelValue",
                        "onUpdate:modelValue"
                    ))
                )
            }
            ), "_" to 1), 8, utsArrayOf(
                "show",
                "onUpdate:show",
                "onClose"
            )),
            createVNode(_component_x_keyboard_number, utsMapOf("mode" to "password", "max-len" to 4, "btn-color" to "white", "digit" to false, "modelShow" to _ctx.showKey, "onUpdate:modelShow" to fun(`$event`: Boolean){
                _ctx.showKey = `$event`
            }
            , "modelValue" to _ctx.phoneSuffix, "onUpdate:modelValue" to fun(`$event`: String){
                _ctx.phoneSuffix = `$event`
            }
            ), null, 8, utsArrayOf(
                "modelShow",
                "onUpdate:modelShow",
                "modelValue",
                "onUpdate:modelValue"
            ))
        ), 64)
    }
    open var globalData: GlobalDataType by `$inject`
    open var resBaseUrl: Any? by `$data`
    open var currentIndex: Number by `$data`
    open var showValidModal: Boolean by `$data`
    open var showKey: Boolean by `$data`
    open var phoneSuffix: String by `$data`
    open var showPanel: Boolean by `$data`
    open var canBack: Boolean by `$data`
    open var orderParams: UTSJSONObject by `$data`
    open var orderData: OrderSummary1 by `$data`
    open var screenWidth: Number by `$data`
    open var screenHeight: Number by `$data`
    open var statusBarHeight: Number by `$data`
    open var viaDistance: String by `$data`
    open var viaTime: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("resBaseUrl" to uni.UNI511F0A5.resBaseUrl, "currentIndex" to 0, "showValidModal" to false, "showKey" to false, "phoneSuffix" to "", "showPanel" to false, "canBack" to false, "orderParams" to UTSJSONObject(), "orderData" to OrderSummary1(orderCount = 0, driverStatus = -2, seatSelectTemplates = utsArrayOf(), orderItems = utsArrayOf(), orderChains = utsArrayOf(), orderRoute = OrderRoute(routeStrategy = "", routeStartPoint = "", routeWaypoints = utsArrayOf(), routeEndPoint = "", routeWaypointsPoiIds = utsArrayOf<String>(), routeStartPoiId = "", routeEndPoiId = "")), "screenWidth" to uni.UNI511F0A5.screenWidth as Number, "screenHeight" to uni.UNI511F0A5.screenHeight as Number, "statusBarHeight" to uni.UNI511F0A5.statusBarHeight as Number, "viaDistance" to "0公里", "viaTime" to "0分钟")
    }
    open var syncNavInfo = ::gen_syncNavInfo_fn
    open fun gen_syncNavInfo_fn(data: String) {
        val dataObj = JSON.parse<UTSJSONObject>(data)
        this.viaDistance = dataObj?.getString("distance") ?: "0公里"
        this.viaTime = dataObj?.getString("time") ?: "0分钟"
    }
    open var onSendData = ::gen_onSendData_fn
    open fun gen_onSendData_fn(data: String) {
        console.log("onSendData:", data)
        this.orderData = JSON.parse<OrderSummary1>(data) as OrderSummary1
        this.setMarker()
        this.showPanel = true
    }
    open var setMarker = ::gen_setMarker_fn
    open fun gen_setMarker_fn() {
        val naviView = (this.`$refs`["naviView"] as McAmapNavComponentPublicInstance)
        val markers = this.orderData.orderChains.map(fun(item, _idx, _arr): MarkerOption {
            val pointArr: UTSArray<Number> = item.point.split(",").reverse().map(fun(item: String, _idx: Number, _arr: UTSArray<String>): Number {
                return UTSNumber.from(item)
            }
            )
            return MarkerOption(latitude = pointArr[0], longitude = pointArr[1], color = item.pointColor, desc = item.pointName, icon = "")
        }
        )
        naviView?.setMarkers(markers)
    }
    open var navQuit = ::gen_navQuit_fn
    open fun gen_navQuit_fn(canCalcRoute: Boolean) {
        vibrator(100)
        this.canBack = true
        uni_useKuxRouter().back(-1)
        uni__emit("queryOrderDetail", canCalcRoute)
    }
    open var tryArrived = ::gen_tryArrived_fn
    open fun gen_tryArrived_fn() {
        val that = this
        showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u786E\u8BA4\u5230\u8FBE" + that.orderData.orderChains[that.currentIndex].pointName + "\u4E0A\u8F66\u70B9\uFF1F", confirmText = "确认", confirmBgColor = that.globalData.theme.primaryColor, confirm = fun(){
            that.verifyArrivedSuccess()
        }
        , close = fun() {
            that.resetVerify()
        }
        ))
    }
    open var verifyArrivedSuccess = ::gen_verifyArrivedSuccess_fn
    open fun gen_verifyArrivedSuccess_fn() {
        val that = this
        showLoading(XLOADINGS_TYPE(title = "确认到达上车点..."))
        ws1?.sendAndOnErr(WebSocketSendMessage(type = MessageType["ARRIVED_TRIP"] as Number, content = that.orderData.orderChains[that.currentIndex].orderId), fun(data){
            console.log("到达上车点：", data)
            vibrator(100)
            uni__emit("queryOrderDetail", false)
            hideXloading()
        }
        , fun(data){
            hideXloading()
            that.resetVerify()
        }
        )
    }
    open var verifySuccess = ::gen_verifySuccess_fn
    open fun gen_verifySuccess_fn() {
        this.showValidModal = true
        this.showKey = true
    }
    open var modalClose = ::gen_modalClose_fn
    open fun gen_modalClose_fn() {
        setTimeout(fun(){
            this.phoneSuffix = ""
            this.resetVerify()
        }
        , 250)
    }
    open var validPhoneConfirm = ::gen_validPhoneConfirm_fn
    open fun gen_validPhoneConfirm_fn() {
        val that = this
        showLoading(XLOADINGS_TYPE(title = "验证乘客手机号..."))
        ws1?.sendAndOnErr(WebSocketSendMessage(type = MessageType["VALID_PHONE"] as Number, content = JSON.stringify(object : UTSJSONObject() {
            var phoneLastFour = that.phoneSuffix
            var orderId = that.orderData.orderChains[that.currentIndex].orderId
        })), fun(data){
            console.log("验证乘客手机号成功：", data)
            vibrator(100)
            hideXloading()
            that.showValidModal = false
            that.showKey = false
            that.phoneSuffix = ""
            if (that.orderData.orderChains.length == 1) {
                that.navQuit(true)
            } else {
                uni__emit("queryOrderDetail", true)
            }
        }
        , fun(data){
            hideXloading()
            that.resetVerify()
        }
        )
    }
    open var resetVerify = ::gen_resetVerify_fn
    open fun gen_resetVerify_fn() {
        if (this.`$refs`["verify"] != null) {
            val verify = this.`$refs`["verify"] as McDragVerifyComponentPublicInstance
            verify?.reset?.invoke()
        }
    }
    open var validOrder = ::gen_validOrder_fn
    open fun gen_validOrder_fn() {
        val that = this
        if (that.orderData.driverStatus == 3) {
            this.finishOrder()
        } else {
            showLoading(XLOADINGS_TYPE(title = "正在开启行程..."))
            ws1?.sendAndOnErr(WebSocketSendMessage(type = MessageType["OPEN_TRIP"] as Number), fun(data){
                console.log("开启行程：", data)
                hideXloading()
                that.orderData.driverStatus = 3
                that.finishOrder()
            }
            , fun(data){
                hideXloading()
            }
            )
        }
    }
    open var finishOrder = ::gen_finishOrder_fn
    open fun gen_finishOrder_fn() {
        val that = this
        val order = that.orderData.orderChains[that.currentIndex]
        showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u786E\u8BA4\u5B8C\u6210" + order.pointName + "\uFF1F", confirmText = "确认", confirmBgColor = that.globalData.theme.primaryColor, confirm = fun(){
            showLoading(XLOADINGS_TYPE(title = "正在完成订单..."))
            ws1?.sendAndOnErr(WebSocketSendMessage(type = MessageType["ORDER_FINISH"] as Number, content = order.orderId), fun(data){
                console.log("完成订单：", data)
                if (that.orderData.orderChains.length > 1) {
                    uni__emit("queryOrderDetail", false)
                } else {
                    val res = JSON.parse<OrderFinishResponse>(data)
                    if (res?.allOfOrderCompleted ?: false) {
                        setTimeout(fun(){
                            showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u60A8\u5F53\u524D\u8BA2\u5355\u5DF2\u5168\u90E8\u7ED3\u675F", confirmText = "返回首页", confirmBgColor = this.globalData.theme.primaryColor, close = fun(){
                                uni_reLaunch(ReLaunchOptions(url = "/pages/home/index"))
                            }
                            ))
                        }
                        , 250)
                    }
                }
                vibrator(100)
                hideXloading()
            }
            , fun(data){
                hideXloading()
                that.resetVerify()
            }
            )
        }
        , close = fun() {
            that.resetVerify()
        }
        ))
    }
    open var onOrderAdd = ::gen_onOrderAdd_fn
    open fun gen_onOrderAdd_fn() {
        val that = this
        ws1?.on(MessageType["ORDER_ADD"] as Number, fun(data){
            console.log("您有一个新的订单：", data)
            vibrator(100)
            hideXloading()
            val res = JSON.parse<OrderAddResponse>(data)
            if (res?.summaryId == that.orderParams["summaryId"]) {
                showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u60A8\u6536\u5230\u4E00\u7B14\u65B0\u7684\u8BA2\u5355", confirmText = "知道了", confirmBgColor = this.globalData.theme.primaryColor, showCancel = false, close = fun(){
                    that.navQuit(true)
                }
                ))
                McAudio.play("/static/audio/new-order.mp3", false)
            }
        }
        )
    }
    open var onOrderAllFinish = ::gen_onOrderAllFinish_fn
    open fun gen_onOrderAllFinish_fn() {
        val that = this
        ws1?.on(MessageType["BIG_ORDER_FINISH"] as Number, fun(data){
            console.log("因订单取消或调度，您当前订单已全部完成：", data)
            vibrator(100)
            hideXloading()
            val res = JSON.parse<OrderFinishResponse>(data)
            if (res?.summaryId == that.orderParams["summaryId"]) {
                showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u56E0\u8BA2\u5355\u53D6\u6D88\u6216\u8C03\u5EA6\uFF0C\u60A8\u5F53\u524D\u8BA2\u5355\u5DF2\u5168\u90E8\u5B8C\u6210", confirmText = "返回首页", confirmBgColor = this.globalData.theme.primaryColor, showCancel = false, close = fun(){
                    uni_reLaunch(ReLaunchOptions(url = "/pages/home/index"))
                }
                ))
            }
        }
        )
    }
    open var onOneOrderFinish = ::gen_onOneOrderFinish_fn
    open fun gen_onOneOrderFinish_fn() {
        ws1?.on(MessageType["ORDER_FINISH"] as Number, fun(data){
            vibrator(100)
            hideXloading()
            val res = JSON.parse<OrderFinishResponse>(data)
            console.log("订单完成：", res)
            if (res?.summaryId == this.orderParams["summaryId"]) {
                if (res?.allOfOrderCompleted ?: false) {
                    console.log("您当前订单已全部完成：弹窗")
                    setTimeout(fun(){
                        showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u60A8\u5F53\u524D\u8BA2\u5355\u5DF2\u5168\u90E8\u5B8C\u6210", confirmText = "返回首页", confirmBgColor = this.globalData.theme.primaryColor, showCancel = false, close = fun(){
                            uni_reLaunch(ReLaunchOptions(url = "/pages/home/index"))
                        }))
                    }, 250)
                } else {
                    uni__emit("queryOrderDetail", true)
                }
            }
        }
        )
    }
    open var onOrderCancel = ::gen_onOrderCancel_fn
    open fun gen_onOrderCancel_fn() {
        val that = this
        ws1?.on(MessageType["ORDER_CANCEL"] as Number, fun(data){
            val res = JSON.parse<OrderCancelResponse>(data)
            console.log("您有一个订单已被取消：", res)
            hideXloading()
            vibrator(100)
            if (res?.summaryId == that.orderParams["summaryId"]) {
                if (res?.backIndex ?: false) {
                    showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u56E0\u53D6\u6D88\u6216\u8005\u8C03\u5EA6\uFF0C\u60A8\u5F53\u524D\u8BA2\u5355\u5DF2\u5168\u90E8\u7ED3\u675F", confirmText = "返回首页", confirmBgColor = this.globalData.theme.primaryColor, showCancel = false, close = fun(){
                        uni_reLaunch(ReLaunchOptions(url = "/pages/home/index"))
                    }))
                } else {
                    showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u60A8\u6709\u4E00\u4E2A\u8BA2\u5355\u5DF2\u88AB\u53D6\u6D88", confirmText = "知道了", confirmBgColor = this.globalData.theme.primaryColor, showCancel = false, close = fun(){
                        that.navQuit(true)
                    }
                    ))
                }
                McAudio.play("/static/audio/order-cancel.mp3", false)
            }
        }
        )
    }
    open var callPhone = ::gen_callPhone_fn
    open fun gen_callPhone_fn() {
        val phone = this.orderData.orderChains[this.currentIndex].phoneNumber
        uni_makePhoneCall(MakePhoneCallOptions(phoneNumber = phone, success = fun(result: MakePhoneCallSuccess){
            console.log("拨打电话成功")
        }
        , fail = fun(_err){
            console.log("拨打电话失败", _err)
            showToast("拨打电话失败", "error")
        }
        ))
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ), utsArrayOf(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("map-container" to padStyleMapOf(utsMapOf("width" to "100%", "backgroundColor" to "#ffffff")), "route-love" to padStyleMapOf(utsMapOf("boxSizing" to "border-box", "width" to "100%", "paddingTop" to "35rpx", "paddingRight" to "35rpx", "paddingBottom" to "35rpx", "paddingLeft" to "35rpx", "position" to "relative", "left" to 0, "right" to 0, "height" to "250rpx")), "title" to utsMapOf(".route-love " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#FFFFFF")), "bg-img" to utsMapOf(".route-love " to utsMapOf("position" to "absolute", "left" to "-10rpx", "top" to 0, "right" to 0, "height" to "609rpx")), "radio-card-group" to utsMapOf(".route-love " to utsMapOf("flexDirection" to "row", "paddingTop" to "15rpx")), "radio-card" to utsMapOf(".route-love .radio-card-group " to utsMapOf("flex" to 1, "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "textAlign" to "center")), "content-panel" to padStyleMapOf(utsMapOf("borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "0rpx", "borderBottomLeftRadius" to "0rpx", "boxSizing" to "border-box", "boxShadow" to "0rpx 0rpx 8rpx 0rpx rgba(89, 119, 177, 0.5)", "transitionProperty" to "transform", "transitionDuration" to "0.5s", "position" to "fixed", "left" to 0, "right" to 0)), "planning-header" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "boxSizing" to "border-box", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "backgroundColor" to "rgba(0,0,0,0)")), "planning-title" to utsMapOf(".planning-header " to utsMapOf("flexDirection" to "row", "alignItems" to "center", "paddingTop" to "5rpx", "paddingRight" to "10rpx", "paddingBottom" to "5rpx", "paddingLeft" to "10rpx", "backgroundImage" to "linear-gradient(to right, #FFF3DD, #00000000)", "borderTopLeftRadius" to "5rpx", "borderTopRightRadius" to "5rpx", "borderBottomRightRadius" to "5rpx", "borderBottomLeftRadius" to "5rpx")), "text" to utsMapOf(".planning-header .planning-title " to utsMapOf("marginRight" to "10rpx"), ".planning-header .sort-btn " to utsMapOf("fontSize" to "26rpx", "color" to "#FFFFFF"), ".route-card .header .traffic-light " to utsMapOf("fontSize" to "26rpx"), ".header-order-title " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx"), ".order-list .order-item .side-tag-box " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#F5F7FA", "position" to "absolute", "left" to "13rpx", "top" to "13rpx"), ".order-list .order-item .order-info .header .left-box " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx"), ".order-list .order-item .order-info .remark " to utsMapOf("width" to "95%", "boxSizing" to "border-box", "paddingLeft" to "6rpx", "fontWeight" to "bold", "fontSize" to "27rpx", "color" to "#D09A5B"), ".order-list .order-item-dx .order-info .header .left-box " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx"), ".order-list .order-item-dx .order-info .remark " to utsMapOf("width" to "95%", "boxSizing" to "border-box", "paddingLeft" to "6rpx", "fontWeight" to "bold", "fontSize" to "27rpx", "color" to "#D09A5B"), ".triping-panel .main-body .left-box " to utsMapOf("fontSize" to "26rpx", "color" to "#000000")), "planning-icon" to utsMapOf(".planning-header .planning-title " to utsMapOf("width" to "21rpx", "height" to "27rpx", "marginRight" to "10rpx")), "sort-btn" to utsMapOf(".planning-header " to utsMapOf("backgroundColor" to "#95B1E7", "paddingTop" to "10rpx", "paddingRight" to "20rpx", "paddingBottom" to "10rpx", "paddingLeft" to "20rpx", "flexDirection" to "row", "alignItems" to "center", "borderTopLeftRadius" to "5rpx", "borderTopRightRadius" to "5rpx", "borderBottomRightRadius" to "5rpx", "borderBottomLeftRadius" to "5rpx")), "sort-icon" to utsMapOf(".planning-header .sort-btn " to utsMapOf("marginLeft" to "10rpx", "width" to "24rpx", "height" to "20rpx")), "routes-container" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "marginTop" to "24rpx", "marginRight" to "30rpx", "marginBottom" to "30rpx", "marginLeft" to "30rpx", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx")), "route-card" to padStyleMapOf(utsMapOf("borderTopLeftRadius" to "16rpx", "borderTopRightRadius" to "16rpx", "borderBottomRightRadius" to "16rpx", "borderBottomLeftRadius" to "16rpx", "justifyContent" to "space-between", "paddingTop" to "15rpx", "paddingRight" to "20rpx", "paddingBottom" to "15rpx", "paddingLeft" to "20rpx", "alignContent" to "space-between", "height" to "210rpx", "flex" to 1)), "header" to utsMapOf(".route-card " to utsMapOf("flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between"), ".order-list .order-item .order-info " to utsMapOf("paddingBottom" to "20rpx", "borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#e7e7e7", "marginBottom" to "20rpx"), ".order-list .order-item-dx .order-info " to utsMapOf("paddingBottom" to "20rpx"), ".triping-panel " to utsMapOf("paddingTop" to "30rpx", "paddingRight" to "45rpx", "paddingBottom" to "10rpx", "paddingLeft" to "45rpx")), "route-title" to utsMapOf(".route-card .header " to utsMapOf("fontSize" to "26rpx")), "traffic-light" to utsMapOf(".route-card .header " to utsMapOf("flexDirection" to "row", "alignItems" to "center")), "light-icon" to utsMapOf(".route-card .header .traffic-light " to utsMapOf("width" to "20rpx", "height" to "22rpx", "marginRight" to "6rpx")), "route-time" to utsMapOf(".route-card " to utsMapOf("fontSize" to "32rpx", "fontWeight" to "bold")), "route-distance" to utsMapOf(".route-card " to utsMapOf("fontSize" to "26rpx")), "bottom-actions" to padStyleMapOf(utsMapOf("backgroundColor" to "#ffffff", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "borderTopWidth" to "1rpx", "borderTopStyle" to "solid", "borderTopColor" to "#eeeeee", "height" to "150rpx", "width" to "100%", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "zIndex" to 10)), "order-btn" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "paddingTop" to 0, "paddingRight" to "100rpx", "paddingBottom" to 0, "paddingLeft" to "20rpx")), "order-icon" to utsMapOf(".order-btn " to utsMapOf("width" to "41rpx", "height" to "47rpx", "marginRight" to "20rpx"), ".triping-panel .header .order-title " to utsMapOf("width" to "24rpx", "height" to "28rpx", "marginRight" to "10rpx")), "header-order-title" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "paddingTop" to "20rpx", "paddingRight" to 0, "paddingBottom" to "20rpx", "paddingLeft" to 0)), "icon" to utsMapOf(".header-order-title " to utsMapOf("width" to "28rpx", "height" to "28rpx", "marginRight" to "10rpx"), ".order-list .order-item .order-info .header .left-box " to utsMapOf("width" to "28rpx", "height" to "28rpx", "marginRight" to "10rpx"), ".order-list .order-item .order-info .address-info .left-box .address-item " to utsMapOf("width" to "20rpx", "height" to "28rpx"), ".order-list .order-item .order-info .seat-info " to utsMapOf("width" to "34rpx", "height" to "28rpx", "marginTop" to "2rpx", "marginLeft" to "15rpx"), ".order-list .order-item .order-info .remark " to utsMapOf("width" to "26rpx", "height" to "26rpx", "marginTop" to "2rpx"), ".order-list .order-item-dx .order-info .header .left-box " to utsMapOf("width" to "28rpx", "height" to "28rpx", "marginRight" to "10rpx"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item " to utsMapOf("width" to "20rpx", "height" to "28rpx"), ".order-list .order-item-dx .order-info .seat-info " to utsMapOf("width" to "34rpx", "height" to "28rpx", "marginTop" to "2rpx", "marginLeft" to "15rpx"), ".order-list .order-item-dx .order-info .remark " to utsMapOf("width" to "26rpx", "height" to "26rpx", "marginTop" to "2rpx")), "num" to utsMapOf(".header-order-title " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#5E7BB7"), ".order-list .order-item .order-info .header .left-box " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#5E7BB7"), ".order-list .order-item .order-info .address-info .right-box " to utsMapOf("color" to "#D18124", "fontSize" to "40rpx"), ".order-list .order-item-dx .order-info .header .left-box " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#D09A5B"), ".order-list .order-item-dx .order-info .address-info .right-box " to utsMapOf("color" to "#D18124", "fontSize" to "40rpx")), "split" to utsMapOf(".header-order-title " to utsMapOf("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx"), ".order-list .order-item .order-info .header .left-box " to utsMapOf("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx"), ".order-list .order-item-dx .order-info .header .left-box " to utsMapOf("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx"), ".triping-panel .main-body .left-box " to utsMapOf("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx")), "more-menu" to utsMapOf(".order-list " to utsMapOf("borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "marginTop" to "10rpx", "marginRight" to "10rpx", "marginBottom" to "10rpx", "marginLeft" to "10rpx", "boxShadow" to "0rpx 0rpx 15rpx 0rpx rgba(89, 119, 177, 0.2)")), "order-item" to utsMapOf(".order-list " to utsMapOf("flex" to 1, "boxSizing" to "border-box", "marginTop" to 0, "marginRight" to "20rpx", "marginBottom" to 0, "marginLeft" to "20rpx", "position" to "relative")), "side-tag-box" to utsMapOf(".order-list .order-item " to utsMapOf("position" to "absolute", "left" to 0, "top" to "15rpx", "width" to "61rpx", "height" to "49rpx", "zIndex" to 2)), "img" to utsMapOf(".order-list .order-item .side-tag-box " to utsMapOf("width" to "100%", "height" to "100%")), "order-info" to utsMapOf(".order-list .order-item " to utsMapOf("backgroundColor" to "#FFFFFF", "boxShadow" to "0rpx 0rpx 10rpx 0rpx rgba(89, 119, 177, 0.2)", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "25rpx", "paddingRight" to "30rpx", "paddingBottom" to "25rpx", "paddingLeft" to "30rpx", "marginTop" to "5rpx", "marginRight" to "10rpx", "marginBottom" to "30rpx", "marginLeft" to "10rpx"), ".order-list .order-item-dx " to utsMapOf("backgroundColor" to "#FFFFFF", "boxShadow" to "0rpx 0rpx 10rpx 0rpx rgba(89, 119, 177, 0.2)", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "25rpx", "paddingRight" to "30rpx", "paddingBottom" to "25rpx", "paddingLeft" to "30rpx", "marginTop" to "5rpx", "marginRight" to "10rpx", "marginBottom" to "30rpx", "marginLeft" to "10rpx")), "left-box" to utsMapOf(".order-list .order-item .order-info .header " to utsMapOf("paddingLeft" to "35rpx"), ".order-list .order-item .order-info .address-info " to utsMapOf("width" to "80%"), ".order-list .order-item-dx .order-info .address-info " to utsMapOf("width" to "80%"), ".triping-panel .main-body " to utsMapOf("width" to "90%")), "right-box" to utsMapOf(".order-list .order-item .order-info .header " to utsMapOf("alignItems" to "center"), ".order-list .order-item-dx .order-info .header " to utsMapOf("alignItems" to "center"), ".order-list .order-item-dx .order-info .address-info " to utsMapOf("width" to "100rpx")), "more-btn" to utsMapOf(".order-list .order-item .order-info .header .right-box " to utsMapOf("fontSize" to "28rpx"), ".order-list .order-item-dx .order-info .header .right-box " to utsMapOf("fontSize" to "28rpx")), "border" to utsMapOf(".order-list .order-item .order-info " to utsMapOf("height" to "1rpx", "backgroundImage" to "none", "backgroundColor" to "#E6E7E9"), ".order-list .order-item-dx .order-info " to utsMapOf("height" to "1rpx", "backgroundImage" to "none", "backgroundColor" to "#E6E7E9")), "address-info" to utsMapOf(".order-list .order-item .order-info " to utsMapOf("paddingLeft" to "20rpx"), ".triping-panel .main-body .left-box " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#898989", "paddingBottom" to "10rpx")), "top" to utsMapOf(".order-list .order-item .order-info .address-info .left-box .address-item " to utsMapOf("alignItems" to "center"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item " to utsMapOf("alignItems" to "center")), "label" to utsMapOf(".order-list .order-item .order-info .address-info .left-box .address-item .top " to utsMapOf("paddingLeft" to "10rpx", "fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000"), ".order-list .order-item .order-info .seat-info " to utsMapOf("fontSize" to "26rpx", "color" to "#898989"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item .top " to utsMapOf("paddingLeft" to "10rpx", "fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000"), ".order-list .order-item-dx .order-info .seat-info " to utsMapOf("fontSize" to "26rpx", "color" to "#898989")), "bottom" to utsMapOf(".order-list .order-item .order-info .address-info .left-box .address-item " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#898989", "marginLeft" to "10rpx", "marginBottom" to "3rpx", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "22rpx", "paddingLeft" to "20rpx"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#898989", "marginLeft" to "10rpx", "marginBottom" to "3rpx", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "22rpx", "paddingLeft" to "20rpx")), "seat-info" to utsMapOf(".order-list .order-item .order-info " to utsMapOf("flexDirection" to "row", "paddingBottom" to "20rpx"), ".order-list .order-item-dx .order-info " to utsMapOf("flexDirection" to "row", "paddingBottom" to "20rpx")), "value" to utsMapOf(".order-list .order-item .order-info .seat-info " to utsMapOf("fontSize" to "26rpx", "color" to "#4D679B"), ".order-list .order-item-dx .order-info .seat-info " to utsMapOf("fontSize" to "26rpx", "color" to "#4D679B")), "remark" to utsMapOf(".order-list .order-item .order-info " to utsMapOf("backgroundImage" to "none", "backgroundColor" to "#FDF7F0", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "12rpx", "paddingRight" to "12rpx", "paddingBottom" to "12rpx", "paddingLeft" to "12rpx", "boxSizing" to "border-box"), ".order-list .order-item-dx .order-info " to utsMapOf("backgroundImage" to "none", "backgroundColor" to "#FDF7F0", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "12rpx", "paddingRight" to "12rpx", "paddingBottom" to "12rpx", "paddingLeft" to "12rpx", "boxSizing" to "border-box")), "btn-group" to utsMapOf(".order-list .order-item .order-info " to utsMapOf("paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0), ".order-list .order-item-dx .order-info " to utsMapOf("paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0), "" to utsMapOf("paddingTop" to "30rpx", "paddingRight" to 0, "paddingBottom" to "30rpx", "paddingLeft" to 0)), "order-item-dx" to utsMapOf(".order-list " to utsMapOf("boxSizing" to "border-box", "marginTop" to 0, "marginRight" to "20rpx", "marginBottom" to 0, "marginLeft" to "20rpx", "position" to "relative")), "triping-panel" to padStyleMapOf(utsMapOf("borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "0rpx", "borderBottomLeftRadius" to "0rpx", "boxSizing" to "border-box", "boxShadow" to "0rpx 0rpx 8rpx 0rpx rgba(89, 119, 177, 0.5)", "position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "#ffffff")), "current-step" to utsMapOf(".triping-panel .header " to utsMapOf("fontSize" to "34rpx", "color" to "#000000")), "main-body" to utsMapOf(".triping-panel " to utsMapOf("paddingTop" to 0, "paddingRight" to "45rpx", "paddingBottom" to "25rpx", "paddingLeft" to "45rpx")), "call-phone" to utsMapOf(".triping-panel .main-body " to utsMapOf("width" to "50rpx", "height" to "50rpx")), "footer" to utsMapOf(".triping-panel " to utsMapOf("paddingTop" to 0, "paddingRight" to "40rpx", "paddingBottom" to "20rpx", "paddingLeft" to "40rpx")), "@TRANSITION" to utsMapOf("content-panel" to utsMapOf("property" to "transform", "duration" to "0.5s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf("globalData" to utsMapOf("type" to "Object"))
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
