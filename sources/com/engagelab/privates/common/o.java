package com.engagelab.privates.common;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.monitor.tcp.TCPTimeManager;
import com.engagelab.privates.common.utils.AESUtil;
import com.engagelab.privates.common.utils.GZipUtil;
import com.engagelab.privates.common.utils.SM4Util;
import com.engagelab.privates.common.utils.StringUtil;
import com.engagelab.privates.common.utils.SystemUtil;
import com.engagelab.privates.core.api.Outputer;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12335a;

    public final int a(Context context, String str, int i9) {
        Context context2;
        long jStart = -1;
        try {
            byte[] bArrB = b(context);
            if (bArrB == null) {
                return 0;
            }
            jStart = TCPTimeManager.start(context, 3);
            context2 = context;
            try {
                byte[] bArrA = a(context2, bArrB, BluetoothConstant.SEND_DATA_MAX_TIMEOUT, str, i9);
                if (bArrA == null) {
                    TCPTimeManager.endFail(context2, 3, jStart, -1);
                    return 0;
                }
                String strA = a(context2, bArrA);
                if (strA == null) {
                    TCPTimeManager.endFail(context2, 3, jStart, -1);
                    return 0;
                }
                int iA = a(context2, strA);
                if (iA == 1) {
                    TCPTimeManager.endSucc(context2, 3, jStart);
                    return iA;
                }
                TCPTimeManager.endFail(context2, 3, jStart, iA);
                return iA;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            context2 = context;
        }
        Throwable th3 = th;
        MTCommonLog.d(a(), "sis address connect failed " + th3.getMessage());
        TCPTimeManager.endFail(context2, 3, jStart, -2);
        return 0;
    }

    public abstract String a();

    public abstract void a(Context context);

    public abstract byte[] a(Context context, byte[] bArr, int i9, String str, int i10);

    public final byte[] b(Context context) {
        int i9;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", 0);
            jSONObject.put("sdkver", "5.4.2");
            jSONObject.put("appkey", MTGlobal.getAppKey(context));
            jSONObject.put("uid", x.s(context));
            jSONObject.put("type", MTGlobal.getNetworkType());
            jSONObject.put("opera", MTGlobal.getNetworkName());
            if (MTGlobal.getTcpSSL()) {
                int iB = x.b(context);
                if (iB == -1) {
                    iB = 1;
                }
                jSONObject.put("cert_ver", iB);
            }
            MTCommonLog.d(a(), "sis send:" + MTCommonLog.toLogString(jSONObject));
            byte[] bArrStringToUtf8Bytes = StringUtil.stringToUtf8Bytes(jSONObject.toString());
            byte[] bArrZip = GZipUtil.zip(bArrStringToUtf8Bytes);
            if (bArrZip == null) {
                i9 = 0;
            } else {
                bArrStringToUtf8Bytes = bArrZip;
                i9 = 1;
            }
            int length = bArrStringToUtf8Bytes.length;
            int iGenerateSeed = AESUtil.generateSeed();
            long j = iGenerateSeed;
            String md5AesKey = AESUtil.getMd5AesKey(j);
            byte b9 = i9 != 0 ? (byte) 1 : (byte) 0;
            int encryptType = MTGlobal.getEncryptType();
            byte[] bArrEncryptBytes = SM4Util.encryptBytes(bArrStringToUtf8Bytes, md5AesKey, md5AesKey.substring(0, 16));
            Outputer outputer = new Outputer(bArrEncryptBytes.length + 10);
            outputer.writeU16(0);
            outputer.writeByteArray("UG".getBytes());
            outputer.writeU32(j);
            outputer.writeU8At((byte) (b9 | 32), 4);
            outputer.writeU16(length);
            outputer.writeByteArray(bArrEncryptBytes);
            outputer.writeU16At(outputer.current(), 0);
            MTCommonLog.d(a(), "send totalLength:" + outputer.current() + ", encryption:" + encryptType + ", compress:" + i9 + ", sid:" + iGenerateSeed);
            return outputer.toByteArray();
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("packageRequest failed "), a());
            return null;
        }
    }

    public final List<String> c(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(d(context));
        Collections.shuffle(arrayList);
        arrayList.addAll(x.d(context));
        return arrayList;
    }

    public final Set<String> d(Context context) {
        return x.r(context);
    }

    public void e(Context context) {
        if (this.f12335a) {
            MTCommonLog.d(a(), "can't connect, isUdpConnecting");
            return;
        }
        List<String> listC = c(context);
        if (listC.isEmpty()) {
            MTCommonLog.d(a(), "there are no udp connect address");
            return;
        }
        this.f12335a = true;
        ArrayList<String> arrayList = new ArrayList();
        for (int i9 = 0; i9 < 3; i9++) {
            arrayList.addAll(listC);
        }
        for (String str : arrayList) {
            if (!x.c(context)) {
                MTCommonLog.d(a(), "can't connect ,connect state is false");
                g(context);
                return;
            }
            if (!SystemUtil.isNetworkConnecting(context)) {
                MTCommonLog.d(a(), "can't connect, network is disConnected");
                g(context);
                return;
            }
            String[] strArrSplit = str.split(Constants.COLON_SEPARATOR);
            String str2 = strArrSplit[strArrSplit.length - 1];
            int iA = a(context, str.substring(0, (str.length() - str2.length()) - 1), Integer.parseInt(str2));
            if (1 == iA) {
                f(context);
                return;
            }
            if (2002 == iA) {
                MTCommonLog.e(a(), "fail: CODE_NOT_APPKEY");
                w.b(context);
                return;
            }
            if (2003 == iA) {
                MTCommonLog.e(a(), "fail: CODE_RESTRICTED");
                w.c(context);
                return;
            } else if (2001 == iA) {
                MTCommonLog.e(a(), "fail: CODE_INVALID_APPKEY");
                w.a(context);
            } else {
                MTCommonLog.w(a(), "fail result:" + iA);
                g(context);
            }
        }
    }

    public final void f(Context context) {
        if (MTGlobal.getTcpSSL()) {
            int iB = x.b(context);
            int iQ = x.q(context);
            if (iB != iQ || iB == -1 || iQ == -1) {
                MTCommonLog.d(a(), "connectSSL_crt_v：" + iB);
                MTCommonLog.d(a(), "tcpAddressSSL_crt_v：" + iQ);
                boolean zB = j.b(context);
                MTCommonLog.d(a(), "get crt：" + zB);
            }
        }
    }

    public void g(Context context) {
        this.f12335a = false;
        a(context);
    }

    public final void d(Context context, JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sis_ips");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i9 = 0; i9 < jSONArrayOptJSONArray.length(); i9++) {
                linkedHashSet.add(String.valueOf(jSONArrayOptJSONArray.get(i9)));
            }
        }
        x.c(context, linkedHashSet);
    }

    public final void c(Context context, JSONObject jSONObject) {
        x.a(context, jSONObject.optJSONArray("ips"));
    }

    public byte[] a(int i9, Context context, String str, int i10) {
        try {
            if (TextUtils.isEmpty(str) || i10 <= 0) {
                return null;
            }
            MTCommonLog.d(a(), "udp connect " + str + Constants.COLON_SEPARATOR + i10);
            InetAddress.getByName(str);
            byte[] bArrB = b(context);
            if (bArrB == null) {
                return null;
            }
            return a(context, bArrB, i9, str, i10);
        } catch (Throwable th) {
            MTCommonLog.d(a(), "udp connect failed " + th.getMessage());
            return null;
        }
    }

    public int a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            MTCommonLog.d(a(), "udp receive " + MTCommonLog.toLogString(jSONObject));
            if (jSONObject.has("code") && jSONObject.has("code")) {
                return jSONObject.optInt("code");
            }
            d(context, jSONObject);
            c(context, jSONObject);
            b(context, jSONObject);
            a(context, jSONObject);
            return 1;
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("parseResponse failed "), a());
            return 0;
        }
    }

    public String a(Context context, byte[] bArr) {
        try {
            byte[] bArr2 = new byte[10];
            System.arraycopy(bArr, 0, bArr2, 0, 10);
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr2);
            short s8 = byteBufferWrap.getShort();
            byteBufferWrap.getShort();
            int i9 = byteBufferWrap.getInt();
            long j = 16777215 & i9;
            byteBufferWrap.getShort();
            int i10 = (i9 >>> 24) & 1;
            String md5AesKey = AESUtil.getMd5AesKey(j);
            MTCommonLog.d(a(), "receive totalLength:" + ((int) s8) + ", encryption:" + (i9 >>> 28) + ", compress:" + i10 + ", sid:" + j);
            int i11 = s8 - 10;
            byte[] bArr3 = new byte[i11];
            System.arraycopy(bArr, 10, bArr3, 0, i11);
            byte[] bArrDecryptBytes = SM4Util.decryptBytes(bArr3, md5AesKey);
            if (i10 == 1) {
                bArrDecryptBytes = GZipUtil.unzip(bArrDecryptBytes);
            }
            return new String(bArrDecryptBytes);
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("parseResponse failed "), a());
            return null;
        }
    }

    public final void b(Context context, JSONObject jSONObject) {
        if (MTGlobal.getTcpSSL()) {
            if (jSONObject.has("cert_ver")) {
                int iOptInt = jSONObject.optInt("cert_ver");
                if (iOptInt != x.q(context)) {
                    x.b(context, (JSONArray) null);
                }
                x.e(context, iOptInt);
                x.b(context, jSONObject.optJSONArray("ssl_ips"));
                return;
            }
            MTCommonLog.d(a(), "no has cert_ver");
            x.b(context, (JSONArray) null);
        }
    }

    public final void a(Context context, JSONObject jSONObject) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("https_report");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i9 = 0; i9 < jSONArrayOptJSONArray.length(); i9++) {
                linkedHashSet.add(JPushConstants.HTTPS_PRE + jSONArrayOptJSONArray.get(i9));
            }
        }
        x.b(context, linkedHashSet);
    }
}
