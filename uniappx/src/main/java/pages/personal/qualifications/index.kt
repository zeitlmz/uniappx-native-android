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
open class GenPagesPersonalQualificationsIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalQualificationsIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalQualificationsIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val carTabs = ref(utsArrayOf<TABS_ITEM_INFO>(TABS_ITEM_INFO(title = "晋AF3562"), TABS_ITEM_INFO(title = "晋AF3563"), TABS_ITEM_INFO(title = "晋AF3564"), TABS_ITEM_INFO(title = "晋AF3565"), TABS_ITEM_INFO(title = "晋AF3566"), TABS_ITEM_INFO(title = "晋AF3567"), TABS_ITEM_INFO(title = "晋AF3562", disabled = true)))
            val formData = reactive<DriverInfo>(DriverInfo(driverSourceType = "0", driverType = "", frontSideIdCardPhoto = "", backSideIdCardPhoto = "", licenseFrontPic = "", licenseSecondPic = "", certificatePic = "", roadPassengerTransportCertificatePic = "", vehicleQualificationList = utsArrayOf()))
            val entryModeSelecteds = ref(utsArrayOf<String>())
            val entryModeStr = ref<String>("租车购车入驻")
            val entryModeList = ref(utsArrayOf<PICKER_ITEM_INFO>(PICKER_ITEM_INFO(title = "租车购车入驻", id = "1"), PICKER_ITEM_INFO(title = "自备车辆入驻", id = "0")))
            val driverTypeStr = ref(utsArrayOf<String>("网约车", "客运车"))
            val driverTypeSelecteds = ref(utsArrayOf<String>())
            val driverTypeList = ref(utsArrayOf<UTSJSONObject>(object : UTSJSONObject() {
                var name = "网约车"
                var id = "0"
            }, object : UTSJSONObject() {
                var name = "客运车"
                var id = "1"
            }))
            val serviceProviderSelecteds = ref(utsArrayOf<String>())
            val serviceProviderStr = ref(utsArrayOf<String>())
            var serviceProviderList = ref(utsArrayOf<UTSJSONObject>())
            val citySelecteds = ref(utsArrayOf<String>())
            val citySelectedStr = ref<String>("")
            var cityList = ref(utsArrayOf<PICKER_ITEM_INFO>())
            val activeCarIndex = ref<String>("0")
            val currentCarInfo = ref<VehicleQualification>(VehicleQualification(vehiclePlateNo = "", companyName = "", qualificationPhoto = ""))
            val checkShowCertificatePic = fun(driverType: String): Boolean {
                val status = driverTypeSelecteds.value.indexOf(driverType) > -1
                console.log("checkShowCertificatePic driverType=", driverType, ", driverTypeSelecteds = ", driverTypeSelecteds.value, ",  status = ", status)
                return status
            }
            fun gen_feedbackDetail_fn() {
                getDriverQualification().then(fun(res: Response){
                    if (res.code == 200) {
                        val driverInfo = JSON.parseObject<DriverInfo>(JSON.stringify(res.data))
                        driverTypeSelecteds.value = driverTypeSelecteds.value.concat((driverInfo?.driverType ?: "").split(","))
                        entryModeSelecteds.value.push(driverInfo?.driverSourceType ?: "")
                        formData.frontSideIdCardPhoto = driverInfo?.frontSideIdCardPhoto ?: ""
                        formData.backSideIdCardPhoto = driverInfo?.backSideIdCardPhoto ?: ""
                        formData.licenseFrontPic = driverInfo?.licenseFrontPic ?: ""
                        formData.licenseSecondPic = driverInfo?.licenseSecondPic ?: ""
                        formData.certificatePic = driverInfo?.certificatePic ?: ""
                        formData.roadPassengerTransportCertificatePic = driverInfo?.roadPassengerTransportCertificatePic ?: ""
                        carTabs.value = utsArrayOf()
                        if (driverInfo?.vehicleQualificationList != null) {
                            formData.vehicleQualificationList = driverInfo.vehicleQualificationList as UTSArray<VehicleQualification>
                            if (formData.vehicleQualificationList != null && formData.vehicleQualificationList.length > 0) {
                                formData.vehicleQualificationList.forEach(fun(item){
                                    carTabs.value.push(TABS_ITEM_INFO(title = item.vehiclePlateNo))
                                }
                                )
                                currentCarInfo.value = formData.vehicleQualificationList[0]
                            }
                        }
                    }
                }
                ).`catch`(fun(err: Any?){
                    console.log("err===", err)
                }
                )
            }
            val feedbackDetail = ::gen_feedbackDetail_fn
            onReady(fun(){
                feedbackDetail()
            }
            )
            watch(activeCarIndex, fun(newVal: String, oldVal: String){
                console.log("当前选中的车辆索引:", newVal)
                currentCarInfo.value = formData.vehicleQualificationList[parseInt(newVal)]
                console.log("当前选中的车辆:", currentCarInfo.value)
            }
            )
            return fun(): Any? {
                val _component_x_picker = resolveEasyComponent("x-picker", GenUniModulesTmxUiComponentsXPickerXPickerClass)
                val _component_x_picker_selected = resolveEasyComponent("x-picker-selected", GenUniModulesTmxUiComponentsXPickerSelectedXPickerSelectedClass)
                val _component_x_image = resolveEasyComponent("x-image", GenUniModulesTmxUiComponentsXImageXImageClass)
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_x_tabs = resolveEasyComponent("x-tabs", GenUniModulesTmxUiComponentsXTabsXTabsClass)
                val _component_x_divider = resolveEasyComponent("x-divider", GenUniModulesTmxUiComponentsXDividerXDividerClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createVNode(_component_mc_base_container, utsMapOf("title" to "司机资质"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "home-bg"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "top-bg"))
                        )),
                        createElementVNode("view", utsMapOf("class" to "approve-info-container"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "info-section"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "section-title"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "title-bar")),
                                    createElementVNode("text", utsMapOf("class" to "title-text"), "基础信息")
                                )),
                                createElementVNode("view", utsMapOf("class" to "info-form", "style" to normalizeStyle(utsMapOf("border-radius" to "20rpx", "background-color" to "#FFFFFF", "padding" to "30rpx 30rpx"))), utsArrayOf(
                                    createVNode(_component_x_picker, utsMapOf("modelValue" to entryModeSelecteds.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                        entryModeSelecteds.value = `$event`
                                    }
                                    , "model-str" to entryModeStr.value, "onUpdate:modelStr" to fun(`$event`: String){
                                        entryModeStr.value = `$event`
                                    }
                                    , "disabled" to true, "list" to entryModeList.value), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "form-item"), utsArrayOf(
                                                createElementVNode("text", utsMapOf("class" to "item-label"), "入驻形式"),
                                                createElementVNode("view", utsMapOf("class" to "item-value"), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to normalizeClass(utsMapOf("placeholder-text" to (entryModeSelecteds.value.length == 0)))), toDisplayString(if ((entryModeSelecteds.value.length > 0)) {
                                                        entryModeStr.value
                                                    } else {
                                                        "请选择"
                                                    }
                                                    ), 3)
                                                ))
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, utsArrayOf(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "model-str",
                                        "onUpdate:modelStr",
                                        "list"
                                    )),
                                    createVNode(_component_x_picker_selected, utsMapOf("label-key" to "name", "modelValue" to driverTypeSelecteds.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                        driverTypeSelecteds.value = `$event`
                                    }
                                    , "disabled" to true, "model-str" to driverTypeStr.value, "onUpdate:modelStr" to fun(`$event`: UTSArray<String>){
                                        driverTypeStr.value = `$event`
                                    }
                                    , "list" to driverTypeList.value), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "form-item"), utsArrayOf(
                                                createElementVNode("text", utsMapOf("class" to "item-label"), "业务范围"),
                                                createElementVNode("view", utsMapOf("class" to "item-value"), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to normalizeClass(utsMapOf("placeholder-text" to (driverTypeSelecteds.value.length == 0)))), toDisplayString(if (driverTypeSelecteds.value.length > 0) {
                                                        driverTypeStr.value.join("、")
                                                    } else {
                                                        "请选择"
                                                    }
                                                    ), 3)
                                                ))
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, utsArrayOf(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "model-str",
                                        "onUpdate:modelStr",
                                        "list"
                                    ))
                                ), 4)
                            )),
                            createElementVNode("view", utsMapOf("class" to "info-section"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "section-title"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "title-bar")),
                                    createElementVNode("text", utsMapOf("class" to "title-text"), "身份证信息")
                                )),
                                createElementVNode("view", utsMapOf("class" to "upload-container"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "upload-item"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "upload-box"), utsArrayOf(
                                            if (isTrue(unref(formData).frontSideIdCardPhoto)) {
                                                createVNode(_component_x_image, utsMapOf("key" to 0, "class" to "uploaded-image", "src" to unref(formData).frontSideIdCardPhoto, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                ))
                                            } else {
                                                createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/id-card-front.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                ))
                                            }
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "upload-item"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "upload-box"), utsArrayOf(
                                            if (isTrue(unref(formData).backSideIdCardPhoto)) {
                                                createVNode(_component_x_image, utsMapOf("key" to 0, "class" to "uploaded-image", "src" to unref(formData).backSideIdCardPhoto, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                ))
                                            } else {
                                                createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/id-card-back.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                ))
                                            }
                                        ))
                                    ))
                                ))
                            )),
                            createElementVNode("view", utsMapOf("class" to "info-section"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "section-title"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "title-bar")),
                                    createElementVNode("text", utsMapOf("class" to "title-text"), "驾驶证信息")
                                )),
                                createElementVNode("view", utsMapOf("class" to "upload-container"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "upload-item"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "upload-box"), utsArrayOf(
                                            if (isTrue(unref(formData).licenseFrontPic)) {
                                                createVNode(_component_x_image, utsMapOf("key" to 0, "class" to "uploaded-image", "src" to unref(formData).licenseFrontPic, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                ))
                                            } else {
                                                createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/driver-license-front.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                ))
                                            }
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "upload-item"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "upload-box"), utsArrayOf(
                                            if (isTrue(unref(formData).licenseSecondPic)) {
                                                createVNode(_component_x_image, utsMapOf("key" to 0, "class" to "uploaded-image", "src" to unref(formData).licenseSecondPic, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                ))
                                            } else {
                                                createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/driver-license-back.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                ))
                                            }
                                        ))
                                    ))
                                ))
                            )),
                            createElementVNode("view", utsMapOf("class" to "info-section"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "section-title"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "title-bar")),
                                    createElementVNode("text", utsMapOf("class" to "title-text"), "驾驶员资质")
                                )),
                                createElementVNode("view", utsMapOf("class" to "upload-container"), utsArrayOf(
                                    if (isTrue(checkShowCertificatePic("0"))) {
                                        createElementVNode("view", utsMapOf("key" to 0, "class" to "upload-item"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "upload-box"), utsArrayOf(
                                                if (isTrue(unref(formData).certificatePic)) {
                                                    createVNode(_component_x_image, utsMapOf("key" to 0, "class" to "uploaded-image", "src" to unref(formData).certificatePic, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                } else {
                                                    createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/qualification-front.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                }
                                            ))
                                        ))
                                    } else {
                                        createCommentVNode("v-if", true)
                                    }
                                    ,
                                    if (isTrue(checkShowCertificatePic("1"))) {
                                        createElementVNode("view", utsMapOf("key" to 1, "class" to "upload-item"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "upload-box"), utsArrayOf(
                                                if (isTrue(unref(formData).roadPassengerTransportCertificatePic)) {
                                                    createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to unref(formData).roadPassengerTransportCertificatePic, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                } else {
                                                    createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/qualification-front-2.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                }
                                            ))
                                        ))
                                    } else {
                                        createCommentVNode("v-if", true)
                                    }
                                ))
                            )),
                            createElementVNode("view", utsMapOf("class" to "info-section"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "section-title"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "title-bar")),
                                    createElementVNode("text", utsMapOf("class" to "title-text"), utsArrayOf(
                                        "车辆信息 ",
                                        if (carTabs.value.length > 0) {
                                            createVNode(_component_x_text, utsMapOf("key" to 0, "class" to "title-text"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    "(" + toDisplayString(carTabs.value.length) + ")个"
                                                )
                                            }), "_" to 1))
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                    ))
                                )),
                                createElementVNode("view", utsMapOf("class" to "info-form"), utsArrayOf(
                                    createVNode(_component_x_tabs, utsMapOf("item-width" to "33.3%", "list" to carTabs.value, "showLine" to false, "round" to "7", "item-active-style" to "background-color:#536FA6;border-radius: 11rpx;", "item-style" to "background-color:#ffffff", "width" to "width: 207rpx", "height" to "63rpx", "modelValue" to activeCarIndex.value, "onUpdate:modelValue" to fun(`$event`: String){
                                        activeCarIndex.value = `$event`
                                    }
                                    ), utsMapOf("default" to withScopedSlotCtx(fun(slotProps: GenUniModulesTmxUiComponentsXTabsXTabsSlotDataDefault): UTSArray<Any> {
                                        val item = slotProps.item
                                        val active = slotProps.active
                                        return utsArrayOf(
                                            createVNode(_component_x_text, utsMapOf("color" to if (active) {
                                                "white"
                                            } else {
                                                "#536FA6"
                                            }
                                            , "style" to normalizeStyle(utsMapOf("font-weight" to "bold"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    toDisplayString(item.title)
                                                )
                                            }
                                            ), "_" to 2), 1032, utsArrayOf(
                                                "color",
                                                "style"
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, utsArrayOf(
                                        "list",
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    )),
                                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("background-color" to "#ffffff", "border-radius" to "20rpx", "margin-top" to "20rpx", "padding" to "20rpx"))), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "section-title", "style" to normalizeStyle(utsMapOf("margin-top" to "10rpx"))), utsArrayOf(
                                            createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("font-size" to "32rpx"))), toDisplayString(currentCarInfo.value.companyName), 5)
                                        ), 4),
                                        if (isTrue(currentCarInfo.value.companyName)) {
                                            createVNode(_component_x_divider, utsMapOf("key" to 0, "lineWidth" to "1", "color" to "#D4D4D4", "style" to normalizeStyle(utsMapOf("margin-top" to "3rpx"))), null, 8, utsArrayOf(
                                                "style"
                                            ))
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                        ,
                                        createElementVNode("view", utsMapOf("class" to "upload-container", "style" to normalizeStyle(utsMapOf("margin-top" to "23rpx"))), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "upload-item", "style" to normalizeStyle(utsMapOf("width" to "100%"))), utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "upload-box"), utsArrayOf(
                                                    createVNode(_component_x_image, utsMapOf("class" to "uploaded-image", "src" to currentCarInfo.value.qualificationPhoto, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                ))
                                            ), 4)
                                        ), 4)
                                    ), 4)
                                ))
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
                return utsMapOf("home-bg" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1, "height" to "100%")), "top-bg" to utsMapOf(".home-bg " to utsMapOf("height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)")), "approve-info-container" to padStyleMapOf(utsMapOf("height" to "100%", "paddingTop" to "30rpx", "paddingBottom" to "330rpx")), "info-section" to padStyleMapOf(utsMapOf("borderTopLeftRadius" to "12rpx", "borderTopRightRadius" to "12rpx", "borderBottomRightRadius" to "12rpx", "borderBottomLeftRadius" to "12rpx", "marginTop" to 0, "marginRight" to "20rpx", "marginBottom" to "20rpx", "marginLeft" to "20rpx", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "20rpx", "paddingLeft" to "20rpx")), "section-title" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "marginBottom" to "20rpx")), "title-bar" to padStyleMapOf(utsMapOf("width" to "6rpx", "height" to "30rpx", "backgroundColor" to "#536FA6", "marginRight" to "10rpx")), "title-text" to padStyleMapOf(utsMapOf("fontSize" to "32rpx", "fontWeight" to "bold", "color" to "#000000")), "info-form" to padStyleMapOf(utsMapOf("width" to "100%")), "form-item" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to "30rpx", "paddingRight" to 0, "paddingBottom" to "30rpx", "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#eeeeee", "borderBottomWidth:last-child" to "medium", "borderBottomStyle:last-child" to "none", "borderBottomColor:last-child" to "#000000")), "item-label" to padStyleMapOf(utsMapOf("fontSize" to "28rpx", "color" to "#6C6C6C")), "item-value" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "fontSize" to "32rpx", "color" to "#333333")), "placeholder-text" to utsMapOf(".item-value " to utsMapOf("fontSize" to "28rpx", "color" to "#B2B2B2")), "icon-mail" to padStyleMapOf(utsMapOf("marginLeft" to "10rpx", "fontSize" to "28rpx")), "icon-arrow" to padStyleMapOf(utsMapOf("marginLeft" to "10rpx", "width" to 11, "height" to 6)), "upload-container" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to "20rpx")), "single-upload" to padStyleMapOf(utsMapOf("justifyContent" to "center")), "upload-item" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "width" to "48%")), "upload-box" to padStyleMapOf(utsMapOf("width" to "100%", "height" to 120, "display" to "flex", "justifyContent" to "center", "alignItems" to "center")), "upload-icon" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "99%")), "uploaded-image" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100%")), "button-group" to padStyleMapOf(utsMapOf("position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to "20rpx", "paddingLeft" to "20rpx", "paddingRight" to "20rpx", "backgroundColor" to "#ffffff", "boxShadow" to "0 -2rpx 10rpx rgba(0, 0, 0, 0.05)", "zIndex" to 100)), "btn-review" to padStyleMapOf(utsMapOf("width" to "49%", "paddingTop" to 2, "paddingRight" to 0, "paddingBottom" to 2, "paddingLeft" to 0, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "fontSize" to 18, "boxShadow" to "0px 5px 10px 0px rgba(0, 0, 0, 0.2)", "backgroundColor" to "#ffffff", "color" to "#333333", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000")), "btn-save" to padStyleMapOf(utsMapOf("width" to "49%", "paddingTop" to 2, "paddingRight" to 0, "paddingBottom" to 2, "paddingLeft" to 0, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "fontSize" to 18, "boxShadow" to "0px 5px 10px 0px rgba(0, 0, 0, 0.2)", "backgroundColor" to "#000000", "color" to "#ffffff")), "car-info-section" to padStyleMapOf(utsMapOf("marginTop" to "20rpx")), "car-info-title" to padStyleMapOf(utsMapOf("fontSize" to "32rpx", "fontWeight" to "bold", "marginBottom" to "10rpx")), "car-info-content" to padStyleMapOf(utsMapOf("backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "20rpx", "paddingLeft" to "20rpx", "marginTop" to "10rpx")), "no-data-tip" to padStyleMapOf(utsMapOf("display" to "flex", "justifyContent" to "center", "alignItems" to "center", "paddingTop" to "40rpx", "paddingRight" to 0, "paddingBottom" to "40rpx", "paddingLeft" to 0, "fontSize" to "28rpx", "color" to "#999999")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
