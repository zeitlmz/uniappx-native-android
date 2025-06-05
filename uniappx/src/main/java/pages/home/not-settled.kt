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
import uts.sdk.modules.jgJpush.JgUtil
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import io.dcloud.uniapp.extapi.exit as uni_exit
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import uts.sdk.modules.mcAmapNavPlus.init
import uts.sdk.modules.mcPermissionRequest.permissionsRequest
import uts.sdk.modules.mcPermissionRequest.requestNotificationPermission
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
            val loginTips = ref<String>("")
            val acitveTab = ref<String>("0")
            val app = getApp()
            val tabs = utsArrayOf(
                TABS_ITEM_INFO(title = "首页")
            )
            val advList = utsArrayOf(
                ADV_ITEM1(image = resBaseUrl + "/static/images/adv-driver-join.png", click = fun(index: Number){
                    console.log(index)
                }
                )
            )
            val gridFuncs = utsArrayOf(
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
                        if (res.code == 200) {
                            clearAuth()
                            router.reLaunch("/pages/home/index")
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
                    jg.init()
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
                uni_exit(null)
            }
            val onPrivacyAgree = fun(){
                showPrivacyModal.value = false
                setPrivacyStatus()
                initJg()
            }
            onMounted(fun(){
                setTheme("dark")
                globalData.theme = getTheme()
                if (!getPrivacyStatus()) {
                    setTimeout(fun(){
                        showPrivacyModal.value = true
                    }
                    , 250)
                }
            }
            )
            val onShow = fun(){}
            val onHide = fun(){}
            __expose(utsMapOf("onShow" to onShow, "onHide" to onHide))
            return fun(): Any? {
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_x_tabs = resolveEasyComponent("x-tabs", GenUniModulesTmxUiComponentsXTabsXTabsClass)
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
                return createElementVNode(Fragment, null, utsArrayOf(
                    createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsArrayOf(
                        utsMapOf("flex" to "1"),
                        "height: " + unref(screenHeight) + "px"
                    )), "bounces" to false, "direction" to if (unref(currentSwiper) == 1) {
                        "none"
                    } else {
                        "vertical"
                    }
                    , "show-scrollbar" to false), utsArrayOf(
                        createElementVNode("view", utsMapOf("style" to normalizeStyle("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        createElementVNode("image", utsMapOf("class" to "home-bg", "src" to ("" + unref(resBaseUrl) + "/static/images/home-bg.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                            "src"
                        )),
                        createElementVNode("view", utsMapOf("class" to "header"), utsArrayOf(
                            createVNode(_component_x_tabs, utsMapOf("modelValue" to unref(acitveTab), "onUpdate:modelValue" to fun(`$event`: String){
                                trySetRefValue(acitveTab, `$event`)
                            }
                            , "onChange" to onTabChange, "line-full" to true, "line-height" to "3", "color" to "#00000000", "list" to tabs), utsMapOf("default" to withScopedSlotCtx(fun(slotProps: GenUniModulesTmxUiComponentsXTabsXTabsSlotDataDefault): UTSArray<Any> {
                                val item = slotProps.item
                                val active = slotProps.active
                                return utsArrayOf(
                                    createVNode(_component_x_text, utsMapOf("style" to normalizeStyle(utsArrayOf(
                                        if (active) {
                                            "font-weight:500;font-size:24;"
                                        } else {
                                            "font-size:22;"
                                        }
                                        ,
                                        utsMapOf("padding" to "0 10px")
                                    ))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            toDisplayString(item.title)
                                        )
                                    }
                                    ), "_" to 2), 1032, utsArrayOf(
                                        "style"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "modelValue"
                            ))
                        )),
                        createElementVNode("swiper", utsMapOf("current" to unref(currentSwiper), "disable-touch" to true), utsArrayOf(
                            createElementVNode("swiper-item", utsMapOf("key" to "0"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "container"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "banner"), utsArrayOf(
                                        createElementVNode("image", utsMapOf("class" to "banner-logo", "src" to ("" + unref(resBaseUrl) + "/static/images/home-logo.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                            "src"
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "card"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "card-body"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "features"), utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "feature-item"), utsArrayOf(
                                                    createElementVNode("image", utsMapOf("class" to "feature-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-books.png"), "mode" to "aspectFit"), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("view", utsMapOf("class" to "feature-text"), utsArrayOf(
                                                        createElementVNode("text", null, "接单灵活"),
                                                        createElementVNode("text", null, "收入无忧")
                                                    ))
                                                )),
                                                createElementVNode("view", utsMapOf("class" to "feature-item"), utsArrayOf(
                                                    createElementVNode("image", utsMapOf("class" to "feature-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-money-safe.png"), "mode" to "aspectFit"), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("view", utsMapOf("class" to "feature-text"), utsArrayOf(
                                                        createElementVNode("text", null, "资金安全"),
                                                        createElementVNode("text", null, "秒到秒提")
                                                    ))
                                                )),
                                                createElementVNode("view", utsMapOf("class" to "feature-item"), utsArrayOf(
                                                    createElementVNode("image", utsMapOf("class" to "feature-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-car-outline.png"), "mode" to "aspectFit"), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("view", utsMapOf("class" to "feature-text"), utsArrayOf(
                                                        createElementVNode("text", null, "车源直供"),
                                                        createElementVNode("text", null, "可租可供")
                                                    ))
                                                ))
                                            )),
                                            if (isTrue(!unref(globalData).isLogin || (unref(globalData).entryStatus <= ENTERY || unref(globalData).entryStatus == AUDIT_REJECT))) {
                                                createElementVNode("view", utsMapOf("key" to 0, "class" to "join-options"), utsArrayOf(
                                                    createElementVNode("image", utsMapOf("class" to "border-bg-left", "src" to ("" + unref(resBaseUrl) + "/static/images/join-options-border-bg-left.png")), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("image", utsMapOf("class" to "border-bg-right", "src" to ("" + unref(resBaseUrl) + "/static/images/join-options-border-bg-right.png")), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("view", utsMapOf("onClick" to fun(){
                                                        onJoinClick("1")
                                                    }, "class" to "join-item active mr--10"), utsArrayOf(
                                                        createElementVNode("text", utsMapOf("class" to "join-item-text"), "租车购车入驻")
                                                    ), 8, utsArrayOf(
                                                        "onClick"
                                                    )),
                                                    createElementVNode("view", utsMapOf("onClick" to fun(){
                                                        onJoinClick("0")
                                                    }, "class" to "join-item"), utsArrayOf(
                                                        createElementVNode("text", utsMapOf("class" to "join-item-text"), "自备车辆入驻")
                                                    ), 8, utsArrayOf(
                                                        "onClick"
                                                    ))
                                                ))
                                            } else {
                                                createCommentVNode("v-if", true)
                                            }
                                            ,
                                            if (isTrue(unref(globalData).isLogin && unref(globalData).entryStatus == AUDIT)) {
                                                createElementVNode("view", utsMapOf("key" to 1, "class" to "join-options", "style" to normalizeStyle(utsMapOf("flex-direction" to "column")), "onClick" to refreshEntryStatus), utsArrayOf(
                                                    createVNode(_component_x_image, utsMapOf("width" to "270rpx", "height" to "221rpx", "model" to "widthFix", "preview" to false, "src" to ("" + unref(resBaseUrl) + "/static/images/home-wait.png")), null, 8, utsArrayOf(
                                                        "src"
                                                    )),
                                                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex-direction" to "row", "align-items" to "center", "position" to "absolute", "margin-top" to "155rpx"))), utsArrayOf(
                                                        createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("font-size" to "26rpx"))), "认证审核中，请稍作等待....", 4),
                                                        createVNode(_component_x_image, utsMapOf("width" to "30rpx", "height" to "30rpx", "model" to "widthFix", "style" to normalizeStyle(utsMapOf("margin-left" to "3px")), "preview" to false, "src" to ("" + unref(resBaseUrl) + "/static/images/image-refresh.png")), null, 8, utsArrayOf(
                                                            "style",
                                                            "src"
                                                        ))
                                                    ), 4)
                                                ), 4)
                                            } else {
                                                createCommentVNode("v-if", true)
                                            }
                                        )),
                                        if (unref(globalData).entryStatus !== AUDIT) {
                                            createElementVNode("text", utsMapOf("key" to 0, "class" to "join-slogan", "style" to normalizeStyle("width: " + (unref(screenWidth) - 60) + "px;")), "—— 加入每橙 心想事成 ——", 4)
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                    )),
                                    createVNode(_component_x_swiper, utsMapOf("height" to "160", "autoPlay" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode(Fragment, null, RenderHelpers.renderList(advList, fun(item, index, __index, _cached): Any {
                                                return createVNode(_component_x_swiper_item, utsMapOf("order" to index, "key" to index, "onClick" to fun(){
                                                    item.click?.invoke(index)
                                                }
                                                ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        createVNode(_component_x_image, utsMapOf("width" to "100%", "model" to "widthFix", "src" to item.image), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
                                                    )
                                                }
                                                ), "_" to 2), 1032, utsArrayOf(
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
                            createElementVNode("swiper-item", utsMapOf("key" to "1"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "container"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "card", "style" to normalizeStyle(utsMapOf("margin-top" to "30px"))), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "card-header"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "left transition"), utsArrayOf(
                                                createElementVNode("image", utsMapOf("class" to "location-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-location.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                )),
                                                createElementVNode("text", null, "太原市")
                                            )),
                                            createElementVNode("view", utsMapOf("class" to "right"), "晴天 25℃")
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "card-body"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "grid-func"), utsArrayOf(
                                                createElementVNode(Fragment, null, RenderHelpers.renderList(gridFuncs.slice(0, 3), fun(item, index, __index, _cached): Any {
                                                    return createElementVNode("view", utsMapOf("class" to "grid-item transition", "onClick" to fun(){
                                                        item.click?.invoke()
                                                    }
                                                    ), utsArrayOf(
                                                        createElementVNode("image", utsMapOf("class" to "grid-icon", "src" to (unref(resBaseUrl) + item.icon), "key" to index, "mode" to "aspectFit"), null, 8, utsArrayOf(
                                                            "src"
                                                        )),
                                                        createElementVNode("view", utsMapOf("class" to "grid-text"), utsArrayOf(
                                                            createElementVNode("text", null, "接单灵活")
                                                        ))
                                                    ), 8, utsArrayOf(
                                                        "onClick"
                                                    ))
                                                }
                                                ), 256)
                                            )),
                                            createElementVNode("view", utsMapOf("class" to "grid-func"), utsArrayOf(
                                                createElementVNode(Fragment, null, RenderHelpers.renderList(gridFuncs.slice(3, 6), fun(item, index, __index, _cached): Any {
                                                    return createElementVNode("view", utsMapOf("class" to "grid-item transition", "onClick" to fun(){
                                                        item.click?.invoke()
                                                    }
                                                    ), utsArrayOf(
                                                        createElementVNode("image", utsMapOf("class" to "grid-icon", "src" to (unref(resBaseUrl) + item.icon), "key" to index, "mode" to "aspectFit"), null, 8, utsArrayOf(
                                                            "src"
                                                        )),
                                                        createElementVNode("view", utsMapOf("class" to "grid-text"), utsArrayOf(
                                                            createElementVNode("text", null, "接单灵活")
                                                        ))
                                                    ), 8, utsArrayOf(
                                                        "onClick"
                                                    ))
                                                }
                                                ), 256)
                                            ))
                                        ))
                                    ), 4),
                                    createVNode(_component_x_swiper, utsMapOf("height" to "160", "autoPlay" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode(Fragment, null, RenderHelpers.renderList(advList, fun(item, index, __index, _cached): Any {
                                                return createVNode(_component_x_swiper_item, utsMapOf("order" to index, "key" to index, "onClick" to fun(){
                                                    item.click?.invoke(index)
                                                }
                                                ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        createVNode(_component_x_image, utsMapOf("width" to "100%", "model" to "widthFix", "src" to item.image), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
                                                    )
                                                }
                                                ), "_" to 2), 1032, utsArrayOf(
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
                        ), 8, utsArrayOf(
                            "current"
                        )),
                        if (isTrue(!unref(globalData).isLogin)) {
                            createElementVNode("view", utsMapOf("key" to 0, "class" to "container"), utsArrayOf(
                                createElementVNode("button", utsMapOf("onClick" to onLoginClick, "class" to "login-btn transition"), "登录/注册")
                            ))
                        } else {
                            createCommentVNode("v-if", true)
                        }
                        ,
                        if (isTrue(unref(globalData).isLogin)) {
                            createElementVNode("view", utsMapOf("key" to 1, "class" to "container"), utsArrayOf(
                                createElementVNode("button", utsMapOf("onClick" to onLogoutClick, "class" to "login-btn transition"), "退出登录")
                            ))
                        } else {
                            createCommentVNode("v-if", true)
                        }
                    ), 12, utsArrayOf(
                        "direction"
                    )),
                    createVNode(_component_x_drawer, utsMapOf("content-margin" to "0px", "show" to unref(showLogin), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showLogin, `$event`)
                    }
                    , "bgColor" to "#ffffff", "show-title" to false, "size" to "500px"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                                "0"
                            )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "login-container"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "login-header"), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "text-size-xl text-weight-b"), "登录"),
                                            createElementVNode("view", utsMapOf("class" to "login-tip"), utsArrayOf(
                                                createElementVNode("image", utsMapOf("class" to "info-icon", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-info-outline-small.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                )),
                                                createElementVNode("text", utsMapOf("class" to "text-size-s text-color-warning"), "未注册手机号验证后自动创建每橙车主账号")
                                            ))
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "login-form"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "phone-input"), utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "country-code", "onClick" to onSelectCountry), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "prefix"), "+86"),
                                                    createElementVNode("image", utsMapOf("class" to "arrow-down", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-filled-samll.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                )),
                                                createElementVNode("view", utsMapOf("class" to "divider")),
                                                createVNode(_component_x_input, utsMapOf("modelValue" to unref(phone), "onUpdate:modelValue" to fun(`$event`: String){
                                                    trySetRefValue(phone, `$event`)
                                                }
                                                , "placeholder" to "请输入手机号", "maxlength" to 11, "class" to "phone-field"), null, 8, utsArrayOf(
                                                    "modelValue"
                                                ))
                                            )),
                                            createElementVNode("view", utsMapOf("class" to "code-input"), utsArrayOf(
                                                createVNode(_component_x_input, utsMapOf("modelValue" to unref(code), "onUpdate:modelValue" to fun(`$event`: String){
                                                    trySetRefValue(code, `$event`)
                                                }
                                                , "placeholder" to "请输入验证码", "maxlength" to 4, "type" to "number"), utsMapOf("inputRight" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        createElementVNode("text", utsMapOf("class" to "get-code-btn", "onClick" to onGetCode), toDisplayString(if (unref(countdown) > 0) {
                                                            "" + unref(countdown) + "s\u540E\u91CD\u8BD5"
                                                        } else {
                                                            "获取验证码"
                                                        }
                                                        ), 1)
                                                    )
                                                }
                                                ), "_" to 1), 8, utsArrayOf(
                                                    "modelValue"
                                                ))
                                            ))
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "login-footer"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "agreement"), utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "agreement-row"), utsArrayOf(
                                                    createVNode(_component_x_checkbox, utsMapOf("modelValue" to unref(agreed), "onUpdate:modelValue" to fun(`$event`: String){
                                                        trySetRefValue(agreed, `$event`)
                                                    }
                                                    , "size" to "18", "class" to "agreement-checkbox"), null, 8, utsArrayOf(
                                                        "modelValue"
                                                    )),
                                                    createElementVNode("text", utsMapOf("class" to "checkbox-text"), "同意"),
                                                    createElementVNode("text", utsMapOf("class" to "agreement-link", "onClick" to onShowAgreement), "《用户服务协议》"),
                                                    createElementVNode("text", utsMapOf("class" to "agreement-text"), "和"),
                                                    createElementVNode("text", utsMapOf("class" to "agreement-link", "onClick" to onShowPrivacy), "《司机端个人信息处理规则》")
                                                ))
                                            )),
                                            createElementVNode("button", utsMapOf("class" to "login-btn transition", "onClick" to onLogin), "登录/注册"),
                                            createElementVNode("view", utsMapOf("class" to "other-login-options"), utsArrayOf(
                                                createElementVNode("text", utsMapOf("class" to "old-phone", "onClick" to onOldPhoneLogin), "旧手机号不在使用")
                                            ))
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "show"
                    )),
                    createVNode(_component_x_modal, utsMapOf("show" to unref(loginTipsModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(loginTipsModal, `$event`)
                    }
                    , "title" to "温馨提示", "onConfirm" to loginRequest, "onCancel" to closeLoginModal), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("text-align" to "center"))), toDisplayString(unref(loginTips)), 5)
                        )
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "show"
                    )),
                    createVNode(_component_x_action_modal, utsMapOf("show" to unref(showPrivacyModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showPrivacyModal, `$event`)
                    }
                    , "overlayClick" to false), utsMapOf("title" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "privacy-title"), "每橙车主法律协议及隐私政策")
                        )
                    }
                    ), "footer" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "link-text", "onClick" to toPrivacyPage), "法律协议及隐私政策"),
                            createElementVNode("view", utsMapOf("class" to "btn-group"), utsArrayOf(
                                createVNode(_component_x_button, utsMapOf("onClick" to onPrivacyReject, "skin" to "thin", "style" to normalizeStyle(utsMapOf("flex" to "1", "margin-right" to "10px"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        "拒绝"
                                    )
                                }
                                ), "_" to 1), 8, utsArrayOf(
                                    "style"
                                )),
                                createVNode(_component_x_button, utsMapOf("onClick" to onPrivacyAgree, "style" to normalizeStyle(utsMapOf("flex" to "1"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        "同意"
                                    )
                                }
                                ), "_" to 1), 8, utsArrayOf(
                                    "style"
                                ))
                            ))
                        )
                    }
                    ), "default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("height" to "600rpx", "margin" to "30rpx 0 10rpx 0", "padding" to "0 30rpx", "box-sizing" to "border-box"))), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "text-row"), "您在使用每橙车主服务前，请认真阅读并充分理解相关用户服务协议、软件使用协议及个人信息处理规则(隐私协议)。"),
                                createElementVNode("text", utsMapOf("class" to "text-row"), "当您点击同意相关条款，并开始使用产品或服务，即表示您已经理解并同意该条款，该条款将构成对您具有法律约束力的文件。个人信息处理规则(隐私协议)主要包含以下内容:"),
                                createElementVNode("text", utsMapOf("class" to "text-row"), "个人信息(包括手机号码、位置、订单信息、行程信息、OAID等)的收集使用规则及设备权限的调用情况。"),
                                createElementVNode("text", utsMapOf("class" to "text-row"), "权限调用目的说明：每橙车主希望获取您的存储权限用于必要的信息配置存储；"),
                                createElementVNode("text", utsMapOf("class" to "text-row"), "相机权限：用于注册中的资料上传；位置权限：用于基于定位的订单匹配和导航、路程规划；"),
                                createElementVNode("text", utsMapOf("class" to "text-row"), "麦克风权限：用于行程中声音获取、行程录音;"),
                                createElementVNode("text", utsMapOf("class" to "text-row"), "电话权限：用于获取设备信息，防控运营风险; 通讯录权限(非必要权限)，用于添加紧急联系；"),
                                createElementVNode("text", utsMapOf("class" to "text-row"), "软件安装列表、MAC地址、ANDROID ID、设备应用权限（应用包名、版本号和运行状态）、设备相关信息（设备厂商、设备型号、设备内存、操作系统版本、推送SDK版本、设备归属地（国家或地区）、SIM卡运营商名称、当前网络类型、WiFi状态）、通知栏设置信息、推送消息内容，"),
                                createElementVNode("text", utsMapOf("class" to "text-row"), "用于手机终端推送消息时使用。"),
                                createElementVNode("text", utsMapOf("class" to "text-row"), "您确认本弹窗并不会直接开启相关权限，我们会就具体权限开启另行征得您的同意。")
                            ), 4)
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
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("text-row" to padStyleMapOf(utsMapOf("fontSize" to "32rpx", "paddingBottom" to "20rpx", "textIndent" to "30rpx")), "container" to padStyleMapOf(utsMapOf("width" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "home-bg" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1)), "header" to padStyleMapOf(utsMapOf("display" to "flex", "justifyContent" to "flex-start", "paddingLeft" to 30, "paddingTop" to 10)), "banner" to padStyleMapOf(utsMapOf("paddingTop" to 30, "paddingRight" to 0, "paddingBottom" to 30, "paddingLeft" to 0, "display" to "flex", "alignItems" to "center")), "banner-logo" to utsMapOf(".banner " to utsMapOf("width" to "80%")), "card" to padStyleMapOf(utsMapOf("width" to "100%", "backgroundColor" to "#ffffff", "boxShadow" to "0px 11px 35px 0px rgba(253, 214, 190, 0.23)", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FFFFFF", "borderRightColor" to "#FFFFFF", "borderBottomColor" to "#FFFFFF", "borderLeftColor" to "#FFFFFF", "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "marginBottom" to 20)), "card-header" to utsMapOf(".card " to utsMapOf("width" to "100%", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "marginBottom" to 10)), "left" to utsMapOf(".card .card-header " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "location-icon" to utsMapOf(".card .card-header .left " to utsMapOf("width" to 13, "height" to 15, "marginRight" to 5)), "arrow-icon" to utsMapOf(".card .card-header .left " to utsMapOf("width" to 8, "height" to 4, "marginLeft" to 5)), "features" to utsMapOf(".card .card-body " to utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to 20, "paddingRight" to 0, "paddingBottom" to 20, "paddingLeft" to 0)), "feature-item" to utsMapOf(".card .card-body .features " to utsMapOf("display" to "flex", "alignItems" to "center", "flex" to 1)), "feature-icon" to utsMapOf(".card .card-body .features .feature-item " to utsMapOf("width" to 28.5, "height" to 29.5, "marginBottom" to 10)), "feature-text" to utsMapOf(".card .card-body .features .feature-item " to utsMapOf("display" to "flex", "flexDirection" to "column", "fontSize" to 15)), "join-options" to utsMapOf(".card .card-body " to utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "position" to "relative")), "border-bg-left" to utsMapOf(".card .card-body .join-options " to utsMapOf("position" to "absolute", "top" to 0, "zIndex" to 2, "pointerEvents" to "none", "width" to "53%", "height" to "100%", "left" to 0)), "border-bg-right" to utsMapOf(".card .card-body .join-options " to utsMapOf("position" to "absolute", "top" to 0, "zIndex" to 2, "pointerEvents" to "none", "width" to "53%", "height" to "100%", "right" to 0)), "join-item" to utsMapOf(".card .card-body .join-options " to utsMapOf("width" to "49%", "height" to 90, "display" to "flex", "justifyContent" to "center", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "fontSize" to 15, "position" to "relative")), "tag" to utsMapOf(".card .card-body .join-options .join-item " to utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "borderTopLeftRadius" to 10, "borderTopRightRadius" to 0, "borderBottomRightRadius" to 20, "borderBottomLeftRadius" to 0, "backgroundColor" to "#000000", "paddingTop" to 3, "paddingRight" to 10, "paddingBottom" to 3, "paddingLeft" to 6)), "tag-text" to utsMapOf(".card .card-body .join-options .join-item .tag " to utsMapOf("width" to "100%", "textAlign" to "center", "color" to "#ffffff", "fontSize" to 12)), "join-item-text" to utsMapOf(".card .card-body .join-options .join-item " to utsMapOf("textAlign" to "center", "fontWeight" to "bold")), "grid-func" to utsMapOf(".card .card-body " to utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to 20, "paddingRight" to 0, "paddingBottom" to 20, "paddingLeft" to 0)), "grid-item" to utsMapOf(".card .card-body .grid-func " to utsMapOf("display" to "flex", "alignItems" to "center", "flex" to 1)), "grid-icon" to utsMapOf(".card .card-body .grid-func .grid-item " to utsMapOf("width" to 35, "height" to 39, "marginBottom" to 10)), "grid-text" to utsMapOf(".card .card-body .grid-func .grid-item " to utsMapOf("display" to "flex", "flexDirection" to "column", "fontSize" to 15, "color" to "#141414")), "join-slogan" to utsMapOf(".card " to utsMapOf("color" to "#9E9FA0", "fontSize" to 13, "marginTop" to 15, "textAlign" to "center")), "contact-btn" to utsMapOf(".card " to utsMapOf("marginTop" to 15), "" to utsMapOf("backgroundColor" to "#000000", "color" to "#ffffff", "textAlign" to "center", "paddingTop" to "10rpx", "paddingRight" to "30rpx", "paddingBottom" to "10rpx", "paddingLeft" to "30rpx", "borderTopLeftRadius" to "30rpx", "borderTopRightRadius" to "30rpx", "borderBottomRightRadius" to "30rpx", "borderBottomLeftRadius" to "30rpx")), "faq-link" to utsMapOf(".card " to utsMapOf("textAlign" to "center", "color" to "#969696", "fontSize" to 15, "marginTop" to 15, "marginRight" to 0, "marginBottom" to 15, "marginLeft" to 0), "" to utsMapOf("textAlign" to "center", "color" to "#969696", "fontSize" to 15, "marginTop" to 15, "marginRight" to 0, "marginBottom" to 15, "marginLeft" to 0)), "login-btn" to padStyleMapOf(utsMapOf("width" to "100%", "backgroundColor" to "#000000", "color" to "#ffffff", "paddingTop" to 3, "paddingRight" to 0, "paddingBottom" to 3, "paddingLeft" to 0, "fontWeight" to "bold", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "marginTop" to 10, "marginRight" to 0, "marginBottom" to 10, "marginLeft" to 0)), "login-container" to padStyleMapOf(utsMapOf("backgroundColor" to "#ffffff", "position" to "relative")), "login-header" to utsMapOf(".login-container " to utsMapOf("textAlign" to "center", "marginTop" to 15, "marginRight" to 15, "marginBottom" to 15, "marginLeft" to 15)), "text-size-xl" to utsMapOf(".login-container .login-header " to utsMapOf("fontSize" to 22, "fontWeight" to "bold", "color" to "#000000", "textAlign" to "center")), "login-tip" to utsMapOf(".login-container .login-header " to utsMapOf("display" to "flex", "flexDirection" to "row", "marginTop" to 16)), "info-icon" to utsMapOf(".login-container .login-header .login-tip " to utsMapOf("width" to 16, "height" to 16, "marginRight" to 5)), "text-color-warning" to utsMapOf(".login-container .login-header .login-tip " to utsMapOf("color" to "#E05656", "fontSize" to "26rpx")), "text-size-s" to utsMapOf(".login-container .login-header " to utsMapOf("fontSize" to 14, "color" to "#C43838")), "mt-8" to utsMapOf(".login-container .login-header " to utsMapOf("marginTop" to 8)), "login-form" to utsMapOf(".login-container " to utsMapOf("marginBottom" to 20)), "phone-icon" to utsMapOf(".login-container .login-form " to utsMapOf("width" to 20, "height" to 20, "marginRight" to 10)), "code-icon" to utsMapOf(".login-container .login-form " to utsMapOf("width" to 20, "height" to 20, "marginRight" to 10)), "phone-input" to utsMapOf(".login-container .login-form " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "backgroundColor" to "#F5F5F5", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "marginBottom" to 20, "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "country-code" to utsMapOf(".login-container .login-form .phone-input " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "paddingTop" to 15, "paddingRight" to 0, "paddingBottom" to 15, "paddingLeft" to 0)), "prefix" to utsMapOf(".login-container .login-form .phone-input .country-code " to utsMapOf("fontSize" to 16, "fontWeight" to "bold")), "arrow-down" to utsMapOf(".login-container .login-form .phone-input .country-code " to utsMapOf("width" to 12, "height" to 8, "marginLeft" to 5)), "divider" to utsMapOf(".login-container .login-form .phone-input " to utsMapOf("width" to 1, "height" to 20, "backgroundColor" to "#CCCCCC", "marginTop" to 0, "marginRight" to 15, "marginBottom" to 0, "marginLeft" to 15)), "phone-field" to utsMapOf(".login-container .login-form .phone-input " to utsMapOf("flex" to 1)), "code-input" to utsMapOf(".login-container .login-form " to utsMapOf("backgroundColor" to "#F5F5F5", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "get-code-btn" to utsMapOf(".login-container .login-form .code-input " to utsMapOf("color" to "#000000", "fontSize" to 15)), "agreement" to utsMapOf(".login-container .login-footer " to utsMapOf("display" to "flex", "justifyContent" to "center", "marginBottom" to 20)), "agreement-row" to utsMapOf(".login-container .login-footer .agreement " to utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "flexWrap" to "nowrap")), "agreement-checkbox" to utsMapOf(".login-container .login-footer .agreement " to utsMapOf("marginRight" to 0)), "checkbox-text" to utsMapOf(".login-container .login-footer .agreement " to utsMapOf("fontSize" to "26rpx", "color" to "#848484", "marginRight" to 5)), "agreement-text" to utsMapOf(".login-container .login-footer .agreement " to utsMapOf("fontSize" to 14, "color" to "#333333", "marginTop" to 0, "marginRight" to 2, "marginBottom" to 0, "marginLeft" to 2)), "agreement-link" to utsMapOf(".login-container .login-footer .agreement " to utsMapOf("color" to "#B09312", "fontSize" to "26rpx")), "other-login-options" to utsMapOf(".login-container .login-footer " to utsMapOf("marginBottom" to 20)), "old-phone" to utsMapOf(".login-container .login-footer .other-login-options " to utsMapOf("textAlign" to "center", "color" to "#B09312", "fontSize" to "26rpx", "textDecorationLine" to "underline")), "wechat-login" to utsMapOf(".login-container .login-footer " to utsMapOf("width" to "100%", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center")), "wechat-icon" to utsMapOf(".login-container .login-footer .wechat-login " to utsMapOf("width" to 42, "height" to 42)), "privacy-title" to padStyleMapOf(utsMapOf("fontSize" to "34rpx", "fontWeight" to "bold", "textAlign" to "center", "paddingTop" to "40rpx")), "link-text" to padStyleMapOf(utsMapOf("fontWeight" to "bold", "paddingBottom" to "40rpx", "textAlign" to "center", "textDecorationLine" to "underline")), "btn-group" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("checkHasEntry" to null)
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
