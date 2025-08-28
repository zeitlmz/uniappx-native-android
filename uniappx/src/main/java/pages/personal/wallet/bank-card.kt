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
import uts.sdk.modules.xTipsS.XTIPS_TYPE
import uts.sdk.modules.xTipsS.showTips as showTips1
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalWalletBankCard : BasePage {
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
        var setup: (__props: GenPagesPersonalWalletBankCard) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalWalletBankCard
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val globalData = inject("globalData") as GlobalDataType
            val isfresh = ref<Boolean>(false)
            val bottomFresh = ref<Boolean>(false)
            val deleteBankTipsModal = ref<Boolean>(false)
            val deleteBankCardId = ref<Number>(-1)
            var scrollDirection = ref<String>("down")
            val bankCardList = ref(_uA<BANK_CARD_INFO>())
            val doQuery = fun(scrollDirection: String){
                getBankCard().then(fun(res: Response){
                    if (res.data != null && res.code == 200) {
                        bankCardList.value = _uA()
                        val result = res.data as UTSArray<UTSJSONObject>
                        if (result.length > 0) {
                            result.forEach(fun(item){
                                bankCardList.value.push(JSON.parse<BANK_CARD_INFO>(JSON.stringify(item)) as BANK_CARD_INFO)
                            }
                            )
                        }
                    }
                    console.log("scrollDirection = ", scrollDirection)
                    if (scrollDirection == "down") {
                        isfresh.value = false
                    } else {
                        bottomFresh.value = false
                    }
                }
                )
            }
            val toAddDefalut = fun(item: BANK_CARD_INFO){
                chooseBankCard(item.id).then(fun(res: Response){
                    if (res.code == 200) {
                        router.push("/pages/personal/wallet/withdraw")
                    }
                }
                )
            }
            val confirmDeleteBankCard = fun(id: Number){
                deleteBankCardId.value = id
                deleteBankTipsModal.value = true
            }
            val toDeleteBankCard = fun(){
                if (deleteBankCardId.value == null || deleteBankCardId.value <= 0) {
                    showTips1(XTIPS_TYPE(title = "银行卡ID不能为空", iconCode = "error", iconColor = "red", titleColor = "red", position = "bottom"))
                    return
                }
                deleteBankCard(deleteBankCardId.value).then(fun(res: Response){
                    if (res.code == 200) {
                        doQuery(scrollDirection.value)
                    } else {
                        showTips1(XTIPS_TYPE(title = res.msg, iconCode = "error", iconColor = "red", titleColor = "red", position = "bottom"))
                    }
                }
                )
            }
            val topLoad = fun(){
                console.log("下拉刷新")
                scrollDirection.value = "down"
                doQuery(scrollDirection.value)
            }
            val bottomLoad = fun(){
                console.log("触底刷新")
                scrollDirection.value = "up"
                doQuery(scrollDirection.value)
            }
            val toAddBank = fun(){
                console.log("前往添加银行卡页面")
                router.push("/pages/personal/wallet/add-bank-card")
            }
            onPageShow(fun(){
                doQuery(scrollDirection.value)
            }
            )
            return fun(): Any? {
                val _component_x_image = resolveEasyComponent("x-image", GenUniModulesTmxUiComponentsXImageXImageClass)
                val _component_mc_active_animation = resolveEasyComponent("mc-active-animation", GenComponentsMcActiveAnimationIndexClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_empty = resolveEasyComponent("x-empty", GenUniModulesTmxUiComponentsXEmptyXEmptyClass)
                val _component_x_pull_refresh = resolveEasyComponent("x-pull-refresh", GenUniModulesTmxUiComponentsXPullRefreshXPullRefreshClass)
                val _component_template = resolveComponent("template")
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_mc_base_container, _uM("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to false, "title" to "银行卡管理"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("style" to _nS("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                            _cE("view", _uM("class" to "home-bg"), _uA(
                                _cE("view", _uM("class" to "top-bg"))
                            )),
                            _cE("view", _uM("class" to "container"), _uA(
                                _cE("view", _uM("class" to "bank-card-list"), _uA(
                                    _cV(_component_template, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_x_pull_refresh, _uM("modelValue" to unref(isfresh), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                trySetRefValue(isfresh, `$event`)
                                            }
                                            , "show-scrollbar" to false, "model-bottom-status" to unref(bottomFresh), "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                                trySetRefValue(bottomFresh, `$event`)
                                            }
                                            , "onRefresh" to topLoad, "onBottomRefresh" to bottomLoad, "height" to ("" + (unref(screenHeight) - unref(globalData).safeAreaBottom - unref(statusBarHeight) - 20) + "px"), "style" to _nS(_uM("margin-bottom" to "220rpx"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE(Fragment, null, RenderHelpers.renderList(unref(bankCardList), fun(item, index, __index, _cached): Any {
                                                        return _cV(_component_x_sheet, _uM("height" to "100", "key" to index), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                _cE("view", _uM("class" to "item", "style" to _nS(_uM<String, Any?>())), _uA(
                                                                    _cV(_component_mc_active_animation, _uM("onClick" to fun(){
                                                                        toAddDefalut(item)
                                                                    }
                                                                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                        return _uA(
                                                                            _cE("view", _uM("class" to "flex flex-row"), _uA(
                                                                                _cV(_component_x_image, _uM("width" to "37", "height" to "35", "round" to "50", "src" to item.bankLogo), null, 8, _uA(
                                                                                    "src"
                                                                                )),
                                                                                _cE("view", _uM("class" to "card-item flex-1 ml-10 mt-5"), _uA(
                                                                                    _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row"))), _uA(
                                                                                        _cE("text", _uM("class" to "bank-name"), _tD(item.bankName), 1),
                                                                                        if (item.status == 1) {
                                                                                            _cE("text", _uM("key" to 0, "class" to "bank-num"), "（默认）")
                                                                                        } else {
                                                                                            _cC("v-if", true)
                                                                                        }
                                                                                    ), 4),
                                                                                    _cE("text", _uM("class" to "bank-num mt-10"), _tD(item.bankCard), 1),
                                                                                    _cE("text", _uM("class" to "u-name mt-5"), _tD(item.realName), 1)
                                                                                ))
                                                                            ))
                                                                        )
                                                                    }
                                                                    ), "_" to 2), 1032, _uA(
                                                                        "onClick"
                                                                    )),
                                                                    _cE("view", _uM("class" to "text-round", "onClick" to fun(){
                                                                        confirmDeleteBankCard(item.id)
                                                                    }
                                                                    ), _uA(
                                                                        _cE("text", _uM("class" to "text-ri"), "解绑")
                                                                    ), 8, _uA(
                                                                        "onClick"
                                                                    ))
                                                                ), 4)
                                                            )
                                                        }
                                                        ), "_" to 2), 1024)
                                                    }
                                                    ), 128),
                                                    if (unref(bankCardList).length <= 0) {
                                                        _cV(_component_x_empty, _uM("key" to 0, "loading" to false, "empty" to true, "showBtn" to false))
                                                    } else {
                                                        _cC("v-if", true)
                                                    }
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "modelValue",
                                                "model-bottom-status",
                                                "height",
                                                "style"
                                            ))
                                        )
                                    }
                                    ), "_" to 1))
                                ))
                            ))
                        )
                    }
                    ), "_" to 1)),
                    _cE("view", _uM("class" to "bottom-panel flex-row"), _uA(
                        _cV(_component_mc_primary_button, _uM("height" to "89rpx", "onClick" to toAddBank), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                "添加银行卡"
                            )
                        }
                        ), "_" to 1))
                    )),
                    _cV(_component_x_modal, _uM("show" to unref(deleteBankTipsModal), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(deleteBankTipsModal, `$event`)
                    }
                    , "title" to "温馨提示", "onConfirm" to fun(){
                        toDeleteBankCard()
                    }
                    , "onCancel" to fun(){
                        deleteBankTipsModal.value = false
                    }
                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("text", _uM("style" to _nS(_uM("text-align" to "center"))), "确认要解绑该银行卡吗？", 4)
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show",
                        "onConfirm",
                        "onCancel"
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
                return _uM("container" to _pS(_uM("width" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 20, "height" to "100%")), "home-bg" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "bottom" to 0, "width" to "100%", "zIndex" to -1)), "top-bg" to _uM(".home-bg " to _uM("width" to "100%", "height" to "100%", "backgroundImage" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)")), "bank-card-list" to _pS(_uM("marginTop" to 50)), "item" to _uM(".bank-card-list " to _uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "bank-name" to _uM(".bank-card-list .item .card-item " to _uM("fontSize" to "32rpx", "fontWeight" to "bold")), "bank-num" to _uM(".bank-card-list .item .card-item " to _uM("fontSize" to "28rpx", "color" to "#545454")), "u-name" to _uM(".bank-card-list .item .card-item " to _uM("fontSize" to "28rpx", "color" to "#545454")), "text-round" to _uM(".bank-card-list .item " to _uM("width" to "150rpx", "height" to "60rpx", "backgroundImage" to "none", "backgroundColor" to "#E9F1FF", "borderTopLeftRadius" to "30rpx", "borderTopRightRadius" to "30rpx", "borderBottomRightRadius" to "30rpx", "borderBottomLeftRadius" to "30rpx", "alignItems" to "center")), "text-ri" to _uM(".bank-card-list .item .text-round " to _uM("fontSize" to "28rpx", "color" to "#5470A8", "paddingTop" to 8, "paddingRight" to 8, "paddingBottom" to 8, "paddingLeft" to 8, "textAlign" to "center")), "bottom-panel" to _pS(_uM("position" to "fixed", "bottom" to 0, "left" to 0, "width" to "100%", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "60rpx", "paddingLeft" to "20rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
