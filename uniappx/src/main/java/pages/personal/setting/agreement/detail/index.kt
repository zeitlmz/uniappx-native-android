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
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalSettingAgreementDetailIndex : BasePage {
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
                return _cE(Fragment, null, _uA(
                    _cV(_component_x_navbar, _uM("title" to "协议内容", "title-color" to "#000000", "title-font-size" to "18", "isPlace" to true, "height" to 50, "showNavBack" to true), _uM("left" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            renderSlot(_ctx.`$slots`, "navbar-left")
                        )
                    }
                    ), "title" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            renderSlot(_ctx.`$slots`, "navbar-title")
                        )
                    }
                    ), "_" to 3)),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("rich-text", _uM("id" to "rich-text", "style" to _nS(_uM("margin-bottom" to "50rpx", "padding" to "15")), "selectable" to true, "nodes" to unref(contentHtml), "onItemclick" to clickItem), null, 44, _uA(
                            "nodes"
                        ))
                    ), 4)
                ), 64)
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
                return _uM("agreement-content" to _pS(_uM("flex" to 1, "height" to "100%", "paddingTop" to "30rpx", "paddingRight" to "30rpx", "paddingBottom" to "30rpx", "paddingLeft" to "30rpx")), "html-wrapper" to _pS(_uM("width" to "100%")), "setting-item" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "name" to _uM(".setting-item " to _uM("fontSize" to 17)), "icon" to _uM(".setting-item " to _uM("width" to "17rpx", "height" to "28rpx", "marginLeft" to "20rpx")), "bottom-panel" to _pS(_uM("position" to "fixed", "bottom" to 0, "left" to 0, "width" to "100%", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "60rpx", "paddingLeft" to "20rpx", "boxShadow" to "0 -2px 10px rgba(0, 0, 0, 0.1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
