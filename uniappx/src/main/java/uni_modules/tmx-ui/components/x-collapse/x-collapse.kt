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
open class GenUniModulesTmxUiComponentsXCollapseXCollapse : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        provide("xCollapseDefaultName", this.activeName)
        onBeforeMount(fun() {
            this.activeName = this.modelValue
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newValue: UTSArray<String>) {
            var newstr = newValue.join("")
            if (newstr == this.activeName.join("")) {
                return
            }
            if (this.multiple) {
                this.activeName = newValue
            } else {
                if (newValue.length >= 1) {
                    this.activeName = _uA(
                        newValue[0]
                    )
                } else {
                    this.activeName = _uA()
                }
            }
            this.pushChildren()
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", null, _uA(
            renderSlot(_ctx.`$slots`, "default")
        ))
    }
    open var modelValue: UTSArray<String> by `$props`
    open var multiple: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var list: UTSArray<CHIDREN_ITEM> by `$data`
    open var activeName: UTSArray<String> by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "list" to _uA<CHIDREN_ITEM>(), "activeName" to _uA<String>())
    }
    open var addItem = ::gen_addItem_fn
    open fun gen_addItem_fn(item: CHIDREN_ITEM) {
        var index = this.list.findIndex(fun(el: CHIDREN_ITEM): Boolean {
            return el.id == item.id
        }
        )
        if (index > -1) {
            this.list.splice(index, 1, item)
        } else {
            this.list.push(item)
        }
        if (this.activeName.length > 0) {
            this.pushChildren()
        }
    }
    open var delItem = ::gen_delItem_fn
    open fun gen_delItem_fn(id: String) {
        var index = this.list.findIndex(fun(el: CHIDREN_ITEM): Boolean {
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
        this.list.forEach(fun(el: CHIDREN_ITEM){
            el.ele.setList(this.activeName)
        }
        )
    }
    open var addChange = ::gen_addChange_fn
    open fun gen_addChange_fn(id: String) {
        if (this.multiple) {
            var index = this.activeName.findIndex(fun(el: String): Boolean {
                return el == id
            })
            if (index > -1) {
                this.activeName.splice(index, 1)
            } else {
                this.activeName.push(id)
            }
        } else {
            if (this.activeName.includes(id)) {
                this.activeName = _uA()
            } else {
                this.activeName = _uA(
                    id
                )
            }
        }
        this.pushChildren()
        this.`$emit`("change", this.activeName)
        this.`$emit`("update:modelValue", this.activeName)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "update:modelValue" to null)
        var props = _nP(_uM("modelValue" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "multiple" to _uM("type" to "Boolean", "default" to true)))
        var propsNeedCastKeys = _uA(
            "modelValue",
            "multiple"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
