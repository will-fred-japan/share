package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ExtensionSchemas.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0523q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0522p f7300a = new C0522p();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC0521o<?> f7301b;

    static {
        AbstractC0521o<?> abstractC0521o;
        c0 c0Var = c0.f7206c;
        try {
            abstractC0521o = (AbstractC0521o) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            abstractC0521o = null;
        }
        f7301b = abstractC0521o;
    }
}
