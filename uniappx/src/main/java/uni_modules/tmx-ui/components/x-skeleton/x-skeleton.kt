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
open class GenUniModulesTmxUiComponentsXSkeletonXSkeleton : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            var t = this
            this.tid = setTimeout(fun() {
                t.myopacity = 0
            }
            , 300)
        }
        , __ins)
        onBeforeUnmount(fun() {
            clearTimeout(this.tid)
        }
        , __ins)
        onActivated(fun() {}, __ins)
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", _uM("ref" to "xSkeleton", "class" to "xSkeleton", "onTransitionend" to _ctx.animationEnd, "style" to _nS(_uM("backgroundColor" to _ctx._color, "width" to _ctx._width, "height" to _ctx._height, "borderRadius" to _ctx._round, "opacity" to _ctx.myopacity, "transitionDuration" to _ctx.duration))), null, 44, _uA(
            "onTransitionend"
        ))
    }
    open var height: String by `$props`
    open var width: String by `$props`
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var round: String by `$props`
    open var duration: String by `$props`
    open var myopacity: Number by `$data`
    open var tid: Number by `$data`
    open var _width: String by `$data`
    open var _height: String by `$data`
    open var _round: String by `$data`
    open var _color: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("myopacity" to 1, "tid" to 0, "_width" to computed<String>(fun(): String {
            return checkIsCssUnit(this.width, xConfig.unit)
        }
        ), "_height" to computed<String>(fun(): String {
            return checkIsCssUnit(this.height, xConfig.unit)
        }
        ), "_round" to computed<String>(fun(): String {
            return checkIsCssUnit(this.round, xConfig.unit)
        }
        ), "_color" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                return getDefaultColor(this.darkColor)
            }
            return getDefaultColor(this.color)
        }
        ))
    }
    open var animationEnd = ::gen_animationEnd_fn
    open fun gen_animationEnd_fn() {
        this.myopacity = if (this.myopacity == 1) {
            0
        } else {
            1
        }
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xSkeleton" to _pS(_uM("transitionTimingFunction" to "linear", "transitionProperty" to "opacity")), "@TRANSITION" to _uM("xSkeleton" to _uM("timingFunction" to "linear", "property" to "opacity")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("height" to _uM("type" to "String", "default" to "12"), "width" to _uM("type" to "String", "default" to "auto"), "color" to _uM("type" to "String", "default" to "#e4e4e4"), "darkColor" to _uM("type" to "String", "default" to "#323232"), "round" to _uM("type" to "String", "default" to "3"), "duration" to _uM("type" to "String", "default" to "900ms")))
        var propsNeedCastKeys = _uA(
            "height",
            "width",
            "color",
            "darkColor",
            "round",
            "duration"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
