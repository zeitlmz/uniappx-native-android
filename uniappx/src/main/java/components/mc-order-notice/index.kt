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
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenComponentsMcOrderNoticeIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsMcOrderNoticeIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsMcOrderNoticeIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val showDrawer = ref(false)
            val orderList = ref(_uA<IntercityOrderReceiveInfo>())
            val processOrder = fun(orderId: String, receive: Boolean){
                showLoading(XLOADINGS_TYPE(title = "\u6B63\u5728" + (if (receive) {
                    "接收"
                } else {
                    "拒收"
                }
                ) + "\u8BA2\u5355..."))
                Ws.ws.sendAndOnErr(WebSocketSendMessage(type = MessageType["ORDER_RECEIVE_CONFIRM"] as Number, content = _uO("orderId" to orderId, "accept" to receive)), fun(data){
                    hideXloading()
                    uni__emit("orderReceiveQuery", null)
                    val res = JSON.parse<UTSJSONObject>(data) as UTSJSONObject
                    if (res.getBoolean("success") ?: false) {
                        showTips(res.getString("msg") ?: "", "success")
                        uni__emit("orderQuery", null)
                    } else {
                        showTips(res.getString("msg") ?: "", "error")
                    }
                }
                , fun(data){
                    hideXloading()
                    showTips("" + (if (receive) {
                        "接收"
                    } else {
                        "拒收"
                    }
                    ) + "\u5931\u8D25", "success")
                    uni__emit("orderReceiveQuery", null)
                }
                )
            }
            val rejectOrder = fun(orderId: String){
                processOrder(orderId, false)
            }
            val agreeOrder = fun(orderId: String){
                processOrder(orderId, true)
            }
            val scheduledTimeMap = reactive<Map<String, RemainingTimeType>>(Map())
            var timer: Number = -1
            val updateScheduledTime = fun(){
                orderList.value.forEach(fun(item: IntercityOrderReceiveInfo){
                    val time = getRemainingTime(addTime(item.time, 90, "second"))
                    if (time > 1) {
                        scheduledTimeMap.set(item.orderId, RemainingTimeType(timestamp = time, strDate = formatToSeconds(time)))
                    } else {
                        scheduledTimeMap.`delete`(item.orderId)
                        item.needDelete = true
                    }
                }
                )
                val oldOrderList = orderList.value.filter(fun(item): Boolean {
                    return !(item.needDelete ?: false)
                }
                )
                if (oldOrderList.length != orderList.value.length) {
                    orderList.value = oldOrderList
                    if (orderList.value.length == 0) {
                        clearInterval(timer)
                        showDrawer.value = false
                    }
                }
            }
            val orderReceiveListFunc = fun(data: UTSArray<IntercityOrderReceiveInfo>){
                orderList.value = data
                console.log("orderReceiveListFunc====>", data)
                if (orderList.value.length > 0) {
                    showDrawer.value = true
                    updateScheduledTime()
                    if (timer > -1) {
                        clearInterval(timer)
                    }
                    timer = setInterval(updateScheduledTime, 1000)
                } else {
                    showDrawer.value = false
                    clearInterval(timer)
                }
            }
            val toReceiveOrderDetail = fun(orderId: String){
                uni_navigateTo(NavigateToOptions(url = "/pages/other/order-detail/receive-order?orderId=" + orderId))
            }
            val isFirst = ref(true)
            onPageShow(fun(){
                console.log("isFirst.value====>", isFirst.value)
                if (!isFirst.value) {
                    console.log("onPageShow====>")
                    updateScheduledTime()
                    setTimeout(fun(){
                        uni__emit("orderReceiveQuery", null)
                    }
                    , 100)
                }
            }
            )
            onPageHide(fun(){
                showDrawer.value = false
                orderList.value = _uA()
                clearInterval(timer)
            }
            )
            onMounted(fun(){
                console.log("onMounted====>")
                isFirst.value = false
                uni__on("orderReceiveList", orderReceiveListFunc)
            }
            )
            onUnmounted(fun(){
                console.log("onUnmounted====>")
                clearInterval(timer)
                orderList.value = _uA()
                uni__off("orderReceiveList", orderReceiveListFunc)
            }
            )
            return fun(): Any? {
                val _component_mc_pain_button = resolveEasyComponent("mc-pain-button", GenComponentsMcPainButtonIndexClass)
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                val _component_x_overlay = resolveEasyComponent("x-overlay", GenUniModulesTmxUiComponentsXOverlayXOverlayClass)
                return _cV(_component_x_overlay, _uM("show" to unref(showDrawer), "onUpdate:show" to fun(`$event`: Boolean){
                    trySetRefValue(showDrawer, `$event`)
                }
                ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("scroll-view", _uM("direction" to "vertical", "style" to _nS("height: " + unref(screenHeight) + "px;")), _uA(
                            _cE("view", _uM("class" to "order-notice-list"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(orderList), fun(item, __key, __index, _cached): Any {
                                    return _cE("view", _uM("class" to "order-notice-item", "key" to item.orderId, "onClick" to fun(){
                                        toReceiveOrderDetail(item.orderId)
                                    }
                                    ), _uA(
                                        _cE("view", _uM("class" to "notice-card-header flex-row flex-row-center-start"), _uA(
                                            _cE("image", _uM("class" to "notice-icon", "src" to "/static/icons/icon-notice-clock.png")),
                                            _cE("text", _uM("class" to "notice-title"), "新订单提醒"),
                                            _cE("text", _uM("class" to "notice-time"), _tD(item.time), 1)
                                        )),
                                        _cE("view", _uM("class" to "address-info flex-row flex-row-center-between"), _uA(
                                            _cE("view", _uM("class" to "left-box"), _uA(
                                                _cE("view", _uM("class" to "address-item"), _uA(
                                                    _cE("view", _uM("class" to "top flex-row", "style" to _nS(_uM("padding-top" to "20rpx"))), _uA(
                                                        _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location-start.png"), "mode" to ""), null, 8, _uA(
                                                            "src"
                                                        )),
                                                        _cE("text", _uM("class" to "label"), _tD(item.startCity + item.startDistrict), 1)
                                                    ), 4),
                                                    _cE("text", _uM("class" to "bottom", "style" to _nS("border-left: 1rpx solid " + unref(globalData).theme.primaryColor + ";")), _tD(item.startAddress), 5)
                                                )),
                                                _cE("view", _uM("class" to "address-item"), _uA(
                                                    _cE("view", _uM("class" to "top flex-row"), _uA(
                                                        _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location-end.png")), null, 8, _uA(
                                                            "src"
                                                        )),
                                                        _cE("text", _uM("class" to "label"), _tD(item.endCity + item.endDistrict), 1)
                                                    )),
                                                    _cE("text", _uM("class" to "bottom"), _tD(item.endAddress), 1)
                                                ))
                                            )),
                                            _cE("view", _uM("class" to "right-box"), _uA(
                                                _cE("view", _uM("class" to "pb-5 flex-row flex-row-center-center"), _uA(
                                                    _cE("text", _uM("class" to "num"), _tD(item.passengerNum), 1),
                                                    _cE("text", _uM("class" to "label"), "人")
                                                )),
                                                _cV(_component_mc_pain_button, _uM("fontSize" to "28rpx", "border" to ("1px solid " + unref(globalData).theme.primaryColor), "color" to unref(globalData).theme.primaryColor, "onClick" to fun(){
                                                    rejectOrder(item.orderId)
                                                }
                                                ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        "拒绝接单(" + _tD(unref(scheduledTimeMap).get(item.orderId)?.strDate) + ")"
                                                    )
                                                }
                                                ), "_" to 2), 1032, _uA(
                                                    "border",
                                                    "color",
                                                    "onClick"
                                                )),
                                                _cE("view", _uM("class" to "pt-15")),
                                                _cV(_component_mc_primary_button, _uM("fontSize" to "28rpx", "onClick" to fun(){
                                                    agreeOrder(item.orderId)
                                                }
                                                ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        "立即接单"
                                                    )
                                                }
                                                ), "_" to 2), 1032, _uA(
                                                    "onClick"
                                                ))
                                            ))
                                        ))
                                    ), 8, _uA(
                                        "onClick"
                                    ))
                                }
                                ), 128)
                            ))
                        ), 4)
                    )
                }
                ), "_" to 1), 8, _uA(
                    "show"
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("order-notice-list" to _pS(_uM("boxSizing" to "border-box", "paddingTop" to 50, "paddingRight" to "32rpx", "paddingBottom" to 50, "paddingLeft" to "32rpx")), "order-notice-item" to _uM(".order-notice-list " to _uM("paddingTop" to "30rpx", "paddingRight" to "30rpx", "paddingBottom" to "30rpx", "paddingLeft" to "30rpx", "marginBottom" to "30rpx", "backgroundColor" to "#ffffff", "borderTopLeftRadius" to "16rpx", "borderTopRightRadius" to "16rpx", "borderBottomRightRadius" to "16rpx", "borderBottomLeftRadius" to "16rpx")), "notice-card-header" to _uM(".order-notice-list .order-notice-item " to _uM("borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#C8C8C8", "paddingBottom" to "15rpx")), "notice-icon" to _uM(".order-notice-list .order-notice-item .notice-card-header " to _uM("width" to "27rpx", "height" to "30rpx")), "notice-title" to _uM(".order-notice-list .order-notice-item .notice-card-header " to _uM("paddingLeft" to "10rpx", "fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#536EA5")), "notice-time" to _uM(".order-notice-list .order-notice-item .notice-card-header " to _uM("paddingLeft" to "20rpx", "fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000")), "left-box" to _uM(".order-notice-list .order-notice-item .address-info " to _uM("width" to "62%")), "icon" to _uM(".order-notice-list .order-notice-item .address-info .left-box .address-item " to _uM("width" to "20rpx", "height" to "28rpx")), "top" to _uM(".order-notice-list .order-notice-item .address-info .left-box .address-item " to _uM("alignItems" to "center")), "label" to _uM(".order-notice-list .order-notice-item .address-info .left-box .address-item .top " to _uM("paddingLeft" to "10rpx", "fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#000000")), "bottom" to _uM(".order-notice-list .order-notice-item .address-info .left-box .address-item " to _uM("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#898989", "marginLeft" to "10rpx", "marginBottom" to "3rpx", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "22rpx", "paddingLeft" to "20rpx")), "right-box" to _uM(".order-notice-list .order-notice-item .address-info " to _uM("width" to "235rpx", "height" to "200rpx")), "num" to _uM(".order-notice-list .order-notice-item .address-info .right-box " to _uM("color" to "#D18124", "fontSize" to "38rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
