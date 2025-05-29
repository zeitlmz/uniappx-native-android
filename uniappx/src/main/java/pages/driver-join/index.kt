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
            val formData = reactive<FormData>(FormData(entryMode = "1", driverType = utsArrayOf(
                "1"
            ), operationCity = "", serviceId = "", driverName = "", frontSideIdCardPhoto = "", backSideIdCardPhoto = "", idCard = "", idCardStartTime = "", idCardEndTime = "", idCardAddress = "", sex = 0, licenseFrontPic = "", licenseSecondPic = "", licenseFirstReceiveDate = "", licenseValidityStart = "", licenseValidityEnd = "", licenseAnnualInspectionDueDate = "", licenseIssuingAuthority = "", licenseNo = "", licenseCarClass = "", licenseFileNo = "", certificatePic = "", grantPlatformGroup = 3, roadPassengerTransportCertificatePic = ""))
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
                    entryModeSelecteds.value = utsArrayOf(
                        formData.entryMode
                    )
                    val driverTypeStr = data.getString("driverType") as String
                    formData.driverType = if (!isBlank(driverTypeStr)) {
                        driverTypeStr.split(",") as UTSArray<String>
                    } else {
                        utsArrayOf(
                            "1"
                        )
                    }
                    driverTypeSelecteds.value = formData.driverType
                    val serviceId = data.getString("serviceId") ?: ""
                    val serviceName = data.getString("serviceName") ?: ""
                    if (!isBlank(serviceId)) {
                        serviceProviderList.value = utsArrayOf(
                            UTSJSONObject(Map<String, Any?>(utsArrayOf(
                                utsArrayOf(
                                    "id",
                                    serviceId
                                ),
                                utsArrayOf(
                                    "serviceName",
                                    serviceName
                                )
                            )))
                        )
                        formData.serviceId = serviceId
                        serviceProviderSelecteds.value = utsArrayOf(
                            serviceId
                        )
                        serviceProviderStr.value = utsArrayOf(
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
                                    utsArrayOf()
                                }
                                if (validPeriodArr.length > 0) {
                                    formData.idCardStartTime = validPeriodArr[0].replace(".", "-").replace(".", "-")
                                    formData.idCardEndTime = validPeriodArr[1].replace(".", "-").replace(".", "-")
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
                uni_chooseImage(ChooseImageOptions(count = 1, sourceType = utsArrayOf(
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
                showXToast(XTOAST_TYPE(title = "您已拒绝相册读取权限，将无法选取照片进行上传", iconCode = "info", iconColor = "#ff8900", duration = 2500))
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
                return createElementVNode(Fragment, null, utsArrayOf(
                    createVNode(_component_mc_base_container, utsMapOf("title" to "入驻信息"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "approve-info-container"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "info-section"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "section-title"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "title-bar")),
                                        createElementVNode("text", utsMapOf("class" to "title-text"), utsArrayOf(
                                            " 基础信息 ",
                                            if (isTrue(auditRejectReason.value != null && auditRejectReason.value != "")) {
                                                createVNode(_component_x_text, utsMapOf("key" to 0, "color" to "red"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        "（审核失败）"
                                                    )
                                                }), "_" to 1))
                                            } else {
                                                createCommentVNode("v-if", true)
                                            }
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "info-form"), utsArrayOf(
                                        createVNode(_component_x_picker, utsMapOf("modelValue" to entryModeSelecteds.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                            entryModeSelecteds.value = `$event`
                                        }
                                        , "model-str" to entryModeStr.value, "onUpdate:modelStr" to fun(`$event`: String){
                                            entryModeStr.value = `$event`
                                        }
                                        , "list" to entryModeList.value), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "form-item"), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "item-label"), "入驻形式"),
                                                    createElementVNode("view", utsMapOf("class" to "item-value"), utsArrayOf(
                                                        createElementVNode("text", utsMapOf("class" to normalizeClass(utsMapOf("placeholder-text" to (entryModeSelecteds.value.length == 0)))), toDisplayString(if ((entryModeSelecteds.value.length > 0)) {
                                                            entryModeStr.value
                                                        } else {
                                                            "请选择"
                                                        }
                                                        ), 3),
                                                        createElementVNode("image", utsMapOf("class" to "icon-arrow", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-line-samll.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
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
                                        , "model-str" to driverTypeStr.value, "onUpdate:modelStr" to fun(`$event`: UTSArray<String>){
                                            driverTypeStr.value = `$event`
                                        }
                                        , "list" to driverTypeList.value, "showSearch" to false), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "form-item"), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "item-label"), "业务范围"),
                                                    createElementVNode("view", utsMapOf("class" to "item-value"), utsArrayOf(
                                                        createElementVNode("text", utsMapOf("class" to normalizeClass(utsMapOf("placeholder-text" to (driverTypeSelecteds.value.length == 0)))), toDisplayString(if (driverTypeSelecteds.value.length > 0) {
                                                            driverTypeStr.value.join("、")
                                                        } else {
                                                            "请选择"
                                                        }
                                                        ), 3),
                                                        createElementVNode("image", utsMapOf("class" to "icon-arrow", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-line-samll.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
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
                                        createVNode(_component_x_picker, utsMapOf("modelValue" to citySelecteds.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                            citySelecteds.value = `$event`
                                        }
                                        , "list" to unref(cityList), "onConfirm" to initServcieList, "model-str" to citySelectedStr.value, "onUpdate:modelStr" to fun(`$event`: String){
                                            citySelectedStr.value = `$event`
                                        }
                                        ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "form-item"), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "item-label"), "运营城市"),
                                                    createElementVNode("view", utsMapOf("class" to "item-value"), utsArrayOf(
                                                        createElementVNode("text", utsMapOf("class" to normalizeClass(utsMapOf("placeholder-text" to (citySelecteds.value.length == 0)))), toDisplayString(if ((citySelecteds.value.length > 0)) {
                                                            citySelectedStr.value
                                                        } else {
                                                            "请选择"
                                                        }
                                                        ), 3),
                                                        createElementVNode("image", utsMapOf("class" to "icon-arrow", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-line-samll.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
                                                    ))
                                                ))
                                            )
                                        }
                                        ), "_" to 1), 8, utsArrayOf(
                                            "modelValue",
                                            "onUpdate:modelValue",
                                            "list",
                                            "model-str",
                                            "onUpdate:modelStr"
                                        )),
                                        createVNode(_component_x_picker_selected, utsMapOf("label-key" to "serviceName", "modelValue" to serviceProviderSelecteds.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                            serviceProviderSelecteds.value = `$event`
                                        }
                                        , "model-str" to serviceProviderStr.value, "onUpdate:modelStr" to fun(`$event`: UTSArray<String>){
                                            serviceProviderStr.value = `$event`
                                        }
                                        , "list" to unref(serviceProviderList), "multiple" to false), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "form-item"), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "item-label"), "所属服务商"),
                                                    createElementVNode("view", utsMapOf("class" to "item-value"), utsArrayOf(
                                                        createElementVNode("text", utsMapOf("class" to normalizeClass(utsMapOf("placeholder-text" to (serviceProviderSelecteds.value.length == 0)))), toDisplayString(if ((serviceProviderSelecteds.value.length > 0)) {
                                                            serviceProviderStr.value.join("、")
                                                        } else {
                                                            "请选择"
                                                        }
                                                        ), 3),
                                                        createElementVNode("image", utsMapOf("class" to "icon-arrow", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-line-samll.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
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
                                    ))
                                )),
                                createElementVNode("view", utsMapOf("class" to "info-section"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "section-title"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "title-bar")),
                                        createElementVNode("text", utsMapOf("class" to "title-text"), "身份证信息")
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "upload-container"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "upload-item"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "upload-box", "onClick" to fun(){
                                                uploadImage(1, "frontSideIdCardPhoto")
                                            }
                                            ), utsArrayOf(
                                                if (isTrue(unref(formData).frontSideIdCardPhoto)) {
                                                    createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to unref(formData).frontSideIdCardPhoto, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                } else {
                                                    createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/id-card-front.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                }
                                            ), 8, utsArrayOf(
                                                "onClick"
                                            ))
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "upload-item"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "upload-box", "onClick" to fun(){
                                                uploadImage(1, "backSideIdCardPhoto")
                                            }
                                            ), utsArrayOf(
                                                if (isTrue(unref(formData).backSideIdCardPhoto)) {
                                                    createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to unref(formData).backSideIdCardPhoto, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                } else {
                                                    createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/id-card-back.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                }
                                            ), 8, utsArrayOf(
                                                "onClick"
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
                                            createElementVNode("view", utsMapOf("class" to "upload-box", "onClick" to fun(){
                                                uploadImage(7, "licenseFrontPic")
                                            }
                                            ), utsArrayOf(
                                                if (isTrue(unref(formData).licenseFrontPic)) {
                                                    createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to unref(formData).licenseFrontPic, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                } else {
                                                    createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/driver-license-front.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                }
                                            ), 8, utsArrayOf(
                                                "onClick"
                                            ))
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "upload-item"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "upload-box", "onClick" to fun(){
                                                uploadImage(7, "licenseSecondPic")
                                            }
                                            ), utsArrayOf(
                                                if (isTrue(unref(formData).licenseSecondPic)) {
                                                    createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to unref(formData).licenseSecondPic, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                } else {
                                                    createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/driver-license-back.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                }
                                            ), 8, utsArrayOf(
                                                "onClick"
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
                                                createElementVNode("view", utsMapOf("class" to "upload-box", "onClick" to fun(){
                                                    uploadImage(-1, "certificatePic")
                                                }), utsArrayOf(
                                                    if (isTrue(unref(formData).certificatePic)) {
                                                        createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to unref(formData).certificatePic, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
                                                    } else {
                                                        createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/qualification-front.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
                                                    }
                                                ), 8, utsArrayOf(
                                                    "onClick"
                                                ))
                                            ))
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                        ,
                                        if (isTrue(checkShowCertificatePic("1"))) {
                                            createElementVNode("view", utsMapOf("key" to 1, "class" to "upload-item"), utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "upload-box", "onClick" to fun(){
                                                    uploadImage(-1, "roadPassengerTransportCertificatePic")
                                                }), utsArrayOf(
                                                    if (isTrue(unref(formData).roadPassengerTransportCertificatePic)) {
                                                        createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to unref(formData).roadPassengerTransportCertificatePic, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
                                                    } else {
                                                        createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/qualification-front-2.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
                                                    }
                                                ), 8, utsArrayOf(
                                                    "onClick"
                                                ))
                                            ))
                                        } else {
                                            createCommentVNode("v-if", true)
                                        }
                                    ))
                                )),
                                if (isTrue(auditRejectReason.value != null && auditRejectReason.value != "")) {
                                    createElementVNode("view", utsMapOf("key" to 0, "class" to "info-section"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "section-title"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "title-bar")),
                                            createVNode(_component_x_text, utsMapOf("class" to "title-text", "color" to "red"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    "审核不通过原因"
                                                )
                                            }), "_" to 1))
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "info-form"), utsArrayOf(
                                            createVNode(_component_x_text, utsMapOf("lines" to 3, "color" to "#6C6C6C"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    toDisplayString(auditRejectReason.value)
                                                )
                                            }), "_" to 1))
                                        ))
                                    ))
                                } else {
                                    createCommentVNode("v-if", true)
                                }
                            )),
                            createElementVNode("view", utsMapOf("class" to "button-group", "style" to normalizeStyle("padding-bottom: " + (unref(globalData).safeAreaBottom + 15) + "px")), utsArrayOf(
                                createElementVNode("button", utsMapOf("class" to "btn-review", "onClick" to submitForReview), "审核提交"),
                                createElementVNode("button", utsMapOf("class" to "btn-save", "onClick" to saveInformation), "信息暂存")
                            ), 4)
                        )
                    }
                    ), "_" to 1)),
                    createVNode(_component_x_modal, utsMapOf("show" to showAgreeModal.value, "onUpdate:show" to fun(`$event`: Boolean){
                        showAgreeModal.value = `$event`
                    }
                    , "bgColor" to "#ECF1F8", "cancel-text" to "拒绝", "overlay-click" to false, "onCancel" to agreeCancel, "confirm-text" to "同意", "onConfirm" to agreeConfirm, "show-title" to false, "height" to "750rpx"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "photo-agree-title"), "相册读取权限申请"),
                            createElementVNode("view", utsMapOf("class" to "desc"), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "pb-10"), "我们获取您手机的相册读取权限是用于以下功能："),
                                createElementVNode("text", utsMapOf("class" to "pb-10"), "1、选取身份证正反面：用于实名认证以及驾驶员身份识别"),
                                createElementVNode("text", utsMapOf("class" to "pb-10"), "2、选取驾驶证主/副页：用于驾驶员驾驶资格的审核。"),
                                createElementVNode("text", utsMapOf("class" to "pb-10"), "3、选取驾驶员网约/客运从业资质：用于驾驶员从业资质的审核。"),
                                createElementVNode("text", null, "如果您拒绝我们获取您的上述信息，将导致您无法提交审核信息。")
                            ))
                        )
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "show",
                        "onUpdate:show"
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
                return utsMapOf("approve-info-container" to padStyleMapOf(utsMapOf("backgroundColor" to "#f5f5f5", "height" to "100%", "paddingTop" to "30rpx", "paddingBottom" to "400rpx")), "info-section" to padStyleMapOf(utsMapOf("backgroundColor" to "#ffffff", "borderTopLeftRadius" to "12rpx", "borderTopRightRadius" to "12rpx", "borderBottomRightRadius" to "12rpx", "borderBottomLeftRadius" to "12rpx", "marginTop" to 0, "marginRight" to "20rpx", "marginBottom" to "20rpx", "marginLeft" to "20rpx", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "20rpx", "paddingLeft" to "20rpx")), "section-title" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "marginBottom" to "20rpx")), "title-bar" to padStyleMapOf(utsMapOf("width" to "6rpx", "height" to "30rpx", "backgroundColor" to "#000000", "marginRight" to "10rpx")), "title-text" to padStyleMapOf(utsMapOf("fontSize" to "32rpx", "fontWeight" to "bold", "color" to "#000000")), "info-form" to padStyleMapOf(utsMapOf("width" to "100%")), "form-item" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to "30rpx", "paddingRight" to 0, "paddingBottom" to "30rpx", "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#eeeeee", "borderBottomWidth:last-child" to "medium", "borderBottomStyle:last-child" to "none", "borderBottomColor:last-child" to "#000000")), "item-label" to padStyleMapOf(utsMapOf("fontSize" to "28rpx", "color" to "#6C6C6C")), "item-value" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "fontSize" to 16, "color" to "#000000")), "placeholder-text" to utsMapOf(".item-value " to utsMapOf("fontSize" to "28rpx", "color" to "#B2B2B2")), "icon-mail" to padStyleMapOf(utsMapOf("marginLeft" to "10rpx", "fontSize" to "28rpx")), "icon-arrow" to padStyleMapOf(utsMapOf("marginLeft" to "10rpx", "width" to 11, "height" to 6)), "upload-container" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to "20rpx")), "single-upload" to padStyleMapOf(utsMapOf("justifyContent" to "center")), "upload-item" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "width" to "48%")), "upload-box" to padStyleMapOf(utsMapOf("width" to "100%", "height" to 120, "display" to "flex", "justifyContent" to "center", "alignItems" to "center")), "upload-icon" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "99%")), "uploaded-image" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100%")), "button-group" to padStyleMapOf(utsMapOf("position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to "20rpx", "paddingLeft" to "20rpx", "paddingRight" to "20rpx", "backgroundColor" to "#ffffff", "zIndex" to 100)), "btn-review" to padStyleMapOf(utsMapOf("width" to "49%", "paddingTop" to 2, "paddingRight" to 0, "paddingBottom" to 2, "paddingLeft" to 0, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "fontSize" to 18, "boxShadow" to "0px 5px 10px 0px rgba(0, 0, 0, 0.2)", "backgroundColor" to "#ffffff", "color" to "#333333", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000")), "btn-save" to padStyleMapOf(utsMapOf("width" to "49%", "paddingTop" to 2, "paddingRight" to 0, "paddingBottom" to 2, "paddingLeft" to 0, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "fontSize" to 18, "boxShadow" to "0px 5px 10px 0px rgba(0, 0, 0, 0.2)", "backgroundColor" to "#000000", "color" to "#ffffff")), "photo-agree-title" to padStyleMapOf(utsMapOf("textAlign" to "center", "width" to "100%", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
