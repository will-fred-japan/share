package p013b7;

import android.content.res.AssetManager;
import android.os.Trace;
import android.util.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;
import p096m7.t;

/* JADX INFO: compiled from: DartExecutor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements p096m7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterJNI f8595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AssetManager f8596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p013b7.c f8598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f8599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8600f;

    /* JADX INFO: renamed from: b7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DartExecutor.java */
    public class C0113a implements m7.c.a {
        public C0113a() {
        }

        @Override // m7.c.a
        public final void a(ByteBuffer byteBuffer, b7.c.e eVar) {
            t.f20513b.getClass();
            t.c(byteBuffer);
            a.this.getClass();
        }
    }

    /* JADX INFO: compiled from: DartExecutor.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FlutterCallbackInformation f8603b;

        public b(AssetManager assetManager, String str, FlutterCallbackInformation flutterCallbackInformation) {
            this.f8602a = str;
            this.f8603b = flutterCallbackInformation;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("DartCallback( bundle path: ");
            sb.append(this.f8602a);
            sb.append(", library path: ");
            FlutterCallbackInformation flutterCallbackInformation = this.f8603b;
            sb.append(flutterCallbackInformation.callbackLibraryPath);
            sb.append(", function: ");
            return A.a.j(sb, flutterCallbackInformation.callbackName, " )");
        }
    }

    /* JADX INFO: compiled from: DartExecutor.java */
    public static class d implements p096m7.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p013b7.c f8607a;

        public d(p013b7.c cVar) {
            this.f8607a = cVar;
        }

        @Override // p096m7.c
        public final void a(String str, ByteBuffer byteBuffer, m7.c.b bVar) {
            this.f8607a.a(str, byteBuffer, bVar);
        }

        @Override // p096m7.c
        public final void b(String str, m7.c.a aVar, p096m7.c.InterfaceC0232c interfaceC0232c) {
            this.f8607a.b(str, aVar, interfaceC0232c);
        }

        @Override // p096m7.c
        public final p096m7.c.InterfaceC0232c c(m7.c.d dVar) {
            return this.f8607a.c(dVar);
        }

        @Override // p096m7.c
        public final void d(String str, ByteBuffer byteBuffer) {
            this.f8607a.a(str, byteBuffer, null);
        }

        @Override // p096m7.c
        public final void e(String str, m7.c.a aVar) {
            this.f8607a.b(str, aVar, null);
        }
    }

    public a(FlutterJNI flutterJNI, AssetManager assetManager, long j) {
        this.f8600f = false;
        C0113a c0113a = new C0113a();
        this.f8595a = flutterJNI;
        this.f8596b = assetManager;
        this.f8597c = j;
        p013b7.c cVar = new p013b7.c(flutterJNI);
        this.f8598d = cVar;
        cVar.b("flutter/isolate", c0113a, null);
        this.f8599e = new d(cVar);
        if (flutterJNI.isAttached()) {
            this.f8600f = true;
        }
    }

    @Override // p096m7.c
    @Deprecated
    public final void a(String str, ByteBuffer byteBuffer, m7.c.b bVar) {
        this.f8599e.a(str, byteBuffer, bVar);
    }

    @Override // p096m7.c
    @Deprecated
    public final void b(String str, m7.c.a aVar, p096m7.c.InterfaceC0232c interfaceC0232c) {
        this.f8599e.b(str, aVar, interfaceC0232c);
    }

    @Override // p096m7.c
    @Deprecated
    public final p096m7.c.InterfaceC0232c c(m7.c.d dVar) {
        return this.f8599e.f8607a.c(dVar);
    }

    @Override // p096m7.c
    @Deprecated
    public final void d(String str, ByteBuffer byteBuffer) {
        this.f8599e.d(str, byteBuffer);
    }

    @Override // p096m7.c
    @Deprecated
    public final void e(String str, m7.c.a aVar) {
        this.f8599e.e(str, aVar);
    }

    public final void f(c cVar, List<String> list) {
        if (this.f8600f) {
            Log.w("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        p170v7.a.b("DartExecutor#executeDartEntrypoint");
        try {
            Objects.toString(cVar);
            this.f8595a.runBundleAndSnapshotFromLibrary(cVar.f8604a, cVar.f8606c, cVar.f8605b, this.f8596b, list, this.f8597c);
            this.f8600f = true;
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: DartExecutor.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f8605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f8606c;

        public c(String str, String str2) {
            this.f8604a = str;
            this.f8605b = null;
            this.f8606c = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f8604a.equals(cVar.f8604a)) {
                return this.f8606c.equals(cVar.f8606c);
            }
            return false;
        }

        public final int hashCode() {
            return this.f8606c.hashCode() + (this.f8604a.hashCode() * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("DartEntrypoint( bundle path: ");
            sb.append(this.f8604a);
            sb.append(", function: ");
            return A.a.j(sb, this.f8606c, " )");
        }

        public c(String str, String str2, String str3) {
            this.f8604a = str;
            this.f8605b = str2;
            this.f8606c = str3;
        }
    }
}
