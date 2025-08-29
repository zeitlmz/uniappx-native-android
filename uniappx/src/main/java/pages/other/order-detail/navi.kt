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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import uts.sdk.modules.mcAmapNav.MapOption
import uts.sdk.modules.mcAmapNav.SingleLocationOptions
import uts.sdk.modules.mcAmapNav.SuccessCallback
import uts.sdk.modules.mcAmapNav.AmapNavOption
import uts.sdk.modules.mcAmapNav.MarkerOption
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import io.dcloud.uniapp.extapi.makePhoneCall as uni_makePhoneCall
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.reLaunch as uni_reLaunch
import uts.sdk.modules.xModalS.showModal
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
import uts.sdk.modules.xVibrateS.vibrator
open class GenPagesOtherOrderDetailNavi : BasePage {
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
        onReady(fun() {
            this.setMarker()
        }
        , __ins)
        onLoad(fun(query: OnLoadOptions) {
            console.log("query:", query)
            this.orderParams = JSON.parse<UTSJSONObject>(JSON.stringify(query)) ?: UTSJSONObject()
            uni__on("onSendData", this.onSendData)
            uni__on("syncNavInfo", this.syncNavInfo)
            uni__on("backPage", this.backPage)
        }
        , __ins)
        onBeforeUnmount(fun() {
            uni__off("syncNavInfo", this.syncNavInfo)
            uni__off("onSendData", this.onSendData)
            uni__off("backPage", this.backPage)
            hideXloading()
        }
        , __ins)
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_mc_amap_nav = resolveEasyComponent("mc-amap-nav", GenComponentsMcAmapNavIndexClass)
        val _component_mc_drag_verify = resolveEasyComponent("mc-drag-verify", GenComponentsMcDragVerifyIndexClass)
        val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
        val _component_x_code_input = resolveEasyComponent("x-code-input", GenUniModulesTmxUiComponentsXCodeInputXCodeInputClass)
        val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
        val _component_x_keyboard_number = resolveEasyComponent("x-keyboard-number", GenUniModulesTmxUiComponentsXKeyboardNumberXKeyboardNumberClass)
        return _cE(Fragment, null, _uA(
            _cV(_component_mc_amap_nav, _uM("style" to _nS("margin-top: " + (_ctx.statusBarHeight + 50) + "px;height:" + (_ctx.screenHeight - 230 - _ctx.globalData.safeAreaBottom - _ctx.statusBarHeight) + "px"), "ref" to "naviView", "onQuit" to fun(){
                _ctx.navQuit(false)
            }
            ), null, 8, _uA(
                "style",
                "onQuit"
            )),
            _cV(_component_mc_base_container, _uM("title" to "订单详情", "bg-color" to "#ffffff", "scroll" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                return _uA(
                    if (isTrue(_ctx.showPanel)) {
                        _cE("view", _uM("key" to 0, "class" to "triping-panel", "style" to _nS("height: " + (180 + _ctx.globalData.safeAreaBottom) + "px;")), _uA(
                            _cE("view", _uM("class" to "header flex-row flex-row-center-between"), _uA(
                                _cE("text", _uM("class" to "current-step"), _uA(
                                    if (isTrue(_ctx.orderData.orderChains[_ctx.currentIndex]?.orderStatus == 3 || _ctx.orderData.orderChains[_ctx.currentIndex]?.waitingStatus == 0)) {
                                        _cE("text", _uM("key" to 0), "正在前往")
                                    } else {
                                        _cE("text", _uM("key" to 1), "已达到")
                                    },
                                    _cE("text", _uM("style" to _nS("color: #" + _ctx.orderData.orderChains[_ctx.currentIndex]?.pointColor + ";")), _tD(_ctx.orderData.orderChains[_ctx.currentIndex]?.pointName), 5),
                                    _cE("text", null, _tD(if (_ctx.orderData.orderChains[_ctx.currentIndex]?.orderStatus == 3) {
                                        "目的地"
                                    } else {
                                        "上车点"
                                    }), 1)
                                )),
                                _cE("view", _uM("class" to "order-title flex-row"), _uA(
                                    _cE("image", _uM("class" to "order-icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-order-outline.png")), null, 8, _uA(
                                        "src"
                                    )),
                                    _cE("view", _uM("class" to "flex-row"), _uA(
                                        _cE("text", _uM("style" to _nS("color:" + _ctx.globalData.theme.primaryColor)), _tD(_ctx.currentIndex + 1), 5),
                                        _cE("text", null, "/"),
                                        _cE("text", _uM("style" to _nS("color:" + _ctx.globalData.theme.primaryColor)), _tD(_ctx.orderData.orderChains.length), 5),
                                        _cE("text", null, "订单")
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "main-body flex-row flex-row-center-between"), _uA(
                                _cE("view", _uM("class" to "left-box"), _uA(
                                    _cE("text", _uM("class" to "address-info"), _tD(_ctx.orderData.orderChains[_ctx.currentIndex].pointAddress), 1),
                                    _cE("view", _uM("class" to "flex-row"), _uA(
                                        _cE("text", _uM("class" to "text"), "距我"),
                                        _cE("text", _uM("class" to "text", "style" to _nS("font-weight: bold;color:" + _ctx.globalData.theme.primaryColor)), _tD(_ctx.viaDistance), 5),
                                        _cE("text", _uM("class" to "split"), "|"),
                                        _cE("text", _uM("class" to "text"), "预计"),
                                        _cE("text", _uM("class" to "text", "style" to _nS("font-weight: bold;color:" + _ctx.globalData.theme.primaryColor)), _tD(_ctx.viaTime), 5)
                                    ))
                                )),
                                _cE("image", _uM("class" to "call-phone", "onClick" to _ctx.callPhone, "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-call-phone-filled.png"), "mode" to "widthFix"), null, 8, _uA(
                                    "onClick",
                                    "src"
                                ))
                            )),
                            _cE("view", _uM("class" to "footer", "style" to _nS("width: " + _ctx.screenWidth + "px;")), _uA(
                                if (isTrue(_ctx.orderData.orderChains[_ctx.currentIndex]?.orderStatus == 2 && _ctx.orderData.orderChains[_ctx.currentIndex]?.waitingStatus == 0)) {
                                    _cV(_component_mc_drag_verify, _uM("key" to 0, "ref" to "verify", "onSuccess" to _ctx.tryArrived, "linear-gradient" to _ctx.globalData.theme.primaryLinearColors, "bg-color" to "#E2EAFA", "verify-text" to "右滑确认到达乘客上车点", "completeText" to "已到达上车点", "verify-text-color" to "#ffffff", "img-icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-verify-arrow-right.png"), "round" to 20), null, 8, _uA(
                                        "onSuccess",
                                        "linear-gradient",
                                        "img-icon-path"
                                    ))
                                } else {
                                    if (isTrue(_ctx.orderData.orderChains[_ctx.currentIndex]?.orderStatus == 2 && _ctx.orderData.orderChains[_ctx.currentIndex]?.waitingStatus == 1)) {
                                        _cV(_component_mc_drag_verify, _uM("key" to 1, "ref" to "verify", "onSuccess" to _ctx.verifySuccess, "linear-gradient" to _uA(
                                            "#25B3EE",
                                            "#1F82C8"
                                        ), "bg-color" to "#CFEFFF", "verify-text" to "右滑确认乘客已上车", "completeText" to "乘客已上车", "verify-text-color" to "#ffffff", "img-icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-verify-arrow-right.png"), "round" to 20), null, 8, _uA(
                                            "onSuccess",
                                            "img-icon-path"
                                        ))
                                    } else {
                                        if (_ctx.orderData.orderChains[_ctx.currentIndex]?.orderStatus == 3) {
                                            _cV(_component_mc_drag_verify, _uM("key" to 2, "ref" to "verify", "onSuccess" to _ctx.validOrder, "linear-gradient" to _uA(
                                                "#44C791",
                                                "#28D07F"
                                            ), "bg-color" to "#D0F6E5", "verify-text" to "右滑确认行程已完成", "completeText" to "行程已完成", "verify-text-color" to "#ffffff", "img-icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-verify-arrow-right.png"), "round" to 20), null, 8, _uA(
                                                "onSuccess",
                                                "img-icon-path"
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    }
                                }
                            ), 4)
                        ), 4)
                    } else {
                        _cC("v-if", true)
                    }
                )
            }
            ), "_" to 1)),
            _cV(_component_x_modal, _uM("show" to _ctx.showValidModal, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.showValidModal = `$event`
            }
            , "show-close" to "", "onClose" to _ctx.modalClose, "height" to "300rpx", "z-index" to "100", "title" to "请输入乘客手机尾号", "show-footer" to false, "overlayClick" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                return _uA(
                    _cV(_component_x_code_input, _uM("auto-focus" to "", "place-shape" to "line", "onClick" to fun(){
                        _ctx.showKey = true
                    }
                    , "onConfirm" to _ctx.validPhoneConfirm, "modelValue" to _ctx.phoneSuffix, "onUpdate:modelValue" to fun(`$event`: String){
                        _ctx.phoneSuffix = `$event`
                    }
                    , "useSysKeyborad" to false, "skin" to "fill"), null, 8, _uA(
                        "onClick",
                        "onConfirm",
                        "modelValue",
                        "onUpdate:modelValue"
                    ))
                )
            }
            ), "_" to 1), 8, _uA(
                "show",
                "onUpdate:show",
                "onClose"
            )),
            _cV(_component_x_keyboard_number, _uM("mode" to "password", "max-len" to 4, "btn-color" to "white", "digit" to false, "modelShow" to _ctx.showKey, "onUpdate:modelShow" to fun(`$event`: Boolean){
                _ctx.showKey = `$event`
            }
            , "modelValue" to _ctx.phoneSuffix, "onUpdate:modelValue" to fun(`$event`: String){
                _ctx.phoneSuffix = `$event`
            }
            ), null, 8, _uA(
                "modelShow",
                "onUpdate:modelShow",
                "modelValue",
                "onUpdate:modelValue"
            ))
        ), 64)
    }
    open var globalData: GlobalDataType by `$inject`
    open var i18n: Tmui4xI18nTml by `$data`
    open var resBaseUrl: Any? by `$data`
    open var currentIndex: Number by `$data`
    open var showValidModal: Boolean by `$data`
    open var showKey: Boolean by `$data`
    open var phoneSuffix: String by `$data`
    open var showPanel: Boolean by `$data`
    open var orderParams: UTSJSONObject by `$data`
    open var orderData: OrderSummary1 by `$data`
    open var screenWidth: Number by `$data`
    open var screenHeight: Number by `$data`
    open var statusBarHeight: Number by `$data`
    open var viaDistance: String by `$data`
    open var viaTime: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "resBaseUrl" to uni.UNI09580B7.resBaseUrl, "currentIndex" to 0, "showValidModal" to false, "showKey" to false, "phoneSuffix" to "", "showPanel" to false, "orderParams" to UTSJSONObject(), "orderData" to OrderSummary1(orderCount = 0, driverStatus = -2, seatSelectTemplates = _uA(), orderItems = _uA(), orderChains = _uA(), orderRoute = OrderRoute(routeStrategy = "", routeStartPoint = "", routeWaypoints = _uA(), routeEndPoint = "", routeWaypointsPoiIds = _uA<String>(), routeStartPoiId = "", routeEndPoiId = "")), "screenWidth" to uni.UNI09580B7.screenWidth as Number, "screenHeight" to uni.UNI09580B7.screenHeight as Number, "statusBarHeight" to uni.UNI09580B7.statusBarHeight as Number, "viaDistance" to "0公里", "viaTime" to "0分钟")
    }
    open var backPage = ::gen_backPage_fn
    open fun gen_backPage_fn() {
        uni_navigateBack(NavigateBackOptions(delta = 1))
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
            return MarkerOption(latitude = pointArr[0], longitude = pointArr[1], color = item.pointColor, desc = item.pointName, showWindinfo = false, address = "", addressDetail = "")
        }
        )
        naviView?.setMarkers(markers)
    }
    open var navQuit = ::gen_navQuit_fn
    open fun gen_navQuit_fn(canCalcRoute: Boolean) {
        vibrator(100)
        uni_useKuxRouter().back(-1)
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
        ws2?.sendAndOnErr(WebSocketSendMessage(type = MessageType["ARRIVED_TRIP"] as Number, content = that.orderData.orderChains[that.currentIndex].orderId), fun(data){
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
        ws2?.sendAndOnErr(WebSocketSendMessage(type = MessageType["VALID_PHONE"] as Number, content = JSON.stringify(object : UTSJSONObject() {
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
                uni__emit("showModalTip", "验证乘客手机号成功")
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
            ws2?.sendAndOnErr(WebSocketSendMessage(type = MessageType["OPEN_TRIP"] as Number), fun(data){
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
            ws2?.sendAndOnErr(WebSocketSendMessage(type = MessageType["ORDER_FINISH"] as Number, content = order.orderId), fun(data){
                console.log("完成订单：", data)
                if (that.orderData.orderChains.length > 1) {
                    uni__emit("showModalTip", order.pointName + "已完成")
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
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("map-container" to _pS(_uM("width" to "100%", "backgroundColor" to "#ffffff")), "route-love" to _pS(_uM("boxSizing" to "border-box", "width" to "100%", "paddingTop" to "35rpx", "paddingRight" to "35rpx", "paddingBottom" to "35rpx", "paddingLeft" to "35rpx", "position" to "relative", "left" to 0, "right" to 0, "height" to "250rpx")), "title" to _uM(".route-love " to _uM("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#FFFFFF")), "bg-img" to _uM(".route-love " to _uM("position" to "absolute", "left" to "-10rpx", "top" to 0, "right" to 0, "height" to "609rpx")), "radio-card-group" to _uM(".route-love " to _uM("flexDirection" to "row", "paddingTop" to "15rpx")), "radio-card" to _uM(".route-love .radio-card-group " to _uM("flex" to 1, "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "textAlign" to "center")), "content-panel" to _pS(_uM("borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "0rpx", "borderBottomLeftRadius" to "0rpx", "boxSizing" to "border-box", "boxShadow" to "0rpx 0rpx 8rpx 0rpx rgba(89, 119, 177, 0.5)", "transitionProperty" to "transform", "transitionDuration" to "0.5s", "position" to "fixed", "left" to 0, "right" to 0)), "planning-header" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "boxSizing" to "border-box", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "backgroundColor" to "rgba(0,0,0,0)")), "planning-title" to _uM(".planning-header " to _uM("flexDirection" to "row", "alignItems" to "center", "paddingTop" to "5rpx", "paddingRight" to "10rpx", "paddingBottom" to "5rpx", "paddingLeft" to "10rpx", "backgroundImage" to "linear-gradient(to right, #FFF3DD, #00000000)", "borderTopLeftRadius" to "5rpx", "borderTopRightRadius" to "5rpx", "borderBottomRightRadius" to "5rpx", "borderBottomLeftRadius" to "5rpx")), "text" to _uM(".planning-header .planning-title " to _uM("marginRight" to "10rpx"), ".planning-header .sort-btn " to _uM("fontSize" to "26rpx", "color" to "#FFFFFF"), ".route-card .header .traffic-light " to _uM("fontSize" to "26rpx"), ".header-order-title " to _uM("fontWeight" to "bold", "fontSize" to "26rpx"), ".order-list .order-item .side-tag-box " to _uM("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#F5F7FA", "position" to "absolute", "left" to "13rpx", "top" to "13rpx"), ".order-list .order-item .order-info .header .left-box " to _uM("fontWeight" to "bold", "fontSize" to "26rpx"), ".order-list .order-item .order-info .remark " to _uM("width" to "95%", "boxSizing" to "border-box", "paddingLeft" to "6rpx", "fontWeight" to "bold", "fontSize" to "27rpx", "color" to "#D09A5B"), ".order-list .order-item-dx .order-info .header .left-box " to _uM("fontWeight" to "bold", "fontSize" to "26rpx"), ".order-list .order-item-dx .order-info .remark " to _uM("width" to "95%", "boxSizing" to "border-box", "paddingLeft" to "6rpx", "fontWeight" to "bold", "fontSize" to "27rpx", "color" to "#D09A5B"), ".triping-panel .main-body .left-box " to _uM("fontSize" to "26rpx", "color" to "#000000")), "planning-icon" to _uM(".planning-header .planning-title " to _uM("width" to "21rpx", "height" to "27rpx", "marginRight" to "10rpx")), "sort-btn" to _uM(".planning-header " to _uM("backgroundColor" to "#95B1E7", "paddingTop" to "10rpx", "paddingRight" to "20rpx", "paddingBottom" to "10rpx", "paddingLeft" to "20rpx", "flexDirection" to "row", "alignItems" to "center", "borderTopLeftRadius" to "5rpx", "borderTopRightRadius" to "5rpx", "borderBottomRightRadius" to "5rpx", "borderBottomLeftRadius" to "5rpx")), "sort-icon" to _uM(".planning-header .sort-btn " to _uM("marginLeft" to "10rpx", "width" to "24rpx", "height" to "20rpx")), "routes-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "marginTop" to "24rpx", "marginRight" to "30rpx", "marginBottom" to "30rpx", "marginLeft" to "30rpx", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx")), "route-card" to _pS(_uM("borderTopLeftRadius" to "16rpx", "borderTopRightRadius" to "16rpx", "borderBottomRightRadius" to "16rpx", "borderBottomLeftRadius" to "16rpx", "justifyContent" to "space-between", "paddingTop" to "15rpx", "paddingRight" to "20rpx", "paddingBottom" to "15rpx", "paddingLeft" to "20rpx", "alignContent" to "space-between", "height" to "210rpx", "flex" to 1)), "header" to _uM(".route-card " to _uM("flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between"), ".order-list .order-item .order-info " to _uM("paddingBottom" to "20rpx", "borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#e7e7e7", "marginBottom" to "20rpx"), ".order-list .order-item-dx .order-info " to _uM("paddingBottom" to "20rpx"), ".triping-panel " to _uM("paddingTop" to "30rpx", "paddingRight" to "45rpx", "paddingBottom" to "10rpx", "paddingLeft" to "45rpx")), "route-title" to _uM(".route-card .header " to _uM("fontSize" to "26rpx")), "traffic-light" to _uM(".route-card .header " to _uM("flexDirection" to "row", "alignItems" to "center")), "light-icon" to _uM(".route-card .header .traffic-light " to _uM("width" to "20rpx", "height" to "22rpx", "marginRight" to "6rpx")), "route-time" to _uM(".route-card " to _uM("fontSize" to "32rpx", "fontWeight" to "bold")), "route-distance" to _uM(".route-card " to _uM("fontSize" to "26rpx")), "bottom-actions" to _pS(_uM("backgroundColor" to "#ffffff", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "borderTopWidth" to "1rpx", "borderTopStyle" to "solid", "borderTopColor" to "#eeeeee", "height" to "150rpx", "width" to "100%", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "zIndex" to 10)), "order-btn" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "paddingTop" to 0, "paddingRight" to "100rpx", "paddingBottom" to 0, "paddingLeft" to "20rpx")), "order-icon" to _uM(".order-btn " to _uM("width" to "41rpx", "height" to "47rpx", "marginRight" to "20rpx"), ".triping-panel .header .order-title " to _uM("width" to "24rpx", "height" to "28rpx", "marginRight" to "10rpx")), "header-order-title" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "paddingTop" to "20rpx", "paddingRight" to 0, "paddingBottom" to "20rpx", "paddingLeft" to 0)), "icon" to _uM(".header-order-title " to _uM("width" to "28rpx", "height" to "28rpx", "marginRight" to "10rpx"), ".order-list .order-item .order-info .header .left-box " to _uM("width" to "28rpx", "height" to "28rpx", "marginRight" to "10rpx"), ".order-list .order-item .order-info .address-info .left-box .address-item " to _uM("width" to "20rpx", "height" to "28rpx"), ".order-list .order-item .order-info .seat-info " to _uM("width" to "34rpx", "height" to "28rpx", "marginTop" to "2rpx", "marginLeft" to "15rpx"), ".order-list .order-item .order-info .remark " to _uM("width" to "26rpx", "height" to "26rpx", "marginTop" to "2rpx"), ".order-list .order-item-dx .order-info .header .left-box " to _uM("width" to "28rpx", "height" to "28rpx", "marginRight" to "10rpx"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item " to _uM("width" to "20rpx", "height" to "28rpx"), ".order-list .order-item-dx .order-info .seat-info " to _uM("width" to "34rpx", "height" to "28rpx", "marginTop" to "2rpx", "marginLeft" to "15rpx"), ".order-list .order-item-dx .order-info .remark " to _uM("width" to "26rpx", "height" to "26rpx", "marginTop" to "2rpx")), "num" to _uM(".header-order-title " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#5E7BB7"), ".order-list .order-item .order-info .header .left-box " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#5E7BB7"), ".order-list .order-item .order-info .address-info .right-box " to _uM("color" to "#D18124", "fontSize" to "40rpx"), ".order-list .order-item-dx .order-info .header .left-box " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#D09A5B"), ".order-list .order-item-dx .order-info .address-info .right-box " to _uM("color" to "#D18124", "fontSize" to "40rpx")), "split" to _uM(".header-order-title " to _uM("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx"), ".order-list .order-item .order-info .header .left-box " to _uM("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx"), ".order-list .order-item-dx .order-info .header .left-box " to _uM("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx"), ".triping-panel .main-body .left-box " to _uM("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx")), "more-menu" to _uM(".order-list " to _uM("borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "marginTop" to "10rpx", "marginRight" to "10rpx", "marginBottom" to "10rpx", "marginLeft" to "10rpx", "boxShadow" to "0rpx 0rpx 15rpx 0rpx rgba(89, 119, 177, 0.2)")), "order-item" to _uM(".order-list " to _uM("flex" to 1, "boxSizing" to "border-box", "marginTop" to 0, "marginRight" to "20rpx", "marginBottom" to 0, "marginLeft" to "20rpx", "position" to "relative")), "side-tag-box" to _uM(".order-list .order-item " to _uM("position" to "absolute", "left" to 0, "top" to "15rpx", "width" to "61rpx", "height" to "49rpx", "zIndex" to 2)), "img" to _uM(".order-list .order-item .side-tag-box " to _uM("width" to "100%", "height" to "100%")), "order-info" to _uM(".order-list .order-item " to _uM("backgroundColor" to "#FFFFFF", "boxShadow" to "0rpx 0rpx 10rpx 0rpx rgba(89, 119, 177, 0.2)", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "25rpx", "paddingRight" to "30rpx", "paddingBottom" to "25rpx", "paddingLeft" to "30rpx", "marginTop" to "5rpx", "marginRight" to "10rpx", "marginBottom" to "30rpx", "marginLeft" to "10rpx"), ".order-list .order-item-dx " to _uM("backgroundColor" to "#FFFFFF", "boxShadow" to "0rpx 0rpx 10rpx 0rpx rgba(89, 119, 177, 0.2)", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "25rpx", "paddingRight" to "30rpx", "paddingBottom" to "25rpx", "paddingLeft" to "30rpx", "marginTop" to "5rpx", "marginRight" to "10rpx", "marginBottom" to "30rpx", "marginLeft" to "10rpx")), "left-box" to _uM(".order-list .order-item .order-info .header " to _uM("paddingLeft" to "35rpx"), ".order-list .order-item .order-info .address-info " to _uM("width" to "80%"), ".order-list .order-item-dx .order-info .address-info " to _uM("width" to "80%"), ".triping-panel .main-body " to _uM("width" to "90%")), "right-box" to _uM(".order-list .order-item .order-info .header " to _uM("alignItems" to "center"), ".order-list .order-item-dx .order-info .header " to _uM("alignItems" to "center"), ".order-list .order-item-dx .order-info .address-info " to _uM("width" to "100rpx")), "more-btn" to _uM(".order-list .order-item .order-info .header .right-box " to _uM("fontSize" to "28rpx"), ".order-list .order-item-dx .order-info .header .right-box " to _uM("fontSize" to "28rpx")), "border" to _uM(".order-list .order-item .order-info " to _uM("height" to "1rpx", "backgroundImage" to "none", "backgroundColor" to "#E6E7E9"), ".order-list .order-item-dx .order-info " to _uM("height" to "1rpx", "backgroundImage" to "none", "backgroundColor" to "#E6E7E9")), "address-info" to _uM(".order-list .order-item .order-info " to _uM("paddingLeft" to "20rpx"), ".triping-panel .main-body .left-box " to _uM("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#898989", "paddingBottom" to "10rpx")), "top" to _uM(".order-list .order-item .order-info .address-info .left-box .address-item " to _uM("alignItems" to "center"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item " to _uM("alignItems" to "center")), "label" to _uM(".order-list .order-item .order-info .address-info .left-box .address-item .top " to _uM("paddingLeft" to "10rpx", "fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000"), ".order-list .order-item .order-info .seat-info " to _uM("fontSize" to "26rpx", "color" to "#898989"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item .top " to _uM("paddingLeft" to "10rpx", "fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000"), ".order-list .order-item-dx .order-info .seat-info " to _uM("fontSize" to "26rpx", "color" to "#898989")), "bottom" to _uM(".order-list .order-item .order-info .address-info .left-box .address-item " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#898989", "marginLeft" to "10rpx", "marginBottom" to "3rpx", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "22rpx", "paddingLeft" to "20rpx"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#898989", "marginLeft" to "10rpx", "marginBottom" to "3rpx", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "22rpx", "paddingLeft" to "20rpx")), "seat-info" to _uM(".order-list .order-item .order-info " to _uM("flexDirection" to "row", "paddingBottom" to "20rpx"), ".order-list .order-item-dx .order-info " to _uM("flexDirection" to "row", "paddingBottom" to "20rpx")), "value" to _uM(".order-list .order-item .order-info .seat-info " to _uM("fontSize" to "26rpx", "color" to "#4D679B"), ".order-list .order-item-dx .order-info .seat-info " to _uM("fontSize" to "26rpx", "color" to "#4D679B")), "remark" to _uM(".order-list .order-item .order-info " to _uM("backgroundImage" to "none", "backgroundColor" to "#FDF7F0", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "12rpx", "paddingRight" to "12rpx", "paddingBottom" to "12rpx", "paddingLeft" to "12rpx", "boxSizing" to "border-box"), ".order-list .order-item-dx .order-info " to _uM("backgroundImage" to "none", "backgroundColor" to "#FDF7F0", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "12rpx", "paddingRight" to "12rpx", "paddingBottom" to "12rpx", "paddingLeft" to "12rpx", "boxSizing" to "border-box")), "btn-group" to _uM(".order-list .order-item .order-info " to _uM("paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0), ".order-list .order-item-dx .order-info " to _uM("paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0), "" to _uM("paddingTop" to "30rpx", "paddingRight" to 0, "paddingBottom" to "30rpx", "paddingLeft" to 0)), "order-item-dx" to _uM(".order-list " to _uM("boxSizing" to "border-box", "marginTop" to 0, "marginRight" to "20rpx", "marginBottom" to 0, "marginLeft" to "20rpx", "position" to "relative")), "triping-panel" to _pS(_uM("borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "0rpx", "borderBottomLeftRadius" to "0rpx", "boxSizing" to "border-box", "boxShadow" to "0rpx 0rpx 8rpx 0rpx rgba(89, 119, 177, 0.5)", "position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "#ffffff")), "current-step" to _uM(".triping-panel .header " to _uM("fontSize" to "34rpx", "color" to "#000000")), "main-body" to _uM(".triping-panel " to _uM("paddingTop" to 0, "paddingRight" to "45rpx", "paddingBottom" to "25rpx", "paddingLeft" to "45rpx")), "call-phone" to _uM(".triping-panel .main-body " to _uM("width" to "50rpx", "height" to "50rpx")), "footer" to _uM(".triping-panel " to _uM("paddingTop" to 0, "paddingRight" to "40rpx", "paddingBottom" to "20rpx", "paddingLeft" to "40rpx")), "@TRANSITION" to _uM("content-panel" to _uM("property" to "transform", "duration" to "0.5s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM("globalData" to _uM("type" to "Object"))
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
