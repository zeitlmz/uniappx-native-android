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
import uts.sdk.modules.mcAmapNav.MapOption
import uts.sdk.modules.mcAmapNav.SingleLocationOptions
import uts.sdk.modules.mcAmapNav.SuccessCallback
import uts.sdk.modules.mcAmapNav.AmapNavOption
import uts.sdk.modules.mcAmapNav.MarkerOption
import uts.sdk.modules.mcAmapNav.NativeNavi
open class GenComponentsMcAmapNavIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var i18n: Tmui4xI18nTml by `$data`
    open var stopNavi: () -> Unit
        get() {
            return unref(this.`$exposed`["stopNavi"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "stopNavi", value)
        }
    open var setShowMode: (mode: Int) -> Unit
        get() {
            return unref(this.`$exposed`["setShowMode"]) as (mode: Int) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setShowMode", value)
        }
    open var destroy: () -> Unit
        get() {
            return unref(this.`$exposed`["destroy"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "destroy", value)
        }
    open var playTTS: (text: String, forcePlay: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["playTTS"]) as (text: String, forcePlay: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "playTTS", value)
        }
    open var addMarkers: (markers: UTSArray<MarkerOption>) -> Unit
        get() {
            return unref(this.`$exposed`["addMarkers"]) as (markers: UTSArray<MarkerOption>) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "addMarkers", value)
        }
    open var setMarkers: (markers: UTSArray<MarkerOption>) -> Unit
        get() {
            return unref(this.`$exposed`["setMarkers"]) as (markers: UTSArray<MarkerOption>) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setMarkers", value)
        }
    open var removeMarkers: () -> Unit
        get() {
            return unref(this.`$exposed`["removeMarkers"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "removeMarkers", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsMcAmapNavIndex, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsMcAmapNavIndex
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            var navi: NativeNavi? = null
            val onViewInit = fun(e: UniNativeViewInitEvent){
                navi = NativeNavi(e.detail.element, fun(){
                    emit("quit")
                }
                )
            }
            val addMarkers = fun(markers: UTSArray<MarkerOption>): Unit {
                navi?.addMarkers(markers)
            }
            val removeMarkers = fun(){
                navi?.removeMarkers()
            }
            val setMarkers = fun(markers: UTSArray<MarkerOption>){
                removeMarkers()
                addMarkers(markers)
            }
            val stopNavi = fun(){
                navi?.stopNavi()
            }
            val setShowMode = fun(mode: Int){
                navi?.setShowMode(mode)
            }
            val playTTS = fun(text: String, forcePlay: Boolean){
                navi?.playTTS(text, forcePlay)
            }
            val destroy = fun(){
                navi?.destroy()
                navi = null
            }
            onUnmounted(fun(){
                destroy()
            }
            )
            onMounted(fun(){
                console.log("导航组件挂载=====")
            }
            )
            __expose(_uM("stopNavi" to stopNavi, "setShowMode" to setShowMode, "destroy" to destroy, "playTTS" to playTTS, "addMarkers" to addMarkers, "setMarkers" to setMarkers, "removeMarkers" to removeMarkers))
            return fun(): Any? {
                return _cE("native-view", _uM("style" to _nS(_uM("width" to "100%", "height" to "100%")), "onInit" to onViewInit), null, 36)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("quit" to null)
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
