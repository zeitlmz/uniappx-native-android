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
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xTipsS.XTIPS_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import uts.sdk.modules.xTipsS.showTips as showTips1
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalJourneyOrderDetail : BasePage {
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
    }
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesPersonalJourneyOrderDetail) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalJourneyOrderDetail
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val globalData = inject("globalData") as GlobalDataType
            val orderPid = ref<String>("")
            val orderDetail = ref(_uA<ORDER_DETAIL_INFO>())
            val transPercentage = fun(driverChargingValue: String): String {
                try {
                    return (parseFloat(driverChargingValue) * 100).toString(10) + "%"
                }
                 catch (err: Throwable) {
                    console.error("transPercentage转换失败：", err)
                    return "--"
                }
            }
            val getOrderDetail = fun(){
                if (orderPid.value == null || orderPid.value == "") {
                    showTips1(XTIPS_TYPE(title = "订单ID不能为空", iconCode = "error", iconColor = "red", titleColor = "red", position = "bottom"))
                    return
                }
                showLoading(XLOADINGS_TYPE(title = "加载中"))
                getOrderIntercityDetail(orderPid.value).then(fun(res: Response){
                    hideXloading()
                    if (res.code == 200 && res.data != null) {
                        orderDetail.value = JSON.parse<UTSArray<ORDER_DETAIL_INFO>>(JSON.stringify(res.data)) as UTSArray<ORDER_DETAIL_INFO>
                    } else {
                        showTips1(XTIPS_TYPE(title = res.msg, iconCode = "error", iconColor = "red", titleColor = "red", position = "bottom"))
                    }
                }
                ).`catch`(fun(err){
                    hideXloading()
                    showTips1(XTIPS_TYPE(title = "获取订单详情失败", iconCode = "error", iconColor = "red", titleColor = "red", position = "bottom"))
                }
                )
            }
            onLoad(fun(options){
                if (options != null) {
                    val opt = JSON.parse(JSON.stringify(options)) as UTSJSONObject
                    val orderPidStr = opt.getString("orderPid")
                    console.log("orderPidStr=", orderPidStr)
                    orderPid.value = if (orderPidStr != null) {
                        orderPidStr
                    } else {
                        ""
                    }
                    getOrderDetail()
                }
            }
            )
            return fun(): Any? {
                val _component_x_empty = resolveEasyComponent("x-empty", GenUniModulesTmxUiComponentsXEmptyXEmptyClass)
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_x_steps_item = resolveEasyComponent("x-steps-item", GenUniModulesTmxUiComponentsXStepsItemXStepsItemClass)
                val _component_x_steps = resolveEasyComponent("x-steps", GenUniModulesTmxUiComponentsXStepsXStepsClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_swiper_item = resolveEasyComponent("x-swiper-item", GenUniModulesTmxUiComponentsXSwiperItemXSwiperItemClass)
                val _component_x_swiper = resolveEasyComponent("x-swiper", GenUniModulesTmxUiComponentsXSwiperXSwiperClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return _cV(_component_mc_base_container, _uM("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to true, "title" to "历史订单", "title-color" to "#ffffff"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("style" to _nS("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        _cE("view", _uM("class" to "home-bg"), _uA(
                            _cE("image", _uM("class" to "bg-image", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-order-detail-back.png"), "mode" to "widthFix"), null, 8, _uA(
                                "src"
                            ))
                        )),
                        _cE("view", _uM("class" to "container", "style" to _nS("height:" + (unref(screenHeight) - unref(statusBarHeight) - 20) + "px")), _uA(
                            if (unref(orderDetail).length <= 0) {
                                _cV(_component_x_empty, _uM("key" to 0, "style" to _nS(_uM("margin-top" to "50px")), "loading" to false, "empty" to true, "showBtn" to false), null, 8, _uA(
                                    "style"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cV(_component_x_swiper, _uM("modelValue" to 0, "height" to ("" + (unref(screenHeight) - unref(statusBarHeight) - 20)), "space" to 10, "model" to "spaceOnly", "spaceOffset" to 5, "autoPlay" to false, "damping" to 1, "vertical" to false, "dotSize" to "10", "dotColor" to "rgba(188, 188, 188, 0.5)", "dotActiveColor" to "rgba(188, 188, 188, 0.5)"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(orderDetail), fun(item, index, __index, _cached): Any {
                                        return _cV(_component_x_swiper_item, _uM("order" to index, "key" to index, "dotOffset" to "3"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "order-list", "style" to _nS(_uM("position" to "relative"))), _uA(
                                                    _cE("image", _uM("class" to "order-card-back-image", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-order-rounded-rectangle.png")), null, 8, _uA(
                                                        "src"
                                                    )),
                                                    _cV(_component_x_sheet, _uM("height" to "650", "color" to "transparent"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _cE("view", _uM("class" to "order-header", "style" to _nS(_uM("flex-direction" to "row", "justify-content" to "space-between", "margin-top" to "10px"))), _uA(
                                                                _cE("view", _uM("class" to "order-status"), _uA(
                                                                    _cE("text", _uM("class" to "tag-text"), "行程" + _tD(index + 1), 1),
                                                                    _cE("image", _uM("class" to "order-status-image", "src" to if (item.status == "4") {
                                                                        "" + unref(resBaseUrl) + "/static/icons/icon-order-complete.png"
                                                                    } else {
                                                                        "" + unref(resBaseUrl) + "/static/icons/icon-order-cancel.png"
                                                                    }
                                                                    ), null, 8, _uA(
                                                                        "src"
                                                                    ))
                                                                )),
                                                                _cE("view", _uM("class" to "order-price"), _uA(
                                                                    _cE("text", _uM("class" to "tag-text"), "￥" + _tD(item.driverFinalProfit ?: "0"), 1)
                                                                ))
                                                            ), 4),
                                                            _cE("view", _uM("class" to "order-body"), _uA(
                                                                _cE("view", _uM("class" to "body-item"), _uA(
                                                                    _cE("text", _uM("class" to "tag-text"), "订单编号："),
                                                                    _cE("text", _uM("class" to "divider"), _tD(item.id), 1)
                                                                )),
                                                                _cE("view", _uM("class" to "body-item"), _uA(
                                                                    _cE("text", _uM("class" to "tag-text"), "服务车辆："),
                                                                    _cE("text", _uM("class" to "divider"), _tD(item.vehiclePlateNo), 1)
                                                                )),
                                                                _cE("view", _uM("class" to "mt-8"), _uA(
                                                                    _cV(_component_x_steps, _uM("model-value" to 1, "vertical" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                        return _uA(
                                                                            _cV(_component_x_steps_item, _uM("activeIcon" to ("" + unref(resBaseUrl) + "/static/icons/icon-location-filled.png")), _uM("default" to withScopedSlotCtx(fun(active: GenUniModulesTmxUiComponentsXStepsItemXStepsItemSlotDataDefault): UTSArray<Any> {
                                                                                return _uA(
                                                                                    _cV(_component_x_text, _uM("class" to "text-black text-weight-b", "font-size" to "30rpx", "lines" to 2), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                        return _uA(
                                                                                            _tD(item.startAddress)
                                                                                        )
                                                                                    }
                                                                                    ), "_" to 2), 1024),
                                                                                    _cV(_component_x_text, _uM("font-size" to "30rpx", "color" to "#898989"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                        return _uA(
                                                                                            "上车时间：" + _tD(item.boardingTime)
                                                                                        )
                                                                                    }
                                                                                    ), "_" to 2), 1024)
                                                                                )
                                                                            }
                                                                            ), "_" to 2), 1032, _uA(
                                                                                "activeIcon"
                                                                            )),
                                                                            _cV(_component_x_steps_item, _uM("activeIcon" to ("" + unref(resBaseUrl) + "/static/icons/icon-location-end.png")), _uM("default" to withScopedSlotCtx(fun(active: GenUniModulesTmxUiComponentsXStepsItemXStepsItemSlotDataDefault): UTSArray<Any> {
                                                                                return _uA(
                                                                                    _cV(_component_x_text, _uM("class" to "text-black text-weight-b", "font-size" to "30rpx", "lines" to 2), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                        return _uA(
                                                                                            _tD(item.endAddress)
                                                                                        )
                                                                                    }
                                                                                    ), "_" to 2), 1024),
                                                                                    _cV(_component_x_text, _uM("font-size" to "30rpx", "color" to "#898989"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                        return _uA(
                                                                                            "结束时间：" + _tD(item.completeTime)
                                                                                        )
                                                                                    }
                                                                                    ), "_" to 2), 1024)
                                                                                )
                                                                            }
                                                                            ), "_" to 2), 1032, _uA(
                                                                                "activeIcon"
                                                                            ))
                                                                        )
                                                                    }
                                                                    ), "_" to 2), 1024)
                                                                )),
                                                                _cE("view", _uM("class" to "body-item mt--5"), _uA(
                                                                    _cE("text", _uM("class" to "tag-text"), "订单金额："),
                                                                    _cE("text", _uM("class" to "divider color-red text-weight-b"), "￥" + _tD(item.originalPrice ?: 0), 1)
                                                                )),
                                                                _cE("view", _uM("class" to "body-item"), _uA(
                                                                    _cE("text", _uM("class" to "tag-text"), "平台抽佣比例："),
                                                                    _cE("text", _uM("class" to "divider color-red text-weight-b"), _tD(transPercentage(item.platformCommissionRate) ?: 0), 1)
                                                                )),
                                                                _cE("view", _uM("class" to "body-item"), _uA(
                                                                    _cE("text", _uM("class" to "tag-text"), "平台抽佣金额："),
                                                                    _cE("text", _uM("class" to "divider color-red text-weight-b"), "-￥" + _tD(item.platformCommissionAmount ?: 0), 1)
                                                                )),
                                                                _cE("view", _uM("class" to "body-item"), _uA(
                                                                    _cE("text", _uM("class" to "tag-text"), "结算比例："),
                                                                    _cE("text", _uM("class" to "divider color-red text-weight-b"), _tD(transPercentage(item.driverChargingValue)), 1)
                                                                )),
                                                                _cE("view", _uM("class" to "body-item"), _uA(
                                                                    _cE("text", _uM("class" to "tag-text"), "分成金额："),
                                                                    _cE("text", _uM("class" to "divider color-red text-weight-b"), "￥" + _tD(item.driverAmount), 1)
                                                                )),
                                                                _cE("view", _uM("class" to "body-item"), _uA(
                                                                    _cE("text", _uM("class" to "tag-text"), "信息费："),
                                                                    _cE("text", _uM("class" to "divider color-red text-weight-b"), "-￥" + _tD(item.driverServiceFee ?: 0), 1)
                                                                )),
                                                                _cE("view", _uM("class" to "body-item"), _uA(
                                                                    _cE("text", _uM("class" to "tag-text"), "承运人保险费："),
                                                                    _cE("text", _uM("class" to "divider color-red text-weight-b"), "-￥" + _tD(item.carrierAmount ?: 0), 1)
                                                                )),
                                                                _cE("view", _uM("class" to "body-item"), _uA(
                                                                    _cE("text", _uM("class" to "tag-text"), "完单奖励："),
                                                                    _cE("text", _uM("class" to "divider color-blue text-weight-b"), "￥" + _tD(item.driverFinishedOrderRewards ?: 0), 1)
                                                                )),
                                                                _cE("view", _uM("class" to "body-item"), _uA(
                                                                    _cE("text", _uM("class" to "tag-text"), "累计完单奖励："),
                                                                    _cE("text", _uM("class" to "divider color-blue text-weight-b"), "￥" + _tD(item.driverCumulativeFinishedOrderRewards ?: 0), 1)
                                                                ))
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 2), 1024)
                                                ), 4)
                                            )
                                        }
                                        ), "_" to 2), 1032, _uA(
                                            "order"
                                        ))
                                    }
                                    ), 128)
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "height"
                            ))
                        ), 4)
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
                return _uM("container" to _pS(_uM("width" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 20)), "home-bg" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "height" to "100%", "zIndex" to -1, "overflow" to "hidden")), "bg-image" to _uM(".home-bg " to _uM("width" to "100%", "position" to "absolute", "top" to 0, "left" to 0)), "order-list" to _pS(_uM("marginTop" to 40)), "order-card-back-image" to _uM(".order-list " to _uM("width" to "100%", "height" to "100%", "position" to "absolute", "top" to 0, "left" to 0)), "order-header" to _uM(".order-list " to _uM("display" to "flex", "flexDirection" to "row", "marginBottom" to 10)), "order-status" to _uM(".order-list .order-header " to _uM("flexDirection" to "row")), "tag-text" to _uM(".order-list .order-header .order-status " to _uM("fontSize" to "35rpx", "fontWeight" to "bold"), ".order-list .order-header .order-price " to _uM("fontSize" to "36rpx", "fontWeight" to "bold", "color" to "#C70000"), ".order-list .order-body " to _uM("color" to "#898989", "fontSize" to "32rpx")), "order-status-image" to _uM(".order-list .order-header .order-status " to _uM("width" to "144rpx", "height" to "114rpx")), "body-item" to _uM(".order-list .order-body " to _uM("paddingTop" to 7, "paddingRight" to 0, "paddingBottom" to 7, "paddingLeft" to 0, "flexDirection" to "row")), "divider" to _uM(".order-list .order-body " to _uM("fontSize" to "32rpx")), "color-red" to _uM(".order-list .order-body " to _uM("color" to "#C70000")), "color-blue" to _uM(".order-list .order-body " to _uM("color" to "#697ec7")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
