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
open class GenPagesOtherSeatSelectIndex : BasePage {
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
        var setup: (__props: GenPagesOtherSeatSelectIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherSeatSelectIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            return fun(): Any? {
                val _component_mc_seat_select = resolveEasyComponent("mc-seat-select", GenComponentsMcSeatSelectIndexClass)
                val _component_x_pull_refresh = resolveEasyComponent("x-pull-refresh", GenUniModulesTmxUiComponentsXPullRefreshXPullRefreshClass)
                val _component_template = resolveComponent("template")
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return _cV(_component_mc_base_container, _uM("title" to "选择座位"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_template, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_x_pull_refresh, _uM("height" to ("" + (unref(screenHeight) - unref(statusBarHeight) - unref(globalData).safeAreaBottom - 110) + "px"), "pullHeight" to 30, "disabled-bottom" to true, "show-scrollbar" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", _uM("class" to "top-header"), _uA(
                                            _cE("view", _uM("class" to "address-info", "style" to _nS(_uM("flex-direction" to "column"))), _uA(
                                                _cE("view", _uM("class" to "address-item", "style" to _nS(_uM("height" to "120rpx"))), _uA(
                                                    _cE("view", _uM("class" to "line")),
                                                    _cE("view", _uM("class" to "top flex-row", "style" to _nS(_uM("padding-top" to "20rpx"))), _uA(
                                                        _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location-start.png"), "mode" to ""), null, 8, _uA(
                                                            "src"
                                                        )),
                                                        _cE("text", _uM("class" to "label"), "万柏林区·中国建设银行(矿院储蓄所)太原市万柏 林区人民政府")
                                                    ), 4)
                                                ), 4),
                                                _cE("view", _uM("class" to "address-item", "style" to _nS(_uM("padding-bottom" to "30rpx"))), _uA(
                                                    _cE("view", _uM("class" to "top flex-row"), _uA(
                                                        _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location-end.png"), "mode" to ""), null, 8, _uA(
                                                            "src"
                                                        )),
                                                        _cE("text", _uM("class" to "label"), "晋中市-太谷区-晋中市县政府")
                                                    ))
                                                ), 4)
                                            ), 4),
                                            _cE("view", _uM("class" to "row-info"), _uA(
                                                _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-clock-filled-small-2.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                )),
                                                _cE("text", _uM("class" to "label"), "当前订单时间："),
                                                _cE("text", _uM("class" to "value"), "2025年04月15日 18:00:00")
                                            )),
                                            _cE("view", _uM("class" to "row-info"), _uA(
                                                _cE("view", _uM("class" to "row-info", "style" to _nS(_uM("padding" to "0 100rpx 0 0"))), _uA(
                                                    _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-people-filled-2.png"), "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    )),
                                                    _cE("text", _uM("class" to "label"), "行程人数："),
                                                    _cE("text", _uM("class" to "value"), "2人")
                                                ), 4),
                                                _cE("view", _uM("class" to "row-info", "style" to _nS(_uM("padding" to "0 0 0 30rpx", "border-left" to "2rpx solid #7394D6"))), _uA(
                                                    _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-car-filled-2.png"), "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    )),
                                                    _cE("text", _uM("class" to "label"), "行程订单："),
                                                    _cE("text", _uM("class" to "value"), "拼车")
                                                ), 4)
                                            )),
                                            _cE("view", _uM("class" to "row-info"), _uA(
                                                _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-filled-small-2.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                )),
                                                _cE("text", _uM("class" to "label"), "座位信息："),
                                                _cE("text", _uM("class" to "value"), "二排左侧 2A / 二排左侧 2B")
                                            )),
                                            _cE("view", _uM("class" to "row-info"), _uA(
                                                _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-remark-filled-2.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                )),
                                                _cE("text", _uM("class" to "label"), "行程备注："),
                                                _cE("text", _uM("class" to "value"), "有大件行李箱，有小孩需要安全座椅")
                                            ))
                                        )),
                                        _cV(_component_mc_seat_select)
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "height"
                                ))
                            )
                        }
                        ), "_" to 1)),
                        _cE("view", _uM("class" to "bottom-panel", "style" to _nS("padding-bottom: " + (unref(globalData).safeAreaBottom + 15) + "px")), _uA(
                            _cE("view", _uM("class" to "left-box"), _uA(
                                _cE("image", _uM("class" to "money-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-money-blue.png"), "mode" to "widthFix"), null, 8, _uA(
                                    "src"
                                )),
                                _cE("text", _uM("class" to "price"), "￥12")
                            )),
                            _cE("view", _uM("class" to "right-box"), _uA(
                                _cV(_component_mc_primary_button, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "确认选座"
                                    )
                                }
                                ), "_" to 1))
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
                return _uM("top-header" to _pS(_uM("position" to "relative", "marginTop" to "30rpx", "marginRight" to "30rpx", "marginBottom" to "30rpx", "marginLeft" to "30rpx", "paddingTop" to "30rpx", "paddingRight" to "30rpx", "paddingBottom" to "30rpx", "paddingLeft" to "30rpx", "backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx")), "row-info" to _pS(_uM("paddingTop" to "15rpx", "paddingRight" to "30rpx", "paddingBottom" to "15rpx", "paddingLeft" to "30rpx", "flexDirection" to "row", "alignItems" to "center")), "icon" to _uM(".row-info " to _uM("width" to "26rpx", "height" to "26rpx", "marginRight" to "10rpx"), ".address-info .address-item " to _uM("width" to "20rpx", "height" to "28rpx", "marginTop" to "4rpx")), "label" to _uM(".row-info " to _uM("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#898989"), ".address-info .address-item .top " to _uM("paddingLeft" to "15rpx", "fontWeight" to "bold", "fontSize" to "30rpx")), "value" to _uM(".row-info " to _uM("fontWeight" to "bold", "fontSize" to "26rpx")), "address-info" to _pS(_uM("paddingTop" to 0, "paddingRight" to "35rpx", "paddingBottom" to 0, "paddingLeft" to "35rpx")), "address-item" to _uM(".address-info " to _uM("position" to "relative")), "line" to _uM(".address-info .address-item " to _uM("position" to "absolute", "left" to "8rpx", "top" to "55rpx", "width" to "2rpx", "height" to "90%", "backgroundImage" to "none", "backgroundColor" to "#879DCB")), "bottom" to _uM(".address-info .address-item " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "marginLeft" to "10rpx", "marginBottom" to "3rpx", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "22rpx", "paddingLeft" to "20rpx")), "bottom-panel" to _pS(_uM("boxSizing" to "border-box", "position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "height" to "110rpx", "backgroundColor" to "#FFFFFF", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "paddingTop" to "30rpx", "paddingRight" to "30rpx", "paddingBottom" to "30rpx", "paddingLeft" to "30rpx")), "left-box" to _uM(".bottom-panel " to _uM("flexDirection" to "row", "alignItems" to "center")), "money-icon" to _uM(".bottom-panel .left-box " to _uM("width" to "43rpx", "marginRight" to "10rpx")), "price" to _uM(".bottom-panel .left-box " to _uM("fontFamily" to "PingFang SC", "fontWeight" to "bold", "fontSize" to "34rpx", "color" to "#4A6497")), "right-box" to _uM(".bottom-panel " to _uM("flexDirection" to "row", "alignItems" to "center", "width" to "266rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
