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
import uts.sdk.modules.mcAmapNav.ContinueLocationOptions
import uts.sdk.modules.mcAmapNav.MapOption
import uts.sdk.modules.mcAmapNav.SingleLocationOptions
import uts.sdk.modules.mcAmapNav.SuccessCallback
import uts.sdk.modules.mcAmapNav.AmapNavOption
import uts.sdk.modules.mcAmapNav.MarkerOption
import uts.sdk.modules.mcAmapNav.NativeMap
open class GenComponentsMcAmapIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var selfLocation: Boolean by `$props`
    open var showLocationBtn: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var startAwaysLocation: (options: ContinueLocationOptions) -> Unit
        get() {
            return unref(this.`$exposed`["startAwaysLocation"]) as (options: ContinueLocationOptions) -> Unit
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
    open var getLocation: (options: SingleLocationOptions) -> Unit
        get() {
            return unref(this.`$exposed`["getLocation"]) as (options: SingleLocationOptions) -> Unit
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
    open var removePolylines: () -> Unit
        get() {
            return unref(this.`$exposed`["removePolylines"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "removePolylines", value)
        }
    open var addPolylines: (latLngStrs: String) -> Unit
        get() {
            return unref(this.`$exposed`["addPolylines"]) as (latLngStrs: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "addPolylines", value)
        }
    open var setPolylines: (latLngStrs: String) -> Unit
        get() {
            return unref(this.`$exposed`["setPolylines"]) as (latLngStrs: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setPolylines", value)
        }
    open var setBounds: (bounds: UTSArray<UTSArray<Number>>) -> Unit
        get() {
            return unref(this.`$exposed`["setBounds"]) as (bounds: UTSArray<UTSArray<Number>>) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setBounds", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsMcAmapIndex, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsMcAmapIndex
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
            val startAwaysLocation = fun(options: ContinueLocationOptions){
                mapView?.startAwaysLocation(options)
            }
            val stopAwaysLocation = fun(){
                mapView?.stopAwaysLocation()
            }
            val getLocation = fun(options: SingleLocationOptions){
                mapView?.getLocation(options)
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
            val addPolylines = fun(latLngStrs: String): Unit {
                mapView?.addPolylines(latLngStrs)
            }
            val removePolylines = fun(){
                mapView?.removePolylines()
            }
            val setPolylines = fun(latLngStrs: String){
                removePolylines()
                addPolylines(latLngStrs)
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
            __expose(_uM("startAwaysLocation" to startAwaysLocation, "stopAwaysLocation" to stopAwaysLocation, "getLocation" to getLocation, "calculate" to calculate, "destroy" to destroy, "changeRouteById" to changeRouteById, "playTTS" to playTTS, "startNavi" to startNavi, "addMarkers" to addMarkers, "setMarkers" to setMarkers, "removeMarkers" to removeMarkers, "removePolylines" to removePolylines, "addPolylines" to addPolylines, "setPolylines" to setPolylines, "setBounds" to setBounds))
            return fun(): Any? {
                return _cE("view", _uM("class" to "map-view-box"), _uA(
                    _cE("native-view", _uM("style" to _nS(_uM("width" to "100%", "height" to "100%")), "onInit" to onViewInit), null, 36),
                    _cE("view", _uM("class" to "map-view-bottom"), _uA(
                        renderSlot(_ctx.`$slots`, "bottom")
                    ))
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
                return _uM("map-view-box" to _pS(_uM("width" to "100%", "height" to "100%", "position" to "relative")), "map-view-bottom" to _uM(".map-view-box " to _uM("position" to "absolute", "left" to 0, "right" to 0, "bottom" to "20rpx", "width" to "100%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("naviInfoUpdate" to null, "arrived" to null, "calcSuccess" to null)
        var props = _nP(_uM("selfLocation" to _uM("type" to "Boolean", "default" to true), "showLocationBtn" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "selfLocation",
            "showLocationBtn"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
