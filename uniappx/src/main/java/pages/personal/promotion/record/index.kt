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
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesPersonalPromotionRecordIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalPromotionRecordIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalPromotionRecordIndex
            val _cache = __ins.renderCache
            val router = uni_useKuxRouter()
            val globalData = inject("globalData") as GlobalDataType
            val selectedDate = ref<String>(formatDate(Date(), "yyyy-MM-dd"))
            val showDatePicker = ref<Boolean>(false)
            val detailList = ref(utsArrayOf<ITEM_INFO>())
            var scrollDirection = "down"
            val isfresh = ref<Boolean>(false)
            val bottomFresh = ref<Boolean>(false)
            var page: Number = 1
            var limit: Number = 15
            val hisQuery = fun(){
                getPromotionRecords(page, limit).then(fun(res: Response){
                    if (res.data != null && res.code == 200) {
                        val result = res.data as UTSJSONObject
                        val totalRes = result.getNumber("total") as Number
                        if (totalRes != null) {
                            totalRes
                        } else {
                            0
                        }
                        val records = result.getArray("records")
                        var dataList = utsArrayOf<ITEM_INFO>()
                        if (records != null) {
                            dataList = JSON.parse<UTSArray<ITEM_INFO>>(JSON.stringify(records)) as UTSArray<ITEM_INFO>
                        }
                        if (scrollDirection == "down") {
                            isfresh.value = false
                            detailList.value = dataList
                        } else {
                            bottomFresh.value = false
                            detailList.value = detailList.value.concat(dataList)
                        }
                    }
                }
                )
            }
            val onScrollDirection = fun(type: String){
                scrollDirection = type
            }
            val topLoad = fun(){
                console.log("下拉刷新")
                page = 1
                hisQuery()
            }
            val bottomLoad = fun(){
                console.log("触底刷新")
                page++
                hisQuery()
            }
            onMounted(fun(){
                hisQuery()
            }
            )
            return fun(): Any? {
                val _component_x_empty = resolveEasyComponent("x-empty", GenUniModulesTmxUiComponentsXEmptyXEmptyClass)
                val _component_x_pull_refresh = resolveEasyComponent("x-pull-refresh", GenUniModulesTmxUiComponentsXPullRefreshXPullRefreshClass)
                val _component_template = resolveComponent("template")
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createVNode(_component_mc_base_container, utsMapOf("showStatusBarPlaceholder" to false, "scroll" to true, "show-navbar" to true, "navbarIsPlace" to false, "static-transparent" to false, "title" to "推广记录"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("style" to normalizeStyle("width:100%;height: " + unref(statusBarHeight) + "px;")), null, 4),
                        createElementVNode("view", utsMapOf("class" to "home-bg"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "top-bg"))
                        )),
                        createElementVNode("view", utsMapOf("class" to "container"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "order-list"), utsArrayOf(
                                createVNode(_component_template, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createVNode(_component_x_pull_refresh, utsMapOf("modelValue" to unref(isfresh), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                            trySetRefValue(isfresh, `$event`)
                                        }
                                        , "show-scrollbar" to false, "onScrollDirection" to onScrollDirection, "model-bottom-status" to unref(bottomFresh), "onUpdate:modelBottomStatus" to fun(`$event`: Boolean){
                                            trySetRefValue(bottomFresh, `$event`)
                                        }
                                        , "onRefresh" to topLoad, "onBottomRefresh" to bottomLoad, "height" to ((unref(screenHeight) - unref(globalData).safeAreaBottom - unref(statusBarHeight) - 100) + "px")), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createElementVNode(Fragment, null, RenderHelpers.renderList(unref(detailList), fun(item, index, __index, _cached): Any {
                                                    return createElementVNode("view", utsMapOf("class" to "order-item", "style" to normalizeStyle("margin-bottom: 20rpx;height:70px;width: " + (unref(screenWidth) - 30) + "; \n							background-color: #ffffff; border-radius: 20rpx; padding: 20rpx;"), "key" to index), utsArrayOf(
                                                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex-direction" to "column", "justify-content" to "space-between"))), utsArrayOf(
                                                            createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("font-family" to "PingFang SC", "font-weight" to "bold", "font-size" to "30rpx", "color" to "#000000"))), toDisplayString(item.maskedPhone), 5),
                                                            createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("font-family" to "PingFang SC", "font-weight" to "bold", "font-size" to "26rpx", "color" to "#BFBFBF", "margin-top" to "5rpx"))), toDisplayString(item.updateTime), 5)
                                                        ), 4),
                                                        createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("font-family" to "PingFang SC", "font-weight" to "bold", "font-size" to "34rpx", "color" to "#2D9E62"))), " 成功 ", 4)
                                                    ), 4)
                                                }
                                                ), 128),
                                                if (unref(detailList).length <= 0) {
                                                    createVNode(_component_x_empty, utsMapOf("key" to 0, "loading" to false, "empty" to true, "showBtn" to false))
                                                } else {
                                                    createCommentVNode("v-if", true)
                                                }
                                            )
                                        }
                                        ), "_" to 1), 8, utsArrayOf(
                                            "modelValue",
                                            "model-bottom-status",
                                            "height"
                                        ))
                                    )
                                }
                                ), "_" to 1))
                            ))
                        ))
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
                return utsMapOf("container" to padStyleMapOf(utsMapOf("width" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 20, "height" to "100%")), "home-bg" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1, "height" to "100%")), "top-bg" to utsMapOf(".home-bg " to utsMapOf("height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)")), "order-list" to padStyleMapOf(utsMapOf("marginTop" to 50, "height" to "100%")), "order-item" to utsMapOf(".order-list " to utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "order-route" to utsMapOf(".order-list .order-item " to utsMapOf("display" to "flex", "alignItems" to "center")), "price" to utsMapOf(".order-list .order-item " to utsMapOf("fontSize" to 23, "color" to "#FF3B30", "fontWeight" to "bold", "marginLeft" to "auto")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
