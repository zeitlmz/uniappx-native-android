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
import uts.sdk.modules.xModalS.X_MODAL_TYPE
import uts.sdk.modules.xLoadingS.hideXloading
import uts.sdk.modules.xLoadingS.showLoading
import uts.sdk.modules.xModalS.showModal
import uts.sdk.modules.uniKuxrouter.useKuxRouter as uni_useKuxRouter
open class GenPagesOtherTripPlanAddIndex : BasePage {
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
        var setup: (__props: GenPagesOtherTripPlanAddIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesOtherTripPlanAddIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val router = uni_useKuxRouter()
            val planGoTime = ref("")
            val planGoTimeStr = ref("")
            val selectDate = ref("")
            val curDate = ref(formatDate(Date(), "yyyy-MM-dd"))
            val deadlineStartSelectDate = ref("")
            val deadlineEndSelectDate = ref("")
            val startDate = ref("")
            val endDate = ref("")
            val refresTop = ref(false)
            val refresBottom = ref(false)
            val bindCar = ref(_uA<String>())
            val seletCarId = ref(_uA<String>())
            val carList = ref(_uA<UTSJSONObject>())
            val bindLinesGrp = ref("")
            val bindDistrictLines = ref(_uA<UTSJSONObject>())
            val showLines = ref(false)
            val linesIds = ref(_uA<String>())
            val selectParentId = ref("")
            val planId = ref("")
            val conflictStatus = ref(false)
            val conflictTripPlanInfo = ref<TripPlanInfo?>(null)
            val autoHeight = ref(screenHeight)
            val title = ref("添加")
            val operationStartTime = ref("")
            val operationEndTime = ref("")
            var dirverQueryPage: Number = 1
            val dirverQueryLimit: Number = 20
            var scrollDirection = "down"
            val initDriverCarList = fun(page: Number?, limit: Number?){
                val queryPage = page ?: dirverQueryPage
                val queryLimit = limit ?: dirverQueryLimit
                getDriverRelationVehicleList(queryPage, queryLimit).then(fun(res: Response){
                    if (res.code == 200) {
                        val result = res.data as UTSJSONObject
                        val totalRes = result.getNumber("total") ?: 0
                        val records = result.getArray("records")
                        var dataList = _uA<UTSJSONObject>()
                        if (records != null && records.length > 0) {
                            records.forEach(fun(item){
                                val itemJson = JSON.parse<TripPlanDriveInfo1>(JSON.stringify(item)) as TripPlanDriveInfo1
                                dataList.push(object : UTSJSONObject() {
                                    var id = itemJson.id
                                    var vehiclePlateNo = itemJson.vehiclePlateNo
                                    var vehicleRatifiedPeople = itemJson.vehicleRatifiedPeople
                                    var templateData = itemJson.templateData
                                    var vehicleModel = itemJson.vehicleModel
                                    var vehicleColor = itemJson.vehicleColor
                                    var carType = itemJson.carType
                                    var vehicleNature = itemJson.vehicleNature
                                    var vehicleQualificationGroupName = itemJson.vehicleQualificationGroupName
                                })
                            })
                        } else {
                            if (totalRes <= 0) {
                                carList.value = dataList
                            }
                        }
                        if (scrollDirection == "down") {
                            refresTop.value = false
                            carList.value = dataList
                        } else {
                            refresBottom.value = false
                            carList.value = carList.value.concat(dataList)
                        }
                    }
                }
                )
            }
            val refreshLoad = fun(){
                dirverQueryPage = 1
                initDriverCarList(dirverQueryPage, dirverQueryLimit)
                setTimeout(fun() {
                    refresTop.value = false
                    showToast("刷新成功", "success")
                }
                , 1500)
            }
            val refresBottomhLoad = fun(){
                dirverQueryPage = dirverQueryPage + 1
                initDriverCarList(dirverQueryPage, dirverQueryLimit)
                setTimeout(fun() {
                    refresBottom.value = false
                    showToast("触底成功", "success")
                }
                , 1500)
            }
            val initLinesTree = fun(){
                getDriverBindLinesTree().then(fun(res: Response){
                    if (res.code == 200) {
                        val dataStr = JSON.stringify(res.data)
                        val jsonList = JSON.parse<UTSArray<UTSJSONObject>>(dataStr) as UTSArray<UTSJSONObject>
                        run {
                            var i: Number = 0
                            while(i < jsonList.length){
                                val item = jsonList[i]
                                item["linesId"] = item["nodeName"]
                                if (item["children"] != null) {
                                    val childrenList = JSON.parse<UTSArray<UTSJSONObject>>(JSON.stringify(item["children"])) as UTSArray<UTSJSONObject>
                                    val childrenFinalList = _uA<UTSJSONObject>()
                                    childrenList.forEach(fun(child){
                                        childrenFinalList.push(object : UTSJSONObject() {
                                            var linesId = child["linesId"]
                                            var nodeName = (child["startDistrictName"] as String) + " - " + child["endDistrictName"] as String
                                        })
                                    })
                                    item["children"] = childrenFinalList
                                } else {
                                    item["children"] = null
                                }
                                i++
                            }
                        }
                        console.log("jsonList==", jsonList)
                        bindDistrictLines.value = jsonList
                    }
                }
                )
            }
            val handleTreeFloderChange = fun(idscopty: UTSArray<String>){
                if (idscopty.length > 0) {
                    var factor = if (conflictStatus.value) {
                        50
                    } else {
                        33
                    }
                    var itemHeight: Number = 0
                    run {
                        var i: Number = 0
                        while(i < bindDistrictLines.value.length){
                            val item = bindDistrictLines.value[i]
                            idscopty.forEach(fun(id){
                                if ((item["nodeName"] as String).startsWith(id)) {
                                    val childList = item["children"] as UTSArray<UTSJSONObject>
                                    itemHeight = itemHeight + (childList.length * factor)
                                }
                            })
                            i++
                        }
                    }
                    autoHeight.value = screenHeight + itemHeight
                } else {
                    autoHeight.value = screenHeight
                }
            }
            val handleTreeChange = fun(ids: UTSArray<String>, allParent: UTSArray<String>, allChildrenId: UTSArray<String>, allIdsAndInd: UTSArray<String>){
                console.log("handleTreeChange ids=", ids)
                console.log("handleTreeChange allParent=", allParent)
                console.log("handleTreeChange allChildrenId=", allChildrenId)
                console.log("handleTreeChange allIdsAndInd=", allIdsAndInd)
                console.log("handleTreeChange bindDistrictLines.value.length=", bindDistrictLines.value.length)
                if (allIdsAndInd.length > 0) {
                    val regex = UTSRegExp("[\\u4e00-\\u9fa5]", "")
                    selectParentId.value = allIdsAndInd.filter(fun(item): Boolean {
                        return regex.test(item)
                    })[0]
                    console.log("handleTreeChange parentId=", selectParentId.value)
                    bindLinesGrp.value = selectParentId.value as String
                    run {
                        var i: Number = 0
                        while(i < bindDistrictLines.value.length){
                            val item = bindDistrictLines.value[i]
                            if (!(item["nodeName"] as String).startsWith(selectParentId.value)) {
                                item["disabled"] = true
                                if (item["children"] != null) {
                                    val childrenList = JSON.parse<UTSArray<UTSJSONObject>>(JSON.stringify(item["children"])) as UTSArray<UTSJSONObject>
                                    childrenList.forEach(fun(child){
                                        child["disabled"] = true
                                    }
                                    )
                                    item["children"] = childrenList
                                }
                            }
                            i++
                        }
                    }
                } else {
                    run {
                        var i: Number = 0
                        while(i < bindDistrictLines.value.length){
                            val item = bindDistrictLines.value[i]
                            item["disabled"] = false
                            if (item["children"] != null) {
                                val childrenList = JSON.parse<UTSArray<UTSJSONObject>>(JSON.stringify(item["children"])) as UTSArray<UTSJSONObject>
                                childrenList.forEach(fun(child){
                                    child["disabled"] = false
                                }
                                )
                                item["children"] = childrenList
                            }
                            i++
                        }
                    }
                    bindLinesGrp.value = ""
                }
                linesIds.value = ids
            }
            val startChange = fun(){
                if ((Date(startDate.value).getTime() - Date(curDate.value).getTime()) < 0) {
                    showToast("开始日期不能小于今天", "error")
                    startDate.value = ""
                    return
                }
                deadlineEndSelectDate.value = addTime(startDate.value, 15, "day").substring(0, 10)
            }
            val endChange = fun(){
                if ((Date(endDate.value).getTime() - Date(startDate.value).getTime()) < 0) {
                    showToast("结束日期不能小于开始日期", "error")
                    endDate.value = ""
                }
                val diff = daysBetweenDays(Date(startDate.value), Date(endDate.value))
                console.log("endChange diff===", diff)
                if (diff > 15) {
                    showToast("日期范围不能超过15天", "error")
                    endDate.value = ""
                }
            }
            val handleAdd = fun(){
                val userInfo = getCacheUserInfo()
                if (userInfo == null) {
                    showToast("会话异常", "error")
                    return
                }
                val driverSessionInfo = userInfo.getJSON("driverSessionInfo")
                val driverId = driverSessionInfo?.getString("driverId")
                val serviceId = driverSessionInfo?.getString("serviceId")
                if (startDate.value == "") {
                    showToast("请选择行程开始日期", "error")
                    return
                }
                if (endDate.value == "") {
                    showToast("请选择行程结束日期", "error")
                    return
                }
                if (planGoTime.value == "") {
                    showToast("请选择行程发车时间", "error")
                    return
                }
                planGoTime.value = planGoTime.value.substring(0, 5) + ":00"
                if (seletCarId.value.length < 1) {
                    showToast("请选择关联车辆", "error")
                    return
                }
                if (linesIds.value.length < 1) {
                    showToast("请选择关联线路", "error")
                    return
                }
                showLoading(XLOADINGS_TYPE(title = "提交中..."))
                val param: UTSJSONObject = _uO("driverId" to driverId, "serviceId" to serviceId, "startDate" to startDate.value, "endDate" to endDate.value, "startTime" to planGoTime.value)
                val selectCarItem = carList.value.filter(fun(item): Boolean {
                    return seletCarId.value[0] == item["id"]
                }
                )
                console.log("upsertDriverPlan selectCarItem=", selectCarItem)
                if (selectCarItem.length > 0) {
                    val driveInfo = JSON.parse(JSON.stringify(selectCarItem[0])) as UTSJSONObject
                    driveInfo["templateData"] = ""
                    param["driveInfo"] = driveInfo
                    param["seatPriceTemplate"] = JSON.parseArray(selectCarItem[0]["templateData"] as String)
                }
                val linesGrpItem = bindDistrictLines.value.filter(fun(item): Boolean {
                    return (item["linesId"] as String).startsWith(bindLinesGrp.value)
                }
                )
                console.log("linesGrpItem==", linesGrpItem)
                if (linesGrpItem.length > 0) {
                    val linesGrp = linesGrpItem[0]
                    param["startCityCode"] = linesGrp["startCityCode"]
                    param["startCityName"] = linesGrp["startCityName"]
                    param["endCityCode"] = linesGrp["endCityCode"]
                    param["endCityName"] = linesGrp["endCityName"]
                    param["linesGroupName"] = linesGrp["linesGroupName"]
                    param["linesIdList"] = linesIds.value.filter(fun(item): Boolean {
                        return !UTSRegExp("[\\u4e00-\\u9fa5]", "").test(item)
                    }
                    )
                }
                if (planId.value != "") {
                    param["id"] = planId.value
                }
                console.log("upsertDriverPlan param=", param)
                upsertDriverPlan(param).then(fun(res: Response){
                    console.log("upsertDriverPlan res=", res)
                    if (res.code == 200 && (res.data == null || (res.data as UTSArray<Any>).length < 1)) {
                        showToast("保存成功", "success")
                        router.push("/pages/other/trip-plan/index")
                    } else {
                        showToast("保存失败", "error")
                        val tripPlanInfoList = JSON.parse<UTSArray<TripPlanInfo>>(JSON.stringify(res.data)) as UTSArray<TripPlanInfo>
                        if (tripPlanInfoList != null && tripPlanInfoList.length > 0) {
                            conflictTripPlanInfo.value = tripPlanInfoList[0]
                            conflictStatus.value = true
                        }
                    }
                }
                ).`catch`(fun(){
                    showToast("提交失败", "error")
                }
                ).`finally`(fun(){
                    hideXloading()
                }
                )
            }
            val toDel = fun(){
                showModal(X_MODAL_TYPE(title = "温馨提示", content = "\u786E\u8BA4\u8981\u5220\u9664\u51B2\u7A81\u7684\u884C\u7A0B\u8BA1\u5212\u5417\uFF1F", confirmText = "确认", confirmBgColor = globalData.theme.primaryColor, showCancel = true, confirm = fun(){
                    console.log("todel==", conflictTripPlanInfo.value)
                    delDriverPlan(JSON.parse<UTSJSONObject>(JSON.stringify(conflictTripPlanInfo.value))!!).then(fun(res: Response){
                        if (res.code == 200) {
                            showToast("操作成功", "success")
                            conflictTripPlanInfo.value = null
                            conflictStatus.value = false
                        }
                    }
                    )
                }
                ))
            }
            val cancel = fun(){
                router.push("/pages/other/trip-plan/index")
            }
            val initShow = fun(planId: String, date: String){
                showLoading(XLOADINGS_TYPE(title = "加载中..."))
                searchDriverPlanByPlanId(planId).then(fun(res: Response){
                    if (res.code == 200) {
                        val planData = JSON.parseObject<UTSJSONObject>(JSON.stringify(res.data)) ?: UTSJSONObject()
                        console.log("searchDriverPlanByPlanId=", planData)
                        startDate.value = planData.getString("startDate") ?: ""
                        endDate.value = planData.getString("endDate") ?: ""
                        planGoTime.value = planData.getString("startTime") ?: ""
                        val driveInfo = planData.getJSON("driveInfo")
                        if (driveInfo != null) {
                            val driveInfoId = driveInfo.getString("id")!!
                            seletCarId.value = _uA(
                                driveInfoId
                            )
                            bindCar.value = _uA(
                                driveInfo.getString("vehiclePlateNo")!!
                            )
                        }
                        bindLinesGrp.value = planData.getString("linesGroupName") ?: ""
                        linesIds.value = planData.getArray("linesIdList") as UTSArray<String>
                        linesIds.value = linesIds.value.filter(fun(item, index): Boolean {
                            return linesIds.value.indexOf(item) == index
                        }
                        )
                        val selectLineNodes = bindDistrictLines.value.filter(fun(item, index): Boolean {
                            return item["linesGroupName"] == bindLinesGrp.value
                        }
                        )
                        if (selectLineNodes.length > 0) {
                            val selectLineNode = selectLineNodes[0]
                            if (selectLineNode.getArray("children")?.length == linesIds.value.length) {
                                linesIds.value.push(selectLineNode.getString("nodeName")!!)
                            }
                        }
                        console.log("searchDriverPlanByPlanId  linesIds=", linesIds.value)
                        handleTreeChange(linesIds.value, _uA(), _uA(), _uA(
                            bindLinesGrp.value
                        ).concat(linesIds.value))
                    }
                }
                ).`catch`(fun(){
                    showToast("服务繁忙，请稍后再试", "error")
                }
                ).`finally`(fun(){
                    hideXloading()
                }
                )
            }
            onLoad(fun(options){
                val opt = JSON.parse(JSON.stringify(options)) as UTSJSONObject
                planId.value = opt.getString("id") ?: ""
                selectDate.value = opt.getString("date") ?: curDate.value
                startDate.value = selectDate.value
                deadlineStartSelectDate.value = addTime(selectDate.value, 90, "day").substring(0, 10)
                deadlineEndSelectDate.value = addTime(selectDate.value, 15, "day").substring(0, 10)
                console.log("selectDate===", selectDate.value, ", deadlineStartSelectDate===", deadlineStartSelectDate.value)
                initDriverCarList(dirverQueryPage, dirverQueryLimit)
                initLinesTree()
                if (planId.value != "") {
                    title.value = "编辑"
                    initShow(planId.value, selectDate.value)
                } else {
                    val hour = Date().getHours()
                    planGoTime.value = (if (hour < 10) {
                        ("0" + hour)
                    } else {
                        hour.toString(10)
                    }
                    ) + ":00"
                }
                showLoading(XLOADINGS_TYPE(title = "加载中..."))
                getServiceOperationTime().then(fun(res: Response){
                    console.log("getServiceOperationTime res ==", res)
                    if (res.code == 200) {
                        val resData = res.data as UTSJSONObject
                        operationStartTime.value = resData.getString("operationStartTime")!!
                        operationEndTime.value = resData.getString("operationEndTime")!!
                    }
                }
                ).`catch`(fun(){
                    showToast("服务繁忙，请稍后再试", "error")
                }
                ).`finally`(fun(){
                    hideXloading()
                }
                )
            }
            )
            return fun(): Any? {
                val _component_mc_date_picker = resolveEasyComponent("mc-date-picker", GenComponentsMcDatePickerIndexClass)
                val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass)
                val _component_x_picker_time = resolveEasyComponent("x-picker-time", GenUniModulesTmxUiComponentsXPickerTimeXPickerTimeClass)
                val _component_x_picker_selected = resolveEasyComponent("x-picker-selected", GenUniModulesTmxUiComponentsXPickerSelectedXPickerSelectedClass)
                val _component_x_tree = resolveEasyComponent("x-tree", GenUniModulesTmxUiComponentsXTreeXTreeClass)
                val _component_x_divider = resolveEasyComponent("x-divider", GenUniModulesTmxUiComponentsXDividerXDividerClass)
                val _component_mc_primary_button = resolveEasyComponent("mc-primary-button", GenComponentsMcPrimaryButtonIndexClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return _cV(_component_mc_base_container, _uM("title" to ("" + title.value + "\u884C\u7A0B\u8BA1\u5212")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "container", "style" to _nS("min-height: " + autoHeight.value + "px;")), _uA(
                            _cV(_component_x_sheet, _uM("padding" to _uA(
                                "30rpx",
                                "26rpx"
                            ), "margin" to _uA(
                                "15",
                                "15",
                                "15",
                                "15"
                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_mc_date_picker, _uM("modelValue" to startDate.value, "onUpdate:modelValue" to fun(`$event`: String){
                                        startDate.value = `$event`
                                    }
                                    , "start-date" to selectDate.value, "end-date" to deadlineStartSelectDate.value, "onChange" to fun(){
                                        startChange()
                                    }
                                    , "title" to "请选择开始日期"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "form-item"), _uA(
                                                _cE("text", _uM("class" to "left-box"), "计划开始日期"),
                                                _cE("view", _uM("class" to "right-box"), _uA(
                                                    if (startDate.value == "") {
                                                        _cE("text", _uM("key" to 0, "class" to "value"), "请选择开始日期")
                                                    } else {
                                                        _cC("v-if", true)
                                                    }
                                                    ,
                                                    _cE("text", _uM("class" to "value"), _tD(startDate.value), 1)
                                                ))
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "start-date",
                                        "end-date",
                                        "onChange"
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_x_sheet, _uM("padding" to _uA(
                                "30rpx",
                                "26rpx"
                            ), "margin" to _uA(
                                "15",
                                "0",
                                "15",
                                "15"
                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_mc_date_picker, _uM("modelValue" to endDate.value, "onUpdate:modelValue" to fun(`$event`: String){
                                        endDate.value = `$event`
                                    }
                                    , "end-date" to deadlineEndSelectDate.value, "onChange" to fun(){
                                        endChange()
                                    }
                                    , "title" to "请选择结束日期"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "form-item"), _uA(
                                                _cE("text", _uM("class" to "left-box"), "计划结束日期"),
                                                _cE("view", _uM("class" to "right-box"), _uA(
                                                    if (endDate.value == "") {
                                                        _cE("text", _uM("key" to 0, "class" to "value"), "请选择结束日期")
                                                    } else {
                                                        _cC("v-if", true)
                                                    }
                                                    ,
                                                    _cE("text", _uM("class" to "value"), _tD(endDate.value), 1)
                                                ))
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "end-date",
                                        "onChange"
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_x_sheet, _uM("padding" to _uA(
                                "30rpx",
                                "26rpx"
                            ), "margin" to _uA(
                                "15",
                                "0",
                                "15",
                                "15"
                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_x_picker_time, _uM("type" to "minute", "modelValue" to planGoTime.value, "onUpdate:modelValue" to fun(`$event`: String){
                                        planGoTime.value = `$event`
                                    }
                                    , "model-str" to planGoTimeStr.value, "onUpdate:modelStr" to fun(`$event`: String){
                                        planGoTimeStr.value = `$event`
                                    }
                                    , "format" to "hh:mm", "start" to operationStartTime.value, "end" to operationEndTime.value, "steps" to 10, "title" to "请选择发车时间"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "form-item"), _uA(
                                                _cE("text", _uM("class" to "left-box"), "发车时间"),
                                                _cE("view", _uM("class" to "right-box"), _uA(
                                                    if (planGoTimeStr.value == "") {
                                                        _cE("text", _uM("key" to 0, "style" to _nS(_uM("color" to "#939393")), "class" to "value"), "请选择发车时间", 4)
                                                    } else {
                                                        _cC("v-if", true)
                                                    }
                                                    ,
                                                    if (planGoTimeStr.value != "") {
                                                        _cE("text", _uM("key" to 1, "style" to _nS(_uM("color" to "#939393")), "class" to "value"), _tD(planGoTimeStr.value), 5)
                                                    } else {
                                                        _cC("v-if", true)
                                                    }
                                                ))
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "model-str",
                                        "onUpdate:modelStr",
                                        "start",
                                        "end"
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_x_sheet, _uM("padding" to _uA(
                                "30rpx",
                                "26rpx"
                            ), "margin" to _uA(
                                "15",
                                "0",
                                "15",
                                "15"
                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "form-item"), _uA(
                                        _cE("text", _uM("class" to "left-box"), "关联车辆"),
                                        _cE("view", _uM("class" to "right-box"), _uA(
                                            _cV(_component_x_picker_selected, _uM("refresh" to refresTop.value, "onUpdate:refresh" to fun(`$event`: Boolean){
                                                refresTop.value = `$event`
                                            }
                                            , "bottom-refresh" to refresBottom.value, "onUpdate:bottomRefresh" to fun(`$event`: Boolean){
                                                refresBottom.value = `$event`
                                            }
                                            , "onRefresh" to refreshLoad, "onBottomRefresh" to refresBottomhLoad, "disabled-bottom" to false, "disabled-pull" to false, "label-key" to "vehiclePlateNo", "filter-key" to "vehiclePlateNo", "multiple" to false, "lazyContent" to true, "model-str" to bindCar.value, "onUpdate:modelStr" to fun(`$event`: UTSArray<String>){
                                                bindCar.value = `$event`
                                            }
                                            , "modelValue" to seletCarId.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                                seletCarId.value = `$event`
                                            }
                                            , "list" to carList.value), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "align-items" to "center"))), _uA(
                                                        if (bindCar.value.length < 1) {
                                                            _cE("text", _uM("key" to 0, "class" to "value", "block" to true), "点击关联车辆")
                                                        } else {
                                                            _cC("v-if", true)
                                                        }
                                                        ,
                                                        if (bindCar.value.length >= 1) {
                                                            _cE("text", _uM("key" to 1, "class" to "value", "block" to true), _tD(bindCar.value.join(",")), 1)
                                                        } else {
                                                            _cC("v-if", true)
                                                        }
                                                        ,
                                                        _cE("image", _uM("class" to "icon", "style" to _nS(_uM("width" to "20rpx", "height" to "25rpx")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-filled-samll.png"), "mode" to "widthFix"), null, 12, _uA(
                                                            "src"
                                                        ))
                                                    ), 4)
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "refresh",
                                                "onUpdate:refresh",
                                                "bottom-refresh",
                                                "onUpdate:bottomRefresh",
                                                "model-str",
                                                "onUpdate:modelStr",
                                                "modelValue",
                                                "onUpdate:modelValue",
                                                "list"
                                            ))
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_x_sheet, _uM("padding" to _uA(
                                "30rpx",
                                "26rpx"
                            ), "margin" to _uA(
                                "15",
                                "0",
                                "15",
                                "15"
                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "form-item", "onClick" to fun(){
                                        showLines.value = !showLines.value
                                    }
                                    ), _uA(
                                        _cE("text", _uM("class" to "left-box"), "关联线路"),
                                        _cE("view", _uM("class" to "right-box"), _uA(
                                            if (bindLinesGrp.value == "") {
                                                _cE("text", _uM("key" to 0, "class" to "value"), "请选择关联线路")
                                            } else {
                                                _cC("v-if", true)
                                            }
                                            ,
                                            if (bindLinesGrp.value != "") {
                                                _cE("text", _uM("key" to 1, "class" to "value"), _tD(bindLinesGrp.value), 1)
                                            } else {
                                                _cC("v-if", true)
                                            }
                                            ,
                                            if (isTrue(!showLines.value)) {
                                                _cE("image", _uM("key" to 2, "class" to "icon", "style" to _nS(_uM("width" to "20rpx", "height" to "25rpx")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-filled-samll.png"), "mode" to "widthFix"), null, 12, _uA(
                                                    "src"
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            }
                                            ,
                                            if (isTrue(showLines.value)) {
                                                _cE("image", _uM("key" to 3, "class" to "icon", "style" to _nS(_uM("width" to "20rpx", "height" to "25rpx", "transform" to "rotate(180deg)")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-arrow-down-filled-samll.png"), "mode" to "widthFix"), null, 12, _uA(
                                                    "src"
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            }
                                        ))
                                    ), 8, _uA(
                                        "onClick"
                                    )),
                                    if (isTrue(showLines.value)) {
                                        _cE("view", _uM("key" to 0, "style" to _nS(_uM("margin-top" to "20rpx"))), _uA(
                                            _cV(_component_x_sheet, _uM("class" to "flex-row flex-row-center-between", "style" to _nS(_uM("width" to "100%", "min-height" to "50px")), "margin" to _uA(
                                                "0",
                                                "0",
                                                "0",
                                                "10"
                                            ), "color" to unref(globalData).theme.painColor), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "left-box flex-row flex-row-center-between", "style" to _nS(_uM("width" to "100%", "height" to "100%"))), _uA(
                                                        _cV(_component_x_tree, _uM("list" to bindDistrictLines.value, "idKey" to "linesId", "labelKey" to "nodeName", "onChange" to handleTreeChange, "onOpenFolderChange" to handleTreeFloderChange, "parentSelectedFullChildren" to true, "modelValue" to linesIds.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                                            linesIds.value = `$event`
                                                        }, "style" to _nS(_uM("width" to "100%", "min-height" to "50px"))), null, 8, _uA(
                                                            "list",
                                                            "modelValue",
                                                            "onUpdate:modelValue",
                                                            "style"
                                                        ))
                                                    ), 4)
                                                )
                                            }), "_" to 1), 8, _uA(
                                                "style",
                                                "color"
                                            ))
                                        ), 4)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )
                            }
                            ), "_" to 1)),
                            if (isTrue(conflictStatus.value && conflictTripPlanInfo.value != null)) {
                                _cV(_component_x_sheet, _uM("key" to 0, "padding" to _uA(
                                    "0"
                                ), "color" to "#00000000", "round" to _uA(
                                    "0"
                                ), "margin" to _uA(
                                    "15",
                                    "0",
                                    "15",
                                    "15"
                                )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", _uM("class" to "tag_card-header flex-row flex-row-center-between"), _uA(
                                            _cE("view", _uM("class" to "card-title flex-row flex-row-center-between"), _uA(
                                                _cE("view", _uM("class" to "title-border", "style" to _nS("background-color: " + unref(globalData).theme.primaryColor + ";")), null, 4),
                                                _cE("text", _uM("class" to "text"), "与以下行程计划存在冲突")
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "tag-card-list"), _uA(
                                            _cV(_component_x_sheet, _uM("height" to "250rpx", "width" to "100%", "margin" to _uA(
                                                "0",
                                                "5"
                                            ), "padding" to _uA(
                                                "15",
                                                "10"
                                            )), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "card-title flex-row flex-row-center-between"), _uA(
                                                        _cE("text", _uM("class" to "title-border", "style" to _nS("font-weight: bold;font-size:30rpx;color: " + unref(globalData).theme.primaryColor + ";")), _tD(conflictTripPlanInfo.value?.id), 5),
                                                        _cE("image", _uM("class" to "icon", "style" to _nS(_uM("width" to "30rpx", "height" to "30rpx")), "src" to ("" + unref(resBaseUrl) + "/static/icons/icon-sub-filled.png"), "mode" to "widthFix", "onClick" to toDel), null, 12, _uA(
                                                            "src"
                                                        ))
                                                    )),
                                                    _cV(_component_x_divider, _uM("class" to "mt-5", "lineWidth" to "2")),
                                                    _cE("view", _uM("class" to "card-title flex-row mt-10"), _uA(
                                                        _cE("text", _uM("class" to "title-border", "style" to _nS(_uM("font-weight" to "bold", "font-size" to "30rpx", "color" to "#777676"))), " 时间： ", 4),
                                                        _cE("text", _uM("class" to "title-border", "style" to _nS(_uM("font-weight" to "bold", "font-size" to "30rpx", "color" to "#000000"))), _tD(conflictTripPlanInfo.value?.startDate) + " " + _tD(conflictTripPlanInfo.value?.startTime), 5)
                                                    )),
                                                    _cE("view", _uM("class" to "card-title flex-row mt-5"), _uA(
                                                        _cE("text", _uM("class" to "title-border", "style" to _nS(_uM("font-weight" to "bold", "font-size" to "30rpx", "color" to "#777676"))), " 城市： ", 4),
                                                        _cE("text", _uM("class" to "title-border", "style" to _nS(_uM("font-weight" to "bold", "font-size" to "30rpx", "color" to "#000000"))), _tD(conflictTripPlanInfo.value?.startCityName) + "-" + _tD(conflictTripPlanInfo.value?.endCityName), 5)
                                                    )),
                                                    _cE("view", _uM("class" to "card-title flex-row mt-5"), _uA(
                                                        _cE("text", _uM("class" to "title-border", "style" to _nS(_uM("font-weight" to "bold", "font-size" to "30rpx", "color" to "#777676"))), " 关联线路： ", 4),
                                                        _cE("text", _uM("class" to "title-border", "style" to _nS(_uM("font-weight" to "bold", "font-size" to "30rpx", "color" to "#000000"))), _tD(conflictTripPlanInfo.value?.linesGroupName), 5)
                                                    ))
                                                )
                                            }), "_" to 1))
                                        ))
                                    )
                                }), "_" to 1))
                            } else {
                                _cC("v-if", true)
                            }
                        ), 4),
                        _cE("view", _uM("class" to "button-group", "style" to _nS("width:" + unref(screenWidth) + "px; padding-bottom: " + (unref(globalData).safeAreaBottom + 15) + "px")), _uA(
                            _cV(_component_mc_primary_button, _uM("class" to "btn-review", "bgColor" to "#ffffff", "color" to "#4A6295", "onClick" to fun(){
                                cancel()
                            }
                            ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    "取消"
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "onClick"
                            )),
                            _cV(_component_mc_primary_button, _uM("class" to "btn-save", "onClick" to fun(){
                                handleAdd()
                            }
                            ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    "确定"
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "onClick"
                            ))
                        ), 4)
                    )
                }
                ), "_" to 1), 8, _uA(
                    "title"
                ))
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
                return _uM("container" to _pS(_uM("width" to "100%", "position" to "relative", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "marginTop" to 15)), "viewer-title" to _pS(_uM("fontSize" to "36rpx", "fontWeight" to "bold", "color" to "#ffffff", "textAlign" to "center")), "confirm-button" to _pS(_uM("height" to "88rpx", "lineHeight" to "88rpx", "textAlign" to "center", "width" to "92%", "backgroundImage" to "linear-gradient(90deg, #ff3232, #fc6832)", "backgroundColor" to "rgba(0,0,0,0)", "borderTopLeftRadius" to "12rpx", "borderTopRightRadius" to "12rpx", "borderBottomRightRadius" to "12rpx", "borderBottomLeftRadius" to "12rpx", "color" to "#ffffff", "fontSize" to "32rpx", "marginTop" to 0, "marginRight" to "30rpx", "marginBottom" to 0, "marginLeft" to "30rpx", "opacity:active" to 0.8)), "drawer-title" to _pS(_uM("textAlign" to "center", "width" to "100%", "marginTop" to "30rpx", "marginRight" to 0, "marginBottom" to "30rpx", "marginLeft" to 0, "fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000")), "form-item" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "left-box" to _uM(".form-item " to _uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center"), ".car-info-item " to _uM("width" to 115, "height" to 100, "position" to "relative")), "right-box" to _uM(".form-item " to _uM("flexDirection" to "row", "alignItems" to "center")), "text" to _uM(".form-item .right-box " to _uM("fontSize" to "32rpx", "color" to "#949494"), ".form-title " to _uM("paddingLeft" to "20rpx", "fontWeight" to "bold", "fontSize" to "36rpx", "color" to "#000000"), ".tag_card-header .card-title " to _uM("paddingLeft" to "20rpx", "fontWeight" to "bold", "fontSize" to "33rpx", "color" to "#000000"), ".tag_card-header .add-btn " to _uM("paddingLeft" to "10rpx", "fontWeight" to "bold", "fontSize" to "32rpx"), ".tag-card-list .tag-card-item .tag-picker .picker-picker " to _uM("fontSize" to "32rpx")), "value" to _uM(".form-item .right-box " to _uM("fontSize" to "32rpx", "color" to "#939393"), ".trip-info-card .trip-body .info-row " to _uM("fontWeight" to "bold", "fontSize" to "30rpx", "color" to "#000000"), ".car-info-item .right-box .info-item " to _uM("color" to "#000000", "fontSize" to 14)), "icon" to _uM(".form-item .right-box " to _uM("width" to 6, "height" to 12, "marginLeft" to "15rpx"), ".trip-info-card .trip-header " to _uM("width" to "30rpx", "height" to "30rpx"), ".tag_card-header .add-btn " to _uM("width" to "34rpx", "height" to "34rpx"), ".tag-card-list .tag-card-item .tag-picker .picker-picker " to _uM("width" to "21rpx", "height" to "11rpx")), "top-box" to _uM(".form-item " to _uM("fontWeight" to "bold", "fontSize" to "32rpx", "color" to "#000000", "paddingBottom" to "20rpx")), "bottom-box" to _uM(".form-item " to _uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "width" to "100%")), "form-title" to _pS(_uM("paddingBottom" to "20rpx")), "title-border" to _uM(".form-title " to _uM("width" to "8rpx", "height" to "33rpx", "borderTopLeftRadius" to "4rpx", "borderTopRightRadius" to "4rpx", "borderBottomRightRadius" to "4rpx", "borderBottomLeftRadius" to "4rpx"), ".tag_card-header .card-title " to _uM("width" to "8rpx", "height" to "33rpx", "borderTopLeftRadius" to "4rpx", "borderTopRightRadius" to "4rpx", "borderBottomRightRadius" to "4rpx", "borderBottomLeftRadius" to "4rpx")), "trip-info-card" to _pS(_uM("backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "paddingTop" to "20rpx", "paddingRight" to "30rpx", "paddingBottom" to "20rpx", "paddingLeft" to "30rpx")), "trip-header" to _uM(".trip-info-card " to _uM("borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#DDDDDD", "paddingBottom" to "15rpx")), "trip-no" to _uM(".trip-info-card .trip-header " to _uM("fontWeight" to "bold", "fontSize" to "30rpx")), "trip-body" to _uM(".trip-info-card " to _uM("paddingTop" to "15rpx")), "info-row" to _uM(".trip-info-card .trip-body " to _uM("paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "fontSize" to "32rpx", "color" to "#000000", "flexDirection" to "row", "alignItems" to "center")), "label" to _uM(".trip-info-card .trip-body .info-row " to _uM("fontSize" to "30rpx", "color" to "#777676", "fontWeight" to "bold"), ".car-info-item .right-box .info-item " to _uM("color" to "#777676", "fontSize" to 14), ".tag-card-list .tag-card-item .tag-picker " to _uM("fontSize" to "32rpx", "paddingBottom" to "15rpx"), ".tag-card-list .tag-card-item .price-input " to _uM("fontSize" to "32rpx", "paddingBottom" to "15rpx")), "car-info-item" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "flex-start")), "status-icon" to _uM(".car-info-item .left-box " to _uM("width" to 70, "height" to 50, "position" to "absolute", "right" to 0, "bottom" to 0)), "title" to _uM(".car-info-item .right-box " to _uM("paddingBottom" to 4, "flexDirection" to "row", "alignItems" to "center")), "car-no" to _uM(".car-info-item .right-box .title " to _uM("fontWeight" to "bold", "fontSize" to 20, "color" to "#000000", "flexDirection" to "row", "alignItems" to "center")), "tag" to _uM(".car-info-item .right-box .title " to _uM("paddingTop" to 1, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#C78300", "borderRightColor" to "#C78300", "borderBottomColor" to "#C78300", "borderLeftColor" to "#C78300", "fontWeight" to "bold", "fontSize" to 14, "color" to "#C78300")), "info-item" to _uM(".car-info-item .right-box " to _uM("flexDirection" to "row", "paddingTop" to 4, "paddingRight" to 0, "paddingBottom" to 4, "paddingLeft" to 0, "boxSizing" to "border-box")), "btn-group" to _uM(".car-info-item .right-box " to _uM("paddingTop" to 5, "paddingBottom" to 3, "paddingRight" to 5, "boxSizing" to "border-box", "flexDirection" to "row", "justifyContent" to "flex-end")), "btn-group-panel" to _pS(_uM("position" to "fixed", "bottom" to 0, "left" to 0, "right" to 0, "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "tag_card-header" to _pS(_uM("paddingBottom" to "20rpx")), "tag-card-item" to _uM(".tag-card-list " to _uM("backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "marginBottom" to "30rpx")), "del-btn" to _uM(".tag-card-list .tag-card-item " to _uM("paddingTop" to 0, "paddingRight" to "18rpx", "paddingBottom" to 0, "paddingLeft" to "18rpx", "alignContent" to "center")), "tag-picker" to _uM(".tag-card-list .tag-card-item " to _uM("flex" to 1, "paddingTop" to "25rpx", "paddingRight" to "25rpx", "paddingBottom" to "25rpx", "paddingLeft" to "25rpx")), "number-input" to _uM(".tag-card-list .tag-card-item .tag-picker " to _uM("borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#90A2C7", "borderRightColor" to "#90A2C7", "borderBottomColor" to "#90A2C7", "borderLeftColor" to "#90A2C7", "textAlign" to "center", "paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "color" to "#4D669A", "fontWeight" to "bold"), ".tag-card-list .tag-card-item .price-input " to _uM("borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#90A2C7", "borderRightColor" to "#90A2C7", "borderBottomColor" to "#90A2C7", "borderLeftColor" to "#90A2C7", "textAlign" to "center", "paddingTop" to "10rpx", "paddingRight" to 0, "paddingBottom" to "10rpx", "paddingLeft" to 0, "color" to "#4D669A", "fontWeight" to "bold")), "picker-picker" to _uM(".tag-card-list .tag-card-item .tag-picker " to _uM("height" to "74rpx", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#90A2C7", "borderRightColor" to "#90A2C7", "borderBottomColor" to "#90A2C7", "borderLeftColor" to "#90A2C7")), "price-input" to _uM(".tag-card-list .tag-card-item " to _uM("flex" to 1, "paddingTop" to "25rpx", "paddingRight" to "25rpx", "paddingBottom" to "25rpx", "paddingLeft" to 0)), "button-group" to _pS(_uM("flex" to 1, "position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "flexDirection" to "row", "justifyContent" to "space-between", "paddingTop" to "20rpx", "paddingLeft" to "20rpx", "paddingRight" to "20rpx", "width" to "100%", "backgroundColor" to "#ffffff", "zIndex" to 100)), "btn-review" to _pS(_uM("width" to "49%", "paddingTop" to 2, "paddingRight" to 0, "paddingBottom" to 2, "paddingLeft" to 0, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "fontSize" to 18, "boxShadow" to "0px 5px 10px 0px rgba(0, 0, 0, 0.2)", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#4A6295", "borderRightColor" to "#4A6295", "borderBottomColor" to "#4A6295", "borderLeftColor" to "#4A6295", "marginRight" to 20)), "btn-save" to _pS(_uM("width" to "49%", "paddingTop" to 2, "paddingRight" to 0, "paddingBottom" to 2, "paddingLeft" to 0, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "fontSize" to 18, "boxShadow" to "0px 5px 10px 0px rgba(0, 0, 0, 0.2)", "color" to "#ffffff", "marginLeft" to 20)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
