package p027d5;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f18525b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f18526a;

    static {
        c cVar = new c();
        cVar.f18526a = null;
        f18525b = cVar;
    }

    public static b a(Context context) {
        b bVar;
        c cVar = f18525b;
        synchronized (cVar) {
            try {
                if (cVar.f18526a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    cVar.f18526a = new b(context);
                }
                bVar = cVar.f18526a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }
}
