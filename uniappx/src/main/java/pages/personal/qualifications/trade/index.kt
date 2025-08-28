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
open class GenPagesPersonalQualificationsTradeIndex : BasePage {
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
        var setup: (__props: GenPagesPersonalQualificationsTradeIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesPersonalQualificationsTradeIndex
            val _cache = __ins.renderCache
            val globalData = inject("globalData") as GlobalDataType
            val formData = reactive<UTSJSONObject>(object : UTSJSONObject() {
                var businessLicense = ""
                var qualificationPhoto = ""
            })
            val entryModeStr = ref<String>("-")
            fun gen_feedbackDetail_fn() {
                getDriverOperatingQualification().then(fun(res: Response){
                    if (res.code == 200 && res.data != null) {
                        val data = res.data as UTSJSONObject
                        val companyName = data.getString("companyName")
                        formData["businessLicense"] = data.getString("businessLicense")
                        formData["qualificationPhoto"] = data.getString("qualificationPhoto")
                        entryModeStr.value = companyName ?: ""
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
            return fun(): Any? {
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
                val _component_x_form_item = resolveEasyComponent("x-form-item", GenUniModulesTmxUiComponentsXFormItemXFormItemClass)
                val _component_x_image = resolveEasyComponent("x-image", GenUniModulesTmxUiComponentsXImageXImageClass)
                val _component_mc_base_container = resolveEasyComponent("mc-base-container", GenComponentsMcBaseContainerIndexClass)
                return _cV(_component_mc_base_container, _uM("title" to "营运资质", "style" to _nS(_uM("background-image" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "home-bg"), _uA(
                            _cE("view", _uM("class" to "top-bg"))
                        )),
                        _cE("view", _uM("class" to "approve-info-container", "style" to _nS("height: " + unref(screenHeight) + "px;")), _uA(
                            _cE("view", _uM("class" to "info-section"), _uA(
                                _cE("view", _uM("class" to "section-title"), _uA(
                                    _cE("view", _uM("class" to "title-bar")),
                                    _cE("text", _uM("class" to "title-text"), "基础信息")
                                )),
                                _cE("view", _uM("class" to "info-form"), _uA(
                                    _cV(_component_x_form_item, _uM("label" to "公司名称", "labelFontColor" to "#000000"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_x_text, _uM("color" to "#6C6C6C", "style" to _nS(_uM("text-align" to "right")), "lines" to 2, "font-size" to "28rpx"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(entryModeStr.value)
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "style"
                                            ))
                                        )
                                    }
                                    ), "_" to 1))
                                )),
                                _cE("view", _uM("class" to "upload-container", "style" to _nS(_uM<String, Any?>())), _uA(
                                    _cE("view", _uM("class" to "upload-item"), _uA(
                                        _cE("view", _uM("class" to "upload-box"), _uA(
                                            if (isTrue(unref(formData)["businessLicense"])) {
                                                _cV(_component_x_image, _uM("key" to 0, "class" to "uploaded-image", "src" to unref(formData)["businessLicense"], "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                ))
                                            } else {
                                                _cE("image", _uM("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/brand-business.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                ))
                                            }
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "upload-item"), _uA(
                                        _cE("view", _uM("class" to "upload-box"), _uA(
                                            if (isTrue(unref(formData)["qualificationPhoto"])) {
                                                _cV(_component_x_image, _uM("key" to 0, "class" to "uploaded-image", "src" to unref(formData)["qualificationPhoto"], "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                ))
                                            } else {
                                                _cE("image", _uM("key" to 1, "class" to "upload-icon", "src" to ("" + unref(resBaseUrl) + "/static/images/brand-qualifications.png"), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                ))
                                            }
                                        ))
                                    ))
                                ), 4)
                            ))
                        ), 4)
                    )
                }
                ), "_" to 1), 8, _uA(
                    "style"
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
                return _uM("home-bg" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "zIndex" to -1, "height" to "100%")), "top-bg" to _uM(".home-bg " to _uM("height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #CAD7F2, #FFFFFF)")), "approve-info-container" to _pS(_uM("height" to "100%", "paddingTop" to "30rpx", "paddingBottom" to "200rpx")), "info-section" to _pS(_uM("borderTopLeftRadius" to "12rpx", "borderTopRightRadius" to "12rpx", "borderBottomRightRadius" to "12rpx", "borderBottomLeftRadius" to "12rpx", "marginTop" to 0, "marginRight" to "20rpx", "marginBottom" to "20rpx", "marginLeft" to "20rpx", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "20rpx", "paddingLeft" to "20rpx")), "section-title" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "marginBottom" to "20rpx")), "title-bar" to _pS(_uM("width" to "6rpx", "height" to "30rpx", "backgroundColor" to "#536FA6", "marginRight" to "10rpx")), "title-text" to _pS(_uM("fontSize" to "32rpx", "fontWeight" to "bold", "color" to "#000000")), "info-form" to _pS(_uM("width" to "100%", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "backgroundColor" to "#FFFFFF", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx")), "form-item" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to "30rpx", "paddingRight" to 0, "paddingBottom" to "30rpx", "paddingLeft" to 0, "borderBottomWidth:last-child" to "medium", "borderBottomStyle:last-child" to "none", "borderBottomColor:last-child" to "#000000")), "upload-container" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to "10rpx")), "upload-item" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "width" to "48%")), "upload-box" to _pS(_uM("width" to "100%", "height" to 120, "display" to "flex", "justifyContent" to "center", "alignItems" to "center")), "upload-icon" to _pS(_uM("width" to "100%", "height" to "99%")), "uploaded-image" to _pS(_uM("width" to "100%", "height" to "100%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
