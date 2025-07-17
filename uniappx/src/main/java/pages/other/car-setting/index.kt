@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI09580B7
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
            val routeStrategyOptions = utsArrayOf<RouteStrategyOption>(RouteStrategyOption(code = "OVERALL_OPTIMAL", name = "综合最优"), RouteStrategyOption(code = "FASTEST", name = "速度优先"), RouteStrategyOption(code = "CHARGE_LESS", name = "少收费"), RouteStrategyOption(code = "DONT_HIGH_SPEED", name = "不走高速"))
            val queryOrUpdateSetting = fun(msg: Any){
                ws?.sendAndOn(WebSocketSendMessage(type = MessageType["QUERY_CAR_SETTING"] as Number, content = msg), fun(data){
                    console.log("查询订单列表：", data)
                    val json = JSON.parse<UTSJSONObject>(data)
                    globalData.carSetting.closeReceiveOrderSwitch = json?.getBoolean("closeReceiveOrderSwitch") ?: true
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
                return createElementVNode(Fragment, null, utsArrayOf(
                    createVNode(_component_mc_base_container, utsMapOf("title" to "出车设置"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                                "15"
                            ), "padding" to utsArrayOf(
                                "20"
                            )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "setting-item"), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "name"), "停止接单"),
                                        createVNode(_component_x_switch, utsMapOf("onClick" to onStopOrderClick, "disabled" to (!unref(globalData).carSetting.closeReceiveOrderSwitch && !unref(serviceConfig).allowDriverCloseTakeOrder), "modelValue" to unref(globalData).carSetting.closeReceiveOrderSwitch, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                            unref(globalData).carSetting.closeReceiveOrderSwitch = `$event`
                                        }
                                        , "onChange" to changeOrderEvt, "label" to utsArrayOf(
                                            "开",
                                            "关"
                                        )), null, 8, utsArrayOf(
                                            "disabled",
                                            "modelValue",
                                            "onUpdate:modelValue"
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            createVNode(_component_x_sheet, utsMapOf("padding" to utsArrayOf(
                                "20"
                            )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "setting-item"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "flex-row flex-row-center-center"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("onClick" to fun(){
                                                showAiDescModal.value = true
                                            }
                                            , "class" to "name pr-10"), "智能规划", 8, utsArrayOf(
                                                "onClick"
                                            )),
                                            createElementVNode("image", utsMapOf("onClick" to fun(){
                                                showAiDescModal.value = true
                                            }
                                            , "style" to normalizeStyle(utsMapOf("width" to "23rpx", "height" to "30rpx")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-tips-outline-small.png")), null, 12, utsArrayOf(
                                                "onClick",
                                                "src"
                                            ))
                                        )),
                                        createVNode(_component_x_switch, utsMapOf("modelValue" to unref(globalData).carSetting.enableAIRouteStrategy, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                            unref(globalData).carSetting.enableAIRouteStrategy = `$event`
                                        }
                                        , "onChange" to changeAiCalcEvt, "label" to utsArrayOf(
                                            "开",
                                            "关"
                                        )), null, 8, utsArrayOf(
                                            "modelValue",
                                            "onUpdate:modelValue"
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            createVNode(_component_x_sheet, utsMapOf("padding" to utsArrayOf(
                                "20"
                            )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "setting-item", "onClick" to fun(){
                                        showRouteStrategy.value = true
                                    }
                                    ), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "name"), "偏好设置"),
                                        createElementVNode("view", utsMapOf("class" to "flex-row flex-row-center-center"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(unref(routeStrategyStr)), 1),
                                            createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                "src"
                                            ))
                                        ))
                                    ), 8, utsArrayOf(
                                        "onClick"
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )
                    }
                    ), "_" to 1)),
                    createVNode(_component_x_drawer, utsMapOf("content-margin" to "30rpx", "show" to unref(showRouteStrategy), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showRouteStrategy, `$event`)
                    }
                    , "bgColor" to "#ECF1F8", "show-title" to false, "size" to "657rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "title"), "偏好设置"),
                            createElementVNode("view", utsMapOf("class" to "radio-btn-group"), utsArrayOf(
                                createElementVNode(Fragment, null, RenderHelpers.renderList(routeStrategyOptions, fun(item, __key, __index, _cached): Any {
                                    return createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                                        "radio-btn",
                                        utsMapOf("actived" to (unref(globalData).carSetting.routeStrategy == item.code))
                                    )), "key" to item.code, "onClick" to fun(){
                                        changeRouteLoveEvt(item)
                                    }
                                    , "style" to normalizeStyle("background-image: linear-gradient(to right, " + (if (unref(globalData).carSetting.routeStrategy == item.code) {
                                        unref(globalData).theme.primaryLinearColors.join(", ")
                                    } else {
                                        utsArrayOf(
                                            "#ffffff",
                                            "#ffffff"
                                        ).join(", ")
                                    }
                                    ) + ")")), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "text", "style" to normalizeStyle("color: " + (if (unref(globalData).carSetting.routeStrategy == item.code) {
                                            "#ffffff"
                                        } else {
                                            "#0000000"
                                        }
                                        ) + ";")), toDisplayString(item.name), 5)
                                    ), 14, utsArrayOf(
                                        "onClick"
                                    ))
                                }
                                ), 64)
                            ))
                        )
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "show"
                    )),
                    createVNode(_component_x_modal, utsMapOf("show" to unref(showAiDescModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showAiDescModal, `$event`)
                    }
                    , "bgColor" to "#ECF1F8", "show-cancel" to false, "confirm-text" to "知道了", "onConfirm" to fun(){
                        showAiDescModal.value = false
                    }
                    , "show-title" to false, "height" to "520rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "title"), "智能规划介绍"),
                            createElementVNode("view", utsMapOf("class" to "desc"), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "pb-10"), "关闭智能规划: 订单以下单时间默认排序，司机可手动拖拽修改顺序。"),
                                createElementVNode("text", null, "开启智能规划: 订单会根据最优路线排序，司机不可手动修改，该模式可有效节省行程和出行时间。")
                            ))
                        )
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "show",
                        "onConfirm"
                    ))
                ), 64)
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
                return utsMapOf("setting-item" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "name" to utsMapOf(".setting-item " to utsMapOf("fontSize" to 17)), "value" to utsMapOf(".setting-item " to utsMapOf("color" to "#939393")), "icon" to utsMapOf(".setting-item " to utsMapOf("width" to "17rpx", "height" to "28rpx", "marginLeft" to "20rpx", "marginTop" to "3rpx")), "title" to padStyleMapOf(utsMapOf("textAlign" to "center", "width" to "100%", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "radio-btn" to utsMapOf(".radio-btn-group " to utsMapOf("paddingTop" to "30rpx", "paddingRight" to "60rpx", "paddingBottom" to "30rpx", "paddingLeft" to "60rpx", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "marginBottom" to "30rpx", "transitionProperty" to "backgroundImage,boxShadow", "transitionDuration" to "0.25s"), ".radio-btn-group .actived" to utsMapOf("boxShadow" to "0rpx 5rpx 10rpx 0rpx rgba(89, 119, 177, 0.2)")), "text" to utsMapOf(".radio-btn-group .radio-btn " to utsMapOf("textAlign" to "center", "fontSize" to "32rpx")), "@TRANSITION" to utsMapOf("radio-btn" to utsMapOf("property" to "backgroundImage,boxShadow", "duration" to "0.25s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
