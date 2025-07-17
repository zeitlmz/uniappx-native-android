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
                return createVNode(_component_mc_base_container, utsMapOf("title" to "选择座位"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createVNode(_component_template, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createVNode(_component_x_pull_refresh, utsMapOf("height" to ("" + (unref(screenHeight) - unref(statusBarHeight) - unref(globalData).safeAreaBottom - 110) + "px"), "pullHeight" to 30, "disabled-bottom" to true, "show-scrollbar" to false), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "top-header"), utsArrayOf(
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
                                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-clock-filled-small-2.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                )),
                                                createElementVNode("text", utsMapOf("class" to "label"), "当前订单时间："),
                                                createElementVNode("text", utsMapOf("class" to "value"), "2025年04月15日 18:00:00")
                                            )),
                                            createElementVNode("view", utsMapOf("class" to "row-info"), utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "row-info", "style" to normalizeStyle(utsMapOf("padding" to "0 100rpx 0 0"))), utsArrayOf(
                                                    createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-people-filled-2.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("text", utsMapOf("class" to "label"), "行程人数："),
                                                    createElementVNode("text", utsMapOf("class" to "value"), "2人")
                                                ), 4),
                                                createElementVNode("view", utsMapOf("class" to "row-info", "style" to normalizeStyle(utsMapOf("padding" to "0 0 0 30rpx", "border-left" to "2rpx solid #7394D6"))), utsArrayOf(
                                                    createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-car-filled-2.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("text", utsMapOf("class" to "label"), "行程订单："),
                                                    createElementVNode("text", utsMapOf("class" to "value"), "拼车")
                                                ), 4)
                                            )),
                                            createElementVNode("view", utsMapOf("class" to "row-info"), utsArrayOf(
                                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-filled-small-2.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                )),
                                                createElementVNode("text", utsMapOf("class" to "label"), "座位信息："),
                                                createElementVNode("text", utsMapOf("class" to "value"), "二排左侧 2A / 二排左侧 2B")
                                            )),
                                            createElementVNode("view", utsMapOf("class" to "row-info"), utsArrayOf(
                                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-remark-filled-2.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                )),
                                                createElementVNode("text", utsMapOf("class" to "label"), "行程备注："),
                                                createElementVNode("text", utsMapOf("class" to "value"), "有大件行李箱，有小孩需要安全座椅")
                                            ))
                                        )),
                                        createVNode(_component_mc_seat_select)
                                    )
                                }
                                ), "_" to 1), 8, utsArrayOf(
                                    "height"
                                ))
                            )
                        }
                        ), "_" to 1)),
                        createElementVNode("view", utsMapOf("class" to "bottom-panel", "style" to normalizeStyle("padding-bottom: " + (unref(globalData).safeAreaBottom + 15) + "px")), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "left-box"), utsArrayOf(
                                createElementVNode("image", utsMapOf("class" to "money-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-money-blue.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                    "src"
                                )),
                                createElementVNode("text", utsMapOf("class" to "price"), "￥12")
                            )),
                            createElementVNode("view", utsMapOf("class" to "right-box"), utsArrayOf(
                                createVNode(_component_mc_primary_button, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
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
            normalizeCssStyles(utsArrayOf(
                styles0
            ), utsArrayOf(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("top-header" to padStyleMapOf(utsMapOf("position" to "relative", "marginTop" to "30rpx", "marginRight" to "30rpx", "marginBottom" to "30rpx", "marginLeft" to "30rpx", "paddingTop" to "30rpx", "paddingRight" to "30rpx", "paddingBottom" to "30rpx", "paddingLeft" to "30rpx", "backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx")), "row-info" to padStyleMapOf(utsMapOf("paddingTop" to "15rpx", "paddingRight" to "30rpx", "paddingBottom" to "15rpx", "paddingLeft" to "30rpx", "flexDirection" to "row", "alignItems" to "center")), "icon" to utsMapOf(".row-info " to utsMapOf("width" to "26rpx", "height" to "26rpx", "marginRight" to "10rpx"), ".address-info .address-item " to utsMapOf("width" to "20rpx", "height" to "28rpx", "marginTop" to "4rpx")), "label" to utsMapOf(".row-info " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#898989"), ".address-info .address-item .top " to utsMapOf("paddingLeft" to "15rpx", "fontWeight" to "bold", "fontSize" to "30rpx")), "value" to utsMapOf(".row-info " to utsMapOf("fontWeight" to "bold", "fontSize" to "26rpx")), "address-info" to padStyleMapOf(utsMapOf("paddingTop" to 0, "paddingRight" to "35rpx", "paddingBottom" to 0, "paddingLeft" to "35rpx")), "address-item" to utsMapOf(".address-info " to utsMapOf("position" to "relative")), "line" to utsMapOf(".address-info .address-item " to utsMapOf("position" to "absolute", "left" to "8rpx", "top" to "55rpx", "width" to "2rpx", "height" to "90%", "backgroundImage" to "none", "backgroundColor" to "#879DCB")), "bottom" to utsMapOf(".address-info .address-item " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "marginLeft" to "10rpx", "marginBottom" to "3rpx", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "22rpx", "paddingLeft" to "20rpx")), "bottom-panel" to padStyleMapOf(utsMapOf("boxSizing" to "border-box", "position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "height" to "110rpx", "backgroundColor" to "#FFFFFF", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "paddingTop" to "30rpx", "paddingRight" to "30rpx", "paddingBottom" to "30rpx", "paddingLeft" to "30rpx")), "left-box" to utsMapOf(".bottom-panel " to utsMapOf("flexDirection" to "row", "alignItems" to "center")), "money-icon" to utsMapOf(".bottom-panel .left-box " to utsMapOf("width" to "43rpx", "marginRight" to "10rpx")), "price" to utsMapOf(".bottom-panel .left-box " to utsMapOf("fontFamily" to "PingFang SC", "fontWeight" to "bold", "fontSize" to "34rpx", "color" to "#4A6497")), "right-box" to utsMapOf(".bottom-panel " to utsMapOf("flexDirection" to "row", "alignItems" to "center", "width" to "266rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
