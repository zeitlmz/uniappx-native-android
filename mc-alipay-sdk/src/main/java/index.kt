@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.mcAlipaySdk
import android.os.Bundle
import com.alipay.sdk.app.OpenAuthTask
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
import java.util.Base64
import java.util.HashMap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
open class AlipayLoginSuccess (
    @JsonNotNull
    open var code: String,
    @JsonNotNull
    open var state: String,
) : UTSObject()
typealias AlipayLoginSuccessCallback = (result: AlipayLoginSuccess) -> Unit
typealias AlipayLoginFailCallback = (result: Any) -> Unit
open class AlipayLoginOptions (
    open var success: AlipayLoginSuccessCallback? = null,
    open var fail: AlipayLoginFailCallback? = null,
) : UTSObject()
open class AlipayShare {
    private var appId: String = "2021005176625436"
    constructor(){
        console.log("appId==", this.appId)
    }
    open var login = fun(options: AlipayLoginOptions){
        console.log("alipaylogin login")
        val bizParams = HashMap<String, String>()
        val state = Base64.getEncoder().encodeToString("mc-driver".toByteArray())
        bizParams.put("url", "https://authweb.alipay.com/auth?auth_type=PURE_OAUTH_SDK&app_id=" + this.appId + "&scope=auth_user&state=" + state)
        console.log("bizParams=", bizParams)
        val scheme = "__alipaysdkmc__"
        val context = UTSAndroid.getUniActivity()!!
        val task = OpenAuthTask(context)
        task.execute(scheme, OpenAuthTask.BizType.AccountAuth, bizParams, fun(paramInt: Number, paramString: String, bundle: Bundle){
            console.log("paramInt=", paramInt, ", paramString=", paramString)
            console.log("bundle=", this.bundleToString(bundle))
            if (paramInt == 9000 && bundle.containsKey("auth_code")) {
                options?.success?.invoke(AlipayLoginSuccess(code = bundle.getString("auth_code")!!, state = bundle.getString("state")!!))
            } else {
                options?.fail?.invoke(object : UTSJSONObject() {
                    var code = paramInt
                    var state = "alipay授权失败"
                })
            }
        }
            , true)
    }
    open var bundleToString = fun(bundle: Bundle): String {
        if (bundle == null) {
            return "null"
        }
        val sb = StringBuilder()
        bundle.keySet().forEach(fun(item){
            sb.append(item).append("=>").append(bundle.get(item)).append("##########")
        }
        )
        return sb.toString()
    }
    companion object {
        private var instance: AlipayShare? = null
        fun getInstance(): AlipayShare {
            if (this.instance == null) {
                this.instance = AlipayShare()
            }
            return this.instance!!
        }
    }
}
