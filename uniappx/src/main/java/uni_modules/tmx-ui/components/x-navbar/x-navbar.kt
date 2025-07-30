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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.reLaunch as uni_reLaunch
open class GenUniModulesTmxUiComponentsXNavbarXNavbar : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var isPlace: Boolean by `$props`
    open var bgColor: String by `$props`
    open var darkBgColor: String by `$props`
    open var activeBgColor: String by `$props`
    open var backColor: String by `$props`
    open var title: String by `$props`
    open var titleColor: String by `$props`
    open var titleActiveColor: String by `$props`
    open var titleFontSize: String by `$props`
    open var lrWidth: String by `$props`
    open var llWidth: String by `$props`
    open var zIndex: Number by `$props`
    open var backErrorPath: String by `$props`
    open var showNavBack: Boolean by `$props`
    open var linearGradient: UTSArray<String> by `$props`
    open var linearActiveGradient: UTSArray<String> by `$props`
    open var staticTransparent: Boolean by `$props`
    open var maxWidth: String by `$props`
    open var height: Number by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsXNavbarXNavbar) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsXNavbarXNavbar
            val _cache = __ins.renderCache
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val statusBarHeight = ref(44)
            val navbarHeight = computed(fun(): Number {
                return props.height
            }
            )
            val isFiexd = ref(false)
            val fiexRatio = ref(1)
            val _stop = ref(0)
            val _linearGradient = computed(fun(): String {
                if (props.linearGradient.length < 3) {
                    return ""
                }
                var str = props.linearGradient.join(",")
                return "linear-gradient(" + str + ")"
            }
            )
            val _linearActiveGradient = computed(fun(): String {
                if (props.linearActiveGradient.length < 3) {
                    return ""
                }
                var str = props.linearActiveGradient.join(",")
                return "linear-gradient(" + str + ")"
            }
            )
            val _lrWidth = computed(fun(): String {
                return checkIsCssUnit(props.lrWidth, xConfig.unit)
            }
            )
            val _llWidth = computed(fun(): String {
                return checkIsCssUnit(props.llWidth, xConfig.unit)
            }
            )
            val _titleFontSize = computed(fun(): String {
                return checkIsCssUnit(props.titleFontSize, xConfig.unit)
            }
            )
            val _bgColor = computed(fun(): String {
                var bgcolor = props.bgColor
                if (xConfig.dark == "dark") {
                    bgcolor = if (props.darkBgColor == "") {
                        "#000000"
                    } else {
                        props.darkBgColor
                    }
                }
                return getDefaultColor(bgcolor)
            }
            )
            val _maxWidth = computed(fun(): String {
                var w = "none"
                if (props.maxWidth != "" && props.maxWidth == "none") {
                    w = props.maxWidth
                }
                w = "none"
                return if (w == "none") {
                    w
                } else {
                    checkIsCssUnit(props.maxWidth, xConfig.unit)
                }
            }
            )
            val _activeBgColor = computed(fun(): String {
                var color = _bgColor.value
                if (props.activeBgColor != "") {
                    color = getDefaultColor(props.activeBgColor)
                }
                var isba = isBlackAndWhite(props.titleActiveColor)
                if (isba) {
                    if (xConfig.dark == "dark") {
                        color = setBgColorLightByDark(color)
                    }
                }
                return color
            }
            )
            val _titleColor = computed(fun(): String {
                if (xConfig.dark == "dark") {
                    return "#ffffff"
                }
                return getDefaultColor(props.titleColor)
            }
            )
            val _backColor = computed(fun(): String {
                if (props.backColor != "") {
                    return getDefaultColor(props.backColor)
                }
                return _titleColor.value
            }
            )
            val _titleActiveColor = computed(fun(): String {
                var isba = isBlackAndWhite(props.titleActiveColor)
                if (isba) {
                    if (xConfig.dark == "dark") {
                        return "#ffffff"
                    }
                }
                return getDefaultColor(props.titleActiveColor)
            }
            )
            val _title = computed(fun(): String {
                return props.title
            }
            )
            val _styleMap = computed(fun(): Map<String, String> {
                var maps = Map<String, String>()
                if (props.staticTransparent) {
                    maps.set("opacity", fiexRatio.value.toString(10))
                } else {
                    maps.set("opacity", "1")
                }
                maps.set("height", (statusBarHeight.value + navbarHeight.value) + "px")
                if (isFiexd.value) {
                    if (_linearActiveGradient.value != "") {
                        maps.set("background-image", _linearActiveGradient.value)
                    } else if (_activeBgColor.value != "") {
                        maps.set("background-color", _activeBgColor.value)
                    } else {
                        maps.set("background-color", _bgColor.value)
                    }
                } else {
                    if (_linearGradient.value != "") {
                        maps.set("background-image", _linearGradient.value)
                    } else {
                        maps.set("background-color", _bgColor.value)
                    }
                }
                return maps
            }
            )
            onMounted(fun(){
                var sys = uni_getWindowInfo()
                statusBarHeight.value = sys.statusBarHeight
                emits("init", statusBarHeight.value + navbarHeight.value)
                if (props.staticTransparent) {
                    fiexRatio.value = 0
                }
            }
            )
            onPageScroll(fun(evt: OnPageScrollOptions){
                _stop.value = evt.scrollTop
            }
            )
            watchEffect(fun(){
                var barheight = statusBarHeight.value + navbarHeight.value
                isFiexd.value = _stop.value > 0
                if (props.staticTransparent) {
                    fiexRatio.value = Math.max(Math.min(_stop.value / barheight, 1), 0)
                }
                emits("fiexdChange", fiexRatio.value)
            }
            )
            val backGo = fun(){
                uni_navigateBack(NavigateBackOptions(fail = fun(_) {
                    uni_reLaunch(ReLaunchOptions(url = props.backErrorPath))
                }
                ))
            }
            return fun(): Any? {
                val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
                return createElementVNode("view", null, utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "xNavbar", "style" to normalizeStyle(utsMapOf("zIndex" to _ctx.zIndex, "maxWidth" to unref(_maxWidth)))), utsArrayOf(
                        createElementVNode("view", utsMapOf("key" to unref(_linearActiveGradient), "style" to normalizeStyle(unref(_styleMap)), "class" to "xNavbarBg"), null, 4),
                        createElementVNode("view", utsMapOf("class" to "xNavbarContentBox"), utsArrayOf(
                            createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("height" to (unref(statusBarHeight) + "px")))), null, 4),
                            createElementVNode("view", utsMapOf("class" to "xNavbarContent", "style" to normalizeStyle(utsMapOf("height" to (unref(navbarHeight) + "px")))), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "xNavBarLeft", "style" to normalizeStyle(utsMapOf("width" to unref(_llWidth)))), utsArrayOf(
                                    if (isTrue(_ctx.showNavBack)) {
                                        createElementVNode("view", utsMapOf("key" to 0, "onClick" to backGo, "class" to "xNavBarBack", "style" to normalizeStyle(utsMapOf("paddingLeft" to "16px"))), utsArrayOf(
                                            createVNode(_component_x_icon, utsMapOf("font-size" to "26", "name" to "arrow-left-s-line", "color" to if (unref(isFiexd)) {
                                                unref(_titleActiveColor)
                                            } else {
                                                unref(_backColor)
                                            }), null, 8, utsArrayOf(
                                                "color"
                                            ))
                                        ), 4)
                                    } else {
                                        createCommentVNode("v-if", true)
                                    }
                                    ,
                                    renderSlot(_ctx.`$slots`, "left", utsMapOf("isFiexd" to unref(isFiexd)))
                                ), 4),
                                createElementVNode("view", utsMapOf("class" to "xNavBarTtitle"), utsArrayOf(
                                    renderSlot(_ctx.`$slots`, "title", utsMapOf("isFiexd" to unref(isFiexd)), fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "xNvbarTtitleOverls", "style" to normalizeStyle(utsMapOf("fontSize" to unref(_titleFontSize), "fontWeight" to "bold", "color" to if (unref(isFiexd)) {
                                                unref(_titleActiveColor)
                                            } else {
                                                unref(_titleColor)
                                            }
                                            ))), toDisplayString(unref(_title)), 5)
                                        )
                                    }
                                    )
                                )),
                                createElementVNode("view", utsMapOf("class" to "xNavBarRight", "style" to normalizeStyle(utsMapOf("width" to unref(_lrWidth)))), utsArrayOf(
                                    renderSlot(_ctx.`$slots`, "right", utsMapOf("isFiexd" to unref(isFiexd)))
                                ), 4)
                            ), 4)
                        ))
                    ), 4),
                    if (isTrue(_ctx.isPlace)) {
                        createElementVNode("view", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("height" to ((unref(statusBarHeight) + unref(navbarHeight)) + "px")))), null, 4)
                    } else {
                        createCommentVNode("v-if", true)
                    }
                ))
            }
        }
        var name = "xNavbar"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xNvbarTtitleOverls" to padStyleMapOf(utsMapOf("lines" to 1, "textOverflow" to "ellipsis", "textAlign" to "center")), "xNavbarContentBox" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%")), "xNavBarBack" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center")), "xNavbar" to padStyleMapOf(utsMapOf("position" to "fixed", "width" to "100%")), "xNavbarContent" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "xNavBarLeft" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center")), "xNavBarRight" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end", "alignItems" to "center")), "xNavBarTtitle" to padStyleMapOf(utsMapOf("flex" to 1, "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "height" to "100%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("fiexdChange" to null, "init" to null)
        var props = normalizePropsOptions(utsMapOf("isPlace" to utsMapOf("type" to "Boolean", "default" to true), "bgColor" to utsMapOf("type" to "String", "default" to "white"), "darkBgColor" to utsMapOf("type" to "String", "default" to "#000000"), "activeBgColor" to utsMapOf("type" to "String", "default" to ""), "backColor" to utsMapOf("type" to "String", "default" to ""), "title" to utsMapOf("type" to "String", "default" to "标题"), "titleColor" to utsMapOf("type" to "String", "default" to "#333333"), "titleActiveColor" to utsMapOf("type" to "String", "default" to "#333333"), "titleFontSize" to utsMapOf("type" to "String", "default" to "17"), "lrWidth" to utsMapOf("type" to "String", "default" to "100"), "llWidth" to utsMapOf("type" to "String", "default" to "100"), "zIndex" to utsMapOf("type" to "Number", "default" to 90), "backErrorPath" to utsMapOf("type" to "String", "default" to "/pages/index/index"), "showNavBack" to utsMapOf("type" to "Boolean", "default" to true), "linearGradient" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "linearActiveGradient" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "staticTransparent" to utsMapOf("type" to "Boolean", "default" to false), "maxWidth" to utsMapOf("type" to "String", "default" to "none"), "height" to utsMapOf("type" to "Number", "default" to 50)))
        var propsNeedCastKeys = utsArrayOf(
            "isPlace",
            "bgColor",
            "darkBgColor",
            "activeBgColor",
            "backColor",
            "title",
            "titleColor",
            "titleActiveColor",
            "titleFontSize",
            "lrWidth",
            "llWidth",
            "zIndex",
            "backErrorPath",
            "showNavBack",
            "linearGradient",
            "linearActiveGradient",
            "staticTransparent",
            "maxWidth",
            "height"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
