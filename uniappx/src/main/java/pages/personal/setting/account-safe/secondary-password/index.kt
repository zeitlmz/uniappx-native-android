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
import uts.sdk.modules.xToastS.XTOAST_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import uts.sdk.modules.jjMd5.md5
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import uts.sdk.modules.xTipsS.showTips as showTips1
import uts.sdk.modules.xToastS.showToast as showToast1
import uts.sdk.modules.xToastS.hideToast
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalSettingAccountSafeSecondaryPasswordIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalSettingAccountSafeSecondaryPasswordIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalSettingAccountSafeSecondaryPasswordIndex
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val globalData = inject("globalData") as GlobalDataType
            val reqData = reactive<PHONE_INFO1>(PHONE_INFO1(phone = "", newPassword = "", code = ""))
            val showPhone = ref<String>("")
            val showPwdKey = ref<String>("")
            val countdown = ref<Number>(0)
            val changePwd = fun(opt: String){
                reqData.newPassword = opt
            }
            val onGetCode = fun(){
                if (countdown.value > 0) {
                    return
                }
                if (reqData.phone == null || reqData.phone == "") {
                    showTips1(XTIPS_TYPE(title = "手机号不能为空", iconCode = "error", iconColor = "red", titleColor = "red", position = "bottom"))
                    return
                }
                showLoading(XLOADINGS_TYPE(title = "验证码发送中"))
                sendSecondaryPasswordResetCode(reqData.phone as String).then(fun(res: Response){
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
            val toSetPwd = fun(){
                val md5Pwd = md5(reqData.newPassword)
                console.log("md5Pwd=", md5Pwd)
                updateSecondaryPassword(md5Pwd, reqData.code).then(fun(res: Response){
                    if (res.code == 200) {
                        showToast1(XTOAST_TYPE(title = "设置成功", iconCode = "success", iconColor = "green", titleColor = "green"))
                        setTimeout(fun(){
                            uni_navigateBack(null)
                        }, 1500)
                    } else {
                        showToast1(XTOAST_TYPE(title = res.msg, iconCode = "error"))
                    }
                }
                )
            }
            onReady(fun(){
                val userInfo = getCacheUserInfo()
                if (userInfo != null) {
                    reqData.phone = userInfo.getString("phoneNumber") ?: ""
                    if (reqData.phone != "") {
                        showPhone.value = reqData.phone.replace(UTSRegExp("(\\d{3})\\d{4}(\\d{4})", ""), "\$1****\$2")
                    }
                }
            }
            )
            return fun(): Any? {
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_x_input = resolveEasyComponent("x-input", GenUniModulesTmxUiComponentsXInputXInputClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_keyboard_number = resolveEasyComponent("x-keyboard-number", GenUniModulesTmxUiComponentsXKeyboardNumberXKeyboardNumberClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                return createElementVNode(Fragment, null, utsArrayOf(
                    createVNode(_component_mc_base_container, utsMapOf("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to false, "title" to "二级密码设置"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("view", utsMapOf("style" to normalizeStyle("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                            createElementVNode("view", utsMapOf("class" to "home-bg"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "top-bg"))
                            )),
                            createElementVNode("view", utsMapOf("class" to "container", "style" to normalizeStyle("height: " + (unref(screenHeight) - unref(globalData).safeAreaBottom - unref(statusBarHeight) - 20) + "px;")), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "mt-50 mb-15"), utsArrayOf(
                                    createVNode(_component_x_sheet, utsMapOf("height" to "120rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "view-itme"), utsArrayOf(
                                                createElementVNode("view", null, utsArrayOf(
                                                    createVNode(_component_x_text, utsMapOf("style" to normalizeStyle(utsMapOf("font-weight" to "bold"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return utsArrayOf(
                                                            "手机号："
                                                        )
                                                    }
                                                    ), "_" to 1), 8, utsArrayOf(
                                                        "style"
                                                    ))
                                                )),
                                                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "50%"))), utsArrayOf(
                                                    createVNode(_component_x_input, utsMapOf("placeholder" to (unref(showPhone) as String), "disabled" to true, "color" to "transparent", "align" to "right"), null, 8, utsArrayOf(
                                                        "placeholder"
                                                    ))
                                                ), 4)
                                            ))
                                        )
                                    }
                                    ), "_" to 1)),
                                    createVNode(_component_x_sheet, utsMapOf("height" to "120rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "view-itme"), utsArrayOf(
                                                createElementVNode("view", null, utsArrayOf(
                                                    createVNode(_component_x_text, utsMapOf("style" to normalizeStyle(utsMapOf("font-weight" to "bold"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return utsArrayOf(
                                                            "验证码："
                                                        )
                                                    }
                                                    ), "_" to 1), 8, utsArrayOf(
                                                        "style"
                                                    ))
                                                )),
                                                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "50%"))), utsArrayOf(
                                                    createVNode(_component_x_input, utsMapOf("color" to "transparent", "type" to "number", "maxlength" to 6, "font-size" to "30rpx", "modelValue" to unref(reqData).code, "onUpdate:modelValue" to fun(`$event`: String){
                                                        unref(reqData).code = `$event`
                                                    }
                                                    , "align" to "right", "placeholder" to "请输入"), utsMapOf("inputRight" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return utsArrayOf(
                                                            createElementVNode("text", utsMapOf("class" to "get-code-btn", "onClick" to onGetCode), toDisplayString(if (unref(countdown) > 0) {
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
                                                ), 4)
                                            ))
                                        )
                                    }
                                    ), "_" to 1)),
                                    createVNode(_component_x_sheet, utsMapOf("height" to "120rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "view-itme"), utsArrayOf(
                                                createElementVNode("view", null, utsArrayOf(
                                                    createVNode(_component_x_text, utsMapOf("style" to normalizeStyle(utsMapOf("font-weight" to "bold"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return utsArrayOf(
                                                            "二级密码："
                                                        )
                                                    }
                                                    ), "_" to 1), 8, utsArrayOf(
                                                        "style"
                                                    ))
                                                )),
                                                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "60%"))), utsArrayOf(
                                                    createVNode(_component_x_keyboard_number, utsMapOf("mode" to "password", "digit" to false, "bgColor" to "#ffffff", "showValue" to false, "maxLen" to 6, "modelValue" to unref(reqData).newPassword, "onUpdate:modelValue" to fun(`$event`: String){
                                                        unref(reqData).newPassword = `$event`
                                                    }
                                                    , "onChange" to changePwd, "title" to "安全键盘请放心输入"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return utsArrayOf(
                                                            createVNode(_component_x_input, utsMapOf("color" to "transparent", "type" to "number", "disabled" to true, "font-size" to "30rpx", "maxlength" to 6, "modelValue" to unref(reqData).newPassword, "onUpdate:modelValue" to fun(`$event`: String){
                                                                unref(reqData).newPassword = `$event`
                                                            }
                                                            , "align" to "right", "placeholder" to "请输入六位数二级密码"), null, 8, utsArrayOf(
                                                                "modelValue",
                                                                "onUpdate:modelValue"
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 1), 8, utsArrayOf(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                ), 4)
                                            ))
                                        )
                                    }
                                    ), "_" to 1))
                                ))
                            ), 4)
                        )
                    }
                    ), "_" to 1)),
                    createElementVNode("view", utsMapOf("class" to "bottom-panel flex-row"), utsArrayOf(
                        createVNode(_component_mc_primary_button, utsMapOf("height" to "89rpx", "onClick" to toSetPwd), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                "确认"
                            )
                        }
                        ), "_" to 1))
                    ))
                ), 64)
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
                return utsMapOf("container" to padStyleMapOf(utsMapOf("width" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 20, "height" to 900)), "home-bg" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "bottom" to 0, "width" to "100%", "zIndex" to -1)), "top-bg" to utsMapOf(".home-bg " to utsMapOf("height" to 900, "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)")), "get-code-btn" to padStyleMapOf(utsMapOf("color" to "#536EA6", "fontSize" to "30rpx")), "view-itme" to padStyleMapOf(utsMapOf("width" to "100%", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "marginTop" to "-10rpx")), "bottom-panel" to padStyleMapOf(utsMapOf("position" to "fixed", "bottom" to 0, "left" to 0, "width" to "100%", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "60rpx", "paddingLeft" to "20rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
