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
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenComponentsMcSeatSelectIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var showPrice: Boolean by `$props`
    open var modelValue: Map<String, ChooseSeat> by `$props`
    open var readonly: Boolean by `$props`
    open var max: Number by `$props`
    open var carInfo: CarInfo by `$props`
    open var seatTemplates: UTSArray<SeatSelectTemplate> by `$props`
    open var processSeat: () -> Unit
        get() {
            return unref(this.`$exposed`["processSeat"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "processSeat", value)
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
            val seatList = ref(utsArrayOf<UTSArray<SeatSelectTemplate>>())
            val processSeat = fun(){
                selfSelectedMap.value = props.modelValue as Map<String, ChooseSeat>
                fjsSeat.value = props.seatTemplates[0] as SeatSelectTemplate
                var maxRow: Number = 0
                val finalSeatList: UTSArray<UTSArray<SeatSelectTemplate>> = utsArrayOf()
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
                        finalSeatList.push(utsArrayOf<SeatSelectTemplate>())
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
            __expose(utsMapOf("processSeat" to processSeat))
            return fun(): Any? {
                return createElementVNode("view", utsMapOf("class" to "seat-select-box"), utsArrayOf(
                    createElementVNode("image", utsMapOf("class" to "seat-select-bg", "src" to ("" + unref(resBaseUrl) + "/static/images/seat-select-bg-" + (if (unref(carRow) <= 2) {
                        2
                    } else {
                        unref(carRow)
                    }
                    ) + "-row.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                        "src"
                    )),
                    if (isTrue(!_ctx.readonly)) {
                        createElementVNode("view", utsMapOf("key" to 0, "class" to "car-info", "style" to normalizeStyle("padding-bottom:" + (if (unref(carRow) <= 2) {
                            "80rpx"
                        } else {
                            "160rpx"
                        }))), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "car-no"), toDisplayString(_ctx.carInfo.plateNumber), 1),
                            createElementVNode("text", utsMapOf("class" to "car-color-brand"), toDisplayString(_ctx.carInfo.carColor), 1),
                            createElementVNode("text", utsMapOf("class" to "car-color-brand"), toDisplayString(_ctx.carInfo.carBrand), 1)
                        ), 4)
                    } else {
                        createElementVNode("view", utsMapOf("key" to 1, "style" to normalizeStyle("height: " + (if (unref(carRow) <= 2) {
                            370
                        } else {
                            440
                        }
                        ) + "rpx")), null, 4)
                    }
                    ,
                    createElementVNode("view", utsMapOf("class" to "seat-row", "style" to normalizeStyle(utsMapOf("padding-bottom" to "80rpx"))), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "seat-item"), utsArrayOf(
                            if (isTrue(!_ctx.readonly)) {
                                createElementVNode("view", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("height" to "30rpx"))), null, 4)
                            } else {
                                createCommentVNode("v-if", true)
                            }
                            ,
                            createElementVNode("image", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "81rpx", "height" to "89rpx")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-driver-filled-small.png"), "mode" to "widthFix"), null, 12, utsArrayOf(
                                "src"
                            )),
                            createElementVNode("view", utsMapOf("class" to "desc-box"), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "desc"), "司机")
                            ))
                        )),
                        createElementVNode("view", utsMapOf("class" to "seat-item"), utsArrayOf(
                            createElementVNode("view", utsMapOf("style" to normalizeStyle("opacity: " + (if (checkShowPrice()) {
                                1
                            } else {
                                0
                            }
                            ) + ";"), "class" to "amplitude-price"), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to normalizeClass(utsMapOf("plus" to (UTSNumber.from(unref(fjsSeat).amplitudePrice) > 0)))), toDisplayString(if (unref(fjsSeat).amplitudePrice != "0") {
                                    "+" + unref(fjsSeat).amplitudePrice
                                } else {
                                    unref(fjsSeat).amplitudePrice
                                }
                                ) + "元", 3)
                            ), 4),
                            if (isTrue(unref(selfSelectedMap).get(unref(fjsSeat).seatKey ?: ""))) {
                                createElementVNode("image", utsMapOf("key" to 0, "onClick" to fun(){
                                    selectEvt(unref(fjsSeat))
                                }, "class" to "selected", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-selected-filled-small.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                    "onClick",
                                    "src"
                                ))
                            } else {
                                if (isTrue(unref(fjsSeat).selected)) {
                                    createElementVNode("image", utsMapOf("key" to 1, "onClick" to fun(){
                                        selectEvt(unref(fjsSeat))
                                    }, "class" to "selected", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-sales-filled-small.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                        "onClick",
                                        "src"
                                    ))
                                } else {
                                    createElementVNode("image", utsMapOf("key" to 2, "onClick" to fun(){
                                        selectEvt(unref(fjsSeat))
                                    }
                                    , "class" to "empty", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-empty-filled-small.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                        "onClick",
                                        "src"
                                    ))
                                }
                            }
                            ,
                            createElementVNode("view", utsMapOf("class" to "desc-box"), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "desc"), toDisplayString(unref(fjsSeat).displayName + "(" + unref(fjsSeat).seatKey + ")"), 1)
                            ))
                        ))
                    ), 4),
                    createElementVNode(Fragment, null, RenderHelpers.renderList(unref(seatList).slice(1), fun(seatArr, index, __index, _cached): Any {
                        return createElementVNode("view", utsMapOf("class" to "seat-row", "key" to index), utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(seatArr, fun(seat, idx, __index, _cached): Any {
                                return createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1")), "key" to seat.seatKey), utsArrayOf(
                                    if (isTrue(seat.isShow)) {
                                        createElementVNode("view", utsMapOf("key" to 0, "class" to "seat-item", "style" to normalizeStyle("" + (if (idx == 1) {
                                            "padding-left: 15rpx;padding-right: 15rpx;"
                                        } else {
                                            ""
                                        }))), utsArrayOf(
                                            if (isTrue(!_ctx.readonly || _ctx.showPrice)) {
                                                createElementVNode("view", utsMapOf("key" to 0, "class" to "amplitude-price"), utsArrayOf(
                                                    if (isTrue(checkShowPrice())) {
                                                        createElementVNode("text", utsMapOf("key" to 0, "class" to normalizeClass(utsMapOf("plus" to (UTSNumber.from(seat.amplitudePrice) > 0)))), toDisplayString(if (seat.amplitudePrice != "0") {
                                                            "+" + seat.amplitudePrice
                                                        } else {
                                                            seat.amplitudePrice
                                                        }) + "元", 3)
                                                    } else {
                                                        createCommentVNode("v-if", true)
                                                    }
                                                ))
                                            } else {
                                                createCommentVNode("v-if", true)
                                            },
                                            if (unref(selfSelectedMap).get(seat.seatKey) != null) {
                                                createElementVNode("image", utsMapOf("key" to 1, "onClick" to fun(){
                                                    selectEvt(seat)
                                                }, "class" to "selected", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-selected-filled-small.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "onClick",
                                                    "src"
                                                ))
                                            } else {
                                                if (isTrue(seat.selected)) {
                                                    createElementVNode("image", utsMapOf("key" to 2, "onClick" to fun(){
                                                        selectEvt(seat)
                                                    }, "class" to "selected", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-sales-filled-small.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "onClick",
                                                        "src"
                                                    ))
                                                } else {
                                                    createElementVNode("image", utsMapOf("key" to 3, "onClick" to fun(){
                                                        selectEvt(seat)
                                                    }, "class" to "empty", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-seat-empty-filled-small.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "onClick",
                                                        "src"
                                                    ))
                                                }
                                            },
                                            createElementVNode("view", utsMapOf("class" to "desc-box"), utsArrayOf(
                                                createElementVNode("text", utsMapOf("class" to "desc"), toDisplayString(seat.displayName + "(" + seat.seatKey + ")"), 1)
                                            ))
                                        ), 4)
                                    } else {
                                        createElementVNode("view", utsMapOf("key" to 1, "class" to "seat-item"))
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
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("car-info" to padStyleMapOf(utsMapOf("paddingTop" to "22%", "paddingRight" to 0, "paddingBottom" to "22%", "paddingLeft" to 0, "display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center")), "car-no" to utsMapOf(".car-info " to utsMapOf("fontWeight" to "400", "fontSize" to "52rpx", "color" to "#000000", "paddingBottom" to "15rpx")), "car-color-brand" to utsMapOf(".car-info " to utsMapOf("fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "seat-select-box" to padStyleMapOf(utsMapOf("position" to "relative", "zIndex" to 22, "paddingTop" to 0, "paddingRight" to "80rpx", "paddingBottom" to "400rpx", "paddingLeft" to "80rpx", "marginTop" to 0, "marginRight" to "30rpx", "marginBottom" to 0, "marginLeft" to "30rpx")), "seat-row" to utsMapOf(".seat-select-box " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "flex-end", "justifyContent" to "center", "paddingBottom" to "80rpx")), "seat-item" to utsMapOf(".seat-select-box .seat-row " to utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "flex" to 1, "width" to "100%", "minHeight" to "100rpx")), "desc" to utsMapOf(".seat-select-box .seat-row .seat-item " to utsMapOf("fontWeight" to "bold", "fontSize" to "28rpx", "color" to "#000000", "paddingTop" to "10rpx")), "amplitude-price" to utsMapOf(".seat-select-box .seat-row .seat-item " to utsMapOf("height" to "45rpx", "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#00bb32", "paddingBottom" to "5rpx")), "plus" to utsMapOf(".seat-select-box .seat-row .seat-item .amplitude-price " to utsMapOf("color" to "#ff3931")), "selected" to utsMapOf(".seat-select-box .seat-row .seat-item " to utsMapOf("width" to "98rpx", "height" to "90rpx")), "empty" to utsMapOf(".seat-select-box .seat-row .seat-item " to utsMapOf("width" to "98rpx", "height" to "90rpx")), "desc-box" to utsMapOf(".seat-select-box .seat-row .seat-item " to utsMapOf("display" to "flex", "fontSize" to "32rpx", "flexDirection" to "column", "alignItems" to "center")), "seat-select-bg" to utsMapOf(".seat-select-box " to utsMapOf("width" to "100%", "position" to "absolute", "top" to 0, "left" to 0, "right" to 0, "zIndex" to -1)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("update:modelValue" to null, "seatSelect" to null, "seatCancel" to null)
        var props = normalizePropsOptions(utsMapOf("showPrice" to utsMapOf("type" to "Boolean", "default" to false), "modelValue" to utsMapOf("type" to "Object", "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        , "required" to true), "readonly" to utsMapOf("type" to "Boolean", "default" to false), "max" to utsMapOf("type" to "Number", "default" to 8), "carInfo" to utsMapOf("type" to "Object", "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "seatTemplates" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<SeatSelectTemplate> {
            return utsArrayOf<SeatSelectTemplate>()
        }
        )))
        var propsNeedCastKeys = utsArrayOf(
            "showPrice",
            "modelValue",
            "readonly",
            "max",
            "carInfo",
            "seatTemplates"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
