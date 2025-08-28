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
open class GenPagesOtherCarSettingIndex : BasePage {
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
        var setup: (__props: GenPagesOtherCarSettingIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherCarSettingIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val ws = Ws.ws
            val serviceConfig = ref<ServiceOrderPermission>(ServiceOrderPermission(allocateSeatModel = false, allowSubmitOrderNoCar = false, allowDriverCloseTakeOrder = false, allowDriverCancelOrder = false, enableNumberPrivacy = false, enableCallRecording = false))
            val onStopOrderClick = fun(){
                if (!globalData.carSetting.closeReceiveOrderSwitch && !serviceConfig.value.allowDriverCloseTakeOrder) {
                    showTips("您的服务商设置当前不允许停止接单", "warning")
                }
            }
            val showRouteStrategy = ref(false)
            val showAiDescModal = ref(false)
            val routeStrategyStr = ref("综合最优")
            val routeStrategyOptions = _uA<RouteStrategyOption>(RouteStrategyOption(code = "OVERALL_OPTIMAL", name = "综合最优"), RouteStrategyOption(code = "FASTEST", name = "速度优先"), RouteStrategyOption(code = "CHARGE_LESS", name = "少收费"), RouteStrategyOption(code = "DONT_HIGH_SPEED", name = "不走高速"))
            val queryOrUpdateSetting = fun(msg: Any){
                ws?.sendAndOn(WebSocketSendMessage(type = MessageType["QUERY_CAR_SETTING"] as Number, content = msg), fun(data){
                    console.log("查询订单列表：", data)
                    val json = JSON.parse<UTSJSONObject>(data)
                    globalData.carSetting.closeReceiveOrderSwitch = json?.getBoolean("closeReceiveOrderSwitch") ?: true
                    globalData.carSetting.enableReceiveOrderConfirm = json?.getBoolean("enableReceiveOrderConfirm") ?: false
                    globalData.carSetting.enableAIRouteStrategy = json?.getBoolean("enableAIRouteStrategy") ?: false
                    globalData.carSetting.routeStrategy = json?.getString("routeStrategy") ?: "OVERALL_OPTIMAL"
                    routeStrategyStr.value = routeStrategyOptions.find(fun(item): Boolean {
                        return item.code == globalData.carSetting.routeStrategy
                    }
                    )?.name ?: "综合最优"
                }
                )
            }
            val changeOrderEvt = fun(kVal: Boolean){
                queryOrUpdateSetting(object : UTSJSONObject() {
                    var closeReceiveOrderSwitch = kVal
                })
            }
            val changeOrderReceiveEvt = fun(kVal: Boolean){
                queryOrUpdateSetting(object : UTSJSONObject() {
                    var enableReceiveOrderConfirm = kVal
                })
            }
            val changeAiCalcEvt = fun(kVal: Boolean){
                queryOrUpdateSetting(object : UTSJSONObject() {
                    var enableAIRouteStrategy = kVal
                })
            }
            val changeRouteLoveEvt = fun(kVal: RouteStrategyOption){
                globalData.carSetting.routeStrategy = kVal.code
                routeStrategyStr.value = kVal.name
                queryOrUpdateSetting(object : UTSJSONObject() {
                    var routeStrategy = kVal.code
                })
                showRouteStrategy.value = false
            }
            onMounted(fun(){
                routeStrategyStr.value = routeStrategyOptions.find(fun(item): Boolean {
                    return item.code == globalData.carSetting.routeStrategy
                }
                )?.name ?: ""
                queryOrUpdateSetting("")
                getServiceOperationSetting().then(fun(res: Response){
                    val data = JSON.parse<ServiceOrderPermission>(JSON.stringify(res.data))
                    serviceConfig.value = data!!
                }
                )
            }
            )
            return fun(): Any? {
                val _component_x_switch = resolveEasyComponent("x-switch", GenUniModulesTmxUiComponentsXSwitchXSwitchClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                val _component_x_drawer = resolveEasyComponent("x-drawer", GenUniModulesTmxUiComponentsXDrawerXDrawerClass)
                val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_mc_base_container, _uM("title" to "出车设置"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cV(_component_x_sheet, _uM("margin" to _uA(
                                "15"
                            ), "padding" to _uA(
                                "20"
                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "setting-item"), _uA(
                                        _cE("text", _uM("class" to "name"), "停止接单"),
                                        _cV(_component_x_switch, _uM("onClick" to onStopOrderClick, "disabled" to (!unref(globalData).carSetting.closeReceiveOrderSwitch && !unref(serviceConfig).allowDriverCloseTakeOrder), "modelValue" to unref(globalData).carSetting.closeReceiveOrderSwitch, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                            unref(globalData).carSetting.closeReceiveOrderSwitch = `$event`
                                        }
                                        , "onChange" to changeOrderEvt, "label" to _uA(
                                            "开",
                                            "关"
                                        )), null, 8, _uA(
                                            "disabled",
                                            "modelValue",
                                            "onUpdate:modelValue"
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_x_sheet, _uM("padding" to _uA(
                                "20"
                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "setting-item"), _uA(
                                        _cE("text", _uM("class" to "name"), "开启订单接收确认"),
                                        _cV(_component_x_switch, _uM("onClick" to onStopOrderClick, "modelValue" to unref(globalData).carSetting.enableReceiveOrderConfirm, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                            unref(globalData).carSetting.enableReceiveOrderConfirm = `$event`
                                        }
                                        , "onChange" to changeOrderReceiveEvt, "label" to _uA(
                                            "开",
                                            "关"
                                        )), null, 8, _uA(
                                            "modelValue",
                                            "onUpdate:modelValue"
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_x_sheet, _uM("padding" to _uA(
                                "20"
                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "setting-item"), _uA(
                                        _cE("view", _uM("class" to "flex-row flex-row-center-center"), _uA(
                                            _cE("text", _uM("onClick" to fun(){
                                                showAiDescModal.value = true
                                            }
                                            , "class" to "name pr-10"), "智能规划", 8, _uA(
                                                "onClick"
                                            )),
                                            _cE("image", _uM("onClick" to fun(){
                                                showAiDescModal.value = true
                                            }
                                            , "style" to _nS(_uM("width" to "23rpx", "height" to "30rpx")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-tips-outline-small.png")), null, 12, _uA(
                                                "onClick",
                                                "src"
                                            ))
                                        )),
                                        _cV(_component_x_switch, _uM("modelValue" to unref(globalData).carSetting.enableAIRouteStrategy, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                            unref(globalData).carSetting.enableAIRouteStrategy = `$event`
                                        }
                                        , "onChange" to changeAiCalcEvt, "label" to _uA(
                                            "开",
                                            "关"
                                        )), null, 8, _uA(
                                            "modelValue",
                                            "onUpdate:modelValue"
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_x_sheet, _uM("padding" to _uA(
                                "20"
                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "setting-item", "onClick" to fun(){
                                        showRouteStrategy.value = true
                                    }
                                    ), _uA(
                                        _cE("text", _uM("class" to "name"), "偏好设置"),
                                        _cE("view", _uM("class" to "flex-row flex-row-center-center"), _uA(
                                            _cE("text", _uM("class" to "value"), _tD(unref(routeStrategyStr)), 1),
                                            _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 8, _uA(
                                                "src"
                                            ))
                                        ))
                                    ), 8, _uA(
                                        "onClick"
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )
                    }
                    ), "_" to 1)),
                    _cV(_component_x_drawer, _uM("content-margin" to "30rpx", "show" to unref(showRouteStrategy), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showRouteStrategy, `$event`)
                    }
                    , "bgColor" to "#ECF1F8", "show-title" to false, "size" to "657rpx"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("text", _uM("class" to "title"), "偏好设置"),
                            _cE("view", _uM("class" to "radio-btn-group"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(routeStrategyOptions, fun(item, __key, __index, _cached): Any {
                                    return _cE("view", _uM("class" to _nC(_uA(
                                        "radio-btn",
                                        _uM("actived" to (unref(globalData).carSetting.routeStrategy == item.code))
                                    )), "key" to item.code, "onClick" to fun(){
                                        changeRouteLoveEvt(item)
                                    }
                                    , "style" to _nS("background-image: linear-gradient(to right, " + (if (unref(globalData).carSetting.routeStrategy == item.code) {
                                        unref(globalData).theme.primaryLinearColors.join(", ")
                                    } else {
                                        _uA(
                                            "#ffffff",
                                            "#ffffff"
                                        ).join(", ")
                                    }
                                    ) + ")")), _uA(
                                        _cE("text", _uM("class" to "text", "style" to _nS("color: " + (if (unref(globalData).carSetting.routeStrategy == item.code) {
                                            "#ffffff"
                                        } else {
                                            "#0000000"
                                        }
                                        ) + ";")), _tD(item.name), 5)
                                    ), 14, _uA(
                                        "onClick"
                                    ))
                                }
                                ), 64)
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    )),
                    _cV(_component_x_modal, _uM("show" to unref(showAiDescModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showAiDescModal, `$event`)
                    }
                    , "bgColor" to "#ECF1F8", "show-cancel" to false, "confirm-text" to "知道了", "onConfirm" to fun(){
                        showAiDescModal.value = false
                    }
                    , "show-title" to false, "height" to "520rpx"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("text", _uM("class" to "title"), "智能规划介绍"),
                            _cE("view", _uM("class" to "desc"), _uA(
                                _cE("text", _uM("class" to "pb-10"), "关闭智能规划: 订单以下单时间默认排序，司机可手动拖拽修改顺序。"),
                                _cE("text", null, "开启智能规划: 订单会根据最优路线排序，司机不可手动修改，该模式可有效节省行程和出行时间。")
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show",
                        "onConfirm"
                    ))
                ), 64)
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
                return _uM("setting-item" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "name" to _uM(".setting-item " to _uM("fontSize" to 17)), "value" to _uM(".setting-item " to _uM("color" to "#939393")), "icon" to _uM(".setting-item " to _uM("width" to "17rpx", "height" to "28rpx", "marginLeft" to "20rpx", "marginTop" to "3rpx")), "title" to _pS(_uM("textAlign" to "center", "width" to "100%", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "radio-btn" to _uM(".radio-btn-group " to _uM("paddingTop" to "30rpx", "paddingRight" to "60rpx", "paddingBottom" to "30rpx", "paddingLeft" to "60rpx", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "marginBottom" to "30rpx", "transitionProperty" to "backgroundImage,boxShadow", "transitionDuration" to "0.25s"), ".radio-btn-group .actived" to _uM("boxShadow" to "0rpx 5rpx 10rpx 0rpx rgba(89, 119, 177, 0.2)")), "text" to _uM(".radio-btn-group .radio-btn " to _uM("textAlign" to "center", "fontSize" to "32rpx")), "@TRANSITION" to _uM("radio-btn" to _uM("property" to "backgroundImage,boxShadow", "duration" to "0.25s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
