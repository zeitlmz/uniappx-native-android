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
            val toAccountBind = fun(){
                router.push("/pages/personal/setting/account-safe/account-bind/index")
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
                return _cV(_component_mc_base_container, _uM("title" to "账户与安全"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        if (unref(globalData).entryStatus == unref(AUDIT_APPROVE)) {
                            _cV(_component_x_sheet, _uM("key" to 0, "margin" to _uA(
                                "15"
                            ), "padding" to _uA(
                                "20",
                                "15",
                                "20",
                                "25"
                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_mc_active_animation, _uM("class" to "setting-item", "onClick" to toSecondaryPassword), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "setting-header"), _uA(
                                                _cE("text", _uM("class" to "label"), "二级密码"),
                                                if (isTrue(unref(secondPasswordStatus))) {
                                                    _cE("text", _uM("key" to 0, "class" to "label", "style" to _nS(_uM("color" to "seagreen"))), "已设置", 4)
                                                } else {
                                                    _cE("text", _uM("key" to 1, "class" to "label", "style" to _nS(_uM("color" to "red"))), "未设置", 4)
                                                }
                                            )),
                                            _cE("view", _uM("class" to "desc"), _uA(
                                                _cE("text", _uM("class" to "text"), "可用于更换手机号、提现")
                                            ))
                                        )
                                    }), "_" to 1))
                                )
                            }), "_" to 1))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cV(_component_x_sheet, _uM("margin" to _uA(
                            "15"
                        ), "padding" to _uA(
                            "20",
                            "15",
                            "20",
                            "25"
                        )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_mc_active_animation, _uM("class" to "setting-item", "onClick" to toAccountBind), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", _uM("class" to "setting-header"), _uA(
                                            _cE("text", _uM("class" to "label"), "账号绑定管理"),
                                            _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 8, _uA(
                                                "src"
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "desc"), _uA(
                                            _cE("text", _uM("class" to "text"), "绑定微信、支付宝等账号")
                                        ))
                                    )
                                }
                                ), "_" to 1))
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_x_sheet, _uM("margin" to _uA(
                            "15"
                        ), "padding" to _uA(
                            "20",
                            "15",
                            "20",
                            "25"
                        )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_mc_active_animation, _uM("class" to "setting-item", "onClick" to toRevokePrivacy), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", _uM("class" to "setting-header"), _uA(
                                            _cE("text", _uM("class" to "label"), "撤回同意隐私政策"),
                                            _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 8, _uA(
                                                "src"
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "desc"), _uA(
                                            _cE("text", _uM("class" to "text"), "操作后账号信息无法恢复，请谨慎操作")
                                        ))
                                    )
                                }
                                ), "_" to 1))
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_x_sheet, _uM("margin" to _uA(
                            "15"
                        ), "padding" to _uA(
                            "20",
                            "15",
                            "20",
                            "25"
                        )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_mc_active_animation, _uM("class" to "setting-item", "onClick" to toAccountCancellation), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", _uM("class" to "setting-header"), _uA(
                                            _cE("text", _uM("class" to "label"), "永久注销账号"),
                                            _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 8, _uA(
                                                "src"
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "desc"), _uA(
                                            _cE("text", _uM("class" to "text"), "操作后账号信息无法恢复，请谨慎操作")
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
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("setting-header" to _uM(".setting-item " to _uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingBottom" to "20rpx")), "label" to _uM(".setting-item .setting-header " to _uM("fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "icon" to _uM(".setting-item .setting-header " to _uM("width" to "11rpx", "height" to "21rpx")), "text" to _uM(".setting-item .desc " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#454545")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
