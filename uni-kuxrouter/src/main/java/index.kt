@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.uniKuxrouter
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
import uts.sdk.modules.kuxRouter.IRouter as IRouter1
import uts.sdk.modules.kuxRouter.RouterOptions
import uts.sdk.modules.kuxRouter.RouteLocationNormalizedLoaded
import uts.sdk.modules.kuxRouter.useRouter
import uts.sdk.modules.kuxRouter.useRoute
import uts.sdk.modules.kuxRouter.createRouter
fun useKuxRouter(): IRouter1 {
    return useRouter()
}
fun useKuxRoute(): RouteLocationNormalizedLoaded {
    return useRoute()
}
fun createKuxRouter(options: RouterOptions): IRouter1 {
    return createRouter(options)
}
typealias PagePath = String
typealias PageName = String
typealias RouteRecordName = PageName
typealias RouteRecordPath = PagePath
open class RouteLocationNormalizedLoaded1 (
    open var query: UTSJSONObject? = null,
    open var params: UTSJSONObject? = null,
    open var data: UTSJSONObject? = null,
    open var name: RouteRecordName? = null,
    @JsonNotNull
    open var path: String,
    open var fullUrl: String? = null,
    open var fullPath: String? = null,
    open var meta: UTSJSONObject? = null,
    open var from: RouteLocationNormalizedLoaded1? = null,
    open var to: RouteLocationNormalizedLoaded1? = null,
) : UTSObject()
typealias NavigationGuardWithThis = (to: RouteLocationNormalizedLoaded1?, from: RouteLocationNormalizedLoaded1?) -> UTSPromise<Any?>
typealias RouteRecordRedirectOption = (to: RouteLocationNormalizedLoaded1?) -> RouteRecordNormalized?
open class RouteRecordNormalized (
    open var beforeEnter: NavigationGuardWithThis? = null,
    open var meta: UTSJSONObject? = null,
    open var name: RouteRecordName? = null,
    open var path: PagePath? = null,
    open var query: UTSJSONObject? = null,
    open var data: UTSJSONObject? = null,
    open var redirect: RouteRecordRedirectOption? = null,
    open var startupIntercept: Boolean? = null,
    open var animationType: String? = null,
    open var animationDuration: Number? = null,
) : UTSObject()
open class UseAddInterceptorOptions (
    open var switchTab: Boolean? = null,
    open var navigateTo: Boolean? = null,
    open var redirectTo: Boolean? = null,
) : UTSObject()
open class RouterOptions1 (
    @JsonNotNull
    open var routes: UTSArray<RouteRecordNormalized>,
    open var useAddInterceptor: UseAddInterceptorOptions? = null,
) : UTSObject()
typealias NavigationFailureType = String
open class NavigationFailure (
    @JsonNotNull
    open var from: RouteLocationNormalizedLoaded1,
    @JsonNotNull
    open var to: RouteLocationNormalizedLoaded1,
    open var type: NavigationFailureType? = null,
) : UTSObject()
typealias NavigationHookAfter = (to: RouteLocationNormalizedLoaded1, from: RouteLocationNormalizedLoaded1, failure: NavigationFailure?) -> Any
open class ErrorListenerOptions (
    open var error: Any? = null,
    open var failure: NavigationFailure? = null,
) : UTSObject()
typealias ErrorListener = (error: ErrorListenerOptions) -> Unit
open class RouteLocationNormalizedOptions (
    open var animationType: String? = null,
    open var animationDuration: Number? = null,
) : UTSObject()
interface IRouter {
    val options: RouterOptions1?
    var from: RouteLocationNormalizedLoaded1?
    fun addRoute(route: RouteRecordNormalized): UTSPromise<Any?>
    fun updateRoute(route: RouteRecordNormalized): UTSPromise<Any?>
    fun currentRoute(): RouteLocationNormalizedLoaded1
    fun afterEach(guard: NavigationHookAfter): () -> Unit
    fun removeAfterEach()
    fun back(delta: Number?)
    fun back(delta: Number?, options: RouteLocationNormalizedOptions?)
    fun beforeEach(guard: NavigationGuardWithThis): () -> Unit
    fun removeBeforeEach()
    fun getRoutes(): UTSArray<RouteRecordNormalized>
    fun hasRoute(name: String): Boolean
    fun onError(listener: ErrorListener)
    fun push(to: RouteRecordPath): UTSPromise<NavigationFailure?>
    fun push(to: RouteRecordNormalized): UTSPromise<NavigationFailure?>
    fun push(to: Any): UTSPromise<NavigationFailure?>
    fun replace(to: RouteRecordPath): UTSPromise<NavigationFailure?>
    fun replace(to: RouteRecordNormalized): UTSPromise<NavigationFailure?>
    fun replace(to: Any): UTSPromise<NavigationFailure?>
    fun reLaunch(to: RouteRecordPath): UTSPromise<NavigationFailure?>
    fun reLaunch(to: RouteRecordNormalized): UTSPromise<NavigationFailure?>
    fun reLaunch(to: Any): UTSPromise<NavigationFailure?>
    fun switchTab(to: RouteRecordPath): UTSPromise<NavigationFailure?>
    fun switchTab(to: RouteRecordNormalized): UTSPromise<NavigationFailure?>
    fun switchTab(to: Any): UTSPromise<NavigationFailure?>
    fun resolve(to: RouteRecordName): RouteLocationNormalizedLoaded1?
}
interface Uni {
    fun useKuxRouter(): IRouter
    fun useKuxRoute(): RouteLocationNormalizedLoaded1
    fun createKuxRouter(options: RouterOptions1): IRouter
}
