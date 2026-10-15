package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: RawMessageInfo.java */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0528w f7216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f7218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7219d;

    public e0(AbstractC0528w abstractC0528w, String str, Object[] objArr) {
        this.f7216a = abstractC0528w;
        this.f7217b = str;
        this.f7218c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f7219d = cCharAt;
            return;
        }
        int i9 = cCharAt & 8191;
        int i10 = 1;
        int i11 = 13;
        while (true) {
            int i12 = i10 + 1;
            char cCharAt2 = str.charAt(i10);
            if (cCharAt2 < 55296) {
                this.f7219d = i9 | (cCharAt2 << i11);
                return;
            } else {
                i9 |= (cCharAt2 & 8191) << i11;
                i11 += 13;
                i10 = i12;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.O
    public final boolean a() {
        return (this.f7219d & 2) == 2;
    }

    @Override // androidx.datastore.preferences.protobuf.O
    public final b0 b() {
        int i9 = this.f7219d;
        if ((i9 & 1) != 0) {
            return b0.f7201a;
        }
        return (i9 & 4) == 4 ? b0.f7203c : b0.f7202b;
    }

    @Override // androidx.datastore.preferences.protobuf.O
    public final Q c() {
        return this.f7216a;
    }
}
