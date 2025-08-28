@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.mcWechatSdk
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import com.tencent.mm.opensdk.constants.ConstantsAPI
import com.tencent.mm.opensdk.modelbase.BaseReq
import com.tencent.mm.opensdk.modelbase.BaseResp
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram
import com.tencent.mm.opensdk.modelmsg.SendAuth
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject
import com.tencent.mm.opensdk.modelmsg.WXTextObject
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
import com.tencent.mm.opensdk.openapi.WXAPIFactory
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
import io.dcloud.uniapp.extapi.downloadFile as uni_downloadFile
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class WeChatLoginSuccess (
    @JsonNotNull
    open var code: String,
    @JsonNotNull
    open var state: String,
) : UTSObject()
typealias WeChatLoginSuccessCallback = (result: WeChatLoginSuccess) -> Unit
typealias WeChatLoginFailCallback = (result: Any) -> Unit
open class WeChatLoginOptions (
    open var state: String? = null,
    open var success: WeChatLoginSuccessCallback? = null,
    open var fail: WeChatLoginFailCallback? = null,
) : UTSObject()
open class WeChatShare {
    private var appId: String = "wx251c3866781ef220"
    private var miniProgramId: String = "gh_2a74a079e98e"
    private var mWXApi: IWXAPI = WXAPIFactory.createWXAPI(UTSAndroid.getAppContext(), this.appId, false)
    private var webpageUrl: String = ""
    private var title: String = ""
    private var description: String = ""
    private var imageBitmap: Bitmap? = null
    private var imageBitmapPath: String? = null
    private var miniProgramPath: String = ""
    open var loginOptions: WeChatLoginOptions? = null
    constructor(){
        console.log("appId==", this.appId)
        this.mWXApi.registerApp(this.appId)
    }
    open fun addMiniProgramId(miniProgramId: String): WeChatShare {
        this.miniProgramId = miniProgramId
        return this
    }
    open fun addMiniProgramPath(miniProgramPath: String): WeChatShare {
        this.miniProgramPath = miniProgramPath
        return this
    }
    open fun addWebpageUrl(webpageUrl: String): WeChatShare {
        this.webpageUrl = webpageUrl
        return this
    }
    open fun addTitle(title: String): WeChatShare {
        this.title = title
        return this
    }
    open fun addDescription(description: String): WeChatShare {
        this.description = description
        return this
    }
    open fun addImageBitmap(imageBitmap: Bitmap?): WeChatShare {
        this.imageBitmap = imageBitmap
        return this
    }
    open fun addImageBitmapPath(imageBitmapPath: String): WeChatShare {
        this.imageBitmapPath = imageBitmapPath
        if (this.imageBitmap == null) {
            this.downloadImgByPath(imageBitmapPath)
        }
        return this
    }
    open fun shareMiniProgram() {
        if (!this.mWXApi.isWXAppInstalled()) {
            console.error("微信未安装")
            uni_showToast(ShowToastOptions(title = "请先安装微信客户端", icon = "none", position = "center"))
            return
        }
        val miniProgramObj: WXMiniProgramObject = WXMiniProgramObject()
        miniProgramObj.webpageUrl = this.webpageUrl
        miniProgramObj.miniprogramType = 0
        miniProgramObj.userName = this.miniProgramId
        miniProgramObj.path = this.miniProgramPath
        val msg: WXMediaMessage = WXMediaMessage(miniProgramObj as WXMediaMessage.IMediaObject)
        msg.title = this.title
        msg.description = this.description
        if (this.imageBitmap != null) {
            msg.setThumbImage(this.imageBitmap)
        } else if (this.imageBitmapPath != null && this.imageBitmapPath != "") {
            this.downloadImgByPath(this.imageBitmapPath!!)
            msg.setThumbImage(this.imageBitmap)
        }
        val req: SendMessageToWX.Req = SendMessageToWX.Req()
        req.transaction = this.buildTransaction("miniProgram")
        req.message = msg
        req.scene = SendMessageToWX.Req.WXSceneSession
        try {
            console.log("mWXApi=", this.mWXApi)
            console.log("req=", req)
            this.mWXApi.sendReq(req)
        }
        catch (err: Throwable) {
            console.error(err)
        }
    }
    open fun shareText(text: String) {
        val textObj: WXTextObject = WXTextObject()
        textObj.text = text
        val msg: WXMediaMessage = WXMediaMessage()
        msg.mediaObject = textObj as WXMediaMessage.IMediaObject
        msg.description = text
        console.log("shareText=", msg)
        val req: SendMessageToWX.Req = SendMessageToWX.Req()
        req.transaction = this.buildTransaction("text")
        req.message = msg
        req.scene = SendMessageToWX.Req.WXSceneSession
        console.log("shareText req=", req)
        this.mWXApi.sendReq(req)
    }
    open fun pullMiniProgram() {
        val req: WXLaunchMiniProgram.Req = WXLaunchMiniProgram.Req()
        req.userName = this.miniProgramId
        req.path = "/pages/other/scan-car/index"
        req.miniprogramType = WXLaunchMiniProgram.Req.MINIPTOGRAM_TYPE_RELEASE
        this.mWXApi.sendReq(req)
    }
    private fun buildTransaction(type: String): String {
        return type + System.currentTimeMillis().toString()
    }
    open var downloadImgByPath = fun(imageBitmapPath: String): UTSPromise<Unit> {
        return wrapUTSPromise(suspend {
            uni_downloadFile(DownloadFileOptions(url = imageBitmapPath, success = fun(downloadResult){
                console.log("downloadResult=", downloadResult)
                if (downloadResult.statusCode == 200) {
                    this.convertImgPathToBitmap(downloadResult.tempFilePath).then(fun(resBit: Bitmap?){
                        this.imageBitmap = resBit
                    })
                } else {
                    console.error("图片下载失败")
                }
            }
                , fail = fun(_){
                    console.error("图片下载失败")
                }
            ))
        })
    }
    open var convertImgPathToBitmap = fun(filePath: String): UTSPromise<Bitmap?> {
        return wrapUTSPromise(suspend w@{
            try {
                val bitmap = BitmapFactory.decodeFile(filePath)
                console.log("转换小程序封面图片成功，Bitmap宽高:", bitmap.getWidth(), "x", bitmap.getHeight())
                return@w bitmap
            }
            catch (error: Throwable) {
                console.error("转换图片地址到Bitmap失败:", error)
                return@w null
            }
        })
    }
    open var login = fun(options: WeChatLoginOptions){
        console.log("wxlogin options state=", options.state)
        this.loginOptions = options
        val req = SendAuth.Req()
        req.scope = "snsapi_userinfo"
        req.state = this.loginOptions!!.state ?: ("mc-driver" + Date.now().toString(10))
        console.log("wxlogin req=", req)
        this.mWXApi!!.sendReq(req)
    }
    companion object {
        private var instance: WeChatShare? = null
        fun getInstance(): WeChatShare {
            if (this.instance == null) {
                this.instance = WeChatShare()
            }
            return this.instance!!
        }
    }
}
open class WXEntryActivity : Activity, IWXAPIEventHandler {
    constructor() : super() {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var api = WXAPIFactory.createWXAPI(this, "")
        api.handleIntent(this.getIntent(), this)
    }
    override fun onResp(resp: BaseResp) {
        if (resp.getType() == ConstantsAPI.COMMAND_SENDAUTH) {
            val options = WeChatShare.getInstance().loginOptions
            if (resp.errCode == BaseResp.ErrCode.ERR_OK) {
                val code = (resp as SendAuth.Resp).code
                val state = (resp as SendAuth.Resp).state
                console.log("wxlogin code = ", code, " state = ", state)
                val success = WeChatLoginSuccess(code = "" + (resp as SendAuth.Resp).code, state = (resp as SendAuth.Resp).state)
                options?.success?.invoke(success)
            } else {
                console.log("wxlogin err = ", resp)
                options?.fail?.invoke(object : UTSJSONObject() {
                    var errCode: Number = 500
                    var errMsg = "授权失败"
                })
            }
        }
        this.finish()
    }
    override fun onReq(req: BaseReq) {
        this.finish()
    }
}
