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
import uts.sdk.modules.mcAmapNav.MapOption
import uts.sdk.modules.mcAmapNav.SingleLocationOptions
import uts.sdk.modules.mcAmapNav.SuccessCallback
import uts.sdk.modules.mcAmapNav.AmapNavOption
import uts.sdk.modules.mcAmapNav.MarkerOption
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
open class GenPagesOtherOrderDetailReceiveOrder : BasePage {
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
        onLoad(fun(query: OnLoadOptions) {
            this.orderId = query["orderId"] as String
        }
        , __ins)
        onBeforeUnmount(fun() {
            val mapView = (this.`$refs`["mapView"] as McAmapComponentPublicInstance)
            mapView?.destroy()
            hideXloading()
        }
        , __ins)
        onReady(fun() {
            this.queryOrderDetail()
        }
        , __ins)
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_mc_amap = resolveEasyComponent("mc-amap", GenComponentsMcAmapIndexClass)
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
        val _component_x_tabs = resolveEasyComponent("x-tabs", GenUniModulesTmxUiComponentsXTabsXTabsClass)
        val _component_mc_pain_button = resolveEasyComponent("mc-pain-button", GenComponentsMcPainButtonIndexClass)
        val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
        val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
        return _cE(Fragment, null, _uA(
            _cV(_component_mc_amap, _uM("self-location" to true, "ref" to "mapView", "style" to _nS("margin-top: " + (_ctx.statusBarHeight + 50) + "px;height: " + (_ctx.screenHeight - 425 - _ctx.globalData.safeAreaBottom) + "px;")), null, 8, _uA(
                "style"
            )),
            _cV(_component_mc_base_container, _uM("title" to "新订单详情", "bg-color" to "#ffffff", "showOrderNotice" to false, "scroll" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                return _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(_ctx.orderList, fun(item, __key, __index, _cached): Any {
                        return _cE("view", _uM("class" to "content-card", "key" to item.confirmOrder.orderId, "style" to _nS("width: 100%;height: 360px;padding-bottom:" + _ctx.globalData.safeAreaBottom + "px;background: #ffffff")), _uA(
                            _cV(_component_x_tabs, _uM("modelValue" to _ctx.acitveTab, "onUpdate:modelValue" to fun(`$event`: String){
                                _ctx.acitveTab = `$event`
                            }
                            , "isItemCenter" to "", "onChange" to _ctx.onTabChange, "line-full" to false, "line-height" to "3", "line-color" to "#5470A7", "color" to "#00000000", "list" to _ctx.tabs), _uM("default" to withScopedSlotCtx(fun(slotProps: GenUniModulesTmxUiComponentsXTabsXTabsSlotDataDefault): UTSArray<Any> {
                                val item = slotProps.item
                                val active = slotProps.active
                                return _uA(
                                    _cV(_component_x_text, _uM("style" to _nS(_uA(
                                        if (active) {
                                            "font-weight:bold;font-size:22;color: #5470A7;"
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
                            ), "_" to 2), 1032, _uA(
                                "modelValue",
                                "onUpdate:modelValue",
                                "onChange",
                                "list"
                            )),
                            _cE("scroll-view", _uM("direction" to "vertical", "style" to _nS(_uM("height" to "225px"))), _uA(
                                _cE("view", _uM("class" to "address-container"), _uA(
                                    _cE("view", _uM("class" to "address-info flex-row flex-row-center-between"), _uA(
                                        _cE("view", _uM("class" to "left-box"), _uA(
                                            _cE("view", _uM("class" to "address-item"), _uA(
                                                _cE("view", _uM("class" to "top flex-row", "style" to _nS(_uM("padding-top" to "20rpx"))), _uA(
                                                    _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-location-start.png"), "mode" to ""), null, 8, _uA(
                                                        "src"
                                                    )),
                                                    _cE("text", _uM("class" to "label"), _tD(item.confirmOrder.startCity + item.confirmOrder.startDistrict), 1)
                                                ), 4),
                                                _cE("text", _uM("class" to "bottom", "style" to _nS("border-left: 1rpx solid " + _ctx.globalData.theme.primaryColor + ";")), _tD(item.confirmOrder.startAddress), 5)
                                            )),
                                            _cE("view", _uM("class" to "address-item"), _uA(
                                                _cE("view", _uM("class" to "top flex-row"), _uA(
                                                    _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-location-end.png")), null, 8, _uA(
                                                        "src"
                                                    )),
                                                    _cE("text", _uM("class" to "label"), _tD(item.confirmOrder.endCity + item.confirmOrder.endDistrict), 1)
                                                )),
                                                _cE("text", _uM("class" to "bottom"), _tD(item.confirmOrder.endAddress), 1)
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "right-box"), _uA(
                                            _cE("view", _uM("class" to "pb-5 flex-row flex-row-center-center"), _uA(
                                                _cE("text", _uM("class" to "num"), _tD(item.confirmOrder.passengerNum), 1),
                                                _cE("text", _uM("class" to "label"), "人")
                                            ))
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "row-info", "style" to _nS(_uM("border-top" to "1rpx solid #CDD5E4"))), _uA(
                                        _cE("view", _uM("class" to "row-info", "style" to _nS(_uM("padding" to "0 100rpx 0 0"))), _uA(
                                            _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-clock-filled-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                                "src"
                                            )),
                                            _cE("text", _uM("class" to "value"), _tD(item.confirmOrder.departureFormat), 1)
                                        ), 4),
                                        _cE("view", _uM("class" to "row-info"), _uA(
                                            _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-seat-filled-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                                "src"
                                            )),
                                            _cE("text", _uM("class" to "value"), _tD(item.confirmOrder.chooseSeat?.map(fun(seat, index, _arr): String {
                                                return seat.displayName + " " + seat.seatKey + (if (index % 2 != 0) {
                                                    " \n"
                                                } else {
                                                    if (index < _arr.length - 1) {
                                                        " / "
                                                    } else {
                                                        ""
                                                    }
                                                }
                                                )
                                            }
                                            )?.join("") ?: "-"), 1)
                                        ))
                                    ), 4),
                                    _cE("view", _uM("class" to "row-info", "style" to _nS(_uM("padding-bottom" to "15rpx"))), _uA(
                                        _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-remark-filled.png"), "mode" to "widthFix"), null, 8, _uA(
                                            "src"
                                        )),
                                        _cE("text", _uM("class" to "label"), "备注："),
                                        _cE("text", _uM("class" to "value"), _tD(if (item.confirmOrder.remark == "") {
                                            "-"
                                        } else {
                                            item.confirmOrder.remark
                                        }
                                        ), 1)
                                    ), 4)
                                ))
                            ), 4),
                            _cE("view", _uM("class" to "bottom-actions", "style" to _nS("padding-bottom: " + (_ctx.globalData.safeAreaBottom + 5) + "px;")), _uA(
                                _cV(_component_mc_pain_button, _uM("fontSize" to "26rpx", "border" to ("1px solid " + _ctx.globalData.theme.primaryColor), "color" to _ctx.globalData.theme.primaryColor, "margin-right" to "20rpx", "onClick" to fun(){
                                    _ctx.rejectOrder(item.confirmOrder.orderId)
                                }
                                ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "拒绝接单(" + _tD(_ctx.scheduledTimeMap.get(item.confirmOrder.orderId)?.strDate) + ")"
                                    )
                                }
                                ), "_" to 2), 1032, _uA(
                                    "border",
                                    "color",
                                    "onClick"
                                )),
                                _cE("view", _uM("class" to "pt-15")),
                                _cV(_component_mc_primary_button, _uM("fontSize" to "26rpx", "onClick" to fun(){
                                    _ctx.agreeOrder(item.confirmOrder.orderId)
                                }
                                ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "立即接单"
                                    )
                                }
                                ), "_" to 2), 1032, _uA(
                                    "onClick"
                                ))
                            ), 4)
                        ), 4)
                    }
                    ), 128)
                )
            }
            ), "_" to 1))
        ), 64)
    }
    open var globalData: GlobalDataType by `$inject`
    open var currentOrderIndex: Number by `$data`
    open var scheduledTimeMap: Map<String, RemainingTimeType1> by `$data`
    open var timer: Number by `$data`
    open var orderId: String by `$data`
    open var orderList: UTSArray<OrderReceiveSummary> by `$data`
    open var statusBarHeight: Number by `$data`
    open var acitveTab: String by `$data`
    open var tabs: UTSArray<Any?> by `$data`
    open var currentChooseSeat: UTSArray<ChooseSeat> by `$data`
    open var seatSelectTemplates: UTSArray<SeatSelectTemplate> by `$data`
    open var resBaseUrl: Any? by `$data`
    open var screenWidth: Number by `$data`
    open var screenHeight: Number by `$data`
    open var pointBounds: UTSArray<UTSArray<Number>> by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("currentOrderIndex" to 0, "scheduledTimeMap" to Map<String, RemainingTimeType1>(), "timer" to -1, "orderId" to "", "orderList" to _uA<OrderReceiveSummary>(), "statusBarHeight" to uni.UNI09580B7.statusBarHeight as Number, "acitveTab" to "0", "tabs" to _uA(
            TABS_ITEM_INFO(title = "上车点位置"),
            TABS_ITEM_INFO(title = "下车点位置")
        ), "currentChooseSeat" to _uA<ChooseSeat>(), "seatSelectTemplates" to _uA<SeatSelectTemplate>(), "resBaseUrl" to uni.UNI09580B7.resBaseUrl, "screenWidth" to uni.UNI09580B7.screenWidth as Number, "screenHeight" to uni.UNI09580B7.screenHeight as Number, "pointBounds" to _uA<UTSArray<Number>>())
    }
    open var processOrder = ::gen_processOrder_fn
    open fun gen_processOrder_fn(orderId: String, receive: Boolean) {
        showLoading(XLOADINGS_TYPE(title = "\u6B63\u5728" + (if (receive) {
            "接收"
        } else {
            "拒收"
        }
        ) + "\u8BA2\u5355..."))
        Ws.ws.sendAndOnErr(WebSocketSendMessage(type = MessageType["ORDER_RECEIVE_CONFIRM"] as Number, content = _uO("orderId" to orderId, "accept" to receive)), fun(data){
            hideXloading()
            val res = JSON.parse<UTSJSONObject>(data) as UTSJSONObject
            uni_navigateBack(NavigateBackOptions(delta = 1, success = fun(_) {
                setTimeout(fun(){
                    if (res.getBoolean("success") ?: false) {
                        showTips(res.getString("msg") ?: "", "success")
                    } else {
                        showTips(res.getString("msg") ?: "", "error")
                    }
                }
                , 250)
            }
            ))
        }
        , fun(data){
            hideXloading()
            showTips("" + (if (receive) {
                "接收"
            } else {
                "拒收"
            }
            ) + "\u5931\u8D25", "success")
        }
        )
    }
    open var rejectOrder = ::gen_rejectOrder_fn
    open fun gen_rejectOrder_fn(orderId: String) {
        this.processOrder(orderId, false)
    }
    open var agreeOrder = ::gen_agreeOrder_fn
    open fun gen_agreeOrder_fn(orderId: String) {
        this.processOrder(orderId, true)
    }
    open var updateScheduledTime = ::gen_updateScheduledTime_fn
    open fun gen_updateScheduledTime_fn() {
        this.orderList.forEach(fun(item: OrderReceiveSummary){
            val time = getRemainingTime(addTime(item.confirmOrder.time, 20, "second"))
            if (time > 1) {
                this.scheduledTimeMap.set(item.confirmOrder.orderId, RemainingTimeType1(timestamp = time, strDate = formatTimestamp(time, false)))
            } else {
                this.scheduledTimeMap.`delete`(item.confirmOrder.orderId)
                item.confirmOrder.needDelete = true
            }
        }
        )
        val oldOrderList = this.orderList.filter(fun(item: OrderReceiveSummary): Boolean {
            return !(item.confirmOrder.needDelete ?: false)
        }
        )
        if (oldOrderList.length != this.orderList.length) {
            this.orderList = oldOrderList
            if (this.orderList.length == 0) {
                clearInterval(this.timer)
                uni_navigateBack(NavigateBackOptions(delta = 1))
            }
        }
    }
    open var onTabChange = ::gen_onTabChange_fn
    open fun gen_onTabChange_fn(_0: TABS_ITEM, index: Number) {
        val boundsPoints = _uA(
            _uA(
                this.globalData.position.latitude,
                this.globalData.position.longitude
            )
        ) as UTSArray<UTSArray<Number>>
        val mapView = (this.`$refs`["mapView"] as McAmapComponentPublicInstance)
        this.orderList[this.currentOrderIndex].orderChains.forEach(fun(item){
            val pointArr: UTSArray<Number> = item.point.split(",").reverse().map(fun(item: String): Number {
                return UTSNumber.from(item)
            }
            )
            boundsPoints.push(pointArr)
        }
        )
        if (index == 0) {
            val startPointArr: UTSArray<Number> = this.orderList[this.currentOrderIndex].confirmOrder.startPoint.split(",").reverse().map(fun(item: String): Number {
                return UTSNumber.from(item)
            })
            boundsPoints.push(startPointArr)
        } else if (index == 1) {
            val endPointArr: UTSArray<Number> = this.orderList[this.currentOrderIndex].confirmOrder.endPoint.split(",").reverse().map(fun(item: String): Number {
                return UTSNumber.from(item)
            }
            )
            boundsPoints.push(endPointArr)
        }
        this.pointBounds = boundsPoints
        mapView?.setBounds(boundsPoints)
    }
    open var queryOrderDetail = ::gen_queryOrderDetail_fn
    open fun gen_queryOrderDetail_fn() {
        val that = this
        ws?.sendAndOn(WebSocketSendMessage(type = MessageType["QUERY_ORDER"] as Number, content = object : UTSJSONObject() {
            var queryType = OrderQueryType["ORDER_RECEIVE_DETAIL"]
            var condition = that.orderId
        }), fun(data){
            val anyData = JSON.parse<QueryResponse<Any>>(data)
            if (anyData?.queryType == 7) {
                val resData = JSON.parse<QueryResponse<OrderReceiveSummary>>(data)
                val orders: UTSArray<OrderReceiveSummary> = _uA()
                orders.push((resData?.data as OrderReceiveSummary))
                that.orderList = orders
                that.updateScheduledTime()
                if (that.timer > -1) {
                    clearInterval(that.timer)
                }
                that.timer = setInterval(this.updateScheduledTime, 1000)
                setTimeout(fun(){
                    val boundsPoints = _uA(
                        _uA(
                            that.globalData.position.latitude,
                            that.globalData.position.longitude
                        )
                    ) as UTSArray<UTSArray<Number>>
                    val mapView = (that.`$refs`["mapView"] as McAmapComponentPublicInstance)
                    val markers = orders[that.currentOrderIndex].orderChains.map(fun(item): MarkerOption {
                        val pointArr: UTSArray<Number> = item.point.split(",").reverse().map(fun(item: String): Number {
                            return UTSNumber.from(item)
                        }
                        )
                        boundsPoints.push(pointArr)
                        return MarkerOption(latitude = pointArr[0], longitude = pointArr[1], color = item.pointColor, desc = item.pointName, showWindinfo = false, address = "", addressDetail = "")
                    }
                    )
                    val orderInfo = this.orderList[this.currentOrderIndex].confirmOrder
                    val startPointArr: UTSArray<Number> = orderInfo.startPoint.split(",").reverse().map(fun(item: String): Number {
                        return UTSNumber.from(item)
                    }
                    )
                    boundsPoints.push(startPointArr)
                    val startMarker = MarkerOption(showWindinfo = true, latitude = startPointArr[0], longitude = startPointArr[1], color = "", desc = "起点", address = orderInfo.startCity + orderInfo.startDistrict, addressDetail = orderInfo.startAddress)
                    val endPointArr: UTSArray<Number> = orderInfo.endPoint.split(",").reverse().map(fun(item: String): Number {
                        return UTSNumber.from(item)
                    }
                    )
                    val endMarker = MarkerOption(showWindinfo = true, latitude = endPointArr[0], longitude = endPointArr[1], color = "", desc = "终点", address = orderInfo.endCity + orderInfo.endDistrict, addressDetail = orderInfo.endAddress)
                    markers.push(startMarker, endMarker)
                    mapView?.setMarkers(markers)
                    mapView?.setPolylines(orders[that.currentOrderIndex].orderPolyline)
                    that.pointBounds = boundsPoints
                    mapView?.setBounds(boundsPoints)
                }
                , 10)
            }
        }
        )
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
                return _uM("map-container" to _pS(_uM("width" to "100%", "backgroundColor" to "#ffffff")), "content-card" to _pS(_uM("borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "0rpx", "borderBottomLeftRadius" to "0rpx", "boxSizing" to "border-box", "boxShadow" to "0rpx 0rpx 8rpx 0rpx rgba(89, 119, 177, 0.5)", "position" to "fixed", "bottom" to 0, "left" to 0)), "address-card" to _pS(_uM("borderTopLeftRadius" to "16rpx", "borderTopRightRadius" to "16rpx", "borderBottomRightRadius" to "16rpx", "borderBottomLeftRadius" to "16rpx", "justifyContent" to "space-between", "paddingTop" to "15rpx", "paddingRight" to "20rpx", "paddingBottom" to "15rpx", "paddingLeft" to "20rpx", "alignContent" to "space-between", "height" to "210rpx", "flex" to 1)), "left-box" to _uM(".address-info " to _uM("width" to "80%")), "icon" to _uM(".address-info .left-box .address-item " to _uM("width" to "20rpx", "height" to "28rpx"), ".row-info " to _uM("width" to "26rpx", "height" to "26rpx", "marginRight" to "10rpx")), "top" to _uM(".address-info .left-box .address-item " to _uM("alignItems" to "center")), "label" to _uM(".address-info .left-box .address-item .top " to _uM("paddingLeft" to "10rpx", "fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000"), ".row-info " to _uM("color" to "#000000", "fontWeight" to "bold", "fontSize" to "26rpx")), "bottom" to _uM(".address-info .left-box .address-item " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#898989", "marginLeft" to "10rpx", "marginBottom" to "3rpx", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "22rpx", "paddingLeft" to "20rpx")), "right-box" to _uM(".address-info " to _uM("width" to "100rpx")), "num" to _uM(".address-info .right-box " to _uM("color" to "#5470A7", "fontSize" to "40rpx")), "address-container" to _pS(_uM("marginTop" to 0, "marginRight" to "30rpx", "marginBottom" to 0, "marginLeft" to "30rpx", "paddingTop" to "10rpx", "paddingRight" to "25rpx", "paddingBottom" to "10rpx", "paddingLeft" to "25rpx", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "backgroundColor" to "#F2F6FF")), "bottom-actions" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "height" to "150rpx", "width" to "100%", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx")), "row-info" to _pS(_uM("paddingTop" to "15rpx", "flexDirection" to "row", "alignItems" to "center")), "value" to _uM(".row-info " to _uM("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#000000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM("globalData" to _uM("type" to "Object"))
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
