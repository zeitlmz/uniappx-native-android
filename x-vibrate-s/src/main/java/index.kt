@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.xVibrateS
import android.content.Context
import android.os.Vibrator
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
fun vibrator(duriation: Number): Boolean {
    try {
        val context = UTSAndroid.getAppContext() as Context
        var vb = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (vb!!.hasVibrator()) {
            vb!!.vibrate(duriation.toLong())
        } else {
            return false
        }
    }
    catch (e: Throwable) {
        console.error(e)
    }
    return false
}
