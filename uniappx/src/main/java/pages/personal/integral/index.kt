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
open class GenPagesPersonalIntegralIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalIntegralIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalIntegralIndex
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val cacheUserInfo = ref<Any?>(null)
            val globalData = inject("globalData") as GlobalDataType
            val transactions = ref(utsArrayOf<TransactionItem1>())
            val date = ref<String>(formatDate(Date(), "yyyy-MM-dd"))
            val myIntegral = ref<Number>(0)
            val isfresh = ref<Boolean>(false)
            val bottomFresh = ref<Boolean>(false)
            var scrollDirection = "down"
            var page: Number = 1
            var limit: Number = 7
            val doQuery = fun(scrollDirection: String){
                val param: UTSJSONObject = UTSJSONObject(Map<String, Any?>(utsArrayOf(
                    utsArrayOf(
                        "type",
                        2
                    ),
                    utsArrayOf(
                        "yearMonth",
                        date.value
                    ),
                    utsArrayOf(
                        "page",
                        page
                    ),
                    utsArrayOf(
                        "limit",
                        limit
                    )
                )))
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
                    var dataList = utsArrayOf<TransactionItem1>()
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
                return createVNode(_component_mc_base_container, utsMapOf("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to true, "title" to "积分管理", "title-color" to "#F5F7FA"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("style" to normalizeStyle("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        createElementVNode("view", utsMapOf("class" to "home-bg"), utsArrayOf(
                            createElementVNode("image", utsMapOf("class" to "bg-image", "src" to ("" + unref(resBaseUrl) + "/static/images/wallet-back.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                "src"
                            ))
                        )),
                        createElementVNode("view", utsMapOf("class" to "container"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "balance-card"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "balance-left"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "balance-title"), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "color-white"), "我的积分")
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "balance-amount"), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "color-white", "style" to normalizeStyle(utsMapOf("font-size" to "30px", "font-weight" to "bold"))), toDisplayString(unref(myIntegral)), 5)
                                    ))
                                )),
                                createElementVNode("view", utsMapOf("class" to "balance-right"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "withdraw-btn", "onClick" to toIntegralExchange), utsArrayOf(
                                        createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("color" to "#5870A3", "text-align" to "center"))), "积分兑换", 4)
                                    ))
                                ))
                            )),
                            createElementVNode("view", utsMapOf("class" to "transaction-card"), utsArrayOf(
                                createElementVNode("image", utsMapOf("class" to "transaction-card-back-image", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-wallet-rounded-rectangle2.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                    "src"
                                )),
                                createElementVNode("view", utsMapOf("class" to "transaction-header"), utsArrayOf(
                                    createElementVNode("view", null, utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "header-title"), "积分明细")
                                    )),
                                    createVNode(_component_mc_date_picker_selector, utsMapOf("modelValue" to unref(date), "onUpdate:modelValue" to fun(`$event`: String){
                                        trySetRefValue(date, `$event`)
                                    }
                                    , "onChange" to hisQuery), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "left-box", "style" to normalizeStyle("width: " + (unref(screenWidth) - 115) + "px;")), utsArrayOf(
                                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-date.png")), null, 8, utsArrayOf(
                                                    "src"
                                                )),
                                                createElementVNode("text", utsMapOf("class" to "text"), toDisplayString(if (unref(date) != "") {
                                                    unref(date)
                                                } else {
                                                    "请选择月份"
                                                }
                                                ), 1)
                                            ), 4)
                                        )
                                    }
                                    ), "_" to 1), 8, utsArrayOf(
                                        "modelValue"
                                    ))
                                )),
                                createVNode(_component_template, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createVNode(_component_x_pull_refresh, utsMapOf("modelValue" to unref(isfresh), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                            trySetRefValue(isfresh, `$event`)
                                        }
                                        , "show-scrollbar" to false, "onScrollDirection" to onScrollDirection, "model-bottom-status" to unref(bottomFresh), "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                            trySetRefValue(bottomFresh, `$event`)
                                        }
                                        , "onRefresh" to topLoad, "onBottomRefresh" to bottomLoad, "height" to ((unref(screenHeight) - unref(globalData).safeAreaBottom - unref(statusBarHeight) - 270) + "px"), ";" to ""), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "transaction-list"), utsArrayOf(
                                                    createElementVNode(Fragment, null, RenderHelpers.renderList(unref(transactions), fun(item, index, __index, _cached): Any {
                                                        return createElementVNode("view", utsMapOf("class" to "transaction-item", "key" to index), utsArrayOf(
                                                            createElementVNode("view", null, utsArrayOf(
                                                                createElementVNode("image", utsMapOf("class" to "transaction-icon", "src" to item.icon), null, 8, utsArrayOf(
                                                                    "src"
                                                                ))
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "transaction-info"), utsArrayOf(
                                                                createElementVNode("view", utsMapOf("class" to "transaction-title"), toDisplayString(item.relevanceType), 1),
                                                                createElementVNode("view", utsMapOf("class" to "transaction-time"), toDisplayString(item.createTime), 1)
                                                            )),
                                                            createElementVNode("view", utsMapOf("class" to "transaction-amount"), utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to normalizeClass(if (item.balanceChange > 0) {
                                                                    "income"
                                                                } else {
                                                                    "expense"
                                                                }
                                                                )), toDisplayString(if (item.balanceChange > 0) {
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
                                                    createVNode(_component_x_empty, utsMapOf("key" to 0, "loading" to false, "empty" to true, "showBtn" to false))
                                                } else {
                                                    createCommentVNode("v-if", true)
                                                }
                                            )
                                        }
                                        ), "_" to 1), 8, utsArrayOf(
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
            normalizeCssStyles(utsArrayOf(
                styles0
            ), utsArrayOf(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("container" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 50)), "home-bg" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "height" to "100%", "zIndex" to -1)), "bg-image" to utsMapOf(".home-bg " to utsMapOf("position" to "absolute", "height" to "100%", "width" to "100%", "top" to 0, "left" to 0)), "color-white" to padStyleMapOf(utsMapOf("color" to "#F5F7FA")), "balance-card" to padStyleMapOf(utsMapOf("width" to "100%", "backgroundColor" to "rgba(0,0,0,0)", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "color" to "#ffffff", "marginBottom" to "35rpx", "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "balance-title" to utsMapOf(".balance-card .balance-left " to utsMapOf("fontSize" to 16, "color" to "rgba(255,255,255,0.9)", "display" to "flex", "alignItems" to "center", "marginBottom" to 5, "flexDirection" to "row")), "balance-amount" to utsMapOf(".balance-card .balance-left " to utsMapOf("fontSize" to 36, "fontWeight" to "bold", "color" to "#ffffff")), "balance-right" to utsMapOf(".balance-card " to utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "flex-end", "width" to "170rpx", "height" to "55rpx")), "withdraw-btn" to utsMapOf(".balance-card .balance-right " to utsMapOf("fontSize" to "28rpx", "color" to "#ffffff", "backgroundColor" to "#F5F7FA", "paddingTop" to "12rpx", "paddingRight" to "12rpx", "paddingBottom" to "12rpx", "paddingLeft" to "12rpx", "borderTopLeftRadius" to "28rpx", "borderTopRightRadius" to "28rpx", "borderBottomRightRadius" to "28rpx", "borderBottomLeftRadius" to "28rpx", "width" to "170rpx", "height" to "55rpx", "alignItems" to "center")), "transaction-card" to padStyleMapOf(utsMapOf("width" to "100%", "backgroundColor" to "rgba(0,0,0,0)", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "paddingTop" to 0, "paddingRight" to 20, "paddingBottom" to 0, "paddingLeft" to 20, "top" to 0, "left" to 0)), "transaction-card-back-image" to utsMapOf(".transaction-card " to utsMapOf("width" to "100%", "position" to "absolute", "top" to 0, "left" to 0)), "transaction-header" to utsMapOf(".transaction-card " to utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to 15, "paddingRight" to 0, "paddingBottom" to 15, "paddingLeft" to 0, "marginTop" to -5)), "header-title" to utsMapOf(".transaction-card .transaction-header " to utsMapOf("fontSize" to 18, "fontWeight" to "bold")), "left-box" to utsMapOf(".transaction-card .transaction-header " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "marginLeft" to 90)), "icon" to utsMapOf(".transaction-card .transaction-header .left-box " to utsMapOf("width" to 15, "height" to 15, "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10)), "text" to utsMapOf(".transaction-card .transaction-header .left-box " to utsMapOf("fontWeight" to "400", "fontSize" to 18, "color" to "#000000")), "text-btn" to utsMapOf(".transaction-card .transaction-header .left-box " to utsMapOf("fontWeight" to "400", "fontSize" to 18, "color" to "#000000")), "transaction-summary" to utsMapOf(".transaction-card " to utsMapOf("display" to "flex", "flexDirection" to "row", "paddingTop" to 15, "paddingRight" to 0, "paddingBottom" to 15, "paddingLeft" to 0)), "summary-item" to utsMapOf(".transaction-card .transaction-summary " to utsMapOf("flex" to 1, "display" to "flex", "flexDirection" to "column", "alignItems" to "center")), "summary-amount" to utsMapOf(".transaction-card .transaction-summary .summary-item " to utsMapOf("marginBottom" to 5), ".transaction-card .transaction-summary .summary-item.income " to utsMapOf("color" to "#2D9E62"), ".transaction-card .transaction-summary .summary-item.expense " to utsMapOf("color" to "#F56C6C")), "summary-label" to utsMapOf(".transaction-card .transaction-summary .summary-item " to utsMapOf("color" to "#666666", "width" to 80, "height" to 24, "backgroundImage" to "none", "backgroundColor" to "#E0EAFF", "borderTopLeftRadius" to 24, "borderTopRightRadius" to 24, "borderBottomRightRadius" to 24, "borderBottomLeftRadius" to 24, "alignItems" to "center", "paddingTop" to 3, "paddingRight" to 3, "paddingBottom" to 3, "paddingLeft" to 3)), "summary-divider" to utsMapOf(".transaction-card .transaction-summary " to utsMapOf("width" to 2, "height" to 40, "backgroundColor" to "#eeeeee", "marginTop" to "auto", "marginRight" to 0, "marginBottom" to "auto", "marginLeft" to 0)), "transaction-list" to utsMapOf(".transaction-card " to utsMapOf("paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "transaction-item" to utsMapOf(".transaction-card .transaction-list " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "paddingTop" to 15, "paddingRight" to 0, "paddingBottom" to 15, "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f0f0f0", "borderBottomWidth:last-child" to "medium", "borderBottomStyle:last-child" to "none", "borderBottomColor:last-child" to "#000000")), "transaction-icon" to utsMapOf(".transaction-card .transaction-list .transaction-item " to utsMapOf("width" to 40, "height" to 40, "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "marginRight" to 15)), "transaction-info" to utsMapOf(".transaction-card .transaction-list .transaction-item " to utsMapOf("flex" to 1)), "transaction-title" to utsMapOf(".transaction-card .transaction-list .transaction-item .transaction-info " to utsMapOf("fontSize" to 16, "color" to "#333333", "marginBottom" to 5)), "transaction-time" to utsMapOf(".transaction-card .transaction-list .transaction-item .transaction-info " to utsMapOf("fontSize" to 12, "color" to "#999999")), "transaction-amount" to utsMapOf(".transaction-card .transaction-list .transaction-item " to utsMapOf("fontSize" to 16, "fontWeight" to "bold")), "income" to utsMapOf(".transaction-card .transaction-list .transaction-item .transaction-amount " to utsMapOf("color" to "#2D9E62")), "expense" to utsMapOf(".transaction-card .transaction-list .transaction-item .transaction-amount " to utsMapOf("color" to "#F56C6C")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
