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
open class GenUniModulesTmxUiComponentsXInputXInput : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.nowValue = this.modelValue
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
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        return createElementVNode("view", null, utsArrayOf(
            createElementVNode("view", utsMapOf("onClick" to _ctx.onClick, "class" to "xInput", "style" to normalizeStyle(utsMapOf("width" to _ctx._width))), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "xInputLeft"), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "left", UTSJSONObject(), fun(): UTSArray<Any> {
                        return utsArrayOf(
                            if (_ctx._leftText != "") {
                                createVNode(_component_x_text, utsMapOf("key" to 0, "font-size" to _ctx._fontSizeUnScale, "style" to normalizeStyle(utsMapOf("padding-right" to "12px"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        toDisplayString(_ctx._leftText)
                                    )
                                }), "_" to 1), 8, utsArrayOf(
                                    "font-size",
                                    "style"
                                ))
                            } else {
                                createCommentVNode("v-if", true)
                            }
                        )
                    }
                    )
                )),
                createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                    utsArrayOf(
                        _ctx._cclass
                    ),
                    "xInputCenter"
                )), "style" to normalizeStyle(utsArrayOf(
                    utsMapOf("borderRadius" to _ctx._round, "backgroundColor" to _ctx._color, "borderWidth" to _ctx._focusBorder[0], "borderStyle" to _ctx._focusBorder[1], "borderColor" to _ctx._focusBorder[2]),
                    _ctx._cstyle
                ))), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "inputLeft"),
                    if (isTrue(_ctx._leftIcon)) {
                        createElementVNode("view", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("margin-left" to "12px"))), utsArrayOf(
                            createVNode(_component_x_icon, utsMapOf("color" to _ctx._iconColor, "name" to _ctx._leftIcon, "font-size" to _ctx._fontSizeUnScale), null, 8, utsArrayOf(
                                "color",
                                "name",
                                "font-size"
                            ))
                        ), 4)
                    } else {
                        createCommentVNode("v-if", true)
                    }
                    ,
                    if (_ctx.type != "textarea") {
                        createElementVNode("input", utsMapOf("key" to 1, "inputmode" to _ctx.inputmode, "holdKeyboard" to _ctx._holdKeyboard, "placeholder-style" to _ctx._placeholderStyle, "style" to normalizeStyle(utsMapOf("color" to _ctx._fontColor, "fontSize" to _ctx._fontSize, "textAlign" to _ctx.align, "padding" to _ctx.inputPadding, "height" to _ctx._height)), "onInput" to _ctx.inputHndler, "onConfirm" to _ctx.confirm, "onLinechange" to _ctx.onLinechange, "onBlur" to _ctx.onBlur, "onKeyboardheightchange" to _ctx.onkeyboardheightchange, "onFocus" to _ctx.onFocus, "confirm-type" to "search", "value" to _ctx.nowValue, "placeholder" to _ctx._placeholder, "class" to "xInputCenterInput", "type" to _ctx.type, "disabled" to _ctx._disabled, "password" to (!_ctx.seePass && _ctx._password), "maxlength" to _ctx.maxlength, "cursorSpacing" to _ctx.cursorSpacing, "cursor-color" to _ctx._cursorColor, "autoFocus" to _ctx._autoFocus, "focus" to _ctx._focus, "confirmType" to _ctx.confirmType, "confirmHold" to _ctx.confirmHold, "cursor" to _ctx.cursor, "selectionStart" to _ctx._selectionStart, "selectionEnd" to _ctx._selectionEnd, "adjustPosition" to _ctx._adjustPosition, "fixed" to _ctx._fixed), null, 44, utsArrayOf(
                            "inputmode",
                            "holdKeyboard",
                            "placeholder-style",
                            "onInput",
                            "onConfirm",
                            "onLinechange",
                            "onBlur",
                            "onKeyboardheightchange",
                            "onFocus",
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
                        createCommentVNode("v-if", true)
                    }
                    ,
                    if (_ctx.type == "textarea") {
                        createElementVNode("textarea", utsMapOf("key" to 2, "holdKeyboard" to _ctx._holdKeyboard, "placeholder-style" to _ctx._placeholderStyle, "style" to normalizeStyle(utsMapOf("color" to _ctx._fontColor, "fontSize" to _ctx._fontSize, "textAlign" to _ctx.align, "padding" to _ctx.inputPadding, "height" to _ctx._height)), "onInput" to _ctx.inputHndler, "onConfirm" to _ctx.confirm, "onLinechange" to _ctx.onLinechange, "onBlur" to _ctx.onAreaBlur, "onKeyboardheightchange" to _ctx.onkeyboardheightchange, "onFocus" to _ctx.onAreaFocus, "value" to _ctx.nowValue, "placeholder" to _ctx._placeholder, "class" to "xInputCenterInput xInputCenterInputArea", "disabled" to _ctx._disabled, "maxlength" to _ctx.maxlength, "cursorSpacing" to _ctx.cursorSpacing, "cursor-color" to _ctx._cursorColor, "autoFocus" to _ctx._autoFocus, "focus" to _ctx._focus, "confirmHold" to _ctx.confirmHold, "cursor" to _ctx.cursor, "selectionStart" to _ctx._selectionStart, "selectionEnd" to _ctx._selectionEnd, "adjustPosition" to _ctx._adjustPosition, "fixed" to _ctx._fixed, "autoHeight" to _ctx._autoHeight), null, 44, utsArrayOf(
                            "holdKeyboard",
                            "placeholder-style",
                            "onInput",
                            "onConfirm",
                            "onLinechange",
                            "onBlur",
                            "onKeyboardheightchange",
                            "onFocus",
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
                        createCommentVNode("v-if", true)
                    }
                    ,
                    if (isTrue(_ctx._showClear && _ctx.nowValue.length > 0)) {
                        createElementVNode("view", utsMapOf("key" to 3, "onClick" to _ctx.clearHandler, "class" to "xInputclear", "style" to normalizeStyle(utsMapOf("padding" to "0 12px"))), utsArrayOf(
                            createVNode(_component_x_icon, utsMapOf("color" to _ctx._clearColor, "name" to "close-circle-fill"), null, 8, utsArrayOf(
                                "color"
                            ))
                        ), 12, utsArrayOf(
                            "onClick"
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    }
                    ,
                    if (isTrue(_ctx._password)) {
                        createElementVNode("view", utsMapOf("key" to 4, "onClick" to fun(){
                            _ctx.seePass = !_ctx.seePass
                        }, "class" to "xInputclear", "style" to normalizeStyle(utsMapOf("padding" to "0 12px"))), utsArrayOf(
                            if (isTrue(!_ctx.seePass)) {
                                createVNode(_component_x_icon, utsMapOf("key" to 0, "color" to _ctx._iconColor, "name" to "eye-off-line"), null, 8, utsArrayOf(
                                    "color"
                                ))
                            } else {
                                createVNode(_component_x_icon, utsMapOf("key" to 1, "color" to _ctx._iconColor, "name" to "eye-fill"), null, 8, utsArrayOf(
                                    "color"
                                ))
                            }
                        ), 12, utsArrayOf(
                            "onClick"
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    }
                    ,
                    renderSlot(_ctx.`$slots`, "inputRight")
                ), 6),
                createElementVNode("view", utsMapOf("class" to "xInputRight"), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "right", UTSJSONObject(), fun(): UTSArray<Any> {
                        return utsArrayOf(
                            if (_ctx._rightText != "") {
                                createVNode(_component_x_text, utsMapOf("key" to 0, "onClick" to _ctx.raightCellClick, "font-size" to _ctx._fontSizeUnScale, "class" to "xInputRightText"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        toDisplayString(_ctx._rightText)
                                    )
                                }), "_" to 1), 8, utsArrayOf(
                                    "onClick",
                                    "font-size"
                                ))
                            } else {
                                createCommentVNode("v-if", true)
                            }
                        )
                    }
                    )
                ))
            ), 12, utsArrayOf(
                "onClick"
            )),
            if (isTrue(_ctx._showFooter || _ctx._maxlength > -1)) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "xInputFooter"), utsArrayOf(
                    createElementVNode("view", null, utsArrayOf(
                        if (isTrue(_ctx._showFooter)) {
                            renderSlot(_ctx.`$slots`, "footer", utsMapOf("key" to 0))
                        } else {
                            createCommentVNode("v-if", true)
                        }
                    )),
                    if (isTrue(_ctx._maxlength > -1 && _ctx._showChartCount)) {
                        createElementVNode("text", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("margin-left" to "20px")), "class" to "xInputMaxLen"), toDisplayString(_ctx._inputLen) + "/" + toDisplayString(_ctx._maxlength), 5)
                    } else {
                        createCommentVNode("v-if", true)
                    },
                    if (isTrue(_ctx._maxlength == -1 && _ctx._showChartCount)) {
                        createElementVNode("text", utsMapOf("key" to 1, "style" to normalizeStyle(utsMapOf("margin-left" to "20px")), "class" to "xInputMaxLen"), " 字符数：" + toDisplayString(_ctx._inputLen), 5)
                    } else {
                        createCommentVNode("v-if", true)
                    }
                ))
            } else {
                createCommentVNode("v-if", true)
            }
        ))
    }
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
    open var focus: Boolean
        @JvmName("getFocus0")
        get() {
            return this.`$props`["focus"] as Boolean
        }
        @JvmName("setFocus0")
        set(value) {
            this.`$props`["focus"] = value
        }
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
    open var nowValue: String by `$data`
    open var seePass: Boolean by `$data`
    open var isFocus: Boolean
        @JvmName("getIsFocus1")
        get() {
            return this.`$data`["isFocus"] as Boolean
        }
        @JvmName("setIsFocus1")
        set(value) {
            this.`$data`["isFocus"] = value
        }
    open var _focusBorder: UTSArray<String> by `$data`
    open var _inputLen: Number by `$data`
    open var _maxlength: Number by `$data`
    open var _showFooter: Boolean by `$data`
    open var _holdKeyboard: Boolean by `$data`
    open var _autoHeight: Boolean by `$data`
    open var _showChartCount: Boolean by `$data`
    open var _fixed: Boolean by `$data`
    open var _width: String by `$data`
    open var _height: String by `$data`
    open var _cstyle: String by `$data`
    open var _placeholderStyle: String by `$data`
    open var _cclass: String by `$data`
    open var _round: String by `$data`
    open var _fontSize: String by `$data`
    open var _fontSizeUnScale: String by `$data`
    open var _showClear: Boolean by `$data`
    open var _rightText: String by `$data`
    open var _leftText: String by `$data`
    open var _confirmType: String by `$data`
    open var _placeholder: String by `$data`
    open var _iconColor: String by `$data`
    open var _color: String by `$data`
    open var _clearColor: String by `$data`
    open var _fontColor: String by `$data`
    open var _cursorColor: String by `$data`
    open var _leftIcon: String by `$data`
    open var _disabled: Boolean by `$data`
    open var _password: Boolean by `$data`
    open var _autoFocus: Boolean by `$data`
    open var _focus: Boolean by `$data`
    open var _adjustPosition: Boolean by `$data`
    open var _selectionEnd: Number by `$data`
    open var _selectionStart: Number by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("nowValue" to "", "seePass" to false, "isFocus" to false, "_focusBorder" to computed<UTSArray<String>>(fun(): UTSArray<String> {
            var style = this.focusBorder.slice(0)
            if (this.focusBorder.length < 4 && xConfig.inputFocusBorder.length == 4) {
                style = xConfig.inputFocusBorder.slice(0)
            }
            if (style.length < 4) {
                return utsArrayOf<String>("0px", "solid", "transparent")
            }
            var oldcolor = style[2]
            var hoverColor = getDefaultColor(style[3])
            if (oldcolor == "") {
                oldcolor = this._color
            }
            if (hoverColor == "") {
                hoverColor = getDefaultColor(xConfig.color)
            }
            return utsArrayOf(
                style[0],
                style[1],
                if (this.isFocus) {
                    hoverColor
                } else {
                    oldcolor
                }
            )
        }
        ), "_inputLen" to computed<Number>(fun(): Number {
            return this.nowValue.split("").length
        }
        ), "_maxlength" to computed<Number>(fun(): Number {
            return this.maxlength
        }
        ), "_showFooter" to computed<Boolean>(fun(): Boolean {
            return this.showFooter
        }
        ), "_holdKeyboard" to computed<Boolean>(fun(): Boolean {
            return this.holdKeyboard
        }
        ), "_autoHeight" to computed<Boolean>(fun(): Boolean {
            return this.autoHeight
        }
        ), "_showChartCount" to computed<Boolean>(fun(): Boolean {
            return this.showChartCount
        }
        ), "_fixed" to computed<Boolean>(fun(): Boolean {
            return this.fixed
        }
        ), "_width" to computed<String>(fun(): String {
            return checkIsCssUnit(this.width, xConfig.unit)
        }
        ), "_height" to computed<String>(fun(): String {
            if (this.autoHeight && this.type == "textarea") {
                return "auto"
            }
            return checkIsCssUnit(this.height, xConfig.unit)
        }
        ), "_cstyle" to computed<String>(fun(): String {
            return this._style
        }
        ), "_placeholderStyle" to computed<String>(fun(): String {
            return if (this.placeholderStyle == "") {
                xConfig.placeholderStyle
            } else {
                this.placeholderStyle
            }
        }
        ), "_cclass" to computed<String>(fun(): String {
            return this._class
        }
        ), "_round" to computed<String>(fun(): String {
            if (this.round == "") {
                return checkIsCssUnit(xConfig.inputRadius, xConfig.unit)
            }
            return checkIsCssUnit(this.round, xConfig.unit)
        }
        ), "_fontSize" to computed<String>(fun(): String {
            var fontSize = checkIsCssUnit(this.fontSize, xConfig.unit)
            if (xConfig.fontScale == 1) {
                return fontSize
            }
            var sizeNumber = parseInt(fontSize)
            if (isNaN(sizeNumber)) {
                sizeNumber = 16
            }
            return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
        }
        ), "_fontSizeUnScale" to computed<String>(fun(): String {
            return this.fontSize
        }
        ), "_showClear" to computed<Boolean>(fun(): Boolean {
            return this.showClear
        }
        ), "_rightText" to computed<String>(fun(): String {
            return this.rightText
        }
        ), "_leftText" to computed<String>(fun(): String {
            return this.leftText
        }
        ), "_confirmType" to computed<String>(fun(): String {
            return this.confirmType
        }
        ), "_placeholder" to computed<String>(fun(): String {
            return this.placeholder
        }
        ), "_iconColor" to computed<String>(fun(): String {
            if (this.iconColor == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.iconColor)
        }
        ), "_color" to computed<String>(fun(): String {
            var color = getDefaultColor(if (this.color == "") {
                xConfig.inputBgColor
            } else {
                this.color
            }
            )
            if (xConfig.dark == "dark") {
                if (this.darkBgColor == "") {
                    color = xConfig.inputDarkColor
                } else {
                    color = getDefaultColor(this.darkBgColor)
                }
            }
            return color
        }
        ), "_clearColor" to computed<String>(fun(): String {
            if (this.clearColor == "") {
                return this._iconColor
            }
            return getDefaultColor(this.clearColor)
        }
        ), "_fontColor" to computed<String>(fun(): String {
            var color = getDefaultColor(this.fontColor)
            if (xConfig.dark == "dark") {
                if (this.darkFontColor == "") {
                    color = "#ffffff"
                } else {
                    color = getDefaultColor(this.darkFontColor)
                }
            }
            return color
        }
        ), "_cursorColor" to computed<String>(fun(): String {
            var color = this.cursorColor
            if (this.cursorColor == "") {
                color = xConfig.color
            }
            return getDefaultColor(color)
        }
        ), "_leftIcon" to computed<String>(fun(): String {
            return this.leftIcon
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ), "_password" to computed<Boolean>(fun(): Boolean {
            return this.password
        }
        ), "_autoFocus" to computed<Boolean>(fun(): Boolean {
            return this.autoFocus
        }
        ), "_focus" to computed<Boolean>(fun(): Boolean {
            return this.focus
        }
        ), "_adjustPosition" to computed<Boolean>(fun(): Boolean {
            return this.adjustPosition
        }
        ), "_selectionEnd" to computed<Number>(fun(): Number {
            return this.selectionEnd
        }
        ), "_selectionStart" to computed<Number>(fun(): Number {
            return this.selectionStart
        }
        ))
    }
    open var getTrimAfterValue = ::gen_getTrimAfterValue_fn
    open fun gen_getTrimAfterValue_fn(value: String): String {
        if (this.trim) {
            return value.trim()
        }
        return value
    }
    open var confirm = ::gen_confirm_fn
    open fun gen_confirm_fn() {
        this.`$emit`("confirm", this.getTrimAfterValue(this.nowValue))
    }
    open var inputHndler = ::gen_inputHndler_fn
    open fun gen_inputHndler_fn(evt: UniInputEvent) {
        this.nowValue = this.getTrimAfterValue(evt.detail.value)
        this.`$emit`("input", this.nowValue)
        this.`$emit`("update:modelValue", this.nowValue)
        this.`$forceUpdate`()
    }
    open var raightCellClick = ::gen_raightCellClick_fn
    open fun gen_raightCellClick_fn() {
        this.`$emit`("rightClick", this.nowValue)
    }
    open var clearHandler = ::gen_clearHandler_fn
    open fun gen_clearHandler_fn() {
        this.nowValue = ""
        this.`$emit`("update:modelValue", "")
        this.`$emit`("clear", "")
    }
    open var onBlur = ::gen_onBlur_fn
    open fun gen_onBlur_fn(evt: UniInputBlurEvent) {
        var newVal = this.getTrimAfterValue(this.nowValue)
        if (newVal != this.nowValue) {
            this.nowValue = newVal
            this.`$emit`("update:modelValue", this.nowValue)
        }
        this.`$emit`("blur", evt)
        this.isFocus = false
        this.valid()
    }
    open var onFocus = ::gen_onFocus_fn
    open fun gen_onFocus_fn(evt: UniInputFocusEvent) {
        this.`$emit`("focus", evt)
        this.isFocus = true
    }
    open var onAreaBlur = ::gen_onAreaBlur_fn
    open fun gen_onAreaBlur_fn(evt: UniTextareaBlurEvent) {
        var newVal = this.getTrimAfterValue(this.nowValue)
        if (newVal != this.nowValue) {
            this.nowValue = newVal
            this.`$emit`("update:modelValue", this.nowValue)
        }
        this.`$emit`("blur", evt)
        this.isFocus = false
        this.valid()
    }
    open var onAreaFocus = ::gen_onAreaFocus_fn
    open fun gen_onAreaFocus_fn(evt: UniTextareaFocusEvent) {
        this.`$emit`("focus", evt)
        this.isFocus = true
    }
    open var onkeyboardheightchange = ::gen_onkeyboardheightchange_fn
    open fun gen_onkeyboardheightchange_fn(evt: UniInputKeyboardHeightChangeEvent) {
        this.`$emit`("keyboardheightchange", evt)
    }
    open var onLinechange = ::gen_onLinechange_fn
    open fun gen_onLinechange_fn(evt: UniTextareaLineChangeEvent) {
        this.`$emit`("linechange", evt)
    }
    open var onClick = ::gen_onClick_fn
    open fun gen_onClick_fn() {
        this.`$emit`("click")
    }
    open var valid = ::gen_valid_fn
    open fun gen_valid_fn() {
        var pelement = this.findParent(this)
        if (pelement == null) {
            return
        }
        var parent: XFormItemComponentPublicInstance = pelement as XFormItemComponentPublicInstance
        parent.validByblur(this.nowValue)
    }
    open var findParent = ::gen_findParent_fn
    open fun gen_findParent_fn(parent: VueComponent?): VueComponent? {
        if (parent == null) {
            return null
        }
        if (parent.`$parent` is XFormItemComponentPublicInstance) {
            return parent.`$parent`
        }
        var parents = this.findParent(parent.`$parent`)
        if (parents is XFormItemComponentPublicInstance) {
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
                return utsMapOf("xInputFooter" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to "8rpx")), "xInputMaxLen" to padStyleMapOf(utsMapOf("color" to "#888888", "fontSize" to 12, "textAlign" to "right")), "xInputCenterInput" to padStyleMapOf(utsMapOf("flex" to 1, "fontSize" to 16, "height" to "100%")), "xInputCenterInputArea" to padStyleMapOf(utsMapOf("lineHeight" to 1.6)), "xInput" to padStyleMapOf(utsMapOf("width" to "100%", "position" to "relative", "display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center")), "xInputCenter" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center", "height" to "100%", "flex" to 1)), "xInputLeft" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center", "height" to "100%")), "xInputRight" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end", "alignItems" to "center", "height" to "100%")), "xInputRightText" to padStyleMapOf(utsMapOf("paddingLeft" to 12, "fontSize" to 16)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("click" to null, "clear" to null, "rightClick" to null, "confirm" to null, "input" to null, "focus" to null, "blur" to null, "linechange" to null, "keyboardheightchange" to null, "update:modelValue" to null)
        var props = normalizePropsOptions(utsMapOf("_style" to utsMapOf("type" to "String", "default" to ""), "focusBorder" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "placeholderStyle" to utsMapOf("type" to "String", "default" to ""), "_class" to utsMapOf("type" to "String", "default" to ""), "round" to utsMapOf("type" to "String", "default" to ""), "showClear" to utsMapOf("type" to "Boolean", "default" to false), "rightText" to utsMapOf("type" to "String", "default" to ""), "leftText" to utsMapOf("type" to "String", "default" to ""), "modelValue" to utsMapOf("type" to "String", "default" to ""), "placeholder" to utsMapOf("type" to "String", "default" to "请输入"), "iconColor" to utsMapOf("type" to "String", "default" to ""), "clearColor" to utsMapOf("type" to "String", "default" to "#bfbfbf"), "color" to utsMapOf("type" to "String", "default" to ""), "darkBgColor" to utsMapOf("type" to "String", "default" to "transparent"), "fontColor" to utsMapOf("type" to "String", "default" to "#333333"), "darkFontColor" to utsMapOf("type" to "String", "default" to ""), "fontSize" to utsMapOf("type" to "String", "default" to "16"), "leftIcon" to utsMapOf("type" to "String", "default" to ""), "name" to utsMapOf("type" to "String", "default" to ""), "disabled" to utsMapOf("type" to "Boolean", "default" to false), "type" to utsMapOf("type" to "String", "default" to "text"), "password" to utsMapOf("type" to "Boolean", "default" to false), "maxlength" to utsMapOf("type" to "Number", "default" to -1), "cursorSpacing" to utsMapOf("type" to "Number", "default" to 0), "cursorColor" to utsMapOf("type" to "String", "default" to ""), "autoFocus" to utsMapOf("type" to "Boolean", "default" to false), "focus" to utsMapOf("type" to "Boolean", "default" to false), "confirmType" to utsMapOf("type" to "String", "default" to "next"), "confirmHold" to utsMapOf("type" to "Boolean", "default" to false), "cursor" to utsMapOf("type" to "Number", "default" to 0), "selectionStart" to utsMapOf("type" to "Number", "default" to -1), "selectionEnd" to utsMapOf("type" to "Number", "default" to -1), "adjustPosition" to utsMapOf("type" to "Boolean", "default" to true), "width" to utsMapOf("type" to "String", "default" to "auto"), "height" to utsMapOf("type" to "String", "default" to "44"), "trim" to utsMapOf("type" to "Boolean", "default" to true), "align" to utsMapOf("type" to "String", "default" to "left"), "autoHeight" to utsMapOf("type" to "Boolean", "default" to false), "fixed" to utsMapOf("type" to "Boolean", "default" to false), "showFooter" to utsMapOf("type" to "Boolean", "default" to false), "showChartCount" to utsMapOf("type" to "Boolean", "default" to false), "inputPadding" to utsMapOf("type" to "String", "default" to "8px 12px"), "inputmode" to utsMapOf("type" to "String", "default" to "text"), "holdKeyboard" to utsMapOf("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = utsArrayOf(
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
            "holdKeyboard"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
