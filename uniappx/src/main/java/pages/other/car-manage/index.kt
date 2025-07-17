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
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.mcAmapNavPlus.checkLocationPermission
import uts.sdk.modules.mcAmapNavPlus.init
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
            val tabs = utsArrayOf(
                TABS_ITEM_INFO(title = "我的录入"),
                TABS_ITEM_INFO(title = "我的绑定")
            )
            val currentSwiper = ref<Number>(0)
            val isfresh = ref<Boolean>(false)
            val bottomFresh = ref<Boolean>(false)
            var scrollDirection = "down"
            val enteringVehicleList = ref(utsArrayOf<CarInfo1>())
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
                    enteringVehicleList.value = JSON.parseArray<CarInfo1>(JSON.stringify(res.data)) ?: utsArrayOf()
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
                    enteringVehicleList.value = JSON.parseArray<CarInfo1>(JSON.stringify(res.data)) ?: utsArrayOf()
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
                return createVNode(_component_mc_base_container, utsMapOf("title" to "车辆管理", "scroll" to false), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "tabs"), utsArrayOf(
                            createVNode(_component_x_tabs, utsMapOf("modelValue" to unref(acitveTab), "onUpdate:modelValue" to fun(`$event`: String){
                                trySetRefValue(acitveTab, `$event`)
                            }
                            , "onChange" to onTabChange, "itemWidth" to "50%", "line-full" to false, "line-height" to "3", "title-color" to "#000000", "line-color" to "#000000", "list" to tabs), utsMapOf("default" to withScopedSlotCtx(fun(slotProps: GenUniModulesTmxUiComponentsXTabsXTabsSlotDataDefault): UTSArray<Any> {
                                val item = slotProps.item
                                val active = slotProps.active
                                return utsArrayOf(
                                    createVNode(_component_x_text, utsMapOf("style" to normalizeStyle(utsArrayOf(
                                        utsMapOf("padding" to "0 10px", "font-size" to "20px"),
                                        utsMapOf("font-weight" to if (active) {
                                            "700"
                                        } else {
                                            "400"
                                        }
                                        )
                                    ))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            toDisplayString(item.title)
                                        )
                                    }
                                    ), "_" to 2), 1032, utsArrayOf(
                                        "style"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "modelValue"
                            ))
                        )),
                        createElementVNode("view", utsMapOf("style" to normalizeStyle("height: " + (unref(screenHeight) - 50 - unref(globalData).safeAreaBottom - 110 - 60) + "px;")), utsArrayOf(
                            createVNode(_component_x_pull_refresh, utsMapOf("pull-height" to 30, "show-scrollbar" to false, "modelValue" to unref(isfresh), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                trySetRefValue(isfresh, `$event`)
                            }
                            , "model-bottom-status" to unref(bottomFresh), "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                trySetRefValue(bottomFresh, `$event`)
                            }
                            , "onRefresh" to topLoad, "onBottomRefresh" to bottomLoad), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    if (unref(acitveTab) == "0") {
                                        createElementVNode(Fragment, utsMapOf("key" to 0), RenderHelpers.renderList(unref(enteringVehicleList), fun(item, index, __index, _cached): Any {
                                            return createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                                                "15",
                                                "15",
                                                "15",
                                                "0"
                                            )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("view", utsMapOf("class" to "car-info-item"), utsArrayOf(
                                                        createElementVNode("view", utsMapOf("class" to "left-box"), utsArrayOf(
                                                            createVNode(_component_x_image, utsMapOf("width" to "180rpx", "height" to "180rpx", "src" to ("" + unref(resBaseUrl) + "/static/images/car-logo.png")), null, 8, utsArrayOf(
                                                                "src"
                                                            )),
                                                            createElementVNode("image", utsMapOf("class" to "status-icon", "src" to transEnteryIcon(item.status), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                                "src"
                                                            ))
                                                        )),
                                                        createElementVNode("view", utsMapOf("class" to "right-box"), utsArrayOf(
                                                            createElementVNode("view", utsMapOf("class" to "title"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "car-no"), toDisplayString(item.vehiclePlateNo), 1),
                                                                createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("font-size" to "23rpx"))), "（" + toDisplayString(item.vehicleColor) + "）", 5)
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "tag-item"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "tag"), toDisplayString(item.vehicleRatifiedPeople) + "座", 1),
                                                                if (item.status == 1) {
                                                                    createElementVNode("text", utsMapOf("key" to 0, "class" to "tag-status ml-3"), "录入中")
                                                                } else {
                                                                    createCommentVNode("v-if", true)
                                                                },
                                                                if (item.status == 6) {
                                                                    createElementVNode("text", utsMapOf("key" to 1, "class" to "tag-status ml-3", "style" to normalizeStyle(utsMapOf("width" to "155rpx"))), "录入成功", 4)
                                                                } else {
                                                                    createCommentVNode("v-if", true)
                                                                }
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "info-item"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "label"), "车辆属性："),
                                                                createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(if (item.vehicleAttribute == 0) {
                                                                    "服务商挂靠"
                                                                } else {
                                                                    "司机自营"
                                                                }), 1)
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "info-item"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "label"), "车辆性质："),
                                                                createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(if (item.vehicleNature == 0) {
                                                                    "网约车"
                                                                } else {
                                                                    "客运车"
                                                                }), 1)
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "info-item"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "label"), "车辆信息："),
                                                                createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(item.vehicleBrand) + toDisplayString(item.vehicleModel), 1)
                                                            )),
                                                            if (item.status == 3) {
                                                                createElementVNode("view", utsMapOf("key" to 0, "class" to "btn-group"), utsArrayOf(
                                                                    createVNode(_component_mc_primary_button, utsMapOf("span" to -1, "height" to "35px", "onClick" to fun(){
                                                                        toEdit(item)
                                                                    }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                        return utsArrayOf(
                                                                            "重新申请"
                                                                        )
                                                                    }), "_" to 2), 1032, utsArrayOf(
                                                                        "onClick"
                                                                    ))
                                                                ))
                                                            } else {
                                                                createCommentVNode("v-if", true)
                                                            },
                                                            if (item.status == 1) {
                                                                createElementVNode("view", utsMapOf("key" to 1, "class" to "btn-group"), utsArrayOf(
                                                                    createVNode(_component_mc_primary_button, utsMapOf("span" to -1, "height" to "35px", "onClick" to fun(){
                                                                        toEdit(item)
                                                                    }), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                        return utsArrayOf(
                                                                            "编辑"
                                                                        )
                                                                    }), "_" to 2), 1032, utsArrayOf(
                                                                        "onClick"
                                                                    ))
                                                                ))
                                                            } else {
                                                                createCommentVNode("v-if", true)
                                                            }
                                                        ))
                                                    ))
                                                )
                                            }), "_" to 2), 1024)
                                        }), 256)
                                    } else {
                                        createCommentVNode("v-if", true)
                                    }
                                    ,
                                    if (unref(acitveTab) == "1") {
                                        createElementVNode(Fragment, utsMapOf("key" to 1), RenderHelpers.renderList(unref(enteringVehicleList), fun(item, index, __index, _cached): Any {
                                            return createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                                                "15",
                                                "15",
                                                "15",
                                                "0"
                                            ), "height" to "300rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("view", utsMapOf("class" to "car-info-item"), utsArrayOf(
                                                        createElementVNode("view", utsMapOf("class" to "left-box"), utsArrayOf(
                                                            createVNode(_component_x_image, utsMapOf("width" to "180rpx", "height" to "180rpx", "src" to ("" + unref(resBaseUrl) + "/static/images/car-logo.png")), null, 8, utsArrayOf(
                                                                "src"
                                                            )),
                                                            createElementVNode("image", utsMapOf("class" to "status-icon", "src" to transBindIcon(item.status), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                                "src"
                                                            ))
                                                        )),
                                                        createElementVNode("view", utsMapOf("class" to "right-box"), utsArrayOf(
                                                            createElementVNode("view", utsMapOf("class" to "title"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "car-no"), toDisplayString(item.vehiclePlateNo), 1),
                                                                createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("font-size" to "23rpx"))), "（" + toDisplayString(item.vehicleColor) + "）", 5)
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "tag-item"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "tag"), toDisplayString(item.vehicleRatifiedPeople) + "座", 1)
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "info-item"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "label"), "车辆属性："),
                                                                createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(if (item.vehicleAttribute == 0) {
                                                                    "服务商挂靠"
                                                                } else {
                                                                    "司机自营"
                                                                }), 1)
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "info-item"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "label"), "车辆性质："),
                                                                createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(if (item.vehicleNature == 0) {
                                                                    "网约车"
                                                                } else {
                                                                    "客运车"
                                                                }), 1)
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "info-item"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "label"), "车辆信息："),
                                                                createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(item.vehicleBrand) + toDisplayString(item.vehicleModel), 1)
                                                            ))
                                                        ))
                                                    ))
                                                )
                                            }), "_" to 2), 1024)
                                        }), 256)
                                    } else {
                                        createCommentVNode("v-if", true)
                                    }
                                    ,
                                    if (unref(enteringVehicleList).length <= 0) {
                                        createVNode(_component_x_empty, utsMapOf("key" to 2, "loading" to false, "empty" to true, "showBtn" to false))
                                    } else {
                                        createCommentVNode("v-if", true)
                                    }
                                )
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "modelValue",
                                "model-bottom-status"
                            ))
                        ), 4),
                        createElementVNode("view", utsMapOf("class" to "btn-group-panel", "style" to normalizeStyle("padding-bottom: " + (unref(globalData).safeAreaBottom + 15) + "px;")), utsArrayOf(
                            createVNode(_component_mc_pain_button, utsMapOf("border" to ("1px solid " + unref(globalData).theme.primaryColor), "color" to unref(globalData).theme.primaryColor, "margin-right" to "10px", "height" to "45px", "onClick" to toBindOtherCar), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    "绑定他人车辆"
                                )
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "border",
                                "color"
                            )),
                            createVNode(_component_mc_primary_button, utsMapOf("height" to "45px", "onClick" to toAdd), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
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
            normalizeCssStyles(utsArrayOf(
                styles0
            ), utsArrayOf(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("tabs" to padStyleMapOf(utsMapOf("backgroundColor" to "#ffffff", "width" to "100%", "paddingTop" to 0, "paddingRight" to 30, "paddingBottom" to 0, "paddingLeft" to 30)), "car-info-item" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "flex-start")), "left-box" to utsMapOf(".car-info-item " to utsMapOf("width" to 115, "height" to 100, "position" to "relative")), "status-icon" to utsMapOf(".car-info-item .left-box " to utsMapOf("width" to 70, "height" to 50, "position" to "absolute", "right" to 0, "bottom" to 0)), "title" to utsMapOf(".car-info-item .right-box " to utsMapOf("paddingBottom" to 4, "flexDirection" to "row", "alignItems" to "center", "width" to "400rpx")), "car-no" to utsMapOf(".car-info-item .right-box .title " to utsMapOf("fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000", "flexDirection" to "row", "alignItems" to "center")), "tag-item" to utsMapOf(".car-info-item .right-box " to utsMapOf("flexDirection" to "row")), "tag" to utsMapOf(".car-info-item .right-box .tag-item " to utsMapOf("paddingTop" to 1, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#C78300", "borderRightColor" to "#C78300", "borderBottomColor" to "#C78300", "borderLeftColor" to "#C78300", "fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#C78300", "width" to "90rpx")), "tag-status" to utsMapOf(".car-info-item .right-box .tag-item " to utsMapOf("paddingTop" to 1, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#C78300", "borderRightColor" to "#C78300", "borderBottomColor" to "#C78300", "borderLeftColor" to "#C78300", "fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#C78300", "width" to "130rpx")), "info-item" to utsMapOf(".car-info-item .right-box " to utsMapOf("flexDirection" to "row", "paddingTop" to "4rpx", "paddingRight" to 0, "paddingBottom" to "4rpx", "paddingLeft" to 0, "boxSizing" to "border-box")), "label" to utsMapOf(".car-info-item .right-box .info-item " to utsMapOf("color" to "#777676", "fontSize" to "26rpx")), "value" to utsMapOf(".car-info-item .right-box .info-item " to utsMapOf("color" to "#000000", "fontSize" to "26rpx")), "btn-group" to utsMapOf(".car-info-item .right-box " to utsMapOf("paddingTop" to 5, "paddingBottom" to 3, "paddingRight" to 15, "boxSizing" to "border-box", "flexDirection" to "row", "justifyContent" to "flex-end")), "btn-group-panel" to padStyleMapOf(utsMapOf("width" to "100%", "backgroundColor" to "#ffffff", "position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "paddingTop" to 15, "paddingLeft" to 15, "paddingRight" to 15, "flexDirection" to "row", "justifyContent" to "space-between")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
