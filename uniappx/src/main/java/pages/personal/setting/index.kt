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
import uts.sdk.modules.xTipsS.XTIPS_TYPE
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import uts.sdk.modules.xModalS.showModal
import uts.sdk.modules.xTipsS.showTips as showTips1
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalSettingIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalSettingIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalSettingIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val router = uni_useKuxRouter()
            val showRouteLove = ref(false)
            val menuList = _uA<MenuItem>(MenuItem(title = "账户与安全", showArrow = true, isHide = !globalData.isLogin, click = fun(){
                console.log("进入账户与安全")
                router.push("/pages/personal/setting/account-safe/index")
            }
            ), MenuItem(title = "紧急联系人", showArrow = true, isHide = globalData.entryStatus != AUDIT_APPROVE, click = fun(){
                router.push("/pages/personal/setting/emergency-contact/index")
            }
            ), MenuItem(title = "权限管理", showArrow = true, isHide = false, click = fun(){
                router.push("/pages/personal/setting/grant-manage/index")
            }
            ), MenuItem(title = "协议管理", showArrow = true, isHide = false, click = fun(){
                router.push("/pages/personal/setting/agreement/index")
            }
            ), MenuItem(title = "关于我们", showArrow = true, isHide = false, click = fun(){
                router.push("/pages/personal/setting/about-us/index")
            }
            ), MenuItem(title = "联系我们", showArrow = true, isHide = false, click = fun(){
                router.push("/pages/personal/setting/contact-us/index")
            }
            ), MenuItem(title = "版本号", value = appVersion, showArrow = false, isHide = false, click = fun(){}))
            val handleLogout = fun(){
                showModal(X_MODAL_TYPE(title = "温馨提示", content = "确认要退出登录", confirmText = "知道了", clickMaskClose = false, confirmBgColor = globalData.theme.primaryColor, confirm = fun(){
                    logout().then(fun(res: Response){
                        globalData.entryStatus = 0
                        if (res.code == 200) {
                            clearAuth()
                            router.push("/pages/home/index")
                            showTips1(XTIPS_TYPE(title = "已退出登录", iconCode = "success", iconColor = "green", titleColor = "green", position = "bottom"))
                        } else {
                            showTips1(XTIPS_TYPE(title = res.msg, iconCode = "error", iconColor = "red", titleColor = "red", position = "bottom"))
                        }
                    }
                    )
                }
                ))
            }
            return fun(): Any? {
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_mc_active_animation = resolveEasyComponent("mc-active-animation", GenComponentsMcActiveAnimationIndexClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_mc_base_container, _uM("title" to "设置"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(menuList, fun(menu, index, __index, _cached): Any {
                                return _cE(Fragment, _uM("key" to menu.title), _uA(
                                    if (isTrue(!menu.isHide ?: true)) {
                                        _cV(_component_mc_active_animation, _uM("key" to 0), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cV(_component_x_sheet, _uM("margin" to _uA(
                                                    "15",
                                                    "15",
                                                    "15",
                                                    if (index == menuList.length - 1) {
                                                        "15"
                                                    } else {
                                                        "0"
                                                    }
                                                ), "padding" to _uA(
                                                    "20"
                                                ), "onClick" to menu.click), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cE("view", _uM("class" to "setting-item"), _uA(
                                                            _cE("text", _uM("class" to "name"), _tD(menu.title), 1),
                                                            _cE("view", _uM("class" to "flex-row"), _uA(
                                                                if (menu.value != null) {
                                                                    _cE("text", _uM("key" to 0, "class" to "value"), _tD(menu.value), 1)
                                                                } else {
                                                                    _cC("v-if", true)
                                                                },
                                                                if (isTrue(menu.showArrow)) {
                                                                    _cE("image", _uM("key" to 1, "class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 8, _uA(
                                                                        "src"
                                                                    ))
                                                                } else {
                                                                    _cC("v-if", true)
                                                                }
                                                            ))
                                                        ))
                                                    )
                                                }), "_" to 2), 1032, _uA(
                                                    "margin",
                                                    "onClick"
                                                ))
                                            )
                                        }), "_" to 2), 1024)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ), 64)
                            }
                            ), 64)
                        )
                    }
                    ), "_" to 1)),
                    if (isTrue(unref(globalData).isLogin)) {
                        _cE("view", _uM("key" to 0, "class" to "bottom-panel flex-row"), _uA(
                            _cV(_component_mc_primary_button, _uM("height" to "100rpx", "onClick" to handleLogout), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    "退出登录"
                                )
                            }), "_" to 1))
                        ))
                    } else {
                        _cC("v-if", true)
                    }
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
                return _uM("setting-item" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "name" to _uM(".setting-item " to _uM("fontSize" to 17)), "icon" to _uM(".setting-item " to _uM("width" to "17rpx", "height" to "28rpx", "marginLeft" to "20rpx")), "bottom-panel" to _pS(_uM("position" to "fixed", "bottom" to 0, "left" to 0, "width" to "100%", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "60rpx", "paddingLeft" to "20rpx", "boxShadow" to "0 -2px 10px rgba(0, 0, 0, 0.1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
