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
open class GenUniModulesTmxUiComponentsXRadioGroupXRadioGroup : VueComponent {
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
        , fun(newValue: String) {
            if (newValue != this.checkvaluelist) {
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
        return _cE("view", _uM("class" to "xRadioGroup", "style" to _nS(_uM("flex-direction" to _ctx.direction))), _uA(
            renderSlot(_ctx.`$slots`, "default")
        ), 4)
    }
    open var modelValue: String by `$props`
    open var direction: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var oldvalueList: UTSArray<XRADIO_LISTITEM_TYPE> by `$data`
    open var checkvaluelist: String by `$data`
    open var tid: Number by `$data`
    open var isDestroy: Boolean by `$data`
    open var id: Any? by `$data`
    open var oldvalueList_ids: UTSArray<String> by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "oldvalueList" to _uA<XRADIO_LISTITEM_TYPE>(), "checkvaluelist" to "", "tid" to 0, "isDestroy" to false, "id" to ("xRadioGroup-" + getUid()), "oldvalueList_ids" to computed<UTSArray<String>>(fun(): UTSArray<String> {
            return this.oldvalueList.map(fun(el: XRADIO_LISTITEM_TYPE): String {
                return el.id
            }
            )
        }
        ))
    }
    open var addItem = ::gen_addItem_fn
    open fun gen_addItem_fn(t: XRadioComponentPublicInstance, item: RADIO_ITEM_INFO, ischange: Boolean) {
        var index = this.oldvalueList.findIndex(fun(el: XRADIO_LISTITEM_TYPE): Boolean {
            return el.id == item.id
        }
        )
        var nowitem = item
        var _this = this
        this.clearAll()
        if (!ischange) {
            if (this.checkvaluelist == item.value && item.nowvalue != item.value) {
                nowitem.nowvalue = nowitem.value
            } else {
                nowitem.nowvalue = nowitem.unvalue
            }
        }
        if (index > -1) {
            this.oldvalueList.splice(index, 1, XRADIO_LISTITEM_TYPE(ele = t, id = nowitem.id, data = nowitem))
        } else {
            this.oldvalueList.push(XRADIO_LISTITEM_TYPE(ele = t, id = nowitem.id, data = nowitem))
        }
        if (ischange) {
            var fl = this.oldvalueList.filter(fun(el: XRADIO_LISTITEM_TYPE): Boolean {
                return el.data.nowvalue == el.data.value
            }
            )
            this.checkvaluelist = if (fl.length == 1) {
                fl[0].data.value
            } else {
                ""
            }
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
        this.oldvalueList.forEach(fun(item: XRADIO_LISTITEM_TYPE){
            if (this.checkvaluelist == item.data.value) {
                item.data.nowvalue = item.data.value
            } else {
                item.data.nowvalue = item.data.unvalue
            }
        }
        )
    }
    open var clearAll = ::gen_clearAll_fn
    open fun gen_clearAll_fn() {
        this.oldvalueList.forEach(fun(item: XRADIO_LISTITEM_TYPE){
            item.data.nowvalue = item.data.unvalue
        }
        )
    }
    open var pushAllChildren = ::gen_pushAllChildren_fn
    open fun gen_pushAllChildren_fn() {
        if (this.isDestroy) {
            return
        }
        try {
            this.oldvalueList.forEach(fun(el: XRADIO_LISTITEM_TYPE){
                el.ele.setSelected(this.checkvaluelist)
            }
            )
        }
         catch (e: Throwable) {}
    }
    open var getAllSelecteds = ::gen_getAllSelecteds_fn
    open fun gen_getAllSelecteds_fn(): String {
        return this.checkvaluelist
    }
    companion object {
        var name = "xRadioGroup"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xRadioGroup" to _pS(_uM("display" to "flex", "flexWrap" to "wrap")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "update:modelValue" to null)
        var props = _nP(_uM("modelValue" to _uM("type" to "String", "default" to ""), "direction" to _uM("type" to "String", "default" to "row")))
        var propsNeedCastKeys = _uA(
            "modelValue",
            "direction"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
