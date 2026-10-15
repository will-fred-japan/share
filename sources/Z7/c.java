package Z7;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f5651d;

    static {
        int i9 = i.f5659c;
        int i10 = i.f5660d;
        long j = i.f5661e;
        String str = i.f5657a;
        c cVar = new c();
        cVar.f5653c = new a(i9, i10, j, str);
        f5651d = cVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // S7.AbstractC0410w
    public final String toString() {
        return "Dispatchers.Default";
    }
}
