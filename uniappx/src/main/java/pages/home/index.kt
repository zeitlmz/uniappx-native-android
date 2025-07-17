@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI09580B7
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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import uts.sdk.modules.jgJpush.JgUtil
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xToastS.XTOAST_TYPE
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import uts.sdk.modules.xToastS.showToast as showToast1
import uts.sdk.modules.xToastS.hideToast
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesHomeIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop
        }
        , __ins)
        onResize(fun(_: OnResizeOptions) {
            uni__emit("onResize", fun() {})
        }
        , __ins)
        onLoad(fun(_: OnLoadOptions) {}, __ins)
        onPageHide(fun() {
            uni__emit("onHide", fun() {})
        }
        , __ins)
        onReady(fun() {
            uni__emit("onReady", fun() {})
            xProvitae.pageReady = true
        }
        , __ins)
        onPageShow(fun() {
            uni__emit("onShow", fun() {})
        }
        , __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesHomeIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesHomeIndex
            val _cache = __ins.renderCache
            val pageRef = ref<ComponentPublicInstance?>(null)
            val globalData = inject("globalData") as GlobalDataType
            val router = uni_useKuxRouter()
            val auditApproveStatus: Number = AUDIT_APPROVE as Number
            val isInited = ref(false)
            val checkHasEntry = fun(){
                if (!globalData.isLogin) {
                    return
                }
                val entryStatusCacheStr = getDriverCurrentCacheStatus()
                val entryStatusCache = if (isBlank(entryStatusCacheStr)) {
                    INIT
                } else {
                    parseInt(entryStatusCacheStr)
                }
                setDriverCurrentStatus(entryStatusCache)
                globalData.entryStatus = entryStatusCache
                if (entryStatusCache != AUDIT_APPROVE) {
                    showLoading(XLOADINGS_TYPE(title = "加载中..."))
                    getDriverCurrentStatus().then(fun(res: Response){
                        val data = res.data as UTSJSONObject
                        val status = data.getNumber("status") as Number
                        globalData.entryStatus = status
                        setDriverCurrentStatus(status as Number)
                        if (status == AUDIT_APPROVE) {
                            setTheme("primary")
                            globalData.theme = getTheme()
                            isInited.value = true
                            setTimeout(fun(){
                                pageRef.value?.`$callMethod`("onInit")
                                pageRef.value?.`$callMethod`("onShow")
                            }, 250)
                        } else {
                            isInited.value = false
                        }
                    }).`catch`(fun(err: Any?){
                        val errInfo = JSON.parse(JSON.stringify(err)) as UTSJSONObject
                        val code = errInfo.getNumber("code") as Number
                        isInited.value = false
                        if (code == 10000) {
                            showToast1(XTOAST_TYPE(title = errInfo.getString("msg") ?: "", iconCode = "error", iconColor = "red", titleColor = "red"))
                        }
                    }).`finally`(fun(){
                        hideXloading()
                    })
                } else {
                    setTheme("primary")
                    globalData.theme = getTheme()
                    setTimeout(fun(){
                        pageRef.value?.`$callMethod`("onInit")
                        pageRef.value?.`$callMethod`("onShow")
                    }
                    , 250)
                    isInited.value = true
                }
            }
            onPageShow(fun(){
                globalData.isLogin = getCacheUserInfo() != null
                checkHasEntry()
                if (isInited.value) {
                    pageRef.value?.`$callMethod`("onShow")
                }
                if (getPrivacyStatus()) {
                    if (globalData.isLogin) {
                        JgUtil.resumePush()
                    } else {
                        JgUtil.stopPush()
                    }
                }
            }
            )
            onReady(fun(){
                pageRef.value?.`$callMethod`("onReady")
                globalData.safeAreaBottom = uni_getSystemInfoSync().safeAreaInsets.bottom
            }
            )
            return fun(): Any? {
                val _component_mc_env_tag = resolveEasyComponent("mc-env-tag", GenComponentsMcEnvTagIndexClass)
                return createElementVNode(Fragment, null, utsArrayOf(
                    if (isTrue(unref(globalData).isLogin && unref(globalData).entryStatus == unref(auditApproveStatus))) {
                        createVNode(unref(GenPagesHomeHadSettledClass), utsMapOf("key" to 0, "ref_key" to "pageRef", "ref" to pageRef), null, 512)
                    } else {
                        createVNode(unref(GenPagesHomeNotSettledClass), utsMapOf("key" to 1, "onCheckHasEntry" to checkHasEntry))
                    }
                    ,
                    createVNode(_component_mc_env_tag)
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(), utsArrayOf(
                GenApp.styles
            ))
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
