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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import uts.sdk.modules.mcAmapNavPlus.checkLocationPermission
import uts.sdk.modules.mcAmapNavPlus.init
open class GenPagesOtherLineManageViewDistinctIndex : BasePage {
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
        var setup: (__props: GenPagesOtherLineManageViewDistinctIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherLineManageViewDistinctIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val driverBindDistrictLines = ref(utsArrayOf<DriverBindDistrictLines>())
            val startDistrictCode = ref<String>("")
            val startCityCode = ref<String>("")
            val endCityCode = ref<String>("")
            val districtToCityName = ref<String>("")
            val carpoolPrice = ref<String>("")
            val fiveExclusivePrice = ref<String>("")
            val sixExclusivePrice = ref<String>("")
            val sevenExclusivePrice = ref<String>("0")
            val eightExclusivePrice = ref<String>("")
            val nineExclusivePrice = ref<String>("0")
            val isfresh = ref<Boolean>(false)
            val bottomFresh = ref<Boolean>(false)
            var scrollDirection = "down"
            val showPrice = ref(false)
            val viewPrice = fun(item: DriverBindDistrictLines){
                showPrice.value = true
                carpoolPrice.value = item.carpoolPrice
                fiveExclusivePrice.value = item.fiveExclusivePrice
                sixExclusivePrice.value = item.sixExclusivePrice
                sevenExclusivePrice.value = item.sevenExclusivePrice
                eightExclusivePrice.value = item.eightExclusivePrice
                nineExclusivePrice.value = item.nineExclusivePrice
            }
            val init = fun(){
                getDriverBindLinesList(startDistrictCode.value, startCityCode.value, endCityCode.value).then(fun(res: Response){
                    driverBindDistrictLines.value = JSON.parseArray<DriverBindDistrictLines>(JSON.stringify(res.data)) ?: utsArrayOf()
                    if (scrollDirection == "down") {
                        isfresh.value = false
                    } else {
                        bottomFresh.value = false
                    }
                }
                )
            }
            val topLoad = fun(){
                console.log("下拉刷新")
                scrollDirection = "down"
                init()
            }
            val bottomLoad = fun(){
                console.log("触底刷新")
                scrollDirection = "up"
                init()
            }
            onLoad(fun(options){
                if (options != null) {
                    val opt = JSON.parse(JSON.stringify(options)) as UTSJSONObject
                    startDistrictCode.value = opt.getString("startDistrictCode") ?: ""
                    startCityCode.value = opt.getString("startCityCode") ?: ""
                    endCityCode.value = opt.getString("endCityCode") ?: ""
                    districtToCityName.value = opt.getString("districtToCityName") ?: ""
                    init()
                }
            }
            )
            return fun(): Any? {
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_pull_refresh = resolveEasyComponent("x-pull-refresh", GenUniModulesTmxUiComponentsXPullRefreshXPullRefreshClass)
                val _component_template = resolveComponent("template")
                val _component_x_drawer = resolveEasyComponent("x-drawer", GenUniModulesTmxUiComponentsXDrawerXDrawerClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createVNode(_component_mc_base_container, utsMapOf("title" to "区县详情"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                            "0"
                        ), "padding" to utsArrayOf(
                            "30rpx"
                        ), "class" to "flex-row", "color" to "#00000000"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "distinct-title flex-row"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "title-border", "style" to normalizeStyle("background-color: " + unref(globalData).theme.primaryColor + ";")), null, 4),
                                    createElementVNode("text", utsMapOf("class" to "text"), toDisplayString(unref(districtToCityName)), 1)
                                ))
                            )
                        }
                        ), "_" to 1)),
                        createVNode(_component_template, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createVNode(_component_x_pull_refresh, utsMapOf("height" to ("" + (unref(screenHeight) - unref(statusBarHeight) - unref(globalData).safeAreaBottom - 130) + "px"), "pullHeight" to 30, "disabled-bottom" to true, "show-scrollbar" to false, "modelValue" to unref(isfresh), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                    trySetRefValue(isfresh, `$event`)
                                }
                                , "model-bottom-status" to unref(bottomFresh), "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                    trySetRefValue(bottomFresh, `$event`)
                                }
                                , "onRefresh" to topLoad, "onBottomRefresh" to bottomLoad), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode(Fragment, null, RenderHelpers.renderList(unref(driverBindDistrictLines), fun(item, index, __index, _cached): Any {
                                            return createVNode(_component_x_sheet, utsMapOf("class" to "flex-row flex-row-center-between", "color" to "#ffffff", "padding" to utsArrayOf(
                                                "30rpx"
                                            ), "margin" to utsArrayOf(
                                                "15",
                                                "0",
                                                "15",
                                                "15"
                                            )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("view", utsMapOf("class" to "left-box flex-row flex-row-center-between"), utsArrayOf(
                                                        createElementVNode("text", null, toDisplayString(item.startDistrictName + "-" + item.endDistrictName), 1)
                                                    )),
                                                    createElementVNode("view", utsMapOf("onClick" to fun(){
                                                        viewPrice(item)
                                                    }
                                                    , "class" to "right-box flex-row flex-row-center-center"), utsArrayOf(
                                                        createElementVNode("text", utsMapOf("style" to normalizeStyle("color: " + unref(globalData).theme.primaryColor + ";")), "价格明细", 4),
                                                        createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
                                                    ), 8, utsArrayOf(
                                                        "onClick"
                                                    ))
                                                )
                                            }
                                            ), "_" to 2), 1024)
                                        }
                                        ), 256)
                                    )
                                }
                                ), "_" to 1), 8, utsArrayOf(
                                    "height",
                                    "modelValue",
                                    "model-bottom-status"
                                ))
                            )
                        }
                        ), "_" to 1)),
                        createVNode(_component_x_drawer, utsMapOf("content-margin" to "30rpx", "show" to unref(showPrice), "onUpdate:show" to fun(`$event`: Boolean){
                            trySetRefValue(showPrice, `$event`)
                        }
                        , "bgColor" to "#ECF1F8", "show-title" to false, "size" to "65%"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "title"), "线路价格明细"),
                                createElementVNode("view", utsMapOf("class" to "price-group"), utsArrayOf(
                                    if (unref(carpoolPrice) != "") {
                                        createElementVNode("text", utsMapOf("key" to 0, "class" to "price-item"), "拼车：" + toDisplayString(unref(carpoolPrice)) + "元", 1)
                                    } else {
                                        createCommentVNode("v-if", true)
                                    }
                                    ,
                                    if (unref(fiveExclusivePrice) != "") {
                                        createElementVNode("text", utsMapOf("key" to 1, "class" to "price-item"), "五座独享：" + toDisplayString(unref(fiveExclusivePrice)) + "元", 1)
                                    } else {
                                        createCommentVNode("v-if", true)
                                    }
                                    ,
                                    if (unref(sixExclusivePrice) != "") {
                                        createElementVNode("text", utsMapOf("key" to 2, "class" to "price-item"), "六座独享：" + toDisplayString(unref(sixExclusivePrice)) + "元", 1)
                                    } else {
                                        createCommentVNode("v-if", true)
                                    }
                                    ,
                                    if (unref(sevenExclusivePrice) != "") {
                                        createElementVNode("text", utsMapOf("key" to 3, "class" to "price-item"), "七座独享：" + toDisplayString(unref(sevenExclusivePrice)) + "元", 1)
                                    } else {
                                        createCommentVNode("v-if", true)
                                    }
                                    ,
                                    if (unref(eightExclusivePrice) != "") {
                                        createElementVNode("text", utsMapOf("key" to 4, "class" to "price-item"), "八座独享：" + toDisplayString(unref(eightExclusivePrice)) + "元", 1)
                                    } else {
                                        createCommentVNode("v-if", true)
                                    }
                                    ,
                                    if (unref(nineExclusivePrice) != "") {
                                        createElementVNode("text", utsMapOf("key" to 5, "class" to "price-item"), "九座独享：" + toDisplayString(unref(nineExclusivePrice)) + "元", 1)
                                    } else {
                                        createCommentVNode("v-if", true)
                                    }
                                )),
                                createElementVNode("view", utsMapOf("class" to "tips"), utsArrayOf(
                                    createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-problem-outline.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                        "src"
                                    )),
                                    createElementVNode("text", utsMapOf("class" to "text"), "部分街镇价格有所不同，联系客服咨询价格相关政策")
                                ))
                            )
                        }
                        ), "_" to 1), 8, utsArrayOf(
                            "show"
                        ))
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
                return utsMapOf("distinct-title" to padStyleMapOf(utsMapOf("alignItems" to "center")), "title-border" to utsMapOf(".distinct-title " to utsMapOf("width" to "8rpx", "height" to "33rpx", "borderTopLeftRadius" to "4rpx", "borderTopRightRadius" to "4rpx", "borderBottomRightRadius" to "4rpx", "borderBottomLeftRadius" to "4rpx")), "text" to utsMapOf(".distinct-title " to utsMapOf("paddingLeft" to "20rpx", "fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000"), ".tips " to utsMapOf("boxSizing" to "border-box", "paddingLeft" to "10rpx", "fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#D50303")), "left-box" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "icon" to utsMapOf(".left-box " to utsMapOf("width" to 12, "height" to 14), ".right-box " to utsMapOf("width" to 6, "height" to 12, "marginLeft" to "10rpx"), ".tips " to utsMapOf("width" to "29rpx", "height" to "29rpx")), "btn-group-panel" to padStyleMapOf(utsMapOf("position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "title" to padStyleMapOf(utsMapOf("textAlign" to "center", "width" to "100%", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "price-item" to utsMapOf(".price-group " to utsMapOf("paddingTop" to "30rpx", "paddingRight" to "30rpx", "paddingBottom" to "30rpx", "paddingLeft" to "30rpx", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "marginBottom" to "30rpx", "backgroundColor" to "#ffffff")), "tips" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "marginBottom" to "30rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
