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
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
open class GenUniModulesTmxUiComponentsXPickerViewXPickerView : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.oninitFun()
            uni__on("onResize", this.oninitFun)
        }
        , __ins)
        onBeforeUnmount(fun() {
            clearTimeout(this.tid)
            uni__off("onResize", this.oninitFun)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newValue: UTSArray<String>) {
            if (newValue.join("") == this.nowValue.join("")) {
                return
            }
            this.nowValue = newValue
            this._modelValueIndex = this.chuliIndex(this.getIdeByindex())
            this.setChangeStrvmodel()
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_picker_item = resolveEasyComponent("x-picker-item", GenUniModulesTmxUiComponentsXPickerItemXPickerItemClass)
        return _cE("view", _uM("class" to "xPickerView", "ref" to "xPickerView"), _uA(
            if (isTrue(_ctx.okNodeInfo)) {
                _cV(_component_x_picker_item, _uM("key" to 0, "unitsFontSize" to _ctx.unitsFontSize, "onCountChange" to _ctx.conutChangeEnd, "duration" to _ctx.duration, "threshold" to _ctx.threshold, "font-size" to _ctx.fontSize, "cellUnits" to _ctx._cellUnits, "onChangeDeep" to _ctx.change, "selectedIndex" to _ctx._modelValueIndex, "parentIndex" to _ctx.parentIndex, "wrapWight" to _ctx._deepWidth, "list" to _ctx._list, "class" to "xPickerViewItem"), null, 8, _uA(
                    "unitsFontSize",
                    "onCountChange",
                    "duration",
                    "threshold",
                    "font-size",
                    "cellUnits",
                    "onChangeDeep",
                    "selectedIndex",
                    "parentIndex",
                    "wrapWight",
                    "list"
                ))
            } else {
                _cC("v-if", true)
            }
        ), 512)
    }
    open var list: UTSArray<PICKER_ITEM_INFO> by `$props`
    open var listPro: UTSArray<X_PICKER_X_ITEM> by `$props`
    open var modelValue: UTSArray<String> by `$props`
    open var modelStr: String by `$props`
    open var cellUnits: UTSArray<String> by `$props`
    open var unitsFontSize: String by `$props`
    open var fontSize: String by `$props`
    open var duration: Number by `$props`
    open var threshold: Number by `$props`
    open var modelStrJoin: String by `$props`
    open var wrapTotalWidth: Number by `$data`
    open var nowValue: UTSArray<String> by `$data`
    open var _modelValueIndex: UTSArray<Number> by `$data`
    open var okNodeInfo: Boolean by `$data`
    open var tid: Number by `$data`
    open var parentIndex: Number by `$data`
    open var _cellUnits: UTSArray<String> by `$data`
    open var _list: UTSArray<X_PICKER_X_ITEM> by `$data`
    open var _maxDeep: Number by `$data`
    open var _deepWidth: Number by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("wrapTotalWidth" to 0, "nowValue" to _uA<String>(), "_modelValueIndex" to _uA<Number>(), "okNodeInfo" to false, "tid" to 0, "parentIndex" to 0, "_cellUnits" to computed<UTSArray<String>>(fun(): UTSArray<String> {
            return this.cellUnits as UTSArray<String>
        }
        ), "_list" to computed<UTSArray<X_PICKER_X_ITEM>>(fun(): UTSArray<X_PICKER_X_ITEM> {
            if (this.listPro.length > 0) {
                return this.listPro
            }
            var list = this.list.slice(0) as UTSArray<PICKER_ITEM_INFO>
            fun addOptionalFieldsToTreeClolone(tree: UTSArray<PICKER_ITEM_INFO>): UTSArray<X_PICKER_X_ITEM> {
                var nowlist = _uA<X_PICKER_X_ITEM>()
                run {
                    var i: Number = 0
                    while(i < tree.length){
                        val node = tree[i]
                        node.disabled = if (node.disabled == null) {
                            false
                        } else {
                            node.disabled!! as Boolean
                        }
                        node.id = if (node.id == null) {
                            i.toString(10)
                        } else {
                            node.id!! as String
                        }
                        node.children = if (node.children == null) {
                            (_uA<PICKER_ITEM_INFO>())
                        } else {
                            node.children!! as UTSArray<PICKER_ITEM_INFO>
                        }
                        var item = X_PICKER_X_ITEM(id = node.id!!, title = node.title, disabled = node.disabled!!, children = _uA<X_PICKER_X_ITEM>())
                        if (node.children!!.length > 0) {
                            item.children = addOptionalFieldsToTreeClolone(node.children!! as UTSArray<PICKER_ITEM_INFO>)
                        }
                        nowlist.push(item)
                        i++
                    }
                }
                return nowlist
            }
            return addOptionalFieldsToTreeClolone(list)
        }
        ), "_maxDeep" to computed<Number>(fun(): Number {
            if (this._list.length == 0) {
                return 0
            }
            fun getdiepWidth(list: UTSArray<X_PICKER_X_ITEM>): Number {
                var deepIndex: Number = 1
                val node = list[0]
                if (node.children.length > 0) {
                    deepIndex += getdiepWidth(node.children)
                }
                return deepIndex
            }
            return getdiepWidth(this._list)
        }
        ), "_deepWidth" to computed<Number>(fun(): Number {
            if (this._list.length == 0) {
                return this.wrapTotalWidth
            }
            fun getdiepWidth(list: UTSArray<X_PICKER_X_ITEM>): Number {
                var deepIndex: Number = 1
                val node = list[0]
                if (node.children.length > 0) {
                    deepIndex += getdiepWidth(node.children)
                }
                return deepIndex
            }
            return this.wrapTotalWidth / Math.max(1, getdiepWidth(this._list))
        }
        ))
    }
    open var setChangeStrvmodel = ::gen_setChangeStrvmodel_fn
    open fun gen_setChangeStrvmodel_fn() {
        var listitem = this.getModelStr()
        var idvalue = _uA<String>()
        var strs = _uA<String>()
        listitem.forEach(fun(el){
            idvalue.push(el.id)
            strs.push(el.title)
        }
        )
        this.`$emit`("update:modelStr", strs.join(this.modelStrJoin))
    }
    open var oninitFun = ::gen_oninitFun_fn
    open fun gen_oninitFun_fn() {
        this.nowValue = this.modelValue.slice(0)
        this._modelValueIndex = this.chuliIndex(this.getIdeByindex())
        this.setChangeStrvmodel()
        this.getNodeInfo()
    }
    open var change = ::gen_change_fn
    open fun gen_change_fn(ids: UTSArray<Number>) {
        this._modelValueIndex = ids
        var listitem = this.getModelStr()
        var idvalue = _uA<String>()
        var strs = _uA<String>()
        listitem.forEach(fun(el){
            idvalue.push(el.id)
            strs.push(el.title)
        }
        )
        this.`$emit`("update:modelValue", idvalue)
        this.`$emit`("update:modelStr", strs.join(this.modelStrJoin))
        if (idvalue.join("") == this.modelValue.join("")) {
            return
        }
        var t = this
        clearTimeout(this.tid)
        t.tid = setTimeout(fun() {
            t.`$emit`("change", idvalue)
        }
        , 30)
    }
    open var chuliIndex = ::gen_chuliIndex_fn
    open fun gen_chuliIndex_fn(indexs: UTSArray<Number>): UTSArray<Number> {
        var ids = indexs.slice(0)
        var kVal = this.nowValue.slice(0)
        run {
            var i: Number = 0
            while(i < this._maxDeep){
                if (i >= kVal.length) {
                    ids.push(0)
                }
                i++
            }
        }
        return ids
    }
    open var getIdeByindex = ::gen_getIdeByindex_fn
    open fun gen_getIdeByindex_fn(): UTSArray<Number> {
        var index: Number = 0
        var kVal = this.nowValue.slice(0)
        var indexs = _uA<Number>()
        fun getIndex(nodes: UTSArray<X_PICKER_X_ITEM>) {
            if (kVal.length <= index || kVal.length == 0) {
                return
            }
            var id = kVal[index]
            var sindex: Number = 0
            run {
                var i: Number = 0
                while(i < nodes.length){
                    var item = nodes[i]
                    if (item.id == id) {
                        sindex = i
                        indexs.push(sindex)
                        if (item.children.length > 0) {
                            index += 1
                            getIndex(item.children)
                        }
                    }
                    i++
                }
            }
        }
        getIndex(this._list)
        return indexs
    }
    open var getModelStr = ::gen_getModelStr_fn
    open fun gen_getModelStr_fn(): UTSArray<X_PICKER_X_ITEM> {
        var ids = this._modelValueIndex.slice(0)
        var index: Number = 0
        var selectedList = _uA<X_PICKER_X_ITEM>()
        fun getStr(nodes: UTSArray<X_PICKER_X_ITEM>) {
            if (ids.length <= index || ids.length == 0) {
                return
            }
            var idx = ids[index]
            idx = Math.max(0, Math.min(nodes.length - 1, idx))
            var item = nodes[idx]
            selectedList.push(item)
            if (item.children.length > 0) {
                index += 1
                getStr(item.children)
            }
        }
        getStr(this._list)
        return selectedList
    }
    open var conutChangeEnd = ::gen_conutChangeEnd_fn
    open fun gen_conutChangeEnd_fn(n: Number) {}
    open var getNodeInfo = ::gen_getNodeInfo_fn
    open fun gen_getNodeInfo_fn() {
        uni_createSelectorQuery().`in`(this).select(".xPickerView").boundingClientRect().exec(fun(ret){
            var nodeinfo = ret[0] as NodeInfo
            this.wrapTotalWidth = nodeinfo.width!!
            this.okNodeInfo = true
        }
        )
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "update:modelStr" to null, "update:modelValue" to null)
        var props = _nP(_uM("list" to _uM("type" to "Array", "default" to fun(): UTSArray<PICKER_ITEM_INFO> {
            return _uA<PICKER_ITEM_INFO>()
        }
        ), "listPro" to _uM("type" to "Array", "default" to fun(): UTSArray<X_PICKER_X_ITEM> {
            return _uA<X_PICKER_X_ITEM>()
        }
        ), "modelValue" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "modelStr" to _uM("type" to "String", "default" to ""), "cellUnits" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "unitsFontSize" to _uM("type" to "String", "default" to "12"), "fontSize" to _uM("type" to "String", "default" to "16"), "duration" to _uM("type" to "Number", "default" to 300), "threshold" to _uM("type" to "Number", "default" to 0.9), "modelStrJoin" to _uM("type" to "String", "default" to ",")))
        var propsNeedCastKeys = _uA(
            "list",
            "listPro",
            "modelValue",
            "modelStr",
            "cellUnits",
            "unitsFontSize",
            "fontSize",
            "duration",
            "threshold",
            "modelStrJoin"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
