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
import uts.sdk.modules.xToastS.XTOAST_TYPE
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import uts.sdk.modules.xModalS.showModal
import uts.sdk.modules.xToastS.showToast as showToast1
import uts.sdk.modules.xToastS.hideToast
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalSettingAccountSafeRevokePrivacyIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalSettingAccountSafeRevokePrivacyIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalSettingAccountSafeRevokePrivacyIndex
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val globalData = inject("globalData") as GlobalDataType
            val confirm = fun(){
                showModal(X_MODAL_TYPE(title = "温馨提示", content = "确认要进行撤回同意隐私政策操作吗?", confirmText = "确认", clickMaskClose = false, confirmBgColor = globalData.theme.primaryColor, confirm = fun(){
                    val curUser = getCacheUserInfo()
                    val param: UTSJSONObject = object : UTSJSONObject() {
                        var grantPlatform: Number = 4
                        var loginAccount = curUser?.getString("account")
                    }
                    closeAccount(param).then(fun(res: Response){
                        globalData.entryStatus = 0
                        if (res.code == 200) {
                            clearAuth()
                            showToast1(XTOAST_TYPE(title = "撤回成功", iconCode = "success", iconColor = "green", titleColor = "green"))
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
                return _cV(_component_mc_base_container, _uM("scroll" to true, "bg-color" to "#ffffff", "title" to "撤回同意隐私政策提醒"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_x_sheet, _uM("margin" to _uA(
                            "0"
                        ), "padding" to _uA(
                            "20",
                            "20",
                            "20",
                            "25"
                        )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("text", _uM("class" to "text-item"), "撤回每橙车主基本功能"),
                                _cE("text", _uM("class" to "text-item bold"), "个人信息处理规则须知:"),
                                _cE("text", _uM("class" to "text-item bold"), "在您撤回《个人信息处理规则》授权前，请先阅读并同意以下内容："),
                                _cE("text", _uM("class" to "text-item"), "一、因为您撤回对基本功能处理您必要个人信息的授权，当您点击“撤回授权”，我们将为您注销账号。"),
                                _cE("text", _uM("class" to "text-item"), "二、撤回授权后您在App中的个人信息和相关权益将被清空，至少包括以下信息："),
                                _cE("text", _uM("class" to "text-item"), "1.车主端账号下的所有个人信息（身份证、驾驶证、车辆信息等）"),
                                _cE("text", _uM("class" to "text-item"), "2.车主端账号下的订单信息"),
                                _cE("text", _uM("class" to "text-item"), "3.车主端账号下的钱包余额、流水等数据"),
                                _cE("text", _uM("class" to "text-item"), "4.车主端账号下的资质等信息"),
                                _cE("text", _uM("class" to "text-item"), "5.车主端账号下的奖励数据；"),
                                _cE("text", _uM("class" to "text-item"), "6.以及您在车主端中留存的其他信息。"),
                                _cE("text", _uM("class" to "text-item"), "四、请您知悉，您撤回授权并不影响撤回前我们基于您的授权已经进行的个人信息处理活动。"),
                                _cE("text", _uM("class" to "text-item"), "五、在您撤回授权后，如您被投诉、举报、诉讼、仲裁、国家有权机关调查或者存在其他我们依法需要配合处理的情况，我们会依法进行处理，并基于这些处理行为按照最小必要原则处理您的个人信息。"),
                                _cE("text", _uM("class" to "text-item"), "六、您撤回授权或者注销账号后，我们会按照个人信息处理规则声明的保存期限保存您的个人信息，保存期满后进行删除或者匿名化处理。"),
                                _cE("view", _uM("class" to "placeholder-box"))
                            )
                        }
                        ), "_" to 1)),
                        _cE("view", _uM("class" to "btn-group-panel flex-row", "style" to _nS("padding-bottom: " + (unref(globalData).safeAreaBottom + 15) + "px;")), _uA(
                            _cV(_component_mc_primary_button, _uM("onClick" to confirm, "height" to "50px"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    "确认撤回"
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
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("text-item" to _uM("" to _uM("fontSize" to "30rpx", "color" to "#000000", "lineHeight" to "60rpx"), ".title" to _uM("fontSize" to "36rpx", "fontWeight" to "bold", "color" to "#000000", "lineHeight" to "60rpx"), ".sub-title" to _uM("fontSize" to "36rpx", "fontWeight" to "bold", "color" to "#000000", "lineHeight" to "60rpx"), ".bold" to _uM("fontWeight" to "bold")), "placeholder-box" to _pS(_uM("height" to "400rpx", "width" to "100%")), "btn-group-panel" to _pS(_uM("position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
