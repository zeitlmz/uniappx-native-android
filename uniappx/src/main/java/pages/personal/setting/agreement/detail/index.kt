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
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalSettingAgreementDetailIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalSettingAgreementDetailIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalSettingAgreementDetailIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val router = uni_useKuxRouter()
            val contentHtml = ref<String>("")
            val hrefPath = ref("")
            val clickItem = fun(event: UniRichTextItemClickEvent){
                val src = (event.detail?.href ?: event.detail) as String
                if (src == null || src == "") {
                    return
                }
                hrefPath.value = src
                console.log("点击链接:", src)
                router.push("/pages/other/web-view/index?title=\u534F\u8BAE\u5185\u5BB9&src=" + encodeURIComponent(src))
            }
            fun gen_escapeHtml_fn(html: String): String {
                return html.replace(UTSRegExp("&lt;", "g"), "<").replace(UTSRegExp("&gt;", "g"), ">").replace(UTSRegExp("&quot;", "g"), "\"").replace(UTSRegExp("&#39;", "g"), "'").replace(UTSRegExp("&amp;", "g"), "&")
            }
            val escapeHtml = ::gen_escapeHtml_fn
            fun gen_removePreTags_fn(html: String): String {
                val preStartRegex = UTSRegExp("^\\s*<pre\\s+[^>]*class\\s*=\\s*[\"'][^\"']*[\"'][^>]*>\\s*", "im")
                val preEndRegex = UTSRegExp("\\s*<\\/pre>\\s*\$", "im")
                var result = html.replace(preStartRegex, "")
                result = result.replace(preEndRegex, "")
                return result
            }
            val removePreTags = ::gen_removePreTags_fn
            val agreementDetail = fun(agreementType: String){
                getLatestAgreementContent(agreementType).then(fun(res: Response){
                    if (res.code == 200) {
                        val content = res.data as String
                        contentHtml.value = escapeHtml(content)
                        contentHtml.value = removePreTags(contentHtml.value)
                    } else {
                        showTips(res.msg, "error")
                    }
                }
                )
            }
            onLoad(fun(options){
                if (options != null) {
                    val opt = JSON.parse(JSON.stringify(options)) as UTSJSONObject
                    console.log("opt=", opt)
                    val agreementType = opt.getString("agreementType") ?: ""
                    agreementDetail(agreementType)
                }
            }
            )
            return fun(): Any? {
                val _component_x_navbar = resolveEasyComponent("x-navbar", GenUniModulesTmxUiComponentsXNavbarXNavbarClass)
                return createElementVNode(Fragment, null, utsArrayOf(
                    createVNode(_component_x_navbar, utsMapOf("title" to "协议内容", "title-color" to "#000000", "title-font-size" to "18", "isPlace" to true, "height" to 50, "showNavBack" to true), utsMapOf("left" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            renderSlot(_ctx.`$slots`, "navbar-left")
                        )
                    }
                    ), "title" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            renderSlot(_ctx.`$slots`, "navbar-title")
                        )
                    }
                    ), "_" to 3)),
                    createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
                        createElementVNode("rich-text", utsMapOf("id" to "rich-text", "style" to normalizeStyle(utsMapOf("margin-bottom" to "50rpx", "padding" to "15")), "selectable" to true, "nodes" to unref(contentHtml), "onItemclick" to clickItem), null, 44, utsArrayOf(
                            "nodes"
                        ))
                    ), 4)
                ), 64)
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
                return utsMapOf("agreement-content" to padStyleMapOf(utsMapOf("flex" to 1, "height" to "100%", "paddingTop" to "30rpx", "paddingRight" to "30rpx", "paddingBottom" to "30rpx", "paddingLeft" to "30rpx")), "html-wrapper" to padStyleMapOf(utsMapOf("width" to "100%")), "setting-item" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "name" to utsMapOf(".setting-item " to utsMapOf("fontSize" to 17)), "icon" to utsMapOf(".setting-item " to utsMapOf("width" to "17rpx", "height" to "28rpx", "marginLeft" to "20rpx")), "bottom-panel" to padStyleMapOf(utsMapOf("position" to "fixed", "bottom" to 0, "left" to 0, "width" to "100%", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "60rpx", "paddingLeft" to "20rpx", "boxShadow" to "0 -2px 10px rgba(0, 0, 0, 0.1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
