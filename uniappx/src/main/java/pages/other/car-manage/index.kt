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
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesOtherCarManageIndex : BasePage {
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
        var setup: (__props: GenPagesOtherCarManageIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherCarManageIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val acitveTab = ref<String>("0")
            val router = uni_useKuxRouter()
            val tabs = _uA(
                TABS_ITEM_INFO(title = "我的录入"),
                TABS_ITEM_INFO(title = "我的绑定")
            )
            val currentSwiper = ref<Number>(0)
            val isfresh = ref<Boolean>(false)
            val bottomFresh = ref<Boolean>(false)
            var scrollDirection = "down"
            val enteringVehicleListMyenter = ref(_uA<CarInfo1>())
            val enteringVehicleList = ref(_uA<CarInfo1>())
            val transEnteryIcon = fun(status: Number): String {
                var iconPath = ""
                when (status) {
                    2 -> 
                        iconPath = "" + resBaseUrl + "/static/icons/icon-car-bind-service-approving.png"
                    3 -> 
                        iconPath = "" + resBaseUrl + "/static/icons/icon-car-bind-platform-reject.png"
                    4 -> 
                        iconPath = "" + resBaseUrl + "/static/icons/icon-car-binded.png"
                    6 -> 
                        iconPath = "" + resBaseUrl + "/static/icons/icon-car-saved.png"
                    else -> 
                        {}
                }
                return iconPath
            }
            val transBindIcon = fun(status: Number): String {
                var iconPath = ""
                when (status) {
                    1 -> 
                        iconPath = "" + resBaseUrl + "/static/icons/icon-car-bind-service-approving.png"
                    2 -> 
                        iconPath = "" + resBaseUrl + "/static/icons/icon-car-bind-platform-reject.png"
                    3 -> 
                        iconPath = "" + resBaseUrl + "/static/icons/icon-car-binded.png"
                    else -> 
                        {}
                }
                return iconPath
            }
            val queryEnteringVehicleList = fun(){
                showLoading(XLOADINGS_TYPE(title = "加载中..."))
                getEnteringVehicleList().then(fun(res: Response){
                    hideXloading()
                    enteringVehicleListMyenter.value = JSON.parseArray<CarInfo1>(JSON.stringify(res.data)) ?: _uA()
                    if (scrollDirection == "down") {
                        isfresh.value = false
                    } else {
                        bottomFresh.value = false
                    }
                }
                )
            }
            val queryBindVehicleList = fun(){
                showLoading(XLOADINGS_TYPE(title = "加载中..."))
                getBindVehicleList().then(fun(res: Response){
                    hideXloading()
                    enteringVehicleList.value = JSON.parseArray<CarInfo1>(JSON.stringify(res.data)) ?: _uA()
                    if (scrollDirection == "down") {
                        isfresh.value = false
                    } else {
                        bottomFresh.value = false
                    }
                }
                )
            }
            val onTabChange = fun(_: TABS_ITEM, index: Number){
                if (index == 0) {
                    queryEnteringVehicleList()
                } else {
                    queryBindVehicleList()
                }
            }
            val topLoad = fun(){
                console.log("下拉刷新")
                scrollDirection = "down"
                if (acitveTab.value == "0") {
                    queryEnteringVehicleList()
                } else {
                    queryBindVehicleList()
                }
            }
            val bottomLoad = fun(){
                console.log("触底刷新")
                scrollDirection = "up"
                if (acitveTab.value == "0") {
                    queryEnteringVehicleList()
                } else {
                    queryBindVehicleList()
                }
            }
            val toEdit = fun(item: CarInfo1){
                val vehicleId = item.id as String
                console.log("toEdit id=", vehicleId)
                router.push("/pages/other/car-manage/add/index?vehicleId=" + vehicleId)
            }
            val toBindOtherCar = fun(){
                router.push("/pages/other/car-manage/bind/index?acitveTab=" + acitveTab)
            }
            val toAdd = fun(){
                router.push("/pages/other/car-manage/add/index")
            }
            val init = fun(){
                queryEnteringVehicleList()
            }
            onReady(fun(){
                init()
            }
            )
            onPageShow(fun(){
                console.log("车辆显示")
                if (acitveTab.value == "0") {
                    queryEnteringVehicleList()
                } else {
                    queryBindVehicleList()
                }
            }
            )
            return fun(): Any? {
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_x_tabs = resolveEasyComponent("x-tabs", GenUniModulesTmxUiComponentsXTabsXTabsClass)
                val _component_x_image = resolveEasyComponent("x-image", GenUniModulesTmxUiComponentsXImageXImageClass)
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_empty = resolveEasyComponent("x-empty", GenUniModulesTmxUiComponentsXEmptyXEmptyClass)
                val _component_x_pull_refresh = resolveEasyComponent("x-pull-refresh", GenUniModulesTmxUiComponentsXPullRefreshXPullRefreshClass)
                val _component_mc_pain_button = resolveEasyComponent("mc-pain-button", GenComponentsMcPainButtonIndexClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return _cV(_component_mc_base_container, _uM("title" to "车辆管理", "scroll" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "tabs"), _uA(
                            _cV(_component_x_tabs, _uM("modelValue" to unref(acitveTab), "onUpdate:modelValue" to fun(`$event`: String){
                                trySetRefValue(acitveTab, `$event`)
                            }
                            , "onChange" to onTabChange, "itemWidth" to "50%", "line-full" to false, "line-height" to "3", "title-color" to "#000000", "line-color" to "#000000", "list" to tabs), _uM("default" to withScopedSlotCtx(fun(slotProps: GenUniModulesTmxUiComponentsXTabsXTabsSlotDataDefault): UTSArray<Any> {
                                val item = slotProps.item
                                val active = slotProps.active
                                return _uA(
                                    _cV(_component_x_text, _uM("style" to _nS(_uA(
                                        _uM("padding" to "0 10px", "font-size" to "20px"),
                                        _uM("font-weight" to if (active) {
                                            "700"
                                        } else {
                                            "400"
                                        }
                                        )
                                    ))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(item.title)
                                        )
                                    }
                                    ), "_" to 2), 1032, _uA(
                                        "style"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "modelValue"
                            ))
                        )),
                        _cE("view", _uM("style" to _nS("height: " + (unref(screenHeight) - 50 - unref(globalData).safeAreaBottom - 110 - 60) + "px;")), _uA(
                            _cV(_component_x_pull_refresh, _uM("pull-height" to 30, "show-scrollbar" to false, "modelValue" to unref(isfresh), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                trySetRefValue(isfresh, `$event`)
                            }
                            , "model-bottom-status" to unref(bottomFresh), "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                trySetRefValue(bottomFresh, `$event`)
                            }
                            , "onRefresh" to topLoad, "onBottomRefresh" to bottomLoad), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    if (unref(acitveTab) == "0") {
                                        _cE(Fragment, _uM("key" to 0), RenderHelpers.renderList(unref(enteringVehicleListMyenter), fun(item, index, __index, _cached): Any {
                                            return _cV(_component_x_sheet, _uM("margin" to _uA(
                                                "15",
                                                "15",
                                                "15",
                                                "0"
                                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "car-info-item"), _uA(
                                                        _cE("view", _uM("class" to "left-box"), _uA(
                                                            _cV(_component_x_image, _uM("width" to "180rpx", "height" to "180rpx", "src" to ("" + unref(resBaseUrl) + "/static/images/car-logo.png")), null, 8, _uA(
                                                                "src"
                                                            )),
                                                            _cE("image", _uM("class" to "status-icon", "src" to transEnteryIcon(item.status), "mode" to "widthFix"), null, 8, _uA(
                                                                "src"
                                                            ))
                                                        )),
                                                        _cE("view", _uM("class" to "right-box"), _uA(
                                                            _cE("view", _uM("class" to "title"), _uA(
                                                                _cE("text", _uM("class" to "car-no"), _tD(item.vehiclePlateNo), 1),
                                                                _cE("text", _uM("style" to _nS(_uM("font-size" to "23rpx"))), "（" + _tD(item.vehicleColor) + "）", 5)
                                                            )),
                                                            _cE("view", _uM("class" to "tag-item"), _uA(
                                                                _cE("text", _uM("class" to "tag"), _tD(item.vehicleRatifiedPeople) + "座", 1),
                                                                if (item.status == 1) {
                                                                    _cE("text", _uM("key" to 0, "class" to "tag-status ml-3"), "录入中")
                                                                } else {
                                                                    _cC("v-if", true)
                                                                },
                                                                if (item.status == 6) {
                                                                    _cE("text", _uM("key" to 1, "class" to "tag-status ml-3", "style" to _nS(_uM("width" to "155rpx"))), "录入成功", 4)
                                                                } else {
                                                                    _cC("v-if", true)
                                                                }
                                                            )),
                                                            _cE("view", _uM("class" to "info-item"), _uA(
                                                                _cE("text", _uM("class" to "label"), "车辆属性："),
                                                                _cE("text", _uM("class" to "value"), _tD(if (item.vehicleAttribute == 0) {
                                                                    "服务商挂靠"
                                                                } else {
                                                                    "司机自营"
                                                                }), 1)
                                                            )),
                                                            _cE("view", _uM("class" to "info-item"), _uA(
                                                                _cE("text", _uM("class" to "label"), "车辆性质："),
                                                                _cE("text", _uM("class" to "value"), _tD(if (item.vehicleNature == 0) {
                                                                    "网约车"
                                                                } else {
                                                                    "客运车"
                                                                }), 1)
                                                            )),
                                                            _cE("view", _uM("class" to "info-item"), _uA(
                                                                _cE("text", _uM("class" to "label"), "车辆信息："),
                                                                _cE("text", _uM("class" to "value"), _tD(item.vehicleBrand) + _tD(item.vehicleModel), 1)
                                                            )),
                                                            if (item.status == 3) {
                                                                _cE("view", _uM("key" to 0, "class" to "btn-group"), _uA(
                                                                    _cV(_component_mc_primary_button, _uM("span" to -1, "height" to "35px", "onClick" to fun(){
                                                                        toEdit(item)
                                                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                        return _uA(
                                                                            "重新申请"
                                                                        )
                                                                    }), "_" to 2), 1032, _uA(
                                                                        "onClick"
                                                                    ))
                                                                ))
                                                            } else {
                                                                _cC("v-if", true)
                                                            },
                                                            if (item.status == 1) {
                                                                _cE("view", _uM("key" to 1, "class" to "btn-group"), _uA(
                                                                    _cV(_component_mc_primary_button, _uM("span" to -1, "height" to "35px", "onClick" to fun(){
                                                                        toEdit(item)
                                                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                        return _uA(
                                                                            "编辑"
                                                                        )
                                                                    }), "_" to 2), 1032, _uA(
                                                                        "onClick"
                                                                    ))
                                                                ))
                                                            } else {
                                                                _cC("v-if", true)
                                                            }
                                                        ))
                                                    ))
                                                )
                                            }), "_" to 2), 1024)
                                        }), 256)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    if (unref(acitveTab) == "1") {
                                        _cE(Fragment, _uM("key" to 1), RenderHelpers.renderList(unref(enteringVehicleList), fun(item, index, __index, _cached): Any {
                                            return _cV(_component_x_sheet, _uM("margin" to _uA(
                                                "15",
                                                "15",
                                                "15",
                                                "0"
                                            ), "height" to "300rpx"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "car-info-item"), _uA(
                                                        _cE("view", _uM("class" to "left-box"), _uA(
                                                            _cV(_component_x_image, _uM("width" to "180rpx", "height" to "180rpx", "src" to ("" + unref(resBaseUrl) + "/static/images/car-logo.png")), null, 8, _uA(
                                                                "src"
                                                            )),
                                                            _cE("image", _uM("class" to "status-icon", "src" to transBindIcon(item.status), "mode" to "widthFix"), null, 8, _uA(
                                                                "src"
                                                            ))
                                                        )),
                                                        _cE("view", _uM("class" to "right-box"), _uA(
                                                            _cE("view", _uM("class" to "title"), _uA(
                                                                _cE("text", _uM("class" to "car-no"), _tD(item.vehiclePlateNo), 1),
                                                                _cE("text", _uM("style" to _nS(_uM("font-size" to "23rpx"))), "（" + _tD(item.vehicleColor) + "）", 5)
                                                            )),
                                                            _cE("view", _uM("class" to "tag-item"), _uA(
                                                                _cE("text", _uM("class" to "tag"), _tD(item.vehicleRatifiedPeople) + "座", 1)
                                                            )),
                                                            _cE("view", _uM("class" to "info-item"), _uA(
                                                                _cE("text", _uM("class" to "label"), "车辆属性："),
                                                                _cE("text", _uM("class" to "value"), _tD(if (item.vehicleAttribute == 0) {
                                                                    "服务商挂靠"
                                                                } else {
                                                                    "司机自营"
                                                                }), 1)
                                                            )),
                                                            _cE("view", _uM("class" to "info-item"), _uA(
                                                                _cE("text", _uM("class" to "label"), "车辆性质："),
                                                                _cE("text", _uM("class" to "value"), _tD(if (item.vehicleNature == 0) {
                                                                    "网约车"
                                                                } else {
                                                                    "客运车"
                                                                }), 1)
                                                            )),
                                                            _cE("view", _uM("class" to "info-item"), _uA(
                                                                _cE("text", _uM("class" to "label"), "车辆信息："),
                                                                _cE("text", _uM("class" to "value"), _tD(item.vehicleBrand) + _tD(item.vehicleModel), 1)
                                                            ))
                                                        ))
                                                    ))
                                                )
                                            }), "_" to 2), 1024)
                                        }), 256)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    if (isTrue(unref(acitveTab) == "0" && unref(enteringVehicleListMyenter).length <= 0)) {
                                        _cV(_component_x_empty, _uM("key" to 2, "loading" to false, "empty" to true, "showBtn" to false))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    if (isTrue(unref(acitveTab) == "1" && unref(enteringVehicleList).length <= 0)) {
                                        _cV(_component_x_empty, _uM("key" to 3, "loading" to false, "empty" to true, "showBtn" to false))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "modelValue",
                                "model-bottom-status"
                            ))
                        ), 4),
                        _cE("view", _uM("class" to "btn-group-panel", "style" to _nS("padding-bottom: " + (unref(globalData).safeAreaBottom + 15) + "px;")), _uA(
                            _cV(_component_mc_pain_button, _uM("border" to ("1px solid " + unref(globalData).theme.primaryColor), "color" to unref(globalData).theme.primaryColor, "margin-right" to "10px", "height" to "45px", "onClick" to toBindOtherCar), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    "绑定他人车辆"
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "border",
                                "color"
                            )),
                            _cV(_component_mc_primary_button, _uM("height" to "45px", "onClick" to toAdd), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    "添加车辆"
                                )
                            }
                            ), "_" to 1))
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
                return _uM("tabs" to _pS(_uM("backgroundColor" to "#ffffff", "width" to "100%", "paddingTop" to 0, "paddingRight" to 30, "paddingBottom" to 0, "paddingLeft" to 30)), "car-info-item" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "flex-start")), "left-box" to _uM(".car-info-item " to _uM("width" to 115, "height" to 100, "position" to "relative")), "status-icon" to _uM(".car-info-item .left-box " to _uM("width" to 70, "height" to 50, "position" to "absolute", "right" to 0, "bottom" to 0)), "title" to _uM(".car-info-item .right-box " to _uM("paddingBottom" to 4, "flexDirection" to "row", "alignItems" to "center", "width" to "400rpx")), "car-no" to _uM(".car-info-item .right-box .title " to _uM("fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000", "flexDirection" to "row", "alignItems" to "center")), "tag-item" to _uM(".car-info-item .right-box " to _uM("flexDirection" to "row")), "tag" to _uM(".car-info-item .right-box .tag-item " to _uM("paddingTop" to 1, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#C78300", "borderRightColor" to "#C78300", "borderBottomColor" to "#C78300", "borderLeftColor" to "#C78300", "fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#C78300", "width" to "90rpx")), "tag-status" to _uM(".car-info-item .right-box .tag-item " to _uM("paddingTop" to 1, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#C78300", "borderRightColor" to "#C78300", "borderBottomColor" to "#C78300", "borderLeftColor" to "#C78300", "fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#C78300", "width" to "130rpx")), "info-item" to _uM(".car-info-item .right-box " to _uM("flexDirection" to "row", "paddingTop" to "4rpx", "paddingRight" to 0, "paddingBottom" to "4rpx", "paddingLeft" to 0, "boxSizing" to "border-box")), "label" to _uM(".car-info-item .right-box .info-item " to _uM("color" to "#777676", "fontSize" to "26rpx")), "value" to _uM(".car-info-item .right-box .info-item " to _uM("color" to "#000000", "fontSize" to "26rpx")), "btn-group" to _uM(".car-info-item .right-box " to _uM("paddingTop" to 5, "paddingBottom" to 3, "paddingRight" to 15, "boxSizing" to "border-box", "flexDirection" to "row", "justifyContent" to "flex-end")), "btn-group-panel" to _pS(_uM("width" to "100%", "backgroundColor" to "#ffffff", "position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "paddingTop" to 15, "paddingLeft" to 15, "paddingRight" to 15, "flexDirection" to "row", "justifyContent" to "space-between")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
