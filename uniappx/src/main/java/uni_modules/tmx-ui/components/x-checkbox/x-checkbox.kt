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
open class GenUniModulesTmxUiComponentsXCheckboxXCheckbox : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onBeforeUnmount(fun() {
            this.isDestroy = true
        }
        , __ins)
        onMounted(fun() {
            var t = this
            this.isDestroy = false
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
        this.`$watch`(fun(): Any? {
            return this.indeterminate
        }
        , fun(newValue: Boolean) {
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
        return _cE("view", _uM("class" to _nC(_uA(
            _uA(
                if (_ctx._disabled) {
                    "checkboxDisabled"
                } else {
                    ""
                }
            ),
            "checkbox"
        )), "onClick" to _ctx.boxClick), _uA(
            if (isTrue(!_ctx.hiddenCheckbox)) {
                _cE("view", _uM("key" to 0, "class" to "checkboxBox", "style" to _nS(_uM("backgroundColor" to if (_ctx._isCheck) {
                    _ctx._color
                } else {
                    "transparent"
                }, "border" to ("1px solid " + (if (_ctx._isCheck) {
                    _ctx._color
                } else {
                    _ctx._unCheckColor
                })), "borderRadius" to _ctx._round, "width" to _ctx._size, "height" to _ctx._size))), _uA(
                    _cE("view", _uM("id" to _ctx.boxId, "ref" to "checkboxBoxIcon", "class" to "checkboxBoxIcon"), _uA(
                        _cV(_component_x_icon, _uM("color" to "white", "name" to if (_ctx._indeterminate) {
                            "subtract-line"
                        } else {
                            _ctx.icon
                        }, "font-size" to _ctx.iconSize), null, 8, _uA(
                            "name",
                            "font-size"
                        ))
                    ), 8, _uA(
                        "id"
                    ))
                ), 4)
            } else {
                _cC("v-if", true)
            }
            ,
            _cE("view", _uM("class" to "checkboxLabelBox", "style" to _nS(_uM("paddingLeft" to if (!_ctx.hiddenCheckbox) {
                _ctx._labelSpace
            } else {
                "0px"
            }
            ))), _uA(
                renderSlot(_ctx.`$slots`, "label", GenUniModulesTmxUiComponentsXCheckboxXCheckboxSlotDataLabel(checked = _ctx._isCheck, value = _ctx.nowValue), fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_x_text, _uM("font-size" to _ctx.labelFontSize, "class" to "checkboxLabel"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _tD(_ctx._label)
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "font-size"
                        ))
                    )
                }
                )
            ), 4)
        ), 10, _uA(
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
    open var indeterminate: Boolean by `$props`
    open var size: String by `$props`
    open var iconSize: String by `$props`
    open var labelFontSize: String by `$props`
    open var labelSpace: String by `$props`
    open var round: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var nowValue: String by `$data`
    open var boxId: Any? by `$data`
    open var tid: Number by `$data`
    open var isDestroy: Boolean by `$data`
    open var undefaultCheck: Boolean by `$data`
    open var _color: String by `$data`
    open var _round: String by `$data`
    open var _unCheckColor: String by `$data`
    open var _isCheck: Boolean by `$data`
    open var _disabled: Boolean by `$data`
    open var _label: String by `$data`
    open var _indeterminate: Boolean by `$data`
    open var _size: String by `$data`
    open var _labelSpace: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "nowValue" to "", "boxId" to ("xCheckbox-" + getUid()), "tid" to 0, "isDestroy" to false, "undefaultCheck" to false, "_color" to computed<String>(fun(): String {
            if (this.color == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.color)
        }
        ), "_round" to computed<String>(fun(): String {
            return checkIsCssUnit(this.round, xConfig.unit)
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
            return this.nowValue == this.value || this.undefaultCheck || this._indeterminate
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ), "_label" to computed<String>(fun(): String {
            return this.label
        }
        ), "_indeterminate" to computed<Boolean>(fun(): Boolean {
            return this.indeterminate
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
        if ((this._isCheck && !this.indeterminate) || this.undefaultCheck) {
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
                0.74
            } else {
                0
            }
            ) + ")")
        }
         catch (e: Throwable) {}
    }
    open var setSelected = ::gen_setSelected_fn
    open fun gen_setSelected_fn(kVal: UTSArray<String>) {
        if (!UTSArray.isArray(kVal)) {
            throw UTSError("val must be an array")
        }
        val isChecked = kVal.includes(this.value)
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
        var parent: XCheckboxGroupComponentPublicInstance = pelement as XCheckboxGroupComponentPublicInstance
        parent.addItem(this, CHECKBOX_ITEM_INFO(id = this.boxId as String, nowvalue = this.nowValue, value = this.value, unvalue = this.unCheckValue), isChange)
    }
    open var findParent = ::gen_findParent_fn
    open fun gen_findParent_fn(parent: VueComponent?): VueComponent? {
        if (parent == null) {
            return null
        }
        if (parent.`$parent` is XCheckboxGroupComponentPublicInstance) {
            return parent.`$parent`
        }
        var parents = this.findParent(parent.`$parent`)
        if (parents is XCheckboxGroupComponentPublicInstance) {
            return parents
        }
        return null
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("checkbox" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "flex-start")), "checkboxLabelBox" to _pS(_uM("flex" to 1)), "checkboxDisabled" to _pS(_uM("opacity" to 0.7)), "checkboxBoxIcon" to _pS(_uM("transitionDuration" to "350ms", "transitionTimingFunction" to "cubic-bezier(0.18,0.89,0.32,1)", "transitionProperty" to "opacity,transform", "opacity" to 0, "transform" to "scale(0)")), "checkboxBox" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "checkboxLabelBoxLeftSpace" to _pS(_uM("paddingLeft" to 10)), "checkboxLabel" to _pS(_uM("fontSize" to 14)), "@TRANSITION" to _uM("checkboxBoxIcon" to _uM("duration" to "350ms", "timingFunction" to "cubic-bezier(0.18,0.89,0.32,1)", "property" to "opacity,transform")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "click" to null, "update:modelValue" to null)
        var props = _nP(_uM("color" to _uM("type" to "String", "default" to ""), "unCheckColor" to _uM("type" to "String", "default" to ""), "darkUnCheckColor" to _uM("type" to "String", "default" to ""), "modelValue" to _uM("type" to "String", "default" to ""), "defaultChecked" to _uM("type" to "Boolean", "default" to false), "value" to _uM("type" to "String", "default" to "1"), "unCheckValue" to _uM("type" to "String", "default" to ""), "disabled" to _uM("type" to "Boolean", "default" to false), "icon" to _uM("type" to "String", "default" to "check-line"), "label" to _uM("type" to "String", "default" to ""), "hiddenCheckbox" to _uM("type" to "Boolean", "default" to false), "indeterminate" to _uM("type" to "Boolean", "default" to false), "size" to _uM("type" to "String", "default" to "24"), "iconSize" to _uM("type" to "String", "default" to "20"), "labelFontSize" to _uM("type" to "String", "default" to "15px"), "labelSpace" to _uM("type" to "String", "default" to "10"), "round" to _uM("type" to "String", "default" to "4")))
        var propsNeedCastKeys = _uA(
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
            "indeterminate",
            "size",
            "iconSize",
            "labelFontSize",
            "labelSpace",
            "round"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
