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
open class GenUniModulesTmxUiComponentsXTreeXTree : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this._list = this.list
            this.folderExopenids = this.getAllFoldreIdByF(this.folderId.slice(0))
            this.nowIds = this.modelValue.slice(0)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.folderId
        }
        , fun(newVal: UTSArray<String>) {
            if (newVal.join("") == this.folderExopenids.join("")) {
                return
            }
            this.`$nextTick`(fun() {
                this.folderExopenids = this.getAllFoldreIdByF(newVal)
            }
            )
        }
        )
        this.`$watch`(fun(): Any? {
            return this.list
        }
        , fun() {
            this.folderExopenids = this.getAllFoldreIdByF(this.folderExopenids.slice(0))
            this._list = this.list
        }
        )
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newVal: UTSArray<String>) {
            if (newVal.join("") == this.nowIds.join("")) {
                return
            }
            this.nowIds = newVal.slice(0)
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_tree_item = resolveEasyComponent("x-tree-item", GenUniModulesTmxUiComponentsXTreeItemXTreeItemClass)
        return _cE("view", null, _uA(
            _cV(_component_x_tree_item, _uM("checkedIcon" to _ctx.checkedIcon, "showChecked" to _ctx.showChecked, "showFloaderIcon" to _ctx.showFloaderIcon, "floaderIcon" to _ctx.floaderIcon, "onSetChildrenData" to _ctx.setChildrenDataEnd, "beforeOpenFloder" to _ctx.beforeOpenFloder, "parentSelectedFullChildren" to _ctx._parentSelectedFullChildren, "onChange" to _ctx.changeEnd, "disabled" to _ctx._disabled, "disabledParentBox" to _ctx._disabledParentBox, "color" to _ctx._color, "onChildrenClick" to _ctx.childrenClickEnd, "onOpenFolderChange" to _ctx.openFolderChange, "folderId" to _ctx._folderExopenids, "idKey" to _ctx.idKey, "labelKey" to _ctx.labelKey, "list" to _ctx._list, "idList" to _ctx.nowIds), null, 8, _uA(
                "checkedIcon",
                "showChecked",
                "showFloaderIcon",
                "floaderIcon",
                "onSetChildrenData",
                "beforeOpenFloder",
                "parentSelectedFullChildren",
                "onChange",
                "disabled",
                "disabledParentBox",
                "color",
                "onChildrenClick",
                "onOpenFolderChange",
                "folderId",
                "idKey",
                "labelKey",
                "list",
                "idList"
            ))
        ))
    }
    open var modelValue: UTSArray<String> by `$props`
    open var folderId: UTSArray<String> by `$props`
    open var parentSelectedFullChildren: Boolean by `$props`
    open var disabledParentBox: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var list: UTSArray<UTSJSONObject> by `$props`
    open var idKey: String by `$props`
    open var labelKey: String by `$props`
    open var color: String by `$props`
    open var beforeOpenFloder: callbackType3 by `$props`
    open var floaderIcon: UTSArray<String> by `$props`
    open var showFloaderIcon: Boolean by `$props`
    open var showChecked: Boolean by `$props`
    open var checkedIcon: UTSArray<String> by `$props`
    open var nowIds: UTSArray<String> by `$data`
    open var folderExopenids: UTSArray<String> by `$data`
    open var _list: UTSArray<UTSJSONObject> by `$data`
    open var _folderExopenids: UTSArray<String> by `$data`
    open var _color: String by `$data`
    open var _disabledParentBox: Boolean by `$data`
    open var _disabled: Boolean by `$data`
    open var _parentSelectedFullChildren: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("nowIds" to _uA<String>(), "folderExopenids" to _uA<String>(), "_list" to _uA<UTSJSONObject>(), "_folderExopenids" to computed<UTSArray<String>>(fun(): UTSArray<String> {
            return this.folderExopenids
        }
        ), "_color" to computed<String>(fun(): String {
            if (this.color == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.color)
        }
        ), "_disabledParentBox" to computed<Boolean>(fun(): Boolean {
            return this.disabledParentBox
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ), "_parentSelectedFullChildren" to computed<Boolean>(fun(): Boolean {
            return this.parentSelectedFullChildren
        }
        ))
    }
    open var getAllFoldreIdByF = ::gen_getAllFoldreIdByF_fn
    open fun gen_getAllFoldreIdByF_fn(onids: UTSArray<String>): UTSArray<String> {
        var ids = _uA<String>()
        var _this = this
        onids.forEach(fun(id){
            ids = ids.concat(findParentIds(_this._list, id, _this.idKey))
        }
        )
        return ids
    }
    open var openFolderChange = ::gen_openFolderChange_fn
    open fun gen_openFolderChange_fn(ids: UTSArray<String>, type: String, id: String) {
        var idscopty = ids.slice(0)
        this.folderExopenids = idscopty
        this.`$emit`("update:folderId", idscopty)
        this.`$emit`("openFolderChange", idscopty)
    }
    open var childrenClickEnd = ::gen_childrenClickEnd_fn
    open fun gen_childrenClickEnd_fn(item: UTSJSONObject) {
        this.`$emit`("childrenClick", item)
    }
    open var upateParentIds = ::gen_upateParentIds_fn
    open fun gen_upateParentIds_fn(): UTSArray<String> {
        var updateNodeStatus = fun(nodes: UTSArray<UTSJSONObject>): UTSArray<String> {
            return _uA<String>()
        }
        updateNodeStatus = fun(nodes: UTSArray<UTSJSONObject>): UTSArray<String> {
            var selectedParentIds = _uA<String>()
            run {
                var i: Number = 0
                while(i < nodes.length){
                    var item = nodes[i]
                    var children = item.getArray<UTSJSONObject>("children")
                    var nodeId = item.getString(this.idKey)!!
                    if (children != null && UTSArray.isArray(children) && children.length > 0) {
                        var childSelectedIds = updateNodeStatus(children)
                        var index = this.nowIds.findIndex(fun(yid: String): Boolean {
                            return yid == nodeId
                        }
                        )
                        var allChildrenIds = flatChildrensId(item, this.idKey)
                        var allSelected = true
                        run {
                            var j: Number = 0
                            while(j < allChildrenIds.length){
                                if (!this.nowIds.includes(allChildrenIds[j])) {
                                    allSelected = false
                                    break
                                }
                                j++
                            }
                        }
                        if (this._parentSelectedFullChildren) {
                            if (allSelected && allChildrenIds.length > 0 && !this.nowIds.includes(nodeId)) {
                                this.nowIds.push(nodeId)
                                selectedParentIds.push(nodeId)
                            } else if (index > -1 && !allSelected) {
                                this.nowIds.splice(index, 1)
                            }
                        }
                    }
                    i++
                }
            }
            return selectedParentIds
        }
        var selectedIds = updateNodeStatus(this._list)
        return selectedIds
    }
    open var changeEnd = ::gen_changeEnd_fn
    open fun gen_changeEnd_fn(ids: UTSArray<String>) {
        var idscopty = ids.slice(0)
        this.nowIds = idscopty
        val updatedParentIds = this.upateParentIds()
        if (updatedParentIds.length > 0) {
            idscopty = this.nowIds.slice(0)
        }
        val allParents = toRaw(getAllParentIds(this._list, this.idKey)) as UTSArray<String>
        val allIds = toRaw(this.nowIds) as UTSArray<String>
        val allSelectedParents = allIds.filter(fun(id: String): Boolean {
            return allParents.includes(id)
        }
        )
        val allSelectedChildrenIds = allIds.filter(fun(id: String): Boolean {
            return !allParents.includes(id)
        }
        )
        var allSelectedChildrenIdsAnyInd = findNodeIndeterminate(this._list, allIds, this.idKey)
        this.`$emit`("change", allIds, allSelectedParents, allSelectedChildrenIds, allSelectedChildrenIdsAnyInd.concat(allIds) as UTSArray<String>)
        this.`$emit`("update:modelValue", allIds)
    }
    open var setChildrenDataEnd = ::gen_setChildrenDataEnd_fn
    open fun gen_setChildrenDataEnd_fn(id: String, item: UTSArray<UTSJSONObject>) {}
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "childrenClick" to null, "openFolderChange" to null, "update:folderId" to null, "update:modelValue" to null)
        var props = _nP(_uM("modelValue" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "folderId" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "parentSelectedFullChildren" to _uM("type" to "Boolean", "default" to false), "disabledParentBox" to _uM("type" to "Boolean", "default" to false), "disabled" to _uM("type" to "Boolean", "default" to false), "list" to _uM("type" to "Array", "default" to fun(): UTSArray<UTSJSONObject> {
            return _uA<UTSJSONObject>()
        }
        ), "idKey" to _uM("type" to "String", "default" to "id"), "labelKey" to _uM("type" to "String", "default" to "text"), "color" to _uM("type" to "String", "default" to ""), "beforeOpenFloder" to _uM("type" to "Function", "default" to fun(itemId: String): UTSPromise<UTSArray<UTSJSONObject>> {
            return UTSPromise.resolve(_uA<UTSJSONObject>())
        }
        ), "floaderIcon" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA<String>("add-circle-line", "indeterminate-circle-line")
        }
        ), "showFloaderIcon" to _uM("type" to "Boolean", "default" to true), "showChecked" to _uM("type" to "Boolean", "default" to true), "checkedIcon" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA<String>("checkbox-blank-circle-line", "checkbox-circle-fill")
        }
        )))
        var propsNeedCastKeys = _uA(
            "modelValue",
            "folderId",
            "parentSelectedFullChildren",
            "disabledParentBox",
            "disabled",
            "list",
            "idKey",
            "labelKey",
            "color",
            "beforeOpenFloder",
            "floaderIcon",
            "showFloaderIcon",
            "showChecked",
            "checkedIcon"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
