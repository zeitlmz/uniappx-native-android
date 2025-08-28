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
open class GenPagesOtherLineManageAddLineIndex : BasePage {
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
        var setup: (__props: GenPagesOtherLineManageAddLineIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherLineManageAddLineIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            return fun(): Any? {
                val _component_x_checkbox = resolveEasyComponent("x-checkbox", GenUniModulesTmxUiComponentsXCheckboxXCheckboxClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_collapse_item = resolveEasyComponent("x-collapse-item", GenUniModulesTmxUiComponentsXCollapseItemXCollapseItemClass)
                val _component_x_collapse = resolveEasyComponent("x-collapse", GenUniModulesTmxUiComponentsXCollapseXCollapseClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return _cV(_component_mc_base_container, _uM("title" to "添加线路"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE(Fragment, null, RenderHelpers.renderList((9 as Number), fun(item, index, __index, _cached): Any {
                            return _cV(_component_x_sheet, _uM("padding" to _uA(
                                "0"
                            ), "margin" to _uA(
                                "15",
                                if (index == 0) {
                                    "15"
                                } else {
                                    "0"
                                }
                                ,
                                "15",
                                "15"
                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_x_collapse, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_x_collapse_item, _uM("showBottomLine" to false, "name" to "1", "title" to "太原市-太原市"), _uM("left" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_x_checkbox, _uM("size" to "18"))
                                                )
                                            }
                                            ), "default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_x_sheet, _uM("margin" to _uA(
                                                        "0"
                                                    ), "class" to "flex-row flex-row-center-between", "color" to "#EAF2FD"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _cE("view", _uM("class" to "left-box flex-row flex-row-center-between"), _uA(
                                                                _cV(_component_x_checkbox, _uM("size" to "18")),
                                                                _cE("text", null, "小店区-太原市")
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
                                )
                            }
                            ), "_" to 2), 1032, _uA(
                                "margin"
                            ))
                        }
                        ), 64),
                        _cE("view", _uM("style" to _nS("width:100%;height: " + (unref(globalData).safeAreaBottom + 55) + "px;")), null, 4)
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
                return _uM("left-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "icon" to _uM(".left-box " to _uM("width" to 12, "height" to 14), ".right-box " to _uM("width" to 6, "height" to 12, "marginLeft" to "10rpx")), "btn-group-panel" to _pS(_uM("position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
