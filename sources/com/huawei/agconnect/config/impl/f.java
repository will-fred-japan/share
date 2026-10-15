package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes.dex */
public class f implements IDecrypt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SecretKey f14607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f14608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14609c = false;

    public f(d dVar) {
        this.f14608b = dVar;
    }

    private void a() {
        try {
            this.f14607a = j.a(this.f14608b);
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e9) {
            H2.a.h(e9, new StringBuilder("Exception when reading the 'K&I' for 'Config'. error is "), "AGC_LocalResource");
            this.f14607a = null;
        }
        this.f14609c = true;
    }

    @Override // com.huawei.agconnect.config.IDecrypt
    public String decrypt(String str, String str2) {
        if (!this.f14609c) {
            a();
        }
        if (this.f14607a != null && !TextUtils.isEmpty(str)) {
            try {
                return new String(j.a(this.f14607a, Hex.decodeHexString(str)), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException e9) {
                H2.a.h(e9, new StringBuilder("decrypt exception:"), "AGC_LocalResource");
                return str2;
            }
        }
        Log.e("AGC_LocalResource", "decrypt exception: secretKey = " + this.f14607a + "raw = " + str);
        return str2;
    }
}
