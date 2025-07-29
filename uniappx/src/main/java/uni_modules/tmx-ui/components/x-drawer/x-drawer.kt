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
import io.dcloud.uniapp.extapi.rpx2px as uni_rpx2px
open class GenUniModulesTmxUiComponentsXDrawerXDrawer : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.lezyShowModal = if (this._lazy) {
                false
            } else {
                true
            }
            var t = this
            fun oninitready() {
                t.isOpenedDefault = true
                var sys = uni_getWindowInfo()
                t._width = sys.windowWidth
                t._height = sys.windowHeight + 44
                t.windtop = t._offset
                t.safeFooterHeight = if (sys.safeAreaInsets.bottom == 0) {
                    16
                } else {
                    sys.safeAreaInsets.bottom
                }
                if (t._show) {
                    t.showAlert()
                }
            }
            oninitready()
        }
        , __ins)
        onBeforeUnmount(fun() {
            clearTimeout(this.tid)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.show
        }
        , fun(_newval: Boolean) {
            if (_newval) {
                this.showAlert()
            } else {
                this.closeAlert()
            }
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        val _component_x_loading = resolveEasyComponent("x-loading", GenUniModulesTmxUiComponentsXLoadingXLoadingClass)
        val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass)
        return createElementVNode("view", null, utsArrayOf(
            createElementVNode("view", utsMapOf("onClick" to _ctx.openDrawer), utsArrayOf(
                renderSlot(_ctx.`$slots`, "trigger", GenUniModulesTmxUiComponentsXDrawerXDrawerSlotDataTrigger(show = _ctx.show))
            ), 8, utsArrayOf(
                "onClick"
            )),
            if (isTrue(_ctx.showOverflay)) {
                createElementVNode("view", utsMapOf("key" to 0, "onClick" to _ctx.onClickOverflowy, "onTouchmove" to _ctx.maskerMove, "id" to _ctx.id, "ref" to "xDrawerWrap", "class" to normalizeClass(utsArrayOf(
                    "xDrawerWrap",
                    utsArrayOf(
                        if ((_ctx._position == "top" || _ctx._position == "bottom") && _ctx._widthCoverCenter) {
                            "xDrawerWrapContentMinwidthWrapDir"
                        } else {
                            ""
                        },
                        "xDrawerWrap_" + _ctx._position
                    )
                )), "style" to normalizeStyle(utsArrayOf(
                    utsMapOf("backgroundColor" to _ctx.overflayBgColor, "width" to "100%", "top" to (_ctx.windtop + "px"), "height" to _ctx.__height, "zIndex" to _ctx.zIndex, "transition-timing-function" to _ctx._animationFun),
                    _ctx._customStyle
                ))), utsArrayOf(
                    if (isTrue(_ctx.showOverflay && _ctx._position == "bottom" && !_ctx.actioning)) {
                        createElementVNode("view", utsMapOf("key" to 0), utsArrayOf(
                            renderSlot(_ctx.`$slots`, "contentTop")
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    },
                    createElementVNode("view", utsMapOf("onTransitionend" to _ctx.onEnd, "onClick" to withModifiers(fun(){}, utsArrayOf(
                        "stop"
                    )), "ref" to "xDrawerWrapContent", "class" to normalizeClass(utsArrayOf(
                        "xDrawerWrapContent",
                        utsArrayOf(
                            if ((_ctx._position == "top" || _ctx._position == "bottom") && _ctx._widthCoverCenter) {
                                "xDrawerWrapContentMinwidth"
                            } else {
                                ""
                            },
                            "xDrawerWrapContent_" + _ctx._position
                        )
                    )), "onTouchstart" to _ctx.mStart, "onTouchmove" to _ctx.mMove, "onTouchend" to _ctx.mEnd, "id" to _ctx.wrapId, "style" to normalizeStyle(utsArrayOf(
                        utsMapOf("width" to if (_ctx._position == "left" || _ctx._position == "right") {
                            _ctx._size
                        } else {
                            "100%"
                        }, "height" to if (_ctx._position == "left" || _ctx._position == "right") {
                            "100%"
                        } else {
                            _ctx._size
                        }, "borderRadius" to _ctx._round, "maxHeight" to if (_ctx._maxHeight != "") {
                            _ctx._maxHeight
                        } else {
                            "100%"
                        }, "transition-timing-function" to _ctx._animationFun, "backgroundColor" to _ctx._bgColor),
                        _ctx.customWrapStyle
                    ))), utsArrayOf(
                        if (isTrue(_ctx._showClose)) {
                            createElementVNode("view", utsMapOf("key" to 0, "class" to "xDrawerXclose"), utsArrayOf(
                                createVNode(_component_x_icon, utsMapOf("onClick" to _ctx.cancelEvt, "color" to _ctx.closeColor, "dark-color" to _ctx.closeDarkColor, "font-size" to "24px", "name" to _ctx._closeIcon), null, 8, utsArrayOf(
                                    "onClick",
                                    "color",
                                    "dark-color",
                                    "name"
                                ))
                            ))
                        } else {
                            createCommentVNode("v-if", true)
                        },
                        if (isTrue(_ctx._showTitle)) {
                            createElementVNode("view", utsMapOf("key" to 1), utsArrayOf(
                                renderSlot(_ctx.`$slots`, "title", utsMapOf("show" to _ctx.show), fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "xDrawerTitleBox"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("fontSize" to _ctx._titleFontSize, "color" to if (_ctx._isDark) {
                                                "white"
                                            } else {
                                                "black"
                                            }, "opacity" to "0.64")), "class" to "xDrawertitleBox"), toDisplayString(_ctx._title), 5)
                                        ))
                                    )
                                })
                            ))
                        } else {
                            createCommentVNode("v-if", true)
                        },
                        if (isTrue(!_ctx.lezyShowModal)) {
                            createVNode(_component_x_loading, utsMapOf("key" to 2), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode("text")
                                )
                            }), "_" to 1))
                        } else {
                            createCommentVNode("v-if", true)
                        },
                        createElementVNode("view", utsMapOf("ref" to "xDrawerContent", "class" to "xDrawerContent", "style" to normalizeStyle(utsMapOf("flex" to "1", "margin" to ("0px 0px " + _ctx._contentMargin + " 0px")))), utsArrayOf(
                            if (isTrue(!_ctx.disabledScroll && _ctx.lezyShowModal)) {
                                createElementVNode("scroll-view", utsMapOf("key" to 0, "onScroll" to _ctx.onScroll, "onScrolltoupper" to _ctx.onScrollTop, "onScrolltolower" to _ctx.onScrollBottom, "style" to normalizeStyle(utsMapOf("flex" to "1")), "scroll-y" to true, "rebound" to false), utsArrayOf(
                                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("padding" to ("0px " + _ctx._contentMargin + " 0px " + _ctx._contentMargin)))), utsArrayOf(
                                        renderSlot(_ctx.`$slots`, "default")
                                    ), 4)
                                ), 44, utsArrayOf(
                                    "onScroll",
                                    "onScrolltoupper",
                                    "onScrolltolower"
                                ))
                            } else {
                                createCommentVNode("v-if", true)
                            },
                            if (isTrue(_ctx.disabledScroll && _ctx.lezyShowModal)) {
                                createElementVNode("view", utsMapOf("key" to 1, "style" to normalizeStyle(utsMapOf("flex" to "1", "padding" to ("0px " + _ctx._contentMargin + " 0px " + _ctx._contentMargin)))), utsArrayOf(
                                    renderSlot(_ctx.`$slots`, "default")
                                ), 4)
                            } else {
                                createCommentVNode("v-if", true)
                            }
                        ), 4),
                        if (isTrue(_ctx.showFooter && _ctx.lezyShowModal)) {
                            createElementVNode("view", utsMapOf("key" to 3, "class" to "xDrawerFooter", "style" to normalizeStyle(utsMapOf("backgroundColor" to _ctx._bgColor))), utsArrayOf(
                                renderSlot(_ctx.`$slots`, "footer", UTSJSONObject(), fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex-direction" to "row", "align-items" to "center", "justify-content" to "center", "display" to "flex"))), utsArrayOf(
                                            if (isTrue(_ctx._showCancel)) {
                                                createVNode(_component_x_button, utsMapOf("key" to 0, "disabled" to _ctx.isLoading, "color" to _ctx._btnColor, "onClick" to _ctx.cancelEvt, "skin" to "thin", "width" to "0px", "block" to true, "style" to normalizeStyle(utsMapOf("margin-right" to "16rpx", "flex" to "1"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        toDisplayString(_ctx._cancelText)
                                                    )
                                                }), "_" to 1), 8, utsArrayOf(
                                                    "disabled",
                                                    "color",
                                                    "onClick",
                                                    "style"
                                                ))
                                            } else {
                                                createCommentVNode("v-if", true)
                                            },
                                            createVNode(_component_x_button, utsMapOf("loading" to _ctx.isLoading, "color" to _ctx._btnColor, "onClick" to _ctx.confirmEvt, "width" to "0px", "disabled" to _ctx._disabledConfirm, "block" to true, "style" to normalizeStyle(utsMapOf("flex" to "1"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    toDisplayString(_ctx._confirmText)
                                                )
                                            }), "_" to 1), 8, utsArrayOf(
                                                "loading",
                                                "color",
                                                "onClick",
                                                "disabled",
                                                "style"
                                            ))
                                        ), 4)
                                    )
                                }),
                                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("height" to (_ctx.safeFooterHeight + "px")))), null, 4)
                            ), 4)
                        } else {
                            createCommentVNode("v-if", true)
                        }
                    ), 46, utsArrayOf(
                        "onTransitionend",
                        "onClick",
                        "onTouchstart",
                        "onTouchmove",
                        "onTouchend",
                        "id"
                    ))
                ), 46, utsArrayOf(
                    "onClick",
                    "onTouchmove",
                    "id"
                ))
            } else {
                createCommentVNode("v-if", true)
            }
        ))
    }
    open var customStyle: String by `$props`
    open var customWrapStyle: String by `$props`
    open var title: String by `$props`
    open var showFooter: Boolean by `$props`
    open var showTitle: Boolean by `$props`
    open var showClose: Boolean by `$props`
    open var overlayClick: Boolean by `$props`
    open var show: Boolean by `$props`
    open var showCancel: Boolean by `$props`
    open var cancelText: String by `$props`
    open var confirmText: String by `$props`
    open var duration: Number by `$props`
    open var watiDuration: Number by `$props`
    open var position: String by `$props`
    open var round: String by `$props`
    open var size: String by `$props`
    open var maxHeight: String by `$props`
    open var bgColor: String by `$props`
    open var darkBgColor: String by `$props`
    open var overflayBgColor: String by `$props`
    open var disabledScroll: Boolean by `$props`
    open var contentMargin: String by `$props`
    open var widthCoverCenter: Boolean by `$props`
    open var swiperLenClose: Number by `$props`
    open var offsetTop: String by `$props`
    open var offsetBottom: String by `$props`
    open var zIndex: Number by `$props`
    open var lazy: Boolean by `$props`
    open var disabledConfirm: Boolean by `$props`
    open var btnColor: String by `$props`
    open var beforeClose: callbackType by `$props`
    open var closeColor: String by `$props`
    open var closeDarkColor: String by `$props`
    open var _width: Number by `$data`
    open var _height: Number by `$data`
    open var showOverflay: Boolean by `$data`
    open var actioning: Boolean by `$data`
    open var status: String by `$data`
    open var id: Any? by `$data`
    open var wrapId: String by `$data`
    open var first: Boolean by `$data`
    open var tid: Number by `$data`
    open var windtop: Number by `$data`
    open var windowBottom: Number by `$data`
    open var start_move_x: Number by `$data`
    open var start_move_y: Number by `$data`
    open var move_x: Number by `$data`
    open var move_y: Number by `$data`
    open var move_end_x: Number by `$data`
    open var move_end_y: Number by `$data`
    open var scrollTop: Number by `$data`
    open var isTopOrBottomByScroll: Boolean by `$data`
    open var xDrawerContentHeight: Number by `$data`
    open var safeFooterHeight: Number by `$data`
    open var lezyShowModal: Boolean by `$data`
    open var isOpenedDefault: Boolean by `$data`
    open var isLoading: Boolean by `$data`
    open var _disabledConfirm: Boolean by `$data`
    open var _lazy: Boolean by `$data`
    open var _customStyle: String by `$data`
    open var _customWrapStyle: String by `$data`
    open var _show: Boolean by `$data`
    open var _widthCoverCenter: Boolean by `$data`
    open var _showClose: Boolean by `$data`
    open var _duration: Number by `$data`
    open var _position: String by `$data`
    open var _title: String by `$data`
    open var _showTitle: Boolean by `$data`
    open var _round: String by `$data`
    open var _offset: Number by `$data`
    open var _offsetBottom: Number by `$data`
    open var _size: String by `$data`
    open var _contentMargin: String by `$data`
    open var _showFooter: Boolean by `$data`
    open var _maxHeight: String by `$data`
    open var _showCancel: Boolean by `$data`
    open var _cancelText: String by `$data`
    open var _confirmText: String by `$data`
    open var _animationFun: String by `$data`
    open var _bgColor: String by `$data`
    open var _btnColor: String by `$data`
    open var __height: String by `$data`
    open var _titleFontSize: String by `$data`
    open var _isDark: Boolean by `$data`
    open var _closeIcon: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("_width" to 0, "_height" to 0, "showOverflay" to false, "actioning" to false, "status" to "", "id" to ("xDrawer" + getUid()), "wrapId" to ("xDrawerWrap" + getUid()) as String, "first" to true, "tid" to 0, "windtop" to 0, "windowBottom" to 0, "start_move_x" to 0, "start_move_y" to 0, "move_x" to 0, "move_y" to 0, "move_end_x" to 0, "move_end_y" to 0, "scrollTop" to -1, "isTopOrBottomByScroll" to false, "xDrawerContentHeight" to 0, "safeFooterHeight" to 0, "lezyShowModal" to true, "isOpenedDefault" to false, "isLoading" to false, "_disabledConfirm" to computed<Boolean>(fun(): Boolean {
            return this.disabledConfirm
        }
        ), "_lazy" to computed<Boolean>(fun(): Boolean {
            return this.lazy
        }
        ), "_customStyle" to computed<String>(fun(): String {
            return this.customStyle
        }
        ), "_customWrapStyle" to computed<String>(fun(): String {
            return this.customWrapStyle
        }
        ), "_show" to computed<Boolean>(fun(): Boolean {
            return this.show
        }
        ), "_widthCoverCenter" to computed<Boolean>(fun(): Boolean {
            return this.widthCoverCenter
        }
        ), "_showClose" to computed<Boolean>(fun(): Boolean {
            return this.showClose
        }
        ), "_duration" to computed<Number>(fun(): Number {
            return this.duration
        }
        ), "_position" to computed<String>(fun(): String {
            return this.position
        }
        ), "_title" to computed<String>(fun(): String {
            return this.title
        }
        ), "_showTitle" to computed<Boolean>(fun(): Boolean {
            return this.showTitle
        }
        ), "_round" to computed<String>(fun(): String {
            var round = this.round
            if (round == "") {
                round = xConfig.drawerRadius
            }
            var radius = checkIsCssUnit(round, xConfig.unit)
            var _r = "none"
            if (this.position == "top") {
                _r = "0px 0px " + radius + " " + radius
            }
            if (this.position == "bottom") {
                _r = "" + radius + " " + radius + " 0px 0px"
            }
            return _r
        }
        ), "_offset" to computed<Number>(fun(): Number {
            var offset = checkIsCssUnit(this.offsetTop, xConfig.unit)
            var x = parseFloat(offset)
            var unit = getUnit(offset)
            if (unit == "rpx") {
                x = uni_rpx2px(x)
            }
            return x
        }
        ), "_offsetBottom" to computed<Number>(fun(): Number {
            var offset = checkIsCssUnit(this.offsetBottom, xConfig.unit)
            var x = parseFloat(offset)
            var unit = getUnit(offset)
            if (unit == "rpx") {
                x = uni_rpx2px(x)
            }
            return x
        }
        ), "_size" to computed<String>(fun(): String {
            return checkIsCssUnit(this.size, xConfig.unit)
        }
        ), "_contentMargin" to computed<String>(fun(): String {
            return checkIsCssUnit(this.contentMargin, xConfig.unit)
        }
        ), "_showFooter" to computed<Boolean>(fun(): Boolean {
            return this.showFooter
        }
        ), "_maxHeight" to computed<String>(fun(): String {
            if (this.maxHeight == "") {
                return ""
            }
            if (this.position == "left" || this.position == "right") {
                return ""
            }
            return checkIsCssUnit(this.maxHeight, xConfig.unit)
        }
        ), "_showCancel" to computed<Boolean>(fun(): Boolean {
            return this.showCancel
        }
        ), "_cancelText" to computed<String>(fun(): String {
            return this.cancelText
        }
        ), "_confirmText" to computed<String>(fun(): String {
            return this.confirmText
        }
        ), "_animationFun" to computed<String>(fun(): String {
            return xConfig.animationFun
        }
        ), "_bgColor" to computed<String>(fun(): String {
            var bgcolor = this.bgColor
            if (xConfig.dark == "dark") {
                if (this.darkBgColor != "") {
                }
                bgcolor = if (this.darkBgColor != "") {
                    this.darkBgColor
                } else {
                    xConfig.sheetDarkColor
                }
            }
            return getDefaultColor(bgcolor)
        }
        ), "_btnColor" to computed<String>(fun(): String {
            if (this.btnColor == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.btnColor)
        }
        ), "__height" to computed<String>(fun(): String {
            var h = "100%"
            if (this._offset > 0 || this._offsetBottom > 0) {
                h = (this._height - this._offsetBottom) + "px"
            }
            return h
        }
        ), "_titleFontSize" to computed<String>(fun(): String {
            return (xConfig.fontScale * 16).toString(10) + "px"
        }
        ), "_isDark" to computed<Boolean>(fun(): Boolean {
            return xConfig.dark == "dark"
        }
        ), "_closeIcon" to computed<String>(fun(): String {
            return xConfig.closeIcon
        }
        ))
    }
    open var cancelEvt = ::gen_cancelEvt_fn
    open fun gen_cancelEvt_fn() {
        this.`$emit`("cancel")
        this.closeAlert()
    }
    open var confirmEvt = ::gen_confirmEvt_fn
    open fun gen_confirmEvt_fn(): UTSPromise<Any> {
        return wrapUTSPromise(suspend w@{
                this.isLoading = true
                var isCanClose = await(this.beforeClose())
                this.isLoading = false
                if (!isCanClose) {
                    return@w UTSPromise.resolve(true)
                }
                this.`$emit`("confirm")
                this.closeAlert()
                return@w UTSPromise.resolve(false)
        })
    }
    open var overflayMoveTouch = ::gen_overflayMoveTouch_fn
    open fun gen_overflayMoveTouch_fn(evt: TouchEvent) {
        evt.preventDefault()
    }
    open var onClickOverflowy = ::gen_onClickOverflowy_fn
    open fun gen_onClickOverflowy_fn(evt: Event) {
        evt.stopPropagation()
        this.`$emit`("click")
        if (!this.overlayClick || this.isLoading) {
            return
        }
        this.closeAlert()
    }
    open var closeAlert = ::gen_closeAlert_fn
    open fun gen_closeAlert_fn() {
        if (this.actioning) {
            return
        }
        if (this.status == "close") {
            return
        }
        this.actioning = true
        this.status = "close"
        this.`$emit`("beforeClose")
        this.setStyleAni()
    }
    open var showAlert = ::gen_showAlert_fn
    open fun gen_showAlert_fn() {
        if (this.actioning) {
            return
        }
        if (this.status == "open") {
            return
        }
        this.showOverflay = true
        this.actioning = true
        this.status = "open"
        this.`$emit`("beforeOpen")
        this.setStyleAni()
    }
    open var setStyleAni = ::gen_setStyleAni_fn
    open fun gen_setStyleAni_fn() {
        try {
            var t = this
            var sys = uni_getWindowInfo()
            t._height = sys.windowHeight - t._offset
            var watiDuration: Number = 60
            if (this.status == "open") {
                this.showOverflay = true
                clearTimeout(this.tid)
                this.tid = setTimeout(fun() {
                    var element = t.`$refs`["xDrawerWrap"] as UniElement?
                    var elementWrap = t.`$refs`["xDrawerWrapContent"] as UniElement?
                    if (element == null || elementWrap == null) {
                        return
                    }
                    element!!.style.setProperty("transition-duration", t._duration.toString(10) + "ms")
                    elementWrap!!.style.setProperty("transition-duration", t._duration.toString(10) + "ms")
                    element!!.style.setProperty("opacity", 1)
                    elementWrap!!.style.setProperty("transform", "translate(0%,0%)")
                }, watiDuration)
            } else if (this.status == "close") {
                var element = t.`$refs`["xDrawerWrap"] as UniElement?
                var elementWrap = t.`$refs`["xDrawerWrapContent"] as UniElement?
                if (element == null || elementWrap == null) {
                    return
                }
                element.style.setProperty("transition-duration", this._duration.toString(10) + "ms")
                elementWrap.style.setProperty("transition-duration", this._duration.toString(10) + "ms")
                element.style.setProperty("opacity", 0)
                if (this._position == "bottom") {
                    elementWrap.style.setProperty("transform", "translate(0%,100%)")
                } else if (this._position == "top") {
                    elementWrap.style.setProperty("transform", "translate(0%,-100%)")
                } else if (this._position == "left") {
                    elementWrap.style.setProperty("transform", "translate(-100%,0%)")
                } else if (this._position == "right") {
                    elementWrap.style.setProperty("transform", "translate(100%,0%)")
                }
            }
        }
         catch (e: Throwable) {}
    }
    open var openDrawer = ::gen_openDrawer_fn
    open fun gen_openDrawer_fn() {
        this.showAlert()
    }
    open var onEnd = ::gen_onEnd_fn
    open fun gen_onEnd_fn() {
        this.actioning = false
        if (this.status == "close") {
            this.showOverflay = false
            this.`$emit`("close")
            this.`$emit`("update:show", false)
            if (this._lazy) {
                this.lezyShowModal = false
            }
        } else {
            this.`$emit`("open")
            if (this._lazy) {
                this.lezyShowModal = true
            }
        }
    }
    open var maskerMove = ::gen_maskerMove_fn
    open fun gen_maskerMove_fn(evt: UniTouchEvent) {}
    open var mStart = ::gen_mStart_fn
    open fun gen_mStart_fn(evt: UniTouchEvent) {
        if (this.swiperLenClose == 0) {
            return
        }
        this.start_move_x = evt.changedTouches[0].clientX
        this.start_move_y = evt.changedTouches[0].clientY
    }
    open var mMove = ::gen_mMove_fn
    open fun gen_mMove_fn(evt: UniTouchEvent) {
        if (this.swiperLenClose == 0) {
            return
        }
        if (evt.changedTouches.length == 0) {
            return
        }
        this.move_x = evt.changedTouches[0].clientX
        this.move_y = evt.changedTouches[0].clientY
    }
    open var mEnd = ::gen_mEnd_fn
    open fun gen_mEnd_fn(evt: UniTouchEvent) {
        if (this.swiperLenClose == 0) {
            return
        }
        if (evt.changedTouches.length == 0) {
            return
        }
        var x = evt.changedTouches[0].clientX
        var y = evt.changedTouches[0].clientY
        this.move_end_x = x
        this.move_end_y = y
        this.swiperClose()
    }
    open var swiperClose = ::gen_swiperClose_fn
    open fun gen_swiperClose_fn() {
        var offsetX = this.move_end_x - this.start_move_x
        var offsetY = this.move_end_y - this.start_move_y
        if (this.swiperLenClose == 0 || (this.actioning && this.status == "close")) {
            return
        }
        if (this.position == "left" && offsetX < this.swiperLenClose * -1 && Math.abs(offsetX) >= Math.abs(offsetY)) {
            this.closeAlert()
        }
        if (this.position == "right" && offsetX > this.swiperLenClose && Math.abs(offsetX) >= Math.abs(offsetY)) {
            this.closeAlert()
        }
        if (this.position == "top" && offsetY < this.swiperLenClose * -1 && Math.abs(offsetY) >= Math.abs(offsetX)) {
            this.closeAlert()
        }
        if (this.position == "bottom" && offsetY > this.swiperLenClose && Math.abs(offsetY) >= Math.abs(offsetX)) {
            this.closeAlert()
        }
    }
    open var onScroll = ::gen_onScroll_fn
    open fun gen_onScroll_fn(evt: UniScrollEvent) {
        if (this.position == "bottom") {
            if (evt.detail.scrollTop > 0) {
                this.start_move_x = this.move_x
                this.start_move_y = this.move_y
            }
        }
        if (this.position == "top") {
            var ele = this.`$refs`["xDrawerContent"] as UniElement?
            if (ele == null) {
                return
            }
            var height = ele.getBoundingClientRect().height
            var maxheight = evt.detail.scrollHeight - evt.detail.scrollTop
            if (evt.detail.scrollTop < maxheight - 1) {
                this.start_move_x = this.move_x
                this.start_move_y = this.move_y
            }
        }
    }
    open var onScrollTop = ::gen_onScrollTop_fn
    open fun gen_onScrollTop_fn(evt: UniScrollToUpperEvent) {
        this.start_move_x = this.move_x
        this.start_move_y = this.move_y
    }
    open var onScrollBottom = ::gen_onScrollBottom_fn
    open fun gen_onScrollBottom_fn(evt: UniScrollToLowerEvent) {
        this.start_move_x = this.move_x
        this.start_move_y = this.move_y
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xDrawerContent" to padStyleMapOf(utsMapOf("position" to "relative")), "xDrawerFooter" to padStyleMapOf(utsMapOf("width" to "100%", "paddingTop" to 0, "paddingRight" to 16, "paddingBottom" to 0, "paddingLeft" to 16)), "xDrawerXclose" to padStyleMapOf(utsMapOf("position" to "absolute", "right" to 16, "top" to 9, "zIndex" to 100)), "xDrawerXcloseOutter" to padStyleMapOf(utsMapOf("paddingRight" to 16)), "xDrawerTitleBox" to padStyleMapOf(utsMapOf("height" to 50, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "xDrawertitleBox" to padStyleMapOf(utsMapOf("maxWidth" to 175, "overflow" to "hidden", "lines" to 1, "textOverflow" to "ellipsis")), "xDrawerWrap_bottom" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "justifyContent" to "flex-end")), "xDrawerWrap_top" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "justifyContent" to "flex-start")), "xDrawerWrap_left" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start")), "xDrawerWrap_right" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end")), "xDrawerWrapContent" to padStyleMapOf(utsMapOf("transitionDuration" to "350ms", "transitionProperty" to "transform", "display" to "flex", "flexDirection" to "column", "position" to "relative")), "xDrawerWrapContentMinwidth" to padStyleMapOf(utsMapOf("maxWidth" to 500)), "xDrawerWrapContentMinwidthWrapDir" to padStyleMapOf(utsMapOf("alignItems" to "center")), "xDrawerWrapContent_bottom" to padStyleMapOf(utsMapOf("transform" to "translate(0%, 100%)")), "xDrawerWrapContent_top" to padStyleMapOf(utsMapOf("transform" to "translate(0%, -100%)")), "xDrawerWrapContent_left" to padStyleMapOf(utsMapOf("transform" to "translate(-100%, 0%)")), "xDrawerWrapContent_right" to padStyleMapOf(utsMapOf("transform" to "translate(100%, 0%)")), "xDrawerWrap" to padStyleMapOf(utsMapOf("opacity" to 0, "position" to "fixed", "left" to 0, "top" to 0, "transitionDuration" to "350ms", "transitionProperty" to "opacity")), "@TRANSITION" to utsMapOf("xDrawerWrapContent" to utsMapOf("duration" to "350ms", "property" to "transform"), "xDrawerWrap" to utsMapOf("duration" to "350ms", "property" to "opacity")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("click" to null, "close" to null, "open" to null, "beforeOpen" to null, "beforeClose" to null, "update:show" to null, "cancel" to null, "confirm" to null)
        var props = normalizePropsOptions(utsMapOf("customStyle" to utsMapOf("type" to "String", "default" to ""), "customWrapStyle" to utsMapOf("type" to "String", "default" to ""), "title" to utsMapOf("type" to "String", "default" to "标题"), "showFooter" to utsMapOf("type" to "Boolean", "default" to false), "showTitle" to utsMapOf("type" to "Boolean", "default" to true), "showClose" to utsMapOf("type" to "Boolean", "default" to false), "overlayClick" to utsMapOf("type" to "Boolean", "default" to true), "show" to utsMapOf("type" to "Boolean", "default" to false), "showCancel" to utsMapOf("type" to "Boolean", "default" to true), "cancelText" to utsMapOf("type" to "String", "default" to "取消"), "confirmText" to utsMapOf("type" to "String", "default" to "确认"), "duration" to utsMapOf("type" to "Number", "default" to 300), "watiDuration" to utsMapOf("type" to "Number", "default" to 120), "position" to utsMapOf("type" to "String", "default" to "bottom"), "round" to utsMapOf("type" to "String", "default" to ""), "size" to utsMapOf("type" to "String", "default" to "50%"), "maxHeight" to utsMapOf("type" to "String", "default" to ""), "bgColor" to utsMapOf("type" to "String", "default" to "white"), "darkBgColor" to utsMapOf("type" to "String", "default" to ""), "overflayBgColor" to utsMapOf("type" to "String", "default" to "rgba(0, 0, 0, 0.4)"), "disabledScroll" to utsMapOf("type" to "Boolean", "default" to false), "contentMargin" to utsMapOf("type" to "String", "default" to "16"), "widthCoverCenter" to utsMapOf("type" to "Boolean", "default" to false), "swiperLenClose" to utsMapOf("type" to "Number", "default" to 0), "offsetTop" to utsMapOf("type" to "String", "default" to "0"), "offsetBottom" to utsMapOf("type" to "String", "default" to "0"), "zIndex" to utsMapOf("type" to "Number", "default" to 1100), "lazy" to utsMapOf("type" to "Boolean", "default" to false), "disabledConfirm" to utsMapOf("type" to "Boolean", "default" to false), "btnColor" to utsMapOf("type" to "String", "default" to ""), "beforeClose" to utsMapOf("type" to "Function", "default" to fun(): UTSPromise<Boolean> {
            return UTSPromise.resolve(true)
        }
        ), "closeColor" to utsMapOf("type" to "String", "default" to "#e6e6e6"), "closeDarkColor" to utsMapOf("type" to "String", "default" to "#545454")))
        var propsNeedCastKeys = utsArrayOf(
            "customStyle",
            "customWrapStyle",
            "title",
            "showFooter",
            "showTitle",
            "showClose",
            "overlayClick",
            "show",
            "showCancel",
            "cancelText",
            "confirmText",
            "duration",
            "watiDuration",
            "position",
            "round",
            "size",
            "maxHeight",
            "bgColor",
            "darkBgColor",
            "overflayBgColor",
            "disabledScroll",
            "contentMargin",
            "widthCoverCenter",
            "swiperLenClose",
            "offsetTop",
            "offsetBottom",
            "zIndex",
            "lazy",
            "disabledConfirm",
            "btnColor",
            "beforeClose",
            "closeColor",
            "closeDarkColor"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
