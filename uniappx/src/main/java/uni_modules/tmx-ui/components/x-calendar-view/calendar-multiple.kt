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
open class GenUniModulesTmxUiComponentsXCalendarViewCalendarMultiple : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var modelValue: String by `$props`
    open var model: String by `$props`
    open var disabledDays: UTSArray<String> by `$props`
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
    open var currentDate: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsXCalendarViewCalendarMultiple) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsXCalendarViewCalendarMultiple
            val _cache = __ins.renderCache
            val proxy = getCurrentInstance()?.proxy
            val xCalendarViewItemRef = ref<UniElement?>(null)
            var calendarDom: calendarDraw? = null
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val calendar = xCalendar()
            val _rangColor = computed(fun(): String {
                var color = if (props.rangColor == "") {
                    xConfig.color
                } else {
                    props.rangColor
                }
                var rgba = hexToRgb(getDefaultColor(color))
                return "rgba(" + rgba.getNumber("r") + "," + rgba.getNumber("g") + "," + rgba.getNumber("b") + "," + (if (props.rangColor == "") {
                    0.2
                } else {
                    1
                }
                ) + ")"
            }
            )
            val _modelValue = computed(fun(): String {
                return props.modelValue
            }
            )
            val _model = computed(fun(): xCalendarMode {
                return props.model
            }
            )
            fun <T> splitArray(ar: UTSArray<T>, len: Number): UTSArray<UTSArray<T>> {
                val result: UTSArray<UTSArray<T>> = utsArrayOf()
                run {
                    var i: Number = 0
                    while(i < ar.length){
                        result.push(ar.slice(i, i + len))
                        i += len
                    }
                }
                return result
            }
            val _fontSize = computed(fun(): String {
                return checkIsCssUnit("16", "")
            }
            )
            val dateArrayList = computed(fun(): UTSArray<UTSArray<xDateArrayItemType>> {
                val primaryColor = getDefaultColor(if (props.color == "") {
                    xConfig.color
                } else {
                    props.color
                }
                )
                val dates = calendar.getCalendar(props.model, props.currentDate, props.modelValue, if (props.startDate != "") {
                    Date(props.startDate.replace(UTSRegExp("-", "g"), "/"))
                } else {
                    null
                }
                , if (props.endDate != "") {
                    Date(props.endDate.replace(UTSRegExp("-", "g"), "/"))
                } else {
                    null
                }
                , xCalendarArgs(color = primaryColor, fontColor = getDefaultColor(if (xConfig.dark == "dark") {
                    props.fontDarkColor
                } else {
                    props.fontColor
                }
                ), activeFontColor = getDefaultColor(props.activeFontColor), rangColor = _rangColor.value, rangFontColor = if (props.rangFontColor == "") {
                    primaryColor
                } else {
                    getDefaultColor(props.rangFontColor)
                }
                ), props.dateStyle, props.disabledDays)
                return splitArray<xDateArrayItemType>(dates, 7)
            }
            )
            fun gen_showLabel_fn(item: xDateArrayItemType): String {
                if (item.isInstart && item.isInEnd && _model.value == "range") {
                    return "本日"
                }
                if (item.isInstart && !item.isInEnd && _model.value == "range") {
                    return "开始"
                }
                if (!item.isInstart && item.isInEnd && _model.value == "range") {
                    return "结束"
                }
                return ""
            }
            val showLabel = ::gen_showLabel_fn
            fun gen_dateClick_fn(item: xDateArrayItemType) {
                if (item.disabled) {
                    return
                }
                emit("click", item)
            }
            val dateClick = ::gen_dateClick_fn
            fun gen_draw_fn(): UTSPromise<Any> {
                return UTSPromise(fun(_resolve, _reject){
                    calendarDom?.draw(dateArrayList.value, _model.value)
                }
                )
            }
            val draw = ::gen_draw_fn
            fun gen_canvsClick_fn(e: UniPointerEvent) {
                xCalendarViewItemRef.value?.getBoundingClientRectAsync()?.then(fun(rect: DOMRect){
                    var cellHeight: Number = 50
                    var cellWidth = rect.width / 7
                    var top = rect.top
                    var left = rect.left
                    var x = e.clientX - left
                    var y = e.clientY - top
                    var col = Math.floor(x / cellWidth)
                    var row = Math.floor(y / cellHeight)
                    var item = dateArrayList.value[row][col]
                    fun testThread(): UTSPromise<Any> {
                        return UTSPromise(fun(_resolve, _reject){
                            dateClick(item)
                        }
                        )
                    }
                    testThread()
                }
                )?.`catch`(fun(er){
                    console.error(er)
                }
                )
            }
            val canvsClick = ::gen_canvsClick_fn
            watch(fun(): Any {
                return dateArrayList.value
            }
            , fun(){
                draw()
            }
            )
            onMounted(fun(){
                calendarDom = calendarDraw(xCalendarViewItemRef.value, proxy)
                nextTick(fun(){
                    draw()
                }
                )
            }
            )
            return fun(): Any? {
                return createElementVNode("view", utsMapOf("class" to "xCalendarViewItem", "ref_key" to "xCalendarViewItemRef", "ref" to xCalendarViewItemRef, "onClick" to canvsClick), null, 512)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xCalendarViewItem" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("change" to null, "click" to null)
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "String", "required" to true, "default" to ""), "model" to utsMapOf("type" to "String", "required" to true, "default" to "day" as xCalendarMode), "disabledDays" to utsMapOf("type" to "Array", "required" to true, "default" to utsArrayOf<String>()), "startDate" to utsMapOf("type" to "String", "required" to true, "default" to "1900-1-1"), "endDate" to utsMapOf("type" to "String", "required" to true, "default" to "2025-5-13"), "dateStyle" to utsMapOf("type" to "Array", "required" to true, "default" to utsArrayOf<xCalendarDateStyle_type>()), "format" to utsMapOf("type" to "String", "required" to true, "default" to "YYYY-MM-DD"), "color" to utsMapOf("type" to "String", "required" to true, "default" to ""), "fontColor" to utsMapOf("type" to "String", "required" to true, "default" to "#333333"), "fontDarkColor" to utsMapOf("type" to "String", "required" to true, "default" to "#ffffff"), "activeFontColor" to utsMapOf("type" to "String", "required" to true, "default" to "#ffffff"), "rangColor" to utsMapOf("type" to "String", "required" to true, "default" to ""), "rangFontColor" to utsMapOf("type" to "String", "required" to true, "default" to ""), "currentDate" to utsMapOf("type" to "String", "required" to true, "default" to "")))
        var propsNeedCastKeys = utsArrayOf(
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
            "rangFontColor",
            "currentDate"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
