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
open class GenUniModulesTmxUiComponentsXCalendarViewXCalendarView : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var modelValue: String by `$props`
    open var model: String by `$props`
    open var disabledDays: UTSArray<String> by `$props`
    open var disabled: Boolean by `$props`
    open var vertical: Boolean by `$props`
    open var startDate: String by `$props`
    open var endDate: String by `$props`
    open var dateStyle: UTSArray<xCalendarDateStyle_type> by `$props`
    open var format: String by `$props`
    open var color: String by `$props`
    open var fontColor: String by `$props`
    open var fontDarkColor: String by `$props`
    open var activeFontColor: String by `$props`
    open var rangColor: String by `$props`
    open var rangFontColor: String by `$props`
    open var headBgColor: String by `$props`
    open var headFontColor: String by `$props`
    open var headStyle: String by `$props`
    open var renderOnly: Boolean by `$props`
    open var next: () -> Unit
        get() {
            return unref(this.`$exposed`["next"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "next", value)
        }
    open var prev: () -> Unit
        get() {
            return unref(this.`$exposed`["prev"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "prev", value)
        }
    open var setCurrentMonth: () -> Unit
        get() {
            return unref(this.`$exposed`["setCurrentMonth"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setCurrentMonth", value)
        }
    open var clear: () -> Unit
        get() {
            return unref(this.`$exposed`["clear"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "clear", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsXCalendarViewXCalendarView, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsXCalendarViewXCalendarView
            val _cache = __ins.renderCache
            val calendar = xCalendar()
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val weeksCn = _uA(
                "周一",
                "周二",
                "周三",
                "周四",
                "周五",
                "周六",
                "周日"
            )
            val _headBgColor = computed(fun(): String {
                return getDefaultColor(props.headBgColor)
            }
            )
            val _headFontColor = computed(fun(): String {
                if (props.headFontColor == "") {
                    return "#333333"
                }
                return getDefaultColor(props.headFontColor)
            }
            )
            val _modelValue = ref(props.modelValue)
            val _currentDate = ref(xDate(props.modelValue).format("YYYY-MM-DD"))
            val _currentDateSwipersIndex = ref(0)
            val _currentDateSwipers = ref(_uA<String>())
            val _currentDateLabel = computed(fun(): String {
                var ars = _currentDate.value.split("-")
                return "" + ars[0] + "\u5E74" + ars[1] + "\u6708"
            }
            )
            val _currentYear = ref(xDate(props.modelValue).getYear())
            var _modelValueDate = computed(fun(): Date {
                if (_modelValue.value == "") {
                    return Date(_currentDate.value.replace(UTSRegExp("-", "g"), "/"))
                }
                return Date(_modelValue.value.replace(UTSRegExp("-", "g"), "/"))
            }
            )
            val _tipsText = computed(fun(): String {
                return if (_modelValue.value != "") {
                    "\u5DF2\u9009\u62E9"
                } else {
                    "未选择日期"
                }
            }
            )
            val _monthBgColor = computed(fun(): String {
                return if (xConfig.dark == "dark") {
                    xConfig.sheetDarkColor
                } else {
                    "#ffffff"
                }
            }
            )
            val _color = computed(fun(): String {
                return if (props.color == "") {
                    getDefaultColor(xConfig.color)
                } else {
                    getDefaultColor(props.color)
                }
            }
            )
            val showPanel = ref(false)
            fun gen_dateClick_fn(item: xDateArrayItemType) {
                val isInselected = calendar.isInCurrente(Date(item.date.date), _modelValueDate.value)
                emit("click", item.date.date)
                if (props.disabled) {
                    return
                }
                var dates = _modelValue.value
                if (isInselected) {
                    dates = ""
                } else {
                    dates = item.date.date
                }
                _modelValue.value = dates
                val nowFormat = xDate(_modelValue.value).format(props.format)
                emit("update:modelValue", nowFormat)
                emit("change", nowFormat)
            }
            val dateClick = ::gen_dateClick_fn
            fun gen_getSwiperListCurrentDates_fn(nowCurrentDate: String): UTSArray<String> {
                var index = _currentDateSwipersIndex.value
                var currentData = xDate(nowCurrentDate)
                var xd = currentData.getClone().setDateOf(1, "d").format("YYYY-MM-DD")
                var start = currentData.getClone().setDateOf(1, "d").subtraction(1, "m").format("YYYY-MM-DD")
                var end = currentData.getClone().setDateOf(1, "d").add(1, "m").format("YYYY-MM-DD")
                var datas = _uA(
                    xd,
                    end,
                    start
                )
                if (_currentDateSwipers.value.length == 0) {
                    return datas
                }
                if (index == 0) {
                    datas = _uA(
                        xd,
                        end,
                        start
                    )
                } else if (index == 1) {
                    datas = _uA(
                        start,
                        xd,
                        end
                    )
                } else if (index == 2) {
                    datas = _uA(
                        end,
                        start,
                        xd
                    )
                }
                return datas
            }
            val getSwiperListCurrentDates = ::gen_getSwiperListCurrentDates_fn
            fun gen_clear_fn() {
                if (_modelValue.value == "") {
                    return
                }
                _modelValue.value = ""
                emit("update:modelValue", _modelValue.value)
                emit("change", _modelValue.value)
            }
            val clear = ::gen_clear_fn
            fun gen_nowMonth_fn() {
                var nowdate = xDate()
                _currentDate.value = nowdate.format("YYYY-MM-DD")
                _currentYear.value = nowdate.getYear()
                _currentDateSwipers.value = getSwiperListCurrentDates(_currentDate.value)
                emit("currentChange", _currentDate.value)
                emit("update:currentDate", _currentDate.value)
            }
            val nowMonth = ::gen_nowMonth_fn
            fun gen_stepperChangeYear_fn(eyear: Number) {
                var nowdate = xDate(_currentDate.value)
                nowdate.setDateOf(eyear, "y")
                _currentDate.value = nowdate.format("YYYY-MM-DD")
                _currentDateSwipers.value = getSwiperListCurrentDates(_currentDate.value)
                emit("currentChange", _currentDate.value)
                emit("update:currentDate", _currentDate.value)
            }
            val stepperChangeYear = ::gen_stepperChangeYear_fn
            fun gen_changeMonth_fn(eyear: Number) {
                var nowdate = xDate(_currentDate.value)
                nowdate.setDateOf(eyear, "m")
                _currentDate.value = nowdate.format("YYYY-MM-DD")
                _currentYear.value = nowdate.getYear()
                showPanel.value = false
                emit("currentChange", _currentDate.value)
                emit("update:currentDate", _currentDate.value)
                _currentDateSwipers.value = getSwiperListCurrentDates(_currentDate.value)
            }
            val changeMonth = ::gen_changeMonth_fn
            fun gen_nextMonth_fn() {
                var nowdate = xDate(_currentDate.value)
                nowdate.add(1, "m")
                _currentDate.value = nowdate.format("YYYY-MM-DD")
                _currentYear.value = nowdate.getYear()
                _currentDateSwipers.value = getSwiperListCurrentDates(_currentDate.value)
                emit("currentChange", _currentDate.value)
                emit("update:currentDate", _currentDate.value)
            }
            val nextMonth = ::gen_nextMonth_fn
            fun gen_prevMonth_fn() {
                var nowdate = xDate(_currentDate.value)
                nowdate.subtraction(1, "m")
                _currentDate.value = nowdate.format("YYYY-MM-DD")
                _currentYear.value = nowdate.getYear()
                _currentDateSwipers.value = getSwiperListCurrentDates(_currentDate.value)
                emit("currentChange", _currentDate.value)
                emit("update:currentDate", _currentDate.value)
            }
            val prevMonth = ::gen_prevMonth_fn
            fun gen_swiperChange_fn(evt: UniSwiperChangeEvent) {
                _currentDateSwipersIndex.value = evt.detail.current
                nextTick(fun(){
                    _currentDate.value = _currentDateSwipers.value[evt.detail.current]
                    _currentDateSwipers.value = getSwiperListCurrentDates(_currentDate.value)
                    var nowdate = xDate(_currentDate.value)
                    _currentYear.value = nowdate.getYear()
                    emit("currentChange", _currentDate.value)
                    emit("update:currentDate", _currentDate.value)
                }
                )
            }
            val swiperChange = ::gen_swiperChange_fn
            watch(_uA(
                fun(): String {
                    return props.modelValue
                }
            ), fun(){
                var nowdate = xDate(props.modelValue).setDateOf(1, "d")
                _modelValue.value = props.modelValue
                if (props.modelValue != "") {
                    var nowcurrentDate = nowdate
                    if (nowcurrentDate.format("YYYY-MM-DD") == _currentDate.value) {
                        return
                    }
                    _currentDate.value = nowcurrentDate.format("YYYY-MM-DD")
                    _currentYear.value = nowcurrentDate.getYear()
                    _currentDateSwipersIndex.value = 0
                    _currentDateSwipers.value = getSwiperListCurrentDates(_currentDate.value)
                }
            }
            )
            onMounted(fun(){
                if (props.modelValue != "") {
                    var nowdate = xDate(props.modelValue)
                    _currentDate.value = nowdate.format("YYYY-MM-DD")
                    _currentYear.value = nowdate.getYear()
                }
                nextTick(fun(){
                    _currentDateSwipers.value = getSwiperListCurrentDates(_currentDate.value)
                    emit("update:currentDate", _currentDate.value)
                }
                )
            }
            )
            fun gen_getmonth_fn(item: String): Number {
                var vls = item.split("-")
                return parseInt(vls[1])
            }
            val getmonth = ::gen_getmonth_fn
            __expose(_uM("next" to fun() {
                nextMonth()
            }
            , "prev" to fun() {
                prevMonth()
            }
            , "setCurrentMonth" to fun() {
                nowMonth()
            }
            , "clear" to fun() {
                clear()
            }
            ))
            return fun(): Any? {
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
                val _component_x_stepper = resolveEasyComponent("x-stepper", GenUniModulesTmxUiComponentsXStepperXStepperClass)
                return _cE("view", _uM("class" to "xCalendarView"), _uA(
                    renderSlot(_ctx.`$slots`, "header", UTSJSONObject(), fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to _nC(_uA(
                                "xCalendarViewDataHeaderWrap",
                                _uA(
                                    if (unref(showPanel)) {
                                        "xCalendarViewMonthOff"
                                    } else {
                                        "xCalendarViewMonthOn"
                                    }
                                )
                            )), "style" to _nS(_uA(
                                _uM("backgroundColor" to unref(_headBgColor)),
                                _ctx.headStyle
                            ))), _uA(
                                _cE("view", _uM("class" to "xCalendarViewHeader", "style" to _nS(_uM("padding" to "0 12px"))), _uA(
                                    _cE("view", _uM("onClick" to fun(){
                                        showPanel.value = !unref(showPanel)
                                    }
                                    , "class" to "xCalendarViewHeaderLeft"), _uA(
                                        _cV(_component_x_text, _uM("color" to unref(_headFontColor), "font-size" to "21"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(_currentDateLabel))
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "color"
                                        )),
                                        _cV(_component_x_icon, _uM("color" to unref(_headFontColor), "font-size" to "21", "name" to "arrow-down-s-fill"), null, 8, _uA(
                                            "color"
                                        ))
                                    ), 8, _uA(
                                        "onClick"
                                    )),
                                    _cE("view", _uM("class" to "xCalendarViewHeaderRight"), _uA(
                                        _cV(_component_x_text, _uM("onClick" to clear, "color" to unref(_headFontColor), "style" to _nS(_uM("padding" to "10px 20px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                "清空"
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "color",
                                            "style"
                                        )),
                                        _cV(_component_x_text, _uM("onClick" to nowMonth, "color" to unref(_headFontColor), "style" to _nS(_uM("padding" to "10px 0px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                "本月"
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "color",
                                            "style"
                                        ))
                                    ))
                                ), 4),
                                _cE("view", _uM("class" to "xCalendarViewDataHeader"), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(7, fun(item, index, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "xCalendarViewDataHeaderItem", "key" to item), _uA(
                                            _cV(_component_x_text, _uM("color" to unref(_headFontColor), "font-size" to "12"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(weeksCn[index])
                                                )
                                            }
                                            ), "_" to 2), 1032, _uA(
                                                "color"
                                            ))
                                        ))
                                    }
                                    ), 64)
                                ))
                            ), 6)
                        )
                    }
                    ),
                    _cE("view", _uM("class" to "xCalendarViewSpace")),
                    _cE("view", _uM("class" to _nC(_uA(
                        _uA(
                            if (unref(showPanel)) {
                                "xCalendarViewMonthOff"
                            } else {
                                "xCalendarViewMonthOn"
                            }
                        ),
                        "xCalendarViewWrap"
                    ))), _uA(
                        if (unref(_currentDateSwipers).length > 0) {
                            _cE("swiper", _uM("key" to 0, "vertical" to props.vertical, "onChange" to swiperChange, "current" to unref(_currentDateSwipersIndex), "circular" to true, "style" to _nS(_uM("width" to "100%", "height" to "100%"))), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(_currentDateSwipers), fun(item, index, __index, _cached): Any {
                                    return _cE("swiper-item", _uM("key" to index, "style" to _nS(_uM("width" to "100%", "height" to "100%"))), _uA(
                                        _cE("view", _uM("style" to _nS(_uM("width" to "100%", "height" to "100%", "position" to "relative"))), _uA(
                                            _cE("view", _uM("class" to "xCalendarViewContentBox"), _uA(
                                                if (isTrue(index == unref(_currentDateSwipersIndex) || !props.renderOnly)) {
                                                    _cV(unref(GenUniModulesTmxUiComponentsXCalendarViewCalendarMultipleClass), _uM("key" to 0, "onClick" to dateClick, "currentDate" to item, "modelValue" to props.modelValue, "model" to props.model, "disabledDays" to props.disabledDays, "startDate" to props.startDate, "endDate" to props.endDate, "dateStyle" to props.dateStyle, "format" to props.format, "color" to props.color, "fontColor" to props.fontColor, "fontDarkColor" to props.fontDarkColor, "activeFontColor" to props.activeFontColor, "rangColor" to props.rangColor, "rangFontColor" to props.rangFontColor), null, 8, _uA(
                                                        "currentDate",
                                                        "modelValue",
                                                        "model",
                                                        "disabledDays",
                                                        "startDate",
                                                        "endDate",
                                                        "dateStyle",
                                                        "format",
                                                        "color",
                                                        "fontColor",
                                                        "fontDarkColor",
                                                        "activeFontColor",
                                                        "rangColor",
                                                        "rangFontColor"
                                                    ))
                                                } else {
                                                    _cC("v-if", true)
                                                }
                                            )),
                                            _cE("view", _uM("class" to "xCalendarViewNum"), _uA(
                                                _cE("text", _uM("class" to "xCalendarViewNumText"), _tD(getmonth(item)), 1)
                                            ))
                                        ), 4)
                                    ), 4)
                                }), 128)
                            ), 44, _uA(
                                "vertical",
                                "current"
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                    ), 2),
                    _cE("view", _uM("class" to "xCalendarViewSpace")),
                    renderSlot(_ctx.`$slots`, "footer", UTSJSONObject(), fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "xCalendarViewFooter"), _uA(
                                _cV(_component_x_text, _uM("color" to "#707070", "font-size" to "14"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(unref(_tipsText))
                                    )
                                }
                                ), "_" to 1))
                            ))
                        )
                    }
                    ),
                    _cE("view", _uM("class" to _nC(_uA(
                        _uA(
                            if (unref(showPanel)) {
                                "xCalendarViewMonthOn"
                            } else {
                                "xCalendarViewMonthOff"
                            }
                        ),
                        "xCalendarViewMonth"
                    )), "style" to _nS(_uM("backgroundColor" to unref(_monthBgColor)))), _uA(
                        _cE("view", _uM("class" to "xCalendarViewHeader", "style" to _nS(_uM("padding" to "0 12px"))), _uA(
                            _cE("view", _uM("onClick" to fun(){
                                showPanel.value = !unref(showPanel)
                            }
                            , "class" to "xCalendarViewHeaderLeft"), _uA(
                                _cV(_component_x_text, _uM("color" to unref(_color), "font-size" to "21"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(unref(_currentDateLabel))
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "color"
                                )),
                                _cV(_component_x_icon, _uM("color" to unref(_color), "font-size" to "21", "name" to "arrow-up-s-fill"), null, 8, _uA(
                                    "color"
                                ))
                            ), 8, _uA(
                                "onClick"
                            )),
                            _cE("view", _uM("class" to "xCalendarViewHeaderRight"), _uA(
                                _cV(_component_x_stepper, _uM("onChange" to stepperChangeYear, "modelValue" to unref(_currentYear), "onUpdate:modelValue" to fun(`$event`: Number){
                                    trySetRefValue(_currentYear, `$event`)
                                }
                                , "min" to 1900, "max" to 5000, "width" to "120"), null, 8, _uA(
                                    "modelValue"
                                ))
                            ))
                        ), 4),
                        _cE("view", _uM("class" to "xCalendarViewMonthWrap", "style" to _nS(_uM("flex" to "1"))), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(12, fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("onClick" to fun(){
                                    changeMonth(index)
                                }
                                , "class" to "xCalendarViewMonthItem", "key" to index), _uA(
                                    _cV(_component_x_text, _uM("font-size" to "18"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(item) + "月"
                                        )
                                    }
                                    ), "_" to 2), 1024)
                                ), 8, _uA(
                                    "onClick"
                                ))
                            }
                            ), 64)
                        ), 4)
                    ), 6)
                ))
            }
        }
        var name = "xCalendarMultiple"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xCalendarViewMonth" to _uM("" to _uM("position" to "absolute", "zIndex" to 3, "left" to 0, "top" to 0, "width" to "100%", "height" to "100%", "display" to "flex", "flexDirection" to "column", "transitionProperty" to "transform,opacity", "transitionTimingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)", "transitionDuration" to "0.3s"), ".xCalendarViewMonthOff" to _uM("pointerEvents" to "none", "opacity" to 0, "transform" to "scale(0, 0)"), ".xCalendarViewMonthOn" to _uM("pointerEvents" to "auto", "opacity" to 1, "transform" to "scale(1, 1)")), "xCalendarViewMonthWrap" to _uM(".xCalendarViewMonth " to _uM("display" to "flex", "flexDirection" to "row", "flexWrap" to "wrap")), "xCalendarViewMonthItem" to _uM(".xCalendarViewMonth .xCalendarViewMonthWrap " to _uM("width" to "33.3333%", "height" to "25%", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "xCalendarViewWrap" to _uM("" to _uM("transitionProperty" to "transform,opacity", "transitionTimingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)", "transitionDuration" to "0.3s", "position" to "relative", "width" to "100%", "flex" to 1), ".xCalendarViewMonthOff" to _uM("pointerEvents" to "none", "opacity" to 0, "transform" to "scale(2, 2)"), ".xCalendarViewMonthOn" to _uM("pointerEvents" to "auto", "opacity" to 1, "transform" to "scale(1, 1)")), "xCalendarViewContentBox" to _uM(".xCalendarViewWrap " to _uM("position" to "absolute", "left" to 0, "top" to 0, "width" to "100%", "height" to "100%", "zIndex" to 3)), "xCalendarViewNum" to _uM(".xCalendarViewWrap " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "width" to "100%", "height" to "100%")), "xCalendarViewNumText" to _uM(".xCalendarViewWrap .xCalendarViewNum " to _uM("fontSize" to 200, "color" to "rgba(125,125,125,0.1)", "fontWeight" to "bold")), "xCalendarViewDataHeaderWrap" to _uM("" to _uM("transitionProperty" to "transform,opacity", "transitionTimingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)", "transitionDuration" to "0.3s"), ".xCalendarViewMonthOff" to _uM("pointerEvents" to "none", "opacity" to 0), ".xCalendarViewMonthOn" to _uM("pointerEvents" to "auto", "opacity" to 1)), "xCalendarViewSpace" to _pS(_uM("height" to 5)), "xCalendarViewHeader" to _pS(_uM("height" to 50, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "xCalendarViewHeaderLeft" to _uM(".xCalendarViewHeader " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center")), "xCalendarViewHeaderRight" to _uM(".xCalendarViewHeader " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end", "alignItems" to "center")), "xCalendarViewDataHeader" to _pS(_uM("height" to 40, "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "xCalendarViewDataHeaderItem" to _uM(".xCalendarViewDataHeader " to _uM("width" to "14.285%", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "xCalendarView" to _pS(_uM("position" to "relative", "display" to "flex", "flexDirection" to "column", "minHeight" to 440)), "xCalendarViewFooter" to _pS(_uM("height" to 40, "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "@TRANSITION" to _uM("xCalendarViewMonth" to _uM("property" to "transform,opacity", "timingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)", "duration" to "0.3s"), "xCalendarViewWrap" to _uM("property" to "transform,opacity", "timingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)", "duration" to "0.3s"), "xCalendarViewDataHeaderWrap" to _uM("property" to "transform,opacity", "timingFunction" to "cubic-bezier(0.42,0.38,0.15,0.93)", "duration" to "0.3s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "click" to null, "currentChange" to null, "update:modelValue" to null, "update:currentDate" to null)
        var props = _nP(_uM("modelValue" to _uM("type" to "String", "required" to true, "default" to ""), "model" to _uM("type" to "String", "required" to true, "default" to "day"), "disabledDays" to _uM("type" to "Array", "required" to true, "default" to _uA<String>()), "disabled" to _uM("type" to "Boolean", "required" to true, "default" to false), "vertical" to _uM("type" to "Boolean", "required" to true, "default" to false), "startDate" to _uM("type" to "String", "required" to true, "default" to "1900-1-1"), "endDate" to _uM("type" to "String", "required" to true, "default" to "2100-1-1"), "dateStyle" to _uM("type" to "Array", "required" to true, "default" to _uA<xCalendarDateStyle_type>()), "format" to _uM("type" to "String", "required" to true, "default" to "YYYY-MM-DD"), "color" to _uM("type" to "String", "required" to true, "default" to ""), "fontColor" to _uM("type" to "String", "required" to true, "default" to "#333333"), "fontDarkColor" to _uM("type" to "String", "required" to true, "default" to "#ffffff"), "activeFontColor" to _uM("type" to "String", "required" to true, "default" to "#ffffff"), "rangColor" to _uM("type" to "String", "required" to true, "default" to ""), "rangFontColor" to _uM("type" to "String", "required" to true, "default" to ""), "headBgColor" to _uM("type" to "String", "required" to true, "default" to "transparent"), "headFontColor" to _uM("type" to "String", "required" to true, "default" to ""), "headStyle" to _uM("type" to "String", "required" to true, "default" to ""), "renderOnly" to _uM("type" to "Boolean", "required" to true, "default" to true)))
        var propsNeedCastKeys = _uA(
            "modelValue",
            "model",
            "disabledDays",
            "disabled",
            "vertical",
            "startDate",
            "endDate",
            "dateStyle",
            "format",
            "color",
            "fontColor",
            "fontDarkColor",
            "activeFontColor",
            "rangColor",
            "rangFontColor",
            "headBgColor",
            "headFontColor",
            "headStyle",
            "renderOnly"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
