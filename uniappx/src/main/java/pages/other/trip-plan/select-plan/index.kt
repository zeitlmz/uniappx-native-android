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
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesOtherTripPlanSelectPlanIndex : BasePage {
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
        var setup: (__props: GenPagesOtherTripPlanSelectPlanIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherTripPlanSelectPlanIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val proxy = getCurrentInstance()!!.proxy!!
            val router = uni_useKuxRouter()
            val topHeaderHeight = ref(0)
            val toSelectSeat = fun(){
                router.push("/pages/other/trip-plan/index")
            }
            val getNodeInfo = fun(){
                setTimeout(fun(){
                    getDomHeight(proxy, ".top-header").then(fun(res: UTSArray<Number>){
                        topHeaderHeight.value = res[0]
                    }
                    )
                }
                , 50)
            }
            onMounted(fun(){
                getNodeInfo()
            }
            )
            return fun(): Any? {
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_pull_refresh = resolveEasyComponent("x-pull-refresh", GenUniModulesTmxUiComponentsXPullRefreshXPullRefreshClass)
                val _component_template = resolveComponent("template")
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return _cV(_component_mc_base_container, _uM("title" to "改派选择计划日期", "showStatusBarPlaceholder" to false, "title-color" to "#ffffff", "navbar-is-place" to false, "staticTransparent" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "top-header", "style" to _nS("padding-top: " + (unref(statusBarHeight) + 50) + "px;background-image: linear-gradient(to right, " + unref(globalData).theme.primaryLinearColors.join(",") + ");")), _uA(
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
                                _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-clock-filled-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                    "src"
                                )),
                                _cE("text", _uM("class" to "label", "style" to _nS("color: " + unref(globalData).theme.primaryColor2 + ";")), "当前订单时间：", 4),
                                _cE("text", _uM("class" to "value"), "2025年04月15日 18:00:00")
                            )),
                            _cE("view", _uM("class" to "row-info"), _uA(
                                _cE("view", _uM("class" to "row-info", "style" to _nS(_uM("padding" to "0 100rpx 0 0"))), _uA(
                                    _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-people-filled.png"), "mode" to "widthFix"), null, 8, _uA(
                                        "src"
                                    )),
                                    _cE("text", _uM("class" to "label", "style" to _nS("color: " + unref(globalData).theme.primaryColor2 + ";")), "行程人数：", 4),
                                    _cE("text", _uM("class" to "value"), "2人")
                                ), 4),
                                _cE("view", _uM("class" to "row-info", "style" to _nS(_uM("padding" to "0 0 0 30rpx", "border-left" to "2rpx solid #7394D6"))), _uA(
                                    _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-car-filled.png"), "mode" to "widthFix"), null, 8, _uA(
                                        "src"
                                    )),
                                    _cE("text", _uM("class" to "label", "style" to _nS("color: " + unref(globalData).theme.primaryColor2 + ";")), "行程订单：", 4),
                                    _cE("text", _uM("class" to "value"), "拼车")
                                ), 4)
                            )),
                            _cE("view", _uM("class" to "row-info"), _uA(
                                _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-filled-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                    "src"
                                )),
                                _cE("text", _uM("class" to "label", "style" to _nS("color: " + unref(globalData).theme.primaryColor2 + ";")), "座位信息：", 4),
                                _cE("text", _uM("class" to "value"), "二排左侧 2A / 二排左侧 2B")
                            )),
                            _cE("view", _uM("class" to "row-info"), _uA(
                                _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-remark-filled.png"), "mode" to "widthFix"), null, 8, _uA(
                                    "src"
                                )),
                                _cE("text", _uM("class" to "label", "style" to _nS("color: " + unref(globalData).theme.primaryColor2 + ";")), "行程备注：", 4),
                                _cE("text", _uM("class" to "value"), "有大件行李箱，有小孩需要安全座椅")
                            ))
                        ), 4),
                        _cV(_component_template, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_x_pull_refresh, _uM("height" to ("" + (unref(screenHeight) - unref(statusBarHeight) - unref(topHeaderHeight) - unref(globalData).safeAreaBottom) + "px"), "pullHeight" to 30, "disabled-bottom" to true, "show-scrollbar" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList((10 as Number), fun(item, __key, __index, _cached): Any {
                                            return _cV(_component_x_sheet, _uM("margin" to _uA(
                                                "15",
                                                "15",
                                                "15",
                                                "0"
                                            ), "key" to item, "padding" to _uA(
                                                "0"
                                            ), "round" to _uA(
                                                "20rpx"
                                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "setting-item"), _uA(
                                                        _cE("view", _uM("class" to "top-box"), _uA(
                                                            _cE("view", _uM("class" to "time"), _uA(
                                                                _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-clock-blue-outline-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                    "src"
                                                                )),
                                                                _cE("text", _uM("class" to "value"), "2024.12.08 05:00:00")
                                                            )),
                                                            _cE("view", _uM("class" to "remain-seat flex-row"), _uA(
                                                                _cE("text", _uM("class" to "text"), "余座："),
                                                                _cE("text", _uM("class" to "num"), "3"),
                                                                _cE("text", _uM("class" to "text"), " 位")
                                                            ))
                                                        )),
                                                        _cE("view", _uM("class" to "route-info"), _uA(
                                                            _cE("text", _uM("class" to "start-address"), "太原市"),
                                                            _cE("view", _uM("class" to "group-name"), _uA(
                                                                _cE("text", _uM("class" to "name", "style" to _nS("color: " + unref(globalData).theme.primaryColor + ";")), "太原-娄烦", 4),
                                                                _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-trip-car-filled.png"), "mode" to "heightFix"), null, 8, _uA(
                                                                    "src"
                                                                ))
                                                            )),
                                                            _cE("text", _uM("class" to "end-address"), "晋中市"),
                                                            _cV(_component_mc_primary_button, _uM("style" to _nS(_uM("margin-right" to "30rpx")), "onClick" to toSelectSeat), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    "去选座"
                                                                )
                                                            }
                                                            ), "_" to 1), 8, _uA(
                                                                "style"
                                                            ))
                                                        ))
                                                    ))
                                                )
                                            }
                                            ), "_" to 2), 1024)
                                        }
                                        ), 64)
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "height"
                                ))
                            )
                        }
                        ), "_" to 1))
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
                return _uM("top-header" to _pS(_uM("position" to "relative", "paddingTop" to 0, "paddingRight" to "15rpx", "paddingBottom" to "30rpx", "paddingLeft" to "15rpx")), "row-info" to _pS(_uM("paddingTop" to "15rpx", "paddingRight" to "30rpx", "paddingBottom" to "15rpx", "paddingLeft" to "30rpx", "flexDirection" to "row", "alignItems" to "center")), "icon" to _uM(".row-info " to _uM("width" to "26rpx", "height" to "26rpx", "marginRight" to "10rpx"), ".address-info .address-item " to _uM("width" to "20rpx", "height" to "28rpx", "marginTop" to "4rpx"), ".setting-item .top-box .time " to _uM("width" to "22rpx", "height" to "22rpx", "marginRight" to "10rpx"), ".setting-item .route-info .group-name " to _uM("width" to "210rpx", "height" to "24rpx")), "label" to _uM(".row-info " to _uM("color" to "#C2D6FF", "fontWeight" to "bold", "fontSize" to "26rpx"), ".address-info .address-item .top " to _uM("paddingLeft" to "15rpx", "fontWeight" to "bold", "fontSize" to "30rpx", "color" to "#FFFFFF")), "value" to _uM(".row-info " to _uM("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#FFFFFF"), ".setting-item .top-box .time " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000")), "address-info" to _pS(_uM("paddingTop" to 0, "paddingRight" to "35rpx", "paddingBottom" to 0, "paddingLeft" to "35rpx")), "address-item" to _uM(".address-info " to _uM("position" to "relative")), "line" to _uM(".address-info .address-item " to _uM("position" to "absolute", "left" to "8rpx", "top" to "55rpx", "width" to "2rpx", "height" to "90%", "backgroundImage" to "none", "backgroundColor" to "#879DCB")), "bottom" to _uM(".address-info .address-item " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#898989", "marginLeft" to "10rpx", "marginBottom" to "3rpx", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "22rpx", "paddingLeft" to "20rpx")), "top-box" to _uM(".setting-item " to _uM("paddingTop" to "20rpx", "paddingRight" to 0, "paddingBottom" to "20rpx", "paddingLeft" to 0, "marginTop" to 0, "marginRight" to "30rpx", "marginBottom" to 0, "marginLeft" to "30rpx", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#C7C7C7")), "time" to _uM(".setting-item .top-box " to _uM("flexDirection" to "row", "alignItems" to "center")), "text" to _uM(".setting-item .top-box .remain-seat " to _uM("fontSize" to "28rpx", "color" to "#868686")), "num" to _uM(".setting-item .top-box .remain-seat " to _uM("fontSize" to "28rpx", "color" to "#C78300")), "route-info" to _uM(".setting-item " to _uM("flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "paddingTop" to "20rpx", "paddingBottom" to "30rpx", "borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#DADADA")), "start-address" to _uM(".setting-item .route-info " to _uM("fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000", "paddingLeft" to "30rpx", "paddingRight" to "10rpx")), "end-address" to _uM(".setting-item .route-info " to _uM("fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000", "paddingLeft" to "10rpx", "paddingRight" to "30rpx")), "group-name" to _uM(".setting-item .route-info " to _uM("alignItems" to "center")), "name" to _uM(".setting-item .route-info .group-name " to _uM("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#5672AB", "paddingBottom" to "6rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
