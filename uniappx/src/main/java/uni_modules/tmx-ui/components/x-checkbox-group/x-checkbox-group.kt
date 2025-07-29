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
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenUniModulesTmxUiComponentsXCheckboxGroupXCheckboxGroup : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onBeforeUnmount(fun() {
            this.isDestroy = true
            clearTimeout(this.tid)
        }
        , __ins)
        onMounted(fun() {
            this.checkvaluelist = this.modelValue
            this.isDestroy = false
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newValue: UTSArray<String>) {
            var n = newValue.join("")
            var v = this.checkvaluelist.join("")
            if (n != v) {
                this.checkvaluelist = newValue
                this.setOldCheckboxValue()
                this.pushAllChildren()
            }
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return createElementVNode("view", utsMapOf("class" to "xCheckboxGroup", "style" to normalizeStyle(utsMapOf("flex-direction" to _ctx.direction))), utsArrayOf(
            renderSlot(_ctx.`$slots`, "default")
        ), 4)
    }
    open var modelValue: UTSArray<String> by `$props`
    open var direction: String by `$props`
    open var max: Number by `$props`
    open var oldvalueList: UTSArray<XCHECKBOX_LISTITEM_TYPE> by `$data`
    open var checkvaluelist: UTSArray<String> by `$data`
    open var tid: Number by `$data`
    open var isDestroy: Boolean by `$data`
    open var id: Any? by `$data`
    open var oldvalueList_ids: UTSArray<String> by `$data`
    open var _max: Number by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("oldvalueList" to utsArrayOf<XCHECKBOX_LISTITEM_TYPE>(), "checkvaluelist" to utsArrayOf<String>(), "tid" to 0, "isDestroy" to false, "id" to ("xCheckboxGroup-" + getUid()), "oldvalueList_ids" to computed<UTSArray<String>>(fun(): UTSArray<String> {
            return this.oldvalueList.map(fun(el: XCHECKBOX_LISTITEM_TYPE): String {
                return el.id
            }
            )
        }
        ), "_max" to computed<Number>(fun(): Number {
            return this.max
        }
        ))
    }
    open var addItem = ::gen_addItem_fn
    open fun gen_addItem_fn(t: XCheckboxComponentPublicInstance, item: CHECKBOX_ITEM_INFO, ischange: Boolean) {
        var _this = this
        var index = this.oldvalueList.findIndex(fun(el: XCHECKBOX_LISTITEM_TYPE): Boolean {
            return el.id == item.id
        }
        )
        var nowitem = item
        var fl = this.oldvalueList.filter(fun(el: XCHECKBOX_LISTITEM_TYPE): Boolean {
            return el.data.nowvalue == el.data.value
        }
        )
        if (!ischange) {
            if (this.checkvaluelist.includes(item.value) && item.nowvalue != item.value) {
                nowitem.nowvalue = nowitem.value
            }
        }
        if (index > -1) {
            var oldItem = this.oldvalueList[index]
            if (fl.length >= this._max && this._max > -1 && ischange && oldItem.data.nowvalue != oldItem.data.value) {
                uni_showToast(ShowToastOptions(title = "已是最大选择数量", icon = "none", mask = true))
                this.pushAllChildren()
                return
            }
            this.oldvalueList.splice(index, 1, XCHECKBOX_LISTITEM_TYPE(ele = t, id = nowitem.id, data = nowitem))
        } else {
            this.oldvalueList.push(XCHECKBOX_LISTITEM_TYPE(ele = t, id = nowitem.id, data = nowitem))
        }
        this.getcheckvaluelist()
        if (ischange) {
            this.`$emit`("update:modelValue", this.checkvaluelist)
            this.`$emit`("change", this.checkvaluelist)
        }
        clearTimeout(this.tid)
        this.tid = setTimeout(fun() {
            _this.pushAllChildren()
        }
        , 100)
    }
    open var setOldCheckboxValue = ::gen_setOldCheckboxValue_fn
    open fun gen_setOldCheckboxValue_fn() {
        this.oldvalueList.forEach(fun(item: XCHECKBOX_LISTITEM_TYPE){
            if (this.checkvaluelist.includes(item.data.value)) {
                item.data.nowvalue = item.data.value
            } else {
                item.data.nowvalue = item.data.unvalue
            }
        }
        )
    }
    open var getcheckvaluelist = ::gen_getcheckvaluelist_fn
    open fun gen_getcheckvaluelist_fn() {
        var fl = this.oldvalueList.filter(fun(el: XCHECKBOX_LISTITEM_TYPE): Boolean {
            return el.data.nowvalue == el.data.value
        }
        )
        var allfill = this.oldvalueList.map(fun(el: XCHECKBOX_LISTITEM_TYPE): String {
            return el.data.value
        }
        )
        var realValue = fl.map(fun(el: XCHECKBOX_LISTITEM_TYPE): String {
            return el.data.value
        }
        )
        var psdiff = this.checkvaluelist.filter(fun(el: String): Boolean {
            return !allfill.includes(el)
        }
        )
        this.checkvaluelist = realValue.concat(psdiff)
    }
    open var pushAllChildren = ::gen_pushAllChildren_fn
    open fun gen_pushAllChildren_fn() {
        if (this.isDestroy) {
            return
        }
        try {
            this.oldvalueList.forEach(fun(el: XCHECKBOX_LISTITEM_TYPE){
                el.ele.setSelected(this.checkvaluelist)
            }
            )
        }
         catch (e: Throwable) {}
    }
    companion object {
        var name = "xCheckboxGroup"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xCheckboxGroup" to padStyleMapOf(utsMapOf("display" to "flex", "flexWrap" to "wrap")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("change" to null, "update:modelValue" to null)
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "direction" to utsMapOf("type" to "String", "default" to "row"), "max" to utsMapOf("type" to "Number", "default" to -1)))
        var propsNeedCastKeys = utsArrayOf(
            "modelValue",
            "direction",
            "max"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
