package p096m7;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: EventChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p096m7.c f20484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f20486c;

    /* JADX INFO: compiled from: EventChannel.java */
    public interface a {
        void success(Object obj);
    }

    /* JADX INFO: compiled from: EventChannel.java */
    public final class b implements m7.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f20487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference<a> f20488b = new AtomicReference<>(null);

        /* JADX INFO: compiled from: EventChannel.java */
        public final class a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AtomicBoolean f20490a = new AtomicBoolean(false);

            public a() {
            }

            public final void a() {
                if (this.f20490a.getAndSet(true)) {
                    return;
                }
                b bVar = b.this;
                if (bVar.f20488b.get() != this) {
                    return;
                }
                d dVar = d.this;
                dVar.f20484a.d(dVar.f20485b, null);
            }

            public final void b(String str, String str2, Object obj) {
                if (this.f20490a.get()) {
                    return;
                }
                b bVar = b.this;
                if (bVar.f20488b.get() != this) {
                    return;
                }
                d dVar = d.this;
                dVar.f20484a.d(dVar.f20485b, dVar.f20486c.c(str, str2, obj));
            }

            @Override // m7.d.a
            public final void success(Object obj) {
                if (this.f20490a.get()) {
                    return;
                }
                b bVar = b.this;
                if (bVar.f20488b.get() != this) {
                    return;
                }
                d dVar = d.this;
                dVar.f20484a.d(dVar.f20485b, dVar.f20486c.a(obj));
            }
        }

        public b(c cVar) {
            this.f20487a = cVar;
        }

        @Override // m7.c.a
        public final void a(ByteBuffer byteBuffer, b7.c.e eVar) {
            d dVar = d.this;
            j jVarE = dVar.f20486c.e(byteBuffer);
            String str = jVarE.f20496a;
            boolean zEquals = str.equals("listen");
            AtomicReference<a> atomicReference = this.f20488b;
            Object obj = jVarE.f20497b;
            String str2 = dVar.f20485b;
            s sVar = dVar.f20486c;
            c cVar = this.f20487a;
            if (!zEquals) {
                if (!str.equals("cancel")) {
                    eVar.a(null);
                    return;
                }
                if (atomicReference.getAndSet(null) == null) {
                    eVar.a(sVar.c("error", "No active stream to cancel", null));
                    return;
                }
                try {
                    cVar.b();
                    eVar.a(sVar.a(null));
                    return;
                } catch (RuntimeException e9) {
                    Log.e("EventChannel#" + str2, "Failed to close event stream", e9);
                    eVar.a(sVar.c("error", e9.getMessage(), null));
                    return;
                }
            }
            a aVar = new a();
            if (atomicReference.getAndSet(aVar) != null) {
                try {
                    cVar.b();
                } catch (RuntimeException e10) {
                    Log.e("EventChannel#" + str2, "Failed to close existing event stream", e10);
                }
            }
            try {
                cVar.a(obj, aVar);
                eVar.a(sVar.a(null));
            } catch (RuntimeException e11) {
                atomicReference.set(null);
                Log.e("EventChannel#" + str2, "Failed to open event stream", e11);
                eVar.a(sVar.c("error", e11.getMessage(), null));
            }
        }
    }

    /* JADX INFO: compiled from: EventChannel.java */
    public interface c {
        void a(Object obj, b.a aVar);

        void b();
    }

    public d(p096m7.c cVar, String str) {
        s sVar = s.f20511a;
        this.f20484a = cVar;
        this.f20485b = str;
        this.f20486c = sVar;
    }

    public final void a(c cVar) {
        this.f20484a.e(this.f20485b, cVar == null ? null : new b(cVar));
    }
}
