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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import uts.sdk.modules.xToastS.XTOAST_TYPE
import uts.sdk.modules.xToastS.showToast as showToast1
import uts.sdk.modules.xToastS.hideToast
open class GenPagesPersonalSettingEmergencyContactIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalSettingEmergencyContactIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalSettingEmergencyContactIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val formData = reactive<FormData1>(FormData1(driverCallName = "", driverCallPhone = ""))
            val saveData = fun(){
                console.log("saveData")
                updateDriverContacts(formData.driverCallName, formData.driverCallPhone).then(fun(res: Response){
                    if (res.code == 200) {
                        showToast1(XTOAST_TYPE(title = "保存成功", iconCode = "success", iconColor = "green", titleColor = "green"))
                    }
                }
                )
            }
            onReady(fun(){
                getDriverContacts().then(fun(res: Response){
                    if (res.code == 200) {
                        val data = res.data as UTSJSONObject
                        formData.driverCallName = data.getString("driverCallName") ?: ""
                        formData.driverCallPhone = data.getString("driverCallPhone") ?: ""
                    }
                }
                )
            }
            )
            return fun(): Any? {
                val _component_x_input = resolveEasyComponent("x-input", GenUniModulesTmxUiComponentsXInputXInputClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createVNode(_component_mc_base_container, utsMapOf("title" to "紧急联系人"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                            "15"
                        ), "padding" to utsArrayOf(
                            "20",
                            "10",
                            "20",
                            "10"
                        )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "setting-item"), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "name"), "紧急联系人姓名"),
                                    createVNode(_component_x_input, utsMapOf("placeholder" to "请输入联系人姓名", "width" to "300rpx", "maxlength" to 10, "color" to "#00000000", "modelValue" to unref(formData).driverCallName, "onUpdate:modelValue" to fun(`$event`: String){
                                        unref(formData).driverCallName = `$event`
                                    }
                                    ), utsMapOf("inputRight" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode("image", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "13rpx", "height" to "28rpx")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 12, utsArrayOf(
                                                "src"
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, utsArrayOf(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    ))
                                ))
                            )
                        }
                        ), "_" to 1)),
                        createVNode(_component_x_sheet, utsMapOf("margin" to utsArrayOf(
                            "15",
                            "0",
                            "15",
                            "15"
                        ), "padding" to utsArrayOf(
                            "15",
                            "10",
                            "15",
                            "10"
                        )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "setting-item"), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "name"), "紧急联系人电话"),
                                    createVNode(_component_x_input, utsMapOf("placeholder" to "请输入联系人电话", "width" to "300rpx", "maxlength" to 11, "color" to "#00000000", "type" to "digit", "modelValue" to unref(formData).driverCallPhone, "onUpdate:modelValue" to fun(`$event`: String){
                                        unref(formData).driverCallPhone = `$event`
                                    }
                                    ), utsMapOf("inputRight" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode("image", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "13rpx", "height" to "28rpx")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-right-line-samll.png"), "mode" to "widthFix"), null, 12, utsArrayOf(
                                                "src"
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, utsArrayOf(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    ))
                                ))
                            )
                        }
                        ), "_" to 1)),
                        createElementVNode("view", utsMapOf("class" to "btn-group-panel flex-row", "style" to normalizeStyle("padding-bottom: " + (unref(globalData).safeAreaBottom + 15) + "px;")), utsArrayOf(
                            createVNode(_component_mc_primary_button, utsMapOf("onClick" to saveData, "height" to "50px"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    "保存"
                                )
                            }
                            ), "_" to 1))
                        ), 4)
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
                return utsMapOf("setting-item" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "name" to utsMapOf(".setting-item " to utsMapOf("fontSize" to 17)), "value" to utsMapOf(".setting-item " to utsMapOf("color" to "#939393")), "btn-group-panel" to padStyleMapOf(utsMapOf("position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
