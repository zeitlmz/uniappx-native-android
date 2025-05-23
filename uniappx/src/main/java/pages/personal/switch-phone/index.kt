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
            val containerHeight = screenHeight - globalData.safeAreaBottom - statusBarHeight - 20 as Number
            val reqData = reactive<PHONE_INFO>(PHONE_INFO(oldPhoneNumber = "", newPhoneNumber = "", code = ""))
            val phoneRule = FORM_RULE(type = "string", errorMessage = "请输入正确的手机号", valid = fun(kVal: Any?): Boolean {
                var pval = kVal as String
                return UTSRegExp("^1[3-9]\\d{9}\$", "").test(pval)
            }
            )
            var vaildPhone = utsArrayOf<FORM_RULE>(phoneRule)
            val codeRule = FORM_RULE(type = "string", errorMessage = "验证码必须是4-6位数字", valid = fun(kVal: Any?): Boolean {
                var pval = kVal as String
                return UTSRegExp("^\\d{4,6}\$", "").test(pval)
            }
            )
            var vaildVerifyCode = utsArrayOf<FORM_RULE>(codeRule)
            val vaildPhones = ref<UTSArray<FORM_RULE>>(vaildPhone)
            val vaildVerifyCodes = ref<UTSArray<FORM_RULE>>(vaildVerifyCode)
            val countdown = ref<Number>(0)
            val getCountDown = fun(paramCountDown: Number): String {
                return "str"
            }
            val toSwitchCheck = fun(){
                console.log("toSwitchCheck=", reqData)
            }
            onReady(fun(){
                val userInfo = getCacheUserInfo()
            }
            )
            return fun(): Any? {
                val _component_x_input = resolveEasyComponent("x-input", GenUniModulesTmxUiComponentsXInputXInputClass)
                val _component_x_form_item = resolveEasyComponent("x-form-item", GenUniModulesTmxUiComponentsXFormItemXFormItemClass)
                val _component_x_form = resolveEasyComponent("x-form", GenUniModulesTmxUiComponentsXFormXFormClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createVNode(_component_mc_base_container, utsMapOf("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to false, "title" to "更换手机"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("style" to normalizeStyle("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        createElementVNode("view", utsMapOf("class" to "home-bg"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "top-bg"))
                        )),
                        createElementVNode("view", utsMapOf("class" to "container", "style" to normalizeStyle("height: " + containerHeight + "px;")), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "mt-50 mb-15"), utsArrayOf(
                                createVNode(_component_x_sheet, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createVNode(_component_x_form, utsMapOf("ref" to "form", "modelValue" to unref(reqData), "onUpdate:modelValue" to fun(`$event`: PHONE_INFO){
                                            trySetRefValue(reqData, `$event`)
                                        }
                                        , "labelFontSize" to "32rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createVNode(_component_x_form_item, utsMapOf("field" to "oldPhoneNumber", "label" to "手机号", "required" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        createVNode(_component_x_input, utsMapOf("color" to "transparent", "modelValue" to unref(reqData).oldPhoneNumber, "onUpdate:modelValue" to fun(`$event`){
                                                            unref(reqData).oldPhoneNumber = `$event`
                                                        }
                                                        , "align" to "right", "disabled" to true, "placeholder" to "请输入旧手机号"), null, 8, utsArrayOf(
                                                            "modelValue",
                                                            "onUpdate:modelValue"
                                                        ))
                                                    )
                                                }
                                                ), "_" to 1)),
                                                createVNode(_component_x_form_item, utsMapOf("style" to normalizeStyle(utsMapOf("font-family" to "PingFang SC")), "label" to "    当前登录手机号关联的所有账号会全部修改", "labelWidth" to "100%", "labelFontSize" to "27rpx", "labelFontColor" to "red"), null, 8, utsArrayOf(
                                                    "style"
                                                )),
                                                createVNode(_component_x_form_item, utsMapOf("rule" to unref(vaildPhones), "field" to "newPhoneNumber", "label" to "新手机号", "required" to true, "labelWidth" to "150"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        createVNode(_component_x_input, utsMapOf("color" to "transparent", "modelValue" to unref(reqData).newPhoneNumber, "onUpdate:modelValue" to fun(`$event`){
                                                            unref(reqData).newPhoneNumber = `$event`
                                                        }
                                                        , "align" to "right", "font-size" to "30rpx", "placeholder" to "请输入新手机号"), null, 8, utsArrayOf(
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
                                                        createVNode(_component_x_input, utsMapOf("color" to "transparent", "type" to "number", "modelValue" to unref(reqData).code, "onUpdate:modelValue" to fun(`$event`){
                                                            unref(reqData).code = `$event`
                                                        }
                                                        , "align" to "right", "font-size" to "30rpx", "placeholder" to "请输入"), utsMapOf("inputRight" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return utsArrayOf(
                                                                createElementVNode("text", utsMapOf("class" to "get-code-btn", "onClick" to toSwitchCheck), toDisplayString(getCountDown(unref(countdown))), 1)
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
                            ))
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
                return utsMapOf("container" to padStyleMapOf(utsMapOf("width" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 20, "height" to 900)), "home-bg" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "bottom" to 0, "width" to "100%", "zIndex" to -1)), "top-bg" to utsMapOf(".home-bg " to utsMapOf("height" to 900, "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)")), "get-code-btn" to padStyleMapOf(utsMapOf("color" to "#536EA6", "fontSize" to "30rpx")), "bottom-panel" to padStyleMapOf(utsMapOf("position" to "fixed", "bottom" to 0, "left" to 0, "width" to "100%", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "60rpx", "paddingLeft" to "20rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
