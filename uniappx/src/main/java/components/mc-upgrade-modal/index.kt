@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI09580B7
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
import io.dcloud.uniapp.extapi.downloadFile as uni_downloadFile
import io.dcloud.uniapp.extapi.installApk as uni_installApk
import uts.sdk.modules.xOpenweb.openWeb
open class GenComponentsMcUpgradeModalIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onBeforeMount(fun() {
            this.getAppInfo()
        }
        , __ins)
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_progress = resolveComponent("progress")
        val _component_mc_pain_button = resolveEasyComponent("mc-pain-button", GenComponentsMcPainButtonIndexClass)
        val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
        val _component_x_overlay = resolveEasyComponent("x-overlay", GenUniModulesTmxUiComponentsXOverlayXOverlayClass)
        return createVNode(_component_x_overlay, utsMapOf("show" to _ctx.isUpgrade, "onUpdate:show" to fun(`$event`: Boolean){
            _ctx.isUpgrade = `$event`
        }
        , "overlay-click" to !(_ctx.latestAppInfo?.upgradeType ?: false), "customContentStyle" to "width:90%;", "custom-style" to "display: flex;align-items: center;justify-content: center;"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
            return utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "modal-box"), utsArrayOf(
                    createElementVNode("image", utsMapOf("class" to "bg-img", "src" to ("/static/images/upgrade-modal-bg-" + _ctx.styleType + ".png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                        "src"
                    )),
                    createElementVNode("view", utsMapOf("class" to "content-box"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "title", "style" to normalizeStyle(utsMapOf("color" to _ctx.currentStyle.btnColor))), "发现新版本V" + toDisplayString(_ctx.latestAppInfo?.appVersion) + "！", 5),
                        createElementVNode("text", utsMapOf("class" to "sub-title", "style" to normalizeStyle(utsMapOf("color" to _ctx.currentStyle.btnColor))), "本次更新内容", 4),
                        createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("height" to "255rpx"))), utsArrayOf(
                            createElementVNode("rich-text", utsMapOf("nodes" to _ctx.latestAppInfo?.upgradeContent), null, 8, utsArrayOf(
                                "nodes"
                            ))
                        ), 4),
                        if (isTrue(!_ctx.showBtnGroup)) {
                            createElementVNode("view", utsMapOf("key" to 0, "class" to "progress-box"), utsArrayOf(
                                createVNode(_component_progress, utsMapOf("class" to "progress", "border-radius" to 35, "percent" to _ctx.percent, "activeColor" to _ctx.currentStyle.btnColor, "show-info" to true, "stroke-width" to 8), null, 8, utsArrayOf(
                                    "percent",
                                    "activeColor"
                                )),
                                createElementVNode("view", null, utsArrayOf(
                                    if (_ctx.percent < 100) {
                                        createElementVNode("text", utsMapOf("key" to 0, "class" to "down-text"), "正在下载，请稍后 (" + toDisplayString(_ctx.downloadedSize) + "/" + toDisplayString(_ctx.packageFileSize) + "M)", 1)
                                    } else {
                                        if (_ctx.percent == 100) {
                                            createElementVNode("text", utsMapOf("key" to 1, "class" to "down-text", "style" to normalizeStyle(utsMapOf("text-decoration-line" to "underline")), "onClick" to _ctx.installApk), "下载完成(共" + toDisplayString(_ctx.packageFileSize) + "M)，点击安装", 13, utsArrayOf(
                                                "onClick"
                                            ))
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                    }
                                ))
                            ))
                        } else {
                            createElementVNode("view", utsMapOf("key" to 1, "class" to "btn-group"), utsArrayOf(
                                createVNode(_component_mc_pain_button, utsMapOf("bg-color" to "#00000000", "border" to _ctx.currentStyle.btnBorder, "color" to _ctx.currentStyle.btnColor, "margin-right" to "30rpx", "onClick" to _ctx.confirm), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        toDisplayString(if (_ctx.canInstallApk) {
                                            "点击安装"
                                        } else {
                                            "直接下载"
                                        }
                                        )
                                    )
                                }
                                ), "_" to 1), 8, utsArrayOf(
                                    "border",
                                    "color",
                                    "onClick"
                                )),
                                createVNode(_component_mc_primary_button, utsMapOf("linear-colors" to _ctx.currentStyle.btnBgColor, "onClick" to _ctx.toStore), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        "去应用商店"
                                    )
                                }
                                ), "_" to 1), 8, utsArrayOf(
                                    "linear-colors",
                                    "onClick"
                                ))
                            ))
                        }
                    ))
                ))
            )
        }
        ), "_" to 1), 8, utsArrayOf(
            "show",
            "onUpdate:show",
            "overlay-click"
        ))
    }
    open var styleType: Number by `$props`
    open var canInstallApk: Boolean by `$data`
    open var version: Any? by `$data`
    open var percent: Number by `$data`
    open var showBtnGroup: Boolean by `$data`
    open var tempFilePath: String by `$data`
    open var downloadedSize: Number by `$data`
    open var packageFileSize: Number by `$data`
    open var screenHeight: Number by `$data`
    open var screenWidth: Number by `$data`
    open var isUpgrade: Boolean by `$data`
    open var latestAppInfo: AppVersionInfo? by `$data`
    open var currentStyle: StyleTypeItem by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("canInstallApk" to false, "version" to appVersion, "percent" to 0, "showBtnGroup" to true, "tempFilePath" to "", "downloadedSize" to 0, "packageFileSize" to 0, "screenHeight" to 0, "screenWidth" to 0, "isUpgrade" to false, "latestAppInfo" to null as AppVersionInfo?, "currentStyle" to computed<StyleTypeItem>(fun(): StyleTypeItem {
            return styleTypeList[this.styleType] as StyleTypeItem
        }
        ))
    }
    open var getAppInfo = ::gen_getAppInfo_fn
    open fun gen_getAppInfo_fn() {
        getLatestVersionDetail(1, appVersion).then(fun(res: Response){
            if (res.data != null) {
                val data = JSON.parse(JSON.stringify(res.data)) as UTSJSONObject
                val upgradeInfo = data.getAny("upgradeInfo")
                if (upgradeInfo != null) {
                    val appInfo = JSON.parse<AppVersionInfo>(JSON.stringify(upgradeInfo)) as AppVersionInfo
                    this.latestAppInfo = appInfo
                }
                val isUpgrade = data.getBoolean("isUpgrade") ?: false
                this.isUpgrade = isUpgrade
            }
            console.log("\u6700\u65B0\u7248\u672C[" + appVersion + "]\u7248\u672C\u4FE1\u606F\uFF1A", res)
        }
        )
    }
    open var toStore = ::gen_toStore_fn
    open fun gen_toStore_fn() {
        openWeb("market://details?id=com.mc.driver.client")
    }
    open var confirm = ::gen_confirm_fn
    open fun gen_confirm_fn() {
        if (this.percent == 100) {
            this.installApk()
            return
        }
        if (this.latestAppInfo?.downloadUrl?.includes(".apk") ?: false) {
            this.download()
        } else {
            showTips("下载地址错误，必须以.apk结尾", "error")
        }
    }
    open var installApk = ::gen_installApk_fn
    open fun gen_installApk_fn() {
        uni_installApk(InstallApkOptions(filePath = this.tempFilePath, complete = fun(_){}))
    }
    open var download = ::gen_download_fn
    open fun gen_download_fn() {
        this.showBtnGroup = false
        val downloadTask = uni_downloadFile(DownloadFileOptions(url = this.latestAppInfo?.downloadUrl ?: "", success = fun(res){
            if (res.statusCode == 200) {
                this.tempFilePath = res.tempFilePath
                this.canInstallApk = true
                this.installApk()
            }
        }
        ))
        downloadTask.onProgressUpdate(fun(res){
            this.percent = parseInt(res.progress.toFixed(0))
            this.downloadedSize = parseFloat((res.totalBytesWritten / Math.pow(1024, 2)).toFixed(2))
            this.packageFileSize = parseFloat((res.totalBytesExpectedToWrite / Math.pow(1024, 2)).toFixed(2))
        }
        )
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("modal-box" to padStyleMapOf(utsMapOf("position" to "relative", "width" to "100%")), "bg-img" to utsMapOf(".modal-box " to utsMapOf("height" to "auto", "width" to "100%", "zIndex" to 1)), "content-box" to utsMapOf(".modal-box " to utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "zIndex" to 2, "width" to "100%", "height" to "100%", "boxSizing" to "border-box", "fontWeight" to "bold", "paddingTop" to "160rpx", "paddingRight" to "30rpx", "paddingBottom" to "50rpx", "paddingLeft" to "30rpx")), "title" to utsMapOf(".modal-box .content-box " to utsMapOf("textAlign" to "center", "fontWeight" to "bold", "fontSize" to "34rpx")), "sub-title" to utsMapOf(".modal-box .content-box " to utsMapOf("paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "textAlign" to "center", "fontSize" to "30rpx", "opacity" to 0.8)), "progress-box" to utsMapOf(".modal-box .content-box " to utsMapOf("boxSizing" to "border-box", "paddingTop" to "5rpx", "paddingRight" to 0, "paddingBottom" to "5rpx", "paddingLeft" to 0, "height" to "80rpx", "width" to "100%")), "progress" to utsMapOf(".modal-box .content-box .progress-box " to utsMapOf("width" to "83%", "height" to "40rpx", "borderTopLeftRadius" to 35, "borderTopRightRadius" to 35, "borderBottomRightRadius" to 35, "borderBottomLeftRadius" to 35)), "down-text" to utsMapOf(".modal-box .content-box .progress-box " to utsMapOf("paddingTop" to "5rpx", "fontSize" to "26rpx", "textAlign" to "center")), "btn-group" to utsMapOf(".modal-box .content-box " to utsMapOf("flexDirection" to "row")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf("styleType" to utsMapOf("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = utsArrayOf(
            "styleType"
        )
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
