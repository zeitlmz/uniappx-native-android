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
open class GenComponentsMcActiveAnimationIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
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
                return _cE("view", _uM("class" to _nC(_uA(
                    "transition",
                    _uM("active" to unref(isPressed))
                )), "onTouchstart" to fun(){
                    isPressed.value = true
                }
                , "onTouchend" to fun(){
                    isPressed.value = false
                }
                , "onClick" to click), _uA(
                    renderSlot(_ctx.`$slots`, "default")
                ), 42, _uA(
                    "onTouchstart",
                    "onTouchend"
                ))
            }
        }
        var name = "mc-active-animation"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("transition" to _uM("" to _uM("transitionProperty" to "all", "transitionDuration" to "0.15s"), ".active" to _uM("opacity" to 0.8, "transform" to "scale(0.98)")), "@TRANSITION" to _uM("transition" to _uM("property" to "all", "duration" to "0.15s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
