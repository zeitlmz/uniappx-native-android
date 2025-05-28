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
open class GenUniModulesMcAmapNavPlusComponentsMcAmapLocationMcAmapLocation : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var enableHighAccuracy: Boolean by `$props`
    open var intervel: Number by `$props`
    open var stop: () -> Unit
        get() {
            return unref(this.`$exposed`["stop"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "stop", value)
        }
    open var startLocation: () -> Unit
        get() {
            return unref(this.`$exposed`["startLocation"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "startLocation", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesMcAmapNavPlusComponentsMcAmapLocationMcAmapLocation, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesMcAmapNavPlusComponentsMcAmapLocationMcAmapLocation
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val startLocation = fun(){
                stopLocation()
                startAmapLocation(ContinueLocationOptions(enableHighAccuracy = props.enableHighAccuracy, intervel = props.intervel), fun(result){
                    emit("location", JSON.stringify(result))
                }
                )
            }
            val stop = fun(){
                stopLocation()
                emit("stop")
            }
            onMounted(fun(){
                startLocation()
            }
            )
            onUnmounted(fun(){
                console.log("持续定位组件onUnmounted")
                stop()
            }
            )
            __expose(utsMapOf("stop" to stop, "startLocation" to startLocation))
            return fun(): Any? {
                return createElementVNode("view")
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("location" to null, "stop" to null)
        var props = normalizePropsOptions(utsMapOf("enableHighAccuracy" to utsMapOf("type" to "Boolean", "default" to false), "intervel" to utsMapOf("type" to "Number", "default" to 1000)))
        var propsNeedCastKeys = utsArrayOf(
            "enableHighAccuracy",
            "intervel"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
