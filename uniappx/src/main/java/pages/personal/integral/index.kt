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
open class GenPagesPersonalIntegralIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalIntegralIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalIntegralIndex
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val cacheUserInfo = ref<Any?>(null)
            val globalData = inject("globalData") as GlobalDataType
            val transactions = ref(_uA<TransactionItem1>())
            val date = ref<String>(formatDate(Date(), "yyyy-MM-dd"))
            val myIntegral = ref<Number>(0)
            val isfresh = ref<Boolean>(false)
            val bottomFresh = ref<Boolean>(false)
            var scrollDirection = "down"
            var page: Number = 1
            var limit: Number = 7
            val doQuery = fun(scrollDirection: String){
                val param: UTSJSONObject = _uO("type" to 2, "yearMonth" to date.value, "page" to page, "limit" to limit)
                console.log("doQuery param=", param)
                getWalletLogVO(param).then(fun(res: Response){
                    val result = res.data as UTSJSONObject
                    val totalRes = result.getNumber("total") as Number
                    if (totalRes != null) {
                        totalRes
                    } else {
                        0
                    }
                    val records = result.getArray("records")
                    var dataList = _uA<TransactionItem1>()
                    if (records != null) {
                        records.forEach(fun(item){
                            val itemJson = JSON.parse<TransactionItem1>(JSON.stringify(item)) as TransactionItem1
                            itemJson.icon = transIconByType(itemJson.relevanceType)
                            dataList.push(itemJson)
                        }
                        )
                    }
                    if (scrollDirection == "down") {
                        transactions.value = dataList
                        isfresh.value = false
                    } else {
                        transactions.value = transactions.value.concat(dataList)
                        bottomFresh.value = false
                    }
                }
                )
            }
            val toIntegralExchange = fun(){
                console.log("前往积分兑换页面")
                showToast("建设中...", "success")
            }
            val onScrollDirection = fun(type: String){
                scrollDirection = type
            }
            val topLoad = fun(){
                console.log("下拉刷新")
                page = 1
                doQuery(scrollDirection)
            }
            val bottomLoad = fun(){
                console.log("触底刷新")
                page++
                doQuery(scrollDirection)
            }
            val hisQuery = fun(){
                page = 1
                if (date.value == null || date.value == "") {
                    date.value = formatDate(Date(), "yyyy-MM")
                } else {
                    date.value = date.value.substring(0, 7)
                }
                console.log("点击时间查询", date.value)
                doQuery(scrollDirection)
            }
            val balanceQuery = fun(){
                getWallet().then(fun(res: Response){
                    val result = res.data as UTSJSONObject
                    console.log("balanceQuery==", result)
                    val assetIntegralNum = result.getNumber("assetIntegral")
                    myIntegral.value = if (assetIntegralNum == null) {
                        0
                    } else {
                        assetIntegralNum
                    }
                }
                )
            }
            onReady(fun(){
                balanceQuery()
                hisQuery()
            }
            )
            return fun(): Any? {
                val _component_mc_date_picker_selector = resolveEasyComponent("mc-date-picker-selector", GenComponentsMcDatePickerSelectorIndexClass)
                val _component_x_empty = resolveEasyComponent("x-empty", GenUniModulesTmxUiComponentsXEmptyXEmptyClass)
                val _component_x_pull_refresh = resolveEasyComponent("x-pull-refresh", GenUniModulesTmxUiComponentsXPullRefreshXPullRefreshClass)
                val _component_template = resolveComponent("template")
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return _cV(_component_mc_base_container, _uM("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to true, "title" to "积分管理", "title-color" to "#F5F7FA"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("style" to _nS("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        _cE("view", _uM("class" to "home-bg"), _uA(
                            _cE("image", _uM("class" to "bg-image", "src" to ("" + unref(resBaseUrl) + "/static/images/wallet-back.png"), "mode" to "widthFix"), null, 8, _uA(
                                "src"
                            ))
                        )),
                        _cE("view", _uM("class" to "container"), _uA(
                            _cE("view", _uM("class" to "balance-card"), _uA(
                                _cE("view", _uM("class" to "balance-left"), _uA(
                                    _cE("view", _uM("class" to "balance-title"), _uA(
                                        _cE("text", _uM("class" to "color-white"), "我的积分")
                                    )),
                                    _cE("view", _uM("class" to "balance-amount"), _uA(
                                        _cE("text", _uM("class" to "color-white", "style" to _nS(_uM("font-size" to "30px", "font-weight" to "bold"))), _tD(unref(myIntegral)), 5)
                                    ))
                                )),
                                _cE("view", _uM("class" to "balance-right"), _uA(
                                    _cE("view", _uM("class" to "withdraw-btn", "onClick" to toIntegralExchange), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("color" to "#5870A3", "text-align" to "center"))), "积分兑换", 4)
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "transaction-card"), _uA(
                                _cE("image", _uM("class" to "transaction-card-back-image", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-wallet-rounded-rectangle2.png"), "mode" to "widthFix"), null, 8, _uA(
                                    "src"
                                )),
                                _cE("view", _uM("class" to "transaction-header"), _uA(
                                    _cE("view", null, _uA(
                                        _cE("text", _uM("class" to "header-title"), "积分明细")
                                    )),
                                    _cV(_component_mc_date_picker_selector, _uM("modelValue" to unref(date), "onUpdate:modelValue" to fun(`$event`: String){
                                        trySetRefValue(date, `$event`)
                                    }
                                    , "onChange" to hisQuery), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "left-box", "style" to _nS("width: " + (unref(screenWidth) - 115) + "px;")), _uA(
                                                _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-date.png")), null, 8, _uA(
                                                    "src"
                                                )),
                                                _cE("text", _uM("class" to "text"), _tD(if (unref(date) != "") {
                                                    unref(date)
                                                } else {
                                                    "请选择月份"
                                                }
                                                ), 1)
                                            ), 4)
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "modelValue"
                                    ))
                                )),
                                _cV(_component_template, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cV(_component_x_pull_refresh, _uM("modelValue" to unref(isfresh), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                            trySetRefValue(isfresh, `$event`)
                                        }
                                        , "show-scrollbar" to false, "onScrollDirection" to onScrollDirection, "model-bottom-status" to unref(bottomFresh), "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                            trySetRefValue(bottomFresh, `$event`)
                                        }
                                        , "onRefresh" to topLoad, "onBottomRefresh" to bottomLoad, "height" to ((unref(screenHeight) - unref(globalData).safeAreaBottom - unref(statusBarHeight) - 270) + "px"), ";" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "transaction-list"), _uA(
                                                    _cE(Fragment, null, RenderHelpers.renderList(unref(transactions), fun(item, index, __index, _cached): Any {
                                                        return _cE("view", _uM("class" to "transaction-item", "key" to index), _uA(
                                                            _cE("view", null, _uA(
                                                                _cE("image", _uM("class" to "transaction-icon", "src" to item.icon), null, 8, _uA(
                                                                    "src"
                                                                ))
                                                            )),
                                                            _cE("view", _uM("class" to "transaction-info"), _uA(
                                                                _cE("view", _uM("class" to "transaction-title"), _tD(item.relevanceType), 1),
                                                                _cE("view", _uM("class" to "transaction-time"), _tD(item.createTime), 1)
                                                            )),
                                                            _cE("view", _uM("class" to "transaction-amount"), _uA(
                                                                _cE("text", _uM("class" to _nC(if (item.balanceChange > 0) {
                                                                    "income"
                                                                } else {
                                                                    "expense"
                                                                }
                                                                )), _tD(if (item.balanceChange > 0) {
                                                                    "+" + item.balanceChange
                                                                } else {
                                                                    "-" + item.balanceChange
                                                                }
                                                                ), 3)
                                                            ))
                                                        ))
                                                    }
                                                    ), 128)
                                                )),
                                                if (unref(transactions).length <= 0) {
                                                    _cV(_component_x_empty, _uM("key" to 0, "loading" to false, "empty" to true, "showBtn" to false))
                                                } else {
                                                    _cC("v-if", true)
                                                }
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "modelValue",
                                            "model-bottom-status",
                                            "height"
                                        ))
                                    )
                                }
                                ), "_" to 1))
                            ))
                        ))
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
                return _uM("container" to _pS(_uM("width" to "100%", "height" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 50)), "home-bg" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "height" to "100%", "zIndex" to -1)), "bg-image" to _uM(".home-bg " to _uM("position" to "absolute", "height" to "100%", "width" to "100%", "top" to 0, "left" to 0)), "color-white" to _pS(_uM("color" to "#F5F7FA")), "balance-card" to _pS(_uM("width" to "100%", "backgroundColor" to "rgba(0,0,0,0)", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "color" to "#ffffff", "marginBottom" to "35rpx", "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "balance-title" to _uM(".balance-card .balance-left " to _uM("fontSize" to 16, "color" to "rgba(255,255,255,0.9)", "display" to "flex", "alignItems" to "center", "marginBottom" to 5, "flexDirection" to "row")), "balance-amount" to _uM(".balance-card .balance-left " to _uM("fontSize" to 36, "fontWeight" to "bold", "color" to "#ffffff")), "balance-right" to _uM(".balance-card " to _uM("display" to "flex", "flexDirection" to "column", "alignItems" to "flex-end", "width" to "170rpx", "height" to "55rpx")), "withdraw-btn" to _uM(".balance-card .balance-right " to _uM("fontSize" to "28rpx", "color" to "#ffffff", "backgroundColor" to "#F5F7FA", "paddingTop" to "12rpx", "paddingRight" to "12rpx", "paddingBottom" to "12rpx", "paddingLeft" to "12rpx", "borderTopLeftRadius" to "28rpx", "borderTopRightRadius" to "28rpx", "borderBottomRightRadius" to "28rpx", "borderBottomLeftRadius" to "28rpx", "width" to "170rpx", "height" to "55rpx", "alignItems" to "center")), "transaction-card" to _pS(_uM("width" to "100%", "backgroundColor" to "rgba(0,0,0,0)", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "paddingTop" to 0, "paddingRight" to 20, "paddingBottom" to 0, "paddingLeft" to 20, "top" to 0, "left" to 0)), "transaction-card-back-image" to _uM(".transaction-card " to _uM("width" to "100%", "position" to "absolute", "top" to 0, "left" to 0)), "transaction-header" to _uM(".transaction-card " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to 15, "paddingRight" to 0, "paddingBottom" to 15, "paddingLeft" to 0, "marginTop" to -5)), "header-title" to _uM(".transaction-card .transaction-header " to _uM("fontSize" to 18, "fontWeight" to "bold")), "left-box" to _uM(".transaction-card .transaction-header " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "marginLeft" to 90)), "icon" to _uM(".transaction-card .transaction-header .left-box " to _uM("width" to 15, "height" to 15, "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10)), "text" to _uM(".transaction-card .transaction-header .left-box " to _uM("fontWeight" to "400", "fontSize" to 18, "color" to "#000000")), "text-btn" to _uM(".transaction-card .transaction-header .left-box " to _uM("fontWeight" to "400", "fontSize" to 18, "color" to "#000000")), "transaction-summary" to _uM(".transaction-card " to _uM("display" to "flex", "flexDirection" to "row", "paddingTop" to 15, "paddingRight" to 0, "paddingBottom" to 15, "paddingLeft" to 0)), "summary-item" to _uM(".transaction-card .transaction-summary " to _uM("flex" to 1, "display" to "flex", "flexDirection" to "column", "alignItems" to "center")), "summary-amount" to _uM(".transaction-card .transaction-summary .summary-item " to _uM("marginBottom" to 5), ".transaction-card .transaction-summary .summary-item.income " to _uM("color" to "#2D9E62"), ".transaction-card .transaction-summary .summary-item.expense " to _uM("color" to "#F56C6C")), "summary-label" to _uM(".transaction-card .transaction-summary .summary-item " to _uM("color" to "#666666", "width" to 80, "height" to 24, "backgroundImage" to "none", "backgroundColor" to "#E0EAFF", "borderTopLeftRadius" to 24, "borderTopRightRadius" to 24, "borderBottomRightRadius" to 24, "borderBottomLeftRadius" to 24, "alignItems" to "center", "paddingTop" to 3, "paddingRight" to 3, "paddingBottom" to 3, "paddingLeft" to 3)), "summary-divider" to _uM(".transaction-card .transaction-summary " to _uM("width" to 2, "height" to 40, "backgroundColor" to "#eeeeee", "marginTop" to "auto", "marginRight" to 0, "marginBottom" to "auto", "marginLeft" to 0)), "transaction-list" to _uM(".transaction-card " to _uM("paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "transaction-item" to _uM(".transaction-card .transaction-list " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "paddingTop" to 15, "paddingRight" to 0, "paddingBottom" to 15, "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f0f0f0", "borderBottomWidth:last-child" to "medium", "borderBottomStyle:last-child" to "none", "borderBottomColor:last-child" to "#000000")), "transaction-icon" to _uM(".transaction-card .transaction-list .transaction-item " to _uM("width" to 40, "height" to 40, "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "marginRight" to 15)), "transaction-info" to _uM(".transaction-card .transaction-list .transaction-item " to _uM("flex" to 1)), "transaction-title" to _uM(".transaction-card .transaction-list .transaction-item .transaction-info " to _uM("fontSize" to 16, "color" to "#333333", "marginBottom" to 5)), "transaction-time" to _uM(".transaction-card .transaction-list .transaction-item .transaction-info " to _uM("fontSize" to 12, "color" to "#999999")), "transaction-amount" to _uM(".transaction-card .transaction-list .transaction-item " to _uM("fontSize" to 16, "fontWeight" to "bold")), "income" to _uM(".transaction-card .transaction-list .transaction-item .transaction-amount " to _uM("color" to "#2D9E62")), "expense" to _uM(".transaction-card .transaction-list .transaction-item .transaction-amount " to _uM("color" to "#F56C6C")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
