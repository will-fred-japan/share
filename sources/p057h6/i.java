package p057h6;

import defpackage.f;

/* JADX INFO: compiled from: StorageCipherAlgorithm.java */
/* JADX INFO: loaded from: classes.dex */
public enum i {
    AES_CBC_PKCS7Padding(new f(18), 1),
    AES_GCM_NoPadding(null, 23);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f19100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19101b;

    i(f fVar, int i9) {
        this.f19100a = fVar;
        this.f19101b = i9;
    }
}
