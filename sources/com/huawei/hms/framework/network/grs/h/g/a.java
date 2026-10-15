package com.huawei.hms.framework.network.grs.h.g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactoryNew;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HostnameVerifier f15128a = new StrictHostnameVerifier();

    public static HostnameVerifier a() {
        return f15128a;
    }

    public static SSLSocketFactory a(Context context) {
        try {
            return new SecureSSLSocketFactoryNew(new SecureX509TrustManager(context.getAssets().open(GrsApp.getInstance().getBrand("/") + "grs_sp.bks"), ""), EncryptUtil.genSecureRandom());
        } catch (IOException | KeyManagementException | NoSuchAlgorithmException e9) {
            throw new AssertionError(e9);
        }
    }
}
