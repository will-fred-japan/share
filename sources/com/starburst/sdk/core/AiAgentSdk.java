package com.starburst.sdk.core;

import A.a;
import J6.c;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.starburst.sdk.core.auth.AliAgentImpl;
import com.starburst.sdk.core.device.api.IAliAgent;
import com.starburst.sdk.core.device.bt.AckQueue;
import com.starburst.sdk.core.device.bt.BleMsgManager;
import com.starburst.sdk.core.device.bt.BluetoothDeviceBean;
import com.starburst.sdk.core.device.bt.BtMsgReceiverHandler;
import com.starburst.sdk.core.device.bt.ConnectedDeviceManager;
import com.starburst.sdk.core.device.bt.api.IAliBt;
import com.starburst.sdk.core.device.bt.api.IBtDataUploadCallback;
import com.starburst.sdk.core.device.bt.api.IBtMsgCallback;
import com.starburst.sdk.core.device.bt.api.IBtReceiverCallback;
import com.starburst.sdk.core.device.bt.api.IOnBtInitStateListener;
import com.starburst.sdk.core.device.bt.callback.ISend2BtCallback;
import com.starburst.sdk.core.device.bt.domain.Sid;
import com.starburst.sdk.core.device.bt.http.HttpClientManage;
import com.starburst.sdk.core.device.bt.http.StripWidthTestManage;
import com.starburst.sdk.core.ntp.NtpTimeSync;
import com.starburst.sdk.utils.j;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AiAgentSdk implements IBtReceiverCallback {
    private static AiAgentSdk sInstance;
    private String TAG = "StbAgentSdk";
    private boolean deviceConnected = false;
    private AliAgentImpl mAliAgent;
    private IBtDataUploadCallback mBtDataUpload;
    private Context mContext;
    private IBtMsgCallback mIBtMsgCallback;
    private String sdkPath;

    private AiAgentSdk() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x007c  */
    public void btVtransfersendData(BluetoothDeviceBean bluetoothDeviceBean, byte[] bArr) {
        byte b9;
        String str = new String(bArr);
        j.f(this.TAG, "btVtransfersendData--".concat(str));
        try {
            JSONObject jSONObject = new JSONObject(str);
            j.f(this.TAG, "stringer--" + jSONObject.getString("sid"));
            String string = jSONObject.getString("sid");
            int iHashCode = string.hashCode();
            if (iHashCode != 69554) {
                if (iHashCode != 69756) {
                    if (iHashCode != 70903) {
                        if (iHashCode == 83127 && string.equals(Sid.TKN)) {
                            b9 = 3;
                        } else {
                            b9 = -1;
                        }
                    } else if (string.equals(Sid.GTD)) {
                        b9 = 2;
                    } else {
                        b9 = -1;
                    }
                } else if (string.equals(Sid.FND)) {
                    b9 = 1;
                } else {
                    b9 = -1;
                }
            } else if (string.equals(Sid.FGS)) {
                b9 = 0;
            } else {
                b9 = -1;
            }
            if (b9 == 0 || b9 == 1 || b9 == 2 || b9 == 3) {
                j.f(this.TAG, "stringer--发送FND-FGS-GTD -> " + jSONObject.getString("sid"));
                BleMsgManager.getInstance().sendRequestMsgNoEncryption(bluetoothDeviceBean, 65, bArr);
            }
        } catch (JSONException e9) {
            j.f(this.TAG, "btVtransfersendData--JSONException--" + e9.getMessage());
            throw new RuntimeException(e9);
        }
    }

    private String getFileRoot() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            j.f(this.TAG, "StarBurstSdk.getInstance().getSdkContext() = " + c.f().g());
            File externalFilesDir = c.f().g().getExternalFilesDir(null);
            if (externalFilesDir != null) {
                return externalFilesDir.getAbsolutePath();
            }
        }
        return c.f().g().getFilesDir().getAbsolutePath();
    }

    public static AiAgentSdk getInstance() {
        if (sInstance == null) {
            synchronized (AiAgentSdk.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new AiAgentSdk();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    public void closeBtMsg(BluetoothDeviceBean bluetoothDeviceBean) {
        j.f(this.TAG, "closeBtMsg ");
        getAgent().customBtImpl(null);
        getInstance().setDeviceConnected(false);
        BleMsgManager.getInstance().closeAllTask();
        getInstance().getAgent().disconnectLp(bluetoothDeviceBean);
        BtMsgReceiverHandler.getInstance().clear();
        StripWidthTestManage.getInstance().closeStripWidth();
        AckQueue.getInstance().clear();
    }

    public IAliAgent getAgent() {
        if (this.mAliAgent == null) {
            this.mAliAgent = new AliAgentImpl(this.mContext);
        }
        return this.mAliAgent;
    }

    public String getSdkPath() {
        if (TextUtils.isEmpty(this.sdkPath)) {
            this.sdkPath = a.j(new StringBuilder(), getFileRoot(), "/starburstsdk/");
        }
        return this.sdkPath;
    }

    public void init(Context context, boolean z8, boolean z9) {
        j.d(z8, z9);
        j.k(this.TAG, "init---context--" + context);
        this.mContext = context;
        if (context == null) {
            return;
        }
        this.sdkPath = a.j(new StringBuilder(), getFileRoot(), "/starburstsdk/");
        File file = new File(this.sdkPath);
        if (!file.exists()) {
            boolean zMkdirs = file.mkdirs();
            StringBuilder sb = new StringBuilder("文件创建");
            sb.append(zMkdirs ? "成功" : "失败");
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(this.sdkPath);
            j.w("HttpUtil", sb.toString());
        }
        HttpClientManage.getInstance().init(this.mContext);
        int i9 = Build.VERSION.SDK_INT;
        j.k(this.TAG, "api_version---" + i9);
        String str = Build.MODEL;
        String str2 = Build.BRAND;
        j.k(this.TAG, "model---" + str + "--brand---" + str2);
        String str3 = Build.PRODUCT;
        String str4 = Build.MANUFACTURER;
        j.k(this.TAG, "product---" + str3 + "--manufacturer---" + str4);
    }

    public void initBtMsg(final BluetoothDeviceBean bluetoothDeviceBean, IOnBtInitStateListener iOnBtInitStateListener) {
        j.f(this.TAG, "initBtMsg ");
        if (ConnectedDeviceManager.getInstance().getConnectedDeviceCount() > 0) {
            j.f(this.TAG, "Connected device count = " + ConnectedDeviceManager.getInstance().getConnectedDeviceCount());
            return;
        }
        NtpTimeSync.syncTime();
        getInstance().setDeviceConnected(true);
        getAgent().customBtImpl(new IAliBt() { // from class: com.starburst.sdk.core.AiAgentSdk.1
            @Override // com.starburst.sdk.core.device.bt.api.IAliBtSender
            public void sendData(BluetoothDeviceBean bluetoothDeviceBean2, byte[] bArr, ISend2BtCallback iSend2BtCallback) {
                j.f(AiAgentSdk.this.TAG, "setBtDataUploadCallback---data==> ".concat(new String(bArr)));
                AiAgentSdk.this.btVtransfersendData(bluetoothDeviceBean2, bArr);
            }

            @Override // com.starburst.sdk.core.device.bt.api.IAliBt
            public void setBtDataUploadCallback(IBtDataUploadCallback iBtDataUploadCallback) {
                j.f(AiAgentSdk.this.TAG, "setBtDataUploadCallback---data==> ");
                AiAgentSdk.this.mBtDataUpload = iBtDataUploadCallback;
            }
        });
        BleMsgManager.getInstance().sendDeviceInit(iOnBtInitStateListener);
        BtMsgReceiverHandler.getInstance().init(this.mBtDataUpload);
        AckQueue.getInstance().init();
        new Handler().postDelayed(new Runnable() { // from class: com.starburst.sdk.core.AiAgentSdk.2
            @Override // java.lang.Runnable
            public void run() {
                if (BtMsgReceiverHandler.getInstance().receiver4FF0) {
                    return;
                }
                BleMsgManager.getInstance().getDeviceInit(bluetoothDeviceBean);
            }
        }, 10000L);
    }

    public boolean isDeviceConnected() {
        return this.deviceConnected;
    }

    @Override // com.starburst.sdk.core.device.bt.api.IBtReceiverCallback
    public void onReceicerData(BluetoothDeviceBean bluetoothDeviceBean, byte[] bArr) {
        BtMsgReceiverHandler.getInstance().onReceiverData(bluetoothDeviceBean, bArr);
    }

    public void setBtMsgCallback(IBtMsgCallback iBtMsgCallback) {
        this.mIBtMsgCallback = iBtMsgCallback;
        if (iBtMsgCallback != null) {
            iBtMsgCallback.setReceivedCallBack(this);
            BleMsgManager.getInstance().init(this.mIBtMsgCallback);
        }
    }

    public void setDeviceConnected(boolean z8) {
        this.deviceConnected = z8;
    }
}
