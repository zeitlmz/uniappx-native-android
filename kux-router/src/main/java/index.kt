@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.kuxRouter
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
import io.dcloud.uniapp.extapi.addInterceptor as uni_addInterceptor
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.reLaunch as uni_reLaunch
import io.dcloud.uniapp.extapi.redirectTo as uni_redirectTo
import io.dcloud.uniapp.extapi.switchTab as uni_switchTab
typealias PagePath = String
typealias PageName = String
typealias RouteRecordName = PageName
typealias RouteRecordPath = PagePath
open class RouteLocationNormalizedLoaded (
    open var query: UTSJSONObject? = null,
    open var params: UTSJSONObject? = null,
    open var data: UTSJSONObject? = null,
    open var name: RouteRecordName? = null,
    @JsonNotNull
    open var path: String,
    open var fullUrl: String? = null,
    open var fullPath: String? = null,
    open var meta: UTSJSONObject? = null,
    open var from: RouteLocationNormalizedLoaded? = null,
    open var to: RouteLocationNormalizedLoaded? = null,
) : UTSObject()
typealias NavigationGuardWithThis = (to: RouteLocationNormalizedLoaded?, from: RouteLocationNormalizedLoaded?) -> UTSPromise<Any?>
typealias RouteRecordRedirectOption = (to: RouteLocationNormalizedLoaded?) -> RouteRecordNormalized?
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
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return RouteRecordNormalizedReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class RouteRecordNormalizedReactiveObject : RouteRecordNormalized, IUTSReactive<RouteRecordNormalized> {
    override var __v_raw: RouteRecordNormalized
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: RouteRecordNormalized, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(beforeEnter = __v_raw.beforeEnter, meta = __v_raw.meta, name = __v_raw.name, path = __v_raw.path, query = __v_raw.query, data = __v_raw.data, redirect = __v_raw.redirect, startupIntercept = __v_raw.startupIntercept, animationType = __v_raw.animationType, animationDuration = __v_raw.animationDuration) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): RouteRecordNormalizedReactiveObject {
        return RouteRecordNormalizedReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var meta: UTSJSONObject?
        get() {
            return trackReactiveGet(__v_raw, "meta", __v_raw.meta, this.__v_isReadonly, this.__v_isShallow)
        }
        set(value) {
            if (!this.__v_canSet("meta")) {
                return
            }
            val oldValue = __v_raw.meta
            __v_raw.meta = value
            triggerReactiveSet(__v_raw, "meta", oldValue, value)
        }
    override var name: RouteRecordName?
        get() {
            return trackReactiveGet(__v_raw, "name", __v_raw.name, this.__v_isReadonly, this.__v_isShallow)
        }
        set(value) {
            if (!this.__v_canSet("name")) {
                return
            }
            val oldValue = __v_raw.name
            __v_raw.name = value
            triggerReactiveSet(__v_raw, "name", oldValue, value)
        }
    override var path: PagePath?
        get() {
            return trackReactiveGet(__v_raw, "path", __v_raw.path, this.__v_isReadonly, this.__v_isShallow)
        }
        set(value) {
            if (!this.__v_canSet("path")) {
                return
            }
            val oldValue = __v_raw.path
            __v_raw.path = value
            triggerReactiveSet(__v_raw, "path", oldValue, value)
        }
    override var query: UTSJSONObject?
        get() {
            return trackReactiveGet(__v_raw, "query", __v_raw.query, this.__v_isReadonly, this.__v_isShallow)
        }
        set(value) {
            if (!this.__v_canSet("query")) {
                return
            }
            val oldValue = __v_raw.query
            __v_raw.query = value
            triggerReactiveSet(__v_raw, "query", oldValue, value)
        }
    override var data: UTSJSONObject?
        get() {
            return trackReactiveGet(__v_raw, "data", __v_raw.data, this.__v_isReadonly, this.__v_isShallow)
        }
        set(value) {
            if (!this.__v_canSet("data")) {
                return
            }
            val oldValue = __v_raw.data
            __v_raw.data = value
            triggerReactiveSet(__v_raw, "data", oldValue, value)
        }
    override var startupIntercept: Boolean?
        get() {
            return trackReactiveGet(__v_raw, "startupIntercept", __v_raw.startupIntercept, this.__v_isReadonly, this.__v_isShallow)
        }
        set(value) {
            if (!this.__v_canSet("startupIntercept")) {
                return
            }
            val oldValue = __v_raw.startupIntercept
            __v_raw.startupIntercept = value
            triggerReactiveSet(__v_raw, "startupIntercept", oldValue, value)
        }
    override var animationType: String?
        get() {
            return trackReactiveGet(__v_raw, "animationType", __v_raw.animationType, this.__v_isReadonly, this.__v_isShallow)
        }
        set(value) {
            if (!this.__v_canSet("animationType")) {
                return
            }
            val oldValue = __v_raw.animationType
            __v_raw.animationType = value
            triggerReactiveSet(__v_raw, "animationType", oldValue, value)
        }
    override var animationDuration: Number?
        get() {
            return trackReactiveGet(__v_raw, "animationDuration", __v_raw.animationDuration, this.__v_isReadonly, this.__v_isShallow)
        }
        set(value) {
            if (!this.__v_canSet("animationDuration")) {
                return
            }
            val oldValue = __v_raw.animationDuration
            __v_raw.animationDuration = value
            triggerReactiveSet(__v_raw, "animationDuration", oldValue, value)
        }
}
open class UseAddInterceptorOptions (
    open var switchTab: Boolean? = null,
    open var navigateTo: Boolean? = null,
    open var redirectTo: Boolean? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return UseAddInterceptorOptionsReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class UseAddInterceptorOptionsReactiveObject : UseAddInterceptorOptions, IUTSReactive<UseAddInterceptorOptions> {
    override var __v_raw: UseAddInterceptorOptions
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: UseAddInterceptorOptions, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(switchTab = __v_raw.switchTab, navigateTo = __v_raw.navigateTo, redirectTo = __v_raw.redirectTo) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UseAddInterceptorOptionsReactiveObject {
        return UseAddInterceptorOptionsReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var switchTab: Boolean?
        get() {
            return trackReactiveGet(__v_raw, "switchTab", __v_raw.switchTab, this.__v_isReadonly, this.__v_isShallow)
        }
        set(value) {
            if (!this.__v_canSet("switchTab")) {
                return
            }
            val oldValue = __v_raw.switchTab
            __v_raw.switchTab = value
            triggerReactiveSet(__v_raw, "switchTab", oldValue, value)
        }
    override var navigateTo: Boolean?
        get() {
            return trackReactiveGet(__v_raw, "navigateTo", __v_raw.navigateTo, this.__v_isReadonly, this.__v_isShallow)
        }
        set(value) {
            if (!this.__v_canSet("navigateTo")) {
                return
            }
            val oldValue = __v_raw.navigateTo
            __v_raw.navigateTo = value
            triggerReactiveSet(__v_raw, "navigateTo", oldValue, value)
        }
    override var redirectTo: Boolean?
        get() {
            return trackReactiveGet(__v_raw, "redirectTo", __v_raw.redirectTo, this.__v_isReadonly, this.__v_isShallow)
        }
        set(value) {
            if (!this.__v_canSet("redirectTo")) {
                return
            }
            val oldValue = __v_raw.redirectTo
            __v_raw.redirectTo = value
            triggerReactiveSet(__v_raw, "redirectTo", oldValue, value)
        }
}
open class RouterOptions (
    @JsonNotNull
    open var routes: UTSArray<RouteRecordNormalized>,
    open var useAddInterceptor: UseAddInterceptorOptions? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return RouterOptionsReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class RouterOptionsReactiveObject : RouterOptions, IUTSReactive<RouterOptions> {
    override var __v_raw: RouterOptions
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: RouterOptions, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(routes = __v_raw.routes, useAddInterceptor = __v_raw.useAddInterceptor) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): RouterOptionsReactiveObject {
        return RouterOptionsReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var routes: UTSArray<RouteRecordNormalized>
        get() {
            return trackReactiveGet(__v_raw, "routes", __v_raw.routes, this.__v_isReadonly, this.__v_isShallow)
        }
        set(value) {
            if (!this.__v_canSet("routes")) {
                return
            }
            val oldValue = __v_raw.routes
            __v_raw.routes = value
            triggerReactiveSet(__v_raw, "routes", oldValue, value)
        }
    override var useAddInterceptor: UseAddInterceptorOptions?
        get() {
            return trackReactiveGet(__v_raw, "useAddInterceptor", __v_raw.useAddInterceptor, this.__v_isReadonly, this.__v_isShallow)
        }
        set(value) {
            if (!this.__v_canSet("useAddInterceptor")) {
                return
            }
            val oldValue = __v_raw.useAddInterceptor
            __v_raw.useAddInterceptor = value
            triggerReactiveSet(__v_raw, "useAddInterceptor", oldValue, value)
        }
}
typealias NavigationFailureType = String
open class NavigationFailure (
    @JsonNotNull
    open var from: RouteLocationNormalizedLoaded,
    @JsonNotNull
    open var to: RouteLocationNormalizedLoaded,
    open var type: NavigationFailureType? = null,
) : UTSObject()
typealias NavigationHookAfter = (to: RouteLocationNormalizedLoaded, from: RouteLocationNormalizedLoaded, failure: NavigationFailure?) -> Any
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
    val options: RouterOptions?
    var from: RouteLocationNormalizedLoaded?
    fun addRoute(route: RouteRecordNormalized): UTSPromise<Any?>
    fun updateRoute(route: RouteRecordNormalized): UTSPromise<Any?>
    fun currentRoute(): RouteLocationNormalizedLoaded
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
    fun resolve(to: RouteRecordName): RouteLocationNormalizedLoaded?
}
interface IRoute {
    fun getRoutes(): UTSArray<RouteLocationNormalizedLoaded>
    fun current(): RouteLocationNormalizedLoaded
    fun hasRoute(nameOrPath: String): Boolean
    fun resolve(to: RouteRecordName): RouteLocationNormalizedLoaded?
}
open class State (
    open var routerInstance: IRouter? = null,
    @JsonNotNull
    open var routerOptions: RouterOptions,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return StateReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class StateReactiveObject : State, IUTSReactive<State> {
    override var __v_raw: State
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: State, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(routerInstance = __v_raw.routerInstance, routerOptions = __v_raw.routerOptions) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): StateReactiveObject {
        return StateReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var routerInstance: IRouter?
        get() {
            return trackReactiveGet(__v_raw, "routerInstance", __v_raw.routerInstance, this.__v_isReadonly, this.__v_isShallow)
        }
        set(value) {
            if (!this.__v_canSet("routerInstance")) {
                return
            }
            val oldValue = __v_raw.routerInstance
            __v_raw.routerInstance = value
            triggerReactiveSet(__v_raw, "routerInstance", oldValue, value)
        }
    override var routerOptions: RouterOptions
        get() {
            return trackReactiveGet(__v_raw, "routerOptions", __v_raw.routerOptions, this.__v_isReadonly, this.__v_isShallow)
        }
        set(value) {
            if (!this.__v_canSet("routerOptions")) {
                return
            }
            val oldValue = __v_raw.routerOptions
            __v_raw.routerOptions = value
            triggerReactiveSet(__v_raw, "routerOptions", oldValue, value)
        }
}
val state = reactive(State(routerInstance = null, routerOptions = RouterOptions(routes = utsArrayOf(), useAddInterceptor = UseAddInterceptorOptions())))
val setRouterInstance = fun(instance: IRouter){
    state.routerInstance = instance
}
val setRouterOptions = fun(options: RouterOptions){
    state.routerOptions = options
}
val updateRoute = fun(route: RouteRecordNormalized): UTSPromise<Unit> {
    return wrapUTSPromise(suspend {
            state.routerOptions.routes.map(fun(item): RouteRecordNormalized {
                if (item.path == route.path) {
                    if (item.data != route.data && route.data != null && JSON.stringify(route.data!!) != "{}") {
                        item.data = route.data
                    }
                    if (item.query != route.query && route.query != null && JSON.stringify(route.query!!) != "{}") {
                        item.query = route.query
                    }
                    if (item.beforeEnter != route.beforeEnter && route.beforeEnter != null) {
                        item.beforeEnter = route.beforeEnter
                    }
                    if (item.meta != route.meta && route.meta != null && JSON.stringify(route.meta!!) != "{}") {
                        item.meta = route.meta
                    }
                    if (route.name != null && item.name != route.name && route.name!!.length > 0) {
                        item.name = route.name
                    }
                    if (item.redirect != route.redirect && route.redirect != null) {
                        item.redirect = route.redirect
                    }
                    return item
                }
                return item
            }
            )
    })
}
val addRoute = fun(route: RouteRecordNormalized): UTSPromise<Unit> {
    return wrapUTSPromise(suspend {
            val res = state.routerOptions.routes.find(fun(item): Boolean {
                return item.path == route.path
            }
            )
            if (res != null) {
                updateRoute(route)
            } else {
                state.routerOptions.routes.push(route)
            }
    })
}
fun findRoute(path: String = "", name: String = ""): RouteRecordNormalized? {
    return state.routerOptions.routes.find(fun(item): Boolean {
        return item.path == path || item.name == name
    }
    )
}
fun findStoreRoute(pathOrName: String = ""): RouteRecordNormalized? {
    return state.routerOptions.routes.find(fun(item): Boolean {
        return item.path == pathOrName || item.name == pathOrName
    }
    )
}
fun isObject(target: Any): Boolean {
    return target is UTSJSONObject
}
fun deepMerge(target: Any, source: Any): Any {
    if (!(target is UTSJSONObject) || !(source is UTSJSONObject)) {
        return source
    }
    for(key in resolveUTSKeyIterator(source as UTSJSONObject)){
        if (isObject((source as UTSJSONObject)[key]!!) && (target as UTSJSONObject)[key] != null) {
            if (isObject((target as UTSJSONObject)[key]!!) && isObject((source as UTSJSONObject)[key]!!)) {
                deepMerge((target as UTSJSONObject)[key]!!, (source as UTSJSONObject)[key]!!)
            } else {
                (target as UTSJSONObject)[key] = (source as UTSJSONObject)[key]
            }
        } else {
            (target as UTSJSONObject)[key] = (source as UTSJSONObject)[key]
        }
    }
    return target as UTSJSONObject
}
val parseQueryString = fun(url: String): UTSJSONObject {
    if (url == null) {
        return UTSJSONObject()
    }
    val pathAndQuery = url.split("?")
    if (pathAndQuery.length == 1) {
        return UTSJSONObject()
    }
    val queryString = if (pathAndQuery.length > 1) {
        pathAndQuery[1]
    } else {
        ""
    }
    val query: UTSJSONObject = UTSJSONObject()
    val pairs = queryString.split("&")
    pairs.forEach(fun(pair){
        val pairSplit = pair.split("=")
        query["" + decodeURIComponent("" + pairSplit[0])] = decodeURIComponent("" + pairSplit[1])
    }
    )
    return query as UTSJSONObject
}
val getPath = fun(path: String): String {
    if (path != null) {
        return path.split("?")[0]
    }
    return ""
}
val getRoute = fun(path: String): String {
    return path.replace(UTSRegExp("^\\/", ""), "")
}
val objToQueryString = fun(obj: UTSJSONObject): String {
    val parts: UTSArray<String> = utsArrayOf()
    obj.toMap().forEach(fun(value, key: String){
        if (obj[key] != null) {
            if (value != null && UTSAndroid.`typeof`(value) !== "undefined") {
                parts.push(encodeURIComponent(key) + "=" + encodeURIComponent("" + value))
            }
        }
    }
    )
    return parts.join("&")
}
fun onChangePageBack(callback: () -> Unit) {
    UTSAndroid.onAppActivityBack(fun(){
        callback()
    }
    )
}
open class Route : IRoute {
    override fun getRoutes(): UTSArray<RouteLocationNormalizedLoaded> {
        val pages = getCurrentPages()
        return pages.map(fun(item: UniPage): RouteLocationNormalizedLoaded {
            val stateRoute = findRoute("/" + item.route)
            var isEmptyOptions = UTSJSONObject.keys(item.options).length == 0
            var query = stateRoute?.query ?: UTSJSONObject()
            val fullPath = if (isEmptyOptions) {
                item.route
            } else {
                "" + item.route + "?" + objToQueryString(query)
            }
            val data = stateRoute?.data ?: UTSJSONObject()
            val name = stateRoute?.name
            var route = RouteLocationNormalizedLoaded(path = item.route, query = query, data = data, name = name, fullUrl = "/" + fullPath, fullPath = "/" + fullPath, meta = UTSJSONObject())
            if (stateRoute != null) {
                route.meta = stateRoute.meta
            }
            return route
        }
        )
    }
    override fun current(): RouteLocationNormalizedLoaded {
        val routes = this.getRoutes()
        val pages = getCurrentPages()
        val page = if (pages.length > 0) {
            pages[pages.length - 1]
        } else {
            null
        }
        console.log(page)
        val path: String = page?.route ?: ""
        val currentRoute = routes.find(fun(item): Boolean {
            return item.path === path
        }
        )!!
        currentRoute.query = page?.options
        return currentRoute
    }
    override fun hasRoute(nameOrPath: String): Boolean {
        return this.getRoutes().find(fun(item): Boolean {
            return item.path == nameOrPath || item.name == nameOrPath
        }
        ) != null
    }
    override fun resolve(to: RouteRecordName): RouteLocationNormalizedLoaded? {
        return this.getRoutes().find(fun(item): Boolean {
            return item.path == to || item.name == to
        }
        )
    }
}
open class Router : IRouter {
    override val options: RouterOptions?
    private var afterEachHooks: UTSArray<NavigationHookAfter>
    private var beforeEachHooks: UTSArray<NavigationGuardWithThis>
    private var errorHook: ErrorListener?
    private var routeManager: IRoute
    private var to: RouteLocationNormalizedLoaded?
    override var from: RouteLocationNormalizedLoaded?
    private var failure: NavigationFailure?
    private var stateRoute: RouteRecordNormalized?
    private var aborted: Boolean
    private var locked: Boolean
    private var switchTabInterceptor: AddInterceptorOptions?
    private var navigateToInterceptor: AddInterceptorOptions?
    private var redirectToInterceptor: AddInterceptorOptions?
    private var reLaunchInterceptor: AddInterceptorOptions?
    private var interceptorUrl: String?
    constructor(){
        this.options = state.routerOptions
        this.afterEachHooks = utsArrayOf()
        this.beforeEachHooks = utsArrayOf()
        this.errorHook = null
        this.routeManager = Route()
        this.to = null
        this.from = null
        this.failure = null
        this.stateRoute = null
        this.interceptorUrl = null
        this.aborted = false
        this.locked = false
        this.switchTabInterceptor = AddInterceptorOptions(invoke = fun(options: SwitchTabOptions): Boolean {
            this.interceptorUrl = options.url
            if (this.interceptorUrl!!.startsWith("/") == false) {
                this.interceptorUrl = "/" + this.interceptorUrl
            }
            this.reLaunch(this.interceptorUrl!!)
            return false
        }
        , success = fun(res: SwitchTabSuccess){}, fail = fun(err: SwitchTabFail) {})
        this.navigateToInterceptor = AddInterceptorOptions(invoke = fun(options: NavigateToOptions): Boolean {
            this.interceptorUrl = options.url
            if (this.interceptorUrl!!.startsWith("/") == false) {
                this.interceptorUrl = "/" + this.interceptorUrl
            }
            this.reLaunch(this.interceptorUrl!!)
            return false
        }
        , success = fun(res: NavigateToSuccess){}, fail = fun(err: NavigateToFail) {})
        this.redirectToInterceptor = AddInterceptorOptions(invoke = fun(options: RedirectToOptions): Boolean {
            this.interceptorUrl = options.url
            if (this.interceptorUrl!!.startsWith("/") == false) {
                this.interceptorUrl = "/" + this.interceptorUrl
            }
            this.reLaunch(this.interceptorUrl!!)
            return false
        }
        , success = fun(res: RedirectToSuccess){}, fail = fun(err: RedirectToFail) {})
        this.reLaunchInterceptor = AddInterceptorOptions(invoke = fun(options: ReLaunchOptions): Boolean {
            this.interceptorUrl = options.url
            if (this.interceptorUrl!!.startsWith("/") == false) {
                this.interceptorUrl = "/" + this.interceptorUrl
            }
            this.reLaunch(this.interceptorUrl!!)
            return false
        }
        , success = fun(res: ReLaunchSuccess){}, fail = fun(err: ReLaunchFail) {})
        this.runBeforeEnter()
        onChangePageBack(fun(){
            this.runBeforeEnter()
        }
        )
        if (state.routerOptions.useAddInterceptor?.switchTab == true) {
            uni_addInterceptor("switchTab", this.switchTabInterceptor!!)
        }
        if (state.routerOptions.useAddInterceptor?.navigateTo == true) {
            uni_addInterceptor("navigateTo", this.navigateToInterceptor!!)
        }
        if (state.routerOptions.useAddInterceptor?.redirectTo == true) {
            uni_addInterceptor("redirectTo", this.redirectToInterceptor!!)
        }
    }
    override fun addRoute(route: RouteRecordNormalized): UTSPromise<Any?> {
        return wrapUTSPromise(suspend w@{
                try {
                    await(uts.sdk.modules.kuxRouter.addRoute(route))
                    return@w null
                }
                 catch (err: Throwable) {
                    this.errorHook?.invoke(ErrorListenerOptions(error = err))
                    return@w err
                }
        })
    }
    override fun updateRoute(route: RouteRecordNormalized): UTSPromise<Any?> {
        return wrapUTSPromise(suspend w@{
                try {
                    await(uts.sdk.modules.kuxRouter.updateRoute(route))
                    return@w null
                }
                 catch (err: Throwable) {
                    this.errorHook?.invoke(ErrorListenerOptions(error = err))
                    return@w err
                }
        })
    }
    override fun currentRoute(): RouteLocationNormalizedLoaded {
        return this.to ?: this.routeManager.current()
    }
    override fun afterEach(guard: NavigationHookAfter): () -> Unit {
        val index = this.afterEachHooks.push(guard)
        val ungisterAfterEachInvoke = fun(){
            this.afterEachHooks.splice(index - 1, 1)
        }
        return ungisterAfterEachInvoke
    }
    override fun removeAfterEach() {
        this.afterEachHooks = utsArrayOf()
    }
    private fun runAfterEach() {
        if (this.afterEachHooks.length > 0) {
            this.afterEachHooks.forEach(fun(value, _){
                value(this.to!!, this.from!!, null)
            }
            )
        }
    }
    private fun runBeforeEach(): UTSPromise<Unit> {
        return wrapUTSPromise(suspend {
                if (this.beforeEachHooks.length > 0) {
                    run {
                        var i: Number = 0
                        while(i < this.beforeEachHooks.length){
                            val res = await(this.beforeEachHooks[i](this.to!!, this.from!!))
                            if (res != null) {
                                if (UTSAndroid.`typeof`(res) === "boolean" && res as Boolean == false) {
                                    this.aborted = true
                                    i++
                                    continue
                                }
                                if (UTSAndroid.`typeof`(res) === "string") {
                                    this.locked = true
                                    this.updateTo(res as String)
                                    i++
                                    continue
                                } else if (UTSAndroid.`typeof`(res) === "object" && res is RouteRecordNormalized) {
                                    this.locked = true
                                    this.updateTo(res)
                                    i++
                                    continue
                                }
                            }
                            i++
                        }
                    }
                }
        })
    }
    override fun back(delta: Number?): Unit {
        this.back(delta as Number, null)
    }
    override fun back(delta: Number?, options: RouteLocationNormalizedOptions?) {
        uni_navigateBack(NavigateBackOptions(delta = delta ?: 1, animationType = options?.animationType ?: "auto", animationDuration = options?.animationDuration, success = fun(_){
            this.runAfterEach()
        }
        , fail = fun(result){
            this.errorHook?.invoke(ErrorListenerOptions(error = result))
        }
        ))
    }
    override fun beforeEach(guard: NavigationGuardWithThis): () -> Unit {
        val index = this.beforeEachHooks.push(guard)
        val ungisterBeforeEachInvoke = fun(){
            this.beforeEachHooks.splice(index - 1, 1)
            this.aborted = false
            this.locked = false
        }
        return ungisterBeforeEachInvoke
    }
    override fun removeBeforeEach() {
        this.beforeEachHooks = utsArrayOf()
    }
    override fun getRoutes(): UTSArray<RouteRecordNormalized> {
        return state.routerOptions.routes
    }
    override fun hasRoute(name: String): Boolean {
        return this.routeManager.hasRoute(name)
    }
    override fun onError(listener: ErrorListener) {
        this.errorHook = listener
    }
    private fun checkNavigationFailure(): Any {
        if (this.aborted) {
            this.failure = NavigationFailure(to = this.to!!, from = this.from!!, type = "aborted")
            this.locked = false
            this.errorHook?.invoke(ErrorListenerOptions(failure = this.failure!!))
            return this.failure!!
        }
        if ((JSON.stringify(this.to!!) == JSON.stringify(this.from))) {
            this.failure = NavigationFailure(to = this.to!!, from = this.from!!, type = "duplicated")
            this.locked = false
            this.errorHook?.invoke(ErrorListenerOptions(failure = this.failure!!))
            return this.failure!!
        }
        return true
    }
    private fun updateTo(to1: Any, to2: RouteLocationNormalizedLoaded? = null) {
        if (UTSAndroid.`typeof`(to1) === "string") {
            var path = getPath(to1 as String)
            var fullPath = path
            var query = parseQueryString(to1 as String)
            val storeQuery = findStoreRoute(to1 as String)?.query ?: UTSJSONObject()
            query = deepMerge(storeQuery, query) as UTSJSONObject
            if (query.toMap().size > 0) {
                fullPath = "" + path + "?" + objToQueryString(storeQuery)
            }
            var fullUrl = fullPath
            this.to = RouteLocationNormalizedLoaded(path = path, query = UTSJSONObject(), fullUrl = fullUrl, fullPath = fullPath, data = findRoute(to1 as String)?.data, name = findRoute(to1 as String)?.name, meta = findRoute(to1 as String)?.meta, to = to2)
        } else if (to1 is RouteRecordNormalized) {
            var path: String = ""
            var query: UTSJSONObject
            var data: UTSJSONObject
            var pathQuery: UTSJSONObject = UTSJSONObject()
            var fullPath: String = ""
            var fullUrl: String
            if (to1.path != null) {
                path = getPath(to1.path!!)
                fullPath = path
                pathQuery = parseQueryString(to1.path!!)
            }
            if (to1.path == null && to1.name != null) {
                fullPath = findStoreRoute(to1.name as String)?.path ?: ""
                path = fullPath
            }
            query = deepMerge(parseQueryString(fullPath), to1.query ?: UTSJSONObject()) as UTSJSONObject
            query = deepMerge(pathQuery, query) as UTSJSONObject
            data = deepMerge(findRoute(path)?.data ?: UTSJSONObject(), to1.data ?: UTSJSONObject()) as UTSJSONObject
            if (query.toMap().size > 0) {
                fullPath = "" + path + "?" + objToQueryString(query)
            }
            fullUrl = fullPath
            this.to = RouteLocationNormalizedLoaded(path = path, query = deepMerge(findRoute(path)?.query ?: UTSJSONObject(), to1.query ?: UTSJSONObject()) as UTSJSONObject, fullUrl = fullUrl, fullPath = fullPath, data = data, name = to1.name ?: findRoute(path)?.name, meta = to1.meta ?: findRoute(path)?.meta, to = to2)
        }
    }
    private fun runBeforeEnter(to: RouteLocationNormalizedLoaded = RouteLocationNormalizedLoaded(path = "")): UTSPromise<Unit> {
        return wrapUTSPromise(suspend {
                val routes = this.getRoutes()
                run {
                    var i: Number = 0
                    while(i < routes.length){
                        val item = routes[i]
                        if (item.beforeEnter != null || item.redirect != null) {
                            if (item.beforeEnter != null && (item.startupIntercept == true || (to.path == item.path))) {
                                val res = await((item.beforeEnter as NavigationGuardWithThis)(this.to, this.from))
                                if (res != null) {
                                    if (res is RouteRecordNormalized) {
                                        this.locked = true
                                        this.aborted = false
                                        this.updateTo(res, this.to)
                                        if (item.startupIntercept == true) {
                                            this.replace(res)
                                        }
                                    } else if (UTSAndroid.`typeof`(res) === "boolean" && res as Boolean == false) {
                                        this.locked = true
                                        this.aborted = true
                                    }
                                }
                            }
                            if (item.redirect != null && (item.startupIntercept == true || (to.path == item.path))) {
                                val res = (item.redirect as RouteRecordRedirectOption)(this.to)
                                if (res != null) {
                                    if (item.startupIntercept == true) {
                                        this.locked = true
                                        this.updateTo(res)
                                        this.replace(res)
                                    } else {
                                        this.locked = true
                                        this.updateTo(res, this.to)
                                    }
                                }
                            }
                        }
                        i++
                    }
                }
        })
    }
    private fun beforeEnter(to: Any): UTSPromise<Unit> {
        return wrapUTSPromise(suspend {
                this.from = this.currentRoute()
                this.updateTo(to)
                await(this.runBeforeEnter(this.to!!))
                await(this.runBeforeEach())
        })
    }
    private fun navigateComplete(callback: UTSPromise<Any>?): UTSPromise<Unit> {
        return wrapUTSPromise(suspend {
                if (callback != null) {
                    await((callback as UTSPromise<Any>))
                    this.locked = false
                    this.aborted = false
                    this.to!!.from = this.from
                }
                this.runAfterEach()
        })
    }
    override fun push(to: RouteRecordPath): UTSPromise<NavigationFailure?> {
        return wrapUTSPromise(suspend w@{
                return@w this.push(to as Any)
        })
    }
    override fun push(to: RouteRecordNormalized): UTSPromise<NavigationFailure?> {
        return wrapUTSPromise(suspend w@{
                return@w this.push(to as Any)
        })
    }
    override fun push(to: Any): UTSPromise<NavigationFailure?> {
        return wrapUTSPromise(suspend w@{
                if (!this.locked) {
                    await(this.beforeEnter(to))
                }
                if (this.checkNavigationFailure() != true) {
                    val callback = this.failure!!
                    this.failure = null
                    this.aborted = false
                    return@w callback
                }
                try {
                    var options = NavigateToOptions(url = this.to!!.fullPath!!, animationDuration = 300, animationType = "pop-in")
                    if (UTSAndroid.`typeof`(to) === "object" && to is RouteRecordNormalized) {
                        options.animationDuration = (to as RouteRecordNormalized).animationDuration ?: 300
                        options.animationType = (to as RouteRecordNormalized).animationType ?: "pop-in"
                    }
                    val callback = uni_navigateTo(options)
                    await(this.navigateComplete(callback as UTSPromise<Any>?))
                    return@w null
                }
                 catch (error: Throwable) {
                    this.locked = false
                    var failType: NavigationFailureType? = null
                    if (error is NavigateToFail) {
                        if (error.message != null) {
                            if (error.message!!.indexOf("is not found") > -1) {
                                failType = "notfound"
                            }
                        }
                    }
                    this.failure = NavigationFailure(to = this.to!!, from = this.from!!, type = failType)
                    this.errorHook?.invoke(ErrorListenerOptions(error = error, failure = this.failure))
                    this.to = null
                    return@w this.failure
                }
        })
    }
    override fun replace(to: RouteRecordName): UTSPromise<NavigationFailure?> {
        return wrapUTSPromise(suspend w@{
                return@w this.replace(to as Any)
        })
    }
    override fun replace(to: RouteRecordNormalized): UTSPromise<NavigationFailure?> {
        return wrapUTSPromise(suspend w@{
                return@w this.replace(to as Any)
        })
    }
    override fun replace(to: Any): UTSPromise<NavigationFailure?> {
        return wrapUTSPromise(suspend w@{
                if (!this.locked) {
                    await(this.beforeEnter(to))
                }
                if (this.checkNavigationFailure() != true) {
                    val callback = this.failure!!
                    this.failure = null
                    return@w callback
                }
                try {
                    val callback = uni_redirectTo(RedirectToOptions(url = this.to!!.fullPath!!))
                    await(this.navigateComplete(callback as UTSPromise<Any>?))
                    return@w null
                }
                 catch (error: Throwable) {
                    var failType: NavigationFailureType? = null
                    if (error is RedirectToFail) {
                        if (error.message != null) {
                            if (error.message!!.indexOf("is not found") > -1) {
                                failType = "notfound"
                            }
                        }
                    }
                    this.failure = NavigationFailure(to = this.to!!, from = this.from!!, type = failType)
                    this.errorHook?.invoke(ErrorListenerOptions(error = error, failure = this.failure))
                    this.to = null
                    return@w this.failure
                }
        })
    }
    override fun reLaunch(to: RouteRecordName): UTSPromise<NavigationFailure?> {
        return wrapUTSPromise(suspend w@{
                return@w this.reLaunch(to as Any)
        })
    }
    override fun reLaunch(to: RouteRecordNormalized): UTSPromise<NavigationFailure?> {
        return wrapUTSPromise(suspend w@{
                return@w this.reLaunch(to as Any)
        })
    }
    override fun reLaunch(to: Any): UTSPromise<NavigationFailure?> {
        return wrapUTSPromise(suspend w@{
                if (!this.locked) {
                    await(this.beforeEnter(to))
                }
                if (this.checkNavigationFailure() != true) {
                    val callback = this.failure!!
                    this.failure = null
                    return@w callback
                }
                try {
                    val callback = uni_reLaunch(ReLaunchOptions(url = this.to!!.fullPath!!))
                    await(this.navigateComplete(callback as UTSPromise<Any>?))
                    return@w null
                }
                 catch (error: Throwable) {
                    var failType: NavigationFailureType? = null
                    if (error is ReLaunchFail) {
                        if (error.message != null) {
                            if (error.message!!.indexOf("is not found") > -1) {
                                failType = "notfound"
                            }
                        }
                    }
                    this.failure = NavigationFailure(to = this.to!!, from = this.from!!, type = failType)
                    this.errorHook?.invoke(ErrorListenerOptions(error = error, failure = this.failure))
                    this.to = null
                    return@w this.failure
                }
        })
    }
    override fun switchTab(to: RouteRecordName): UTSPromise<NavigationFailure?> {
        return wrapUTSPromise(suspend w@{
                return@w this.switchTab(to as Any)
        })
    }
    override fun switchTab(to: RouteRecordNormalized): UTSPromise<NavigationFailure?> {
        return wrapUTSPromise(suspend w@{
                return@w this.switchTab(to as Any)
        })
    }
    override fun switchTab(to: Any): UTSPromise<NavigationFailure?> {
        return wrapUTSPromise(suspend w@{
                if (!this.locked) {
                    await(this.beforeEnter(to))
                }
                if (this.checkNavigationFailure() != true) {
                    val callback = this.failure!!
                    this.failure = null
                    return@w callback
                }
                if (!this.routeManager.hasRoute(getRoute(this.to!!.path))) {
                    try {
                        val callback = uni_switchTab(SwitchTabOptions(url = this.to!!.fullPath!!))
                        await(this.navigateComplete(callback as UTSPromise<Any>?))
                        return@w null
                    }
                     catch (error: Throwable) {
                        var failType: NavigationFailureType? = null
                        if (error is SwitchTabFail) {
                            if (error.message != null) {
                                if (error.message!!.indexOf("is not found") > -1) {
                                    failType = "notfound"
                                } else if (error.message!!.indexOf("is not tab page") > -1) {
                                    failType = "notTabPage"
                                }
                            }
                        }
                        this.failure = NavigationFailure(to = this.to!!, from = this.from!!, type = failType)
                        this.errorHook?.invoke(ErrorListenerOptions(error = error, failure = this.failure))
                        this.to = null
                        return@w this.failure
                    }
                }
                return@w null
        })
    }
    override fun resolve(to: RouteRecordName): RouteLocationNormalizedLoaded? {
        val data = this.routeManager.resolve(to)
        if (data == null) {
            val error = UniError()
            error.errMsg = "未找到规范化路由信息"
            this.errorHook?.invoke(ErrorListenerOptions(error = error))
            return null
        }
        return this.routeManager.resolve(to)
    }
}
fun useRouter(): IRouter {
    if (state.routerInstance == null) {
        throw UTSError("请先创建路由器实例")
    }
    return state.routerInstance!!
}
fun useRoute(): RouteLocationNormalizedLoaded {
    if (state.routerInstance == null) {
        throw UTSError("请先创建路由器实例")
    }
    return state.routerInstance!!.currentRoute()
}
fun createRouter(options: RouterOptions): IRouter {
    setRouterOptions(options)
    setRouterInstance(Router())
    return state.routerInstance!!
}
