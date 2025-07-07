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
import uts.sdk.modules.mcPermissionRequest.checkGrantedCamera
import uts.sdk.modules.mcPermissionRequest.checkGrantedLocation
import uts.sdk.modules.mcPermissionRequest.checkGrantedPhoto
import uts.sdk.modules.mcPermissionRequest.checkGrantedNotice
import io.dcloud.uniapp.extapi.openAppAuthorizeSetting as uni_openAppAuthorizeSetting
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalSettingGrantManageIndex : BasePage {
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
            val menuList = ref(utsArrayOf<MenuItem1>())
            onPageShow(fun(){
                menuList.value = utsArrayOf<MenuItem1>(MenuItem1(title = "通知", desc = "用于新增订单、取消订单消息通知提醒。", granted = checkGrantedNotice(), click = fun(){
                    openSystemSettings()
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
                return createVNode(_component_mc_base_container, utsMapOf("title" to "权限管理"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode(Fragment, null, RenderHelpers.renderList(unref(menuList), fun(menu, index, __index, _cached): Any {
                            return createVNode(_component_mc_active_animation, utsMapOf("key" to menu.title), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                                        "15",
                                        if (index > 0) {
                                            "0"
                                        } else {
                                            "15"
                                        }
                                        ,
                                        "15",
                                        "15"
                                    ), "padding" to utsArrayOf(
                                        "15"
                                    ), "onClick" to menu.click), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "setting-item"), utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "left-box", "style" to normalizeStyle(utsMapOf("width" to ("" + (unref(screenWidth) - 150) + "px")))), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "name"), toDisplayString(menu.title), 1),
                                                    createElementVNode("text", utsMapOf("class" to "desc"), toDisplayString(menu.desc), 1)
                                                ), 4),
                                                createElementVNode("view", utsMapOf("class" to "right-box flex-row"), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(if (menu.granted) {
                                                        "已授权"
                                                    } else {
                                                        "去设置"
                                                    }
                                                    ), 1),
                                                    createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                ))
                                            ))
                                        )
                                    }
                                    ), "_" to 2), 1032, utsArrayOf(
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
            normalizeCssStyles(utsArrayOf(
                styles0
            ), utsArrayOf(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("setting-item" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "gap" to "20rpx")), "name" to utsMapOf(".setting-item .left-box " to utsMapOf("fontSize" to "30rpx")), "desc" to utsMapOf(".setting-item .left-box " to utsMapOf("fontSize" to "26rpx", "color" to "#999999")), "right-box" to utsMapOf(".setting-item " to utsMapOf("flexShrink" to 0)), "value" to utsMapOf(".setting-item .right-box " to utsMapOf("fontSize" to "26rpx", "color" to "#646464")), "icon" to utsMapOf(".setting-item " to utsMapOf("width" to "17rpx", "height" to "28rpx", "marginLeft" to "20rpx")), "bottom-panel" to padStyleMapOf(utsMapOf("position" to "fixed", "bottom" to 0, "left" to 0, "width" to "100%", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "60rpx", "paddingLeft" to "20rpx", "boxShadow" to "0 -2px 10px rgba(0, 0, 0, 0.1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
