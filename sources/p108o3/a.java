package p108o3;

import N1.g;
import android.app.Application;
import android.content.res.AssetFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import p056h5.C0598e;
import p061i1.h;
import p099n1.d;
import p126q3.c;

/* JADX INFO: compiled from: MemoryApi.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile a f20681g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f20682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p151t3.a f20683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0239a f20684c = new C0239a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f20685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f20686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f20687f;

    /* JADX INFO: renamed from: o3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MemoryApi.java */
    public class C0239a {
    }

    /* JADX INFO: compiled from: MemoryApi.java */
    public class b implements Runnable {
        public b() {
        }

        /* JADX WARN: Code duplicated, block: B:80:0x01c3  */
        /* JADX WARN: Code duplicated, block: B:87:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            FileInputStream fileInputStream;
            int i9 = 1;
            boolean z8 = false;
            if (a.this.f20683b.f21405c == 2) {
                c.e().getClass();
                if (c.b()) {
                    u3.a aVarA = u3.a.a();
                    a aVar = a.this;
                    p151t3.a aVar2 = aVar.f20683b;
                    C0239a c0239a = aVar.f20684c;
                    if (aVarA.f21672a) {
                        C0598e.o("startCheck canAnalyse", new Object[0]);
                    } else {
                        aVarA.f21673b = false;
                        ScheduledFuture<?> scheduledFuture = aVarA.f21676e;
                        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                            C0598e.o("enter startCheck", new Object[0]);
                            aVarA.f21675d = c0239a;
                            long j = a.c().a() ? 1 : 30;
                            aVarA.f21676e = p117p3.a.f20786a.scheduleWithFixedDelay(new Q.a(aVarA, aVar2, 6, z8), j, j, TimeUnit.SECONDS);
                        }
                    }
                }
            }
            a aVar3 = a.this;
            aVar3.getClass();
            if (!p143s3.b.d().f21226e) {
                p143s3.b bVarD = p143s3.b.d();
                if (bVarD.f21224c == null) {
                    String string = bVarD.e().getString("filePath", "");
                    if (!TextUtils.isEmpty(string)) {
                        File file = new File(string);
                        AssetFileDescriptor.AutoCloseInputStream autoCloseInputStream = 0;
                        aVar = null;
                        aVar = null;
                        aVar = null;
                        p143s3.a aVar4 = null;
                        if (file.exists()) {
                            StringBuilder sb = new StringBuilder();
                            try {
                                try {
                                    fileInputStream = new FileInputStream(file);
                                    while (true) {
                                        try {
                                            int i10 = fileInputStream.read();
                                            if (i10 == -1) {
                                                break;
                                            } else {
                                                sb.append((char) i10);
                                            }
                                        } catch (Exception e9) {
                                            e = e9;
                                            if (file.delete()) {
                                                C0598e.n(e, "Could not read result file %s, deleted it.", file);
                                            } else {
                                                C0598e.n(e, "Could not read result file %s, could not delete it either.", file);
                                            }
                                            if (fileInputStream != null) {
                                                try {
                                                    fileInputStream.close();
                                                } catch (IOException unused) {
                                                }
                                            }
                                        }
                                    }
                                    JSONObject jSONObject = new JSONObject(sb.toString());
                                    p143s3.a aVarA2 = p143s3.b.a(new File(jSONObject.optString("heapDumpFilePath")), jSONObject);
                                    bVarD.f21224c = aVarA2;
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                    aVar4 = aVarA2;
                                } catch (Throwable th) {
                                    th = th;
                                    autoCloseInputStream = "filePath";
                                    if (autoCloseInputStream != 0) {
                                        try {
                                            autoCloseInputStream.close();
                                        } catch (IOException unused3) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                fileInputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                if (autoCloseInputStream != 0) {
                                    autoCloseInputStream.close();
                                }
                                throw th;
                            }
                        } else {
                            bVarD.e().edit().putString("filePath", "").commit();
                        }
                        C0598e.o("cache heapdump %s", aVar4);
                        bVarD.f21224c = aVar4;
                    }
                }
                aVar3.f20683b.getClass();
                C0598e.o("upload mode", new Object[0]);
                List<String> list = p101n3.a.f20575a;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - p101n3.a.f20578d < 300000 || !p126q3.b.a().b()) {
                    C0598e.o("uploadCheck return", new Object[0]);
                } else {
                    a aVarC = a.c();
                    A1.b.M(aVarC.f20682a, "You must call init() first before using !!!");
                    if (d.b(aVarC.f20682a)) {
                        if (!TextUtils.equals(h.d().optString("update_version_code", ""), p143s3.b.d().e().getString("updateVersionCode", ""))) {
                            p143s3.b.d().b();
                        } else if (h.f19250x) {
                            p101n3.a.f20578d = jCurrentTimeMillis;
                            if (A1.b.b0(p101n3.a.f20577c) || a.c().a()) {
                                C0598e.o("hprof_force_upload", new Object[0]);
                                p143s3.b.d().f();
                            } else {
                                p117p3.a.f20787b.execute(new g(i9));
                            }
                        } else if (h.f19230b) {
                            Log.d("ApmInsight", p199z2.b.f(new String[]{"can not report,memory upload check return"}));
                        }
                    } else {
                        C0598e.o("uploadCheck return", new Object[0]);
                    }
                }
            }
            a.this.f20686e = false;
        }
    }

    public static a c() {
        if (f20681g == null) {
            synchronized (a.class) {
                try {
                    if (f20681g == null) {
                        f20681g = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f20681g;
    }

    public final boolean a() {
        try {
            p151t3.a aVar = this.f20683b;
            if (aVar != null && aVar.f21403a) {
                try {
                    if ((this.f20682a.getApplicationInfo().flags & 2) != 0) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception e9) {
            C0598e.o(Log.getStackTraceString(e9), new Object[0]);
        }
        return false;
    }

    public final p151t3.a b() {
        A1.b.M(this.f20683b, p151t3.a.class.getSimpleName().concat(" mustn't be null"));
        return this.f20683b;
    }

    public final void d() {
        if (this.f20686e) {
            return;
        }
        C0598e.o("MemoryApi start", new Object[0]);
        this.f20686e = true;
        if (!this.f20685d) {
            throw new IllegalStateException("You must call init() first before using !!!");
        }
        p117p3.a.f20787b.execute(new b());
    }
}
