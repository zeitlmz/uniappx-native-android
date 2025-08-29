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
open class GenComponentsMcEnvTagIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsMcEnvTagIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsMcEnvTagIndex
            val _cache = __ins.renderCache
            val envs: Envs = Envs(dev = EnvOption(name = "dev", color = "#00c240", desc = "开发"), pre = EnvOption(name = "pre", color = "#c28b00", desc = "预生产"), prod = EnvOption(name = "test", color = "#cc182b", desc = "正式"))
            val currentEnv = computed(fun(): EnvOption {
                var envOption = envs.dev
                if (BaseApiStore.currentEnvType == 0) {
                    envOption = envs.pre
                } else if (BaseApiStore.currentEnvType == 1) {
                    envOption = envs.pre
                }
                return envOption
            }
            )
            return fun(): Any? {
                return _cE("view")
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("env-box" to _pS(_uM("position" to "fixed", "display" to "flex", "alignItems" to "center", "cursor" to "pointer", "bottom" to "-30rpx", "right" to "-85rpx", "width" to "200rpx", "height" to "100rpx", "opacity" to 0.5, "transform" to "rotateZ(-45deg)")), "text" to _uM(".env-box " to _uM("color" to "#FFFFFF", "fontSize" to "26rpx", "marginTop" to "5rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
