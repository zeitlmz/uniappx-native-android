@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.xShareS
import android.content.Intent
import androidx.core.content.FileProvider
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
import java.io.File
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
fun xShare(title: String, minType: String, content: String?, path: String?) {
    val context = UTSAndroid.getAppContext()!!
    if (minType == "text/plain") {
        var action = Intent()
        action.setAction(Intent.ACTION_SEND)
        action.setType("text/plain")
        if (content != null) {
            action.putExtra(Intent.EXTRA_TEXT, content!!)
        }
        UTSAndroid.getUniActivity()!!.startActivity(Intent.createChooser(action, title))
    } else {
        if (path == null || minType == "") {
            console.error("类型或者路径为空")
            return
        }
        var realfilepath = UTSAndroid.convert2AbsFullPath(path)
        var file = File(realfilepath)
        var action = Intent()
        action.setAction(Intent.ACTION_SEND)
        action.setType(minType)
        var contentUri = FileProvider.getUriForFile(context, "xShareS.FileProvider", file)
        action.putExtra(Intent.EXTRA_STREAM, contentUri)
        UTSAndroid.getUniActivity()!!.startActivity(Intent.createChooser(action, title))
    }
}
