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
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import uts.sdk.modules.xModalS.showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenUniModulesTmxUiComponentsXTreeItemXTreeItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this._list = this.list
            this.openFLoderIds = this.folderId
            this.nowIds = this.idList
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.folderId
        }
        , fun(newVal: UTSArray<String>) {
            if (newVal.join("") == this.openFLoderIds.join("")) {
                return
            }
            this.openFLoderIds = newVal
        }
        )
        this.`$watch`(fun(): Any? {
            return this.list
        }
        , fun() {
            this._list = this.list
        }
        )
        this.`$watch`(fun(): Any? {
            return this.idList
        }
        , fun(newVal: UTSArray<String>) {
            if (newVal.join("") == this.nowIds.join("")) {
                return
            }
            this.nowIds = newVal
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
        val _component_x_input = resolveEasyComponent("x-input", GenUniModulesTmxUiComponentsXInputXInputClass)
        val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        val _component_x_tree_item = resolveEasyComponent("x-tree-item", GenUniModulesTmxUiComponentsXTreeItemXTreeItemClass)
        return createElementVNode("view", utsMapOf("class" to "xTree"), utsArrayOf(
            createVNode(_component_x_modal, utsMapOf("height" to "auto", "onConfirm" to _ctx.editeclick, "title" to if (_ctx.editeType == "add") {
                "添加下级"
            } else {
                "修改内容"
            }
            , "show" to _ctx.showModal, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.showModal = `$event`
            }
            ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    if (_ctx.nowediteItem != null) {
                        createElementVNode("view", utsMapOf("key" to 0), utsArrayOf(
                            createVNode(_component_x_input, utsMapOf("dark-bg-color" to "", "height" to "48", "modelValue" to _ctx.nowediteItemText, "onUpdate:modelValue" to fun(`$event`: String){
                                _ctx.nowediteItemText = `$event`
                            }), utsMapOf("inputLeft" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createVNode(_component_x_text, utsMapOf("_style" to "padding:0 12px"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            "标题值"
                                        )
                                    }), "_" to 1))
                                )
                            }), "_" to 1), 8, utsArrayOf(
                                "modelValue",
                                "onUpdate:modelValue"
                            )),
                            createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("height" to "10px"))), null, 4),
                            createVNode(_component_x_input, utsMapOf("dark-bg-color" to "", "height" to "48", "placeholder" to "不要重复,空时自动生成", "modelValue" to _ctx.nowediteItemId, "onUpdate:modelValue" to fun(`$event`: String){
                                _ctx.nowediteItemId = `$event`
                            }), utsMapOf("inputLeft" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createVNode(_component_x_text, utsMapOf("_style" to "padding:0 12px"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            "标识ID"
                                        )
                                    }), "_" to 1))
                                )
                            }), "_" to 1), 8, utsArrayOf(
                                "modelValue",
                                "onUpdate:modelValue"
                            ))
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    }
                )
            }
            ), "_" to 1), 8, utsArrayOf(
                "onConfirm",
                "title",
                "show",
                "onUpdate:show"
            )),
            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx._list, fun(item, index, __index, _cached): Any {
                return createElementVNode("view", utsMapOf("class" to "xTreeItemCell", "key" to index), utsArrayOf(
                    createElementVNode("view", utsMapOf("hover-start-time" to 5, "hover-stay-time" to 30, "hover-class" to if (_ctx.getChildren(item).length > 0) {
                        "hoverClass"
                    } else {
                        "hoverClassOff"
                    }
                    , "onClick" to withModifiers(fun(){
                        _ctx.childrenEvent(item)
                    }
                    , utsArrayOf(
                        "stop"
                    )), "style" to normalizeStyle(utsMapOf("height" to "50px")), "class" to "xTreeItemCellWrap"), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "xTreeItemCellWrapLeft"), utsArrayOf(
                            if (isTrue(item.getArray("children") != null && _ctx._showFloaderIcon)) {
                                createElementVNode("view", utsMapOf("key" to 0, "class" to "xTreeItemCellWrapLeftIcon"), utsArrayOf(
                                    if (isTrue(!_ctx.isInOpenFloder(item))) {
                                        createVNode(_component_x_icon, utsMapOf("key" to 0, "color" to "#333333", "font-size" to "21", "name" to _ctx._floaderIcon[0]), null, 8, utsArrayOf(
                                            "name"
                                        ))
                                    } else {
                                        createCommentVNode("v-if", true)
                                    },
                                    if (isTrue(_ctx.isInOpenFloder(item))) {
                                        createVNode(_component_x_icon, utsMapOf("key" to 1, "color" to _ctx._color, "font-size" to "21", "name" to _ctx._floaderIcon[1]), null, 8, utsArrayOf(
                                            "color",
                                            "name"
                                        ))
                                    } else {
                                        createCommentVNode("v-if", true)
                                    }
                                ))
                            } else {
                                createCommentVNode("v-if", true)
                            }
                            ,
                            createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("color" to if (_ctx.isSelected(item)) {
                                _ctx._color
                            } else {
                                _ctx._itemColor
                            }
                            , "fontSize" to _ctx._fontSize)), "class" to "xTreeItemCellWrapLeftText"), toDisplayString(item.getString(_ctx.labelKey)), 5)
                        )),
                        if (isTrue(_ctx.isShowAdd(item))) {
                            createElementVNode("view", utsMapOf("key" to 0, "hover-start-time" to 5, "hover-stay-time" to 30, "hover-class" to "hoverClass", "onClick" to withModifiers(fun(){
                                _ctx.showModalEdte(item, "add")
                            }, utsArrayOf(
                                "stop"
                            )), "style" to normalizeStyle(utsMapOf("margin-right" to "10px"))), utsArrayOf(
                                createVNode(_component_x_icon, utsMapOf("color" to if (!_ctx.isDisabled(item)) {
                                    _ctx._color
                                } else {
                                    "#cecece"
                                }, "font-size" to "21", "name" to "add-large-line"), null, 8, utsArrayOf(
                                    "color"
                                ))
                            ), 12, utsArrayOf(
                                "onClick"
                            ))
                        } else {
                            createCommentVNode("v-if", true)
                        }
                        ,
                        if (isTrue(_ctx.isShowEdite(item))) {
                            createElementVNode("view", utsMapOf("key" to 1, "hover-start-time" to 5, "hover-stay-time" to 30, "hover-class" to "hoverClass", "onClick" to withModifiers(fun(){
                                _ctx.showModalEdte(item, "change")
                            }, utsArrayOf(
                                "stop"
                            )), "style" to normalizeStyle(utsMapOf("margin-right" to "10px"))), utsArrayOf(
                                createVNode(_component_x_icon, utsMapOf("color" to if (!_ctx.isDisabled(item)) {
                                    _ctx._color
                                } else {
                                    "#cecece"
                                }, "font-size" to "21", "name" to "edit-box-line"), null, 8, utsArrayOf(
                                    "color"
                                ))
                            ), 12, utsArrayOf(
                                "onClick"
                            ))
                        } else {
                            createCommentVNode("v-if", true)
                        }
                        ,
                        if (isTrue(_ctx.isShowRemove(item))) {
                            createElementVNode("view", utsMapOf("key" to 2, "hover-start-time" to 5, "hover-stay-time" to 30, "hover-class" to "hoverClass", "onClick" to withModifiers(fun(){
                                _ctx.removeItem(item)
                            }, utsArrayOf(
                                "stop"
                            )), "style" to normalizeStyle(utsMapOf("margin-right" to "10px"))), utsArrayOf(
                                createVNode(_component_x_icon, utsMapOf("color" to if (!_ctx.isDisabled(item)) {
                                    _ctx._color
                                } else {
                                    "#cecece"
                                }, "font-size" to "21", "name" to "delete-bin-2-line"), null, 8, utsArrayOf(
                                    "color"
                                ))
                            ), 12, utsArrayOf(
                                "onClick"
                            ))
                        } else {
                            createCommentVNode("v-if", true)
                        }
                        ,
                        if (isTrue(_ctx._showChecked)) {
                            createElementVNode("view", utsMapOf("key" to 3, "hover-start-time" to 5, "hover-stay-time" to 30, "hover-class" to "hoverClass", "onClick" to withModifiers(fun(){
                                _ctx.checkBoxClickEvent(item)
                            }, utsArrayOf(
                                "stop"
                            )), "style" to normalizeStyle(utsMapOf("opacity" to if (_ctx.isDisabled(item)) {
                                "0.3"
                            } else {
                                "1"
                            }))), utsArrayOf(
                                if (isTrue(_ctx._parentSelectedFullChildren)) {
                                    createVNode(_component_x_icon, utsMapOf("key" to 0, "color" to if (_ctx.isSelected(item) || _ctx.isIndeterminate(item)) {
                                        _ctx._color
                                    } else {
                                        "#cecece"
                                    }, "font-size" to "21", "name" to if (_ctx.isSelected(item)) {
                                        _ctx._checkedIcon[1]
                                    } else {
                                        if (_ctx.isIndeterminate(item)) {
                                            "indeterminate-circle-line"
                                        } else {
                                            _ctx._checkedIcon[0]
                                        }
                                    }), null, 8, utsArrayOf(
                                        "color",
                                        "name"
                                    ))
                                } else {
                                    createVNode(_component_x_icon, utsMapOf("key" to 1, "color" to if (_ctx.isSelected(item)) {
                                        _ctx._color
                                    } else {
                                        "#cecece"
                                    }, "font-size" to "21", "name" to if (_ctx.isSelected(item)) {
                                        _ctx._checkedIcon[1]
                                    } else {
                                        _ctx._checkedIcon[0]
                                    }), null, 8, utsArrayOf(
                                        "color",
                                        "name"
                                    ))
                                }
                            ), 12, utsArrayOf(
                                "onClick"
                            ))
                        } else {
                            createCommentVNode("v-if", true)
                        }
                    ), 12, utsArrayOf(
                        "hover-class",
                        "onClick"
                    )),
                    if (isTrue(_ctx.isInOpenFloder(item) && _ctx.showChildren)) {
                        createVNode(_component_x_tree_item, utsMapOf("key" to 0, "checkedIcon" to _ctx.checkedIcon, "showChecked" to _ctx._showChecked, "showFloaderIcon" to _ctx.showFloaderIcon, "floaderIcon" to _ctx.floaderIcon, "onChildrenClick" to _ctx.childrenClickEnd, "onOpenFolderChange" to _ctx.openFolderChangeEnd, "onSetChildrenData" to _ctx.setChildrenDataEnd, "beforeOpenFloder" to _ctx.beforeOpenFloder, "parentSelectedFullChildren" to _ctx._parentSelectedFullChildren, "disabled" to _ctx._disabled, "disabledParentBox" to _ctx._disabledParentBox, "onChange" to _ctx.changeEnd, "idList" to _ctx.nowIds, "color" to _ctx._color, "folderId" to _ctx.openFLoderIds, "idKey" to _ctx.idKey, "labelKey" to _ctx.labelKey, "style" to normalizeStyle(utsMapOf("margin-left" to "30px")), "list" to _ctx.getChildren(item), "modelValue" to _ctx.nowIds, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                            _ctx.nowIds = `$event`
                        }), null, 8, utsArrayOf(
                            "checkedIcon",
                            "showChecked",
                            "showFloaderIcon",
                            "floaderIcon",
                            "onChildrenClick",
                            "onOpenFolderChange",
                            "onSetChildrenData",
                            "beforeOpenFloder",
                            "parentSelectedFullChildren",
                            "disabled",
                            "disabledParentBox",
                            "onChange",
                            "idList",
                            "color",
                            "folderId",
                            "idKey",
                            "labelKey",
                            "style",
                            "list",
                            "modelValue",
                            "onUpdate:modelValue"
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    }
                ))
            }
            ), 128)
        ))
    }
    open var idList: UTSArray<String> by `$props`
    open var list: UTSArray<UTSJSONObject> by `$props`
    open var idKey: String by `$props`
    open var labelKey: String by `$props`
    open var folderId: UTSArray<String> by `$props`
    open var color: String by `$props`
    open var disabledParentBox: Boolean by `$props`
    open var parentSelectedFullChildren: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var beforeOpenFloder: callbackType2 by `$props`
    open var floaderIcon: UTSArray<String> by `$props`
    open var showFloaderIcon: Boolean by `$props`
    open var showChecked: Boolean by `$props`
    open var checkedIcon: UTSArray<String> by `$props`
    open var nowIds: UTSArray<String> by `$data`
    open var showChildren: Boolean by `$data`
    open var openFLoderIds: UTSArray<String> by `$data`
    open var tid: Number by `$data`
    open var _list: UTSArray<UTSJSONObject> by `$data`
    open var nowediteItem: UTSJSONObject? by `$data`
    open var showModal: Boolean by `$data`
    open var nowediteItemText: String by `$data`
    open var nowediteItemId: String by `$data`
    open var editeType: String by `$data`
    open var newItem: UTSJSONObject? by `$data`
    open var _checkedIcon: UTSArray<String> by `$data`
    open var _showChecked: Boolean by `$data`
    open var _showFloaderIcon: Boolean by `$data`
    open var _floaderIcon: UTSArray<String> by `$data`
    open var _childrenList: UTSArray<UTSJSONObject> by `$data`
    open var _folderId: UTSArray<String> by `$data`
    open var _color: String by `$data`
    open var _disabledParentBox: Boolean by `$data`
    open var _disabled: Boolean by `$data`
    open var _parentSelectedFullChildren: Boolean by `$data`
    open var _fontSize: String by `$data`
    open var _itemColor: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("nowIds" to utsArrayOf<String>(), "showChildren" to true, "openFLoderIds" to utsArrayOf<String>(), "tid" to 0, "_list" to utsArrayOf<UTSJSONObject>(), "nowediteItem" to null as UTSJSONObject?, "showModal" to false, "nowediteItemText" to "", "nowediteItemId" to "", "editeType" to "change", "newItem" to null as UTSJSONObject?, "_checkedIcon" to computed<UTSArray<String>>(fun(): UTSArray<String> {
            return this.checkedIcon
        }
        ), "_showChecked" to computed<Boolean>(fun(): Boolean {
            return this.showChecked
        }
        ), "_showFloaderIcon" to computed<Boolean>(fun(): Boolean {
            return this.showFloaderIcon
        }
        ), "_floaderIcon" to computed<UTSArray<String>>(fun(): UTSArray<String> {
            return this.floaderIcon
        }
        ), "_childrenList" to computed<UTSArray<UTSJSONObject>>(fun(): UTSArray<UTSJSONObject> {
            return this.list
        }
        ), "_folderId" to computed<UTSArray<String>>(fun(): UTSArray<String> {
            return this.openFLoderIds
        }
        ), "_color" to computed<String>(fun(): String {
            return this.color
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
        ), "_fontSize" to computed<String>(fun(): String {
            if (xConfig.fontScale == 1) {
                return "16"
            }
            return (16 * xConfig.fontScale).toString(10)
        }
        ), "_itemColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                return "white"
            }
            return "#666"
        }
        ))
    }
    open var childrenEvent = ::gen_childrenEvent_fn
    open fun gen_childrenEvent_fn(item: UTSJSONObject): UTSPromise<Any> {
        return wrapUTSPromise(suspend w@{
                var id = item.getString(this.idKey)
                if (id == null) {
                    return@w UTSPromise.resolve(true)
                }
                this.`$emit`("childrenClick", item)
                var idsIndex: Number = -1
                run {
                    var i: Number = 0
                    while(i < this.openFLoderIds.length){
                        if (this.openFLoderIds[i] == id) {
                            idsIndex = i
                            break
                        }
                        i++
                    }
                }
                var children = this.getChildren(item)
                var isOpenChildren = item.getArray("children")
                if (isOpenChildren == null) {
                    return@w UTSPromise.resolve(true)
                }
                if (idsIndex == -1 && children.length == 0) {
                    var asyncList = await(this.beforeOpenFloder(id))
                    var resultList = asyncList as UTSArray<UTSJSONObject>
                    if (resultList.length > 0) {
                        var n = setChildrenByid(this._list, id, this.idKey, resultList)
                        item.set("children", resultList)
                        children = resultList
                        this.`$emit`("setChildrenData", id, this._list)
                    }
                }
                if (children.length == 0) {
                    return@w UTSPromise.resolve(true)
                }
                if (idsIndex > -1) {
                    this.openFLoderIds.splice(idsIndex, 1)
                } else {
                    this.openFLoderIds.push(id)
                }
                this.`$emit`("openFolderChange", this.openFLoderIds.slice(0), if (idsIndex == -1) {
                    "open"
                } else {
                    "close"
                }
                , id)
                return@w UTSPromise.resolve(true)
        })
    }
    open var setChildrenDataEnd = ::gen_setChildrenDataEnd_fn
    open fun gen_setChildrenDataEnd_fn(id: String, item: UTSArray<UTSJSONObject>) {
        var parent = findParentNode(this._list, id, this.idKey) as UTSJSONObject?
        if (parent == null) {
            var index = this._list.findIndex(fun(item): Boolean {
                return id == item.getString(this.idKey)!!
            })
            if (index > -1) {
                this._list[index].set("children", item)
                this.`$emit`("setChildrenData", id, this._list)
            }
        } else {
            var index = this._list.findIndex(fun(item): Boolean {
                return item!!.getString(this.idKey) != parent!!.getString(this.idKey)!!
            }
            )
            if (index > -1) {
                this._list[index].set("children", item)
                this.`$emit`("setChildrenData", id, this._list)
            }
        }
    }
    open var isInOpenFloder = ::gen_isInOpenFloder_fn
    open fun gen_isInOpenFloder_fn(item: UTSJSONObject): Boolean {
        var id = item.getString(this.idKey)
        if (id == null) {
            return false
        }
        if (this.openFLoderIds.includes(id)) {
            return true
        }
        return false
    }
    open var getListItemHeight = ::gen_getListItemHeight_fn
    open fun gen_getListItemHeight_fn(item: UTSJSONObject): Number {
        var id = item.getString(this.idKey)
        if (id == null || !this.isInOpenFloder(item)) {
            return 1
        }
        var children = this.getChildren(item)
        if (children.length == 0) {
            return 1
        }
        return children.length + 1
    }
    open var getChildren = ::gen_getChildren_fn
    open fun gen_getChildren_fn(item: UTSJSONObject): UTSArray<UTSJSONObject> {
        var c = item.getArray<UTSJSONObject>("children")
        if (c == null) {
            return utsArrayOf<UTSJSONObject>()
        }
        return c
    }
    open var updateIds = ::gen_updateIds_fn
    open fun gen_updateIds_fn() {}
    open var openFolderChangeEnd = ::gen_openFolderChangeEnd_fn
    open fun gen_openFolderChangeEnd_fn(ids: UTSArray<String>, type: String, id: String) {
        this.`$emit`("openFolderChange", ids.slice(0), type, id)
    }
    open var childrenClickEnd = ::gen_childrenClickEnd_fn
    open fun gen_childrenClickEnd_fn(item: UTSJSONObject) {
        this.`$emit`("childrenClick", item)
    }
    open var checkBoxClickEvent = ::gen_checkBoxClickEvent_fn
    open fun gen_checkBoxClickEvent_fn(item: UTSJSONObject) {
        if (this.isDisabled(item)) {
            return
        }
        var id = item.getString(this.idKey)
        if (id == null) {
            return
        }
        var idsIndex: Number = -1
        run {
            var i: Number = 0
            while(i < this.nowIds.length){
                if (this.nowIds[i] == id) {
                    idsIndex = i
                    break
                }
                i++
            }
        }
        var sids = this.nowIds.slice(0)
        var indeterminate = this.isIndeterminate(item)
        var selected = this.isSelected(item)
        if (idsIndex > -1) {
            sids.splice(idsIndex, 1)
            if (this._parentSelectedFullChildren && this.getChildren(item).length > 0) {
                var tmepids = flatChildrensId(item, this.idKey)
                sids = sids.filter(fun(el): Boolean {
                    return !tmepids.includes(el)
                }
                )
            }
        } else {
            sids.push(id)
            if (this._parentSelectedFullChildren && this.getChildren(item).length > 0) {
                var tmepids = flatChildrensId(item, this.idKey)
                sids = sids.concat(tmepids)
            }
        }
        this.nowIds = sids
        this.`$emit`("change", this.nowIds.slice(0))
    }
    open var changeEnd = ::gen_changeEnd_fn
    open fun gen_changeEnd_fn(ids: UTSArray<String>) {
        this.nowIds = ids.slice(0)
        this.`$emit`("change", ids.slice(0))
    }
    open var isSelected = ::gen_isSelected_fn
    open fun gen_isSelected_fn(item: UTSJSONObject): Boolean {
        var id = item.getString(this.idKey)
        id = if (id == null) {
            ""
        } else {
            id
        }
        return this.nowIds.includes(id)
    }
    open var isIndeterminate = ::gen_isIndeterminate_fn
    open fun gen_isIndeterminate_fn(item: UTSJSONObject): Boolean {
        if (this.isSelected(item)) {
            return false
        }
        var children = this.getChildren(item)
        if (children.length === 0) {
            return false
        }
        var allChildrenIds = flatChildrensId(item, this.idKey)
        if (allChildrenIds.length === 0) {
            return false
        }
        var selectedChildrenCount: Number = 0
        run {
            var i: Number = 0
            while(i < allChildrenIds.length){
                if (this.nowIds.includes(allChildrenIds[i])) {
                    selectedChildrenCount++
                }
                i++
            }
        }
        return selectedChildrenCount > 0 && selectedChildrenCount < allChildrenIds.length
    }
    @get:JvmName("getIsDisabled0")
    @set:JvmName("setIsDisabled0")
    open var isDisabled = ::gen_isDisabled_fn
    open fun gen_isDisabled_fn(item: UTSJSONObject): Boolean {
        var children = this.getChildren(item)
        var disabled = item.getBoolean("disabled")
        disabled = if (disabled == null) {
            false
        } else {
            disabled
        }
        if (children.length > 0) {
            return this._disabledParentBox || disabled || this._disabled
        }
        return disabled || this._disabled
    }
    open var editeclick = ::gen_editeclick_fn
    open fun gen_editeclick_fn() {
        if (this.nowediteItem == null) {
            return
        }
        if (this.nowediteItemText == "") {
            uni_showToast(ShowToastOptions(title = "标题不能为空", icon = "none"))
            return
        }
        var item = this.nowediteItem!!
        var id = item.getString(this.idKey)!!
        if (this.editeType == "change") {
            item.set(this.labelKey, this.nowediteItemText)
            item.set(this.idKey, this.nowediteItemId)
            var index = this._list.findIndex(fun(item): Boolean {
                return id == item.getString(this.idKey)!!
            })
            if (index > -1) {
                this._list[index] = item
                this.`$emit`("setChildrenData", id, this._list)
            }
        } else if (this.editeType == "add" && this.newItem != null) {
            id = this.nowediteItemId
            if (id == "") {
                id = Math.random().toString(16).substring(1, 20)
            }
            this.newItem!!.set(this.labelKey, this.nowediteItemText)
            this.newItem!!.set(this.idKey, id)
            var nextChildre = this.getChildren(item)
            if (nextChildre.length == 0) {
                this.newItem!!.set("children", utsArrayOf<UTSJSONObject>(this.newItem!!))
            } else {
                nextChildre.push(this.newItem!! as UTSJSONObject)
            }
            var index = this._list.findIndex(fun(item): Boolean {
                return id == item.getString(this.idKey)!!
            }
            )
            if (index > -1) {
                this._list[index] = item
                this.`$emit`("setChildrenData", id, this._list)
            }
            this.nowediteItemId = ""
            this.nowediteItemText = ""
        }
    }
    open var isShowEdite = ::gen_isShowEdite_fn
    open fun gen_isShowEdite_fn(item: UTSJSONObject): Boolean {
        var showEditeLabel = item.getBoolean("showEdite")
        return showEditeLabel == true
    }
    open var isShowAdd = ::gen_isShowAdd_fn
    open fun gen_isShowAdd_fn(item: UTSJSONObject): Boolean {
        var showEditeLabel = item.getBoolean("showAdd")
        return showEditeLabel == true
    }
    open var isShowRemove = ::gen_isShowRemove_fn
    open fun gen_isShowRemove_fn(item: UTSJSONObject): Boolean {
        var showEditeLabel = item.getBoolean("showRemove")
        return showEditeLabel == true
    }
    open var showModalEdte = ::gen_showModalEdte_fn
    open fun gen_showModalEdte_fn(item: UTSJSONObject, editeType: String) {
        if (editeType == "add") {
            var newitem: UTSJSONObject = object : UTSJSONObject() {
                var disabled = false
                var showEdite = false
                var showRemove = true
            }
            newitem.set(this.labelKey, "")
            newitem.set(this.idKey, "")
            this.newItem = newitem
        }
        var disabled = this.isDisabled(item)
        this.editeType = editeType
        if (disabled) {
            return
        }
        this.nowediteItem = item
        if (editeType == "change") {
            this.nowediteItemText = if (item.getString(this.labelKey) == null) {
                ""
            } else {
                item.getString(this.labelKey)!!
            }
            this.nowediteItemId = if (item.getString(this.idKey) == null) {
                ""
            } else {
                item.getString(this.idKey)!!
            }
        } else if (editeType == "add") {
            this.nowediteItemId = ""
            this.nowediteItemText = ""
        }
        this.showModal = true
    }
    open var removeItem = ::gen_removeItem_fn
    open fun gen_removeItem_fn(item: UTSJSONObject) {
        console.log(this._list)
        var t = this
        uni_showModal(ShowModalOptions(title = "提醒", content = "确认删除?", success = fun(res) {
            if (res.confirm) {
                var id = item.getString(t.idKey)!!
                var index = t._list.findIndex(fun(item: UTSJSONObject): Boolean {
                    return id == item.getString(t.idKey)!!
                }
                )
                if (index > -1) {
                    t._list.splice(index, 1)
                    t.`$emit`("setChildrenData", id, t._list)
                }
            }
        }
        ))
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("hoverClass" to padStyleMapOf(utsMapOf("backgroundColor" to "rgba(0,0,0,0.03)")), "hoverClassOff" to padStyleMapOf(utsMapOf("backgroundColor" to "rgba(0,0,0,0)")), "xTreeItemCellWrapLeftText" to padStyleMapOf(utsMapOf("flex" to 1, "textOverflow" to "ellipsis", "lines" to 2)), "xTreeItemCellWrapLeftIcon" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center", "width" to 30)), "xTreeItemCellWrapLeft" to padStyleMapOf(utsMapOf("flex" to 1, "display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center")), "xTreeItemCellWrap" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "rgba(0,0,0,0.03)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("change" to null, "childrenClick" to null, "openFolderChange" to null, "setChildrenData" to null, "update:modelValue" to null)
        var props = normalizePropsOptions(utsMapOf("idList" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "list" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<UTSJSONObject> {
            return utsArrayOf<UTSJSONObject>()
        }
        ), "idKey" to utsMapOf("type" to "String", "default" to "id"), "labelKey" to utsMapOf("type" to "String", "default" to "text"), "folderId" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "color" to utsMapOf("type" to "String", "default" to ""), "disabledParentBox" to utsMapOf("type" to "Boolean", "default" to false), "parentSelectedFullChildren" to utsMapOf("type" to "Boolean", "default" to false), "disabled" to utsMapOf("type" to "Boolean", "default" to false), "beforeOpenFloder" to utsMapOf("type" to "Function", "default" to fun(itemId: String): UTSPromise<UTSArray<UTSJSONObject>> {
            return UTSPromise.resolve(utsArrayOf<UTSJSONObject>())
        }
        ), "floaderIcon" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>("folder-add-line", "folder-open-fill")
        }
        ), "showFloaderIcon" to utsMapOf("type" to "Boolean", "default" to true), "showChecked" to utsMapOf("type" to "Boolean", "default" to false), "checkedIcon" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>("checkbox-blank-line", "checkbox-fill")
        }
        )))
        var propsNeedCastKeys = utsArrayOf(
            "idList",
            "list",
            "idKey",
            "labelKey",
            "folderId",
            "color",
            "disabledParentBox",
            "parentSelectedFullChildren",
            "disabled",
            "beforeOpenFloder",
            "floaderIcon",
            "showFloaderIcon",
            "showChecked",
            "checkedIcon"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
