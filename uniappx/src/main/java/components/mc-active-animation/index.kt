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
open class GenComponentsMcActiveAnimationIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsMcActiveAnimationIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsMcActiveAnimationIndex
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val isPressed = ref<Boolean>(false)
            val click = fun(){
                emit("click")
            }
            return fun(): Any? {
                return createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                    "transition",
                    utsMapOf("active" to unref(isPressed))
                )), "onTouchstart" to fun(){
                    isPressed.value = true
                }
                , "onTouchend" to fun(){
                    isPressed.value = false
                }
                , "onClick" to click), utsArrayOf(
                    renderSlot(_ctx.`$slots`, "default")
                ), 42, utsArrayOf(
                    "onTouchstart",
                    "onTouchend"
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
                return utsMapOf("transition" to utsMapOf("" to utsMapOf("transitionDuration" to "0.15s"), ".active" to utsMapOf("opacity" to 0.8, "transform" to "scale(0.98)")), "@TRANSITION" to utsMapOf("transition" to utsMapOf("duration" to "0.15s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("click" to null)
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
