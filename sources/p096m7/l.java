package p096m7;

import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: MethodChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p096m7.c f20500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f20502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p096m7.c.InterfaceC0232c f20503d;

    /* JADX INFO: compiled from: MethodChannel.java */
    public final class a implements m7.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f20504a;

        public a(c cVar) {
            this.f20504a = cVar;
        }

        @Override // m7.c.a
        public final void a(ByteBuffer byteBuffer, b7.c.e eVar) {
            l lVar = l.this;
            try {
                this.f20504a.onMethodCall(lVar.f20502c.e(byteBuffer), new k(this, eVar));
            } catch (RuntimeException e9) {
                Log.e("MethodChannel#" + lVar.f20501b, "Failed to handle method call", e9);
                eVar.a(lVar.f20502c.b(e9.getMessage(), Log.getStackTraceString(e9)));
            }
        }
    }

    /* JADX INFO: compiled from: MethodChannel.java */
    public final class b implements m7.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f20506a;

        public b(d dVar) {
            this.f20506a = dVar;
        }

        @Override // m7.c.b
        public final void a(ByteBuffer byteBuffer) {
            l lVar = l.this;
            d dVar = this.f20506a;
            try {
                if (byteBuffer == null) {
                    dVar.notImplemented();
                } else {
                    try {
                        dVar.success(lVar.f20502c.f(byteBuffer));
                    } catch (e e9) {
                        dVar.error(e9.f20492a, e9.getMessage(), e9.f20493b);
                    }
                }
            } catch (RuntimeException e10) {
                Log.e("MethodChannel#" + lVar.f20501b, "Failed to handle method call result", e10);
            }
        }
    }

    /* JADX INFO: compiled from: MethodChannel.java */
    public interface c {
        void onMethodCall(j jVar, d dVar);
    }

    /* JADX INFO: compiled from: MethodChannel.java */
    public interface d {
        void error(String str, String str2, Object obj);

        void notImplemented();

        void success(Object obj);
    }

    public l(p096m7.c cVar, String str) {
        this(cVar, str, s.f20511a, null);
    }

    public final void a(String str, Object obj, d dVar) {
        this.f20500a.a(this.f20501b, this.f20502c.d(new j(obj, str)), dVar == null ? null : new b(dVar));
    }

    public final void b(c cVar) {
        String str = this.f20501b;
        p096m7.c cVar2 = this.f20500a;
        p096m7.c.InterfaceC0232c interfaceC0232c = this.f20503d;
        if (interfaceC0232c != null) {
            cVar2.b(str, cVar != null ? new a(cVar) : null, interfaceC0232c);
        } else {
            cVar2.e(str, cVar != null ? new a(cVar) : null);
        }
    }

    public l(p096m7.c cVar, String str, m mVar, p096m7.c.InterfaceC0232c interfaceC0232c) {
        this.f20500a = cVar;
        this.f20501b = str;
        this.f20502c = mVar;
        this.f20503d = interfaceC0232c;
    }
}
