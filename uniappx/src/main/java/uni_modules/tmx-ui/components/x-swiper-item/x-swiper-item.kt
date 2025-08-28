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
open class GenUniModulesTmxUiComponentsXSwiperItemXSwiperItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.pushDataToParent()
        }
        , __ins)
        onBeforeUnmount(fun() {
            this.removeSelf()
        }
        , __ins)
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", _uM("class" to "xSwiperItem", "onTouchstart" to _ctx.mStart, "onTouchmove" to _ctx.mMove, "onTouchend" to _ctx.mEnd, "onTouchcancel" to _ctx.mEnd, "style" to _nS(_uM("height" to _ctx._itemheight, "borderRadius" to _ctx._round, "width" to _ctx._styleOpts.width, "top" to ("" + _ctx._styleOpts.top), "left" to ("" + _ctx._styleOpts.left), "zIndex" to if (_ctx.isActive) {
            "8"
        } else {
            "1"
        }
        , "position" to if (_ctx.xSwiperModel == "card") {
            "absolute"
        } else {
            "relative"
        }
        ))), _uA(
            _cE("view", _uM("class" to "xSwiperItembox", "style" to _nS(_uM("width" to _ctx._styleOpts.width, "borderRadius" to _ctx._round))), _uA(
                _cE("view", _uM("class" to _nC(_uA(
                    _uA(
                        if (_ctx.xSwipershowScalAni) {
                            if ((_ctx.isActive || _ctx.isActiveNextOrPrev)) {
                                "xSwiperItemWrapSaniOn"
                            } else {
                                "xSwiperItemWrapSaniOff"
                            }
                        } else {
                            ""
                        }
                    ),
                    "xSwiperItemWrap"
                )), "style" to _nS(_uM("borderRadius" to _ctx._round))), _uA(
                    renderSlot(_ctx.`$slots`, "default")
                ), 6)
            ), 4)
        ), 44, _uA(
            "onTouchstart",
            "onTouchmove",
            "onTouchend",
            "onTouchcancel"
        ))
    }
    open var xSwiperDisabled: Boolean by `$inject`
    open var xSwiperRadius: String by `$inject`
    open var xSwipershowScalAni: Boolean by `$inject`
    open var xSwiperSpace: Number by `$inject`
    open var xSwiperSpaceOffset: Number by `$inject`
    open var xSwiperModel: String by `$inject`
    open var xSwiperViews: Number by `$inject`
    open var order: Number by `$props`
    open var round: String by `$props`
    open var id: String by `$data`
    open var containerSize: SIZE by `$data`
    open var list: UTSArray<String> by `$data`
    open var currentId: String by `$data`
    open var currentId_next: String by `$data`
    open var currentId_prev: String by `$data`
    open var moveShowCurrentIdByPrev: String by `$data`
    open var moveShowCurrentIdByNext: String by `$data`
    open var dateIdff: Number by `$data`
    open var _pos_x: Number by `$data`
    open var _pos_y: Number by `$data`
    open var isMoving: Boolean by `$data`
    open var isActive: Boolean by `$data`
    open var isActiveNextOrPrev: Boolean by `$data`
    open var isLastCildren: Boolean by `$data`
    open var isFirstCildren: Boolean by `$data`
    open var _xSwiperItemAlign: String by `$data`
    open var _itemLeft: Number by `$data`
    open var _itemRight: Number by `$data`
    open var itemwidth: Number by `$data`
    open var _styleOpts: itemstyletype by `$data`
    open var _itemheight: String by `$data`
    open var _round: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("id" to ("xSwiperItem-" + getUid()) as String, "containerSize" to SIZE(width = 0, height = 0), "list" to _uA<String>(), "currentId" to "", "currentId_next" to "", "currentId_prev" to "", "moveShowCurrentIdByPrev" to "", "moveShowCurrentIdByNext" to "", "dateIdff" to 0, "_pos_x" to 0, "_pos_y" to 0, "isMoving" to false, "isActive" to computed<Boolean>(fun(): Boolean {
            return this.currentId == this.id
        }
        ), "isActiveNextOrPrev" to computed<Boolean>(fun(): Boolean {
            return this.moveShowCurrentIdByNext == this.id || this.moveShowCurrentIdByPrev == this.id
        }
        ), "isLastCildren" to computed<Boolean>(fun(): Boolean {
            if (this.list.length == 0) {
                return true
            }
            var lstid = this.list[this.list.length - 1]
            return lstid == this.id
        }
        ), "isFirstCildren" to computed<Boolean>(fun(): Boolean {
            if (this.list.length == 0) {
                return true
            }
            var lstid = this.list[0]
            return lstid == this.id
        }
        ), "_xSwiperItemAlign" to computed<String>(fun(): String {
            var nowindex = this.list.findIndex(fun(el: String): Boolean {
                return el == this.currentId
            }
            )
            var selftindex = this.list.findIndex(fun(el: String): Boolean {
                return el == this.id
            }
            )
            if (this.xSwiperModel == "spaceOnly") {
                if (this.isActive && this.isLastCildren) {
                    return ""
                } else if (this.list[this.list.length - 2] == this.id && this.list[this.list.length - 1] == this.currentId) {
                    return "xSwiperItemAlign"
                }
            } else if (this.xSwiperModel == "space") {
                if (selftindex < nowindex || (selftindex == this.list.length - 1 && this.isActive)) {
                    return "xSwiperItemAlign"
                }
            }
            return ""
        }
        ), "_itemLeft" to computed<Number>(fun(): Number {
            if ((this.xSwiperModel != "space" && this.xSwiperModel != "spaceOnly") || this.list.length <= 1) {
                return 0
            }
            var nowindex = this.list.findIndex(fun(el: String): Boolean {
                return el == this.currentId
            }
            )
            var selftindex = this.list.findIndex(fun(el: String): Boolean {
                return el == this.id
            }
            )
            if (this.xSwiperModel == "spaceOnly") {
                if (this.isActive && this.isLastCildren) {
                    return this.xSwiperSpaceOffset + this.xSwiperSpace
                } else if (this.list[this.list.length - 2] == this.id && this.list[this.list.length - 1] == this.currentId) {
                    return this.xSwiperSpaceOffset
                } else if (this.isActive) {
                    return 0
                }
            } else if (this.xSwiperModel == "space") {
                if ((selftindex == 0 && this.isActive) || (selftindex == this.list.length - 1 && this.isActive)) {
                    return 0
                } else if (this.isActive) {
                    return this.xSwiperSpace + this.xSwiperSpaceOffset
                } else if (selftindex < nowindex) {
                    return this.xSwiperSpaceOffset
                } else if (selftindex > nowindex) {
                    return this.xSwiperSpaceOffset * -1
                }
            }
            return this.xSwiperSpaceOffset * -1
        }
        ), "_itemRight" to computed<Number>(fun(): Number {
            if ((this.xSwiperModel != "space" && this.xSwiperModel != "spaceOnly") || this.isFirstCildren || this.list.length <= 1) {
                return 0
            }
            if (this.isActive) {
            }
            return this.xSwiperSpaceOffset * -1
        }
        ), "itemwidth" to computed<Number>(fun(): Number {
            var nowindex = this.list.findIndex(fun(el: String): Boolean {
                return el == this.currentId
            }
            )
            var selftindex = this.list.findIndex(fun(el: String): Boolean {
                return el == this.id
            }
            )
            if ((this.xSwiperModel != "space" && this.xSwiperModel != "spaceOnly") || this.xSwiperSpace <= 1 || this.xSwiperSpaceOffset == 0) {
                return this.containerSize.width
            }
            if (this.isFirstCildren || this.isLastCildren) {
                return this.containerSize.width - this.xSwiperSpace - this.xSwiperSpaceOffset
            }
            if (this.xSwiperModel == "space") {
                if (selftindex == 0 || selftindex == this.list.length - 1) {
                    return this.containerSize.width - this.xSwiperSpace - this.xSwiperSpaceOffset
                } else if (this.isActive) {
                    return this.containerSize.width - this.xSwiperSpace * 2 - this.xSwiperSpaceOffset * 2
                }
            }
            return this.containerSize.width - this.xSwiperSpace - this.xSwiperSpaceOffset
        }
        ), "_styleOpts" to computed<itemstyletype>(fun(): itemstyletype {
            var nowindex = this.list.findIndex(fun(el: String): Boolean {
                return el == this.currentId
            }
            )
            var selftindex = this.list.findIndex(fun(el: String): Boolean {
                return el == this.id
            }
            )
            var space = this.xSwiperSpace + this.xSwiperSpaceOffset
            if (this.list.length <= 1 || (this.xSwiperModel != "space" && this.xSwiperModel != "spaceOnly" && this.xSwiperModel != "spaceIn" && this.xSwiperModel != "card")) {
                return itemstyletype(left = "0px", width = this.containerSize.width + "px", height = this.containerSize.height + "px", top = "0px")
            }
            var opts = itemstyletype(left = "0px", width = this.containerSize.width + "px", height = this.containerSize.height + "px", top = "0px")
            if (this.xSwiperModel == "space") {
                if (selftindex == nowindex) {
                    if (selftindex == 0) {
                        opts.left = "0px"
                        opts.width = (this.containerSize.width - space) + "px"
                    } else if (selftindex == this.list.length - 1) {
                        opts.left = space + "px"
                        opts.width = (this.containerSize.width - space) + "px"
                    } else {
                        opts.left = space + "px"
                        opts.width = (this.containerSize.width - space * 2) + "px"
                    }
                } else {
                    if (selftindex < nowindex) {
                        opts.left = this.xSwiperSpaceOffset + "px"
                    } else if (selftindex == 1) {
                        opts.left = this.xSwiperSpace + "px"
                    } else {
                        opts.left = space + this.xSwiperSpace + "px"
                    }
                }
            } else if (this.xSwiperModel == "spaceOnly") {
                if (selftindex == nowindex) {
                    if (selftindex == 0) {
                        opts.width = (this.containerSize.width - space) + "px"
                        opts.left = "0px"
                    } else if (selftindex == this.list.length - 1) {
                        opts.width = (this.containerSize.width - space) + "px"
                        opts.left = space + "px"
                    } else {
                        opts.width = (this.containerSize.width - space) + "px"
                        opts.left = "0px"
                    }
                } else {
                    if (selftindex < nowindex && selftindex == this.list.length - 2) {
                        opts.left = this.xSwiperSpaceOffset + "px"
                    } else {
                        opts.left = this.xSwiperSpace + "px"
                    }
                }
            } else if (this.xSwiperModel == "spaceIn") {
                if (selftindex == nowindex) {
                    if (selftindex == 0) {
                        opts.left = "0px"
                        opts.width = (this.containerSize.width - space) + "px"
                    } else if (selftindex == this.list.length - 1) {
                        opts.left = space + "px"
                        opts.width = (this.containerSize.width - space) + "px"
                    } else {
                        opts.left = space + "px"
                        opts.width = (this.containerSize.width - space * 2) + "px"
                    }
                } else {
                    if (selftindex < nowindex) {
                        opts.left = this.xSwiperSpaceOffset * 2 + "px"
                        opts.width = this.containerSize.width + "px"
                        opts.height = (this.containerSize.height - this.xSwiperSpace * 2) + "px"
                        opts.top = this.xSwiperSpace + "px"
                    } else {
                        opts.left = this.xSwiperSpaceOffset * -2 + "px"
                        opts.width = this.containerSize.width + "px"
                        opts.height = (this.containerSize.height - this.xSwiperSpace * 2) + "px"
                        opts.top = this.xSwiperSpace + "px"
                    }
                }
            } else if (this.xSwiperModel == "card") {
                if (selftindex == nowindex) {
                    if (selftindex == 0) {
                        opts.left = "0px"
                        opts.width = (this.containerSize.width - space) + "px"
                    } else if (selftindex == this.list.length - 1) {
                        opts.left = space + "px"
                        opts.width = (this.containerSize.width - space) + "px"
                    } else {
                        opts.left = "0px"
                        opts.width = (this.containerSize.width - space) + "px"
                    }
                } else {
                    if (selftindex < nowindex && selftindex == this.list.length - 2) {
                        opts.left = this.xSwiperSpaceOffset + "px"
                    } else {
                        opts.left = this.xSwiperSpaceOffset * -1 + "px"
                    }
                }
            }
            return opts
        }
        ), "_itemheight" to computed<String>(fun(): String {
            return this._styleOpts.height
        }
        ), "_round" to computed<String>(fun(): String {
            if (this.round == "") {
                return this.xSwiperRadius
            }
            return checkIsCssUnit(this.round, xConfig.unit)
        }
        ))
    }
    open var pushDataToParent = ::gen_pushDataToParent_fn
    open fun gen_pushDataToParent_fn() {
        var pelement = this.findParent(this)
        if (pelement == null) {
            return
        }
        var parent: XSwiperComponentPublicInstance = pelement as XSwiperComponentPublicInstance
        parent.pushAdd(SWIPER_ITEM(id = this.id, order = this.order, ele = this))
    }
    open var findParent = ::gen_findParent_fn
    open fun gen_findParent_fn(parent: VueComponent?): VueComponent? {
        if (parent == null) {
            return null
        }
        if (parent.`$parent` is XSwiperComponentPublicInstance) {
            return parent.`$parent`
        }
        var parents = this.findParent(parent.`$parent`)
        if (parents is XSwiperComponentPublicInstance) {
            return parents
        }
        return null
    }
    open var removeSelf = ::gen_removeSelf_fn
    open fun gen_removeSelf_fn() {
        var pelement = this.findParent(this)
        if (pelement == null) {
            return
        }
        var parent: XSwiperComponentPublicInstance = pelement as XSwiperComponentPublicInstance
        parent.delItem(this.id)
    }
    open var setConfig = ::gen_setConfig_fn
    open fun gen_setConfig_fn(size: SIZE) {
        this.containerSize = size
    }
    open var setList = ::gen_setList_fn
    open fun gen_setList_fn(ids: UTSArray<String>, currentId: String) {
        this.list = ids
        this.currentId = currentId
    }
    open var setNextOrNext = ::gen_setNextOrNext_fn
    open fun gen_setNextOrNext_fn(id: String) {
        this.moveShowCurrentIdByNext = id
    }
    open var setNextOrPrev = ::gen_setNextOrPrev_fn
    open fun gen_setNextOrPrev_fn(id: String) {
        this.moveShowCurrentIdByPrev = id
    }
    open var setCureentIdPrevAndNext = ::gen_setCureentIdPrevAndNext_fn
    open fun gen_setCureentIdPrevAndNext_fn(prevId: String, nextId: String) {
        this.currentId_next = nextId
        this.currentId_prev = prevId
    }
    open var mStart = ::gen_mStart_fn
    open fun gen_mStart_fn(evt: UniTouchEvent) {
        if (this.xSwiperDisabled) {
            return
        }
        this.dateIdff = Date.now()
        var pelement = this.findParent(this)
        if (pelement == null) {
            return
        }
        var parent: XSwiperComponentPublicInstance = pelement as XSwiperComponentPublicInstance
        this._pos_x = evt.touches[0].clientX
        this._pos_y = evt.touches[0].clientY
        parent.mStart(evt, this.order)
    }
    open var mMove = ::gen_mMove_fn
    open fun gen_mMove_fn(evt: UniTouchEvent) {
        if (this.xSwiperDisabled) {
            return
        }
        var pelement = this.findParent(this)
        if (pelement == null) {
            return
        }
        var parent: XSwiperComponentPublicInstance = pelement as XSwiperComponentPublicInstance
        parent.mMove(evt, this.order)
    }
    open var mEnd = ::gen_mEnd_fn
    open fun gen_mEnd_fn(evt: UniTouchEvent) {
        if (this.xSwiperDisabled) {
            return
        }
        var pelement = this.findParent(this)
        if (pelement == null) {
            return
        }
        var parent: XSwiperComponentPublicInstance = pelement as XSwiperComponentPublicInstance
        var diffdate = Date.now() - this.dateIdff
        var diffx = evt.changedTouches[0].clientX - this._pos_x
        var diffy = evt.changedTouches[0].clientY - this._pos_y
        if (Math.floor(Math.abs(diffx)) == Math.floor(Math.abs(diffy)) && diffx == 0 && diffdate > 50 && diffdate <= 250) {
            parent.swiperClick(this.order)
            this.`$emit`("click")
        }
        if (Math.floor(Math.abs(diffx)) != Math.floor(Math.abs(diffy))) {
            parent.mEnd(evt, this.order)
        }
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xSwiperItem" to _pS(_uM("display" to "flex", "flexDirection" to "row", "transitionDuration" to "350ms", "transitionProperty" to "opacity,transform,left,margin,top,width", "transitionTimingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)")), "xSwiperItemAlign" to _pS(_uM("justifyContent" to "flex-end")), "xSwiperItembox" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "height" to "100%", "transitionDuration" to "350ms", "transitionProperty" to "width", "transitionTimingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)", "overflow" to "hidden")), "xSwiperItemWrapSaniOn" to _pS(_uM("transform" to "scale(1)", "opacity" to 1)), "xSwiperItemWrapSaniOff" to _pS(_uM("transform" to "scale(0)", "opacity" to 0)), "xSwiperItemOn" to _pS(_uM("zIndex" to 6)), "xSwiperItemWrapSaniDiffOff_left" to _pS(_uM("zIndex" to 2)), "xSwiperItemWrapSaniDiffOff_right" to _pS(_uM("zIndex" to 2)), "xSwiperItemWrap" to _pS(_uM("flex" to 1, "height" to "100%", "width" to "100%", "transitionDuration" to "600ms", "transitionProperty" to "opacity,transform,left,margin", "transitionTimingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)")), "@TRANSITION" to _uM("xSwiperItem" to _uM("duration" to "350ms", "property" to "opacity,transform,left,margin,top,width", "timingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)"), "xSwiperItembox" to _uM("duration" to "350ms", "property" to "width", "timingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)"), "xSwiperItemWrap" to _uM("duration" to "600ms", "property" to "opacity,transform,left,margin", "timingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM("xSwiperDisabled" to _uM("default" to false, "type" to "Boolean"), "xSwiperRadius" to _uM("default" to "0px", "type" to "String"), "xSwipershowScalAni" to _uM("default" to false, "type" to "Boolean"), "xSwiperSpace" to _uM("default" to 0, "type" to "Number"), "xSwiperSpaceOffset" to _uM("default" to 0, "type" to "Number"), "xSwiperModel" to _uM("default" to "", "type" to "String"), "xSwiperViews" to _uM("default" to 1, "type" to "Number"))
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM("order" to _uM("type" to "Number", "default" to -1, "required" to true), "round" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "order",
            "round"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
