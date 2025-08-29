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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import uts.sdk.modules.mcWechatSdk.WeChatShare
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xToastS.XTOAST_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import io.dcloud.uniapp.extapi.saveImageToPhotosAlbum as uni_saveImageToPhotosAlbum
import uts.sdk.modules.xToastS.showToast as showXToast
import uts.sdk.modules.xBase642fileS.toPngFile
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalPromotionIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop
            uni__emit("onPageScroll", e.scrollTop)
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
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesPersonalPromotionIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalPromotionIndex
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val cacheUserInfo = ref<Any?>(null)
            val globalData = inject("globalData") as GlobalDataType
            val promotionCount = ref<Number>(1)
            val promotionPersons = ref<Number>(20)
            val totalReward = ref<Number>(5.11)
            val promotionRewardAmount = ref<Number>(0)
            val activityPromotionSrc = ref<String>("")
            val showValidModal = ref<Boolean>(false)
            val showAgreeModal = ref<Boolean>(false)
            val rankingList = ref(_uA<RankingInfo>())
            val fetchPromotionReward = fun(){
                getPromotionReward().then(fun(res: Response){
                    if (res.code == 200) {
                        promotionRewardAmount.value = parseFloat(res.data as String)
                    }
                }
                )
            }
            val fetchUserPromotionData = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        try {
                            showLoading(XLOADINGS_TYPE(title = "加载中..."))
                            val res = await(getUserPromotionData())
                            if (res.code === 200) {
                                val resultData = res.data as UTSJSONObject
                                promotionCount.value = resultData.getNumber("selfRankNo") ?: -1
                                promotionPersons.value = resultData.getNumber("selfShareCount") ?: 0
                                totalReward.value = resultData.getNumber("selfPromotionIncome") ?: 0
                                rankingList.value = JSON.parse<UTSArray<RankingInfo>>(JSON.stringify(resultData.getArray("tops"))) ?: _uA()
                            }
                            hideXloading()
                        }
                         catch (error: Throwable) {
                            hideXloading()
                            showToast("获取用户推广数据失败", "error")
                        }
                })
            }
            val handlePromotion = fun(){
                WeChatShare.getInstance().addTitle("更省钱 更快捷 更安全").addDescription("邀请新用户分享").addImageBitmapPath(miniProgramCover).addWebpageUrl("http://uniapp.dcloud.io").shareMiniProgram()
            }
            val saveImageToAlbum = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w@{
                        if (!getPhotoAgreeStatus()) {
                            showAgreeModal.value = true
                            return@w
                        }
                        try {
                            showLoading(XLOADINGS_TYPE(title = "保存中..."))
                            val filePath = await(toPngFile(activityPromotionSrc.value))
                            uni_saveImageToPhotosAlbum(SaveImageToPhotosAlbumOptions(filePath = filePath, success = fun(_) {
                                showToast("海报已保存到相册", "success")
                            }
                            , fail = fun(_) {
                                showToast("海报保存相册失败", "error")
                            }
                            , complete = fun(_) {
                                hideXloading()
                            }
                            ))
                        }
                         catch (error: Throwable) {
                            hideXloading()
                            showToast("保存图片失败", "error")
                        }
                })
            }
            val generatePoster = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        try {
                            showLoading(XLOADINGS_TYPE(title = "生成中..."))
                            val res = await(generatePromotionPoster())
                            if (res.code === 200) {
                                showValidModal.value = false
                                setTimeout(fun(){
                                    showValidModal.value = true
                                }
                                , 100)
                                activityPromotionSrc.value = res.data as String
                            }
                            hideXloading()
                        }
                         catch (error: Throwable) {
                            hideXloading()
                            showTips("生成推广海报失败", "success")
                        }
                })
            }
            val goToRecord = fun(){
                router.push("/pages/personal/promotion/record/index")
            }
            val agreeCancel = fun(){
                showXToast(XTOAST_TYPE(title = "您已拒绝媒体访问权限申请，将无法保存推广海报到本地相册", iconCode = "info", iconColor = "#ff8900", duration = 3000))
            }
            val agreeConfirm = fun(){
                setPhotoAgreeStatus()
                saveImageToAlbum()
            }
            onReady(fun(){
                fetchUserPromotionData()
                fetchPromotionReward()
                WeChatShare.getInstance().addImageBitmapPath(miniProgramCover)
            }
            )
            return fun(): Any? {
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                val _component_x_overlay = resolveEasyComponent("x-overlay", GenUniModulesTmxUiComponentsXOverlayXOverlayClass)
                val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_mc_base_container, _uM("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to true, "title" to "推广奖励", "title-color" to "#F5F7FA"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("style" to _nS("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                            _cE("view", _uM("class" to "home-bg"), _uA(
                                _cE("image", _uM("class" to "bg-image", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-bg.png"), "mode" to "widthFix"), null, 8, _uA(
                                    "src"
                                ))
                            )),
                            _cE("view", _uM("class" to "container", "style" to _nS("height: " + (unref(screenHeight) + 410) + "px")), _uA(
                                _cE("view", _uM("class" to "promotion-card"), _uA(
                                    _cE("view", _uM("class" to "promotion-content"), _uA(
                                        _cE("view", _uM("class" to "promo-reward-box"), _uA(
                                            _cE("text", _uM("class" to "promotion-desc"), "每推荐1个新用户，"),
                                            _cE("text", _uM("class" to "promotion-desc"), "登录每橙专车小程序，你可赚取现金奖励"),
                                            _cE("view", _uM("class" to "promotion-money"), _uA(
                                                _cE("view", _uM("class" to "reward-amount"), _uA(
                                                    _cE("text", _uM("class" to "amount"), _tD(unref(promotionRewardAmount) ?: "---"), 1)
                                                )),
                                                _cE("view", _uM("class" to "unit"), _uA(
                                                    _cV(_component_x_text, _uM("class" to "unit-text", "color" to "#D31B01"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            "元"
                                                        )
                                                    }
                                                    ), "_" to 1))
                                                ))
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "promotion-buttons"), _uA(
                                            _cE("view", _uM("class" to "promo-button promote-now", "onClick" to handlePromotion), _uA(
                                                _cE("text", _uM("class" to "button-text"), "立即推广")
                                            ))
                                        ))
                                    ))
                                )),
                                _cE("view", _uM("class" to "reward-card"), _uA(
                                    _cE("image", _uM("style" to _nS(_uM("width" to "100%", "position" to "absolute")), "src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-awrod.png"), "mode" to "widthFix"), null, 12, _uA(
                                        "src"
                                    )),
                                    _cE("view", _uM("class" to "reward-title"), _uA(
                                        _cE("view", _uM("class" to "view-record", "onClick" to goToRecord), _uA(
                                            _cE("view", _uM("class" to "record-icon"), _uA(
                                                _cE("image", _uM("src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-record.png"), "mode" to "aspectFit", "class" to "arrow-icon"), null, 8, _uA(
                                                    "src"
                                                ))
                                            )),
                                            _cE("text", _uM("class" to "record-text", "style" to _nS(_uM<String, Any?>())), "推广记录", 4)
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "reward-stats"), _uA(
                                        _cE("view", _uM("class" to "stat-item"), _uA(
                                            _cE("view", _uM("class" to "stat-item-bg")),
                                            _cE("text", _uM("class" to "stat-value"), _tD(if ((unref(promotionCount) != null && unref(promotionCount) <= 0)) {
                                                "-"
                                            } else {
                                                unref(promotionCount)
                                            }
                                            ), 1),
                                            _cE("text", _uM("class" to "stat-label"), "推广排行")
                                        )),
                                        _cE("view", _uM("class" to "stat-item border-lr"), _uA(
                                            _cE("view", _uM("class" to "stat-item-bg")),
                                            _cE("text", _uM("class" to "stat-value"), _tD(unref(promotionPersons) ?: "---"), 1),
                                            _cE("text", _uM("class" to "stat-label"), "推广人数")
                                        )),
                                        _cE("view", _uM("class" to "stat-item"), _uA(
                                            _cE("view", _uM("class" to "stat-item-bg")),
                                            _cE("text", _uM("class" to "stat-value"), _tD(unref(totalReward) ?: "---"), 1),
                                            _cE("text", _uM("class" to "stat-label"), "获取收益")
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "ranking-header"), _uA(
                                        _cE("image", _uM("class" to "ranking-header-img", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-rank.png"), "mode" to "widthFix"), null, 8, _uA(
                                            "src"
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "ranking-list"), _uA(
                                        _cE("view", _uM("class" to "ranking-item"), _uA(
                                            _cE("view", _uM("class" to "ranking-medal"), _uA(
                                                _cE("image", _uM("src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-rank-2.png"), "mode" to "aspectFit", "class" to "medal-icon"), null, 8, _uA(
                                                    "src"
                                                ))
                                            )),
                                            if (unref(rankingList).length >= 2) {
                                                _cE("view", _uM("key" to 0, "class" to "user-info"), _uA(
                                                    _cE("text", _uM("class" to "user-name"), _tD(unref(rankingList)[1].maskedPhone), 1)
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            }
                                            ,
                                            if (unref(rankingList).length >= 2) {
                                                _cE("text", _uM("key" to 1, "class" to "user-count"), _tD(unref(rankingList)[1].inviteCount) + "人", 1)
                                            } else {
                                                _cC("v-if", true)
                                            }
                                            ,
                                            if (unref(rankingList).length < 2) {
                                                _cE("text", _uM("key" to 2, "class" to "user-count mt-5"), "--")
                                            } else {
                                                _cC("v-if", true)
                                            }
                                        )),
                                        if (unref(rankingList).length >= 1) {
                                            _cE("view", _uM("key" to 0, "class" to "ranking-item", "style" to _nS(_uM("margin-top" to "-60rpx"))), _uA(
                                                _cE("view", _uM("class" to "ranking-medal"), _uA(
                                                    _cE("image", _uM("src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-rank-1.png"), "mode" to "aspectFit", "class" to "medal-icon"), null, 8, _uA(
                                                        "src"
                                                    ))
                                                )),
                                                _cE("view", _uM("class" to "user-info"), _uA(
                                                    _cE("text", _uM("class" to "user-name"), _tD(unref(rankingList)[0].maskedPhone), 1)
                                                )),
                                                _cE("text", _uM("class" to "user-count"), _tD(unref(rankingList)[0].inviteCount) + "人", 1)
                                            ), 4)
                                        } else {
                                            _cC("v-if", true)
                                        }
                                        ,
                                        _cE("view", _uM("class" to "ranking-item"), _uA(
                                            _cE("view", _uM("class" to "ranking-medal"), _uA(
                                                _cE("image", _uM("src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-rank-3.png"), "mode" to "aspectFit", "class" to "medal-icon"), null, 8, _uA(
                                                    "src"
                                                ))
                                            )),
                                            if (unref(rankingList).length >= 3) {
                                                _cE("view", _uM("key" to 0, "class" to "user-info"), _uA(
                                                    _cE("text", _uM("class" to "user-name"), _tD(unref(rankingList)[2].maskedPhone), 1)
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            }
                                            ,
                                            if (unref(rankingList).length >= 3) {
                                                _cE("text", _uM("key" to 1, "class" to "user-count"), _tD(unref(rankingList)[2].inviteCount) + "人", 1)
                                            } else {
                                                _cC("v-if", true)
                                            }
                                            ,
                                            if (unref(rankingList).length < 3) {
                                                _cE("text", _uM("key" to 2, "class" to "user-count mt-5"), "--")
                                            } else {
                                                _cC("v-if", true)
                                            }
                                        ))
                                    ))
                                )),
                                _cE("view", _uM("class" to "promotion-buttons", "style" to _nS(_uM("width" to "100%"))), _uA(
                                    _cE("view", _uM("class" to "promo-button generate-poster", "onClick" to generatePoster), _uA(
                                        _cE("text", _uM("class" to "button-text"), "生成推广海报")
                                    ))
                                ), 4)
                            ), 4)
                        )
                    }
                    ), "_" to 1)),
                    _cV(_component_x_overlay, _uM("show" to unref(showValidModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showValidModal, `$event`)
                    }
                    , "show-close" to true, "z-index" to 100, "overlayClick" to false, "custom-style" to "display: flex;align-items: center;justify-content: center;flex-direction: column;"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "poster-container"), _uA(
                                _cE("image", _uM("src" to unref(activityPromotionSrc), "mode" to "widthFix", "onLongpress" to saveImageToAlbum), null, 40, _uA(
                                    "src"
                                )),
                                _cE("text", _uM("class" to "save-tip"), "长按可保存至本地相册")
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    )),
                    _cV(_component_x_modal, _uM("show" to unref(showAgreeModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showAgreeModal, `$event`)
                    }
                    , "bgColor" to "#ECF1F8", "cancel-text" to "拒绝", "overlay-click" to false, "onCancel" to agreeCancel, "confirm-text" to "同意", "onConfirm" to agreeConfirm, "show-title" to false, "height" to "500rpx"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("text", _uM("class" to "photo-agree-title"), "媒体访问权限申请"),
                            _cE("view", _uM("class" to "desc"), _uA(
                                _cE("text", _uM("class" to "pb-10"), "我们获取您手机的媒体访问权限是用于保存推广海报到本地相册。"),
                                _cE("text", null, "如果您拒绝我们获取您的上述权限，将导致您无法保存推广海报到本地相册。"),
                                _cE("text", _uM("style" to _nS(_uM("color" to "red"))), "本APP提供了撤回系统权限的功能，具体路径:个人中心(登录后点击右上角)-设置-账户与安全-权限管理。", 4)
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    ))
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("container" to _pS(_uM("width" to "100%", "height" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 20)), "home-bg" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "height" to "100%", "zIndex" to -1)), "bg-image" to _uM(".home-bg " to _uM("width" to "100%", "height" to "100%", "position" to "absolute", "top" to 0, "left" to 0)), "promotion-card" to _pS(_uM("borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "marginBottom" to 15, "paddingTop" to 20, "paddingRight" to 15, "paddingBottom" to 20, "paddingLeft" to 15, "boxShadow" to "0 2px 10px rgba(0, 0, 0, 0.05)", "backgroundColor" to "rgba(0,0,0,0)", "marginTop" to "800rpx")), "promotion-title" to _pS(_uM("textAlign" to "center", "marginBottom" to 20)), "title-text" to _uM(".promotion-title " to _uM("fontSize" to 20, "fontWeight" to "bold", "color" to "#FF6B00"), ".reward-title " to _uM("fontSize" to 16, "fontWeight" to "bold", "color" to "#333333")), "promotion-subtitle" to _pS(_uM("marginTop" to 5)), "subtitle-text" to _uM(".promotion-subtitle " to _uM("fontSize" to 14, "color" to "#999999")), "promotion-content" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "backgroundColor" to "rgba(0,0,0,0)")), "promo-reward-box" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "backgroundColor" to "rgba(0,0,0,0)", "width" to "100%", "paddingTop" to 10, "paddingRight" to 0, "paddingBottom" to 10, "paddingLeft" to 0)), "promotion-desc" to _pS(_uM("textAlign" to "center", "color" to "#D31B01", "fontSize" to "30rpx", "fontWeight" to "bold")), "promotion-money" to _pS(_uM("marginTop" to "20rpx", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "unit" to _uM(".promotion-money " to _uM("marginTop" to "34rpx"), ".reward-amount " to _uM("fontSize" to 16, "color" to "#FF6B00", "marginLeft" to 5)), "reward-amount" to _pS(_uM("display" to "flex", "flexDirection" to "row", "marginTop" to 10, "marginRight" to 0, "marginBottom" to 10, "marginLeft" to 0)), "amount" to _uM(".reward-amount " to _uM("fontSize" to "90rpx", "fontWeight" to "bold", "color" to "#D31B01")), "unit-text" to _uM(".reward-amount " to _uM("fontWeight" to "bold", "color" to "#D31B01", "fontSize" to "34rpx")), "promotion-buttons" to _pS(_uM("display" to "flex", "flexDirection" to "row", "width" to "90%")), "promo-button" to _pS(_uM("flex" to 1, "height" to 45, "borderTopLeftRadius" to 22.5, "borderTopRightRadius" to 22.5, "borderBottomRightRadius" to 22.5, "borderBottomLeftRadius" to 22.5, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "marginTop" to 0, "marginRight" to 8, "marginBottom" to 0, "marginLeft" to 8)), "promote-now" to _pS(_uM("backgroundColor" to "#FF6B00")), "button-text" to _uM(".promote-now " to _uM("color" to "#FFFFFF", "fontSize" to 16, "fontWeight" to "bold"), ".generate-poster " to _uM("color" to "#ffffff", "fontSize" to 16, "fontWeight" to "bold")), "generate-poster" to _pS(_uM("backgroundColor" to "#FF6B00", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FF6B00", "borderRightColor" to "#FF6B00", "borderBottomColor" to "#FF6B00", "borderLeftColor" to "#FF6B00", "marginTop" to "13rpx")), "reward-card" to _pS(_uM("borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "marginBottom" to 15, "boxShadow" to "0 2px 10px rgba(0, 0, 0, 0.05)", "flexDirection" to "column", "alignItems" to "center", "width" to "100%", "backgroundColor" to "rgba(0,0,0,0)", "marginTop" to "300rpx")), "reward-title" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "flex-end", "marginBottom" to 15, "marginTop" to "40rpx", "right" to 20, "position" to "absolute")), "view-record" to _uM(".reward-title " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "flex-end")), "record-text" to _uM(".reward-title .view-record " to _uM("color" to "#FE3308", "fontWeight" to "bold", "fontSize" to "23rpx", "fontFamily" to "PingFang SC")), "record-icon" to _uM(".reward-title .view-record " to _uM("marginLeft" to 5)), "arrow-icon" to _uM(".reward-title .view-record .record-icon " to _uM("width" to 16, "height" to 16)), "reward-stats" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-around", "marginTop" to "130rpx")), "stat-item" to _uM(".reward-stats " to _uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "marginTop" to 0, "marginRight" to "10rpx", "marginBottom" to 0, "marginLeft" to "10rpx", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "borderTopWidth" to 0, "borderRightWidth" to 0, "borderBottomWidth" to 0, "borderLeftWidth" to 0, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FC9329", "borderRightColor" to "#FC9329", "borderBottomColor" to "#FC9329", "borderLeftColor" to "#FC9329", "width" to "185rpx", "height" to "133rpx")), "stat-item-bg" to _uM(".reward-stats .stat-item " to _uM("position" to "absolute", "top" to 0, "left" to 0, "height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #FFFFFF, #FFF1CD)")), "stat-value" to _uM(".reward-stats .stat-item " to _uM("fontSize" to 24, "fontWeight" to "bold", "color" to "#FE3408", "marginBottom" to 5, "marginTop" to 8)), "stat-label" to _uM(".reward-stats .stat-item " to _uM("fontSize" to 14, "color" to "#000000")), "border-lr" to _uM(".reward-stats " to _uM("borderLeftWidth" to 1, "borderLeftStyle" to "solid", "borderLeftColor" to "#EEEEEE", "borderRightWidth" to 1, "borderRightStyle" to "solid", "borderRightColor" to "#EEEEEE")), "ranking-card" to _pS(_uM("backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "paddingTop" to 0, "paddingRight" to 0, "paddingBottom" to 15, "paddingLeft" to 0, "boxShadow" to "0 2px 10px rgba(0, 0, 0, 0.05)", "overflow" to "hidden")), "ranking-header" to _pS(_uM("width" to "540rpx", "height" to "35rpx", "position" to "relative", "marginTop" to "30rpx")), "ranking-header-img" to _uM(".ranking-header " to _uM("width" to "100%", "height" to "100%", "position" to "absolute", "top" to 0, "left" to 0)), "ranking-list" to _pS(_uM("paddingTop" to "60rpx", "paddingRight" to 15, "paddingBottom" to "60rpx", "paddingLeft" to 15, "flexDirection" to "row", "alignItems" to "center", "marginTop" to "20rpx")), "ranking-item" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "textAlign" to "center", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#F5F5F5", "marginTop" to 0, "marginRight" to 13, "marginBottom" to 0, "marginLeft" to 13)), "ranking-medal" to _pS(_uM("width" to "130rpx", "height" to "75rpx", "marginRight" to 10)), "medal-icon" to _uM(".ranking-medal " to _uM("width" to "100%", "height" to "100%")), "user-info" to _pS(_uM("marginTop" to "5rpx", "marginLeft" to "-17rpx")), "user-name" to _uM(".user-info " to _uM("fontSize" to "23rpx", "color" to "#7C7C7C")), "user-count" to _pS(_uM("marginLeft" to "-17rpx", "fontSize" to "35rpx", "color" to "#FE3408", "fontWeight" to "bold")), "poster-container" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center")), "save-tip" to _pS(_uM("marginTop" to "20rpx", "fontSize" to "28rpx", "color" to "#FFFFFF", "textAlign" to "center")), "photo-agree-title" to _pS(_uM("textAlign" to "center", "width" to "100%", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
