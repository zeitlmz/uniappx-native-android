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
import uts.sdk.modules.mcAmapNavPlus.init
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenPagesOtherLineManageIndex : BasePage {
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
        var setup: (__props: GenPagesOtherLineManageIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherLineManageIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val isfresh = ref<Boolean>(false)
            val bottomFresh = ref<Boolean>(false)
            var scrollDirection = "down"
            val linesAggCityList = ref(utsArrayOf<LinesAggCityInfo>())
            val itemMap = ref<Map<Number, UTSArray<LinesBindInfo>>>(Map())
            val toViewDistinct = fun(item: LinesBindInfo){
                uni_navigateTo(NavigateToOptions(url = "/pages/other/line-manage/view-distinct/index?districtToCityName=" + item.districtToCityName + "&startDistrictCode=" + item.startDistrictCode + "&startCityCode=" + item.startCityCode + "&endCityCode=" + item.endCityCode))
            }
            val onChange = fun(item: LinesAggCityInfo, index: Number){
                getDriverBindLinesDistrictToCityList(item.startCityCode, item.endCityCode).then(fun(res: Response){
                    itemMap.value.set(index, JSON.parseArray<LinesBindInfo>(JSON.stringify(res.data)) ?: utsArrayOf())
                }
                )
            }
            val init = fun(){
                getDriverBindLines().then(fun(res: Response){
                    linesAggCityList.value = JSON.parseArray<LinesAggCityInfo>(JSON.stringify(res.data)) ?: utsArrayOf()
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
            onReady(fun(){
                init()
            }
            )
            return fun(): Any? {
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_collapse_item = resolveEasyComponent("x-collapse-item", GenUniModulesTmxUiComponentsXCollapseItemXCollapseItemClass)
                val _component_x_collapse = resolveEasyComponent("x-collapse", GenUniModulesTmxUiComponentsXCollapseXCollapseClass)
                val _component_x_empty = resolveEasyComponent("x-empty", GenUniModulesTmxUiComponentsXEmptyXEmptyClass)
                val _component_x_pull_refresh = resolveEasyComponent("x-pull-refresh", GenUniModulesTmxUiComponentsXPullRefreshXPullRefreshClass)
                val _component_template = resolveComponent("template")
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createVNode(_component_mc_base_container, utsMapOf("title" to "线路管理"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createVNode(_component_template, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createVNode(_component_x_pull_refresh, utsMapOf("height" to ("" + (unref(screenHeight) - unref(statusBarHeight) - unref(globalData).safeAreaBottom - 125) + "px"), "pullHeight" to 30, "disabled-bottom" to true, "show-scrollbar" to false, "modelValue" to unref(isfresh), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                    trySetRefValue(isfresh, `$event`)
                                }
                                , "model-bottom-status" to unref(bottomFresh), "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                    trySetRefValue(bottomFresh, `$event`)
                                }
                                , "onRefresh" to topLoad, "onBottomRefresh" to bottomLoad), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode(Fragment, null, RenderHelpers.renderList(unref(linesAggCityList), fun(item, index, __index, _cached): Any {
                                            return createVNode(_component_x_sheet, utsMapOf("padding" to utsArrayOf(
                                                "0"
                                            ), "margin" to utsArrayOf(
                                                "15",
                                                if (index == 0) {
                                                    "15"
                                                } else {
                                                    "0"
                                                }
                                                ,
                                                "15",
                                                "20"
                                            ), "style" to normalizeStyle(utsMapOf("margin-bottom" to "20px"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createVNode(_component_x_collapse, utsMapOf("onChange" to fun(){
                                                        onChange(item, index)
                                                    }
                                                    ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return utsArrayOf(
                                                            createVNode(_component_x_collapse_item, utsMapOf("showBottomLine" to false, "name" to "1", "title" to (item.startCityName + "-" + item.endCityName)), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return utsArrayOf(
                                                                    createElementVNode(Fragment, null, RenderHelpers.renderList(unref(itemMap).get(index), fun(item2, index2, __index, _cached): Any {
                                                                        return createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                                                                            "0"
                                                                        ), "class" to "flex-row flex-row-center-between", "color" to unref(globalData).theme.painColor), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                            return utsArrayOf(
                                                                                createElementVNode("view", utsMapOf("class" to "left-box flex-row flex-row-center-between"), utsArrayOf(
                                                                                    createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location-filled.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                                                        "src"
                                                                                    )),
                                                                                    createElementVNode("text", utsMapOf("class" to "pl-5"), toDisplayString(item2.districtToCityName), 1)
                                                                                )),
                                                                                createElementVNode("view", utsMapOf("class" to "right-box flex-row flex-row-center-between", "onClick" to fun(){
                                                                                    toViewDistinct(item2)
                                                                                }
                                                                                ), utsArrayOf(
                                                                                    createElementVNode("text", utsMapOf("style" to normalizeStyle("color: " + unref(globalData).theme.primaryColor + ";")), "查看区县", 4),
                                                                                    createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                                                        "src"
                                                                                    ))
                                                                                ), 8, utsArrayOf(
                                                                                    "onClick"
                                                                                ))
                                                                            )
                                                                        }
                                                                        ), "_" to 2), 1032, utsArrayOf(
                                                                            "color"
                                                                        ))
                                                                    }
                                                                    ), 256)
                                                                )
                                                            }
                                                            ), "_" to 2), 1032, utsArrayOf(
                                                                "title"
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 2), 1032, utsArrayOf(
                                                        "onChange"
                                                    ))
                                                )
                                            }
                                            ), "_" to 2), 1032, utsArrayOf(
                                                "margin",
                                                "style"
                                            ))
                                        }
                                        ), 256),
                                        if (unref(linesAggCityList).length <= 0) {
                                            createVNode(_component_x_empty, utsMapOf("key" to 0, "loading" to false, "empty" to true, "showBtn" to false))
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                    )
                                }
                                ), "_" to 1), 8, utsArrayOf(
                                    "height",
                                    "modelValue",
                                    "model-bottom-status"
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
                return utsMapOf("left-box" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "icon" to utsMapOf(".left-box " to utsMapOf("width" to 12, "height" to 14), ".right-box " to utsMapOf("width" to 6, "height" to 12, "marginLeft" to "10rpx")), "btn-group-panel" to padStyleMapOf(utsMapOf("position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
