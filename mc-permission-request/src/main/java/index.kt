@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.mcPermissionRequest
import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.core.content.ContextCompat
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
val ERRORCODE_GET_NOT_EMPTY = "-2"
val ERRORCODE_CHECK_FAILED = "-3"
open class RequestFailed (
    @JsonNotNull
    open var errorMsg: String,
    @JsonNotNull
    open var errorCode: String,
) : UTSObject()
open class RequestResult (
    @JsonNotNull
    open var msg: String,
    @JsonNotNull
    open var allRight: Boolean = false,
    @JsonNotNull
    open var grantList: UTSArray<String>,
) : UTSObject()
open class PermissionCallback (
    open var success: ((res: RequestResult) -> Unit)? = null,
    open var fail: ((res: RequestFailed) -> Unit)? = null,
    open var complete: (() -> Unit)? = null,
) : UTSObject()
val checkGrantedNotice = fun(): Boolean {
    return UTSAndroid.checkSystemPermissionGranted(UTSAndroid.getUniActivity()!!, utsArrayOf(
        Manifest.permission.POST_NOTIFICATIONS
    ))
}
val checkGrantedLocation = fun(): Boolean {
    return UTSAndroid.checkSystemPermissionGranted(UTSAndroid.getUniActivity()!!, utsArrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION
    )) || UTSAndroid.checkSystemPermissionGranted(UTSAndroid.getUniActivity()!!, utsArrayOf(
        Manifest.permission.ACCESS_BACKGROUND_LOCATION
    )) || UTSAndroid.checkSystemPermissionGranted(UTSAndroid.getUniActivity()!!, utsArrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION
    ))
}
val checkGrantedCamera = fun(): Boolean {
    return UTSAndroid.checkSystemPermissionGranted(UTSAndroid.getUniActivity()!!, utsArrayOf(
        Manifest.permission.CAMERA
    ))
}
val checkGrantedPhoto = fun(): Boolean {
    return UTSAndroid.checkSystemPermissionGranted(UTSAndroid.getUniActivity()!!, utsArrayOf(
        Manifest.permission.READ_MEDIA_IMAGES
    ))
}
val permissionsRequest = fun(permissionType: String, cbMap: PermissionCallback){
    if (UTSAndroid.getSystemPermissionDenied(UTSAndroid.getUniActivity()!!, utsArrayOf(
            permissionType
        )).isEmpty()) {
        cbMap.success?.invoke(RequestResult(msg = "权限已经全部授权，无需再申请", allRight = true, grantList = utsArrayOf(
            permissionType
        )))
        cbMap.complete?.invoke()
        return
    }
    UTSAndroid.requestSystemPermission(UTSAndroid.getUniActivity()!!, utsArrayOf(
        permissionType
    ), fun(allRight: Boolean, _: UTSArray<String>) {
        if (!UTSAndroid.getSystemPermissionDenied(UTSAndroid.getUniActivity()!!, utsArrayOf(
                permissionType
            )).isEmpty()) {
            cbMap.fail?.invoke(RequestFailed(errorMsg = "权限请求完成,getSystemPermissionDenied 失败,授权未完成", errorCode = ERRORCODE_GET_NOT_EMPTY))
            cbMap.complete?.invoke()
            return
        }
        if (!UTSAndroid.checkSystemPermissionGranted(UTSAndroid.getUniActivity()!!, utsArrayOf(
                permissionType
            ))) {
            cbMap.fail?.invoke(RequestFailed(errorMsg = "权限请求完成,checkSystemPermissionGranted 失败,授权未完成", errorCode = ERRORCODE_CHECK_FAILED))
            cbMap.complete?.invoke()
            return
        }
        cbMap.success?.invoke(RequestResult(msg = "权限申请成功", allRight = true, grantList = utsArrayOf(
            permissionType
        )))
        cbMap.complete?.invoke()
    }
        , fun(_: Boolean, _2: UTSArray<String>) {})
}
val BRAND_XIAOMI = "xiaomi"
val BRAND_HUAWEI = "huawei"
val BRAND_HONOR = "honor"
val BRAND_VIVO = "vivo"
val BRAND_OPPO = "oppo"
fun requestNotificationPermission(): Unit {
    val context = UTSAndroid.getAppContext() as Context
    val activity = UTSAndroid.getUniActivity() as Activity
    console.log("进入 requestNotificationPermission==============", Build.VERSION.SDK_INT)
    if (activity.isFinishing()) {
        console.error("Activity is not available or is finishing")
        return
    }
    var brand = ""
    if (Build.BRAND != null) {
        brand = Build.BRAND.toLowerCase()
    }
    if (Build.VERSION.SDK_INT >= 33) {
        val permission = Manifest.permission.POST_NOTIFICATIONS
        if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
            uni_showToast(ShowToastOptions(title = "已获得通知权限", icon = "none"))
            console.log("已获得通知权限==============")
            return
        }
        showPermissionDialog(activity, brand)
    } else {
        if (brand == BRAND_XIAOMI || brand == BRAND_HUAWEI || brand == BRAND_VIVO || brand == BRAND_OPPO) {
            showPermissionDialog(activity, brand)
        } else {
            uni_showToast(ShowToastOptions(title = "系统已自动授予通知权限", icon = "none"))
        }
    }
}
fun showPermissionDialog(activity: Activity, brand: String): Unit {
    val builder = AlertDialog.Builder(activity)
    builder.setTitle("需要通知权限").setMessage("请允许通知权限，以便及时接收重要消息").setPositiveButton("去开启", fun(dialog: DialogInterface, which: Number){
        goToNotificationSettings(activity, brand)
    }
    ).setNegativeButton("取消", fun(dialog: DialogInterface, which: Number){}).setCancelable(false)
    if (brand === BRAND_XIAOMI || brand === BRAND_VIVO) {
        builder.setNeutralButton("系统设置", fun(dialog: DialogInterface, which: Number){
            goToSystemNotificationSettings(activity, brand)
        }
        )
    }
    val dialog = builder.create()
    dialog.show()
    try {
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(Color.parseColor("#536FA6"))
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#6C6C6C"))
        if (brand === BRAND_XIAOMI || brand === BRAND_VIVO) {
            dialog.getButton(DialogInterface.BUTTON_NEUTRAL).setTextColor(Color.parseColor("#536FA6"))
        }
    }
    catch (e: Throwable) {
        console.log("设置对话框按钮颜色失败", e)
    }
}
fun goToNotificationSettings(activity: Activity, brand: String): Unit {
    try {
        val intent = Intent()
        console.log("goToNotificationSettings == > getPackageName ", activity.getPackageName())
        when (brand) {
            BRAND_XIAOMI ->
            {
                intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
                intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName())
            }
            BRAND_HUAWEI ->
            {
                intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
                intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName())
                intent.putExtra("app_uid", activity.getApplicationInfo().uid)
                intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
                intent.putExtra("app_package", activity.getPackageName())
                intent.putExtra("app_uid", activity.getApplicationInfo().uid)
            }
            BRAND_HONOR ->
            {
                intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
                intent.putExtra("app_package", activity.getPackageName())
                intent.putExtra("app_uid", activity.getApplicationInfo().uid)
            }
            BRAND_VIVO ->
            {
                intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
                intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName())
            }
            BRAND_OPPO ->
            {
                intent.action = "com.oppo.safe.permission.notification.APP_NOTIFICATION_SETTINGS"
                intent.putExtra("packageName", activity.getPackageName())
            }
            else ->
                if (Build.VERSION.SDK_INT >= 26) {
                    intent.action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
                    intent.putExtra(Settings.EXTRA_APP_PACKAGE, activity.getPackageName())
                } else {
                    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                    intent.data = Uri.parse("package:" + activity.getPackageName())
                }
        }
        activity.startActivity(intent)
    }
    catch (e: Throwable) {
        console.error("跳转到应用通知设置失败", e.message)
        try {
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            intent.data = Uri.parse("package:" + activity.getPackageName())
            activity.startActivity(intent)
        }
        catch (e2: Throwable) {
            console.error("跳转到应用详情页失败", e2.message)
            uni_showToast(ShowToastOptions(title = "无法打开设置，请手动设置", icon = "none"))
        }
    }
}
fun goToSystemNotificationSettings(activity: Activity, brand: String): Unit {
    try {
        val intent = Intent()
        if (brand === BRAND_XIAOMI) {
            intent.setClassName("com.android.settings", "com.android.settings.Settings\$NotificationFilterActivity")
        } else if (brand === BRAND_VIVO) {
            intent.action = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"
        }
        if (intent.getComponent() != null || intent.getAction() != null) {
            activity.startActivity(intent)
        } else {
            goToNotificationSettings(activity, brand)
        }
    }
    catch (e: Throwable) {
        console.error("跳转到系统通知设置失败", e.message)
        goToNotificationSettings(activity, brand)
    }
}
