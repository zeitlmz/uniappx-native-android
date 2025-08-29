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
import uts.sdk.modules.xTipsS.XTIPS_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import uts.sdk.modules.xModalS.showModal
import uts.sdk.modules.xTipsS.showTips as showTips1
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalWalletWithdraw : BasePage {
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
        var setup: (__props: GenPagesPersonalWalletWithdraw) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalWalletWithdraw
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val globalData = inject("globalData") as GlobalDataType
            val availableAmount = ref<Number>(0)
            var withdrawAmount = ref<String>("")
            var cantWithdrawAmount = ref<String>("")
            val maxDailyLimit = ref<Number>(100)
            val feeRate = ref<Number>(1)
            val bankCardInfo = ref<BANK_CARD_INFO?>(null)
            val bankCardInfoName = ref<String?>(null)
            val withdrawRule = ref(_uA<String>())
            val isWithdrawCash = ref<Boolean>(true)
            val cantWithdrawMsg = ref<String>("")
            val moneyFreezeDays = ref<Number>(0)
            val showModal = ref<Boolean>(false)
            val canWithdraw = computed(fun(): Boolean {
                return parseFloat(withdrawAmount.value) > 0 && parseFloat(withdrawAmount.value) <= availableAmount.value
            }
            )
            val setWithdrawAll = fun(){
                withdrawAmount.value = availableAmount.value.toString(10)
            }
            val goToAddAccount = fun(){
                console.log("前往添加账户页面")
                router.push("/pages/personal/wallet/bank-card")
            }
            val init = fun(){
                getBankCard().then(fun(res: Response){
                    if (res.data != null && res.code == 200) {
                        val result = res.data as UTSArray<UTSJSONObject>
                        console.log("getBankCard==", result)
                        if (result.length > 0) {
                            val item = result[0] as UTSJSONObject
                            bankCardInfo.value = JSON.parse<BANK_CARD_INFO>(JSON.stringify(item))
                            bankCardInfoName.value = bankCardInfo.value?.bankNameAndCard
                        }
                    }
                }
                )
                getWallet().then(fun(res: Response){
                    if (res.data != null && res.code == 200) {
                        val result = res.data as UTSJSONObject
                        console.log("balanceQuery==", result)
                        val canWithdrawAssetBalance = result.getString("canWithdrawAssetBalance")
                        availableAmount.value = if (canWithdrawAssetBalance == null) {
                            0
                        } else {
                            parseFloat(canWithdrawAssetBalance)
                        }
                        moneyFreezeDays.value = result.getNumber("moneyFreezeDays") ?: 0
                        isWithdrawCash.value = result.getBoolean("isWithdrawCash") ?: false
                        cantWithdrawMsg.value = result.getString("cantWithdrawMsg") ?: ""
                        if (isWithdrawCash.value) {
                            cantWithdrawAmount.value = availableAmount.value.toString(10)
                        }
                    }
                }
                )
                withdrawRule.value = _uA(
                    "提现手续费：每笔提现收取金额的1%作为手续费",
                    "提现时间：每周一至周五（如遇法定节假日顺延）",
                    "提现限制：单日提现限额2000元"
                )
            }
            val handleViewCantWithdrawMsg = fun(){
                showModal.value = true
            }
            val handleWithdraw = fun(){
                if (withdrawRule.value == null || withdrawRule.value.length == 0) {
                    showTips1(XTIPS_TYPE(title = "提现规则未设置，请联系管理员", iconCode = "error", iconColor = "red", titleColor = "red", position = "bottom"))
                    return
                }
                if (!canWithdraw.value) {
                    showTips1(XTIPS_TYPE(title = "请输入正确的提现金额", iconCode = "error", iconColor = "red", titleColor = "red", position = "bottom"))
                    return
                }
                if (bankCardInfo.value == null) {
                    showTips1(XTIPS_TYPE(title = "请选择提现银行卡", iconCode = "error", iconColor = "red", titleColor = "red", position = "bottom"))
                    return
                }
                val bankId = (bankCardInfo.value as BANK_CARD_INFO).id
                if (bankId == null) {
                    showTips1(XTIPS_TYPE(title = "请选择提现银行卡", iconCode = "error", iconColor = "red", titleColor = "red", position = "bottom"))
                    return
                }
                showLoading(XLOADINGS_TYPE(title = "提现处理中..."))
                balanceAccountWithdraw(bankId, withdrawAmount.value).then(fun(res: Response){
                    hideXloading()
                    if (res.code == 200) {
                        showTips1(XTIPS_TYPE(title = "提现成功", iconCode = "success", iconColor = "green", titleColor = "green", position = "bottom"))
                        setTimeout(fun(){
                            uni_navigateBack(null)
                        }, 1500)
                    } else {
                        showTips1(XTIPS_TYPE(title = res.msg, iconCode = "error", iconColor = "red", titleColor = "red", position = "bottom"))
                    }
                }
                )
            }
            onPageShow(fun(){
                init()
            }
            )
            return fun(): Any? {
                val _component_x_input = resolveEasyComponent("x-input", GenUniModulesTmxUiComponentsXInputXInputClass)
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_mc_base_container, _uM("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to false, "title" to "提现"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("style" to _nS("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                            _cE("view", _uM("class" to "home-bg"), _uA(
                                _cE("view", _uM("class" to "top-bg"))
                            )),
                            _cE("view", _uM("class" to "container", "style" to _nS("height: " + (unref(screenHeight) - unref(globalData).safeAreaBottom - unref(statusBarHeight) - 20) + "px;")), _uA(
                                _cE("view", _uM("class" to "withdraw-card"), _uA(
                                    if (isTrue(unref(isWithdrawCash))) {
                                        _cE("view", _uM("key" to 0, "class" to "card-header"), _uA(
                                            _cE("text", null, "提现至"),
                                            _cE("view", _uM("class" to "add-account", "onClick" to goToAddAccount), _uA(
                                                if (unref(bankCardInfoName) == null) {
                                                    _cE("text", _uM("key" to 0, "class" to "text"), "请添加收款账户")
                                                } else {
                                                    _cE("text", _uM("key" to 1, "class" to "text"), _tD(unref(bankCardInfoName)), 1)
                                                }
                                            ))
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    if (isTrue(unref(isWithdrawCash))) {
                                        _cE("view", _uM("key" to 1, "class" to "amount-input-container"), _uA(
                                            _cE("view", _uM("class" to "amount-input-wrapper"), _uA(
                                                _cE("text", _uM("style" to _nS(_uM("font-size" to "24px", "font-weight" to "bold"))), "¥", 4),
                                                _cV(_component_x_input, _uM("style" to _nS(_uM("margin-left" to "10px")), "type" to "digit", "modelValue" to unref(withdrawAmount), "onUpdate:modelValue" to fun(`$event`: Ref<String>){
                                                    withdrawAmount = trySetRefValue(withdrawAmount, `$event`)
                                                }, "placeholder" to "0.00", "color" to "#ffffff"), null, 8, _uA(
                                                    "style",
                                                    "modelValue"
                                                ))
                                            )),
                                            _cE("view", _uM("class" to "amount-label"), _uA(
                                                _cE("view", _uM("style" to _nS(_uM("display" to "flex", "flex-direction" to "row"))), _uA(
                                                    _cE("text", _uM("class" to "text"), "可提现金额："),
                                                    _cE("text", _uM("class" to "available-amount"), "¥ " + _tD(unref(availableAmount)), 1)
                                                ), 4),
                                                _cE("text", _uM("class" to "withdraw-all", "onClick" to setWithdrawAll), "全部提现")
                                            ))
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    if (isTrue(!unref(isWithdrawCash))) {
                                        _cE("view", _uM("key" to 2, "class" to "amount-input-container"), _uA(
                                            _cE("view", _uM("class" to "amount-input-wrapper"), _uA(
                                                _cE("text", _uM("style" to _nS(_uM("font-size" to "24px", "font-weight" to "bold"))), "¥", 4),
                                                _cV(_component_x_input, _uM("style" to _nS(_uM("margin-left" to "10px")), "disabled" to true, "type" to "digit", "modelValue" to unref(cantWithdrawAmount), "onUpdate:modelValue" to fun(`$event`: Ref<String>){
                                                    cantWithdrawAmount = trySetRefValue(cantWithdrawAmount, `$event`)
                                                }, "placeholder" to "0.00", "color" to "#ffffff"), null, 8, _uA(
                                                    "style",
                                                    "modelValue"
                                                ))
                                            ))
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )),
                                if (isTrue(unref(isWithdrawCash))) {
                                    _cV(_component_mc_primary_button, _uM("key" to 0, "disabled" to (!unref(canWithdraw) && unref(isWithdrawCash)), "span" to -1, "height" to "45px", "onClick" to handleWithdraw), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "立即提现"
                                        )
                                    }), "_" to 1), 8, _uA(
                                        "disabled"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (isTrue(!unref(isWithdrawCash))) {
                                    _cV(_component_mc_primary_button, _uM("key" to 1, "span" to -1, "height" to "45px", "onClick" to handleViewCantWithdrawMsg), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "查看不可提现原因"
                                        )
                                    }), "_" to 1))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                _cE("view", _uM("class" to "withdraw-rules-card"), _uA(
                                    if (unref(moneyFreezeDays) > 0) {
                                        _cE("view", _uM("key" to 0), _uA(
                                            _cE("view", _uM("class" to "withdraw-rules"), _uA(
                                                _cE("image", _uM("class" to "info-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-withdraw-rule.png")), null, 8, _uA(
                                                    "src"
                                                )),
                                                _cE("text", _uM("class" to "text"), "冻结规则：")
                                            )),
                                            _cE("view", _uM("class" to "rules-list"), _uA(
                                                _cE("view", _uM("class" to "rule-item"), _uA(
                                                    _cV(_component_x_text, _uM("style" to _nS(_uM("font-size" to "25rpx", "font-weight" to "350"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            "1、冻结天数: " + _tD(unref(moneyFreezeDays)) + "天 "
                                                        )
                                                    }), "_" to 1), 8, _uA(
                                                        "style"
                                                    ))
                                                )),
                                                _cE("view", _uM("class" to "rule-item tips"), _uA(
                                                    _cV(_component_x_text, _uM("style" to _nS(_uM("font-size" to "25rpx", "font-weight" to "bold", "color" to "#D50303"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            "*冻结天数指的是当天的收入需要等待 " + _tD(unref(moneyFreezeDays)) + "天才可提现"
                                                        )
                                                    }), "_" to 1), 8, _uA(
                                                        "style"
                                                    ))
                                                ))
                                            ))
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    _cE("view", _uM("class" to "withdraw-rules"), _uA(
                                        _cE("image", _uM("class" to "info-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-withdraw-rule.png")), null, 8, _uA(
                                            "src"
                                        )),
                                        _cE("text", _uM("class" to "text"), "提现规则：")
                                    )),
                                    _cE("view", _uM("class" to "rules-list"), _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(unref(withdrawRule), fun(item, index, __index, _cached): Any {
                                            return _cE("view", _uM("class" to "rule-item", "key" to index), _uA(
                                                _cV(_component_x_text, _uM("style" to _nS(_uM("font-size" to "25rpx", "font-weight" to "350"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD(index + 1) + "、" + _tD(item)
                                                    )
                                                }
                                                ), "_" to 2), 1032, _uA(
                                                    "style"
                                                ))
                                            ))
                                        }
                                        ), 128)
                                    ))
                                ))
                            ), 4)
                        )
                    }
                    ), "_" to 1)),
                    _cV(_component_x_modal, _uM("show" to unref(showModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showModal, `$event`)
                    }
                    , "bgColor" to "#ECF1F8", "cancel-text" to "关闭", "overlay-click" to true, "title" to "不可提现规则", "onCancel" to fun(){
                        showModal.value = false
                    }
                    , "show-title" to false, "height" to "350rpx", "showFooter" to false, "showClose" to true, "showCancel" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("text", _uM("class" to "cantWithdrawMsg-title")),
                            _cE("view", _uM("class" to "desc"), _uA(
                                _cE("text", _uM("class" to "pb-10 mt-10"), _tD(unref(cantWithdrawMsg)), 1)
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show",
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
                return _uM("container" to _pS(_uM("width" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 20, "height" to 900)), "home-bg" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1)), "top-bg" to _uM(".home-bg " to _uM("height" to 900, "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)")), "withdraw-card" to _pS(_uM("width" to "100%", "backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "marginTop" to 50, "boxShadow" to "0px 5px 15px rgba(0, 0, 0, 0.05)", "marginBottom" to 20)), "card-header" to _uM(".withdraw-card " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingBottom" to 15, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#ECECEC")), "add-account" to _uM(".withdraw-card .card-header " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "text" to _uM(".withdraw-card .card-header .add-account " to _uM("fontSize" to 16, "color" to "#666666"), ".withdraw-card .amount-input-container .amount-label " to _uM("fontSize" to 14, "color" to "#6C6C6C"), ".withdraw-rules-card .withdraw-rules " to _uM("fontSize" to 14, "color" to "#6C6C6C", "fontWeight" to "bold"), ".withdraw-rules-card .rules-list .rule-item " to _uM("fontSize" to "25rpx"), ".tips " to _uM("boxSizing" to "border-box", "fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#D50303")), "arrow-icon" to _uM(".withdraw-card .card-header .add-account " to _uM("width" to 16, "height" to 16, "marginLeft" to 5)), "amount-input-container" to _uM(".withdraw-card " to _uM("marginTop" to 25)), "amount-label" to _uM(".withdraw-card .amount-input-container " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "marginTop" to 15, "justifyContent" to "space-between")), "available-amount" to _uM(".withdraw-card .amount-input-container .amount-label " to _uM("color" to "#6C6C6C", "fontWeight" to "bold", "marginRight" to 10)), "withdraw-all" to _uM(".withdraw-card .amount-input-container .amount-label " to _uM("color" to "#D50303", "fontSize" to 14, "alignItems" to "flex-end")), "amount-input-wrapper" to _uM(".withdraw-card .amount-input-container " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#ECECEC", "paddingBottom" to 10, "height" to 70)), "currency-symbol" to _uM(".withdraw-card .amount-input-container .amount-input-wrapper " to _uM("fontSize" to 24, "fontWeight" to "bold", "color" to "#6C6C6C", "marginRight" to 10, "marginLeft" to 10)), "amount-input" to _uM(".withdraw-card .amount-input-container .amount-input-wrapper " to _uM("fontSize" to 24, "fontWeight" to "bold", "color" to "#333333", "flex" to 1, "height" to 40)), "withdraw-rules-card" to _pS(_uM("paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "height" to "100%")), "withdraw-rules" to _uM(".withdraw-rules-card " to _uM("marginTop" to 10, "display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "info-icon" to _uM(".withdraw-rules-card .withdraw-rules " to _uM("width" to 16, "height" to 16, "marginRight" to 5)), "rules-list" to _uM(".withdraw-rules-card " to _uM("marginTop" to 5)), "rule-item" to _uM(".withdraw-rules-card .rules-list " to _uM("marginBottom" to 5)), "cantWithdrawMsg-title" to _pS(_uM("textAlign" to "center", "width" to "100%", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "tips" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "marginBottom" to "30rpx")), "icon" to _uM(".tips " to _uM("width" to "29rpx", "height" to "29rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
