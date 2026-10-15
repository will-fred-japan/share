package p147s7;

/* JADX INFO: compiled from: Messages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21314b;

    public e(String str, String str2) {
        this.f21313a = str;
        this.f21314b = str2;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f21314b;
    }
}
