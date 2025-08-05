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
import uts.sdk.modules.xToastS.XTOAST_TYPE
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import uts.sdk.modules.xModalS.showModal
import uts.sdk.modules.xToastS.showToast as showToast1
import uts.sdk.modules.xToastS.hideToast
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalSettingAccountSafeAccountCancellationIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalSettingAccountSafeAccountCancellationIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalSettingAccountSafeAccountCancellationIndex
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val globalData = inject("globalData") as GlobalDataType
            val confirm = fun(){
                showModal(X_MODAL_TYPE(title = "温馨提示", content = "确认要进行账号注销操作吗?", confirmText = "确认", clickMaskClose = false, confirmBgColor = globalData.theme.primaryColor, confirm = fun(){
                    val curUser = getCacheUserInfo()
                    val param: UTSJSONObject = object : UTSJSONObject() {
                        var grantPlatform: Number = 4
                        var loginAccount = curUser?.getString("account")
                    }
                    closeAccount(param).then(fun(res: Response){
                        globalData.entryStatus = 0
                        if (res.code == 200) {
                            clearAuth()
                            showToast1(XTOAST_TYPE(title = "注销成功", iconCode = "success", iconColor = "green", titleColor = "green"))
                            router.push("/pages/home/index")
                        }
                    }
                    )
                }
                ))
            }
            return fun(): Any? {
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createVNode(_component_mc_base_container, utsMapOf("bg-color" to "#ffffff", "title" to "账号注销提示"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                            "0"
                        ), "padding" to utsArrayOf(
                            "20",
                            "20",
                            "20",
                            "25"
                        )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "text-item"), "1. 账号注销后，您在每橙的信息将被清空且无法找回。"),
                                createElementVNode("text", utsMapOf("class" to "text-item"), "2. 账号注销后，我们将停止为您提供服务，并根据法律法规规定及平台个人信息处理规则约定的期限对您的个人信息停止除存储和采取必要的安全保护措施之外的处理。在保存期限内，我们将不再对您的个人信息进行商业化使用。保存期限届满后我们将对您的个人信息进行匿名化处理。"),
                                createElementVNode("text", utsMapOf("class" to "text-item"), "3. 如您使用每橙服务过程中存在违反法律法规每橙使用协议、规则等的情形，您的违法、违约记录及相应的每橙信用记录不会随着账号的注销而清除，将被每橙永久保存。"),
                                createElementVNode("text", utsMapOf("class" to "text-item"), "4. 如您注销账号后，重新注册账号，违法、违约记录及相应的每橙信用记录将会恢复。")
                            )
                        }
                        ), "_" to 1)),
                        createElementVNode("view", utsMapOf("class" to "btn-group-panel flex-row", "style" to normalizeStyle("padding-bottom: " + (unref(globalData).safeAreaBottom + 15) + "px;")), utsArrayOf(
                            createVNode(_component_mc_primary_button, utsMapOf("onClick" to confirm, "height" to "50px"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    "确认注销"
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
                return utsMapOf("text-item" to padStyleMapOf(utsMapOf("fontSize" to "30rpx", "color" to "#000000", "lineHeight" to "60rpx")), "btn-group-panel" to padStyleMapOf(utsMapOf("position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
