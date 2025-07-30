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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
open class GenComponentsMcEnvTagIndex : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsMcEnvTagIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsMcEnvTagIndex
            val _cache = __ins.renderCache
            val viewBaseUrl = fun(){
                showTips(BaseApiStore.baseUrl, "success")
            }
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
                return createElementVNode("view", utsMapOf("class" to "env-box", "onClick" to viewBaseUrl, "style" to normalizeStyle("background-color: " + unref(currentEnv).color + ";")), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "text"), toDisplayString(unref(currentEnv).desc), 1)
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("env-box" to padStyleMapOf(utsMapOf("position" to "fixed", "display" to "flex", "alignItems" to "center", "cursor" to "pointer", "bottom" to "-30rpx", "right" to "-85rpx", "width" to "200rpx", "height" to "100rpx", "opacity" to 0.5, "transform" to "rotateZ(-45deg)")), "text" to utsMapOf(".env-box " to utsMapOf("color" to "#FFFFFF", "fontSize" to "26rpx", "marginTop" to "5rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = utsMapOf()
        var emits: Map<String, Any?> = utsMapOf()
        var props = normalizePropsOptions(utsMapOf())
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf()
        var components: Map<String, CreateVueComponent> = utsMapOf()
    }
}
