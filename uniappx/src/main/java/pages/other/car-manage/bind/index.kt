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
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import uts.sdk.modules.xModalS.showModal
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesOtherCarManageBindIndex : BasePage {
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
        var setup: (__props: GenPagesOtherCarManageBindIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherCarManageBindIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val router = uni_useKuxRouter()
            val isfresh = ref<Boolean>(false)
            val bottomFresh = ref<Boolean>(false)
            var scrollDirection = "down"
            val bindVehicleList = ref(_uA<CarInfo1>())
            val parentAcitveTab = ref<String>("1")
            var page: Number = 1
            var limit: Number = 5
            val queryBindVehicleList = fun(){
                showLoading(XLOADINGS_TYPE(title = "加载中..."))
                getBindOtherVehicleList(page, limit).then(fun(res: Response){
                    hideXloading()
                    val result = res.data as UTSJSONObject
                    val totalRes = result.getNumber("total") ?: 0
                    val records = result.getArray("records")
                    var dataList = _uA<CarInfo1>()
                    if (records != null && records.length > 0) {
                        records.forEach(fun(item){
                            val itemJson = JSON.parse<CarInfo1>(JSON.stringify(item)) as CarInfo1
                            dataList.push(itemJson)
                        })
                    } else {
                        if (totalRes <= 0) {
                            bindVehicleList.value = dataList
                        }
                    }
                    if (scrollDirection == "down") {
                        isfresh.value = false
                        bindVehicleList.value = dataList
                    } else {
                        bottomFresh.value = false
                        bindVehicleList.value = bindVehicleList.value.concat(dataList)
                    }
                }
                )
            }
            val topLoad = fun(){
                console.log("下拉刷新")
                scrollDirection = "down"
                page = 1
                queryBindVehicleList()
            }
            val bottomLoad = fun(){
                console.log("触底刷新")
                scrollDirection = "up"
                page++
                queryBindVehicleList()
            }
            val toBind = fun(item: CarInfo1){
                showModal(X_MODAL_TYPE(title = "温馨提示", content = "确认要绑定该车辆吗?", confirmText = "确认", clickMaskClose = false, confirmBgColor = globalData.theme.primaryColor, confirm = fun(){
                    boundVehicle(item.id as String).then(fun(res: Response){
                        if (res.code == 200) {
                            showToast("提交成功", "success")
                            setTimeout(fun(){
                                uni_navigateBack(null)
                            }
                            , 1500)
                        }
                    }
                    )
                }
                ))
            }
            onReady(fun(){
                queryBindVehicleList()
            }
            )
            onLoad(fun(options){
                if (options != null) {
                    val opt = JSON.parse(JSON.stringify(options)) as UTSJSONObject
                    console.log("opt=", opt)
                    parentAcitveTab.value = opt.getString("acitveTab") ?: "1"
                }
            }
            )
            return fun(): Any? {
                val _component_x_image = resolveEasyComponent("x-image", GenUniModulesTmxUiComponentsXImageXImageClass)
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_empty = resolveEasyComponent("x-empty", GenUniModulesTmxUiComponentsXEmptyXEmptyClass)
                val _component_x_pull_refresh = resolveEasyComponent("x-pull-refresh", GenUniModulesTmxUiComponentsXPullRefreshXPullRefreshClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return _cV(_component_mc_base_container, _uM("title" to "绑定车辆", "scroll" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("style" to _nS("position: relative;height: " + (unref(screenHeight) - 50 - unref(globalData).safeAreaBottom - unref(statusBarHeight) - unref(statusBarHeight)) + "px;")), _uA(
                            _cV(_component_x_pull_refresh, _uM("pull-height" to 30, "show-scrollbar" to false, "modelValue" to unref(isfresh), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                trySetRefValue(isfresh, `$event`)
                            }
                            , "model-bottom-status" to unref(bottomFresh), "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                trySetRefValue(bottomFresh, `$event`)
                            }
                            , "onRefresh" to topLoad, "onBottomRefresh" to bottomLoad), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(bindVehicleList), fun(item, index, __index, _cached): Any {
                                        return _cV(_component_x_sheet, _uM("margin" to _uA(
                                            "15",
                                            "15",
                                            "15",
                                            "0"
                                        ), "padding" to _uA(
                                            "20",
                                            "20",
                                            "10",
                                            "10"
                                        )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "car-info-item"), _uA(
                                                    _cE("view", _uM("class" to "left-box"), _uA(
                                                        _cV(_component_x_image, _uM("width" to "180rpx", "height" to "180rpx", "src" to ("" + unref(resBaseUrl) + "/static/images/car-logo.png")), null, 8, _uA(
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
                                                            }
                                                            ), 1)
                                                        )),
                                                        _cE("view", _uM("class" to "info-item"), _uA(
                                                            _cE("text", _uM("class" to "label"), "车辆性质："),
                                                            _cE("text", _uM("class" to "value"), _tD(if (item.vehicleNature == 0) {
                                                                "网约车"
                                                            } else {
                                                                "客运车"
                                                            }
                                                            ), 1)
                                                        )),
                                                        _cE("view", _uM("class" to "info-item"), _uA(
                                                            _cE("text", _uM("class" to "label"), "车辆信息："),
                                                            _cV(_component_x_text, _uM("class" to "value", "fontSize" to "26rpx", "lines" to 2, "_style" to "width: 300rpx;"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _tD(item.vehicleBrand) + _tD(item.vehicleModel)
                                                                )
                                                            }
                                                            ), "_" to 2), 1024)
                                                        )),
                                                        _cE("view", _uM("class" to "btn-group"), _uA(
                                                            _cV(_component_mc_primary_button, _uM("span" to -1, "height" to "35px", "onClick" to fun(){
                                                                toBind(item)
                                                            }
                                                            ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    "立即绑定"
                                                                )
                                                            }
                                                            ), "_" to 2), 1032, _uA(
                                                                "onClick"
                                                            ))
                                                        ))
                                                    ))
                                                ))
                                            )
                                        }
                                        ), "_" to 2), 1024)
                                    }
                                    ), 256),
                                    if (unref(bindVehicleList).length <= 0) {
                                        _cV(_component_x_empty, _uM("key" to 0, "loading" to false, "empty" to true, "showBtn" to false))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "modelValue",
                                "model-bottom-status"
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
                return _uM("tabs" to _pS(_uM("backgroundColor" to "#ffffff", "width" to "100%", "paddingTop" to 0, "paddingRight" to 30, "paddingBottom" to 0, "paddingLeft" to 30)), "car-info-item" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "flex-start")), "left-box" to _uM(".car-info-item " to _uM("width" to 115, "height" to 100, "position" to "relative")), "status-icon" to _uM(".car-info-item .left-box " to _uM("width" to 70, "height" to 50, "position" to "absolute", "right" to 0, "bottom" to 0)), "title" to _uM(".car-info-item .right-box " to _uM("paddingBottom" to 4, "flexDirection" to "row", "alignItems" to "center", "width" to "420rpx")), "car-no" to _uM(".car-info-item .right-box .title " to _uM("fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000", "flexDirection" to "row", "alignItems" to "center")), "tag" to _uM(".car-info-item .right-box .title " to _uM("paddingTop" to 1, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#C78300", "borderRightColor" to "#C78300", "borderBottomColor" to "#C78300", "borderLeftColor" to "#C78300", "fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#C78300"), ".car-info-item .right-box .tag-item " to _uM("paddingTop" to 1, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#C78300", "borderRightColor" to "#C78300", "borderBottomColor" to "#C78300", "borderLeftColor" to "#C78300", "fontWeight" to "bold", "fontSize" to "26rpx", "color" to "#C78300", "width" to "90rpx")), "tag-item" to _uM(".car-info-item .right-box " to _uM("flexDirection" to "row")), "info-item" to _uM(".car-info-item .right-box " to _uM("flexDirection" to "row", "paddingTop" to "4rpx", "paddingRight" to 0, "paddingBottom" to "4rpx", "paddingLeft" to 0, "boxSizing" to "border-box")), "label" to _uM(".car-info-item .right-box .info-item " to _uM("color" to "#777676", "fontSize" to "26rpx")), "value" to _uM(".car-info-item .right-box .info-item " to _uM("color" to "#000000", "fontSize" to "26rpx")), "btn-group" to _uM(".car-info-item .right-box " to _uM("paddingTop" to 5, "paddingBottom" to 3, "paddingRight" to 18, "boxSizing" to "border-box", "flexDirection" to "row", "justifyContent" to "flex-end")), "btn-group-panel" to _pS(_uM("width" to "100%", "backgroundColor" to "#ffffff", "position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "paddingTop" to 15, "paddingLeft" to 15, "paddingRight" to 15, "flexDirection" to "row", "justifyContent" to "space-between")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
