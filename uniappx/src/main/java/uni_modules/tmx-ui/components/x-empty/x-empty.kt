@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI09580B7
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
open class GenUniModulesTmxUiComponentsXEmptyXEmpty : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_loading = resolveEasyComponent("x-loading", GenUniModulesTmxUiComponentsXLoadingXLoadingClass)
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass)
        val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass)
        return createElementVNode("view", utsMapOf("class" to "xEmpty"), utsArrayOf(
            if (isTrue(_ctx._loading)) {
                createVNode(_component_x_loading, utsMapOf("key" to 0))
            } else {
                createCommentVNode("v-if", true)
            }
            ,
            if (isTrue(!_ctx._loading && !_ctx._more && (_ctx._empty || _ctx._error))) {
                createElementVNode("view", utsMapOf("key" to 1, "class" to "xEmptyWrap"), utsArrayOf(
                    createElementVNode("image", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "200px", "height" to "200px")), "src" to _ctx.src), null, 12, utsArrayOf(
                        "src"
                    )),
                    if (isTrue(_ctx._empty)) {
                        createVNode(_component_x_text, utsMapOf("key" to 0, "font-size" to "16", "style" to normalizeStyle(utsMapOf("opacity" to "0.5"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                toDisplayString(_ctx._title)
                            )
                        }), "_" to 1), 8, utsArrayOf(
                            "style"
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    },
                    if (isTrue(_ctx._error)) {
                        createVNode(_component_x_text, utsMapOf("key" to 1, "font-size" to "16", "style" to normalizeStyle(utsMapOf("opacity" to "0.5"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                toDisplayString(_ctx._errorLabel)
                            )
                        }), "_" to 1), 8, utsArrayOf(
                            "style"
                        ))
                    } else {
                        createCommentVNode("v-if", true)
                    },
                    renderSlot(_ctx.`$slots`, "default", UTSJSONObject(), fun(): UTSArray<Any> {
                        return utsArrayOf(
                            if (isTrue(_ctx._showBtn)) {
                                createElementVNode("view", utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("padding-top" to "21px"))), utsArrayOf(
                                    createVNode(_component_x_button, utsMapOf("onClick" to _ctx.onclick, "width" to "150px", "color" to _ctx._btnColor, "font-color" to _ctx._btnTextColor), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            toDisplayString(_ctx._btnLabel)
                                        )
                                    }), "_" to 1), 8, utsArrayOf(
                                        "onClick",
                                        "color",
                                        "font-color"
                                    ))
                                ), 4)
                            } else {
                                createCommentVNode("v-if", true)
                            }
                        )
                    })
                ))
            } else {
                createCommentVNode("v-if", true)
            }
            ,
            if (isTrue(_ctx._more && !_ctx._loading && !_ctx._error && !_ctx._empty)) {
                createVNode(_component_x_text, utsMapOf("key" to 2, "font-size" to "16", "style" to normalizeStyle(utsMapOf("padding" to "16px", "opacity" to "0.5"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        toDisplayString(_ctx._moreLabel)
                    )
                }), "_" to 1), 8, utsArrayOf(
                    "style"
                ))
            } else {
                createCommentVNode("v-if", true)
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
        return utsMapOf("_showBtn" to computed<Boolean>(fun(): Boolean {
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
            return this.moreLabel
        }
        ), "_errorLabel" to computed<String>(fun(): String {
            return this.errorLabel
        }
        ), "_btnLabel" to computed<String>(fun(): String {
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
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xEmpty" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center", "marginTop" to 16, "marginRight" to 0, "marginBottom" to 16, "marginLeft" to 0)), "xEmptyWrap" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf("click" to null)
        var props = normalizePropsOptions(utsMapOf("loading" to utsMapOf("type" to "Boolean", "default" to true), "empty" to utsMapOf("type" to "Boolean", "default" to false), "error" to utsMapOf("type" to "Boolean", "default" to false), "more" to utsMapOf("type" to "Boolean", "default" to false), "moreLabel" to utsMapOf("type" to "String", "default" to "没有更多数据啦"), "errorLabel" to utsMapOf("type" to "String", "default" to "出错啦~"), "btnLabel" to utsMapOf("type" to "String", "default" to "点击重试"), "btnColor" to utsMapOf("type" to "String", "default" to ""), "btnTextColor" to utsMapOf("type" to "String", "default" to ""), "title" to utsMapOf("type" to "String", "default" to "当前没有数据"), "src" to utsMapOf("type" to "String", "default" to "/static/tmui4xLibs/static/empty.png"), "showBtn" to utsMapOf("type" to "Boolean", "default" to true)))
        var propsNeedCastKeys = utsArrayOf(
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
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
