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
import uts.sdk.modules.mcPermissionRequest.checkDrawOverlays
import uts.sdk.modules.mcPermissionRequest.checkGrantedNotice
import uts.sdk.modules.mcPermissionRequest.openBatteryPage
import uts.sdk.modules.mcPermissionRequest.openNotificationSetting
import uts.sdk.modules.mcPermissionRequest.requestDrawOverlaysPermission
import uts.sdk.modules.mcPermissionRequest.checkGrantedCamera
import uts.sdk.modules.mcPermissionRequest.checkGrantedLocation
import uts.sdk.modules.mcPermissionRequest.checkGrantedPhoto
import io.dcloud.uniapp.extapi.openAppAuthorizeSetting as uni_openAppAuthorizeSetting
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalSettingGrantManageIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalSettingGrantManageIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalSettingGrantManageIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val router = uni_useKuxRouter()
            val showRouteLove = ref(false)
            val openSystemSettings = fun(){
                uni_openAppAuthorizeSetting(OpenAppAuthorizeSettingOptions(success = fun(res) {
                    console.log("openSystemSettings=", res)
                }
                ))
            }
            val menuList = ref(_uA<MenuItem1>())
            onPageShow(fun(){
                menuList.value = _uA<MenuItem1>(MenuItem1(title = "电池优化", desc = "用于降低App后台接单时被杀进程的几率。", granted = false, click = fun(){
                    openBatteryPage()
                }
                ), MenuItem1(title = "悬浮窗", desc = "用于App后台接单时显示小悬浮窗口。", granted = checkDrawOverlays(), click = fun(){
                    requestDrawOverlaysPermission()
                }
                ), MenuItem1(title = "通知", desc = "用于新增订单、取消订单消息通知提醒。", granted = checkGrantedNotice(), click = fun(){
                    openNotificationSetting()
                }
                ), MenuItem1(title = "相册", desc = "用于选取上传入驻资料，如身份证、驾驶、营运资质等。", granted = checkGrantedPhoto(), click = fun(){
                    openSystemSettings()
                }
                ), MenuItem1(title = "相机", desc = "用于拍摄上传入驻资料，如身份证、驾驶、营运资质等。", granted = checkGrantedCamera(), click = fun(){
                    openSystemSettings()
                }
                ), MenuItem1(title = "定位", desc = "用于匹配附近订单、路线规划、导航等", granted = checkGrantedLocation(), click = fun(){
                    openSystemSettings()
                }
                ))
            }
            )
            return fun(): Any? {
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_mc_active_animation = resolveEasyComponent("mc-active-animation", GenComponentsMcActiveAnimationIndexClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return _cV(_component_mc_base_container, _uM("title" to "权限管理"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
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
                                        "15"
                                    ), "onClick" to menu.click), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "setting-item"), _uA(
                                                _cE("view", _uM("class" to "left-box", "style" to _nS(_uM("width" to ("" + (unref(screenWidth) - 150) + "px")))), _uA(
                                                    _cE("text", _uM("class" to "name"), _tD(menu.title), 1),
                                                    _cE("text", _uM("class" to "desc"), _tD(menu.desc), 1)
                                                ), 4),
                                                _cE("view", _uM("class" to "right-box flex-row"), _uA(
                                                    _cE("text", _uM("class" to "value"), _tD(if (menu.granted) {
                                                        "已授权"
                                                    } else {
                                                        "去设置"
                                                    }
                                                    ), 1),
                                                    _cE("image", _uM("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    ))
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
                return _uM("setting-item" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "gap" to "20rpx")), "name" to _uM(".setting-item .left-box " to _uM("fontSize" to "30rpx")), "desc" to _uM(".setting-item .left-box " to _uM("fontSize" to "26rpx", "color" to "#999999")), "right-box" to _uM(".setting-item " to _uM("flexShrink" to 0)), "value" to _uM(".setting-item .right-box " to _uM("fontSize" to "26rpx", "color" to "#646464")), "icon" to _uM(".setting-item " to _uM("width" to "17rpx", "height" to "28rpx", "marginLeft" to "20rpx")), "bottom-panel" to _pS(_uM("position" to "fixed", "bottom" to 0, "left" to 0, "width" to "100%", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "60rpx", "paddingLeft" to "20rpx", "boxShadow" to "0 -2px 10px rgba(0, 0, 0, 0.1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
