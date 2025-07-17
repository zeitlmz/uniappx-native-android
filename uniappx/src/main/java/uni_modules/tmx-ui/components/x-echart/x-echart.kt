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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
import io.dcloud.uniapp.extapi.createWebviewContext as uni_createWebviewContext
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenUniModulesTmxUiComponentsXEchartXEchart : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.getNodeInfo()
            this.onAddlisentMesage()
            uni__on("onResize", this.onResizeChart)
        }
        , __ins)
        onBeforeMount(fun() {
            clearTimeout(this.tid)
        }
        , __ins)
        onBeforeUnmount(fun() {
            uni__off("onResize", this.onResizeChart)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.opts
        }
        , fun() {
            this.drawer()
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        return createElementVNode("view", utsMapOf("class" to "xEchart", "style" to normalizeStyle(utsMapOf("width" to _ctx._width, "height" to _ctx._height))), utsArrayOf(
            if (isTrue(!_ctx.isLoaded)) {
                createElementVNode("view", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("width" to "100%", "height" to "100%", "display" to "flex", "justify-content" to "center", "align-items" to "center", "flex-direction" to "row"))), utsArrayOf(
                    createVNode(_component_x_icon, utsMapOf("color" to "primary", "spin" to true, "name" to "loader-4-line"))
                ), 4)
            } else {
                createElementVNode("web-view", utsMapOf("key" to 1, "onLoad" to _ctx.appWebViewLoaded, "id" to _ctx.id, "src" to "/hybrid/html/local.html", "style" to normalizeStyle(utsMapOf("width" to "100%", "height" to "100%", "opacity" to if (_ctx.isLoaded) {
                    1
                } else {
                    0
                }
                )), "onMessage" to _ctx.onMessage), null, 44, utsArrayOf(
                    "onLoad",
                    "id",
                    "onMessage"
                ))
            }
        ), 4)
    }
    open var width: String by `$props`
    open var height: String by `$props`
    open var opts: String by `$props`
    open var id: String by `$data`
    open var webviewContext: WebviewContext? by `$data`
    open var isLoaded: Boolean by `$data`
    open var boxWidth: Number by `$data`
    open var boxHeight: Number by `$data`
    open var tid: Number by `$data`
    open var tid2: Number by `$data`
    open var realLoaded: Boolean by `$data`
    open var dipcatchEvents: Map<String, eventsType> by `$data`
    open var _width: String by `$data`
    open var _height: String by `$data`
    open var _options: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("id" to ("xEchart-" + getUid()) as String, "webviewContext" to null as WebviewContext?, "isLoaded" to false, "boxWidth" to 10, "boxHeight" to 10, "tid" to 0, "tid2" to 0, "realLoaded" to false, "dipcatchEvents" to Map<String, eventsType>(), "_width" to computed<String>(fun(): String {
            return checkIsCssUnit(this.width, xConfig.unit)
        }
        ), "_height" to computed<String>(fun(): String {
            return checkIsCssUnit(this.height, xConfig.unit)
        }
        ), "_options" to computed<String>(fun(): String {
            return this.opts
        }
        ))
    }
    open var onResizeChart = ::gen_onResizeChart_fn
    open fun gen_onResizeChart_fn() {
        if (this.realLoaded) {
            this.cahrtActions("resize", "", null)
        }
    }
    open var getNodeInfo = ::gen_getNodeInfo_fn
    open fun gen_getNodeInfo_fn() {
        var t = this
        uni_createSelectorQuery().`in`(this).select(".xEchart").boundingClientRect().exec(fun(ret){
            var nodeinfo = ret[0] as NodeInfo
            this.boxWidth = nodeinfo.width!!
            this.boxHeight = nodeinfo.height!!
            if (t.webviewContext != null) {
                return
            }
            t.isLoaded = true
            this.tid = setTimeout(fun() {
                t.webviewContext = uni_createWebviewContext(t.id, t)
            }
            , 50)
        }
        )
    }
    open var onAddlisentMesage = ::gen_onAddlisentMesage_fn
    open fun gen_onAddlisentMesage_fn() {}
    open var onMessage = ::gen_onMessage_fn
    open fun gen_onMessage_fn(event: WebViewMessageEvent) {
        var msgdatas = event.detail.data
        if (msgdatas.length > 0) {
            var msg = msgdatas[0]!! as UTSJSONObject
            var ac = msg!!.getString("action") as String
            if (ac == "img") {
                var imgbase64 = msg!!.getString("url") as String
                console.log(imgbase64)
            } else if (ac == "onJSBridgeReady") {
            } else if (ac == "click") {
                var eventId = msg!!.getString("eventId") as String
                var filterEvents = this.dipcatchEvents.get(eventId)
                if (filterEvents != null) {
                    var handler = filterEvents!! as eventsType
                    var datas = msg!!.getString("data")
                    if (datas == null || datas == "") {
                        handler(UTSJSONObject())
                    } else {
                        var eventData = JSON.parse(datas!!)!! as UTSJSONObject
                        handler(eventData)
                    }
                }
            }
        }
    }
    open var drawer = ::gen_drawer_fn
    open fun gen_drawer_fn() {
        if (!this.realLoaded) {
            uni_showToast(ShowToastOptions(title = "加载中...", icon = "none"))
            return
        }
        this.eventJsCall("chart_setOption", "'" + this._options + "'")
    }
    open var setOptions = ::gen_setOptions_fn
    open fun gen_setOptions_fn(opts: Any) {
        if (!this.realLoaded) {
            uni_showToast(ShowToastOptions(title = "加载中...", icon = "none"))
            return
        }
        this.eventJsCall("chart_setOption", "'" + opts as String + "'")
    }
    open var getImg = ::gen_getImg_fn
    open fun gen_getImg_fn() {
        this.eventJsCall("EchartImg", "")
    }
    open var cahrtActions = ::gen_cahrtActions_fn
    open fun gen_cahrtActions_fn(kFun: String, opts: String, evt: eventsType?) {
        var filterevents = utsArrayOf(
            "click"
        )
        var eventsid = ("x-" + getUid()) as String
        if (evt != null && filterevents.includes(kFun)) {
            this.dipcatchEvents.set(eventsid, evt!!)
        }
        this.webviewContext?.evalJS("chart_call('" + kFun + "','" + opts + "','" + eventsid + "')")
    }
    open var eventJsCall = ::gen_eventJsCall_fn
    open fun gen_eventJsCall_fn(callfun: String, str: String) {
        this.webviewContext?.evalJS("" + callfun + "(" + str + ")")
    }
    open var appWebViewLoaded = ::gen_appWebViewLoaded_fn
    open fun gen_appWebViewLoaded_fn() {
        this.realLoaded = true
        this.drawer()
        this.`$emit`("init")
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("init" to null)
        var props = normalizePropsOptions(utsMapOf("width" to utsMapOf("type" to "String", "default" to "auto"), "height" to utsMapOf("type" to "String", "default" to "250px"), "opts" to utsMapOf("type" to "String", "default" to "")))
        var propsNeedCastKeys = utsArrayOf(
            "width",
            "height",
            "opts"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
