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
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
import uts.sdk.modules.mcAmapNavPlus.init
open class GenUniModulesTmxUiComponentsXCalendarViewCalender : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.init()
        }
        , __ins)
        onBeforeUnmount(fun() {
            clearTimeout(this.tid)
            clearTimeout(this.tid2)
            clearTimeout(this.tid3)
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newVal: String) {
            if (newVal == "") {
                this.selectedDate = null
                clearTimeout(this.tid3)
                var _this = this
                this.tid3 = setTimeout(fun(){
                    _this.nowDate = xDate(_this.date)
                    _this.`$forceUpdate`()
                    _this.workAsync()
                }
                , 50)
                return
            }
            if (this.selectedDate != null) {
                if (xDate(newVal).isBetweenOf(this.selectedDate!!, "=", "d")) {
                    return
                }
            }
            var _this = this
            _this.selectedDate = xDate(newVal)
            _this.workAsync()
        }
        )
        this.`$watch`(fun(): Any? {
            return this.date
        }
        , fun() {
            var _this = this
            var dur: Number = 5
            dur = 350
            clearTimeout(this.tid3)
            this.tid3 = setTimeout(fun() {
                _this.nowDate = xDate(_this.date)
                _this.`$forceUpdate`()
                _this.workAsync()
            }
            , dur)
        }
        )
        this.`$watch`(fun(): Any? {
            return this.dateStyle
        }
        , fun() {
            var _this = this
            _this.`$forceUpdate`()
            _this.workAsync()
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return createElementVNode("view", utsMapOf("class" to "xCalendarView", "style" to normalizeStyle(utsMapOf("opacity" to _ctx.opacityBox))), utsArrayOf(
            createElementVNode("view", utsMapOf("ref" to "xCalendarViewBody", "android-layer-type" to "hardware", "onTouchend" to _ctx.AppclickEnd, "onTouchstart" to _ctx.Appclicstart, "style" to normalizeStyle(utsMapOf("height" to (_ctx.caleBodySize.height + "px"))), "class" to "xCalendarViewBody"), null, 44, utsArrayOf(
                "onTouchend",
                "onTouchstart"
            )),
            createElementVNode("view", utsMapOf("class" to "xCalendarBgMonth", "style" to normalizeStyle(utsMapOf("height" to "100%"))), utsArrayOf(
                createElementVNode("text", utsMapOf("class" to "xCalendarBgMonthText"), toDisplayString(_ctx._nowMonth), 1)
            ), 4)
        ), 4)
    }
    open var modelValue: String by `$props`
    open var date: String by `$props`
    open var idx: Number by `$props`
    open var activeIndex: Number by `$props`
    open var disabledDays: UTSArray<String> by `$props`
    open var color: String by `$props`
    open var dateStyle: UTSArray<xCalendarDateStyle_type> by `$props`
    open var startDate: String by `$props`
    open var endDate: String by `$props`
    open var disabled: Boolean by `$props`
    open var nowDate: xDate by `$data`
    open var nowDateArrays: UTSArray<xDateArrayItem> by `$data`
    open var weeksCn: UTSArray<String> by `$data`
    open var selectedDate: xDate? by `$data`
    open var bodyHeight: Any? by `$data`
    open var nowYear: Number by `$data`
    open var nowDateLable: String by `$data`
    open var selectedDateLable: String by `$data`
    open var tid: Number by `$data`
    open var caleBodySize: BODY_SIZE_TYPE by `$data`
    open var xCalendarViewObj: xCalendarView? by `$data`
    open var isShowYearAndMonthBox: Boolean by `$data`
    open var opacityBox: Number by `$data`
    open var tid2: Number by `$data`
    open var tid3: Number by `$data`
    open var _x: Number by `$data`
    open var _y: Number by `$data`
    open var startTimeTouch: Number by `$data`
    open var _computedCalc: (x: String) -> String by `$data`
    open var _disabled: Boolean by `$data`
    open var _activeIndex: Number by `$data`
    open var _color: String by `$data`
    open var _dateStyle: UTSArray<xCalendarDateStyle_real_type> by `$data`
    open var _isDark: Boolean by `$data`
    open var _isMonthBgcolor: String by `$data`
    open var _startDate: xDate by `$data`
    open var _endDate: xDate by `$data`
    open var _nowMonth: Number by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("nowDate" to xDate(), "nowDateArrays" to utsArrayOf<xDateArrayItem>(), "weeksCn" to utsArrayOf(
            "周一",
            "周二",
            "周三",
            "周四",
            "周五",
            "周六",
            "周日"
        ), "selectedDate" to null as xDate?, "bodyHeight" to (300.toString(10) + "px"), "nowYear" to 1900, "nowDateLable" to "", "selectedDateLable" to "", "tid" to 0, "caleBodySize" to BODY_SIZE_TYPE(height = 300, width = 0), "xCalendarViewObj" to null as xCalendarView?, "isShowYearAndMonthBox" to false, "opacityBox" to 1, "tid2" to 20, "tid3" to 50, "_x" to 0, "_y" to 0, "startTimeTouch" to 0, "_computedCalc" to computed<(x: String) -> String>(fun(): (x: String) -> String {
            return fun(x: String): String {
                return checkIsCssUnit(x, xConfig.unit)
            }
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ), "_activeIndex" to computed<Number>(fun(): Number {
            return this.activeIndex
        }
        ), "_color" to computed<String>(fun(): String {
            if (this.color == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.color)
        }
        ), "_dateStyle" to computed<UTSArray<xCalendarDateStyle_real_type>>(fun(): UTSArray<xCalendarDateStyle_real_type> {
            var dalls = utsArrayOf<xCalendarDateStyle_real_type>()
            run {
                var i: Number = 0
                while(i < this.dateStyle.length){
                    var item = this.dateStyle[i] as xCalendarDateStyle_type
                    dalls.push(xCalendarDateStyle_real_type(dot = if (item.dot == null) {
                        false
                    } else {
                        item.dot!!
                    }
                    , dotColor = if (item.dotColor == null) {
                        "#ffaa00"
                    } else {
                        item.dotColor!!
                    }
                    , dotLabelColor = if (item.dotLabelColor == null) {
                        "#ffffff"
                    } else {
                        item.dotLabelColor!!
                    }
                    , dotLabel = if (item.dotLabel == null) {
                        ""
                    } else {
                        item.dotLabel!!
                    }
                    , label = if (item.label == null) {
                        ""
                    } else {
                        item.label!!
                    }
                    , color = if (item.color == null) {
                        ""
                    } else {
                        item.color!!
                    }
                    , fontColor = if (item.fontColor == null) {
                        ""
                    } else {
                        item.fontColor!!
                    }
                    , date = xDate(item.date).format("YYYY/MM/DD")))
                    i++
                }
            }
            return dalls
        }
        ), "_isDark" to computed<Boolean>(fun(): Boolean {
            return xConfig.dark == "dark"
        }
        ), "_isMonthBgcolor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                return xConfig.sheetDarkColor
            }
            return "#ffffff"
        }
        ), "_startDate" to computed<xDate>(fun(): xDate {
            this.`$forceUpdate`()
            return xDate(this.startDate)
        }
        ), "_endDate" to computed<xDate>(fun(): xDate {
            this.`$forceUpdate`()
            return xDate(this.endDate)
        }
        ), "_nowMonth" to computed<Number>(fun(): Number {
            return xDate(this.date).getMonth() + 1
        }
        ))
    }
    open var workAsync = ::gen_workAsync_fn
    open fun gen_workAsync_fn() {
        var _this = this
        open class IntentRunable : Runnable {
            override fun run() {
                _this.nowDateArrays = _this.getCalendar()
                _this.appUpdate(0)
            }
        }
        UTSAndroid.getUniActivity()!!.runOnUiThread(IntentRunable())
    }
    open var init = ::gen_init_fn
    open fun gen_init_fn() {
        if (this.modelValue != "") {
            this.selectedDate = xDate(this.modelValue)
        }
        this.nowDate = xDate(this.date)
        var t = this
        this.getDominfo().then(fun(){
            t.workAsync()
        }
        )
    }
    open var appUpdate = ::gen_appUpdate_fn
    open fun gen_appUpdate_fn(timeout: Number) {
        var t = this
        clearTimeout(this.tid)
        this.tid = setTimeout(fun() {
            t.xCalendarViewObj = xCalendarView(t.`$refs`["xCalendarViewBody"]!! as UniElement, t.caleBodySize)
            if (t.xCalendarViewObj == null) {
                return
            }
            t.xCalendarViewObj!!.updateNowDateArrays(xCalendarViewUpdateType(ar = t.nowDateArrays, disabledDays = t.disabledDays as UTSArray<String>, nowDate = xDate(this.date), selectedDate = t.selectedDate, start = xDate(t.nowDateArrays[0].date.date), end = xDate(t.nowDateArrays[t.nowDateArrays.length - 1].date.date), color = t._color, dateStyle = t._dateStyle))
            t.xCalendarViewObj!!.drawer()
        }
        , timeout)
    }
    open var getDominfo = ::gen_getDominfo_fn
    open fun gen_getDominfo_fn(): UTSPromise<Boolean> {
        var t = this
        return UTSPromise(fun(res, rej){
            uni_createSelectorQuery().`in`(this).select(".xCalendarViewBody").boundingClientRect().exec(fun(result){
                var node = result[0]!! as NodeInfo
                t.caleBodySize.width = node.width!!
                res(true)
            }
            )
        }
        )
    }
    @get:JvmName("getIsDisabled0")
    @set:JvmName("setIsDisabled0")
    open var isDisabled = ::gen_isDisabled_fn
    open fun gen_isDisabled_fn(date: xDateDayInfoType): Boolean {
        var ds = this.disabledDays as UTSArray<String>
        var pass = false
        var start = this._startDate
        var end = this._endDate
        var now = xDate(date.date)
        run {
            var i: Number = 0
            while(i < ds.length){
                if (xDate(ds[i]).isBetweenOf(now, "=", "d")) {
                    pass = true
                    break
                }
                i++
            }
        }
        if (!pass) {
            pass = !now.isBetween(start, end, "d", "[]")
        }
        return pass
    }
    open var isSelected = ::gen_isSelected_fn
    open fun gen_isSelected_fn(date: xDateDayInfoType): Boolean {
        if (this.selectedDate == null) {
            return false
        }
        return this.selectedDate!!.isBetweenOf(xDate(date.date), "=", "d")
    }
    open var isInCureentMonth = ::gen_isInCureentMonth_fn
    open fun gen_isInCureentMonth_fn(date: xDateDayInfoType): Boolean {
        var cureentDate = xDate(date.date)
        var start = this.nowDate.getDateStartOf("m")
        var end = this.nowDate.getDateEndOf("m")
        return cureentDate.isBetween(start, end, "d")
    }
    open var isDot = ::gen_isDot_fn
    open fun gen_isDot_fn(date: dateStyleType): Boolean {
        if (date.dot.dotLabel == "" && date.dot.dot) {
            return true
        }
        return false
    }
    open var clickDate = ::gen_clickDate_fn
    open fun gen_clickDate_fn(item: xDateArrayItem) {
        var date = item.date
        if (item.isDisabled || !item.isInCureentMonth || this._disabled) {
            return
        }
        this.selectedDate = xDate(date.date)
        this.workAsync()
        this.`$emit`("change", this.selectedDate!!.format())
    }
    open var Appclicstart = ::gen_Appclicstart_fn
    open fun gen_Appclicstart_fn(evt: UniTouchEvent) {
        this._x = evt.changedTouches[0].clientX
        this._y = evt.changedTouches[0].clientY
        this.startTimeTouch = Date.now()
    }
    open var AppclickEnd = ::gen_AppclickEnd_fn
    open fun gen_AppclickEnd_fn(evt: UniTouchEvent) {
        var diffdate = Date.now() - this.startTimeTouch
        var diffx = Math.abs(evt.changedTouches[0].clientX - this._x)
        var diffy = Math.abs(evt.changedTouches[0].clientY - this._y)
        var clickeventtime = false
        if (Math.abs(diffx) == Math.abs(diffy) && diffx == 0 && diffdate > 50 && diffdate <= 250) {
            clickeventtime = true
        }
        if (!clickeventtime) {
            return
        }
        if (this.xCalendarViewObj == null) {
            return
        }
        var item = this.xCalendarViewObj!!.clickEnd(evt.changedTouches[0].clientX, evt.changedTouches[0].clientY)
        var date = item.date
        if (item.isDisabled || !item.isInCureentMonth || this._disabled) {
            return
        }
        var oldDate = this.selectedDate
        this.selectedDate = xDate(date.date)
        this.getUpdateCalendar(oldDate)
        this.appUpdate(0)
        this.`$emit`("change", this.selectedDate!!.format())
    }
    open var dateColor = ::gen_dateColor_fn
    open fun gen_dateColor_fn(date: xDateDayInfoType, isInCurrent: Boolean, isDisabled: Boolean, isSelectted: Boolean): dateStyleType {
        var indexDatestyle = this._dateStyle.findIndex(fun(el): Boolean {
            return xDate(el.date).isBetweenOf(xDate(date.date), "=", "d")
        }
        )
        var dot = dateStyleDot(dot = false, dotColor = "#ffaa00", dotLabelColor = "#ffffff", dotLabel = "")
        var bgstyle = dateStyleBg(label = "", fontColor = if (this._isDark) {
            "#ffffff"
        } else {
            "#333333"
        }
        , backgroundColor = "transparent", opacity = 1)
        if (indexDatestyle > -1) {
            var item = this._dateStyle[indexDatestyle]
            dot.dot = item.dot!!
            dot.dotColor = item.dotColor!!
            dot.dotLabelColor = item.dotLabelColor!!
            dot.dotLabel = item.dotLabel!!
            bgstyle.label = item.label!!
            bgstyle.fontColor = if (item.fontColor != "" && isInCurrent) {
                item.fontColor
            } else {
                if (this._isDark) {
                    "#ffffff"
                } else {
                    "#333"
                }
            }
            if (!isInCurrent) {
                bgstyle.fontColor = if (item.fontColor != "" && isInCurrent) {
                    item.fontColor
                } else {
                    if (this._isDark) {
                        "#b4b4b4"
                    } else {
                        "#a1a1a1"
                    }
                }
            }
            if (isDisabled) {
                bgstyle.fontColor = if (item.fontColor != "" && isInCurrent) {
                    item.fontColor
                } else {
                    if (this._isDark) {
                        "#b4b4b4"
                    } else {
                        "#a6a6a6"
                    }
                }
                bgstyle.opacity = 0.5
            } else {
                bgstyle.opacity = 1
            }
            if (isSelectted && isInCurrent) {
                bgstyle.fontColor = "white"
                bgstyle.backgroundColor = this._color
            } else {
                bgstyle.backgroundColor = if (item.color != "" && isInCurrent) {
                    item.color
                } else {
                    "transparent"
                }
            }
        } else {
            if (!isInCurrent) {
                bgstyle.fontColor = if (this._isDark) {
                    "#b4b4b4"
                } else {
                    "#a1a1a1"
                }
            }
            if (isDisabled) {
                bgstyle.fontColor = if (this._isDark) {
                    "#818181"
                } else {
                    "#a6a6a6"
                }
                bgstyle.opacity = 0.5
            } else {
                bgstyle.opacity = 1
            }
            if (isSelectted && isInCurrent) {
                bgstyle.backgroundColor = this._color
                bgstyle.fontColor = "white"
            } else {
                bgstyle.backgroundColor = "transparent"
            }
        }
        return dateStyleType(dot = dot, dstyle = bgstyle)
    }
    open var getCalendar = ::gen_getCalendar_fn
    open fun gen_getCalendar_fn(): UTSArray<xDateArrayItem> {
        var allDates = this.nowDate.getDaysOf("m")
        var fristdate = allDates[0]
        var enddate = allDates[allDates.length - 1]
        var firstDates = xDate(fristdate.date).getDaysOf("w")
        var EndDates = xDate(enddate.date).getDaysOf("w")
        var firsetLastIndex: Number = -1
        run {
            var i: Number = 0
            while(i < allDates.length){
                var el = allDates[i]
                if (el.date == firstDates[firstDates.length - 1].date) {
                    firsetLastIndex = i
                    break
                }
                i++
            }
        }
        var LastFirsetIndex: Number = -1
        run {
            var i: Number = 0
            while(i < allDates.length){
                var el = allDates[i]
                if (el.date == EndDates[0].date) {
                    LastFirsetIndex = i
                    break
                }
                i++
            }
        }
        var calcDays = allDates.slice(firsetLastIndex + 1, LastFirsetIndex)
        allDates = firstDates.concat(calcDays)
        allDates = allDates.concat(EndDates)
        if (allDates.length % 6 > 0) {
            var adds = xDate(EndDates[EndDates.length - 1].date)
            adds.add(1, "d")
            var addWiiks = adds.getDaysOf("w")
            allDates = allDates.concat(addWiiks)
        }
        var dateByXdateItem = utsArrayOf<xDateArrayItem>()
        run {
            var i: Number = 0
            while(i < allDates.length){
                var item = allDates[i]
                var isInCurrent = this.isInCureentMonth(item)
                var isDisabled = this.isDisabled(item)
                var isSelectted = this.isSelected(item)
                var sstyle = this.dateColor(item, isInCurrent, isDisabled, isSelectted)
                dateByXdateItem.push(xDateArrayItem(date = item, isDisabled = isDisabled, isInCureentMonth = isInCurrent, isSelected = isSelectted, style = sstyle))
                i++
            }
        }
        return dateByXdateItem
    }
    open var getUpdateCalendar = ::gen_getUpdateCalendar_fn
    open fun gen_getUpdateCalendar_fn(oldDate: xDate?) {
        run {
            var i: Number = 0
            while(i < this.nowDateArrays.length){
                var item = this.nowDateArrays[i]
                if (oldDate != null) {
                    if (xDate(item.date.date).isBetweenOf(oldDate!!, "=", "d")) {
                        var isInCurrent = this.isInCureentMonth(item.date)
                        var isDisabled = this.isDisabled(item.date)
                        var isSelectted = this.isSelected(item.date)
                        var sstyle = this.dateColor(item.date, isInCurrent, isDisabled, isSelectted)
                        item.style = sstyle
                    }
                }
                if (this.selectedDate != null) {
                    if (xDate(item.date.date).isBetweenOf(this.selectedDate!!, "=", "d")) {
                        var isInCurrent = this.isInCureentMonth(item.date)
                        var isDisabled = this.isDisabled(item.date)
                        var isSelectted = this.isSelected(item.date)
                        var sstyle = this.dateColor(item.date, isInCurrent, isDisabled, isSelectted)
                        item.style = sstyle
                    }
                }
                i++
            }
        }
    }
    open var setNowDate = ::gen_setNowDate_fn
    open fun gen_setNowDate_fn() {
        this.nowDate = xDate()
        this.selectedDate = xDate()
        this.appUpdate(0)
        var formatdate = this.selectedDate!!.format()
        this.`$emit`("change", formatdate)
    }
    open var setMonth = ::gen_setMonth_fn
    open fun gen_setMonth_fn(index: Number) {
        this.nowDate.setDateOf(index, "m")
        this.nowDateArrays = this.getCalendar()
        this.appUpdate(0)
        this.`$emit`("change", this.nowDate.format())
        this.isShowYearAndMonthBox = false
    }
    open var yearChange = ::gen_yearChange_fn
    open fun gen_yearChange_fn(year: Number) {
        this.nowDate.setDateOf(year, "y")
        this.nowDateArrays = this.getCalendar()
        this.appUpdate(0)
        this.`$emit`("change", this.nowDate.format())
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xCalendarView" to padStyleMapOf(utsMapOf("transitionProperty" to "opacity", "transitionDuration" to "0.2s", "transitionTimingFunction" to "ease-in", "position" to "relative")), "xCalendarViewBodyDot" to padStyleMapOf(utsMapOf("minWidth" to 8, "minHeight" to 8, "position" to "absolute", "right" to 0, "top" to 0, "borderTopLeftRadius" to 11, "borderTopRightRadius" to 11, "borderBottomRightRadius" to 11, "borderBottomLeftRadius" to 11, "paddingTop" to 3, "paddingRight" to 3, "paddingBottom" to 3, "paddingLeft" to 3)), "xCalendarViewBodyDotLabel" to padStyleMapOf(utsMapOf("fontSize" to 10)), "xCalendarViewBodyDateLable" to padStyleMapOf(utsMapOf("pointerEvents" to "none")), "xCalendarViewBodyDateLableText" to padStyleMapOf(utsMapOf("fontSize" to 10)), "hoverOpacity" to padStyleMapOf(utsMapOf("opacity" to 0.5)), "xCalendarBgMonth" to padStyleMapOf(utsMapOf("position" to "absolute", "left" to 0, "top" to 0, "width" to "100%", "height" to "100%", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "pointerEvents" to "none")), "xCalendarBgMonthText" to padStyleMapOf(utsMapOf("fontSize" to 200, "color" to "rgba(125,125,125,0.1)", "fontWeight" to "bold")), "xCalendarViewBody" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "flexWrap" to "wrap")), "xCalendarViewBodyDate" to padStyleMapOf(utsMapOf("width" to "14.28%", "height" to 50, "display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center", "position" to "relative")), "xCalendarViewBodyDateBox" to padStyleMapOf(utsMapOf("borderTopLeftRadius" to 45, "borderTopRightRadius" to 45, "borderBottomRightRadius" to 45, "borderBottomLeftRadius" to 45, "width" to 45, "height" to 45, "display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center")), "xCalendarViewBodyDateSelected" to padStyleMapOf(utsMapOf("backgroundColor" to "#FF0000")), "@TRANSITION" to utsMapOf("xCalendarView" to utsMapOf("property" to "opacity", "duration" to "0.2s", "timingFunction" to "ease-in")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("change" to null)
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "String", "default" to ""), "date" to utsMapOf("type" to "String", "default" to ""), "idx" to utsMapOf("type" to "Number", "default" to -1), "activeIndex" to utsMapOf("type" to "Number", "default" to -1), "disabledDays" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "color" to utsMapOf("type" to "String", "default" to ""), "dateStyle" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<xCalendarDateStyle_type> {
            return utsArrayOf<xCalendarDateStyle_type>()
        }
        ), "startDate" to utsMapOf("type" to "String", "default" to "1900-1-1"), "endDate" to utsMapOf("type" to "String", "default" to "2100-12-31"), "disabled" to utsMapOf("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = utsArrayOf(
            "modelValue",
            "date",
            "idx",
            "activeIndex",
            "disabledDays",
            "color",
            "dateStyle",
            "startDate",
            "endDate",
            "disabled"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
