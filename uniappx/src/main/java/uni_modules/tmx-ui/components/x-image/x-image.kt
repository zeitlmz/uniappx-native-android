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
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
import io.dcloud.uniapp.extapi.getImageInfo as uni_getImageInfo
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.previewImage as uni_previewImage
open class GenUniModulesTmxUiComponentsXImageXImage : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            var t = this
            this.imgLoad()
            var ele = uni_getElementById(this.idBox!!)
            if (ele == null) {
                return
            }
            if (this.resizeObserver == null) {
                this.resizeObserver = UniResizeObserver(fun(entries: UTSArray<UniResizeObserverEntry>){
                    entries.forEach(fun(entry){
                        if (entry.target == ele) {
                            t.tid = setTimeout(fun() {
                                t.getNodes()
                            }
                            , 50)
                        }
                    }
                    )
                }
                )
            }
            this.resizeObserver!!.observe(ele!!)
            t.tid = setTimeout(fun() {
                t.getNodes()
            }
            , 50)
            this.setIsVisibledShow()
        }
        , __ins)
        onBeforeUnmount(fun() {
            clearTimeout(this.tid)
            clearTimeout(this.tid2)
            this.resizeObserver?.disconnect()
        }
        , __ins)
        onUpdated(fun() {}, __ins)
        this.`$watch`(fun(): Any? {
            return this.src
        }
        , fun() {
            this.imgLoad()
        }
        )
        this.`$watch`(fun(): Any? {
            return this._scrollTop
        }
        , fun() {
            if (!this.lazy) {
                return
            }
            clearTimeout(this.tid2)
            var t = this
            this.tid2 = setTimeout(fun() {
                t.setIsVisibledShow()
            }
            , 10)
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass)
        return _cE("view", _uM("key" to _ctx.keyidsf, "onClick" to _ctx.prevImage, "class" to "xImage", "ref" to "xImage", "id" to _ctx.idBox, "style" to _nS(_uM("width" to _ctx._place_size.width, "height" to _ctx._place_size.height))), _uA(
            _cE("view", _uM("class" to "xImageBox", "style" to _nS(_uM("width" to _ctx._img_box_size.width, "height" to _ctx._img_box_size.height, "borderRadius" to _ctx._round, "pointerEvent" to "none"))), _uA(
                if (isTrue(_ctx.isLoading)) {
                    renderSlot(_ctx.`$slots`, "loading", _uM("key" to 0), fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "xImagePlace", "style" to _nS(_uM("backgroundColor" to _ctx._placeBgColor))), _uA(
                                if (isTrue(_ctx.isLoading)) {
                                    _cV(_component_x_icon, _uM("key" to 0, "font-size" to _ctx.iconSize, "name" to "loader-2-line", "color" to "primary", "spin" to true), null, 8, _uA(
                                        "font-size"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ), 4)
                        )
                    })
                } else {
                    _cC("v-if", true)
                }
                ,
                if (isTrue(_ctx.isError)) {
                    renderSlot(_ctx.`$slots`, "error", _uM("key" to 1), fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "xImagePlace", "style" to _nS(_uM("backgroundColor" to _ctx._placeBgColor))), _uA(
                                if (isTrue(_ctx.isError)) {
                                    _cV(_component_x_icon, _uM("key" to 0, "font-size" to _ctx.iconSize, "color" to "error", "name" to "landscape-line"), null, 8, _uA(
                                        "font-size"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ), 4)
                        )
                    })
                } else {
                    _cC("v-if", true)
                }
                ,
                if (isTrue(!_ctx.isError)) {
                    _cE("image", _uM("key" to 2, "fade-show" to _ctx.fadeShow, "class" to _nC(_uA(
                        "xImageImg",
                        _uA(
                            if (_ctx.isLoading) {
                                "xImageImgAbs"
                            } else {
                                ""
                            }
                        )
                    )), "mode" to _ctx._model, "style" to _nS(_uA(
                        _ctx._styleMap,
                        _uM("visibility" to if (_ctx.isVisibled || !_ctx.lazy) {
                            "visible"
                        } else {
                            "hidden"
                        })
                    )), "src" to _ctx._src), null, 14, _uA(
                        "fade-show",
                        "mode",
                        "src"
                    ))
                } else {
                    _cC("v-if", true)
                }
            ), 4)
        ), 12, _uA(
            "onClick",
            "id"
        ))
    }
    open var width: String by `$props`
    open var height: String by `$props`
    open var src: String by `$props`
    open var previewSrc: String by `$props`
    open var model: String by `$props`
    open var preview: Boolean by `$props`
    open var ratio: Number by `$props`
    open var round: String by `$props`
    open var iconSize: String by `$props`
    open var placeBgColor: String by `$props`
    open var placeDarkBgColor: String by `$props`
    open var fadeShow: Boolean by `$props`
    open var lazy: Boolean by `$props`
    open var id: String by `$data`
    open var idBox: String by `$data`
    open var isLoading: Boolean by `$data`
    open var isError: Boolean by `$data`
    open var reload: Number by `$data`
    open var imgrealWidth: Number by `$data`
    open var imgrealHeight: Number by `$data`
    open var boxWidth: Number by `$data`
    open var boxHeight: Number by `$data`
    open var ratioWidth: Number by `$data`
    open var ratioHeight: Number by `$data`
    open var isLoaded: Boolean by `$data`
    open var tid: Number by `$data`
    open var resizeObserver: UniResizeObserver? by `$data`
    open var androidAndWebUrl: String by `$data`
    open var dateTime: Number by `$data`
    open var _x: Number by `$data`
    open var _y: Number by `$data`
    open var boxLeft: Number by `$data`
    open var boxTop: Number by `$data`
    open var isVisibled: Boolean by `$data`
    open var tid2: Number by `$data`
    open var keyidsf: Number by `$data`
    open var _model: String by `$data`
    open var _placeBgColor: String by `$data`
    open var _round: String by `$data`
    open var _src: String by `$data`
    open var _previewSrc: String by `$data`
    open var _place_size: IMG_SIZE_INFO_PLACE by `$data`
    open var _scrollTop: Number by `$data`
    open var _img_box_size: IMG_SIZE_INFO_PLACE by `$data`
    open var _img_size: IMG_SIZE_INFO_PLACE by `$data`
    open var _styleMap: Map<String, String> by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("id" to ("xImage-" + getUid()) as String, "idBox" to ("xImage-" + getUid()) as String, "isLoading" to true, "isError" to false, "reload" to 0, "imgrealWidth" to 0, "imgrealHeight" to 0, "boxWidth" to 0, "boxHeight" to 0, "ratioWidth" to 0, "ratioHeight" to 0, "isLoaded" to false, "tid" to 0, "resizeObserver" to null as UniResizeObserver?, "androidAndWebUrl" to "", "dateTime" to 0, "_x" to 0, "_y" to 0, "boxLeft" to 0, "boxTop" to 0, "isVisibled" to false, "tid2" to 0, "keyidsf" to 0, "_model" to computed<String>(fun(): String {
            return this.model
        }
        ), "_placeBgColor" to computed<String>(fun(): String {
            var bgcolor = this.placeBgColor
            if (xConfig.dark == "dark") {
                bgcolor = this.placeDarkBgColor
                if (this.placeDarkBgColor == "") {
                    bgcolor = xConfig.inputDarkColor
                }
            }
            return getDefaultColor(bgcolor)
        }
        ), "_round" to computed<String>(fun(): String {
            return checkIsCssUnit(this.round, xConfig.unit)
        }
        ), "_src" to computed<String>(fun(): String {
            return this.src
        }
        ), "_previewSrc" to computed<String>(fun(): String {
            if (this.previewSrc == "") {
                return this.src
            }
            return this.previewSrc
        }
        ), "_place_size" to computed<IMG_SIZE_INFO_PLACE>(fun(): IMG_SIZE_INFO_PLACE {
            return IMG_SIZE_INFO_PLACE(width = checkIsCssUnit(this.width, xConfig.unit), height = checkIsCssUnit(this.height, xConfig.unit))
        }
        ), "_scrollTop" to computed<Number>(fun(): Number {
            return xProvitae.scrollTop
        }
        ), "_img_box_size" to computed<IMG_SIZE_INFO_PLACE>(fun(): IMG_SIZE_INFO_PLACE {
            if (this.imgrealHeight > 0) {
                return this._img_size
            }
            var _w = this.width
            var _h = this.height
            var us_w = checkIsCssUnit(this.width, xConfig.unit)
            var us_h = checkIsCssUnit(this.height, xConfig.unit)
            if (this.width.lastIndexOf("%") > -1 || this.width == "auto") {
                us_w = "100%"
                _w = "100%"
            }
            if (this.height.lastIndexOf("%") > -1 || this.height == "auto" || this.isError) {
                if (this.boxHeight >= 5) {
                    _h = this.boxHeight.toString(10) + "px"
                } else {
                    if (this.width.lastIndexOf("%") > -1 || this.width == "auto") {
                        if (this.height == "100%") {
                            _h = (this.ratio * this.boxHeight).toString(10) + "px"
                        } else {
                            _h = (this.ratio * this.boxWidth).toString(10) + "px"
                        }
                    } else {
                        _h = (this.ratio * parseFloat(us_w)).toString(10) + getUnit(us_w)
                    }
                }
                return IMG_SIZE_INFO_PLACE(width = _w, height = _h)
            }
            return IMG_SIZE_INFO_PLACE(width = us_w, height = us_h)
        }
        ), "_img_size" to computed<IMG_SIZE_INFO_PLACE>(fun(): IMG_SIZE_INFO_PLACE {
            var us_w = checkIsCssUnit(this.width, xConfig.unit)
            var us_h = checkIsCssUnit(this.height, xConfig.unit)
            if (!this.isLoaded) {
                return IMG_SIZE_INFO_PLACE(width = "300px", height = "300px")
            }
            if (this.boxWidth > 0) {
                var ratio = this.boxWidth / this.imgrealWidth
                if ((this.height == "auto")) {
                    us_h = (ratio * this.imgrealHeight).toString(10) + "px"
                }
                if ((this.width == "auto")) {
                    us_w = this.boxWidth.toString(10) + "px"
                }
                if ((this.height.lastIndexOf("%") > -1)) {
                    us_h = this.boxHeight.toString(10) + "px"
                }
                if ((this.width.lastIndexOf("%") > -1)) {
                    us_w = this.boxWidth.toString(10) + "px"
                }
            }
            return IMG_SIZE_INFO_PLACE(width = us_w, height = us_h)
        }
        ), "_styleMap" to computed<Map<String, String>>(fun(): Map<String, String> {
            var styleMap = Map<String, String>()
            styleMap.set("width", this._img_size.width)
            styleMap.set("height", this._img_size.height)
            styleMap.set("transform", if (this.isLoading) {
                "scale(0.1)"
            } else {
                "scale(1)"
            }
            )
            styleMap.set("visibility", if (this.isLoading) {
                "visible"
            } else {
                if (!this.isError) {
                    "visible"
                } else {
                    "hidden"
                }
            }
            )
            styleMap.set("opacity", if (this.isLoading) {
                "0"
            } else {
                "1"
            }
            )
            styleMap.set("border-raiuds", this._round)
            return styleMap
        }
        ))
    }
    open var setIsVisibledShow = ::gen_setIsVisibledShow_fn
    open fun gen_setIsVisibledShow_fn() {
        var win = uni_getWindowInfo()
        var t = this
        uni_createSelectorQuery().`in`(this).select(".xImage").boundingClientRect().exec(fun(ret){
            var nodeinfo = ret[0] as NodeInfo
            var winHeight = win.windowHeight
            var eleTop = nodeinfo.top!!
            var eleBotom = nodeinfo.bottom!!
            t.isVisibled = if (eleBotom < 0 || eleTop > winHeight) {
                false
            } else {
                true
            }
        }
        )
    }
    open var prevImage = ::gen_prevImage_fn
    open fun gen_prevImage_fn() {
        this.`$emit`("click")
        if (this.preview) {
            uni_previewImage(PreviewImageOptions(current = this._previewSrc, urls = _uA(
                this._previewSrc
            )))
        }
    }
    open var imgLoad2 = ::gen_imgLoad2_fn
    open fun gen_imgLoad2_fn(evt: ImageLoadEvent) {
        this.imgrealWidth = evt.detail.width
        this.imgrealHeight = evt.detail.height
        this.isLoading = false
        this.androidAndWebUrl = this._src
        this.isError = false
        this.isLoaded = true
    }
    open var imgLoad = ::gen_imgLoad_fn
    open fun gen_imgLoad_fn() {
        var t = this
        uni_getImageInfo(GetImageInfoOptions(src = this._src, fail = fun(error: IMediaError) {
            console.log("error", error.errMsg)
            t.isError = true
            t.isLoading = false
        }
        , success = fun(result: GetImageInfoSuccess) {
            t.isLoading = false
            t.isError = false
            t.isLoaded = true
            if (result.path != t.androidAndWebUrl) {
                t.imgrealWidth = result.width
                t.imgrealHeight = result.height
                t.androidAndWebUrl = result.path
                t.keyidsf += 1
            }
        }
        ))
    }
    open var imgError = ::gen_imgError_fn
    open fun gen_imgError_fn() {
        this.isError = true
        this.isLoading = false
    }
    open var getNodes = ::gen_getNodes_fn
    open fun gen_getNodes_fn() {
        var t = this
        uni_createSelectorQuery().`in`(this).select(".xImage").boundingClientRect().exec(fun(ret){
            var nodeinfo = ret[0] as NodeInfo
            t.boxWidth = nodeinfo.width!!
            t.boxHeight = nodeinfo.height!!
        }
        )
    }
    open var resize = ::gen_resize_fn
    open fun gen_resize_fn() {
        this.isLoaded = false
        var t = this
        uni_createSelectorQuery().`in`(this).select(".xImage").boundingClientRect().exec(fun(ret){
            var nodeinfo = ret[0] as NodeInfo
            t.boxWidth = nodeinfo.width!!
            t.boxHeight = nodeinfo.height!!
            t.isLoaded = true
        }
        )
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xImage" to _pS(_uM("position" to "relative", "overflow" to "hidden")), "xImageBox" to _pS(_uM("pointerEvents" to "none")), "xImagePlace" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "width" to "100%", "height" to "100%")), "xImageImgAbs" to _pS(_uM("position" to "absolute", "pointerEvents" to "none")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM("width" to _uM("type" to "String", "default" to "100%"), "height" to _uM("type" to "String", "default" to "auto"), "src" to _uM("type" to "String", "default" to ""), "previewSrc" to _uM("type" to "String", "default" to ""), "model" to _uM("type" to "String", "default" to "fill"), "preview" to _uM("type" to "Boolean", "default" to true), "ratio" to _uM("type" to "Number", "default" to 1.25), "round" to _uM("type" to "String", "default" to "0"), "iconSize" to _uM("type" to "String", "default" to "16"), "placeBgColor" to _uM("type" to "String", "default" to "#F5F5F5"), "placeDarkBgColor" to _uM("type" to "String", "default" to ""), "fadeShow" to _uM("type" to "Boolean", "default" to false), "lazy" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "width",
            "height",
            "src",
            "previewSrc",
            "model",
            "preview",
            "ratio",
            "round",
            "iconSize",
            "placeBgColor",
            "placeDarkBgColor",
            "fadeShow",
            "lazy"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
