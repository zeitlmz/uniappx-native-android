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
import io.dcloud.uniapp.extapi.chooseImage as uni_chooseImage
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesOtherCarManageAddIndex : BasePage {
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
        var setup: (__props: GenPagesOtherCarManageAddIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherCarManageAddIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val router = uni_useKuxRouter()
            val vehicleId = ref<String>("")
            val initForm = fun(): CarDetailInfo {
                return CarDetailInfo(id = "", status = 0, serviceId = 0, userIdentityInfoId = 0, vehicleNature = "0", vehicleAttribute = "1", vehicleProvinceCode = "", vehicleProvinceName = "", vehicleCityCode = "", vehicleCityName = "", vehicleLicenseA = "", vehicleLicenseB = "", vehicleLicenseC = "", vehicleYears = 0, vehiclePlateNo = "", carType = "", registerDate = "", licenseIssuingDate = "", licenseFileNo = "", useCharacter = "", vehicleBrand = "", vehicleModel = "", vehicleVin = "", vehicleEngineNo = "", vehicleRatifiedPeople = 0, vehiclePic = "", vehicleColor = "", rackNumber = "", annualInspectionDueDate = "", transportPic = "", licenceNo = "", businessScope = "", transportIssuingAuthority = "", transportIssuingDate = "", roadPassengerTransportCertificate = "", roadPassengerTransportCertificateNo = "", roadPassengerTransportCertificateDate = "", trafficPic = "", trafficCompanyName = "", trafficInsuranceNo = "", trafficAmount = 0, trafficValidityDateStart = "", trafficValidityDateEnd = "", commercialPic = "", commercialCompanyName = "", commercialInsuranceNo = "", commercialAmountA = 0, commercialAmountB = 0, commercialValidityDateStart = "", commercialValidityDateEnd = "", carrierPic = "", carrierCompanyName = "", carrierInsuranceNo = "", carrierAmount = 0, carrierValidityDateStart = "", carrierValidityDateEnd = "", carrierAmountIsEnough = true, seatTemplateId = null, remark = "", serviceName = "")
            }
            val formData = ref<CarDetailInfo>(initForm())
            val colorRows = computed(fun(): UTSArray<UTSArray<colorOption>> {
                val rows: UTSArray<UTSArray<colorOption>> = utsArrayOf()
                run {
                    var i: Number = 0
                    while(i < colorOptions.value.length){
                        val row: UTSArray<colorOption> = utsArrayOf()
                        row.push(colorOptions.value[i])
                        if (i + 1 < colorOptions.value.length) {
                            row.push(colorOptions.value[i + 1])
                        }
                        rows.push(row)
                        i += 2
                    }
                }
                return rows
            }
            )
            val showColorSelector = ref<Boolean>(false)
            val selectedColor = ref<colorOption>(colorOption(name = "", color = ""))
            val selectColor = fun(color: colorOption){
                selectedColor.value = color
                showColorSelector.value = false
                formData.value.vehicleColor = color.name
            }
            val carProSelecteds = ref(utsArrayOf<String>("1"))
            val carProModeStr = ref<String>("司机自营")
            val carProModeList = ref(utsArrayOf<PICKER_ITEM_INFO>(PICKER_ITEM_INFO(title = "司机自营", id = "1"), PICKER_ITEM_INFO(title = "挂靠车辆", id = "0")))
            val driverTypeStr = ref<String>("网约车")
            val driverTypeSelecteds = ref(utsArrayOf<String>("0"))
            val driverTypeList = ref(utsArrayOf<PICKER_ITEM_INFO>(PICKER_ITEM_INFO(title = "网约车", id = "0"), PICKER_ITEM_INFO(title = "客运车", id = "1")))
            val transportStatus = computed(fun(): String {
                console.log("driverTypeSelecteds=", driverTypeSelecteds)
                return driverTypeSelecteds.value[0]
            }
            )
            fun gen_feedbackDetail_fn() {
                getCarVehicleInfoDetail(vehicleId.value).then(fun(res: Response){
                    if (res.data != null) {
                        val data = res.data as UTSJSONObject
                        val detailInfo = JSON.parseObject<CarDetailInfo>(JSON.stringify(res.data))
                        formData.value = detailInfo ?: initForm()
                        if (formData.value != null) {
                            val vehicleAttribute = data.getNumber("vehicleAttribute")
                            formData.value.vehicleAttribute = if (vehicleAttribute != null) {
                                vehicleAttribute.toString(10)
                            } else {
                                "1"
                            }
                            carProSelecteds.value = utsArrayOf(
                                formData.value.vehicleAttribute
                            )
                            val vehicleNature = data.getNumber("vehicleNature")
                            formData.value.vehicleNature = if (vehicleNature != null) {
                                vehicleNature.toString(10)
                            } else {
                                "0"
                            }
                            driverTypeSelecteds.value = utsArrayOf(
                                formData.value.vehicleNature
                            )
                            colorOptions.value.forEach(fun(item: colorOption){
                                if (item.name == formData.value.vehicleColor) {
                                    selectedColor.value = item
                                    return
                                }
                            }
                            )
                        }
                    }
                }
                ).`catch`(fun(err: Any?){
                    console.log("err===", err)
                }
                )
            }
            val feedbackDetail = ::gen_feedbackDetail_fn
            fun gen_handleUploadFileInfo_fn(type: String, path: String, recognizeRes: UTSJSONObject) {
                if (formData.value == null) {
                    return
                }
                when (type) {
                    "vehiclePic" -> 
                        formData.value.vehiclePic = path
                    "vehicleLicenseA" -> 
                        {
                            if (!isBlank(path)) {
                                formData.value.vehicleLicenseA = path
                            }
                            if (!objOfNull(recognizeRes)) {
                                formData.value.carType = recognizeRes.getString("vehicleType") ?: ""
                                formData.value.registerDate = recognizeRes.getString("registrationDate") ?: ""
                                formData.value.licenseIssuingDate = recognizeRes.getString("issueDate") ?: ""
                                formData.value.useCharacter = recognizeRes.getString("useNature") ?: ""
                                formData.value.vehicleVin = recognizeRes.getString("vinCode") ?: ""
                                formData.value.vehiclePlateNo = recognizeRes.getString("licensePlateNumber") ?: ""
                                formData.value.vehicleEngineNo = recognizeRes.getString("engineNumber") ?: ""
                            }
                        }
                    "vehicleLicenseB" -> 
                        {
                            if (!isBlank(path)) {
                                formData.value.vehicleLicenseB = path
                            }
                            if (!objOfNull(recognizeRes)) {
                                formData.value.licenseFileNo = recognizeRes.getString("recordNumber") ?: ""
                                formData.value.vehicleRatifiedPeople = recognizeRes.getNumber("passengerCapacity") ?: 0
                            }
                        }
                    "vehicleLicenseC" -> 
                        if (!isBlank(path)) {
                            formData.value.vehicleLicenseC = path
                        }
                    "roadPassengerTransportCertificate" -> 
                        if (!isBlank(path)) {
                            formData.value.roadPassengerTransportCertificate = path
                        }
                    "transportPic" -> 
                        if (!isBlank(path)) {
                            formData.value.transportPic = path
                        }
                    "trafficPic" -> 
                        if (!isBlank(path)) {
                            formData.value.trafficPic = path
                        }
                    "commercialPic" -> 
                        if (!isBlank(path)) {
                            formData.value.commercialPic = path
                        }
                    "carrierPic" -> 
                        if (!isBlank(path)) {
                            formData.value.carrierPic = path
                        }
                    else -> 
                        {}
                }
            }
            val handleUploadFileInfo = ::gen_handleUploadFileInfo_fn
            fun gen_uploadImage_fn(type: Number, type2: String) {
                console.log("type2=", type2)
                uni_chooseImage(ChooseImageOptions(count = 1, sourceType = utsArrayOf(
                    "album",
                    "camera"
                ), success = fun(res){
                    val tempFilePath = res.tempFilePaths[0] as String
                    console.log("tempFilePath", res)
                    handleUploadFileInfo(type2, tempFilePath as String, UTSJSONObject())
                    uploadFileSync(OrcData(platformName = "car", type = type, file = tempFilePath)).then(fun(res: Response){
                        console.log("上传结果", res)
                        handleUploadFileInfo(type2, res.data as String, UTSJSONObject())
                    }
                    )
                    if (type > 0) {
                        aliOcrSync(OrcData(type = type, platformName = "car", file = tempFilePath)).then(fun(res: Response){
                            console.log("ocr结果", res)
                            handleUploadFileInfo(type2, "", res.data as UTSJSONObject)
                        }
                        )
                    }
                }
                ))
            }
            val uploadImage = ::gen_uploadImage_fn
            val assembleReqData = fun(formData: CarDetailInfo){
                if (carProSelecteds.value.length > 0) {
                    formData.vehicleAttribute = carProSelecteds.value[0]
                }
                if (driverTypeSelecteds.value.length > 0) {
                    formData.vehicleNature = driverTypeSelecteds.value[0]
                }
            }
            fun gen_submitForReview_fn() {
                assembleReqData(formData.value)
                if (carProSelecteds.value.length <= 0) {
                    showToast("请选择车辆属性", "warning")
                    return
                }
                if (driverTypeSelecteds.value.length <= 0) {
                    showToast("请选择车辆性质", "warning")
                    return
                }
                if (formData.value.vehiclePic == "") {
                    showToast("请上传车辆照片", "warning")
                    return
                }
                if (formData.value.vehicleLicenseA == "" || formData.value.vehicleLicenseB == "" || formData.value.vehicleLicenseC == "") {
                    showToast("请上传行驶证照片", "warning")
                    return
                }
                console.log("提交审核", formData.value)
                if (formData.value.vehicleNature == "0" && formData.value.transportPic == "") {
                    showToast("请上传营运资质照片", "warning")
                    return
                }
                if (formData.value.vehicleNature == "1" && formData.value.roadPassengerTransportCertificate == "") {
                    showToast("请上传营运资质照片", "warning")
                    return
                }
                if (formData.value.trafficPic == "" || formData.value.commercialPic == "") {
                    showToast("请上传保险信息照片", "warning")
                    return
                }
                showLoading(XLOADINGS_TYPE(title = "提交中..."))
                val submitData = UTSJSONObject.assign<UTSJSONObject>(UTSJSONObject(), formData.value) as UTSJSONObject
                submitData.set("id", vehicleId.value)
                submitVehicleInfo(submitData).then(fun(res: Response){
                    showToast("提交成功", "success")
                    router.push("/pages/other/car-manage/index")
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
                assembleReqData(formData.value)
                val submitData = UTSJSONObject.assign<UTSJSONObject>(UTSJSONObject(), formData.value) as UTSJSONObject
                console.log("信息暂存", submitData)
                if (vehicleId.value == null || vehicleId.value == "") {
                    submitData.set("id", null)
                } else {
                    submitData.set("id", vehicleId.value)
                }
                showLoading(XLOADINGS_TYPE(title = "保存中..."))
                saveVehicleInfo(submitData).then(fun(res: Response){
                    showToast("保存成功", "success")
                    vehicleId.value = res.data as String
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
            onLoad(fun(options){
                if (options != null) {
                    val opt = JSON.parse(JSON.stringify(options)) as UTSJSONObject
                    console.log("opt=", opt)
                    val tempId = opt.getString("vehicleId") ?: "0"
                    vehicleId.value = tempId
                    feedbackDetail()
                }
            }
            )
            return fun(): Any? {
                val _component_x_picker = resolveEasyComponent("x-picker", GenUniModulesTmxUiComponentsXPickerXPickerClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return createElementVNode(Fragment, null, utsArrayOf(
                    createVNode(_component_mc_base_container, utsMapOf("title" to "添加车辆"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "approve-info-container", "style" to normalizeStyle(utsMapOf<String, Any?>())), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "info-section"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "section-title"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "title-bar")),
                                        createElementVNode("text", utsMapOf("class" to "title-text"), "基础信息")
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "info-form"), utsArrayOf(
                                        createVNode(_component_x_picker, utsMapOf("modelValue" to carProSelecteds.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                            carProSelecteds.value = `$event`
                                        }
                                        , "model-str" to carProModeStr.value, "onUpdate:modelStr" to fun(`$event`: String){
                                            carProModeStr.value = `$event`
                                        }
                                        , "list" to carProModeList.value), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "form-item"), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "item-label"), "车辆属性"),
                                                    createElementVNode("view", utsMapOf("class" to "item-value"), utsArrayOf(
                                                        createElementVNode("text", utsMapOf("class" to normalizeClass(utsMapOf("placeholder-text" to (carProSelecteds.value.length == 0)))), toDisplayString(if ((carProSelecteds.value.length > 0)) {
                                                            carProModeStr.value
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
                                        createVNode(_component_x_picker, utsMapOf("modelValue" to driverTypeSelecteds.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                            driverTypeSelecteds.value = `$event`
                                        }
                                        , "model-str" to driverTypeStr.value, "onUpdate:modelStr" to fun(`$event`: String){
                                            driverTypeStr.value = `$event`
                                        }
                                        , "list" to driverTypeList.value), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createElementVNode("view", utsMapOf("class" to "form-item"), utsArrayOf(
                                                    createElementVNode("text", utsMapOf("class" to "item-label"), "车辆性质"),
                                                    createElementVNode("view", utsMapOf("class" to "item-value"), utsArrayOf(
                                                        createElementVNode("text", utsMapOf("class" to normalizeClass(utsMapOf("placeholder-text" to (driverTypeSelecteds.value.length == 0)))), toDisplayString(if (driverTypeSelecteds.value.length > 0) {
                                                            driverTypeStr.value
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
                                        createElementVNode("text", utsMapOf("class" to "title-text"), "车辆信息")
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "upload-container"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "upload-item"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "upload-box", "onClick" to fun(){
                                                uploadImage(-1, "vehiclePic")
                                            }
                                            ), utsArrayOf(
                                                if (isTrue(formData.value.vehiclePic)) {
                                                    createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to formData.value.vehiclePic, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                } else {
                                                    createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/car-info.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
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
                                    createElementVNode("view", utsMapOf("class" to "info-form"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "form-item", "onClick" to fun(){
                                            showColorSelector.value = true
                                        }
                                        ), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "item-label"), "车辆颜色"),
                                            createElementVNode("view", utsMapOf("class" to "item-value"), utsArrayOf(
                                                if (isTrue(selectedColor.value)) {
                                                    createElementVNode("view", utsMapOf("key" to 0), utsArrayOf(
                                                        createElementVNode("view", utsMapOf("style" to normalizeStyle("background-color: " + selectedColor.value.color + ";")), null, 4),
                                                        createElementVNode("text", null, toDisplayString(selectedColor.value.name), 1)
                                                    ))
                                                } else {
                                                    createElementVNode("text", utsMapOf("key" to 1, "class" to "placeholder-text"), "请选择")
                                                }
                                                ,
                                                createElementVNode("image", utsMapOf("class" to "icon-arrow", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-line-samll.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                    "src"
                                                ))
                                            ))
                                        ), 8, utsArrayOf(
                                            "onClick"
                                        ))
                                    ))
                                )),
                                createElementVNode("view", utsMapOf("class" to "info-section"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "section-title"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "title-bar")),
                                        createElementVNode("text", utsMapOf("class" to "title-text"), "行驶证信息")
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "upload-container"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "upload-item"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "upload-box", "onClick" to fun(){
                                                uploadImage(6, "vehicleLicenseA")
                                            }
                                            ), utsArrayOf(
                                                if (isTrue(formData.value.vehicleLicenseA)) {
                                                    createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to formData.value.vehicleLicenseA, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                } else {
                                                    createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/car-vehicleLicenseA.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                }
                                            ), 8, utsArrayOf(
                                                "onClick"
                                            ))
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "upload-item"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "upload-box", "onClick" to fun(){
                                                uploadImage(6, "vehicleLicenseB")
                                            }
                                            ), utsArrayOf(
                                                if (isTrue(formData.value.vehicleLicenseB)) {
                                                    createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to formData.value.vehicleLicenseB, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                } else {
                                                    createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/car-vehicleLicenseB.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                }
                                            ), 8, utsArrayOf(
                                                "onClick"
                                            ))
                                        ))
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "upload-container"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "upload-item"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "upload-box", "onClick" to fun(){
                                                uploadImage(-1, "vehicleLicenseC")
                                            }
                                            ), utsArrayOf(
                                                if (isTrue(formData.value.vehicleLicenseC)) {
                                                    createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to formData.value.vehicleLicenseC, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                } else {
                                                    createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/car-vehicleLicenseC.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
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
                                        createElementVNode("text", utsMapOf("class" to "title-text"), "营运资质信息（运输证）")
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "upload-container"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "upload-item"), utsArrayOf(
                                            if (transportStatus.value == "1") {
                                                createElementVNode("view", utsMapOf("key" to 0, "class" to "upload-box", "onClick" to fun(){
                                                    uploadImage(-1, "roadPassengerTransportCertificate")
                                                }), utsArrayOf(
                                                    if (isTrue(formData.value.roadPassengerTransportCertificate)) {
                                                        createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to formData.value.roadPassengerTransportCertificate, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
                                                    } else {
                                                        createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/car-transportCertificate.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
                                                    }
                                                ), 8, utsArrayOf(
                                                    "onClick"
                                                ))
                                            } else {
                                                createCommentVNode("v-if", true)
                                            }
                                            ,
                                            if (transportStatus.value == "0") {
                                                createElementVNode("view", utsMapOf("key" to 1, "class" to "upload-box", "onClick" to fun(){
                                                    uploadImage(-1, "transportPic")
                                                }), utsArrayOf(
                                                    if (isTrue(formData.value.transportPic)) {
                                                        createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to formData.value.transportPic, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
                                                    } else {
                                                        createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/car-transportCertificate.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                            "src"
                                                        ))
                                                    }
                                                ), 8, utsArrayOf(
                                                    "onClick"
                                                ))
                                            } else {
                                                createCommentVNode("v-if", true)
                                            }
                                        ))
                                    ))
                                )),
                                createElementVNode("view", utsMapOf("class" to "info-section"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "section-title"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "title-bar")),
                                        createElementVNode("text", utsMapOf("class" to "title-text"), "保险信息")
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "upload-container"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "upload-item"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "upload-box", "onClick" to fun(){
                                                uploadImage(-1, "trafficPic")
                                            }
                                            ), utsArrayOf(
                                                if (isTrue(formData.value.trafficPic)) {
                                                    createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to formData.value.trafficPic, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                } else {
                                                    createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/car-traffic.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                }
                                            ), 8, utsArrayOf(
                                                "onClick"
                                            ))
                                        )),
                                        createElementVNode("view", utsMapOf("class" to "upload-item"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "upload-box", "onClick" to fun(){
                                                uploadImage(-1, "commercialPic")
                                            }
                                            ), utsArrayOf(
                                                if (isTrue(formData.value.commercialPic)) {
                                                    createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to formData.value.commercialPic, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                } else {
                                                    createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/car-commercial.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
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
                                        createElementVNode("text", utsMapOf("class" to "title-text"), "承运险信息（非必填）")
                                    )),
                                    createElementVNode("view", utsMapOf("class" to "upload-container"), utsArrayOf(
                                        createElementVNode("view", utsMapOf("class" to "upload-item"), utsArrayOf(
                                            createElementVNode("view", utsMapOf("class" to "upload-box", "onClick" to fun(){
                                                uploadImage(-1, "carrierPic")
                                            }
                                            ), utsArrayOf(
                                                if (isTrue(formData.value.carrierPic)) {
                                                    createElementVNode("image", utsMapOf("key" to 0, "class" to "uploaded-image", "src" to formData.value.carrierPic, "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                } else {
                                                    createElementVNode("image", utsMapOf("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/car-carrier.png"), "mode" to "widthFix"), null, 8, utsArrayOf(
                                                        "src"
                                                    ))
                                                }
                                            ), 8, utsArrayOf(
                                                "onClick"
                                            ))
                                        ))
                                    ))
                                ))
                            ), 4),
                            createElementVNode("view", utsMapOf("class" to "button-group", "style" to normalizeStyle("width:" + unref(screenWidth) + "px; padding-bottom: " + (unref(globalData).safeAreaBottom + 15) + "px")), utsArrayOf(
                                createElementVNode("button", utsMapOf("class" to "btn-review", "onClick" to submitForReview), "审核提交"),
                                createElementVNode("button", utsMapOf("class" to "btn-save", "onClick" to saveInformation), "信息暂存")
                            ), 4)
                        )
                    }
                    ), "_" to 1)),
                    if (isTrue(showColorSelector.value)) {
                        createElementVNode("view", utsMapOf("key" to 0, "class" to "color-selector-popup"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "color-selector-mask", "onClick" to fun(){
                                showColorSelector.value = false
                            }), null, 8, utsArrayOf(
                                "onClick"
                            )),
                            createElementVNode("view", utsMapOf("class" to "color-selector-container"), utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "color-selector-header"), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "color-selector-title"), "选择车身颜色")
                                )),
                                createElementVNode("view", utsMapOf("class" to "color-selector-content"), utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "color-grid"), utsArrayOf(
                                        createElementVNode(Fragment, null, RenderHelpers.renderList(colorRows.value, fun(row, rowIndex, __index, _cached): Any {
                                            return createElementVNode("view", utsMapOf("class" to "color-row", "key" to rowIndex), utsArrayOf(
                                                createElementVNode(Fragment, null, RenderHelpers.renderList(row, fun(item, index, __index, _cached): Any {
                                                    return createElementVNode("view", utsMapOf("class" to "color-item", "style" to normalizeStyle("" + (if (selectedColor.value.name == item.name) {
                                                        "border: 2px solid #536FA6;"
                                                    } else {
                                                        ""
                                                    })), "key" to index, "onClick" to fun(){
                                                        selectColor(item)
                                                    }), utsArrayOf(
                                                        createElementVNode("view", utsMapOf("class" to "color-circle", "style" to normalizeStyle("background-color: " + item.color + ";")), null, 4),
                                                        createElementVNode("text", utsMapOf("class" to "color-name"), toDisplayString(item.name), 1),
                                                        if (selectedColor.value.name === item.name) {
                                                            createElementVNode("image", utsMapOf("key" to 0, "class" to "selected-mark", "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-success.png")), null, 8, utsArrayOf(
                                                                "src"
                                                            ))
                                                        } else {
                                                            createCommentVNode("v-if", true)
                                                        }
                                                    ), 12, utsArrayOf(
                                                        "onClick"
                                                    ))
                                                }), 128)
                                            ))
                                        }), 128)
                                    ))
                                ))
                            ))
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    }
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
                return utsMapOf("approve-info-container" to padStyleMapOf(utsMapOf("backgroundColor" to "#f5f5f5", "height" to "100%", "paddingTop" to "30rpx", "paddingBottom" to "350rpx")), "info-section" to padStyleMapOf(utsMapOf("backgroundColor" to "#ffffff", "borderTopLeftRadius" to "12rpx", "borderTopRightRadius" to "12rpx", "borderBottomRightRadius" to "12rpx", "borderBottomLeftRadius" to "12rpx", "marginTop" to 0, "marginRight" to "20rpx", "marginBottom" to "20rpx", "marginLeft" to "20rpx", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "20rpx", "paddingLeft" to "20rpx")), "section-title" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "marginBottom" to "20rpx")), "title-bar" to padStyleMapOf(utsMapOf("width" to "6rpx", "height" to "30rpx", "backgroundColor" to "#000000", "marginRight" to "10rpx")), "title-text" to padStyleMapOf(utsMapOf("fontSize" to "32rpx", "fontWeight" to "bold", "color" to "#000000")), "info-form" to padStyleMapOf(utsMapOf("width" to "100%")), "form-item" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to "30rpx", "paddingRight" to 0, "paddingBottom" to "30rpx", "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#eeeeee", "borderBottomWidth:last-child" to "medium", "borderBottomStyle:last-child" to "none", "borderBottomColor:last-child" to "#000000")), "item-label" to padStyleMapOf(utsMapOf("fontSize" to "28rpx", "color" to "#6C6C6C")), "item-value" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "fontSize" to 16, "color" to "#000000")), "placeholder-text" to utsMapOf(".item-value " to utsMapOf("fontSize" to "28rpx", "color" to "#B2B2B2")), "icon-mail" to padStyleMapOf(utsMapOf("marginLeft" to "10rpx", "fontSize" to "28rpx")), "icon-arrow" to padStyleMapOf(utsMapOf("marginLeft" to "10rpx", "width" to 11, "height" to 6)), "upload-container" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to "20rpx")), "single-upload" to padStyleMapOf(utsMapOf("justifyContent" to "center")), "upload-item" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "width" to "48%")), "upload-box" to padStyleMapOf(utsMapOf("width" to "100%", "height" to 120, "display" to "flex", "justifyContent" to "center", "alignItems" to "center")), "upload-icon" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "99%")), "uploaded-image" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100%")), "button-group" to padStyleMapOf(utsMapOf("flex" to 1, "position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to "20rpx", "paddingLeft" to "20rpx", "paddingRight" to "20rpx", "width" to "100%", "backgroundColor" to "#ffffff", "zIndex" to 100)), "btn-review" to padStyleMapOf(utsMapOf("width" to "49%", "paddingTop" to 2, "paddingRight" to 0, "paddingBottom" to 2, "paddingLeft" to 0, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "fontSize" to 18, "boxShadow" to "0px 5px 10px 0px rgba(0, 0, 0, 0.2)", "backgroundColor" to "#ffffff", "color" to "#333333", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000")), "btn-save" to padStyleMapOf(utsMapOf("width" to "49%", "paddingTop" to 2, "paddingRight" to 0, "paddingBottom" to 2, "paddingLeft" to 0, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "fontSize" to 18, "boxShadow" to "0px 5px 10px 0px rgba(0, 0, 0, 0.2)", "backgroundColor" to "#000000", "color" to "#ffffff")), "color-selector-popup" to padStyleMapOf(utsMapOf("position" to "fixed", "top" to 0, "left" to 0, "right" to 0, "bottom" to 0, "zIndex" to 9999)), "color-selector-mask" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to 0, "left" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "rgba(0,0,0,0.5)")), "color-selector-container" to padStyleMapOf(utsMapOf("position" to "absolute", "left" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "#F2F2F2", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "paddingTop" to "30rpx", "paddingRight" to "30rpx", "paddingBottom" to "30rpx", "paddingLeft" to "30rpx", "transform" to "translateY(0)", "animation" to "slideUp 0.3s ease-out")), "color-selector-header" to padStyleMapOf(utsMapOf("display" to "flex", "justifyContent" to "center", "paddingBottom" to "20rpx", "marginBottom" to "20rpx", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "rgba(0,0,0,0.1)")), "color-selector-title" to padStyleMapOf(utsMapOf("fontSize" to "32rpx", "fontWeight" to "bold", "textAlign" to "center")), "color-selector-content" to padStyleMapOf(utsMapOf("paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "maxHeight" to "1000rpx", "overflowY" to "auto")), "color-grid" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column")), "color-row" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "marginBottom" to "20rpx")), "color-item" to padStyleMapOf(utsMapOf("width" to "48%", "height" to "100rpx", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "16rpx", "borderTopRightRadius" to "16rpx", "borderBottomRightRadius" to "16rpx", "borderBottomLeftRadius" to "16rpx", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "position" to "relative")), "color-circle" to padStyleMapOf(utsMapOf("width" to "60rpx", "height" to "60rpx", "borderTopLeftRadius" to "50rpx", "borderTopRightRadius" to "50rpx", "borderBottomRightRadius" to "50rpx", "borderBottomLeftRadius" to "50rpx", "marginRight" to "20rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "rgba(0,0,0,0.1)", "borderRightColor" to "rgba(0,0,0,0.1)", "borderBottomColor" to "rgba(0,0,0,0.1)", "borderLeftColor" to "rgba(0,0,0,0.1)")), "color-name" to padStyleMapOf(utsMapOf("fontSize" to "28rpx", "color" to "#333333")), "selected-mark" to padStyleMapOf(utsMapOf("position" to "absolute", "top" to "0rpx", "right" to "5rpx", "width" to "30rpx", "height" to "30rpx")), "@FONT-FACE" to utsMapOf("0" to utsMapOf()))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
