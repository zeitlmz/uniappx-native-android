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
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
open class GenUniModulesTmxUiComponentsXBadgeXBadge : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.getNodeInfo()
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.label
        }
        , fun() {
            var t = this
            this.`$nextTick`(fun(){
                t.getNodeInfo()
            }
            )
        }
        )
        this.`$watch`(fun(): Any? {
            return this.count
        }
        , fun() {
            var t = this
            this.`$nextTick`(fun(){
                t.getNodeInfo()
            }
            )
        }
        )
        this.`$watch`(fun(): Any? {
            return this.position
        }
        , fun() {
            var t = this
            this.`$nextTick`(fun(){
                t.getNodeInfo()
            }
            )
        }
        )
        this.`$watch`(fun(): Any? {
            return this.offset
        }
        , fun() {
            var t = this
            this.`$nextTick`(fun(){
                t.getNodeInfo()
            }
            )
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", _uM("class" to "xBadge", "style" to _nS(_uM("padding" to _ctx.padding))), _uA(
            _cE("view", _uM("class" to "xBadgeWrap"), _uA(
                _cE("text", _uM("style" to _nS(_ctx._cStyles[0]!!), "class" to _nC(_uA(
                    "xBadge-dot",
                    _uA(
                        if (_ctx._isDot) {
                            "noneShow"
                        } else {
                            "nonex"
                        }
                    )
                ))), null, 6),
                _cE("view", _uM("id" to "xBadge-countAndLabel", "class" to _nC(_uA(
                    "xBadge-countAndLabel",
                    _uA(
                        if (_ctx._isDot) {
                            "nonex"
                        } else {
                            "noneShow"
                        }
                    )
                )), "style" to _nS(_ctx._cStyles[1]!!)), _uA(
                    _cE("text", _uM("class" to "xBadge-countAndLabelText", "style" to _nS(_uM("color" to _ctx._fontColor, "fontSize" to _ctx._fontSize))), _tD(_ctx._label), 5)
                ), 6),
                renderSlot(_ctx.`$slots`, "default")
            ))
        ), 4)
    }
    open var fontSize: String by `$props`
    open var bgColor: String by `$props`
    open var fontColor: String by `$props`
    open var dot: Boolean by `$props`
    open var count: Number by `$props`
    open var maxCount: Number by `$props`
    open var label: String by `$props`
    open var position: String by `$props`
    open var offset: UTSArray<Number> by `$props`
    open var padding: String by `$data`
    open var test: Map<String, String> by `$data`
    open var _offset: UTSArray<Number> by `$data`
    open var _isDot: Boolean by `$data`
    open var _cStyles: UTSArray<Map<String, String>> by `$data`
    open var _fontColor: String by `$data`
    open var _fontSize: String by `$data`
    open var _label: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("padding" to "4px 4px", "test" to Map<String, String>(_uA(
            _uA(
                "border",
                "2px solid red"
            ),
            _uA(
                "background-color",
                "green"
            )
        )), "_offset" to computed<UTSArray<Number>>(fun(): UTSArray<Number> {
            return this.offset
        }
        ), "_isDot" to computed<Boolean>(fun(): Boolean {
            if (this.label != "" || this.count > 0 || !this.dot) {
                return false
            }
            return true
        }
        ), "_cStyles" to computed<UTSArray<Map<String, String>>>(fun(): UTSArray<Map<String, String>> {
            var trs = ""
            if (this.position == "right") {
                trs = "translate(50%, -50%)"
            } else if (this.position == "left") {
                trs = "translate(-50%, -50%)"
            } else if (this.position == "bottomLeft") {
                trs = "translate(-50%, 50%)"
            } else if (this.position == "bottomRight") {
                trs = "translate(50%, 50%)"
            } else if (this.position == "top") {
                trs = "translate(0%, -50%)"
            } else if (this.position == "bottom") {
                trs = "translate(0%, 50%)"
            }
            var top = ""
            var bottom = ""
            var left = ""
            var right = ""
            if (this.position == "top") {
                top = "0px"
                left = "auto"
                right = "auto"
            } else if (this.position == "bottom") {
                bottom = "0px"
                left = "auto"
                right = "auto"
            } else if (this.position == "right") {
                top = this._offset[1].toString(10) + "px"
                right = this._offset[0].toString(10) + "px"
            } else if (this.position == "left") {
                top = "0px"
                left = "0px"
            } else if (this.position == "bottomLeft") {
                bottom = "0px"
                left = "0px"
            } else if (this.position == "bottomRight") {
                bottom = "0px"
                right = "0px"
            }
            var dotMapCs = Map<String, String>()
            dotMapCs.set("background", getDefaultColor(this.bgColor))
            dotMapCs.set("left", left)
            dotMapCs.set("right", right)
            dotMapCs.set("top", top)
            dotMapCs.set("bottom", bottom)
            dotMapCs.set("transform", trs)
            var labelMapCs = Map<String, String>()
            labelMapCs.set("background", getDefaultColor(this.bgColor))
            labelMapCs.set("left", left)
            labelMapCs.set("right", right)
            labelMapCs.set("top", top)
            labelMapCs.set("bottom", bottom)
            labelMapCs.set("transform", trs)
            labelMapCs.set("visibility", if (this._label == "") {
                "hidden"
            } else {
                "visible"
            }
            )
            var t = this
            this.`$nextTick`(fun(){
                t.getNodeInfo()
            }
            )
            return _uA<Map<String, String>>(dotMapCs, labelMapCs)
        }
        ), "_fontColor" to computed<String>(fun(): String {
            return getDefaultColor(this.fontColor)
        }
        ), "_fontSize" to computed<String>(fun(): String {
            return checkIsCssUnit(this.fontSize, xConfig.unit)
        }
        ), "_label" to computed<String>(fun(): String {
            if (this.label != "") {
                return this.label
            }
            if (this.count > 0 && this.count <= this.maxCount) {
                return this.count.toString()
            }
            if (this.count <= 0) {
                return ""
            }
            return this.maxCount!!.toString() + "+"
        }
        ))
    }
    open var getNodeInfo = ::gen_getNodeInfo_fn
    open fun gen_getNodeInfo_fn() {
        var t = this
        uni_createSelectorQuery().`in`(this).select(".xBadge-countAndLabel").boundingClientRect().exec(fun(ret){
            if (ret.length == 0) {
                return
            }
            var nodeinfo = ret[0] as NodeInfo
            if (nodeinfo == null) {
                return
            }
            var width = nodeinfo.width as Number
            var height = nodeinfo.height as Number
            var max = Math.max(width, height)
            var px = Math.ceil(max / 2)
            t.padding = "" + px + "px " + px + "px"
        }
        )
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xBadge" to _pS(_uM("overflow" to "visible")), "xBadge-countAndLabel" to _pS(_uM("position" to "absolute", "zIndex" to 3, "borderTopLeftRadius" to 100, "borderTopRightRadius" to 100, "borderBottomRightRadius" to 100, "borderBottomLeftRadius" to 100, "paddingTop" to "0rpx", "paddingRight" to 4, "paddingBottom" to "0rpx", "paddingLeft" to 4, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "xBadge-countAndLabelText" to _pS(_uM("lineHeight" to 1.5, "textAlign" to "center")), "xBadge-dot" to _pS(_uM("position" to "absolute", "width" to 6, "height" to 6, "borderTopLeftRadius" to 18, "borderTopRightRadius" to 18, "borderBottomRightRadius" to 18, "borderBottomLeftRadius" to 18, "zIndex" to 3, "opacity" to 0)), "noneShow" to _pS(_uM("opacity" to 1)), "nonex" to _pS(_uM("opacity" to 0)), "xBadgeWrap" to _pS(_uM("flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center", "overflow" to "visible", "position" to "relative")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("fontSize" to _uM("type" to "String", "default" to "9"), "bgColor" to _uM("type" to "String", "default" to "error"), "fontColor" to _uM("type" to "String", "default" to "white"), "dot" to _uM("type" to "Boolean", "default" to true), "count" to _uM("type" to "Number", "default" to 0), "maxCount" to _uM("type" to "Number", "default" to 99), "label" to _uM("type" to "String", "default" to ""), "position" to _uM("type" to "String", "default" to "right"), "offset" to _uM("type" to "Array", "default" to fun(): UTSArray<Number> {
            return _uA<Number>(0, 0)
        }
        , "validator" to fun(kVal: UTSArray<Number>): Boolean {
            if (kVal.length == 0 || kVal.length == 2) {
                return true
            }
            console.error("x:必须是长度为2的数字数组参数或者空数组")
            return false
        }
        )))
        var propsNeedCastKeys = _uA(
            "fontSize",
            "bgColor",
            "fontColor",
            "dot",
            "count",
            "maxCount",
            "label",
            "position",
            "offset"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
