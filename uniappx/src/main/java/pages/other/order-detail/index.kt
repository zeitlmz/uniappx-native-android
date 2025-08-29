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
import uts.sdk.modules.mcAmapNav.LocationResult
import uts.sdk.modules.mcAmapNav.MapOption
import uts.sdk.modules.mcAmapNav.SingleLocationOptions
import uts.sdk.modules.mcAmapNav.SuccessCallback
import uts.sdk.modules.mcAmapNav.AmapNavOption
import uts.sdk.modules.mcAmapNav.MarkerOption
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xToastS.XTOAST_TYPE
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import uts.sdk.modules.mcAmapNav.initKey
import uts.sdk.modules.mcAmapNav.checkLocationPermission
import io.dcloud.uniapp.extapi.makePhoneCall as uni_makePhoneCall
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.reLaunch as uni_reLaunch
import uts.sdk.modules.xModalS.showModal
import uts.sdk.modules.xToastS.showToast as showXToast
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
import uts.sdk.modules.xVibrateS.vibrator
open class GenPagesOtherOrderDetailIndex : BasePage {
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
        onPageShow(fun() {
            this.initEvt()
            if (!this.isFrist) {
                this.isFrist = false
                this.queryOrderDetail(true, this.orderParams["orderStatus"] != "0")
            }
        }
        , __ins)
        onReady(fun() {
            this.queryOrderDetail(true, this.orderParams["orderStatus"] != "0")
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
                this.queryOrderDetail(canCalcRoute, canCalcRoute)
            }
            )
            uni__on("showModalTip", fun(text: String){
                this.showModalTip(text)
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
            uni__off("showModalTip", null)
            ws1?.off(MessageType["ARRIVED_TRIP"] as Number)
            ws1?.off(MessageType["OPEN_TRIP"] as Number)
            ws1?.off(MessageType["ORDER_FINISH"] as Number)
            ws1?.off(MessageType["ORDER_ADD"] as Number)
            ws1?.off(MessageType["BIG_ORDER_FINISH"] as Number)
            ws1?.off(MessageType["ORDER_SORT"] as Number)
            ws1?.off(MessageType["ORDER_CANCEL"] as Number)
            ws1?.off(MessageType["BEFORE_CHECK"] as Number)
            ws1?.off(MessageType["ORDER_FINISH"] as Number)
            ws1?.off(MessageType["VALID_PHONE"] as Number)
            hideXloading()
        }
        , __ins)
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
        val _component_mc_amap = resolveEasyComponent("mc-amap", GenComponentsMcAmapIndexClass)
        val _component_x_switch = resolveEasyComponent("x-switch", GenUniModulesTmxUiComponentsXSwitchXSwitchClass)
        val _component_mc_active_animation = resolveEasyComponent("mc-active-animation", GenComponentsMcActiveAnimationIndexClass)
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        val _component_x_cell = resolveEasyComponent("x-cell", GenUniModulesTmxUiComponentsXCellXCellClass)
        val _component_x_popover = resolveEasyComponent("x-popover", GenUniModulesTmxUiComponentsXPopoverXPopoverClass)
        val _component_mc_pain_button = resolveEasyComponent("mc-pain-button", GenComponentsMcPainButtonIndexClass)
        val _component_x_drag_item_mc = resolveEasyComponent("x-drag-item-mc", GenUniModulesTmxUiComponentsXDragItemMcXDragItemMcClass)
        val _component_x_drag_mc = resolveEasyComponent("x-drag-mc", GenUniModulesTmxUiComponentsXDragMcXDragMcClass)
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
        return _cE(Fragment, null, _uA(
            _cV(_component_mc_amap, _uM("self-location" to true, "ref" to "mapView", "style" to _nS("margin-top: " + (_ctx.statusBarHeight + 50) + "px;height: " + _ctx.mapContentHeight + "px;"), "onNaviInfoUpdate" to _ctx.naviInfoUpdate, "onCalcSuccess" to _ctx.calcRouteSuccess, "onArrived" to _ctx.arriveDestination), _uM("bottom" to withSlotCtx(fun(): UTSArray<Any> {
                return _uA(
                    _cE("view", _uM("class" to "flex-row flex-row-center-between"), _uA(
                        _cE("view", _uM("class" to "flex-row flex-row-center-between pl-15 pt-15"), _uA(
                            if (_ctx.orderData.driverStatus == 0) {
                                _cV(_component_mc_primary_button, _uM("key" to 0, "onClick" to _ctx.openTrip, "height" to "57rpx", "bgColor" to "#ffffff", "icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-books-2.png"), "color" to "#000000", "margin-right" to "20rpx"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        " 开启行程 "
                                    )
                                }), "_" to 1), 8, _uA(
                                    "onClick",
                                    "icon-path"
                                ))
                            } else {
                                if (_ctx.orderData.driverStatus == 3) {
                                    _cV(_component_mc_primary_button, _uM("key" to 1, "onClick" to _ctx.closeTrip, "height" to "57rpx", "bgColor" to "#ffffff", "icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-stop-trip-outline.png"), "color" to "#000000", "margin-right" to "20rpx"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            " 暂停行程 "
                                        )
                                    }), "_" to 1), 8, _uA(
                                        "onClick",
                                        "icon-path"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            }
                        )),
                        _cE("view", _uM("class" to "flex-row flex-row-center-between pt-10 pr-15"), _uA(
                            _cV(_component_mc_primary_button, _uM("height" to "57rpx", "onClick" to _ctx.initLocation, "bgColor" to "#ffffff", "icon-size" to "35rpx", "icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-my-location-outline.png"), "color" to "#000000"), null, 8, _uA(
                                "onClick",
                                "icon-path"
                            ))
                        ))
                    )),
                    withDirectives(_cE("view", _uM("class" to "route-love"), _uA(
                        _cE("image", _uM("class" to "bg-img", "style" to _nS("width:" + (_ctx.screenWidth + 10) + "px"), "src" to ("" + _ctx.resBaseUrl + "/static/images/route-loves-bg.png")), null, 12, _uA(
                            "src"
                        )),
                        _cE("text", _uM("class" to "title"), "路线偏好:"),
                        _cE("view", _uM("class" to "radio-card-group"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(_ctx.routeStrategyOptions.slice(0, 2), fun(item, __key, __index, _cached): Any {
                                return _cE("text", _uM("key" to item.code, "onClick" to fun(){
                                    _ctx.routeLoveClick(item)
                                }
                                , "class" to "radio-card mr-7", "style" to _nS("" + (if (_ctx.routeStrategy == item.code) {
                                    "font-weight: bold;color: " + _ctx.globalData.theme.primaryColor + ";"
                                } else {
                                    ""
                                }
                                ))), _tD(item.name), 13, _uA(
                                    "onClick"
                                ))
                            }
                            ), 128)
                        )),
                        _cE("view", _uM("class" to "radio-card-group"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(_ctx.routeStrategyOptions.slice(2, 4), fun(item, __key, __index, _cached): Any {
                                return _cE("text", _uM("key" to item.code, "onClick" to fun(){
                                    _ctx.routeLoveClick(item)
                                }
                                , "class" to "radio-card mr-7", "style" to _nS("" + (if (_ctx.routeStrategy == item.code) {
                                    "font-weight: bold;color: " + _ctx.globalData.theme.primaryColor + ";"
                                } else {
                                    ""
                                }
                                ))), _tD(item.name), 13, _uA(
                                    "onClick"
                                ))
                            }
                            ), 128)
                        ))
                    ), 512), _uA(
                        _uA(
                            vShow,
                            _ctx.showRouteStrategyOptions
                        )
                    )),
                    withDirectives(_cE("view", _uM("style" to _nS(_uM("height" to "24rpx"))), null, 4), _uA(
                        _uA(
                            vShow,
                            !_ctx.showRouteStrategyOptions
                        )
                    ))
                )
            }
            ), "_" to 1), 8, _uA(
                "style",
                "onNaviInfoUpdate",
                "onCalcSuccess",
                "onArrived"
            )),
            _cV(_component_mc_base_container, _uM("title" to "订单详情", "bg-color" to "#ffffff", "scroll" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                return _uA(
                    _cE("view", _uM("class" to "content-panel", "onTransitionend" to _ctx.onTransitionend, "ref" to "contentPanel", "style" to _nS("transform: translateY(" + _ctx.transformHeight + "px);height: " + _ctx.cardHeight + "px;bottom:" + (_ctx.globalData.safeAreaBottom + 80) + "px;background: " + (if (_ctx.showOrderList) {
                        "#F5F7FA;"
                    } else {
                        "#ffffff"
                    }
                    ))), _uA(
                        withDirectives(_cE("view", _uM("class" to "flex-row-center-between", "onClick" to _ctx.viewOrders, "style" to _nS("height:40rpx;margin-bottom: 20rpx;background-color: " + _ctx.globalData.theme.primaryLinearColors[0] + ";")), _uA(
                            _cE("image", _uM("style" to _nS(_uM("height" to "27rpx", "width" to "27rpx", "margin-top" to "6rpx")), "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-tow-arrow-down-outline.png"), "mode" to "widthFix"), null, 12, _uA(
                                "src"
                            ))
                        ), 12, _uA(
                            "onClick"
                        )), _uA(
                            _uA(
                                vShow,
                                _ctx.showOrderList
                            )
                        )),
                        withDirectives(_cE("view", _uM("style" to _nS(_uM("height" to "34rpx"))), null, 4), _uA(
                            _uA(
                                vShow,
                                !_ctx.showOrderList
                            )
                        )),
                        _cE("view", _uM("class" to "planning-header"), _uA(
                            withDirectives(_cE("view", _uM("class" to "header-order-title"), _uA(
                                if (_ctx.routes.length > 0) {
                                    _cE("image", _uM("key" to 0, "class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-road-guid.png"), "mode" to "widthFix"), null, 8, _uA(
                                        "src"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (_ctx.routes.length > 0) {
                                    _cE("view", _uM("key" to 1, "class" to "flex-row"), _uA(
                                        _cE("text", _uM("class" to "text"), "距我"),
                                        _cE("text", _uM("class" to "num"), _tD(_ctx.selectedRoute.distance), 1),
                                        _cE("text", _uM("class" to "split"), "|"),
                                        _cE("text", _uM("class" to "text"), "预计"),
                                        _cE("text", _uM("class" to "num"), _tD(_ctx.selectedRoute.time), 1)
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ), 512), _uA(
                                _uA(
                                    vShow,
                                    _ctx.showOrderList
                                )
                            )),
                            withDirectives(_cE("view", _uM("class" to "planning-title"), _uA(
                                _cE("image", _uM("onClick" to fun(){
                                    _ctx.showAiDescModal = true
                                }
                                , "class" to "planning-icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-tips-outline-small.png")), null, 8, _uA(
                                    "onClick",
                                    "src"
                                )),
                                _cE("text", _uM("onClick" to fun(){
                                    _ctx.showAiDescModal = true
                                }
                                , "class" to "text"), "智能规划", 8, _uA(
                                    "onClick"
                                )),
                                _cV(_component_x_switch, _uM("modelValue" to _ctx.isSmartPlanning, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                    _ctx.isSmartPlanning = `$event`
                                }
                                , "disabled" to (_ctx.orderData.orderCount <= 2), "size" to "small", "onChange" to _ctx.onPlanningChange, "color" to "#D1B27A"), null, 8, _uA(
                                    "modelValue",
                                    "onUpdate:modelValue",
                                    "disabled",
                                    "onChange"
                                ))
                            ), 512), _uA(
                                _uA(
                                    vShow,
                                    (!_ctx.showOrderList && !_ctx.isDx) || !_ctx.isDx
                                )
                            )),
                            if (isTrue(!_ctx.showOrderList && _ctx.isDx)) {
                                _cE("view", _uM("key" to 0, "class" to "planning-title"), _uA(
                                    _cE("image", _uM("class" to "planning-icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-road-guid-2.png"), "mode" to "widthFix"), null, 8, _uA(
                                        "src"
                                    )),
                                    _cE("text", _uM("class" to "text"), "独享")
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            withDirectives(_cV(_component_mc_active_animation, _uM("class" to "sort-btn", "onClick" to _ctx.routeLoveBtnClick), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("text", _uM("class" to "text"), _tD(_ctx.routeStrategyStr), 1),
                                    _cE("image", _uM("class" to "sort-icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-transform-white-filled.png"), "mode" to "widthFix"), null, 8, _uA(
                                        "src"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "onClick"
                            )), _uA(
                                _uA(
                                    vShow,
                                    (_ctx.showOrderList && _ctx.isDx) || !_ctx.showOrderList
                                )
                            ))
                        )),
                        withDirectives(_cE("view", _uM("class" to "routes-container", "style" to _nS("background-image: linear-gradient(to bottom, " + _ctx.globalData.theme.painColor + ", #ffffff);")), _uA(
                            if (_ctx.routes.length <= 0) {
                                _cE("view", _uM("key" to 0, "class" to "flex-row flex-row-center-center", "style" to _nS(_uM("height" to "200rpx", "color" to "#cccccc"))), _uA(
                                    _cE("text", _uM("style" to _nS(_uM("text-align" to "center"))), "暂无路线规划", 4)
                                ), 4)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cE(Fragment, null, RenderHelpers.renderList(_ctx.routes, fun(route, index, __index, _cached): Any {
                                return _cV(_component_mc_active_animation, _uM("key" to index, "class" to "route-card", "style" to _nS("" + (if (_ctx.selectedRoute.routeId === route.routeId) {
                                    ("background-image: linear-gradient(to bottom, " + _ctx.globalData.theme.primaryLinearColors.join(", ") + ");")
                                } else {
                                    ""
                                }
                                )), "onClick" to fun(){
                                    _ctx.selectRoute(route)
                                }
                                ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", _uM("class" to "header"), _uA(
                                            _cE("text", _uM("class" to "route-title", "style" to _nS("" + (if (_ctx.selectedRoute.routeId === route.routeId) {
                                                "color: #ffffff;"
                                            } else {
                                                ""
                                            }
                                            ))), "线路" + _tD(index + 1), 5),
                                            _cE("view", _uM("class" to "traffic-light"), _uA(
                                                _cE("image", _uM("class" to "light-icon", "src" to if (_ctx.selectedRoute.routeId === route.routeId) {
                                                    "" + _ctx.resBaseUrl + "/static/icons/icon-traffic-white-outline-small.png"
                                                } else {
                                                    "" + _ctx.resBaseUrl + "/static/icons/icon-traffic-black-outline-small.png"
                                                }
                                                ), null, 8, _uA(
                                                    "src"
                                                )),
                                                _cE("text", _uM("class" to "text", "style" to _nS("" + (if (_ctx.selectedRoute.routeId === route.routeId) {
                                                    "color: #ffffff;"
                                                } else {
                                                    ""
                                                }
                                                ))), _tD(route.lights), 5)
                                            ))
                                        )),
                                        _cE("text", _uM("class" to "route-time", "style" to _nS("" + (if (_ctx.selectedRoute.routeId === route.routeId) {
                                            "color: #ffffff;"
                                        } else {
                                            ""
                                        }
                                        ))), _tD(route.time), 5),
                                        _cE("text", _uM("class" to "route-distance", "style" to _nS("" + (if (_ctx.selectedRoute.routeId === route.routeId) {
                                            "color: #ffffff;"
                                        } else {
                                            ""
                                        }
                                        ))), _tD(route.distance), 5)
                                    )
                                }
                                ), "_" to 2), 1032, _uA(
                                    "style",
                                    "onClick"
                                ))
                            }
                            ), 128)
                        ), 4), _uA(
                            _uA(
                                vShow,
                                !_ctx.showOrderList
                            )
                        )),
                        if (isTrue(_ctx.showOrderList && _ctx.isDx)) {
                            _cE("view", _uM("key" to 0, "class" to "order-list"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(_ctx.orderData.orderItems, fun(item, index, __index, _cached): Any {
                                    return _cE("view", _uM("class" to "order-item-dx", "key" to item.planId), _uA(
                                        _cE("view", _uM("class" to "order-info", "style" to _nS("border: 4rpx solid " + _ctx.globalData.theme.primaryColor + ";background-image: linear-gradient(to bottom, " + _ctx.globalData.theme.painColor + ", #ffffff, #ffffff, #ffffff);")), _uA(
                                            _cE("view", _uM("class" to "header flex-row flex-row-center-between"), _uA(
                                                _cE("view", _uM("class" to "left-box flex-row"), _uA(
                                                    _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-road-guid-2.png"), "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    )),
                                                    _cE("text", _uM("class" to "text"), "独享")
                                                )),
                                                _cV(_component_x_popover, _uM("position" to "br"), _uM("menu" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cE("view", _uM("class" to "more-menu"), _uA(
                                                            _cV(_component_x_cell, _uM("onClick" to fun(){
                                                                _ctx.cancelOrder(item.orderId, item.sortNum)
                                                            }, "show-bottom-border" to false, "card" to false, "titleColor" to if (_ctx.serviceConfig.allowDriverCancelOrder) {
                                                                "red"
                                                            } else {
                                                                "#999999"
                                                            }, "title" to "取消订单"), null, 8, _uA(
                                                                "onClick",
                                                                "titleColor"
                                                            ))
                                                        ))
                                                    )
                                                }), "default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cE("view", _uM("class" to "right-box flex-row"), _uA(
                                                            _cE("text", _uM("class" to "more-btn"), "更多"),
                                                            _cV(_component_x_icon, _uM("name" to "more-2-line"))
                                                        ))
                                                    )
                                                }), "_" to 2), 1024)
                                            )),
                                            _cE("view", _uM("class" to "border")),
                                            _cE("view", _uM("class" to "address-info flex-row flex-row-center-between"), _uA(
                                                _cE("view", _uM("class" to "left-box"), _uA(
                                                    _cE("view", _uM("class" to "address-item"), _uA(
                                                        _cE("view", _uM("class" to "top flex-row", "style" to _nS(_uM("padding-top" to "20rpx"))), _uA(
                                                            _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-location-start.png"), "mode" to ""), null, 8, _uA(
                                                                "src"
                                                            )),
                                                            _cE("text", _uM("class" to "label"), _tD(item.startCity + "-" + item.startDistrict), 1)
                                                        ), 4),
                                                        _cE("text", _uM("class" to "bottom", "style" to _nS("border-left: 1rpx solid " + _ctx.globalData.theme.primaryColor + ";")), _tD(item.startAddress), 5)
                                                    )),
                                                    _cE("view", _uM("class" to "address-item"), _uA(
                                                        _cE("view", _uM("class" to "top flex-row"), _uA(
                                                            _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-location-end.png"), "mode" to ""), null, 8, _uA(
                                                                "src"
                                                            )),
                                                            _cE("text", _uM("class" to "label"), _tD(item.endCity + "-" + item.endDistrict), 1)
                                                        )),
                                                        _cE("text", _uM("class" to "bottom"), _tD(item.endAddress), 1)
                                                    ))
                                                )),
                                                _cE("view", _uM("class" to "right-box flex-row flex-row-center-center"), _uA(
                                                    _cE("text", _uM("class" to "num"), _tD(item.passengerNum), 1),
                                                    _cE("text", _uM("class" to "label"), "人")
                                                ))
                                            )),
                                            _cE("view", _uM("class" to "remark flex-row"), _uA(
                                                _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-info-outline-small-2.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                )),
                                                _cE("text", _uM("class" to "text"), "备注：" + _tD(item.remark ?: "-"), 1)
                                            )),
                                            _cE("view", _uM("class" to "btn-group flex-row"), _uA(
                                                _cV(_component_mc_pain_button, _uM("margin-right" to "26rpx", "onClick" to fun(){
                                                    _ctx.callPhone(item.phoneNumber)
                                                }, "icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-call-phone-outline.png")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        "联系乘客"
                                                    )
                                                }), "_" to 2), 1032, _uA(
                                                    "onClick",
                                                    "icon-path"
                                                )),
                                                if (item.waitingStatus == 0) {
                                                    _cV(_component_mc_primary_button, _uM("key" to 0, "onClick" to fun(){
                                                        _ctx.tryArrived(item.orderId, item.sortNum)
                                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            "到达上车点"
                                                        )
                                                    }), "_" to 2), 1032, _uA(
                                                        "onClick"
                                                    ))
                                                } else {
                                                    if (isTrue(_ctx.orderParams["orderStatus"] != "0" && item.status < 3)) {
                                                        _cV(_component_mc_primary_button, _uM("key" to 1, "onClick" to fun(){
                                                            _ctx.passengerPickUp(item.orderId, item.sortNum, index)
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "乘客上车"
                                                            )
                                                        }), "_" to 2), 1032, _uA(
                                                            "onClick"
                                                        ))
                                                    } else {
                                                        if (item.status == 3) {
                                                            _cV(_component_mc_primary_button, _uM("key" to 2, "onClick" to fun(){
                                                                _ctx.validOrder(item.orderId, item.sortNum)
                                                            }, "linear-colors" to _uA(
                                                                "#44C791",
                                                                "#28D07F"
                                                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    "完成订单"
                                                                )
                                                            }), "_" to 2), 1032, _uA(
                                                                "onClick"
                                                            ))
                                                        } else {
                                                            if (item.status == 4) {
                                                                _cV(_component_mc_primary_button, _uM("key" to 3, "linear-colors" to _uA(
                                                                    "#44C791",
                                                                    "#28D07F"
                                                                )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                    return _uA(
                                                                        "已完成"
                                                                    )
                                                                }), "_" to 1))
                                                            } else {
                                                                _cC("v-if", true)
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
                                _cV(_component_x_pull_refresh, _uM("key" to 1, "height" to (_ctx.pullViewHeight + "px"), "class" to "order-list", "disabled-bottom" to true, "disabled-pull" to true, "show-scrollbar" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        if (_ctx.sortList.length > 0) {
                                            _cV(_component_x_drag_mc, _uM("key" to 0, "onChange" to _ctx.onDragSortchange, "list" to _ctx.sortList), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE(Fragment, null, RenderHelpers.renderList(_ctx.orderData.orderItems, fun(item, index, __index, _cached): Any {
                                                        return _cV(_component_x_drag_item_mc, _uM("key" to item.orderId, "order" to index), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                if (isTrue(!_ctx.isSmartPlanning && _ctx.sortList.length > 1)) {
                                                                    _cE("view", _uM("key" to 0, "class" to "order-item"), _uA(
                                                                        _cE("view", _uM("class" to "side-tag-box"), _uA(
                                                                            _cE("image", _uM("class" to "img", "src" to ("" + _ctx.resBaseUrl + "/static/images/box-side-tag.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                                "src"
                                                                            )),
                                                                            _cE("text", _uM("class" to "text"), _tD((index + 1).toString(10).padStart(2, "0")), 1)
                                                                        )),
                                                                        _cE("view", _uM("class" to "order-info", "style" to _nS("border: 4rpx solid #" + item.color + ";")), _uA(
                                                                            _cE("view", _uM("class" to "header flex-row flex-row-center-between"), _uA(
                                                                                _cE("view", _uM("class" to "left-box flex-row"), _uA(
                                                                                    _cE("text", _uM("class" to "text", "style" to _nS("color: #" + item.color + ";")), _tD(item.sortNum) + "号订单：", 5),
                                                                                    _cE("text", _uM("class" to "num"), _tD(item.orderId), 1)
                                                                                )),
                                                                                _cV(_component_x_popover, _uM("position" to "br"), _uM("menu" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return _uA(
                                                                                        _cE("view", _uM("class" to "more-menu"), _uA(
                                                                                            _cV(_component_x_cell, _uM("onClick" to fun(){
                                                                                                _ctx.cancelOrder(item.orderId, item.sortNum)
                                                                                            }, "show-bottom-border" to false, "card" to false, "titleColor" to if (_ctx.serviceConfig.allowDriverCancelOrder) {
                                                                                                "red"
                                                                                            } else {
                                                                                                "#999999"
                                                                                            }, "title" to "取消订单"), null, 8, _uA(
                                                                                                "onClick",
                                                                                                "titleColor"
                                                                                            ))
                                                                                        ))
                                                                                    )
                                                                                }), "default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return _uA(
                                                                                        _cE("view", _uM("class" to "right-box flex-row"), _uA(
                                                                                            _cE("text", _uM("class" to "more-btn"), "更多"),
                                                                                            _cV(_component_x_icon, _uM("name" to "more-2-line"))
                                                                                        ))
                                                                                    )
                                                                                }), "_" to 2), 1024)
                                                                            )),
                                                                            _cE("view", _uM("class" to "address-info flex-row flex-row-center-between"), _uA(
                                                                                _cE("view", _uM("class" to "left-box"), _uA(
                                                                                    _cE("view", _uM("class" to "address-item"), _uA(
                                                                                        _cE("view", _uM("class" to "top flex-row"), _uA(
                                                                                            _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-location-start.png"), "mode" to ""), null, 8, _uA(
                                                                                                "src"
                                                                                            )),
                                                                                            _cE("text", _uM("class" to "label"), _tD(item.startCity + "-" + item.startDistrict), 1)
                                                                                        )),
                                                                                        _cE("text", _uM("class" to "bottom", "style" to _nS("border-left: 1rpx solid " + _ctx.globalData.theme.primaryColor + ";")), _tD(item.startAddress), 5)
                                                                                    )),
                                                                                    _cE("view", _uM("class" to "address-item"), _uA(
                                                                                        _cE("view", _uM("class" to "top flex-row"), _uA(
                                                                                            _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-location-end.png"), "mode" to ""), null, 8, _uA(
                                                                                                "src"
                                                                                            )),
                                                                                            _cE("text", _uM("class" to "label"), _tD(item.endCity + "-" + item.endDistrict), 1)
                                                                                        )),
                                                                                        _cE("text", _uM("class" to "bottom"), _tD(item.endAddress), 1)
                                                                                    ))
                                                                                )),
                                                                                _cE("view", _uM("class" to "right-box flex-row flex-row-center-center"), _uA(
                                                                                    _cE("text", _uM("class" to "num"), _tD(item.passengerNum), 1),
                                                                                    _cE("text", _uM("class" to "label"), "人")
                                                                                ))
                                                                            )),
                                                                            _cE("view", _uM("class" to "seat-info"), _uA(
                                                                                _cE("text", _uM("class" to "label"), "座位信息："),
                                                                                _cE("text", _uM("class" to "value"), _tD(item.chooseSeat?.map(fun(seat, index, _arr): String {
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
                                                                                    _cE("image", _uM("key" to 0, "onClick" to fun(){
                                                                                        _ctx.viewSeat(item)
                                                                                    }, "class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-seat-view-filled.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                                        "onClick",
                                                                                        "src"
                                                                                    ))
                                                                                } else {
                                                                                    _cC("v-if", true)
                                                                                }
                                                                            )),
                                                                            _cE("view", _uM("class" to "remark flex-row"), _uA(
                                                                                _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-info-outline-small-2.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                                    "src"
                                                                                )),
                                                                                _cE("text", _uM("class" to "text"), "备注：" + _tD(item.remark), 1)
                                                                            )),
                                                                            _cE("view", _uM("class" to "btn-group flex-row"), _uA(
                                                                                _cV(_component_mc_pain_button, _uM("margin-right" to "26rpx", "onClick" to fun(){
                                                                                    _ctx.callPhone(item.phoneNumber)
                                                                                }, "icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-call-phone-outline.png")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return _uA(
                                                                                        "联系乘客"
                                                                                    )
                                                                                }), "_" to 2), 1032, _uA(
                                                                                    "onClick",
                                                                                    "icon-path"
                                                                                )),
                                                                                if (isTrue(_ctx.orderParams["orderStatus"] != "0" && item.waitingStatus == 0)) {
                                                                                    _cV(_component_mc_primary_button, _uM("key" to 0, "onClick" to fun(){
                                                                                        _ctx.tryArrived(item.orderId, item.sortNum)
                                                                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                        return _uA(
                                                                                            "到达上车点"
                                                                                        )
                                                                                    }), "_" to 2), 1032, _uA(
                                                                                        "onClick"
                                                                                    ))
                                                                                } else {
                                                                                    if (isTrue(_ctx.orderParams["orderStatus"] != "0" && item.status < 3)) {
                                                                                        _cV(_component_mc_primary_button, _uM("key" to 1, "onClick" to fun(){
                                                                                            _ctx.passengerPickUp(item.orderId, item.sortNum, index)
                                                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                            return _uA(
                                                                                                "乘客上车"
                                                                                            )
                                                                                        }), "_" to 2), 1032, _uA(
                                                                                            "onClick"
                                                                                        ))
                                                                                    } else {
                                                                                        if (isTrue(item.status == 3 && _ctx.isSendMode)) {
                                                                                            _cV(_component_mc_primary_button, _uM("key" to 2, "onClick" to fun(){
                                                                                                _ctx.validOrder(item.orderId, item.sortNum)
                                                                                            }, "linear-colors" to _uA(
                                                                                                "#44C791",
                                                                                                "#28D07F"
                                                                                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                                return _uA(
                                                                                                    "完成订单"
                                                                                                )
                                                                                            }), "_" to 2), 1032, _uA(
                                                                                                "onClick"
                                                                                            ))
                                                                                        } else {
                                                                                            if (isTrue(item.status == 4 && _ctx.isSendMode)) {
                                                                                                _cV(_component_mc_primary_button, _uM("key" to 3, "linear-colors" to _uA(
                                                                                                    "#44C791",
                                                                                                    "#28D07F"
                                                                                                )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                                    return _uA(
                                                                                                        "已完成"
                                                                                                    )
                                                                                                }), "_" to 1))
                                                                                            } else {
                                                                                                _cC("v-if", true)
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            ))
                                                                        ), 4)
                                                                    ))
                                                                } else {
                                                                    _cE("view", _uM("key" to 1, "class" to "order-item", "onLongpress" to withModifiers(_ctx.longpressStop, _uA(
                                                                        "stop"
                                                                    ))), _uA(
                                                                        _cE("view", _uM("class" to "side-tag-box"), _uA(
                                                                            _cE("image", _uM("class" to "img", "src" to ("" + _ctx.resBaseUrl + "/static/images/box-side-tag.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                                "src"
                                                                            )),
                                                                            _cE("text", _uM("class" to "text"), _tD((index + 1).toString(10).padStart(2, "0")), 1)
                                                                        )),
                                                                        _cE("view", _uM("class" to "order-info", "style" to _nS("border: 4rpx solid #" + item.color + ";")), _uA(
                                                                            _cE("view", _uM("class" to "header flex-row flex-row-center-between"), _uA(
                                                                                _cE("view", _uM("class" to "left-box flex-row"), _uA(
                                                                                    _cE("text", _uM("class" to "text", "style" to _nS("color: #" + item.color + ";")), _tD(item.sortNum) + "号订单：", 5),
                                                                                    _cE("text", _uM("class" to "num"), _tD(item.orderId), 1)
                                                                                )),
                                                                                _cV(_component_x_popover, _uM("position" to "br"), _uM("menu" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return _uA(
                                                                                        _cE("view", _uM("class" to "more-menu"), _uA(
                                                                                            _cV(_component_x_cell, _uM("onClick" to fun(){
                                                                                                _ctx.cancelOrder(item.orderId, item.sortNum)
                                                                                            }, "show-bottom-border" to false, "card" to false, "titleColor" to if (_ctx.serviceConfig.allowDriverCancelOrder) {
                                                                                                "red"
                                                                                            } else {
                                                                                                "#999999"
                                                                                            }, "title" to "取消订单"), null, 8, _uA(
                                                                                                "onClick",
                                                                                                "titleColor"
                                                                                            ))
                                                                                        ))
                                                                                    )
                                                                                }), "default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return _uA(
                                                                                        _cE("view", _uM("class" to "right-box flex-row"), _uA(
                                                                                            _cE("text", _uM("class" to "more-btn"), "更多"),
                                                                                            _cV(_component_x_icon, _uM("name" to "more-2-line"))
                                                                                        ))
                                                                                    )
                                                                                }), "_" to 2), 1024)
                                                                            )),
                                                                            _cE("view", _uM("class" to "address-info flex-row flex-row-center-between"), _uA(
                                                                                _cE("view", _uM("class" to "left-box"), _uA(
                                                                                    _cE("view", _uM("class" to "address-item"), _uA(
                                                                                        _cE("view", _uM("class" to "top flex-row"), _uA(
                                                                                            _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-location-start.png"), "mode" to ""), null, 8, _uA(
                                                                                                "src"
                                                                                            )),
                                                                                            _cE("text", _uM("class" to "label"), _tD(item.startCity + "-" + item.startDistrict), 1)
                                                                                        )),
                                                                                        _cE("text", _uM("class" to "bottom", "style" to _nS("border-left: 1rpx solid " + _ctx.globalData.theme.primaryColor + ";")), _tD(item.startAddress), 5)
                                                                                    )),
                                                                                    _cE("view", _uM("class" to "address-item"), _uA(
                                                                                        _cE("view", _uM("class" to "top flex-row"), _uA(
                                                                                            _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-location-end.png"), "mode" to ""), null, 8, _uA(
                                                                                                "src"
                                                                                            )),
                                                                                            _cE("text", _uM("class" to "label"), _tD(item.endCity + "-" + item.endDistrict), 1)
                                                                                        )),
                                                                                        _cE("text", _uM("class" to "bottom"), _tD(item.endAddress), 1)
                                                                                    ))
                                                                                )),
                                                                                _cE("view", _uM("class" to "right-box flex-row flex-row-center-center"), _uA(
                                                                                    _cE("text", _uM("class" to "num"), _tD(item.passengerNum), 1),
                                                                                    _cE("text", _uM("class" to "label"), "人")
                                                                                ))
                                                                            )),
                                                                            _cE("view", _uM("class" to "seat-info", "onClick" to fun(){
                                                                                _ctx.viewSeat(item)
                                                                            }), _uA(
                                                                                _cE("text", _uM("class" to "label"), "座位信息："),
                                                                                _cE("text", _uM("class" to "value"), _tD(item.chooseSeat?.map(fun(seat, index, _arr): String {
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
                                                                                _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-seat-view-filled.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                                    "src"
                                                                                ))
                                                                            ), 8, _uA(
                                                                                "onClick"
                                                                            )),
                                                                            _cE("view", _uM("class" to "remark flex-row"), _uA(
                                                                                _cE("image", _uM("class" to "icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-info-outline-small-2.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                                    "src"
                                                                                )),
                                                                                _cE("text", _uM("class" to "text"), "备注：" + _tD(item.remark), 1)
                                                                            )),
                                                                            _cE("view", _uM("class" to "btn-group flex-row"), _uA(
                                                                                _cV(_component_mc_pain_button, _uM("margin-right" to "26rpx", "onClick" to fun(){
                                                                                    _ctx.callPhone(item.phoneNumber)
                                                                                }, "icon-path" to ("" + _ctx.resBaseUrl + "/static/icons/icon-call-phone-outline.png")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                    return _uA(
                                                                                        "联系乘客"
                                                                                    )
                                                                                }), "_" to 2), 1032, _uA(
                                                                                    "onClick",
                                                                                    "icon-path"
                                                                                )),
                                                                                if (isTrue(_ctx.orderParams["orderStatus"] != "0" && item.waitingStatus == 0)) {
                                                                                    _cV(_component_mc_primary_button, _uM("key" to 0, "onClick" to fun(){
                                                                                        _ctx.tryArrived(item.orderId, item.sortNum)
                                                                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                        return _uA(
                                                                                            "到达上车点"
                                                                                        )
                                                                                    }), "_" to 2), 1032, _uA(
                                                                                        "onClick"
                                                                                    ))
                                                                                } else {
                                                                                    if (isTrue(_ctx.orderParams["orderStatus"] != "0" && item.status < 3)) {
                                                                                        _cV(_component_mc_primary_button, _uM("key" to 1, "onClick" to fun(){
                                                                                            _ctx.passengerPickUp(item.orderId, item.sortNum, index)
                                                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                            return _uA(
                                                                                                "乘客上车"
                                                                                            )
                                                                                        }), "_" to 2), 1032, _uA(
                                                                                            "onClick"
                                                                                        ))
                                                                                    } else {
                                                                                        if (isTrue(item.status == 3 && _ctx.isSendMode)) {
                                                                                            _cV(_component_mc_primary_button, _uM("key" to 2, "onClick" to fun(){
                                                                                                _ctx.validOrder(item.orderId, item.sortNum)
                                                                                            }, "linear-colors" to _uA(
                                                                                                "#44C791",
                                                                                                "#28D07F"
                                                                                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                                return _uA(
                                                                                                    "完成订单"
                                                                                                )
                                                                                            }), "_" to 2), 1032, _uA(
                                                                                                "onClick"
                                                                                            ))
                                                                                        } else {
                                                                                            if (isTrue(item.status == 4 && _ctx.isSendMode)) {
                                                                                                _cV(_component_mc_primary_button, _uM("key" to 3, "linear-colors" to _uA(
                                                                                                    "#44C791",
                                                                                                    "#28D07F"
                                                                                                )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                                    return _uA(
                                                                                                        "已完成"
                                                                                                    )
                                                                                                }), "_" to 1))
                                                                                            } else {
                                                                                                _cC("v-if", true)
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            ))
                                                                        ), 4)
                                                                    ), 40, _uA(
                                                                        "onLongpress"
                                                                    ))
                                                                }
                                                            )
                                                        }), "_" to 2), 1032, _uA(
                                                            "order"
                                                        ))
                                                    }), 128)
                                                )
                                            }), "_" to 1), 8, _uA(
                                                "onChange",
                                                "list"
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    )
                                }), "_" to 1), 8, _uA(
                                    "height"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        }
                    ), 44, _uA(
                        "onTransitionend"
                    ))
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
            )),
            _cV(_component_x_modal, _uM("show" to _ctx.showCancelModal, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.showCancelModal = `$event`
            }
            , "show-close" to "", "onClose" to _ctx.modalCancelClose, "height" to if (_ctx.isLiquidatedDamages) {
                "690rpx"
            } else {
                "550rpx"
            }
            , "z-index" to "100", "title" to ("\u53D6\u6D88" + _ctx.orderNo + "\u53F7\u8BA2\u5355"), "show-footer" to false, "overlayClick" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                return _uA(
                    if (isTrue(_ctx.isLiquidatedDamages)) {
                        _cE("view", _uM("key" to 0, "class" to "pb-15 flex-row flex-row-center-center"), _uA(
                            _cE("text", null, "违约金额: "),
                            _cE("text", _uM("style" to _nS(_uM("color" to "red"))), "￥" + _tD(_ctx.defaultDeduction), 5)
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cV(_component_x_input, _uM("type" to "textarea", "auto-focus" to "", "modelValue" to _ctx.cancelReason, "onUpdate:modelValue" to fun(`$event`: String){
                        _ctx.cancelReason = `$event`
                    }
                    , "height" to "200rpx", "maxlength" to 50, "showChartCount" to "", "placeholder" to "请输入取消原因"), null, 8, _uA(
                        "modelValue",
                        "onUpdate:modelValue"
                    )),
                    if (isTrue(_ctx.isLiquidatedDamages)) {
                        _cE("view", _uM("key" to 1, "class" to "pt-10 pb-5"), _uA(
                            _cV(_component_x_radio_group, _uM("class" to "flex-row flex-row-center-center", "modelValue" to _ctx.driverCancelResponsibility, "onUpdate:modelValue" to fun(`$event`: String){
                                _ctx.driverCancelResponsibility = `$event`
                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_x_radio, _uM("onlyChecked" to true, "value" to "false", "class" to "pr-30", "label" to "乘客无责 ")),
                                    _cV(_component_x_radio, _uM("onlyChecked" to true, "value" to "true", "label" to "乘客有责"))
                                )
                            }), "_" to 1), 8, _uA(
                                "modelValue",
                                "onUpdate:modelValue"
                            ))
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("class" to "btn-group flex-row"), _uA(
                        _cV(_component_x_button, _uM("onClick" to _ctx.modalCancelClose, "skin" to "thin", "style" to _nS(_uM("flex" to "1", "margin-right" to "10px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                "取消"
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "onClick",
                            "style"
                        )),
                        _cV(_component_x_button, _uM("onClick" to _ctx.cancelModalConfirm, "style" to _nS(_uM("flex" to "1"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                "确认"
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "onClick",
                            "style"
                        ))
                    ))
                )
            }
            ), "_" to 1), 8, _uA(
                "show",
                "onUpdate:show",
                "onClose",
                "height",
                "title"
            )),
            _cE("view", _uM("class" to "bottom-actions", "style" to _nS("padding-bottom: " + (_ctx.globalData.safeAreaBottom + 5) + "px;")), _uA(
                _cE("view", _uM("class" to "order-btn", "onClick" to _ctx.viewOrders), _uA(
                    _cE("image", _uM("class" to "order-icon", "src" to ("" + _ctx.resBaseUrl + "/static/icons/icon-order-outline.png")), null, 8, _uA(
                        "src"
                    )),
                    _cE("view", null, _uA(
                        _cE("view", _uM("class" to "text"), "查看订单"),
                        _cE("view", _uM("class" to "flex-row"), _uA(
                            "(包含",
                            _cE("text", _uM("style" to _nS("color:" + _ctx.globalData.theme.primaryColor)), _tD(_ctx.orderData.orderCount), 5),
                            _cE("text", null, "笔订单)")
                        ))
                    ))
                ), 8, _uA(
                    "onClick"
                )),
                if (_ctx.orderParams["orderStatus"] != "0") {
                    _cV(_component_mc_primary_button, _uM("key" to 0, "border-radius" to "20rpx", "height" to "89rpx", "onClick" to fun(){
                        _ctx.startNavigation(false)
                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            "开始导航"
                        )
                    }), "_" to 1), 8, _uA(
                        "onClick"
                    ))
                } else {
                    if (isTrue(_ctx.isCurrentDay || (_ctx.orderParams["orderStatus"] == "0" && _ctx.checkTimeBefore(_ctx.orderParams["queryDate"] as String)))) {
                        _cV(_component_mc_primary_button, _uM("key" to 1, "border-radius" to "20rpx", "height" to "89rpx", "onClick" to _ctx.handleStartPickup), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                "出发接驾"
                            )
                        }), "_" to 1), 8, _uA(
                            "onClick"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                }
            ), 4),
            _cV(_component_x_modal, _uM("show" to _ctx.showAiDescModal, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.showAiDescModal = `$event`
            }
            , "bgColor" to "#ECF1F8", "show-cancel" to false, "confirm-text" to "知道了", "onConfirm" to fun(){
                _ctx.showAiDescModal = false
            }
            , "show-title" to false, "height" to "520rpx"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                return _uA(
                    _cE("text", _uM("class" to "ai-desc-title"), "智能规划介绍"),
                    _cE("view", _uM("class" to "desc"), _uA(
                        _cE("text", _uM("class" to "pb-10"), "关闭智能规划: 订单以下单时间默认排序，司机可手动拖拽修改顺序。"),
                        _cE("text", null, "开启智能规划: 订单会根据最优路线排序，司机不可手动修改，该模式可有效节省行程和出行时间，订单数量大于两单有效。")
                    ))
                )
            }
            ), "_" to 1), 8, _uA(
                "show",
                "onUpdate:show",
                "onConfirm"
            )),
            _cV(_component_mc_seat_viewer, _uM("ref" to "seatViewer", "data" to _ctx.currentChooseSeat, "seatTemplates" to _ctx.seatSelectTemplates), null, 8, _uA(
                "data",
                "seatTemplates"
            )),
            _cV(_component_x_modal, _uM("show" to _ctx.showAgreeLocationModal, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.showAgreeLocationModal = `$event`
            }
            , "bgColor" to "#ECF1F8", "cancel-text" to "拒绝", "overlay-click" to false, "onCancel" to _ctx.locationAgreeCancel, "confirm-text" to "同意", "onConfirm" to _ctx.locationAgreeConfirm, "show-title" to false, "height" to "500rpx"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                return _uA(
                    _cE("text", _uM("class" to "location-agree-title"), "定位权限获取申请"),
                    _cE("view", _uM("class" to "desc"), _uA(
                        _cE("text", _uM("class" to "pb-10"), "我们获取您的位置信息是用于匹配附近的订单、记录轨迹、规划导航路线。"),
                        _cE("text", null, "如果您拒绝我们获取您的上述信息，将导致您无法作为驾驶员向乘客提供服务。")
                    ))
                )
            }
            ), "_" to 1), 8, _uA(
                "show",
                "onUpdate:show",
                "onCancel",
                "onConfirm"
            ))
        ), 64)
    }
    open var globalData: GlobalDataType by `$inject`
    open var i18n: Tmui4xI18nTml by `$data`
    open var isSendMode: Boolean by `$data`
    open var showAgreeLocationModal: Boolean by `$data`
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
    open var pointBounds: UTSArray<UTSArray<Number>> by `$data`
    open var isFrist: Boolean by `$data`
    open var cardHeight: Number by `$data`
    open var cardShowHeight: Number by `$data`
    open var pullViewHeight: Number by `$data`
    open var transformHeight: Number by `$data`
    open var mapViewHeight: Number by `$data`
    open var isCurrentDay: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "isSendMode" to false, "showAgreeLocationModal" to false, "showAiDescModal" to false, "today" to formatDate(Date(), "yyyy-MM-dd"), "currentChooseSeat" to _uA<ChooseSeat>(), "seatSelectTemplates" to _uA<SeatSelectTemplate>(), "resBaseUrl" to uni.UNI09580B7.resBaseUrl, "orderNo" to 1, "orderIndex" to 0, "orderId" to "", "showValidModal" to false, "showKey" to false, "phoneSuffix" to "", "showCancelModal" to false, "cancelReason" to "", "driverCancelResponsibility" to "false", "isLiquidatedDamages" to false, "defaultDeduction" to "", "orderParams" to UTSJSONObject(), "sortList" to _uA<UTSJSONObject>(), "orderData" to OrderSummary1(orderCount = 0, driverStatus = -2, seatSelectTemplates = _uA(), orderItems = _uA(), orderChains = _uA(), orderRoute = OrderRoute(routeStrategy = "", routeStartPoint = "", routeWaypoints = _uA(), routeEndPoint = "", routeWaypointsPoiIds = _uA<String>(), routeStartPoiId = "", routeEndPoiId = "")), "screenWidth" to uni.UNI09580B7.screenWidth as Number, "screenHeight" to uni.UNI09580B7.screenHeight as Number, "statusBarHeight" to uni.UNI09580B7.statusBarHeight as Number, "isSmartPlanning" to true, "selectedRoute" to RouteSimpleInfo(routeId = -1, time = "", distance = "", lights = 0, paths = ""), "showOrderList" to false, "orderList" to _uA<Any>(), "routes" to _uA<RouteSimpleInfo>(), "isDx" to false, "showRouteStrategyOptions" to false, "routeStrategyMap" to object : UTSJSONObject() {
            var OVERALL_OPTIMAL: Number = 10
            var FASTEST: Number = 0
            var CHARGE_LESS: Number = 14
            var DONT_HIGH_SPEED: Number = 13
        }, "routeStrategyOptions" to _uA<RouteStrategyOption>(RouteStrategyOption(code = "OVERALL_OPTIMAL", name = "综合最优"), RouteStrategyOption(code = "FASTEST", name = "速度优先"), RouteStrategyOption(code = "CHARGE_LESS", name = "少收费"), RouteStrategyOption(code = "DONT_HIGH_SPEED", name = "不走高速")), "routeStrategy" to "OVERALL_OPTIMAL", "routeStrategyStr" to "综合最优", "tripingViewHeight" to 200, "viaDistance" to "0公里", "viaTime" to "0分钟", "mapContentHeight" to 0, "serviceConfig" to ServiceOrderPermission(allocateSeatModel = false, allowSubmitOrderNoCar = false, allowDriverCloseTakeOrder = false, allowDriverCancelOrder = false, enableNumberPrivacy = false, enableCallRecording = false), "pointBounds" to _uA<UTSArray<Number>>(), "isFrist" to true, "cardHeight" to computed<Number>(fun(): Number {
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
            return this.cardHeight - 40
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
    open var checkTimeBefore = ::gen_checkTimeBefore_fn
    open fun gen_checkTimeBefore_fn(date1: String): Boolean {
        val newDate = formatDate(Date(), "yyyy-MM-dd")
        return isTimeBefore(date1, newDate)
    }
    open var locationAgreeCancel = ::gen_locationAgreeCancel_fn
    open fun gen_locationAgreeCancel_fn() {
        setTimeout(fun(){
            showXToast(XTOAST_TYPE(title = "您已拒绝定位获取权限，将无法进行后面的业务", iconCode = "info", iconColor = "#ff8900", duration = 2500))
        }
        , 250)
    }
    open var locationAgreeConfirm = ::gen_locationAgreeConfirm_fn
    open fun gen_locationAgreeConfirm_fn() {
        checkLocationPermission(fun(all: Boolean){
            if (all) {
                console.log("同意权限=======", all)
                setLocationGrantStatus("agree")
                uni__emit("startLocation", true)
                this.queryOrderDetail(true, false)
            } else {
                this.locationAgreeCancel()
            }
        }
        )
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
    open fun gen_initEvt_fn() {
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
        refreshSeatTemplate("DRIVER_PLAN:ORDER_SEAT_METADATA:" + item.planId + ":" + item.departureDay).then(fun(res: Response){
            if (res.code == 200) {
                that.seatSelectTemplates = JSON.parseObject<UTSArray<SeatSelectTemplate>>(JSON.stringify(res.data)) ?: _uA()
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
        ws1?.sendAndOn(WebSocketSendMessage(type = MessageType["QUERY_ORDER"] as Number, content = _uO("queryType" to queryType, "condition" to if (that.orderParams["orderStatus"] != "0") {
            ""
        } else {
            JSON.stringify(object : UTSJSONObject() {
                var reserveDate = that.orderParams["queryDate"]
                var summaryId = that.orderParams["summaryId"]
            })
        }
        )), fun(data){
            val anyData = JSON.parse<QueryResponse<Any>>(data)
            if (anyData?.queryType == 6) {
                val resData = JSON.parse<QueryResponse<UTSArray<IntercityOrderReceiveInfo>>>(data)
                console.log("orderReceiveQuery==>", resData)
                uni__emit("orderReceiveList", resData?.data)
                return
            }
            val res = (JSON.parse<OrderData>(data) as OrderData).data
            that.orderData = res
            that.routeStrategy = res.orderRoute.routeStrategy
            if (forceCalc || ((that.orderParams["orderStatus"] != "0" || res.orderItems.length > 1) && canCalcRoute)) {
                that.calcRoute()
            }
            that.sortList = _uA<UTSJSONObject>()
            if (res.orderItems.length > 0) {
                setTimeout(fun(){
                    val boundsPoints = _uA(
                        _uA(
                            that.globalData.position.latitude,
                            that.globalData.position.longitude
                        )
                    ) as UTSArray<UTSArray<Number>>
                    var isSendMode = true
                    if (res.orderItems.filter(fun(item: OrderItem, idx: Number, arr: UTSArray<OrderItem>): Boolean {
                        return item.status < 3
                    }
                    ).length > 0) {
                        isSendMode = false
                    }
                    that.isSendMode = isSendMode
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
                        boundsPoints.push(pointArr)
                        return MarkerOption(latitude = pointArr[0], longitude = pointArr[1], color = item.pointColor, desc = item.pointName, showWindinfo = false, address = "", addressDetail = "")
                    }
                    )
                    mapView?.setMarkers(markers)
                    that.pointBounds = boundsPoints
                    mapView?.setBounds(boundsPoints)
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
        if (!isLocationAgree()) {
            return
        }
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
        console.log("触发路径规划：", options)
    }
    open var initLocation = ::gen_initLocation_fn
    open fun gen_initLocation_fn() {
        val mapView = (this.`$refs`["mapView"] as McAmapComponentPublicInstance)
        mapView?.getLocation(SingleLocationOptions(successCallback = fun(res: LocationResult){
            var log = "\u5355\u6B21\u5B9A\u4F4D\u56DE\u8C03 " + JSON.stringify(res)
            console.log(log)
        }
        ))
    }
    open var naviInfoUpdate = ::gen_naviInfoUpdate_fn
    open fun gen_naviInfoUpdate_fn(navInfo: String) {
        console.log("导航信息更新：", navInfo)
        val navInfoArr = JSON.parse<UTSArray<UTSJSONObject>>(navInfo)
        val nav = navInfoArr?.get(0)
        this.viaDistance = formatDistance(nav?.getNumber("distance") ?: 0, DistanceOption())
        this.viaTime = formatDuration(nav?.getNumber("time") ?: 0)
        this.syncRoutePaths(false)
        uni__emit("syncNavInfo", JSON.stringify(_uO("distance" to this.viaDistance, "time" to this.viaTime)))
    }
    open var calcRouteSuccess = ::gen_calcRouteSuccess_fn
    open fun gen_calcRouteSuccess_fn(data: String) {
        hideXloading()
        val routeData = JSON.parse<UTSJSONObject>(data) ?: UTSJSONObject()
        val routes: UTSArray<RouteSimpleInfo> = _uA()
        UTSJSONObject.keys(routeData).forEach(fun(key: String, index: Number, array: UTSArray<String>){
            val value = routeData.getJSON(key)
            routes.push(RouteSimpleInfo(routeId = UTSNumber.from(key), time = formatDuration(value?.getNumber("allTime") ?: 0), distance = formatDistance(value?.getNumber("allLength") ?: 0, DistanceOption()), lights = value?.getNumber("trafficLightCount") ?: 0, paths = value?.getString("paths") ?: ""))
        }
        )
        this.routes = routes
        this.selectRoute(routes[0])
        console.log("路径规划成功：", routes)
        val mapView = (this.`$refs`["mapView"] as McAmapComponentPublicInstance)
        setTimeout(fun(){
            mapView?.changeRouteById(this.routes[0].routeId)
        }
        , 10)
    }
    open var startNavigation = ::gen_startNavigation_fn
    open fun gen_startNavigation_fn(isEmulator: Boolean) {
        val that = this
        if (!isLocationAgree()) {
            that.showAgreeLocationModal = true
            return
        }
        if (that.routes.length <= 0) {
            return showTips("暂无路线规划，无法开启导航", "warning")
        }
        this.syncRoutePaths(true)
        (this.`$refs`["mapView"] as McAmapComponentPublicInstance)?.startNavi(this.selectedRoute.routeId, isEmulator)
        uni_navigateTo(NavigateToOptions(url = "/pages/other/order-detail/navi?planId=" + this.orderParams["planId"] + "&summaryId=" + this.orderParams["summaryId"], success = fun(res){
            uni__emit("onSendData", JSON.stringify(that.orderData))
            uni__emit("syncNavInfo", JSON.stringify(_uO("distance" to this.viaDistance, "time" to this.viaTime)))
        }
        ))
    }
    open var navQuit = ::gen_navQuit_fn
    open fun gen_navQuit_fn() {
        this.initEvt()
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
        ws1?.sendAndOnErr(WebSocketSendMessage(type = MessageType["QUERY_CAR_SETTING"] as Number, content = object : UTSJSONObject() {
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
        ws1?.sendAndOn(WebSocketSendMessage(type = MessageType["TRIP_REPORT"] as Number, content = JSON.stringify(object : UTSJSONObject() {
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
            val mapView = this.`$refs`["mapView"] as McAmapComponentPublicInstance
            if (this.selectedRoute.routeId == -1) {
                mapView?.setBounds(this.pointBounds)
            } else {
                mapView?.changeRouteById(this.selectedRoute.routeId)
            }
        }
        , 100)
    }
    open var routeLoveClick = ::gen_routeLoveClick_fn
    open fun gen_routeLoveClick_fn(option: RouteStrategyOption) {
        this.routeStrategy = option.code
        this.routeStrategyStr = option.name
        if (this.orderParams["orderStatus"] != "0" || this.orderData.orderItems.length > 1) {
            this.calcRoute()
        }
        setTimeout(fun(){
            this.showRouteStrategyOptions = false
        }
        , 50)
        ws1?.sendAndOn(WebSocketSendMessage(type = MessageType["QUERY_CAR_SETTING"] as Number, content = object : UTSJSONObject() {
            var routeStrategy = option.code
        }), fun(data){
            console.log("修复线路偏好成功：", data)
        }
        )
    }
    open var routeLoveBtnClick = ::gen_routeLoveBtnClick_fn
    open fun gen_routeLoveBtnClick_fn() {
        this.showRouteStrategyOptions = !this.showRouteStrategyOptions
    }
    open var openTrip = ::gen_openTrip_fn
    open fun gen_openTrip_fn() {
        ws1?.sendAndOn(WebSocketSendMessage(type = MessageType["OPEN_TRIP"] as Number), fun(data){
            console.log("开启行程：", data)
            this.orderData.driverStatus = 3
            vibrator(100)
        }
        )
    }
    open var closeTrip = ::gen_closeTrip_fn
    open fun gen_closeTrip_fn() {
        ws1?.sendAndOn(WebSocketSendMessage(type = MessageType["STOP_TRIP"] as Number), fun(data){
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
        ws1?.sendAndOn(WebSocketSendMessage(type = MessageType["ARRIVED_TRIP"] as Number, content = that.orderId), fun(data){
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
        if (!isLocationAgree()) {
            that.showAgreeLocationModal = true
            return
        }
        showLoading(XLOADINGS_TYPE(title = "正在出车中..."))
        ws1?.sendAndOnErr(WebSocketSendMessage(type = MessageType["BEFORE_CHECK"] as Number), fun(data){
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
        ws1?.sendAndOnErr(WebSocketSendMessage(type = MessageType["VALID_PHONE"] as Number, content = JSON.stringify(object : UTSJSONObject() {
            var phoneLastFour = that.phoneSuffix
            var orderId = that.orderId
        })), fun(data){
            console.log("验证乘客手机号成功：", data)
            that.queryOrderDetail(true, true)
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
            ws1?.sendAndOnErr(WebSocketSendMessage(type = MessageType["ORDER_FINISH"] as Number, content = orderId), fun(data){
                console.log("完成订单：", data)
                if (that.orderIndex < that.orderData.orderItems.length - 1) {
                    that.queryOrderDetail(true, false)
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
            ws1?.sendAndOnErr(WebSocketSendMessage(type = MessageType["OPEN_TRIP"] as Number), fun(data){
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
        ws1?.sendAndOnErr(WebSocketSendMessage(type = MessageType["ORDER_CANCEL"] as Number, content = JSON.stringify(object : UTSJSONObject() {
            var orderId = that.orderId
            var driverCancelResponsibility = that.driverCancelResponsibility == "true"
            var cancelReason = "司机主动取消，原因如下：" + that.cancelReason
        })), fun(data){
            console.log("取消订单：", data)
            hideXloading()
            that.orderId = ""
            that.showCancelModal = false
            val res = JSON.parse<OrderCancelResponse>(data)
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
            }
        }
        , fun(data){
            hideXloading()
        }
        )
    }
    open var showModalTip = ::gen_showModalTip_fn
    open fun gen_showModalTip_fn(text: String) {
        val pages = getCurrentPages()
        val currentPage = pages[pages.length - 1]
        val isNaviPage = currentPage.route == "pages/other/order-detail/navi"
        setTimeout(fun() {
            showModal(X_MODAL_TYPE(title = "温馨提示", content = if (isNaviPage) {
                "" + text + ",\u5F53\u524D\u5DF2\u91CD\u65B0\u89C4\u5212\u8DEF\u5F84\uFF0C\u5982\u679C\u8981\u81EA\u5B9A\u4E49\u9009\u62E9\u89C4\u5212\u7B56\u7565\uFF0C\u8BF7\u70B9\u51FB\u8FD4\u56DE\u6309\u94AE\u3002"
            } else {
                text
            }
            , confirmText = if (isNaviPage) {
                "继续"
            } else {
                "知道了"
            }
            , confirmBgColor = this.globalData.theme.primaryColor, cancelText = "返回", showCancel = isNaviPage, confirm = fun(){
                this.queryOrderDetail(true, true)
            }
            , cancel = fun() {
                if (isNaviPage) {
                    uni__emit("backPage", null)
                } else {
                    setTimeout(fun(){
                        this.queryOrderDetail(true, true)
                    }
                    , 250)
                }
            }
            ))
        }
        , 250)
    }
    open var onOrderAdd = ::gen_onOrderAdd_fn
    open fun gen_onOrderAdd_fn() {
        val that = this
        ws1?.on(MessageType["ORDER_ADD"] as Number, fun(data){
            console.log("您有一个新的订单：", data)
            hideXloading()
            val res = JSON.parse<OrderAddResponse>(data)
            if (res?.summaryId == that.orderParams["summaryId"]) {
                that.showModalTip("您收到一笔新的订单")
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
            }
        }
        )
    }
    open var onOneOrderFinish = ::gen_onOneOrderFinish_fn
    open fun gen_onOneOrderFinish_fn() {
        val that = this
        ws1?.on(MessageType["ORDER_FINISH"] as Number, fun(data){
            console.log("订单完成：", data)
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
            if (res?.summaryId == that.orderParams["summaryId"]) {
                var title = "您有一笔订单已被取消"
                var audioPath = "/static/audio/order-cancel.mp3"
                if (res?.mode == 1) {
                    title = "您有多笔订单已被取消"
                    audioPath = "/static/audio/order-cancel-multi.mp3"
                }
                if (res?.backIndex ?: false) {
                    setTimeout(fun() {
                        showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u56E0\u53D6\u6D88\u6216\u8C03\u5EA6\uFF0C\u60A8\u5F53\u524D\u8BA2\u5355\u5DF2\u5168\u90E8\u7ED3\u675F", confirmText = "返回首页", confirmBgColor = this.globalData.theme.primaryColor, showCancel = false, close = fun(){
                            uni_reLaunch(ReLaunchOptions(url = "/pages/home/index"))
                        }))
                    }, 250)
                } else {
                    that.showModalTip(title)
                }
                McAudio.play(audioPath, false)
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
        ws1?.sendAndOnErr(WebSocketSendMessage(type = MessageType["ORDER_SORT"] as Number, content = JSON.stringify(object : UTSJSONObject() {
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
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("map-container" to _pS(_uM("width" to "100%", "backgroundColor" to "#ffffff")), "route-love" to _pS(_uM("boxSizing" to "border-box", "width" to "100%", "paddingTop" to "35rpx", "paddingRight" to "35rpx", "paddingBottom" to "35rpx", "paddingLeft" to "35rpx", "position" to "relative", "left" to 0, "right" to 0, "height" to "250rpx")), "title" to _uM(".route-love " to _uM("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#FFFFFF")), "bg-img" to _uM(".route-love " to _uM("position" to "absolute", "left" to "-10rpx", "top" to 0, "right" to 0, "height" to "609rpx")), "radio-card-group" to _uM(".route-love " to _uM("flexDirection" to "row", "paddingTop" to "15rpx")), "radio-card" to _uM(".route-love .radio-card-group " to _uM("flex" to 1, "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "textAlign" to "center")), "content-panel" to _pS(_uM("borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "0rpx", "borderBottomLeftRadius" to "0rpx", "boxSizing" to "border-box", "boxShadow" to "0rpx 0rpx 8rpx 0rpx rgba(89, 119, 177, 0.5)", "transitionProperty" to "transform", "transitionDuration" to "0.5s", "position" to "fixed", "left" to 0, "right" to 0)), "planning-header" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "boxSizing" to "border-box", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "backgroundColor" to "rgba(0,0,0,0)")), "planning-title" to _uM(".planning-header " to _uM("flexDirection" to "row", "alignItems" to "center", "paddingTop" to "5rpx", "paddingRight" to "10rpx", "paddingBottom" to "5rpx", "paddingLeft" to "10rpx", "backgroundImage" to "linear-gradient(to right, #FFF3DD, #00000000)", "borderTopLeftRadius" to "5rpx", "borderTopRightRadius" to "5rpx", "borderBottomRightRadius" to "5rpx", "borderBottomLeftRadius" to "5rpx")), "text" to _uM(".planning-header .planning-title " to _uM("marginRight" to "10rpx"), ".planning-header .sort-btn " to _uM("fontSize" to "26rpx", "color" to "#FFFFFF"), ".route-card .header .traffic-light " to _uM("fontSize" to "26rpx"), ".header-order-title " to _uM("fontWeight" to "bold", "fontSize" to "26rpx"), ".order-list .order-item .side-tag-box " to _uM("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#F5F7FA", "position" to "absolute", "left" to "13rpx", "top" to "13rpx"), ".order-list .order-item .order-info .header .left-box " to _uM("fontWeight" to "bold", "fontSize" to "26rpx"), ".order-list .order-item .order-info .remark " to _uM("width" to "95%", "boxSizing" to "border-box", "paddingLeft" to "6rpx", "fontWeight" to "bold", "fontSize" to "27rpx", "color" to "#D09A5B"), ".order-list .order-item-dx .order-info .header .left-box " to _uM("fontWeight" to "bold", "fontSize" to "26rpx"), ".order-list .order-item-dx .order-info .remark " to _uM("width" to "95%", "boxSizing" to "border-box", "paddingLeft" to "6rpx", "fontWeight" to "bold", "fontSize" to "27rpx", "color" to "#D09A5B"), ".triping-panel .main-body .left-box " to _uM("fontSize" to "26rpx", "color" to "#000000")), "planning-icon" to _uM(".planning-header .planning-title " to _uM("width" to "21rpx", "height" to "27rpx", "marginRight" to "10rpx")), "sort-btn" to _uM(".planning-header " to _uM("backgroundColor" to "#95B1E7", "paddingTop" to "10rpx", "paddingRight" to "20rpx", "paddingBottom" to "10rpx", "paddingLeft" to "20rpx", "flexDirection" to "row", "alignItems" to "center", "borderTopLeftRadius" to "5rpx", "borderTopRightRadius" to "5rpx", "borderBottomRightRadius" to "5rpx", "borderBottomLeftRadius" to "5rpx")), "sort-icon" to _uM(".planning-header .sort-btn " to _uM("marginLeft" to "10rpx", "width" to "24rpx", "height" to "20rpx")), "routes-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "marginTop" to "24rpx", "marginRight" to "30rpx", "marginBottom" to "30rpx", "marginLeft" to "30rpx", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx")), "route-card" to _pS(_uM("borderTopLeftRadius" to "16rpx", "borderTopRightRadius" to "16rpx", "borderBottomRightRadius" to "16rpx", "borderBottomLeftRadius" to "16rpx", "justifyContent" to "space-between", "paddingTop" to "15rpx", "paddingRight" to "20rpx", "paddingBottom" to "15rpx", "paddingLeft" to "20rpx", "alignContent" to "space-between", "height" to "210rpx", "flex" to 1)), "header" to _uM(".route-card " to _uM("flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between"), ".order-list .order-item .order-info " to _uM("paddingBottom" to "20rpx", "borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#e7e7e7"), ".order-list .order-item-dx .order-info " to _uM("paddingBottom" to "20rpx"), ".triping-panel " to _uM("paddingTop" to "30rpx", "paddingRight" to "45rpx", "paddingBottom" to "10rpx", "paddingLeft" to "45rpx")), "route-title" to _uM(".route-card .header " to _uM("fontSize" to "26rpx")), "traffic-light" to _uM(".route-card .header " to _uM("flexDirection" to "row", "alignItems" to "center")), "light-icon" to _uM(".route-card .header .traffic-light " to _uM("width" to "20rpx", "height" to "22rpx", "marginRight" to "6rpx")), "route-time" to _uM(".route-card " to _uM("fontSize" to "32rpx", "fontWeight" to "bold")), "route-distance" to _uM(".route-card " to _uM("fontSize" to "26rpx")), "bottom-actions" to _pS(_uM("backgroundColor" to "#ffffff", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "borderTopWidth" to "1rpx", "borderTopStyle" to "solid", "borderTopColor" to "#eeeeee", "height" to "150rpx", "width" to "100%", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "zIndex" to 10)), "order-btn" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "paddingTop" to 0, "paddingRight" to "100rpx", "paddingBottom" to 0, "paddingLeft" to "20rpx")), "order-icon" to _uM(".order-btn " to _uM("width" to "41rpx", "height" to "47rpx", "marginRight" to "20rpx"), ".triping-panel .header .order-title " to _uM("width" to "24rpx", "height" to "28rpx", "marginRight" to "10rpx")), "header-order-title" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0)), "icon" to _uM(".header-order-title " to _uM("width" to "28rpx", "height" to "28rpx", "marginRight" to "10rpx"), ".order-list .order-item .order-info .header .left-box " to _uM("width" to "28rpx", "height" to "28rpx", "marginRight" to "10rpx"), ".order-list .order-item .order-info .address-info .left-box .address-item " to _uM("width" to "20rpx", "height" to "28rpx"), ".order-list .order-item .order-info .seat-info " to _uM("width" to "34rpx", "height" to "28rpx", "marginTop" to "2rpx", "marginLeft" to "15rpx"), ".order-list .order-item .order-info .remark " to _uM("width" to "26rpx", "height" to "26rpx", "marginTop" to "2rpx"), ".order-list .order-item-dx .order-info .header .left-box " to _uM("width" to "28rpx", "height" to "28rpx", "marginRight" to "10rpx"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item " to _uM("width" to "20rpx", "height" to "28rpx"), ".order-list .order-item-dx .order-info .seat-info " to _uM("width" to "34rpx", "height" to "28rpx", "marginTop" to "2rpx", "marginLeft" to "15rpx"), ".order-list .order-item-dx .order-info .remark " to _uM("width" to "26rpx", "height" to "26rpx", "marginTop" to "2rpx")), "num" to _uM(".header-order-title " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#5E7BB7"), ".order-list .order-item .order-info .header .left-box " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#5E7BB7"), ".order-list .order-item .order-info .address-info .right-box " to _uM("color" to "#D18124", "fontSize" to "40rpx"), ".order-list .order-item-dx .order-info .header .left-box " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#D09A5B"), ".order-list .order-item-dx .order-info .address-info .right-box " to _uM("color" to "#D18124", "fontSize" to "40rpx")), "split" to _uM(".header-order-title " to _uM("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx"), ".order-list .order-item .order-info .header .left-box " to _uM("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx"), ".order-list .order-item-dx .order-info .header .left-box " to _uM("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx"), ".triping-panel .main-body .left-box " to _uM("color" to "#A8A7A7", "paddingTop" to 0, "paddingRight" to "10rpx", "paddingBottom" to 0, "paddingLeft" to "10rpx")), "order-list" to _pS(_uM("paddingBottom" to "50rpx")), "more-menu" to _uM(".order-list " to _uM("borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "marginTop" to "10rpx", "marginRight" to "10rpx", "marginBottom" to "10rpx", "marginLeft" to "10rpx", "boxShadow" to "0rpx 0rpx 15rpx 0rpx rgba(89, 119, 177, 0.2)")), "order-item" to _uM(".order-list " to _uM("boxSizing" to "border-box", "marginTop" to 0, "marginRight" to "20rpx", "marginBottom" to 0, "marginLeft" to "20rpx", "position" to "relative", "paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "15rpx", "paddingLeft" to 0)), "side-tag-box" to _uM(".order-list .order-item " to _uM("position" to "absolute", "left" to 0, "top" to "15rpx", "width" to "61rpx", "height" to "49rpx", "zIndex" to 2)), "img" to _uM(".order-list .order-item .side-tag-box " to _uM("width" to "100%", "height" to "100%")), "order-info" to _uM(".order-list .order-item " to _uM("backgroundColor" to "#FFFFFF", "boxShadow" to "0rpx 0rpx 10rpx 0rpx rgba(89, 119, 177, 0.2)", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "25rpx", "paddingRight" to "30rpx", "paddingBottom" to "25rpx", "paddingLeft" to "30rpx"), ".order-list .order-item-dx " to _uM("backgroundColor" to "#FFFFFF", "boxShadow" to "0rpx 0rpx 10rpx 0rpx rgba(89, 119, 177, 0.2)", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "25rpx", "paddingRight" to "30rpx", "paddingBottom" to "25rpx", "paddingLeft" to "30rpx", "marginTop" to "5rpx", "marginRight" to "10rpx", "marginBottom" to "30rpx", "marginLeft" to "10rpx")), "left-box" to _uM(".order-list .order-item .order-info .header " to _uM("paddingLeft" to "35rpx"), ".order-list .order-item .order-info .address-info " to _uM("width" to "80%"), ".order-list .order-item-dx .order-info .address-info " to _uM("width" to "80%"), ".triping-panel .main-body " to _uM("width" to "90%")), "right-box" to _uM(".order-list .order-item .order-info .header " to _uM("alignItems" to "center"), ".order-list .order-item-dx .order-info .header " to _uM("alignItems" to "center"), ".order-list .order-item-dx .order-info .address-info " to _uM("width" to "100rpx")), "more-btn" to _uM(".order-list .order-item .order-info .header .right-box " to _uM("fontSize" to "28rpx"), ".order-list .order-item-dx .order-info .header .right-box " to _uM("fontSize" to "28rpx")), "border" to _uM(".order-list .order-item .order-info " to _uM("height" to "1rpx", "backgroundImage" to "none", "backgroundColor" to "#E6E7E9"), ".order-list .order-item-dx .order-info " to _uM("height" to "1rpx", "backgroundImage" to "none", "backgroundColor" to "#E6E7E9")), "address-info" to _uM(".order-list .order-item .order-info " to _uM("paddingLeft" to "20rpx", "paddingTop" to "20rpx"), ".triping-panel .main-body .left-box " to _uM("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#898989", "paddingBottom" to "10rpx")), "top" to _uM(".order-list .order-item .order-info .address-info .left-box .address-item " to _uM("alignItems" to "center"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item " to _uM("alignItems" to "center")), "label" to _uM(".order-list .order-item .order-info .address-info .left-box .address-item .top " to _uM("paddingLeft" to "10rpx", "fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000"), ".order-list .order-item .order-info .seat-info " to _uM("fontSize" to "26rpx", "color" to "#898989"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item .top " to _uM("paddingLeft" to "10rpx", "fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000"), ".order-list .order-item-dx .order-info .seat-info " to _uM("fontSize" to "26rpx", "color" to "#898989")), "bottom" to _uM(".order-list .order-item .order-info .address-info .left-box .address-item " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#898989", "marginLeft" to "10rpx", "marginBottom" to "3rpx", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "22rpx", "paddingLeft" to "20rpx"), ".order-list .order-item-dx .order-info .address-info .left-box .address-item " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#898989", "marginLeft" to "10rpx", "marginBottom" to "3rpx", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "22rpx", "paddingLeft" to "20rpx")), "seat-info" to _uM(".order-list .order-item .order-info " to _uM("flexDirection" to "row", "paddingBottom" to "20rpx"), ".order-list .order-item-dx .order-info " to _uM("flexDirection" to "row", "paddingBottom" to "20rpx")), "value" to _uM(".order-list .order-item .order-info .seat-info " to _uM("fontSize" to "26rpx", "color" to "#4D679B"), ".order-list .order-item-dx .order-info .seat-info " to _uM("fontSize" to "26rpx", "color" to "#4D679B")), "remark" to _uM(".order-list .order-item .order-info " to _uM("backgroundImage" to "none", "backgroundColor" to "#FDF7F0", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "12rpx", "paddingRight" to "12rpx", "paddingBottom" to "12rpx", "paddingLeft" to "12rpx", "boxSizing" to "border-box"), ".order-list .order-item-dx .order-info " to _uM("backgroundImage" to "none", "backgroundColor" to "#FDF7F0", "borderTopLeftRadius" to "11rpx", "borderTopRightRadius" to "11rpx", "borderBottomRightRadius" to "11rpx", "borderBottomLeftRadius" to "11rpx", "paddingTop" to "12rpx", "paddingRight" to "12rpx", "paddingBottom" to "12rpx", "paddingLeft" to "12rpx", "boxSizing" to "border-box")), "btn-group" to _uM(".order-list .order-item .order-info " to _uM("paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0), ".order-list .order-item-dx .order-info " to _uM("paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0), "" to _uM("paddingTop" to "30rpx", "paddingRight" to 0, "paddingBottom" to "30rpx", "paddingLeft" to 0)), "order-item-dx" to _uM(".order-list " to _uM("boxSizing" to "border-box", "marginTop" to "20rpx", "marginRight" to "20rpx", "marginBottom" to 0, "marginLeft" to "20rpx", "position" to "relative")), "triping-panel" to _pS(_uM("borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "0rpx", "borderBottomLeftRadius" to "0rpx", "boxSizing" to "border-box", "boxShadow" to "0rpx 0rpx 8rpx 0rpx rgba(89, 119, 177, 0.5)", "position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "#ffffff")), "current-step" to _uM(".triping-panel .header " to _uM("fontSize" to "34rpx", "color" to "#000000")), "main-body" to _uM(".triping-panel " to _uM("paddingTop" to 0, "paddingRight" to "45rpx", "paddingBottom" to "25rpx", "paddingLeft" to "45rpx")), "call-phone" to _uM(".triping-panel .main-body " to _uM("width" to "50rpx", "height" to "50rpx")), "footer" to _uM(".triping-panel " to _uM("paddingTop" to 0, "paddingRight" to "40rpx", "paddingBottom" to "20rpx", "paddingLeft" to "40rpx")), "ai-desc-title" to _pS(_uM("textAlign" to "center", "width" to "100%", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "location-agree-title" to _pS(_uM("textAlign" to "center", "width" to "100%", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "@TRANSITION" to _uM("content-panel" to _uM("property" to "transform", "duration" to "0.5s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM("globalData" to _uM("type" to "Object"))
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
