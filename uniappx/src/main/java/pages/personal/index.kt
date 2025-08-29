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
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xToastS.XTOAST_TYPE
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import io.dcloud.uniapp.extapi.chooseImage as uni_chooseImage
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import io.dcloud.uniapp.extapi.makePhoneCall as uni_makePhoneCall
import uts.sdk.modules.jjMd5.md5
import io.dcloud.uniapp.extapi.saveImageToPhotosAlbum as uni_saveImageToPhotosAlbum
import uts.sdk.modules.xModalS.showModal
import uts.sdk.modules.xToastS.showToast as showXToast
import uts.sdk.modules.xBase642fileS.toPngFile
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalIndex : BasePage {
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
            val formData = ref<AuditInfo>(AuditInfo(status = -1, processRemark = null))
            val defaultHeadImg = resBaseUrl + "/static/images/img-default-avatar3.png"
            val auditHeadImg = resBaseUrl + "/static/images/img-audit-avatar.png"
            val headImg = ref<String>(defaultHeadImg)
            val showHeadWarning = ref<Boolean>(false)
            val showAgreeModal = ref<Boolean>(false)
            val showPosterAgreeModal = ref<Boolean>(false)
            val formDetail = reactive<PERSONAL_INDEX_INFO>(PERSONAL_INDEX_INFO(name = "", avatar = "", serviceStar = 0, accompanyDays = "1", totalOrder = "0", totalIncome = "0", todayOrder = 0, operatingIncome = "0", teamRanking = 0, activityBonus = "0", totalFineAmount = "0", totalAmountReceived = "0"))
            val bodyActualHei = ref<Number>(screenHeight)
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
            fun gen_headImgInit_fn() {
                getHeadImg().then(fun(res: Response){
                    if (res.code == 200 && res.data != null) {
                        val data = res.data as UTSJSONObject
                        console.log("getHeadImg res =", res)
                        formData.value.status = data.getNumber("status") ?: -1
                        formData.value.processRemark = data.getString("processRemark") ?: null
                        if (formData.value.status == 1 || formData.value.status == 2) {
                            if (data.getString("headImg") != null && data.getString("headImg") != "") {
                                headImg.value = data.getString("headImg")!!
                            } else {
                                headImg.value = defaultHeadImg
                            }
                        } else if (formData.value.status == 0) {
                            headImg.value = auditHeadImg
                        }
                    }
                }
                ).`catch`(fun(err: Any?){
                    console.log("err===", err)
                }
                )
            }
            val headImgInit = ::gen_headImgInit_fn
            fun gen_uploadImage_fn() {
                if (formData.value.status == 0) {
                    showTips("您的头像正在审核中。", "warning")
                    return
                }
                if (!getPhotoAgreeStatus()) {
                    showAgreeModal.value = true
                    return
                }
                uni_chooseImage(ChooseImageOptions(count = 1, sourceType = _uA(
                    "album",
                    "camera"
                ), success = fun(res){
                    val tempFilePath = res.tempFilePaths[0] as String
                    console.log("tempFilePath", res)
                    uploadFileSync(OrcData(platformName = "car", type = -1, file = tempFilePath)).then(fun(res: Response){
                        console.log("上传结果", res)
                        if (res.code == 200) {
                            submitHeadImgAudit(object : UTSJSONObject() {
                                var headImg = res.data as String
                            }).then(fun(res: Response){
                                if (res.code == 200) {
                                    showTips("您的头像已提交审核，待审核通过后可正常显示。", "success")
                                    headImgInit()
                                }
                            }
                            )
                        }
                    }
                    )
                }
                , fail = fun(err: ChooseImageFail) {
                    if (err.errMsg == "No Permission") {
                        removePhotoAgreeStatus()
                    }
                }
                ))
            }
            val uploadImage = ::gen_uploadImage_fn
            val activityPromotionSrc = ref("")
            val showPosterModal = ref(false)
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
                            val res = await(generateDriverAppletImage())
                            if (res.code === 200) {
                                showPosterModal.value = false
                                setTimeout(fun(){
                                    showPosterModal.value = true
                                }
                                , 100)
                                activityPromotionSrc.value = res.data as String
                            }
                            hideXloading()
                        }
                         catch (error: Throwable) {
                            hideXloading()
                            showTips("生成推广海报失败", "error")
                        }
                })
            }
            val agreeCancel = fun(){
                showXToast(XTOAST_TYPE(title = "您已拒绝相机使用/媒体访问权限申请，将无法拍摄/选取照片进行上传和访问相册", iconCode = "info", iconColor = "#ff8900", duration = 3000))
            }
            val agreeConfirm = fun(){
                setPhotoAgreeStatus()
                if (showPosterModal.value) {
                    saveImageToAlbum()
                } else {
                    uploadImage()
                }
            }
            onReady(fun(){
                init()
                headImgInit()
            }
            )
            return fun(): Any? {
                val _component_mc_active_animation = resolveEasyComponent("mc-active-animation", GenComponentsMcActiveAnimationIndexClass)
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_popover = resolveEasyComponent("x-popover", GenUniModulesTmxUiComponentsXPopoverXPopoverClass)
                val _component_x_rate = resolveEasyComponent("x-rate", GenUniModulesTmxUiComponentsXRateXRateClass)
                val _component_x_image = resolveEasyComponent("x-image", GenUniModulesTmxUiComponentsXImageXImageClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                val _component_x_code_input = resolveEasyComponent("x-code-input", GenUniModulesTmxUiComponentsXCodeInputXCodeInputClass)
                val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
                val _component_x_keyboard_number = resolveEasyComponent("x-keyboard-number", GenUniModulesTmxUiComponentsXKeyboardNumberXKeyboardNumberClass)
                val _component_x_overlay = resolveEasyComponent("x-overlay", GenUniModulesTmxUiComponentsXOverlayXOverlayClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_mc_base_container, _uM("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to true, "lrWidth" to "130"), _uM("navbar-right" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "justify-content" to "center", "margin-right" to "30rpx"))), _uA(
                                _cV(_component_mc_active_animation, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("image", _uM("class" to "x-navbar-button", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-customer.png"), "onClick" to fun(){
                                            handleCustomer()
                                        }
                                        ), null, 8, _uA(
                                            "src",
                                            "onClick"
                                        ))
                                    )
                                }
                                ), "_" to 1)),
                                _cV(_component_mc_active_animation, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("image", _uM("class" to "x-navbar-button ml23", "src" to "/static/icons/icon-driver-promotion.png", "onClick" to fun(){
                                            generatePoster()
                                        }
                                        ), null, 8, _uA(
                                            "onClick"
                                        ))
                                    )
                                }
                                ), "_" to 1)),
                                _cV(_component_mc_active_animation, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("image", _uM("class" to "x-navbar-button ml23", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-setting.png"), "onClick" to fun(){
                                            handleSetting()
                                        }
                                        ), null, 8, _uA(
                                            "src",
                                            "onClick"
                                        ))
                                    )
                                }
                                ), "_" to 1))
                            ), 4)
                        )
                    }
                    ), "default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("style" to _nS("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                            _cE("view", _uM("class" to "home-bg"), _uA(
                                _cE("view", _uM("class" to "top-bg"))
                            )),
                            _cE("view", _uM("class" to "container", "style" to _nS("height: " + (unref(screenHeight) - unref(statusBarHeight)) + "px;")), _uA(
                                _cE("view", _uM("class" to "user-card"), _uA(
                                    _cE("view", _uM("class" to "user-info"), _uA(
                                        _cV(_component_x_popover, _uM("position" to "bl", "showTriangle" to unref(showHeadWarning), "modelValue" to unref(showHeadWarning)), createSlots(_uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("image", _uM("class" to "avatar", "src" to unref(headImg), "onClick" to fun(){
                                                    uploadImage()
                                                }
                                                ), null, 8, _uA(
                                                    "src",
                                                    "onClick"
                                                ))
                                            )
                                        }
                                        ), "_" to 2), _uA(
                                            if (isTrue(unref(showHeadWarning))) {
                                                _uM("name" to "menu", "fn" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cV(_component_x_sheet, _uM("dark-color" to "#333", "margin" to _uA(
                                                            "0"
                                                        )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                _cV(_component_x_text, _uM("color" to "red"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                    return _uA(
                                                                        "头像更换申请被驳回，已更换为原来头像。"
                                                                    )
                                                                }), "_" to 1)),
                                                                _cV(_component_x_text, _uM("color" to "red"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                    return _uA(
                                                                        "驳回原因：" + _tD(unref(formData).processRemark)
                                                                    )
                                                                }), "_" to 1))
                                                            )
                                                        }), "_" to 1))
                                                    )
                                                }), "key" to "0")
                                            } else {
                                                null
                                            }
                                        )), 1032, _uA(
                                            "showTriangle",
                                            "modelValue"
                                        )),
                                        _cE("view", _uM("class" to "user-details"), _uA(
                                            _cE("view", _uM("class" to "username"), _uA(
                                                _cE("text", _uM("style" to _nS(_uM("font-size" to "23px", "font-weight" to "bold"))), _tD(unref(formDetail).name), 5)
                                            )),
                                            _cE("view", _uM("class" to "rating"), _uA(
                                                _cV(_component_x_rate, _uM("modelValue" to unref(formDetail).serviceStar, "unColor" to "#ffffff", "readonly" to true, "unicon" to ("" + unref(resBaseUrl) + "/static/icons/icon-gray-star.png")), null, 8, _uA(
                                                    "modelValue",
                                                    "unicon"
                                                )),
                                                _cE("text", _uM("class" to "score"), _tD(unref(formDetail).serviceStar) + "分", 1)
                                            ))
                                        ))
                                    ))
                                )),
                                _cE("view", _uM("class" to "join-info", "style" to _nS("width: " + unref(screenWidth) + ";")), _uA(
                                    _cE("text", _uM("class" to "text-size"), "加入"),
                                    _cE("text", _uM("class" to "text-size cus-blue"), _tD(unref(formDetail).accompanyDays), 1),
                                    _cE("text", _uM("class" to "text-size"), "天，累计完单"),
                                    _cE("text", _uM("class" to "text-size cus-green"), _tD(unref(formDetail).totalOrder), 1),
                                    _cE("text", _uM("class" to "text-size"), "笔，累计收益"),
                                    _cE("text", _uM("class" to "text-size cus-green"), _tD(unref(formDetail).totalIncome ?: 0), 1),
                                    _cE("text", _uM("class" to "text-size"), "元~")
                                ), 4),
                                _cE("view", _uM("class" to "card-view", "style" to _nS("width: " + unref(screenWidth) + "px;")), _uA(
                                    _cV(_component_x_image, _uM("class" to "stats-card-img", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-rounded-rectangle.png")), null, 8, _uA(
                                        "src"
                                    )),
                                    _cE("view", _uM("class" to "stats-data-card"), _uA(
                                        _cE("view", _uM("class" to "stats-card"), _uA(
                                            _cE("view", _uM("class" to "stats-card-item"), _uA(
                                                _cE("view", _uM("class" to "stats-item"), _uA(
                                                    _cE("view", _uM("class" to "stats-value"), _tD(unref(formDetail).todayOrder), 1),
                                                    _cE("view", _uM("class" to "stats-label"), "今日订单(单)")
                                                )),
                                                _cE("view", _uM("class" to "stats-item-space")),
                                                _cE("view", _uM("class" to "stats-item"), _uA(
                                                    _cE("view", _uM("class" to "stats-value"), _tD(unref(formDetail).operatingIncome ?: 0), 1),
                                                    _cE("view", _uM("class" to "stats-label"), "今日收入(元)")
                                                )),
                                                _cE("view", _uM("class" to "stats-item-space")),
                                                _cE("view", _uM("class" to "stats-item"), _uA(
                                                    _cE("view", _uM("class" to "stats-value"), _tD(unref(formDetail).teamRanking), 1),
                                                    _cE("view", _uM("class" to "stats-label"), "车队排行(名)")
                                                ))
                                            )),
                                            _cE("view", _uM("class" to "stats-card-item"), _uA(
                                                _cE("view", _uM("class" to "stats-item"), _uA(
                                                    _cE("view", _uM("class" to "stats-value"), _tD(unref(formDetail).activityBonus), 1),
                                                    _cE("view", _uM("class" to "stats-label"), "今日奖励(元)")
                                                )),
                                                _cE("view", _uM("class" to "stats-item-space")),
                                                _cE("view", _uM("class" to "stats-item"), _uA(
                                                    _cE("view", _uM("class" to "stats-value"), _tD(unref(formDetail).totalFineAmount), 1),
                                                    _cE("view", _uM("class" to "stats-label"), "今日罚款(元)")
                                                )),
                                                _cE("view", _uM("class" to "stats-item-space")),
                                                _cE("view", _uM("class" to "stats-item"), _uA(
                                                    _cE("view", _uM("class" to "stats-value"), _tD(unref(formDetail).totalAmountReceived), 1),
                                                    _cE("view", _uM("class" to "stats-label"), "到账金额(元)")
                                                ))
                                            ))
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "function-buttons"), _uA(
                                        _cE("view", _uM("class" to "function-button blue", "onClick" to fun(){
                                            toWallet()
                                        }
                                        ), _uA(
                                            _cE("image", _uM("class" to "function-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-my-change.png")), null, 8, _uA(
                                                "src"
                                            )),
                                            _cE("text", _uM("class" to "function-icon-text"), "我的零钱")
                                        ), 8, _uA(
                                            "onClick"
                                        )),
                                        _cV(_component_mc_active_animation, _uM("class" to "function-button green", "onClick" to fun(){
                                            toMonthsData()
                                        }
                                        ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("image", _uM("class" to "function-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-months-summary.png")), null, 8, _uA(
                                                    "src"
                                                )),
                                                _cE("text", _uM("class" to "function-icon-text"), "月度数据")
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "onClick"
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "menu-grid"), _uA(
                                        _cE("view", _uM("class" to "menu-row"), _uA(
                                            _cV(_component_mc_active_animation, _uM("class" to "menu-item", "onClick" to fun(){
                                                toJourney()
                                            }
                                            ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("image", _uM("class" to "menu-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-hisorder.png")), null, 8, _uA(
                                                        "src"
                                                    )),
                                                    _cE("text", null, "历史行程")
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "onClick"
                                            )),
                                            _cV(_component_mc_active_animation, _uM("class" to "menu-item", "onClick" to toSwitchPhone), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("image", _uM("class" to "menu-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-change-phone.png")), null, 8, _uA(
                                                        "src"
                                                    )),
                                                    _cE("text", null, "更换手机")
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_mc_active_animation, _uM("class" to "menu-item", "onClick" to fun(){
                                                toTradeQualification()
                                            }
                                            ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("image", _uM("class" to "menu-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-trade-aptitude.png")), null, 8, _uA(
                                                        "src"
                                                    )),
                                                    _cE("text", null, "营运资质")
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "onClick"
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "menu-row"), _uA(
                                            _cV(_component_mc_active_animation, _uM("class" to "menu-item", "onClick" to fun(){
                                                toDriverQualification()
                                            }
                                            ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("image", _uM("class" to "menu-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-driver-aptitude.png")), null, 8, _uA(
                                                        "src"
                                                    )),
                                                    _cE("text", null, "司机资质")
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "onClick"
                                            )),
                                            _cV(_component_mc_active_animation, _uM("class" to "menu-item", "onClick" to fun(){
                                                toIntegral()
                                            }
                                            ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("image", _uM("class" to "menu-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-integral.png")), null, 8, _uA(
                                                        "src"
                                                    )),
                                                    _cE("text", null, "积分管理")
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "onClick"
                                            )),
                                            _cV(_component_mc_active_animation, _uM("class" to "menu-item", "onClick" to fun(){
                                                toPromotion()
                                            }
                                            ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("image", _uM("class" to "menu-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/personal-promotion-rewards.png")), null, 8, _uA(
                                                        "src"
                                                    )),
                                                    _cE("text", null, "推广奖励")
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "onClick"
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "menu-row"), _uA(
                                            _cE("view", _uM("class" to "menu-item")),
                                            _cE("view", _uM("class" to "menu-item"))
                                        ))
                                    ))
                                ), 4)
                            ), 4)
                        )
                    }
                    ), "_" to 1)),
                    _cV(_component_x_modal, _uM("show" to unref(showValidModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showValidModal, `$event`)
                    }
                    , "show-close" to "", "onClose" to modalClose, "height" to "300rpx", "z-index" to "100", "title" to "请输入六位数二级密码", "show-footer" to false, "overlayClick" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cV(_component_x_code_input, _uM("width" to "80rpx", "showNumber" to false, "auto-focus" to "", "place-shape" to "line", "maxlength" to 6, "modelValue" to unref(secondPwd), "onUpdate:modelValue" to fun(`$event`: String){
                                trySetRefValue(secondPwd, `$event`)
                            }
                            , "useSysKeyborad" to false, "skin" to "fill", "onClick" to codeClick), null, 8, _uA(
                                "modelValue"
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    )),
                    _cV(_component_x_keyboard_number, _uM("showValue" to false, "mode" to "password", "digit" to false, "model-show" to unref(secondPwdShow), "maxLen" to 6, "modelValue" to unref(secondPwd), "onUpdate:modelValue" to fun(`$event`: String){
                        trySetRefValue(secondPwd, `$event`)
                    }
                    , "onConfirm" to confirmPwd, "onCancel" to fun(){
                        secondPwdShow.value = false
                    }
                    , "title" to "安全键盘请放心输入", "bgColor" to "#ffffff"), null, 8, _uA(
                        "model-show",
                        "modelValue",
                        "onCancel"
                    )),
                    _cV(_component_x_modal, _uM("show" to unref(showAgreeModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showAgreeModal, `$event`)
                    }
                    , "bgColor" to "#ECF1F8", "cancel-text" to "拒绝", "overlay-click" to false, "onCancel" to agreeCancel, "confirm-text" to "同意", "onConfirm" to agreeConfirm, "show-title" to false, "height" to "850rpx"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("text", _uM("class" to "photo-agree-title"), "相机使用/媒体访问权限申请"),
                            _cE("view", _uM("class" to "desc"), _uA(
                                _cE("text", _uM("class" to "pb-10"), "我们获取您手机的相机使用/媒体访问权限是用于以下功能："),
                                _cE("text", _uM("class" to "pb-10"), "1、拍摄/选取本人正面照片：用于头像上传、审核。"),
                                _cE("text", _uM("class" to "pb-10"), "2、获取媒体访问权限：保存推广海报到本地相册。"),
                                _cE("text", null, "如果您拒绝我们获取您的上述所有信息，将导致您头像无法上传。"),
                                _cE("text", _uM("style" to _nS(_uM("color" to "red"))), "本APP提供了撤回系统权限的功能，具体路径:个人中心(登录后点击右上角)-设置-账户与安全-权限管理。", 4)
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    )),
                    _cV(_component_x_overlay, _uM("show" to unref(showPosterModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showPosterModal, `$event`)
                    }
                    , "show-close" to true, "z-index" to 100, "overlayClick" to false, "custom-style" to "display: flex;align-items: center;justify-content: center;flex-direction: column; "), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "poster-container", "style" to _nS(_uM("margin-top" to "100"))), _uA(
                                _cE("image", _uM("src" to unref(activityPromotionSrc), "style" to _nS(_uM("width" to "90%", "height" to "auto")), "mode" to "widthFix", "onLongpress" to saveImageToAlbum), null, 44, _uA(
                                    "src"
                                )),
                                _cE("text", _uM("class" to "save-tip"), "长按可保存至本地相册")
                            ), 4)
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
                return _uM("container" to _pS(_uM("width" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 15)), "home-bg" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1, "height" to "100%")), "top-bg" to _uM(".home-bg " to _uM("height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)")), "x-navbar-button" to _uM("" to _uM("width" to "40rpx", "height" to "40rpx"), ".ml23" to _uM("marginLeft" to "23rpx"), ".mr25" to _uM("marginRight" to "25rpx"), ".mr20" to _uM("marginRight" to 20)), "user-card" to _pS(_uM("width" to "100%", "backgroundColor" to "rgba(0,0,0,0)", "boxShadow" to "0px 11px 35px 0px rgba(253, 214, 190, 0.23)", "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "marginTop" to 20)), "user-info" to _uM(".user-card " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "avatar" to _uM(".user-card .user-info " to _uM("width" to "130rpx", "height" to "130rpx", "backgroundImage" to "none", "backgroundColor" to "#00000000", "borderTopLeftRadius" to "65rpx", "borderTopRightRadius" to "65rpx", "borderBottomRightRadius" to "65rpx", "borderBottomLeftRadius" to "65rpx", "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#00000000", "borderRightColor" to "#00000000", "borderBottomColor" to "#00000000", "borderLeftColor" to "#00000000", "marginRight" to 15)), "user-details" to _uM(".user-card .user-info " to _uM("flex" to 1)), "username" to _uM(".user-card .user-info .user-details " to _uM("fontSize" to 40, "width" to "270rpx", "height" to 38, "fontFamily" to "PingFang SC", "fontWeight" to "bold", "color" to "#000000")), "rating" to _uM(".user-card .user-info .user-details " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "marginBottom" to 5)), "star" to _uM(".user-card .user-info .user-details .rating " to _uM("width" to 18, "height" to 18, "marginRight" to 8)), "score" to _uM(".user-card .user-info .user-details .rating " to _uM("marginLeft" to 5, "fontWeight" to "bold", "fontSize" to 17, "color" to "#000000")), "join-info" to _pS(_uM("lineHeight" to "16px", "display" to "flex", "flexDirection" to "row", "marginLeft" to "25rpx")), "text-size" to _uM(".join-info " to _uM("fontSize" to "28rpx"), ".join-info .cus-blue" to _uM("color" to "#4294F7"), ".join-info .cus-green" to _uM("color" to "#2D9E62")), "card-view" to _pS(_uM("position" to "relative", "width" to "100%", "zIndex" to -1, "marginLeft" to -15, "marginTop" to 15, "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "stats-card-img" to _uM(".card-view " to _uM("width" to "100%", "position" to "absolute", "left" to 0), ".card-view .stats-data-card " to _uM("width" to "100%", "position" to "relative")), "stats-data-card" to _uM(".card-view " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "height" to "290rpx", "marginTop" to 15)), "stats-card" to _uM(".card-view .stats-data-card " to _uM("position" to "absolute", "zIndex" to 1, "marginTop" to 15, "width" to "100%")), "stats-card-item" to _uM(".card-view .stats-data-card .stats-card " to _uM("width" to "100%", "backgroundColor" to "rgba(0,0,0,0)", "paddingTop" to "15rpx", "paddingRight" to 0, "paddingBottom" to "15rpx", "paddingLeft" to 0, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-around", "alignItems" to "center")), "stats-item" to _uM(".card-view .stats-data-card .stats-card .stats-card-item " to _uM("flex" to 1, "display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "paddingTop" to 0, "paddingRight" to "8rpx", "paddingBottom" to 0, "paddingLeft" to "8rpx")), "stats-value" to _uM(".card-view .stats-data-card .stats-card .stats-card-item .stats-item " to _uM("fontSize" to "20rpx", "fontWeight" to "bold", "color" to "#000000", "marginBottom" to "5rpx")), "stats-label" to _uM(".card-view .stats-data-card .stats-card .stats-card-item .stats-item " to _uM("fontSize" to "12rpx", "color" to "#666666", "whiteSpace" to "nowrap")), "stats-item-space" to _uM(".card-view .stats-data-card .stats-card .stats-card-item " to _uM("width" to "20rpx")), "function-buttons" to _uM(".card-view " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "backgroundColor" to "rgba(0,0,0,0)", "marginTop" to "20rpx", "position" to "relative")), "function-button" to _uM(".card-view .function-buttons " to _uM("width" to "48%", "height" to 50, "borderTopLeftRadius" to 30, "borderTopRightRadius" to 30, "borderBottomRightRadius" to 30, "borderBottomLeftRadius" to 30, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center"), ".card-view .function-buttons .blue" to _uM("backgroundColor" to "#EDF2FF"), ".card-view .function-buttons .green" to _uM("backgroundColor" to "#E7F7EB")), "function-icon" to _uM(".card-view .function-buttons .function-button " to _uM("width" to "100%", "height" to "100%")), "function-icon-text" to _uM(".card-view .function-buttons .function-button " to _uM("fontSize" to 16, "fontWeight" to "bold", "color" to "#ffffff", "position" to "absolute", "zIndex" to 1)), "menu-grid" to _uM(".card-view " to _uM("width" to "100%", "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 30, "borderTopRightRadius" to 30, "borderBottomRightRadius" to 30, "borderBottomLeftRadius" to 30, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FFFFFF", "borderRightColor" to "#FFFFFF", "borderBottomColor" to "#FFFFFF", "borderLeftColor" to "#FFFFFF", "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "marginTop" to 15, "marginBottom" to 20)), "menu-row" to _uM(".card-view .menu-grid " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "marginBottom" to 20, "marginBottom:last-child" to 0)), "menu-item" to _uM(".card-view .menu-grid .menu-row " to _uM("width" to "30%", "display" to "flex", "flexDirection" to "column", "alignItems" to "center")), "menu-icon" to _uM(".card-view .menu-grid .menu-row .menu-item " to _uM("width" to 30, "height" to 30, "marginBottom" to 10, "marginBottom:last-child" to 0)), "photo-agree-title" to _pS(_uM("textAlign" to "center", "width" to "100%", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "poster-container" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center")), "save-tip" to _pS(_uM("marginTop" to "20rpx", "fontSize" to "28rpx", "color" to "#FFFFFF", "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
