package p042f7;

import android.content.Context;
import io.flutter.plugin.platform.g;
import p096m7.c;

/* JADX INFO: compiled from: FlutterPlugin.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: f7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FlutterPlugin.java */
    public interface InterfaceC0199a {
    }

    /* JADX INFO: compiled from: FlutterPlugin.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f18711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.flutter.embedding.engine.a f18712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f18713c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final g f18714d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final p005a7.a.C0088a f18715e;

        public b(Context context, io.flutter.embedding.engine.a aVar, c cVar, g gVar, p005a7.a.C0088a c0088a) {
            this.f18711a = context;
            this.f18712b = aVar;
            this.f18713c = cVar;
            this.f18714d = gVar;
            this.f18715e = c0088a;
        }
    }

    void onAttachedToEngine(b bVar);

    void onDetachedFromEngine(b bVar);
}
