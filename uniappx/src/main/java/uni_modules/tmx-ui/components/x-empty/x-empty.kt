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
open class GenUniModulesTmxUiComponentsXEmptyXEmpty : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_loading = resolveEasyComponent("x-loading", GenUniModulesTmxUiComponentsXLoadingXLoadingClass)
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
        val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass)
        return _cE("view", _uM("class" to "xEmpty"), _uA(
            if (isTrue(_ctx._loading)) {
                _cV(_component_x_loading, _uM("key" to 0))
            } else {
                _cC("v-if", true)
            }
            ,
            if (isTrue(!_ctx._loading && !_ctx._more && (_ctx._empty || _ctx._error))) {
                _cE("view", _uM("key" to 1, "class" to "xEmptyWrap"), _uA(
                    _cE("image", _uM("style" to _nS(_uM("width" to "200px", "height" to "200px")), "src" to _ctx.src), null, 12, _uA(
                        "src"
                    )),
                    if (isTrue(_ctx._empty)) {
                        _cV(_component_x_text, _uM("key" to 0, "font-size" to "16", "style" to _nS(_uM("opacity" to "0.5"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _tD(_ctx._title)
                            )
                        }), "_" to 1), 8, _uA(
                            "style"
                        ))
                    } else {
                        _cC("v-if", true)
                    },
                    if (isTrue(_ctx._error)) {
                        _cV(_component_x_text, _uM("key" to 1, "font-size" to "16", "style" to _nS(_uM("opacity" to "0.5"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _tD(_ctx._errorLabel)
                            )
                        }), "_" to 1), 8, _uA(
                            "style"
                        ))
                    } else {
                        _cC("v-if", true)
                    },
                    renderSlot(_ctx.`$slots`, "default", UTSJSONObject(), fun(): UTSArray<Any> {
                        return _uA(
                            if (isTrue(_ctx._showBtn)) {
                                _cE("view", _uM("key" to 0, "style" to _nS(_uM("padding-top" to "21px"))), _uA(
                                    _cV(_component_x_button, _uM("onClick" to _ctx.onclick, "width" to "150px", "color" to _ctx._btnColor, "font-color" to _ctx._btnTextColor), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(_ctx._btnLabel)
                                        )
                                    }), "_" to 1), 8, _uA(
                                        "onClick",
                                        "color",
                                        "font-color"
                                    ))
                                ), 4)
                            } else {
                                _cC("v-if", true)
                            }
                        )
                    })
                ))
            } else {
                _cC("v-if", true)
            }
            ,
            if (isTrue(_ctx._more && !_ctx._loading && !_ctx._error && !_ctx._empty)) {
                _cV(_component_x_text, _uM("key" to 2, "font-size" to "16", "style" to _nS(_uM("padding" to "16px", "opacity" to "0.5"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _tD(_ctx._moreLabel)
                    )
                }), "_" to 1), 8, _uA(
                    "style"
                ))
            } else {
                _cC("v-if", true)
            }
        ))
    }
    open var loading: Boolean by `$props`
    open var empty: Boolean by `$props`
    open var error: Boolean by `$props`
    open var more: Boolean by `$props`
    open var moreLabel: String by `$props`
    open var errorLabel: String by `$props`
    open var btnLabel: String by `$props`
    open var btnColor: String by `$props`
    open var btnTextColor: String by `$props`
    open var title: String by `$props`
    open var src: String by `$props`
    open var showBtn: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var _showBtn: Boolean by `$data`
    open var _loading: Boolean by `$data`
    open var _error: Boolean by `$data`
    open var _more: Boolean by `$data`
    open var _empty: Boolean by `$data`
    open var _moreLabel: String by `$data`
    open var _errorLabel: String by `$data`
    open var _btnLabel: String by `$data`
    open var _btnColor: String by `$data`
    open var _btnTextColor: String by `$data`
    open var _title: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "_showBtn" to computed<Boolean>(fun(): Boolean {
            return this.showBtn
        }
        ), "_loading" to computed<Boolean>(fun(): Boolean {
            return this.loading
        }
        ), "_error" to computed<Boolean>(fun(): Boolean {
            return this.error
        }
        ), "_more" to computed<Boolean>(fun(): Boolean {
            return this.more
        }
        ), "_empty" to computed<Boolean>(fun(): Boolean {
            return this.empty
        }
        ), "_moreLabel" to computed<String>(fun(): String {
            if (this.moreLabel == "") {
                return this!!.i18n.t("tmui4x.empty.moreLabel")
            }
            return this.moreLabel
        }
        ), "_errorLabel" to computed<String>(fun(): String {
            if (this.errorLabel == "") {
                return this!!.i18n.t("tmui4x.empty.errorLabel")
            }
            return this.errorLabel
        }
        ), "_btnLabel" to computed<String>(fun(): String {
            if (this.btnLabel == "") {
                return this!!.i18n.t("tmui4x.empty.btnLabel")
            }
            return this.btnLabel
        }
        ), "_btnColor" to computed<String>(fun(): String {
            if (this.btnColor == "") {
                return getDefaultColor(xConfig.color)
            }
            return getDefaultColor(this.btnColor)
        }
        ), "_btnTextColor" to computed<String>(fun(): String {
            return getDefaultColor(this.btnTextColor)
        }
        ), "_title" to computed<String>(fun(): String {
            if (this.title == "") {
                return this!!.i18n.t("tmui4x.empty.title")
            }
            return this.title
        }
        ))
    }
    open var onclick = ::gen_onclick_fn
    open fun gen_onclick_fn() {
        this.`$emit`("click")
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xEmpty" to _pS(_uM("display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center", "marginTop" to 16, "marginRight" to 0, "marginBottom" to 16, "marginLeft" to 0)), "xEmptyWrap" to _pS(_uM("display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM("loading" to _uM("type" to "Boolean", "default" to true), "empty" to _uM("type" to "Boolean", "default" to false), "error" to _uM("type" to "Boolean", "default" to false), "more" to _uM("type" to "Boolean", "default" to false), "moreLabel" to _uM("type" to "String", "default" to ""), "errorLabel" to _uM("type" to "String", "default" to ""), "btnLabel" to _uM("type" to "String", "default" to ""), "btnColor" to _uM("type" to "String", "default" to ""), "btnTextColor" to _uM("type" to "String", "default" to ""), "title" to _uM("type" to "String", "default" to ""), "src" to _uM("type" to "String", "default" to "/static/tmui4xLibs/static/empty.png"), "showBtn" to _uM("type" to "Boolean", "default" to true)))
        var propsNeedCastKeys = _uA(
            "loading",
            "empty",
            "error",
            "more",
            "moreLabel",
            "errorLabel",
            "btnLabel",
            "btnColor",
            "btnTextColor",
            "title",
            "src",
            "showBtn"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
