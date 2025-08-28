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
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenUniModulesTmxUiComponentsXKeyboardNumberXKeyboardNumber : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.nowValue = this.modelValue
            var t = this
            if (this.modelShow) {
                this.tid = setTimeout(fun() {
                    t.show = t.modelShow
                }
                , 200)
            }
        }
        , __ins)
        onBeforeUnmount(fun() {
            clearTimeout(this.tid)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newvalue: String) {
            if (newvalue == this.nowValue) {
                return
            }
            this.nowValue = newvalue
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
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        val _component_x_drawer = resolveEasyComponent("x-drawer", GenUniModulesTmxUiComponentsXDrawerXDrawerClass)
        return _cE(Fragment, null, _uA(
            _cE("view", _uM("onClick" to _ctx.openShow), _uA(
                renderSlot(_ctx.`$slots`, "default")
            ), 8, _uA(
                "onClick"
            )),
            _cV(_component_x_drawer, _uM("onClose" to _ctx.onClose, "widthCoverCenter" to true, "disabled-scroll" to true, "bgColor" to _ctx._bgColor, "size" to "auto", "overflayBgColor" to "rgba(0,0,0,0)", "title" to _ctx.title, "onCancel" to _ctx.onCancel, "show" to _ctx.show, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.show = `$event`
            }
            , "show-close" to true), _uM("title" to withSlotCtx(fun(): UTSArray<Any> {
                return _uA(
                    _cE("view", _uM("style" to _nS(_uM("height" to "44px", "display" to "flex", "justify-content" to "center", "align-items" to "center", "flex-direction" to "row"))), _uA(
                        if (isTrue(_ctx.showValue)) {
                            _cE("text", _uM("key" to 0, "style" to _nS(_uM("fontSize" to if (_ctx.nowValue.split("").length > 0) {
                                "16px"
                            } else {
                                "12px"
                            }, "color" to _ctx._fontColor))), _tD(if (_ctx.nowValue.split("").length > 0) {
                                _ctx.nowValue
                            } else {
                                _ctx._title
                            }), 5)
                        } else {
                            _cE("text", _uM("key" to 1, "style" to _nS(_uM("fontSize" to "12px", "color" to _ctx._fontColor))), _tD(_ctx._title), 5)
                        }
                    ), 4)
                )
            }
            ), "default" to withSlotCtx(fun(): UTSArray<Any> {
                return _uA(
                    if (isTrue(_ctx.digit)) {
                        _cE("view", _uM("key" to 0, "class" to "xKeyboardNumber"), _uA(
                            _cE("view", _uM("class" to "xKeyboardLeft"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(_ctx.numbList, fun(item, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index, "class" to "xKeyboardLeftLine"), _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(item, fun(item2, index2, __index, _cached): Any {
                                            return _cE("view", _uM("onClick" to fun(){
                                                _ctx.itemClick(item2)
                                            }, "key" to index2, "class" to "xKeyboardItem", "hover-start-time" to 20, "hover-stay-time" to 250, "hover-class" to "xKeyboardHover", "style" to _nS(_uM("backgroundColor" to _ctx._btnColor))), _uA(
                                                _cE("text", _uM("style" to _nS(_uM("color" to _ctx._fontColor)), "class" to "xKeyboardText"), _tD(item2), 5)
                                            ), 12, _uA(
                                                "onClick"
                                            ))
                                        }), 128)
                                    ))
                                }), 128)
                            )),
                            _cE("view", _uM("class" to "xKeyboardRight"), _uA(
                                _cE("view", _uM("style" to _nS(_uM("backgroundColor" to _ctx._btnColor, "height" to "50px")), "onClick" to _ctx.del, "class" to "xKeyboardItemDel xKeyboardItemNoright", "hover-class" to "xKeyboardHover", "hover-start-time" to 10, "hover-stay-time" to 250), _uA(
                                    _cV(_component_x_icon, _uM("color" to _ctx._fontColor, "name" to "delete-back-2-line", "font-size" to "24"), null, 8, _uA(
                                        "color"
                                    ))
                                ), 12, _uA(
                                    "onClick"
                                )),
                                _cE("view", _uM("onClick" to _ctx.ok, "style" to _nS(_uM("backgroundColor" to _ctx._color)), "class" to "xKeyboardItem xKeyboardItemNoright", "hover-class" to "xKeyboardHover", "hover-start-time" to 10, "hover-stay-time" to 250), _uA(
                                    _cE("text", _uM("style" to _nS(_uM("color" to "white", "font-size" to "16px"))), "确认", 4)
                                ), 12, _uA(
                                    "onClick"
                                ))
                            ))
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    if (isTrue(!_ctx.digit)) {
                        _cE("view", _uM("key" to 1, "class" to "xKeyboardNumber"), _uA(
                            _cE("view", _uM("class" to "xKeyboardLeft"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(_ctx.numbList2, fun(item, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index, "class" to "xKeyboardLeftLine"), _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(item, fun(item2, index2, __index, _cached): Any {
                                            return _cE("view", _uM("onClick" to fun(){
                                                _ctx.itemClick(item2)
                                            }, "key" to index2, "class" to "xKeyboardItem", "hover-start-time" to 20, "hover-stay-time" to 250, "hover-class" to "xKeyboardHover", "style" to _nS(_uM("backgroundColor" to _ctx._btnColor))), _uA(
                                                _cE("text", _uM("style" to _nS(_uM("color" to _ctx._fontColor)), "class" to "xKeyboardText"), _tD(item2), 5)
                                            ), 12, _uA(
                                                "onClick"
                                            ))
                                        }), 128)
                                    ))
                                }), 128),
                                _cE("view", _uM("class" to "xKeyboardLeftLine"), _uA(
                                    _cE("view", _uM("onClick" to fun(){
                                        _ctx.itemClick("0")
                                    }, "class" to "xKeyboardItem", "hover-start-time" to 20, "hover-stay-time" to 250, "hover-class" to "xKeyboardHover", "style" to _nS(_uM("backgroundColor" to _ctx._btnColor))), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("color" to _ctx._fontColor)), "class" to "xKeyboardText"), "0", 4)
                                    ), 12, _uA(
                                        "onClick"
                                    )),
                                    _cE("view", _uM("onClick" to _ctx.del, "class" to "xKeyboardItem", "hover-start-time" to 20, "hover-stay-time" to 250, "hover-class" to "xKeyboardHover", "style" to _nS(_uM("backgroundColor" to _ctx._btnColor))), _uA(
                                        _cV(_component_x_icon, _uM("color" to _ctx._fontColor, "name" to "delete-back-2-line", "font-size" to "24"), null, 8, _uA(
                                            "color"
                                        ))
                                    ), 12, _uA(
                                        "onClick"
                                    )),
                                    _cE("view", _uM("onClick" to _ctx.ok, "style" to _nS(_uM("backgroundColor" to _ctx._color, "margin-right" to "5px")), "class" to "xKeyboardItem xKeyboardItemNoright", "hover-class" to "xKeyboardHover", "hover-start-time" to 10, "hover-stay-time" to 250), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("color" to "white", "font-size" to "16px"))), "确认", 4)
                                    ), 12, _uA(
                                        "onClick"
                                    ))
                                ))
                            ))
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("style" to _nS(_uM("height" to "12px"))), null, 4)
                )
            }
            ), "_" to 1), 8, _uA(
                "onClose",
                "bgColor",
                "title",
                "onCancel",
                "show",
                "onUpdate:show"
            ))
        ), 64)
    }
    open var showValue: Boolean by `$props`
    open var modelValue: String by `$props`
    open var maxLen: Number by `$props`
    open var modelShow: Boolean by `$props`
    open var title: String by `$props`
    open var color: String by `$props`
    open var btnColor: String by `$props`
    open var bgColor: String by `$props`
    open var fontColor: String by `$props`
    open var max: Number by `$props`
    open var digit: Boolean by `$props`
    open var mode: String by `$props`
    open var hold: Boolean by `$props`
    open var show: Boolean by `$data`
    open var nowValue: String by `$data`
    open var numbList: UTSArray<UTSArray<String>> by `$data`
    open var numbList2: UTSArray<UTSArray<String>> by `$data`
    open var tid: Number by `$data`
    open var _hold: Boolean by `$data`
    open var _color: String by `$data`
    open var _btnColor: String by `$data`
    open var _bgColor: String by `$data`
    open var _fontColor: String by `$data`
    open var _title: String by `$data`
    open var _max: Number by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("show" to false, "nowValue" to "", "numbList" to _uA(
            _uA(
                "1",
                "2",
                "3"
            ),
            _uA(
                "4",
                "5",
                "6"
            ),
            _uA(
                "7",
                "8",
                "9"
            ),
            _uA(
                "00",
                "0",
                "."
            )
        ), "numbList2" to _uA(
            _uA(
                "1",
                "2",
                "3"
            ),
            _uA(
                "4",
                "5",
                "6"
            ),
            _uA(
                "7",
                "8",
                "9"
            )
        ), "tid" to 0, "_hold" to computed<Boolean>(fun(): Boolean {
            return this.hold
        }
        ), "_color" to computed<String>(fun(): String {
            if (this.color == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.color)
        }
        ), "_btnColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                return xConfig.inputDarkColor
            }
            return getDefaultColor(this.btnColor)
        }
        ), "_bgColor" to computed<String>(fun(): String {
            return getDefaultColor(this.bgColor)
        }
        ), "_fontColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                return "#ffffff"
            }
            return getDefaultColor(this.fontColor)
        }
        ), "_title" to computed<String>(fun(): String {
            return this.title
        }
        ), "_max" to computed<Number>(fun(): Number {
            return this.max
        }
        ))
    }
    open var openShow = ::gen_openShow_fn
    open fun gen_openShow_fn() {
        this.show = true
        this.`$emit`("update:modelShow", true)
    }
    open var onCancel = ::gen_onCancel_fn
    open fun gen_onCancel_fn() {
        this.`$emit`("cancel", this.nowValue)
    }
    open var onClose = ::gen_onClose_fn
    open fun gen_onClose_fn() {
        this.`$emit`("update:modelShow", false)
    }
    open var itemClick = ::gen_itemClick_fn
    open fun gen_itemClick_fn(value: String) {
        var isDem = this.nowValue.lastIndexOf(".") > -1
        var isMaxvalu = this.nowValue.split("").length >= this.maxLen
        if (isMaxvalu) {
            return
        }
        if (this.mode == "number") {
            if (isDem && value == ".") {
                return
            }
            if ((this.nowValue.split("").length == 0 && value == "00") || (this.nowValue.split("").length == 0 && value == ".")) {
                return
            }
            if (this.nowValue.substring(0, 1) == "0" && this.nowValue.split("").length == 1 && value != ".") {
                return
            }
            var totalvalue = parseFloat(this.nowValue + value)
            if (totalvalue > this._max && this._max != 0) {
                uni_showToast(ShowToastOptions(title = "应该小于" + this._max.toString(10), icon = "error"))
                return
            }
        }
        this.nowValue = this.nowValue + value
        this.`$emit`("update:modelValue", this.nowValue)
        this.`$emit`("change", this.nowValue)
    }
    open var ok = ::gen_ok_fn
    open fun gen_ok_fn() {
        this.`$emit`("confirm", this.nowValue)
        if (!this._hold) {
            this.show = false
            this.`$emit`("update:modelShow", false)
        }
    }
    open var del = ::gen_del_fn
    open fun gen_del_fn() {
        if (this.nowValue.split("").length == 0) {
            return
        }
        var stp = this.nowValue.split("")
        stp = stp.slice(0, stp.length - 1)
        this.nowValue = stp.join("")
        this.`$emit`("update:modelValue", this.nowValue)
        this.`$emit`("change", this.nowValue)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xKeyboardText" to _pS(_uM("fontWeight" to "bold", "fontSize" to 20)), "xKeyboardHover" to _pS(_uM("opacity" to 0.6)), "xKeyboardLeftLine" to _pS(_uM("display" to "flex", "flexDirection" to "row")), "xKeyboardNumber" to _pS(_uM("display" to "flex", "flexDirection" to "row")), "xKeyboardLeft" to _pS(_uM("flex" to 1)), "xKeyboardItem" to _pS(_uM("flex" to 1, "height" to 50, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "marginRight" to 5, "marginBottom" to 5, "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6)), "xKeyboardItemDel" to _pS(_uM("height" to 50, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "marginRight" to 5, "marginBottom" to 5, "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6)), "xKeyboardItemNoright" to _pS(_uM("marginRight" to 0)), "xKeyboardRight" to _pS(_uM("width" to "140rpx", "display" to "flex", "flexDirection" to "column")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "update:modelShow" to null, "confirm" to null, "cancel" to null, "update:modelValue" to null)
        var props = _nP(_uM("showValue" to _uM("type" to "Boolean", "default" to false), "modelValue" to _uM("type" to "String", "default" to ""), "maxLen" to _uM("type" to "Number", "default" to 9), "modelShow" to _uM("type" to "Boolean", "default" to false), "title" to _uM("type" to "String", "default" to "安全键盘请放心输入"), "color" to _uM("type" to "String", "default" to ""), "btnColor" to _uM("type" to "String", "default" to "transparent"), "bgColor" to _uM("type" to "String", "default" to "info"), "fontColor" to _uM("type" to "String", "default" to "#3b3b3b"), "max" to _uM("type" to "Number", "default" to 0), "digit" to _uM("type" to "Boolean", "default" to true), "mode" to _uM("type" to "String", "default" to "number"), "hold" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "showValue",
            "modelValue",
            "maxLen",
            "modelShow",
            "title",
            "color",
            "btnColor",
            "bgColor",
            "fontColor",
            "max",
            "digit",
            "mode",
            "hold"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
