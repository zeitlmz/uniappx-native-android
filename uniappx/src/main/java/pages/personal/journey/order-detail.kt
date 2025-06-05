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
        var setup: (__props: GenPagesPersonalJourneyOrderDetail) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalJourneyOrderDetail
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val globalData = inject("globalData") as GlobalDataType
            val orderPid = ref<String>("")
            val orderDetail = ref(utsArrayOf<ORDER_DETAIL_INFO>())
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
                return createVNode(_component_mc_base_container, utsMapOf("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to true, "title" to "历史订单", "title-color" to "#ffffff"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("style" to normalizeStyle("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        createElementVNode("view", utsMapOf("class" to "home-bg"), utsArrayOf(
                            createElementVNode("image", utsMapOf("class" to "bg-image", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-order-detail-back.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                "src"
                            ))
                        )),
                        createElementVNode("view", utsMapOf("class" to "container", "style" to normalizeStyle("height:" + (unref(screenHeight) - unref(statusBarHeight) - 20) + "px")), utsArrayOf(
                            if (unref(orderDetail).length <= 0) {
                                createVNode(_component_x_empty, utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("margin-top" to "50px")), "loading" to false, "empty" to true, "showBtn" to false), null, 8, utsArrayOf(
                                    "style"
                                ))
                            } else {
                                createCommentVNode("v-if", true)
                            }
                            ,
                            createVNode(_component_x_swiper, utsMapOf("modelValue" to 0, "height" to ("" + (unref(screenHeight) - unref(statusBarHeight) - 20) + " + ''"), "space" to 10, "model" to "spaceOnly", "spaceOffset" to 5, "autoPlay" to false, "damping" to 1, "vertical" to false, "dotSize" to "10", "dotColor" to "rgba(188, 188, 188, 0.5)", "dotActiveColor" to "rgba(188, 188, 188, 0.5)"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode(Fragment, null, RenderHelpers.renderList(unref(orderDetail), fun(item, index, __index, _cached): Any {
                                        return createVNode(_component_x_swiper_item, utsMapOf("order" to index, "key" to index, "dotOffset" to "3"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "order-list", "style" to normalizeStyle(utsMapOf("position" to "relative"))), utsArrayOf(
                                                    createElementVNode("image", utsMapOf("class" to "order-card-back-image", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-order-rounded-rectangle.png")), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createVNode(_component_x_sheet, utsMapOf("height" to "550", "color" to "transparent"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return utsArrayOf(
                                                            createElementVNode("view", utsMapOf("class" to "order-header", "style" to normalizeStyle(utsMapOf("flex-direction" to "row", "justify-content" to "space-between", "margin-top" to "10px"))), utsArrayOf(
                                                                createElementVNode("view", utsMapOf("class" to "order-status"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "tag-text"), "行程" + toDisplayString(index + 1), 1),
                                                                    createElementVNode("image", utsMapOf("class" to "order-status-image", "src" to if (item.status == "4") {
                                                                        "" + unref(resBaseUrl) + "/static/icons/icon-order-complete.png"
                                                                    } else {
                                                                        "" + unref(resBaseUrl) + "/static/icons/icon-order-cancel.png"
                                                                    }
                                                                    ), null, 8, utsArrayOf(
                                                                        "src"
                                                                    ))
                                                                )),
                                                                createElementVNode("view", utsMapOf("class" to "order-price"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "tag-text"), "￥" + toDisplayString(item.originalPrice ?: "0"), 1)
                                                                ))
                                                            ), 4),
                                                            createElementVNode("view", utsMapOf("class" to "order-body"), utsArrayOf(
                                                                createElementVNode("view", utsMapOf("class" to "body-item"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "tag-text"), "订单编号："),
                                                                    createElementVNode("text", utsMapOf("class" to "divider"), toDisplayString(item.id), 1)
                                                                )),
                                                                createElementVNode("view", utsMapOf("class" to "body-item"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "tag-text"), "服务车辆："),
                                                                    createElementVNode("text", utsMapOf("class" to "divider"), toDisplayString(item.vehiclePlateNo), 1)
                                                                )),
                                                                createElementVNode("view", utsMapOf("class" to "mt-8"), utsArrayOf(
                                                                    createVNode(_component_x_steps, utsMapOf("model-value" to 1, "vertical" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                        return utsArrayOf(
                                                                            createVNode(_component_x_steps_item, utsMapOf("activeIcon" to ("" + unref(resBaseUrl) + "/static/icons/icon-location-filled.png")), utsMapOf("default" to withScopedSlotCtx(fun(active: GenUniModulesTmxUiComponentsXStepsItemXStepsItemSlotDataDefault): UTSArray<Any> {
                                                                                return utsArrayOf(
                                                                                    createVNode(_component_x_text, utsMapOf("class" to "text-black text-weight-b", "font-size" to "30rpx", "lines" to 2), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                        return utsArrayOf(
                                                                                            toDisplayString(item.startAddress)
                                                                                        )
                                                                                    }
                                                                                    ), "_" to 2), 1024),
                                                                                    createVNode(_component_x_text, utsMapOf("font-size" to "30rpx", "color" to "#898989"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                        return utsArrayOf(
                                                                                            "上车时间：" + toDisplayString(item.boardingTime)
                                                                                        )
                                                                                    }
                                                                                    ), "_" to 2), 1024)
                                                                                )
                                                                            }
                                                                            ), "_" to 2), 1032, utsArrayOf(
                                                                                "activeIcon"
                                                                            )),
                                                                            createVNode(_component_x_steps_item, utsMapOf("activeIcon" to ("" + unref(resBaseUrl) + "/static/icons/icon-location-end.png")), utsMapOf("default" to withScopedSlotCtx(fun(active: GenUniModulesTmxUiComponentsXStepsItemXStepsItemSlotDataDefault): UTSArray<Any> {
                                                                                return utsArrayOf(
                                                                                    createVNode(_component_x_text, utsMapOf("class" to "text-black text-weight-b", "font-size" to "30rpx", "lines" to 2), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                        return utsArrayOf(
                                                                                            toDisplayString(item.endAddress)
                                                                                        )
                                                                                    }
                                                                                    ), "_" to 2), 1024),
                                                                                    createVNode(_component_x_text, utsMapOf("font-size" to "30rpx", "color" to "#898989"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                        return utsArrayOf(
                                                                                            "结束时间：" + toDisplayString(item.completeTime)
                                                                                        )
                                                                                    }
                                                                                    ), "_" to 2), 1024)
                                                                                )
                                                                            }
                                                                            ), "_" to 2), 1032, utsArrayOf(
                                                                                "activeIcon"
                                                                            ))
                                                                        )
                                                                    }
                                                                    ), "_" to 2), 1024)
                                                                )),
                                                                createElementVNode("view", utsMapOf("class" to "body-item mt--5"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "tag-text"), "订单金额："),
                                                                    createElementVNode("text", utsMapOf("class" to "divider color-red text-weight-b"), "￥" + toDisplayString(item.originalPrice ?: 0), 1)
                                                                )),
                                                                createElementVNode("view", utsMapOf("class" to "body-item"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "tag-text"), "结算比例："),
                                                                    createElementVNode("text", utsMapOf("class" to "divider color-red text-weight-b"), toDisplayString(transPercentage(item.driverChargingValue)), 1)
                                                                )),
                                                                createElementVNode("view", utsMapOf("class" to "body-item"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "tag-text"), "信息费："),
                                                                    createElementVNode("text", utsMapOf("class" to "divider color-red text-weight-b"), "-￥" + toDisplayString(item.driverServiceFee ?: 0), 1)
                                                                )),
                                                                createElementVNode("view", utsMapOf("class" to "body-item"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "tag-text"), "承运人保险费："),
                                                                    createElementVNode("text", utsMapOf("class" to "divider color-red text-weight-b"), "-￥" + toDisplayString(item.carrierAmount ?: 0), 1)
                                                                )),
                                                                createElementVNode("view", utsMapOf("class" to "body-item"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "tag-text"), "完单奖励："),
                                                                    createElementVNode("text", utsMapOf("class" to "divider color-blue text-weight-b"), "￥" + toDisplayString(item.driverFinishedOrderRewards ?: 0), 1)
                                                                )),
                                                                createElementVNode("view", utsMapOf("class" to "body-item"), utsArrayOf(
                                                                    createElementVNode("text", utsMapOf("class" to "tag-text"), "累计完单奖励："),
                                                                    createElementVNode("text", utsMapOf("class" to "divider color-blue text-weight-b"), "￥" + toDisplayString(item.driverCumulativeFinishedOrderRewards ?: 0), 1)
                                                                ))
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 2), 1024)
                                                ), 4)
                                            )
                                        }
                                        ), "_" to 2), 1032, utsArrayOf(
                                            "order"
                                        ))
                                    }
                                    ), 128)
                                )
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "height"
                            ))
                        ), 4)
                    )
                }
                ), "_" to 1))
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
                return utsMapOf("container" to padStyleMapOf(utsMapOf("width" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 20)), "home-bg" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "height" to "100%", "zIndex" to -1, "overflow" to "hidden")), "bg-image" to utsMapOf(".home-bg " to utsMapOf("width" to "100%", "position" to "absolute", "top" to 0, "left" to 0)), "order-list" to padStyleMapOf(utsMapOf("marginTop" to 40)), "order-card-back-image" to utsMapOf(".order-list " to utsMapOf("width" to "100%", "height" to "100%", "position" to "absolute", "top" to 0, "left" to 0)), "order-header" to utsMapOf(".order-list " to utsMapOf("display" to "flex", "flexDirection" to "row", "marginBottom" to 10)), "order-status" to utsMapOf(".order-list .order-header " to utsMapOf("flexDirection" to "row")), "tag-text" to utsMapOf(".order-list .order-header .order-status " to utsMapOf("fontSize" to "35rpx", "fontWeight" to "bold"), ".order-list .order-header .order-price " to utsMapOf("fontSize" to "36rpx", "fontWeight" to "bold", "color" to "#C70000"), ".order-list .order-body " to utsMapOf("color" to "#898989", "fontSize" to "32rpx")), "order-status-image" to utsMapOf(".order-list .order-header .order-status " to utsMapOf("width" to "144rpx", "height" to "114rpx")), "body-item" to utsMapOf(".order-list .order-body " to utsMapOf("paddingTop" to 7, "paddingRight" to 0, "paddingBottom" to 7, "paddingLeft" to 0, "flexDirection" to "row")), "divider" to utsMapOf(".order-list .order-body " to utsMapOf("fontSize" to "32rpx")), "color-red" to utsMapOf(".order-list .order-body " to utsMapOf("color" to "#C70000")), "color-blue" to utsMapOf(".order-list .order-body " to utsMapOf("color" to "#697ec7")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
