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
import uts.sdk.modules.xToastS.XTOAST_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import uts.sdk.modules.xTipsS.showTips as showTips1
import uts.sdk.modules.xToastS.showToast as showToast1
import uts.sdk.modules.xToastS.hideToast
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalSwitchPhoneIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalSwitchPhoneIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalSwitchPhoneIndex
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val globalData = inject("globalData") as GlobalDataType
            val reqData = reactive<PHONE_INFO>(PHONE_INFO(oldPhoneNumber = "", newPhoneNumber = "", code = ""))
            var vaildPhone = _uA<FORM_RULE>(FORM_RULE(type = "string", errorMessage = "请输入正确的手机号", valid = fun(kVal: Any?): Boolean {
                var pval = kVal as String
                return UTSRegExp("^1[3-9]\\d{9}\$", "").test(pval)
            }
            ))
            var vaildVerifyCode = _uA<FORM_RULE>(FORM_RULE(type = "string", errorMessage = "验证码必须是4-6位数字", valid = fun(kVal: Any?): Boolean {
                var pval = kVal as String
                return UTSRegExp("^\\d{4,6}\$", "").test(pval)
            }
            ))
            val vaildPhones = ref<UTSArray<FORM_RULE>>(vaildPhone)
            val vaildVerifyCodes = ref<UTSArray<FORM_RULE>>(vaildVerifyCode)
            val countdown = ref<Number>(0)
            val onGetCode = fun(){
                if (countdown.value > 0) {
                    return
                }
                if (reqData.newPhoneNumber == null || reqData.newPhoneNumber == "") {
                    showTips1(XTIPS_TYPE(title = "请输入预留手机号", iconCode = "error", iconColor = "red", titleColor = "red", position = "bottom"))
                    return
                }
                showLoading(XLOADINGS_TYPE(title = "验证码发送中"))
                sendChangePhoneValid(reqData.newPhoneNumber as String).then(fun(res: Response){
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
            val toSwitchCheck = fun(){
                console.log("toSwitchCheck=", reqData)
                checkPhoneNumber(reqData.newPhoneNumber).then(fun(res: Response){
                    if (res.code == 200) {
                        onGetCode()
                    } else {
                        showToast1(XTOAST_TYPE(title = res.msg, iconCode = "error"))
                    }
                }
                )
            }
            val toSwitch = fun(){
                changePhoneNumber(reqData.oldPhoneNumber, reqData.newPhoneNumber, reqData.code).then(fun(res: Response){
                    if (res.code == 200) {
                        showToast1(XTOAST_TYPE(title = "修改成功", iconCode = "success", iconColor = "green", titleColor = "green"))
                        clearAuth()
                        router.push("/pages/home/index")
                    } else {
                        showToast1(XTOAST_TYPE(title = res.msg, iconCode = "error"))
                    }
                }
                )
            }
            onReady(fun(){
                val userInfo = getCacheUserInfo()
                if (userInfo != null) {
                    reqData.oldPhoneNumber = userInfo.getString("phoneNumber") ?: ""
                }
            }
            )
            return fun(): Any? {
                val _component_x_input = resolveEasyComponent("x-input", GenUniModulesTmxUiComponentsXInputXInputClass)
                val _component_x_form_item = resolveEasyComponent("x-form-item", GenUniModulesTmxUiComponentsXFormItemXFormItemClass)
                val _component_x_form = resolveEasyComponent("x-form", GenUniModulesTmxUiComponentsXFormXFormClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_mc_base_container, _uM("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to false, "title" to "更换手机"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("style" to _nS("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                            _cE("view", _uM("class" to "home-bg"), _uA(
                                _cE("view", _uM("class" to "top-bg"))
                            )),
                            _cE("view", _uM("class" to "container", "style" to _nS("height: " + (unref(screenHeight) - unref(globalData).safeAreaBottom - unref(statusBarHeight) - 20) + "px;")), _uA(
                                _cE("view", _uM("class" to "mt-50 mb-15"), _uA(
                                    _cV(_component_x_sheet, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_x_form, _uM("ref" to "form", "modelValue" to unref(reqData), "onUpdate:modelValue" to fun(`$event`: PHONE_INFO){
                                                trySetRefValue(reqData, `$event`)
                                            }
                                            , "labelFontSize" to "32rpx"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_x_form_item, _uM("field" to "oldPhoneNumber", "label" to "手机号", "required" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _cV(_component_x_input, _uM("type" to "number", "color" to "transparent", "modelValue" to unref(reqData).oldPhoneNumber, "onUpdate:modelValue" to fun(`$event`: String){
                                                                unref(reqData).oldPhoneNumber = `$event`
                                                            }
                                                            , "align" to "right", "disabled" to true, "placeholder" to "请输入旧手机号"), null, 8, _uA(
                                                                "modelValue",
                                                                "onUpdate:modelValue"
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 1)),
                                                    _cV(_component_x_form_item, _uM("style" to _nS(_uM("font-family" to "PingFang SC")), "label" to "    当前登录手机号关联的所有账号会全部修改", "labelWidth" to "100%", "labelFontSize" to "27rpx", "labelFontColor" to "red"), null, 8, _uA(
                                                        "style"
                                                    )),
                                                    _cV(_component_x_form_item, _uM("rule" to unref(vaildPhones), "field" to "newPhoneNumber", "label" to "新手机号", "required" to true, "labelWidth" to "150"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _cV(_component_x_input, _uM("type" to "number", "color" to "transparent", "modelValue" to unref(reqData).newPhoneNumber, "onUpdate:modelValue" to fun(`$event`: String){
                                                                unref(reqData).newPhoneNumber = `$event`
                                                            }
                                                            , "align" to "right", "font-size" to "30rpx", "placeholder" to "请输入新手机号"), null, 8, _uA(
                                                                "modelValue",
                                                                "onUpdate:modelValue"
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 1), 8, _uA(
                                                        "rule"
                                                    )),
                                                    _cV(_component_x_form_item, _uM("rule" to unref(vaildVerifyCodes), "field" to "verifyCode", "label" to "验证码", "required" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _cV(_component_x_input, _uM("color" to "transparent", "type" to "number", "modelValue" to unref(reqData).code, "onUpdate:modelValue" to fun(`$event`: String){
                                                                unref(reqData).code = `$event`
                                                            }
                                                            , "align" to "right", "font-size" to "30rpx", "placeholder" to "请输入"), _uM("inputRight" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _cE("text", _uM("class" to "get-code-btn", "onClick" to toSwitchCheck), _tD(if (unref(countdown) > 0) {
                                                                        "" + unref(countdown) + "s\u540E\u91CD\u8BD5"
                                                                    } else {
                                                                        "获取验证码"
                                                                    }
                                                                    ), 1)
                                                                )
                                                            }
                                                            ), "_" to 1), 8, _uA(
                                                                "modelValue",
                                                                "onUpdate:modelValue"
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 1), 8, _uA(
                                                        "rule"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "modelValue"
                                            ))
                                        )
                                    }
                                    ), "_" to 1))
                                ))
                            ), 4)
                        )
                    }
                    ), "_" to 1)),
                    _cE("view", _uM("class" to "bottom-panel flex-row", "style" to _nS("padding-bottom: " + (unref(globalData).safeAreaBottom + 15) + "px;")), _uA(
                        _cV(_component_mc_primary_button, _uM("height" to "45px", "onClick" to toSwitch), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                " 修改 "
                            )
                        }
                        ), "_" to 1))
                    ), 4)
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
                return _uM("container" to _pS(_uM("width" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 20, "height" to 900)), "home-bg" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "bottom" to 0, "width" to "100%", "zIndex" to -1)), "top-bg" to _uM(".home-bg " to _uM("height" to 900, "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)")), "get-code-btn" to _pS(_uM("color" to "#536EA6", "fontSize" to "30rpx")), "bottom-panel" to _pS(_uM("position" to "fixed", "bottom" to 0, "left" to 0, "width" to "100%", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "60rpx", "paddingLeft" to "20rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
