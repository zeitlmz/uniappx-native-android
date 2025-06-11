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
open class GenPagesPersonalSettingAboutUsIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalSettingAboutUsIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalSettingAboutUsIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            return fun(): Any? {
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createVNode(_component_mc_base_container, utsMapOf("title" to "关于我们"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "logo-box"), utsArrayOf(
                            createElementVNode("image", utsMapOf("class" to "icon", "src" to "/static/logo.png", "mode" to "widthFix")),
                            createElementVNode("text", utsMapOf("class" to "version"), "V" + toDisplayString(unref(appVersion)), 1)
                        )),
                        createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                            "15"
                        ), "padding" to utsArrayOf(
                            "20"
                        )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "desc"), "每橙车主定位于汽车消费生态服务产业解决方案，以自研的“每橙车主”出行平台为支撑，通过网约车、定制客运和旅游专车三大主营业务板块，构建汽车后市场和客运服务相融合的多维数字消费生态。"),
                                createElementVNode("view", utsMapOf("class" to "ercode-box"), utsArrayOf(
                                    createElementVNode("image", utsMapOf("class" to "ercode", "src" to ("" + unref(resBaseUrl) + "/static/images/image-wx-qrcode.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                        "src"
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "pl-20"), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "text"), "微信扫码关注“每橙公众号”"),
                                        createElementVNode("text", utsMapOf("class" to "text"), "第一时间接收各类福利通知")
                                    ))
                                ))
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
                return utsMapOf("logo-box" to padStyleMapOf(utsMapOf("flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "paddingTop" to "74rpx", "paddingBottom" to "20rpx")), "icon" to utsMapOf(".logo-box " to utsMapOf("width" to "186rpx", "height" to "187rpx")), "version" to utsMapOf(".logo-box " to utsMapOf("fontWeight" to "bold", "fontSize" to "42rpx", "color" to "#000000", "paddingTop" to "24rpx")), "desc" to padStyleMapOf(utsMapOf("borderBottomWidth" to 1, "borderBottomStyle" to "dashed", "borderBottomColor" to "#4B677D", "lineHeight" to "60rpx", "paddingBottom" to "30rpx", "fontSize" to "30rpx", "color" to "#000000")), "ercode-box" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "paddingTop" to "40rpx", "paddingBottom" to "200rpx")), "ercode" to utsMapOf(".ercode-box " to utsMapOf("width" to "160rpx", "height" to "160rpx")), "text" to utsMapOf(".ercode-box " to utsMapOf("fontSize" to "30rpx", "color" to "#000000", "lineHeight" to "60rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
