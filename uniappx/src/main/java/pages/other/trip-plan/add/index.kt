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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
open class GenPagesOtherTripPlanAddIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop
        }
        , __ins)
        onResize(fun(_: OnResizeOptions) {
            uni__emit("onResize", fun() {})
        }
        , __ins)
        onLoad(fun(_: OnLoadOptions) {}, __ins)
        onPageHide(fun() {
            uni__emit("onHide", fun() {})
        }
        , __ins)
        onReady(fun() {
            uni__emit("onReady", fun() {})
            xProvitae.pageReady = true
        }
        , __ins)
        onPageShow(fun() {
            uni__emit("onShow", fun() {})
        }
        , __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesOtherTripPlanAddIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherTripPlanAddIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val planGoTime = ref("")
            val planGoTimeStr = ref("")
            val startDate = ref("")
            val endDate = ref("")
            val bindCar = ref("")
            val bindLinesGrp = ref("")
            val bindDistrictLines = ref(utsArrayOf<DriverBindDistrictLines1>())
            val tagList = ref(utsArrayOf<TripPlanTagInfo>())
            val seatTemplates = ref(utsArrayOf<SeatSelectTemplate>())
            val seatSelectData = ref<Map<String, ChooseSeat>>(Map())
            val seatSelect = ref<McSeatSelectComponentPublicInstance?>(null)
            val selectDate = ref("")
            val showLines = ref(false)
            val show = fun(planId: String, date: String){
                searchDriverPlanByPlanId(planId).then(fun(res: Response){
                    if (res.code == 200) {
                        val planData = JSON.parseObject<UTSJSONObject>(JSON.stringify(res.data)) ?: UTSJSONObject()
                        console.log("searchDriverPlanByPlanId=", planData)
                        startDate.value = planData.getString("startDate") ?: ""
                        endDate.value = planData.getString("endDate") ?: ""
                        planGoTime.value = planData.getString("startTime") ?: ""
                        bindCar.value = planData.getJSON("driveInfo")?.getString("vehiclePlateNo") ?: ""
                        bindLinesGrp.value = planData.getString("linesGroupName") ?: ""
                        bindDistrictLines.value = JSON.parseObject<UTSArray<DriverBindDistrictLines1>>(JSON.stringify(planData.getArray("carLinesList"))) ?: utsArrayOf()
                        tagList.value = JSON.parseObject<UTSArray<TripPlanTagInfo>>(JSON.stringify(planData.getArray("tagInfoList"))) ?: utsArrayOf()
                        refreshSeatTemplate("DRIVER_PLAN:ORDER_SEAT_METADATA:" + planId + ":" + date).then(fun(res: Response){
                            if (res.code == 200) {
                                seatTemplates.value = JSON.parseObject<UTSArray<SeatSelectTemplate>>(JSON.stringify(res.data)) ?: utsArrayOf()
                                seatTemplates.value.forEach(fun(item){
                                    item.selected = false
                                }
                                )
                                setTimeout(fun(){
                                    seatSelect.value?.processSeat?.invoke()
                                }
                                , 100)
                            }
                        }
                        )
                    }
                }
                )
            }
            onLoad(fun(options){
                if (options != null) {
                    val opt = JSON.parse(JSON.stringify(options)) as UTSJSONObject
                    val planId = opt.getString("id") ?: ""
                    selectDate.value = opt.getString("date") ?: ""
                    show(planId, selectDate.value)
                }
            }
            )
            return fun(): Any? {
                val _component_mc_date_picker = resolveEasyComponent("mc-date-picker", GenComponentsMcDatePickerIndexClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_picker_time = resolveEasyComponent("x-picker-time", GenUniModulesTmxUiComponentsXPickerTimeXPickerTimeClass)
                val _component_mc_seat_select = resolveEasyComponent("mc-seat-select", GenComponentsMcSeatSelectIndexClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createVNode(_component_mc_base_container, utsMapOf("title" to "行程详情"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createVNode(_component_x_sheet, utsMapOf("padding" to utsArrayOf(
                            "30rpx",
                            "26rpx"
                        ), "margin" to utsArrayOf(
                            "15",
                            "15",
                            "15",
                            "15"
                        )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createVNode(_component_mc_date_picker, utsMapOf("modelValue" to selectDate.value, "onUpdate:modelValue" to fun(`$event`: String){
                                    selectDate.value = `$event`
                                }
                                ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "form-item"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "left-box"), "出行日期"),
                                            createElementVNode("view", utsMapOf("class" to "right-box"), utsArrayOf(
                                                createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(selectDate.value), 1)
                                            ))
                                        ))
                                    )
                                }
                                ), "_" to 1), 8, utsArrayOf(
                                    "modelValue",
                                    "onUpdate:modelValue"
                                ))
                            )
                        }
                        ), "_" to 1)),
                        createVNode(_component_x_sheet, utsMapOf("padding" to utsArrayOf(
                            "30rpx",
                            "26rpx"
                        ), "margin" to utsArrayOf(
                            "15",
                            "0",
                            "15",
                            "15"
                        )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createVNode(_component_x_picker_time, utsMapOf("type" to "minute", "modelValue" to planGoTime.value, "onUpdate:modelValue" to fun(`$event`: String){
                                    planGoTime.value = `$event`
                                }
                                , "model-str" to planGoTimeStr.value, "onUpdate:modelStr" to fun(`$event`: String){
                                    planGoTimeStr.value = `$event`
                                }
                                , "format" to "hh:mm"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "form-item"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "left-box"), "发车时间"),
                                            createElementVNode("view", utsMapOf("class" to "right-box"), utsArrayOf(
                                                createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(planGoTimeStr.value), 1)
                                            ))
                                        ))
                                    )
                                }
                                ), "_" to 1), 8, utsArrayOf(
                                    "modelValue",
                                    "onUpdate:modelValue",
                                    "model-str",
                                    "onUpdate:modelStr"
                                ))
                            )
                        }
                        ), "_" to 1)),
                        createVNode(_component_x_sheet, utsMapOf("padding" to utsArrayOf(
                            "30rpx",
                            "26rpx"
                        ), "margin" to utsArrayOf(
                            "15",
                            "0",
                            "15",
                            "15"
                        )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "form-item"), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "left-box"), "关联车辆"),
                                    createElementVNode("view", utsMapOf("class" to "right-box"), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(bindCar.value), 1)
                                    ))
                                ))
                            )
                        }
                        ), "_" to 1)),
                        createVNode(_component_x_sheet, utsMapOf("padding" to utsArrayOf(
                            "30rpx",
                            "26rpx"
                        ), "margin" to utsArrayOf(
                            "15",
                            "0",
                            "15",
                            "15"
                        )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "form-item", "onClick" to fun(){
                                    showLines.value = !showLines.value
                                }
                                ), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "left-box"), "关联线路"),
                                    createElementVNode("view", utsMapOf("class" to "right-box"), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(bindLinesGrp.value), 1),
                                        if (isTrue(!showLines.value)) {
                                            createElementVNode("image", utsMapOf("key" to 0, "class" to "icon", "style" to normalizeStyle(utsMapOf("width" to "20rpx", "height" to "25rpx")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-filled-samll.png"), "mode" to "widthFix"), null, 12, utsArrayOf(
                                                "src"
                                            ))
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                        ,
                                        if (isTrue(showLines.value)) {
                                            createElementVNode("image", utsMapOf("key" to 1, "class" to "icon", "style" to normalizeStyle(utsMapOf("width" to "20rpx", "height" to "25rpx", "transform" to "rotate(180deg)")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-filled-samll.png"), "mode" to "widthFix"), null, 12, utsArrayOf(
                                                "src"
                                            ))
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                    ))
                                ), 8, utsArrayOf(
                                    "onClick"
                                )),
                                if (isTrue(showLines.value)) {
                                    createElementVNode("view", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("margin-top" to "10rpx"))), utsArrayOf(
                                        createElementVNode(Fragment, null, RenderHelpers.renderList(bindDistrictLines.value, fun(item2, index2, __index, _cached): Any {
                                            return createVNode(_component_x_sheet, utsMapOf("class" to "flex-row flex-row-center-between", "style" to normalizeStyle(utsMapOf("margin-bottom" to "5rpx")), "margin" to utsArrayOf(
                                                "0",
                                                "0",
                                                "0",
                                                "10"
                                            ), "color" to unref(globalData).theme.painColor, "height" to "30rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("view", utsMapOf("class" to "left-box flex-row flex-row-center-between"), utsArrayOf(
                                                        createElementVNode("image", utsMapOf("class" to "icon", "style" to normalizeStyle(utsMapOf("width" to "28rpx", "height" to "30rpx")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location-filled.png"), "mode" to "widthFix"), null, 12, utsArrayOf(
                                                            "src"
                                                        )),
                                                        createElementVNode("text", utsMapOf("class" to "text ml-5", "style" to normalizeStyle(utsMapOf("color" to "#949494", "font-size" to "30rpx"))), toDisplayString(item2.startDistrictName) + "-" + toDisplayString(item2.endDistrictName), 5)
                                                    ))
                                                )
                                            }), "_" to 2), 1032, utsArrayOf(
                                                "style",
                                                "color"
                                            ))
                                        }), 256)
                                    ), 4)
                                } else {
                                    createCommentVNode("v-if", true)
                                }
                            )
                        }
                        ), "_" to 1)),
                        createVNode(_component_x_sheet, utsMapOf("padding" to utsArrayOf(
                            "0"
                        ), "color" to "#00000000", "round" to utsArrayOf(
                            "0"
                        ), "margin" to utsArrayOf(
                            "15",
                            "0",
                            "15",
                            "15"
                        )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "tag_card-header flex-row flex-row-center-between"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "card-title flex-row flex-row-center-between"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "title-border", "style" to normalizeStyle("background-color: " + unref(globalData).theme.primaryColor + ";")), null, 4),
                                        createElementVNode("text", utsMapOf("class" to "text"), "配置标签")
                                    ))
                                )),
                                createElementVNode("view", utsMapOf("class" to "tag-card-list"), utsArrayOf(
                                    createElementVNode(Fragment, null, RenderHelpers.renderList(tagList.value, fun(item, index, __index, _cached): Any {
                                        return createElementVNode("view", utsMapOf("class" to "tag-card-item flex-row"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "tag-picker"), utsArrayOf(
                                                createElementVNode("text", utsMapOf("class" to "label"), "标签名称："),
                                                createElementVNode("text", utsMapOf("class" to "number-input", "style" to normalizeStyle(utsMapOf("background" to "#F5F9FF"))), toDisplayString((item.tagName as String)), 5)
                                            )),
                                            createElementVNode("view", utsMapOf("class" to "price-input"), utsArrayOf(
                                                createElementVNode("text", utsMapOf("class" to "label"), "浮动金额："),
                                                createElementVNode("text", utsMapOf("class" to "number-input"), toDisplayString((item.changeAmount as String)), 1)
                                            ))
                                        ))
                                    }
                                    ), 256)
                                ))
                            )
                        }
                        ), "_" to 1)),
                        createVNode(_component_mc_seat_select, utsMapOf("model-value" to seatSelectData.value, "showPrice" to "", "ref_key" to "seatSelect", "ref" to seatSelect, "readonly" to "", "seat-templates" to seatTemplates.value), null, 8, utsArrayOf(
                            "model-value",
                            "seat-templates"
                        ))
                    )
                }
                ), "_" to 1))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ), utsArrayOf(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("viewer-title" to padStyleMapOf(utsMapOf("fontSize" to "36rpx", "fontWeight" to "bold", "color" to "#ffffff", "textAlign" to "center")), "confirm-button" to padStyleMapOf(utsMapOf("height" to "88rpx", "lineHeight" to "88rpx", "textAlign" to "center", "width" to "92%", "backgroundImage" to "linear-gradient(90deg, #ff3232, #fc6832)", "backgroundColor" to "rgba(0,0,0,0)", "borderTopLeftRadius" to "12rpx", "borderTopRightRadius" to "12rpx", "borderBottomRightRadius" to "12rpx", "borderBottomLeftRadius" to "12rpx", "color" to "#ffffff", "fontSize" to "32rpx", "marginTop" to 0, "marginRight" to "30rpx", "marginBottom" to 0, "marginLeft" to "30rpx", "opacity:active" to 0.8)), "drawer-title" to padStyleMapOf(utsMapOf("textAlign" to "center", "width" to "100%", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "form-item" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "left-box" to utsMapOf(".form-item " to utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center"), ".car-info-item " to utsMapOf("width" to 115, "height" to 100, "position" to "relative")), "right-box" to utsMapOf(".form-item " to utsMapOf("flexDirection" to "row", "alignItems" to "center")), "text" to utsMapOf(".form-item .right-box " to utsMapOf("fontSize" to "32rpx", "color" to "#949494"), ".form-title " to utsMapOf("paddingLeft" to "20rpx", "fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000"), ".tag_card-header .card-title " to utsMapOf("paddingLeft" to "20rpx", "fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000"), ".tag_card-header .add-btn " to utsMapOf("paddingLeft" to "10rpx", "fontWeight" to "bold", "fontSize" to "32rpx"), ".tag-card-list .tag-card-item .tag-picker .picker-picker " to utsMapOf("fontSize" to "32rpx")), "value" to utsMapOf(".form-item .right-box " to utsMapOf("fontSize" to "32rpx", "color" to "#000000"), ".trip-info-card .trip-body .info-row " to utsMapOf("fontWeight" to "bold", "fontSize" to "30rpx", "color" to "#000000"), ".car-info-item .right-box .info-item " to utsMapOf("color" to "#000000", "fontSize" to 14)), "icon" to utsMapOf(".form-item .right-box " to utsMapOf("width" to 6, "height" to 12, "marginLeft" to "15rpx"), ".trip-info-card .trip-header " to utsMapOf("width" to "30rpx", "height" to "30rpx"), ".tag_card-header .add-btn " to utsMapOf("width" to "34rpx", "height" to "34rpx"), ".tag-card-list .tag-card-item .tag-picker .picker-picker " to utsMapOf("width" to "21rpx", "height" to "11rpx")), "top-box" to utsMapOf(".form-item " to utsMapOf("fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000", "paddingBottom" to "20rpx")), "bottom-box" to utsMapOf(".form-item " to utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "width" to "100%")), "form-title" to padStyleMapOf(utsMapOf("paddingBottom" to "20rpx")), "title-border" to utsMapOf(".form-title " to utsMapOf("width" to "8rpx", "height" to "33rpx", "borderTopLeftRadius" to "4rpx", "borderTopRightRadius" to "4rpx", "borderBottomRightRadius" to "4rpx", "borderBottomLeftRadius" to "4rpx"), ".tag_card-header .card-title " to utsMapOf("width" to "8rpx", "height" to "33rpx", "borderTopLeftRadius" to "4rpx", "borderTopRightRadius" to "4rpx", "borderBottomRightRadius" to "4rpx", "borderBottomLeftRadius" to "4rpx")), "trip-info-card" to padStyleMapOf(utsMapOf("backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "paddingTop" to "20rpx", "paddingRight" to "30rpx", "paddingBottom" to "20rpx", "paddingLeft" to "30rpx")), "trip-header" to utsMapOf(".trip-info-card " to utsMapOf("borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#DDDDDD", "paddingBottom" to "15rpx")), "trip-no" to utsMapOf(".trip-info-card .trip-header " to utsMapOf("fontWeight" to "bold", "fontSize" to "30rpx")), "trip-body" to utsMapOf(".trip-info-card " to utsMapOf("paddingTop" to "15rpx")), "info-row" to utsMapOf(".trip-info-card .trip-body " to utsMapOf("paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "fontSize" to "32rpx", "color" to "#000000", "flexDirection" to "row", "alignItems" to "center")), "label" to utsMapOf(".trip-info-card .trip-body .info-row " to utsMapOf("fontSize" to "30rpx", "color" to "#777676", "fontWeight" to "bold"), ".car-info-item .right-box .info-item " to utsMapOf("color" to "#777676", "fontSize" to 14), ".tag-card-list .tag-card-item .tag-picker " to utsMapOf("fontSize" to "32rpx", "paddingBottom" to "15rpx"), ".tag-card-list .tag-card-item .price-input " to utsMapOf("fontSize" to "32rpx", "paddingBottom" to "15rpx")), "car-info-item" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "flex-start")), "status-icon" to utsMapOf(".car-info-item .left-box " to utsMapOf("width" to 70, "height" to 50, "position" to "absolute", "right" to 0, "bottom" to 0)), "title" to utsMapOf(".car-info-item .right-box " to utsMapOf("paddingBottom" to 4, "flexDirection" to "row", "alignItems" to "center")), "car-no" to utsMapOf(".car-info-item .right-box .title " to utsMapOf("fontWeight" to "bold", "fontSize" to 20, "color" to "#000000", "flexDirection" to "row", "alignItems" to "center")), "tag" to utsMapOf(".car-info-item .right-box .title " to utsMapOf("paddingTop" to 1, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#C78300", "borderRightColor" to "#C78300", "borderBottomColor" to "#C78300", "borderLeftColor" to "#C78300", "fontWeight" to "bold", "fontSize" to 14, "color" to "#C78300")), "info-item" to utsMapOf(".car-info-item .right-box " to utsMapOf("flexDirection" to "row", "paddingTop" to 4, "paddingRight" to 0, "paddingBottom" to 4, "paddingLeft" to 0, "boxSizing" to "border-box")), "btn-group" to utsMapOf(".car-info-item .right-box " to utsMapOf("paddingTop" to 5, "paddingBottom" to 3, "paddingRight" to 5, "boxSizing" to "border-box", "flexDirection" to "row", "justifyContent" to "flex-end")), "btn-group-panel" to padStyleMapOf(utsMapOf("position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "tag_card-header" to padStyleMapOf(utsMapOf("paddingBottom" to "20rpx")), "tag-card-item" to utsMapOf(".tag-card-list " to utsMapOf("backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "marginBottom" to "30rpx")), "del-btn" to utsMapOf(".tag-card-list .tag-card-item " to utsMapOf("paddingTop" to 0, "paddingRight" to "18rpx", "paddingBottom" to 0, "paddingLeft" to "18rpx", "alignContent" to "center")), "tag-picker" to utsMapOf(".tag-card-list .tag-card-item " to utsMapOf("flex" to 1, "paddingTop" to "25rpx", "paddingRight" to "25rpx", "paddingBottom" to "25rpx", "paddingLeft" to "25rpx")), "number-input" to utsMapOf(".tag-card-list .tag-card-item .tag-picker " to utsMapOf("borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#90A2C7", "borderRightColor" to "#90A2C7", "borderBottomColor" to "#90A2C7", "borderLeftColor" to "#90A2C7", "textAlign" to "center", "paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "color" to "#4D669A", "fontWeight" to "bold"), ".tag-card-list .tag-card-item .price-input " to utsMapOf("borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#90A2C7", "borderRightColor" to "#90A2C7", "borderBottomColor" to "#90A2C7", "borderLeftColor" to "#90A2C7", "textAlign" to "center", "paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "color" to "#4D669A", "fontWeight" to "bold")), "picker-picker" to utsMapOf(".tag-card-list .tag-card-item .tag-picker " to utsMapOf("height" to "74rpx", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#90A2C7", "borderRightColor" to "#90A2C7", "borderBottomColor" to "#90A2C7", "borderLeftColor" to "#90A2C7")), "price-input" to utsMapOf(".tag-card-list .tag-card-item " to utsMapOf("flex" to 1, "paddingTop" to "25rpx", "paddingRight" to "25rpx", "paddingBottom" to "25rpx", "paddingLeft" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
