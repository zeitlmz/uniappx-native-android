@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.xBase642fileS
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
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
import java.io.File
import java.io.FileOutputStream
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
fun toPngFile(data: String): UTSPromise<String> {
    var fileName = Math.random().toString(16).substring(2, 16)
    var baesestrAr = data.split(",") as UTSArray<String>
    var base64Data = baesestrAr[1]
    var fileUrl = ""
    try {
        var context = UTSAndroid.getAppContext()!!
        var filepath = context.getExternalCacheDir()?.getPath() ?: ""
        var decodedBytes = Base64.decode(base64Data, Base64.DEFAULT)
        var bitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
        var file = File(filepath, fileName + ".png")
        var fos = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
        fileUrl = file.getPath()
    }
    catch (error: Throwable) {
        console.error("处理图片错误:", error)
        return UTSPromise.reject(fileUrl) as UTSPromise<String>
    }
    return UTSPromise.resolve(fileUrl)
}
