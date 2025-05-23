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
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import io.dcloud.uniapp.extapi.saveImageToPhotosAlbum as uni_saveImageToPhotosAlbum
import uts.sdk.modules.xBase642fileS.toPngFile
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalPromotionIndex : BasePage {
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
            val rankingList = ref(utsArrayOf<RankingInfo>())
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
                                rankingList.value = JSON.parse<UTSArray<RankingInfo>>(JSON.stringify(resultData.getArray("tops"))) ?: utsArrayOf()
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
                return wrapUTSPromise(suspend {
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
                return createElementVNode(Fragment, null, utsArrayOf(
                    createVNode(_component_mc_base_container, utsMapOf("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to true, "title" to "推广奖励", "title-color" to "#F5F7FA"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("view", utsMapOf("style" to normalizeStyle("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                            createElementVNode("view", utsMapOf("class" to "home-bg"), utsArrayOf(
                                createElementVNode("image", utsMapOf("class" to "bg-image", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-bg.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                    "src"
                                ))
                            )),
                            createElementVNode("view", utsMapOf("class" to "container", "style" to normalizeStyle("height: " + (unref(screenHeight) + 410) + "px")), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "promotion-card"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "promotion-content"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "promo-reward-box"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "promotion-desc"), "每推荐1个新用户，"),
                                            createElementVNode("text", utsMapOf("class" to "promotion-desc"), "登录每橙专车小程序，你可赚取现金奖励"),
                                            createElementVNode("view", utsMapOf("class" to "promotion-money"), utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "reward-amount"), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "amount"), toDisplayString(unref(promotionRewardAmount) ?: "---"), 1)
                                                )),
                                                createElementVNode("view", utsMapOf("class" to "unit"), utsArrayOf(
                                                    createVNode(_component_x_text, utsMapOf("class" to "unit-text", "color" to "#D31B01"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return utsArrayOf(
                                                            "元"
                                                        )
                                                    }
                                                    ), "_" to 1))
                                                ))
                                            ))
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "promotion-buttons"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "promo-button promote-now", "onClick" to handlePromotion), utsArrayOf(
                                                createElementVNode("text", utsMapOf("class" to "button-text"), "立即推广")
                                            ))
                                        ))
                                    ))
                                )),
                                createElementVNode("view", utsMapOf("class" to "reward-card"), utsArrayOf(
                                    createElementVNode("image", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "100%", "position" to "absolute")), "src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-awrod.png"), "mode" to "widthFix"), null, 12, utsArrayOf(
                                        "src"
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "reward-title"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "view-record", "onClick" to goToRecord), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "record-icon"), utsArrayOf(
                                                createElementVNode("image", utsMapOf("src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-record.png"), "mode" to "aspectFit", "class" to "arrow-icon"), null, 8, utsArrayOf(
                                                    "src"
                                                ))
                                            )),
                                            createElementVNode("text", utsMapOf("class" to "record-text", "style" to normalizeStyle(utsMapOf<String, Any?>())), "推广记录", 4)
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "reward-stats"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "stat-item"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "stat-item-bg")),
                                            createElementVNode("text", utsMapOf("class" to "stat-value"), toDisplayString(if ((unref(promotionCount) != null && unref(promotionCount) <= 0)) {
                                                "-"
                                            } else {
                                                unref(promotionCount)
                                            }
                                            ), 1),
                                            createElementVNode("text", utsMapOf("class" to "stat-label"), "推广排行")
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "stat-item border-lr"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "stat-item-bg")),
                                            createElementVNode("text", utsMapOf("class" to "stat-value"), toDisplayString(unref(promotionPersons) ?: "---"), 1),
                                            createElementVNode("text", utsMapOf("class" to "stat-label"), "推广人数")
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "stat-item"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "stat-item-bg")),
                                            createElementVNode("text", utsMapOf("class" to "stat-value"), toDisplayString(unref(totalReward) ?: "---"), 1),
                                            createElementVNode("text", utsMapOf("class" to "stat-label"), "获取收益")
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "ranking-header"), utsArrayOf(
                                        createElementVNode("image", utsMapOf("class" to "ranking-header-img", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-rank.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                            "src"
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "ranking-list"), utsArrayOf(
                                        if (unref(rankingList).length >= 2) {
                                            createElementVNode("view", utsMapOf("key" to 0, "class" to "ranking-item"), utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "ranking-medal"), utsArrayOf(
                                                    createElementVNode("image", utsMapOf("src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-rank-2.png"), "mode" to "aspectFit", "class" to "medal-icon"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                )),
                                                createElementVNode("view", utsMapOf("class" to "user-info"), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "user-name"), toDisplayString(unref(rankingList)[1].maskedPhone), 1)
                                                )),
                                                createElementVNode("text", utsMapOf("class" to "user-count"), toDisplayString(unref(rankingList)[1].inviteCount) + "人", 1)
                                            ))
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                        ,
                                        if (unref(rankingList).length >= 1) {
                                            createElementVNode("view", utsMapOf("key" to 1, "class" to "ranking-item", "style" to normalizeStyle(utsMapOf("margin-top" to "-100rpx"))), utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "ranking-medal"), utsArrayOf(
                                                    createElementVNode("image", utsMapOf("src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-rank-1.png"), "mode" to "aspectFit", "class" to "medal-icon"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                )),
                                                createElementVNode("view", utsMapOf("class" to "user-info"), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "user-name"), toDisplayString(unref(rankingList)[0].maskedPhone), 1)
                                                )),
                                                createElementVNode("text", utsMapOf("class" to "user-count"), toDisplayString(unref(rankingList)[0].inviteCount) + "人", 1)
                                            ), 4)
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                        ,
                                        if (unref(rankingList).length >= 3) {
                                            createElementVNode("view", utsMapOf("key" to 2, "class" to "ranking-item"), utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "ranking-medal"), utsArrayOf(
                                                    createElementVNode("image", utsMapOf("src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-rank-3.png"), "mode" to "aspectFit", "class" to "medal-icon"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                )),
                                                createElementVNode("view", utsMapOf("class" to "user-info"), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "user-name"), toDisplayString(unref(rankingList)[2].maskedPhone), 1)
                                                )),
                                                createElementVNode("text", utsMapOf("class" to "user-count"), toDisplayString(unref(rankingList)[2].inviteCount) + "人", 1)
                                            ))
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                    ))
                                )),
                                createElementVNode("view", utsMapOf("class" to "promotion-buttons", "style" to normalizeStyle(utsMapOf("width" to "100%"))), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "promo-button generate-poster", "onClick" to generatePoster), utsArrayOf(
                                        createElementVNode("text", utsMapOf("class" to "button-text"), "生成推广海报")
                                    ))
                                ), 4)
                            ), 4)
                        )
                    }
                    ), "_" to 1)),
                    createVNode(_component_x_overlay, utsMapOf("show" to unref(showValidModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showValidModal, `$event`)
                    }
                    , "show-close" to true, "z-index" to 100, "overlayClick" to false, "custom-style" to "display: flex;align-items: center;justify-content: center;flex-direction: column;"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "poster-container"), utsArrayOf(
                                createElementVNode("image", utsMapOf("src" to unref(activityPromotionSrc), "mode" to "widthFix", "onLongpress" to saveImageToAlbum), null, 40, utsArrayOf(
                                    "src"
                                )),
                                createElementVNode("text", utsMapOf("class" to "save-tip"), "长按可保存至本地相册")
                            ))
                        )
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "show"
                    ))
                ), 64)
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
                return utsMapOf("container" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 20)), "home-bg" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "height" to "100%", "zIndex" to -1)), "bg-image" to utsMapOf(".home-bg " to utsMapOf("width" to "100%", "height" to "100%", "position" to "absolute", "top" to 0, "left" to 0)), "promotion-card" to padStyleMapOf(utsMapOf("borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "marginBottom" to 15, "paddingTop" to 20, "paddingRight" to 15, "paddingBottom" to 20, "paddingLeft" to 15, "boxShadow" to "0 2px 10px rgba(0, 0, 0, 0.05)", "backgroundColor" to "rgba(0,0,0,0)", "marginTop" to "800rpx")), "promotion-title" to padStyleMapOf(utsMapOf("textAlign" to "center", "marginBottom" to 20)), "title-text" to utsMapOf(".promotion-title " to utsMapOf("fontSize" to 20, "fontWeight" to "bold", "color" to "#FF6B00"), ".reward-title " to utsMapOf("fontSize" to 16, "fontWeight" to "bold", "color" to "#333333")), "promotion-subtitle" to padStyleMapOf(utsMapOf("marginTop" to 5)), "subtitle-text" to utsMapOf(".promotion-subtitle " to utsMapOf("fontSize" to 14, "color" to "#999999")), "promotion-content" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "backgroundColor" to "rgba(0,0,0,0)")), "promo-reward-box" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "backgroundColor" to "rgba(0,0,0,0)", "width" to "100%", "paddingTop" to 10, "paddingRight" to 0, "paddingBottom" to 10, "paddingLeft" to 0)), "promotion-desc" to padStyleMapOf(utsMapOf("textAlign" to "center", "color" to "#D31B01", "fontSize" to "30rpx", "fontWeight" to "bold")), "promotion-money" to padStyleMapOf(utsMapOf("marginTop" to "20rpx", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "unit" to utsMapOf(".promotion-money " to utsMapOf("marginTop" to "34rpx"), ".reward-amount " to utsMapOf("fontSize" to 16, "color" to "#FF6B00", "marginLeft" to 5)), "reward-amount" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "marginTop" to 10, "marginRight" to 0, "marginBottom" to 10, "marginLeft" to 0)), "amount" to utsMapOf(".reward-amount " to utsMapOf("fontSize" to "90rpx", "fontWeight" to "bold", "color" to "#D31B01")), "unit-text" to utsMapOf(".reward-amount " to utsMapOf("fontWeight" to "bold", "color" to "#D31B01", "fontSize" to "34rpx")), "promotion-buttons" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "width" to "90%")), "promo-button" to padStyleMapOf(utsMapOf("flex" to 1, "height" to 45, "borderTopLeftRadius" to 22.5, "borderTopRightRadius" to 22.5, "borderBottomRightRadius" to 22.5, "borderBottomLeftRadius" to 22.5, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "marginTop" to 0, "marginRight" to 8, "marginBottom" to 0, "marginLeft" to 8)), "promote-now" to padStyleMapOf(utsMapOf("backgroundColor" to "#FF6B00")), "button-text" to utsMapOf(".promote-now " to utsMapOf("color" to "#FFFFFF", "fontSize" to 16, "fontWeight" to "bold"), ".generate-poster " to utsMapOf("color" to "#ffffff", "fontSize" to 16, "fontWeight" to "bold")), "generate-poster" to padStyleMapOf(utsMapOf("backgroundColor" to "#FF6B00", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FF6B00", "borderRightColor" to "#FF6B00", "borderBottomColor" to "#FF6B00", "borderLeftColor" to "#FF6B00", "marginTop" to "13rpx")), "reward-card" to padStyleMapOf(utsMapOf("borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "marginBottom" to 15, "boxShadow" to "0 2px 10px rgba(0, 0, 0, 0.05)", "flexDirection" to "column", "alignItems" to "center", "width" to "100%", "backgroundColor" to "rgba(0,0,0,0)", "marginTop" to "300rpx")), "reward-title" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "marginBottom" to 15, "marginTop" to "40rpx", "right" to 20, "position" to "absolute")), "view-record" to utsMapOf(".reward-title " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "flex-end")), "record-text" to utsMapOf(".reward-title .view-record " to utsMapOf("color" to "#FE3308", "fontWeight" to "bold", "fontSize" to "23rpx", "fontFamily" to "PingFang SC")), "record-icon" to utsMapOf(".reward-title .view-record " to utsMapOf("marginLeft" to 5)), "arrow-icon" to utsMapOf(".reward-title .view-record .record-icon " to utsMapOf("width" to 16, "height" to 16)), "reward-stats" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-around", "marginTop" to "130rpx")), "stat-item" to utsMapOf(".reward-stats " to utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "marginTop" to 0, "marginRight" to "10rpx", "marginBottom" to 0, "marginLeft" to "10rpx", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "borderTopWidth" to 0, "borderRightWidth" to 0, "borderBottomWidth" to 0, "borderLeftWidth" to 0, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FC9329", "borderRightColor" to "#FC9329", "borderBottomColor" to "#FC9329", "borderLeftColor" to "#FC9329", "width" to "185rpx", "height" to "133rpx")), "stat-item-bg" to utsMapOf(".reward-stats .stat-item " to utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #FFFFFF, #FFF1CD)")), "stat-value" to utsMapOf(".reward-stats .stat-item " to utsMapOf("fontSize" to 24, "fontWeight" to "bold", "color" to "#FE3408", "marginBottom" to 5, "marginTop" to 8)), "stat-label" to utsMapOf(".reward-stats .stat-item " to utsMapOf("fontSize" to 14, "color" to "#000000")), "border-lr" to utsMapOf(".reward-stats " to utsMapOf("borderLeftWidth" to 1, "borderLeftStyle" to "solid", "borderLeftColor" to "#EEEEEE", "borderRightWidth" to 1, "borderRightStyle" to "solid", "borderRightColor" to "#EEEEEE")), "ranking-card" to padStyleMapOf(utsMapOf("backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "paddingTop" to 0, "paddingRight" to 0, "paddingBottom" to 15, "paddingLeft" to 0, "boxShadow" to "0 2px 10px rgba(0, 0, 0, 0.05)", "overflow" to "hidden")), "ranking-header" to padStyleMapOf(utsMapOf("width" to "540rpx", "height" to "35rpx", "position" to "relative", "marginTop" to "30rpx")), "ranking-header-img" to utsMapOf(".ranking-header " to utsMapOf("width" to "100%", "height" to "100%", "position" to "absolute", "top" to 0, "left" to 0)), "ranking-list" to padStyleMapOf(utsMapOf("paddingTop" to "60rpx", "paddingRight" to 15, "paddingBottom" to "60rpx", "paddingLeft" to 15, "flexDirection" to "row", "alignItems" to "center", "marginTop" to "20rpx")), "ranking-item" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "textAlign" to "center", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#F5F5F5", "marginTop" to 0, "marginRight" to 13, "marginBottom" to 0, "marginLeft" to 13)), "ranking-medal" to padStyleMapOf(utsMapOf("width" to "130rpx", "height" to "75rpx", "marginRight" to 10)), "medal-icon" to utsMapOf(".ranking-medal " to utsMapOf("width" to "100%", "height" to "100%")), "user-info" to padStyleMapOf(utsMapOf("marginTop" to "5rpx", "marginLeft" to "-17rpx")), "user-name" to utsMapOf(".user-info " to utsMapOf("fontSize" to "23rpx", "color" to "#7C7C7C")), "user-count" to padStyleMapOf(utsMapOf("marginLeft" to "-17rpx", "fontSize" to "35rpx", "color" to "#FE3408", "fontWeight" to "bold")), "poster-container" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center")), "save-tip" to padStyleMapOf(utsMapOf("marginTop" to "20rpx", "fontSize" to "28rpx", "color" to "#FFFFFF", "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
