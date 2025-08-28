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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
open class GenPagesOtherTripPlanDetailIndex : BasePage {
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
        var setup: (__props: GenPagesOtherTripPlanDetailIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherTripPlanDetailIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val planGoTime = ref("")
            val planGoTimeStr = ref("")
            val startDate = ref("")
            val endDate = ref("")
            val bindCar = ref("")
            val bindLinesGrp = ref("")
            val bindDistrictLines = ref(_uA<DriverBindDistrictLines2>())
            val tagList = ref(_uA<TripPlanTagInfo>())
            val seatTemplates = ref(_uA<SeatSelectTemplate>())
            val seatSelectData = ref<Map<String, ChooseSeat>>(Map())
            val seatSelect = ref<McSeatSelectComponentPublicInstance?>(null)
            val selectDate = ref("")
            val showLines = ref(false)
            val show = fun(planId: String, date: String){
                searchDriverPlanByPlanId(planId).then(fun(res: Response){
                    if (res.code == 200) {
                        val planData = JSON.parse<UTSJSONObject>(JSON.stringify(res.data)) ?: UTSJSONObject()
                        console.log("searchDriverPlanByPlanId=", planData)
                        startDate.value = planData.getString("startDate") ?: ""
                        endDate.value = planData.getString("endDate") ?: ""
                        planGoTime.value = planData.getString("startTime") ?: ""
                        bindCar.value = planData.getJSON("driveInfo")?.getString("vehiclePlateNo") ?: ""
                        bindLinesGrp.value = planData.getString("linesGroupName") ?: ""
                        val carLinesListStr = JSON.stringify(planData.getArray("carLinesList"))
                        if (carLinesListStr != null && carLinesListStr != "") {
                            bindDistrictLines.value = JSON.parseArray<DriverBindDistrictLines2>(carLinesListStr)!!
                        }
                        tagList.value = JSON.parse<UTSArray<TripPlanTagInfo>>(JSON.stringify(planData.getArray("tagInfoList"))) ?: _uA()
                        refreshSeatTemplate("DRIVER_PLAN:ORDER_SEAT_METADATA:" + planId + ":" + date).then(fun(res: Response){
                            if (res.code == 200) {
                                seatTemplates.value = JSON.parse<UTSArray<SeatSelectTemplate>>(JSON.stringify(res.data)) ?: _uA()
                                seatTemplates.value.forEach(fun(item){
                                    item.selected = false
                                }
                                )
                                console.log("seatTemplates.value===", seatTemplates.value)
                                setTimeout(fun(){
                                    seatSelect.value?.processSeat?.invoke()
                                }
                                , 1000)
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
                return _cV(_component_mc_base_container, _uM("title" to "行程详情"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_x_sheet, _uM("padding" to _uA(
                            "30rpx",
                            "26rpx"
                        ), "margin" to _uA(
                            "15",
                            "15",
                            "15",
                            "15"
                        )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_mc_date_picker, _uM("modelValue" to selectDate.value, "onUpdate:modelValue" to fun(`$event`: String){
                                    selectDate.value = `$event`
                                }
                                ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", _uM("class" to "form-item"), _uA(
                                            _cE("text", _uM("class" to "left-box"), "出行日期"),
                                            _cE("view", _uM("class" to "right-box"), _uA(
                                                _cE("text", _uM("class" to "value"), _tD(selectDate.value), 1)
                                            ))
                                        ))
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "modelValue",
                                    "onUpdate:modelValue"
                                ))
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_x_sheet, _uM("padding" to _uA(
                            "30rpx",
                            "26rpx"
                        ), "margin" to _uA(
                            "15",
                            "0",
                            "15",
                            "15"
                        )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_x_picker_time, _uM("type" to "minute", "modelValue" to planGoTime.value, "onUpdate:modelValue" to fun(`$event`: String){
                                    planGoTime.value = `$event`
                                }
                                , "model-str" to planGoTimeStr.value, "onUpdate:modelStr" to fun(`$event`: String){
                                    planGoTimeStr.value = `$event`
                                }
                                , "format" to "hh:mm"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", _uM("class" to "form-item"), _uA(
                                            _cE("text", _uM("class" to "left-box"), "发车时间"),
                                            _cE("view", _uM("class" to "right-box"), _uA(
                                                _cE("text", _uM("class" to "value"), _tD(planGoTimeStr.value), 1)
                                            ))
                                        ))
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "modelValue",
                                    "onUpdate:modelValue",
                                    "model-str",
                                    "onUpdate:modelStr"
                                ))
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_x_sheet, _uM("padding" to _uA(
                            "30rpx",
                            "26rpx"
                        ), "margin" to _uA(
                            "15",
                            "0",
                            "15",
                            "15"
                        )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "form-item"), _uA(
                                    _cE("text", _uM("class" to "left-box"), "关联车辆"),
                                    _cE("view", _uM("class" to "right-box"), _uA(
                                        _cE("text", _uM("class" to "value"), _tD(bindCar.value), 1)
                                    ))
                                ))
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_x_sheet, _uM("padding" to _uA(
                            "30rpx",
                            "26rpx"
                        ), "margin" to _uA(
                            "15",
                            "0",
                            "15",
                            "15"
                        )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "form-item", "onClick" to fun(){
                                    showLines.value = !showLines.value
                                }
                                ), _uA(
                                    _cE("text", _uM("class" to "left-box"), "关联线路"),
                                    _cE("view", _uM("class" to "right-box"), _uA(
                                        _cE("text", _uM("class" to "value"), _tD(bindLinesGrp.value), 1),
                                        if (isTrue(!showLines.value)) {
                                            _cE("image", _uM("key" to 0, "class" to "icon", "style" to _nS(_uM("width" to "20rpx", "height" to "25rpx")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-filled-samll.png"), "mode" to "widthFix"), null, 12, _uA(
                                                "src"
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                        ,
                                        if (isTrue(showLines.value)) {
                                            _cE("image", _uM("key" to 1, "class" to "icon", "style" to _nS(_uM("width" to "20rpx", "height" to "25rpx", "transform" to "rotate(180deg)")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-filled-samll.png"), "mode" to "widthFix"), null, 12, _uA(
                                                "src"
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    ))
                                ), 8, _uA(
                                    "onClick"
                                )),
                                if (isTrue(showLines.value)) {
                                    _cE("view", _uM("key" to 0, "style" to _nS(_uM("margin-top" to "10rpx"))), _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(bindDistrictLines.value, fun(item2, index2, __index, _cached): Any {
                                            return _cV(_component_x_sheet, _uM("class" to "flex-row flex-row-center-between", "style" to _nS(_uM("margin-bottom" to "5rpx")), "margin" to _uA(
                                                "0",
                                                "0",
                                                "0",
                                                "10"
                                            ), "color" to unref(globalData).theme.painColor, "height" to "30rpx"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "left-box flex-row flex-row-center-between"), _uA(
                                                        _cE("image", _uM("class" to "icon", "style" to _nS(_uM("width" to "28rpx", "height" to "30rpx")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location-filled.png"), "mode" to "widthFix"), null, 12, _uA(
                                                            "src"
                                                        )),
                                                        _cE("text", _uM("class" to "text ml-5", "style" to _nS(_uM("color" to "#949494", "font-size" to "30rpx"))), _tD(item2.startDistrictName) + "-" + _tD(item2.endDistrictName), 5)
                                                    ))
                                                )
                                            }), "_" to 2), 1032, _uA(
                                                "style",
                                                "color"
                                            ))
                                        }), 256)
                                    ), 4)
                                } else {
                                    _cC("v-if", true)
                                }
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_x_sheet, _uM("padding" to _uA(
                            "0"
                        ), "color" to "#00000000", "round" to _uA(
                            "0"
                        ), "margin" to _uA(
                            "15",
                            "0",
                            "15",
                            "15"
                        )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "tag_card-header flex-row flex-row-center-between"), _uA(
                                    _cE("view", _uM("class" to "card-title flex-row flex-row-center-between"), _uA(
                                        _cE("view", _uM("class" to "title-border", "style" to _nS("background-color: " + unref(globalData).theme.primaryColor + ";")), null, 4),
                                        _cE("text", _uM("class" to "text"), "配置标签")
                                    ))
                                )),
                                _cE("view", _uM("class" to "tag-card-list"), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(tagList.value, fun(item, index, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "tag-card-item flex-row"), _uA(
                                            _cE("view", _uM("class" to "tag-picker"), _uA(
                                                _cE("text", _uM("class" to "label"), "标签名称："),
                                                _cE("text", _uM("class" to "number-input", "style" to _nS(_uM("background" to "#F5F9FF"))), _tD((item.tagName as String)), 5)
                                            )),
                                            _cE("view", _uM("class" to "price-input"), _uA(
                                                _cE("text", _uM("class" to "label"), "浮动金额："),
                                                _cE("text", _uM("class" to "number-input"), _tD((item.changeAmount as String)), 1)
                                            ))
                                        ))
                                    }
                                    ), 256)
                                ))
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_mc_seat_select, _uM("model-value" to seatSelectData.value, "showPrice" to "", "ref_key" to "seatSelect", "ref" to seatSelect, "readonly" to "", "seat-templates" to seatTemplates.value), null, 8, _uA(
                            "model-value",
                            "seat-templates"
                        ))
                    )
                }
                ), "_" to 1))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("viewer-title" to _pS(_uM("fontSize" to "36rpx", "fontWeight" to "bold", "color" to "#ffffff", "textAlign" to "center")), "confirm-button" to _pS(_uM("height" to "88rpx", "lineHeight" to "88rpx", "textAlign" to "center", "width" to "92%", "backgroundImage" to "linear-gradient(90deg, #ff3232, #fc6832)", "backgroundColor" to "rgba(0,0,0,0)", "borderTopLeftRadius" to "12rpx", "borderTopRightRadius" to "12rpx", "borderBottomRightRadius" to "12rpx", "borderBottomLeftRadius" to "12rpx", "color" to "#ffffff", "fontSize" to "32rpx", "marginTop" to 0, "marginRight" to "30rpx", "marginBottom" to 0, "marginLeft" to "30rpx", "opacity:active" to 0.8)), "drawer-title" to _pS(_uM("textAlign" to "center", "width" to "100%", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "form-item" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "left-box" to _uM(".form-item " to _uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center"), ".car-info-item " to _uM("width" to 115, "height" to 100, "position" to "relative")), "right-box" to _uM(".form-item " to _uM("flexDirection" to "row", "alignItems" to "center")), "text" to _uM(".form-item .right-box " to _uM("fontSize" to "32rpx", "color" to "#949494"), ".form-title " to _uM("paddingLeft" to "20rpx", "fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000"), ".tag_card-header .card-title " to _uM("paddingLeft" to "20rpx", "fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000"), ".tag_card-header .add-btn " to _uM("paddingLeft" to "10rpx", "fontWeight" to "bold", "fontSize" to "32rpx"), ".tag-card-list .tag-card-item .tag-picker .picker-picker " to _uM("fontSize" to "32rpx")), "value" to _uM(".form-item .right-box " to _uM("fontSize" to "32rpx", "color" to "#000000"), ".trip-info-card .trip-body .info-row " to _uM("fontWeight" to "bold", "fontSize" to "30rpx", "color" to "#000000"), ".car-info-item .right-box .info-item " to _uM("color" to "#000000", "fontSize" to 14)), "icon" to _uM(".form-item .right-box " to _uM("width" to 6, "height" to 12, "marginLeft" to "15rpx"), ".trip-info-card .trip-header " to _uM("width" to "30rpx", "height" to "30rpx"), ".tag_card-header .add-btn " to _uM("width" to "34rpx", "height" to "34rpx"), ".tag-card-list .tag-card-item .tag-picker .picker-picker " to _uM("width" to "21rpx", "height" to "11rpx")), "top-box" to _uM(".form-item " to _uM("fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000", "paddingBottom" to "20rpx")), "bottom-box" to _uM(".form-item " to _uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "width" to "100%")), "form-title" to _pS(_uM("paddingBottom" to "20rpx")), "title-border" to _uM(".form-title " to _uM("width" to "8rpx", "height" to "33rpx", "borderTopLeftRadius" to "4rpx", "borderTopRightRadius" to "4rpx", "borderBottomRightRadius" to "4rpx", "borderBottomLeftRadius" to "4rpx"), ".tag_card-header .card-title " to _uM("width" to "8rpx", "height" to "33rpx", "borderTopLeftRadius" to "4rpx", "borderTopRightRadius" to "4rpx", "borderBottomRightRadius" to "4rpx", "borderBottomLeftRadius" to "4rpx")), "trip-info-card" to _pS(_uM("backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "paddingTop" to "20rpx", "paddingRight" to "30rpx", "paddingBottom" to "20rpx", "paddingLeft" to "30rpx")), "trip-header" to _uM(".trip-info-card " to _uM("borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#DDDDDD", "paddingBottom" to "15rpx")), "trip-no" to _uM(".trip-info-card .trip-header " to _uM("fontWeight" to "bold", "fontSize" to "30rpx")), "trip-body" to _uM(".trip-info-card " to _uM("paddingTop" to "15rpx")), "info-row" to _uM(".trip-info-card .trip-body " to _uM("paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "fontSize" to "32rpx", "color" to "#000000", "flexDirection" to "row", "alignItems" to "center")), "label" to _uM(".trip-info-card .trip-body .info-row " to _uM("fontSize" to "30rpx", "color" to "#777676", "fontWeight" to "bold"), ".car-info-item .right-box .info-item " to _uM("color" to "#777676", "fontSize" to 14), ".tag-card-list .tag-card-item .tag-picker " to _uM("fontSize" to "32rpx", "paddingBottom" to "15rpx"), ".tag-card-list .tag-card-item .price-input " to _uM("fontSize" to "32rpx", "paddingBottom" to "15rpx")), "car-info-item" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "flex-start")), "status-icon" to _uM(".car-info-item .left-box " to _uM("width" to 70, "height" to 50, "position" to "absolute", "right" to 0, "bottom" to 0)), "title" to _uM(".car-info-item .right-box " to _uM("paddingBottom" to 4, "flexDirection" to "row", "alignItems" to "center")), "car-no" to _uM(".car-info-item .right-box .title " to _uM("fontWeight" to "bold", "fontSize" to 20, "color" to "#000000", "flexDirection" to "row", "alignItems" to "center")), "tag" to _uM(".car-info-item .right-box .title " to _uM("paddingTop" to 1, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#C78300", "borderRightColor" to "#C78300", "borderBottomColor" to "#C78300", "borderLeftColor" to "#C78300", "fontWeight" to "bold", "fontSize" to 14, "color" to "#C78300")), "info-item" to _uM(".car-info-item .right-box " to _uM("flexDirection" to "row", "paddingTop" to 4, "paddingRight" to 0, "paddingBottom" to 4, "paddingLeft" to 0, "boxSizing" to "border-box")), "btn-group" to _uM(".car-info-item .right-box " to _uM("paddingTop" to 5, "paddingBottom" to 3, "paddingRight" to 5, "boxSizing" to "border-box", "flexDirection" to "row", "justifyContent" to "flex-end")), "btn-group-panel" to _pS(_uM("position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "tag_card-header" to _pS(_uM("paddingBottom" to "20rpx")), "tag-card-item" to _uM(".tag-card-list " to _uM("backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "marginBottom" to "30rpx")), "del-btn" to _uM(".tag-card-list .tag-card-item " to _uM("paddingTop" to 0, "paddingRight" to "18rpx", "paddingBottom" to 0, "paddingLeft" to "18rpx", "alignContent" to "center")), "tag-picker" to _uM(".tag-card-list .tag-card-item " to _uM("flex" to 1, "paddingTop" to "25rpx", "paddingRight" to "25rpx", "paddingBottom" to "25rpx", "paddingLeft" to "25rpx")), "number-input" to _uM(".tag-card-list .tag-card-item .tag-picker " to _uM("borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#90A2C7", "borderRightColor" to "#90A2C7", "borderBottomColor" to "#90A2C7", "borderLeftColor" to "#90A2C7", "textAlign" to "center", "paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "color" to "#4D669A", "fontWeight" to "bold"), ".tag-card-list .tag-card-item .price-input " to _uM("borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#90A2C7", "borderRightColor" to "#90A2C7", "borderBottomColor" to "#90A2C7", "borderLeftColor" to "#90A2C7", "textAlign" to "center", "paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "color" to "#4D669A", "fontWeight" to "bold")), "picker-picker" to _uM(".tag-card-list .tag-card-item .tag-picker " to _uM("height" to "74rpx", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#90A2C7", "borderRightColor" to "#90A2C7", "borderBottomColor" to "#90A2C7", "borderLeftColor" to "#90A2C7")), "price-input" to _uM(".tag-card-list .tag-card-item " to _uM("flex" to 1, "paddingTop" to "25rpx", "paddingRight" to "25rpx", "paddingBottom" to "25rpx", "paddingLeft" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
