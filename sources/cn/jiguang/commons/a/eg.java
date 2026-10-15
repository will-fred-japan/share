package cn.jiguang.commons.a;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public final class eg implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9950a;

    public eg(String str) {
        this.f9950a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f9950a, str);
    }
}
