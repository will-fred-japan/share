package Q2;

import E4.c;
import com.bytedance.services.slardar.config.IConfigManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: ConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f3741e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f3742a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CopyOnWriteArrayList f3743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f3744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f3745d;

    public static a a() {
        if (f3741e == null) {
            synchronized (a.class) {
                try {
                    if (f3741e == null) {
                        f3741e = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3741e;
    }

    public final void b(b bVar) {
        if (this.f3743b == null) {
            this.f3743b = new CopyOnWriteArrayList();
        }
        if (!this.f3743b.contains(bVar)) {
            this.f3743b.add(bVar);
        }
        if (this.f3745d) {
            bVar.a(this.f3744c);
        }
    }

    public final synchronized void c() {
        if (this.f3742a) {
            return;
        }
        this.f3742a = true;
        ((IConfigManager) c.a(IConfigManager.class)).registerConfigListener(new C0043a());
    }

    /* JADX INFO: renamed from: Q2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConfigManager.java */
    public class C0043a implements p175w3.a {
        public C0043a() {
        }

        @Override // p175w3.a
        public final void onRefresh(JSONObject jSONObject, boolean z8) {
            if (A1.b.f1393A) {
                p010b3.b.a("APM-Config", "config:" + jSONObject);
            }
            a aVar = a.this;
            aVar.f3744c = jSONObject;
            aVar.f3745d = true;
            CopyOnWriteArrayList copyOnWriteArrayList = aVar.f3743b;
            if (copyOnWriteArrayList != null) {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    try {
                        ((b) it.next()).a(jSONObject);
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        @Override // p175w3.a
        public final void onReady() {
        }
    }
}
