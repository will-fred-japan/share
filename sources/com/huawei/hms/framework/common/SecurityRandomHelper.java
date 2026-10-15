package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* JADX INFO: loaded from: classes.dex */
public class SecurityRandomHelper {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile SecurityRandomHelper instance;

    private SecurityRandomHelper() {
    }

    public static SecurityRandomHelper getInstance() {
        if (instance == null) {
            synchronized (SecurityRandomHelper.class) {
                try {
                    if (instance == null) {
                        EncryptUtil.setBouncycastleFlag(true);
                        instance = new SecurityRandomHelper();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public byte[] generateSecureRandom(int i9) {
        return EncryptUtil.generateSecureRandom(i9);
    }

    public String generateSecureRandomStr(int i9) {
        return EncryptUtil.generateSecureRandomStr(i9);
    }
}
