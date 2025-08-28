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
open class GenPagesPersonalSettingContactUsIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalSettingContactUsIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalSettingContactUsIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            return fun(): Any? {
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return _cV(_component_mc_base_container, _uM("title" to "联系我们"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_x_sheet, _uM("margin" to _uA(
                            "15"
                        ), "padding" to _uA(
                            "30rpx",
                            "10rpx",
                            "30rpx",
                            "20rpx"
                        )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "desc-item"), _uA(
                                    _cE("text", _uM("class" to "label"), "客服电话"),
                                    _cE("text", _uM("class" to "text"), "0351-6329000")
                                )),
                                _cE("view", _uM("class" to "desc-item"), _uA(
                                    _cE("text", _uM("class" to "label"), "网址"),
                                    _cE("text", _uM("class" to "text"), "https://www.mctwlx.com")
                                )),
                                _cE("view", _uM("class" to "desc-item"), _uA(
                                    _cE("text", _uM("class" to "label"), "企业微信"),
                                    _cE("text", _uM("class" to "text"), "15513610262")
                                )),
                                _cE("view", _uM("class" to "desc-item", "style" to _nS(_uM("border" to "none"))), _uA(
                                    _cE("text", _uM("class" to "label"), "联系地址"),
                                    _cE("text", _uM("class" to "text"), "山西省太原市万柏林区柏林国际商务中心15-20层")
                                ), 4)
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
                return _uM("desc-item" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to "30rpx", "paddingRight" to 0, "paddingBottom" to "30rpx", "paddingLeft" to 0, "borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#D4D4D4", "boxSizing" to "border-box")), "text" to _uM(".desc-item " to _uM("textAlign" to "right", "width" to "70%", "fontSize" to "30rpx", "color" to "#000000")), "label" to _uM(".desc-item " to _uM("fontSize" to "30rpx", "color" to "#000000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
