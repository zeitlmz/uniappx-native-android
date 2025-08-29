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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
open class GenPagesOtherWebViewIndex : BasePage {
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
                return _cE(Fragment, null, _uA(
                    _cV(_component_x_navbar, _uM("title" to unref(title), "title-color" to "#000000", "title-font-size" to "18", "isPlace" to true, "height" to 50, "showNavBack" to true), _uM("left" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            renderSlot(_ctx.`$slots`, "navbar-left")
                        )
                    }
                    ), "title" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            renderSlot(_ctx.`$slots`, "navbar-title")
                        )
                    }
                    ), "_" to 3), 8, _uA(
                        "title"
                    )),
                    _cE("web-view", _uM("id" to "cus-web-view", "src" to unref(src), "verticalScrollBarAccess" to true, "style" to _nS("height: " + unref(contentHeight) + "px;")), null, 12, _uA(
                        "src"
                    ))
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(), _uA(
                GenApp.styles
            ))
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
