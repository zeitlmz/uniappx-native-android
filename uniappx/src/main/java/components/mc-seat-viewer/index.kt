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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
open class GenComponentsMcSeatViewerIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var data: UTSArray<ChooseSeat> by `$props`
    open var seatTemplates: UTSArray<SeatSelectTemplate> by `$props`
    open var show: () -> Unit
        get() {
            return unref(this.`$exposed`["show"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "show", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsMcSeatViewerIndex, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsMcSeatViewerIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val props = __props
            val seatSelectData = ref<Map<String, ChooseSeat>>(Map())
            val seatSelect = ref<McSeatSelectComponentPublicInstance?>(null)
            val showDrawer = ref(false)
            val show = fun(){
                showDrawer.value = true
                val seatMap: Map<String, ChooseSeat> = Map()
                props.data.forEach(fun(item: ChooseSeat, _idx: Number, _arr: UTSArray<ChooseSeat>){
                    seatMap.set(item.seatKey, item)
                }
                )
                seatSelectData.value = seatMap
                setTimeout(fun(){
                    seatSelect.value?.processSeat?.invoke()
                }
                , 100)
            }
            val close = fun(){
                showDrawer.value = false
            }
            __expose(utsMapOf("show" to show))
            return fun(): Any? {
                val _component_mc_seat_select = resolveEasyComponent("mc-seat-select", GenComponentsMcSeatSelectIndexClass)
                val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
                return createVNode(_component_x_modal, utsMapOf("show" to showDrawer.value, "onUpdate:show" to fun(`$event`: Boolean){
                    showDrawer.value = `$event`
                }
                , "height" to "85%", "width" to "100%", "contentPadding" to "0", "bgColor" to "#00000000"), utsMapOf("title" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "viewer-title"), "座位信息图预览")
                    )
                }
                ), "footer" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "confirm-button", "style" to normalizeStyle("background-image: linear-gradient(to right, " + unref(globalData).theme.primaryLinearColors.join(",") + ");"), "onClick" to close), "关闭", 4)
                    )
                }
                ), "default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        if (isTrue(showDrawer.value)) {
                            createVNode(_component_mc_seat_select, utsMapOf("key" to 0, "showPrice" to "", "model-value" to seatSelectData.value, "ref_key" to "seatSelect", "ref" to seatSelect, "readonly" to "", "seat-templates" to _ctx.seatTemplates), null, 8, utsArrayOf(
                                "model-value",
                                "seat-templates"
                            ))
                        } else {
                            createCommentVNode("v-if", true)
                        }
                    )
                }
                ), "_" to 1), 8, utsArrayOf(
                    "show",
                    "onUpdate:show"
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
                return utsMapOf("viewer-title" to padStyleMapOf(utsMapOf("fontSize" to "36rpx", "fontWeight" to "bold", "color" to "#ffffff", "textAlign" to "center")), "confirm-button" to padStyleMapOf(utsMapOf("height" to "88rpx", "lineHeight" to "88rpx", "textAlign" to "center", "width" to "92%", "backgroundImage" to "linear-gradient(90deg, #ff3232, #fc6832)", "backgroundColor" to "rgba(0,0,0,0)", "borderTopLeftRadius" to "12rpx", "borderTopRightRadius" to "12rpx", "borderBottomRightRadius" to "12rpx", "borderBottomLeftRadius" to "12rpx", "color" to "#ffffff", "fontSize" to "32rpx", "marginTop" to 0, "marginRight" to "30rpx", "marginBottom" to 0, "marginLeft" to "30rpx", "opacity:active" to 0.8)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf("data" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<ChooseSeat> {
            return utsArrayOf<ChooseSeat>()
        }
        , "required" to true), "seatTemplates" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<Any?> {
            return utsArrayOf()
        }
        )))
        var propsNeedCastKeys = utsArrayOf(
            "data",
            "seatTemplates"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
