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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
open class GenUniModulesTmxUiComponentsXDragItemMcXDragItemMc : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.orderIndex = this.order
            var _this = this
            uni__on("onResize", this.getNodes)
            setTimeout(fun() {
                _this.getNodes()
            }
            , 50)
        }
        , __ins)
        onBeforeUnmount(fun() {
            var parent: XDragMcComponentPublicInstance? = null
            try {
                parent = this.`$parent` as XDragMcComponentPublicInstance
            }
             catch (e: Throwable) {}
            if (parent != null) {
                parent!!.delItem(this.id)
            }
            uni__off("onResize", this.getNodes)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.disabled
        }
        , fun() {
            this.getNodes()
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", _uM("onClick" to _ctx.onClick, "onTouchend" to _ctx.onTouchEnd, "ref" to "xDragItemMc", "class" to "xDragItemMc", "style" to _nS(_uM("top" to (_ctx._defaultTop + "px"), "left" to (_ctx._defaultLeft + "px"), "zIndex" to if (_ctx.nowId == _ctx.id && _ctx.nowId != "") {
            "5"
        } else {
            "1"
        }
        , "transitionDuration" to if (_ctx.nowId != _ctx.id && _ctx.nowId != "") {
            "0.4s"
        } else {
            "0s"
        }
        ))), _uA(
            renderSlot(_ctx.`$slots`, "default")
        ), 44, _uA(
            "onClick",
            "onTouchend"
        ))
    }
    open var order: Number by `$props`
    open var disabled: Boolean by `$props`
    open var id: String by `$data`
    open var cellHeight: Number by `$data`
    open var cellWidth: Number by `$data`
    open var nowActiveIndex: Number by `$data`
    open var targetActiveIndex: Number by `$data`
    open var orderIndex: Number by `$data`
    open var nowId: String by `$data`
    open var _defaultTop: Number by `$data`
    open var _defaultLeft: Number by `$data`
    open var _disabled: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("id" to ("xCollapseItem-" + getUid()) as String, "cellHeight" to 0, "cellWidth" to 0, "nowActiveIndex" to -1, "targetActiveIndex" to -1, "orderIndex" to -1, "nowId" to "", "_defaultTop" to computed<Number>(fun(): Number {
            var parent: XDragMcComponentPublicInstance? = null
            try {
                parent = this.`$parent` as XDragMcComponentPublicInstance
            }
             catch (e: Throwable) {
                return this.cellHeight * this.orderIndex
            }
            if (parent != null && UTSAndroid.`typeof`(parent.getTopOffsetByIndex) === "function") {
                return parent.getTopOffsetByIndex(this.orderIndex)
            } else {
                return this.cellHeight * this.orderIndex
            }
        }
        ), "_defaultLeft" to computed<Number>(fun(): Number {
            var colindex: Number = 0
            return this.cellWidth * colindex
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ))
    }
    open var onClick = ::gen_onClick_fn
    open fun gen_onClick_fn() {}
    open var onTouchEnd = ::gen_onTouchEnd_fn
    open fun gen_onTouchEnd_fn() {
        this.`$emit`("click")
    }
    open var getNodes = ::gen_getNodes_fn
    open fun gen_getNodes_fn() {
        var ele = this.`$refs`["xDragItemMc"] as UniElement?
        if (ele == null) {
            return
        }
        ele.getBoundingClientRectAsync()?.then(fun(rect){
            console.log("rect===\u300B", rect)
            this.cellHeight = rect.height!!
            this.cellWidth = rect.width!!
            this.pushChildren(rect)
            this.setStylSetProperty("height", this.cellHeight)
            this.setStylSetProperty("z-index", "1")
            this.setStylSetProperty("transition-duration", "0s")
        }
        )?.`catch`(fun(){})
    }
    open var pushChildren = ::gen_pushChildren_fn
    open fun gen_pushChildren_fn(node: DOMRect) {
        var parent: XDragMcComponentPublicInstance? = null
        try {
            parent = this.`$parent` as XDragMcComponentPublicInstance
        }
         catch (e: Throwable) {}
        if (parent != null) {
            parent!!.addItem(CHILDREN_INFO(id = this.id, index = this.order, oldindex = this.order, ele = this, disabled = this._disabled, node = node))
        }
    }
    open var updateForce = ::gen_updateForce_fn
    open fun gen_updateForce_fn() {
        this.`$forceUpdate`()
    }
    open var setOrderIndex = ::gen_setOrderIndex_fn
    open fun gen_setOrderIndex_fn(index: Number) {
        this.orderIndex = index
    }
    open var setActivdId = ::gen_setActivdId_fn
    open fun gen_setActivdId_fn(id: String) {
        this.nowId = id
    }
    open var setStylSetProperty = ::gen_setStylSetProperty_fn
    open fun gen_setStylSetProperty_fn(name: String, value: Any?) {
        var ele = this.`$refs`["xDragItemMc"] as UniElement
        ele.style.setProperty(name, value)
    }
    open var getStylSetProperty = ::gen_getStylSetProperty_fn
    open fun gen_getStylSetProperty_fn(name: String): Any? {
        var ele = this.`$refs`["xDragItemMc"] as UniElement
        return ele.style.getPropertyValue(name)
    }
    open var updatePos = ::gen_updatePos_fn
    open fun gen_updatePos_fn() {
        this.setStylSetProperty("height", this.cellHeight)
        this.setStylSetProperty("top", this._defaultTop + "px")
        this.setStylSetProperty("left", this._defaultLeft + "px")
        this.setStylSetProperty("transition-duration", "0.4s")
        this.setStylSetProperty("z-index", "1")
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xDragItemMc" to _pS(_uM("position" to "absolute", "left" to 0, "top" to 0, "width" to "100%", "transitionTimingFunction" to "ease", "transitionProperty" to "top,left", "zIndex" to 1)), "@TRANSITION" to _uM("xDragItemMc" to _uM("timingFunction" to "ease", "property" to "top,left")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM("order" to _uM("type" to "Number", "default" to 0, "required" to true), "disabled" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "order",
            "disabled"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
