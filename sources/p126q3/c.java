package p126q3;

import A1.b;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.apm.insight.Npth;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import p056h5.C0598e;
import p061i1.h;

/* JADX INFO: compiled from: HeapDumper.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile c f20917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f20918c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20919a = System.currentTimeMillis();

    /* JADX INFO: compiled from: HeapDumper.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            c.this.d();
        }
    }

    public c() {
        b.M(p108o3.a.c().f20682a, "You must call init() first before using !!!");
    }

    public static boolean b() {
        long availableBytes;
        try {
            if (TextUtils.isEmpty(p108o3.a.c().f20687f)) {
                availableBytes = "mounted".equals(Environment.getExternalStorageState()) ? new StatFs(Environment.getExternalStorageDirectory().getPath()).getAvailableBytes() : 0L;
            } else {
                availableBytes = new StatFs(new File(p108o3.a.c().f20687f).getPath()).getAvailableBytes();
            }
        } catch (Throwable unused) {
        }
        try {
            long jD = p099n1.a.d();
            return availableBytes > 0 && jD > 0 && ((float) availableBytes) > ((float) jD) * 1.5f;
        } catch (Exception e9) {
            e9.printStackTrace();
            return false;
        }
    }

    public static c e() {
        if (f20917b == null) {
            synchronized (c.class) {
                try {
                    if (f20917b == null) {
                        f20917b = new c();
                        f20918c = b.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f20917b;
    }

    public final void a(long j) {
        this.f20919a = j;
        p143s3.b.d().e();
        if (p108o3.a.c().b().f21405c == 2) {
            p117p3.a.f20787b.execute(new a());
        } else {
            d();
        }
    }

    /* JADX WARN: Code duplicated, block: B:66:0x01c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void c() throws Throwable {
        Exception e9;
        Throwable th;
        long jNanoTime = System.nanoTime();
        File file = f20918c.f20910a;
        if (file == null) {
            return;
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        b.S0("dump_begin");
        p108o3.a.c().b().getClass();
        FileOutputStream fileOutputStream = null;
        try {
            if (p108o3.a.c().b().f21405c == 2) {
                C0598e.o("Native dump", new Object[0]);
                try {
                    Npth.dumpHprof(file.getAbsolutePath());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    if (h.f19230b) {
                        Log.d("ApmInsight", p199z2.b.f(new String[]{"Npth.dumpHprof() error :" + th2.getMessage()}));
                    }
                }
                Thread.sleep(30000L);
                C0598e.o("Native dump exist ? " + new File(file.getAbsolutePath()).exists(), new Object[0]);
            } else {
                Debug.dumpHprofData(file.getAbsolutePath());
            }
            p143s3.b.d().e().edit().putString("updateVersionCode", h.d().optString("update_version_code")).commit();
        } catch (Exception e10) {
            C0598e.n(e10, "Could not realDump heap", new Object[0]);
            file = null;
        }
        p143s3.b.d().e().edit().putBoolean("hasShrink", false).commit();
        b.S0("dump_end");
        b.P("dump_time", System.currentTimeMillis() - jCurrentTimeMillis);
        if (file == null) {
            return;
        }
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
        p143s3.a.C0254a c0254a = new p143s3.a.C0254a();
        c0254a.f21213b = file;
        c0254a.f21217f = 0L;
        c0254a.f21219h = this.f20919a;
        long j = h.f19238k;
        long jF = h.f();
        if (j <= 0) {
            j = jF;
        }
        c0254a.f21220i = j;
        file.length();
        c0254a.f21212a = p011b4.h.f8543c;
        c0254a.f21218g = millis;
        b.M(c0254a.f21213b, "heapDumpFile");
        p143s3.a aVar = new p143s3.a(c0254a);
        C0598e.o(aVar.toString(), new Object[0]);
        p143s3.b bVarD = p143s3.b.d();
        bVarD.f21224c = aVar;
        File file2 = b.a().f20911b;
        if (file2.exists()) {
            file2.delete();
        }
        C0598e.o("analyzedHeapFile.getHeapDumpFilePath() %s", file2.getPath());
        bVarD.e().edit().putString("filePath", file2.getPath()).commit();
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                p143s3.b.c(aVar, jSONObject);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileOutputStream2.write(jSONObject.toString().getBytes());
                    fileOutputStream2.close();
                } catch (Exception e11) {
                    e9 = e11;
                    fileOutputStream = fileOutputStream2;
                    try {
                        C0598e.n(e9, "Could not save leak analysis result to disk.", new Object[0]);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        p143s3.b bVarD2 = p143s3.b.d();
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        bVarD2.f21226e = true;
                        bVarD2.e().edit().putLong("lastDumpTime", jCurrentTimeMillis2).commit();
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (Exception e12) {
            e9 = e12;
        } catch (Throwable th5) {
            th = th5;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        p143s3.b bVarD3 = p143s3.b.d();
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        bVarD3.f21226e = true;
        bVarD3.e().edit().putLong("lastDumpTime", jCurrentTimeMillis3).commit();
    }

    public final void d() throws Throwable {
        try {
            if (b()) {
                c();
                u3.a aVarA = u3.a.a();
                aVarA.getClass();
                C0598e.o("finish dumpHeap", new Object[0]);
                aVarA.f21674c = false;
            }
        } catch (Exception e9) {
            e9.printStackTrace();
        }
    }
}
