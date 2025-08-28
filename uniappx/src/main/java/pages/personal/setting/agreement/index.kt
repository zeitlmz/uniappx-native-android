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
open class GenPagesPersonalSettingAgreementIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalSettingAgreementIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalSettingAgreementIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val router = uni_useKuxRouter()
            val showRouteLove = ref(false)
            val agreementDetail = fun(agreementType: Number){
                router.push("/pages/personal/setting/agreement/detail/index?agreementType=" + agreementType)
            }
            val menuList = _uA<MenuItem2>(MenuItem2(title = "软件使用协议", showArrow = true, click = fun(){
                agreementDetail(1)
            }
            ), MenuItem2(title = "用户服务协议", showArrow = true, click = fun(){
                agreementDetail(2)
            }
            ), MenuItem2(title = "录音录像信息处理协议", showArrow = true, click = fun(){
                agreementDetail(3)
            }
            ), MenuItem2(title = "个人信息处理规则(隐私协议)", showArrow = true, click = fun(){
                agreementDetail(4)
            }
            ), MenuItem2(title = "收集信息第三方SDK清单", showArrow = true, click = fun(){
                agreementDetail(5)
            }
            ), MenuItem2(title = "Android系统权限调用", showArrow = true, click = fun(){
                agreementDetail(7)
            }
            ))
            return fun(): Any? {
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_mc_active_animation = resolveEasyComponent("mc-active-animation", GenComponentsMcActiveAnimationIndexClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return _cV(_component_mc_base_container, _uM("title" to "协议管理"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(menuList, fun(menu, index, __index, _cached): Any {
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
                                                _cE("text", _uM("class" to "name"), _tD(menu.title), 1),
                                                _cE("view", _uM("class" to "flex-row"), _uA(
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
                        ), 64)
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
