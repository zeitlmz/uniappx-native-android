@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI09580B7
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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
open class GenPagesOtherWebViewIndex : BasePage {
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
        var setup: (__props: GenPagesOtherWebViewIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherWebViewIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val title = ref("内容")
            val src = ref("")
            val contentHeight = ref(screenHeight)
            val computeContentHeightCus = fun(){
                val webviewElement = uni_getElementById("cus-web-view") as UniWebViewElement
                console.log("webviewElement.scrollHeight=", webviewElement.scrollHeight)
                console.log("webviewElement.offsetHeight=", webviewElement.offsetHeight)
                console.log("contentHeight", screenHeight)
                contentHeight.value = screenHeight - statusBarHeight - 100
            }
            onLoad(fun(options){
                if (options != null) {
                    val opt = JSON.parse(JSON.stringify(options)) as UTSJSONObject
                    console.log("opt=", opt)
                    title.value = opt.getString("title") ?: ""
                    src.value = opt.getString("src") ?: ""
                    setTimeout(fun(){
                        computeContentHeightCus()
                    }
                    , 200)
                }
            }
            )
            return fun(): Any? {
                val _component_x_navbar = resolveEasyComponent("x-navbar", GenUniModulesTmxUiComponentsXNavbarXNavbarClass)
                return createElementVNode(Fragment, null, utsArrayOf(
                    createVNode(_component_x_navbar, utsMapOf("title" to unref(title), "title-color" to "#000000", "title-font-size" to "18", "isPlace" to true, "height" to 50, "showNavBack" to true), utsMapOf("left" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            renderSlot(_ctx.`$slots`, "navbar-left")
                        )
                    }
                    ), "title" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            renderSlot(_ctx.`$slots`, "navbar-title")
                        )
                    }
                    ), "_" to 3), 8, utsArrayOf(
                        "title"
                    )),
                    createElementVNode("web-view", utsMapOf("id" to "cus-web-view", "src" to unref(src), "verticalScrollBarAccess" to true, "style" to normalizeStyle("height: " + unref(contentHeight) + "px;")), null, 12, utsArrayOf(
                        "src"
                    ))
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(), utsArrayOf(
                GenApp.styles
            ))
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
