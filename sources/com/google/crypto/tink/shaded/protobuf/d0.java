package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: compiled from: RawMessageInfo.java */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q f14051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f14053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14054d;

    public d0(Q q8, String str, Object[] objArr) {
        this.f14051a = q8;
        this.f14052b = str;
        this.f14053c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f14054d = cCharAt;
            return;
        }
        int i9 = cCharAt & 8191;
        int i10 = 1;
        int i11 = 13;
        while (true) {
            int i12 = i10 + 1;
            char cCharAt2 = str.charAt(i10);
            if (cCharAt2 < 55296) {
                this.f14054d = i9 | (cCharAt2 << i11);
                return;
            } else {
                i9 |= (cCharAt2 & 8191) << i11;
                i11 += 13;
                i10 = i12;
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O
    public final boolean a() {
        return (this.f14054d & 2) == 2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O
    public final a0 b() {
        int i9 = this.f14054d;
        if ((i9 & 1) != 0) {
            return a0.f14037a;
        }
        return (i9 & 4) == 4 ? a0.f14039c : a0.f14038b;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O
    public final Q c() {
        return this.f14051a;
    }
}
