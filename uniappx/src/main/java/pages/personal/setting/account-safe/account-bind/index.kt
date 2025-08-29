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
import uts.sdk.modules.mcAlipaySdk.AlipayLoginOptions
import uts.sdk.modules.mcAlipaySdk.AlipayShare
import uts.sdk.modules.mcAlipaySdk.AlipayLoginSuccess
import uts.sdk.modules.mcWechatSdk.WeChatLoginOptions
import uts.sdk.modules.mcWechatSdk.WeChatLoginSuccess
import uts.sdk.modules.mcWechatSdk.WeChatShare
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalSettingAccountSafeAccountBindIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalSettingAccountSafeAccountBindIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalSettingAccountSafeAccountBindIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val router = uni_useKuxRouter()
            val showRouteLove = ref(false)
            val menuList = ref(_uA<MenuItem3>())
            val queryDriverThirdLoginInfo = fun(){
                getDriverThirdLoginInfo().then(fun(res: Response){
                    if (res.code == 200) {
                        val data = res.data as UTSJSONObject
                        val wxThirdLoginBind = data.getBoolean("wxThirdLoginBind")
                        val alipayThirdLoginBind = data.getBoolean("alipayThirdLoginBind")
                        val appleThirdLoginBind = data.getBoolean("appleThirdLoginBind")
                        menuList.value[0].status = wxThirdLoginBind ?: false
                        menuList.value[1].status = alipayThirdLoginBind ?: false
                        if (menuList.value.length > 2) {
                            menuList.value[2].status = appleThirdLoginBind ?: false
                        }
                    }
                }
                )
            }
            val wechatLogin = fun(){
                WeChatShare.getInstance().login(WeChatLoginOptions(state = "mc-driver", success = fun(res: WeChatLoginSuccess){
                    console.log("wechatLogin success=>", res)
                    driverBindThirdLogin(object : UTSJSONObject() {
                        var loginAccount = res.code
                        var grantPlatform: Number = 5
                    }).then(fun(resData: Response){
                        console.log("wechatLogin driverBindThirdLogin res=", resData)
                        queryDriverThirdLoginInfo()
                    }
                    )
                }
                , fail = fun(err: Any){
                    console.log("wechatLogin error=>", err)
                }
                ))
            }
            val alipayLogin = fun(){
                AlipayShare.getInstance().login(AlipayLoginOptions(success = fun(res: AlipayLoginSuccess){
                    console.log("alipayAuth success=>", res)
                    driverBindThirdLogin(object : UTSJSONObject() {
                        var loginAccount = res.code
                        var grantPlatform: Number = 12
                    }).then(fun(resData: Response){
                        console.log("alipayLogin driverBindThirdLogin resData=", resData)
                        queryDriverThirdLoginInfo()
                    }
                    )
                }
                , fail = fun(err: Any){
                    console.log("alipayLogin error=>", err)
                }
                ))
            }
            val toBind = fun(agreementType: Number){
                if (agreementType == 1) {
                    wechatLogin()
                } else if (agreementType == 2) {
                    alipayLogin()
                }
            }
            onPageShow(fun(){
                menuList.value = _uA(
                    MenuItem3(title = "微信", showArrow = true, icon = "/static/icons/icon-wechat.png", status = true, click = fun(){
                        toBind(1)
                    }
                    ),
                    MenuItem3(title = "支付宝", showArrow = true, icon = "/static/icons/icon-alipay.png", status = false, click = fun(){
                        toBind(2)
                    }
                    )
                )
                queryDriverThirdLoginInfo()
            }
            )
            return fun(): Any? {
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_mc_active_animation = resolveEasyComponent("mc-active-animation", GenComponentsMcActiveAnimationIndexClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return _cV(_component_mc_base_container, _uM("title" to "账号绑定管理"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(menuList), fun(menu, index, __index, _cached): Any {
                            return _cV(_component_mc_active_animation, _uM("key" to menu.title), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_x_sheet, _uM("margin" to _uA(
                                        "15",
                                        if (index > 0) {
                                            "0"
                                        } else {
                                            "15"
                                        }
                                        ,
                                        "15",
                                        "15"
                                    ), "padding" to _uA(
                                        "20"
                                    ), "onClick" to menu.click), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "setting-item"), _uA(
                                                _cE("view", _uM("class" to "item-right", "style" to _nS(_uM<String, Any?>())), _uA(
                                                    _cE("image", _uM("class" to "icon", "mode" to "widthFix", "style" to _nS(_uM<String, Any?>()), "src" to ("" + unref(resBaseUrl) + menu.icon)), null, 12, _uA(
                                                        "src"
                                                    )),
                                                    _cE("text", _uM("class" to "name"), _tD(menu.title), 1)
                                                ), 4),
                                                _cE("view", _uM("class" to "flex-row"), _uA(
                                                    _cE("text", _uM("style" to _nS(_uM("color" to "#6C6C6C"))), _tD(if (menu.status) {
                                                        "已绑定"
                                                    } else {
                                                        "未绑定"
                                                    }
                                                    ), 5),
                                                    if (isTrue(menu.showArrow)) {
                                                        _cE("image", _uM("key" to 0, "class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 8, _uA(
                                                            "src"
                                                        ))
                                                    } else {
                                                        _cC("v-if", true)
                                                    }
                                                ))
                                            ))
                                        )
                                    }
                                    ), "_" to 2), 1032, _uA(
                                        "margin",
                                        "onClick"
                                    ))
                                )
                            }
                            ), "_" to 2), 1024)
                        }
                        ), 128)
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
                return _uM("setting-item" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "item-right" to _uM(".setting-item " to _uM("flexDirection" to "row", "alignItems" to "center")), "icon" to _uM(".setting-item .item-right " to _uM("width" to "45rpx", "height" to "45rpx", "marginRight" to "10rpx"), ".setting-item " to _uM("width" to "17rpx", "height" to "28rpx", "marginLeft" to "20rpx")), "name" to _uM(".setting-item " to _uM("fontSize" to 17)), "bottom-panel" to _pS(_uM("position" to "fixed", "bottom" to 0, "left" to 0, "width" to "100%", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "60rpx", "paddingLeft" to "20rpx", "boxShadow" to "0 -2px 10px rgba(0, 0, 0, 0.1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
