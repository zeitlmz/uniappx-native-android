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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import uts.sdk.modules.xVibrateS.vibrator
open class GenUniModulesTmxUiComponentsXDragXDrag : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        provide("XDRAGE_HEIGHT", checkIsCssUnit(this.itemHeight, xConfig.unit))
        provide("XDRAGE_COL", this.col)
        provide("XDRAGE_MAX_LEN", this.list.length)
        onMounted(fun() {
            this.oldList = this.list.slice(0)
            this.getXdrageDomRect()
        }
        , __ins)
        onUpdated(fun() {
            this.getXdrageDomRect()
        }
        , __ins)
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return createElementVNode("view", utsMapOf("class" to "xDrag", "ref" to "xDrag", "onLongpress" to _ctx.mStart, "onTouchmove" to withModifiers(_ctx.mMove, utsArrayOf(
            "stop"
        )), "onTouchend" to _ctx.mEnd, "onTouchcancel" to _ctx.mEnd, "style" to normalizeStyle(utsMapOf("height" to (_ctx._totalHeight + "px")))), utsArrayOf(
            renderSlot(_ctx.`$slots`, "default")
        ), 44, utsArrayOf(
            "onLongpress",
            "onTouchmove",
            "onTouchend",
            "onTouchcancel"
        ))
    }
    open var itemHeight: String by `$props`
    open var col: Number by `$props`
    open var list: UTSArray<UTSJSONObject> by `$props`
    open var scrollDiff: Number by `$props`
    open var domlist: UTSArray<CHILDREN_INFO> by `$data`
    open var backckList: UTSArray<String> by `$data`
    open var oldList: UTSArray<UTSJSONObject> by `$data`
    open var activeIndex: Number by `$data`
    open var targetIndex: Number by `$data`
    open var cellHeight: Number by `$data`
    open var cellWidth: Number by `$data`
    open var isMoveing: Boolean by `$data`
    open var _x: Number by `$data`
    open var _y: Number by `$data`
    open var tid: Number by `$data`
    open var oragie_x: Number by `$data`
    open var oragie_y: Number by `$data`
    open var scrollDiffTopJuli: Number by `$data`
    open var tid2: Number by `$data`
    open var oldStartXy: POSITION by `$data`
    open var xdragRect: XDRAG_DOMRECT by `$data`
    open var _rows: Number by `$data`
    open var _cols: Number by `$data`
    open var _totalHeight: Number by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("domlist" to utsArrayOf<CHILDREN_INFO>(), "backckList" to utsArrayOf<String>(), "oldList" to utsArrayOf<UTSJSONObject>(), "activeIndex" to -1, "targetIndex" to -1, "cellHeight" to 0, "cellWidth" to 0, "isMoveing" to false, "_x" to 0, "_y" to 0, "tid" to 0, "oragie_x" to 0, "oragie_y" to 0, "scrollDiffTopJuli" to 0, "tid2" to 12, "oldStartXy" to POSITION(col = 0, row = 0, index = 0), "xdragRect" to XDRAG_DOMRECT(width = 0, height = 0, left = 0, top = 0, right = 0, bottom = 0), "_rows" to computed<Number>(fun(): Number {
            var row = Math.ceil(this.domlist.length / this.col)
            return row
        }
        ), "_cols" to computed<Number>(fun(): Number {
            return this.col
        }
        ), "_totalHeight" to computed<Number>(fun(): Number {
            return this._rows * this.cellHeight
        }
        ))
    }
    open var updataResize = ::gen_updataResize_fn
    open fun gen_updataResize_fn(resize: CHILDREN_SIZE) {
        this.cellHeight = resize.height
        this.cellWidth = resize.width
    }
    open var addItem = ::gen_addItem_fn
    open fun gen_addItem_fn(item: CHILDREN_INFO) {
        var index = this.domlist.findIndex(fun(el: CHILDREN_INFO): Boolean {
            return el.id == item.id
        }
        )
        if (index > -1) {
            this.domlist.splice(index, 1, item)
        } else {
            this.domlist.push(item)
        }
        this.cellHeight = item.node.height!!
        this.cellWidth = item.node.width!!
    }
    open var delItem = ::gen_delItem_fn
    open fun gen_delItem_fn(id: String) {
        var index = this.domlist.findIndex(fun(el: CHILDREN_INFO): Boolean {
            return el.id == id
        }
        )
        if (index > -1) {
            this.domlist.splice(index, 1)
        }
    }
    open var indexTransformer = ::gen_indexTransformer_fn
    open fun gen_indexTransformer_fn(originalIndex: Number): Number {
        var detail = this.targetIndex - this.activeIndex
        if (detail > 0) {
            return originalIndex - 1
        }
        return originalIndex + 1
    }
    open var getLastMaxCol = ::gen_getLastMaxCol_fn
    open fun gen_getLastMaxCol_fn(): Number {
        val totalRows = Math.ceil(this.domlist.length / this.col)
        val lastRowColumns = this.domlist.length % this.col
        return if (lastRowColumns === 0) {
            this.col
        } else {
            lastRowColumns
        }
    }
    open var coverXy = ::gen_coverXy_fn
    open fun gen_coverXy_fn(x: Number, y: Number): POSITION {
        var maxRow = Math.floor((this.domlist.length - 1) / this.col)
        var lastMacCol = this.getLastMaxCol()
        var el = this.`$refs`["xDrag"] as UniElement
        var bounce = this.xdragRect
        bounce = this.getByAppDomRect(el)
        var row = Math.floor((y - bounce.top!!) / this.cellHeight)
        var col = Math.floor((x - bounce.left!!) / this.cellWidth)
        row = Math.min(Math.max(0, row), maxRow)
        col = Math.min(Math.max(0, col), this.col - 1)
        var index = (row + 1) * this.col - (this.col - col)
        col = if (maxRow == row) {
            Math.min(lastMacCol - 1, col)
        } else {
            col
        }
        index = Math.min(Math.max(0, index), this.domlist.length - 1)
        return POSITION(row = row, col = col, index = index)
    }
    open var eventTransformer_start = ::gen_eventTransformer_start_fn
    open fun gen_eventTransformer_start_fn(evt: POSITION_XY) {
        var t = this
        if (t.domlist.length == 0) {
            return
        }
        this.backckList = this.domlist.map(fun(el): String {
            return el.id
        }
        )
        var x = evt.x
        var y = evt.y
        val startPos = this.coverXy(x, y)
        this.activeIndex = startPos.index
        this.targetIndex = this.activeIndex
        this.oldStartXy = startPos
        var childrenIndex = this.domlist.findIndex(fun(el): Boolean {
            return el.id == this.backckList[this.activeIndex]
        }
        )
        if (childrenIndex == -1) {
            return
        }
        var children = this.domlist[childrenIndex]!!
        var childrenEle = children!!.ele
        var childrenTop = parseFloat(childrenEle!!.getStylSetProperty("top") as String)
        var childrenLeft = parseFloat(childrenEle!!.getStylSetProperty("left") as String)
        childrenEle!!.setStylSetProperty("transition-duration", "0s")
        childrenEle!!.setStylSetProperty("z-index", "5")
        this._x = x - childrenLeft
        this._y = y - childrenTop
        run {
            var i: Number = 0
            while(i < t.backckList.length){
                var temdom = t.backckList[i]
                var elIndex = t.domlist.findIndex(fun(el): Boolean {
                    return el.id == temdom
                }
                )
                var el = t.domlist[elIndex]
                el.ele!!.setActivdId(children.id)
                i++
            }
        }
    }
    open var eventTransformer_move = ::gen_eventTransformer_move_fn
    open fun gen_eventTransformer_move_fn(evt: POSITION_XY) {
        var t = this
        if (t.domlist.length == 0 || t.backckList.length == 0) {
            return
        }
        var x = evt.x
        var y = evt.y
        var el = this.`$refs`["xDrag"] as UniElement
        var childrenIndex = t.domlist.findIndex(fun(el): Boolean {
            return el.id == t.backckList[t.activeIndex]
        }
        )
        if (childrenIndex == -1) {
            return
        }
        var children = t.domlist[childrenIndex]!!
        var childrenEle = children!!.ele
        var offsetY = y - t._y
        var offsetX = x - t._x
        childrenEle!!.setStylSetProperty("top", offsetY.toString(10) + "px")
        childrenEle!!.setStylSetProperty("left", offsetX.toString(10) + "px")
        childrenEle!!.setStylSetProperty("transition-duration", "0s")
        childrenEle!!.setStylSetProperty("z-index", "5")
        var target = t.coverXy(x, y)
        var targetIndex = target.index
        var targetChildren = t.domlist[targetIndex]!!
        if (targetChildren.disabled) {
            return
        }
        if (targetIndex == t.activeIndex) {
            return
        }
        this.oldStartXy = target
        var backChildrent = t.backckList.slice(0)[t.activeIndex]
        var backTargChildren = t.backckList.slice(0)[targetIndex]
        t.targetIndex = targetIndex
        var backChildrent_model = t.oldList.slice(0)[t.activeIndex]
        var backTargChildren_model = t.oldList.slice(0)[t.targetIndex]
        t.backckList.splice(t.activeIndex, 1, backTargChildren)
        t.backckList.splice(t.targetIndex, 1, backChildrent)
        t.oldList.splice(t.activeIndex, 1, backTargChildren_model)
        t.oldList.splice(t.targetIndex, 1, backChildrent_model)
        run {
            var i: Number = 0
            while(i < t.backckList.length){
                var temdom = t.backckList[i]
                var elIndex = t.domlist.findIndex(fun(el): Boolean {
                    return el.id == temdom
                }
                )
                var el = t.domlist[elIndex]
                el.oldindex = el.index
                el.index = i
                el.ele!!.setOrderIndex(i)
                i++
            }
        }
        t.activeIndex = t.targetIndex
    }
    open var eventTransformer_end = ::gen_eventTransformer_end_fn
    open fun gen_eventTransformer_end_fn(evt: POSITION_XY) {
        var t = this
        if (t.domlist.length == 0 || t.backckList.length == 0) {
            return
        }
        var x = evt.x
        var y = evt.y
        var childrenIndex = t.domlist.findIndex(fun(el): Boolean {
            return el.id == t.backckList[t.activeIndex]
        }
        )
        if (childrenIndex == -1) {
            return
        }
        var children = t.domlist[childrenIndex]!!
        var childrenEle = children!!.ele
        var result = t.coverXy(x, y)
        var targetChildren = t.domlist[result.index]!!
        if (targetChildren.disabled) {
            result = this.oldStartXy
        }
        var col = result.col
        var row = result.row
        childrenEle!!.setStylSetProperty("top", (this.cellHeight * row) + "px")
        childrenEle!!.setStylSetProperty("left", (this.cellWidth * col) + "px")
        t.domlist.sort(fun(ela, elb): Number {
            return ela.index - elb.index
        }
        )
        run {
            var i: Number = 0
            while(i < t.domlist.length){
                var temdom = t.domlist[i]
                temdom.oldindex = temdom.index
                temdom.index = i
                temdom.ele!!.setOrderIndex(i)
                temdom.ele!!.setActivdId("")
                temdom.ele!!.updateForce()
                i++
            }
        }
        this.`$emit`("change", JSON.parseArray<UTSJSONObject>(JSON.stringify(this.oldList)!!)!!)
    }
    open var mStart = ::gen_mStart_fn
    open fun gen_mStart_fn(evt: UniTouchEvent) {
        var x = evt.changedTouches[0].clientX
        var y = evt.changedTouches[0].clientY
        this.oragie_x = x
        this.oragie_y = y
        var tempActiveIndex = this.coverXy(x, y).index
        if (tempActiveIndex == -1) {
            return
        }
        var children = this.domlist[tempActiveIndex]!!
        if (children.disabled) {
            return
        }
        this.getXdrageDomRect()
        this.scrollDiffTopJuli = 0
        clearTimeout(this.tid2)
        this.isMoveing = true
        vibrator(100)
        this.eventTransformer_start(POSITION_XY(x = x, y = y))
        this.`$emit`("start")
        evt.preventDefault()
        evt.stopPropagation()
    }
    open var getXdrageDomRect = ::gen_getXdrageDomRect_fn
    open fun gen_getXdrageDomRect_fn() {}
    open var getByAppDomRect = ::gen_getByAppDomRect_fn
    open fun gen_getByAppDomRect_fn(ele: UniElement): XDRAG_DOMRECT {
        var rect = XDRAG_DOMRECT(width = 0, height = 0, left = 0, right = 0, top = 0, bottom = 0)
        var res = ele.getBoundingClientRect()
        rect = XDRAG_DOMRECT(width = res.width, height = res.height, left = res.left, right = res.right, top = res.top, bottom = res.bottom)
        return rect
    }
    open var mMove = ::gen_mMove_fn
    open fun gen_mMove_fn(evt: UniTouchEvent) {
        if (!this.isMoveing || this.activeIndex == -1) {
            return
        }
        var x = evt.changedTouches[0].clientX + this.scrollDiffTopJuli
        var y = evt.changedTouches[0].clientY
        evt.preventDefault()
        evt.stopPropagation()
        this.eventTransformer_move(POSITION_XY(x = x, y = y))
        var el = this.`$refs`["xDrag"] as UniElement
        var bounce = this.xdragRect
        bounce = this.getByAppDomRect(el)
        var maxheight = uni_getWindowInfo().windowHeight
        var diffBottom = Math.abs(bounce.bottom - maxheight)
        var _this = this
        clearTimeout(_this.tid2)
        _this.tid2 = setTimeout(fun(){
            if (bounce.bottom - maxheight > 0 && diffBottom > 25) {
                this.`$emit`("move", _this.scrollDiff)
                _this.scrollDiffTopJuli += _this.scrollDiff
            } else if (bounce.top < 0 && Math.abs(bounce.top) > 25) {
                this.`$emit`("move", _this.scrollDiff * -1)
                _this.scrollDiffTopJuli -= _this.scrollDiff
            }
        }
        , 200)
    }
    open var mEnd = ::gen_mEnd_fn
    open fun gen_mEnd_fn(evt: UniTouchEvent) {
        this.scrollDiffTopJuli = 0
        clearTimeout(this.tid2)
        this.`$emit`("end")
        if (!this.isMoveing) {
            return
        }
        this.isMoveing = false
        var x = evt.changedTouches[0].clientX
        var y = evt.changedTouches[0].clientY
        this.eventTransformer_end(POSITION_XY(x = x, y = y))
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xDrag" to padStyleMapOf(utsMapOf("position" to "relative")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("change" to null, "move" to null, "end" to null, "start" to null)
        var props = normalizePropsOptions(utsMapOf("itemHeight" to utsMapOf("type" to "String", "default" to "50"), "col" to utsMapOf("type" to "Number", "default" to 1), "list" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<UTSJSONObject> {
            return utsArrayOf<UTSJSONObject>()
        }
        , "required" to true), "scrollDiff" to utsMapOf("type" to "Number", "default" to 25)))
        var propsNeedCastKeys = utsArrayOf(
            "itemHeight",
            "col",
            "list",
            "scrollDiff"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
