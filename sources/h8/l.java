package h8;

import K7.p;
import S7.A;
import S7.C;
import S7.InterfaceC0413z;
import S7.J;
import X7.o;
import android.media.SoundPool;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SoundPoolPlayer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f19137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f19138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final X7.c f19139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f19140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f19141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g8.a f19142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m f19143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i8.d f19144h;

    /* JADX INFO: compiled from: SoundPoolPlayer.kt */
    @D7.e(c = "xyz.luan.audioplayers.player.SoundPoolPlayer$urlSource$1$1", f = "SoundPoolPlayer.kt", l = {}, m = "invokeSuspend")
    public static final class a extends D7.i implements p<InterfaceC0413z, B7.e<? super p188x7.k>, Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i8.d f19145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l f19146c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ l f19147d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f19148e;

        /* JADX INFO: renamed from: h8.l$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SoundPoolPlayer.kt */
        @D7.e(c = "xyz.luan.audioplayers.player.SoundPoolPlayer$urlSource$1$1$1", f = "SoundPoolPlayer.kt", l = {}, m = "invokeSuspend")
        public static final class C0208a extends D7.i implements p<InterfaceC0413z, B7.e<? super p188x7.k>, Object> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f19149b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ l f19150c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f19151d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ l f19152e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ i8.d f19153f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ long f19154g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0208a(l lVar, String str, l lVar2, i8.d dVar, long j, B7.e<? super C0208a> eVar) {
                super(2, eVar);
                this.f19150c = lVar;
                this.f19151d = str;
                this.f19152e = lVar2;
                this.f19153f = dVar;
                this.f19154g = j;
            }

            @Override // D7.a
            public final B7.e<p188x7.k> create(Object obj, B7.e<?> eVar) {
                C0208a c0208a = new C0208a(this.f19150c, this.f19151d, this.f19152e, this.f19153f, this.f19154g, eVar);
                c0208a.f19149b = obj;
                return c0208a;
            }

            @Override // K7.p
            public final Object invoke(InterfaceC0413z interfaceC0413z, B7.e<? super p188x7.k> eVar) {
                return ((C0208a) create(interfaceC0413z, eVar)).invokeSuspend(p188x7.k.f22364a);
            }

            @Override // D7.a
            public final Object invokeSuspend(Object obj) {
                C7.a aVar = C7.a.f1806a;
                p188x7.g.b(obj);
                InterfaceC0413z interfaceC0413z = (InterfaceC0413z) this.f19149b;
                l lVar = this.f19150c;
                n nVar = lVar.f19137a;
                StringBuilder sb = new StringBuilder("Now loading ");
                String str = this.f19151d;
                sb.append(str);
                nVar.c(sb.toString());
                int iLoad = lVar.f19143g.f19155a.load(str, 1);
                lVar.f19143g.f19156b.put(new Integer(iLoad), this.f19152e);
                lVar.f19140d = new Integer(iLoad);
                lVar.f19137a.c("time to call load() for " + this.f19153f + ": " + (System.currentTimeMillis() - this.f19154g) + " player=" + interfaceC0413z);
                return p188x7.k.f22364a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i8.d dVar, l lVar, l lVar2, long j, B7.e<? super a> eVar) {
            super(2, eVar);
            this.f19145b = dVar;
            this.f19146c = lVar;
            this.f19147d = lVar2;
            this.f19148e = j;
        }

        @Override // D7.a
        public final B7.e<p188x7.k> create(Object obj, B7.e<?> eVar) {
            return new a(this.f19145b, this.f19146c, this.f19147d, this.f19148e, eVar);
        }

        @Override // K7.p
        public final Object invoke(InterfaceC0413z interfaceC0413z, B7.e<? super p188x7.k> eVar) {
            return ((a) create(interfaceC0413z, eVar)).invokeSuspend(p188x7.k.f22364a);
        }

        @Override // D7.a
        public final Object invokeSuspend(Object obj) throws IOException {
            String absolutePath;
            C7.a aVar = C7.a.f1806a;
            p188x7.g.b(obj);
            i8.d dVar = this.f19145b;
            boolean z8 = dVar.f19321b;
            String str = dVar.f19320a;
            if (z8) {
                absolutePath = R7.l.Y(str, "file://");
            } else {
                URL url = URI.create(str).toURL();
                kotlin.jvm.internal.k.d(url, "toURL(...)");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                InputStream inputStreamOpenStream = url.openStream();
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i9 = inputStreamOpenStream.read(bArr);
                        Integer numValueOf = Integer.valueOf(i9);
                        if (i9 <= 0) {
                            numValueOf = null;
                        }
                        if (numValueOf == null) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, numValueOf.intValue());
                    }
                    p188x7.k kVar = p188x7.k.f22364a;
                    inputStreamOpenStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    kotlin.jvm.internal.k.d(byteArray, "toByteArray(...)");
                    File fileCreateTempFile = File.createTempFile(RemoteMessageConst.Notification.SOUND, "");
                    FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                    try {
                        fileOutputStream.write(byteArray);
                        fileCreateTempFile.deleteOnExit();
                        fileOutputStream.close();
                        absolutePath = fileCreateTempFile.getAbsolutePath();
                        kotlin.jvm.internal.k.d(absolutePath, "getAbsolutePath(...)");
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            p199z2.b.r(fileOutputStream, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        p199z2.b.r(inputStreamOpenStream, th3);
                        throw th4;
                    }
                }
            }
            String str2 = absolutePath;
            l lVar = this.f19146c;
            X7.c cVar = lVar.f19139c;
            Z7.c cVar2 = J.f4233a;
            C.c(cVar, o.f5165a, new C0208a(lVar, str2, this.f19147d, this.f19145b, this.f19148e, null), 2);
            return p188x7.k.f22364a;
        }
    }

    public l(n wrappedPlayer, k soundPoolManager) {
        kotlin.jvm.internal.k.e(wrappedPlayer, "wrappedPlayer");
        kotlin.jvm.internal.k.e(soundPoolManager, "soundPoolManager");
        this.f19137a = wrappedPlayer;
        this.f19138b = soundPoolManager;
        Z7.c cVar = J.f4233a;
        this.f19139c = A.a(o.f5165a);
        g8.a aVar = wrappedPlayer.f19160c;
        this.f19142f = aVar;
        soundPoolManager.a(aVar);
        g8.a audioContext = this.f19142f;
        kotlin.jvm.internal.k.e(audioContext, "audioContext");
        m mVar = soundPoolManager.f19136b.get(audioContext.a());
        if (mVar != null) {
            this.f19143g = mVar;
        } else {
            throw new IllegalStateException(("Could not create SoundPool " + this.f19142f).toString());
        }
    }

    @Override // h8.i
    public final void a(boolean z8) {
        Integer num = this.f19141e;
        if (num != null) {
            this.f19143g.f19155a.setLoop(num.intValue(), z8 ? -1 : 0);
        }
    }

    @Override // h8.i
    public final void b(i8.c source) {
        kotlin.jvm.internal.k.e(source, "source");
        source.b(this);
    }

    @Override // h8.i
    public final boolean d() {
        return false;
    }

    @Override // h8.i
    public final void e(float f6) {
        Integer num = this.f19141e;
        if (num != null) {
            this.f19143g.f19155a.setRate(num.intValue(), f6);
        }
    }

    @Override // h8.i
    public final void f(g8.a aVar) {
        if (!this.f19142f.a().equals(aVar.a())) {
            release();
            k kVar = this.f19138b;
            kVar.a(aVar);
            m mVar = kVar.f19136b.get(aVar.a());
            if (mVar == null) {
                throw new IllegalStateException(("Could not create SoundPool " + aVar).toString());
            }
            this.f19143g = mVar;
        }
        this.f19142f = aVar;
    }

    @Override // h8.i
    public final void g(float f6, float f9) {
        Integer num = this.f19141e;
        if (num != null) {
            this.f19143g.f19155a.setVolume(num.intValue(), f6, f9);
        }
    }

    @Override // h8.i
    public final /* bridge */ /* synthetic */ Integer getCurrentPosition() {
        return null;
    }

    @Override // h8.i
    public final /* bridge */ /* synthetic */ Integer getDuration() {
        return null;
    }

    public final void h(i8.d dVar) throws Throwable {
        l lVar;
        i8.d dVar2;
        Throwable th;
        if (dVar != null) {
            synchronized (this.f19143g.f19157c) {
                try {
                    Map<i8.d, List<l>> map = this.f19143g.f19157c;
                    List<l> arrayList = map.get(dVar);
                    if (arrayList == null) {
                        try {
                            arrayList = new ArrayList<>();
                            map.put(dVar, arrayList);
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                    List<l> list = arrayList;
                    l lVar2 = (l) y7.n.J(list);
                    if (lVar2 != null) {
                        boolean z8 = lVar2.f19137a.f19169m;
                        this.f19137a.h(z8);
                        this.f19140d = lVar2.f19140d;
                        this.f19137a.c("Reusing soundId " + this.f19140d + " for " + dVar + " is prepared=" + z8 + ' ' + this);
                        lVar = this;
                        dVar2 = dVar;
                    } else {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        this.f19137a.h(false);
                        this.f19137a.c("Fetching actual URL for " + dVar);
                        X7.c cVar = this.f19139c;
                        Z7.c cVar2 = J.f4233a;
                        lVar = this;
                        dVar2 = dVar;
                        try {
                            C.c(cVar, Z7.b.f5649c, new a(dVar2, lVar, this, jCurrentTimeMillis, null), 2);
                        } catch (Throwable th3) {
                            th = th3;
                            th = th;
                            throw th;
                        }
                    }
                    list.add(this);
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } else {
            lVar = this;
            dVar2 = dVar;
        }
        lVar.f19144h = dVar2;
    }

    @Override // h8.i
    public final void pause() {
        Integer num = this.f19141e;
        if (num != null) {
            this.f19143g.f19155a.pause(num.intValue());
        }
    }

    @Override // h8.i
    public final void release() {
        stop();
        Integer num = this.f19140d;
        if (num != null) {
            int iIntValue = num.intValue();
            i8.d dVar = this.f19144h;
            if (dVar == null) {
                return;
            }
            synchronized (this.f19143g.f19157c) {
                try {
                    List<l> list = this.f19143g.f19157c.get(dVar);
                    if (list == null) {
                        return;
                    }
                    if ((list.size() == 1 ? list.get(0) : null) == this) {
                        this.f19143g.f19157c.remove(dVar);
                        this.f19143g.f19155a.unload(iIntValue);
                        this.f19143g.f19156b.remove(num);
                        this.f19137a.c("unloaded soundId " + iIntValue);
                    } else {
                        list.remove(this);
                    }
                    this.f19140d = null;
                    h(null);
                    p188x7.k kVar = p188x7.k.f22364a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // h8.i
    public final void seekTo(int i9) {
        if (i9 != 0) {
            throw new UnsupportedOperationException("LOW_LATENCY mode does not support: seek");
        }
        Integer num = this.f19141e;
        if (num != null) {
            int iIntValue = num.intValue();
            stop();
            if (this.f19137a.f19170n) {
                this.f19143g.f19155a.resume(iIntValue);
            }
        }
    }

    @Override // h8.i
    public final void start() {
        Integer num = this.f19141e;
        Integer num2 = this.f19140d;
        if (num != null) {
            this.f19143g.f19155a.resume(num.intValue());
            return;
        }
        if (num2 != null) {
            SoundPool soundPool = this.f19143g.f19155a;
            int iIntValue = num2.intValue();
            n nVar = this.f19137a;
            float f6 = nVar.f19164g;
            this.f19141e = Integer.valueOf(soundPool.play(iIntValue, f6, f6, 0, nVar.j == g8.e.f18992b ? -1 : 0, nVar.f19166i));
        }
    }

    @Override // h8.i
    public final void stop() {
        Integer num = this.f19141e;
        if (num != null) {
            this.f19143g.f19155a.stop(num.intValue());
            this.f19141e = null;
        }
    }

    @Override // h8.i
    public final void c() {
    }

    @Override // h8.i
    public final void reset() {
    }
}
