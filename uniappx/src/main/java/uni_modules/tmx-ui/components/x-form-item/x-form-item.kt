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
open class GenUniModulesTmxUiComponentsXFormItemXFormItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.pushDataToParent()
        }
        , __ins)
        onBeforeUnmount(fun() {
            this.removeSelf()
            clearTimeout(this.tid)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.field
        }
        , fun() {
            this.pushDataToParent()
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
        return createElementVNode("view", utsMapOf("class" to "xFormItem", "ref" to "xFormItem", "style" to normalizeStyle(utsArrayOf(
            _ctx._bordrBottomSolid,
            utsMapOf("paddingTop" to _ctx._cellPadding[0], "paddingBottom" to _ctx._cellPadding[1])
        ))), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "xFormIitemWrap", "style" to normalizeStyle(utsMapOf("flexDirection" to if (_ctx._labelDirection == "horizontal") {
                "row"
            } else {
                "column"
            }
            ))), utsArrayOf(
                if (isTrue(_ctx._showLabel)) {
                    createElementVNode("view", utsMapOf("key" to 0, "class" to "xFormIteLabel", "style" to normalizeStyle(utsMapOf("width" to if (_ctx._labelDirection == "horizontal") {
                        _ctx._labelWidth
                    } else {
                        "auto"
                    }, "paddingBottom" to if (_ctx._labelDirection == "horizontal") {
                        "0"
                    } else {
                        _ctx._labelPadding[1]
                    }, "paddingTop" to if (_ctx._labelDirection == "horizontal") {
                        "0"
                    } else {
                        _ctx._labelPadding[0]
                    }, "justify-content" to _ctx._labelAlign))), utsArrayOf(
                        renderSlot(_ctx.`$slots`, "label", UTSJSONObject(), fun(): UTSArray<Any> {
                            return utsArrayOf(
                                if (isTrue(_ctx._showRequired && _ctx._required)) {
                                    createElementVNode("text", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("fontSize" to _ctx._labelFontSize, "color" to "red", "paddingRight" to "8rpx"))), "*", 4)
                                } else {
                                    createCommentVNode("v-if", true)
                                },
                                if (isTrue(_ctx._label)) {
                                    createVNode(_component_x_text, utsMapOf("key" to 1, "font-size" to _ctx._labelFontSize, "color" to _ctx._labelFontColor), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            toDisplayString(_ctx._label)
                                        )
                                    }), "_" to 1), 8, utsArrayOf(
                                        "font-size",
                                        "color"
                                    ))
                                } else {
                                    createCommentVNode("v-if", true)
                                }
                            )
                        })
                    ), 4)
                } else {
                    createCommentVNode("v-if", true)
                }
                ,
                createElementVNode("view", utsMapOf("class" to "xFormIteContent", "style" to normalizeStyle(utsArrayOf(
                    utsMapOf("flex" to if (_ctx._labelDirection == "horizontal") {
                        "1"
                    } else {
                        "auto"
                    }
                    ),
                    _ctx._contentStyle
                ))), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "default")
                ), 4)
            ), 4),
            if (isTrue(_ctx.isError && !_ctx.first && _ctx._required && _ctx._showError)) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "xFormItemError"), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "error", UTSJSONObject(), fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "xFormItemErrorText", "style" to normalizeStyle(utsMapOf("fontSize" to _ctx._errorFontsize, "textAlign" to _ctx.XFORMITEM_ERROR_ALIGN))), toDisplayString(_ctx.errorText), 5)
                        )
                    })
                ))
            } else {
                createCommentVNode("v-if", true)
            }
        ), 4)
    }
    open var XFORMITEM_TOP: Number by `$inject`
    open var XFORMITEM_LABEL_WIDTH: String by `$inject`
    open var XFORMITEM_LABEL_Direction: String by `$inject`
    open var XFORMITEM_LABEL_FontColor: String by `$inject`
    open var XFORMITEM_LABEL_SCROLL: Boolean by `$inject`
    open var XFORMITEM_LABEL_FontSize: String by `$inject`
    open var XFORMITEM_SHOWLABEL: Boolean by `$inject`
    open var XFORMITEM_ERROR_ALIGN: String by `$inject`
    open var label: String by `$props`
    open var showLabel: Any? by `$props`
    open var field: String by `$props`
    open var required: Boolean by `$props`
    open var showRequired: Boolean by `$props`
    open var rule: UTSArray<FORM_RULE> by `$props`
    open var labelWidth: String by `$props`
    open var labelDirection: String by `$props`
    open var labelFontColor: String by `$props`
    open var labelFontSize: String by `$props`
    open var labelAlign: String by `$props`
    open var showBottomBorder: Boolean by `$props`
    open var cellPadding: UTSArray<String> by `$props`
    open var labelPadding: UTSArray<String> by `$props`
    open var showError: Boolean by `$props`
    open var contentStyle: String by `$props`
    open var id: String by `$data`
    open var errorText: String by `$data`
    open var isError: Boolean by `$data`
    open var first: Boolean by `$data`
    open var tid: Number by `$data`
    open var _contentStyle: String by `$data`
    open var _showError: Boolean by `$data`
    open var _cellPadding: UTSArray<String> by `$data`
    open var _labelPadding: UTSArray<String> by `$data`
    open var _parentTop: Number by `$data`
    open var _labelWidth: String by `$data`
    open var _labelFontSize: String by `$data`
    open var _labelDirection: String by `$data`
    open var _labelFontColor: String by `$data`
    open var _label: String by `$data`
    open var _showLabel: Boolean by `$data`
    open var _showRequired: Boolean by `$data`
    open var _rule: UTSArray<FORM_RULE> by `$data`
    open var _showBottomBoder: Boolean by `$data`
    open var _required: Boolean by `$data`
    open var _errorFontsize: String by `$data`
    open var _bordrBottomSolid: String by `$data`
    open var _labelAlign: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("id" to ("xFormItem-" + getUid()) as String, "errorText" to "请正确填写", "isError" to false, "first" to true, "tid" to 0, "_contentStyle" to computed<String>(fun(): String {
            return this.contentStyle
        }
        ), "_showError" to computed<Boolean>(fun(): Boolean {
            return this.showError
        }
        ), "_cellPadding" to computed<UTSArray<String>>(fun(): UTSArray<String> {
            var mb = checkIsCssUnit(this.cellPadding[0], xConfig.unit)
            var pb = checkIsCssUnit(this.cellPadding[1], xConfig.unit)
            return utsArrayOf(
                mb,
                pb
            )
        }
        ), "_labelPadding" to computed<UTSArray<String>>(fun(): UTSArray<String> {
            var mb = checkIsCssUnit(this.labelPadding[0], xConfig.unit)
            var pb = checkIsCssUnit(this.labelPadding[1], xConfig.unit)
            return utsArrayOf(
                mb,
                pb
            )
        }
        ), "_parentTop" to computed<Number>(fun(): Number {
            return this.XFORMITEM_TOP
        }
        ), "_labelWidth" to computed<String>(fun(): String {
            if (this.labelWidth != "") {
                return checkIsCssUnit(this.labelWidth, xConfig.unit)
            }
            return checkIsCssUnit(this.XFORMITEM_LABEL_WIDTH, xConfig.unit)
        }
        ), "_labelFontSize" to computed<String>(fun(): String {
            var labelsize = checkIsCssUnit(this.XFORMITEM_LABEL_FontSize, xConfig.unit)
            if (this.labelFontSize != "") {
                labelsize = checkIsCssUnit(this.labelFontSize, xConfig.unit)
            }
            return labelsize
        }
        ), "_labelDirection" to computed<String>(fun(): String {
            if (this.labelDirection != "") {
                return this.labelDirection
            }
            return this.XFORMITEM_LABEL_Direction
        }
        ), "_labelFontColor" to computed<String>(fun(): String {
            if (this.labelFontColor != "") {
                return getDefaultColor(this.labelFontColor)
            }
            return getDefaultColor(this.XFORMITEM_LABEL_FontColor)
        }
        ), "_label" to computed<String>(fun(): String {
            return this.label
        }
        ), "_showLabel" to computed<Boolean>(fun(): Boolean {
            var show = this.XFORMITEM_SHOWLABEL
            if (this.showLabel != null) {
                show = this.showLabel!! as Boolean
            }
            return show
        }
        ), "_showRequired" to computed<Boolean>(fun(): Boolean {
            return this.showRequired
        }
        ), "_rule" to computed<UTSArray<FORM_RULE>>(fun(): UTSArray<FORM_RULE> {
            return this.rule
        }
        ), "_showBottomBoder" to computed<Boolean>(fun(): Boolean {
            return this.showBottomBorder
        }
        ), "_required" to computed<Boolean>(fun(): Boolean {
            return this.required
        }
        ), "_errorFontsize" to computed<String>(fun(): String {
            return (xConfig.fontScale * 14).toString(10) + "px"
        }
        ), "_bordrBottomSolid" to computed<String>(fun(): String {
            if (!this.showBottomBorder) {
                return "border-bottom:none"
            }
            var lightSolid = "border-bottom: 1px solid #f5f5f5"
            var darkSolid = "border-bottom: 1px solid " + xConfig.borderDarkColor
            return if (xConfig.dark == "dark") {
                darkSolid
            } else {
                lightSolid
            }
        }
        ), "_labelAlign" to computed<String>(fun(): String {
            var dq = "flex-start"
            if (this.labelAlign == "right") {
                dq = "flex-end"
            } else if (this.labelAlign == "center") {
                dq = "center"
            }
            return dq
        }
        ))
    }
    open var pushDataToParent = ::gen_pushDataToParent_fn
    open fun gen_pushDataToParent_fn() {
        var pelement = this.findParent(this)
        if (pelement == null) {
            return
        }
        var parent: XFormComponentPublicInstance = pelement as XFormComponentPublicInstance
        parent.pushAdd(FORM_ITEM(id = this.id, ele = this, top = 0, name = this.field))
        var t = this
        uni_createSelectorQuery().`in`(t).select(".xFormItem").boundingClientRect().exec(fun(ret){
            var nodeinfo = ret[0] as NodeInfo
            parent.pushAdd(FORM_ITEM(id = t.id, ele = t, top = nodeinfo.top!!, name = t.field))
        }
        )
    }
    open var removeSelf = ::gen_removeSelf_fn
    open fun gen_removeSelf_fn() {
        var pelement = this.findParent(this)
        if (pelement == null) {
            return
        }
        var parent: XFormComponentPublicInstance = pelement as XFormComponentPublicInstance
        parent.delItem(this.id)
    }
    open var getParentRules = ::gen_getParentRules_fn
    open fun gen_getParentRules_fn(): UTSArray<FORM_RULE> {
        var pelement = this.findParent(this)
        if (pelement == null) {
            return utsArrayOf<FORM_RULE>()
        }
        var parent: XFormComponentPublicInstance = pelement as XFormComponentPublicInstance
        return parent.getRules(this.field) as UTSArray<FORM_RULE>
    }
    open fun vaildCompele(kVal: Any?, isSkipBlur: Boolean? = true): FORM_SUBMIT_OBJECT {
        this.first = false
        if (!this._required) {
            return FORM_SUBMIT_OBJECT(valid = true, key = this.field, value = kVal, errorMessage = "")
        }
        val rulesList = this._rule.concat(this.getParentRules()) as UTSArray<FORM_RULE>
        if (rulesList.length == 0 && this._required) {
            var isSuccess = formVaild(kVal, FORM_RULE())
            this.isError = !isSuccess
            return FORM_SUBMIT_OBJECT(valid = isSuccess, key = this.field, value = kVal, errorMessage = if (isSuccess) {
                ""
            } else {
                "请正确填写/选择"
            }
            )
        }
        var isSuccess = true
        run {
            var i: Number = 0
            while(i < rulesList.length){
                var item = rulesList[i]
                if (item.trigger == "blur" && isSkipBlur == true) {
                    i++
                    continue
                }
                isSuccess = formVaild(kVal, item)
                this.isError = !isSuccess
                if (!isSuccess) {
                    if (item.errorMessage != "" && UTSAndroid.`typeof`(item.errorMessage) == "string") {
                        this.errorText = item.errorMessage!! as String
                    } else {
                        this.errorText = "请正确填写/选择"
                    }
                    break
                }
                i++
            }
        }
        return FORM_SUBMIT_OBJECT(valid = isSuccess, key = this.field, value = kVal, errorMessage = if (isSuccess) {
            ""
        } else {
            this.errorText
        }
        )
    }
    open var clearValid = ::gen_clearValid_fn
    open fun gen_clearValid_fn() {
        this.isError = false
        this.first = true
    }
    open var getVaildStatus = ::gen_getVaildStatus_fn
    open fun gen_getVaildStatus_fn(kVal: Any?): FORM_SUBMIT_OBJECT {
        if (!this._required) {
            return FORM_SUBMIT_OBJECT(valid = true, key = this.field, value = kVal, errorMessage = "")
        }
        val rulesList = this._rule.concat(this.getParentRules()) as UTSArray<FORM_RULE>
        if (rulesList.length == 0 && this._required) {
            var isSuccess = formVaild(kVal, FORM_RULE())
            return FORM_SUBMIT_OBJECT(valid = isSuccess, key = this.field, value = kVal, errorMessage = if (isSuccess) {
                ""
            } else {
                "请正确填写/选择"
            }
            )
        }
        var isSuccess = true
        var errotips = ""
        run {
            var i: Number = 0
            while(i < rulesList.length){
                var item = rulesList[i]
                isSuccess = formVaild(kVal, item)
                if (!isSuccess) {
                    if (item.errorMessage != "" && UTSAndroid.`typeof`(item.errorMessage) == "string") {
                        errotips = item.errorMessage!! as String
                    } else {
                        errotips = "请正确填写/选择"
                    }
                    break
                }
                i++
            }
        }
        return FORM_SUBMIT_OBJECT(valid = isSuccess, key = this.field, value = kVal, errorMessage = if (isSuccess) {
            ""
        } else {
            errotips
        }
        )
    }
    open var validByblur = ::gen_validByblur_fn
    open fun gen_validByblur_fn(value: Any) {
        this.vaildCompele(value, false)
    }
    open var findParent = ::gen_findParent_fn
    open fun gen_findParent_fn(parent: VueComponent?): VueComponent? {
        if (parent == null) {
            return null
        }
        if (parent.`$parent` is XFormComponentPublicInstance) {
            return parent.`$parent`
        }
        var parents = this.findParent(parent.`$parent`)
        if (parents is XFormComponentPublicInstance) {
            return parents
        }
        return null
    }
    companion object {
        var name = "xFormItem"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xFormIteLabel" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "xFormItem" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column")), "xFormItemErrorText" to padStyleMapOf(utsMapOf("color" to "#FF0000", "paddingTop" to 5, "display" to "flex")), "xFormIitemWrap" to padStyleMapOf(utsMapOf("display" to "flex")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf("XFORMITEM_TOP" to utsMapOf("type" to "Number", "default" to 0), "XFORMITEM_LABEL_WIDTH" to utsMapOf("type" to "String", "default" to "100"), "XFORMITEM_LABEL_Direction" to utsMapOf("type" to "String", "default" to "horizontal"), "XFORMITEM_LABEL_FontColor" to utsMapOf("type" to "String", "default" to "#333333"), "XFORMITEM_LABEL_SCROLL" to utsMapOf("type" to "Boolean", "default" to true), "XFORMITEM_LABEL_FontSize" to utsMapOf("type" to "String", "default" to "16"), "XFORMITEM_SHOWLABEL" to utsMapOf("type" to "Boolean", "default" to true), "XFORMITEM_ERROR_ALIGN" to utsMapOf("type" to "String", "default" to "right"))
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf("label" to utsMapOf("type" to "String", "default" to ""), "showLabel" to utsMapOf("default" to null), "field" to utsMapOf("type" to "String", "default" to ""), "required" to utsMapOf("type" to "Boolean", "default" to false), "showRequired" to utsMapOf("type" to "Boolean", "default" to true), "rule" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<FORM_RULE> {
            return utsArrayOf<FORM_RULE>()
        }
        ), "labelWidth" to utsMapOf("type" to "String", "default" to ""), "labelDirection" to utsMapOf("type" to "String", "default" to ""), "labelFontColor" to utsMapOf("type" to "String", "default" to ""), "labelFontSize" to utsMapOf("type" to "String", "default" to ""), "labelAlign" to utsMapOf("type" to "String", "default" to "left"), "showBottomBorder" to utsMapOf("type" to "Boolean", "default" to true), "cellPadding" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>("10", "10")
        }
        ), "labelPadding" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>("12", "12")
        }
        ), "showError" to utsMapOf("type" to "Boolean", "default" to true), "contentStyle" to utsMapOf("type" to "String", "default" to "")))
        var propsNeedCastKeys = utsArrayOf(
            "label",
            "showLabel",
            "field",
            "required",
            "showRequired",
            "rule",
            "labelWidth",
            "labelDirection",
            "labelFontColor",
            "labelFontSize",
            "labelAlign",
            "showBottomBorder",
            "cellPadding",
            "labelPadding",
            "showError",
            "contentStyle"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
