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
open class GenUniModulesTmxUiComponentsXPickerTimeXPickerTime : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.nowPull = getPagePullRefresh()
            var nowValue = xDate(this.default_time_date + this.modelValue)
            this.defaultModelvalue(nowValue.format("hh:mm:ss"), this.modelValue != "")
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newvalue: String) {
            if (newvalue == "") {
                return
            }
            var isType = this._getDateType
            var nowValue = xDate(this.default_time_date + newvalue)
            if (nowValue.isBetweenOf(xDate(this.nowValueStr), "=", isType)) {
                return
            }
            this.defaultModelvalue(nowValue.format("hh:mm:ss"), true)
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
        val _component_x_picker_view = resolveEasyComponent("x-picker-view", GenUniModulesTmxUiComponentsXPickerViewXPickerViewClass)
        val _component_x_drawer = resolveEasyComponent("x-drawer", GenUniModulesTmxUiComponentsXDrawerXDrawerClass)
        return createElementVNode(Fragment, null, utsArrayOf(
            createElementVNode("view", utsMapOf("onClick" to _ctx.openShow), utsArrayOf(
                renderSlot(_ctx.`$slots`, "default")
            ), 8, utsArrayOf(
                "onClick"
            )),
            createVNode(_component_x_drawer, utsMapOf("cancel-text" to _ctx.cancelText, "confirm-text" to _ctx.confirmText, "zIndex" to _ctx.zIndex, "widthCoverCenter" to _ctx.widthCoverCenter, "disabledScroll" to true, "title" to _ctx.title, "onClose" to _ctx.onClose, "onConfirm" to _ctx.onConfirm, "onCancel" to _ctx.onCancel, "showFooter" to true, "show" to _ctx.show, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.show = `$event`
            }
            , "show-close" to _ctx.showClose, "size" to "410px"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "xPickerDateWrap"), utsArrayOf(
                        if (isTrue(_ctx.show)) {
                            createElementVNode(Fragment, utsMapOf("key" to 0), RenderHelpers.renderList(_ctx.dateList.slice(3), fun(item, index, __index, _cached): Any {
                                return createVNode(_component_x_picker_view, utsMapOf("cellUnits" to utsArrayOf(
                                    _ctx.cellUnits[index + 3]
                                ), "key" to (index + 3), "onChange" to fun(`$event`: Any){
                                    _ctx.mchange(`$event` as UTSArray<String>, index + 3)
                                }, "model-value" to _ctx.nowValue[index + 3], "style" to normalizeStyle(utsMapOf("flex" to "1")), "list" to item), null, 8, utsArrayOf(
                                    "cellUnits",
                                    "onChange",
                                    "model-value",
                                    "style",
                                    "list"
                                ))
                            }), 128)
                        } else {
                            createCommentVNode("v-if", true)
                        }
                    ))
                )
            }
            ), "_" to 1), 8, utsArrayOf(
                "cancel-text",
                "confirm-text",
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
    open var modelValue: String by `$props`
    open var modelStr: String by `$props`
    open var modelShow: Boolean by `$props`
    open var title: String by `$props`
    open var cancelText: String by `$props`
    open var confirmText: String by `$props`
    open var start: String by `$props`
    open var end: String by `$props`
    open var type: String by `$props`
    open var format: String by `$props`
    open var cellUnits: UTSArray<String> by `$props`
    open var zIndex: Number by `$props`
    open var showClose: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var widthCoverCenter: Boolean by `$props`
    open var steps: Number by `$props`
    open var default_year: Number by `$data`
    open var default_month: Number by `$data`
    open var default_date: Number by `$data`
    open var default_time_date: String by `$data`
    open var show: Boolean by `$data`
    open var nowValue: UTSArray<UTSArray<String>> by `$data`
    open var nowValueStr: String by `$data`
    open var startDate: xDate by `$data`
    open var endDate: xDate by `$data`
    open var dateList: UTSArray<UTSArray<PICKER_ITEM_INFO>> by `$data`
    open var nowPull: Boolean by `$data`
    open var _start_date: xDate by `$data`
    open var _end_date: xDate by `$data`
    open var _getDateType: xDateTypeTime by `$data`
    open var _disabled: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        var startValue = xDate("2000-1-1 0:0:0")
        var endValue = xDate("2000-1-1 23:59:59")
        return utsMapOf("default_year" to 2000, "default_month" to 1, "default_date" to 1, "default_time_date" to "2000-1-1 ", "show" to false, "nowValue" to utsArrayOf<UTSArray<String>>(), "nowValueStr" to "", "startDate" to startValue, "endDate" to endValue, "dateList" to utsArrayOf<UTSArray<PICKER_ITEM_INFO>>(), "nowPull" to false, "_start_date" to computed<xDate>(fun(): xDate {
            if (this.start == "") {
                return this.startDate
            }
            return xDate(this.default_time_date + this.start)
        }
        ), "_end_date" to computed<xDate>(fun(): xDate {
            if (this.end == "") {
                return this.endDate
            }
            return xDate(this.default_time_date + this.end)
        }
        ), "_getDateType" to computed<xDateTypeTime>(fun(): xDateTypeTime {
            var isType = "s" as xDateTypeTime
            if (this.type == "year") {
                isType = "y"
            }
            if (this.type == "month") {
                isType = "m"
            }
            if (this.type == "day") {
                isType = "d"
            }
            if (this.type == "hour") {
                isType = "h"
            }
            if (this.type == "minute") {
                isType = "M"
            }
            return isType
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ))
    }
    open var defaultModelvalue = ::gen_defaultModelvalue_fn
    open fun gen_defaultModelvalue_fn(newvalue: String, showStr: Boolean) {
        var isType = this._getDateType
        var nowValue = xDate(this.default_time_date + newvalue)
        if (nowValue.isBetweenOf(this._start_date, "<=", isType)) {
            nowValue = this._start_date
        }
        if (nowValue.isBetweenOf(this._end_date, ">=", isType)) {
            nowValue = this._end_date
        }
        var stp = this.getRangByDateTime(nowValue)
        this.nowValue = stp.value
        this.nowValueStr = stp.str
        this.dateList = this.getTimeTreeByStartAndEnd(this._start_date, this._end_date)
        console.log("defaultModelvalue===", this.dateList)
        if (showStr) {
            this.`$emit`("update:modelStr", this.formatTimeDate())
        }
    }
    open var getRangByDateTime = ::gen_getRangByDateTime_fn
    open fun gen_getRangByDateTime_fn(d: xDate): coverValue {
        var nowRange = utsArrayOf<UTSArray<String>>(utsArrayOf(
            d.getYear().toString(10)
        ), utsArrayOf(
            d.getMonth().toString(10)
        ), utsArrayOf(
            d.getDate().toString(10)
        ), utsArrayOf(
            d.getHours().toString(10)
        ), utsArrayOf(
            d.getMinutes().toString(10)
        ), utsArrayOf(
            d.getSeconds().toString(10)
        ))
        var nowRangeStr = d.getYear().toString(10) + "-" + (d.getMonth() + 1).toString(10) + "-" + d.getDate().toString(10) + " " + d.getHours().toString(10) + ":" + d.getMinutes().toString(10) + ":" + d.getSeconds().toString(10)
        return coverValue(value = nowRange as UTSArray<UTSArray<String>>, str = nowRangeStr)
    }
    open var getNowTypeLenIndex = ::gen_getNowTypeLenIndex_fn
    open fun gen_getNowTypeLenIndex_fn(): Number {
        var index: Number = 6
        if (this.type == "hour") {
            index = 4
        } else if (this.type == "minute") {
            index = 5
        }
        return index
    }
    open var indexToHex = ::gen_indexToHex_fn
    open fun gen_indexToHex_fn(i: Number): String {
        var n = i.toString(10)
        if (n.length == 1) {
            return "0" + n
        }
        return n
    }
    open var getTimeTreeByStartAndEnd = ::gen_getTimeTreeByStartAndEnd_fn
    open fun gen_getTimeTreeByStartAndEnd_fn(start: xDate, end: xDate): UTSArray<UTSArray<PICKER_ITEM_INFO>> {
        var startCopy = start.getClone()
        var nowDate = xDate(this.nowValueStr)
        var endCopy = end.getClone()
        var years = utsArrayOf<PICKER_ITEM_INFO>()
        var months = utsArrayOf<PICKER_ITEM_INFO>()
        var days = utsArrayOf<PICKER_ITEM_INFO>()
        var hours = utsArrayOf<PICKER_ITEM_INFO>()
        var minutes = utsArrayOf<PICKER_ITEM_INFO>()
        var seconds = utsArrayOf<PICKER_ITEM_INFO>()
        run {
            var i = startCopy.getYear()
            while(i <= endCopy.getYear()){
                years.push(PICKER_ITEM_INFO(id = i.toString(10), title = this.indexToHex(i)))
                i++
            }
        }
        var _this = this
        fun getD(type: String, s: Number, n: Number) {
            if (type == "m") {
                run {
                    var i = s
                    while(i <= n){
                        months.push(PICKER_ITEM_INFO(id = i.toString(10), title = _this.indexToHex(i + 1)))
                        i++
                    }
                }
            } else if (type == "d") {
                run {
                    var i = s
                    while(i <= n){
                        days.push(PICKER_ITEM_INFO(id = i.toString(10), title = _this.indexToHex(i)))
                        i++
                    }
                }
            } else if (type == "h") {
                run {
                    var i = s
                    while(i <= n){
                        hours.push(PICKER_ITEM_INFO(id = i.toString(10), title = _this.indexToHex(i)))
                        i++
                    }
                }
            } else if (type == "M") {
                run {
                    var i = s
                    while(i <= n){
                        minutes.push(PICKER_ITEM_INFO(id = i.toString(10), title = _this.indexToHex(i)))
                        if (this.steps > 0) {
                            i += (this.steps - 1)
                        } else {
                            console.warn("steps[", this.steps, "]设置无效")
                        }
                        i++
                    }
                }
            } else if (type == "s") {
                run {
                    var i = s
                    while(i <= n){
                        seconds.push(PICKER_ITEM_INFO(id = i.toString(10), title = _this.indexToHex(i)))
                        i++
                    }
                }
            }
        }
        fun getDnumber(type: xDateTypeTime, target: xDateTypeTime): UTSArray<Number> {
            var st: Number = 0
            var et: Number = 0
            if (nowDate.isBetween(startCopy, endCopy, type, "()")) {
                if (target == "m") {
                    st = 0
                    et = 11
                } else if (target == "d") {
                    st = 1
                    et = nowDate.getMonthCountDay()
                } else if (target == "h") {
                    st = 0
                    et = 23
                } else if (target == "M" || target == "s") {
                    st = 0
                    et = 59
                }
            } else {
                if (startCopy.isBetweenOf(endCopy, "=", type)) {
                    if (target == "m") {
                        st = startCopy.getMonth()
                        et = endCopy.getMonth()
                    } else if (target == "d") {
                        st = startCopy.getDate()
                        et = endCopy.getDate()
                    } else if (target == "h") {
                        st = startCopy.getHours()
                        et = endCopy.getHours()
                    } else if (target == "M") {
                        st = startCopy.getMinutes()
                        et = endCopy.getMinutes()
                    } else if (target == "s") {
                        st = startCopy.getSeconds()
                        et = endCopy.getSeconds()
                    }
                } else if (nowDate.isBetweenOf(startCopy, "<=", type)) {
                    if (target == "m") {
                        st = startCopy.getMonth()
                        et = 11
                    } else if (target == "d") {
                        st = startCopy.getDate()
                        et = startCopy.getMonthCountDay()
                    } else if (target == "h") {
                        st = startCopy.getHours()
                        et = 23
                    } else if (target == "M") {
                        st = startCopy.getMinutes()
                        et = 59
                    } else if (target == "s") {
                        st = startCopy.getSeconds()
                        et = 59
                    }
                } else if (nowDate.isBetweenOf(endCopy, ">=", type)) {
                    if (target == "m") {
                        st = 0
                        et = endCopy.getMonth()
                    } else if (target == "d") {
                        st = 1
                        et = endCopy.getMonthCountDay()
                    } else if (target == "h") {
                        st = 0
                        et = endCopy.getHours()
                    } else if (target == "M") {
                        st = 0
                        et = endCopy.getMinutes()
                    } else if (target == "s") {
                        st = 0
                        et = endCopy.getSeconds()
                    }
                }
            }
            return utsArrayOf<Number>(st, et)
        }
        var maxlen = this.getNowTypeLenIndex()
        if (maxlen > 1) {
            var sdate = getDnumber("y", "m")
            getD("m", sdate[0]!!, sdate[1]!!)
        }
        if (maxlen > 2) {
            var sdate = getDnumber("m", "d")
            getD("d", sdate[0]!!, sdate[1]!!)
        }
        if (maxlen > 3) {
            var sdate = getDnumber("d", "h")
            getD("h", sdate[0]!!, sdate[1]!!)
        }
        if (maxlen > 4) {
            var sdate = getDnumber("h", "M")
            getD("M", sdate[0]!!, sdate[1]!!)
        }
        if (maxlen > 5) {
            var sdate = getDnumber("M", "s")
            getD("s", sdate[0]!!, sdate[1]!!)
        }
        return utsArrayOf(
            years,
            months,
            days,
            hours,
            minutes,
            seconds
        ).slice(0, this.getNowTypeLenIndex()) as UTSArray<UTSArray<PICKER_ITEM_INFO>>
    }
    open var getRangNumber = ::gen_getRangNumber_fn
    open fun gen_getRangNumber_fn(start: Number, end: Number): UTSArray<String> {
        var iar = utsArrayOf<String>()
        run {
            var i = start
            while(i <= end){
                iar.push(i.toString(10))
                i++
            }
        }
        return iar
    }
    open var stringArValuCoverToString = ::gen_stringArValuCoverToString_fn
    open fun gen_stringArValuCoverToString_fn(): String {
        if (this.nowValue.length != 6) {
            return ""
        }
        return this.fillNumber(this.nowValue[0][0]) + "-" + this.fillNumber((parseInt(this.nowValue[1][0]) + 1).toString(10)) + "-" + this.fillNumber(this.nowValue[2][0]) + " " + this.fillNumber(this.nowValue[3][0]) + ":" + this.fillNumber(this.nowValue[4][0]) + ":" + this.fillNumber(this.nowValue[5][0])
    }
    open var fillNumber = ::gen_fillNumber_fn
    open fun gen_fillNumber_fn(n: String): String {
        if (n.length > 1) {
            return n
        }
        return "0" + n
    }
    open var formatTimeDate = ::gen_formatTimeDate_fn
    open fun gen_formatTimeDate_fn(): String {
        if (this.nowValue.length != 6) {
            return ""
        }
        var sp = this.format
        sp = sp.replace(UTSRegExp("YYYY", "g"), this.fillNumber(this.nowValue[0][0]))
        sp = sp.replace(UTSRegExp("MM", "g"), this.fillNumber((parseInt(this.nowValue[1][0]) + 1).toString(10)))
        sp = sp.replace(UTSRegExp("DD", "g"), this.fillNumber(this.nowValue[2][0]))
        sp = sp.replace(UTSRegExp("hh", "g"), this.fillNumber(this.nowValue[3][0]))
        sp = sp.replace(UTSRegExp("mm", "g"), this.fillNumber(this.nowValue[4][0]))
        sp = sp.replace(UTSRegExp("ss", "g"), this.fillNumber(this.nowValue[5][0]))
        return sp
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
        this.cancelResetDataCol()
        setPagePullRefresh(this.nowPull)
    }
    open var mchange = ::gen_mchange_fn
    open fun gen_mchange_fn(ids: UTSArray<String>, index: Number) {
        this.nowValue.splice(index, 1, ids)
        this.nowValueStr = this.stringArValuCoverToString()
        this.`$emit`("change", this.nowValueStr.split(" ")[1])
        this.dateList = this.getTimeTreeByStartAndEnd(this._start_date, this._end_date)
    }
    open var onCancel = ::gen_onCancel_fn
    open fun gen_onCancel_fn() {
        this.`$emit`("cancel")
        this.cancelResetDataCol()
    }
    open var cancelResetDataCol = ::gen_cancelResetDataCol_fn
    open fun gen_cancelResetDataCol_fn() {
        var stp = this.getRangByDateTime(xDate(this.default_time_date + this.modelValue))
        this.nowValue = stp.value
        this.nowValueStr = stp.str
        this.dateList = this.getTimeTreeByStartAndEnd(this._start_date, this._end_date)
    }
    open var onConfirm = ::gen_onConfirm_fn
    open fun gen_onConfirm_fn() {
        this.nowValueStr = this.stringArValuCoverToString()
        this.`$emit`("update:modelValue", this.nowValueStr.split(" ")[1])
        this.`$emit`("update:modelStr", this.formatTimeDate())
        this.`$emit`("confirm", this.nowValueStr.split(" ")[1])
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xPickerDateWrap" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("cancel" to null, "confirm" to null, "change" to null, "update:modelShow" to null, "update:modelStr" to null, "update:modelValue" to null)
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "String", "default" to ""), "modelStr" to utsMapOf("type" to "String", "default" to ""), "modelShow" to utsMapOf("type" to "Boolean", "default" to false), "title" to utsMapOf("type" to "String", "default" to "请选择时间"), "cancelText" to utsMapOf("type" to "String", "default" to "取消"), "confirmText" to utsMapOf("type" to "String", "default" to "确认"), "start" to utsMapOf("type" to "String", "default" to ""), "end" to utsMapOf("type" to "String", "default" to ""), "type" to utsMapOf("type" to "String", "default" to "second"), "format" to utsMapOf("type" to "String", "default" to "hh:mm:ss"), "cellUnits" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>("年", "月", "日", "小时", "分钟", "秒数")
        }
        ), "zIndex" to utsMapOf("type" to "Number", "default" to 1100), "showClose" to utsMapOf("type" to "Boolean", "default" to false), "disabled" to utsMapOf("type" to "Boolean", "default" to false), "widthCoverCenter" to utsMapOf("type" to "Boolean", "default" to false), "steps" to utsMapOf("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = utsArrayOf(
            "modelValue",
            "modelStr",
            "modelShow",
            "title",
            "cancelText",
            "confirmText",
            "start",
            "end",
            "type",
            "format",
            "cellUnits",
            "zIndex",
            "showClose",
            "disabled",
            "widthCoverCenter",
            "steps"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
