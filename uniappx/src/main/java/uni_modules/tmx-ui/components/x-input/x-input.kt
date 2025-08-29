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
open class GenUniModulesTmxUiComponentsXInputXInput : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var _style: String by `$props`
    open var focusBorder: UTSArray<String> by `$props`
    open var placeholderStyle: String by `$props`
    open var _class: String by `$props`
    open var round: String by `$props`
    open var showClear: Boolean by `$props`
    open var rightText: String by `$props`
    open var leftText: String by `$props`
    open var modelValue: String by `$props`
    open var placeholder: String by `$props`
    open var iconColor: String by `$props`
    open var clearColor: String by `$props`
    open var color: String by `$props`
    open var darkBgColor: String by `$props`
    open var fontColor: String by `$props`
    open var darkFontColor: String by `$props`
    open var fontSize: String by `$props`
    open var leftIcon: String by `$props`
    open var name: String by `$props`
    open var disabled: Boolean by `$props`
    open var type: String by `$props`
    open var password: Boolean by `$props`
    open var maxlength: Number by `$props`
    open var cursorSpacing: Number by `$props`
    open var cursorColor: String by `$props`
    open var autoFocus: Boolean by `$props`
    open var focus: Boolean by `$props`
    open var confirmType: String by `$props`
    open var confirmHold: Boolean by `$props`
    open var cursor: Number by `$props`
    open var selectionStart: Number by `$props`
    open var selectionEnd: Number by `$props`
    open var adjustPosition: Boolean by `$props`
    open var width: String by `$props`
    open var height: String by `$props`
    open var trim: Boolean by `$props`
    open var align: String by `$props`
    open var autoHeight: Boolean by `$props`
    open var fixed: Boolean by `$props`
    open var showFooter: Boolean by `$props`
    open var showChartCount: Boolean by `$props`
    open var inputPadding: String by `$props`
    open var inputmode: String by `$props`
    open var holdKeyboard: Boolean by `$props`
    open var isLink: Boolean by `$props`
    open var rightIcon: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsXInputXInput) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsXInputXInput
            val _cache = __ins.renderCache
            val i18n = xConfig.i18n
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val nowValue = ref("")
            val seePass = ref(false)
            val isFocus = ref(false)
            val proxy = getCurrentInstance()?.proxy ?: null
            val _focusBorder = computed(fun(): UTSArray<String> {
                var style = props.focusBorder.slice(0)
                if (props.focusBorder.length < 4 && xConfig.inputFocusBorder.length == 4) {
                    style = xConfig.inputFocusBorder.slice(0)
                }
                if (style.length < 4) {
                    return _uA<String>("0px", "solid", "transparent")
                }
                var oldcolor = style[2]
                var hoverColor = getDefaultColor(style[3])
                if (oldcolor == "") {
                    oldcolor = props.color
                }
                if (hoverColor == "") {
                    hoverColor = getDefaultColor(xConfig.color)
                }
                return _uA(
                    style[0],
                    style[1],
                    if (isFocus.value) {
                        hoverColor
                    } else {
                        oldcolor
                    }
                )
            }
            )
            val _inputLen = computed(fun(): Number {
                return nowValue.value.split("").length
            }
            )
            val _maxlength = computed(fun(): Number {
                return props.maxlength
            }
            )
            val _showFooter = computed(fun(): Boolean {
                return props.showFooter
            }
            )
            val _holdKeyboard = computed(fun(): Boolean {
                return props.holdKeyboard
            }
            )
            val _autoHeight = computed(fun(): Boolean {
                return props.autoHeight
            }
            )
            val _isLink = computed(fun(): Boolean {
                return props.isLink
            }
            )
            val _rightIcon = computed(fun(): String {
                return props.rightIcon
            }
            )
            val _showChartCount = computed(fun(): Boolean {
                return props.showChartCount
            }
            )
            val _fixed = computed(fun(): Boolean {
                return props.fixed
            }
            )
            val _width = computed(fun(): String {
                return checkIsCssUnit(props.width, xConfig.unit)
            }
            )
            val _height = computed(fun(): String {
                if (props.autoHeight && props.type == "textarea") {
                    return "auto"
                }
                return checkIsCssUnit(props.height, xConfig.unit)
            }
            )
            val _cstyle = computed(fun(): String {
                return props._style
            }
            )
            val _placeholderStyle = computed(fun(): String {
                return if (props.placeholderStyle == "") {
                    xConfig.placeholderStyle
                } else {
                    props.placeholderStyle
                }
            }
            )
            val _cclass = computed(fun(): String {
                return props._class
            }
            )
            val _round = computed(fun(): String {
                if (props.round == "") {
                    return checkIsCssUnit(xConfig.inputRadius, xConfig.unit)
                }
                return checkIsCssUnit(props.round, xConfig.unit)
            }
            )
            val _fontSize = computed(fun(): String {
                var fontSize = checkIsCssUnit(props.fontSize, xConfig.unit)
                if (xConfig.fontScale == 1) {
                    return fontSize
                }
                var sizeNumber = parseInt(fontSize)
                if (isNaN(sizeNumber)) {
                    sizeNumber = 16
                }
                return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
            }
            )
            val _fontSizeUnScale = computed(fun(): String {
                return props.fontSize
            }
            )
            val _showClear = computed(fun(): Boolean {
                return props.showClear
            }
            )
            val _rightText = computed(fun(): String {
                return props.rightText
            }
            )
            val _leftText = computed(fun(): String {
                return props.leftText
            }
            )
            val _confirmType = computed(fun(): String {
                return props.confirmType
            }
            )
            val _placeholder = computed(fun(): String {
                if (props.placeholder == "") {
                    return i18n!!.t("tmui4x.input.placeholder")
                }
                return props.placeholder
            }
            )
            val _iconColor = computed(fun(): String {
                if (props.iconColor == "") {
                    return getDefaultColor(xConfig.color)
                }
                return getDefaultColor(props.iconColor)
            }
            )
            val _color = computed(fun(): String {
                var color = getDefaultColor(if (props.color == "") {
                    xConfig.inputBgColor
                } else {
                    props.color
                }
                )
                if (xConfig.dark == "dark") {
                    if (props.darkBgColor == "") {
                        color = xConfig.inputDarkColor
                    } else {
                        color = getDefaultColor(props.darkBgColor)
                    }
                }
                return color
            }
            )
            val _clearColor = computed(fun(): String {
                if (props.clearColor == "") {
                    return _iconColor.value
                }
                return getDefaultColor(props.clearColor)
            }
            )
            val _fontColor = computed(fun(): String {
                var color = getDefaultColor(props.fontColor)
                if (xConfig.dark == "dark") {
                    if (props.darkFontColor == "") {
                        color = "#ffffff"
                    } else {
                        color = getDefaultColor(props.darkFontColor)
                    }
                }
                return color
            }
            )
            val _cursorColor = computed(fun(): String {
                var color = props.cursorColor
                if (props.cursorColor == "") {
                    color = xConfig.color
                }
                return getDefaultColor(color)
            }
            )
            val _leftIcon = computed(fun(): String {
                return props.leftIcon
            }
            )
            val _disabled = computed(fun(): Boolean {
                return props.disabled
            }
            )
            val _password = computed(fun(): Boolean {
                return props.password
            }
            )
            val _autoFocus = computed(fun(): Boolean {
                return props.autoFocus
            }
            )
            val _focus = computed(fun(): Boolean {
                return props.focus
            }
            )
            val _adjustPosition = computed(fun(): Boolean {
                return props.adjustPosition
            }
            )
            val _selectionEnd = computed(fun(): Number {
                return props.selectionEnd
            }
            )
            val _selectionStart = computed(fun(): Number {
                return props.selectionStart
            }
            )
            fun gen_getTrimAfterValue_fn(value: String): String {
                if (props.trim) {
                    return value.trim()
                }
                return value
            }
            val getTrimAfterValue = ::gen_getTrimAfterValue_fn
            fun gen_confirm_fn() {
                emits("confirm", getTrimAfterValue(nowValue.value))
            }
            val confirm = ::gen_confirm_fn
            fun gen_inputHndler_fn(evt: UniInputEvent) {
                nowValue.value = getTrimAfterValue(evt.detail.value)
                emits("input", nowValue.value)
                emits("update:modelValue", nowValue.value)
            }
            val inputHndler = ::gen_inputHndler_fn
            fun gen_raightCellClick_fn() {
                emits("rightClick", nowValue.value)
            }
            val raightCellClick = ::gen_raightCellClick_fn
            var findParent: FindParentCall? = null
            findParent = fun(parent: VueComponent?): VueComponent? {
                if (parent == null) {
                    return null
                }
                if (parent.`$parent` is XFormItemComponentPublicInstance) {
                    return parent.`$parent`
                }
                var parents = findParent!!(parent.`$parent`)
                if (parents is XFormItemComponentPublicInstance) {
                    return parents
                }
                return null
            }
            fun gen_valid_fn() {
                var pelement = findParent!!(proxy)
                if (pelement == null) {
                    return
                }
                var parent: XFormItemComponentPublicInstance = pelement as XFormItemComponentPublicInstance
                parent.validByblur(nowValue.value)
            }
            val valid = ::gen_valid_fn
            fun gen_clearHandler_fn() {
                nowValue.value = ""
                emits("update:modelValue", "")
                emits("clear", "")
            }
            val clearHandler = ::gen_clearHandler_fn
            fun gen_onBlur_fn(evt: UniInputBlurEvent) {
                var newVal = getTrimAfterValue(nowValue.value)
                if (newVal != nowValue.value) {
                    nowValue.value = newVal
                    emits("update:modelValue", nowValue.value)
                }
                emits("blur", evt)
                isFocus.value = false
                valid()
            }
            val onBlur = ::gen_onBlur_fn
            fun gen_onFocus_fn(evt: UniInputFocusEvent) {
                emits("focus", evt)
                isFocus.value = true
            }
            val onFocus = ::gen_onFocus_fn
            fun gen_onAreaBlur_fn(evt: UniTextareaBlurEvent) {
                var newVal = getTrimAfterValue(nowValue.value)
                if (newVal != nowValue.value) {
                    nowValue.value = newVal
                    emits("update:modelValue", nowValue.value)
                }
                emits("blur", evt)
                isFocus.value = false
                valid()
            }
            val onAreaBlur = ::gen_onAreaBlur_fn
            fun gen_onAreaFocus_fn(evt: UniTextareaFocusEvent) {
                emits("focus", evt)
                isFocus.value = true
            }
            val onAreaFocus = ::gen_onAreaFocus_fn
            fun gen_onkeyboardheightchange_fn(evt: UniInputKeyboardHeightChangeEvent) {
                emits("keyboardheightchange", evt)
            }
            val onkeyboardheightchange = ::gen_onkeyboardheightchange_fn
            fun gen_onLinechange_fn(evt: UniTextareaLineChangeEvent) {
                emits("linechange", evt)
            }
            val onLinechange = ::gen_onLinechange_fn
            fun gen_onClick_fn() {
                emits("click")
            }
            val onClick = ::gen_onClick_fn
            watch(fun(): String {
                return props.modelValue
            }
            , fun(newValue: String){
                if (newValue == nowValue.value) {
                    return
                }
                nowValue.value = newValue
            }
            )
            onMounted(fun(){
                nowValue.value = props.modelValue
            }
            )
            return fun(): Any? {
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("onClick" to onClick, "class" to "xInput", "style" to _nS(_uM("width" to _width.value))), _uA(
                        _cE("view", _uM("class" to "xInputLeft"), _uA(
                            renderSlot(_ctx.`$slots`, "left", UTSJSONObject(), fun(): UTSArray<Any> {
                                return _uA(
                                    if (_leftText.value != "") {
                                        _cV(_component_x_text, _uM("key" to 0, "font-size" to _fontSizeUnScale.value, "style" to _nS(_uM("padding-right" to "12px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(_leftText.value)
                                            )
                                        }), "_" to 1), 8, _uA(
                                            "font-size",
                                            "style"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )
                            }
                            )
                        )),
                        _cE("view", _uM("class" to _nC(_uA(
                            _uA(
                                _cclass.value
                            ),
                            "xInputCenter"
                        )), "style" to _nS(_uA(
                            _uM("borderRadius" to _round.value, "backgroundColor" to _color.value, "borderWidth" to _focusBorder.value[0], "borderStyle" to _focusBorder.value[1], "borderColor" to _focusBorder.value[2]),
                            _cstyle.value
                        ))), _uA(
                            renderSlot(_ctx.`$slots`, "inputLeft"),
                            if (isTrue(_leftIcon.value)) {
                                _cE("view", _uM("key" to 0, "style" to _nS(_uM("margin-left" to "12px"))), _uA(
                                    _cV(_component_x_icon, _uM("color" to _iconColor.value, "name" to _leftIcon.value, "font-size" to _fontSizeUnScale.value), null, 8, _uA(
                                        "color",
                                        "name",
                                        "font-size"
                                    ))
                                ), 4)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (props.type != "textarea") {
                                _cE("input", _uM("key" to 1, "inputmode" to props.inputmode, "holdKeyboard" to _holdKeyboard.value, "placeholder-style" to _placeholderStyle.value, "style" to _nS(_uM("color" to _fontColor.value, "fontSize" to _fontSize.value, "textAlign" to props.align, "padding" to props.inputPadding, "height" to _height.value)), "onInput" to inputHndler, "onConfirm" to confirm, "onLinechange" to onLinechange, "onBlur" to onBlur, "onKeyboardheightchange" to onkeyboardheightchange, "onFocus" to onFocus, "confirm-type" to "search", "value" to nowValue.value, "placeholder" to _placeholder.value, "class" to "xInputCenterInput", "type" to props.type, "disabled" to _disabled.value, "password" to (!seePass.value && _password.value), "maxlength" to props.maxlength, "cursorSpacing" to props.cursorSpacing, "cursor-color" to _cursorColor.value, "autoFocus" to _autoFocus.value, "focus" to _focus.value, "confirmType" to props.confirmType, "confirmHold" to props.confirmHold, "cursor" to props.cursor, "selectionStart" to _selectionStart.value, "selectionEnd" to _selectionEnd.value, "adjustPosition" to _adjustPosition.value, "fixed" to _fixed.value), null, 44, _uA(
                                    "inputmode",
                                    "holdKeyboard",
                                    "placeholder-style",
                                    "value",
                                    "placeholder",
                                    "type",
                                    "disabled",
                                    "password",
                                    "maxlength",
                                    "cursorSpacing",
                                    "cursor-color",
                                    "autoFocus",
                                    "focus",
                                    "confirmType",
                                    "confirmHold",
                                    "cursor",
                                    "selectionStart",
                                    "selectionEnd",
                                    "adjustPosition",
                                    "fixed"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (props.type == "textarea") {
                                _cE("textarea", _uM("key" to 2, "holdKeyboard" to _holdKeyboard.value, "placeholder-style" to _placeholderStyle.value, "style" to _nS(_uM("color" to _fontColor.value, "fontSize" to _fontSize.value, "textAlign" to props.align, "padding" to props.inputPadding, "height" to _height.value)), "onInput" to inputHndler, "onConfirm" to confirm, "onLinechange" to onLinechange, "onBlur" to onAreaBlur, "onKeyboardheightchange" to onkeyboardheightchange, "onFocus" to onAreaFocus, "value" to nowValue.value, "placeholder" to _placeholder.value, "class" to "xInputCenterInput xInputCenterInputArea", "disabled" to _disabled.value, "maxlength" to props.maxlength, "cursorSpacing" to props.cursorSpacing, "cursor-color" to _cursorColor.value, "autoFocus" to _autoFocus.value, "focus" to _focus.value, "confirmHold" to props.confirmHold, "cursor" to props.cursor, "selectionStart" to _selectionStart.value, "selectionEnd" to _selectionEnd.value, "adjustPosition" to _adjustPosition.value, "fixed" to _fixed.value, "autoHeight" to _autoHeight.value), null, 44, _uA(
                                    "holdKeyboard",
                                    "placeholder-style",
                                    "value",
                                    "placeholder",
                                    "disabled",
                                    "maxlength",
                                    "cursorSpacing",
                                    "cursor-color",
                                    "autoFocus",
                                    "focus",
                                    "confirmHold",
                                    "cursor",
                                    "selectionStart",
                                    "selectionEnd",
                                    "adjustPosition",
                                    "fixed",
                                    "autoHeight"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (isTrue(_showClear.value && nowValue.value.length > 0)) {
                                _cE("view", _uM("key" to 3, "onClick" to clearHandler, "class" to "xInputclear", "style" to _nS(_uM("padding" to "0 12px"))), _uA(
                                    _cV(_component_x_icon, _uM("color" to _clearColor.value, "name" to "close-circle-fill"), null, 8, _uA(
                                        "color"
                                    ))
                                ), 4)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (isTrue(_password.value)) {
                                _cE("view", _uM("key" to 4, "onClick" to fun(){
                                    seePass.value = !seePass.value
                                }, "class" to "xInputclear", "style" to _nS(_uM("padding" to "0 12px"))), _uA(
                                    if (isTrue(!seePass.value)) {
                                        _cV(_component_x_icon, _uM("key" to 0, "color" to _iconColor.value, "name" to "eye-off-line"), null, 8, _uA(
                                            "color"
                                        ))
                                    } else {
                                        _cV(_component_x_icon, _uM("key" to 1, "color" to _iconColor.value, "name" to "eye-fill"), null, 8, _uA(
                                            "color"
                                        ))
                                    }
                                ), 12, _uA(
                                    "onClick"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            renderSlot(_ctx.`$slots`, "inputRight"),
                            if (isTrue(_isLink.value || _rightIcon.value != "")) {
                                _cE("view", _uM("key" to 5, "style" to _nS(_uM("padding" to "0 12px"))), _uA(
                                    _cV(_component_x_icon, _uM("color" to _iconColor.value, "name" to "arrow-right-s-line"), null, 8, _uA(
                                        "color"
                                    ))
                                ), 4)
                            } else {
                                _cC("v-if", true)
                            }
                        ), 6),
                        _cE("view", _uM("class" to "xInputRight"), _uA(
                            renderSlot(_ctx.`$slots`, "right", UTSJSONObject(), fun(): UTSArray<Any> {
                                return _uA(
                                    if (_rightText.value != "") {
                                        _cV(_component_x_text, _uM("key" to 0, "onClick" to raightCellClick, "font-size" to _fontSizeUnScale.value, "class" to "xInputRightText"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(_rightText.value)
                                            )
                                        }), "_" to 1), 8, _uA(
                                            "font-size"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )
                            }
                            )
                        ))
                    ), 4),
                    if (isTrue(_showFooter.value || _maxlength.value > -1)) {
                        _cE("view", _uM("key" to 0, "class" to "xInputFooter"), _uA(
                            _cE("view", null, _uA(
                                if (isTrue(_showFooter.value)) {
                                    renderSlot(_ctx.`$slots`, "footer", _uM("key" to 0))
                                } else {
                                    _cC("v-if", true)
                                }
                            )),
                            if (isTrue(_maxlength.value > -1 && _showChartCount.value)) {
                                _cE("text", _uM("key" to 0, "style" to _nS(_uM("margin-left" to "20px")), "class" to "xInputMaxLen"), _tD(_inputLen.value) + "/" + _tD(_maxlength.value), 5)
                            } else {
                                _cC("v-if", true)
                            },
                            if (isTrue(_maxlength.value == -1 && _showChartCount.value)) {
                                _cE("text", _uM("key" to 1, "style" to _nS(_uM("margin-left" to "20px")), "class" to "xInputMaxLen"), " 字符数：" + _tD(_inputLen.value), 5)
                            } else {
                                _cC("v-if", true)
                            }
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                ))
            }
        }
        var name = "xInput"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xInputFooter" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to "8rpx")), "xInputMaxLen" to _pS(_uM("color" to "#888888", "fontSize" to 12, "textAlign" to "right")), "xInputCenterInput" to _pS(_uM("flex" to 1, "fontSize" to 16, "height" to "100%")), "xInputCenterInputArea" to _pS(_uM("lineHeight" to 1.6)), "xInput" to _pS(_uM("width" to "100%", "position" to "relative", "display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center")), "xInputCenter" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center", "height" to "100%", "flex" to 1)), "xInputLeft" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center", "height" to "100%")), "xInputRight" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end", "alignItems" to "center", "height" to "100%")), "xInputRightText" to _pS(_uM("paddingLeft" to 12, "fontSize" to 16)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null, "clear" to null, "rightClick" to null, "confirm" to null, "input" to null, "focus" to null, "blur" to null, "linechange" to null, "keyboardheightchange" to null, "update:modelValue" to null)
        var props = _nP(_uM("_style" to _uM("type" to "String", "required" to true, "default" to ""), "focusBorder" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "placeholderStyle" to _uM("type" to "String", "required" to true, "default" to ""), "_class" to _uM("type" to "String", "required" to true, "default" to ""), "round" to _uM("type" to "String", "required" to true, "default" to ""), "showClear" to _uM("type" to "Boolean", "required" to true, "default" to false), "rightText" to _uM("type" to "String", "required" to true, "default" to ""), "leftText" to _uM("type" to "String", "required" to true, "default" to ""), "modelValue" to _uM("type" to "String", "required" to true, "default" to ""), "placeholder" to _uM("type" to "String", "required" to true, "default" to ""), "iconColor" to _uM("type" to "String", "required" to true, "default" to ""), "clearColor" to _uM("type" to "String", "required" to true, "default" to "#bfbfbf"), "color" to _uM("type" to "String", "required" to true, "default" to ""), "darkBgColor" to _uM("type" to "String", "required" to true, "default" to "transparent"), "fontColor" to _uM("type" to "String", "required" to true, "default" to "#333333"), "darkFontColor" to _uM("type" to "String", "required" to true, "default" to ""), "fontSize" to _uM("type" to "String", "required" to true, "default" to "16"), "leftIcon" to _uM("type" to "String", "required" to true, "default" to ""), "name" to _uM("type" to "String", "required" to true, "default" to ""), "disabled" to _uM("type" to "Boolean", "required" to true, "default" to false), "type" to _uM("type" to "String", "required" to true, "default" to "text"), "password" to _uM("type" to "Boolean", "required" to true, "default" to false), "maxlength" to _uM("type" to "Number", "required" to true, "default" to -1), "cursorSpacing" to _uM("type" to "Number", "required" to true, "default" to 0), "cursorColor" to _uM("type" to "String", "required" to true, "default" to ""), "autoFocus" to _uM("type" to "Boolean", "required" to true, "default" to false), "focus" to _uM("type" to "Boolean", "required" to true, "default" to false), "confirmType" to _uM("type" to "String", "required" to true, "default" to "next"), "confirmHold" to _uM("type" to "Boolean", "required" to true, "default" to false), "cursor" to _uM("type" to "Number", "required" to true, "default" to 0), "selectionStart" to _uM("type" to "Number", "required" to true, "default" to -1), "selectionEnd" to _uM("type" to "Number", "required" to true, "default" to -1), "adjustPosition" to _uM("type" to "Boolean", "required" to true, "default" to true), "width" to _uM("type" to "String", "required" to true, "default" to "auto"), "height" to _uM("type" to "String", "required" to true, "default" to "44"), "trim" to _uM("type" to "Boolean", "required" to true, "default" to true), "align" to _uM("type" to "String", "required" to true, "default" to "left"), "autoHeight" to _uM("type" to "Boolean", "required" to true, "default" to false), "fixed" to _uM("type" to "Boolean", "required" to true, "default" to false), "showFooter" to _uM("type" to "Boolean", "required" to true, "default" to false), "showChartCount" to _uM("type" to "Boolean", "required" to true, "default" to false), "inputPadding" to _uM("type" to "String", "required" to true, "default" to "8px 12px"), "inputmode" to _uM("type" to "String", "required" to true, "default" to "text"), "holdKeyboard" to _uM("type" to "Boolean", "required" to true, "default" to false), "isLink" to _uM("type" to "Boolean", "required" to true, "default" to false), "rightIcon" to _uM("type" to "String", "required" to true, "default" to "")))
        var propsNeedCastKeys = _uA(
            "_style",
            "focusBorder",
            "placeholderStyle",
            "_class",
            "round",
            "showClear",
            "rightText",
            "leftText",
            "modelValue",
            "placeholder",
            "iconColor",
            "clearColor",
            "color",
            "darkBgColor",
            "fontColor",
            "darkFontColor",
            "fontSize",
            "leftIcon",
            "name",
            "disabled",
            "type",
            "password",
            "maxlength",
            "cursorSpacing",
            "cursorColor",
            "autoFocus",
            "focus",
            "confirmType",
            "confirmHold",
            "cursor",
            "selectionStart",
            "selectionEnd",
            "adjustPosition",
            "width",
            "height",
            "trim",
            "align",
            "autoHeight",
            "fixed",
            "showFooter",
            "showChartCount",
            "inputPadding",
            "inputmode",
            "holdKeyboard",
            "isLink",
            "rightIcon"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
