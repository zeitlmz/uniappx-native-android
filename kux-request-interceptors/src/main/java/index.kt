@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.kuxRequestInterceptors
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
typealias RetryFunction<T, R> = (url: String, config: T) -> UTSPromise<R?>
open class RetryOptions<T, R> (
    @JsonNotNull
    open var retryTimes: Number,
    @JsonNotNull
    open var retry: RetryFunction<T, R>,
) : UTSObject()
open class ResponseErrorCallbackOptions<T, R> (
    @JsonNotNull
    open var response: R,
    @JsonNotNull
    open var retryOptions: RetryOptions<T, R>,
) : UTSObject()
open class RIInterceptor<T, R> (
    open var requestInterceptor: ((config: T) -> UTSPromise<T>)? = null,
    open var responseInterceptor: ((response: R) -> UTSPromise<R>)? = null,
    open var requestInterceptorError: ((error: IUniError) -> UTSPromise<IUniError?>)? = null,
    open var responseInterceptorError: ((response: R) -> UTSPromise<R?>)? = null,
    open var responseInterceptorErrorWithRetry: ((options: ResponseErrorCallbackOptions<T, R>) -> UTSPromise<R?>)? = null,
) : UTSObject()
interface RIInterceptorManager<T, R> {
    fun use(interceptor: RIInterceptor<T, R>): String
    fun eject(id: String)
    fun clear()
    fun get(id: String): RIInterceptor<T, R>?
    fun handleRequest(config: T): UTSPromise<T>
    fun handleResponse(response: R): UTSPromise<R>
    fun handleRequestError(error: IUniError): UTSPromise<IUniError?>
    fun handleResponseError(response: R): UTSPromise<R?>
    fun handleResponseErrorWithRetry(options: ResponseErrorCallbackOptions<T, R>): UTSPromise<R?>
}
fun generateUUID(output: String = "lower"): String {
    val str = "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx"
    return str.replace(UTSRegExp("[xy]", "g"), fun(c: String, offset: Number, string: String): String {
        val r = (Math.random() * 16) or 0
        val v = if (c == "x") {
            r
        } else {
            (r and 0x3) or 0x8
        }
        val outputString = v.toString(16)
        return if (output == "lower") {
            outputString.toLowerCase()
        } else {
            outputString.toUpperCase()
        }
    }
    )
}
open class RIInterceptorManagerImpl<T, R> : RIInterceptorManager<T, R> {
    private var interceptors: Map<String, RIInterceptor<T, R>> = Map()
    override fun use(interceptor: RIInterceptor<T, R>): String {
        val uuid = generateUUID()
        this.interceptors.set(uuid, interceptor)
        return uuid
    }
    override fun eject(id: String): Unit {
        this.interceptors.`delete`(id)
    }
    override fun clear() {
        this.interceptors.clear()
    }
    override fun get(id: String): RIInterceptor<T, R>? {
        return this.interceptors.get(id)
    }
    override fun handleRequest(config: T): UTSPromise<T> {
        return wrapUTSPromise(suspend w@{
                var promise = UTSPromise.resolve(config)
                this.interceptors.forEach(fun(interceptor: RIInterceptor<T, R>, key: String, map: Map<String, RIInterceptor<T, R>>){
                    if (interceptor.requestInterceptor != null) {
                        promise = interceptor!!.requestInterceptor?.invoke(config)!!
                    }
                }
                )
                return@w promise
        })
    }
    override fun handleResponse(response: R): UTSPromise<R> {
        return wrapUTSPromise(suspend w@{
                var promise = UTSPromise.resolve(response)
                this.interceptors.forEach(fun(interceptor: RIInterceptor<T, R>, key: String, map: Map<String, RIInterceptor<T, R>>){
                    if (interceptor.responseInterceptor != null) {
                        promise = interceptor!!.responseInterceptor?.invoke(response)!!
                    }
                }
                )
                return@w promise
        })
    }
    override fun handleRequestError(error: IUniError): UTSPromise<IUniError?> {
        return wrapUTSPromise(suspend w@{
                var promise: UTSPromise<IUniError?> = UTSPromise.resolve(error) as UTSPromise<IUniError?>
                this.interceptors.forEach(fun(interceptor: RIInterceptor<T, R>){
                    if (interceptor.requestInterceptorError != null) {
                        promise = interceptor!!.requestInterceptorError?.invoke(error)!!
                    }
                }
                )
                return@w promise as UTSPromise<IUniError?>
        })
    }
    override fun handleResponseError(response: R): UTSPromise<R?> {
        return wrapUTSPromise(suspend w@{
                var promise: UTSPromise<R?> = UTSPromise.resolve(null) as UTSPromise<R?>
                this.interceptors.forEach(fun(interceptor: RIInterceptor<T, R>, key: String, map: Map<String, RIInterceptor<T, R>>){
                    if (interceptor.responseInterceptorError != null) {
                        promise = interceptor!!.responseInterceptorError?.invoke(response)!!
                    }
                }
                )
                return@w promise as UTSPromise<R?>
        })
    }
    override fun handleResponseErrorWithRetry(options: ResponseErrorCallbackOptions<T, R>): UTSPromise<R?> {
        return wrapUTSPromise(suspend w@{
                var promise: UTSPromise<R?> = UTSPromise.resolve(null) as UTSPromise<R?>
                this.interceptors.forEach(fun(interceptor: RIInterceptor<T, R>, key: String, map: Map<String, RIInterceptor<T, R>>){
                    if (interceptor.responseInterceptorErrorWithRetry != null) {
                        promise = interceptor!!.responseInterceptorErrorWithRetry?.invoke(options)!!
                    }
                }
                )
                return@w promise as UTSPromise<R?>
        })
    }
}
