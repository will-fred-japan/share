package p178w6;

import K7.l;
import android.content.Context;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.jvm.internal.k;
import p187x6.b;
import q6.e;
import q6.f;

/* JADX INFO: compiled from: MediaRecorder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f22132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f22133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f22134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MediaRecorder f22135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f22136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f22137g;

    public c(Context context, b recorderStateStreamHandler) {
        k.e(context, "context");
        k.e(recorderStateStreamHandler, "recorderStateStreamHandler");
        this.f22131a = context;
        this.f22132b = recorderStateStreamHandler;
        this.f22136f = -160.0d;
    }

    @Override // p178w6.b
    public final void a() {
        MediaRecorder mediaRecorder = this.f22135e;
        if (mediaRecorder != null) {
            try {
                if (this.f22134d) {
                    mediaRecorder.resume();
                    h(f.RECORD);
                }
            } catch (IllegalStateException e9) {
                Log.d("MediaRecorder", R7.e.B("\n                        Did you call resume() before before start() or after stop()?\n                        " + e9.getMessage() + "\n                        "));
            }
        }
    }

    @Override // p178w6.b
    public final ArrayList b() {
        double dLog10;
        if (this.f22133c) {
            MediaRecorder mediaRecorder = this.f22135e;
            k.b(mediaRecorder);
            dLog10 = Math.log10(((double) mediaRecorder.getMaxAmplitude()) / 32768.0d) * ((double) 20);
            if (dLog10 > this.f22136f) {
                this.f22136f = dLog10;
            }
        } else {
            dLog10 = -160.0d;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Double.valueOf(dLog10));
        arrayList.add(Double.valueOf(this.f22136f));
        return arrayList;
    }

    @Override // p178w6.b
    public final boolean c() {
        return this.f22134d;
    }

    @Override // p178w6.b
    public final void cancel() {
        g();
        e eVar = this.f22137g;
        String str = eVar != null ? eVar.f21008a : null;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (SecurityException unused) {
        }
    }

    @Override // p178w6.b
    public final boolean d() {
        return this.f22133c;
    }

    @Override // p178w6.b
    public final void dispose() {
        g();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0053  */
    @Override // p178w6.b
    public final void e(e eVar) throws Exception {
        int i9;
        g();
        int i10 = Build.VERSION.SDK_INT;
        MediaRecorder mediaRecorder = i10 < 31 ? new MediaRecorder() : E5.f.d(this.f22131a);
        mediaRecorder.setAudioSource(eVar.f21018l);
        mediaRecorder.setAudioEncodingBitRate(eVar.f21009b);
        mediaRecorder.setAudioSamplingRate(eVar.f21010c);
        int i11 = 1;
        int i12 = eVar.f21022p;
        if (1 >= i12) {
            i12 = 1;
        }
        if (2 <= i12) {
            i12 = 2;
        }
        mediaRecorder.setAudioChannels(i12);
        q6.b bVar = eVar.f21024r;
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            i9 = 2;
        } else if (iOrdinal == 3 || iOrdinal == 4) {
            i9 = 1;
        } else if (iOrdinal != 7) {
            i9 = 0;
        } else if (i10 >= 29) {
            i9 = 11;
        } else {
            i9 = 2;
        }
        mediaRecorder.setOutputFormat(i9);
        int iOrdinal2 = bVar.ordinal();
        if (iOrdinal2 == 0) {
            i11 = 3;
        } else if (iOrdinal2 == 1) {
            i11 = 5;
        } else if (iOrdinal2 == 2) {
            i11 = 4;
        } else if (iOrdinal2 != 3) {
            if (iOrdinal2 == 4) {
                i11 = 2;
            } else if (iOrdinal2 == 7 && i10 >= 29) {
                i11 = 7;
            } else {
                Log.d("MediaRecorder", "Falling back to AAC LC");
                i11 = 3;
            }
        }
        mediaRecorder.setAudioEncoder(i11);
        mediaRecorder.setOutputFile(eVar.f21008a);
        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
            this.f22137g = eVar;
            this.f22135e = mediaRecorder;
            h(f.RECORD);
        } catch (IOException e9) {
            mediaRecorder.release();
            throw new Exception(e9);
        } catch (IllegalStateException e10) {
            mediaRecorder.release();
            throw new Exception(e10);
        }
    }

    @Override // p178w6.b
    public final void f(l<? super String, p188x7.k> lVar) {
        g();
        e eVar = this.f22137g;
        lVar.invoke(eVar != null ? eVar.f21008a : null);
    }

    public final void g() {
        MediaRecorder mediaRecorder = this.f22135e;
        if (mediaRecorder != null) {
            try {
                if (this.f22133c || this.f22134d) {
                    mediaRecorder.stop();
                }
            } catch (RuntimeException unused) {
            } finally {
                MediaRecorder mediaRecorder2 = this.f22135e;
                k.b(mediaRecorder2);
                mediaRecorder2.reset();
                MediaRecorder mediaRecorder3 = this.f22135e;
                k.b(mediaRecorder3);
                mediaRecorder3.release();
                this.f22135e = null;
            }
        }
        h(f.STOP);
        this.f22136f = -160.0d;
    }

    public final void h(f fVar) {
        int iOrdinal = fVar.ordinal();
        b bVar = this.f22132b;
        if (iOrdinal == 0) {
            this.f22133c = true;
            this.f22134d = true;
            bVar.c(f.PAUSE);
        } else if (iOrdinal == 1) {
            this.f22133c = true;
            this.f22134d = false;
            bVar.c(f.RECORD);
        } else {
            if (iOrdinal != 2) {
                throw new L4.b();
            }
            this.f22133c = false;
            this.f22134d = false;
            bVar.c(f.STOP);
        }
    }

    @Override // p178w6.b
    public final void pause() {
        MediaRecorder mediaRecorder = this.f22135e;
        if (mediaRecorder != null) {
            try {
                if (this.f22133c) {
                    mediaRecorder.pause();
                    h(f.PAUSE);
                }
            } catch (IllegalStateException e9) {
                Log.d("MediaRecorder", R7.e.B("\n                        Did you call pause() before before start() or after stop()?\n                        " + e9.getMessage() + "\n                        "));
            }
        }
    }
}
