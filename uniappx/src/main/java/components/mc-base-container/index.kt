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
open class GenComponentsMcBaseContainerIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var direction: String by `$props`
    open var bgColor: String by `$props`
    open var showOrderNotice: Boolean by `$props`
    open var showStatusBarPlaceholder: Boolean by `$props`
    open var staticTransparent: Boolean by `$props`
    open var scroll: Boolean by `$props`
    open var navbarIsPlace: Boolean by `$props`
    open var height: String by `$props`
    open var showNavbar: Boolean by `$props`
    open var title: String by `$props`
    open var titleColor: String by `$props`
    open var showNavBack: Boolean by `$props`
    open var navbarHeight: Number by `$props`
    open var linearGradient: UTSArray<String> by `$props`
    open var linearActiveGradient: UTSArray<String> by `$props`
    open var lrWidth: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsMcBaseContainerIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsMcBaseContainerIndex
            val _cache = __ins.renderCache
            return fun(): Any? {
                val _component_x_navbar = resolveEasyComponent("x-navbar", GenUniModulesTmxUiComponentsXNavbarXNavbarClass)
                val _component_mc_order_notice = resolveEasyComponent("mc-order-notice", GenComponentsMcOrderNoticeIndexClass)
                val _component_mc_env_tag = resolveEasyComponent("mc-env-tag", GenComponentsMcEnvTagIndexClass)
                return _cE(Fragment, null, _uA(
                    if (isTrue(_ctx.showNavbar)) {
                        _cV(_component_x_navbar, _uM("key" to 0, "title" to _ctx.title, "title-color" to _ctx.titleColor, "title-font-size" to "18", "isPlace" to _ctx.navbarIsPlace, "height" to _ctx.navbarHeight, "showNavBack" to _ctx.showNavBack, "linear-gradient" to _ctx.linearGradient, "lrWidth" to _ctx.lrWidth, "linear-active-gradient" to _ctx.linearActiveGradient, "staticTransparent" to _ctx.staticTransparent), _uM("left" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                renderSlot(_ctx.`$slots`, "navbar-left")
                            )
                        }), "title" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                renderSlot(_ctx.`$slots`, "navbar-title")
                            )
                        }), "right" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                renderSlot(_ctx.`$slots`, "navbar-right")
                            )
                        }), "_" to 3), 8, _uA(
                            "title",
                            "title-color",
                            "isPlace",
                            "height",
                            "showNavBack",
                            "linear-gradient",
                            "lrWidth",
                            "linear-active-gradient",
                            "staticTransparent"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    if (isTrue(_ctx.showOrderNotice)) {
                        _cV(_component_mc_order_notice, _uM("key" to 1))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("scroll-view", _uM("direction" to if (_ctx.scroll) {
                        _ctx.direction
                    } else {
                        "none"
                    }
                    , "bounces" to false, "style" to _nS("" + (if (_ctx.bgColor != "") {
                        "background-color: " + _ctx.bgColor + ";"
                    } else {
                        ""
                    }
                    ) + ";width:100%;height: " + unref(screenHeight) + "px;}"), "show-scrollbar" to false), _uA(
                        _cE("view", _uM("style" to _nS(_uA(
                            _uM("width" to "100%"),
                            "" + unref(screenHeight) + "px;"
                        ))), _uA(
                            renderSlot(_ctx.`$slots`, "default")
                        ), 4)
                    ), 12, _uA(
                        "direction"
                    )),
                    _cV(_component_mc_env_tag)
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("location" to null)
        var props = _nP(_uM("direction" to _uM("type" to "String", "default" to "vertical"), "bgColor" to _uM("type" to "String", "default" to "#edf1f8"), "showOrderNotice" to _uM("type" to "Boolean", "default" to true), "showStatusBarPlaceholder" to _uM("type" to "Boolean", "default" to false), "staticTransparent" to _uM("type" to "Boolean", "default" to false), "scroll" to _uM("type" to "Boolean", "default" to true), "navbarIsPlace" to _uM("type" to "Boolean", "default" to true), "height" to _uM("type" to "String", "default" to "100%"), "showNavbar" to _uM("type" to "Boolean", "default" to true), "title" to _uM("type" to "String", "default" to ""), "titleColor" to _uM("type" to "String", "default" to "#000000"), "showNavBack" to _uM("type" to "Boolean", "default" to true), "navbarHeight" to _uM("type" to "Number", "default" to 50), "linearGradient" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "linearActiveGradient" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "lrWidth" to _uM("type" to "String", "default" to "100")))
        var propsNeedCastKeys = _uA(
            "direction",
            "bgColor",
            "showOrderNotice",
            "showStatusBarPlaceholder",
            "staticTransparent",
            "scroll",
            "navbarIsPlace",
            "height",
            "showNavbar",
            "title",
            "titleColor",
            "showNavBack",
            "navbarHeight",
            "linearGradient",
            "linearActiveGradient",
            "lrWidth"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
