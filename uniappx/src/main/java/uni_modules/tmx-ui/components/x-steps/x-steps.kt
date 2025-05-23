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
open class GenUniModulesTmxUiComponentsXStepsXSteps : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        provide("xsetpsIcon", this.icon)
        provide("xsetpsActiveIcon", this.activeIcon)
        provide("xsetpsiconSize", this.iconSize)
        provide("xsetpslabelSize", this.labelSize)
        provide("xsetpsdescSize", this.descSize)
        provide("xsetpsactiveColor", this.activeColor)
        provide("xsetpscolor", this.color)
        provide("xsetpsvertical", this._vertical)
        provide("xsetpsdisabled", this._disabled)
        onMounted(fun() {
            this.activeIndex = this.modelValue
            this.pushActive()
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newValue: Number) {
            if (newValue == this.activeIndex) {
                return
            }
            this.activeIndex = newValue
            this.pushActive()
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
            if (_ctx._vertical) {
                "xStepsV"
            } else {
                "xStepsH"
            }
        ))), utsArrayOf(
            renderSlot(_ctx.`$slots`, "default")
        ), 2)
    }
    open var modelValue: Number by `$props`
    open var icon: String by `$props`
    open var activeIcon: String by `$props`
    open var iconSize: String by `$props`
    open var labelSize: String by `$props`
    open var descSize: String by `$props`
    open var color: String by `$props`
    open var activeColor: String by `$props`
    open var vertical: Boolean by `$props`
    open var reverse: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var list: UTSArray<CHIDREN_ITEM1> by `$data`
    open var activeIndex: Number by `$data`
    open var _vertical: Boolean by `$data`
    open var _disabled: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("list" to utsArrayOf<CHIDREN_ITEM1>(), "activeIndex" to 0, "_vertical" to computed<Boolean>(fun(): Boolean {
            return this.vertical
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ))
    }
    open var addItem = ::gen_addItem_fn
    open fun gen_addItem_fn(item: CHIDREN_ITEM1) {
        var index = this.list.findIndex(fun(el: CHIDREN_ITEM1): Boolean {
            return el.id == item.id
        }
        )
        if (index > -1) {
            this.list.splice(index, 1, item)
        } else {
            this.list.push(item)
        }
        this.pushChildren()
        this.pushActive()
    }
    open var delItem = ::gen_delItem_fn
    open fun gen_delItem_fn(id: String) {
        var index = this.list.findIndex(fun(el: CHIDREN_ITEM1): Boolean {
            return el.id == id
        }
        )
        if (index > -1) {
            this.list.splice(index, 1)
        }
        this.pushChildren()
    }
    open var pushChildren = ::gen_pushChildren_fn
    open fun gen_pushChildren_fn() {
        var ids = this.list.map(fun(el: CHIDREN_ITEM1): String {
            return el.id
        }
        )
        this.list.forEach(fun(el: CHIDREN_ITEM1){
            el.ele.setList(ids)
        }
        )
    }
    open var pushActive = ::gen_pushActive_fn
    open fun gen_pushActive_fn() {
        if (this.reverse) {
            this.list.forEach(fun(el: CHIDREN_ITEM1, index: Number){
                val reverseIndex = this.list.length - 1 - index
                el.ele.setActive(reverseIndex <= (this.list.length - 1 - this.activeIndex))
            })
        } else {
            this.list.forEach(fun(el: CHIDREN_ITEM1, index: Number){
                el.ele.setActive(index <= this.activeIndex)
            }
            )
        }
    }
    open var addChange = ::gen_addChange_fn
    open fun gen_addChange_fn(id: String) {
        var index = this.list.findIndex(fun(el: CHIDREN_ITEM1): Boolean {
            return el.id == id
        }
        )
        if (index > -1) {
            this.activeIndex = index
        }
        this.pushActive()
        this.`$emit`("change", index)
        this.`$emit`("update:modelValue", index)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xStepsH" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "flex-start", "justifyContent" to "center")), "xStepsV" to padStyleMapOf(utsMapOf("display" to "flex")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("change" to null, "update:modelValue" to null)
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "Number", "default" to 0), "icon" to utsMapOf("type" to "String", "default" to "checkbox-blank-circle-fill"), "activeIcon" to utsMapOf("type" to "String", "default" to "checkbox-circle-fill"), "iconSize" to utsMapOf("type" to "String", "default" to "14"), "labelSize" to utsMapOf("type" to "String", "default" to "14"), "descSize" to utsMapOf("type" to "String", "default" to "11"), "color" to utsMapOf("type" to "String", "default" to "#333333"), "activeColor" to utsMapOf("type" to "String", "default" to ""), "vertical" to utsMapOf("type" to "Boolean", "default" to false), "reverse" to utsMapOf("type" to "Boolean", "default" to false), "disabled" to utsMapOf("type" to "Boolean", "default" to true)))
        var propsNeedCastKeys = utsArrayOf(
            "modelValue",
            "icon",
            "activeIcon",
            "iconSize",
            "labelSize",
            "descSize",
            "color",
            "activeColor",
            "vertical",
            "reverse",
            "disabled"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
