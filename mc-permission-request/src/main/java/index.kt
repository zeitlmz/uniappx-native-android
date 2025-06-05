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
open class AndroidPermission (
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var description: String,
) : UTSObject()
typealias AndroidPermissionMap = Map<String, AndroidPermission>
open class PermissionOption (
    open var message: String? = null,
    open var showDialog: Boolean? = null,
    open var onDenied: String? = null,
) : UTSObject()
open class AndroidPermissionKeys (
    @JsonNotNull
    open var ACCESS_CHECKIN_PROPERTIES: String,
    @JsonNotNull
    open var ACCESS_COARSE_LOCATION: String,
    @JsonNotNull
    open var ACCESS_FINE_LOCATION: String,
    @JsonNotNull
    open var ACCESS_LOCATION_EXTRA_COMMANDS: String,
    @JsonNotNull
    open var ACCESS_MOCK_LOCATION: String,
    @JsonNotNull
    open var ACCESS_NETWORK_STATE: String,
    @JsonNotNull
    open var ACCESS_SURFACE_FLINGER: String,
    @JsonNotNull
    open var ACCESS_WIFI_STATE: String,
    @JsonNotNull
    open var ACCOUNT_MANAGER: String,
    @JsonNotNull
    open var AUTHENTICATE_ACCOUNTS: String,
    @JsonNotNull
    open var BATTERY_STATS: String,
    @JsonNotNull
    open var BIND_APPWIDGET: String,
    @JsonNotNull
    open var BIND_DEVICE_ADMIN: String,
    @JsonNotNull
    open var BIND_INPUT_METHOD: String,
    @JsonNotNull
    open var BIND_REMOTEVIEWS: String,
    @JsonNotNull
    open var BIND_WALLPAPER: String,
    @JsonNotNull
    open var BLUETOOTH: String,
    @JsonNotNull
    open var BLUETOOTH_ADMIN: String,
    @JsonNotNull
    open var BRICK: String,
    @JsonNotNull
    open var BROADCAST_PACKAGE_REMOVED: String,
    @JsonNotNull
    open var BROADCAST_SMS: String,
    @JsonNotNull
    open var BROADCAST_STICKY: String,
    @JsonNotNull
    open var BROADCAST_WAP_PUSH: String,
    @JsonNotNull
    open var CALL_PHONE: String,
    @JsonNotNull
    open var CALL_PRIVILEGED: String,
    @JsonNotNull
    open var CAMERA: String,
    @JsonNotNull
    open var CHANGE_COMPONENT_ENABLED_STATE: String,
    @JsonNotNull
    open var CHANGE_CONFIGURATION: String,
    @JsonNotNull
    open var CHANGE_NETWORK_STATE: String,
    @JsonNotNull
    open var CHANGE_WIFI_MULTICAST_STATE: String,
    @JsonNotNull
    open var CHANGE_WIFI_STATE: String,
    @JsonNotNull
    open var CLEAR_APP_CACHE: String,
    @JsonNotNull
    open var CLEAR_APP_USER_DATA: String,
    @JsonNotNull
    open var CWJ_GROUP: String,
    @JsonNotNull
    open var CELL_PHONE_MASTER_EX: String,
    @JsonNotNull
    open var CONTROL_LOCATION_UPDATES: String,
    @JsonNotNull
    open var DELETE_CACHE_FILES: String,
    @JsonNotNull
    open var DELETE_PACKAGES: String,
    @JsonNotNull
    open var DEVICE_POWER: String,
    @JsonNotNull
    open var DIAGNOSTIC: String,
    @JsonNotNull
    open var DISABLE_KEYGUARD: String,
    @JsonNotNull
    open var DUMP: String,
    @JsonNotNull
    open var EXPAND_STATUS_BAR: String,
    @JsonNotNull
    open var FACTORY_TEST: String,
    @JsonNotNull
    open var FLASHLIGHT: String,
    @JsonNotNull
    open var FORCE_BACK: String,
    @JsonNotNull
    open var GET_ACCOUNTS: String,
    @JsonNotNull
    open var GET_PACKAGE_SIZE: String,
    @JsonNotNull
    open var GET_TASKS: String,
    @JsonNotNull
    open var GLOBAL_SEARCH: String,
    @JsonNotNull
    open var HARDWARE_TEST: String,
    @JsonNotNull
    open var INJECT_EVENTS: String,
    @JsonNotNull
    open var INSTALL_LOCATION_PROVIDER: String,
    @JsonNotNull
    open var INSTALL_PACKAGES: String,
    @JsonNotNull
    open var INTERNAL_SYSTEM_WINDOW: String,
    @JsonNotNull
    open var INTERNET: String,
    @JsonNotNull
    open var KILL_BACKGROUND_PROCESSES: String,
    @JsonNotNull
    open var MANAGE_ACCOUNTS: String,
    @JsonNotNull
    open var MANAGE_APP_TOKENS: String,
    @JsonNotNull
    open var MTWEAK_USER: String,
    @JsonNotNull
    open var MTWEAK_FORUM: String,
    @JsonNotNull
    open var MASTER_CLEAR: String,
    @JsonNotNull
    open var MODIFY_AUDIO_SETTINGS: String,
    @JsonNotNull
    open var MODIFY_PHONE_STATE: String,
    @JsonNotNull
    open var MOUNT_FORMAT_FILESYSTEMS: String,
    @JsonNotNull
    open var MOUNT_UNMOUNT_FILESYSTEMS: String,
    @JsonNotNull
    open var NFC: String,
    @JsonNotNull
    open var PERSISTENT_ACTIVITY: String,
    @JsonNotNull
    open var PROCESS_OUTGOING_CALLS: String,
    @JsonNotNull
    open var READ_CALENDAR: String,
    @JsonNotNull
    open var READ_CONTACTS: String,
    @JsonNotNull
    open var READ_FRAME_BUFFER: String,
    @JsonNotNull
    open var READ_HISTORY_BOOKMARKS: String,
    @JsonNotNull
    open var READ_INPUT_STATE: String,
    @JsonNotNull
    open var READ_LOGS: String,
    @JsonNotNull
    open var READ_PHONE_STATE: String,
    @JsonNotNull
    open var READ_SMS: String,
    @JsonNotNull
    open var READ_SYNC_SETTINGS: String,
    @JsonNotNull
    open var READ_SYNC_STATS: String,
    @JsonNotNull
    open var REBOOT: String,
    @JsonNotNull
    open var RECEIVE_BOOT_COMPLETED: String,
    @JsonNotNull
    open var RECEIVE_MMS: String,
    @JsonNotNull
    open var RECEIVE_SMS: String,
    @JsonNotNull
    open var RECEIVE_WAP_PUSH: String,
    @JsonNotNull
    open var RECORD_AUDIO: String,
    @JsonNotNull
    open var REORDER_TASKS: String,
    @JsonNotNull
    open var RESTART_PACKAGES: String,
    @JsonNotNull
    open var SEND_SMS: String,
    @JsonNotNull
    open var SET_ACTIVITY_WATCHER: String,
    @JsonNotNull
    open var SET_ALARM: String,
    @JsonNotNull
    open var SET_ALWAYS_FINISH: String,
    @JsonNotNull
    open var SET_ANIMATION_SCALE: String,
    @JsonNotNull
    open var SET_DEBUG_APP: String,
    @JsonNotNull
    open var SET_ORIENTATION: String,
    @JsonNotNull
    open var SET_PREFERRED_APPLICATIONS: String,
    @JsonNotNull
    open var SET_PROCESS_LIMIT: String,
    @JsonNotNull
    open var SET_TIME: String,
    @JsonNotNull
    open var SET_TIME_ZONE: String,
    @JsonNotNull
    open var SET_WALLPAPER: String,
    @JsonNotNull
    open var SET_WALLPAPER_HINTS: String,
    @JsonNotNull
    open var SIGNAL_PERSISTENT_PROCESSES: String,
    @JsonNotNull
    open var STATUS_BAR: String,
    @JsonNotNull
    open var SUBSCRIBED_FEEDS_READ: String,
    @JsonNotNull
    open var SUBSCRIBED_FEEDS_WRITE: String,
    @JsonNotNull
    open var SYSTEM_ALERT_WINDOW: String,
    @JsonNotNull
    open var UPDATE_DEVICE_STATS: String,
    @JsonNotNull
    open var USE_CREDENTIALS: String,
    @JsonNotNull
    open var USE_SIP: String,
    @JsonNotNull
    open var VIBRATE: String,
    @JsonNotNull
    open var WAKE_LOCK: String,
    @JsonNotNull
    open var WRITE_APN_SETTINGS: String,
    @JsonNotNull
    open var WRITE_CALENDAR: String,
    @JsonNotNull
    open var WRITE_CONTACTS: String,
    @JsonNotNull
    open var WRITE_EXTERNAL_STORAGE: String,
    @JsonNotNull
    open var WRITE_GSERVICES: String,
    @JsonNotNull
    open var WRITE_HISTORY_BOOKMARKS: String,
    @JsonNotNull
    open var WRITE_SECURE_SETTINGS: String,
    @JsonNotNull
    open var WRITE_SETTINGS: String,
    @JsonNotNull
    open var WRITE_SMS: String,
    @JsonNotNull
    open var NOTIFICATIONS: String,
) : UTSObject()
val ANDROID_PERMISSIONS: AndroidPermissionMap = Map(utsArrayOf(
    utsArrayOf(
        "ACCESS_CHECKIN_PROPERTIES",
        object : UTSJSONObject() {
            var name = "android.permission.ACCESS_CHECKIN_PROPERTIES"
            var description = "访问登记属性 - 读取或写入登记check-in数据库属性表的权限"
        }
    ),
    utsArrayOf(
        "ACCESS_COARSE_LOCATION",
        object : UTSJSONObject() {
            var name = "android.permission.ACCESS_COARSE_LOCATION"
            var description = "获取错略位置 - 通过WiFi或移动基站的方式获取用户错略的经纬度信息,定位精度大概误差在30~1500米"
        }
    ),
    utsArrayOf(
        "ACCESS_FINE_LOCATION",
        object : UTSJSONObject() {
            var name = "android.permission.ACCESS_FINE_LOCATION"
            var description = "获取精确位置 - 通过GPS芯片接收卫星的定位信息,定位精度达10米以内"
        }
    ),
    utsArrayOf(
        "ACCESS_LOCATION_EXTRA_COMMANDS",
        object : UTSJSONObject() {
            var name = "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS"
            var description = "访问定位额外命令 - 允许程序访问额外的定位提供者指令"
        }
    ),
    utsArrayOf(
        "ACCESS_MOCK_LOCATION",
        object : UTSJSONObject() {
            var name = "android.permission.ACCESS_MOCK_LOCATION"
            var description = "获取模拟定位信息 - 获取模拟定位信息,一般用于帮助开发者调试应用"
        }
    ),
    utsArrayOf(
        "ACCESS_NETWORK_STATE",
        object : UTSJSONObject() {
            var name = "android.permission.ACCESS_NETWORK_STATE"
            var description = "获取网络状态 - 获取网络信息状态,如当前的网络连接是否有效"
        }
    ),
    utsArrayOf(
        "ACCESS_SURFACE_FLINGER",
        object : UTSJSONObject() {
            var name = "android.permission.ACCESS_SURFACE_FLINGER"
            var description = "访问Surface Flinger - Android平台上底层的图形显示支持,一般用于游戏或照相机预览界面和底层模式的屏幕截图"
        }
    ),
    utsArrayOf(
        "ACCESS_WIFI_STATE",
        object : UTSJSONObject() {
            var name = "android.permission.ACCESS_WIFI_STATE"
            var description = "获取WiFi状态 - 获取当前WiFi接入的状态以及WLAN热点的信息"
        }
    ),
    utsArrayOf(
        "ACCOUNT_MANAGER",
        object : UTSJSONObject() {
            var name = "android.permission.ACCOUNT_MANAGER"
            var description = "账户管理 - 获取账户验证信息,主要为GMail账户信息,只有系统级进程才能访问的权限"
        }
    ),
    utsArrayOf(
        "AUTHENTICATE_ACCOUNTS",
        object : UTSJSONObject() {
            var name = "android.permission.AUTHENTICATE_ACCOUNTS"
            var description = "验证账户 - 允许一个程序通过账户验证方式访问账户管理ACCOUNT_MANAGER相关信息"
        }
    ),
    utsArrayOf(
        "BATTERY_STATS",
        object : UTSJSONObject() {
            var name = "android.permission.BATTERY_STATS"
            var description = "电量统计 - 获取电池电量统计信息"
        }
    ),
    utsArrayOf(
        "BIND_APPWIDGET",
        object : UTSJSONObject() {
            var name = "android.permission.BIND_APPWIDGET"
            var description = "绑定小插件 - 允许一个程序告诉appWidget服务需要访问小插件的数据库,只有非常少的应用才用到此权限"
        }
    ),
    utsArrayOf(
        "BIND_DEVICE_ADMIN",
        object : UTSJSONObject() {
            var name = "android.permission.BIND_DEVICE_ADMIN"
            var description = "绑定设备管理 - 请求系统管理员接收者receiver,只有系统才能使用"
        }
    ),
    utsArrayOf(
        "BIND_INPUT_METHOD",
        object : UTSJSONObject() {
            var name = "android.permission.BIND_INPUT_METHOD"
            var description = "绑定输入法 - 请求InputMethodService服务,只有系统才能使用"
        }
    ),
    utsArrayOf(
        "BIND_REMOTEVIEWS",
        object : UTSJSONObject() {
            var name = "android.permission.BIND_REMOTEVIEWS"
            var description = "绑定RemoteView - 必须通过RemoteViewsService服务来请求,只有系统才能用"
        }
    ),
    utsArrayOf(
        "BIND_WALLPAPER",
        object : UTSJSONObject() {
            var name = "android.permission.BIND_WALLPAPER"
            var description = "绑定壁纸 - 必须通过WallpaperService服务来请求,只有系统才能用"
        }
    ),
    utsArrayOf(
        "BLUETOOTH",
        object : UTSJSONObject() {
            var name = "android.permission.BLUETOOTH"
            var description = "使用蓝牙 - 允许程序连接配对过的蓝牙设备"
        }
    ),
    utsArrayOf(
        "BLUETOOTH_ADMIN",
        object : UTSJSONObject() {
            var name = "android.permission.BLUETOOTH_ADMIN"
            var description = "蓝牙管理 - 允许程序进行发现和配对新的蓝牙设备"
        }
    ),
    utsArrayOf(
        "BRICK",
        object : UTSJSONObject() {
            var name = "android.permission.BRICK"
            var description = "变成砖头 - 能够禁用手机,非常危险,顾名思义就是让手机变成砖头"
        }
    ),
    utsArrayOf(
        "BROADCAST_PACKAGE_REMOVED",
        object : UTSJSONObject() {
            var name = "android.permission.BROADCAST_PACKAGE_REMOVED"
            var description = "应用删除时广播 - 当一个应用在删除时触发一个广播"
        }
    ),
    utsArrayOf(
        "BROADCAST_SMS",
        object : UTSJSONObject() {
            var name = "android.permission.BROADCAST_SMS"
            var description = "收到短信时广播 - 当收到短信时触发一个广播"
        }
    ),
    utsArrayOf(
        "BROADCAST_STICKY",
        object : UTSJSONObject() {
            var name = "android.permission.BROADCAST_STICKY"
            var description = "连续广播 - 允许一个程序收到广播后快速收到下一个广播"
        }
    ),
    utsArrayOf(
        "BROADCAST_WAP_PUSH",
        object : UTSJSONObject() {
            var name = "android.permission.BROADCAST_WAP_PUSH"
            var description = "WAP PUSH广播 - WAP PUSH服务收到后触发一个广播"
        }
    ),
    utsArrayOf(
        "CALL_PHONE",
        object : UTSJSONObject() {
            var name = "android.permission.CALL_PHONE"
            var description = "拨打电话 - 允许程序从非系统拨号器里输入电话号码"
        }
    ),
    utsArrayOf(
        "CALL_PRIVILEGED",
        object : UTSJSONObject() {
            var name = "android.permission.CALL_PRIVILEGED"
            var description = "通话权限 - 允许程序拨打电话,替换系统的拨号器界面"
        }
    ),
    utsArrayOf(
        "CAMERA",
        object : UTSJSONObject() {
            var name = "android.permission.CAMERA"
            var description = "拍照权限 - 允许访问摄像头进行拍照"
        }
    ),
    utsArrayOf(
        "CHANGE_COMPONENT_ENABLED_STATE",
        object : UTSJSONObject() {
            var name = "android.permission.CHANGE_COMPONENT_ENABLED_STATE"
            var description = "改变组件状态 - 改变组件是否启用状态"
        }
    ),
    utsArrayOf(
        "CHANGE_CONFIGURATION",
        object : UTSJSONObject() {
            var name = "android.permission.CHANGE_CONFIGURATION"
            var description = "改变配置 - 允许当前应用改变配置,如定位"
        }
    ),
    utsArrayOf(
        "CHANGE_NETWORK_STATE",
        object : UTSJSONObject() {
            var name = "android.permission.CHANGE_NETWORK_STATE"
            var description = "改变网络状态 - 改变网络状态如是否能联网"
        }
    ),
    utsArrayOf(
        "CHANGE_WIFI_MULTICAST_STATE",
        object : UTSJSONObject() {
            var name = "android.permission.CHANGE_WIFI_MULTICAST_STATE"
            var description = "改变WiFi多播状态 - 改变WiFi多播状态"
        }
    ),
    utsArrayOf(
        "CHANGE_WIFI_STATE",
        object : UTSJSONObject() {
            var name = "android.permission.CHANGE_WIFI_STATE"
            var description = "改变WiFi状态 - 改变WiFi状态"
        }
    ),
    utsArrayOf(
        "CLEAR_APP_CACHE",
        object : UTSJSONObject() {
            var name = "android.permission.CLEAR_APP_CACHE"
            var description = "清除应用缓存 - 清除应用缓存"
        }
    ),
    utsArrayOf(
        "CLEAR_APP_USER_DATA",
        object : UTSJSONObject() {
            var name = "android.permission.CLEAR_APP_USER_DATA"
            var description = "清除用户数据 - 清除应用的用户数据"
        }
    ),
    utsArrayOf(
        "CWJ_GROUP",
        object : UTSJSONObject() {
            var name = "android.permission.CWJ_GROUP"
            var description = "底层访问权限 - 允许CWJ账户组访问底层信息"
        }
    ),
    utsArrayOf(
        "CELL_PHONE_MASTER_EX",
        object : UTSJSONObject() {
            var name = "android.permission.CELL_PHONE_MASTER_EX"
            var description = "手机优化大师扩展权限 - 手机优化大师扩展权限"
        }
    ),
    utsArrayOf(
        "CONTROL_LOCATION_UPDATES",
        object : UTSJSONObject() {
            var name = "android.permission.CONTROL_LOCATION_UPDATES"
            var description = "控制定位更新 - 允许获得移动网络定位信息改变"
        }
    ),
    utsArrayOf(
        "DELETE_CACHE_FILES",
        object : UTSJSONObject() {
            var name = "android.permission.DELETE_CACHE_FILES"
            var description = "删除缓存文件 - 允许应用删除缓存文件"
        }
    ),
    utsArrayOf(
        "DELETE_PACKAGES",
        object : UTSJSONObject() {
            var name = "android.permission.DELETE_PACKAGES"
            var description = "删除应用 - 允许程序删除应用"
        }
    ),
    utsArrayOf(
        "DEVICE_POWER",
        object : UTSJSONObject() {
            var name = "android.permission.DEVICE_POWER"
            var description = "电源管理 - 允许访问底层电源管理"
        }
    ),
    utsArrayOf(
        "DIAGNOSTIC",
        object : UTSJSONObject() {
            var name = "android.permission.DIAGNOSTIC"
            var description = "应用诊断 - 允许程序到RW到诊断资源"
        }
    ),
    utsArrayOf(
        "DISABLE_KEYGUARD",
        object : UTSJSONObject() {
            var name = "android.permission.DISABLE_KEYGUARD"
            var description = "禁用键盘锁 - 允许程序禁用键盘锁"
        }
    ),
    utsArrayOf(
        "DUMP",
        object : UTSJSONObject() {
            var name = "android.permission.DUMP"
            var description = "转存系统信息 - 允许程序获取系统dump信息从系统服务"
        }
    ),
    utsArrayOf(
        "EXPAND_STATUS_BAR",
        object : UTSJSONObject() {
            var name = "android.permission.EXPAND_STATUS_BAR"
            var description = "状态栏控制 - 允许程序扩展或收缩状态栏"
        }
    ),
    utsArrayOf(
        "FACTORY_TEST",
        object : UTSJSONObject() {
            var name = "android.permission.FACTORY_TEST"
            var description = "工厂测试模式 - 允许程序运行工厂测试模式"
        }
    ),
    utsArrayOf(
        "FLASHLIGHT",
        object : UTSJSONObject() {
            var name = "android.permission.FLASHLIGHT"
            var description = "使用闪光灯 - 允许访问闪光灯"
        }
    ),
    utsArrayOf(
        "FORCE_BACK",
        object : UTSJSONObject() {
            var name = "android.permission.FORCE_BACK"
            var description = "强制后退 - 允许程序强制使用back后退按键,无论Activity是否在顶层"
        }
    ),
    utsArrayOf(
        "GET_ACCOUNTS",
        object : UTSJSONObject() {
            var name = "android.permission.GET_ACCOUNTS"
            var description = "访问账户Gmail列表 - 访问GMail账户列表"
        }
    ),
    utsArrayOf(
        "GET_PACKAGE_SIZE",
        object : UTSJSONObject() {
            var name = "android.permission.GET_PACKAGE_SIZE"
            var description = "获取应用大小 - 获取应用的文件大小"
        }
    ),
    utsArrayOf(
        "GET_TASKS",
        object : UTSJSONObject() {
            var name = "android.permission.GET_TASKS"
            var description = "获取任务信息 - 允许程序获取当前或最近运行的应用"
        }
    ),
    utsArrayOf(
        "GLOBAL_SEARCH",
        object : UTSJSONObject() {
            var name = "android.permission.GLOBAL_SEARCH"
            var description = "允许全局搜索 - 允许程序使用全局搜索功能"
        }
    ),
    utsArrayOf(
        "HARDWARE_TEST",
        object : UTSJSONObject() {
            var name = "android.permission.HARDWARE_TEST"
            var description = "硬件测试 - 访问硬件辅助设备,用于硬件测试"
        }
    ),
    utsArrayOf(
        "INJECT_EVENTS",
        object : UTSJSONObject() {
            var name = "android.permission.INJECT_EVENTS"
            var description = "注射事件 - 允许访问本程序的底层事件,获取按键、轨迹球的事件流"
        }
    ),
    utsArrayOf(
        "INSTALL_LOCATION_PROVIDER",
        object : UTSJSONObject() {
            var name = "android.permission.INSTALL_LOCATION_PROVIDER"
            var description = "安装定位提供 - 安装定位提供"
        }
    ),
    utsArrayOf(
        "INSTALL_PACKAGES",
        object : UTSJSONObject() {
            var name = "android.permission.INSTALL_PACKAGES"
            var description = "安装应用程序 - 允许程序安装应用"
        }
    ),
    utsArrayOf(
        "INTERNAL_SYSTEM_WINDOW",
        object : UTSJSONObject() {
            var name = "android.permission.INTERNAL_SYSTEM_WINDOW"
            var description = "内部系统窗口 - 允许程序打开内部窗口,不对第三方应用程序开放此权限"
        }
    ),
    utsArrayOf(
        "INTERNET",
        object : UTSJSONObject() {
            var name = "android.permission.INTERNET"
            var description = "访问网络 - 访问网络连接,可能产生GPRS流量"
        }
    ),
    utsArrayOf(
        "KILL_BACKGROUND_PROCESSES",
        object : UTSJSONObject() {
            var name = "android.permission.KILL_BACKGROUND_PROCESSES"
            var description = "结束后台进程 - 允许程序调用killBackgroundProcesses(String).方法结束后台进程"
        }
    ),
    utsArrayOf(
        "MANAGE_ACCOUNTS",
        object : UTSJSONObject() {
            var name = "android.permission.MANAGE_ACCOUNTS"
            var description = "管理账户 - 允许程序管理AccountManager中的账户列表"
        }
    ),
    utsArrayOf(
        "MANAGE_APP_TOKENS",
        object : UTSJSONObject() {
            var name = "android.permission.MANAGE_APP_TOKENS"
            var description = "管理程序引用 - 管理创建、摧毁、Z轴顺序,仅用于系统"
        }
    ),
    utsArrayOf(
        "MTWEAK_USER",
        object : UTSJSONObject() {
            var name = "android.permission.MTWEAK_USER"
            var description = "高级权限 - 允许mTweak用户访问高级系统权限"
        }
    ),
    utsArrayOf(
        "MTWEAK_FORUM",
        object : UTSJSONObject() {
            var name = "android.permission.MTWEAK_FORUM"
            var description = "社区权限 - 允许使用mTweak社区权限"
        }
    ),
    utsArrayOf(
        "MASTER_CLEAR",
        object : UTSJSONObject() {
            var name = "android.permission.MASTER_CLEAR"
            var description = "软格式化 - 允许程序执行软格式化,删除系统配置信息"
        }
    ),
    utsArrayOf(
        "MODIFY_AUDIO_SETTINGS",
        object : UTSJSONObject() {
            var name = "android.permission.MODIFY_AUDIO_SETTINGS"
            var description = "修改声音设置 - 修改声音设置信息"
        }
    ),
    utsArrayOf(
        "MODIFY_PHONE_STATE",
        object : UTSJSONObject() {
            var name = "android.permission.MODIFY_PHONE_STATE"
            var description = "修改电话状态 - 修改电话状态,如飞行模式,但不包含替换系统拨号器界面"
        }
    ),
    utsArrayOf(
        "MOUNT_FORMAT_FILESYSTEMS",
        object : UTSJSONObject() {
            var name = "android.permission.MOUNT_FORMAT_FILESYSTEMS"
            var description = "格式化文件系统 - 格式化可移动文件系统,比如格式化清空SD卡"
        }
    ),
    utsArrayOf(
        "MOUNT_UNMOUNT_FILESYSTEMS",
        object : UTSJSONObject() {
            var name = "android.permission.MOUNT_UNMOUNT_FILESYSTEMS"
            var description = "挂载文件系统 - 挂载、反挂载外部文件系统"
        }
    ),
    utsArrayOf(
        "NFC",
        object : UTSJSONObject() {
            var name = "android.permission.NFC"
            var description = "允许NFC通讯 - 允许程序执行NFC近距离通讯操作,用于移动支持"
        }
    ),
    utsArrayOf(
        "PERSISTENT_ACTIVITY",
        object : UTSJSONObject() {
            var name = "android.permission.PERSISTENT_ACTIVITY"
            var description = "永久Activity - 创建一个永久的Activity,该功能标记为将来将被移除"
        }
    ),
    utsArrayOf(
        "PROCESS_OUTGOING_CALLS",
        object : UTSJSONObject() {
            var name = "android.permission.PROCESS_OUTGOING_CALLS"
            var description = "处理拨出电话 - 允许程序监视,修改或放弃播出电话"
        }
    ),
    utsArrayOf(
        "READ_CALENDAR",
        object : UTSJSONObject() {
            var name = "android.permission.READ_CALENDAR"
            var description = "读取日程提醒 - 允许程序读取用户的日程信息"
        }
    ),
    utsArrayOf(
        "READ_CONTACTS",
        object : UTSJSONObject() {
            var name = "android.permission.READ_CONTACTS"
            var description = "读取联系人 - 允许应用访问联系人通讯录信息"
        }
    ),
    utsArrayOf(
        "READ_FRAME_BUFFER",
        object : UTSJSONObject() {
            var name = "android.permission.READ_FRAME_BUFFER"
            var description = "屏幕截图 - 读取帧缓存用于屏幕截图"
        }
    ),
    utsArrayOf(
        "READ_HISTORY_BOOKMARKS",
        object : UTSJSONObject() {
            var name = "com.android.browser.permission.READ_HISTORY_BOOKMARKS"
            var description = "读取收藏夹和历史记录 - 读取浏览器收藏夹和历史记录"
        }
    ),
    utsArrayOf(
        "READ_INPUT_STATE",
        object : UTSJSONObject() {
            var name = "android.permission.READ_INPUT_STATE"
            var description = "读取输入状态 - 读取当前键的输入状态,仅用于系统"
        }
    ),
    utsArrayOf(
        "READ_LOGS",
        object : UTSJSONObject() {
            var name = "android.permission.READ_LOGS"
            var description = "读取系统日志 - 读取系统底层日志"
        }
    ),
    utsArrayOf(
        "READ_PHONE_STATE",
        object : UTSJSONObject() {
            var name = "android.permission.READ_PHONE_STATE"
            var description = "读取电话状态 - 访问电话状态"
        }
    ),
    utsArrayOf(
        "READ_SMS",
        object : UTSJSONObject() {
            var name = "android.permission.READ_SMS"
            var description = "读取短信内容 - 读取短信内容"
        }
    ),
    utsArrayOf(
        "READ_SYNC_SETTINGS",
        object : UTSJSONObject() {
            var name = "android.permission.READ_SYNC_SETTINGS"
            var description = "读取同步设置 - 读取同步设置,读取Google在线同步设置"
        }
    ),
    utsArrayOf(
        "READ_SYNC_STATS",
        object : UTSJSONObject() {
            var name = "android.permission.READ_SYNC_STATS"
            var description = "读取同步状态 - 读取同步状态,获得Google在线同步状态"
        }
    ),
    utsArrayOf(
        "REBOOT",
        object : UTSJSONObject() {
            var name = "android.permission.REBOOT"
            var description = "重启设备 - 允许程序重新启动设备"
        }
    ),
    utsArrayOf(
        "RECEIVE_BOOT_COMPLETED",
        object : UTSJSONObject() {
            var name = "android.permission.RECEIVE_BOOT_COMPLETED"
            var description = "开机自动允许 - 允许程序开机自动运行"
        }
    ),
    utsArrayOf(
        "RECEIVE_MMS",
        object : UTSJSONObject() {
            var name = "android.permission.RECEIVE_MMS"
            var description = "接收彩信 - 接收彩信"
        }
    ),
    utsArrayOf(
        "RECEIVE_SMS",
        object : UTSJSONObject() {
            var name = "android.permission.RECEIVE_SMS"
            var description = "接收短信 - 接收短信"
        }
    ),
    utsArrayOf(
        "RECEIVE_WAP_PUSH",
        object : UTSJSONObject() {
            var name = "android.permission.RECEIVE_WAP_PUSH"
            var description = "接收Wap Push - 接收WAP PUSH信息"
        }
    ),
    utsArrayOf(
        "RECORD_AUDIO",
        object : UTSJSONObject() {
            var name = "android.permission.RECORD_AUDIO"
            var description = "录音 - 录制声音通过手机或耳机的麦克"
        }
    ),
    utsArrayOf(
        "REORDER_TASKS",
        object : UTSJSONObject() {
            var name = "android.permission.REORDER_TASKS"
            var description = "排序系统任务 - 重新排序系统Z轴运行中的任务"
        }
    ),
    utsArrayOf(
        "RESTART_PACKAGES",
        object : UTSJSONObject() {
            var name = "android.permission.RESTART_PACKAGES"
            var description = "结束系统任务 - 结束任务通过restartPackage(String)方法,该方式将在外来放弃"
        }
    ),
    utsArrayOf(
        "SEND_SMS",
        object : UTSJSONObject() {
            var name = "android.permission.SEND_SMS"
            var description = "发送短信 - 发送短信"
        }
    ),
    utsArrayOf(
        "SET_ACTIVITY_WATCHER",
        object : UTSJSONObject() {
            var name = "android.permission.SET_ACTIVITY_WATCHER"
            var description = "设置Activity观察其 - 设置Activity观察器一般用于monkey测试"
        }
    ),
    utsArrayOf(
        "SET_ALARM",
        object : UTSJSONObject() {
            var name = "com.android.alarm.permission.SET_ALARM"
            var description = "设置闹铃提醒 - 设置闹铃提醒"
        }
    ),
    utsArrayOf(
        "SET_ALWAYS_FINISH",
        object : UTSJSONObject() {
            var name = "android.permission.SET_ALWAYS_FINISH"
            var description = "设置总是退出 - 设置程序在后台是否总是退出"
        }
    ),
    utsArrayOf(
        "SET_ANIMATION_SCALE",
        object : UTSJSONObject() {
            var name = "android.permission.SET_ANIMATION_SCALE"
            var description = "设置动画缩放 - 设置全局动画缩放"
        }
    ),
    utsArrayOf(
        "SET_DEBUG_APP",
        object : UTSJSONObject() {
            var name = "android.permission.SET_DEBUG_APP"
            var description = "设置调试程序 - 设置调试程序,一般用于开发"
        }
    ),
    utsArrayOf(
        "SET_ORIENTATION",
        object : UTSJSONObject() {
            var name = "android.permission.SET_ORIENTATION"
            var description = "设置屏幕方向 - 设置屏幕方向为横屏或标准方式显示,不用于普通应用"
        }
    ),
    utsArrayOf(
        "SET_PREFERRED_APPLICATIONS",
        object : UTSJSONObject() {
            var name = "android.permission.SET_PREFERRED_APPLICATIONS"
            var description = "设置应用参数 - 设置应用的参数,已不再工作具体查看addPackageToPreferred(String)介绍"
        }
    ),
    utsArrayOf(
        "SET_PROCESS_LIMIT",
        object : UTSJSONObject() {
            var name = "android.permission.SET_PROCESS_LIMIT"
            var description = "设置进程限制 - 允许程序设置最大的进程数量的限制"
        }
    ),
    utsArrayOf(
        "SET_TIME",
        object : UTSJSONObject() {
            var name = "android.permission.SET_TIME"
            var description = "设置系统时间 - 设置系统时间"
        }
    ),
    utsArrayOf(
        "SET_TIME_ZONE",
        object : UTSJSONObject() {
            var name = "android.permission.SET_TIME_ZONE"
            var description = "设置系统时区 - 设置系统时区"
        }
    ),
    utsArrayOf(
        "SET_WALLPAPER",
        object : UTSJSONObject() {
            var name = "android.permission.SET_WALLPAPER"
            var description = "设置桌面壁纸 - 设置桌面壁纸"
        }
    ),
    utsArrayOf(
        "SET_WALLPAPER_HINTS",
        object : UTSJSONObject() {
            var name = "android.permission.SET_WALLPAPER_HINTS"
            var description = "设置壁纸建议 - 设置壁纸建议"
        }
    ),
    utsArrayOf(
        "SIGNAL_PERSISTENT_PROCESSES",
        object : UTSJSONObject() {
            var name = "android.permission.SIGNAL_PERSISTENT_PROCESSES"
            var description = "发送永久进程信号 - 发送一个永久的进程信号"
        }
    ),
    utsArrayOf(
        "STATUS_BAR",
        object : UTSJSONObject() {
            var name = "android.permission.STATUS_BAR"
            var description = "状态栏控制 - 允许程序打开、关闭、禁用状态栏"
        }
    ),
    utsArrayOf(
        "SUBSCRIBED_FEEDS_READ",
        object : UTSJSONObject() {
            var name = "android.permission.SUBSCRIBED_FEEDS_READ"
            var description = "访问订阅内容 - 访问订阅信息的数据库"
        }
    ),
    utsArrayOf(
        "SUBSCRIBED_FEEDS_WRITE",
        object : UTSJSONObject() {
            var name = "android.permission.SUBSCRIBED_FEEDS_WRITE"
            var description = "写入订阅内容 - 写入或修改订阅内容的数据库"
        }
    ),
    utsArrayOf(
        "SYSTEM_ALERT_WINDOW",
        object : UTSJSONObject() {
            var name = "android.permission.SYSTEM_ALERT_WINDOW"
            var description = "显示系统窗口 - 显示系统窗口"
        }
    ),
    utsArrayOf(
        "UPDATE_DEVICE_STATS",
        object : UTSJSONObject() {
            var name = "android.permission.UPDATE_DEVICE_STATS"
            var description = "更新设备状态 - 更新设备状态"
        }
    ),
    utsArrayOf(
        "USE_CREDENTIALS",
        object : UTSJSONObject() {
            var name = "android.permission.USE_CREDENTIALS"
            var description = "使用证书 - 允许程序请求验证从AccountManager"
        }
    ),
    utsArrayOf(
        "USE_SIP",
        object : UTSJSONObject() {
            var name = "android.permission.USE_SIP"
            var description = "使用SIP视频 - 允许程序使用SIP视频服务"
        }
    ),
    utsArrayOf(
        "VIBRATE",
        object : UTSJSONObject() {
            var name = "android.permission.VIBRATE"
            var description = "使用振动 - 允许振动"
        }
    ),
    utsArrayOf(
        "WAKE_LOCK",
        object : UTSJSONObject() {
            var name = "android.permission.WAKE_LOCK"
            var description = "唤醒锁定 - 允许程序在手机屏幕关闭后后台进程仍然运行"
        }
    ),
    utsArrayOf(
        "WRITE_APN_SETTINGS",
        object : UTSJSONObject() {
            var name = "android.permission.WRITE_APN_SETTINGS"
            var description = "写入GPRS接入点设置 - 写入网络GPRS接入点设置"
        }
    ),
    utsArrayOf(
        "WRITE_CALENDAR",
        object : UTSJSONObject() {
            var name = "android.permission.WRITE_CALENDAR"
            var description = "写入日程提醒 - 写入日程,但不可读取"
        }
    ),
    utsArrayOf(
        "WRITE_CONTACTS",
        object : UTSJSONObject() {
            var name = "android.permission.WRITE_CONTACTS"
            var description = "写入联系人 - 写入联系人,但不可读取"
        }
    ),
    utsArrayOf(
        "WRITE_EXTERNAL_STORAGE",
        object : UTSJSONObject() {
            var name = "android.permission.WRITE_EXTERNAL_STORAGE"
            var description = "写入外部存储 - 允许程序写入外部存储,如SD卡上写文件"
        }
    ),
    utsArrayOf(
        "WRITE_GSERVICES",
        object : UTSJSONObject() {
            var name = "android.permission.WRITE_GSERVICES"
            var description = "写入Google地图数据 - 允许程序写入Google Map服务数据"
        }
    ),
    utsArrayOf(
        "WRITE_HISTORY_BOOKMARKS",
        object : UTSJSONObject() {
            var name = "com.android.browser.permission.WRITE_HISTORY_BOOKMARKS"
            var description = "写入收藏夹和历史记录 - 写入浏览器历史记录或收藏夹,但不可读取"
        }
    ),
    utsArrayOf(
        "WRITE_SECURE_SETTINGS",
        object : UTSJSONObject() {
            var name = "android.permission.WRITE_SECURE_SETTINGS"
            var description = "读写系统敏感设置 - 允许程序读写系统安全敏感的设置项"
        }
    ),
    utsArrayOf(
        "WRITE_SETTINGS",
        object : UTSJSONObject() {
            var name = "android.permission.WRITE_SETTINGS"
            var description = "读写系统设置 - 允许读写系统设置项"
        }
    ),
    utsArrayOf(
        "WRITE_SMS",
        object : UTSJSONObject() {
            var name = "android.permission.WRITE_SMS"
            var description = "编写短信 - 允许编写短信"
        }
    ),
    utsArrayOf(
        "NOTIFICATIONS",
        object : UTSJSONObject() {
            var name = "android.permission.POST_NOTIFICATIONS"
            var description = "提醒通知 - 允许设备接收消息通知提醒"
        }
    )
))
val getPermissionName = fun(key: String): String? {
    val permission = ANDROID_PERMISSIONS.get(key)
    return if (permission != null) {
        permission.name
    } else {
        null
    }
}
val getPermissionDescription = fun(key: String): String? {
    val permission = ANDROID_PERMISSIONS.get(key)
    return if (permission != null) {
        permission.description
    } else {
        null
    }
}
val getPermissionNames = fun(keys: UTSArray<String>): UTSArray<String> {
    val names: UTSArray<String> = utsArrayOf()
    keys.forEach(fun(key: String){
        val name = getPermissionName(key)
        if (name != null) {
            names.push(name)
        }
    }
    )
    return names
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
