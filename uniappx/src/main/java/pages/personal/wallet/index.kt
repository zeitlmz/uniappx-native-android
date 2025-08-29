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
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import uts.sdk.modules.jjMd5.md5
import uts.sdk.modules.xModalS.showModal
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalWalletIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalWalletIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalWalletIndex
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val cacheUserInfo = ref<Any?>(null)
            val globalData = inject("globalData") as GlobalDataType
            val assetBalance = ref<Number?>(0)
            val bankCardCount = ref<Number?>(0)
            val totalIncome = ref<Number?>(0)
            val totalDisburse = ref<Number?>(0)
            val showBalance = ref<Boolean>(true)
            val secondPwd = ref<String>("")
            val secondPwdShow = ref<Boolean>(false)
            val showValidModal = ref<Boolean>(false)
            val date = ref<String>(formatDate(Date(), "yyyy-MM"))
            val isfresh = ref<Boolean>(false)
            val bottomFresh = ref<Boolean>(false)
            var scrollDirection = "down"
            var page: Number = 1
            var limit: Number = 7
            val transactions = ref(_uA<TransactionItem>())
            val doQuery = fun(scrollDirection: String){
                val param: UTSJSONObject = _uO("type" to 1, "yearMonth" to date.value, "page" to page, "limit" to limit)
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
                    var dataList = _uA<TransactionItem>()
                    if (records != null && records.length > 0) {
                        records.forEach(fun(item){
                            val itemJson = JSON.parse<TransactionItem>(JSON.stringify(item)) as TransactionItem
                            itemJson.icon = transIconByType(itemJson.relevanceType)
                            dataList.push(itemJson)
                        })
                        totalIncome.value = dataList[0].totalIncome
                        totalDisburse.value = dataList[0].totalDisburse
                    } else {
                        if (totalRes <= 0) {
                            totalIncome.value = 0
                            totalDisburse.value = 0
                            transactions.value = dataList
                        }
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
            val topLoad = fun(){
                console.log("下拉刷新")
                page = 1
                scrollDirection = "down"
                doQuery(scrollDirection)
            }
            val bottomLoad = fun(){
                console.log("触底刷新")
                page++
                scrollDirection = "up"
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
                    val assetBalanceNum = result.getString("assetBalance")
                    assetBalance.value = if (assetBalanceNum == null) {
                        0
                    } else {
                        parseFloat(assetBalanceNum)
                    }
                    val bankCardCountNum = result.getNumber("bankCardCount")
                    bankCardCount.value = if (bankCardCountNum == null) {
                        0
                    } else {
                        bankCardCountNum
                    }
                }
                )
            }
            val confirmPwd = fun(){
                val md5Pwd = md5(secondPwd.value) as String
                console.log("md5Pwd", md5Pwd)
                checkSecondPassword(md5Pwd).then(fun(res: Response){
                    if (res.code == 200 && res.data == true) {
                        router.push("/pages/personal/wallet/withdraw")
                        setTimeout(fun(){
                            secondPwdShow.value = false
                            showValidModal.value = false
                            secondPwd.value = ""
                        }, 200)
                    } else {
                        showToast("二级密码错误", "error")
                    }
                }
                )
            }
            val modalClose = fun(){
                secondPwdShow.value = false
                showValidModal.value = false
                secondPwd.value = ""
            }
            val codeClick = fun(){
                console.log("codeClick======")
                secondPwdShow.value = false
                setTimeout(fun(){
                    secondPwdShow.value = true
                }
                , 100)
            }
            val toWithdraw = fun(){
                console.log("前往提现页面")
                checkUserSetSecondPassword().then(fun(res: Response){
                    if (res.code == 200) {
                        if (res.data == true) {
                            showValidModal.value = false
                            secondPwdShow.value = false
                            setTimeout(fun(){
                                secondPwdShow.value = true
                                showValidModal.value = true
                            }, 100)
                        } else {
                            showModal(X_MODAL_TYPE(title = "温馨提示", content = "还未设置二级密码，是否进行设置?", confirmText = "确认", clickMaskClose = false, confirmBgColor = globalData.theme.primaryColor, confirm = fun(){
                                router.push("/pages/personal/setting/account-safe/secondary-password/index")
                            }))
                        }
                    } else {
                        showTips(res.msg, "error")
                    }
                }
                )
            }
            onPageShow(fun(){
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
                val _component_x_code_input = resolveEasyComponent("x-code-input", GenUniModulesTmxUiComponentsXCodeInputXCodeInputClass)
                val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
                val _component_x_keyboard_number = resolveEasyComponent("x-keyboard-number", GenUniModulesTmxUiComponentsXKeyboardNumberXKeyboardNumberClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_mc_base_container, _uM("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to true, "title" to "我的钱包", "title-color" to "#F5F7FA"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
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
                                            _cE("text", _uM("class" to "color-white"), "账户余额"),
                                            if (isTrue(unref(showBalance))) {
                                                _cE("image", _uM("key" to 0, "class" to "eye-icon", "onClick" to fun(){
                                                    showBalance.value = false
                                                }, "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-wallet-eye.png")), null, 8, _uA(
                                                    "onClick",
                                                    "src"
                                                ))
                                            } else {
                                                _cE("image", _uM("key" to 1, "class" to "eye-icon", "onClick" to fun(){
                                                    showBalance.value = true
                                                }
                                                , "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-wallet-eye-close2.png")), null, 8, _uA(
                                                    "onClick",
                                                    "src"
                                                ))
                                            }
                                        )),
                                        _cE("view", _uM("class" to "balance-amount"), _uA(
                                            _cE("text", _uM("class" to "color-white", "style" to _nS(_uM("font-size" to "30px", "font-weight" to "bold"))), _tD(if (unref(showBalance)) {
                                                unref(assetBalance)
                                            } else {
                                                "****"
                                            }
                                            ), 5)
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "balance-right"), _uA(
                                        _cE("view", _uM("class" to "bank-cards"), _uA(
                                            _cE("image", _uM("class" to "bank-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-wallet-bank-card.png")), null, 8, _uA(
                                                "src"
                                            )),
                                            _cE("text", _uM("class" to "color-white"), "银行卡(" + _tD(unref(bankCardCount)) + ")", 1)
                                        )),
                                        _cE("view", _uM("class" to "withdraw-btn", "onClick" to toWithdraw), _uA(
                                            _cE("text", _uM("style" to _nS(_uM("color" to "#5870A3"))), "提现", 4)
                                        ))
                                    ))
                                )),
                                _cE("view", _uM("class" to "transaction-card", "style" to _nS("height: " + (unref(screenHeight) - unref(globalData).safeAreaBottom - unref(statusBarHeight) - 220) + "px;")), _uA(
                                    _cE("image", _uM("class" to "transaction-card-back-image", "mode" to "widthFix", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-wallet-rounded-rectangle2.png")), null, 8, _uA(
                                        "src"
                                    )),
                                    _cE("view", _uM("class" to "transaction-header"), _uA(
                                        _cE("view", null, _uA(
                                            _cE("text", _uM("class" to "header-title"), "收支记录")
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
                                    _cE("view", _uM("class" to "transaction-summary"), _uA(
                                        _cE("view", _uM("class" to "summary-item income"), _uA(
                                            _cE("view", _uM("class" to "summary-amount"), _uA(
                                                _cE("text", _uM("style" to _nS(_uM("color" to "#45820A", "font-weight" to "bold", "font-size" to "20px"))), _tD(if (unref(totalIncome) == null) {
                                                    0
                                                } else {
                                                    unref(totalIncome)
                                                }
                                                ), 5)
                                            )),
                                            _cE("view", _uM("class" to "summary-label"), " 收入(元) ")
                                        )),
                                        _cE("view", _uM("class" to "summary-divider")),
                                        _cE("view", _uM("class" to "summary-item expense"), _uA(
                                            _cE("view", _uM("class" to "summary-amount"), _uA(
                                                _cE("text", _uM("style" to _nS(_uM("color" to "#CE3A3A", "font-weight" to "bold", "font-size" to "20px"))), _tD(if (unref(totalDisburse) == null) {
                                                    0
                                                } else {
                                                    unref(totalDisburse)
                                                }
                                                ), 5)
                                            )),
                                            _cE("view", _uM("class" to "summary-label"), "支出(元)")
                                        ))
                                    )),
                                    _cV(_component_template, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_x_pull_refresh, _uM("modelValue" to unref(isfresh), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                trySetRefValue(isfresh, `$event`)
                                            }
                                            , "show-scrollbar" to false, "model-bottom-status" to unref(bottomFresh), "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                                trySetRefValue(bottomFresh, `$event`)
                                            }
                                            , "onRefresh" to topLoad, "onBottomRefresh" to bottomLoad, "height" to ((unref(screenHeight) - unref(globalData).safeAreaBottom - unref(statusBarHeight)) + "rpx")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "transaction-list"), _uA(
                                                        _cE(Fragment, null, RenderHelpers.renderList(unref(transactions), fun(item, index, __index, _cached): Any {
                                                            return _cE("view", _uM("class" to "transaction-item", "key" to index), _uA(
                                                                _cE("view", null, _uA(
                                                                    _cE("image", _uM("class" to "transaction-icon", "src" to (unref(resBaseUrl) + item.icon)), null, 8, _uA(
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
                                                                        item.balanceChange
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
                                ), 4)
                            ))
                        )
                    }
                    ), "_" to 1)),
                    _cV(_component_x_modal, _uM("show" to unref(showValidModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showValidModal, `$event`)
                    }
                    , "show-close" to "", "onClose" to modalClose, "height" to "300rpx", "z-index" to "100", "title" to "请输入六位数二级密码", "show-footer" to false, "overlayClick" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cV(_component_x_code_input, _uM("width" to "80rpx", "showNumber" to false, "auto-focus" to "", "place-shape" to "line", "maxlength" to 6, "modelValue" to unref(secondPwd), "onUpdate:modelValue" to fun(`$event`: String){
                                trySetRefValue(secondPwd, `$event`)
                            }
                            , "useSysKeyborad" to false, "skin" to "fill", "onClick" to codeClick), null, 8, _uA(
                                "modelValue"
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    )),
                    _cV(_component_x_keyboard_number, _uM("showValue" to false, "mode" to "password", "digit" to false, "model-show" to unref(secondPwdShow), "maxLen" to 6, "modelValue" to unref(secondPwd), "onUpdate:modelValue" to fun(`$event`: String){
                        trySetRefValue(secondPwd, `$event`)
                    }
                    , "onConfirm" to confirmPwd, "onCancel" to fun(){
                        secondPwdShow.value = false
                    }
                    , "title" to "安全键盘请放心输入", "bgColor" to "#ffffff"), null, 8, _uA(
                        "model-show",
                        "modelValue",
                        "onCancel"
                    ))
                ), 64)
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
                return _uM("container" to _pS(_uM("width" to "100%", "height" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 50)), "home-bg" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "height" to "100%", "zIndex" to -1)), "bg-image" to _uM(".home-bg " to _uM("width" to "100%", "height" to "100%", "position" to "absolute", "top" to 0, "left" to 0)), "color-white" to _pS(_uM("color" to "#F5F7FA")), "balance-card" to _pS(_uM("width" to "100%", "backgroundColor" to "rgba(0,0,0,0)", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "color" to "#ffffff", "marginBottom" to 15, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "balance-title" to _uM(".balance-card .balance-left " to _uM("fontSize" to 16, "color" to "rgba(255,255,255,0.9)", "display" to "flex", "alignItems" to "center", "marginBottom" to 5, "flexDirection" to "row")), "eye-icon" to _uM(".balance-card .balance-left .balance-title " to _uM("width" to 20, "height" to 15, "marginLeft" to 5)), "balance-amount" to _uM(".balance-card .balance-left " to _uM("fontSize" to 36, "fontWeight" to "bold", "color" to "#ffffff")), "balance-right" to _uM(".balance-card " to _uM("display" to "flex", "flexDirection" to "column", "alignItems" to "flex-end")), "bank-cards" to _uM(".balance-card .balance-right " to _uM("fontSize" to 14, "color" to "rgba(255,255,255,0.9)", "backgroundColor" to "rgba(0,0,0,0)", "marginBottom" to 5, "marginLeft" to 15, "display" to "flex", "flexDirection" to "row")), "bank-icon" to _uM(".balance-card .balance-right .bank-cards " to _uM("width" to 16, "height" to 16, "marginRight" to 5)), "withdraw-btn" to _uM(".balance-card .balance-right " to _uM("fontSize" to 14, "color" to "#ffffff", "backgroundColor" to "#F5F7FA", "paddingTop" to 5, "paddingRight" to 25, "paddingBottom" to 5, "paddingLeft" to 25, "borderTopLeftRadius" to 20, "borderTopRightRadius" to 20, "borderBottomRightRadius" to 20, "borderBottomLeftRadius" to 20, "width" to "90%", "alignItems" to "center")), "transaction-card" to _pS(_uM("width" to "100%", "backgroundColor" to "rgba(0,0,0,0)", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "paddingTop" to 0, "paddingRight" to 20, "paddingBottom" to 0, "paddingLeft" to 20, "top" to 0, "left" to 0)), "transaction-card-back-image" to _uM(".transaction-card " to _uM("width" to "100%", "position" to "absolute", "top" to 0, "left" to 0)), "transaction-header" to _uM(".transaction-card " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to 15, "paddingRight" to 0, "paddingBottom" to 15, "paddingLeft" to 0, "marginTop" to -5)), "header-title" to _uM(".transaction-card .transaction-header " to _uM("fontSize" to 18, "fontWeight" to "bold")), "left-box" to _uM(".transaction-card .transaction-header " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "marginLeft" to 90)), "icon" to _uM(".transaction-card .transaction-header .left-box " to _uM("width" to 15, "height" to 15, "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10)), "text" to _uM(".transaction-card .transaction-header .left-box " to _uM("fontWeight" to "400", "fontSize" to 18, "color" to "#000000")), "text-btn" to _uM(".transaction-card .transaction-header .left-box " to _uM("fontWeight" to "400", "fontSize" to 18, "color" to "#000000")), "transaction-summary" to _uM(".transaction-card " to _uM("display" to "flex", "flexDirection" to "row", "paddingTop" to 15, "paddingRight" to 0, "paddingBottom" to 15, "paddingLeft" to 0)), "summary-item" to _uM(".transaction-card .transaction-summary " to _uM("flex" to 1, "display" to "flex", "flexDirection" to "column", "alignItems" to "center")), "summary-amount" to _uM(".transaction-card .transaction-summary .summary-item " to _uM("marginBottom" to 5), ".transaction-card .transaction-summary .summary-item.income " to _uM("color" to "#2D9E62"), ".transaction-card .transaction-summary .summary-item.expense " to _uM("color" to "#F56C6C")), "summary-label" to _uM(".transaction-card .transaction-summary .summary-item " to _uM("color" to "#666666", "width" to 80, "height" to 24, "backgroundImage" to "none", "backgroundColor" to "#E0EAFF", "borderTopLeftRadius" to 24, "borderTopRightRadius" to 24, "borderBottomRightRadius" to 24, "borderBottomLeftRadius" to 24, "alignItems" to "center", "paddingTop" to 3, "paddingRight" to 3, "paddingBottom" to 3, "paddingLeft" to 3)), "summary-divider" to _uM(".transaction-card .transaction-summary " to _uM("width" to 2, "height" to 40, "backgroundColor" to "#eeeeee", "marginTop" to "auto", "marginRight" to 0, "marginBottom" to "auto", "marginLeft" to 0)), "transaction-list" to _uM(".transaction-card " to _uM("paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "transaction-item" to _uM(".transaction-card .transaction-list " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "paddingTop" to 15, "paddingRight" to 0, "paddingBottom" to 15, "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f0f0f0", "borderBottomWidth:last-child" to "medium", "borderBottomStyle:last-child" to "none", "borderBottomColor:last-child" to "#000000")), "transaction-icon" to _uM(".transaction-card .transaction-list .transaction-item " to _uM("width" to 40, "height" to 40, "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "marginRight" to 15)), "transaction-info" to _uM(".transaction-card .transaction-list .transaction-item " to _uM("flex" to 1)), "transaction-title" to _uM(".transaction-card .transaction-list .transaction-item .transaction-info " to _uM("fontSize" to 16, "color" to "#333333", "marginBottom" to 5)), "transaction-time" to _uM(".transaction-card .transaction-list .transaction-item .transaction-info " to _uM("fontSize" to 12, "color" to "#999999")), "transaction-amount" to _uM(".transaction-card .transaction-list .transaction-item " to _uM("fontSize" to 16, "fontWeight" to "bold")), "income" to _uM(".transaction-card .transaction-list .transaction-item .transaction-amount " to _uM("color" to "#2D9E62")), "expense" to _uM(".transaction-card .transaction-list .transaction-item .transaction-amount " to _uM("color" to "#F56C6C")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
