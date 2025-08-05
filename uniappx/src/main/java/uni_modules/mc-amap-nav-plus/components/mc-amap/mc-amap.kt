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
open class GenUniModulesMcAmapNavPlusComponentsMcAmapMcAmap : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var selfLocation: Boolean by `$props`
    open var showLocationBtn: Boolean by `$props`
    open var startAwaysLocation: (options: ContinueLocationOptions, successCallback: SuccessCallback) -> Unit
        get() {
            return unref(this.`$exposed`["startAwaysLocation"]) as (options: ContinueLocationOptions, successCallback: SuccessCallback) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "startAwaysLocation", value)
        }
    open var stopAwaysLocation: () -> Unit
        get() {
            return unref(this.`$exposed`["stopAwaysLocation"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "stopAwaysLocation", value)
        }
    open var getLocation: (options: SingleLocationOptions, successCallback: SuccessCallback) -> Unit
        get() {
            return unref(this.`$exposed`["getLocation"]) as (options: SingleLocationOptions, successCallback: SuccessCallback) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getLocation", value)
        }
    open var calculate: (navOption: AmapNavOption) -> Unit
        get() {
            return unref(this.`$exposed`["calculate"]) as (navOption: AmapNavOption) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "calculate", value)
        }
    open var destroy: () -> Unit
        get() {
            return unref(this.`$exposed`["destroy"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "destroy", value)
        }
    open var changeRouteById: (routeId: Number) -> Unit
        get() {
            return unref(this.`$exposed`["changeRouteById"]) as (routeId: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeRouteById", value)
        }
    open var playTTS: (text: String, forcePlay: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["playTTS"]) as (text: String, forcePlay: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "playTTS", value)
        }
    open var startNavi: (routeId: Number, isEmulator: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["startNavi"]) as (routeId: Number, isEmulator: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "startNavi", value)
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
    open var setBounds: (bounds: UTSArray<UTSArray<Number>>) -> Unit
        get() {
            return unref(this.`$exposed`["setBounds"]) as (bounds: UTSArray<UTSArray<Number>>) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setBounds", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesMcAmapNavPlusComponentsMcAmapMcAmap, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesMcAmapNavPlusComponentsMcAmapMcAmap
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            var mapView: NativeMap? = null
            val onViewInit = fun(e: UniNativeViewInitEvent){
                mapView = NativeMap(e.detail.element, MapOption(selfLocation = props.selfLocation, showLocationBtn = props.showLocationBtn, arriveCb = fun(){
                    emit("arrived")
                }
                , calcSuccessCb = fun(data){
                    emit("calcSuccess", data)
                }
                , naviInfoUpdateCb = fun(data){
                    emit("naviInfoUpdate", data)
                }
                ))
            }
            val startAwaysLocation = fun(options: ContinueLocationOptions, successCallback: SuccessCallback){
                mapView?.startAwaysLocation(options, successCallback)
            }
            val stopAwaysLocation = fun(){
                mapView?.stopAwaysLocation()
            }
            val getLocation = fun(options: SingleLocationOptions, successCallback: SuccessCallback){
                mapView?.getLocation(options, successCallback)
            }
            val calculate = fun(navOption: AmapNavOption){
                mapView?.calculate(navOption)
            }
            val addMarkers = fun(markers: UTSArray<MarkerOption>): Unit {
                mapView?.addMarkers(markers)
            }
            val removeMarkers = fun(){
                mapView?.removeMarkers()
            }
            val setMarkers = fun(markers: UTSArray<MarkerOption>){
                removeMarkers()
                addMarkers(markers)
            }
            val setBounds = fun(bounds: UTSArray<UTSArray<Number>>){
                mapView?.setBounds(bounds)
            }
            val startNavi = fun(routeId: Number, isEmulator: Boolean){
                mapView?.startNavi(routeId, isEmulator)
            }
            val changeRouteById = fun(routeId: Number){
                mapView?.changeRouteById(routeId)
            }
            val playTTS = fun(text: String, forcePlay: Boolean){
                mapView?.playTTS(text, forcePlay)
            }
            val destroy = fun(){
                mapView?.destroy()
                mapView = null
                console.log("destroy-mapView:", mapView)
            }
            __expose(utsMapOf("startAwaysLocation" to startAwaysLocation, "stopAwaysLocation" to stopAwaysLocation, "getLocation" to getLocation, "calculate" to calculate, "destroy" to destroy, "changeRouteById" to changeRouteById, "playTTS" to playTTS, "startNavi" to startNavi, "addMarkers" to addMarkers, "setMarkers" to setMarkers, "removeMarkers" to removeMarkers, "setBounds" to setBounds))
            return fun(): Any? {
                return createElementVNode("view", utsMapOf("class" to "map-view-box"), utsArrayOf(
                    createElementVNode("native-view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "100%", "height" to "100%")), "onInit" to onViewInit), null, 36),
                    createElementVNode("view", utsMapOf("class" to "map-view-bottom"), utsArrayOf(
                        renderSlot(_ctx.`$slots`, "bottom")
                    ))
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
                return utsMapOf("map-view-box" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100%", "position" to "relative")), "map-view-bottom" to utsMapOf(".map-view-box " to utsMapOf("position" to "absolute", "left" to 0, "right" to 0, "bottom" to "20rpx", "width" to "100%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("naviInfoUpdate" to null, "arrived" to null, "calcSuccess" to null)
        var props = normalizePropsOptions(utsMapOf("selfLocation" to utsMapOf("type" to "Boolean", "default" to true), "showLocationBtn" to utsMapOf("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = utsArrayOf(
            "selfLocation",
            "showLocationBtn"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
