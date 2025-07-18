@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.mcAmapNavPlus
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.SparseArray
import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import com.amap.api.maps.AMap
import com.amap.api.maps.CameraUpdateFactory
import com.amap.api.maps.MapsInitializer
import com.amap.api.maps.TextureMapView
import com.amap.api.maps.model.BitmapDescriptorFactory
import com.amap.api.maps.model.LatLng
import com.amap.api.maps.model.LatLngBounds
import com.amap.api.maps.model.Marker
import com.amap.api.maps.model.MarkerOptions
import com.amap.api.maps.model.MyLocationStyle
import com.amap.api.navi.AMapNavi
import com.amap.api.navi.AMapNaviListener
import com.amap.api.navi.AMapNaviView
import com.amap.api.navi.AMapNaviViewListener
import com.amap.api.navi.AMapNaviViewOptions
import com.amap.api.navi.NaviSetting
import com.amap.api.navi.enums.AMapNaviOnlineCarHailingType
import com.amap.api.navi.enums.MapStyle
import com.amap.api.navi.enums.NaviType
import com.amap.api.navi.model.AMapCalcRouteResult
import com.amap.api.navi.model.AMapCarInfo
import com.amap.api.navi.model.AMapLaneInfo
import com.amap.api.navi.model.AMapModelCross
import com.amap.api.navi.model.AMapNaviCameraInfo
import com.amap.api.navi.model.AMapNaviCross
import com.amap.api.navi.model.AMapNaviLocation
import com.amap.api.navi.model.AMapNaviPath
import com.amap.api.navi.model.AMapNaviRouteNotifyData
import com.amap.api.navi.model.AMapNaviToViaInfo
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo
import com.amap.api.navi.model.AMapServiceAreaInfo
import com.amap.api.navi.model.AimLessModeCongestionInfo
import com.amap.api.navi.model.AimLessModeStat
import com.amap.api.navi.model.NaviInfo
import com.amap.api.navi.model.NaviLatLng
import com.amap.api.navi.model.NaviPoi
import com.amap.api.navi.view.RouteOverLay
import com.amap.apis.utils.core.api.AMapUtilCoreApi
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
import uts.sdk.modules.mcAmapNavPlus.ReflectionUtil
import io.dcloud.uniapp.extapi.showToast as uni_showToast
typealias SuccessCallback = (res: LocationResult) -> Unit
open class AmapNavOption (
    open var carNumber: String? = null,
    @JsonNotNull
    open var startLng: Number,
    @JsonNotNull
    open var startLat: Number,
    open var startName: String? = null,
    @JsonNotNull
    open var startPoiId: String,
    @JsonNotNull
    open var endPoiId: String,
    @JsonNotNull
    open var wayPoints: UTSArray<UTSArray<Number>>,
    @JsonNotNull
    open var poiIds: UTSArray<String>,
    @JsonNotNull
    open var endLng: Number,
    @JsonNotNull
    open var endLat: Number,
    @JsonNotNull
    open var endName: String,
    @JsonNotNull
    open var calcStrategy: Number,
) : UTSObject()
open class SingleLocationOptions (
    open var enableHighAccuracy: Boolean? = null,
) : UTSObject()
open class ContinueLocationOptions (
    open var enableHighAccuracy: Boolean? = null,
    open var intervel: Number? = null,
) : UTSObject()
open class LocationResult (
    @JsonNotNull
    open var latitude: Number,
    @JsonNotNull
    open var longitude: Number,
    @JsonNotNull
    open var provinceName: String,
    @JsonNotNull
    open var cityName: String,
    @JsonNotNull
    open var distinctName: String,
    @JsonNotNull
    open var address: String,
    @JsonNotNull
    open var adcode: String,
) : UTSObject()
typealias AgreeCallback = (res: Boolean) -> Unit
open class MarkerOption (
    @JsonNotNull
    open var desc: String,
    @JsonNotNull
    open var icon: String,
    @JsonNotNull
    open var color: String,
    @JsonNotNull
    open var latitude: Number,
    @JsonNotNull
    open var longitude: Number,
) : UTSObject()
open class MapOption (
    @JsonNotNull
    open var selfLocation: Boolean = false,
    @JsonNotNull
    open var showLocationBtn: Boolean = false,
    open var calcSuccessCb: ((data: String) -> Unit)? = null,
    open var naviInfoUpdateCb: ((data: String) -> Unit)? = null,
    open var arriveCb: (() -> Unit)? = null,
) : UTSObject()
fun loadImageFromAssets(fname: String): Bitmap? {
    var bitmap: Bitmap? = null
    try {
        var assetManager = UTSAndroid.getAppContext()!!.getAssets()
        var inputStream = assetManager.open(fname)
        bitmap = BitmapFactory.decodeStream(inputStream)
    }
    catch (e: Throwable) {}
    return bitmap
}
open class PlatformUtils {
    constructor(){}
    open fun setScreenOrientation(type: Number) {
        if (type == 1) {
            UTSAndroid.getUniActivity()!!.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        } else {
            UTSAndroid.getUniActivity()!!.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        }
    }
    open fun permissionsRequest(permissionNeed: UTSArray<String>, callback: (ret: Boolean, desc: String) -> Unit) {
        if ("io.dcloud.uniappx" != UTSAndroid.getAppContext()?.packageName && "io.dcloud.HBuilder" != UTSAndroid.getAppContext()?.packageName) {
            uni_showToast(ShowToastOptions(title = "自定义基座不支持当前测试"))
            return
        }
        if (UTSAndroid.getSystemPermissionDenied(UTSAndroid.getUniActivity()!!, permissionNeed).isEmpty()) {
            callback(false, "已具备权限")
            return
        }
        UTSAndroid.requestSystemPermission(UTSAndroid.getUniActivity()!!, permissionNeed, fun(allRight: Boolean, _: UTSArray<String>) {
            if (allRight) {
                if (!UTSAndroid.getSystemPermissionDenied(UTSAndroid.getUniActivity()!!, permissionNeed).isEmpty()) {
                    callback(false, "权限请求完成,getSystemPermissionDenied 失败")
                    return
                }
                if (!UTSAndroid.checkSystemPermissionGranted(UTSAndroid.getUniActivity()!!, permissionNeed)) {
                    callback(false, "权限请求完成,checkSystemPermissionGranted 失败")
                    return
                }
                callback(true, "")
            } else {
                callback(false, "用户拒绝了部分权限")
            }
        }
            , fun(_: Boolean, _: UTSArray<String>) {
                callback(false, "用户拒绝了部分权限")
            }
        )
    }
}
open class MyAMapLocationListener : AMapLocationListener {
    open var successCallback: SuccessCallback
    open var locationClient: AMapLocationClient
    open var isOnce: Boolean
    constructor(successCallback: SuccessCallback, locationClient: AMapLocationClient, isOnce: Boolean){
        this.locationClient = locationClient
        this.successCallback = successCallback
        this.isOnce = isOnce
    }
    override fun onLocationChanged(location: AMapLocation) {
        if (location.getErrorCode() == 0) {
            val result = LocationResult(latitude = location.getLatitude(), longitude = location.getLongitude(), provinceName = location.getProvince(), cityName = location.getCity(), distinctName = location.getDistrict(), address = location.getAddress(), adcode = location.getAdCode())
            this.successCallback(result)
        }
        if (this.isOnce) {
            this.locationClient.onDestroy()
        }
    }
}
open class MyLocationUtils {
    private var locationClientContinue: AMapLocationClient = AMapLocationClient(UTSAndroid.getAppContext()!!)
    constructor(){}
    open fun getAmapOnceLocation(options: SingleLocationOptions, successCallback: SuccessCallback) {
        val _options_enableHighAccuracy = options.enableHighAccuracy
        val enableHighAccuracy = if (_options_enableHighAccuracy == null) {
            true
        } else {
            _options_enableHighAccuracy
        }
        val locationClientSingle: AMapLocationClient = AMapLocationClient(UTSAndroid.getAppContext()!!)
        val locationSingleListener = MyAMapLocationListener(successCallback, locationClientSingle, true)
        locationClientSingle.setLocationListener(locationSingleListener)
        val locationClientSingleOption = AMapLocationClientOption()
        if (enableHighAccuracy) {
            locationClientSingleOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy)
        }
        locationClientSingleOption.setOnceLocation(true)
        locationClientSingleOption.setLocationCacheEnable(false)
        locationClientSingle.setLocationOption(locationClientSingleOption)
        locationClientSingle.startLocation()
    }
    open fun startAmapLocation(options: ContinueLocationOptions, successCallback: SuccessCallback) {
        this.stopLocation()
        val _options_enableHighAccuracy = options.enableHighAccuracy
        val enableHighAccuracy = if (_options_enableHighAccuracy == null) {
            true
        } else {
            _options_enableHighAccuracy
        }
        val intervel = options.intervel
        val locationContinueListener = MyAMapLocationListener(successCallback, this.locationClientContinue, false)
        this.locationClientContinue.setLocationListener(locationContinueListener)
        val locationClientContinueOption = AMapLocationClientOption()
        if (enableHighAccuracy) {
            locationClientContinueOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy)
        }
        if (intervel != null) {
            locationClientContinueOption.setInterval(intervel.toLong())
        }
        this.locationClientContinue.setLocationOption(locationClientContinueOption)
        this.locationClientContinue.startLocation()
    }
    open fun stopLocation() {
        this.locationClientContinue.stopLocation()
    }
    open fun destory() {
        this.locationClientContinue.onDestroy()
    }
}
open class LocationUtils {
    private constructor(){}
    companion object {
        var locationUtils: MyLocationUtils? = null
        var platformUtils: PlatformUtils? = null
        fun getLocationU(): MyLocationUtils? {
            if (this.locationUtils == null) {
                this.locationUtils = MyLocationUtils()
            }
            return this.locationUtils
        }
        fun getPlatformU(): PlatformUtils? {
            if (this.platformUtils == null) {
                this.platformUtils = PlatformUtils()
            }
            return this.platformUtils
        }
    }
}
open class CallbackOptions (
    open var success: ((res: RoutesData) -> Unit)? = null,
    open var fail: ((error: RoutesData) -> Unit)? = null,
) : UTSObject()
open class RouteData : UTSObject() {
}
open class RoutesData (
    @JsonNotNull
    open var message: String,
    @JsonNotNull
    open var errorCode: Number,
    @JsonNotNull
    open var data: Map<Int, AMapNaviPath>,
) : UTSObject()
open class PointType (
    @JsonNotNull
    open var longitude: Number,
    @JsonNotNull
    open var latitude: Number,
    open var address: String? = null,
) : UTSObject()
open class NaviOptions (
    open var start: PointType? = null,
    open var wayPoints: UTSArray<PointType>? = null,
    @JsonNotNull
    open var end: PointType,
) : UTSObject()
fun init(apiKey: String) {
    MapsInitializer.updatePrivacyShow(UTSAndroid.getAppContext()!!, true, true)
    MapsInitializer.updatePrivacyAgree(UTSAndroid.getAppContext()!!, true)
    AMapNavi.setApiKey(UTSAndroid.getAppContext()!!, apiKey)
}
fun checkLocationPermission(cb: AgreeCallback) {
    console.log("定位权限申请 checkLocationPermission执行")
    var permissions = utsArrayOf(
        "android.permission.ACCESS_FINE_LOCATION"
    )
    UTSAndroid.requestSystemPermission(UTSAndroid.getUniActivity()!!, permissions, fun(allRight: Boolean, grantedList: UTSArray<String>) {
        if (allRight) {
            console.log("用户同意了全部权限")
        } else {
            console.log("用户仅同意了 grantedList中的权限", grantedList)
        }
        cb(allRight)
    }
        , fun(doNotAskAgain: Boolean, grantedList: UTSArray<String>) {
            console.log("用户拒绝了部分权限，仅允许了grantedList中的权限")
            if (doNotAskAgain) {
                console.log("用户拒绝了权限，并且选择不再询问")
            }
            cb(doNotAskAgain)
        }
    )
}
fun getAmapOnceLocation(options: SingleLocationOptions, successCallback: SuccessCallback) {
    LocationUtils.getLocationU()?.getAmapOnceLocation(options, successCallback)
}
fun startAmapLocation(options: ContinueLocationOptions, successCallback: SuccessCallback) {
    LocationUtils.getLocationU()?.startAmapLocation(options, successCallback)
}
fun stopLocation() {
    LocationUtils.getLocationU()?.stopLocation()
}
fun setScreenOrientation(type: Number) {
    LocationUtils.getPlatformU()?.setScreenOrientation(type)
}
fun permissionsRequest(permissionNeed: UTSArray<String>, callback: (ret: Boolean, desc: String) -> Unit) {
    LocationUtils.getPlatformU()?.permissionsRequest(permissionNeed, callback)
}
typealias CallbackType = (res: RoutesData) -> Unit
typealias NoParamsCallbackType = () -> Unit
typealias ClearRouteDataType = () -> Unit
typealias NaviInfoUpdateType = (data: NaviInfo) -> Unit
typealias QuitType = () -> Unit
open class MyNaviListener : AMapNaviListener {
    private var aMapNavi: AMapNavi? = null
    private var successCb: CallbackType
    private var arriveCb: NoParamsCallbackType
    private var clearRouteDataCb: ClearRouteDataType
    private var naviInfoUpdateCb: NaviInfoUpdateType
    constructor(aMapNavi: AMapNavi?, successCb: CallbackType, arriveCb: NoParamsCallbackType, clearRouteDataCb: ClearRouteDataType, naviInfoUpdateCb: NaviInfoUpdateType){
        this.aMapNavi = aMapNavi
        this.successCb = successCb
        this.arriveCb = arriveCb
        this.clearRouteDataCb = clearRouteDataCb
        this.naviInfoUpdateCb = naviInfoUpdateCb
    }
    override fun hideCross() {}
    override fun hideLaneInfo() {}
    override fun hideModeCross() {}
    override fun notifyParallelRoad(parallelRoadType: Int) {}
    override fun onArriveDestination() {
        console.log("到达目的地后回调函数")
        this.arriveCb()
    }
    override fun onArrivedWayPoint(wayID: Int) {
        console.log("驾车路径导航到达某个途经点的回调函数:", wayID)
    }
    override fun onCalculateRouteFailure(routeResult: AMapCalcRouteResult) {
        console.log("算路错误", routeResult)
    }
    override fun onCalculateRouteFailure(errorInfo: Int) {}
    override fun onCalculateRouteSuccess(routeResult: AMapCalcRouteResult) {
        this.clearRouteDataCb()
        val result = RoutesData(message = "算路成功", errorCode = 0, data = Map<Int, AMapNaviPath>())
        val paths = this.aMapNavi?.getNaviPaths()
        paths?.forEach(fun(key: Int, path: AMapNaviPath){
            result.data.set(key, path)
        }
        )
        this.successCb(result)
    }
    override fun onCalculateRouteSuccess(routeIds: kotlin.IntArray) {}
    override fun onEndEmulatorNavi() {
        console.log("模拟导航停止")
        this.arriveCb()
    }
    override fun onGetNavigationText(type: Int, text: String) {
        console.log("导航播报信息回调函数", text)
    }
    override fun onGetNavigationText(text: String) {}
    override fun onGpsOpenStatus(enabled: Boolean) {}
    override fun onGpsSignalWeak(isWeak: Boolean) {}
    override fun onInitNaviFailure() {
        console.log("导航初始化失败")
    }
    override fun onInitNaviSuccess() {
        console.log("导航初始化成功")
    }
    override fun onLocationChange(location: AMapNaviLocation) {}
    override fun onNaviInfoUpdate(naviInfo: NaviInfo) {
        this.naviInfoUpdateCb(naviInfo)
    }
    override fun onNaviRouteNotify(notifyData: AMapNaviRouteNotifyData) {}
    override fun onPlayRing(type: Int) {}
    override fun onReCalculateRouteForTrafficJam() {}
    override fun onReCalculateRouteForYaw() {}
    override fun onServiceAreaUpdate(infoArray: kotlin.Array<AMapServiceAreaInfo>) {}
    override fun onStartNavi(type: Int) {
        console.log("启动导航成功", type)
    }
    override fun onTrafficStatusUpdate() {}
    override fun OnUpdateTrafficFacility(aMapNaviTrafficFacilityInfo: AMapNaviTrafficFacilityInfo) {}
    override fun OnUpdateTrafficFacility(infos: kotlin.Array<AMapNaviTrafficFacilityInfo>) {}
    override fun showCross(aMapNaviCross: AMapNaviCross) {}
    override fun showLaneInfo(laneInfo: AMapLaneInfo) {}
    override fun showLaneInfo(laneInfos: kotlin.Array<AMapLaneInfo>, laneBackgroundInfo: kotlin.ByteArray, laneRecommendedInfo: kotlin.ByteArray) {}
    override fun showModeCross(modelCross: AMapModelCross) {}
    override fun updateAimlessModeCongestionInfo(aimLessModeCongestionInfo: AimLessModeCongestionInfo) {}
    override fun updateAimlessModeStatistics(aimLessModeStat: AimLessModeStat) {}
    override fun updateCameraInfo(infoArray: kotlin.Array<AMapNaviCameraInfo>) {}
    override fun updateIntervalCameraInfo(startCameraInfo: AMapNaviCameraInfo, endCameraInfo: AMapNaviCameraInfo, status: Int) {}
}
open class MyNaviViewListener : AMapNaviViewListener {
    private var quitCb: () -> Unit
    constructor(quitCb: () -> Unit){
        this.quitCb = quitCb
    }
    override fun onNaviSetting() {
        console.log("界面右下角设置按钮的点击回调")
    }
    override fun onNaviCancel() {
        this.quitCb()
    }
    override fun onNaviBackClick(): Boolean {
        console.log("退出导航")
        return false
    }
    override fun onNaviMapMode(var1: Int) {
        console.log("onNaviMapMode")
    }
    override fun onNaviTurnClick() {
        console.log("onNaviTurnClick")
    }
    override fun onNextRoadClick() {
        console.log("onNextRoadClick")
    }
    override fun onScanViewButtonClick() {
        console.log("点击全览")
    }
    override fun onLockMap(var1: Boolean) {
        console.log("onLockMap")
    }
    override fun onNaviViewLoaded() {
        console.log("onNaviViewLoaded")
    }
    override fun onMapTypeChanged(var1: Int) {
        console.log("白天黑夜模式切换：", var1)
    }
    override fun onNaviViewShowMode(var1: Int) {
        console.log("onNaviViewLoaded")
    }
}
val createCustomBitmap = fun(text: String, color: String, width: Int, height: Int): Bitmap {
    val bitmap: Bitmap = Bitmap.createBitmap(width + 10, height * 3, Bitmap.Config.ARGB_8888)
    val canvas: Canvas = Canvas(bitmap)
    val paint: Paint = Paint()
    paint.setStrokeWidth(UTSNumber.from(4).toFloat())
    paint.setShadowLayer(UTSNumber.from(5).toFloat(), UTSNumber.from(0).toFloat(), UTSNumber.from(0).toFloat(), Color.parseColor("#e8e8e8"))
    paint.setColor(Color.parseColor(color))
    canvas.drawRoundRect(UTSNumber.from(5).toFloat(), UTSNumber.from(5).toFloat(), UTSNumber.from(width).toFloat(), UTSNumber.from(height * 0.9).toFloat(), UTSNumber.from(10).toFloat(), UTSNumber.from(10).toFloat(), paint)
    paint.setColor(Color.WHITE)
    paint.setShadowLayer(UTSNumber.from(0).toFloat(), UTSNumber.from(0).toFloat(), UTSNumber.from(0).toFloat(), Color.parseColor("#e8e8e8"))
    canvas.drawRoundRect(UTSNumber.from(9).toFloat(), UTSNumber.from(9).toFloat(), UTSNumber.from(width - 4).toFloat(), UTSNumber.from(height * 0.9 - 4).toFloat(), UTSNumber.from(8).toFloat(), UTSNumber.from(8).toFloat(), paint)
    paint.setShadowLayer(UTSNumber.from(5).toFloat(), UTSNumber.from(0).toFloat(), UTSNumber.from(0).toFloat(), Color.GRAY)
    paint.setColor(Color.WHITE)
    canvas.drawCircle(UTSNumber.from(width / 2).toFloat(), UTSNumber.from(height * 1.5).toFloat(), UTSNumber.from(height / 2.1).toFloat(), paint)
    paint.setColor(Color.parseColor("#65dd7a"))
    paint.setShadowLayer(UTSNumber.from(5).toFloat(), UTSNumber.from(0).toFloat(), UTSNumber.from(0).toFloat(), Color.parseColor("#e8e8e8"))
    canvas.drawCircle(UTSNumber.from(width / 2).toFloat(), UTSNumber.from(height * 1.5).toFloat(), UTSNumber.from(height / 2.1 - 10).toFloat(), paint)
    paint.setColor(Color.WHITE)
    canvas.drawCircle(UTSNumber.from(width / 2).toFloat(), UTSNumber.from(height * 1.5).toFloat(), UTSNumber.from(height / 2.1 - 25).toFloat(), paint)
    paint.setShadowLayer(UTSNumber.from(0).toFloat(), UTSNumber.from(0).toFloat(), UTSNumber.from(0).toFloat(), Color.parseColor("#e8e8e8"))
    paint.setColor(Color.parseColor(color))
    paint.setTextSize(UTSNumber.from(40).toFloat())
    canvas.drawText(text, UTSNumber.from(20).toFloat(), UTSNumber.from(50).toFloat(), paint)
    return bitmap
}
open class MapStore {
    constructor(){}
    companion object {
        var mapView: TextureMapView? = null
        var mapNaviView: AMapNaviView? = null
    }
}
open class NativeMap {
    private var element: UniNativeViewElement? = null
    private var aMap: AMap? = null
    private var mAMapNavi: AMapNavi? = null
    private var options: MapOption? = null
    private var routeData: Map<Int, AMapNaviPath>? = Map<Int, AMapNaviPath>()
    private var markers: ArrayList<Marker>? = ArrayList()
    private var routeOverlays: SparseArray<RouteOverLay>? = SparseArray<RouteOverLay>()
    private var naviListener: MyNaviListener? = null
    constructor(element: UniNativeViewElement, options: MapOption){
        this.element = element
        this.options = options
        this.bindView()
    }
    open fun startNavi(routeId: Number, isEmulator: Boolean) {
        this.mAMapNavi?.selectRouteId(routeId.toInt())
        this.mAMapNavi?.setAMapNaviOnlineCarHailingType(AMapNaviOnlineCarHailingType.TRANSPORT)
        this.mAMapNavi?.startSpeak()
        if (isEmulator) {
            this.mAMapNavi?.startNavi(NaviType.EMULATOR)
        } else {
            this.mAMapNavi?.startNavi(NaviType.GPS)
        }
    }
    open fun addMarkers(markers: UTSArray<MarkerOption>) {
        val markerOptionsList: UTSArray<MarkerOptions> = utsArrayOf()
        markers.forEach(fun(marker: MarkerOption, _idx: Number, _arr: UTSArray<MarkerOption>){
            val markerOptions: MarkerOptions = MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(createCustomBitmap(marker.desc, "#" + marker.color, 200, 80))).position(LatLng(marker.latitude.toDouble(), marker.longitude.toDouble())).setFlat(false).snippet(marker.desc).infoWindowEnable(false).anchor(UTSNumber.from(0.5).toFloat(), UTSNumber.from(0.5).toFloat()).zIndex(UTSNumber.from(999999).toFloat())
            markerOptionsList.push(markerOptions)
        }
        )
        this.markers = this.aMap?.addMarkers(markerOptionsList, false) as ArrayList<Marker>
    }
    open fun removeMarkers() {
        this.markers?.forEach(fun(marker){
            marker.remove()
        }
        )
        this.markers?.clear()
    }
    open fun playTTS(text: String, forcePlay: Boolean) {
        this.mAMapNavi?.playTTS(text, forcePlay)
    }
    open fun setBounds(points: UTSArray<UTSArray<Number>>) {
        val boundsBuilder = LatLngBounds.Builder()
        if (points != null) {
            points.forEach(fun(coord: UTSArray<Number>){
                boundsBuilder.include(LatLng(coord[0].toDouble(), coord[1].toDouble()))
            }
            )
        }
        val bounds = boundsBuilder.build()
        this.aMap?.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 150))
    }
    open fun changeRouteById(routeId: Number) {
        this.mAMapNavi?.selectRouteId(routeId.toInt())
        run {
            var i: Int = 0
            while(i < (this.routeOverlays?.size() ?: 0 as Int)){
                val id: Int = this.routeOverlays?.keyAt(i) ?: 0 as Int
                val routeOverlay: RouteOverLay? = this.routeOverlays?.valueAt(i)
                var transparency: Number = 0.4
                var zIndex: Int = -2
                var arrowVisible = true
                if (id == routeId.toInt()) {
                    transparency = 1
                    zIndex = -1
                    val boundsBuilder = LatLngBounds.Builder()
                    val coords = this.routeData?.get(routeId.toInt())?.getCoordList()
                    if (coords != null) {
                        coords.forEach(fun(coord: NaviLatLng){
                            boundsBuilder.include(LatLng(coord.getLatitude(), coord.getLongitude()))
                        }
                        )
                    }
                    val bounds = boundsBuilder.build()
                    arrowVisible = false
                    this.aMap?.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 150))
                }
                routeOverlay?.setArrowOnRoute(arrowVisible)
                routeOverlay?.setTransparency(transparency.toFloat())
                routeOverlay?.setZindex(zIndex)
                i++
            }
        }
    }
    open fun drawRoutes(routeId: Number, path: AMapNaviPath) {
        val routeOverLay: RouteOverLay = RouteOverLay(this.aMap!!, path, UTSAndroid.getUniActivity()!!)
        routeOverLay.setTrafficLine(true)
        routeOverLay.setArrowOnRoute(true)
        routeOverLay.setPassRouteVisible(true)
        routeOverLay.setZindex(-2)
        val transparency: Number = 0.4
        routeOverLay.setTransparency(transparency.toFloat())
        routeOverLay.addToMap()
        this.routeOverlays?.put(routeId.toInt(), routeOverLay)
    }
    open fun checkLocationPermission() {
        var permissions = utsArrayOf(
            "android.permission.ACCESS_FINE_LOCATION"
        )
        UTSAndroid.requestSystemPermission(UTSAndroid.getUniActivity()!!, permissions, fun(allRight: Boolean, grantedList: UTSArray<String>) {
            if (allRight) {
                console.log("用户同意了全部权限")
            } else {
                console.log("用户仅同意了 grantedList中的权限", grantedList)
            }
        }
            , fun(doNotAskAgain: Boolean, grantedList: UTSArray<String>) {
                console.log("用户拒绝了部分权限，仅允许了grantedList中的权限")
                if (doNotAskAgain) {
                    console.log("用户拒绝了权限，并且选择不再询问")
                }
            }
        )
    }
    open fun getLocation(options: SingleLocationOptions, successCallback: SuccessCallback) {
        getAmapOnceLocation(options, fun(res: LocationResult){
            this.aMap?.moveCamera(CameraUpdateFactory.changeLatLng(LatLng(res.latitude.toDouble(), res.longitude.toDouble())))
            MapStore.mapView?.getMap()?.moveCamera(CameraUpdateFactory.changeLatLng(LatLng(res.latitude.toDouble(), res.longitude.toDouble())))
            successCallback(res)
        }
        )
    }
    open fun startAwaysLocation(options: ContinueLocationOptions, successCallback: SuccessCallback) {
        startAmapLocation(options, fun(res: LocationResult){
            this.aMap?.moveCamera(CameraUpdateFactory.changeLatLng(LatLng(res.latitude.toDouble(), res.longitude.toDouble())))
            successCallback(res)
        }
        )
    }
    open fun stopAwaysLocation() {
        console.log("停止持续定位")
        stopLocation()
    }
    open fun destroy() {
        this.clearRoute()
        this.removeMarkers()
        this.aMap?.clear()
        this.aMap = null
        this.mAMapNavi?.removeAMapNaviListener(this.naviListener!!)
        this.mAMapNavi = null
        this.naviListener = null
        this.element = null
        this.options = null
        this.markers = null
        this.routeOverlays = null
        this.routeData = null
        console.log("destroy-map:", this.aMap)
    }
    open fun clearRoute() {
        run {
            var i: Int = 0
            while(i < (this.routeOverlays?.size() ?: 0 as Int)){
                val routeOverlay: RouteOverLay? = this.routeOverlays?.valueAt(i)
                routeOverlay?.removeFromMap()
                i++
            }
        }
        this.routeOverlays?.clear()
        this.routeData?.clear()
    }
    open fun calculate(navOption: AmapNavOption) {
        console.log("开始算路，配置：", navOption)
        this.clearRoute()
        if (navOption.carNumber != null && navOption.carNumber != "") {
            val carInfo: AMapCarInfo = AMapCarInfo()
            carInfo.setCarNumber(navOption.carNumber)
            carInfo.setRestriction(true)
            this.mAMapNavi?.setCarInfo(carInfo)
        }
        val mEndPoi = NaviPoi("目的地", LatLng(navOption.endLat.toDouble(), navOption.endLng.toDouble()), "")
        if (this.mAMapNavi != null) {
            val wayPoints: MutableList<NaviPoi> = UTSArray()
            var idx: Number = 0
            navOption.wayPoints.forEach(fun(point: UTSArray<Number>){
                val wayPoi = NaviPoi(idx + "", LatLng(point[0].toDouble(), point[1].toDouble()), "")
                wayPoints.add(wayPoi)
                idx++
            }
            )
            console.log("途经点数据：", wayPoints)
            val mStartPoi = NaviPoi("出发地", LatLng(navOption.startLat.toDouble(), navOption.startLng.toDouble()), "")
            this.mAMapNavi?.calculateDriveRoute(mStartPoi, mEndPoi, wayPoints, navOption.calcStrategy.toInt())
        }
    }
    open fun bindView() {
        AMapUtilCoreApi.setCollectInfoEnable(true)
        val context = UTSAndroid.getAppContext()!!
        this.mAMapNavi = AMapNavi.getInstance(context) as AMapNavi
        this.mAMapNavi?.setMultipleRouteNaviMode(false)
        this.mAMapNavi?.setTrafficInfoUpdateEnabled(true)
        var mapView = MapStore.mapView
        if (mapView == null) {
            console.log("创建mapView地图了=======")
            mapView = TextureMapView(context)
            mapView?.onCreate(Bundle())
            MapStore.mapView = mapView
        }
        this.element?.bindAndroidView(mapView!!)
        this.aMap = mapView.getMap()!! as AMap
        this.aMap?.setMapType(4)
        this.aMap?.setTrafficEnabled(true)
        this.aMap?.setMyLocationEnabled(this.options?.selfLocation ?: false)
        val myLocationStyle = MyLocationStyle()
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromBitmap(loadImageFromAssets("self-car.png")))
        myLocationStyle.radiusFillColor(Color.argb(0, 0, 0, 0))
        myLocationStyle.strokeColor(Color.argb(0, 0, 0, 0))
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE)
        this.aMap?.setMyLocationStyle(myLocationStyle)
        val mUiSettings = this.aMap?.getUiSettings()
        mUiSettings?.setMyLocationButtonEnabled(this.options?.showLocationBtn ?: false)
        mUiSettings?.setScaleControlsEnabled(true)
        mUiSettings?.setZoomControlsEnabled(false)
        this.mAMapNavi = AMapNavi.getInstance(context) as AMapNavi
        this.mAMapNavi?.setUseInnerVoice(true, true)
        this.naviListener = MyNaviListener(this.mAMapNavi, fun(res: RoutesData){
            this.routeData = res.data
            val data: UTSJSONObject = UTSJSONObject()
            res.data.forEach(fun(value: AMapNaviPath, key: Int){
                val paths: UTSArray<String> = utsArrayOf()
                value.getCoordList().forEach(fun(item: NaviLatLng){
                    paths.push(item.getLongitude() + "," + item.getLatitude())
                }
                )
                data[key] = object : UTSJSONObject() {
                    var allTime = value.getAllTime()
                    var allLength = value.getAllLength()
                    var trafficLightCount = value.getTrafficLightCount()
                    var paths = paths.join(";")
                }
                this.drawRoutes(key, value)
            }
            )
            this.options?.calcSuccessCb?.invoke(JSON.stringify(data))
        }
            , fun(){
                this.options?.arriveCb?.invoke()
            }
            , fun(){
                this.routeData?.clear()
            }
            , fun(data: NaviInfo){
                val arr: UTSArray<UTSJSONObject> = utsArrayOf()
                console.log("导航信息更新-sdk:", data)
                data.getToViaInfo()?.forEach(fun(item: AMapNaviToViaInfo){
                    arr.push(object : UTSJSONObject() {
                        var distance = item.getDistance()
                        var time = item.getTime()
                    })
                }
                )
                if (arr.length > 0) {
                    console.log("导航信息更新-多单:", data.getToViaInfo())
                } else {
                    console.log("导航信息更新一单:", ReflectionUtil)
                    arr.push(object : UTSJSONObject() {
                        var distance = ReflectionUtil.getProtectedField<Number>(data, "mRouteRemainDis")
                        var time = ReflectionUtil.getProtectedField<Number>(data, "mRouteRemainTime")
                    })
                }
                console.log("导航信息-arr:", arr)
                this.options?.naviInfoUpdateCb?.invoke(JSON.stringify(arr))
            }
        )
        this.mAMapNavi?.addAMapNaviListener(naviListener)
    }
}
open class NativeNavi {
    private var element: UniNativeViewElement? = null
    private var aMap: AMap? = null
    private var mAMapNavi: AMapNavi? = null
    private var markers: ArrayList<Marker>? = ArrayList()
    private var quitCb: QuitType? = null
    private var mNaviViewListener: MyNaviViewListener? = null
    constructor(element: UniNativeViewElement, quitCb: QuitType){
        this.element = element
        this.quitCb = quitCb
        this.bindView()
    }
    open fun stopNavi() {
        this.mAMapNavi?.stopSpeak()
        this.mAMapNavi?.stopNavi()
    }
    open fun destroy() {
        this.stopNavi()
        this.removeMarkers()
        this.aMap = null
        this.mAMapNavi = null
        this.markers = null
        this.mNaviViewListener = null
        this.element = null
        this.quitCb = null
        MapStore.mapNaviView?.setAMapNaviViewListener(null)
    }
    open fun addMarkers(markers: UTSArray<MarkerOption>) {
        val markerOptionsList: UTSArray<MarkerOptions> = utsArrayOf()
        markers.forEach(fun(marker: MarkerOption, _idx: Number, _arr: UTSArray<MarkerOption>){
            val markerOptions: MarkerOptions = MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(createCustomBitmap(marker.desc, "#" + marker.color, 200, 80))).position(LatLng(marker.latitude.toDouble(), marker.longitude.toDouble())).setFlat(false).snippet(marker.desc).infoWindowEnable(false).anchor(UTSNumber.from(0.5).toFloat(), UTSNumber.from(0.5).toFloat()).zIndex(UTSNumber.from(999999999999).toFloat())
            markerOptionsList.push(markerOptions)
        }
        )
        this.markers = this.aMap?.addMarkers(markerOptionsList, false) as ArrayList<Marker>
    }
    open fun removeMarkers() {
        this.markers?.forEach(fun(marker){
            marker.remove()
        }
        )
        this.markers?.clear()
    }
    open fun playTTS(text: String, forcePlay: Boolean) {
        this.mAMapNavi?.playTTS(text, forcePlay)
    }
    open fun setShowMode(mode: Int) {
        MapStore.mapNaviView?.setShowMode(mode)
    }
    open fun bindView() {
        NaviSetting.updatePrivacyShow(UTSAndroid.getAppContext()!!, true, true)
        NaviSetting.updatePrivacyAgree(UTSAndroid.getAppContext()!!, true)
        val activity = this.element?.getAndroidActivity()
        this.mNaviViewListener = MyNaviViewListener(fun(){
            this.stopNavi()
            this.quitCb?.invoke()
        }
        )
        this.mAMapNavi = AMapNavi.getInstance(activity!!) as AMapNavi
        val naviMapViewOption: AMapNaviViewOptions = AMapNaviViewOptions()
        naviMapViewOption.setSettingMenuEnabled(false)
        var mapNaviView = MapStore.mapNaviView
        if (mapNaviView == null) {
            console.log("创建mapNaviView地图了=======")
            mapNaviView = AMapNaviView(activity, naviMapViewOption)
            mapNaviView?.onCreate(Bundle())
            MapStore.mapNaviView = mapNaviView
        }
        mapNaviView.getViewOptions().setAutoDisplayOverview(true)
        mapNaviView.getViewOptions().setSettingMenuEnabled(false)
        mapNaviView.getViewOptions().setMapStyle(MapStyle.DAY, "")
        mapNaviView.getViewOptions().setTrafficLayerEnabled(true)
        mapNaviView.getViewOptions().setLaneInfoShow(true)
        mapNaviView.setShowTrafficLightView(true)
        mapNaviView.setShowDriveCongestion(true)
        mapNaviView.setTrafficLightsVisible(true)
        mapNaviView.setAMapNaviViewListener(this.mNaviViewListener!!)
        this.aMap = mapNaviView?.getMap()
        this.element?.bindAndroidView(mapNaviView!!)
    }
}
