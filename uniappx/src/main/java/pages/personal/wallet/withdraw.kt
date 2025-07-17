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
import uts.sdk.modules.xTipsS.XTIPS_TYPE
import uts.sdk.modules.mcAmapNavPlus.checkLocationPermission
import uts.sdk.modules.mcAmapNavPlus.init
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import uts.sdk.modules.xTipsS.showTips as showTips1
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalWalletWithdraw : BasePage {
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
        var setup: (__props: GenPagesPersonalWalletWithdraw) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalWalletWithdraw
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val globalData = inject("globalData") as GlobalDataType
            val availableAmount = ref<Number>(0)
            var withdrawAmount = ref<String>("")
            val maxDailyLimit = ref<Number>(100)
            val feeRate = ref<Number>(1)
            val bankCardInfo = ref<BANK_CARD_INFO?>(null)
            val bankCardInfoName = ref<String?>(null)
            val withdrawRule = ref(utsArrayOf<String>())
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
                    }
                }
                )
                withdrawRule.value = utsArrayOf(
                    "1、提现手续费：每笔提现收取金额的1%作为手续费",
                    "2、提现时间：每周一至周五（如遇法定节假日顺延）",
                    "3、提现限制：单日提现限额2000元"
                )
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
                return createVNode(_component_mc_base_container, utsMapOf("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to false, "title" to "提现"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("style" to normalizeStyle("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        createElementVNode("view", utsMapOf("class" to "home-bg"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "top-bg"))
                        )),
                        createElementVNode("view", utsMapOf("class" to "container", "style" to normalizeStyle("height: " + (unref(screenHeight) - unref(globalData).safeAreaBottom - unref(statusBarHeight) - 20) + "px;")), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "withdraw-card"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "card-header"), utsArrayOf(
                                    createElementVNode("text", null, "提现至"),
                                    createElementVNode("view", utsMapOf("class" to "add-account", "onClick" to goToAddAccount), utsArrayOf(
                                        if (unref(bankCardInfoName) == null) {
                                            createElementVNode("text", utsMapOf("key" to 0, "class" to "text"), "请添加收款账户")
                                        } else {
                                            createElementVNode("text", utsMapOf("key" to 1, "class" to "text"), toDisplayString(unref(bankCardInfoName)), 1)
                                        }
                                    ))
                                )),
                                createElementVNode("view", utsMapOf("class" to "amount-input-container"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "amount-input-wrapper"), utsArrayOf(
                                        createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("font-size" to "24px", "font-weight" to "bold"))), "¥", 4),
                                        createVNode(_component_x_input, utsMapOf("style" to normalizeStyle(utsMapOf("margin-left" to "10px")), "type" to "digit", "modelValue" to unref(withdrawAmount), "onUpdate:modelValue" to fun(`$event`: String){
                                            withdrawAmount = trySetRefValue(withdrawAmount, `$event`)
                                        }
                                        , "placeholder" to "0.00", "color" to "#ffffff"), null, 8, utsArrayOf(
                                            "style",
                                            "modelValue"
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "amount-label"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("display" to "flex", "flex-direction" to "row"))), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "text"), "可提现金额："),
                                            createElementVNode("text", utsMapOf("class" to "available-amount"), "¥ " + toDisplayString(unref(availableAmount)), 1)
                                        ), 4),
                                        createElementVNode("text", utsMapOf("class" to "withdraw-all", "onClick" to setWithdrawAll), "全部提现")
                                    ))
                                ))
                            )),
                            createVNode(_component_mc_primary_button, utsMapOf("disabled" to !unref(canWithdraw), "span" to -1, "height" to "45px", "onClick" to handleWithdraw), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    "立即提现"
                                )
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "disabled"
                            )),
                            if (unref(withdrawRule).length > 0) {
                                createElementVNode("view", utsMapOf("key" to 0, "class" to "withdraw-rules-card"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "withdraw-rules"), utsArrayOf(
                                        createElementVNode("image", utsMapOf("class" to "info-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-withdraw-rule.png")), null, 8, utsArrayOf(
                                            "src"
                                        )),
                                        createElementVNode("text", utsMapOf("class" to "text"), "提现规则：")
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "rules-list"), utsArrayOf(
                                        createElementVNode(Fragment, null, RenderHelpers.renderList(unref(withdrawRule), fun(item, index, __index, _cached): Any {
                                            return createElementVNode("view", utsMapOf("class" to "rule-item", "key" to index), utsArrayOf(
                                                createVNode(_component_x_text, utsMapOf("style" to normalizeStyle(utsMapOf("font-size" to "25rpx", "font-weight" to "350"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        toDisplayString(item)
                                                    )
                                                }), "_" to 2), 1032, utsArrayOf(
                                                    "style"
                                                ))
                                            ))
                                        }), 128)
                                    ))
                                ))
                            } else {
                                createCommentVNode("v-if", true)
                            }
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
                return utsMapOf("container" to padStyleMapOf(utsMapOf("width" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 20, "height" to 900)), "home-bg" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1)), "top-bg" to utsMapOf(".home-bg " to utsMapOf("height" to 900, "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)")), "withdraw-card" to padStyleMapOf(utsMapOf("width" to "100%", "backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "marginTop" to 50, "boxShadow" to "0px 5px 15px rgba(0, 0, 0, 0.05)", "marginBottom" to 20)), "card-header" to utsMapOf(".withdraw-card " to utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingBottom" to 15, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#ECECEC")), "add-account" to utsMapOf(".withdraw-card .card-header " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "text" to utsMapOf(".withdraw-card .card-header .add-account " to utsMapOf("fontSize" to 16, "color" to "#666666"), ".withdraw-card .amount-input-container .amount-label " to utsMapOf("fontSize" to 14, "color" to "#6C6C6C"), ".withdraw-rules-card .withdraw-rules " to utsMapOf("fontSize" to 14, "color" to "#6C6C6C", "fontWeight" to "bold"), ".withdraw-rules-card .rules-list .rule-item " to utsMapOf("fontSize" to "25rpx")), "arrow-icon" to utsMapOf(".withdraw-card .card-header .add-account " to utsMapOf("width" to 16, "height" to 16, "marginLeft" to 5)), "amount-input-container" to utsMapOf(".withdraw-card " to utsMapOf("marginTop" to 25)), "amount-label" to utsMapOf(".withdraw-card .amount-input-container " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "marginTop" to 15, "justifyContent" to "space-between")), "available-amount" to utsMapOf(".withdraw-card .amount-input-container .amount-label " to utsMapOf("color" to "#6C6C6C", "fontWeight" to "bold", "marginRight" to 10)), "withdraw-all" to utsMapOf(".withdraw-card .amount-input-container .amount-label " to utsMapOf("color" to "#D50303", "fontSize" to 14, "alignItems" to "flex-end")), "amount-input-wrapper" to utsMapOf(".withdraw-card .amount-input-container " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#ECECEC", "paddingBottom" to 10, "height" to 70)), "currency-symbol" to utsMapOf(".withdraw-card .amount-input-container .amount-input-wrapper " to utsMapOf("fontSize" to 24, "fontWeight" to "bold", "color" to "#6C6C6C", "marginRight" to 10, "marginLeft" to 10)), "amount-input" to utsMapOf(".withdraw-card .amount-input-container .amount-input-wrapper " to utsMapOf("fontSize" to 24, "fontWeight" to "bold", "color" to "#333333", "flex" to 1, "height" to 40)), "withdraw-rules-card" to padStyleMapOf(utsMapOf("paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "height" to "100%")), "withdraw-rules" to utsMapOf(".withdraw-rules-card " to utsMapOf("marginTop" to 10, "display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "info-icon" to utsMapOf(".withdraw-rules-card .withdraw-rules " to utsMapOf("width" to 16, "height" to 16, "marginRight" to 5)), "rules-list" to utsMapOf(".withdraw-rules-card " to utsMapOf("marginTop" to 5)), "rule-item" to utsMapOf(".withdraw-rules-card .rules-list " to utsMapOf("marginBottom" to 5)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
