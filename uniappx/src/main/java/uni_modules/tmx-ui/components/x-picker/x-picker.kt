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
open class GenUniModulesTmxUiComponentsXPickerXPicker : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.nowValue = this.modelValue.slice(0)
            this.yanchiDuration = if (this._lazyContent) {
                false
            } else {
                true
            }
            this.nowPull = getPagePullRefresh()
            this.onSetDefaultStr()
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newvalue: UTSArray<String>) {
            if (newvalue.join("") == this.nowValue.join("")) {
                return
            }
            this.nowValue = newvalue.slice(0)
            var str = this.getIdeBystr()
            this.`$emit`("update:modelStr", str.join(this.modelStrJoin))
            this.modelStrValue = str.join(this.modelStrJoin)
        }
        )
        this.`$watch`(fun(): Any? {
            return this.modelShow
        }
        , fun(newValue: Boolean) {
            if (newValue == this.show) {
                return
            }
            this.show = newValue
        }
        )
        this.`$watch`(fun(): Any? {
            return this._list
        }
        , fun() {
            if (this.show) {
                return
            }
            if (this._list.length == 0) {
                this.`$emit`("update:modelStr", "")
                this.modelStrValue = ""
                return
            }
            if (this._list.length > 0) {
                this.onSetDefaultStr()
            }
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_picker_view = resolveEasyComponent("x-picker-view", GenUniModulesTmxUiComponentsXPickerViewXPickerViewClass)
        val _component_x_drawer = resolveEasyComponent("x-drawer", GenUniModulesTmxUiComponentsXDrawerXDrawerClass)
        return createElementVNode(Fragment, null, utsArrayOf(
            createElementVNode("view", utsMapOf("onClick" to _ctx.openShow), utsArrayOf(
                renderSlot(_ctx.`$slots`, "default")
            ), 8, utsArrayOf(
                "onClick"
            )),
            createVNode(_component_x_drawer, utsMapOf("customWrapStyle" to _ctx.customWrapStyle, "lazy" to _ctx._lazyContent, "cancel-text" to _ctx.cancelText, "confirm-text" to _ctx.confirmText, "onOpen" to _ctx.onOpen, "zIndex" to _ctx.zIndex, "widthCoverCenter" to _ctx.widthCoverCenter, "disabledScroll" to true, "max-height" to "80%", "size" to "450", "title" to _ctx.title, "onClose" to _ctx.onClose, "onConfirm" to _ctx.onConfirm, "onCancel" to _ctx.onCancel, "showFooter" to true, "show" to _ctx.show, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.show = `$event`
            }
            , "show-close" to _ctx.showClose), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    if (isTrue(_ctx.yanchiDuration)) {
                        createVNode(_component_x_picker_view, utsMapOf("key" to 0, "unitsFontSize" to _ctx.unitsFontSize, "modelStrJoin" to _ctx.modelStrJoin, "cell-units" to _ctx._cellUnits, "onUpdate:modelStr" to _ctx.strChange, "onChange" to _ctx.mchange, "modelValue" to _ctx.nowValue, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                            _ctx.nowValue = `$event`
                        }, "list" to _ctx._list), null, 8, utsArrayOf(
                            "unitsFontSize",
                            "modelStrJoin",
                            "cell-units",
                            "onUpdate:modelStr",
                            "onChange",
                            "modelValue",
                            "onUpdate:modelValue",
                            "list"
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    }
                )
            }
            ), "_" to 1), 8, utsArrayOf(
                "customWrapStyle",
                "lazy",
                "cancel-text",
                "confirm-text",
                "onOpen",
                "zIndex",
                "widthCoverCenter",
                "title",
                "onClose",
                "onConfirm",
                "onCancel",
                "show",
                "onUpdate:show",
                "show-close"
            ))
        ), 64)
    }
    open var list: UTSArray<PICKER_ITEM_INFO> by `$props`
    open var modelValue: UTSArray<String> by `$props`
    open var modelStr: String by `$props`
    open var modelShow: Boolean by `$props`
    open var title: String by `$props`
    open var cancelText: String by `$props`
    open var confirmText: String by `$props`
    open var lazyContent: Boolean by `$props`
    open var cellUnits: UTSArray<String> by `$props`
    open var unitsFontSize: String by `$props`
    open var modelStrJoin: String by `$props`
    open var zIndex: Number by `$props`
    open var showClose: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var widthCoverCenter: Boolean by `$props`
    open var customWrapStyle: String by `$props`
    open var show: Boolean by `$data`
    open var nowValue: UTSArray<String> by `$data`
    open var modelStrValue: String by `$data`
    open var nowPull: Boolean by `$data`
    open var yanchiDuration: Boolean by `$data`
    open var _list: UTSArray<PICKER_ITEM_INFO> by `$data`
    open var _lazyContent: Boolean by `$data`
    open var _cellUnits: UTSArray<String> by `$data`
    open var _disabled: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("show" to false, "nowValue" to utsArrayOf<String>(), "modelStrValue" to "", "nowPull" to false, "yanchiDuration" to false, "_list" to computed<UTSArray<PICKER_ITEM_INFO>>(fun(): UTSArray<PICKER_ITEM_INFO> {
            return this.list.slice(0)
        }
        ), "_lazyContent" to computed<Boolean>(fun(): Boolean {
            return this.lazyContent
        }
        ), "_cellUnits" to computed<UTSArray<String>>(fun(): UTSArray<String> {
            return this.cellUnits
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ))
    }
    open var onSetDefaultStr = ::gen_onSetDefaultStr_fn
    open fun gen_onSetDefaultStr_fn() {
        if (this.modelStr == "" && this._list.length > 0) {
            var str = this.getIdeBystr()
            this.`$emit`("update:modelStr", str.join(this.modelStrJoin))
            this.modelStrValue = str.join(this.modelStrJoin)
        }
    }
    open var openShow = ::gen_openShow_fn
    open fun gen_openShow_fn() {
        if (this._disabled) {
            return
        }
        this.show = true
        this.`$emit`("update:modelShow", true)
        setPagePullRefresh(false)
    }
    open var onClose = ::gen_onClose_fn
    open fun gen_onClose_fn() {
        this.`$emit`("update:modelShow", false)
        this.nowValue = this.modelValue.slice(0)
        setPagePullRefresh(this.nowPull)
        if (this._lazyContent) {
            this.yanchiDuration = false
        }
    }
    open var strChange = ::gen_strChange_fn
    open fun gen_strChange_fn(str: String) {
        this.modelStrValue = str
    }
    open var onOpen = ::gen_onOpen_fn
    open fun gen_onOpen_fn() {
        this.yanchiDuration = true
    }
    open var mchange = ::gen_mchange_fn
    open fun gen_mchange_fn(ids: UTSArray<String>) {
        this.`$emit`("change", ids.slice(0))
    }
    open var onCancel = ::gen_onCancel_fn
    open fun gen_onCancel_fn() {
        this.`$emit`("cancel")
        this.nowValue = this.modelValue.slice(0)
    }
    open var getDefaultSeledids = ::gen_getDefaultSeledids_fn
    open fun gen_getDefaultSeledids_fn(): UTSArray<String> {
        var list = this._list
        var ids = utsArrayOf<String>()
        fun getid(listitem: UTSArray<PICKER_ITEM_INFO>) {
            if (listitem.length == 0) {
                return
            }
            var id = listitem[0].id
            ids.push(if (id == null) {
                "0"
            } else {
                id!!
            }
            )
            var children = if (listitem[0].children == null) {
                (utsArrayOf<PICKER_ITEM_INFO>())
            } else {
                listitem[0].children!!
            }
            if (children.length > 0) {
                getid(children)
            }
        }
        getid(list)
        return ids
    }
    open var onConfirm = ::gen_onConfirm_fn
    open fun gen_onConfirm_fn() {
        var ids = this.nowValue.slice(0)
        var nowModelStr = this.getIdeBystr()
        ids = if (ids.length == 0 || nowModelStr.length == 0) {
            this.getDefaultSeledids()
        } else {
            ids
        }
        this.nowValue = ids
        this.`$emit`("update:modelValue", ids)
        this.`$emit`("update:modelStr", this.modelStrValue)
        this.`$emit`("confirm", ids)
    }
    open var listDatas = ::gen_listDatas_fn
    open fun gen_listDatas_fn(): UTSArray<X_PICKER_X_ITEM> {
        if (this.list.length == 0) {
            return utsArrayOf<X_PICKER_X_ITEM>()
        }
        var list = this.list.slice(0) as UTSArray<PICKER_ITEM_INFO>
        fun addOptionalFieldsToTreeClolone(tree: UTSArray<PICKER_ITEM_INFO>): UTSArray<X_PICKER_X_ITEM> {
            var nowlist = utsArrayOf<X_PICKER_X_ITEM>()
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
                        (utsArrayOf<PICKER_ITEM_INFO>())
                    } else {
                        node.children!! as UTSArray<PICKER_ITEM_INFO>
                    }
                    var item = X_PICKER_X_ITEM(id = node.id!!, title = node.title, disabled = node.disabled!!, children = utsArrayOf<X_PICKER_X_ITEM>())
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
    open var getIdeBystr = ::gen_getIdeBystr_fn
    open fun gen_getIdeBystr_fn(): UTSArray<String> {
        var list = this.listDatas()
        if (list.length == 0) {
            return utsArrayOf<String>()
        }
        var index: Number = 0
        var kVal = this.nowValue.slice(0)
        var strs = utsArrayOf<String>()
        fun getIndex(nodes: UTSArray<X_PICKER_X_ITEM>) {
            if (kVal.length <= index || kVal.length == 0) {
                return
            }
            var id = kVal[index]
            run {
                var i: Number = 0
                while(i < nodes.length){
                    var item = nodes[i]
                    if (item.id == id) {
                        i
                        strs.push(item.title)
                        if (item.children.length > 0) {
                            index += 1
                            getIndex(item.children)
                        }
                    }
                    i++
                }
            }
        }
        getIndex(list)
        return strs
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("cancel" to null, "confirm" to null, "change" to null, "update:modelShow" to null, "update:modelStr" to null, "update:modelValue" to null)
        var props = normalizePropsOptions(utsMapOf("list" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<PICKER_ITEM_INFO> {
            return utsArrayOf<PICKER_ITEM_INFO>()
        }
        ), "modelValue" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "modelStr" to utsMapOf("type" to "String", "default" to ""), "modelShow" to utsMapOf("type" to "Boolean", "default" to false), "title" to utsMapOf("type" to "String", "default" to "请选择"), "cancelText" to utsMapOf("type" to "String", "default" to "取消"), "confirmText" to utsMapOf("type" to "String", "default" to "确认"), "lazyContent" to utsMapOf("type" to "Boolean", "default" to true), "cellUnits" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "unitsFontSize" to utsMapOf("type" to "String", "default" to "12"), "modelStrJoin" to utsMapOf("type" to "String", "default" to ","), "zIndex" to utsMapOf("type" to "Number", "default" to 1100), "showClose" to utsMapOf("type" to "Boolean", "default" to false), "disabled" to utsMapOf("type" to "Boolean", "default" to false), "widthCoverCenter" to utsMapOf("type" to "Boolean", "default" to false), "customWrapStyle" to utsMapOf("type" to "String", "default" to "")))
        var propsNeedCastKeys = utsArrayOf(
            "list",
            "modelValue",
            "modelStr",
            "modelShow",
            "title",
            "cancelText",
            "confirmText",
            "lazyContent",
            "cellUnits",
            "unitsFontSize",
            "modelStrJoin",
            "zIndex",
            "showClose",
            "disabled",
            "widthCoverCenter",
            "customWrapStyle"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
