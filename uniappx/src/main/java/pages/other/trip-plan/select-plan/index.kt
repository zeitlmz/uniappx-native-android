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
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesOtherTripPlanSelectPlanIndex : BasePage {
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
                return createVNode(_component_mc_base_container, utsMapOf("title" to "改派选择计划日期", "showStatusBarPlaceholder" to false, "title-color" to "#ffffff", "navbar-is-place" to false, "staticTransparent" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "top-header", "style" to normalizeStyle("padding-top: " + (unref(statusBarHeight) + 50) + "px;background-image: linear-gradient(to right, " + unref(globalData).theme.primaryLinearColors.join(",") + ");")), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "address-info", "style" to normalizeStyle(utsMapOf("flex-direction" to "column"))), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "address-item", "style" to normalizeStyle(utsMapOf("height" to "120rpx"))), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "line")),
                                    createElementVNode("view", utsMapOf("class" to "top flex-row", "style" to normalizeStyle(utsMapOf("padding-top" to "20rpx"))), utsArrayOf(
                                        createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location-start.png"), "mode" to ""), null, 8, utsArrayOf(
                                            "src"
                                        )),
                                        createElementVNode("text", utsMapOf("class" to "label"), "万柏林区·中国建设银行(矿院储蓄所)太原市万柏 林区人民政府")
                                    ), 4)
                                ), 4),
                                createElementVNode("view", utsMapOf("class" to "address-item", "style" to normalizeStyle(utsMapOf("padding-bottom" to "30rpx"))), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "top flex-row"), utsArrayOf(
                                        createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location-end.png"), "mode" to ""), null, 8, utsArrayOf(
                                            "src"
                                        )),
                                        createElementVNode("text", utsMapOf("class" to "label"), "晋中市-太谷区-晋中市县政府")
                                    ))
                                ), 4)
                            ), 4),
                            createElementVNode("view", utsMapOf("class" to "row-info"), utsArrayOf(
                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-clock-filled-small.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                    "src"
                                )),
                                createElementVNode("text", utsMapOf("class" to "label", "style" to normalizeStyle("color: " + unref(globalData).theme.primaryColor2 + ";")), "当前订单时间：", 4),
                                createElementVNode("text", utsMapOf("class" to "value"), "2025年04月15日 18:00:00")
                            )),
                            createElementVNode("view", utsMapOf("class" to "row-info"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "row-info", "style" to normalizeStyle(utsMapOf("padding" to "0 100rpx 0 0"))), utsArrayOf(
                                    createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-people-filled.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                        "src"
                                    )),
                                    createElementVNode("text", utsMapOf("class" to "label", "style" to normalizeStyle("color: " + unref(globalData).theme.primaryColor2 + ";")), "行程人数：", 4),
                                    createElementVNode("text", utsMapOf("class" to "value"), "2人")
                                ), 4),
                                createElementVNode("view", utsMapOf("class" to "row-info", "style" to normalizeStyle(utsMapOf("padding" to "0 0 0 30rpx", "border-left" to "2rpx solid #7394D6"))), utsArrayOf(
                                    createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-car-filled.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                        "src"
                                    )),
                                    createElementVNode("text", utsMapOf("class" to "label", "style" to normalizeStyle("color: " + unref(globalData).theme.primaryColor2 + ";")), "行程订单：", 4),
                                    createElementVNode("text", utsMapOf("class" to "value"), "拼车")
                                ), 4)
                            )),
                            createElementVNode("view", utsMapOf("class" to "row-info"), utsArrayOf(
                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-filled-small.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                    "src"
                                )),
                                createElementVNode("text", utsMapOf("class" to "label", "style" to normalizeStyle("color: " + unref(globalData).theme.primaryColor2 + ";")), "座位信息：", 4),
                                createElementVNode("text", utsMapOf("class" to "value"), "二排左侧 2A / 二排左侧 2B")
                            )),
                            createElementVNode("view", utsMapOf("class" to "row-info"), utsArrayOf(
                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-remark-filled.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                    "src"
                                )),
                                createElementVNode("text", utsMapOf("class" to "label", "style" to normalizeStyle("color: " + unref(globalData).theme.primaryColor2 + ";")), "行程备注：", 4),
                                createElementVNode("text", utsMapOf("class" to "value"), "有大件行李箱，有小孩需要安全座椅")
                            ))
                        ), 4),
                        createVNode(_component_template, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createVNode(_component_x_pull_refresh, utsMapOf("height" to ("" + (unref(screenHeight) - unref(statusBarHeight) - unref(topHeaderHeight) - unref(globalData).safeAreaBottom) + "px"), "pullHeight" to 30, "disabled-bottom" to true, "show-scrollbar" to false), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode(Fragment, null, RenderHelpers.renderList((10 as Number), fun(item, __key, __index, _cached): Any {
                                            return createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                                                "15",
                                                "15",
                                                "15",
                                                "0"
                                            ), "key" to item, "padding" to utsArrayOf(
                                                "0"
                                            ), "round" to utsArrayOf(
                                                "20rpx"
                                            )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("view", utsMapOf("class" to "setting-item"), utsArrayOf(
                                                        createElementVNode("view", utsMapOf("class" to "top-box"), utsArrayOf(
                                                            createElementVNode("view", utsMapOf("class" to "time"), utsArrayOf(
                                                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-clock-blue-outline-small.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                                    "src"
                                                                )),
                                                                createElementVNode("text", utsMapOf("class" to "value"), "2024.12.08 05:00:00")
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "remain-seat flex-row"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "text"), "余座："),
                                                                createElementVNode("text", utsMapOf("class" to "num"), "3"),
                                                                createElementVNode("text", utsMapOf("class" to "text"), " 位")
                                                            ))
                                                        )),
                                                        createElementVNode("view", utsMapOf("class" to "route-info"), utsArrayOf(
                                                            createElementVNode("text", utsMapOf("class" to "start-address"), "太原市"),
                                                            createElementVNode("view", utsMapOf("class" to "group-name"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "name", "style" to normalizeStyle("color: " + unref(globalData).theme.primaryColor + ";")), "太原-娄烦", 4),
                                                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-trip-car-filled.png"), "mode" to "heightFix"), null, 8, utsArrayOf(
                                                                    "src"
                                                                ))
                                                            )),
                                                            createElementVNode("text", utsMapOf("class" to "end-address"), "晋中市"),
                                                            createVNode(_component_mc_primary_button, utsMapOf("style" to normalizeStyle(utsMapOf("margin-right" to "30rpx")), "onClick" to toSelectSeat), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return utsArrayOf(
                                                                    "去选座"
                                                                )
                                                            }
                                                            ), "_" to 1), 8, utsArrayOf(
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
                                ), "_" to 1), 8, utsArrayOf(
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
            normalizeCssStyles(utsArrayOf(
                styles0
            ), utsArrayOf(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("top-header" to padStyleMapOf(utsMapOf("position" to "relative", "paddingTop" to 0, "paddingRight" to "15rpx", "paddingBottom" to "30rpx", "paddingLeft" to "15rpx")), "row-info" to padStyleMapOf(utsMapOf("paddingTop" to "15rpx", "paddingRight" to "30rpx", "paddingBottom" to "15rpx", "paddingLeft" to "30rpx", "flexDirection" to "row", "alignItems" to "center")), "icon" to utsMapOf(".row-info " to utsMapOf("width" to "26rpx", "height" to "26rpx", "marginRight" to "10rpx"), ".address-info .address-item " to utsMapOf("width" to "20rpx", "height" to "28rpx", "marginTop" to "4rpx"), ".setting-item .top-box .time " to utsMapOf("width" to "22rpx", "height" to "22rpx", "marginRight" to "10rpx"), ".setting-item .route-info .group-name " to utsMapOf("width" to "210rpx", "height" to "24rpx")), "label" to utsMapOf(".row-info " to utsMapOf("color" to "#C2D6FF", "fontWeight" to "bold", "fontSize" to "26rpx"), ".address-info .address-item .top " to utsMapOf("paddingLeft" to "15rpx", "fontWeight" to "bold", "fontSize" to "30rpx", "color" to "#FFFFFF")), "value" to utsMapOf(".row-info " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#FFFFFF"), ".setting-item .top-box .time " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000")), "address-info" to padStyleMapOf(utsMapOf("paddingTop" to 0, "paddingRight" to "35rpx", "paddingBottom" to 0, "paddingLeft" to "35rpx")), "address-item" to utsMapOf(".address-info " to utsMapOf("position" to "relative")), "line" to utsMapOf(".address-info .address-item " to utsMapOf("position" to "absolute", "left" to "8rpx", "top" to "55rpx", "width" to "2rpx", "height" to "90%", "backgroundImage" to "none", "backgroundColor" to "#879DCB")), "bottom" to utsMapOf(".address-info .address-item " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#898989", "marginLeft" to "10rpx", "marginBottom" to "3rpx", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "22rpx", "paddingLeft" to "20rpx")), "top-box" to utsMapOf(".setting-item " to utsMapOf("paddingTop" to "20rpx", "paddingRight" to 0, "paddingBottom" to "20rpx", "paddingLeft" to 0, "marginTop" to 0, "marginRight" to "30rpx", "marginBottom" to 0, "marginLeft" to "30rpx", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#C7C7C7")), "time" to utsMapOf(".setting-item .top-box " to utsMapOf("flexDirection" to "row", "alignItems" to "center")), "text" to utsMapOf(".setting-item .top-box .remain-seat " to utsMapOf("fontSize" to "28rpx", "color" to "#868686")), "num" to utsMapOf(".setting-item .top-box .remain-seat " to utsMapOf("fontSize" to "28rpx", "color" to "#C78300")), "route-info" to utsMapOf(".setting-item " to utsMapOf("flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "paddingTop" to "20rpx", "paddingBottom" to "30rpx", "borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#DADADA")), "start-address" to utsMapOf(".setting-item .route-info " to utsMapOf("fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000", "paddingLeft" to "30rpx", "paddingRight" to "10rpx")), "end-address" to utsMapOf(".setting-item .route-info " to utsMapOf("fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000", "paddingLeft" to "10rpx", "paddingRight" to "30rpx")), "group-name" to utsMapOf(".setting-item .route-info " to utsMapOf("alignItems" to "center")), "name" to utsMapOf(".setting-item .route-info .group-name " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#5672AB", "paddingBottom" to "6rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
