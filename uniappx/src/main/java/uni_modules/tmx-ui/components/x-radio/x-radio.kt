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
open class GenUniModulesTmxUiComponentsXRadioXRadio : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onBeforeUnmount(fun() {
            this.isDestroy = true
        }
        , __ins)
        onMounted(fun() {
            this.isDestroy = false
            var t = this
            var pelement = this.findParent(this)
            if (pelement != null) {
                this.undefaultCheck = false
            } else {
                this.undefaultCheck = this.defaultChecked
            }
            this.`$nextTick`(fun(){
                t.nowValue = t.modelValue
                t.setAni()
                t.pushDataToParent(false)
            }
            )
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newValue: String) {
            if (newValue == this.nowValue) {
                return
            }
            this.nowValue = newValue
            this.setAni()
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
        return createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
            utsArrayOf(
                if (_ctx._disabled) {
                    "checkboxDisabled"
                } else {
                    ""
                }
            ),
            "checkbox"
        )), "onClick" to _ctx.boxClick), utsArrayOf(
            if (isTrue(!_ctx.hiddenCheckbox)) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "radioBox", "style" to normalizeStyle(utsMapOf("backgroundColor" to if (_ctx._isCheck) {
                    _ctx._color
                } else {
                    "transparent"
                }, "border" to ("1px solid " + (if (_ctx._isCheck) {
                    _ctx._color
                } else {
                    _ctx._unCheckColor
                })), "width" to _ctx._size, "height" to _ctx._size))), utsArrayOf(
                    createElementVNode("view", utsMapOf("id" to _ctx.boxId, "ref" to "checkboxBoxIcon", "class" to "checkboxBoxIcon"), utsArrayOf(
                        createVNode(_component_x_icon, utsMapOf("color" to "white", "name" to _ctx.icon, "font-size" to _ctx.iconSize), null, 8, utsArrayOf(
                            "name",
                            "font-size"
                        ))
                    ), 8, utsArrayOf(
                        "id"
                    ))
                ), 4)
            } else {
                createCommentVNode("v-if", true)
            }
            ,
            createElementVNode("view", utsMapOf("class" to "checkboxLabelBox", "style" to normalizeStyle(utsMapOf("paddingLeft" to if (!_ctx.hiddenCheckbox) {
                _ctx._labelSpace
            } else {
                "0px"
            }
            ))), utsArrayOf(
                renderSlot(_ctx.`$slots`, "label", GenUniModulesTmxUiComponentsXRadioXRadioSlotDataLabel(checked = _ctx._isCheck, value = _ctx.nowValue), fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createVNode(_component_x_text, utsMapOf("font-size" to _ctx.labelFontSize, "class" to "checkboxLabel"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                toDisplayString(_ctx._label)
                            )
                        }
                        ), "_" to 1), 8, utsArrayOf(
                            "font-size"
                        ))
                    )
                }
                )
            ), 4)
        ), 10, utsArrayOf(
            "onClick"
        ))
    }
    open var color: String by `$props`
    open var unCheckColor: String by `$props`
    open var darkUnCheckColor: String by `$props`
    open var modelValue: String by `$props`
    open var defaultChecked: Boolean by `$props`
    open var value: String by `$props`
    open var unCheckValue: String by `$props`
    open var disabled: Boolean by `$props`
    open var icon: String by `$props`
    open var label: String by `$props`
    open var hiddenCheckbox: Boolean by `$props`
    open var size: String by `$props`
    open var iconSize: String by `$props`
    open var labelFontSize: String by `$props`
    open var labelSpace: String by `$props`
    open var onlyChecked: Boolean by `$props`
    open var nowValue: String by `$data`
    open var boxId: Any? by `$data`
    open var tid: Number by `$data`
    open var isDestroy: Boolean by `$data`
    open var undefaultCheck: Boolean by `$data`
    open var _color: String by `$data`
    open var _unCheckColor: String by `$data`
    open var _isCheck: Boolean by `$data`
    open var _disabled: Boolean by `$data`
    open var _label: String by `$data`
    open var _size: String by `$data`
    open var _labelSpace: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("nowValue" to "", "boxId" to ("xRadio-" + getUid()), "tid" to 0, "isDestroy" to false, "undefaultCheck" to false, "_color" to computed<String>(fun(): String {
            if (this.color == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.color)
        }
        ), "_unCheckColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark" && this.darkUnCheckColor != "") {
                return getDefaultColor(this.darkUnCheckColor)
            }
            if (this.unCheckColor == "") {
                return getDefaultColor(xConfig.unRadioAndCheckBoxColor)
            }
            return getDefaultColor(this.unCheckColor)
        }
        ), "_isCheck" to computed<Boolean>(fun(): Boolean {
            return this.nowValue == this.value || this.undefaultCheck
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ), "_label" to computed<String>(fun(): String {
            return this.label
        }
        ), "_size" to computed<String>(fun(): String {
            var size = checkIsCssUnit(this.size, xConfig.unit)
            if (xConfig.fontScale == 1) {
                return size
            }
            var sizeNumber = parseInt(size)
            if (isNaN(sizeNumber)) {
                sizeNumber = 24
            }
            return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(size)
        }
        ), "_labelSpace" to computed<String>(fun(): String {
            return checkIsCssUnit(this.labelSpace, xConfig.unit)
        }
        ))
    }
    open var boxClick = ::gen_boxClick_fn
    open fun gen_boxClick_fn() {
        this.`$emit`("click")
        if (this._disabled) {
            return
        }
        var pelement = this.findParent(this)
        if (this.onlyChecked) {
            if ((pelement == null && this._isCheck) || this.undefaultCheck) {
                return
            }
            if (pelement != null) {
                var parent: XRadioGroupComponentPublicInstance = pelement as XRadioGroupComponentPublicInstance
                var nowValueChecked = parent.getAllSelecteds() as String
                if (nowValueChecked == this.value && this._isCheck) {
                    return
                }
            }
        }
        if (this._isCheck || this.undefaultCheck) {
            this.nowValue = this.unCheckValue
        } else {
            this.nowValue = this.value
        }
        this.`$emit`("update:modelValue", this.nowValue)
        this.`$emit`("change", this._isCheck, this.nowValue)
        if (this.undefaultCheck) {
            this.undefaultCheck = false
        } else {
            this.pushDataToParent(true)
        }
        this.setAni()
    }
    open var setAni = ::gen_setAni_fn
    open fun gen_setAni_fn() {
        if (this.hiddenCheckbox || this.isDestroy) {
            return
        }
        try {
            var el = this.`$refs`["checkboxBoxIcon"] as Element
            el.style.setProperty("opacity", if (this._isCheck) {
                1
            } else {
                0
            }
            )
            el.style.setProperty("transform", "scale(" + (if (this._isCheck) {
                0.44
            } else {
                0
            }
            ) + ")")
        }
         catch (e: Throwable) {}
    }
    open var setSelected = ::gen_setSelected_fn
    open fun gen_setSelected_fn(kVal: String) {
        val isChecked = kVal == this.value
        if (isChecked) {
            this.nowValue = this.value
        } else {
            this.nowValue = this.unCheckValue
        }
        this.setAni()
    }
    open var pushDataToParent = ::gen_pushDataToParent_fn
    open fun gen_pushDataToParent_fn(isChange: Boolean) {
        var pelement = this.findParent(this)
        if (pelement == null) {
            return
        }
        var parent: XRadioGroupComponentPublicInstance = pelement as XRadioGroupComponentPublicInstance
        parent.addItem(this as XRadioComponentPublicInstance, RADIO_ITEM_INFO(id = this.boxId as String, nowvalue = this.nowValue, value = this.value, unvalue = this.unCheckValue), isChange)
    }
    open var findParent = ::gen_findParent_fn
    open fun gen_findParent_fn(parent: VueComponent?): VueComponent? {
        if (parent == null) {
            return null
        }
        if (parent.`$parent` is XRadioGroupComponentPublicInstance) {
            return parent.`$parent`
        }
        var parents = this.findParent(parent.`$parent`)
        if (parents is XRadioGroupComponentPublicInstance) {
            return parents
        }
        return null
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("checkbox" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "flex-start")), "checkboxDisabled" to padStyleMapOf(utsMapOf("opacity" to 0.7)), "checkboxBoxIcon" to padStyleMapOf(utsMapOf("transitionDuration" to "350ms", "transitionTimingFunction" to "cubic-bezier(0.18,0.89,0.32,1)", "transitionProperty" to "opacity,transform", "opacity" to 0, "transform" to "scale(0)")), "radioBox" to padStyleMapOf(utsMapOf("borderTopLeftRadius" to 14, "borderTopRightRadius" to 14, "borderBottomRightRadius" to 14, "borderBottomLeftRadius" to 14, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "checkboxLabelBox" to padStyleMapOf(utsMapOf("flex" to 1)), "checkboxLabelBoxLeftSpace" to padStyleMapOf(utsMapOf("paddingLeft" to 10)), "checkboxLabel" to padStyleMapOf(utsMapOf("fontSize" to 14)), "@TRANSITION" to utsMapOf("checkboxBoxIcon" to utsMapOf("duration" to "350ms", "timingFunction" to "cubic-bezier(0.18,0.89,0.32,1)", "property" to "opacity,transform")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("change" to null, "click" to null, "update:modelValue" to null)
        var props = normalizePropsOptions(utsMapOf("color" to utsMapOf("type" to "String", "default" to ""), "unCheckColor" to utsMapOf("type" to "String", "default" to ""), "darkUnCheckColor" to utsMapOf("type" to "String", "default" to ""), "modelValue" to utsMapOf("type" to "String", "default" to ""), "defaultChecked" to utsMapOf("type" to "Boolean", "default" to false), "value" to utsMapOf("type" to "String", "default" to "1"), "unCheckValue" to utsMapOf("type" to "String", "default" to ""), "disabled" to utsMapOf("type" to "Boolean", "default" to false), "icon" to utsMapOf("type" to "String", "default" to "checkbox-blank-circle-fill"), "label" to utsMapOf("type" to "String", "default" to ""), "hiddenCheckbox" to utsMapOf("type" to "Boolean", "default" to false), "size" to utsMapOf("type" to "String", "default" to "24"), "iconSize" to utsMapOf("type" to "String", "default" to "20"), "labelFontSize" to utsMapOf("type" to "String", "default" to "15px"), "labelSpace" to utsMapOf("type" to "String", "default" to "10"), "onlyChecked" to utsMapOf("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = utsArrayOf(
            "color",
            "unCheckColor",
            "darkUnCheckColor",
            "modelValue",
            "defaultChecked",
            "value",
            "unCheckValue",
            "disabled",
            "icon",
            "label",
            "hiddenCheckbox",
            "size",
            "iconSize",
            "labelFontSize",
            "labelSpace",
            "onlyChecked"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
