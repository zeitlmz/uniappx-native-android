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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
open class GenComponentsMcBaseContainerIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var direction: String by `$props`
    open var bgColor: String by `$props`
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
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsMcBaseContainerIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsMcBaseContainerIndex
            val _cache = __ins.renderCache
            return fun(): Any? {
                val _component_x_navbar = resolveEasyComponent("x-navbar", GenUniModulesTmxUiComponentsXNavbarXNavbarClass)
                val _component_mc_env_tag = resolveEasyComponent("mc-env-tag", GenComponentsMcEnvTagIndexClass)
                return createElementVNode(Fragment, null, utsArrayOf(
                    if (isTrue(_ctx.showNavbar)) {
                        createVNode(_component_x_navbar, utsMapOf("key" to 0, "title" to _ctx.title, "title-color" to _ctx.titleColor, "title-font-size" to "18", "isPlace" to _ctx.navbarIsPlace, "height" to _ctx.navbarHeight, "showNavBack" to _ctx.showNavBack, "linear-gradient" to _ctx.linearGradient, "linear-active-gradient" to _ctx.linearActiveGradient, "staticTransparent" to _ctx.staticTransparent), utsMapOf("left" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                renderSlot(_ctx.`$slots`, "navbar-left")
                            )
                        }), "title" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                renderSlot(_ctx.`$slots`, "navbar-title")
                            )
                        }), "right" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                renderSlot(_ctx.`$slots`, "navbar-right")
                            )
                        }), "_" to 3), 8, utsArrayOf(
                            "title",
                            "title-color",
                            "isPlace",
                            "height",
                            "showNavBack",
                            "linear-gradient",
                            "linear-active-gradient",
                            "staticTransparent"
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    }
                    ,
                    createElementVNode("scroll-view", utsMapOf("direction" to if (_ctx.scroll) {
                        _ctx.direction
                    } else {
                        "none"
                    }
                    , "bounces" to false, "style" to normalizeStyle("" + (if (_ctx.bgColor != "") {
                        "background-color: " + _ctx.bgColor + ";"
                    } else {
                        ""
                    }
                    ) + ";width:100%;height: " + unref(screenHeight) + "px;}"), "show-scrollbar" to false), utsArrayOf(
                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsArrayOf(
                            utsMapOf("width" to "100%"),
                            "" + unref(screenHeight) + "px;"
                        ))), utsArrayOf(
                            renderSlot(_ctx.`$slots`, "default")
                        ), 4)
                    ), 12, utsArrayOf(
                        "direction"
                    )),
                    createVNode(_component_mc_env_tag)
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("location" to null)
        var props = normalizePropsOptions(utsMapOf("direction" to utsMapOf("type" to "String", "default" to "vertical"), "bgColor" to utsMapOf("type" to "String", "default" to "#edf1f8"), "showStatusBarPlaceholder" to utsMapOf("type" to "Boolean", "default" to false), "staticTransparent" to utsMapOf("type" to "Boolean", "default" to false), "scroll" to utsMapOf("type" to "Boolean", "default" to true), "navbarIsPlace" to utsMapOf("type" to "Boolean", "default" to true), "height" to utsMapOf("type" to "String", "default" to "100%"), "showNavbar" to utsMapOf("type" to "Boolean", "default" to true), "title" to utsMapOf("type" to "String", "default" to ""), "titleColor" to utsMapOf("type" to "String", "default" to "#000000"), "showNavBack" to utsMapOf("type" to "Boolean", "default" to true), "navbarHeight" to utsMapOf("type" to "Number", "default" to 50), "linearGradient" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "linearActiveGradient" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        )))
        var propsNeedCastKeys = utsArrayOf(
            "direction",
            "bgColor",
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
            "linearActiveGradient"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
