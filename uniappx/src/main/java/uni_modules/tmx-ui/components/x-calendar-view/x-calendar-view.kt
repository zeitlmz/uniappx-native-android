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
open class GenUniModulesTmxUiComponentsXCalendarViewXCalendarView : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            if (this.modelValue != "") {
                this.nowDate = xDate(this.modelValue)
                this.selectedDate = this.nowDate.format("YYYY-MM-DD")
                this.nowYear = this.nowDate.getYear()
            }
            this.list = this.getDefaultBoxListData()
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.modelValue
        }
        , fun(newVal: String) {
            if (newVal == "") {
                this.selectedDate = ""
            } else if (xDate(newVal).isBetweenOf(this.nowDate, "=", "m")) {
                this.selectedDate = xDate(newVal).format("YYYY-MM-DD")
            } else {
                this.nowDate = xDate(newVal)
                this.selectedDate = this.nowDate.format("YYYY-MM-DD")
                this.list = this.setDataListBySiperIndex(newVal)
            }
            this.nowYear = this.nowDate.getYear()
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        val _component_calendar = resolveComponent("calendar")
        val _component_x_stepper = resolveEasyComponent("x-stepper", GenUniModulesTmxUiComponentsXStepperXStepperClass)
        return createElementVNode("view", utsMapOf("class" to "xCalendar"), utsArrayOf(
            if (isTrue(!_ctx._hideHeader)) {
                createElementVNode("view", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("display" to "flex", "flex-direction" to "row", "justify-content" to "space-between", "align-items" to "center", "height" to "40px"))), utsArrayOf(
                    createElementVNode("view", utsMapOf("onClick" to fun(){
                        _ctx.showYear(true)
                    }, "style" to normalizeStyle(utsMapOf("flex" to "1", "display" to "flex", "flex-direction" to "row", "justify-content" to "flex-start", "align-items" to "center"))), utsArrayOf(
                        createVNode(_component_x_text, utsMapOf("color" to "#333", "font-size" to "16", "class" to "xCalendarNowSelecTtitle"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                toDisplayString(_ctx._nowDateLable)
                            )
                        }), "_" to 1)),
                        createVNode(_component_x_icon, utsMapOf("font-size" to "24", "name" to "arrow-down-s-fill"))
                    ), 12, utsArrayOf(
                        "onClick"
                    )),
                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("display" to "flex", "flex-direction" to "row", "justify-content" to "center", "align-items" to "center", "height" to "100%"))), utsArrayOf(
                        createElementVNode("view", utsMapOf("onClick" to _ctx.setNowDate, "class" to "headerItemXcalendar", "hover-class" to "hoverOpacity"), utsArrayOf(
                            createVNode(_component_x_text, utsMapOf("color" to "#333", "font-size" to "16"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    "本日"
                                )
                            }), "_" to 1))
                        ), 8, utsArrayOf(
                            "onClick"
                        )),
                        createElementVNode("view", utsMapOf("onClick" to _ctx.clearDate, "class" to "headerItemXcalendar", "hover-class" to "hoverOpacity"), utsArrayOf(
                            createVNode(_component_x_text, utsMapOf("color" to "#333", "font-size" to "16"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    "清空"
                                )
                            }), "_" to 1))
                        ), 8, utsArrayOf(
                            "onClick"
                        ))
                    ), 4)
                ), 4)
            } else {
                createCommentVNode("v-if", true)
            }
            ,
            createElementVNode("view", utsMapOf("class" to "xCalendarViewHeader"), utsArrayOf(
                createElementVNode(Fragment, null, RenderHelpers.renderList(7, fun(item, index, __index, _cached): Any {
                    return createElementVNode("view", utsMapOf("class" to "xCalendarViewDate", "key" to index), utsArrayOf(
                        createVNode(_component_x_text, utsMapOf("color" to "#333", "font-size" to "16"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                toDisplayString(_ctx.weeksCn[index]!!)
                            )
                        }
                        ), "_" to 2), 1024)
                    ))
                }
                ), 64)
            )),
            if (isTrue(!_ctx._disabledSwiper)) {
                createElementVNode("swiper", utsMapOf("key" to 1, "current" to _ctx.swiperCuureindex, "vertical" to _ctx._vertical, "circular" to true, "autoplay" to false, "onChange" to _ctx.swiperChange, "style" to normalizeStyle(utsMapOf("height" to (_ctx.caleBodySize.height + "px")))), utsArrayOf(
                    createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.list, fun(item, index, __index, _cached): Any {
                        return createElementVNode("swiper-item", utsMapOf("key" to index, "style" to normalizeStyle(utsMapOf("height" to (_ctx.caleBodySize.height + "px")))), utsArrayOf(
                            createVNode(_component_calendar, utsMapOf("disabled" to _ctx._disabled, "disabledDays" to _ctx.disabledDays, "startDate" to _ctx.startDate, "endDate" to _ctx.endDate, "dateStyle" to _ctx.dateStyle, "ref_for" to true, "ref" to "calendar", "onChange" to fun(`$event`: Any){
                                _ctx.dateChange(`$event` as String, index)
                            }, "modelValue" to _ctx.selectedDate, "date" to item), null, 8, utsArrayOf(
                                "disabled",
                                "disabledDays",
                                "startDate",
                                "endDate",
                                "dateStyle",
                                "onChange",
                                "modelValue",
                                "date"
                            ))
                        ), 4)
                    }), 128)
                ), 44, utsArrayOf(
                    "current",
                    "vertical",
                    "onChange"
                ))
            } else {
                createCommentVNode("v-if", true)
            }
            ,
            if (isTrue(_ctx._disabledSwiper && _ctx.list.length > 0)) {
                createElementVNode("view", utsMapOf("key" to 2), utsArrayOf(
                    createVNode(_component_calendar, utsMapOf("disabled" to _ctx._disabled, "disabledDays" to _ctx.disabledDays, "startDate" to _ctx.startDate, "endDate" to _ctx.endDate, "dateStyle" to _ctx.dateStyle, "ref" to "calendar", "onChange" to fun(`$event`: Any){
                        _ctx.dateChange(`$event` as String, 0)
                    }, "modelValue" to _ctx.selectedDate, "date" to _ctx.list[0]), null, 8, utsArrayOf(
                        "disabled",
                        "disabledDays",
                        "startDate",
                        "endDate",
                        "dateStyle",
                        "onChange",
                        "modelValue",
                        "date"
                    ))
                ))
            } else {
                createCommentVNode("v-if", true)
            }
            ,
            if (isTrue(!_ctx._hideHeader)) {
                createElementVNode("view", utsMapOf("key" to 3, "style" to normalizeStyle(utsMapOf("display" to "flex", "flex-direction" to "row", "justify-content" to "center", "align-items" to "center", "height" to "40px"))), utsArrayOf(
                    createVNode(_component_x_text, utsMapOf("color" to "#707070", "font-size" to "14", "class" to "xCalendarNowSelecTtitle"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            toDisplayString(if (_ctx.selectedDate != "") {
                                "您已选择: " + _ctx.selectedDate
                            } else {
                                "未选择日期"
                            })
                        )
                    }), "_" to 1))
                ), 4)
            } else {
                createCommentVNode("v-if", true)
            }
            ,
            createElementVNode("view", utsMapOf("class" to "xCalendarSetBox", "style" to normalizeStyle(utsMapOf("opacity" to if (_ctx.isShowYearAndMonthBox) {
                "1"
            } else {
                "0"
            }
            , "width" to if (_ctx.isShowYearAndMonthBox) {
                (_ctx.fullyeBox.width + "px")
            } else {
                "0px"
            }
            , "height" to if (_ctx.isShowYearAndMonthBox) {
                (_ctx.fullyeBox.height + "px")
            } else {
                "0px"
            }
            , "backgroundColor" to _ctx._isMonthBgcolor))), utsArrayOf(
                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("display" to "flex", "flex-direction" to "row", "justify-content" to "space-between", "align-items" to "center", "height" to "60px"))), utsArrayOf(
                    createElementVNode("view", utsMapOf("onClick" to fun(){
                        _ctx.showYear(false)
                    }
                    , "style" to normalizeStyle(utsMapOf("flex" to "1", "display" to "flex", "flex-direction" to "row", "justify-content" to "flex-start", "align-items" to "center"))), utsArrayOf(
                        createVNode(_component_x_text, utsMapOf("color" to _ctx._color, "font-size" to "16", "class" to "xCalendarNowSelecTtitle"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                toDisplayString(_ctx._nowDateLable)
                            )
                        }
                        ), "_" to 1), 8, utsArrayOf(
                            "color"
                        )),
                        createVNode(_component_x_icon, utsMapOf("color" to _ctx._color, "font-size" to "24", "name" to "arrow-up-s-fill"), null, 8, utsArrayOf(
                            "color"
                        ))
                    ), 12, utsArrayOf(
                        "onClick"
                    )),
                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("display" to "flex", "flex-direction" to "row", "justify-content" to "center", "align-items" to "center"))), utsArrayOf(
                        createVNode(_component_x_stepper, utsMapOf("onChange" to _ctx.yearChange, "width" to "170", "btn-width" to "50", "height" to "40", "modelValue" to _ctx.nowYear, "onUpdate:modelValue" to fun(`$event`: Number){
                            _ctx.nowYear = `$event`
                        }
                        , "min" to _ctx._startDate.getYear(), "max" to _ctx._endDate.getYear()), null, 8, utsArrayOf(
                            "onChange",
                            "modelValue",
                            "onUpdate:modelValue",
                            "min",
                            "max"
                        ))
                    ), 4)
                ), 4),
                createElementVNode("view", utsMapOf("class" to "xCalendarSetBoxMonth"), utsArrayOf(
                    createElementVNode(Fragment, null, RenderHelpers.renderList(12, fun(item, index, __index, _cached): Any {
                        return createElementVNode("view", utsMapOf("onClick" to fun(){
                            _ctx.setMonth(index)
                        }
                        , "style" to normalizeStyle(utsMapOf("backgroundColor" to if (_ctx.nowMonth == item) {
                            _ctx._color
                        } else {
                            "transparent"
                        }
                        )), "class" to "xCalendarSetBoxMonthItem", "key" to index), utsArrayOf(
                            createVNode(_component_x_text, utsMapOf("color" to if (_ctx.nowMonth == item) {
                                "white"
                            } else {
                                "#333"
                            }
                            , "fontSize" to "18"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    toDisplayString(item) + "月"
                                )
                            }
                            ), "_" to 2), 1032, utsArrayOf(
                                "color"
                            ))
                        ), 12, utsArrayOf(
                            "onClick"
                        ))
                    }
                    ), 64)
                ))
            ), 4)
        ))
    }
    open var modelValue: String by `$props`
    open var disabledDays: UTSArray<String> by `$props`
    open var startDate: String by `$props`
    open var endDate: String by `$props`
    open var dateStyle: UTSArray<xCalendarDateStyle_type> by `$props`
    open var format: String by `$props`
    open var color: String by `$props`
    open var hideHeader: Boolean by `$props`
    open var disabledSwiper: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var vertical: Boolean by `$props`
    open var nowDate: xDate by `$data`
    open var selectedDate: String by `$data`
    open var weeksCn: UTSArray<String> by `$data`
    open var bodyHeight: Any? by `$data`
    open var tid: Number by `$data`
    open var caleBodySize: BODY_SIZE_TYPE by `$data`
    open var xCalendarViewObj: xCalendarView? by `$data`
    open var isShowYearAndMonthBox: Boolean by `$data`
    open var boxWidth: Number by `$data`
    open var boxHeight: Number by `$data`
    open var swiperCuureindex: Number by `$data`
    open var list: UTSArray<String> by `$data`
    open var fullyeBox: BODY_SIZE_TYPE by `$data`
    open var nowYear: Number by `$data`
    open var _nowDateValue: String by `$data`
    open var _vertical: Boolean by `$data`
    open var _hideHeader: Boolean by `$data`
    open var _disabledSwiper: Boolean by `$data`
    open var _disabled: Boolean by `$data`
    open var _nowDateLable: String by `$data`
    open var nowMonth: Number by `$data`
    open var _startDate: xDate by `$data`
    open var _endDate: xDate by `$data`
    open var _color: String by `$data`
    open var _isMonthBgcolor: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("nowDate" to xDate(), "selectedDate" to "", "weeksCn" to utsArrayOf(
            "周一",
            "周二",
            "周三",
            "周四",
            "周五",
            "周六",
            "周日"
        ), "bodyHeight" to (300.toString(10) + "px"), "tid" to 0, "caleBodySize" to BODY_SIZE_TYPE(height = 300, width = 0), "xCalendarViewObj" to null as xCalendarView?, "isShowYearAndMonthBox" to false, "boxWidth" to 0, "boxHeight" to 350, "swiperCuureindex" to 0, "list" to utsArrayOf<String>(), "fullyeBox" to BODY_SIZE_TYPE(height = 0, width = 0), "nowYear" to 0, "_nowDateValue" to computed<String>(fun(): String {
            return this.nowDate.format("YYYY-MM-DD")
        }
        ), "_vertical" to computed<Boolean>(fun(): Boolean {
            return this.vertical
        }
        ), "_hideHeader" to computed<Boolean>(fun(): Boolean {
            return this.hideHeader
        }
        ), "_disabledSwiper" to computed<Boolean>(fun(): Boolean {
            return this.disabledSwiper
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ), "_nowDateLable" to computed<String>(fun(): String {
            if (this.swiperCuureindex > this.list.length - 1) {
                return ""
            }
            var date = this.list[this.swiperCuureindex]
            return xDate(date).format("YYYY年MM月")
        }
        ), "nowMonth" to computed<Number>(fun(): Number {
            return this.nowDate.getMonth() + 1
        }
        ), "_startDate" to computed<xDate>(fun(): xDate {
            return xDate(this.startDate)
        }
        ), "_endDate" to computed<xDate>(fun(): xDate {
            return xDate(this.endDate)
        }
        ), "_color" to computed<String>(fun(): String {
            if (this.color == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.color)
        }
        ), "_isMonthBgcolor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                return xConfig.sheetDarkColor
            }
            return "#ffffff"
        }
        ))
    }
    open var getDefaultBoxListData = ::gen_getDefaultBoxListData_fn
    open fun gen_getDefaultBoxListData_fn(): UTSArray<String> {
        var xd = this.nowDate.getClone().format("YYYY-MM") + "-01"
        var start = this.nowDate.getClone().subtraction(1, "m").format("YYYY-MM") + "-01"
        var end = this.nowDate.getClone().add(1, "m").format("YYYY-MM") + "-01"
        return utsArrayOf(
            xd,
            end,
            start
        )
    }
    open var setDataListBySiperIndex = ::gen_setDataListBySiperIndex_fn
    open fun gen_setDataListBySiperIndex_fn(date: String): UTSArray<String> {
        var index = this.swiperCuureindex
        var currentData = xDate(date)
        var xd = currentData.getClone().format("YYYY-MM") + "-01"
        var start = currentData.getClone().subtraction(1, "m").format("YYYY-MM") + "-01"
        var end = currentData.getClone().add(1, "m").format("YYYY-MM") + "-01"
        var datas = utsArrayOf(
            end,
            start,
            xd
        )
        if (index == 0) {
            datas = utsArrayOf(
                xd,
                end,
                start
            )
        } else if (index == 1) {
            datas = utsArrayOf(
                start,
                xd,
                end
            )
        }
        return datas
    }
    open var getlistDataByNowdate = ::gen_getlistDataByNowdate_fn
    open fun gen_getlistDataByNowdate_fn(index: Number): UTSArray<String> {
        var currentData = xDate(this.list[index])
        var xd = currentData.getClone().format("YYYY-MM") + "-01"
        var start = currentData.getClone().subtraction(1, "m").format("YYYY-MM") + "-01"
        var end = currentData.getClone().add(1, "m").format("YYYY-MM") + "-01"
        var currswilistdata = this.list[index]
        var datas = utsArrayOf(
            end,
            start,
            xd
        )
        if (index == 0 && currswilistdata == xd) {
            datas = utsArrayOf(
                xd,
                end,
                start
            )
        } else if (index == 1 && currswilistdata == xd) {
            datas = utsArrayOf(
                start,
                xd,
                end
            )
        }
        return datas
    }
    open var swiperChange = ::gen_swiperChange_fn
    open fun gen_swiperChange_fn(evt: UniSwiperChangeEvent) {
        var index = evt.detail.current
        this.swiperCuureindex = index
        this.list = this.getlistDataByNowdate(index)
    }
    open var dateChange = ::gen_dateChange_fn
    open fun gen_dateChange_fn(date: String, index: Number) {
        if (date == "") {
            this.selectedDate = ""
        } else {
            this.selectedDate = xDate(date).format("YYYY-MM-DD")
        }
        this.updateEvents()
        this.`$emit`("click", this.selectedDate)
    }
    open var setNowDate = ::gen_setNowDate_fn
    open fun gen_setNowDate_fn() {
        this.nowDate = xDate()
        this.selectedDate = this.nowDate.format("YYYY-MM-DD")
        this.list = this.getDefaultBoxListData()
        this.swiperCuureindex = 0
        this.nowYear = this.nowDate.getYear()
        this.updateEvents()
    }
    open var clearDate = ::gen_clearDate_fn
    open fun gen_clearDate_fn() {
        this.selectedDate = ""
        this.updateEvents()
    }
    open var showYear = ::gen_showYear_fn
    open fun gen_showYear_fn(show: Boolean) {
        var t = this
        uni_createSelectorQuery().`in`(this).select(".xCalendar").boundingClientRect().exec(fun(result){
            var node = result[0]!! as NodeInfo
            t.fullyeBox.width = node.width!!
            t.fullyeBox.height = node.height!!
            t.isShowYearAndMonthBox = show
        }
        )
    }
    open var updateEvents = ::gen_updateEvents_fn
    open fun gen_updateEvents_fn() {
        var formatdate = this.selectedDate
        this.`$emit`("update:modelValue", formatdate)
        this.`$emit`("change", formatdate)
    }
    open var yearChange = ::gen_yearChange_fn
    open fun gen_yearChange_fn(year: Number) {
        var dtx = this.nowDate.getClone().setDateOf(year, "y").format("YYYY-MM-DD")
        this.nowDate = xDate(dtx)
        this.selectedDate = this.nowDate.format("YYYY-MM-DD")
        this.list = this.setDataListBySiperIndex(this.selectedDate)
        this.updateEvents()
        this.`$emit`("currentChange", this.selectedDate)
    }
    open var setMonth = ::gen_setMonth_fn
    open fun gen_setMonth_fn(index: Number) {
        var dtx = this.nowDate.getClone().setDateOf(index, "m").format("YYYY-MM-DD")
        this.nowDate = xDate(dtx)
        this.selectedDate = this.nowDate.format("YYYY-MM-DD")
        this.list = this.setDataListBySiperIndex(this.selectedDate)
        this.updateEvents()
        this.isShowYearAndMonthBox = false
        this.nowYear = this.nowDate.getYear()
        this.`$emit`("currentChange", this.selectedDate)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xCalendar" to padStyleMapOf(utsMapOf("display" to "flex", "position" to "relative")), "xCalendarSetBoxMonthItem" to padStyleMapOf(utsMapOf("width" to "33.33%", "height" to "25%", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10)), "xCalendarSetBoxMonth" to padStyleMapOf(utsMapOf("flex" to 1, "display" to "flex", "flexDirection" to "row", "flexWrap" to "wrap")), "xCalendarSetBox" to padStyleMapOf(utsMapOf("position" to "absolute", "display" to "flex", "flexDirection" to "column", "transitionProperty" to "width,height,opacity", "transitionDuration" to "0.2s", "transitionTimingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)")), "xCalendarNowSelecTtitle" to padStyleMapOf(utsMapOf("fontSize" to 16, "fontWeight" to "bold", "paddingLeft" to 10)), "headerItemXcalendar" to padStyleMapOf(utsMapOf("paddingTop" to 0, "paddingRight" to 16, "paddingBottom" to 0, "paddingLeft" to 16, "height" to "100%", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "xCalendarViewHeader" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row")), "xCalendarViewDate" to padStyleMapOf(utsMapOf("width" to "14.28%", "height" to 40, "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "@TRANSITION" to utsMapOf("xCalendarSetBox" to utsMapOf("property" to "width,height,opacity", "duration" to "0.2s", "timingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("change" to null, "click" to null, "currentChange" to null, "update:modelValue" to null)
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "String", "default" to ""), "disabledDays" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>()
        }
        ), "startDate" to utsMapOf("type" to "String", "default" to "2020-1-1"), "endDate" to utsMapOf("type" to "String", "default" to "2040-12-31"), "dateStyle" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<xCalendarDateStyle_type> {
            return utsArrayOf<xCalendarDateStyle_type>()
        }
        ), "format" to utsMapOf("type" to "String", "default" to "YYYY-MM-DD"), "color" to utsMapOf("type" to "String", "default" to ""), "hideHeader" to utsMapOf("type" to "Boolean", "default" to false), "disabledSwiper" to utsMapOf("type" to "Boolean", "default" to false), "disabled" to utsMapOf("type" to "Boolean", "default" to false), "vertical" to utsMapOf("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = utsArrayOf(
            "modelValue",
            "disabledDays",
            "startDate",
            "endDate",
            "dateStyle",
            "format",
            "color",
            "hideHeader",
            "disabledSwiper",
            "disabled",
            "vertical"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf("calendar" to GenUniModulesTmxUiComponentsXCalendarViewCalenderClass)
    }
}
