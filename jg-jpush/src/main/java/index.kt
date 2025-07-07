@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.jgJpush
import android.app.Notification
import android.content.Context
import cn.jiguang.api.utils.JCollectionAuth
import cn.jpush.android.api.CmdMessage
import cn.jpush.android.api.CustomMessage
import cn.jpush.android.api.JPushInterface
import cn.jpush.android.api.JPushMessage
import cn.jpush.android.api.NotificationMessage
import cn.jpush.android.data.JPushConfigEx
import cn.jpush.android.data.JPushLocalNotification
import cn.jpush.android.service.JCommonService
import cn.jpush.android.service.JPushMessageReceiver
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
open class JgUtil {
    constructor(){}
    open fun init() {
        console.log("初始化极光推送=====")
        val cusContext = UTSAndroid.getAppContext()
        JPushInterface.setDebugMode(true)
        val config = JPushConfigEx()
        config.setjAppKey("8e00add2deac36aa5599da87")
        config.setXmAppId("2882303761520415688")
        config.setXmAppKey("5162041542688")
        config.setOppoAppId("33302519")
        config.setOppoAppKey("b271982497f04d969fe5ca51fd5ef691")
        config.setOppoAppSecret("6cff3eb5e88245f6926e817c0ce25577")
        config.setHwAppId("111537715")
        config.setMzAppId("155549")
        config.setMzAppKey("da823c2266bb43dfb1502c6ca8a6e4e2")
        JPushInterface.setChannel(cusContext, "mc-cs")
        JPushInterface.init(cusContext, config)
        this.clearBadgeNumber()
    }
    open fun setAlias(alias: String): JgUtil {
        console.log("jpush aliasInit==", JgUtil.aliasInit)
        if (JgUtil.aliasInit == null || JgUtil.aliasInit != alias) {
            JgUtil.aliasInit = alias
            console.log("jpush alias==", alias)
            JPushInterface.setAlias(UTSAndroid.getAppContext(), 10, alias)
        }
        this.clearBadgeNumber()
        JgUtil.resumePush()
        return this
    }
    open fun clearBadgeNumber(): Unit {
        console.log("清除角标")
        JPushInterface.setBadgeNumber(UTSAndroid.getAppContext(), -1)
    }
    open fun getConnectionState(): Boolean {
        val state = JPushInterface.getConnectionState(UTSAndroid.getAppContext())
        console.log("getConnectionState=", state)
        return state
    }
    open fun getRegistrationID(): String {
        val registrationID = JPushInterface.getRegistrationID(UTSAndroid.getAppContext())
        console.log("getRegistrationID=", registrationID)
        return registrationID
    }
    open fun sendLocalNotice(noticeId: Number, title: String, content: String, extras: String): Unit {
        val notification = JPushLocalNotification()
        notification.setNotificationId(noticeId.toLong())
        notification.setCategory(Notification.CATEGORY_SERVICE)
        notification.setPriority(Notification.PRIORITY_MAX)
        notification.setTitle(title)
        notification.setContent(content)
        notification.setExtras(extras)
        JPushInterface.setBadgeNumber(UTSAndroid.getAppContext(), 0)
        JPushInterface.addLocalNotification(UTSAndroid.getAppContext(), notification)
    }
    open fun removeLocalNotic(noticeId: Number): Unit {
        JPushInterface.removeLocalNotification(UTSAndroid.getAppContext(), noticeId.toLong())
    }
    open fun clearLocalAll(): Unit {
        JPushInterface.clearLocalNotifications(UTSAndroid.getAppContext())
    }
    companion object {
        private var aliasInit: String? = null
        fun stopPush(): Unit {
            console.log("stopPush 停止推送")
            JPushInterface.stopPush(UTSAndroid.getAppContext())
        }
        fun resumePush(): Unit {
            console.log("resumePush 开启推送")
            JPushInterface.resumePush(UTSAndroid.getAppContext())
        }
        fun isPushStopped(): Boolean {
            console.log("isPushStopped 开启推送")
            return JPushInterface.isPushStopped(UTSAndroid.getAppContext())
        }
        fun setPrivacyAuth(isAuth: Boolean): Unit {
            console.log("setAuth 设置隐私权限 isAuth=", isAuth)
            JCollectionAuth.setAuth(UTSAndroid.getAppContext(), isAuth)
        }
    }
}
open class MyJCommonService : JCommonService {
    constructor() : super() {}
}
open class MyJPushMessageReceiver : JPushMessageReceiver {
    constructor() : super() {}
    override fun onConnected(context: Context, status: Boolean) {
        console.log("JPush onConnected收到的消息= ", status)
    }
    override fun onCommandResult(context: Context, cmdMsg: CmdMessage) {
        console.log("JPush onCommandResult收到的消息= ", cmdMsg)
    }
    override fun onMessage(context: Context, message: CustomMessage) {
        console.log("JPush onMessage收到的消息= ", message)
    }
    override fun onNotifyMessageArrived(context: Context, notification: NotificationMessage) {
        console.log("JPush onNotifyMessageArrived收到的消息= ", notification)
    }
    override fun onNotifyMessageOpened(context: Context, notification: NotificationMessage) {
        console.log("JPush onNotifyMessageOpened被打开的事件= ", notification)
    }
    override fun onNotifyMessageDismiss(context: Context, notification: NotificationMessage) {
        console.log("JPush onNotifyMessageDismiss被关闭的事件= ", notification)
        JPushInterface.setBadgeNumber(UTSAndroid.getAppContext(), -1)
    }
    override fun onAliasOperatorResult(context: Context, message: JPushMessage) {
        console.log("JPush别名操作通知事件= ", message)
    }
    override fun onRegister(context: Context, registrationState: String) {
        console.log("JPush应用注册收到事件= ", registrationState)
    }
}
