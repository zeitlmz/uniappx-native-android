@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI09580B7
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
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
import io.dcloud.uniapp.extapi.pageScrollTo as uni_pageScrollTo
open class GenUniModulesTmxUiComponentsXFormXForm : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var labelWidth: String by `$props`
    open var labelDirection: String by `$props`
    open var labelFontColor: String by `$props`
    open var errorAutoPage: Boolean by `$props`
    open var modelValue: Any by `$props`
    open var labelFontSize: String by `$props`
    open var showLabel: Boolean by `$props`
    open var errorAlign: String by `$props`
    open var rules: Map<String, UTSArray<FORM_RULE>> by `$props`
    open var watchValidStatus: Boolean by `$props`
    open var modelValid: Boolean by `$props`
    open var pushAdd: (item: FORM_ITEM) -> Unit
        get() {
            return unref(this.`$exposed`["pushAdd"]) as (item: FORM_ITEM) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "pushAdd", value)
        }
    open var delItem: (id: String) -> Unit
        get() {
            return unref(this.`$exposed`["delItem"]) as (id: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "delItem", value)
        }
    open var getRules: (key: String) -> UTSArray<FORM_RULE>
        get() {
            return unref(this.`$exposed`["getRules"]) as (key: String) -> UTSArray<FORM_RULE>
        }
        set(value) {
            setRefValue(this.`$exposed`, "getRules", value)
        }
    open var valid: (keys: UTSArray<String>) -> FORM_SUBMIT_RESULT
        get() {
            return unref(this.`$exposed`["valid"]) as (keys: UTSArray<String>) -> FORM_SUBMIT_RESULT
        }
        set(value) {
            setRefValue(this.`$exposed`, "valid", value)
        }
    open var clearValid: () -> Unit
        get() {
            return unref(this.`$exposed`["clearValid"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "clearValid", value)
        }
    open var submit: () -> FORM_SUBMIT_RESULT
        get() {
            return unref(this.`$exposed`["submit"]) as () -> FORM_SUBMIT_RESULT
        }
        set(value) {
            setRefValue(this.`$exposed`, "submit", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsXFormXForm, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsXFormXForm
            val _cache = __ins.renderCache
            val proxy = getCurrentInstance()?.proxy ?: null
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val list = ref(utsArrayOf<FORM_ITEM>())
            val top = ref(0)
            val isOkTop = ref(false)
            val isdestry = ref(false)
            val oldFormData = ref(UTSJSONObject() as Any)
            val id = ("xForm-" + getUid()) as String
            val props = __props
            val _modelValue = computed(fun(): Any {
                return props.modelValue
            }
            )
            val _rules = computed(fun(): Map<String, UTSArray<FORM_RULE>> {
                return props.rules
            }
            )
            var validTimeid: Number = 12
            provide("XFORMITEM_TOP", computed(fun(): Number {
                return top.value
            }
            ))
            provide("XFORMITEM_LABEL_WIDTH", computed(fun(): String {
                return props.labelWidth
            }
            ))
            provide("XFORMITEM_LABEL_Direction", computed(fun(): String {
                return props.labelDirection
            }
            ))
            provide("labelFontColor", computed(fun(): String {
                return props.labelFontColor
            }
            ))
            provide("XFORMITEM_LABEL_SCROLL", computed(fun(): Boolean {
                return props.errorAutoPage
            }
            ))
            provide("XFORMITEM_LABEL_FontSize", computed(fun(): String {
                return props.labelFontSize
            }
            ))
            provide("XFORMITEM_SHOWLABEL", computed(fun(): Boolean {
                return props.showLabel
            }
            ))
            provide("XFORMITEM_ERROR_ALIGN", computed(fun(): String {
                return props.errorAlign
            }
            ))
            fun gen_getNodeInfo_fn() {
                uni_createSelectorQuery().`in`(proxy).select(".xForm").boundingClientRect().exec(fun(ret){
                    var nodeinfo = ret[0] as NodeInfo
                    top.value = nodeinfo.top!!
                    isOkTop.value = true
                }
                )
            }
            val getNodeInfo = ::gen_getNodeInfo_fn
            fun gen_actionsRequired_fn(templist: UTSArray<FORMITEM_R>) {
                list.value.forEach(fun(el: FORM_ITEM){
                    var index = templist.findIndex(fun(ele: FORMITEM_R): Boolean {
                        return ele.key == el.name
                    }
                    )
                    if (index > -1) {
                        el.ele.vaildCompele(templist[index].value)
                    }
                }
                )
            }
            val actionsRequired = ::gen_actionsRequired_fn
            fun gen_diffFiled_fn(newvals: Any, olds: Any) {
                if (isdestry.value) {
                    return
                }
                if (UTSAndroid.`typeof`(newvals) != "object" || UTSAndroid.`typeof`(olds) != "object") {
                    return
                }
                var newval = JSON.parseObject(JSON.stringify(newvals)) as UTSJSONObject
                var old = JSON.parseObject(JSON.stringify(olds)) as UTSJSONObject
                var fileds = utsArrayOf<FORMITEM_R>()
                for(key in resolveUTSKeyIterator(old)){
                    var kVal: Any? = newval.get(key)
                    var oldval: Any? = old.get(key)
                    if (UTSArray.isArray(kVal) && UTSArray.isArray(oldval)) {
                        var temval = (kVal as UTSArray<Any>).length
                        var temoldval = (oldval as UTSArray<Any>).length
                        if (temval != temoldval) {
                            fileds.push(FORMITEM_R(key = key, value = kVal as UTSArray<Any>))
                        }
                    } else if (kVal != oldval) {
                        fileds.push(FORMITEM_R(key = key, value = kVal))
                    }
                }
                actionsRequired(fileds)
                oldFormData.value = JSON.parse<Any>(JSON.stringify(_modelValue.value))!!
            }
            val diffFiled = ::gen_diffFiled_fn
            fun _valid(keys: UTSArray<String>, isShowwStatusInTag: Boolean = true): FORM_SUBMIT_RESULT {
                var toptemp: Number = 0
                var result = FORM_SUBMIT_RESULT(valid = true, errorMessage = "", key = "", formData = utsArrayOf<FORM_SUBMIT_OBJECT>())
                var modevalue = JSON.parseObject(JSON.stringify(_modelValue.value)) as UTSJSONObject
                for(key in resolveUTSKeyIterator(modevalue)){
                    if (keys.length == 0 || keys.includes(key)) {
                        var valdata: Any? = modevalue.get(key)
                        var index = list.value.findIndex(fun(ele: FORM_ITEM): Boolean {
                            return ele.name == key
                        }
                        )
                        if (index > -1) {
                            var resultJg = null as FORM_SUBMIT_OBJECT?
                            if (isShowwStatusInTag) {
                                resultJg = list.value[index].ele.vaildCompele(valdata, false) as FORM_SUBMIT_OBJECT
                            } else {
                                resultJg = list.value[index].ele.getVaildStatus(valdata) as FORM_SUBMIT_OBJECT
                            }
                            if (!resultJg!!.valid && result.valid) {
                                result.valid = false
                                result.key = key
                                result.errorMessage = resultJg!!.errorMessage
                                toptemp = list.value[index].top
                            }
                            result.formData.push(resultJg!!)
                        }
                    }
                }
                if (isShowwStatusInTag) {
                    emits("submit", result)
                    if (props.errorAutoPage && !result.valid && toptemp > 0) {
                        uni_pageScrollTo(PageScrollToOptions(scrollTop = toptemp, fail = fun(_){
                            console.error("当前页面没有放置可滚动的列表，但使用了表单出错滚动功能，请关闭表单属性：error-auto-page")
                        }
                        ))
                    }
                }
                return result
            }
            fun gen_getStatus_fn() {
                if (!props.watchValidStatus) {
                    return
                }
                clearTimeout(validTimeid)
                validTimeid = setTimeout(fun() {
                    val result = _valid(utsArrayOf<String>(), false)
                    console.log(result.valid)
                    emits("update:modelValid", result.valid)
                }
                , 120)
            }
            val getStatus = ::gen_getStatus_fn
            onMounted(fun(){
                oldFormData.value = JSON.parse<Any>(JSON.stringify(_modelValue.value))!!
                getNodeInfo()
            }
            )
            onBeforeUnmount(fun(){
                clearTimeout(validTimeid)
                isdestry.value = true
                list.value = utsArrayOf<FORM_ITEM>()
                oldFormData.value = UTSJSONObject()
            }
            )
            watch(fun(): Any {
                return props.modelValue
            }
            , fun(newValue: Any){
                diffFiled(newValue, oldFormData.value)
                if (props.watchValidStatus) {
                    getStatus()
                }
            }
            , WatchOptions(deep = true))
            __expose(utsMapOf("pushAdd" to fun(item: FORM_ITEM) {
                if (isdestry.value) {
                    return
                }
                var index = list.value.findIndex(fun(el: FORM_ITEM): Boolean {
                    return el.id == item.id
                }
                )
                if (index > -1) {
                    list.value.splice(index, 1, item)
                } else {
                    list.value.push(item)
                }
            }
            , "delItem" to fun(id: String) {
                if (isdestry.value) {
                    return
                }
                if (list.value.length == 0) {
                    return
                }
                var index: Number = list.value.findIndex(fun(el: FORM_ITEM): Boolean {
                    return el.id == id
                }
                )
                if (index > -1) {
                    list.value.splice(index, 1)
                }
            }
            , "getRules" to fun(key: String): UTSArray<FORM_RULE> {
                val _localRules = _rules.value.get(key)
                if (_localRules == null) {
                    return utsArrayOf<FORM_RULE>()
                }
                return _localRules!!
            }
            , "valid" to fun(keys: UTSArray<String>): FORM_SUBMIT_RESULT {
                return _valid(keys)
            }
            , "clearValid" to fun() {
                list.value.forEach(fun(el: FORM_ITEM){
                    el.ele.clearValid()
                }
                )
            }
            , "submit" to fun(): FORM_SUBMIT_RESULT {
                return _valid(utsArrayOf<String>())
            }
            ))
            return fun(): Any? {
                return createElementVNode("view", utsMapOf("class" to "xForm"), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "default")
                ))
            }
        }
        var name = "xForm"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("submit" to null, "update:modelValid" to null)
        var props = normalizePropsOptions(utsMapOf("labelWidth" to utsMapOf("type" to "String", "required" to true, "default" to "100"), "labelDirection" to utsMapOf("type" to "String", "required" to true, "default" to "horizontal"), "labelFontColor" to utsMapOf("type" to "String", "required" to true, "default" to "#333333"), "errorAutoPage" to utsMapOf("type" to "Boolean", "required" to true, "default" to true), "modelValue" to utsMapOf("required" to true, "default" to UTSJSONObject()), "labelFontSize" to utsMapOf("type" to "String", "required" to true, "default" to "16"), "showLabel" to utsMapOf("type" to "Boolean", "required" to true, "default" to true), "errorAlign" to utsMapOf("type" to "String", "required" to true, "default" to "left"), "rules" to utsMapOf("type" to "Object", "required" to true, "default" to Map<String, UTSArray<FORM_RULE>>()), "watchValidStatus" to utsMapOf("type" to "Boolean", "required" to true, "default" to false), "modelValid" to utsMapOf("type" to "Boolean", "required" to true, "default" to false)))
        var propsNeedCastKeys = utsArrayOf(
            "labelWidth",
            "labelDirection",
            "labelFontColor",
            "errorAutoPage",
            "modelValue",
            "labelFontSize",
            "showLabel",
            "errorAlign",
            "rules",
            "watchValidStatus",
            "modelValid"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
