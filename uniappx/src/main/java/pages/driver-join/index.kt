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
import io.dcloud.uniapp.extapi.chooseImage as uni_chooseImage
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import uts.sdk.modules.xToastS.showToast as showXToast
open class GenPagesDriverJoinIndex : BasePage {
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
        var setup: (__props: GenPagesDriverJoinIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDriverJoinIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val showAgreeModal = ref<Boolean>(false)
            val currentImageType = ref<ImageType>(ImageType(type = 0, type2 = ""))
            val formData = reactive<FormData>(FormData(entryMode = "1", driverType = _uA(
                "1"
            ), operationCity = "", serviceId = "", driverName = "", frontSideIdCardPhoto = "", backSideIdCardPhoto = "", idCard = "", idCardStartTime = "", idCardEndTime = "", idCardAddress = "", sex = 0, licenseFrontPic = "", licenseSecondPic = "", licenseFirstReceiveDate = "", licenseValidityStart = "", licenseValidityEnd = "", licenseAnnualInspectionDueDate = "", licenseIssuingAuthority = "", licenseNo = "", licenseCarClass = "", licenseFileNo = "", certificatePic = "", grantPlatformGroup = 3, roadPassengerTransportCertificatePic = ""))
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
            val auditRejectReason = ref<String>("")
            val checkShowCertificatePic = fun(driverType: String): Boolean {
                val status = driverTypeSelecteds.value.indexOf(driverType) > -1
                console.log("checkShowCertificatePic driverType=", driverType, ", driverTypeSelecteds = ", driverTypeSelecteds.value, ",  status = ", status)
                return status
            }
            fun gen_feedbackDetail_fn() {
                getCarDriverInfoById().then(fun(res: Response){
                    val data = res.data as UTSJSONObject
                    val driverSourceType = data.getNumber("driverSourceType")
                    formData.entryMode = if (driverSourceType != null) {
                        driverSourceType.toString(10)
                    } else {
                        "1"
                    }
                    entryModeSelecteds.value = _uA(
                        formData.entryMode
                    )
                    val driverTypeStr = data.getString("driverType") as String
                    formData.driverType = if (!isBlank(driverTypeStr)) {
                        driverTypeStr.split(",") as UTSArray<String>
                    } else {
                        _uA(
                            "1"
                        )
                    }
                    driverTypeSelecteds.value = formData.driverType
                    val serviceId = data.getString("serviceId") ?: ""
                    val serviceName = data.getString("serviceName") ?: ""
                    if (!isBlank(serviceId)) {
                        serviceProviderList.value = _uA(
                            _uO("id" to serviceId, "serviceName" to serviceName)
                        )
                        formData.serviceId = serviceId
                        serviceProviderSelecteds.value = _uA(
                            serviceId
                        )
                        serviceProviderStr.value = _uA(
                            serviceName
                        )
                    }
                    formData.frontSideIdCardPhoto = data.getString("frontSideIdCardPhoto")
                    formData.backSideIdCardPhoto = data.getString("backSideIdCardPhoto")
                    formData.idCard = data.getString("idCard")
                    formData.idCardStartTime = data.getString("idCardStartTime")
                    formData.idCardEndTime = data.getString("idCardEndTime")
                    formData.idCardAddress = data.getString("idCardAddress")
                    formData.sex = data.getNumber("sex")
                    formData.driverName = data.getString("driverName")
                    formData.licenseFrontPic = data.getString("licenseFrontPic")
                    formData.licenseSecondPic = data.getString("licenseSecondPic")
                    formData.licenseFirstReceiveDate = data.getString("licenseFirstReceiveDate")
                    formData.licenseValidityStart = data.getString("licenseValidityStart")
                    formData.licenseValidityEnd = data.getString("licenseValidityEnd")
                    formData.licenseAnnualInspectionDueDate = data.getString("licenseAnnualInspectionDueDate")
                    formData.licenseIssuingAuthority = data.getString("licenseIssuingAuthority")
                    formData.licenseNo = data.getString("licenseNo")
                    formData.licenseCarClass = data.getString("licenseCarClass")
                    formData.licenseFileNo = data.getString("licenseFileNo")
                    formData.certificatePic = data.getString("certificatePic")
                    formData.roadPassengerTransportCertificatePic = data.getString("roadPassengerTransportCertificatePic")
                    auditRejectReason.value = data.getString("auditReason") ?: ""
                }
                ).`catch`(fun(err: Any?){
                    console.log("err===", err)
                }
                )
            }
            val feedbackDetail = ::gen_feedbackDetail_fn
            fun gen_selectCity_fn() {
                getDriverLinesOpenCityList().then(fun(res: Response){
                    cityList.value = JSON.parse<UTSArray<PICKER_ITEM_INFO>>(JSON.stringify(res["data"])) as UTSArray<PICKER_ITEM_INFO>
                }
                )
            }
            val selectCity = ::gen_selectCity_fn
            fun gen_initServcieList_fn(ids: UTSArray<String>) {
                val curCitySelectedStr = citySelectedStr.value.split(",")[0]
                val curCityCode = ids[0]
                getServiceListByOpenCity(object : UTSJSONObject() {
                    var startCityCode = curCityCode
                    var startCityName = curCitySelectedStr
                }).then(fun(res: Response){
                    serviceProviderList.value = res["data"] as UTSArray<UTSJSONObject>
                }
                )
            }
            val initServcieList = ::gen_initServcieList_fn
            val checkDate = fun(dateStr: String?): Boolean {
                if (dateStr == null) {
                    return false
                }
                val pattern = UTSRegExp("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])\$", "")
                return pattern.test(dateStr)
            }
            fun gen_handleUploadFileInfo_fn(type: String, path: String, recognizeRes: UTSJSONObject) {
                when (type) {
                    "frontSideIdCardPhoto" -> 
                        {
                            if (!isBlank(path)) {
                                formData.frontSideIdCardPhoto = path
                            }
                            if (!objOfNull(recognizeRes)) {
                                formData.idCard = recognizeRes.getString("idNumber")
                                formData.idCardAddress = recognizeRes.getString("address")
                                formData.driverName = recognizeRes.getString("name")
                                formData.sex = if (recognizeRes.getString("sex") != null) {
                                    if (recognizeRes.getString("sex") == "男") {
                                        1
                                    } else {
                                        2
                                    }
                                } else {
                                    0
                                }
                            }
                        }
                    "backSideIdCardPhoto" -> 
                        {
                            if (!isBlank(path)) {
                                formData.backSideIdCardPhoto = path
                            }
                            if (!objOfNull(recognizeRes)) {
                                val validPeriod = recognizeRes.getString("validPeriod")
                                val validPeriodArr = if (validPeriod != null) {
                                    validPeriod.split("-")
                                } else {
                                    _uA()
                                }
                                if (validPeriodArr.length > 0) {
                                    formData.idCardStartTime = validPeriodArr[0].replace(".", "-").replace(".", "-")
                                    formData.idCardStartTime = if (checkDate(formData.idCardStartTime)) {
                                        formData.idCardStartTime
                                    } else {
                                        null
                                    }
                                    formData.idCardEndTime = validPeriodArr[1].replace(".", "-").replace(".", "-")
                                    formData.idCardEndTime = if (checkDate(formData.idCardEndTime)) {
                                        formData.idCardEndTime
                                    } else {
                                        null
                                    }
                                }
                            }
                        }
                    "licenseFrontPic" -> 
                        {
                            if (!isBlank(path)) {
                                formData.licenseFrontPic = path
                            }
                            if (!objOfNull(recognizeRes)) {
                                formData.licenseFirstReceiveDate = recognizeRes.getString("initialIssueDate")
                                formData.licenseValidityStart = recognizeRes.getString("validFromDate")
                                formData.licenseValidityStart = if (checkDate(formData.licenseValidityStart)) {
                                    formData.licenseValidityStart
                                } else {
                                    null
                                }
                                formData.licenseIssuingAuthority = recognizeRes.getString("issueAuthority")
                                formData.licenseNo = recognizeRes.getString("licenseNumber")
                                formData.licenseCarClass = recognizeRes.getString("approvedType")
                            }
                        }
                    "licenseSecondPic" -> 
                        {
                            if (!isBlank(path)) {
                                formData.licenseSecondPic = path
                            }
                            if (!objOfNull(recognizeRes)) {
                                formData.licenseFileNo = recognizeRes.getString("recordNumber")
                            }
                        }
                    "certificatePic" -> 
                        formData.certificatePic = path
                    "roadPassengerTransportCertificatePic" -> 
                        formData.roadPassengerTransportCertificatePic = path
                    else -> 
                        {}
                }
            }
            val handleUploadFileInfo = ::gen_handleUploadFileInfo_fn
            fun gen_uploadImage_fn(type: Number, type2: String) {
                currentImageType.value = ImageType(type = type, type2 = type2)
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
                    uploadFileSync(OrcData(platformName = "car", type = type, file = tempFilePath)).then(fun(res: Response){
                        console.log("上传结果", res)
                        handleUploadFileInfo(type2, res.data as String, UTSJSONObject())
                    }
                    )
                    if (type2 !== "certificatePic") {
                        aliOcrSync(OrcData(type = type, platformName = "car", file = tempFilePath)).then(fun(res: Response){
                            console.log("ocr结果", res)
                            handleUploadFileInfo(type2, "", res.data as UTSJSONObject)
                        }
                        )
                    }
                }
                , fail = fun(err: ChooseImageFail) {
                    if (err.errMsg == "No Permission") {
                        removePhotoAgreeStatus()
                    }
                }
                ))
            }
            val uploadImage = ::gen_uploadImage_fn
            val assembleReqData = fun(submitData: UTSJSONObject){
                if (entryModeSelecteds.value.length > 0) {
                    submitData.set("driverSourceType", entryModeSelecteds.value[0])
                }
                if (serviceProviderSelecteds.value.length > 0) {
                    submitData.set("serviceId", serviceProviderSelecteds.value[0])
                }
                submitData.set("driverType", driverTypeSelecteds.value.join(","))
            }
            fun gen_submitForReview_fn() {
                if (serviceProviderSelecteds.value.length <= 0) {
                    showToast("请选择所属服务商", "warning")
                    return
                }
                if (formData.frontSideIdCardPhoto == "" || formData.backSideIdCardPhoto == "") {
                    showToast("请上传身份证正反面照片", "warning")
                    return
                }
                if (formData.licenseFrontPic == "" || formData.licenseSecondPic == "") {
                    showToast("请上传驾驶证主页和副页照片", "warning")
                    return
                }
                showLoading(XLOADINGS_TYPE(title = "提交中..."))
                val submitData = UTSJSONObject.assign<UTSJSONObject>(UTSJSONObject(), formData) as UTSJSONObject
                assembleReqData(submitData)
                console.log("提交审核", formData)
                saveOrUpdateDriverInfo(submitData).then(fun(res: Response){
                    showToast("提交成功", "success")
                    setTimeout(fun(){
                        uni_navigateBack(null)
                    }
                    , 1500)
                }
                ).`catch`(fun(){
                    showToast("提交失败", "error")
                }
                ).`finally`(fun(){
                    hideXloading()
                }
                )
            }
            val submitForReview = ::gen_submitForReview_fn
            fun gen_saveInformation_fn() {
                val submitData = UTSJSONObject.assign<UTSJSONObject>(UTSJSONObject(), formData) as UTSJSONObject
                assembleReqData(submitData)
                console.log("信息暂存", submitData)
                showLoading(XLOADINGS_TYPE(title = "保存中..."))
                saveDriverInfo(submitData).then(fun(res: Response){
                    showToast("保存成功", "success")
                }
                ).`catch`(fun(){
                    showToast("保存失败", "error")
                }
                ).`finally`(fun(){
                    hideXloading()
                }
                )
            }
            val saveInformation = ::gen_saveInformation_fn
            val agreeCancel = fun(){
                showXToast(XTOAST_TYPE(title = "您已拒绝相机使用/媒体访问权限申请，将无法拍摄/选取照片进行上传", iconCode = "info", iconColor = "#ff8900", duration = 3000))
            }
            val agreeConfirm = fun(){
                setPhotoAgreeStatus()
                uploadImage(currentImageType.value.type, currentImageType.value.type2)
            }
            onReady(fun(){
                selectCity()
                feedbackDetail()
            }
            )
            return fun(): Any? {
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_x_picker = resolveEasyComponent("x-picker", GenUniModulesTmxUiComponentsXPickerXPickerClass)
                val _component_x_picker_selected = resolveEasyComponent("x-picker-selected", GenUniModulesTmxUiComponentsXPickerSelectedXPickerSelectedClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_mc_base_container, _uM("title" to "入驻信息"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "approve-info-container"), _uA(
                                _cE("view", _uM("class" to "info-section"), _uA(
                                    _cE("view", _uM("class" to "section-title"), _uA(
                                        _cE("view", _uM("class" to "title-bar")),
                                        _cE("text", _uM("class" to "title-text"), _uA(
                                            " 基础信息 ",
                                            if (isTrue(auditRejectReason.value != null && auditRejectReason.value != "")) {
                                                _cV(_component_x_text, _uM("key" to 0, "color" to "red"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        "（审核失败）"
                                                    )
                                                }), "_" to 1))
                                            } else {
                                                _cC("v-if", true)
                                            }
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "info-form"), _uA(
                                        _cV(_component_x_picker, _uM("modelValue" to entryModeSelecteds.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                            entryModeSelecteds.value = `$event`
                                        }
                                        , "model-str" to entryModeStr.value, "onUpdate:modelStr" to fun(`$event`: String){
                                            entryModeStr.value = `$event`
                                        }
                                        , "list" to entryModeList.value), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "form-item"), _uA(
                                                    _cE("text", _uM("class" to "item-label"), "入驻形式"),
                                                    _cE("view", _uM("class" to "item-value"), _uA(
                                                        _cE("text", _uM("class" to _nC(_uM("placeholder-text" to (entryModeSelecteds.value.length == 0)))), _tD(if ((entryModeSelecteds.value.length > 0)) {
                                                            entryModeStr.value
                                                        } else {
                                                            "请选择"
                                                        }
                                                        ), 3),
                                                        _cE("image", _uM("class" to "icon-arrow", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-line-samll.png"), "mode" to "widthFix"), null, 8, _uA(
                                                            "src"
                                                        ))
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
                                        , "model-str" to driverTypeStr.value, "onUpdate:modelStr" to fun(`$event`: UTSArray<String>){
                                            driverTypeStr.value = `$event`
                                        }
                                        , "list" to driverTypeList.value, "showSearch" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "form-item"), _uA(
                                                    _cE("text", _uM("class" to "item-label"), "业务范围"),
                                                    _cE("view", _uM("class" to "item-value"), _uA(
                                                        _cE("text", _uM("class" to _nC(_uM("placeholder-text" to (driverTypeSelecteds.value.length == 0)))), _tD(if (driverTypeSelecteds.value.length > 0) {
                                                            driverTypeStr.value.join("、")
                                                        } else {
                                                            "请选择"
                                                        }
                                                        ), 3),
                                                        _cE("image", _uM("class" to "icon-arrow", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-line-samll.png"), "mode" to "widthFix"), null, 8, _uA(
                                                            "src"
                                                        ))
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
                                        _cV(_component_x_picker, _uM("modelValue" to citySelecteds.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                            citySelecteds.value = `$event`
                                        }
                                        , "list" to unref(cityList), "onConfirm" to initServcieList, "model-str" to citySelectedStr.value, "onUpdate:modelStr" to fun(`$event`: String){
                                            citySelectedStr.value = `$event`
                                        }
                                        ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "form-item"), _uA(
                                                    _cE("text", _uM("class" to "item-label"), "运营城市"),
                                                    _cE("view", _uM("class" to "item-value"), _uA(
                                                        _cE("text", _uM("class" to _nC(_uM("placeholder-text" to (citySelecteds.value.length == 0)))), _tD(if ((citySelecteds.value.length > 0)) {
                                                            citySelectedStr.value
                                                        } else {
                                                            "请选择"
                                                        }
                                                        ), 3),
                                                        _cE("image", _uM("class" to "icon-arrow", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-line-samll.png"), "mode" to "widthFix"), null, 8, _uA(
                                                            "src"
                                                        ))
                                                    ))
                                                ))
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "modelValue",
                                            "onUpdate:modelValue",
                                            "list",
                                            "model-str",
                                            "onUpdate:modelStr"
                                        )),
                                        _cV(_component_x_picker_selected, _uM("label-key" to "serviceName", "modelValue" to serviceProviderSelecteds.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                            serviceProviderSelecteds.value = `$event`
                                        }
                                        , "model-str" to serviceProviderStr.value, "onUpdate:modelStr" to fun(`$event`: UTSArray<String>){
                                            serviceProviderStr.value = `$event`
                                        }
                                        , "list" to unref(serviceProviderList), "multiple" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "form-item"), _uA(
                                                    _cE("text", _uM("class" to "item-label"), "所属服务商"),
                                                    _cE("view", _uM("class" to "item-value"), _uA(
                                                        _cE("text", _uM("class" to _nC(_uM("placeholder-text" to (serviceProviderSelecteds.value.length == 0)))), _tD(if ((serviceProviderSelecteds.value.length > 0)) {
                                                            serviceProviderStr.value.join("、")
                                                        } else {
                                                            "请选择"
                                                        }
                                                        ), 3),
                                                        _cE("image", _uM("class" to "icon-arrow", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-line-samll.png"), "mode" to "widthFix"), null, 8, _uA(
                                                            "src"
                                                        ))
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
                                    ))
                                )),
                                _cE("view", _uM("class" to "info-section"), _uA(
                                    _cE("view", _uM("class" to "section-title"), _uA(
                                        _cE("view", _uM("class" to "title-bar")),
                                        _cE("text", _uM("class" to "title-text"), "身份证信息")
                                    )),
                                    _cE("view", _uM("class" to "upload-container"), _uA(
                                        _cE("view", _uM("class" to "upload-item"), _uA(
                                            _cE("view", _uM("class" to "upload-box", "onClick" to fun(){
                                                uploadImage(1, "frontSideIdCardPhoto")
                                            }
                                            ), _uA(
                                                if (isTrue(unref(formData).frontSideIdCardPhoto)) {
                                                    _cE("image", _uM("key" to 0, "class" to "uploaded-image", "src" to unref(formData).frontSideIdCardPhoto, "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    ))
                                                } else {
                                                    _cE("image", _uM("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/id-card-front.png"), "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    ))
                                                }
                                            ), 8, _uA(
                                                "onClick"
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "upload-item"), _uA(
                                            _cE("view", _uM("class" to "upload-box", "onClick" to fun(){
                                                uploadImage(1, "backSideIdCardPhoto")
                                            }
                                            ), _uA(
                                                if (isTrue(unref(formData).backSideIdCardPhoto)) {
                                                    _cE("image", _uM("key" to 0, "class" to "uploaded-image", "src" to unref(formData).backSideIdCardPhoto, "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    ))
                                                } else {
                                                    _cE("image", _uM("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/id-card-back.png"), "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    ))
                                                }
                                            ), 8, _uA(
                                                "onClick"
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
                                            _cE("view", _uM("class" to "upload-box", "onClick" to fun(){
                                                uploadImage(7, "licenseFrontPic")
                                            }
                                            ), _uA(
                                                if (isTrue(unref(formData).licenseFrontPic)) {
                                                    _cE("image", _uM("key" to 0, "class" to "uploaded-image", "src" to unref(formData).licenseFrontPic, "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    ))
                                                } else {
                                                    _cE("image", _uM("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/driver-license-front.png"), "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    ))
                                                }
                                            ), 8, _uA(
                                                "onClick"
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "upload-item"), _uA(
                                            _cE("view", _uM("class" to "upload-box", "onClick" to fun(){
                                                uploadImage(7, "licenseSecondPic")
                                            }
                                            ), _uA(
                                                if (isTrue(unref(formData).licenseSecondPic)) {
                                                    _cE("image", _uM("key" to 0, "class" to "uploaded-image", "src" to unref(formData).licenseSecondPic, "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    ))
                                                } else {
                                                    _cE("image", _uM("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/driver-license-back.png"), "mode" to "widthFix"), null, 8, _uA(
                                                        "src"
                                                    ))
                                                }
                                            ), 8, _uA(
                                                "onClick"
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
                                                _cE("view", _uM("class" to "upload-box", "onClick" to fun(){
                                                    uploadImage(-1, "certificatePic")
                                                }), _uA(
                                                    if (isTrue(unref(formData).certificatePic)) {
                                                        _cE("image", _uM("key" to 0, "class" to "uploaded-image", "src" to unref(formData).certificatePic, "mode" to "widthFix"), null, 8, _uA(
                                                            "src"
                                                        ))
                                                    } else {
                                                        _cE("image", _uM("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/qualification-front.png"), "mode" to "widthFix"), null, 8, _uA(
                                                            "src"
                                                        ))
                                                    }
                                                ), 8, _uA(
                                                    "onClick"
                                                ))
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                        ,
                                        if (isTrue(checkShowCertificatePic("1"))) {
                                            _cE("view", _uM("key" to 1, "class" to "upload-item"), _uA(
                                                _cE("view", _uM("class" to "upload-box", "onClick" to fun(){
                                                    uploadImage(-1, "roadPassengerTransportCertificatePic")
                                                }), _uA(
                                                    if (isTrue(unref(formData).roadPassengerTransportCertificatePic)) {
                                                        _cE("image", _uM("key" to 0, "class" to "uploaded-image", "src" to unref(formData).roadPassengerTransportCertificatePic, "mode" to "widthFix"), null, 8, _uA(
                                                            "src"
                                                        ))
                                                    } else {
                                                        _cE("image", _uM("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/qualification-front-2.png"), "mode" to "widthFix"), null, 8, _uA(
                                                            "src"
                                                        ))
                                                    }
                                                ), 8, _uA(
                                                    "onClick"
                                                ))
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    ))
                                )),
                                if (isTrue(auditRejectReason.value != null && auditRejectReason.value != "")) {
                                    _cE("view", _uM("key" to 0, "class" to "info-section"), _uA(
                                        _cE("view", _uM("class" to "section-title"), _uA(
                                            _cE("view", _uM("class" to "title-bar")),
                                            _cV(_component_x_text, _uM("class" to "title-text", "color" to "red"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "审核不通过原因"
                                                )
                                            }), "_" to 1))
                                        )),
                                        _cE("view", _uM("class" to "info-form"), _uA(
                                            _cV(_component_x_text, _uM("lines" to 3, "color" to "#6C6C6C"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(auditRejectReason.value)
                                                )
                                            }), "_" to 1))
                                        ))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            )),
                            _cE("view", _uM("class" to "button-group", "style" to _nS("padding-bottom: " + (unref(globalData).safeAreaBottom + 15) + "px")), _uA(
                                _cE("button", _uM("class" to "btn-review", "onClick" to submitForReview), "审核提交"),
                                _cE("button", _uM("class" to "btn-save", "onClick" to saveInformation), "信息暂存")
                            ), 4)
                        )
                    }
                    ), "_" to 1)),
                    _cV(_component_x_modal, _uM("show" to showAgreeModal.value, "onUpdate:show" to fun(`$event`: Boolean){
                        showAgreeModal.value = `$event`
                    }
                    , "bgColor" to "#ECF1F8", "cancel-text" to "拒绝", "overlay-click" to false, "onCancel" to agreeCancel, "confirm-text" to "同意", "onConfirm" to agreeConfirm, "show-title" to false, "height" to "850rpx"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("text", _uM("class" to "photo-agree-title"), "相机使用/媒体访问权限申请"),
                            _cE("view", _uM("class" to "desc"), _uA(
                                _cE("text", _uM("class" to "pb-10"), "我们获取您手机的相机使用/媒体访问权限是用于以下功能："),
                                _cE("text", _uM("class" to "pb-10"), "1、拍摄/选取身份证正反面照片：用于实名认证以及驾驶员身份识别"),
                                _cE("text", _uM("class" to "pb-10"), "2、拍摄/选取驾驶证主/副页照片：用于驾驶员驾驶资格的审核。"),
                                _cE("text", _uM("class" to "pb-10"), "3、拍摄/选取驾驶员网约/客运从业资质照片：用于驾驶员从业资质的审核。"),
                                _cE("text", _uM("class" to "pb-10"), "相机使用/媒体访问权限是在相机拍摄或相册选取照片时各自申请。"),
                                _cE("text", null, "如果您拒绝我们获取您的上述所有信息，将导致您无法提交审核信息。"),
                                _cE("text", _uM("style" to _nS(_uM("color" to "red"))), "本APP提供了撤回系统权限的功能，具体路径:个人中心(登录后点击右上角)-设置-账户与安全-权限管理。", 4)
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show",
                        "onUpdate:show"
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
                return _uM("approve-info-container" to _pS(_uM("backgroundColor" to "#f5f5f5", "height" to "100%", "paddingTop" to "30rpx", "paddingBottom" to "400rpx")), "info-section" to _pS(_uM("backgroundColor" to "#ffffff", "borderTopLeftRadius" to "12rpx", "borderTopRightRadius" to "12rpx", "borderBottomRightRadius" to "12rpx", "borderBottomLeftRadius" to "12rpx", "marginTop" to 0, "marginRight" to "20rpx", "marginBottom" to "20rpx", "marginLeft" to "20rpx", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "20rpx", "paddingLeft" to "20rpx")), "section-title" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "marginBottom" to "20rpx")), "title-bar" to _pS(_uM("width" to "6rpx", "height" to "30rpx", "backgroundColor" to "#000000", "marginRight" to "10rpx")), "title-text" to _pS(_uM("fontSize" to "32rpx", "fontWeight" to "bold", "color" to "#000000")), "info-form" to _pS(_uM("width" to "100%")), "form-item" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to "30rpx", "paddingRight" to 0, "paddingBottom" to "30rpx", "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#eeeeee", "borderBottomWidth:last-child" to "medium", "borderBottomStyle:last-child" to "none", "borderBottomColor:last-child" to "#000000")), "item-label" to _pS(_uM("fontSize" to "28rpx", "color" to "#6C6C6C")), "item-value" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "fontSize" to 16, "color" to "#000000")), "placeholder-text" to _uM(".item-value " to _uM("fontSize" to "28rpx", "color" to "#B2B2B2")), "icon-mail" to _pS(_uM("marginLeft" to "10rpx", "fontSize" to "28rpx")), "icon-arrow" to _pS(_uM("marginLeft" to "10rpx", "width" to 11, "height" to 6)), "upload-container" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to "20rpx")), "single-upload" to _pS(_uM("justifyContent" to "center")), "upload-item" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "width" to "48%")), "upload-box" to _pS(_uM("width" to "100%", "height" to 120, "display" to "flex", "justifyContent" to "center", "alignItems" to "center")), "upload-icon" to _pS(_uM("width" to "100%", "height" to "99%")), "uploaded-image" to _pS(_uM("width" to "100%", "height" to "100%")), "button-group" to _pS(_uM("position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to "20rpx", "paddingLeft" to "20rpx", "paddingRight" to "20rpx", "backgroundColor" to "#ffffff", "zIndex" to 100)), "btn-review" to _pS(_uM("width" to "49%", "paddingTop" to 2, "paddingRight" to 0, "paddingBottom" to 2, "paddingLeft" to 0, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "fontSize" to 18, "boxShadow" to "0px 5px 10px 0px rgba(0, 0, 0, 0.2)", "backgroundColor" to "#ffffff", "color" to "#333333", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000")), "btn-save" to _pS(_uM("width" to "49%", "paddingTop" to 2, "paddingRight" to 0, "paddingBottom" to 2, "paddingLeft" to 0, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "fontSize" to 18, "boxShadow" to "0px 5px 10px 0px rgba(0, 0, 0, 0.2)", "backgroundColor" to "#000000", "color" to "#ffffff")), "photo-agree-title" to _pS(_uM("textAlign" to "center", "width" to "100%", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
