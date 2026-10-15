package cn.jiguang.net;

import android.text.TextUtils;
import defpackage.f;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public class DefaultHostVerifier implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10605a;

    public DefaultHostVerifier(String str) {
        this.f10605a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        StringBuilder sbI = f.i("host:", str, ",checkHost:");
        sbI.append(this.f10605a);
        cn.jiguang.x.f.c("DefaultHostVerifier", sbI.toString());
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f10605a, str);
    }
}
