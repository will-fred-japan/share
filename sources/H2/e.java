package H2;

import android.content.SharedPreferences;
import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: CpuCollectManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f2378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f2379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f2380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences f2381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public V2.a f2382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p193y3.a f2383f;

    /* JADX INFO: compiled from: CpuCollectManager.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f2384a;

        static {
            e eVar = new e();
            eVar.f2378a = new AtomicBoolean(false);
            try {
                eVar.f2383f = A1.b.w(p061i1.h.f19229a);
            } catch (Throwable unused) {
            }
            p193y3.a aVar = eVar.f2383f;
            f fVar = new f();
            fVar.f2385a = new AtomicBoolean(false);
            fVar.f2387c = aVar;
            eVar.f2380c = fVar;
            p193y3.a aVar2 = eVar.f2383f;
            h hVar = new h();
            hVar.j = true;
            hVar.f2392b = new AtomicBoolean(false);
            hVar.f2391a = fVar;
            hVar.f2399i = aVar2;
            eVar.f2379b = hVar;
            f2384a = eVar;
        }
    }

    public final void a() {
        BufferedReader bufferedReader;
        String line;
        Map<String, ?> all = this.f2381d.getAll();
        if (all != null) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                try {
                    String key = entry.getKey();
                    try {
                        bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + ((String) entry.getValue()).split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0] + "/stat").getPath()), 100);
                        try {
                            line = bufferedReader.readLine();
                            bufferedReader.close();
                        } catch (Throwable unused) {
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            line = "";
                        }
                    } catch (Throwable unused2) {
                        bufferedReader = null;
                    }
                    if (line.isEmpty()) {
                        this.f2381d.edit().remove(key).apply();
                    } else {
                        String str = line.split(" ")[1];
                        if (!key.endsWith(str.substring(1, str.length() - 1))) {
                            this.f2381d.edit().remove(key).apply();
                        }
                    }
                } catch (Throwable unused3) {
                }
            }
        }
    }

    public final boolean b() {
        if (!this.f2382e.isForeground()) {
            Map<String, ?> all = this.f2381d.getAll();
            if (all != null) {
                Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                while (it.hasNext()) {
                    try {
                        if (((String) it.next().getValue()).split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1].equals("true")) {
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            return this.f2382e.isForeground();
        }
        this.f2381d.edit().putString(N2.a.u1(), Process.myPid() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f2382e.isForeground()).apply();
        return true;
    }
}
