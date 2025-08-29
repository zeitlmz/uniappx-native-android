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
        return _cV(_component_x_overlay, _uM("show" to _ctx.isUpgrade, "onUpdate:show" to fun(`$event`: Boolean){
            _ctx.isUpgrade = `$event`
        }
        , "overlay-click" to !(_ctx.latestAppInfo?.upgradeType ?: false), "customContentStyle" to "width:90%;", "custom-style" to "display: flex;align-items: center;justify-content: center;"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
            return _uA(
                _cE("view", _uM("class" to "modal-box"), _uA(
                    _cE("image", _uM("class" to "bg-img", "src" to ("/static/images/upgrade-modal-bg-" + _ctx.styleType + ".png"), "mode" to "widthFix"), null, 8, _uA(
                        "src"
                    )),
                    _cE("view", _uM("class" to "content-box"), _uA(
                        _cE("text", _uM("class" to "title", "style" to _nS(_uM("color" to _ctx.currentStyle.btnColor))), "发现新版本V" + _tD(_ctx.latestAppInfo?.appVersion) + "！", 5),
                        _cE("text", _uM("class" to "sub-title", "style" to _nS(_uM("color" to _ctx.currentStyle.btnColor))), "本次更新内容", 4),
                        _cE("scroll-view", _uM("style" to _nS(_uM("height" to "255rpx"))), _uA(
                            _cE("rich-text", _uM("nodes" to _ctx.latestAppInfo?.upgradeContent), null, 8, _uA(
                                "nodes"
                            ))
                        ), 4),
                        if (isTrue(!_ctx.showBtnGroup)) {
                            _cE("view", _uM("key" to 0, "class" to "progress-box"), _uA(
                                _cV(_component_progress, _uM("class" to "progress", "border-radius" to 35, "percent" to _ctx.percent, "activeColor" to _ctx.currentStyle.btnColor, "show-info" to true, "stroke-width" to 8), null, 8, _uA(
                                    "percent",
                                    "activeColor"
                                )),
                                _cE("view", null, _uA(
                                    if (_ctx.percent < 100) {
                                        _cE("text", _uM("key" to 0, "class" to "down-text"), "正在下载，请稍后 (" + _tD(_ctx.downloadedSize) + "/" + _tD(_ctx.packageFileSize) + "M)", 1)
                                    } else {
                                        if (_ctx.percent == 100) {
                                            _cE("text", _uM("key" to 1, "class" to "down-text", "style" to _nS(_uM("text-decoration-line" to "underline")), "onClick" to _ctx.installApk), "下载完成(共" + _tD(_ctx.packageFileSize) + "M)，点击安装", 13, _uA(
                                                "onClick"
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    }
                                ))
                            ))
                        } else {
                            _cE("view", _uM("key" to 1, "class" to "btn-group"), _uA(
                                _cV(_component_mc_pain_button, _uM("bg-color" to "#00000000", "border" to _ctx.currentStyle.btnBorder, "color" to _ctx.currentStyle.btnColor, "margin-right" to "30rpx", "onClick" to _ctx.confirm), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(if (_ctx.canInstallApk) {
                                            "点击安装"
                                        } else {
                                            "直接下载"
                                        }
                                        )
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "border",
                                    "color",
                                    "onClick"
                                )),
                                _cV(_component_mc_primary_button, _uM("linear-colors" to _ctx.currentStyle.btnBgColor, "onClick" to _ctx.toStore), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "去应用商店"
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "linear-colors",
                                    "onClick"
                                ))
                            ))
                        }
                    ))
                ))
            )
        }
        ), "_" to 1), 8, _uA(
            "show",
            "onUpdate:show",
            "overlay-click"
        ))
    }
    open var styleType: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
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
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "canInstallApk" to false, "version" to appVersion, "percent" to 0, "showBtnGroup" to true, "tempFilePath" to "", "downloadedSize" to 0, "packageFileSize" to 0, "screenHeight" to 0, "screenWidth" to 0, "isUpgrade" to false, "latestAppInfo" to null as AppVersionInfo?, "currentStyle" to computed<StyleTypeItem>(fun(): StyleTypeItem {
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
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("modal-box" to _pS(_uM("position" to "relative", "width" to "100%")), "bg-img" to _uM(".modal-box " to _uM("height" to "auto", "width" to "100%", "zIndex" to 1)), "content-box" to _uM(".modal-box " to _uM("position" to "absolute", "top" to 0, "left" to 0, "zIndex" to 2, "width" to "100%", "height" to "100%", "boxSizing" to "border-box", "fontWeight" to "bold", "paddingTop" to "160rpx", "paddingRight" to "30rpx", "paddingBottom" to "50rpx", "paddingLeft" to "30rpx")), "title" to _uM(".modal-box .content-box " to _uM("textAlign" to "center", "fontWeight" to "bold", "fontSize" to "34rpx")), "sub-title" to _uM(".modal-box .content-box " to _uM("paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "textAlign" to "center", "fontSize" to "30rpx", "opacity" to 0.8)), "progress-box" to _uM(".modal-box .content-box " to _uM("boxSizing" to "border-box", "paddingTop" to "5rpx", "paddingRight" to 0, "paddingBottom" to "5rpx", "paddingLeft" to 0, "height" to "80rpx", "width" to "100%")), "progress" to _uM(".modal-box .content-box .progress-box " to _uM("width" to "83%", "height" to "40rpx", "borderTopLeftRadius" to 35, "borderTopRightRadius" to 35, "borderBottomRightRadius" to 35, "borderBottomLeftRadius" to 35)), "down-text" to _uM(".modal-box .content-box .progress-box " to _uM("paddingTop" to "5rpx", "fontSize" to "26rpx", "textAlign" to "center")), "btn-group" to _uM(".modal-box .content-box " to _uM("flexDirection" to "row")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("styleType" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "styleType"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
