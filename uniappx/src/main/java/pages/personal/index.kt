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
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import uts.sdk.modules.mcAmapNavPlus.checkLocationPermission
import uts.sdk.modules.mcAmapNavPlus.init
import io.dcloud.uniapp.extapi.makePhoneCall as uni_makePhoneCall
import uts.sdk.modules.jjMd5.md5
import uts.sdk.modules.xModalS.showModal
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalIndex
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val cacheUserInfo = ref<Any?>(null)
            val proxy = getCurrentInstance()!!.proxy!!
            val globalData = inject("globalData") as GlobalDataType
            val secondPwd = ref<String>("")
            val secondPwdShow = ref<Boolean>(false)
            val showValidModal = ref<Boolean>(false)
            val formDetail = reactive<PERSONAL_INDEX_INFO>(PERSONAL_INDEX_INFO(name = "", avatar = "", serviceStar = 0, accompanyDays = "1", totalOrder = "0", totalIncome = "0", todayOrder = 0, operatingIncome = "0", teamRanking = 0, activityBonus = "0", totalFineAmount = "0", totalAmountReceived = "0"))
            val bodyActualHei = ref<Number>(screenHeight)
            val autoHeight = fun(): Number {
                val bodyHeight = (screenHeight - globalData.safeAreaBottom - statusBarHeight - 20 - 20) * 2
                val needHeight: Number = 1466
                bodyActualHei.value = needHeight
                return bodyActualHei.value
            }
            val handleCustomer = fun(){
                console.log("进入客服")
                uni_makePhoneCall(MakePhoneCallOptions(phoneNumber = CUSTOMER_PHONE, success = fun(result: MakePhoneCallSuccess){
                    console.log("拨打电话成功")
                }
                , fail = fun(_err){
                    console.log("拨打电话失败", _err)
                    showToast("拨打电话失败", "error")
                }
                ))
            }
            val handleSetting = fun(){
                router.push("/pages/personal/setting/index")
            }
            val toWallet = fun(){
                console.log("进入我的零钱")
                router.push("/pages/personal/wallet/index")
            }
            val toMonthsData = fun(){
                console.log("进入月度数据")
                router.push("/pages/personal/months-data/index")
            }
            val toJourney = fun(){
                console.log("进入我的行程")
                router.push("/pages/personal/journey/index")
            }
            val toDriverQualification = fun(){
                console.log("进入司机资质管理")
                router.push("/pages/personal/qualifications/index")
            }
            val toTradeQualification = fun(){
                console.log("进入营运资质管理")
                router.push("/pages/personal/qualifications/trade/index")
            }
            val toIntegral = fun(){
                console.log("进入积分管理")
                router.push("/pages/personal/integral/index")
            }
            val toPromotion = fun(){
                console.log("进入推广奖励")
                router.push("/pages/personal/promotion/index")
            }
            val confirmPwd = fun(){
                val md5Pwd = md5(secondPwd.value) as String
                console.log("md5Pwd", md5Pwd)
                checkSecondPassword(md5Pwd).then(fun(res: Response){
                    if (res.code == 200 && res.data == true) {
                        router.push("/pages/personal/switch-phone/index")
                        setTimeout(fun(){
                            secondPwdShow.value = false
                            showValidModal.value = false
                            secondPwd.value = ""
                        }, 200)
                    } else {
                        showToast("二级密码错误", "error")
                    }
                }
                )
            }
            val modalClose = fun(){
                secondPwdShow.value = false
                showValidModal.value = false
                secondPwd.value = ""
            }
            val codeClick = fun(){
                console.log("codeClick======")
                secondPwdShow.value = false
                setTimeout(fun(){
                    secondPwdShow.value = true
                }
                , 100)
            }
            val toSwitchPhone = fun(){
                console.log("进入变更手机号")
                checkUserSetSecondPassword().then(fun(res: Response){
                    if (res.code == 200) {
                        if (res.data == true) {
                            showValidModal.value = false
                            secondPwdShow.value = false
                            setTimeout(fun(){
                                secondPwdShow.value = true
                                showValidModal.value = true
                            }, 100)
                        } else {
                            showModal(X_MODAL_TYPE(title = "温馨提示", content = "还未设置二级密码，是否进行设置?", confirmText = "确认", clickMaskClose = false, confirmBgColor = globalData.theme.primaryColor, confirm = fun(){
                                router.push("/pages/personal/setting/account-safe/secondary-password/index")
                            }))
                        }
                    } else {
                        showTips(res.msg, "error")
                    }
                }
                )
            }
            val init = fun(){
                val userInfo = getCacheUserInfo()
                console.log("userInfo=", userInfo)
                if (userInfo != null) {
                    val userIdentity = userInfo.getJSON("userIdentity")
                    val realName = userIdentity?.getString("realName")
                    if (realName == null || realName == "") {
                        formDetail.name = userInfo.getString("nickname")
                    } else {
                        formDetail.name = realName
                    }
                }
                getDriverStarAndTotalIncome().then(fun(res: Response){
                    if (res.data != null) {
                        val data = res.data as UTSJSONObject
                        val serviceStar = data.getString("serviceStar")
                        formDetail.serviceStar = if (serviceStar != null && serviceStar != "") {
                            parseFloat(serviceStar)
                        } else {
                            0
                        }
                        formDetail.accompanyDays = data.getString("accompanyDays")
                        formDetail.totalOrder = data.getString("totalOrder")
                        formDetail.totalIncome = data.getString("totalIncome")
                    }
                }
                ).`catch`(fun(err: Any?){
                    console.error("getDriverStarAndTotalIncome err：", err)
                }
                )
                getTodayOrderAmount().then(fun(res: Response){
                    if (res.data != null) {
                        val data = res.data as UTSJSONObject
                        formDetail.todayOrder = data.getNumber("todayOrder")
                        formDetail.operatingIncome = data.getString("operatingIncome")
                        formDetail.teamRanking = data.getNumber("teamRanking")
                        formDetail.activityBonus = data.getString("activityBonus")
                        formDetail.totalFineAmount = data.getString("totalFineAmount")
                        formDetail.totalAmountReceived = data.getString("totalAmountReceived")
                    }
                }
                ).`catch`(fun(err: Any?){
                    console.error("getTodayOrderAmount err：", err)
                }
                )
            }
            onReady(fun(){
                init()
            }
            )
            return fun(): Any? {
                val _component_mc_active_animation = resolveEasyComponent("mc-active-animation", GenComponentsMcActiveAnimationIndexClass)
                val _component_x_rate = resolveEasyComponent("x-rate", GenUniModulesTmxUiComponentsXRateXRateClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                val _component_x_code_input = resolveEasyComponent("x-code-input", GenUniModulesTmxUiComponentsXCodeInputXCodeInputClass)
                val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
                val _component_x_keyboard_number = resolveEasyComponent("x-keyboard-number", GenUniModulesTmxUiComponentsXKeyboardNumberXKeyboardNumberClass)
                return createElementVNode(Fragment, null, utsArrayOf(
                    createVNode(_component_mc_base_container, utsMapOf("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to true), utsMapOf("navbar-right" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createVNode(_component_mc_active_animation, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode("image", utsMapOf("class" to "x-navbar-button mr25", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-customer.png"), "onClick" to fun(){
                                        handleCustomer()
                                    }
                                    ), null, 8, utsArrayOf(
                                        "src",
                                        "onClick"
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            createVNode(_component_mc_active_animation, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode("image", utsMapOf("class" to "x-navbar-button mr20", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-setting.png"), "onClick" to fun(){
                                        handleSetting()
                                    }
                                    ), null, 8, utsArrayOf(
                                        "src",
                                        "onClick"
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )
                    }
                    ), "default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("view", utsMapOf("style" to normalizeStyle("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                            createElementVNode("view", utsMapOf("class" to "home-bg"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "top-bg"))
                            )),
                            createElementVNode("view", utsMapOf("class" to "container", "style" to normalizeStyle("height: " + autoHeight() + "rpx;")), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "user-card"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "user-info"), utsArrayOf(
                                        createElementVNode("image", utsMapOf("class" to "avatar", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-default-avatar.png")), null, 8, utsArrayOf(
                                            "src"
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "user-details"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "username"), utsArrayOf(
                                                createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("font-size" to "23px", "font-weight" to "bold"))), toDisplayString(unref(formDetail).name), 5)
                                            )),
                                            createElementVNode("view", utsMapOf("class" to "rating"), utsArrayOf(
                                                createVNode(_component_x_rate, utsMapOf("modelValue" to unref(formDetail).serviceStar, "unColor" to "#ffffff", "readonly" to true, "unicon" to ("" + unref(resBaseUrl) + "/static/icons/icon-gray-star.png")), null, 8, utsArrayOf(
                                                    "modelValue",
                                                    "unicon"
                                                )),
                                                createElementVNode("text", utsMapOf("class" to "score"), toDisplayString(unref(formDetail).serviceStar) + "分", 1)
                                            ))
                                        ))
                                    ))
                                )),
                                createElementVNode("view", utsMapOf("class" to "join-info", "style" to normalizeStyle("width: " + unref(screenWidth) + ";")), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "text-size"), "加入"),
                                    createElementVNode("text", utsMapOf("class" to "text-size cus-blue"), toDisplayString(unref(formDetail).accompanyDays), 1),
                                    createElementVNode("text", utsMapOf("class" to "text-size"), "天，累计完单"),
                                    createElementVNode("text", utsMapOf("class" to "text-size cus-green"), toDisplayString(unref(formDetail).totalOrder), 1),
                                    createElementVNode("text", utsMapOf("class" to "text-size"), "笔，累计收益"),
                                    createElementVNode("text", utsMapOf("class" to "text-size cus-green"), toDisplayString(unref(formDetail).totalIncome ?: 0), 1),
                                    createElementVNode("text", utsMapOf("class" to "text-size"), "元~")
                                ), 4),
                                createElementVNode("view", utsMapOf("class" to "card-view", "style" to normalizeStyle("width: " + unref(screenWidth) + "px;")), utsArrayOf(
                                    createElementVNode("image", utsMapOf("class" to "stats-card-img", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-rounded-rectangle.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                        "src"
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "stats-data-card"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "stats-card"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "stats-card-item"), utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "stats-item"), utsArrayOf(
                                                    createElementVNode("view", utsMapOf("class" to "stats-value"), toDisplayString(unref(formDetail).todayOrder), 1),
                                                    createElementVNode("view", utsMapOf("class" to "stats-label"), "今日订单(单)")
                                                )),
                                                createElementVNode("view", utsMapOf("class" to "stats-item-space")),
                                                createElementVNode("view", utsMapOf("class" to "stats-item"), utsArrayOf(
                                                    createElementVNode("view", utsMapOf("class" to "stats-value"), toDisplayString(unref(formDetail).operatingIncome ?: 0), 1),
                                                    createElementVNode("view", utsMapOf("class" to "stats-label"), "今日营收(元)")
                                                )),
                                                createElementVNode("view", utsMapOf("class" to "stats-item-space")),
                                                createElementVNode("view", utsMapOf("class" to "stats-item"), utsArrayOf(
                                                    createElementVNode("view", utsMapOf("class" to "stats-value"), toDisplayString(unref(formDetail).teamRanking), 1),
                                                    createElementVNode("view", utsMapOf("class" to "stats-label"), "车队排行(名)")
                                                ))
                                            )),
                                            createElementVNode("view", utsMapOf("class" to "stats-card-item"), utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "stats-item"), utsArrayOf(
                                                    createElementVNode("view", utsMapOf("class" to "stats-value"), toDisplayString(unref(formDetail).activityBonus), 1),
                                                    createElementVNode("view", utsMapOf("class" to "stats-label"), "今日奖励(元)")
                                                )),
                                                createElementVNode("view", utsMapOf("class" to "stats-item-space")),
                                                createElementVNode("view", utsMapOf("class" to "stats-item"), utsArrayOf(
                                                    createElementVNode("view", utsMapOf("class" to "stats-value"), toDisplayString(unref(formDetail).totalFineAmount), 1),
                                                    createElementVNode("view", utsMapOf("class" to "stats-label"), "今日罚款(元)")
                                                )),
                                                createElementVNode("view", utsMapOf("class" to "stats-item-space")),
                                                createElementVNode("view", utsMapOf("class" to "stats-item"), utsArrayOf(
                                                    createElementVNode("view", utsMapOf("class" to "stats-value"), toDisplayString(unref(formDetail).totalAmountReceived), 1),
                                                    createElementVNode("view", utsMapOf("class" to "stats-label"), "到账金额(元)")
                                                ))
                                            ))
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "function-buttons"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "function-button blue", "onClick" to fun(){
                                            toWallet()
                                        }
                                        ), utsArrayOf(
                                            createElementVNode("image", utsMapOf("class" to "function-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-my-change.png")), null, 8, utsArrayOf(
                                                "src"
                                            )),
                                            createElementVNode("text", utsMapOf("class" to "function-icon-text"), "我的零钱")
                                        ), 8, utsArrayOf(
                                            "onClick"
                                        )),
                                        createVNode(_component_mc_active_animation, utsMapOf("class" to "function-button green", "onClick" to fun(){
                                            toMonthsData()
                                        }
                                        ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createElementVNode("image", utsMapOf("class" to "function-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-months-summary.png")), null, 8, utsArrayOf(
                                                    "src"
                                                )),
                                                createElementVNode("text", utsMapOf("class" to "function-icon-text"), "月度数据")
                                            )
                                        }
                                        ), "_" to 1), 8, utsArrayOf(
                                            "onClick"
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "menu-grid"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "menu-row"), utsArrayOf(
                                            createVNode(_component_mc_active_animation, utsMapOf("class" to "menu-item", "onClick" to fun(){
                                                toJourney()
                                            }
                                            ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("image", utsMapOf("class" to "menu-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-hisorder.png")), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("text", null, "历史行程")
                                                )
                                            }
                                            ), "_" to 1), 8, utsArrayOf(
                                                "onClick"
                                            )),
                                            createVNode(_component_mc_active_animation, utsMapOf("class" to "menu-item", "onClick" to toSwitchPhone), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("image", utsMapOf("class" to "menu-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-change-phone.png")), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("text", null, "更换手机")
                                                )
                                            }
                                            ), "_" to 1)),
                                            createVNode(_component_mc_active_animation, utsMapOf("class" to "menu-item", "onClick" to fun(){
                                                toTradeQualification()
                                            }
                                            ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("image", utsMapOf("class" to "menu-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-trade-aptitude.png")), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("text", null, "营运资质")
                                                )
                                            }
                                            ), "_" to 1), 8, utsArrayOf(
                                                "onClick"
                                            ))
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "menu-row"), utsArrayOf(
                                            createVNode(_component_mc_active_animation, utsMapOf("class" to "menu-item", "onClick" to fun(){
                                                toDriverQualification()
                                            }
                                            ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("image", utsMapOf("class" to "menu-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-driver-aptitude.png")), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("text", null, "司机资质")
                                                )
                                            }
                                            ), "_" to 1), 8, utsArrayOf(
                                                "onClick"
                                            )),
                                            createVNode(_component_mc_active_animation, utsMapOf("class" to "menu-item", "onClick" to fun(){
                                                toIntegral()
                                            }
                                            ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("image", utsMapOf("class" to "menu-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-integral.png")), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("text", null, "积分管理")
                                                )
                                            }
                                            ), "_" to 1), 8, utsArrayOf(
                                                "onClick"
                                            )),
                                            createVNode(_component_mc_active_animation, utsMapOf("class" to "menu-item", "onClick" to fun(){
                                                toPromotion()
                                            }
                                            ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    createElementVNode("image", utsMapOf("class" to "menu-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-rewards.png")), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("text", null, "推广奖励")
                                                )
                                            }
                                            ), "_" to 1), 8, utsArrayOf(
                                                "onClick"
                                            ))
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "menu-row"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "menu-item")),
                                            createElementVNode("view", utsMapOf("class" to "menu-item"))
                                        ))
                                    ))
                                ), 4)
                            ), 4)
                        )
                    }
                    ), "_" to 1)),
                    createVNode(_component_x_modal, utsMapOf("show" to unref(showValidModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showValidModal, `$event`)
                    }
                    , "show-close" to "", "onClose" to modalClose, "height" to "300rpx", "z-index" to "100", "title" to "请输入六位数二级密码", "show-footer" to false, "overlayClick" to false), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createVNode(_component_x_code_input, utsMapOf("width" to "80rpx", "showNumber" to false, "auto-focus" to "", "place-shape" to "line", "maxlength" to 6, "modelValue" to unref(secondPwd), "onUpdate:modelValue" to fun(`$event`: String){
                                trySetRefValue(secondPwd, `$event`)
                            }
                            , "useSysKeyborad" to false, "skin" to "fill", "onClick" to codeClick), null, 8, utsArrayOf(
                                "modelValue"
                            ))
                        )
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "show"
                    )),
                    createVNode(_component_x_keyboard_number, utsMapOf("showValue" to false, "mode" to "password", "digit" to false, "model-show" to unref(secondPwdShow), "maxLen" to 6, "modelValue" to unref(secondPwd), "onUpdate:modelValue" to fun(`$event`: String){
                        trySetRefValue(secondPwd, `$event`)
                    }
                    , "onConfirm" to confirmPwd, "onCancel" to fun(){
                        secondPwdShow.value = false
                    }
                    , "title" to "安全键盘请放心输入", "bgColor" to "#ffffff"), null, 8, utsArrayOf(
                        "model-show",
                        "modelValue",
                        "onCancel"
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
                return utsMapOf("container" to padStyleMapOf(utsMapOf("width" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 15)), "home-bg" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1, "height" to "100%")), "top-bg" to utsMapOf(".home-bg " to utsMapOf("height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)")), "x-navbar-button" to utsMapOf("" to utsMapOf("width" to 25, "height" to 25), ".mr25" to utsMapOf("marginRight" to 25), ".mr20" to utsMapOf("marginRight" to 20)), "user-card" to padStyleMapOf(utsMapOf("width" to "100%", "backgroundColor" to "rgba(0,0,0,0)", "boxShadow" to "0px 11px 35px 0px rgba(253, 214, 190, 0.23)", "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "marginTop" to 20)), "user-info" to utsMapOf(".user-card " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "avatar" to utsMapOf(".user-card .user-info " to utsMapOf("width" to 90, "height" to 90, "backgroundImage" to "none", "backgroundColor" to "#00000000", "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#00000000", "borderRightColor" to "#00000000", "borderBottomColor" to "#00000000", "borderLeftColor" to "#00000000", "marginRight" to 15)), "user-details" to utsMapOf(".user-card .user-info " to utsMapOf("flex" to 1)), "username" to utsMapOf(".user-card .user-info .user-details " to utsMapOf("fontSize" to 40, "width" to "270rpx", "height" to 38, "fontFamily" to "PingFang SC", "fontWeight" to "bold", "color" to "#000000")), "rating" to utsMapOf(".user-card .user-info .user-details " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "marginBottom" to 5)), "star" to utsMapOf(".user-card .user-info .user-details .rating " to utsMapOf("width" to 18, "height" to 18, "marginRight" to 8)), "score" to utsMapOf(".user-card .user-info .user-details .rating " to utsMapOf("marginLeft" to 5, "fontWeight" to "bold", "fontSize" to 17, "color" to "#000000")), "join-info" to padStyleMapOf(utsMapOf("lineHeight" to "16px", "display" to "flex", "flexDirection" to "row", "marginLeft" to "25rpx")), "text-size" to utsMapOf(".join-info " to utsMapOf("fontSize" to "28rpx"), ".join-info .cus-blue" to utsMapOf("color" to "#4294F7"), ".join-info .cus-green" to utsMapOf("color" to "#2D9E62")), "card-view" to padStyleMapOf(utsMapOf("position" to "relative", "width" to "100%", "zIndex" to -1, "marginLeft" to -15, "marginTop" to 15, "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "stats-card-img" to utsMapOf(".card-view " to utsMapOf("width" to "100%", "position" to "absolute", "left" to 0), ".card-view .stats-data-card " to utsMapOf("width" to "100%", "position" to "relative")), "stats-data-card" to utsMapOf(".card-view " to utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "height" to "290rpx", "marginTop" to 15)), "stats-card" to utsMapOf(".card-view .stats-data-card " to utsMapOf("position" to "absolute", "zIndex" to 1, "marginTop" to 15, "width" to "100%")), "stats-card-item" to utsMapOf(".card-view .stats-data-card .stats-card " to utsMapOf("width" to "100%", "backgroundColor" to "rgba(0,0,0,0)", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "15rpx", "paddingLeft" to 0, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-around", "alignItems" to "center")), "stats-item" to utsMapOf(".card-view .stats-data-card .stats-card .stats-card-item " to utsMapOf("flex" to 1, "display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "paddingTop" to 0, "paddingRight" to "8rpx", "paddingBottom" to 0, "paddingLeft" to "8rpx")), "stats-value" to utsMapOf(".card-view .stats-data-card .stats-card .stats-card-item .stats-item " to utsMapOf("fontSize" to "20rpx", "fontWeight" to "bold", "color" to "#000000", "marginBottom" to "5rpx")), "stats-label" to utsMapOf(".card-view .stats-data-card .stats-card .stats-card-item .stats-item " to utsMapOf("fontSize" to "12rpx", "color" to "#666666", "whiteSpace" to "nowrap")), "stats-item-space" to utsMapOf(".card-view .stats-data-card .stats-card .stats-card-item " to utsMapOf("width" to "20rpx")), "function-buttons" to utsMapOf(".card-view " to utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "backgroundColor" to "rgba(0,0,0,0)", "marginTop" to "20rpx", "position" to "relative")), "function-button" to utsMapOf(".card-view .function-buttons " to utsMapOf("width" to "48%", "height" to 50, "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center"), ".card-view .function-buttons .blue" to utsMapOf("backgroundColor" to "#EDF2FF"), ".card-view .function-buttons .green" to utsMapOf("backgroundColor" to "#E7F7EB")), "function-icon" to utsMapOf(".card-view .function-buttons .function-button " to utsMapOf("width" to "100%", "height" to "100%")), "function-icon-text" to utsMapOf(".card-view .function-buttons .function-button " to utsMapOf("fontSize" to 16, "fontWeight" to "bold", "color" to "#ffffff", "position" to "absolute", "zIndex" to 1)), "menu-grid" to utsMapOf(".card-view " to utsMapOf("width" to "100%", "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FFFFFF", "borderRightColor" to "#FFFFFF", "borderBottomColor" to "#FFFFFF", "borderLeftColor" to "#FFFFFF", "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "marginTop" to 15, "marginBottom" to 20)), "menu-row" to utsMapOf(".card-view .menu-grid " to utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "marginBottom" to 20, "marginBottom:last-child" to 0)), "menu-item" to utsMapOf(".card-view .menu-grid .menu-row " to utsMapOf("width" to "30%", "display" to "flex", "flexDirection" to "column", "alignItems" to "center")), "menu-icon" to utsMapOf(".card-view .menu-grid .menu-row .menu-item " to utsMapOf("width" to 30, "height" to 30, "marginBottom" to 10, "marginBottom:last-child" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
