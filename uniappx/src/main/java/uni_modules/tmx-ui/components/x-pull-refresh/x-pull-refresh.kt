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
open class GenUniModulesTmxUiComponentsXPullRefreshXPullRefresh : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            var t = this
            t.isRefresh = this.modelValue
            t.refresherTriggered = t.isRefresh
            if (t.isRefresh) {
                t.`$emit`("refresh")
            }
        }
        , __ins)
        onBeforeUnmount(fun() {
            clearTimeout(this.tid)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newValue: Boolean) {
            if (newValue == this.isRefresh) {
                return
            }
            this.isRefresh = false
            this.refresherTriggered = false
            this.status = "reset"
        }
        )
        this.`$watch`(fun(): Any? {
            return this.modelBottomStatus
        }
        , fun(newValue: Boolean) {
            this.bootomIsRefresh = newValue
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        val _component_x_loading = resolveEasyComponent("x-loading", GenUniModulesTmxUiComponentsXLoadingXLoadingClass)
        return _cE("view", _uM("style" to _nS(_uM("height" to _ctx._height))), _uA(
            if (_ctx.mode == "listview") {
                _cE("list-view", _uM("key" to 0, "show-scrollbar" to _ctx._showScrollbar, "refresher-background" to "transparent", "scroll-top" to _ctx.scrollTop, "scroll-into-view" to _ctx.scrollIntoView, "onRefresherpulling" to _ctx.rPulling, "onRefresherrefresh" to _ctx.rPullEnd, "onRefresherrestore" to _ctx.rPullReset, "onRefresherabort" to _ctx.rPullingAbort, "onScrolltolower" to _ctx.scrollEndBottom, "onScroll" to _ctx.scrollingEvt, "refresher-triggered" to _ctx.refresherTriggered, "direction" to "vertical", "refresher-enabled" to !_ctx._disabledPull, "refresher-threshold" to _ctx.pullHeight, "refresher-default-style" to "none", "style" to _nS(_uM("height" to "100%"))), _uA(
                    renderSlot(_ctx.`$slots`, "default"),
                    _cE("list-item", _uM("class" to "xRefreshPullContentWrap", "slot" to "refresher", "style" to _nS(_uM("height" to ((_ctx.pullHeight * 2.5).toString(10) + "px"), "overflay" to "hidden"))), _uA(
                        _cE("view", _uM("class" to "xRefreshPullContent", "style" to _nS(_uM("paddingBottom" to _ctx._pullDiffHeight))), _uA(
                            renderSlot(_ctx.`$slots`, "pull", _uM("status" to _ctx._status, "dy" to _ctx.pullDy), fun(): UTSArray<Any> {
                                return _uA(
                                    if (_ctx._status != 1) {
                                        _cV(_component_x_icon, _uM("key" to 0, "name" to _ctx._status_obj.icon, "font-size" to "30", "color" to _ctx._status_obj.color), null, 8, _uA(
                                            "name",
                                            "color"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    },
                                    if (_ctx._status == 1) {
                                        _cV(_component_x_icon, _uM("key" to 1, "name" to _ctx._status_obj.icon, "spin" to true, "font-size" to "30", "color" to _ctx._status_obj.color), null, 8, _uA(
                                            "name",
                                            "color"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    },
                                    _cE("text", _uM("class" to "xRefreshText", "style" to _nS(_uM("color" to _ctx._status_obj.textColor))), _tD(_ctx._status_obj.text), 5)
                                )
                            })
                        ), 4)
                    ), 4),
                    _cE("list-item", null, _uA(
                        if (isTrue(_ctx.bootomIsRefresh)) {
                            _cE("view", _uM("key" to 0, "class" to "xRefreshPullContentBottom"), _uA(
                                renderSlot(_ctx.`$slots`, "bottom", UTSJSONObject(), fun(): UTSArray<Any> {
                                    return _uA(
                                        _cV(_component_x_loading)
                                    )
                                })
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                    ))
                ), 44, _uA(
                    "show-scrollbar",
                    "scroll-top",
                    "scroll-into-view",
                    "onRefresherpulling",
                    "onRefresherrefresh",
                    "onRefresherrestore",
                    "onRefresherabort",
                    "onScrolltolower",
                    "onScroll",
                    "refresher-triggered",
                    "refresher-enabled",
                    "refresher-threshold"
                ))
            } else {
                _cC("v-if", true)
            }
            ,
            if (_ctx.mode == "scrollview") {
                _cE("scroll-view", _uM("key" to 1, "scroll-top" to _ctx.scrollTop, "scroll-into-view" to _ctx.scrollIntoView, "show-scrollbar" to _ctx._showScrollbar, "refresher-background" to "transparent", "onRefresherpulling" to _ctx.rPulling, "onRefresherrefresh" to _ctx.rPullEnd, "onRefresherrestore" to _ctx.rPullReset, "onRefresherabort" to _ctx.rPullingAbort, "onScrolltolower" to _ctx.scrollEndBottom, "onScroll" to _ctx.scrollingEvt, "refresher-triggered" to _ctx.refresherTriggered, "direction" to "vertical", "refresher-enabled" to !_ctx._disabledPull, "refresher-threshold" to _ctx.pullHeight, "refresher-default-style" to "none", "style" to _nS(_uM("height" to "100%"))), _uA(
                    _cE("view", _uM("class" to "xRefreshPullContentWrap", "slot" to "refresher", "style" to _nS(_uM("height" to ((_ctx.pullHeight * 2.5).toString(10) + "px")))), _uA(
                        _cE("view", _uM("class" to "xRefreshPullContent", "style" to _nS(_uM("paddingBottom" to _ctx._pullDiffHeight))), _uA(
                            renderSlot(_ctx.`$slots`, "pull", _uM("status" to _ctx._status, "dy" to _ctx.pullDy), fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_x_icon, _uM("name" to _ctx._status_obj.icon, "spin" to (_ctx._status == 1), "font-size" to "30", "color" to _ctx._status_obj.color), null, 8, _uA(
                                        "name",
                                        "spin",
                                        "color"
                                    )),
                                    _cE("text", _uM("class" to "xRefreshText", "style" to _nS(_uM("color" to _ctx._status_obj.textColor))), _tD(_ctx._status_obj.text), 5)
                                )
                            })
                        ), 4)
                    ), 4),
                    renderSlot(_ctx.`$slots`, "default"),
                    if (isTrue(_ctx.bootomIsRefresh)) {
                        _cE("view", _uM("key" to 0, "class" to "xRefreshPullContentBottom"), _uA(
                            renderSlot(_ctx.`$slots`, "bottom", UTSJSONObject(), fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_x_loading)
                                )
                            })
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                ), 44, _uA(
                    "scroll-top",
                    "scroll-into-view",
                    "show-scrollbar",
                    "onRefresherpulling",
                    "onRefresherrefresh",
                    "onRefresherrestore",
                    "onRefresherabort",
                    "onScrolltolower",
                    "onScroll",
                    "refresher-triggered",
                    "refresher-enabled",
                    "refresher-threshold"
                ))
            } else {
                _cC("v-if", true)
            }
        ), 4)
    }
    open var height: String by `$props`
    open var pullHeight: Number by `$props`
    open var color: String by `$props`
    open var textColor: String by `$props`
    open var modelValue: Boolean by `$props`
    open var modelBottomStatus: Boolean by `$props`
    open var mode: String by `$props`
    open var showScrollbar: Boolean by `$props`
    open var disabledPull: Boolean by `$props`
    open var disabledBottom: Boolean by `$props`
    open var status: XPULL_STATUS by `$data`
    open var isRefresh: Boolean by `$data`
    open var refresherTriggered: Boolean by `$data`
    open var pullDy: Number by `$data`
    open var tid: Number by `$data`
    open var bootomIsRefresh: Boolean by `$data`
    open var statusbarHeight: Number by `$data`
    open var dirtid: Number by `$data`
    open var scrollTop: Number by `$data`
    open var scrollIntoView: String by `$data`
    open var _disabledPull: Boolean by `$data`
    open var _disabledBottom: Boolean by `$data`
    open var _showScrollbar: Boolean by `$data`
    open var _height: String by `$data`
    open var _color: String by `$data`
    open var _textColor: String by `$data`
    open var _status: Number by `$data`
    open var _status_obj: XSTATUS_OBJ_INFO by `$data`
    open var _pullDiffHeight: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("status" to "none" as XPULL_STATUS, "isRefresh" to false, "refresherTriggered" to false, "pullDy" to 0, "tid" to 0, "bootomIsRefresh" to false, "statusbarHeight" to 0, "dirtid" to 12, "scrollTop" to 0, "scrollIntoView" to "", "_disabledPull" to computed<Boolean>(fun(): Boolean {
            return this.disabledPull
        }
        ), "_disabledBottom" to computed<Boolean>(fun(): Boolean {
            return this.disabledBottom
        }
        ), "_showScrollbar" to computed<Boolean>(fun(): Boolean {
            return this.showScrollbar
        }
        ), "_height" to computed<String>(fun(): String {
            return checkIsCssUnit(this.height, xConfig.unit)
        }
        ), "_color" to computed<String>(fun(): String {
            if (this.color == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.color)
        }
        ), "_textColor" to computed<String>(fun(): String {
            if (this.textColor == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.textColor)
        }
        ), "_status" to computed<Number>(fun(): Number {
            if (this.isRefresh) {
                return 1
            }
            if (this.pullDy < this.pullHeight) {
                return 2
            }
            if (this.pullDy >= this.pullHeight) {
                return 3
            }
            return 0
        }
        ), "_status_obj" to computed<XSTATUS_OBJ_INFO>(fun(): XSTATUS_OBJ_INFO {
            if (this._status == 1) {
                return XSTATUS_OBJ_INFO(icon = "loader-line", text = "刷新中..", color = this._color, textColor = this._textColor)
            }
            if (this._status == 2) {
                return XSTATUS_OBJ_INFO(icon = "arrow-down-line", text = "继续下拉", color = this._color, textColor = this._textColor)
            }
            if (this._status == 3) {
                return XSTATUS_OBJ_INFO(icon = "arrow-up-line", text = "松开刷新", color = this._color, textColor = this._textColor)
            }
            return XSTATUS_OBJ_INFO(icon = "checkbox-circle-line", text = "刷新完成", color = this._color, textColor = this._textColor)
        }
        ), "_pullDiffHeight" to computed<String>(fun(): String {
            var strNumber = if (this.pullDy > (this.pullHeight * 2)) {
                this.pullDy
            } else {
                this.pullDy
            }
            strNumber = Math.min(this.pullHeight, strNumber)
            strNumber = strNumber / 2
            return strNumber.toString(10) + "px"
        }
        ))
    }
    open var rPulling = ::gen_rPulling_fn
    open fun gen_rPulling_fn(evt: UniRefresherEvent) {
        var py = evt.detail.dy
        this.pullDy = py
        if (this.pullDy <= 0 && this.isRefresh) {
            clearTimeout(this.tid)
            this.isRefresh = false
            this.refresherTriggered = false
            this.status = "none"
            this.`$emit`("update:modelValue", false)
        }
        if (this.pullDy <= 0 && !this.isRefresh) {
            this.status = "none"
        }
    }
    open var rPullEnd = ::gen_rPullEnd_fn
    open fun gen_rPullEnd_fn() {
        if (this.isRefresh) {
            return
        }
        var t = this
        if (!t.isRefresh) {
            t.`$emit`("refresh")
        }
        t.refresherTriggered = true
        t.isRefresh = true
        t.`$emit`("update:modelValue", true)
    }
    open var rPullReset = ::gen_rPullReset_fn
    open fun gen_rPullReset_fn() {}
    open var rPullingAbort = ::gen_rPullingAbort_fn
    open fun gen_rPullingAbort_fn() {}
    open var scrollingEvt = ::gen_scrollingEvt_fn
    open fun gen_scrollingEvt_fn(evt: UniScrollEvent) {
        this.`$emit`("scroll", evt)
        var dir = if (evt.detail.deltaY < 0) {
            "up"
        } else {
            "down"
        }
        this.`$emit`("scrollDirection", dir)
    }
    open var scrollEndBottom = ::gen_scrollEndBottom_fn
    open fun gen_scrollEndBottom_fn() {
        if (this.bootomIsRefresh || this._disabledBottom) {
            return
        }
        this.bootomIsRefresh = true
        this.`$emit`("update:modelBottomStatus", true)
        this.`$emit`("bottomRefresh")
    }
    open var setScrollTop = ::gen_setScrollTop_fn
    open fun gen_setScrollTop_fn(top: Number) {
        this.scrollTop = top
    }
    open var setScrollIntoView = ::gen_setScrollIntoView_fn
    open fun gen_setScrollIntoView_fn(id: String) {
        this.scrollIntoView = id
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xRefreshPullContentBottom" to _pS(_uM("paddingTop" to 16, "paddingRight" to 0, "paddingBottom" to 16, "paddingLeft" to 0)), "xRefreshPullContentWrap" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "flex-end", "width" to "100%")), "xRefreshPullContent" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "flex" to 1)), "xRefreshText" to _pS(_uM("fontSize" to 16, "marginLeft" to 8)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("refresh" to null, "bottomRefresh" to null, "update:modelBottomStatus" to null, "scroll" to null, "scrollDirection" to null, "update:modelValue" to null)
        var props = _nP(_uM("height" to _uM("type" to "String", "default" to "100%"), "pullHeight" to _uM("type" to "Number", "default" to 60), "color" to _uM("type" to "String", "default" to ""), "textColor" to _uM("type" to "String", "default" to ""), "modelValue" to _uM("type" to "Boolean", "default" to false), "modelBottomStatus" to _uM("type" to "Boolean", "default" to false), "mode" to _uM("type" to "String", "default" to "scrollview"), "showScrollbar" to _uM("type" to "Boolean", "default" to true), "disabledPull" to _uM("type" to "Boolean", "default" to false), "disabledBottom" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "height",
            "pullHeight",
            "color",
            "textColor",
            "modelValue",
            "modelBottomStatus",
            "mode",
            "showScrollbar",
            "disabledPull",
            "disabledBottom"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
