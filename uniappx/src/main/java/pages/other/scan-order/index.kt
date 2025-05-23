@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI511F0A5
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
import uts.sdk.modules.mcWechatSdk.WeChatShare
open class GenPagesOtherScanOrderIndex : BasePage {
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
        var setup: (__props: GenPagesOtherScanOrderIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherScanOrderIndex
            val _cache = __ins.renderCache
            val queryDate = ref<String>("")
            val planId = ref<String>("")
            val linesGroupName = ref<String>("")
            val xcTime = ref<String>("")
            val shareImc = ref<String>("")
            val localImagePath = ref<String>("")
            val toShare = fun(){
                try {
                    val userInfo = getCacheUserInfo()
                    if (userInfo == null) {
                        console.error("用户信息获取失败")
                        showToast("用户信息获取失败", "error")
                        return
                    }
                    val driverSessionInfo = userInfo.getJSON("driverSessionInfo")
                    if (driverSessionInfo == null) {
                        console.error("司机信息获取失败")
                        showToast("司机信息获取失败", "error")
                        return
                    }
                    val driverId = driverSessionInfo.getString("driverId")
                    if (driverId == null) {
                        console.error("司机ID获取失败")
                        showToast("司机ID获取失败", "error")
                        return
                    }
                    console.log("开始分享, driverId:", driverId, "planId:", planId.value, "date:", queryDate.value)
                    val title = xcTime.value + " " + linesGroupName.value + " 司机已就绪，点击链接马上出发"
                    WeChatShare.getInstance().addTitle(title).addDescription("行程码分享").addMiniProgramPath("/pages/other/scan-car/index?driverId=" + driverId + "&planId=" + planId.value + "&date=" + queryDate.value).addWebpageUrl("http://uniapp.dcloud.io").addImageBitmapPath(miniProgramCover).shareMiniProgram()
                    console.log("分享调用完成")
                }
                 catch (error: Throwable) {
                    console.error("分享失败:", error)
                    showToast("分享失败，请重试", "error")
                }
            }
            onLoad(fun(options){
                if (options != null) {
                    val opt = JSON.parse(JSON.stringify(options)) as UTSJSONObject
                    queryDate.value = opt.getString("date") ?: ""
                    planId.value = opt.getString("planId") ?: ""
                    linesGroupName.value = opt.getString("linesGroupName") ?: ""
                    xcTime.value = opt.getString("xcTime") ?: ""
                    generateOfflinePaymentQRCode(planId.value, queryDate.value).then(fun(res: Response){
                        shareImc.value = res.data as String
                    }
                    )
                }
                WeChatShare.getInstance().addImageBitmapPath(miniProgramCover)
            }
            )
            return fun(): Any? {
                val _component_mc_active_animation = resolveEasyComponent("mc-active-animation", GenComponentsMcActiveAnimationIndexClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createVNode(_component_mc_base_container, utsMapOf("title" to "扫码下单", "showStatusBarPlaceholder" to false, "title-color" to "#ffffff", "navbar-is-place" to false, "staticTransparent" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "scan-order-box", "style" to normalizeStyle("height: " + unref(screenHeight) + "px; padding-top: " + (unref(statusBarHeight) + 50) + "px;")), utsArrayOf(
                            createElementVNode("image", utsMapOf("class" to "box-bg", "src" to ("" + unref(resBaseUrl) + "/static/images/scan-order-bg.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                "src"
                            )),
                            createElementVNode("view", utsMapOf("class" to "trip-info"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "info-row"), utsArrayOf(
                                    createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-trip-outline-small.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                        "src"
                                    )),
                                    createElementVNode("text", utsMapOf("class" to "label"), "行程线路："),
                                    createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(unref(linesGroupName)), 1)
                                )),
                                createElementVNode("view", utsMapOf("class" to "info-row"), utsArrayOf(
                                    createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-clock-outline-small.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                        "src"
                                    )),
                                    createElementVNode("text", utsMapOf("class" to "label"), "行程时间："),
                                    createElementVNode("text", utsMapOf("class" to "value"), toDisplayString(unref(xcTime)), 1)
                                ))
                            )),
                            createElementVNode("view", utsMapOf("class" to "ercode-box"), utsArrayOf(
                                createElementVNode("image", utsMapOf("class" to "ercode-bg", "src" to ("" + unref(resBaseUrl) + "/static/images/ercode-bg.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                    "src"
                                )),
                                createElementVNode("view", utsMapOf("class" to "ercode"), utsArrayOf(
                                    createElementVNode("image", utsMapOf("class" to "img", "src" to unref(shareImc), "mode" to "widthFix"), null, 8, utsArrayOf(
                                        "src"
                                    )),
                                    createElementVNode("text", utsMapOf("class" to "tips-text"), "扫码可直接下单"),
                                    createElementVNode("view", utsMapOf("class" to "btn-group"), utsArrayOf(
                                        createVNode(_component_mc_active_animation, utsMapOf("class" to "share-item", "onClick" to toShare), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createElementVNode("image", utsMapOf("class" to "icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-wechat-2.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                )),
                                                createElementVNode("text", utsMapOf("class" to "name"), "分享到微信")
                                            )
                                        }
                                        ), "_" to 1))
                                    ))
                                ))
                            ))
                        ), 4)
                    )
                }
                ), "_" to 1))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ), utsArrayOf(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("scan-order-box" to padStyleMapOf(utsMapOf("position" to "relative", "width" to "100%", "height" to "100%")), "trip-info" to utsMapOf(".scan-order-box " to utsMapOf("paddingTop" to "60rpx", "paddingRight" to "60rpx", "paddingBottom" to "60rpx", "paddingLeft" to "60rpx")), "info-row" to utsMapOf(".scan-order-box .trip-info " to utsMapOf("flexDirection" to "row", "alignItems" to "center", "marginBottom" to "30rpx")), "icon" to utsMapOf(".scan-order-box .trip-info .info-row " to utsMapOf("width" to "30rpx", "height" to "auto", "marginRight" to "20rpx"), ".scan-order-box .ercode-box .ercode .btn-group .share-item " to utsMapOf("width" to "76rpx", "height" to "auto")), "label" to utsMapOf(".scan-order-box .trip-info .info-row " to utsMapOf("fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#D1DEF6")), "value" to utsMapOf(".scan-order-box .trip-info .info-row " to utsMapOf("fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#ffffff")), "ercode-box" to utsMapOf(".scan-order-box " to utsMapOf("marginTop" to 0, "marginRight" to "30rpx", "marginBottom" to 0, "marginLeft" to "30rpx", "position" to "relative")), "ercode-bg" to utsMapOf(".scan-order-box .ercode-box " to utsMapOf("width" to "100%", "height" to "auto")), "ercode" to utsMapOf(".scan-order-box .ercode-box " to utsMapOf("position" to "absolute", "top" to "120rpx", "left" to "50%", "borderTopLeftRadius" to "30rpx", "borderTopRightRadius" to "30rpx", "borderBottomRightRadius" to "30rpx", "borderBottomLeftRadius" to "30rpx", "transform" to "translateX(-50%)")), "img" to utsMapOf(".scan-order-box .ercode-box .ercode " to utsMapOf("width" to "440rpx", "height" to "440rpx")), "tips-text" to utsMapOf(".scan-order-box .ercode-box .ercode " to utsMapOf("width" to "100%", "paddingTop" to "40rpx", "paddingRight" to 0, "paddingBottom" to "170rpx", "paddingLeft" to 0, "textAlign" to "center", "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "btn-group" to utsMapOf(".scan-order-box .ercode-box .ercode " to utsMapOf("flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-evenly")), "share-item" to utsMapOf(".scan-order-box .ercode-box .ercode .btn-group " to utsMapOf("alignItems" to "center", "marginTop" to 0, "marginRight" to "30rpx", "marginBottom" to 0, "marginLeft" to "30rpx")), "name" to utsMapOf(".scan-order-box .ercode-box .ercode .btn-group .share-item " to utsMapOf("marginTop" to "20rpx", "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "box-bg" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "right" to 0, "height" to "100%", "width" to "100%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
