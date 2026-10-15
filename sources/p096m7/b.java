package p096m7;

import android.util.Log;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: BasicMessageChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p096m7.c f20476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i<T> f20478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p096m7.c.InterfaceC0232c f20479d;

    /* JADX INFO: compiled from: BasicMessageChannel.java */
    public final class a implements m7.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c<T> f20480a;

        public a(c cVar) {
            this.f20480a = cVar;
        }

        @Override // m7.c.a
        public final void a(ByteBuffer byteBuffer, b7.c.e eVar) {
            b bVar = b.this;
            try {
                this.f20480a.d(bVar.f20478c.b(byteBuffer), new p096m7.a(this, eVar));
            } catch (RuntimeException e9) {
                Log.e("BasicMessageChannel#" + bVar.f20477b, "Failed to handle message", e9);
                eVar.a(null);
            }
        }
    }

    /* JADX INFO: renamed from: m7.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BasicMessageChannel.java */
    public final class C0231b implements m7.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d<T> f20482a;

        public C0231b(d dVar) {
            this.f20482a = dVar;
        }

        @Override // m7.c.b
        public final void a(ByteBuffer byteBuffer) {
            b bVar = b.this;
            try {
                this.f20482a.c(bVar.f20478c.b(byteBuffer));
            } catch (RuntimeException e9) {
                Log.e("BasicMessageChannel#" + bVar.f20477b, "Failed to handle message reply", e9);
            }
        }
    }

    /* JADX INFO: compiled from: BasicMessageChannel.java */
    public interface c<T> {
        void d(Object obj, p096m7.a aVar);
    }

    /* JADX INFO: compiled from: BasicMessageChannel.java */
    public interface d<T> {
        void c(T t);
    }

    public b(p096m7.c cVar, String str, i<T> iVar, p096m7.c.InterfaceC0232c interfaceC0232c) {
        this.f20476a = cVar;
        this.f20477b = str;
        this.f20478c = iVar;
        this.f20479d = interfaceC0232c;
    }

    public final void a(Serializable serializable, d dVar) {
        this.f20476a.a(this.f20477b, this.f20478c.a(serializable), dVar == null ? null : new C0231b(dVar));
    }

    public final void b(c<T> cVar) {
        String str = this.f20477b;
        p096m7.c cVar2 = this.f20476a;
        p096m7.c.InterfaceC0232c interfaceC0232c = this.f20479d;
        if (interfaceC0232c != null) {
            cVar2.b(str, cVar != null ? new a(cVar) : null, interfaceC0232c);
        } else {
            cVar2.e(str, cVar != null ? new a(cVar) : null);
        }
    }
}
