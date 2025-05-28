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
import uts.sdk.modules.xVibrateS.vibrator
open class GenComponentsMcDragVerifyIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var round: Number by `$props`
    open var height: String by `$props`
    open var swiperDiff: Number by `$props`
    open var verifyText: String by `$props`
    open var completeText: String by `$props`
    open var verifyTextColor: String by `$props`
    open var imgIconPath: String by `$props`
    open var iconCode: String by `$props`
    open var clickDiff: Number by `$props`
    open var longDiff: Number by `$props`
    open var disabled: Boolean by `$props`
    open var linearGradient: UTSArray<String> by `$props`
    open var bgColor: String by `$props`
    open var completeLinearGradient: UTSArray<String> by `$props`
    open var verifyPos: String by `$props`
    open var reset: () -> Unit
        get() {
            return unref(this.`$exposed`["reset"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "reset", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsMcDragVerifyIndex, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsMcDragVerifyIndex
            val _cache = __ins.renderCache
            val proxy = getCurrentInstance()!!.proxy!!
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val isCompleted = ref(false)
            val totalWidth = ref(0)
            val barWidth = ref(0)
            val outStyle = ref(UTSJSONObject())
            val innerStyle = ref(UTSJSONObject())
            val dragVerifyInner = ref<UniElement?>(null)
            watchEffect(fun(){
                val outStyleObj: UTSJSONObject = object : UTSJSONObject() {
                    var backgroundColor = props.bgColor
                    var borderRadius = props.round + "rpx"
                    var height = props.height
                }
                outStyle.value = outStyleObj
                val innerStyleObj: UTSJSONObject = object : UTSJSONObject() {
                    var backgroundImage = "linear-gradient(to right, " + (if ((isCompleted.value || props.disabled)) {
                        props.completeLinearGradient.join(", ")
                    } else {
                        props.linearGradient.join(", ")
                    }
                    ) + ")"
                    var borderRadius = props.round + "rpx"
                    var height = props.height
                    var color = props.verifyTextColor
                }
                if (props.disabled) {
                    innerStyleObj["width"] = "100%"
                } else {
                    innerStyleObj["width"] = props.verifyPos
                }
                innerStyle.value = innerStyleObj
            }
            )
            val start = fun(){
                vibrator(100)
            }
            val move = fun(){
                vibrator(100)
            }
            val reset = fun(){
                isCompleted.value = false
                dragVerifyInner.value?.style?.setProperty("width", barWidth.value + "px")
            }
            val touchSwiper = fun(e: UTSJSONObject){
                if (e.getString("direction") == "right") {
                    isCompleted.value = true
                    dragVerifyInner.value?.style?.setProperty("width", totalWidth.value + "px")
                    vibrator(100)
                    emit("success")
                }
            }
            val getNodeInfo = fun(){
                setTimeout(fun(){
                    uni_createSelectorQuery().`in`(proxy).selectAll(".drag-verify").boundingClientRect().exec(fun(rect){
                        var nodes = rect[0] as UTSArray<NodeInfo>
                        if (nodes.length != 2) {
                            return
                        }
                        var node1 = nodes[0] as NodeInfo
                        var node2 = nodes[1] as NodeInfo
                        totalWidth.value = node1.width!!
                        barWidth.value = node2.width!!
                        dragVerifyInner.value?.style?.setProperty("width", barWidth.value + "px")
                    }
                    )
                }
                , 250)
            }
            onMounted(fun(){
                getNodeInfo()
            }
            )
            __expose(utsMapOf("reset" to reset))
            return fun(): Any? {
                val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
                val _component_x_finger = resolveEasyComponent("x-finger", GenUniModulesTmxUiComponentsXFingerXFingerClass)
                return createElementVNode("view", utsMapOf("class" to "drag-verify box", "style" to normalizeStyle(unref(outStyle))), utsArrayOf(
                    createVNode(_component_x_finger, utsMapOf("disabled" to (_ctx.disabled || unref(isCompleted)), "style" to normalizeStyle(utsMapOf("width" to "100%", "height" to "100%")), "clickDiff" to _ctx.clickDiff, "longDiff" to _ctx.longDiff, "swiperDiff" to _ctx.swiperDiff, "onMove" to move, "onStart" to start, "onSwiper" to unref(touchSwiper)), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "drag-verify inner flex-row flex-row-center-center", "ref_key" to "dragVerifyInner", "ref" to dragVerifyInner, "style" to normalizeStyle(unref(innerStyle))), utsArrayOf(
                                if (isTrue(_ctx.disabled || unref(isCompleted))) {
                                    createElementVNode("text", utsMapOf("key" to 0, "class" to "verify-text", "style" to normalizeStyle("color: " + _ctx.verifyTextColor + ";")), toDisplayString(_ctx.completeText), 5)
                                } else {
                                    createElementVNode("text", utsMapOf("key" to 1, "class" to "verify-text", "style" to normalizeStyle("color: " + _ctx.verifyTextColor + ";")), toDisplayString(_ctx.verifyText), 5)
                                }
                                ,
                                if (isTrue(!unref(isCompleted) && !_ctx.disabled)) {
                                    createElementVNode(Fragment, utsMapOf("key" to 2), utsArrayOf(
                                        if (_ctx.imgIconPath != "") {
                                            createElementVNode("image", utsMapOf("key" to 0, "class" to "img-icon", "src" to _ctx.imgIconPath, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                "src"
                                            ))
                                        } else {
                                            createVNode(_component_x_icon, utsMapOf("key" to 1, "code" to _ctx.iconCode), null, 8, utsArrayOf(
                                                "code"
                                            ))
                                        }
                                    ), 64)
                                } else {
                                    createCommentVNode("v-if", true)
                                }
                            ), 4)
                        )
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "disabled",
                        "style",
                        "clickDiff",
                        "longDiff",
                        "swiperDiff",
                        "onSwiper"
                    ))
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("drag-verify" to utsMapOf(".box" to utsMapOf("width" to "100%")), "inner" to utsMapOf(".drag-verify.box " to utsMapOf("transitionProperty" to "width,backgroundColor", "transitionDuration" to "0.35s")), "verify-text" to utsMapOf(".drag-verify.box .inner " to utsMapOf("fontWeight" to "bold", "fontSize" to "36rpx", "paddingRight" to "20rpx")), "img-icon" to utsMapOf(".drag-verify.box .inner " to utsMapOf("width" to "40rpx", "height" to "29rpx")), "@TRANSITION" to utsMapOf("inner" to utsMapOf("property" to "width,backgroundColor", "duration" to "0.35s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("success" to null, "fail" to null)
        var props = normalizePropsOptions(utsMapOf("round" to utsMapOf("type" to "Number", "default" to 20), "height" to utsMapOf("type" to "String", "default" to "110rpx"), "swiperDiff" to utsMapOf("type" to "Number", "default" to 100), "verifyText" to utsMapOf("type" to "String", "default" to "向右滑动进行验证"), "completeText" to utsMapOf("type" to "String", "default" to "验证成功"), "verifyTextColor" to utsMapOf("type" to "String", "default" to "#ffffff"), "imgIconPath" to utsMapOf("type" to "String", "default" to ""), "iconCode" to utsMapOf("type" to "String", "default" to ""), "clickDiff" to utsMapOf("type" to "Number", "default" to 50), "longDiff" to utsMapOf("type" to "Number", "default" to 800), "disabled" to utsMapOf("type" to "Boolean", "default" to false), "linearGradient" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf(
                "#44C791",
                "#28D07F"
            )
        }
        ), "bgColor" to utsMapOf("type" to "String", "default" to "#D0F6E5"), "completeLinearGradient" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf(
                "#B3B3B3",
                "#B3B3B3"
            )
        }
        ), "verifyPos" to utsMapOf("type" to "String", "default" to "80%")))
        var propsNeedCastKeys = utsArrayOf(
            "round",
            "height",
            "swiperDiff",
            "verifyText",
            "completeText",
            "verifyTextColor",
            "imgIconPath",
            "iconCode",
            "clickDiff",
            "longDiff",
            "disabled",
            "linearGradient",
            "bgColor",
            "completeLinearGradient",
            "verifyPos"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
