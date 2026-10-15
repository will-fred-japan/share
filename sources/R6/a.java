package R6;

import java.util.Arrays;

/* JADX INFO: compiled from: GeneratedFileSelectorApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f4034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f4035f;

    public a(String path, String str, String str2, long j, byte[] bArr, m mVar) {
        kotlin.jvm.internal.k.e(path, "path");
        this.f4030a = path;
        this.f4031b = str;
        this.f4032c = str2;
        this.f4033d = j;
        this.f4034e = bArr;
        this.f4035f = mVar;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(a.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        a aVar = (a) obj;
        return r.a(this.f4030a, aVar.f4030a) && r.a(this.f4031b, aVar.f4031b) && r.a(this.f4032c, aVar.f4032c) && r.a(Long.valueOf(this.f4033d), Long.valueOf(aVar.f4033d)) && r.a(this.f4034e, aVar.f4034e) && r.a(this.f4035f, aVar.f4035f);
    }

    public final int hashCode() {
        return r.b(this.f4035f) + ((r.b(this.f4034e) + ((r.b(Long.valueOf(this.f4033d)) + ((r.b(this.f4032c) + ((r.b(this.f4031b) + ((r.b(this.f4030a) + (a.class.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "FileResponse(path=" + this.f4030a + ", mimeType=" + this.f4031b + ", name=" + this.f4032c + ", size=" + this.f4033d + ", bytes=" + Arrays.toString(this.f4034e) + ", fileSelectorNativeException=" + this.f4035f + ")";
    }
}
