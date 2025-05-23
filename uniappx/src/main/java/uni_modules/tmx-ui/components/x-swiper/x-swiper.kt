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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
import uts.sdk.modules.mcAmapNavPlus.init
open class GenUniModulesTmxUiComponentsXSwiperXSwiper : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        provide("xSwiperRadius", this._round)
        provide("xSwipershowScalAni", this._showScalAni)
        provide("xSwiperSpace", this.space)
        provide("xSwiperSpaceOffset", this.spaceOffset)
        provide("xSwiperModel", this.model)
        onMounted(fun() {
            if (this.vertical) {
                this.dirs = "up"
            }
            var t = this
            this.tid = setTimeout(fun() {
                t.getNodeInfo()
            }
            , 200)
            uni__on("onHide", this.pause)
            uni__on("onShow", this.pauseInStart)
        }
        , __ins)
        onBeforeUnmount(fun() {
            clearInterval(this.tid)
            uni__off("onHide", this.pause)
            uni__off("onShow", this.pauseInStart)
            this.resizeObserver?.disconnect()
        }
        , __ins)
        onDeactivated(fun() {}, __ins)
        onActivated(fun() {}, __ins)
        this.`$watch`(fun(): Any? {
            return this.autoPlay
        }
        , fun() {
            this.pause()
            this.init(true)
        }
        )
        this.`$watch`(fun(): Any? {
            return this.list
        }
        , fun() {
            this.pause()
            this.init(true)
        }
        , WatchOptions(deep = true))
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newvalue: Number) {
            if (newvalue == this.nowCureentIndex) {
                return
            }
            this.nowCureentIndex = newvalue
            this.pause()
            this.init(false)
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return createElementVNode("view", utsMapOf("onTouchstart" to _ctx.mStart, "onTouchmove" to _ctx.mMove, "onTouchend" to _ctx.mEnd, "onTouchcancel" to _ctx.mEnd, "key" to _ctx.key, "ref" to "xSwiper", "class" to "xSwiper", "id" to _ctx.parentId, "style" to normalizeStyle(utsMapOf("height" to _ctx._height, "width" to _ctx._width, "borderRadius" to _ctx._round))), utsArrayOf(
            createElementVNode("view", utsMapOf("id" to _ctx.id, "ref" to "xSwiperWrap", "class" to normalizeClass(utsArrayOf(
                "xSwiperWrap",
                utsArrayOf(
                    if (_ctx.vertical) {
                        "xSwiperV"
                    } else {
                        "xSwiperH"
                    }
                )
            )), "style" to normalizeStyle(utsMapOf("width" to (_ctx.boxWidth + "px"), "height" to (_ctx.boxHeight + "px"), "borderRadius" to _ctx._round))), utsArrayOf(
                renderSlot(_ctx.`$slots`, "default")
            ), 14, utsArrayOf(
                "id"
            )),
            if (isTrue(_ctx.vertical && _ctx._showDot)) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "xSwiperDotV", "style" to normalizeStyle(utsMapOf("right" to _ctx._dotOffset)), "onClik" to withModifiers(fun(){}, utsArrayOf(
                    "stop"
                ))), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "dotV", GenUniModulesTmxUiComponentsXSwiperXSwiperSlotDataDotV(current = _ctx.nowCureentIndex, len = _ctx.list.length), fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.list, fun(item, index, __index, _cached): Any {
                                return createElementVNode("view", utsMapOf("onClick" to withModifiers(fun(){
                                    _ctx.dotClick(index)
                                }, utsArrayOf(
                                    "stop"
                                )), "key" to index, "class" to "xSwiperDotItemV", "style" to normalizeStyle(utsMapOf("height" to if (_ctx.nowCureentIndex == index) {
                                    (_ctx._dotSize * 3) + "px"
                                } else {
                                    _ctx._dotSize + "px"
                                }, "width" to (_ctx._dotSize + "px"), "backgroundColor" to if (_ctx.nowCureentIndex == index) {
                                    _ctx._dotActiveColor
                                } else {
                                    _ctx._dotColor
                                }, "transition-timing-function" to _ctx.animationFun))), null, 12, utsArrayOf(
                                    "onClick"
                                ))
                            }), 128)
                        )
                    })
                ), 44, utsArrayOf(
                    "onClik"
                ))
            } else {
                createCommentVNode("v-if", true)
            }
            ,
            if (isTrue(!_ctx.vertical && _ctx._showDot)) {
                createElementVNode("view", utsMapOf("key" to 1, "class" to "xSwiperDotH", "style" to normalizeStyle(utsMapOf("bottom" to _ctx._dotOffset))), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "dot", GenUniModulesTmxUiComponentsXSwiperXSwiperSlotDataDot(current = _ctx.nowCureentIndex, len = _ctx.list.length), fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.list, fun(_item, index, __index, _cached): Any {
                                return createElementVNode("view", utsMapOf("key" to index, "onClick" to withModifiers(fun(){
                                    _ctx.dotClick(index)
                                }, utsArrayOf(
                                    "stop"
                                )), "class" to "xSwiperDotItemH", "style" to normalizeStyle(utsMapOf("width" to if (_ctx.nowCureentIndex == index) {
                                    (_ctx._dotSize * 3) + "px"
                                } else {
                                    _ctx._dotSize + "px"
                                }, "height" to (_ctx._dotSize + "px"), "backgroundColor" to if (_ctx.nowCureentIndex == index) {
                                    _ctx._dotActiveColor
                                } else {
                                    _ctx._dotColor
                                }, "transition-timing-function" to _ctx.animationFun))), null, 12, utsArrayOf(
                                    "onClick"
                                ))
                            }), 128)
                        )
                    })
                ), 4)
            } else {
                createCommentVNode("v-if", true)
            }
        ), 44, utsArrayOf(
            "onTouchstart",
            "onTouchmove",
            "onTouchend",
            "onTouchcancel",
            "id"
        ))
    }
    open var modelValue: Number by `$props`
    open var width: String by `$props`
    open var height: String by `$props`
    open var threshold: Number by `$props`
    open var damping: Number by `$props`
    open var animationDuration: Number by `$props`
    open var spaceOffset: Number by `$props`
    open var space: Number by `$props`
    open var model: String by `$props`
    open var animationFun: String by `$props`
    open var duration: Number by `$props`
    open var vertical: Boolean by `$props`
    open var round: String by `$props`
    open var dotColor: String by `$props`
    open var dotActiveColor: String by `$props`
    open var dotOffset: String by `$props`
    open var dotSize: String by `$props`
    open var showDot: Boolean by `$props`
    open var autoPlay: Boolean by `$props`
    open var showScalAni: Boolean by `$props`
    open var id: String by `$data`
    open var parentId: String by `$data`
    open var status: String by `$data`
    open var dirs: DICR by `$data`
    open var swiperTouchMove: POSITON by `$data`
    open var touchStartPos: POSITON by `$data`
    open var nowPos: POSITON by `$data`
    open var nowCureentIndex: Number by `$data`
    open var isMoveing: Boolean by `$data`
    open var swiperDiff: Number by `$data`
    open var containerSize: SIZE by `$data`
    open var list: UTSArray<SWIPER_ITEM> by `$data`
    open var startLeft: Number by `$data`
    open var startTop: Number by `$data`
    open var tid: Number by `$data`
    open var isResert: Boolean by `$data`
    open var resizeObserver: UniResizeObserver? by `$data`
    open var dateIdff: Number by `$data`
    open var key: Number by `$data`
    open var tid2: Number by `$data`
    open var isLastingAniMoveing: Boolean by `$data`
    open var _height: String by `$data`
    open var _width: String by `$data`
    open var _round: String by `$data`
    open var _dotColor: String by `$data`
    open var _dotActiveColor: String by `$data`
    open var _dotOffset: String by `$data`
    open var _autoPlay: Boolean by `$data`
    open var _dotSize: Number by `$data`
    open var _showScalAni: Boolean by `$data`
    open var boxHeight: Number by `$data`
    open var boxWidth: Number by `$data`
    open var _modelValue: Number by `$data`
    open var _showDot: Boolean by `$data`
    open var _containerSizeHeight: Number by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("id" to ("xSwiperItem-" + getUid()) as String, "parentId" to ("xSwiperParent-" + getUid()) as String, "status" to "runing" as String, "dirs" to "none" as DICR, "swiperTouchMove" to POSITON(x = 0, y = 0), "touchStartPos" to POSITON(x = 0, y = 0), "nowPos" to POSITON(x = 0, y = 0), "nowCureentIndex" to 0, "isMoveing" to false, "swiperDiff" to 0, "containerSize" to SIZE(width = 0, height = 0), "list" to utsArrayOf<SWIPER_ITEM>(), "startLeft" to 0, "startTop" to 0, "tid" to 0, "isResert" to false, "resizeObserver" to null as UniResizeObserver?, "dateIdff" to 0, "key" to 1, "tid2" to 12, "isLastingAniMoveing" to false, "_height" to computed<String>(fun(): String {
            return checkIsCssUnit(this.height, xConfig.unit)
        }
        ), "_width" to computed<String>(fun(): String {
            return checkIsCssUnit(this.width, xConfig.unit)
        }
        ), "_round" to computed<String>(fun(): String {
            return checkIsCssUnit(this.round, xConfig.unit)
        }
        ), "_dotColor" to computed<String>(fun(): String {
            return getDefaultColor(this.dotColor)
        }
        ), "_dotActiveColor" to computed<String>(fun(): String {
            return getDefaultColor(this.dotActiveColor)
        }
        ), "_dotOffset" to computed<String>(fun(): String {
            return checkIsCssUnit(this.dotOffset, xConfig.unit)
        }
        ), "_autoPlay" to computed<Boolean>(fun(): Boolean {
            return this.autoPlay
        }
        ), "_dotSize" to computed<Number>(fun(): Number {
            var p = parseInt(this.dotSize)
            if (this.dotSize.lastIndexOf("rpx") > -1) {
                p = rpx2px(p)
            }
            return Math.floor(p)
        }
        ), "_showScalAni" to computed<Boolean>(fun(): Boolean {
            return this.showScalAni
        }
        ), "boxHeight" to computed<Number>(fun(): Number {
            if (!this.vertical) {
                return this.containerSize.height
            }
            return this.containerSize.height * this.list.length
        }
        ), "boxWidth" to computed<Number>(fun(): Number {
            if (this.vertical) {
                return this.containerSize.width
            }
            return this.containerSize.width * this.list.length
        }
        ), "_modelValue" to computed<Number>(fun(): Number {
            return this.modelValue
        }
        ), "_showDot" to computed<Boolean>(fun(): Boolean {
            return this.showDot
        }
        ), "_containerSizeHeight" to computed<Number>(fun(): Number {
            return this.containerSize.height
        }
        ))
    }
    open var pause = ::gen_pause_fn
    open fun gen_pause_fn() {
        this.status = "pause"
        clearInterval(this.tid)
    }
    open var pauseInStart = ::gen_pauseInStart_fn
    open fun gen_pauseInStart_fn() {
        this.init(false)
    }
    open var resize = ::gen_resize_fn
    open fun gen_resize_fn() {
        var t = this
        var ele = uni_getElementById(this.parentId!!)
        if (this.resizeObserver == null) {
            this.resizeObserver = UniResizeObserver(fun(entries: UTSArray<UniResizeObserverEntry>){
                entries.forEach(fun(entry){
                    if (entry.target == ele) {
                        t.pause()
                        t.getNodeInfo()
                    }
                }
                )
            }
            )
        }
    }
    open var init = ::gen_init_fn
    open fun gen_init_fn(isDefault: Boolean) {
        if (this.containerSize.width == 0) {
            return
        }
        var t = this
        clearInterval(this.tid)
        this.status = "pause"
        if (isDefault) {
            t.nowCureentIndex = Math.max(0, Math.min(this.list.length - 1, this.modelValue))
        }
        var post = this.getLeftByPage(this.nowCureentIndex)
        this.pushArrayChildrenList(this.nowCureentIndex, -1)
        this.setStylePos(post, true)
        if (!this._autoPlay) {
            return
        }
        this.tid = setInterval(fun(){
            var pgs = t.nowCureentIndex + (if (t.isResert) {
                -1
            } else {
                1
            }
            )
            pgs = Math.max(0, pgs)
            var anima = true
            if (pgs >= this.list.length) {
                pgs = 0
                this.isLastingAniMoveing = true
            }
            t.nowCureentIndex = pgs
            var pos = t.getLeftByPage(pgs)
            t.setStylePos(pos, anima)
            t.status = "runing"
            t.pushArrayChildrenList(t.nowCureentIndex, -1)
            t.updateEvents(pgs)
            t.gerRestHeight()
        }
        , this.duration)
    }
    open var updateEvents = ::gen_updateEvents_fn
    open fun gen_updateEvents_fn(index: Number) {
        if (index == this.nowCureentIndex) {
            return
        }
        this.`$emit`("change", index)
        this.`$emit`("update:modelValue", index)
    }
    open var pushAdd = ::gen_pushAdd_fn
    open fun gen_pushAdd_fn(item: SWIPER_ITEM) {
        this.list.push(item)
        this.pushArrayChildrenComs()
        this.init(true)
    }
    open var delItem = ::gen_delItem_fn
    open fun gen_delItem_fn(id: String) {
        if (this.list.length == 0) {
            return
        }
        var index: Number = this.list.findIndex(fun(el: SWIPER_ITEM): Boolean {
            return el.id == id
        }
        )
        if (index > -1) {
            this.list.splice(index, 1)
        }
        this.nowCureentIndex = 0
        this.pushArrayChildrenList(this.nowCureentIndex, -1)
        this.init(false)
    }
    open var pushArrayChildrenComs = ::gen_pushArrayChildrenComs_fn
    open fun gen_pushArrayChildrenComs_fn() {
        if (this.list.length == 0) {
            return
        }
        this.list.forEach(fun(el: SWIPER_ITEM){
            el.ele.setConfig(this.containerSize)
        }
        )
    }
    open var pushArrayChildrenList = ::gen_pushArrayChildrenList_fn
    open fun gen_pushArrayChildrenList_fn(currentIndex: Number, nextindex: Number) {
        if (this.list.length == 0) {
            return
        }
        try {
            var ids = this.list.map(fun(el: SWIPER_ITEM): String {
                return el.id
            }
            )
            var nowid = this.list[currentIndex].id
            var t = this
            this.list.forEach(fun(el: SWIPER_ITEM){
                el.ele.setList(ids, nowid)
                if (nextindex > -1) {
                    var nextid = t.list[nextindex].id
                    el.ele.setNextOrNext(nextid)
                }
            }
            )
        }
         catch (e: Throwable) {}
    }
    open var getNodeInfo = ::gen_getNodeInfo_fn
    open fun gen_getNodeInfo_fn() {
        var t = this
        uni_createSelectorQuery().`in`(t).select(".xSwiper").boundingClientRect().exec(fun(ret){
            var nodeinfo = ret[0] as NodeInfo
            t.containerSize.width = nodeinfo.width!!
            t.containerSize.height = nodeinfo.height!!
            t.pushArrayChildrenComs()
            t.init(true)
            t.key = t.key + 1
        }
        )
    }
    open var getNodeInfoNoInt = ::gen_getNodeInfoNoInt_fn
    open fun gen_getNodeInfoNoInt_fn() {
        var t = this
        uni_createSelectorQuery().`in`(t).select(".xSwiper").boundingClientRect().exec(fun(ret){
            var nodeinfo = ret[0] as NodeInfo
            t.containerSize.width = nodeinfo.width!!
            t.containerSize.height = nodeinfo.height!!
            t.pushArrayChildrenComs()
        }
        )
    }
    open var dotClick = ::gen_dotClick_fn
    open fun gen_dotClick_fn(index: Number) {
        if (index != this.nowCureentIndex) {
            this.updateEvents(index)
        }
        this.nowCureentIndex = index
        this.pause()
        this.setStylePos(this.getLeftByPage(index), true)
        this.pauseInStart()
    }
    open var getLeftByPage = ::gen_getLeftByPage_fn
    open fun gen_getLeftByPage_fn(page: Number): Number {
        var pg = Math.max(0, Math.min(this.list.length - 1, page))
        if (this.vertical) {
            return pg * this.containerSize.height * -1
        }
        return pg * this.containerSize.width * -1
    }
    open var setStylePos = ::gen_setStylePos_fn
    open fun gen_setStylePos_fn(pos: Number, isAni: Boolean) {
        var node = uni_getElementById(this.id) as UniElement?
        if (node == null) {
            return
        }
        if (isAni && this.isLastingAniMoveing == false) {
            node!!.style.setProperty("transition-duration", this.animationDuration + "ms")
        } else {
            node!!.style.setProperty("transition-duration", "0ms")
        }
        if (this.vertical) {
            node!!.style.setProperty("transform", "translateY(" + pos + "px)")
            this.startTop = pos
        } else {
            node!!.style.setProperty("transform", "translateX(" + pos + "px)")
            this.startLeft = pos
        }
        this.isLastingAniMoveing = false
    }
    open var translateStart = ::gen_translateStart_fn
    open fun gen_translateStart_fn(x: Number, y: Number): UTSPromise<Any> {
        return wrapUTSPromise(suspend w@{
                var node = this.`$refs`["xSwiperWrap"] as UniElement
                var parentNode = this.`$refs`["xSwiper"] as UniElement
                var left: Number = 0
                var top: Number = 0
                var rect = parentNode.getBoundingClientRect()
                left = rect.left
                top = rect.top
                var pos = POSITON(x = x, y = y)
                this.touchStartPos = pos
                this.swiperTouchMove = POSITON(x = x - left, y = y - top)
                node.style.setProperty("transition-duration", "0ms")
                return@w UTSPromise.resolve(true)
        })
    }
    open var getDICT = ::gen_getDICT_fn
    open fun gen_getDICT_fn(x: Number, y: Number): DICR {
        if (x == y && x == 0) {
            return "none"
        }
        var dicr: DICR = "none"
        if (Math.abs(x) >= Math.abs(y)) {
            if (x > 0) {
                dicr = "left"
            } else {
                dicr = "right"
            }
        }
        if (Math.abs(x) < Math.abs(y)) {
            if (y > 0) {
                dicr = "up"
            } else {
                dicr = "bottom"
            }
        }
        return dicr
    }
    open var getPageByX = ::gen_getPageByX_fn
    open fun gen_getPageByX_fn(x: Number, y: Number, realLeftx: Number): Number {
        var maxwidth = this.containerSize.width * (this.list.length - 1)
        var minwidth: Number = 0
        if (realLeftx > minwidth) {
            return 0
        } else if (this.nowPos.x < maxwidth * -1) {
            return this.list.length - 1
        }
        var page = Math.floor(Math.abs(realLeftx) / this.containerSize.width)
        page = Math.max(0, Math.min(page, this.list.length - 1))
        if (this.nowCureentIndex == page) {
            var diffx = x - this.touchStartPos.x
            var diffy = y - this.touchStartPos.x
            var dirc = this.getDICT(diffx, diffy)
            if (x > 0 && Math.abs(diffx) > this.threshold) {
                page += 1
            } else if (x < 0 && Math.abs(diffx) > this.threshold) {
                page -= 1
            }
        }
        page = Math.max(0, Math.min(page, this.list.length - 1))
        return page
    }
    open var getPageByY = ::gen_getPageByY_fn
    open fun gen_getPageByY_fn(x: Number, y: Number, realLeftx: Number): Number {
        var maxwidth = this.containerSize.height * (this.list.length - 1)
        var minwidth: Number = 0
        if (realLeftx > minwidth) {
            return 0
        } else if (this.nowPos.x < maxwidth * -1) {
            return this.list.length - 1
        }
        var page = Math.floor(Math.abs(realLeftx) / this.containerSize.height)
        page = Math.max(0, Math.min(page, this.list.length - 1))
        if (this.nowCureentIndex == page) {
            var diffx = x - this.touchStartPos.x
            var diffy = y - this.touchStartPos.x
            var dirc = this.getDICT(diffx, diffy)
            if (y > 0 && Math.abs(diffy) > this.threshold) {
                page += 1
            } else if (y < 0 && Math.abs(diffy) > this.threshold) {
                page -= 1
            }
        }
        page = Math.max(0, Math.min(page, this.list.length - 1))
        return page
    }
    open var setHorizontalSwiper = ::gen_setHorizontalSwiper_fn
    open fun gen_setHorizontalSwiper_fn(x: Number, y: Number) {
        var node = this.`$refs`["xSwiperWrap"] as UniElement
        var maxwidth = this.containerSize.width * (this.list.length - 1)
        var diff_x = this.touchStartPos.x - x
        var _x = -diff_x + this.startLeft
        if (_x > 0) {
            _x = _x * this.damping
        }
        if (_x < maxwidth * -1 && _x < 0) {
            val maxPullValue = maxwidth * -1
            val decayRate = 1 - this.damping
            _x = _x + (maxPullValue - _x) * decayRate
        }
        node.style.setProperty("transform", "translateX(" + _x + "px)")
        this.nowPos.x = _x
    }
    open var setVerticalSwiper = ::gen_setVerticalSwiper_fn
    open fun gen_setVerticalSwiper_fn(x: Number, y: Number) {
        var node = this.`$refs`["xSwiperWrap"] as UniElement
        var maxheight = this.containerSize.height * (this.list.length - 1)
        var diff_x = this.touchStartPos.x - x
        var diff_y = this.touchStartPos.y - y
        var dirc: DICR = this.getDICT(diff_x, diff_y)
        var _x = -diff_x + this.startLeft
        var _y = -diff_y + this.startTop
        if (_y > 0) {
            _y = _y * this.damping
        }
        if (_y < maxheight * -1 && _y < 0) {
            val maxPullValue = maxheight * -1
            val decayRate = 1 - this.damping
            _y = _y + (maxPullValue - _y) * decayRate
        }
        node.style.setProperty("transform", "translateY(" + _y + "px)")
        this.nowPos.y = _y
    }
    open var setHorizontalSwiperMend = ::gen_setHorizontalSwiperMend_fn
    open fun gen_setHorizontalSwiperMend_fn(x: Number, y: Number) {
        var page = this.getPageByX(x, y, this.nowPos.x)
        var diffx = x - this.touchStartPos.x
        var diffy = y - this.touchStartPos.y
        if (this.nowCureentIndex == page && page != 0) {
            page = 0
            this.isLastingAniMoveing = true
        }
        if (Math.abs(diffx) == Math.abs(diffy)) {
            page = this.nowCureentIndex
        } else {
            this.updateEvents(page)
        }
        this.nowCureentIndex = Math.abs(page)
        this.setStylePos(this.getLeftByPage(page), true)
        this.gerRestHeight()
    }
    open var gerRestHeight = ::gen_gerRestHeight_fn
    open fun gen_gerRestHeight_fn() {
        var t = this
        clearTimeout(this.tid2)
        t.tid2 = setTimeout(fun() {
            t.getNodeInfoNoInt()
        }
        , 300)
    }
    open var setVerticalSwiperMend = ::gen_setVerticalSwiperMend_fn
    open fun gen_setVerticalSwiperMend_fn(x: Number, y: Number) {
        var page = this.getPageByY(x, y, this.nowPos.y)
        var diffx = x - this.touchStartPos.x
        var diffy = y - this.touchStartPos.y
        if (Math.abs(diffx) == Math.abs(diffy)) {
            page = this.nowCureentIndex
        } else {
            this.updateEvents(page)
        }
        this.nowCureentIndex = Math.abs(page)
        this.setStylePos(this.getLeftByPage(page), true)
        this.updateEvents(page)
    }
    open var setSiperOnMoveCurrent = ::gen_setSiperOnMoveCurrent_fn
    open fun gen_setSiperOnMoveCurrent_fn(x: Number, y: Number) {
        var page: Number = 0
        if (this.vertical) {
            page = this.getPageByY(x, y, this.nowPos.x)
        } else {
            page = this.getPageByX(x, y, this.nowPos.x)
        }
        var nextpage = page
        var current = this.nowCureentIndex
        var diffpage = Math.abs(nextpage - current)
        if (diffpage > 1) {
            if (current > nextpage) {
                current = page
                nextpage = this.nowCureentIndex - 1
            } else {
                current = page
                nextpage = this.nowCureentIndex + 1
            }
        }
    }
    open var translateMove = ::gen_translateMove_fn
    open fun gen_translateMove_fn(x: Number, y: Number) {
        if (!this.vertical) {
            this.setHorizontalSwiper(x, y)
        } else {
            this.setVerticalSwiper(x, y)
        }
        this.setSiperOnMoveCurrent(x, y)
    }
    open var mStart = ::gen_mStart_fn
    open fun gen_mStart_fn(evt: UniTouchEvent) {
        this.dateIdff = Date.now()
        this.pause()
        evt.preventDefault()
        if (evt.changedTouches.length == 0) {
            return
        }
        this.translateStart(evt.changedTouches[0].clientX, evt.changedTouches[0].clientY)
    }
    open var mMove = ::gen_mMove_fn
    open fun gen_mMove_fn(evt: UniTouchEvent) {
        this.pause()
        evt.preventDefault()
        if (this.vertical) {
            evt.stopPropagation()
        }
        if (evt.changedTouches.length == 0) {
            return
        }
        this.translateMove(evt.changedTouches[0].clientX, evt.changedTouches[0].clientY)
    }
    open var swiperClick = ::gen_swiperClick_fn
    open fun gen_swiperClick_fn() {
        this.`$emit`("click", this.nowCureentIndex)
    }
    open var mEnd = ::gen_mEnd_fn
    open fun gen_mEnd_fn(evt: UniTouchEvent) {
        var diffdate = Date.now() - this.dateIdff
        var diffx = evt.changedTouches[0].clientX - this.touchStartPos.x
        var diffy = evt.changedTouches[0].clientY - this.touchStartPos.y
        if (Math.abs(diffx) == Math.abs(diffy) && diffx == 0 && diffdate > 50 && diffdate <= 250) {
            this.swiperClick()
        }
        clearTimeout(this.tid)
        var t = this
        if (this._autoPlay) {
            this.tid = setTimeout(fun() {
                t.pauseInStart()
            }
            , this.animationDuration)
        }
        if (!this.vertical) {
            this.setHorizontalSwiperMend(evt.changedTouches[0].clientX, evt.changedTouches[0].clientY)
        } else {
            this.setVerticalSwiperMend(evt.changedTouches[0].clientX, evt.changedTouches[0].clientY)
        }
        this.pushArrayChildrenList(t.nowCureentIndex, -1)
        this.isMoveing = false
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xSwiper" to padStyleMapOf(utsMapOf("transitionDuration" to "350ms", "transitionProperty" to "height", "transitionTimingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)", "position" to "relative", "overflow" to "hidden")), "xSwiperH" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row")), "xSwiperV" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column")), "xSwiperWrap" to padStyleMapOf(utsMapOf("display" to "flex", "transform" to "translate(0px)", "transitionProperty" to "transform", "transitionDuration" to "0ms", "position" to "relative", "overflow" to "hidden")), "xSwiperDotH" to padStyleMapOf(utsMapOf("position" to "absolute", "height" to 32, "width" to "100%", "display" to "flex", "flexDirection" to "row", "alignItems" to "flex-end", "justifyContent" to "center", "zIndex" to 9, "pointerEvents" to "none")), "xSwiperDotItemH" to padStyleMapOf(utsMapOf("width" to 6, "height" to 6, "marginTop" to 0, "marginRight" to 3, "marginBottom" to 0, "marginLeft" to 3, "transitionProperty" to "width", "transitionDuration" to "300ms", "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8)), "xSwiperDotV" to padStyleMapOf(utsMapOf("position" to "absolute", "height" to "100%", "width" to 30, "display" to "flex", "flexDirection" to "column", "alignItems" to "flex-end", "justifyContent" to "center", "zIndex" to 9, "pointerEvents" to "none")), "xSwiperDotItemV" to padStyleMapOf(utsMapOf("width" to 6, "height" to 6, "marginTop" to 5, "marginRight" to "0rpx", "marginBottom" to 5, "marginLeft" to "0rpx", "transitionProperty" to "height", "transitionDuration" to "300ms", "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "zIndex" to 9)), "@TRANSITION" to utsMapOf("xSwiper" to utsMapOf("duration" to "350ms", "property" to "height", "timingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)"), "xSwiperWrap" to utsMapOf("property" to "transform", "duration" to "0ms"), "xSwiperDotItemH" to utsMapOf("property" to "width", "duration" to "300ms"), "xSwiperDotItemV" to utsMapOf("property" to "height", "duration" to "300ms")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("change" to null, "click" to null, "update:modelValue" to null)
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "Number", "default" to 0), "width" to utsMapOf("type" to "String", "default" to "auto"), "height" to utsMapOf("type" to "String", "default" to "150"), "threshold" to utsMapOf("type" to "Number", "default" to 30), "damping" to utsMapOf("type" to "Number", "default" to 0.06), "animationDuration" to utsMapOf("type" to "Number", "default" to 500), "spaceOffset" to utsMapOf("type" to "Number", "default" to 0), "space" to utsMapOf("type" to "Number", "default" to 0), "model" to utsMapOf("type" to "String", "default" to ""), "animationFun" to utsMapOf("type" to "String", "default" to "cubic-bezier(0, 0.55, 0.45, 1)"), "duration" to utsMapOf("type" to "Number", "default" to 5000), "vertical" to utsMapOf("type" to "Boolean", "default" to false), "round" to utsMapOf("type" to "String", "default" to "10"), "dotColor" to utsMapOf("type" to "String", "default" to "rgba(255,255,255,0.5)"), "dotActiveColor" to utsMapOf("type" to "String", "default" to "rgba(255,255,255,1)"), "dotOffset" to utsMapOf("type" to "String", "default" to "15"), "dotSize" to utsMapOf("type" to "String", "default" to "6"), "showDot" to utsMapOf("type" to "Boolean", "default" to true), "autoPlay" to utsMapOf("type" to "Boolean", "default" to true), "showScalAni" to utsMapOf("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = utsArrayOf(
            "modelValue",
            "width",
            "height",
            "threshold",
            "damping",
            "animationDuration",
            "spaceOffset",
            "space",
            "model",
            "animationFun",
            "duration",
            "vertical",
            "round",
            "dotColor",
            "dotActiveColor",
            "dotOffset",
            "dotSize",
            "showDot",
            "autoPlay",
            "showScalAni"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
