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
open class GenPagesPersonalSettingAboutUsIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalSettingAboutUsIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalSettingAboutUsIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            return fun(): Any? {
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return _cV(_component_mc_base_container, _uM("title" to "关于我们"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "logo-box"), _uA(
                            _cE("image", _uM("class" to "icon", "src" to "/static/logo.png", "mode" to "widthFix")),
                            _cE("text", _uM("class" to "version"), "V" + _tD(unref(appVersion)), 1)
                        )),
                        _cV(_component_x_sheet, _uM("margin" to _uA(
                            "15"
                        ), "padding" to _uA(
                            "20"
                        )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("text", _uM("class" to "desc"), "每橙车主定位于汽车消费生态服务产业解决方案，以自研的“每橙车主”出行平台为支撑，通过网约车、定制客运和旅游专车三大主营业务板块，构建汽车后市场和客运服务相融合的多维数字消费生态。"),
                                _cE("view", _uM("class" to "ercode-box"), _uA(
                                    _cE("image", _uM("class" to "ercode", "src" to ("" + unref(resBaseUrl) + "/static/images/image-wx-qrcode.png"), "mode" to "widthFix"), null, 8, _uA(
                                        "src"
                                    )),
                                    _cE("view", _uM("class" to "pl-20"), _uA(
                                        _cE("text", _uM("class" to "text"), "微信扫码关注“每橙公众号”"),
                                        _cE("text", _uM("class" to "text"), "第一时间接收各类福利通知")
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
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("logo-box" to _pS(_uM("flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "paddingTop" to "74rpx", "paddingBottom" to "20rpx")), "icon" to _uM(".logo-box " to _uM("width" to "186rpx", "height" to "187rpx")), "version" to _uM(".logo-box " to _uM("fontWeight" to "bold", "fontSize" to "42rpx", "color" to "#000000", "paddingTop" to "24rpx")), "desc" to _pS(_uM("borderBottomWidth" to 1, "borderBottomStyle" to "dashed", "borderBottomColor" to "#4B677D", "lineHeight" to "60rpx", "paddingBottom" to "30rpx", "fontSize" to "30rpx", "color" to "#000000")), "ercode-box" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "paddingTop" to "40rpx", "paddingBottom" to "200rpx")), "ercode" to _uM(".ercode-box " to _uM("width" to "160rpx", "height" to "160rpx")), "text" to _uM(".ercode-box " to _uM("fontSize" to "30rpx", "color" to "#000000", "lineHeight" to "60rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
