package p057h6;

import W5.e;
import W5.f;

/* JADX INFO: compiled from: KeyCipherAlgorithm.java */
/* JADX INFO: loaded from: classes.dex */
public enum b {
    RSA_ECB_PKCS1Padding(new e(16), 1),
    RSA_ECB_OAEPwithSHA_256andMGF1Padding(new f(18), 23),
    AES_GCM_NoPadding(new defpackage.f(17), 23);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f19087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19088b;

    b(c cVar, int i9) {
        this.f19087a = cVar;
        this.f19088b = i9;
    }
}
