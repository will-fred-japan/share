package cn.jpush.android.w;

import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import defpackage.f;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public class a implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11722a;

    public a(String str) {
        this.f11722a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        StringBuilder sbI = f.i("host:", str, ",checkHost:");
        sbI.append(this.f11722a);
        Logger.d("DefaultHostVerifier", sbI.toString());
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f11722a, str);
    }
}
