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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenPagesOtherLineManageIndex : BasePage {
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
        var setup: (__props: GenPagesOtherLineManageIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherLineManageIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val isfresh = ref<Boolean>(false)
            val bottomFresh = ref<Boolean>(false)
            var scrollDirection = "down"
            val linesAggCityList = ref(_uA<LinesAggCityInfo>())
            val itemMap = ref<Map<Number, UTSArray<LinesBindInfo>>>(Map())
            val toViewDistinct = fun(item: LinesBindInfo){
                uni_navigateTo(NavigateToOptions(url = "/pages/other/line-manage/view-distinct/index?districtToCityName=" + item.districtToCityName + "&startDistrictCode=" + item.startDistrictCode + "&startCityCode=" + item.startCityCode + "&endCityCode=" + item.endCityCode))
            }
            val onChange = fun(item: LinesAggCityInfo, index: Number){
                getDriverBindLinesDistrictToCityList(item.startCityCode, item.endCityCode).then(fun(res: Response){
                    itemMap.value.set(index, JSON.parseArray<LinesBindInfo>(JSON.stringify(res.data)) ?: _uA())
                }
                )
            }
            val init = fun(){
                getDriverBindLines().then(fun(res: Response){
                    linesAggCityList.value = JSON.parseArray<LinesAggCityInfo>(JSON.stringify(res.data)) ?: _uA()
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
                return _cV(_component_mc_base_container, _uM("title" to "线路管理"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_template, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_x_pull_refresh, _uM("height" to ("" + (unref(screenHeight) - unref(statusBarHeight) - unref(globalData).safeAreaBottom - 125) + "px"), "pullHeight" to 30, "disabled-bottom" to true, "show-scrollbar" to false, "modelValue" to unref(isfresh), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                    trySetRefValue(isfresh, `$event`)
                                }
                                , "model-bottom-status" to unref(bottomFresh), "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                    trySetRefValue(bottomFresh, `$event`)
                                }
                                , "onRefresh" to topLoad, "onBottomRefresh" to bottomLoad), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(unref(linesAggCityList), fun(item, index, __index, _cached): Any {
                                            return _cV(_component_x_sheet, _uM("padding" to _uA(
                                                "0"
                                            ), "margin" to _uA(
                                                "15",
                                                if (index == 0) {
                                                    "15"
                                                } else {
                                                    "0"
                                                }
                                                ,
                                                "15",
                                                "20"
                                            ), "style" to _nS(_uM("margin-bottom" to "20px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_x_collapse, _uM("onChange" to fun(){
                                                        onChange(item, index)
                                                    }
                                                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _cV(_component_x_collapse_item, _uM("showBottomLine" to false, "name" to "1", "title" to (item.startCityName + "-" + item.endCityName)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _cE(Fragment, null, RenderHelpers.renderList(unref(itemMap).get(index), fun(item2, index2, __index, _cached): Any {
                                                                        return _cV(_component_x_sheet, _uM("margin" to _uA(
                                                                            "0",
                                                                            if (index2 == 0) {
                                                                                "0"
                                                                            } else {
                                                                                "20rpx"
                                                                            }
                                                                            ,
                                                                            "0",
                                                                            "0"
                                                                        ), "class" to "flex-row flex-row-center-between", "color" to unref(globalData).theme.painColor), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                            return _uA(
                                                                                _cE("view", _uM("class" to "left-box flex-row flex-row-center-between"), _uA(
                                                                                    _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location-filled.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                                        "src"
                                                                                    )),
                                                                                    _cE("text", _uM("class" to "pl-5"), _tD(item2.districtToCityName), 1)
                                                                                )),
                                                                                _cE("view", _uM("class" to "right-box flex-row flex-row-center-between", "onClick" to fun(){
                                                                                    toViewDistinct(item2)
                                                                                }
                                                                                ), _uA(
                                                                                    _cE("text", _uM("style" to _nS("color: " + unref(globalData).theme.primaryColor + ";")), "查看区县", 4),
                                                                                    _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                                        "src"
                                                                                    ))
                                                                                ), 8, _uA(
                                                                                    "onClick"
                                                                                ))
                                                                            )
                                                                        }
                                                                        ), "_" to 2), 1032, _uA(
                                                                            "margin",
                                                                            "color"
                                                                        ))
                                                                    }
                                                                    ), 256)
                                                                )
                                                            }
                                                            ), "_" to 2), 1032, _uA(
                                                                "title"
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 2), 1032, _uA(
                                                        "onChange"
                                                    ))
                                                )
                                            }
                                            ), "_" to 2), 1032, _uA(
                                                "margin",
                                                "style"
                                            ))
                                        }
                                        ), 256),
                                        if (unref(linesAggCityList).length <= 0) {
                                            _cV(_component_x_empty, _uM("key" to 0, "loading" to false, "empty" to true, "showBtn" to false))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    )
                                }
                                ), "_" to 1), 8, _uA(
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
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("left-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "icon" to _uM(".left-box " to _uM("width" to 12, "height" to 14), ".right-box " to _uM("width" to 6, "height" to 12, "marginLeft" to "10rpx")), "btn-group-panel" to _pS(_uM("position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
