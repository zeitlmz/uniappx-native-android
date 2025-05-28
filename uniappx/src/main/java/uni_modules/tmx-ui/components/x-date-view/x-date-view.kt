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
open class GenUniModulesTmxUiComponentsXDateViewXDateView : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.nowPull = getPagePullRefresh()
            var nowValue = xDate(this.modelValue)
            this.defaultModelvalue(nowValue.format("YYYY-MM-DD"), this.modelValue != "")
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
            if (xDate(newvalue).isBetweenOf(xDate(this.nowValueStr), "=", isType)) {
                return
            }
            this.defaultModelvalue(newvalue, true)
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_picker_view = resolveEasyComponent("x-picker-view", GenUniModulesTmxUiComponentsXPickerViewXPickerViewClass)
        return createElementVNode("view", utsMapOf("class" to "xPickerDateWrap", "onTouchstart" to _ctx.onTouchstart, "onTouchend" to _ctx.onTouchend, "onTouchcancel" to _ctx.onTouchend), utsArrayOf(
            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.dateList, fun(item, index, __index, _cached): Any {
                return createVNode(_component_x_picker_view, utsMapOf("cellUnits" to utsArrayOf(
                    _ctx.cellUnits[index]
                ), "onChange" to fun(`$event`: Any){
                    _ctx.mchange(`$event` as UTSArray<String>, index)
                }
                , "model-value" to _ctx.nowValue[index], "key" to index, "style" to normalizeStyle(utsMapOf("flex" to "1")), "list" to item), null, 8, utsArrayOf(
                    "cellUnits",
                    "onChange",
                    "model-value",
                    "style",
                    "list"
                ))
            }
            ), 128)
        ), 40, utsArrayOf(
            "onTouchstart",
            "onTouchend",
            "onTouchcancel"
        ))
    }
    open var modelValue: String by `$props`
    open var modelStr: String by `$props`
    open var title: String by `$props`
    open var start: String by `$props`
    open var end: String by `$props`
    open var type: String by `$props`
    open var format: String by `$props`
    open var formatSyncValue: Boolean by `$props`
    open var cellUnits: UTSArray<String> by `$props`
    open var nowValue: UTSArray<UTSArray<String>> by `$data`
    open var nowValueStr: String by `$data`
    open var startDate: xDate by `$data`
    open var endDate: xDate by `$data`
    open var dateList: UTSArray<UTSArray<PICKER_ITEM_INFO>> by `$data`
    open var changeIndex: Number by `$data`
    open var nowPull: Boolean by `$data`
    open var _start_date: xDate by `$data`
    open var _end_date: xDate by `$data`
    open var _getDateType: xDateTypeTime by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        var startValue = xDate()
        var endValue = xDate()
        startValue.subtraction(1, "y")
        return utsMapOf("nowValue" to utsArrayOf<UTSArray<String>>(), "nowValueStr" to "", "startDate" to startValue, "endDate" to endValue, "dateList" to utsArrayOf<UTSArray<PICKER_ITEM_INFO>>(), "changeIndex" to 0, "nowPull" to false, "_start_date" to computed<xDate>(fun(): xDate {
            if (this.start == "") {
                return this.startDate
            }
            return xDate(this.start)
        }
        ), "_end_date" to computed<xDate>(fun(): xDate {
            if (this.end == "") {
                return this.endDate
            }
            return xDate(this.end)
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
        ))
    }
    open var defaultModelvalue = ::gen_defaultModelvalue_fn
    open fun gen_defaultModelvalue_fn(newvalue: String, showStr: Boolean) {
        var isType = this._getDateType
        var nowValue = xDate(newvalue)
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
        this.`$emit`("update:modelStr", this.formatTimeDate())
    }
    open var getRangByDateTime = ::gen_getRangByDateTime_fn
    open fun gen_getRangByDateTime_fn(d: xDate): coverValue1 {
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
        return coverValue1(value = nowRange as UTSArray<UTSArray<String>>, str = nowRangeStr)
    }
    open var getNowTypeLenIndex = ::gen_getNowTypeLenIndex_fn
    open fun gen_getNowTypeLenIndex_fn(): Number {
        var index: Number = 6
        if (this.type == "year") {
            index = 1
        } else if (this.type == "month") {
            index = 2
        } else if (this.type == "day") {
            index = 3
        } else if (this.type == "hour") {
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
                        et = endCopy.getDate()
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
            var sdate = getDnumber("m", "s")
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
        var newsday = xDate(this.nowValue[0][0] + "-" + (parseInt(this.nowValue[1][0]) + 1).toString(10) + "-1")
        var days = parseInt(this.nowValue[2][0])
        days = if (days >= newsday.getMonthCountDay()) {
            newsday.getMonthCountDay()
        } else {
            days
        }
        this.nowValue.splice(2, 1, utsArrayOf(
            days.toString(10)
        ))
        return this.fillNumber(this.nowValue[0][0]) + "-" + this.fillNumber((parseInt(this.nowValue[1][0]) + 1).toString(10)) + "-" + this.fillNumber(this.nowValue[2][0]) + " " + this.fillNumber(this.nowValue[3][0]) + ":" + this.fillNumber(this.nowValue[4][0]) + ":" + this.fillNumber(this.nowValue[5][0])
    }
    open var fillNumber = ::gen_fillNumber_fn
    open fun gen_fillNumber_fn(n: String): String {
        if (parseInt(n) > 9) {
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
    open var mchange = ::gen_mchange_fn
    open fun gen_mchange_fn(ids: UTSArray<String>, index: Number) {
        this.nowValue.splice(index, 1, ids)
        this.nowValueStr = this.stringArValuCoverToString()
        this.`$emit`("change", this.nowValueStr)
        this.dateList = this.getTimeTreeByStartAndEnd(this._start_date, this._end_date)
        this.`$forceUpdate`()
        this.onConfirm()
    }
    open var onTouchstart = ::gen_onTouchstart_fn
    open fun gen_onTouchstart_fn() {
        setPagePullRefresh(false)
    }
    open var onTouchend = ::gen_onTouchend_fn
    open fun gen_onTouchend_fn() {
        setPagePullRefresh(this.nowPull)
    }
    open var onConfirm = ::gen_onConfirm_fn
    open fun gen_onConfirm_fn() {
        val syncValue: String = if (this.formatSyncValue) {
            this.formatTimeDate()
        } else {
            (toRaw(this.nowValueStr) as String)
        }
        this.`$emit`("update:modelValue", syncValue)
        this.`$emit`("update:modelStr", this.formatTimeDate())
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
        var emits: Map<String, Any?> = utsMapOf("change" to null, "update:modelStr" to null, "update:modelValue" to null)
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "String", "default" to ""), "modelStr" to utsMapOf("type" to "String", "default" to ""), "title" to utsMapOf("type" to "String", "default" to "请选择时间"), "start" to utsMapOf("type" to "String", "default" to ""), "end" to utsMapOf("type" to "String", "default" to ""), "type" to utsMapOf("type" to "String", "default" to "day"), "format" to utsMapOf("type" to "String", "default" to "YYYY-MM-DD"), "formatSyncValue" to utsMapOf("type" to "Boolean", "default" to false), "cellUnits" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>("年", "月", "日", "时", "分", "秒")
        }
        )))
        var propsNeedCastKeys = utsArrayOf(
            "modelValue",
            "modelStr",
            "title",
            "start",
            "end",
            "type",
            "format",
            "formatSyncValue",
            "cellUnits"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
