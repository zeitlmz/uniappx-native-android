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
open class GenPagesPersonalSettingAccountSafeIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalSettingAccountSafeIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalSettingAccountSafeIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val router = uni_useKuxRouter()
            val secondPasswordStatus = ref<Boolean>(false)
            val toAccountCancellation = fun(){
                router.push("/pages/personal/setting/account-safe/account-cancellation/index")
            }
            val toRevokePrivacy = fun(){
                router.push("/pages/personal/setting/account-safe/revoke-privacy/index")
            }
            val toSecondaryPassword = fun(){
                router.push("/pages/personal/setting/account-safe/secondary-password/index")
            }
            onReady(fun(){
                checkUserSetSecondPassword().then(fun(res: Response){
                    if (res.code == 200) {
                        secondPasswordStatus.value = res.data as Boolean
                    }
                }
                )
            }
            )
            return fun(): Any? {
                val _component_mc_active_animation = resolveEasyComponent("mc-active-animation", GenComponentsMcActiveAnimationIndexClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createVNode(_component_mc_base_container, utsMapOf("title" to "账户与安全"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                            "15"
                        ), "padding" to utsArrayOf(
                            "20",
                            "15",
                            "20",
                            "25"
                        )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createVNode(_component_mc_active_animation, utsMapOf("class" to "setting-item", "onClick" to toSecondaryPassword), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "setting-header"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "label"), "二级密码"),
                                            if (isTrue(unref(secondPasswordStatus))) {
                                                createElementVNode("text", utsMapOf("key" to 0, "class" to "label", "style" to normalizeStyle(utsMapOf("color" to "seagreen"))), "已设置", 4)
                                            } else {
                                                createElementVNode("text", utsMapOf("key" to 1, "class" to "label", "style" to normalizeStyle(utsMapOf("color" to "red"))), "未设置", 4)
                                            }
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "desc"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "text"), "可用于更换手机号、提现")
                                        ))
                                    )
                                }
                                ), "_" to 1))
                            )
                        }
                        ), "_" to 1)),
                        createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                            "15"
                        ), "padding" to utsArrayOf(
                            "20",
                            "15",
                            "20",
                            "25"
                        )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createVNode(_component_mc_active_animation, utsMapOf("class" to "setting-item", "onClick" to toAccountCancellation), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "setting-header"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "label"), "永久注销账号"),
                                            createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                "src"
                                            ))
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "desc"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "text"), "操作后账号信息无法恢复，请谨慎操作")
                                        ))
                                    )
                                }
                                ), "_" to 1))
                            )
                        }
                        ), "_" to 1)),
                        createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                            "15"
                        ), "padding" to utsArrayOf(
                            "20",
                            "15",
                            "20",
                            "25"
                        )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createVNode(_component_mc_active_animation, utsMapOf("class" to "setting-item", "onClick" to toRevokePrivacy), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "setting-header"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "label"), "撤回同意隐私政策"),
                                            createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                "src"
                                            ))
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "desc"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "text"), "操作后账号信息无法恢复，请谨慎操作")
                                        ))
                                    )
                                }
                                ), "_" to 1))
                            )
                        }
                        ), "_" to 1))
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
                return utsMapOf("setting-header" to utsMapOf(".setting-item " to utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingBottom" to "20rpx")), "label" to utsMapOf(".setting-item .setting-header " to utsMapOf("fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "icon" to utsMapOf(".setting-item .setting-header " to utsMapOf("width" to "11rpx", "height" to "21rpx")), "text" to utsMapOf(".setting-item .desc " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#454545")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
