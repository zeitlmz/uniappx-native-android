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
            val carTabs = ref(_uA<TABS_ITEM_INFO>(TABS_ITEM_INFO(title = "晋AF3562"), TABS_ITEM_INFO(title = "晋AF3563"), TABS_ITEM_INFO(title = "晋AF3564"), TABS_ITEM_INFO(title = "晋AF3565"), TABS_ITEM_INFO(title = "晋AF3566"), TABS_ITEM_INFO(title = "晋AF3567"), TABS_ITEM_INFO(title = "晋AF3562", disabled = true)))
            val formData = reactive<DriverInfo>(DriverInfo(driverSourceType = "0", driverType = "", frontSideIdCardPhoto = "", backSideIdCardPhoto = "", licenseFrontPic = "", licenseSecondPic = "", certificatePic = "", roadPassengerTransportCertificatePic = "", vehicleQualificationList = _uA()))
            val entryModeSelecteds = ref(_uA<String>())
            val entryModeStr = ref<String>("租车购车入驻")
            val entryModeList = ref(_uA<PICKER_ITEM_INFO>(PICKER_ITEM_INFO(title = "租车购车入驻", id = "1"), PICKER_ITEM_INFO(title = "自备车辆入驻", id = "0")))
            val driverTypeStr = ref(_uA<String>("网约车", "客运车"))
            val driverTypeSelecteds = ref(_uA<String>())
            val driverTypeList = ref(_uA<UTSJSONObject>(object : UTSJSONObject() {
                var name = "网约车"
                var id = "0"
            }, object : UTSJSONObject() {
                var name = "客运车"
                var id = "1"
            }))
            val serviceProviderSelecteds = ref(_uA<String>())
            val serviceProviderStr = ref(_uA<String>())
            var serviceProviderList = ref(_uA<UTSJSONObject>())
            val citySelecteds = ref(_uA<String>())
            val citySelectedStr = ref<String>("")
            var cityList = ref(_uA<PICKER_ITEM_INFO>())
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
                        carTabs.value = _uA()
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
                return _cV(_component_mc_base_container, _uM("title" to "司机资质"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "home-bg"), _uA(
                            _cE("view", _uM("class" to "top-bg"))
                        )),
                        _cE("view", _uM("class" to "approve-info-container"), _uA(
                            _cE("view", _uM("class" to "info-section"), _uA(
                                _cE("view", _uM("class" to "section-title"), _uA(
                                    _cE("view", _uM("class" to "title-bar")),
                                    _cE("text", _uM("class" to "title-text"), "基础信息")
                                )),
                                _cE("view", _uM("class" to "info-form", "style" to _nS(_uM("border-radius" to "20rpx", "background-color" to "#FFFFFF", "padding" to "30rpx 30rpx"))), _uA(
                                    _cV(_component_x_picker, _uM("modelValue" to entryModeSelecteds.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                        entryModeSelecteds.value = `$event`
                                    }
                                    , "model-str" to entryModeStr.value, "onUpdate:modelStr" to fun(`$event`: String){
                                        entryModeStr.value = `$event`
                                    }
                                    , "disabled" to true, "list" to entryModeList.value), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "form-item"), _uA(
                                                _cE("text", _uM("class" to "item-label"), "入驻形式"),
                                                _cE("view", _uM("class" to "item-value"), _uA(
                                                    _cE("text", _uM("class" to _nC(_uM("placeholder-text" to (entryModeSelecteds.value.length == 0)))), _tD(if ((entryModeSelecteds.value.length > 0)) {
                                                        entryModeStr.value
                                                    } else {
                                                        "请选择"
                                                    }
                                                    ), 3)
                                                ))
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "model-str",
                                        "onUpdate:modelStr",
                                        "list"
                                    )),
                                    _cV(_component_x_picker_selected, _uM("label-key" to "name", "modelValue" to driverTypeSelecteds.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                        driverTypeSelecteds.value = `$event`
                                    }
                                    , "disabled" to true, "model-str" to driverTypeStr.value, "onUpdate:modelStr" to fun(`$event`: UTSArray<String>){
                                        driverTypeStr.value = `$event`
                                    }
                                    , "list" to driverTypeList.value), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "form-item"), _uA(
                                                _cE("text", _uM("class" to "item-label"), "业务范围"),
                                                _cE("view", _uM("class" to "item-value"), _uA(
                                                    _cE("text", _uM("class" to _nC(_uM("placeholder-text" to (driverTypeSelecteds.value.length == 0)))), _tD(if (driverTypeSelecteds.value.length > 0) {
                                                        driverTypeStr.value.join("、")
                                                    } else {
                                                        "请选择"
                                                    }
                                                    ), 3)
                                                ))
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "model-str",
                                        "onUpdate:modelStr",
                                        "list"
                                    ))
                                ), 4)
                            )),
                            _cE("view", _uM("class" to "info-section"), _uA(
                                _cE("view", _uM("class" to "section-title"), _uA(
                                    _cE("view", _uM("class" to "title-bar")),
                                    _cE("text", _uM("class" to "title-text"), "身份证信息")
                                )),
                                _cE("view", _uM("class" to "upload-container"), _uA(
                                    _cE("view", _uM("class" to "upload-item"), _uA(
                                        _cE("view", _uM("class" to "upload-box"), _uA(
                                            if (isTrue(unref(formData).frontSideIdCardPhoto)) {
                                                _cV(_component_x_image, _uM("key" to 0, "class" to "uploaded-image", "src" to unref(formData).frontSideIdCardPhoto, "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                ))
                                            } else {
                                                _cE("image", _uM("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/id-card-front.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                ))
                                            }
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "upload-item"), _uA(
                                        _cE("view", _uM("class" to "upload-box"), _uA(
                                            if (isTrue(unref(formData).backSideIdCardPhoto)) {
                                                _cV(_component_x_image, _uM("key" to 0, "class" to "uploaded-image", "src" to unref(formData).backSideIdCardPhoto, "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                ))
                                            } else {
                                                _cE("image", _uM("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/id-card-back.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                ))
                                            }
                                        ))
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "info-section"), _uA(
                                _cE("view", _uM("class" to "section-title"), _uA(
                                    _cE("view", _uM("class" to "title-bar")),
                                    _cE("text", _uM("class" to "title-text"), "驾驶证信息")
                                )),
                                _cE("view", _uM("class" to "upload-container"), _uA(
                                    _cE("view", _uM("class" to "upload-item"), _uA(
                                        _cE("view", _uM("class" to "upload-box"), _uA(
                                            if (isTrue(unref(formData).licenseFrontPic)) {
                                                _cV(_component_x_image, _uM("key" to 0, "class" to "uploaded-image", "src" to unref(formData).licenseFrontPic, "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                ))
                                            } else {
                                                _cE("image", _uM("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/driver-license-front.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                ))
                                            }
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "upload-item"), _uA(
                                        _cE("view", _uM("class" to "upload-box"), _uA(
                                            if (isTrue(unref(formData).licenseSecondPic)) {
                                                _cV(_component_x_image, _uM("key" to 0, "class" to "uploaded-image", "src" to unref(formData).licenseSecondPic, "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                ))
                                            } else {
                                                _cE("image", _uM("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/driver-license-back.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                ))
                                            }
                                        ))
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "info-section"), _uA(
                                _cE("view", _uM("class" to "section-title"), _uA(
                                    _cE("view", _uM("class" to "title-bar")),
                                    _cE("text", _uM("class" to "title-text"), "驾驶员资质")
                                )),
                                _cE("view", _uM("class" to "upload-container"), _uA(
                                    if (isTrue(checkShowCertificatePic("0"))) {
                                        _cE("view", _uM("key" to 0, "class" to "upload-item"), _uA(
                                            _cE("view", _uM("class" to "upload-box"), _uA(
                                                if (isTrue(unref(formData).certificatePic)) {
                                                    _cV(_component_x_image, _uM("key" to 0, "class" to "uploaded-image", "src" to unref(formData).certificatePic, "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    ))
                                                } else {
                                                    _cE("image", _uM("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/qualification-front.png"), "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    ))
                                                }
                                            ))
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    if (isTrue(checkShowCertificatePic("1"))) {
                                        _cE("view", _uM("key" to 1, "class" to "upload-item"), _uA(
                                            _cE("view", _uM("class" to "upload-box"), _uA(
                                                if (isTrue(unref(formData).roadPassengerTransportCertificatePic)) {
                                                    _cE("image", _uM("key" to 0, "class" to "uploaded-image", "src" to unref(formData).roadPassengerTransportCertificatePic, "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    ))
                                                } else {
                                                    _cE("image", _uM("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/qualification-front-2.png"), "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    ))
                                                }
                                            ))
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ))
                            )),
                            _cE("view", _uM("class" to "info-section"), _uA(
                                _cE("view", _uM("class" to "section-title"), _uA(
                                    _cE("view", _uM("class" to "title-bar")),
                                    _cE("text", _uM("class" to "title-text"), _uA(
                                        "车辆信息 ",
                                        if (carTabs.value.length > 0) {
                                            _cV(_component_x_text, _uM("key" to 0, "class" to "title-text"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "(" + _tD(carTabs.value.length) + ")个"
                                                )
                                            }), "_" to 1))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    ))
                                )),
                                _cE("view", _uM("class" to "info-form"), _uA(
                                    _cV(_component_x_tabs, _uM("item-width" to "33.3%", "list" to carTabs.value, "showLine" to false, "round" to "7", "item-active-style" to "background-color:#536FA6;border-radius: 11rpx;", "item-style" to "background-color:#ffffff", "width" to "width: 207rpx", "height" to "63rpx", "modelValue" to activeCarIndex.value, "onUpdate:modelValue" to fun(`$event`: String){
                                        activeCarIndex.value = `$event`
                                    }
                                    ), _uM("default" to withScopedSlotCtx(fun(slotProps: GenUniModulesTmxUiComponentsXTabsXTabsSlotDataDefault): UTSArray<Any> {
                                        val item = slotProps.item
                                        val active = slotProps.active
                                        return _uA(
                                            _cV(_component_x_text, _uM("color" to if (active) {
                                                "white"
                                            } else {
                                                "#536FA6"
                                            }
                                            , "style" to _nS(_uM("font-weight" to "bold"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(item.title)
                                                )
                                            }
                                            ), "_" to 2), 1032, _uA(
                                                "color",
                                                "style"
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "list",
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    )),
                                    _cE("view", _uM("style" to _nS(_uM("background-color" to "#ffffff", "border-radius" to "20rpx", "margin-top" to "20rpx", "padding" to "20rpx"))), _uA(
                                        _cE("view", _uM("class" to "section-title", "style" to _nS(_uM("margin-top" to "10rpx"))), _uA(
                                            _cE("text", _uM("style" to _nS(_uM("font-size" to "32rpx"))), _tD(currentCarInfo.value.companyName), 5)
                                        ), 4),
                                        if (isTrue(currentCarInfo.value.companyName)) {
                                            _cV(_component_x_divider, _uM("key" to 0, "lineWidth" to "1", "color" to "#D4D4D4", "style" to _nS(_uM("margin-top" to "3rpx"))), null, 8, _uA(
                                                "style"
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                        ,
                                        _cE("view", _uM("class" to "upload-container", "style" to _nS(_uM("margin-top" to "23rpx"))), _uA(
                                            _cE("view", _uM("class" to "upload-item", "style" to _nS(_uM("width" to "100%"))), _uA(
                                                _cE("view", _uM("class" to "upload-box"), _uA(
                                                    _cV(_component_x_image, _uM("class" to "uploaded-image", "src" to currentCarInfo.value.qualificationPhoto, "mode" to "widthFix"), null, 8, _uA(
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
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("home-bg" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1, "height" to "100%")), "top-bg" to _uM(".home-bg " to _uM("height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)")), "approve-info-container" to _pS(_uM("height" to "100%", "paddingTop" to "30rpx", "paddingBottom" to "330rpx")), "info-section" to _pS(_uM("borderTopLeftRadius" to "12rpx", "borderTopRightRadius" to "12rpx", "borderBottomRightRadius" to "12rpx", "borderBottomLeftRadius" to "12rpx", "marginTop" to 0, "marginRight" to "20rpx", "marginBottom" to "20rpx", "marginLeft" to "20rpx", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "20rpx", "paddingLeft" to "20rpx")), "section-title" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "marginBottom" to "20rpx")), "title-bar" to _pS(_uM("width" to "6rpx", "height" to "30rpx", "backgroundColor" to "#536FA6", "marginRight" to "10rpx")), "title-text" to _pS(_uM("fontSize" to "32rpx", "fontWeight" to "bold", "color" to "#000000")), "info-form" to _pS(_uM("width" to "100%")), "form-item" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to "30rpx", "paddingRight" to 0, "paddingBottom" to "30rpx", "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#eeeeee", "borderBottomWidth:last-child" to "medium", "borderBottomStyle:last-child" to "none", "borderBottomColor:last-child" to "#000000")), "item-label" to _pS(_uM("fontSize" to "28rpx", "color" to "#6C6C6C")), "item-value" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "fontSize" to "32rpx", "color" to "#333333")), "placeholder-text" to _uM(".item-value " to _uM("fontSize" to "28rpx", "color" to "#B2B2B2")), "icon-mail" to _pS(_uM("marginLeft" to "10rpx", "fontSize" to "28rpx")), "icon-arrow" to _pS(_uM("marginLeft" to "10rpx", "width" to 11, "height" to 6)), "upload-container" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to "20rpx")), "single-upload" to _pS(_uM("justifyContent" to "center")), "upload-item" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "width" to "48%")), "upload-box" to _pS(_uM("width" to "100%", "height" to 120, "display" to "flex", "justifyContent" to "center", "alignItems" to "center")), "upload-icon" to _pS(_uM("width" to "100%", "height" to "99%")), "uploaded-image" to _pS(_uM("width" to "100%", "height" to "100%")), "button-group" to _pS(_uM("position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to "20rpx", "paddingLeft" to "20rpx", "paddingRight" to "20rpx", "backgroundColor" to "#ffffff", "boxShadow" to "0 -2rpx 10rpx rgba(0, 0, 0, 0.05)", "zIndex" to 100)), "btn-review" to _pS(_uM("width" to "49%", "paddingTop" to 2, "paddingRight" to 0, "paddingBottom" to 2, "paddingLeft" to 0, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "fontSize" to 18, "boxShadow" to "0px 5px 10px 0px rgba(0, 0, 0, 0.2)", "backgroundColor" to "#ffffff", "color" to "#333333", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000")), "btn-save" to _pS(_uM("width" to "49%", "paddingTop" to 2, "paddingRight" to 0, "paddingBottom" to 2, "paddingLeft" to 0, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "fontSize" to 18, "boxShadow" to "0px 5px 10px 0px rgba(0, 0, 0, 0.2)", "backgroundColor" to "#000000", "color" to "#ffffff")), "car-info-section" to _pS(_uM("marginTop" to "20rpx")), "car-info-title" to _pS(_uM("fontSize" to "32rpx", "fontWeight" to "bold", "marginBottom" to "10rpx")), "car-info-content" to _pS(_uM("backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "20rpx", "paddingLeft" to "20rpx", "marginTop" to "10rpx")), "no-data-tip" to _pS(_uM("display" to "flex", "justifyContent" to "center", "alignItems" to "center", "paddingTop" to "40rpx", "paddingRight" to 0, "paddingBottom" to "40rpx", "paddingLeft" to 0, "fontSize" to "28rpx", "color" to "#999999")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
