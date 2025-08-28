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
import uts.sdk.modules.mcAlipaySdk.AlipayLoginOptions
import uts.sdk.modules.mcAlipaySdk.AlipayShare
import uts.sdk.modules.mcAlipaySdk.AlipayLoginSuccess
import uts.sdk.modules.jgJpush.JgUtil
import uts.sdk.modules.mcWechatSdk.WeChatLoginOptions
import uts.sdk.modules.mcWechatSdk.WeChatLoginSuccess
import uts.sdk.modules.mcWechatSdk.WeChatShare
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import io.dcloud.uniapp.extapi.exit as uni_exit
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import uts.sdk.modules.mcPermissionRequest.permissionsRequest
import uts.sdk.modules.mcPermissionRequest.requestNotificationPermission
import io.dcloud.uniapp.extapi.reLaunch as uni_reLaunch
import uts.sdk.modules.xModalS.showModal
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesHomeNotSettled : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var onShow: () -> Unit
        get() {
            return unref(this.`$exposed`["onShow"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "onShow", value)
        }
    open var onHide: () -> Unit
        get() {
            return unref(this.`$exposed`["onHide"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "onHide", value)
        }
    open var onReady: () -> Unit
        get() {
            return unref(this.`$exposed`["onReady"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "onReady", value)
        }
    open var onInit: () -> Unit
        get() {
            return unref(this.`$exposed`["onInit"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "onInit", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesHomeNotSettled, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesHomeNotSettled
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val router = uni_useKuxRouter()
            val globalData = inject("globalData") as GlobalDataType
            val showPrivacyModal = ref(false)
            val loginTipsModal = ref<Boolean>(false)
            val loginThridTipsModal = ref<Boolean>(false)
            val loginTips = ref<String>("")
            val acitveTab = ref<String>("0")
            val app = getApp()
            val tabs = _uA(
                TABS_ITEM_INFO(title = "首页")
            )
            val handleSetting = fun(){
                router.push("/pages/personal/setting/index")
            }
            val advList = _uA(
                ADV_ITEM1(image = "/static/images/adv-driver-join.png", click = fun(index: Number){
                    console.log(index)
                }
                )
            )
            val gridFuncs = _uA(
                GRID_FUNC_ITEM1(icon = "/static/icons/icon-car.png", text = "租车购车", click = fun(){
                    console.log("租车购车")
                }
                ),
                GRID_FUNC_ITEM1(icon = "/static/icons/icon-idcard.png", text = "证件代办", click = fun(){
                    console.log("证件代办")
                }
                ),
                GRID_FUNC_ITEM1(icon = "/static/icons/icon-power.png", text = "充电站", click = fun(){
                    console.log("充电站")
                }
                ),
                GRID_FUNC_ITEM1(icon = "/static/icons/icon-giveup.png", text = "加油站", click = fun(){
                    console.log("加油站")
                }
                ),
                GRID_FUNC_ITEM1(icon = "/static/icons/icon-wc.png", text = "附近厕所", click = fun(){
                    console.log("附近厕所")
                }
                ),
                GRID_FUNC_ITEM1(icon = "/static/icons/icon-service.png", text = "联系客服", click = fun(){
                    console.log("联系客服")
                }
                )
            )
            val showLogin = ref<Boolean>(false)
            val showThridLogin = ref<Boolean>(false)
            val phone = ref<String>("")
            val code = ref<String>("")
            val countdown = ref<Number>(0)
            val agreed = ref<String>("false")
            val currentSwiper = ref<Number>(0)
            val refreshEntryStatus = fun(){
                emit("checkHasEntry")
            }
            val onTabChange = fun(_: TABS_ITEM, index: Number){
                currentSwiper.value = index
            }
            val onJoinClick = fun(kVal: String){
                console.log("onJoinClick val==", kVal)
                if (globalData == null || !globalData.isLogin) {
                    console.error("未登录")
                    showTips("请先登录", "success")
                    showLogin.value = true
                    return
                }
                console.log("onJoinClick router==", router)
                router.push("/pages/driver-join/index")
            }
            val onLoginClick = fun(){
                showLogin.value = true
            }
            val onLogoutClick = fun(){
                showModal(X_MODAL_TYPE(title = "温馨提示", content = "确认要退出登录", confirmText = "确定", clickMaskClose = false, confirmBgColor = globalData.theme.primaryColor, confirm = fun(){
                    logout().then(fun(res: Response){
                        globalData.entryStatus = 0
                        if (res.code == 200) {
                            clearAuth()
                            uni_reLaunch(ReLaunchOptions(url = "/pages/home/index"))
                            showTips("已退出登录", "success")
                        } else {
                            showTips(res.msg, "error")
                        }
                    }
                    )
                }
                ))
            }
            val onGetCode = fun(){
                if (countdown.value > 0) {
                    return
                }
                if (phone.value?.length !== 11) {
                    showTips("请输入正确的手机号", "error")
                    return
                }
                showLoading(XLOADINGS_TYPE(title = "验证码发送中"))
                sendPhoneValid(phone.value).then(fun(){
                    showTips("验证码发送成功", "success")
                    countdown.value = 60
                    var timer: Number = 0
                    timer = setInterval(fun(){
                        countdown.value--
                        if (countdown.value <= 0) {
                            clearInterval(timer)
                        }
                    }
                    , 1000)
                }
                )
            }
            val initJg = fun(){
                if (globalData.isLogin) {
                    val driverInfo = getCacheUserInfo()!!.getJSON("driverSessionInfo")
                    val driverId = driverInfo?.getString("driverId") ?: ""
                    val jg = JgUtil()
                    jg.setAlias(driverId)
                    setTimeout(fun(){
                        jg.getRegistrationID()
                        jg.getConnectionState()
                    }
                    , 10000)
                    app.globalData.jg = jg
                }
            }
            val openNotifiPerm = fun(){
                requestNotificationPermission()
            }
            val loginRequest = fun(){
                showLoading(XLOADINGS_TYPE(title = "登录中..."))
                login(object : UTSJSONObject() {
                    var loginAccount = phone.value
                    var captcha = code.value
                    var grantPlatform: Number = 4
                }).then(fun(res: Response){
                    val data = res.data as UTSJSONObject
                    val token = data.getString("token")
                    if (token != null) {
                        setToken(token)
                        setCacheUserInfo(data)
                        globalData.isLogin = true
                        initJg()
                        onPushMessage()
                    }
                    showTips("登录成功", "success")
                    showLogin.value = false
                    emit("checkHasEntry")
                    setTimeout(fun(){
                        openNotifiPerm()
                    }
                    , 300)
                }
                ).`catch`(fun(err: Any?){
                    val errInfo = JSON.parse(JSON.stringify(err)) as UTSJSONObject
                    if (errInfo.getNumber("code") == 10000) {
                        loginTipsModal.value = true
                        loginTips.value = errInfo.getString("msg") ?: ""
                    }
                }
                )
            }
            val closeLoginModal = fun(){
                loginTipsModal.value = false
                loginTips.value = ""
            }
            val onLogin = fun(){
                if (phone.value.length != 11) {
                    showTips("请输入正确的手机号", "error")
                    return
                }
                if (code.value == "") {
                    showTips("请输入验证码", "error")
                    return
                }
                if (agreed.value != "1") {
                    showTips("请阅读并同意用户协议和隐私政策", "warning")
                    return
                }
                loginRequest()
            }
            val refreshCurrentUser = fun(){
                getNotDesensitizedCurrentUser().then(fun(res: Response){
                    if (res.code == 200) {
                        val data = res.data as UTSJSONObject
                        val token = data.getString("token")
                        if (token != null) {
                            setToken(token)
                            setCacheUserInfo(data)
                            globalData.isLogin = true
                            initJg()
                            onPushMessage()
                        }
                        showTips("登录成功", "success")
                        showThridLogin.value = false
                        showLogin.value = false
                        emit("checkHasEntry")
                        setTimeout(fun(){
                            openNotifiPerm()
                        }
                        , 300)
                    }
                }
                )
            }
            val initThirdLoginDriverSession = fun(){
                console.log("initThirdLoginDriverSession===")
                driverThirdLoginInitDriverSession().then(fun(userRes: Response){
                    if (userRes.code == 200) {
                        refreshCurrentUser()
                    }
                }
                ).`catch`(fun(err: Any?){
                    val errInfo = JSON.parse(JSON.stringify(err)) as UTSJSONObject
                    if (errInfo.getNumber("code") == 10000) {
                        loginThridTipsModal.value = true
                        loginTips.value = errInfo.getString("msg") ?: ""
                    }
                }
                )
            }
            val bindThridLogin = fun(){
                if (phone.value.length != 11) {
                    showTips("请输入正确的手机号", "error")
                    return
                }
                if (code.value == "") {
                    showTips("请输入验证码", "error")
                    return
                }
                if (agreed.value != "1") {
                    showTips("请阅读并同意用户协议和隐私政策", "warning")
                    return
                }
                driverThirdLoginBindPhoneNumber(phone.value, code.value).then(fun(res: Response){
                    if (res.code == 200) {
                        initThirdLoginDriverSession()
                    }
                }
                )
            }
            val handleThridSession = fun(res: Response){
                val data = res.data as UTSJSONObject
                val token = data.getString("token")
                if (token != null) {
                    setToken(token)
                }
                val userIdentityInfo = data.getJSON("userIdentity")
                val identityInfoId = userIdentityInfo?.getString("identityInfoId")
                if (identityInfoId == null || identityInfoId == "") {
                    console.log("显示三方登录")
                    showLogin.value = false
                    setTimeout(fun(){
                        showThridLogin.value = true
                    }, 100)
                } else {
                    initThirdLoginDriverSession()
                }
            }
            val wechatLogin = fun(){
                if (agreed.value != "1") {
                    showTips("请阅读并同意用户协议和隐私政策", "warning")
                    return
                }
                WeChatShare.getInstance().login(WeChatLoginOptions(state = "mc-driver", success = fun(res: WeChatLoginSuccess){
                    console.log("wechatLogin success=>", res)
                    login(object : UTSJSONObject() {
                        var loginAccount = res.code
                        var grantPlatform: Number = 5
                    }).then(fun(resData: Response){
                        console.log("wechatLogin=", resData)
                        handleThridSession(resData)
                    }
                    )
                }
                , fail = fun(err: Any){
                    console.log("wechatLogin error=>", err)
                }
                ))
            }
            val alipayLogin = fun(){
                if (agreed.value != "1") {
                    showTips("请阅读并同意用户协议和隐私政策", "warning")
                    return
                }
                AlipayShare.getInstance().login(AlipayLoginOptions(success = fun(res: AlipayLoginSuccess){
                    console.log("alipayAuth success=>", res)
                    login(object : UTSJSONObject() {
                        var loginAccount = res.code
                        var grantPlatform: Number = 12
                    }).then(fun(resData: Response){
                        console.log("alipayLogin resData=", resData)
                        handleThridSession(resData)
                    }
                    )
                }
                , fail = fun(err: Any){
                    console.log("alipayLogin error=>", err)
                }
                ))
            }
            val onShowAgreement = fun(){
                router.push("/pages/personal/setting/agreement/detail/index?agreementType=2")
            }
            val onShowPrivacy = fun(){
                router.push("/pages/personal/setting/agreement/detail/index?agreementType=4")
            }
            val onSelectCountry = fun(){}
            val onOldPhoneLogin = fun(){
                router.push("/pages/personal/switch-phone/no-login-index")
            }
            val toPrivacyPage = fun(){
                router.push("/pages/personal/setting/agreement/index")
            }
            val onPrivacyReject = fun(){
                removePrivacyStatus()
                uni_exit(null)
            }
            val onPrivacyAgree = fun(){
                showPrivacyModal.value = false
                setPrivacyStatus()
                initJg()
                emit("agreePrivacy")
            }
            onMounted(fun(){
                setTheme("dark")
                globalData.theme = getTheme()
                if (!getPrivacyStatus()) {
                    setTimeout(fun(){
                        showPrivacyModal.value = true
                    }, 250)
                } else {
                    emit("agreePrivacy")
                }
            }
            )
            val onShow = fun(){}
            val onHide = fun(){}
            val onReady1 = fun(){}
            val onInit = fun(){}
            __expose(_uM("onShow" to onShow, "onHide" to onHide, "onReady" to onReady1, "onInit" to onInit))
            return fun(): Any? {
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_x_tabs = resolveEasyComponent("x-tabs", GenUniModulesTmxUiComponentsXTabsXTabsClass)
                val _component_mc_active_animation = resolveEasyComponent("mc-active-animation", GenComponentsMcActiveAnimationIndexClass)
                val _component_x_image = resolveEasyComponent("x-image", GenUniModulesTmxUiComponentsXImageXImageClass)
                val _component_x_swiper_item = resolveEasyComponent("x-swiper-item", GenUniModulesTmxUiComponentsXSwiperItemXSwiperItemClass)
                val _component_x_swiper = resolveEasyComponent("x-swiper", GenUniModulesTmxUiComponentsXSwiperXSwiperClass)
                val _component_x_input = resolveEasyComponent("x-input", GenUniModulesTmxUiComponentsXInputXInputClass)
                val _component_x_checkbox = resolveEasyComponent("x-checkbox", GenUniModulesTmxUiComponentsXCheckboxXCheckboxClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_drawer = resolveEasyComponent("x-drawer", GenUniModulesTmxUiComponentsXDrawerXDrawerClass)
                val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
                val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass)
                val _component_x_action_modal = resolveEasyComponent("x-action-modal", GenUniModulesTmxUiComponentsXActionModalXActionModalClass)
                return _cE(Fragment, null, _uA(
                    _cE("scroll-view", _uM("style" to _nS(_uA(
                        _uM("flex" to "1"),
                        "height: " + unref(screenHeight) + "px"
                    )), "bounces" to false, "direction" to if (unref(currentSwiper) == 1) {
                        "none"
                    } else {
                        "vertical"
                    }
                    , "show-scrollbar" to false), _uA(
                        _cE("view", _uM("style" to _nS("width: " + unref(screenWidth) + "px;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        _cE("image", _uM("class" to "home-bg", "src" to "/static/images/home-bg.png", "mode" to "widthFix")),
                        _cE("view", _uM("class" to "header"), _uA(
                            _cV(_component_x_tabs, _uM("modelValue" to unref(acitveTab), "onUpdate:modelValue" to fun(`$event`: String){
                                trySetRefValue(acitveTab, `$event`)
                            }
                            , "onChange" to onTabChange, "line-full" to true, "line-height" to "3", "color" to "#00000000", "list" to tabs), _uM("default" to withScopedSlotCtx(fun(slotProps: GenUniModulesTmxUiComponentsXTabsXTabsSlotDataDefault): UTSArray<Any> {
                                val item = slotProps.item
                                val active = slotProps.active
                                return _uA(
                                    _cV(_component_x_text, _uM("style" to _nS(_uA(
                                        if (active) {
                                            "font-weight:500;font-size:24;"
                                        } else {
                                            "font-size:22;"
                                        }
                                        ,
                                        _uM("padding" to "0 10px")
                                    ))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(item.title)
                                        )
                                    }
                                    ), "_" to 2), 1032, _uA(
                                        "style"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "modelValue"
                            )),
                            _cV(_component_mc_active_animation, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("image", _uM("class" to "x-navbar-button mr20", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-setting.png"), "onClick" to fun(){
                                        handleSetting()
                                    }
                                    ), null, 8, _uA(
                                        "src",
                                        "onClick"
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )),
                        _cE("swiper", _uM("current" to unref(currentSwiper), "disable-touch" to true), _uA(
                            _cE("swiper-item", _uM("key" to "0"), _uA(
                                _cE("view", _uM("class" to "container"), _uA(
                                    _cE("view", _uM("class" to "banner"), _uA(
                                        _cE("image", _uM("class" to "banner-logo", "src" to "/static/images/home-logo.png", "mode" to "widthFix"))
                                    )),
                                    _cE("view", _uM("class" to "card"), _uA(
                                        _cE("view", _uM("class" to "card-body"), _uA(
                                            _cE("view", _uM("class" to "features"), _uA(
                                                _cE("view", _uM("class" to "feature-item"), _uA(
                                                    _cE("image", _uM("class" to "feature-icon", "src" to "/static/icons/icon-books.png", "mode" to "aspectFit")),
                                                    _cE("view", _uM("class" to "feature-text"), _uA(
                                                        _cE("text", null, "接单灵活"),
                                                        _cE("text", null, "收入无忧")
                                                    ))
                                                )),
                                                _cE("view", _uM("class" to "feature-item"), _uA(
                                                    _cE("image", _uM("class" to "feature-icon", "src" to "/static/icons/icon-money-safe.png", "mode" to "aspectFit")),
                                                    _cE("view", _uM("class" to "feature-text"), _uA(
                                                        _cE("text", null, "资金安全"),
                                                        _cE("text", null, "秒到秒提")
                                                    ))
                                                )),
                                                _cE("view", _uM("class" to "feature-item"), _uA(
                                                    _cE("image", _uM("class" to "feature-icon", "src" to "/static/icons/icon-car-outline.png", "mode" to "aspectFit")),
                                                    _cE("view", _uM("class" to "feature-text"), _uA(
                                                        _cE("text", null, "车源直供"),
                                                        _cE("text", null, "可租可供")
                                                    ))
                                                ))
                                            )),
                                            if (isTrue(!unref(globalData).isLogin || (unref(globalData).entryStatus <= ENTERY || unref(globalData).entryStatus == AUDIT_REJECT))) {
                                                _cE("view", _uM("key" to 0, "class" to "join-options"), _uA(
                                                    _cE("image", _uM("onClick" to fun(){
                                                        onJoinClick("1")
                                                    }, "class" to "border-bg-left", "src" to "/static/images/join-options-border-bg-left.png"), null, 8, _uA(
                                                        "onClick"
                                                    )),
                                                    _cE("image", _uM("onClick" to fun(){
                                                        onJoinClick("0")
                                                    }, "class" to "border-bg-right", "src" to "/static/images/join-options-border-bg-right.png"), null, 8, _uA(
                                                        "onClick"
                                                    )),
                                                    _cE("view", _uM("onClick" to fun(){
                                                        onJoinClick("1")
                                                    }, "class" to "join-item active mr--10"), _uA(
                                                        _cE("text", _uM("class" to "join-item-text"), "租车购车入驻")
                                                    ), 8, _uA(
                                                        "onClick"
                                                    )),
                                                    _cE("view", _uM("onClick" to fun(){
                                                        onJoinClick("0")
                                                    }, "class" to "join-item"), _uA(
                                                        _cE("text", _uM("class" to "join-item-text"), "自备车辆入驻")
                                                    ), 8, _uA(
                                                        "onClick"
                                                    ))
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            }
                                            ,
                                            if (isTrue(unref(globalData).isLogin && unref(globalData).entryStatus == AUDIT)) {
                                                _cE("view", _uM("key" to 1, "class" to "join-options", "style" to _nS(_uM("flex-direction" to "column")), "onClick" to refreshEntryStatus), _uA(
                                                    _cV(_component_x_image, _uM("width" to "270rpx", "height" to "221rpx", "model" to "widthFix", "preview" to false, "src" to "/static/images/home-wait.png")),
                                                    _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "align-items" to "center", "position" to "absolute", "margin-top" to "155rpx"))), _uA(
                                                        _cE("text", _uM("style" to _nS(_uM("font-size" to "26rpx"))), "认证审核中，请稍作等待....", 4),
                                                        _cV(_component_x_image, _uM("width" to "30rpx", "height" to "30rpx", "model" to "widthFix", "style" to _nS(_uM("margin-left" to "3px")), "preview" to false, "src" to "/static/images/image-refresh.png"), null, 8, _uA(
                                                            "style"
                                                        ))
                                                    ), 4)
                                                ), 4)
                                            } else {
                                                _cC("v-if", true)
                                            }
                                        )),
                                        if (unref(globalData).entryStatus !== AUDIT) {
                                            _cE("text", _uM("key" to 0, "class" to "join-slogan", "style" to _nS("width: " + (unref(screenWidth) - 60) + "px;")), "—— 加入每橙 心想事成 ——", 4)
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    )),
                                    _cV(_component_x_swiper, _uM("height" to "160", "autoPlay" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(advList, fun(item, index, __index, _cached): Any {
                                                return _cV(_component_x_swiper_item, _uM("order" to index, "key" to index, "onClick" to fun(){
                                                    item.click?.invoke(index)
                                                }
                                                ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cV(_component_x_image, _uM("width" to "100%", "model" to "widthFix", "src" to item.image), null, 8, _uA(
                                                            "src"
                                                        ))
                                                    )
                                                }
                                                ), "_" to 2), 1032, _uA(
                                                    "order",
                                                    "onClick"
                                                ))
                                            }
                                            ), 64)
                                        )
                                    }
                                    ), "_" to 1))
                                ))
                            )),
                            _cE("swiper-item", _uM("key" to "1"), _uA(
                                _cE("view", _uM("class" to "container"), _uA(
                                    _cE("view", _uM("class" to "card", "style" to _nS(_uM("margin-top" to "30px"))), _uA(
                                        _cE("view", _uM("class" to "card-header"), _uA(
                                            _cE("view", _uM("class" to "left transition"), _uA(
                                                _cE("image", _uM("class" to "location-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                )),
                                                _cE("text", null, "太原市")
                                            )),
                                            _cE("view", _uM("class" to "right"), "晴天 25℃")
                                        )),
                                        _cE("view", _uM("class" to "card-body"), _uA(
                                            _cE("view", _uM("class" to "grid-func"), _uA(
                                                _cE(Fragment, null, RenderHelpers.renderList(gridFuncs.slice(0, 3), fun(item, index, __index, _cached): Any {
                                                    return _cE("view", _uM("class" to "grid-item transition", "onClick" to fun(){
                                                        item.click?.invoke()
                                                    }
                                                    ), _uA(
                                                        _cE("image", _uM("class" to "grid-icon", "src" to (unref(resBaseUrl) + item.icon), "key" to index, "mode" to "aspectFit"), null, 8, _uA(
                                                            "src"
                                                        )),
                                                        _cE("view", _uM("class" to "grid-text"), _uA(
                                                            _cE("text", null, "接单灵活")
                                                        ))
                                                    ), 8, _uA(
                                                        "onClick"
                                                    ))
                                                }
                                                ), 256)
                                            )),
                                            _cE("view", _uM("class" to "grid-func"), _uA(
                                                _cE(Fragment, null, RenderHelpers.renderList(gridFuncs.slice(3, 6), fun(item, index, __index, _cached): Any {
                                                    return _cE("view", _uM("class" to "grid-item transition", "onClick" to fun(){
                                                        item.click?.invoke()
                                                    }
                                                    ), _uA(
                                                        _cE("image", _uM("class" to "grid-icon", "src" to (unref(resBaseUrl) + item.icon), "key" to index, "mode" to "aspectFit"), null, 8, _uA(
                                                            "src"
                                                        )),
                                                        _cE("view", _uM("class" to "grid-text"), _uA(
                                                            _cE("text", null, "接单灵活")
                                                        ))
                                                    ), 8, _uA(
                                                        "onClick"
                                                    ))
                                                }
                                                ), 256)
                                            ))
                                        ))
                                    ), 4),
                                    _cV(_component_x_swiper, _uM("height" to "160", "autoPlay" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(advList, fun(item, index, __index, _cached): Any {
                                                return _cV(_component_x_swiper_item, _uM("order" to index, "key" to index, "onClick" to fun(){
                                                    item.click?.invoke(index)
                                                }
                                                ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cV(_component_x_image, _uM("width" to "100%", "model" to "widthFix", "src" to item.image), null, 8, _uA(
                                                            "src"
                                                        ))
                                                    )
                                                }
                                                ), "_" to 2), 1032, _uA(
                                                    "order",
                                                    "onClick"
                                                ))
                                            }
                                            ), 64)
                                        )
                                    }
                                    ), "_" to 1))
                                ))
                            ))
                        ), 8, _uA(
                            "current"
                        )),
                        if (isTrue(!unref(globalData).isLogin)) {
                            _cE("view", _uM("key" to 0, "class" to "container"), _uA(
                                _cE("button", _uM("onClick" to onLoginClick, "class" to "login-btn transition"), "登录/注册")
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue(unref(globalData).isLogin)) {
                            _cE("view", _uM("key" to 1, "class" to "container"), _uA(
                                _cE("button", _uM("onClick" to onLogoutClick, "class" to "login-btn transition"), "退出登录")
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                    ), 12, _uA(
                        "direction"
                    )),
                    _cV(_component_x_drawer, _uM("content-margin" to "0px", "show" to unref(showLogin), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showLogin, `$event`)
                    }
                    , "bgColor" to "#ffffff", "show-title" to false, "size" to "500px"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cV(_component_x_sheet, _uM("margin" to _uA(
                                "0"
                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "login-container"), _uA(
                                        _cE("view", _uM("class" to "login-header"), _uA(
                                            _cE("text", _uM("class" to "text-size-xl text-weight-b"), "登录"),
                                            _cE("view", _uM("class" to "login-tip"), _uA(
                                                _cE("image", _uM("class" to "info-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-info-outline-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                )),
                                                _cE("text", _uM("class" to "text-size-s text-color-warning"), "未注册手机号验证后自动创建每橙车主账号")
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "login-form"), _uA(
                                            _cE("view", _uM("class" to "phone-input"), _uA(
                                                _cE("view", _uM("class" to "country-code", "onClick" to onSelectCountry), _uA(
                                                    _cE("text", _uM("class" to "prefix"), "+86"),
                                                    _cE("image", _uM("class" to "arrow-down", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-filled-samll.png"), "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    ))
                                                )),
                                                _cE("view", _uM("class" to "divider")),
                                                _cV(_component_x_input, _uM("modelValue" to unref(phone), "onUpdate:modelValue" to fun(`$event`: String){
                                                    trySetRefValue(phone, `$event`)
                                                }
                                                , "placeholder" to "请输入手机号", "maxlength" to 11, "class" to "phone-field", "type" to "number"), null, 8, _uA(
                                                    "modelValue"
                                                ))
                                            )),
                                            _cE("view", _uM("class" to "code-input"), _uA(
                                                _cV(_component_x_input, _uM("modelValue" to unref(code), "onUpdate:modelValue" to fun(`$event`: String){
                                                    trySetRefValue(code, `$event`)
                                                }
                                                , "placeholder" to "请输入验证码", "maxlength" to 4, "type" to "number"), _uM("inputRight" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cE("text", _uM("class" to "get-code-btn", "onClick" to onGetCode), _tD(if (unref(countdown) > 0) {
                                                            "" + unref(countdown) + "s\u540E\u91CD\u8BD5"
                                                        } else {
                                                            "获取验证码"
                                                        }
                                                        ), 1)
                                                    )
                                                }
                                                ), "_" to 1), 8, _uA(
                                                    "modelValue"
                                                ))
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "login-footer"), _uA(
                                            _cE("view", _uM("class" to "agreement"), _uA(
                                                _cE("view", _uM("class" to "agreement-row"), _uA(
                                                    _cV(_component_x_checkbox, _uM("modelValue" to unref(agreed), "onUpdate:modelValue" to fun(`$event`: String){
                                                        trySetRefValue(agreed, `$event`)
                                                    }
                                                    , "size" to "18", "class" to "agreement-checkbox"), null, 8, _uA(
                                                        "modelValue"
                                                    )),
                                                    _cE("text", _uM("class" to "checkbox-text"), "同意"),
                                                    _cE("text", _uM("class" to "agreement-link", "onClick" to onShowAgreement), "《用户服务协议》"),
                                                    _cE("text", _uM("class" to "agreement-text"), "和"),
                                                    _cE("text", _uM("class" to "agreement-link", "onClick" to onShowPrivacy), "《司机端个人信息处理规则》")
                                                ))
                                            )),
                                            _cE("button", _uM("class" to "login-btn transition", "onClick" to onLogin), "登录/注册"),
                                            _cE("view", _uM("class" to "other-login-options"), _uA(
                                                _cE("text", _uM("class" to "old-phone", "onClick" to onOldPhoneLogin), "旧手机号不在使用")
                                            )),
                                            _cE("view", _uM("class" to "thrend-login"), _uA(
                                                _cE("image", _uM("class" to "btn-icon", "style" to _nS(_uM("margin-right" to "50rpx")), "onClick" to wechatLogin, "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-wechat.png"), "mode" to "widthFix"), null, 12, _uA(
                                                    "src"
                                                )),
                                                _cE("image", _uM("class" to "btn-icon", "onClick" to alipayLogin, "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-alipay.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                ))
                                            ))
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    )),
                    _cV(_component_x_drawer, _uM("content-margin" to "0px", "show" to unref(showThridLogin), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showThridLogin, `$event`)
                    }
                    , "bgColor" to "#ffffff", "show-title" to false, "size" to "500px"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cV(_component_x_sheet, _uM("margin" to _uA(
                                "0"
                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "login-container"), _uA(
                                        _cE("view", _uM("class" to "login-header"), _uA(
                                            _cE("text", _uM("class" to "text-size-xl text-weight-b"), "绑定手机号码"),
                                            _cE("view", _uM("class" to "login-tip"), _uA(
                                                _cE("image", _uM("class" to "info-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-info-outline-small.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                )),
                                                _cE("text", _uM("class" to "text-size-s text-color-warning"), "用户首次使用三方登录后需绑定手机号")
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "login-form"), _uA(
                                            _cE("view", _uM("class" to "phone-input"), _uA(
                                                _cE("view", _uM("class" to "country-code", "onClick" to onSelectCountry), _uA(
                                                    _cE("text", _uM("class" to "prefix"), "+86"),
                                                    _cE("image", _uM("class" to "arrow-down", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-filled-samll.png"), "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    ))
                                                )),
                                                _cE("view", _uM("class" to "divider")),
                                                _cV(_component_x_input, _uM("modelValue" to unref(phone), "onUpdate:modelValue" to fun(`$event`: String){
                                                    trySetRefValue(phone, `$event`)
                                                }
                                                , "placeholder" to "请输入手机号", "maxlength" to 11, "class" to "phone-field", "type" to "number"), null, 8, _uA(
                                                    "modelValue"
                                                ))
                                            )),
                                            _cE("view", _uM("class" to "code-input"), _uA(
                                                _cV(_component_x_input, _uM("modelValue" to unref(code), "onUpdate:modelValue" to fun(`$event`: String){
                                                    trySetRefValue(code, `$event`)
                                                }
                                                , "placeholder" to "请输入验证码", "maxlength" to 4, "type" to "number"), _uM("inputRight" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cE("text", _uM("class" to "get-code-btn", "onClick" to onGetCode), _tD(if (unref(countdown) > 0) {
                                                            "" + unref(countdown) + "s\u540E\u91CD\u8BD5"
                                                        } else {
                                                            "获取验证码"
                                                        }
                                                        ), 1)
                                                    )
                                                }
                                                ), "_" to 1), 8, _uA(
                                                    "modelValue"
                                                ))
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "login-footer"), _uA(
                                            _cE("view", _uM("class" to "agreement"), _uA(
                                                _cE("view", _uM("class" to "agreement-row"), _uA(
                                                    _cV(_component_x_checkbox, _uM("modelValue" to unref(agreed), "onUpdate:modelValue" to fun(`$event`: String){
                                                        trySetRefValue(agreed, `$event`)
                                                    }
                                                    , "size" to "18", "class" to "agreement-checkbox"), null, 8, _uA(
                                                        "modelValue"
                                                    )),
                                                    _cE("text", _uM("class" to "checkbox-text"), "同意"),
                                                    _cE("text", _uM("class" to "agreement-link", "onClick" to onShowAgreement), "《用户服务协议》"),
                                                    _cE("text", _uM("class" to "agreement-text"), "和"),
                                                    _cE("text", _uM("class" to "agreement-link", "onClick" to onShowPrivacy), "《司机端个人信息处理规则》")
                                                ))
                                            )),
                                            _cE("button", _uM("class" to "login-btn transition", "onClick" to bindThridLogin), "提交")
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    )),
                    _cV(_component_x_modal, _uM("show" to unref(loginTipsModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(loginTipsModal, `$event`)
                    }
                    , "title" to "温馨提示", "onConfirm" to loginRequest, "onCancel" to closeLoginModal), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("text", _uM("style" to _nS(_uM("text-align" to "center"))), _tD(unref(loginTips)), 5)
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    )),
                    _cV(_component_x_modal, _uM("show" to unref(loginThridTipsModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(loginThridTipsModal, `$event`)
                    }
                    , "title" to "温馨提示", "onConfirm" to initThirdLoginDriverSession, "onCancel" to onLogoutClick), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("text", _uM("style" to _nS(_uM("text-align" to "center"))), _tD(unref(loginTips)), 5)
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    )),
                    _cV(_component_x_action_modal, _uM("show" to unref(showPrivacyModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showPrivacyModal, `$event`)
                    }
                    , "overlayClick" to false), _uM("title" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("text", _uM("class" to "privacy-title"), "每橙车主法律协议及隐私政策")
                        )
                    }
                    ), "footer" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("text", _uM("class" to "link-text", "onClick" to toPrivacyPage), "法律协议及隐私政策"),
                            _cE("view", _uM("class" to "btn-group"), _uA(
                                _cV(_component_x_button, _uM("onClick" to onPrivacyReject, "skin" to "thin", "style" to _nS(_uM("flex" to "1", "margin-right" to "10px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "拒绝"
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "style"
                                )),
                                _cV(_component_x_button, _uM("onClick" to onPrivacyAgree, "style" to _nS(_uM("flex" to "1"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "同意"
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "style"
                                ))
                            ))
                        )
                    }
                    ), "default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("scroll-view", _uM("style" to _nS(_uM("height" to "600rpx", "margin" to "30rpx 0 10rpx 0", "padding" to "0 30rpx", "box-sizing" to "border-box"))), _uA(
                                _cE("text", _uM("class" to "text-row"), "您在使用每橙车主服务前，请认真阅读并充分理解相关用户服务协议、软件使用协议及个人信息处理规则(隐私协议)。"),
                                _cE("text", _uM("class" to "text-row"), "当您点击同意相关条款，并开始使用产品或服务，即表示您已经理解并同意该条款，该条款将构成对您具有法律约束力的文件。个人信息处理规则(隐私协议)主要包含以下内容:"),
                                _cE("text", _uM("class" to "text-row"), "个人信息(1.注册用户手机号码、2.驾驶员及车辆资格审核信息、3.位置信息、4.订单信息、5.收款时间，金额，渠道、6.OAID)"),
                                _cE("text", _uM("class" to "text-row"), "权限调用目的说明：每橙车主希望获取您的存储权限用于必要的信息配置存储；"),
                                _cE("text", _uM("class" to "text-row"), "相机权限：用于注册中的资料上传；位置权限：用于基于定位的订单匹配和导航、路程规划；"),
                                _cE("text", _uM("class" to "text-row"), "麦克风权限：用于行程中声音获取、行程录音;"),
                                _cE("text", _uM("class" to "text-row"), "电话权限：用于获取设备信息，防控运营风险;通讯录权限(非必要权限)，用于添加紧急联系；"),
                                _cE("text", _uM("class" to "text-row"), "UniPush集成个推SDK功能："),
                                _cE("text", _uM("class" to "text-row"), "使用目的：实现操作消息的推送和提示，向您的设备发送重要通知（如订单状态、系统更新、活动提醒等）。"),
                                _cE("text", _uM("class" to "text-row"), "收集信息方式与范围：登录每橙车主App后，您可以体验UniPush个推推送的消息和通知的推送服务。您在体验推送服务的同时，我们系统后台会自动给您生成唯一的Registration，您可以向您自己的Registration发送\"消息通知\"的信息。"),
                                _cE("text", _uM("class" to "text-row"), "UniPush个推SDK在服务过程中可能收集以下信息：设备信息【如 IP 地址、GNSS 信息、网络类型、WiFi 状态、WiFi 参数、WiFi 列表、SSID、BSSID、ANDROID ID、基站信息、WiFi 信号强度的信息、蓝牙信息、传感器信息（矢量、加速度、压力、方向、地磁）、设备信号强度信息、外部存储目录、读取电话状态】、设备标识信息（IDFA、OAID）、当前应用信息（应用名、应用版本号）、设备参数及系统信息（设备品牌及型号、操作系统、运营商信息、屏幕分辨率）。"),
                                _cE("text", _uM("class" to "text-row"), "您也可以使用第三方帐号(微信、支付宝)登录并使用，您将授权我们获取您在第三方平台注册的公开信息（头像、昵称以及您授权的其他信息），用于与每橙车主绑定，使您可以直接登录并使用本产品和相关服务。"),
                                _cE("text", _uM("class" to "text-row"), "您确认本弹窗并不会直接开启相关权限，我们会就具体权限开启另行征得您的同意。权限开启后，您还可以随时通过设备设置关闭权限。"),
                                _cE("text", _uM("class" to "text-row blod"), "本APP提供了撤回隐私政策授权的功能，具体路径:登录后点击右上角(已入驻是头像图标)-设置图标-账户与安全-撤回同意隐私政策。"),
                                _cE("text", _uM("class" to "text-row blod"), "本APP提供了撤回系统权限的功能，具体路径:登录后点击右上角(已入驻是头像图标)-设置图标-账户与安全-权限管理。")
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
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("text-row" to _pS(_uM("fontSize" to "32rpx", "paddingBottom" to "20rpx", "textIndent" to "30rpx")), "blod" to _pS(_uM("color" to "#FF0000")), "container" to _pS(_uM("width" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "home-bg" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1)), "header" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingLeft" to 30, "paddingTop" to 10)), "banner" to _pS(_uM("paddingTop" to 30, "paddingRight" to 0, "paddingBottom" to 30, "paddingLeft" to 0, "display" to "flex", "alignItems" to "center")), "banner-logo" to _uM(".banner " to _uM("width" to "80%")), "card" to _pS(_uM("width" to "100%", "backgroundColor" to "#ffffff", "boxShadow" to "0px 11px 35px 0px rgba(253, 214, 190, 0.23)", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FFFFFF", "borderRightColor" to "#FFFFFF", "borderBottomColor" to "#FFFFFF", "borderLeftColor" to "#FFFFFF", "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "marginBottom" to 20)), "card-header" to _uM(".card " to _uM("width" to "100%", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "marginBottom" to 10)), "left" to _uM(".card .card-header " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "location-icon" to _uM(".card .card-header .left " to _uM("width" to 13, "height" to 15, "marginRight" to 5)), "arrow-icon" to _uM(".card .card-header .left " to _uM("width" to 8, "height" to 4, "marginLeft" to 5)), "features" to _uM(".card .card-body " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to 20, "paddingRight" to 0, "paddingBottom" to 20, "paddingLeft" to 0)), "feature-item" to _uM(".card .card-body .features " to _uM("display" to "flex", "alignItems" to "center", "flex" to 1)), "feature-icon" to _uM(".card .card-body .features .feature-item " to _uM("width" to 28.5, "height" to 29.5, "marginBottom" to 10)), "feature-text" to _uM(".card .card-body .features .feature-item " to _uM("display" to "flex", "flexDirection" to "column", "fontSize" to 15)), "join-options" to _uM(".card .card-body " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "position" to "relative")), "border-bg-left" to _uM(".card .card-body .join-options " to _uM("position" to "absolute", "top" to 0, "zIndex" to 2, "pointerEvents" to "none", "width" to "53%", "height" to "100%", "left" to 0)), "border-bg-right" to _uM(".card .card-body .join-options " to _uM("position" to "absolute", "top" to 0, "zIndex" to 2, "pointerEvents" to "none", "width" to "53%", "height" to "100%", "right" to 0)), "join-item" to _uM(".card .card-body .join-options " to _uM("width" to "49%", "height" to 90, "display" to "flex", "justifyContent" to "center", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "fontSize" to 15, "position" to "relative")), "tag" to _uM(".card .card-body .join-options .join-item " to _uM("position" to "absolute", "top" to 0, "left" to 0, "borderTopLeftRadius" to 10, "borderTopRightRadius" to 0, "borderBottomRightRadius" to 20, "borderBottomLeftRadius" to 0, "backgroundColor" to "#000000", "paddingTop" to 3, "paddingRight" to 10, "paddingBottom" to 3, "paddingLeft" to 6)), "tag-text" to _uM(".card .card-body .join-options .join-item .tag " to _uM("width" to "100%", "textAlign" to "center", "color" to "#ffffff", "fontSize" to 12)), "join-item-text" to _uM(".card .card-body .join-options .join-item " to _uM("textAlign" to "center", "fontWeight" to "bold")), "grid-func" to _uM(".card .card-body " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to 20, "paddingRight" to 0, "paddingBottom" to 20, "paddingLeft" to 0)), "grid-item" to _uM(".card .card-body .grid-func " to _uM("display" to "flex", "alignItems" to "center", "flex" to 1)), "grid-icon" to _uM(".card .card-body .grid-func .grid-item " to _uM("width" to 35, "height" to 39, "marginBottom" to 10)), "grid-text" to _uM(".card .card-body .grid-func .grid-item " to _uM("display" to "flex", "flexDirection" to "column", "fontSize" to 15, "color" to "#141414")), "join-slogan" to _uM(".card " to _uM("color" to "#9E9FA0", "fontSize" to 13, "marginTop" to 15, "textAlign" to "center")), "contact-btn" to _uM(".card " to _uM("marginTop" to 15), "" to _uM("backgroundColor" to "#000000", "color" to "#ffffff", "textAlign" to "center", "paddingTop" to "10rpx", "paddingRight" to "30rpx", "paddingBottom" to "10rpx", "paddingLeft" to "30rpx", "borderTopLeftRadius" to "30rpx", "borderTopRightRadius" to "30rpx", "borderBottomRightRadius" to "30rpx", "borderBottomLeftRadius" to "30rpx")), "faq-link" to _uM(".card " to _uM("textAlign" to "center", "color" to "#969696", "fontSize" to 15, "marginTop" to 15, "marginRight" to 0, "marginBottom" to 15, "marginLeft" to 0), "" to _uM("textAlign" to "center", "color" to "#969696", "fontSize" to 15, "marginTop" to 15, "marginRight" to 0, "marginBottom" to 15, "marginLeft" to 0)), "login-btn" to _pS(_uM("width" to "100%", "backgroundColor" to "#000000", "color" to "#ffffff", "paddingTop" to 3, "paddingRight" to 0, "paddingBottom" to 3, "paddingLeft" to 0, "fontWeight" to "bold", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "marginTop" to 10, "marginRight" to 0, "marginBottom" to 10, "marginLeft" to 0)), "login-container" to _pS(_uM("backgroundColor" to "#ffffff", "position" to "relative")), "login-header" to _uM(".login-container " to _uM("textAlign" to "center", "marginTop" to 15, "marginRight" to 15, "marginBottom" to 15, "marginLeft" to 15)), "text-size-xl" to _uM(".login-container .login-header " to _uM("fontSize" to 22, "fontWeight" to "bold", "color" to "#000000", "textAlign" to "center")), "login-tip" to _uM(".login-container .login-header " to _uM("display" to "flex", "flexDirection" to "row", "marginTop" to 16)), "info-icon" to _uM(".login-container .login-header .login-tip " to _uM("width" to 16, "height" to 16, "marginRight" to 5)), "text-color-warning" to _uM(".login-container .login-header .login-tip " to _uM("color" to "#E05656", "fontSize" to "26rpx")), "text-size-s" to _uM(".login-container .login-header " to _uM("fontSize" to 14, "color" to "#C43838")), "mt-8" to _uM(".login-container .login-header " to _uM("marginTop" to 8)), "login-form" to _uM(".login-container " to _uM("marginBottom" to 20)), "phone-icon" to _uM(".login-container .login-form " to _uM("width" to 20, "height" to 20, "marginRight" to 10)), "code-icon" to _uM(".login-container .login-form " to _uM("width" to 20, "height" to 20, "marginRight" to 10)), "phone-input" to _uM(".login-container .login-form " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "backgroundColor" to "#F5F5F5", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "marginBottom" to 20, "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "country-code" to _uM(".login-container .login-form .phone-input " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "paddingTop" to 15, "paddingRight" to 0, "paddingBottom" to 15, "paddingLeft" to 0)), "prefix" to _uM(".login-container .login-form .phone-input .country-code " to _uM("fontSize" to 16, "fontWeight" to "bold")), "arrow-down" to _uM(".login-container .login-form .phone-input .country-code " to _uM("width" to 12, "height" to 8, "marginLeft" to 5)), "divider" to _uM(".login-container .login-form .phone-input " to _uM("width" to 1, "height" to 20, "backgroundColor" to "#CCCCCC", "marginTop" to 0, "marginRight" to 15, "marginBottom" to 0, "marginLeft" to 15)), "phone-field" to _uM(".login-container .login-form .phone-input " to _uM("flex" to 1)), "code-input" to _uM(".login-container .login-form " to _uM("backgroundColor" to "#F5F5F5", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "get-code-btn" to _uM(".login-container .login-form .code-input " to _uM("color" to "#000000", "fontSize" to 15)), "agreement" to _uM(".login-container .login-footer " to _uM("display" to "flex", "justifyContent" to "center", "marginBottom" to 20)), "agreement-row" to _uM(".login-container .login-footer .agreement " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "flexWrap" to "nowrap")), "agreement-checkbox" to _uM(".login-container .login-footer .agreement " to _uM("marginRight" to 0)), "checkbox-text" to _uM(".login-container .login-footer .agreement " to _uM("fontSize" to "26rpx", "color" to "#848484", "marginRight" to 5)), "agreement-text" to _uM(".login-container .login-footer .agreement " to _uM("fontSize" to 14, "color" to "#333333", "marginTop" to 0, "marginRight" to 2, "marginBottom" to 0, "marginLeft" to 2)), "agreement-link" to _uM(".login-container .login-footer .agreement " to _uM("color" to "#B09312", "fontSize" to "26rpx")), "other-login-options" to _uM(".login-container .login-footer " to _uM("marginBottom" to 20)), "old-phone" to _uM(".login-container .login-footer .other-login-options " to _uM("textAlign" to "center", "color" to "#B09312", "fontSize" to "26rpx", "textDecorationLine" to "underline")), "thrend-login" to _uM(".login-container .login-footer " to _uM("width" to "100%", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "gap" to "30rpx")), "btn-icon" to _uM(".login-container .login-footer .thrend-login " to _uM("width" to 42, "height" to 42)), "privacy-title" to _pS(_uM("fontSize" to "34rpx", "fontWeight" to "bold", "textAlign" to "center", "paddingTop" to "40rpx")), "link-text" to _pS(_uM("fontWeight" to "bold", "paddingBottom" to "40rpx", "textAlign" to "center", "textDecorationLine" to "underline")), "btn-group" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between")), "x-navbar-button" to _uM("" to _uM("width" to 25, "height" to 25), ".mr25" to _uM("marginRight" to 25), ".mr20" to _uM("marginRight" to 20)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("checkHasEntry" to null, "agreePrivacy" to null)
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
