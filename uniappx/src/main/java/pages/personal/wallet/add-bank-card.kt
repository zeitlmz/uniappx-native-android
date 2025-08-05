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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xTipsS.XTIPS_TYPE
import uts.sdk.modules.xToastS.XTOAST_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import uts.sdk.modules.xTipsS.showTips as showTips1
import uts.sdk.modules.xToastS.showToast as showToast1
import uts.sdk.modules.xToastS.hideToast
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalWalletAddBankCard : BasePage {
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
        var setup: (__props: GenPagesPersonalWalletAddBankCard) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalWalletAddBankCard
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val globalData = inject("globalData") as GlobalDataType
            val reqData = reactive<BANK_CARD_INFO>(BANK_CARD_INFO(id = 0, realName = "", idCard = "", bankName = "", bankCard = "", bankPhone = "", bankLogo = "", code = "", status = -1, bankNameAndCard = ""))
            var vaildUsername = utsArrayOf<FORM_RULE>(FORM_RULE(type = "string", errorMessage = "不能空且要小于4个字符", trigger = "blur", valid = fun(kVal: Any?): Boolean {
                var pval = kVal as String
                return pval.length > 0 && pval.length <= 4
            }
            ))
            var vaildIdCard = utsArrayOf<FORM_RULE>(FORM_RULE(type = "string", errorMessage = "不能空且不小于18个字符", valid = fun(kVal: Any?): Boolean {
                var pval = kVal as String
                return pval.length == 18
            }
            ))
            var vaildBankCard = utsArrayOf<FORM_RULE>(FORM_RULE(type = "string", errorMessage = "银行卡号必须是16-19位数字", valid = fun(kVal: Any?): Boolean {
                var pval = kVal as String
                return UTSRegExp("^\\d{16,19}\$", "").test(pval)
            }
            ))
            var vaildPhone = utsArrayOf<FORM_RULE>(FORM_RULE(type = "string", errorMessage = "请输入正确的手机号", valid = fun(kVal: Any?): Boolean {
                var pval = kVal as String
                return UTSRegExp("^1[3-9]\\d{9}\$", "").test(pval)
            }
            ))
            var vaildVerifyCode = utsArrayOf<FORM_RULE>(FORM_RULE(type = "string", errorMessage = "验证码必须是4-6位数字", valid = fun(kVal: Any?): Boolean {
                var pval = kVal as String
                return UTSRegExp("^\\d{4,6}\$", "").test(pval)
            }
            ))
            val validname = ref<UTSArray<FORM_RULE>>(vaildUsername)
            val vaildIdCards = ref<UTSArray<FORM_RULE>>(vaildIdCard)
            val vaildBankCards = ref<UTSArray<FORM_RULE>>(vaildBankCard)
            val vaildPhones = ref<UTSArray<FORM_RULE>>(vaildPhone)
            val vaildVerifyCodes = ref<UTSArray<FORM_RULE>>(vaildVerifyCode)
            val countdown = ref<Number>(0)
            val onGetCode = fun(){
                if (countdown.value > 0) {
                    return
                }
                if (reqData.bankPhone == null || reqData.bankPhone == "") {
                    showTips1(XTIPS_TYPE(title = "请输入预留手机号", iconCode = "error", iconColor = "red", titleColor = "red", position = "bottom"))
                    return
                }
                showLoading(XLOADINGS_TYPE(title = "验证码发送中"))
                sendBankCardPhoneValid(reqData.bankPhone as String).then(fun(res: Response){
                    if (res.code == 200) {
                        showToast1(XTOAST_TYPE(title = "验证码发送成功", iconCode = "success", iconColor = "green", titleColor = "green"))
                        hideXloading()
                        countdown.value = 60
                        var timer: Number = 0
                        timer = setInterval(fun(){
                            countdown.value--
                            if (countdown.value <= 0) {
                                clearInterval(timer)
                            }
                        }
                        , 1000)
                    }
                }
                )
            }
            val toValidateBankCard = fun(){
                val param = JSON.parse(JSON.stringify(reqData)) as UTSJSONObject
                validateBankCard(param).then(fun(res: Response){
                    if (res.code == 200) {
                        val result = res.data as UTSJSONObject
                        reqData.bankName = result.getString("bankName") ?: ""
                        reqData.bankLogo = result.getString("bankLogo") ?: ""
                        onGetCode()
                    } else {
                        showToast1(XTOAST_TYPE(title = res.msg, iconCode = "error"))
                    }
                }
                )
            }
            val toAddBankCard = fun(){
                val param = JSON.parse(JSON.stringify(reqData)) as UTSJSONObject
                param.set("id", null)
                addBankCard(param).then(fun(res: Response){
                    if (res.code == 200) {
                        showToast1(XTOAST_TYPE(title = "添加成功", iconCode = "success", iconColor = "green", titleColor = "green"))
                        router.push("/pages/personal/wallet/bank-card")
                    } else {
                        showToast1(XTOAST_TYPE(title = res.msg, iconCode = "error"))
                    }
                }
                )
            }
            return fun(): Any? {
                val _component_x_input = resolveEasyComponent("x-input", GenUniModulesTmxUiComponentsXInputXInputClass)
                val _component_x_form_item = resolveEasyComponent("x-form-item", GenUniModulesTmxUiComponentsXFormItemXFormItemClass)
                val _component_x_form = resolveEasyComponent("x-form", GenUniModulesTmxUiComponentsXFormXFormClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createVNode(_component_mc_base_container, utsMapOf("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to false, "title" to "添加银行卡"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("style" to normalizeStyle("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        createElementVNode("view", utsMapOf("class" to "home-bg"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "top-bg"))
                        )),
                        createElementVNode("view", utsMapOf("class" to "container", "style" to normalizeStyle("height: " + (unref(screenHeight) - unref(globalData).safeAreaBottom - unref(statusBarHeight) - 20) + "px;")), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "mt-50 mb-15"), utsArrayOf(
                                createVNode(_component_x_sheet, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createVNode(_component_x_form, utsMapOf("ref" to "form", "modelValue" to unref(reqData), "onUpdate:modelValue" to fun(`$event`: BANK_CARD_INFO){
                                            trySetRefValue(reqData, `$event`)
                                        }
                                        , "labelFontSize" to "13"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createVNode(_component_x_form_item, utsMapOf("rule" to unref(validname), "field" to "username", "label" to "姓名", "required" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        createVNode(_component_x_input, utsMapOf("cursor-color" to "red", "color" to "transparent", "modelValue" to unref(reqData).realName, "onUpdate:modelValue" to fun(`$event`: String){
                                                            unref(reqData).realName = `$event`
                                                        }
                                                        , "align" to "right", "placeholder" to "请输入姓名"), null, 8, utsArrayOf(
                                                            "modelValue",
                                                            "onUpdate:modelValue"
                                                        ))
                                                    )
                                                }
                                                ), "_" to 1), 8, utsArrayOf(
                                                    "rule"
                                                )),
                                                createVNode(_component_x_form_item, utsMapOf("rule" to unref(vaildIdCards), "field" to "idCardNum", "label" to "身份证号", "required" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        createVNode(_component_x_input, utsMapOf("color" to "transparent", "modelValue" to unref(reqData).idCard, "onUpdate:modelValue" to fun(`$event`: String){
                                                            unref(reqData).idCard = `$event`
                                                        }
                                                        , "align" to "right", "placeholder" to "请输入身份证号"), null, 8, utsArrayOf(
                                                            "modelValue",
                                                            "onUpdate:modelValue"
                                                        ))
                                                    )
                                                }
                                                ), "_" to 1), 8, utsArrayOf(
                                                    "rule"
                                                )),
                                                createVNode(_component_x_form_item, utsMapOf("rule" to unref(vaildBankCards), "field" to "bankCardNum", "label" to "银行卡号", "required" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        createVNode(_component_x_input, utsMapOf("color" to "transparent", "modelValue" to unref(reqData).bankCard, "onUpdate:modelValue" to fun(`$event`: String){
                                                            unref(reqData).bankCard = `$event`
                                                        }
                                                        , "align" to "right", "placeholder" to "请输入银行卡号"), null, 8, utsArrayOf(
                                                            "modelValue",
                                                            "onUpdate:modelValue"
                                                        ))
                                                    )
                                                }
                                                ), "_" to 1), 8, utsArrayOf(
                                                    "rule"
                                                )),
                                                createVNode(_component_x_form_item, utsMapOf("rule" to unref(vaildPhones), "field" to "phoneNum", "label" to "预留手机号", "required" to true, "labelWidth" to "150"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        createVNode(_component_x_input, utsMapOf("color" to "transparent", "modelValue" to unref(reqData).bankPhone, "onUpdate:modelValue" to fun(`$event`: String){
                                                            unref(reqData).bankPhone = `$event`
                                                        }
                                                        , "align" to "right", "placeholder" to "请输入手机号"), null, 8, utsArrayOf(
                                                            "modelValue",
                                                            "onUpdate:modelValue"
                                                        ))
                                                    )
                                                }
                                                ), "_" to 1), 8, utsArrayOf(
                                                    "rule"
                                                )),
                                                createVNode(_component_x_form_item, utsMapOf("rule" to unref(vaildVerifyCodes), "field" to "verifyCode", "label" to "验证码", "required" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        createVNode(_component_x_input, utsMapOf("color" to "transparent", "type" to "number", "modelValue" to unref(reqData).code, "onUpdate:modelValue" to fun(`$event`: String){
                                                            unref(reqData).code = `$event`
                                                        }
                                                        , "align" to "right", "placeholder" to "请输入", "font-size" to "30rpx"), utsMapOf("inputRight" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "get-code-btn", "onClick" to toValidateBankCard), toDisplayString(if (unref(countdown) > 0) {
                                                                    "" + unref(countdown) + "s\u540E\u91CD\u8BD5"
                                                                } else {
                                                                    "获取验证码"
                                                                }
                                                                ), 1)
                                                            )
                                                        }
                                                        ), "_" to 1), 8, utsArrayOf(
                                                            "modelValue",
                                                            "onUpdate:modelValue"
                                                        ))
                                                    )
                                                }
                                                ), "_" to 1), 8, utsArrayOf(
                                                    "rule"
                                                ))
                                            )
                                        }
                                        ), "_" to 1), 8, utsArrayOf(
                                            "modelValue"
                                        ))
                                    )
                                }
                                ), "_" to 1))
                            )),
                            createVNode(_component_mc_primary_button, utsMapOf("span" to -1, "height" to "45px", "onClick" to toAddBankCard), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    " 立即添加 "
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
                return utsMapOf("container" to padStyleMapOf(utsMapOf("width" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 20, "height" to 900)), "home-bg" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "bottom" to 0, "width" to "100%", "zIndex" to -1)), "top-bg" to utsMapOf(".home-bg " to utsMapOf("height" to 900, "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)")), "get-code-btn" to padStyleMapOf(utsMapOf("color" to "#536EA6", "fontSize" to "30rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
