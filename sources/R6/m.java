package R6;

/* JADX INFO: compiled from: GeneratedFileSelectorApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f4062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4063b;

    public m(l lVar, String message) {
        kotlin.jvm.internal.k.e(message, "message");
        this.f4062a = lVar;
        this.f4063b = message;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(m.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        m mVar = (m) obj;
        return r.a(this.f4062a, mVar.f4062a) && r.a(this.f4063b, mVar.f4063b);
    }

    public final int hashCode() {
        return r.b(this.f4063b) + ((r.b(this.f4062a) + (m.class.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "FileSelectorNativeException(fileSelectorExceptionCode=" + this.f4062a + ", message=" + this.f4063b + ")";
    }
}
