@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.jjMd5
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
import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils
val md5 = fun(str: String): String {
    console.log("md5==", str)
    val md5Data = DigestUtils.md5(str)
    console.log("md5==", Hex.encodeHex(md5Data))
    console.log("md5==", String(Hex.encodeHex(md5Data)))
    return String(Hex.encodeHex(md5Data))
}
