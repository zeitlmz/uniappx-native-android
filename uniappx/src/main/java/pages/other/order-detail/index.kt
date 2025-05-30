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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.reLaunch as uni_reLaunch
import uts.sdk.modules.xModalS.showModal
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
import uts.sdk.modules.xVibrateS.vibrator
open class GenPagesOtherOrderDetailIndex : BasePage {
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
            this.initEvt(true)
            console.log("onReady")
        }
        , __ins)
        onLoad(fun(query: OnLoadOptions) {
            console.log("query:", query)
            this.orderParams = query
            this.routeStrategy = this.globalData.carSetting.routeStrategy ?: "OVERALL_OPTIMAL"
            this.routeStrategyStr = this.routeStrategyOptions.find(fun(item): Boolean {
                return item.code == this.globalData.carSetting.routeStrategy
            }
            )?.name ?: "综合最优"
            this.isDx = (this.orderParams["typeOfBoarding"] == "1")
            if (this.isDx) {
                this.isSmartPlanning = false
            } else {
                this.isSmartPlanning = this.globalData.carSetting.enableAIRouteStrategy
            }
            uni__on("queryOrderDetail", fun(canCalcRoute: Boolean){
                this.initEvt(canCalcRoute)
            }
            )
            this.getServiceConfig()
            this.updateToday()
        }
        , __ins)
        onBeforeUnmount(fun() {
            val mapView = (this.`$refs`["mapView"] as McAmapComponentPublicInstance)
            mapView?.destroy()
            uni__off("queryOrderDetail", null)
        }
        , __ins)
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
        val _component_mc_amap = resolveEasyComponent("mc-amap", GenUniModulesMcAmapNavPlusComponentsMcAmapMcAmapClass)
        val _component_x_switch = resolveEasyComponent("x-switch", GenUniModulesTmxUiComponentsXSwitchXSwitchClass)
        val _component_mc_active_animation = resolveEasyComponent("mc-active-animation", GenComponentsMcActiveAnimationIndexClass)
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        val _component_x_cell = resolveEasyComponent("x-cell", GenUniModulesTmxUiComponentsXCellXCellClass)
        val _component_x_popover = resolveEasyComponent("x-popover", GenUniModulesTmxUiComponentsXPopoverXPopoverClass)
        val _component_mc_pain_button = resolveEasyComponent("mc-pain-button", GenComponentsMcPainButtonIndexClass)
        val _component_x_drag_item = resolveEasyComponent("x-drag-item", GenUniModulesTmxUiComponentsXDragItemXDragItemClass)
        val _component_x_drag = resolveEasyComponent("x-drag", GenUniModulesTmxUiComponentsXDragXDragClass)
        val _component_x_pull_refresh = resolveEasyComponent("x-pull-refresh", GenUniModulesTmxUiComponentsXPullRefreshXPullRefreshClass)
        val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
        val _component_x_code_input = resolveEasyComponent("x-code-input", GenUniModulesTmxUiComponentsXCodeInputXCodeInputClass)
        val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
        val _component_x_keyboard_number = resolveEasyComponent("x-keyboard-number", GenUniModulesTmxUiComponentsXKeyboardNumberXKeyboardNumberClass)
        val _component_x_input = resolveEasyComponent("x-input", GenUniModulesTmxUiComponentsXInputXInputClass)
        val _component_x_radio = resolveEasyComponent("x-radio", GenUniModulesTmxUiComponentsXRadioXRadioClass)
        val _component_x_radio_group = resolveEasyComponent("x-radio-group", GenUniModulesTmxUiComponentsXRadioGroupXRadioGroupClass)
        val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass)
        val _component_mc_seat_viewer = resolveEasyComponent("mc-seat-viewer", GenComponentsMcSeatViewerIndexClass)
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_mc_amap, utsMapOf("self-location" to true, "ref" to "mapView", "style" to normalizeStyle("margin-top: " + (_ctx.statusBarHeight + 50) + "px;height: " + _ctx.mapContentHeight + "px;"), "onNaviInfoUpdate" to _ctx.naviInfoUpdate, "onCalcSuccess" to _ctx.calcRouteSuccess, "onArrived" to _ctx.arriveDestination), utsMapOf("bottom" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "flex-row flex-row-center-between"), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "flex-row flex-row-center-between pl-15 pt-15"), utsArrayOf(
                            withDirectives(createVNode(_component_mc_primary_button, utsMapOf("onClick" to _ctx.openTrip, "height" to "57rpx", "bgColor" to "#ffffff", "icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-books-2.png"), "color" to "#000000", "margin-right" to "20rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    " 开启行程 "
                                )
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "onClick",
                                "icon-path"
                            )), utsArrayOf(
                                utsArrayOf(
                                    vShow,
                                    _ctx.orderData.driverStatus == 0
                                )
                            )),
                            withDirectives(createVNode(_component_mc_primary_button, utsMapOf("onClick" to _ctx.closeTrip, "height" to "57rpx", "bgColor" to "#ffffff", "icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-stop-trip-outline.png"), "color" to "#000000", "margin-right" to "20rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    " 暂停行程 "
                                )
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "onClick",
                                "icon-path"
                            )), utsArrayOf(
                                utsArrayOf(
                                    vShow,
                                    _ctx.orderData.driverStatus == 3
                                )
                            ))
                        )),
                        createElementVNode("view", utsMapOf("class" to "flex-row flex-row-center-between pt-10 pr-15"), utsArrayOf(
                            createVNode(_component_mc_primary_button, utsMapOf("height" to "57rpx", "onClick" to _ctx.initLocation, "bgColor" to "#ffffff", "icon-size" to "35rpx", "icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-my-location-outline.png"), "color" to "#000000"), null, 8, utsArrayOf(
                                "onClick",
                                "icon-path"
                            ))
                        ))
                    )),
                    withDirectives(createElementVNode("view", utsMapOf("class" to "route-love"), utsArrayOf(
                        createElementVNode("image", utsMapOf("class" to "bg-img", "style" to normalizeStyle("width:" + (_ctx.screenWidth + 10) + "px"), "src" to ("" + _ctx.resBaseUrl + "/static/images/route-loves-bg.png")), null, 12, utsArrayOf(
                            "src"
                        )),
                        createElementVNode("text", utsMapOf("class" to "title"), "路线偏好:"),
                        createElementVNode("view", utsMapOf("class" to "radio-card-group"), utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.routeStrategyOptions.slice(0, 2), fun(item, __key, __index, _cached): Any {
                                return createElementVNode("text", utsMapOf("key" to item.code, "onClick" to fun(){
                                    _ctx.routeLoveClick(item)
                                }
                                , "class" to "radio-card mr-7", "style" to normalizeStyle("" + (if (_ctx.routeStrategy == item.code) {
                                    "font-weight: bold;color: " + _ctx.globalData.theme.primaryColor + ";"
                                } else {
                                    ""
                                }
                                ))), toDisplayString(item.name), 13, utsArrayOf(
                                    "onClick"
                                ))
                            }
                            ), 128)
                        )),
                        createElementVNode("view", utsMapOf("class" to "radio-card-group"), utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.routeStrategyOptions.slice(2, 4), fun(item, __key, __index, _cached): Any {
                                return createElementVNode("text", utsMapOf("key" to item.code, "onClick" to fun(){
                                    _ctx.routeLoveClick(item)
                                }
                                , "class" to "radio-card mr-7", "style" to normalizeStyle("" + (if (_ctx.routeStrategy == item.code) {
                                    "font-weight: bold;color: " + _ctx.globalData.theme.primaryColor + ";"
                                } else {
                                    ""
                                }
                                ))), toDisplayString(item.name), 13, utsArrayOf(
                                    "onClick"
                                ))
                            }
                            ), 128)
                        ))
                    ), 512), utsArrayOf(
                        utsArrayOf(
                            vShow,
                            _ctx.showRouteStrategyOptions
                        )
                    )),
                    withDirectives(createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("height" to "24rpx"))), null, 4), utsArrayOf(
                        utsArrayOf(
                            vShow,
                            !_ctx.showRouteStrategyOptions
                        )
                    ))
                )
            }
            ), "_" to 1), 8, utsArrayOf(
                "style",
                "onNaviInfoUpdate",
                "onCalcSuccess",
                "onArrived"
            )),
            createVNode(_component_mc_base_container, utsMapOf("title" to "订单详情", "bg-color" to "#ffffff", "scroll" to false), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "content-panel", "onTransitionend" to _ctx.onTransitionend, "ref" to "contentPanel", "style" to normalizeStyle("transform: translateY(" + _ctx.transformHeight + "px);height: " + _ctx.cardHeight + "px;bottom:" + (_ctx.globalData.safeAreaBottom + 80) + "px;background: " + (if (_ctx.showOrderList) {
                        "#F5F7FA;"
                    } else {
                        "#ffffff"
                    }
                    ))), utsArrayOf(
                        withDirectives(createElementVNode("view", utsMapOf("class" to "flex-row-center-between", "onClick" to _ctx.viewOrders, "style" to normalizeStyle("height:40rpx;margin-bottom: 20rpx;background-color: " + _ctx.globalData.theme.primaryLinearColors[0] + ";")), utsArrayOf(
                            createElementVNode("image", utsMapOf("style" to normalizeStyle(utsMapOf("height" to "27rpx", "width" to "27rpx", "margin-top" to "6rpx")), "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-tow-arrow-down-outline.png"), "mode" to "widthFix"), null, 12, utsArrayOf(
                                "src"
                            ))
                        ), 12, utsArrayOf(
                            "onClick"
                        )), utsArrayOf(
                            utsArrayOf(
                                vShow,
                                _ctx.showOrderList
                            )
                        )),
                        withDirectives(createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("height" to "34rpx"))), null, 4), utsArrayOf(
                            utsArrayOf(
                                vShow,
                                !_ctx.showOrderList
                            )
                        )),
                        createElementVNode("view", utsMapOf("class" to "planning-header"), utsArrayOf(
                            withDirectives(createElementVNode("view", utsMapOf("class" to "header-order-title"), utsArrayOf(
                                if (_ctx.routes.length > 0) {
                                    createElementVNode("image", utsMapOf("key" to 0, "class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-road-guid.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                        "src"
                                    ))
                                } else {
                                    createCommentVNode("v-if", true)
                                }
                                ,
                                if (_ctx.routes.length > 0) {
                                    createElementVNode("view", utsMapOf("key" to 1, "class" to "flex-row"), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "text"), "距我"),
                                        createElementVNode("text", utsMapOf("class" to "num"), toDisplayString(_ctx.selectedRoute.distance), 1),
                                        createElementVNode("text", utsMapOf("class" to "split"), "|"),
                                        createElementVNode("text", utsMapOf("class" to "text"), "预计"),
                                        createElementVNode("text", utsMapOf("class" to "num"), toDisplayString(_ctx.selectedRoute.time), 1)
                                    ))
                                } else {
                                    createCommentVNode("v-if", true)
                                }
                            ), 512), utsArrayOf(
                                utsArrayOf(
                                    vShow,
                                    _ctx.showOrderList
                                )
                            )),
                            withDirectives(createElementVNode("view", utsMapOf("class" to "planning-title"), utsArrayOf(
                                createElementVNode("image", utsMapOf("onClick" to fun(){
                                    _ctx.showAiDescModal = true
                                }
                                , "class" to "planning-icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-tips-outline-small.png")), null, 8, utsArrayOf(
                                    "onClick",
                                    "src"
                                )),
                                createElementVNode("text", utsMapOf("onClick" to fun(){
                                    _ctx.showAiDescModal = true
                                }
                                , "class" to "text"), "智能规划", 8, utsArrayOf(
                                    "onClick"
                                )),
                                createVNode(_component_x_switch, utsMapOf("modelValue" to _ctx.isSmartPlanning, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                    _ctx.isSmartPlanning = `$event`
                                }
                                , "disabled" to (_ctx.orderData.orderCount <= 1), "size" to "small", "onChange" to _ctx.onPlanningChange, "color" to "#D1B27A"), null, 8, utsArrayOf(
                                    "modelValue",
                                    "onUpdate:modelValue",
                                    "disabled",
                                    "onChange"
                                ))
                            ), 512), utsArrayOf(
                                utsArrayOf(
                                    vShow,
                                    (!_ctx.showOrderList && !_ctx.isDx) || !_ctx.isDx
                                )
                            )),
                            if (isTrue(!_ctx.showOrderList && _ctx.isDx)) {
                                createElementVNode("view", utsMapOf("key" to 0, "class" to "planning-title"), utsArrayOf(
                                    createElementVNode("image", utsMapOf("class" to "planning-icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-road-guid-2.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                        "src"
                                    )),
                                    createElementVNode("text", utsMapOf("class" to "text"), "独享")
                                ))
                            } else {
                                createCommentVNode("v-if", true)
                            }
                            ,
                            withDirectives(createVNode(_component_mc_active_animation, utsMapOf("class" to "sort-btn", "onClick" to _ctx.routeLoveBtnClick), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "text"), toDisplayString(_ctx.routeStrategyStr), 1),
                                    createElementVNode("image", utsMapOf("class" to "sort-icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-transform-white-filled.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                        "src"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "onClick"
                            )), utsArrayOf(
                                utsArrayOf(
                                    vShow,
                                    (_ctx.showOrderList && _ctx.isDx) || !_ctx.showOrderList
                                )
                            ))
                        )),
                        withDirectives(createElementVNode("view", utsMapOf("class" to "routes-container", "style" to normalizeStyle("background-image: linear-gradient(to bottom, " + _ctx.globalData.theme.painColor + ", #fffff);")), utsArrayOf(
                            if (_ctx.routes.length <= 0) {
                                createElementVNode("view", utsMapOf("key" to 0, "class" to "flex-row flex-row-center-center", "style" to normalizeStyle(utsMapOf("height" to "200rpx", "color" to "#cccccc"))), utsArrayOf(
                                    createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("text-align" to "center"))), "暂无路线规划", 4)
                                ), 4)
                            } else {
                                createCommentVNode("v-if", true)
                            }
                            ,
                            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.routes, fun(route, index, __index, _cached): Any {
                                return createVNode(_component_mc_active_animation, utsMapOf("key" to index, "class" to "route-card", "style" to normalizeStyle("" + (if (_ctx.selectedRoute.routeId === route.routeId) {
                                    ("background-image: linear-gradient(to bottom, " + _ctx.globalData.theme.primaryLinearColors.join(", ") + ");")
                                } else {
                                    ""
                                }
                                )), "onClick" to fun(){
                                    _ctx.selectRoute(route)
                                }
                                ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "header"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "route-title", "style" to normalizeStyle("" + (if (_ctx.selectedRoute.routeId === route.routeId) {
                                                "color: #ffffff;"
                                            } else {
                                                ""
                                            }
                                            ))), "线路" + toDisplayString(index + 1), 5),
                                            createElementVNode("view", utsMapOf("class" to "traffic-light"), utsArrayOf(
                                                createElementVNode("image", utsMapOf("class" to "light-icon", "src" to if (_ctx.selectedRoute.routeId === route.routeId) {
                                                    "" + _ctx.resBaseUrl + "/static/icons/icon-traffic-white-outline-small.png"
                                                } else {
                                                    "" + _ctx.resBaseUrl + "/static/icons/icon-traffic-black-outline-small.png"
                                                }
                                                ), null, 8, utsArrayOf(
                                                    "src"
                                                )),
                                                createElementVNode("text", utsMapOf("class" to "text", "style" to normalizeStyle("" + (if (_ctx.selectedRoute.routeId === route.routeId) {
                                                    "color: #ffffff;"
                                                } else {
                                                    ""
                                                }
                                                ))), toDisplayString(route.lights), 5)
                                            ))
                                        )),
                                        createElementVNode("text", utsMapOf("class" to "route-time", "style" to normalizeStyle("" + (if (_ctx.selectedRoute.routeId === route.routeId) {
                                            "color: #ffffff;"
                                        } else {
                                            ""
                                        }
                                        ))), toDisplayString(route.time), 5),
                                        createElementVNode("text", utsMapOf("class" to "route-distance", "style" to normalizeStyle("" + (if (_ctx.selectedRoute.routeId === route.routeId) {
                                            "color: #ffffff;"
                                        } else {
                                            ""
                                        }
                                        ))), toDisplayString(route.distance), 5)
                                    )
                                }
                                ), "_" to 2), 1032, utsArrayOf(
                                    "style",
                                    "onClick"
                                ))
                            }
                            ), 128)
                        ), 4), utsArrayOf(
                            utsArrayOf(
                                vShow,
                                !_ctx.showOrderList
                            )
                        )),
                        if (isTrue(_ctx.showOrderList && _ctx.isDx)) {
                            createElementVNode("view", utsMapOf("key" to 0, "class" to "order-list"), utsArrayOf(
                                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.orderData.orderItems, fun(item, index, __index, _cached): Any {
                                    return createElementVNode("view", utsMapOf("class" to "order-item-dx", "key" to item.planId), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "order-info", "style" to normalizeStyle("border: 4rpx solid " + _ctx.globalData.theme.primaryColor + ";background-image: linear-gradient(to bottom, " + _ctx.globalData.theme.painColor + ", #ffffff, #ffffff, #ffffff);")), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "header flex-row flex-row-center-between"), utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "left-box flex-row"), utsArrayOf(
                                                    createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-road-guid-2.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("text", utsMapOf("class" to "text"), "独享")
                                                )),
                                                createVNode(_component_x_popover, utsMapOf("position" to "br"), utsMapOf("menu" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        createElementVNode("view", utsMapOf("class" to "more-menu"), utsArrayOf(
                                                            createVNode(_component_x_cell, utsMapOf("onClick" to fun(){
                                                                _ctx.cancelOrder(item.orderId, item.sortNum)
                                                            }, "show-bottom-border" to false, "card" to false, "titleColor" to if (_ctx.serviceConfig.allowDriverCancelOrder) {
                                                                "red"
                                                            } else {
                                                                "#999999"
                                                            }, "title" to "取消订单"), null, 8, utsArrayOf(
                                                                "onClick",
                                                                "titleColor"
                                                            ))
                                                        ))
                                                    )
                                                }), "default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        createElementVNode("view", utsMapOf("class" to "right-box flex-row"), utsArrayOf(
                                                            createElementVNode("text", utsMapOf("class" to "more-btn"), "更多"),
                                                            createVNode(_component_x_icon, utsMapOf("name" to "more-2-line"))
                                                        ))
                                                    )
                                                }), "_" to 2), 1024)
                                            )),
                                            createElementVNode("view", utsMapOf("class" to "border")),
                                            createElementVNode("view", utsMapOf("class" to "address-info flex-row flex-row-center-between"), utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "left-box"), utsArrayOf(
                                                    createElementVNode("view", utsMapOf("class" to "address-item"), utsArrayOf(
                                                        createElementVNode("view", utsMapOf("class" to "top flex-row", "style" to normalizeStyle(utsMapOf("padding-top" to "20rpx"))), utsArrayOf(
                                                            createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-location-start.png"), "mode" to ""), null, 8, utsArrayOf(
                                                                "src"
                                                            )),
                                                            createElementVNode("text", utsMapOf("class" to "label"), toDisplayString(item.startCity + "-" + item.startDistrict), 1)
                                                        ), 4),
                                                        createElementVNode("text", utsMapOf("class" to "bottom", "style" to normalizeStyle("border-left: 1rpx solid " + _ctx.globalData.theme.primaryColor + ";")), toDisplayString(item.startAddress), 5)
                                                    )),
                                                    createElementVNode("view", utsMapOf("class" to "address-item"), utsArrayOf(
                                                        createElementVNode("view", utsMapOf("class" to "top flex-row"), utsArrayOf(
                                                            createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-location-end.png"), "mode" to ""), null, 8, utsArrayOf(
                                                                "src"
                                                            )),
                                                            createElementVNode("text", utsMapOf("class" to "label"), toDisplayString(item.endCity + "-" + item.endDistrict), 1)
                                                        )),
                                                        createElementVNode("text", utsMapOf("class" to "bottom"), toDisplayString(item.endAddress), 1)
                                                    ))
                                                )),
                                                createElementVNode("view", utsMapOf("class" to "right-box flex-row flex-row-center-center"), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "num"), toDisplayString(item.passengerNum), 1),
                                                    createElementVNode("text", utsMapOf("class" to "label"), "人")
                                                ))
                                            )),
                                            createElementVNode("view", utsMapOf("class" to "remark flex-row"), utsArrayOf(
                                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-info-outline-small-2.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                )),
                                                createElementVNode("text", utsMapOf("class" to "text"), "备注：" + toDisplayString(item.remark ?: "-"), 1)
                                            )),
                                            createElementVNode("view", utsMapOf("class" to "btn-group flex-row"), utsArrayOf(
                                                createVNode(_component_mc_pain_button, utsMapOf("margin-right" to "26rpx", "onClick" to fun(){
                                                    _ctx.callPhone(item.phoneNumber)
                                                }, "icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-call-phone-outline.png")), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        "联系乘客"
                                                    )
                                                }), "_" to 2), 1032, utsArrayOf(
                                                    "onClick",
                                                    "icon-path"
                                                )),
                                                if (item.waitingStatus == 0) {
                                                    createVNode(_component_mc_primary_button, utsMapOf("key" to 0, "onClick" to fun(){
                                                        _ctx.tryArrived(item.orderId, item.sortNum)
                                                    }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return utsArrayOf(
                                                            "到达上车点"
                                                        )
                                                    }), "_" to 2), 1032, utsArrayOf(
                                                        "onClick"
                                                    ))
                                                } else {
                                                    if (isTrue(_ctx.orderParams["orderStatus"] != "0" && item.status < 3)) {
                                                        createVNode(_component_mc_primary_button, utsMapOf("key" to 1, "onClick" to fun(){
                                                            _ctx.passengerPickUp(item.orderId, item.sortNum, index)
                                                        }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return utsArrayOf(
                                                                "乘客上车"
                                                            )
                                                        }), "_" to 2), 1032, utsArrayOf(
                                                            "onClick"
                                                        ))
                                                    } else {
                                                        if (item.status == 3) {
                                                            createVNode(_component_mc_primary_button, utsMapOf("key" to 2, "onClick" to fun(){
                                                                _ctx.validOrder(item.orderId, item.sortNum)
                                                            }, "linear-colors" to utsArrayOf(
                                                                "#44C791",
                                                                "#28D07F"
                                                            )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return utsArrayOf(
                                                                    "完成订单"
                                                                )
                                                            }), "_" to 2), 1032, utsArrayOf(
                                                                "onClick"
                                                            ))
                                                        } else {
                                                            if (item.status == 4) {
                                                                createVNode(_component_mc_primary_button, utsMapOf("key" to 3, "linear-colors" to utsArrayOf(
                                                                    "#44C791",
                                                                    "#28D07F"
                                                                )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                    return utsArrayOf(
                                                                        "已完成"
                                                                    )
                                                                }), "_" to 1))
                                                            } else {
                                                                createCommentVNode("v-if", true)
                                                            }
                                                        }
                                                    }
                                                }
                                            ))
                                        ), 4)
                                    ))
                                }), 128)
                            ))
                        } else {
                            if (isTrue(_ctx.showOrderList)) {
                                createVNode(_component_x_pull_refresh, utsMapOf("key" to 1, "height" to (_ctx.pullViewHeight + "px"), "class" to "order-list", "disabled-bottom" to true, "disabled-pull" to true, "show-scrollbar" to false), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        if (_ctx.sortList.length > 0) {
                                            createVNode(_component_x_drag, utsMapOf("key" to 0, "onChange" to _ctx.onDragSortchange, "itemHeight" to "auto", "list" to _ctx.sortList), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.orderData.orderItems, fun(item, index, __index, _cached): Any {
                                                        return createVNode(_component_x_drag_item, utsMapOf("key" to item.orderId, "order" to index), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return utsArrayOf(
                                                                if (isTrue(!_ctx.isSmartPlanning && _ctx.sortList.length > 1)) {
                                                                    createElementVNode("view", utsMapOf("key" to 0, "class" to "order-item"), utsArrayOf(
                                                                        createElementVNode("view", utsMapOf("class" to "side-tag-box"), utsArrayOf(
                                                                            createElementVNode("image", utsMapOf("class" to "img", "src" to ("" + _ctx.resBaseUrl + "/static/images/box-side-tag.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                                                "src"
                                                                            )),
                                                                            createElementVNode("text", utsMapOf("class" to "text"), toDisplayString((index + 1).toString(10).padStart(2, "0")), 1)
                                                                        )),
                                                                        createElementVNode("view", utsMapOf("class" to "order-info", "style" to normalizeStyle("border: 4rpx solid #" + item.color + ";")), utsArrayOf(
                                                                            createElementVNode("view", utsMapOf("class" to "header flex-row flex-row-center-between"), utsArrayOf(
                                                                                createElementVNode("view", utsMapOf("class" to "left-box flex-row"), utsArrayOf(
                                                                                    createElementVNode("text", utsMapOf("class" to "text", "style" to normalizeStyle("color: #" + item.color + ";")), toDisplayString(item.sortNum) + "号订单：", 5),
                                                                                    createElementVNode("text", utsMapOf("class" to "num"), toDisplayString(item.orderId), 1)
                                                                                )),
                                                                                createVNode(_component_x_popover, utsMapOf("position" to "br"), utsMapOf("menu" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return utsArrayOf(
                                                                                        createElementVNode("view", utsMapOf("class" to "more-menu"), utsArrayOf(
                                                                                            createVNode(_component_x_cell, utsMapOf("onClick" to fun(){
                                                                                                _ctx.cancelOrder(item.orderId, item.sortNum)
                                                                                            }, "show-bottom-border" to false, "card" to false, "titleColor" to if (_ctx.serviceConfig.allowDriverCancelOrder) {
                                                                                                "red"
                                                                                            } else {
                                                                                                "#999999"
                                                                                            }, "title" to "取消订单"), null, 8, utsArrayOf(
                                                                                                "onClick",
                                                                                                "titleColor"
                                                                                            ))
                                                                                        ))
                                                                                    )
                                                                                }), "default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return utsArrayOf(
                                                                                        createElementVNode("view", utsMapOf("class" to "right-box flex-row"), utsArrayOf(
                                                                                            createElementVNode("text", utsMapOf("class" to "more-btn"), "更多"),
                                                                                            createVNode(_component_x_icon, utsMapOf("name" to "more-2-line"))
                                                                                        ))
                                                                                    )
                                                                                }), "_" to 2), 1024)
                                                                            )),
                                                                            createElementVNode("view", utsMapOf("class" to "address-info flex-row flex-row-center-between"), utsArrayOf(
                                                                                createElementVNode("view", utsMapOf("class" to "left-box"), utsArrayOf(
                                                                                    createElementVNode("view", utsMapOf("class" to "address-item"), utsArrayOf(
                                                                                        createElementVNode("view", utsMapOf("class" to "top flex-row"), utsArrayOf(
                                                                                            createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-location-start.png"), "mode" to ""), null, 8, utsArrayOf(
                                                                                                "src"
                                                                                            )),
                                                                                            createElementVNode("text", utsMapOf("class" to "label"), toDisplayString(item.startCity + "-" + item.startDistrict), 1)
                                                                                        )),
                                                                                        createElementVNode("text", utsMapOf("class" to "bottom", "style" to normalizeStyle("border-left: 1rpx solid " + _ctx.globalData.theme.primaryColor + ";")), toDisplayString(item.startAddress), 5)
                                                                                    )),
                                                                                    createElementVNode("view", utsMapOf("class" to "address-item"), utsArrayOf(
                                                                                        createElementVNode("view", utsMapOf("class" to "top flex-row"), utsArrayOf(
                                                                                            createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-location-end.png"), "mode" to ""), null, 8, utsArrayOf(
                                                                                                "src"
                                                                                            )),
                                                                                            createElementVNode("text", utsMapOf("class" to "label"), toDisplayString(item.endCity + "-" + item.endDistrict), 1)
                                                                                        )),
                                                                                        createElementVNode("text", utsMapOf("class" to "bottom"), toDisplayString(item.endAddress), 1)
                                                                                    ))
                                                                                )),
                                                                                createElementVNode("view", utsMapOf("class" to "right-box flex-row flex-row-center-center"), utsArrayOf(
                                                                                    createElementVNode("text", utsMapOf("class" to "num"), toDisplayString(item.passengerNum), 1),
                                                                                    createElementVNode("text", utsMapOf("class" to "label"), "人")
                                                                                ))
                                                                            )),
                                                                            createElementVNode("view", utsMapOf("class" to "seat-info"), utsArrayOf(
                                                                                createElementVNode("text", utsMapOf("class" to "label"), "座位信息："),
                                                                                createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(item.chooseSeat?.map(fun(seat, index, _arr): String {
                                                                                    return seat.displayName + " " + seat.seatKey + (if (index % 2 != 0) {
                                                                                        " \n"
                                                                                    } else {
                                                                                        if (index < _arr.length - 1) {
                                                                                            " / "
                                                                                        } else {
                                                                                            ""
                                                                                        }
                                                                                    })
                                                                                })?.join("") ?: "-"), 1),
                                                                                if (item.seatModel == 0) {
                                                                                    createElementVNode("image", utsMapOf("key" to 0, "onClick" to fun(){
                                                                                        _ctx.viewSeat(item)
                                                                                    }, "class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-seat-view-filled.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                                                        "onClick",
                                                                                        "src"
                                                                                    ))
                                                                                } else {
                                                                                    createCommentVNode("v-if", true)
                                                                                }
                                                                            )),
                                                                            createElementVNode("view", utsMapOf("class" to "remark flex-row"), utsArrayOf(
                                                                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-info-outline-small-2.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                                                    "src"
                                                                                )),
                                                                                createElementVNode("text", utsMapOf("class" to "text"), "备注：" + toDisplayString(item.remark), 1)
                                                                            )),
                                                                            createElementVNode("view", utsMapOf("class" to "btn-group flex-row"), utsArrayOf(
                                                                                createVNode(_component_mc_pain_button, utsMapOf("margin-right" to "26rpx", "onClick" to fun(){
                                                                                    _ctx.callPhone(item.phoneNumber)
                                                                                }, "icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-call-phone-outline.png")), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return utsArrayOf(
                                                                                        "联系乘客"
                                                                                    )
                                                                                }), "_" to 2), 1032, utsArrayOf(
                                                                                    "onClick",
                                                                                    "icon-path"
                                                                                )),
                                                                                if (isTrue(_ctx.orderParams["orderStatus"] != "0" && item.waitingStatus == 0)) {
                                                                                    createVNode(_component_mc_primary_button, utsMapOf("key" to 0, "onClick" to fun(){
                                                                                        _ctx.tryArrived(item.orderId, item.sortNum)
                                                                                    }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                        return utsArrayOf(
                                                                                            "到达上车点"
                                                                                        )
                                                                                    }), "_" to 2), 1032, utsArrayOf(
                                                                                        "onClick"
                                                                                    ))
                                                                                } else {
                                                                                    if (isTrue(_ctx.orderParams["orderStatus"] != "0" && item.status < 3)) {
                                                                                        createVNode(_component_mc_primary_button, utsMapOf("key" to 1, "onClick" to fun(){
                                                                                            _ctx.passengerPickUp(item.orderId, item.sortNum, index)
                                                                                        }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                            return utsArrayOf(
                                                                                                "乘客上车"
                                                                                            )
                                                                                        }), "_" to 2), 1032, utsArrayOf(
                                                                                            "onClick"
                                                                                        ))
                                                                                    } else {
                                                                                        if (item.status == 3) {
                                                                                            createVNode(_component_mc_primary_button, utsMapOf("key" to 2, "onClick" to fun(){
                                                                                                _ctx.validOrder(item.orderId, item.sortNum)
                                                                                            }, "linear-colors" to utsArrayOf(
                                                                                                "#44C791",
                                                                                                "#28D07F"
                                                                                            )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                                return utsArrayOf(
                                                                                                    "完成订单"
                                                                                                )
                                                                                            }), "_" to 2), 1032, utsArrayOf(
                                                                                                "onClick"
                                                                                            ))
                                                                                        } else {
                                                                                            if (item.status == 4) {
                                                                                                createVNode(_component_mc_primary_button, utsMapOf("key" to 3, "linear-colors" to utsArrayOf(
                                                                                                    "#44C791",
                                                                                                    "#28D07F"
                                                                                                )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                                    return utsArrayOf(
                                                                                                        "已完成"
                                                                                                    )
                                                                                                }), "_" to 1))
                                                                                            } else {
                                                                                                createCommentVNode("v-if", true)
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            ))
                                                                        ), 4)
                                                                    ))
                                                                } else {
                                                                    createElementVNode("view", utsMapOf("key" to 1, "class" to "order-item", "onLongpress" to withModifiers(_ctx.longpressStop, utsArrayOf(
                                                                        "stop"
                                                                    ))), utsArrayOf(
                                                                        createElementVNode("view", utsMapOf("class" to "side-tag-box"), utsArrayOf(
                                                                            createElementVNode("image", utsMapOf("class" to "img", "src" to ("" + _ctx.resBaseUrl + "/static/images/box-side-tag.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                                                "src"
                                                                            )),
                                                                            createElementVNode("text", utsMapOf("class" to "text"), toDisplayString((index + 1).toString(10).padStart(2, "0")), 1)
                                                                        )),
                                                                        createElementVNode("view", utsMapOf("class" to "order-info", "style" to normalizeStyle("border: 4rpx solid #" + item.color + ";")), utsArrayOf(
                                                                            createElementVNode("view", utsMapOf("class" to "header flex-row flex-row-center-between"), utsArrayOf(
                                                                                createElementVNode("view", utsMapOf("class" to "left-box flex-row"), utsArrayOf(
                                                                                    createElementVNode("text", utsMapOf("class" to "text", "style" to normalizeStyle("color: #" + item.color + ";")), toDisplayString(item.sortNum) + "号订单：", 5),
                                                                                    createElementVNode("text", utsMapOf("class" to "num"), toDisplayString(item.orderId), 1)
                                                                                )),
                                                                                createVNode(_component_x_popover, utsMapOf("position" to "br"), utsMapOf("menu" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return utsArrayOf(
                                                                                        createElementVNode("view", utsMapOf("class" to "more-menu"), utsArrayOf(
                                                                                            createVNode(_component_x_cell, utsMapOf("onClick" to fun(){
                                                                                                _ctx.cancelOrder(item.orderId, item.sortNum)
                                                                                            }, "show-bottom-border" to false, "card" to false, "titleColor" to if (_ctx.serviceConfig.allowDriverCancelOrder) {
                                                                                                "red"
                                                                                            } else {
                                                                                                "#999999"
                                                                                            }, "title" to "取消订单"), null, 8, utsArrayOf(
                                                                                                "onClick",
                                                                                                "titleColor"
                                                                                            ))
                                                                                        ))
                                                                                    )
                                                                                }), "default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return utsArrayOf(
                                                                                        createElementVNode("view", utsMapOf("class" to "right-box flex-row"), utsArrayOf(
                                                                                            createElementVNode("text", utsMapOf("class" to "more-btn"), "更多"),
                                                                                            createVNode(_component_x_icon, utsMapOf("name" to "more-2-line"))
                                                                                        ))
                                                                                    )
                                                                                }), "_" to 2), 1024)
                                                                            )),
                                                                            createElementVNode("view", utsMapOf("class" to "address-info flex-row flex-row-center-between"), utsArrayOf(
                                                                                createElementVNode("view", utsMapOf("class" to "left-box"), utsArrayOf(
                                                                                    createElementVNode("view", utsMapOf("class" to "address-item"), utsArrayOf(
                                                                                        createElementVNode("view", utsMapOf("class" to "top flex-row"), utsArrayOf(
                                                                                            createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-location-start.png"), "mode" to ""), null, 8, utsArrayOf(
                                                                                                "src"
                                                                                            )),
                                                                                            createElementVNode("text", utsMapOf("class" to "label"), toDisplayString(item.startCity + "-" + item.startDistrict), 1)
                                                                                        )),
                                                                                        createElementVNode("text", utsMapOf("class" to "bottom", "style" to normalizeStyle("border-left: 1rpx solid " + _ctx.globalData.theme.primaryColor + ";")), toDisplayString(item.startAddress), 5)
                                                                                    )),
                                                                                    createElementVNode("view", utsMapOf("class" to "address-item"), utsArrayOf(
                                                                                        createElementVNode("view", utsMapOf("class" to "top flex-row"), utsArrayOf(
                                                                                            createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-location-end.png"), "mode" to ""), null, 8, utsArrayOf(
                                                                                                "src"
                                                                                            )),
                                                                                            createElementVNode("text", utsMapOf("class" to "label"), toDisplayString(item.endCity + "-" + item.endDistrict), 1)
                                                                                        )),
                                                                                        createElementVNode("text", utsMapOf("class" to "bottom"), toDisplayString(item.endAddress), 1)
                                                                                    ))
                                                                                )),
                                                                                createElementVNode("view", utsMapOf("class" to "right-box flex-row flex-row-center-center"), utsArrayOf(
                                                                                    createElementVNode("text", utsMapOf("class" to "num"), toDisplayString(item.passengerNum), 1),
                                                                                    createElementVNode("text", utsMapOf("class" to "label"), "人")
                                                                                ))
                                                                            )),
                                                                            createElementVNode("view", utsMapOf("class" to "seat-info", "onClick" to fun(){
                                                                                _ctx.viewSeat(item)
                                                                            }), utsArrayOf(
                                                                                createElementVNode("text", utsMapOf("class" to "label"), "座位信息："),
                                                                                createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(item.chooseSeat?.map(fun(seat, index, _arr): String {
                                                                                    return seat.displayName + " " + seat.seatKey + (if (index % 2 != 0) {
                                                                                        " \n"
                                                                                    } else {
                                                                                        if (index < _arr.length - 1) {
                                                                                            " / "
                                                                                        } else {
                                                                                            ""
                                                                                        }
                                                                                    })
                                                                                })?.join("") ?: "-"), 1),
                                                                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-seat-view-filled.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                                                    "src"
                                                                                ))
                                                                            ), 8, utsArrayOf(
                                                                                "onClick"
                                                                            )),
                                                                            createElementVNode("view", utsMapOf("class" to "remark flex-row"), utsArrayOf(
                                                                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-info-outline-small-2.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                                                    "src"
                                                                                )),
                                                                                createElementVNode("text", utsMapOf("class" to "text"), "备注：" + toDisplayString(item.remark), 1)
                                                                            )),
                                                                            createElementVNode("view", utsMapOf("class" to "btn-group flex-row"), utsArrayOf(
                                                                                createVNode(_component_mc_pain_button, utsMapOf("margin-right" to "26rpx", "onClick" to fun(){
                                                                                    _ctx.callPhone(item.phoneNumber)
                                                                                }, "icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-call-phone-outline.png")), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return utsArrayOf(
                                                                                        "联系乘客"
                                                                                    )
                                                                                }), "_" to 2), 1032, utsArrayOf(
                                                                                    "onClick",
                                                                                    "icon-path"
                                                                                )),
                                                                                if (isTrue(_ctx.orderParams["orderStatus"] != "0" && item.waitingStatus == 0)) {
                                                                                    createVNode(_component_mc_primary_button, utsMapOf("key" to 0, "onClick" to fun(){
                                                                                        _ctx.tryArrived(item.orderId, item.sortNum)
                                                                                    }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                        return utsArrayOf(
                                                                                            "到达上车点"
                                                                                        )
                                                                                    }), "_" to 2), 1032, utsArrayOf(
                                                                                        "onClick"
                                                                                    ))
                                                                                } else {
                                                                                    if (isTrue(_ctx.orderParams["orderStatus"] != "0" && item.status < 3)) {
                                                                                        createVNode(_component_mc_primary_button, utsMapOf("key" to 1, "onClick" to fun(){
                                                                                            _ctx.passengerPickUp(item.orderId, item.sortNum, index)
                                                                                        }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                            return utsArrayOf(
                                                                                                "乘客上车"
                                                                                            )
                                                                                        }), "_" to 2), 1032, utsArrayOf(
                                                                                            "onClick"
                                                                                        ))
                                                                                    } else {
                                                                                        if (item.status == 3) {
                                                                                            createVNode(_component_mc_primary_button, utsMapOf("key" to 2, "onClick" to fun(){
                                                                                                _ctx.validOrder(item.orderId, item.sortNum)
                                                                                            }, "linear-colors" to utsArrayOf(
                                                                                                "#44C791",
                                                                                                "#28D07F"
                                                                                            )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                                return utsArrayOf(
                                                                                                    "完成订单"
                                                                                                )
                                                                                            }), "_" to 2), 1032, utsArrayOf(
                                                                                                "onClick"
                                                                                            ))
                                                                                        } else {
                                                                                            if (item.status == 4) {
                                                                                                createVNode(_component_mc_primary_button, utsMapOf("key" to 3, "linear-colors" to utsArrayOf(
                                                                                                    "#44C791",
                                                                                                    "#28D07F"
                                                                                                )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                                    return utsArrayOf(
                                                                                                        "已完成"
                                                                                                    )
                                                                                                }), "_" to 1))
                                                                                            } else {
                                                                                                createCommentVNode("v-if", true)
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            ))
                                                                        ), 4)
                                                                    ), 40, utsArrayOf(
                                                                        "onLongpress"
                                                                    ))
                                                                }
                                                            )
                                                        }), "_" to 2), 1032, utsArrayOf(
                                                            "order"
                                                        ))
                                                    }), 128)
                                                )
                                            }), "_" to 1), 8, utsArrayOf(
                                                "onChange",
                                                "list"
                                            ))
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                    )
                                }), "_" to 1), 8, utsArrayOf(
                                    "height"
                                ))
                            } else {
                                createCommentVNode("v-if", true)
                            }
                        }
                    ), 44, utsArrayOf(
                        "onTransitionend"
                    ))
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
            )),
            createVNode(_component_x_modal, utsMapOf("show" to _ctx.showCancelModal, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.showCancelModal = `$event`
            }
            , "show-close" to "", "onClose" to _ctx.modalCancelClose, "height" to if (_ctx.isLiquidatedDamages) {
                "690rpx"
            } else {
                "550rpx"
            }
            , "z-index" to "100", "title" to ("\u53D6\u6D88" + _ctx.orderNo + "\u53F7\u8BA2\u5355"), "show-footer" to false, "overlayClick" to false), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    if (isTrue(_ctx.isLiquidatedDamages)) {
                        createElementVNode("view", utsMapOf("key" to 0, "class" to "pb-15 flex-row flex-row-center-center"), utsArrayOf(
                            createElementVNode("text", null, "违约金额: "),
                            createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("color" to "red"))), "￥" + toDisplayString(_ctx.defaultDeduction), 5)
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    }
                    ,
                    createVNode(_component_x_input, utsMapOf("type" to "textarea", "auto-focus" to "", "modelValue" to _ctx.cancelReason, "onUpdate:modelValue" to fun(`$event`: String){
                        _ctx.cancelReason = `$event`
                    }
                    , "height" to "200rpx", "maxlength" to 50, "showChartCount" to "", "placeholder" to "请输入取消原因"), null, 8, utsArrayOf(
                        "modelValue",
                        "onUpdate:modelValue"
                    )),
                    if (isTrue(_ctx.isLiquidatedDamages)) {
                        createElementVNode("view", utsMapOf("key" to 1, "class" to "pt-10 pb-5"), utsArrayOf(
                            createVNode(_component_x_radio_group, utsMapOf("class" to "flex-row flex-row-center-center", "modelValue" to _ctx.driverCancelResponsibility, "onUpdate:modelValue" to fun(`$event`: String){
                                _ctx.driverCancelResponsibility = `$event`
                            }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createVNode(_component_x_radio, utsMapOf("onlyChecked" to true, "value" to "false", "class" to "pr-30", "label" to "乘客无责 ")),
                                    createVNode(_component_x_radio, utsMapOf("onlyChecked" to true, "value" to "true", "label" to "乘客有责"))
                                )
                            }), "_" to 1), 8, utsArrayOf(
                                "modelValue",
                                "onUpdate:modelValue"
                            ))
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    }
                    ,
                    createElementVNode("view", utsMapOf("class" to "btn-group flex-row"), utsArrayOf(
                        createVNode(_component_x_button, utsMapOf("onClick" to _ctx.modalCancelClose, "skin" to "thin", "style" to normalizeStyle(utsMapOf("flex" to "1", "margin-right" to "10px"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                "取消"
                            )
                        }
                        ), "_" to 1), 8, utsArrayOf(
                            "onClick",
                            "style"
                        )),
                        createVNode(_component_x_button, utsMapOf("onClick" to _ctx.cancelModalConfirm, "style" to normalizeStyle(utsMapOf("flex" to "1"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                "确认"
                            )
                        }
                        ), "_" to 1), 8, utsArrayOf(
                            "onClick",
                            "style"
                        ))
                    ))
                )
            }
            ), "_" to 1), 8, utsArrayOf(
                "show",
                "onUpdate:show",
                "onClose",
                "height",
                "title"
            )),
            createElementVNode("view", utsMapOf("class" to "bottom-actions", "style" to normalizeStyle("padding-bottom: " + (_ctx.globalData.safeAreaBottom + 5) + "px;")), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "order-btn", "onClick" to _ctx.viewOrders), utsArrayOf(
                    createElementVNode("image", utsMapOf("class" to "order-icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-order-outline.png")), null, 8, utsArrayOf(
                        "src"
                    )),
                    createElementVNode("view", null, utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "text"), "查看订单"),
                        createElementVNode("view", utsMapOf("class" to "flex-row"), utsArrayOf(
                            "(包含",
                            createElementVNode("text", utsMapOf("style" to normalizeStyle("color:" + _ctx.globalData.theme.primaryColor)), toDisplayString(_ctx.orderData.orderCount), 5),
                            createElementVNode("text", null, "笔订单)")
                        ))
                    ))
                ), 8, utsArrayOf(
                    "onClick"
                )),
                if (_ctx.orderParams["orderStatus"] != "0") {
                    createVNode(_component_mc_primary_button, utsMapOf("key" to 0, "border-radius" to "20rpx", "height" to "89rpx", "onClick" to fun(){
                        _ctx.startNavigation(false)
                    }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "开始导航"
                        )
                    }), "_" to 1), 8, utsArrayOf(
                        "onClick"
                    ))
                } else {
                    if (isTrue(_ctx.isCurrentDay)) {
                        createVNode(_component_mc_primary_button, utsMapOf("key" to 1, "border-radius" to "20rpx", "height" to "89rpx", "onClick" to _ctx.handleStartPickup), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                "出发接驾"
                            )
                        }), "_" to 1), 8, utsArrayOf(
                            "onClick"
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    }
                }
            ), 4),
            createVNode(_component_x_modal, utsMapOf("show" to _ctx.showAiDescModal, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.showAiDescModal = `$event`
            }
            , "bgColor" to "#ECF1F8", "show-cancel" to false, "confirm-text" to "知道了", "onConfirm" to fun(){
                _ctx.showAiDescModal = false
            }
            , "show-title" to false, "height" to "520rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "ai-desc-title"), "智能规划介绍"),
                    createElementVNode("view", utsMapOf("class" to "desc"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "pb-10"), "关闭智能规划: 订单以下单时间默认排序，司机可手动拖拽修改顺序。"),
                        createElementVNode("text", null, "开启智能规划: 订单会根据最优路线排序，司机不可手动修改，该模式可有效节省行程和出行时间。")
                    ))
                )
            }
            ), "_" to 1), 8, utsArrayOf(
                "show",
                "onUpdate:show",
                "onConfirm"
            )),
            createVNode(_component_mc_seat_viewer, utsMapOf("ref" to "seatViewer", "data" to _ctx.currentChooseSeat, "seatTemplates" to _ctx.seatSelectTemplates), null, 8, utsArrayOf(
                "data",
                "seatTemplates"
            ))
        ), 64)
    }
    open var globalData: GlobalDataType by `$inject`
    open var showAiDescModal: Boolean by `$data`
    open var today: Any? by `$data`
    open var currentChooseSeat: UTSArray<ChooseSeat> by `$data`
    open var seatSelectTemplates: UTSArray<SeatSelectTemplate> by `$data`
    open var resBaseUrl: Any? by `$data`
    open var orderNo: Number by `$data`
    open var orderIndex: Number by `$data`
    open var orderId: String by `$data`
    open var showValidModal: Boolean by `$data`
    open var showKey: Boolean by `$data`
    open var phoneSuffix: String by `$data`
    open var showCancelModal: Boolean by `$data`
    open var cancelReason: String by `$data`
    open var driverCancelResponsibility: String by `$data`
    open var isLiquidatedDamages: Boolean by `$data`
    open var defaultDeduction: String by `$data`
    open var orderParams: UTSJSONObject by `$data`
    open var sortList: UTSArray<UTSJSONObject> by `$data`
    open var orderData: OrderSummary1 by `$data`
    open var screenWidth: Number by `$data`
    open var screenHeight: Number by `$data`
    open var statusBarHeight: Number by `$data`
    open var isSmartPlanning: Boolean by `$data`
    open var selectedRoute: RouteSimpleInfo by `$data`
    open var showOrderList: Boolean by `$data`
    open var orderList: UTSArray<Any> by `$data`
    open var routes: UTSArray<RouteSimpleInfo> by `$data`
    open var isDx: Boolean by `$data`
    open var showRouteStrategyOptions: Boolean by `$data`
    open var routeStrategyMap: UTSJSONObject by `$data`
    open var routeStrategyOptions: UTSArray<RouteStrategyOption> by `$data`
    open var routeStrategy: String by `$data`
    open var routeStrategyStr: String by `$data`
    open var tripingViewHeight: Number by `$data`
    open var viaDistance: String by `$data`
    open var viaTime: String by `$data`
    open var mapContentHeight: Number by `$data`
    open var serviceConfig: ServiceOrderPermission by `$data`
    open var cardHeight: Number by `$data`
    open var cardShowHeight: Number by `$data`
    open var pullViewHeight: Number by `$data`
    open var transformHeight: Number by `$data`
    open var mapViewHeight: Number by `$data`
    open var isCurrentDay: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("showAiDescModal" to false, "today" to formatDate(Date(), "yyyy-MM-dd"), "currentChooseSeat" to utsArrayOf<ChooseSeat>(), "seatSelectTemplates" to utsArrayOf<SeatSelectTemplate>(), "resBaseUrl" to uni.UNI511F0A5.resBaseUrl, "orderNo" to 1, "orderIndex" to 0, "orderId" to "", "showValidModal" to false, "showKey" to false, "phoneSuffix" to "", "showCancelModal" to false, "cancelReason" to "", "driverCancelResponsibility" to "false", "isLiquidatedDamages" to false, "defaultDeduction" to "", "orderParams" to UTSJSONObject(), "sortList" to utsArrayOf<UTSJSONObject>(), "orderData" to OrderSummary1(orderCount = 0, driverStatus = -2, seatSelectTemplates = utsArrayOf(), orderItems = utsArrayOf(), orderChains = utsArrayOf(), orderRoute = OrderRoute(routeStrategy = "", routeStartPoint = "", routeWaypoints = utsArrayOf(), routeEndPoint = "", routeWaypointsPoiIds = utsArrayOf<String>(), routeStartPoiId = "", routeEndPoiId = "")), "screenWidth" to uni.UNI511F0A5.screenWidth as Number, "screenHeight" to uni.UNI511F0A5.screenHeight as Number, "statusBarHeight" to uni.UNI511F0A5.statusBarHeight as Number, "isSmartPlanning" to true, "selectedRoute" to RouteSimpleInfo(routeId = -1, time = "", distance = "", lights = 0, paths = ""), "showOrderList" to false, "orderList" to utsArrayOf<Any>(), "routes" to utsArrayOf<RouteSimpleInfo>(), "isDx" to false, "showRouteStrategyOptions" to false, "routeStrategyMap" to object : UTSJSONObject() {
            var OVERALL_OPTIMAL: Number = 10
            var FASTEST: Number = 0
            var CHARGE_LESS: Number = 14
            var DONT_HIGH_SPEED: Number = 13
        }, "routeStrategyOptions" to utsArrayOf<RouteStrategyOption>(RouteStrategyOption(code = "OVERALL_OPTIMAL", name = "综合最优"), RouteStrategyOption(code = "FASTEST", name = "速度优先"), RouteStrategyOption(code = "CHARGE_LESS", name = "少收费"), RouteStrategyOption(code = "DONT_HIGH_SPEED", name = "不走高速")), "routeStrategy" to "OVERALL_OPTIMAL", "routeStrategyStr" to "综合最优", "tripingViewHeight" to 200, "viaDistance" to "0公里", "viaTime" to "0分钟", "mapContentHeight" to 0, "serviceConfig" to ServiceOrderPermission(allocateSeatModel = false, allowSubmitOrderNoCar = false, allowDriverCloseTakeOrder = false, allowDriverCancelOrder = false, enableNumberPrivacy = false, enableCallRecording = false), "cardHeight" to computed<Number>(fun(): Number {
            return if (this.isDx) {
                400
            } else {
                this.screenHeight - 335
            }
        }
        ), "cardShowHeight" to computed<Number>(fun(): Number {
            var height: Number = 190
            if (this.showOrderList) {
                height = if (this.isDx) {
                    400
                } else {
                    this.screenHeight - 350
                }
            }
            return height
        }
        ), "pullViewHeight" to computed<Number>(fun(): Number {
            return this.cardHeight - 60
        }
        ), "transformHeight" to computed<Number>(fun(): Number {
            return this.cardHeight - this.cardShowHeight
        }
        ), "mapViewHeight" to computed<Number>(fun(): Number {
            return this.screenHeight - this.cardShowHeight - this.statusBarHeight - this.globalData.safeAreaBottom - 120
        }
        ), "isCurrentDay" to computed<Boolean>(fun(): Boolean {
            var isToday = false
            if (this.orderData.orderItems.length > 0) {
                if (this.orderData.orderItems[0]?.departureDay == this.today) {
                    isToday = true
                }
            }
            return isToday
        }
        ))
    }
    open var getServiceConfig = ::gen_getServiceConfig_fn
    open fun gen_getServiceConfig_fn() {
        getServiceOperationSetting().then(fun(res: Response){
            val data = JSON.parse<ServiceOrderPermission>(JSON.stringify(res.data))
            this.serviceConfig = data!!
        }
        )
    }
    open var longpressStop = ::gen_longpressStop_fn
    open fun gen_longpressStop_fn() {}
    open var updateToday = ::gen_updateToday_fn
    open fun gen_updateToday_fn() {
        setTimeout(fun(){
            this.today = formatDate(Date(), "yyyy-MM-dd")
            if (!this.isCurrentDay) {
                this.updateToday()
            }
        }
        , 3000)
    }
    open var initEvt = ::gen_initEvt_fn
    open fun gen_initEvt_fn(canCalcRoute: Boolean) {
        this.queryOrderDetail(canCalcRoute, false)
        this.initLocation()
        this.setContentHeight()
        this.onOrderAdd()
        this.onOrderAllFinish()
        this.onOneOrderFinish()
        this.onOrderCancel()
    }
    open var viewSeat = ::gen_viewSeat_fn
    open fun gen_viewSeat_fn(item: OrderItem) {
        console.log("OrderItem:", item)
        val that = this
        that.currentChooseSeat = item.chooseSeat
        val date = formatDate(Date(), "yyyy-MM-dd")
        refreshSeatTemplate("DRIVER_PLAN:ORDER_SEAT_METADATA:" + item.planId + ":" + date).then(fun(res: Response){
            if (res.code == 200) {
                that.seatSelectTemplates = JSON.parseObject<UTSArray<SeatSelectTemplate>>(JSON.stringify(res.data)) ?: utsArrayOf()
                setTimeout(fun(){
                    (that.`$refs`["seatViewer"] as McSeatViewerComponentPublicInstance)?.show()
                }
                , 100)
            }
        }
        )
    }
    open var queryOrderDetail = ::gen_queryOrderDetail_fn
    open fun gen_queryOrderDetail_fn(canCalcRoute: Boolean, forceCalc: Boolean) {
        val that = this
        var queryType: Number = 0
        if (that.orderParams["orderStatus"] != "0") {
            queryType = OrderQueryType["PICKUP_ORDER_DETAIL"] as Number
        } else {
            queryType = OrderQueryType["RESERVATION_ORDER_DETAIL"] as Number
        }
        ws?.sendAndOn(WebSocketSendMessage(type = MessageType["QUERY_ORDER"] as Number, content = UTSJSONObject(Map<String, Any?>(utsArrayOf(
            utsArrayOf(
                "queryType",
                queryType
            ),
            utsArrayOf(
                "condition",
                if (that.orderParams["orderStatus"] != "0") {
                    ""
                } else {
                    JSON.stringify(object : UTSJSONObject() {
                        var reserveDate = that.orderParams["queryDate"]
                        var summaryId = that.orderParams["summaryId"]
                    })
                }
            )
        )))), fun(data){
            val res = (JSON.parse<OrderData>(data) as OrderData).data
            that.orderData = res
            that.routeStrategy = res.orderRoute.routeStrategy
            if (forceCalc || (that.orderParams["orderStatus"] != "0" || res.orderItems.length > 1) && canCalcRoute) {
                that.calcRoute()
            }
            that.sortList = utsArrayOf<UTSJSONObject>()
            if (res.orderItems.length > 0) {
                setTimeout(fun(){
                    that.sortList = res.orderItems.map(fun(item, _idx, _arr): UTSJSONObject {
                        return (object : UTSJSONObject() {
                            var id = item.orderId
                        })
                    }
                    )
                    val mapView = (that.`$refs`["mapView"] as McAmapComponentPublicInstance)
                    val markers = res.orderChains.map(fun(item, _idx, _arr): MarkerOption {
                        val pointArr: UTSArray<Number> = item.point.split(",").reverse().map(fun(item: String, _idx: Number, _arr: UTSArray<String>): Number {
                            return UTSNumber.from(item)
                        }
                        )
                        return MarkerOption(latitude = pointArr[0], longitude = pointArr[1], color = item.pointColor, desc = item.pointName, icon = "")
                    }
                    )
                    mapView?.setMarkers(markers)
                }
                , 10)
            }
            uni__emit("onSendData", JSON.stringify(that.orderData))
            console.log("订单详情数据：", that.orderData)
        }
        )
    }
    open var calcRoute = ::gen_calcRoute_fn
    open fun gen_calcRoute_fn() {
        showLoading(XLOADINGS_TYPE(title = "正在进行线路规划..."))
        val mapView = (this.`$refs`["mapView"] as McAmapComponentPublicInstance)
        val startPoint = this.orderData.orderRoute.routeStartPoint.split(",")
        val endPoint = this.orderData.orderRoute.routeEndPoint.split(",")
        val point = this.orderData.orderRoute.routeWaypoints.map(fun(item: String, _idx: Number, _arr: UTSArray<String>): UTSArray<Number> {
            return item.split(",").reverse().map(fun(item: String, _idx: Number, _arr: UTSArray<String>): Number {
                return UTSNumber.from(item)
            }
            )
        }
        )
        val options = AmapNavOption(wayPoints = point, poiIds = this.orderData.orderRoute.routeWaypointsPoiIds, startLng = UTSNumber.from(startPoint[0]), startLat = UTSNumber.from(startPoint[1]), startPoiId = this.orderData.orderRoute.routeStartPoiId, endPoiId = this.orderData.orderRoute.routeEndPoiId, endLng = UTSNumber.from(endPoint[0]), endLat = UTSNumber.from(endPoint[1]), endName = "", calcStrategy = this.routeStrategyMap[this.routeStrategy] as Number)
        mapView?.calculate(options)
    }
    open var initLocation = ::gen_initLocation_fn
    open fun gen_initLocation_fn() {
        val mapView = (this.`$refs`["mapView"] as McAmapComponentPublicInstance)
        mapView?.getLocation(SingleLocationOptions(), fun(res: LocationResult){
            var log = "\u5355\u6B21\u5B9A\u4F4D\u56DE\u8C03 " + JSON.stringify(res)
            console.log(log)
        }
        )
    }
    open var naviInfoUpdate = ::gen_naviInfoUpdate_fn
    open fun gen_naviInfoUpdate_fn(navInfo: String) {
        console.log("导航信息更新：", navInfo)
        val navInfoArr = JSON.parse<UTSArray<UTSJSONObject>>(navInfo)
        val nav = navInfoArr?.get(0)
        this.viaDistance = formatDistance(nav?.getNumber("distance") ?: 0, DistanceOption())
        this.viaTime = formatDuration(nav?.getNumber("time") ?: 0)
        this.syncRoutePaths(false)
        uni__emit("syncNavInfo", JSON.stringify(let {
            object : UTSJSONObject() {
                var distance = it.viaDistance
                var time = it.viaTime
            }
        }))
    }
    open var calcRouteSuccess = ::gen_calcRouteSuccess_fn
    open fun gen_calcRouteSuccess_fn(data: String) {
        hideXloading()
        val routeData = JSON.parse<UTSJSONObject>(data) ?: UTSJSONObject()
        val routes: UTSArray<RouteSimpleInfo> = utsArrayOf()
        UTSJSONObject.keys(routeData).forEach(fun(key: String, index: Number, array: UTSArray<String>){
            val value = routeData.getJSON(key)
            routes.push(RouteSimpleInfo(routeId = UTSNumber.from(key), time = formatDuration(value?.getNumber("allTime") ?: 0), distance = formatDistance(value?.getNumber("allLength") ?: 0, DistanceOption()), lights = value?.getNumber("trafficLightCount") ?: 0, paths = value?.getString("paths") ?: ""))
        }
        )
        this.routes = routes
        this.selectRoute(routes[0])
        val mapView = (this.`$refs`["mapView"] as McAmapComponentPublicInstance)
        setTimeout(fun(){
            mapView?.changeRouteById(this.routes[0].routeId)
        }
        , 10)
    }
    open var startNavigation = ::gen_startNavigation_fn
    open fun gen_startNavigation_fn(isEmulator: Boolean) {
        val that = this
        if (that.routes.length <= 0) {
            return showTips("暂无路线规划，无法开启导航", "warning")
        }
        (this.`$refs`["mapView"] as McAmapComponentPublicInstance)?.startNavi(this.selectedRoute.routeId, isEmulator)
        uni_navigateTo(NavigateToOptions(url = "/pages/other/order-detail/navi?planId=" + this.orderParams["planId"] + "&summaryId=" + this.orderParams["summaryId"], events = object : UTSJSONObject() {
            var query = fun(canCalcRoute: Boolean){
                that.initEvt(canCalcRoute)
            }
        }, success = fun(res){
            uni__emit("onSendData", JSON.stringify(that.orderData))
            uni__emit("syncNavInfo", JSON.stringify(let {
                object : UTSJSONObject() {
                    var distance = it.viaDistance
                    var time = it.viaTime
                }
            }))
        }
        ))
    }
    open var navQuit = ::gen_navQuit_fn
    open fun gen_navQuit_fn() {
        this.initEvt(false)
    }
    open var arriveDestination = ::gen_arriveDestination_fn
    open fun gen_arriveDestination_fn() {
        console.log("组件回调-到达目的地")
    }
    open var locationupdate = ::gen_locationupdate_fn
    open fun gen_locationupdate_fn(location: Any) {
        console.log("位置信息更新", location)
    }
    open var onPlanningChange = ::gen_onPlanningChange_fn
    open fun gen_onPlanningChange_fn(kVal: Boolean) {
        ws?.sendAndOnErr(WebSocketSendMessage(type = MessageType["QUERY_CAR_SETTING"] as Number, content = object : UTSJSONObject() {
            var enableAIRouteStrategy = kVal
        }), fun(data){
            val json = JSON.parse<UTSJSONObject>(data)
            this.globalData.carSetting.closeReceiveOrderSwitch = json?.getBoolean("closeReceiveOrderSwitch") ?: true
            this.globalData.carSetting.enableAIRouteStrategy = json?.getBoolean("enableAIRouteStrategy") ?: false
            this.globalData.carSetting.routeStrategy = json?.getString("routeStrategy") ?: "OVERALL_OPTIMAL"
            this.queryOrderDetail(true, false)
        }
        , fun(data){
            this.isSmartPlanning = false
            console.log("this.isSmartPlanning = ", this.isSmartPlanning)
        }
        )
    }
    open var selectRoute = ::gen_selectRoute_fn
    open fun gen_selectRoute_fn(route: RouteSimpleInfo) {
        if (route.routeId != null) {
            this.selectedRoute = route
            val mapView = this.`$refs`["mapView"] as McAmapComponentPublicInstance
            mapView?.changeRouteById(route.routeId)
            this.viaDistance = this.selectedRoute.distance
            this.viaTime = this.selectedRoute.time
            this.syncRoutePaths(true)
        }
    }
    open var syncRoutePaths = ::gen_syncRoutePaths_fn
    open fun gen_syncRoutePaths_fn(syncPath: Boolean) {
        val that = this
        ws?.sendAndOn(WebSocketSendMessage(type = MessageType["TRIP_REPORT"] as Number, content = JSON.stringify(object : UTSJSONObject() {
            var polyline = if (syncPath) {
                that.selectedRoute.paths
            } else {
                ""
            }
            var navigationRouteInfo = object : UTSJSONObject() {
                var distance = that.viaDistance
                var duration = that.viaTime
            }
        })), fun(data){
            console.log("同步路线成功：", data)
        }
        )
    }
    open var setContentHeight = ::gen_setContentHeight_fn
    open fun gen_setContentHeight_fn() {
        this.mapContentHeight = this.mapViewHeight
    }
    open var viewOrders = ::gen_viewOrders_fn
    open fun gen_viewOrders_fn() {
        this.showOrderList = !this.showOrderList
        if (!this.showOrderList) {
            this.setContentHeight()
        }
        this.showRouteStrategyOptions = false
    }
    open var onTransitionend = ::gen_onTransitionend_fn
    open fun gen_onTransitionend_fn() {
        if (this.showOrderList) {
            this.setContentHeight()
        }
        setTimeout(fun(){
            this.selectRoute(this.selectedRoute)
        }
        , 100)
    }
    open var routeLoveClick = ::gen_routeLoveClick_fn
    open fun gen_routeLoveClick_fn(option: RouteStrategyOption) {
        this.routeStrategy = option.code
        this.routeStrategyStr = option.name
        this.calcRoute()
        setTimeout(fun(){
            this.showRouteStrategyOptions = false
        }
        , 50)
    }
    open var routeLoveBtnClick = ::gen_routeLoveBtnClick_fn
    open fun gen_routeLoveBtnClick_fn() {
        if (this.orderData.driverStatus < 0) {
            return
        }
        this.showRouteStrategyOptions = !this.showRouteStrategyOptions
    }
    open var openTrip = ::gen_openTrip_fn
    open fun gen_openTrip_fn() {
        ws?.sendAndOn(WebSocketSendMessage(type = MessageType["OPEN_TRIP"] as Number), fun(data){
            console.log("开启行程：", data)
            this.orderData.driverStatus = 3
            vibrator(100)
        }
        )
    }
    open var closeTrip = ::gen_closeTrip_fn
    open fun gen_closeTrip_fn() {
        ws?.sendAndOn(WebSocketSendMessage(type = MessageType["STOP_TRIP"] as Number), fun(data){
            console.log("关闭行程：", data)
            vibrator(100)
            this.orderData.driverStatus = 0
        }
        )
    }
    open var tryArrived = ::gen_tryArrived_fn
    open fun gen_tryArrived_fn(orderId: String, sortNum: Number) {
        val that = this
        vibrator(100)
        showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u786E\u8BA4\u5230\u8FBE" + that.orderNo + "\u53F7\u8BA2\u5355\u4E0A\u8F66\u70B9\uFF1F", confirmText = "确认", confirmBgColor = this.globalData.theme.primaryColor, confirm = fun(){
            this.orderId = orderId
            this.orderNo = sortNum
            that.verifyArrivedSuccess()
        }
        ))
    }
    open var passengerPickUp = ::gen_passengerPickUp_fn
    open fun gen_passengerPickUp_fn(orderId: String, orderNo: Number, index: Number) {
        this.orderNo = orderNo
        this.orderIndex = index
        vibrator(100)
        this.orderId = orderId
        this.verifySuccess()
    }
    open var verifyArrivedSuccess = ::gen_verifyArrivedSuccess_fn
    open fun gen_verifyArrivedSuccess_fn() {
        val that = this
        ws?.sendAndOn(WebSocketSendMessage(type = MessageType["ARRIVED_TRIP"] as Number, content = that.orderId), fun(data){
            console.log("到达上车点：", data)
            vibrator(100)
            that.queryOrderDetail(false, false)
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
            this.orderId = ""
        }
        , 100)
    }
    open var handleStartPickup = ::gen_handleStartPickup_fn
    open fun gen_handleStartPickup_fn() {
        val that = this
        showLoading(XLOADINGS_TYPE(title = "正在出车中..."))
        ws?.sendAndOnErr(WebSocketSendMessage(type = MessageType["BEFORE_CHECK"] as Number), fun(data){
            console.log("检车成功：", data)
            restartListening(that.orderParams["summaryId"] as String).then(fun(){
                that.orderParams["orderStatus"] = "1"
                that.queryOrderDetail(true, false)
            }
            ).`finally`(fun(){
                vibrator(100)
                hideXloading()
            }
            )
        }
        , fun(data){
            hideXloading()
        }
        )
    }
    open var validPhoneConfirm = ::gen_validPhoneConfirm_fn
    open fun gen_validPhoneConfirm_fn() {
        val that = this
        showLoading(XLOADINGS_TYPE(title = "验证乘客手机号..."))
        ws?.sendAndOnErr(WebSocketSendMessage(type = MessageType["VALID_PHONE"] as Number, content = JSON.stringify(object : UTSJSONObject() {
            var phoneLastFour = that.phoneSuffix
            var orderId = that.orderId
        })), fun(data){
            console.log("到达上车点：", data)
            that.queryOrderDetail(that.orderIndex == that.orderData.orderItems.length - 1, false)
            hideXloading()
            vibrator(100)
            that.showValidModal = false
            that.showKey = false
            that.phoneSuffix = ""
            that.orderId = ""
            that.orderIndex = 0
        }
        , fun(data){
            hideXloading()
        }
        )
    }
    open var toSelectPlan = ::gen_toSelectPlan_fn
    open fun gen_toSelectPlan_fn(orderId: String, status: Number) {
        if (status > 2) {
            return showToast("乘客已上车，无法进行改派", "error")
        }
        uni_useKuxRouter().push("/pages/other/trip-plan/select-plan/index?orderId=" + orderId)
    }
    open var finishOrder = ::gen_finishOrder_fn
    open fun gen_finishOrder_fn(orderId: String, sortNum: Number) {
        val that = this
        showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u786E\u8BA4\u5B8C\u6210" + sortNum + "\u53F7\u8BA2\u5355\uFF1F", confirmText = "确认", confirmBgColor = that.globalData.theme.primaryColor, confirm = fun(){
            showLoading(XLOADINGS_TYPE(title = "正在完成订单..."))
            ws?.sendAndOnErr(WebSocketSendMessage(type = MessageType["ORDER_FINISH"] as Number, content = orderId), fun(data){
                console.log("完成订单：", data)
                if (that.orderIndex < that.orderData.orderItems.length - 1) {
                    that.queryOrderDetail(true, false)
                }
                hideXloading()
            }
            , fun(data){
                hideXloading()
            }
            )
        }
        ))
    }
    open var validOrder = ::gen_validOrder_fn
    open fun gen_validOrder_fn(orderId: String, sortNum: Number) {
        val that = this
        if (that.orderData.driverStatus == 3) {
            this.finishOrder(orderId, sortNum)
        } else {
            showLoading(XLOADINGS_TYPE(title = "正在开启行程..."))
            ws?.sendAndOnErr(WebSocketSendMessage(type = MessageType["OPEN_TRIP"] as Number), fun(data){
                console.log("开启行程：", data)
                hideXloading()
                that.orderData.driverStatus = 3
                that.finishOrder(orderId, sortNum)
            }
            , fun(data){
                hideXloading()
            }
            )
        }
    }
    open var modalCancelClose = ::gen_modalCancelClose_fn
    open fun gen_modalCancelClose_fn() {
        this.orderId = ""
        this.cancelReason = ""
        this.showCancelModal = false
        this.driverCancelResponsibility = "false"
        this.defaultDeduction = "0"
        this.isLiquidatedDamages = false
    }
    open var cancelOrder = ::gen_cancelOrder_fn
    open fun gen_cancelOrder_fn(orderId: String, sortNum: Number) {
        if (!this.serviceConfig.allowDriverCancelOrder) {
            showTips("您的服务商设置当前不允许取消订单", "warning")
            return
        }
        this.orderNo = sortNum
        this.orderId = orderId
        getIntercityPassengerCancellation(orderId).then(fun(res: Response){
            val data = JSON.parse<PassengerCancellation>(JSON.stringify(res.data))
            if (1 == data?.isCancel) {
                this.showCancelModal = true
                this.isLiquidatedDamages = 1 == data?.isLiquidatedDamages
                this.defaultDeduction = data?.defaultDeduction ?: "0"
            } else {
                showTips("该订单无法被取消", "warning")
            }
        }
        )
    }
    open var cancelModalConfirm = ::gen_cancelModalConfirm_fn
    open fun gen_cancelModalConfirm_fn() {
        val that = this
        if (that.cancelReason.trim() == "") {
            return showTips("请输入取消原因", "warning")
        }
        showLoading(XLOADINGS_TYPE(title = "正在取消订单..."))
        ws?.sendAndOnErr(WebSocketSendMessage(type = MessageType["ORDER_CANCEL"] as Number, content = JSON.stringify(object : UTSJSONObject() {
            var orderId = that.orderId
            var driverCancelResponsibility = that.driverCancelResponsibility == "true"
            var cancelReason = "司机主动取消，原因如下：" + that.cancelReason
        })), fun(data){
            console.log("取消订单：", data)
            hideXloading()
            val res = JSON.parse<OrderCancelResponse>(data)
            that.orderId = ""
            that.showCancelModal = false
            if (res?.summaryId == that.orderParams["summaryId"]) {
                if (res?.backIndex ?: false) {
                    setTimeout(fun() {
                        showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u60A8\u5F53\u524D\u8BA2\u5355\u5DF2\u5168\u90E8\u7ED3\u675F", confirmText = "返回首页", confirmBgColor = this.globalData.theme.primaryColor, close = fun(){
                            uni_reLaunch(ReLaunchOptions(url = "/pages/home/index"))
                        }))
                    }, 250)
                } else {
                    that.queryOrderDetail(true, false)
                }
                McAudio.play("/static/audio/order-cancel.mp3", false)
            }
        }
        , fun(data){
            hideXloading()
        }
        )
    }
    open var onOrderAdd = ::gen_onOrderAdd_fn
    open fun gen_onOrderAdd_fn() {
        val that = this
        ws?.on(MessageType["ORDER_ADD"] as Number, fun(data){
            console.log("您有一个新的订单：", data)
            hideXloading()
            val res = JSON.parse<OrderAddResponse>(data)
            if (res?.summaryId == that.orderParams["summaryId"]) {
                setTimeout(fun() {
                    showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u60A8\u6536\u5230\u4E00\u7B14\u65B0\u7684\u8BA2\u5355", confirmText = "知道了", confirmBgColor = this.globalData.theme.primaryColor, showCancel = false, close = fun(){
                        that.queryOrderDetail(true, false)
                    }
                    ))
                }
                , 250)
                McAudio.play("/static/audio/new-order.mp3", false)
            }
        }
        )
    }
    open var onOrderAllFinish = ::gen_onOrderAllFinish_fn
    open fun gen_onOrderAllFinish_fn() {
        val that = this
        ws?.on(MessageType["BIG_ORDER_FINISH"] as Number, fun(data){
            console.log("因订单取消或调度，您当前订单已全部完成：", data)
            hideXloading()
            val res = JSON.parse<OrderFinishResponse>(data)
            if (res?.summaryId == that.orderParams["summaryId"]) {
                setTimeout(fun() {
                    showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u56E0\u8BA2\u5355\u53D6\u6D88\u6216\u8C03\u5EA6\uFF0C\u60A8\u5F53\u524D\u8BA2\u5355\u5DF2\u5168\u90E8\u5B8C\u6210", confirmText = "返回首页", confirmBgColor = this.globalData.theme.primaryColor, showCancel = false, close = fun(){
                        uni_reLaunch(ReLaunchOptions(url = "/pages/home/index"))
                    }
                    ))
                }
                , 250)
                McAudio.play("/static/audio/order-cancel.mp3", false)
            }
        }
        )
    }
    open var onOneOrderFinish = ::gen_onOneOrderFinish_fn
    open fun gen_onOneOrderFinish_fn() {
        val that = this
        ws?.on(MessageType["ORDER_FINISH"] as Number, fun(data){
            console.log("因订单取消或调度，您当前订单已全部完成：", data)
            hideXloading()
            val res = JSON.parse<OrderFinishResponse>(data)
            if (res?.summaryId == that.orderParams["summaryId"]) {
                if (res?.allOfOrderCompleted ?: false) {
                    setTimeout(fun() {
                        showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u60A8\u5F53\u524D\u8BA2\u5355\u5DF2\u5168\u90E8\u5B8C\u6210", confirmText = "返回首页", confirmBgColor = this.globalData.theme.primaryColor, showCancel = false, close = fun(){
                            uni_reLaunch(ReLaunchOptions(url = "/pages/home/index"))
                        }))
                    }, 250)
                } else {
                    that.queryOrderDetail(false, false)
                }
                McAudio.play("/static/audio/order-cancel.mp3", false)
            }
        }
        )
    }
    open var onOrderCancel = ::gen_onOrderCancel_fn
    open fun gen_onOrderCancel_fn() {
        val that = this
        ws?.on(MessageType["ORDER_CANCEL"] as Number, fun(data){
            val res = JSON.parse<OrderCancelResponse>(data)
            console.log("您有一个订单已被取消：", res)
            if (res?.summaryId == that.orderParams["summaryId"]) {
                if (res?.backIndex ?: false) {
                    setTimeout(fun() {
                        showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u60A8\u5F53\u524D\u8BA2\u5355\u5DF2\u5168\u90E8\u7ED3\u675F", confirmText = "返回首页", confirmBgColor = this.globalData.theme.primaryColor, showCancel = false, close = fun(){
                            uni_reLaunch(ReLaunchOptions(url = "/pages/home/index"))
                        }))
                    }, 250)
                } else {
                    setTimeout(fun() {
                        showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u60A8\u6709\u4E00\u4E2A\u8BA2\u5355\u5DF2\u88AB\u53D6\u6D88", confirmText = "知道了", confirmBgColor = this.globalData.theme.primaryColor, showCancel = false, close = fun(){
                            that.queryOrderDetail(true, false)
                        }
                        ))
                    }
                    , 250)
                }
                McAudio.play("/static/audio/order-cancel.mp3", false)
            }
        }
        )
    }
    open var callPhone = ::gen_callPhone_fn
    open fun gen_callPhone_fn(phone: String) {
        uni_makePhoneCall(MakePhoneCallOptions(phoneNumber = phone, success = fun(result: MakePhoneCallSuccess){
            console.log("拨打电话成功")
        }
        , fail = fun(_err){
            console.log("拨打电话失败", _err)
            showToast("拨打电话失败", "error")
        }
        ))
    }
    open var onDragSortchange = ::gen_onDragSortchange_fn
    open fun gen_onDragSortchange_fn(list: UTSArray<UTSJSONObject>) {
        console.warn("变动的数据：", list)
        if (list.length == 1) {
            return
        }
        val that = this
        showLoading(XLOADINGS_TYPE(title = "正在重新排序..."))
        ws?.sendAndOnErr(WebSocketSendMessage(type = MessageType["ORDER_SORT"] as Number, content = JSON.stringify(object : UTSJSONObject() {
            var type = if (that.orderData.driverStatus == -2) {
                1
            } else {
                0
            }
            var orderIds = list.map(fun(item, _idx, _arr): String {
                return item.getString("id") ?: ""
            }
            ).join(",")
            var reserveDate = that.orderParams["queryDate"]
            var summaryId = that.orderParams["summaryId"]
        })), fun(data){
            console.log("重新排序成功：", data)
            that.queryOrderDetail(true, false)
            hideXloading()
        }
        , fun(data){
            that.queryOrderDetail(false, false)
            hideXloading()
        }
        )
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
                return utsMapOf("map-container" to padStyleMapOf(utsMapOf("width" to "100%", "backgroundColor" to "#ffffff")), "route-love" to padStyleMapOf(utsMapOf("boxSizing" to "border-box", "width" to "100%", "paddingTop" to "35rpx", "paddingRight" to "35rpx", "paddingBottom" to "35rpx", "paddingLeft" to "35rpx", "position" to "relative", "left" to 0, "right" to 0, "height" to "250rpx")), "title" to utsMapOf(".route-love " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#FFFFFF")), "bg-img" to utsMapOf(".route-love " to utsMapOf("position" to "absolute", "left" to "-10rpx", "top" to 0, "right" to 0, "height" to "609rpx")), "radio-card-group" to utsMapOf(".route-love " to utsMapOf("flexDirection" to "row", "paddingTop" to "15rpx")), "radio-card" to utsMapOf(".route-love .radio-card-group " to utsMapOf("flex" to 1, "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "textAlign" to "center")), "content-panel" to padStyleMapOf(utsMapOf("borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "0rpx", "borderBottomLeftRadius" to "0rpx", "boxSizing" to "border-box", "boxShadow" to "0rpx 0rpx 8rpx 0rpx rgba(89, 119, 177, 0.5)", "transitionProperty" to "transform", "transitionDuration" to "0.5s", "position" to "fixed", "left" to 0, "right" to 0)), "planning-header" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "boxSizing" to "border-box", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "backgroundColor" to "rgba(0,0,0,0)")), "planning-title" to utsMapOf(".planning-header " to utsMapOf("flexDirection" to "row", "alignItems" to "center", "paddingTop" to "5rpx", "paddingRight" to "10rpx", "paddingBottom" to "5rpx", "paddingLeft" to "10rpx", "backgroundImage" to "linear-gradient(to right, #FFF3DD, #00000000)", "borderTopLeftRadius" to "5rpx", "borderTopRightRadius" to "5rpx", "borderBottomRightRadius" to "5rpx", "borderBottomLeftRadius" to "5rpx")), "text" to utsMapOf(".planning-header .planning-title " to utsMapOf("marginRight" to "10rpx"), ".planning-header .sort-btn " to utsMapOf("fontSize" to "26rpx", "color" to "#FFFFFF"), ".route-card .header .traffic-light " to utsMapOf("fontSize" to "26rpx"), ".header-order-title " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx"), ".order-list .order-item .side-tag-box " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#F5F7FA", "position" to "absolute", "left" to "13rpx", "top" to "13rpx"), ".order-list .order-item .order-info .header .left-box " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx"), ".order-list .order-item .order-info .remark " to utsMapOf("width" to "95%", "boxSizing" to "border-box", "paddingLeft" to "6rpx", "fontWeight" to "bold", "fontSize" to "27rpx", "color" to "#D09A5B"), ".order-list .order-item-dx .order-info .header .left-box " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx"), ".order-list .order-item-dx .order-info .remark " to utsMapOf("width" to "95%", "boxSizing" to "border-box", "paddingLeft" to "6rpx", "fontWeight" to "bold", "fontSize" to "27rpx", "color" to "#D09A5B"), ".triping-panel .main-body .left-box " to utsMapOf("fontSize" to "26rpx", "color" to "#000000")), "planning-icon" to utsMapOf(".planning-header .planning-title " to utsMapOf("width" to "21rpx", "height" to "27rpx", "marginRight" to "10rpx")), "sort-btn" to utsMapOf(".planning-header " to utsMapOf("backgroundColor" to "#95B1E7", "paddingTop" to "10rpx", "paddingRight" to "20rpx", "paddingBottom" to "10rpx", "paddingLeft" to "20rpx", "flexDirection" to "row", "alignItems" to "center", "borderTopLeftRadius" to "5rpx", "borderTopRightRadius" to "5rpx", "borderBottomRightRadius" to "5rpx", "borderBottomLeftRadius" to "5rpx")), "sort-icon" to utsMapOf(".planning-header .sort-btn " to utsMapOf("marginLeft" to "10rpx", "width" to "24rpx", "height" to "20rpx")), "routes-container" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "marginTop" to "24rpx", "marginRight" to "30rpx", "marginBottom" to "30rpx", "marginLeft" to "30rpx", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx")), "route-card" to padStyleMapOf(utsMapOf("borderTopLeftRadius" to "16rpx", "borderTopRightRadius" to "16rpx", "borderBottomRightRadius" to "16rpx", "borderBottomLeftRadius" to "16rpx", "justifyContent" to "space-between", "paddingTop" to "15rpx", "paddingRight" to "20rpx", "paddingBottom" to "15rpx", "paddingLeft" to "20rpx", "alignContent" to "space-between", "height" to "210rpx", "flex" to 1)), "header" to utsMapOf(".route-card " to utsMapOf("flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between"), ".order-list .order-item .order-info " to utsMapOf("paddingBottom" to "20rpx", "borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#e7e7e7", "marginBottom" to "20rpx"), ".order-list .order-item-dx .order-info " to utsMapOf("paddingBottom" to "20rpx"), ".triping-panel " to utsMapOf("paddingTop" to "30rpx", "paddingRight" to "45rpx", "paddingBottom" to "10rpx", "paddingLeft" to "45rpx")), "route-title" to utsMapOf(".route-card .header " to utsMapOf("fontSize" to "26rpx")), "traffic-light" to utsMapOf(".route-card .header " to utsMapOf("flexDirection" to "row", "alignItems" to "center")), "light-icon" to utsMapOf(".route-card .header .traffic-light " to utsMapOf("width" to "20rpx", "height" to "22rpx", "marginRight" to "6rpx")), "route-time" to utsMapOf(".route-card " to utsMapOf("fontSize" to "32rpx", "fontWeight" to "bold")), "route-distance" to utsMapOf(".route-card " to utsMapOf("fontSize" to "26rpx")), "bottom-actions" to padStyleMapOf(utsMapOf("backgroundColor" to "#ffffff", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "borderTopWidth" to "1rpx", "borderTopStyle" to "solid", "borderTopColor" to "#eeeeee", "height" to "150rpx", "width" to "100%", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "zIndex" to 10)), "order-btn" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "paddingTop" to 0, "paddingRight" to "100rpx", "paddingBottom" to 0, "paddingLeft" to "20rpx")), "order-icon" to utsMapOf(".order-btn " to utsMapOf("width" to "41rpx", "height" to "47rpx", "marginRight" to "20rpx"), ".triping-panel .header .order-title " to utsMapOf("width" to "24rpx", "height" to "28rpx", "marginRight" to "10rpx")), "header-order-title" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0)), "icon" to utsMapOf(".header-order-title " to utsMapOf("width" to "28rpx", "height" to "28rpx", "marginRight" to "10rpx"), ".order-list .order-item .order-info .header .left-box " to utsMapOf("width" to "28rpx", "height" to "28rpx", "marginRight" to "10rpx"), ".order-list .order-item .order-info .address-info .left-box .address-item " to utsMapOf("width" to "20rpx", "height" to "28rpx"), ".order-list .order-item .order-info .seat-info " to utsMapOf("width" to "34rpx", "height" to "28rpx", "marginTop" to "2rpx", "marginLeft" to "15rpx"), ".order-list .order-item .order-info .remark " to utsMapOf("width" to "26rpx", "height" to "26rpx", "marginTop" to "2rpx"), ".order-list .order-item-dx .order-info .header .left-box " to utsMapOf("width" to "28rpx", "height" to "28rpx", "marginRight" to "10rpx"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item " to utsMapOf("width" to "20rpx", "height" to "28rpx"), ".order-list .order-item-dx .order-info .seat-info " to utsMapOf("width" to "34rpx", "height" to "28rpx", "marginTop" to "2rpx", "marginLeft" to "15rpx"), ".order-list .order-item-dx .order-info .remark " to utsMapOf("width" to "26rpx", "height" to "26rpx", "marginTop" to "2rpx")), "num" to utsMapOf(".header-order-title " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#5E7BB7"), ".order-list .order-item .order-info .header .left-box " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#5E7BB7"), ".order-list .order-item .order-info .address-info .right-box " to utsMapOf("color" to "#D18124", "fontSize" to "40rpx"), ".order-list .order-item-dx .order-info .header .left-box " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#D09A5B"), ".order-list .order-item-dx .order-info .address-info .right-box " to utsMapOf("color" to "#D18124", "fontSize" to "40rpx")), "split" to utsMapOf(".header-order-title " to utsMapOf("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx"), ".order-list .order-item .order-info .header .left-box " to utsMapOf("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx"), ".order-list .order-item-dx .order-info .header .left-box " to utsMapOf("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx"), ".triping-panel .main-body .left-box " to utsMapOf("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx")), "more-menu" to utsMapOf(".order-list " to utsMapOf("borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "marginTop" to "10rpx", "marginRight" to "10rpx", "marginBottom" to "10rpx", "marginLeft" to "10rpx", "boxShadow" to "0rpx 0rpx 15rpx 0rpx rgba(89, 119, 177, 0.2)")), "order-item" to utsMapOf(".order-list " to utsMapOf("flex" to 1, "boxSizing" to "border-box", "marginTop" to 0, "marginRight" to "20rpx", "marginBottom" to 0, "marginLeft" to "20rpx", "position" to "relative")), "side-tag-box" to utsMapOf(".order-list .order-item " to utsMapOf("position" to "absolute", "left" to 0, "top" to "15rpx", "width" to "61rpx", "height" to "49rpx", "zIndex" to 2)), "img" to utsMapOf(".order-list .order-item .side-tag-box " to utsMapOf("width" to "100%", "height" to "100%")), "order-info" to utsMapOf(".order-list .order-item " to utsMapOf("backgroundColor" to "#FFFFFF", "boxShadow" to "0rpx 0rpx 10rpx 0rpx rgba(89, 119, 177, 0.2)", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "25rpx", "paddingRight" to "30rpx", "paddingBottom" to "25rpx", "paddingLeft" to "30rpx", "marginTop" to "5rpx", "marginRight" to "10rpx", "marginBottom" to "30rpx", "marginLeft" to "10rpx"), ".order-list .order-item-dx " to utsMapOf("backgroundColor" to "#FFFFFF", "boxShadow" to "0rpx 0rpx 10rpx 0rpx rgba(89, 119, 177, 0.2)", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "25rpx", "paddingRight" to "30rpx", "paddingBottom" to "25rpx", "paddingLeft" to "30rpx", "marginTop" to "5rpx", "marginRight" to "10rpx", "marginBottom" to "30rpx", "marginLeft" to "10rpx")), "left-box" to utsMapOf(".order-list .order-item .order-info .header " to utsMapOf("paddingLeft" to "35rpx"), ".order-list .order-item .order-info .address-info " to utsMapOf("width" to "80%"), ".order-list .order-item-dx .order-info .address-info " to utsMapOf("width" to "80%"), ".triping-panel .main-body " to utsMapOf("width" to "90%")), "right-box" to utsMapOf(".order-list .order-item .order-info .header " to utsMapOf("alignItems" to "center"), ".order-list .order-item-dx .order-info .header " to utsMapOf("alignItems" to "center"), ".order-list .order-item-dx .order-info .address-info " to utsMapOf("width" to "100rpx")), "more-btn" to utsMapOf(".order-list .order-item .order-info .header .right-box " to utsMapOf("fontSize" to "28rpx"), ".order-list .order-item-dx .order-info .header .right-box " to utsMapOf("fontSize" to "28rpx")), "border" to utsMapOf(".order-list .order-item .order-info " to utsMapOf("height" to "1rpx", "backgroundImage" to "none", "backgroundColor" to "#E6E7E9"), ".order-list .order-item-dx .order-info " to utsMapOf("height" to "1rpx", "backgroundImage" to "none", "backgroundColor" to "#E6E7E9")), "address-info" to utsMapOf(".order-list .order-item .order-info " to utsMapOf("paddingLeft" to "20rpx"), ".triping-panel .main-body .left-box " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#898989", "paddingBottom" to "10rpx")), "top" to utsMapOf(".order-list .order-item .order-info .address-info .left-box .address-item " to utsMapOf("alignItems" to "center"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item " to utsMapOf("alignItems" to "center")), "label" to utsMapOf(".order-list .order-item .order-info .address-info .left-box .address-item .top " to utsMapOf("paddingLeft" to "10rpx", "fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000"), ".order-list .order-item .order-info .seat-info " to utsMapOf("fontSize" to "26rpx", "color" to "#898989"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item .top " to utsMapOf("paddingLeft" to "10rpx", "fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000"), ".order-list .order-item-dx .order-info .seat-info " to utsMapOf("fontSize" to "26rpx", "color" to "#898989")), "bottom" to utsMapOf(".order-list .order-item .order-info .address-info .left-box .address-item " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#898989", "marginLeft" to "10rpx", "marginBottom" to "3rpx", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "22rpx", "paddingLeft" to "20rpx"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#898989", "marginLeft" to "10rpx", "marginBottom" to "3rpx", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "22rpx", "paddingLeft" to "20rpx")), "seat-info" to utsMapOf(".order-list .order-item .order-info " to utsMapOf("flexDirection" to "row", "paddingBottom" to "20rpx"), ".order-list .order-item-dx .order-info " to utsMapOf("flexDirection" to "row", "paddingBottom" to "20rpx")), "value" to utsMapOf(".order-list .order-item .order-info .seat-info " to utsMapOf("fontSize" to "26rpx", "color" to "#4D679B"), ".order-list .order-item-dx .order-info .seat-info " to utsMapOf("fontSize" to "26rpx", "color" to "#4D679B")), "remark" to utsMapOf(".order-list .order-item .order-info " to utsMapOf("backgroundImage" to "none", "backgroundColor" to "#FDF7F0", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "12rpx", "paddingRight" to "12rpx", "paddingBottom" to "12rpx", "paddingLeft" to "12rpx", "boxSizing" to "border-box"), ".order-list .order-item-dx .order-info " to utsMapOf("backgroundImage" to "none", "backgroundColor" to "#FDF7F0", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "12rpx", "paddingRight" to "12rpx", "paddingBottom" to "12rpx", "paddingLeft" to "12rpx", "boxSizing" to "border-box")), "btn-group" to utsMapOf(".order-list .order-item .order-info " to utsMapOf("paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0), ".order-list .order-item-dx .order-info " to utsMapOf("paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0), "" to utsMapOf("paddingTop" to "30rpx", "paddingRight" to 0, "paddingBottom" to "30rpx", "paddingLeft" to 0)), "order-item-dx" to utsMapOf(".order-list " to utsMapOf("boxSizing" to "border-box", "marginTop" to "20rpx", "marginRight" to "20rpx", "marginBottom" to 0, "marginLeft" to "20rpx", "position" to "relative")), "triping-panel" to padStyleMapOf(utsMapOf("borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "0rpx", "borderBottomLeftRadius" to "0rpx", "boxSizing" to "border-box", "boxShadow" to "0rpx 0rpx 8rpx 0rpx rgba(89, 119, 177, 0.5)", "position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "#ffffff")), "current-step" to utsMapOf(".triping-panel .header " to utsMapOf("fontSize" to "34rpx", "color" to "#000000")), "main-body" to utsMapOf(".triping-panel " to utsMapOf("paddingTop" to 0, "paddingRight" to "45rpx", "paddingBottom" to "25rpx", "paddingLeft" to "45rpx")), "call-phone" to utsMapOf(".triping-panel .main-body " to utsMapOf("width" to "50rpx", "height" to "50rpx")), "footer" to utsMapOf(".triping-panel " to utsMapOf("paddingTop" to 0, "paddingRight" to "40rpx", "paddingBottom" to "20rpx", "paddingLeft" to "40rpx")), "ai-desc-title" to padStyleMapOf(utsMapOf("textAlign" to "center", "width" to "100%", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "@TRANSITION" to utsMapOf("content-panel" to utsMapOf("property" to "transform", "duration" to "0.5s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf("globalData" to utsMapOf("type" to "Object"))
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
