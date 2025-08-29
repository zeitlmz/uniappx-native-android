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
open class GenComponentsMcSeatSelectIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var showPrice: Boolean by `$props`
    open var modelValue: Map<String, ChooseSeat> by `$props`
    open var readonly: Boolean by `$props`
    open var max: Number by `$props`
    open var carInfo: CarInfo by `$props`
    open var seatTemplates: UTSArray<SeatSelectTemplate> by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var processSeat: () -> Unit
        get() {
            return unref(this.`$exposed`["processSeat"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "processSeat", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsMcSeatSelectIndex, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsMcSeatSelectIndex
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val carRow = ref(0)
            val selfSelectedMap = ref<Map<String, ChooseSeat>>(props.modelValue as Map<String, ChooseSeat>)
            val fjsSeat = ref<SeatSelectTemplate>(SeatSelectTemplate(seatKey = "", displayName = "", rowsNumber = 0, columnNumber = 0, isShow = false, amplitudePrice = "0", selected = false))
            val otherSelectedMap: Map<String, Boolean> = Map()
            val seatList = ref(_uA<UTSArray<SeatSelectTemplate>>())
            val processSeat = fun(){
                selfSelectedMap.value = props.modelValue as Map<String, ChooseSeat>
                fjsSeat.value = props.seatTemplates[0] as SeatSelectTemplate
                var maxRow: Number = 0
                val finalSeatList: UTSArray<UTSArray<SeatSelectTemplate>> = _uA()
                props.seatTemplates.forEach(fun(seat: SeatSelectTemplate, _idx: Number, _arr: UTSArray<SeatSelectTemplate>){
                    if (seat.isShow && maxRow < seat.rowsNumber) {
                        maxRow = seat.rowsNumber
                    }
                    if (seat.selected) {
                        otherSelectedMap.set(seat.seatKey, seat.selected)
                    }
                    var curRow: Number = -1
                    if (curRow != seat.rowsNumber) {
                        curRow = seat.rowsNumber
                        finalSeatList.push(_uA<SeatSelectTemplate>())
                    }
                    finalSeatList[seat.rowsNumber].push(seat)
                }
                )
                carRow.value = maxRow + 1
                console.log("carRow.value::===", carRow.value)
                seatList.value = finalSeatList.filter(fun(item: UTSArray<SeatSelectTemplate>, _idx: Number, _arr: UTSArray<UTSArray<SeatSelectTemplate>>): Boolean {
                    return item.length > 0
                }
                )
            }
            val selectEvt = fun(seat: SeatSelectTemplate){
                if (props.readonly) {
                    return
                }
                if (seat.isForbidSelect) {
                    uni_showToast(ShowToastOptions(title = "该座位暂未开放", icon = "none"))
                    return
                }
                if (otherSelectedMap.get(seat.seatKey) != null) {
                    uni_showToast(ShowToastOptions(title = "无法选择他人座位", icon = "none"))
                    return
                }
                if (!seat.selected && selfSelectedMap.value.size >= props.max) {
                    return uni_showToast(ShowToastOptions(title = "座位选择数量已上限，请先取消选中", icon = "none"))
                }
                seat.selected = !seat.selected
                if (seat.selected) {
                    selfSelectedMap.value.set(seat.seatKey, ChooseSeat(seatKey = seat.seatKey, displayName = seat.displayName, amplitudePrice = seat.amplitudePrice))
                    emit("seatSelect", seat)
                } else {
                    selfSelectedMap.value.`delete`(seat.seatKey)
                    emit("seatCancel", seat)
                }
                emit("update:modelValue", selfSelectedMap.value)
            }
            val checkShowPrice = fun(): Boolean {
                if (props.showPrice) {
                    return true
                }
                return otherSelectedMap.get(fjsSeat.value.seatKey ?: "") == null && !props.readonly && fjsSeat.value.amplitudePrice != "0"
            }
            onMounted(fun(){
                processSeat()
            }
            )
            __expose(_uM("processSeat" to processSeat))
            return fun(): Any? {
                return _cE("view", _uM("class" to "seat-select-box"), _uA(
                    _cE("image", _uM("class" to "seat-select-bg", "src" to ("" + unref(resBaseUrl) + "/static/images/seat-select-bg-" + (if (unref(carRow) <= 2) {
                        2
                    } else {
                        unref(carRow)
                    }
                    ) + "-row.png"), "mode" to "widthFix"), null, 8, _uA(
                        "src"
                    )),
                    if (isTrue(!_ctx.readonly)) {
                        _cE("view", _uM("key" to 0, "class" to "car-info", "style" to _nS("padding-bottom:" + (if (unref(carRow) <= 2) {
                            "80rpx"
                        } else {
                            "160rpx"
                        }))), _uA(
                            _cE("text", _uM("class" to "car-no"), _tD(_ctx.carInfo.plateNumber), 1),
                            _cE("text", _uM("class" to "car-color-brand"), _tD(_ctx.carInfo.carColor), 1),
                            _cE("text", _uM("class" to "car-color-brand"), _tD(_ctx.carInfo.carBrand), 1)
                        ), 4)
                    } else {
                        _cE("view", _uM("key" to 1, "style" to _nS("height: " + (if (unref(carRow) <= 2) {
                            370
                        } else {
                            440
                        }
                        ) + "rpx")), null, 4)
                    }
                    ,
                    _cE("view", _uM("class" to "seat-row", "style" to _nS(_uM("padding-bottom" to "80rpx"))), _uA(
                        _cE("view", _uM("class" to "seat-item"), _uA(
                            if (isTrue(!_ctx.readonly)) {
                                _cE("view", _uM("key" to 0, "style" to _nS(_uM("height" to "30rpx"))), null, 4)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cE("image", _uM("style" to _nS(_uM("width" to "81rpx", "height" to "89rpx")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-driver-filled-small.png"), "mode" to "widthFix"), null, 12, _uA(
                                "src"
                            )),
                            _cE("view", _uM("class" to "desc-box"), _uA(
                                _cE("text", _uM("class" to "desc"), "司机")
                            ))
                        )),
                        _cE("view", _uM("class" to "seat-item"), _uA(
                            _cE("view", _uM("style" to _nS("opacity: " + (if (checkShowPrice()) {
                                1
                            } else {
                                0
                            }
                            ) + ";"), "class" to "amplitude-price"), _uA(
                                _cE("text", _uM("class" to _nC(_uM("plus" to (UTSNumber.from(unref(fjsSeat).amplitudePrice) > 0)))), _tD(if (unref(fjsSeat).amplitudePrice != "0") {
                                    "+" + unref(fjsSeat).amplitudePrice
                                } else {
                                    unref(fjsSeat).amplitudePrice
                                }
                                ) + "元", 3)
                            ), 4),
                            if (isTrue(unref(fjsSeat).isForbidSelect)) {
                                _cE("image", _uM("key" to 0, "onClick" to fun(){
                                    selectEvt(unref(fjsSeat))
                                }, "class" to "selected", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-forbid-select-filled-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                    "onClick",
                                    "src"
                                ))
                            } else {
                                if (isTrue(unref(selfSelectedMap).get(unref(fjsSeat).seatKey ?: ""))) {
                                    _cE("image", _uM("key" to 1, "onClick" to fun(){
                                        selectEvt(unref(fjsSeat))
                                    }, "class" to "selected", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-selected-filled-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                        "onClick",
                                        "src"
                                    ))
                                } else {
                                    if (isTrue(unref(fjsSeat).selected)) {
                                        _cE("image", _uM("key" to 2, "onClick" to fun(){
                                            selectEvt(unref(fjsSeat))
                                        }, "class" to "selected", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-sales-filled-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                            "onClick",
                                            "src"
                                        ))
                                    } else {
                                        _cE("image", _uM("key" to 3, "onClick" to fun(){
                                            selectEvt(unref(fjsSeat))
                                        }
                                        , "class" to "empty", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-empty-filled-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                            "onClick",
                                            "src"
                                        ))
                                    }
                                }
                            }
                            ,
                            _cE("view", _uM("class" to "desc-box"), _uA(
                                _cE("text", _uM("class" to "desc"), _tD(unref(fjsSeat).displayName + "(" + unref(fjsSeat).seatKey + ")"), 1)
                            ))
                        ))
                    ), 4),
                    _cE(Fragment, null, RenderHelpers.renderList(unref(seatList).slice(1), fun(seatArr, index, __index, _cached): Any {
                        return _cE("view", _uM("class" to "seat-row", "key" to index), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(seatArr, fun(seat, idx, __index, _cached): Any {
                                return _cE("view", _uM("style" to _nS(_uM("flex" to "1")), "key" to seat.seatKey), _uA(
                                    if (isTrue(seat.isShow)) {
                                        _cE("view", _uM("key" to 0, "class" to "seat-item", "style" to _nS("" + (if (idx == 1) {
                                            "padding-left: 15rpx;padding-right: 15rpx;"
                                        } else {
                                            ""
                                        }))), _uA(
                                            if (isTrue(!_ctx.readonly || _ctx.showPrice)) {
                                                _cE("view", _uM("key" to 0, "class" to "amplitude-price"), _uA(
                                                    if (isTrue(checkShowPrice())) {
                                                        _cE("text", _uM("key" to 0, "class" to _nC(_uM("plus" to (UTSNumber.from(seat.amplitudePrice) > 0)))), _tD(if (seat.amplitudePrice != "0") {
                                                            "+" + seat.amplitudePrice
                                                        } else {
                                                            seat.amplitudePrice
                                                        }) + "元", 3)
                                                    } else {
                                                        _cC("v-if", true)
                                                    }
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            },
                                            if (isTrue(seat.isForbidSelect)) {
                                                _cE("image", _uM("key" to 1, "onClick" to fun(){
                                                    selectEvt(unref(fjsSeat))
                                                }, "class" to "selected", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-forbid-select-filled-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "onClick",
                                                    "src"
                                                ))
                                            } else {
                                                if (unref(selfSelectedMap).get(seat.seatKey) != null) {
                                                    _cE("image", _uM("key" to 2, "onClick" to fun(){
                                                        selectEvt(seat)
                                                    }, "class" to "selected", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-selected-filled-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                                        "onClick",
                                                        "src"
                                                    ))
                                                } else {
                                                    if (isTrue(seat.selected)) {
                                                        _cE("image", _uM("key" to 3, "onClick" to fun(){
                                                            selectEvt(seat)
                                                        }, "class" to "selected", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-sales-filled-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                                            "onClick",
                                                            "src"
                                                        ))
                                                    } else {
                                                        _cE("image", _uM("key" to 4, "onClick" to fun(){
                                                            selectEvt(seat)
                                                        }, "class" to "empty", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-empty-filled-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                                            "onClick",
                                                            "src"
                                                        ))
                                                    }
                                                }
                                            },
                                            _cE("view", _uM("class" to "desc-box"), _uA(
                                                _cE("text", _uM("class" to "desc"), _tD(seat.displayName + "(" + seat.seatKey + ")"), 1)
                                            ))
                                        ), 4)
                                    } else {
                                        _cE("view", _uM("key" to 1, "class" to "seat-item"))
                                    }
                                ), 4)
                            }
                            ), 128)
                        ))
                    }
                    ), 128)
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("car-info" to _pS(_uM("paddingTop" to "22%", "paddingRight" to 0, "paddingBottom" to "22%", "paddingLeft" to 0, "display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center")), "car-no" to _uM(".car-info " to _uM("fontWeight" to "400", "fontSize" to "52rpx", "color" to "#000000", "paddingBottom" to "15rpx")), "car-color-brand" to _uM(".car-info " to _uM("fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "seat-select-box" to _pS(_uM("position" to "relative", "zIndex" to 22, "paddingTop" to 0, "paddingRight" to "80rpx", "paddingBottom" to "400rpx", "paddingLeft" to "80rpx", "marginTop" to 0, "marginRight" to "30rpx", "marginBottom" to 0, "marginLeft" to "30rpx")), "seat-row" to _uM(".seat-select-box " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "flex-end", "justifyContent" to "center", "paddingBottom" to "80rpx")), "seat-item" to _uM(".seat-select-box .seat-row " to _uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "flex" to 1, "width" to "100%", "minHeight" to "100rpx")), "desc" to _uM(".seat-select-box .seat-row .seat-item " to _uM("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000", "paddingTop" to "10rpx")), "amplitude-price" to _uM(".seat-select-box .seat-row .seat-item " to _uM("height" to "45rpx", "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#00bb32", "paddingBottom" to "5rpx")), "plus" to _uM(".seat-select-box .seat-row .seat-item .amplitude-price " to _uM("color" to "#ff3931")), "selected" to _uM(".seat-select-box .seat-row .seat-item " to _uM("width" to "98rpx", "height" to "90rpx")), "empty" to _uM(".seat-select-box .seat-row .seat-item " to _uM("width" to "98rpx", "height" to "90rpx")), "desc-box" to _uM(".seat-select-box .seat-row .seat-item " to _uM("display" to "flex", "fontSize" to "32rpx", "flexDirection" to "column", "alignItems" to "center")), "seat-select-bg" to _uM(".seat-select-box " to _uM("width" to "100%", "position" to "absolute", "top" to 0, "left" to 0, "right" to 0, "zIndex" to -1)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "seatSelect" to null, "seatCancel" to null)
        var props = _nP(_uM("showPrice" to _uM("type" to "Boolean", "default" to false), "modelValue" to _uM("type" to "Object", "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        , "required" to true), "readonly" to _uM("type" to "Boolean", "default" to false), "max" to _uM("type" to "Number", "default" to 8), "carInfo" to _uM("type" to "Object", "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "seatTemplates" to _uM("type" to "Array", "default" to fun(): UTSArray<SeatSelectTemplate> {
            return _uA<SeatSelectTemplate>()
        }
        )))
        var propsNeedCastKeys = _uA(
            "showPrice",
            "modelValue",
            "readonly",
            "max",
            "carInfo",
            "seatTemplates"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
