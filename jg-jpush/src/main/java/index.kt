@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.jgJpush
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
open class JgUtil {
    constructor(){}
    open fun init() {
        console.log("初始化极光推送=====")
    }
    open fun setAlias(alias: String): JgUtil {
        return this
    }
    open fun clearBadgeNumber(): Unit {
        console.log("清除角标")
    }
    open fun getConnectionState(): Boolean {
        return false
    }
    open fun getRegistrationID(): String {
        return ""
    }
    open fun sendLocalNotice(noticeId: Number, title: String, content: String, extras: String): Unit {}
    open fun removeLocalNotic(noticeId: Number): Unit {}
    open fun clearLocalAll(): Unit {}
    companion object {
        private var aliasInit: String? = null
        fun stopPush(): Unit {
            console.log("stopPush 停止推送")
        }
        fun resumePush(): Unit {
            console.log("resumePush 开启推送")
        }
        fun isPushStopped(): Boolean {
            console.log("isPushStopped 开启推送")
            return false
        }
        fun setPrivacyAuth(isAuth: Boolean): Unit {
            console.log("setAuth 设置隐私权限 isAuth=", isAuth)
        }
    }
}
