package O3;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: BaseMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f3467b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3468a;

    public static boolean c(E.a aVar) {
        String str = (String) aVar.f1949e;
        ConcurrentHashMap<String, Long> concurrentHashMap = f3467b;
        if (!concurrentHashMap.containsKey(str)) {
            concurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
            return true;
        }
        if (System.currentTimeMillis() - concurrentHashMap.get(str).longValue() < 10000) {
            return false;
        }
        concurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
        return true;
    }

    @Override // O3.b
    public final synchronized boolean a(E.a aVar) {
        try {
            if (!b().equals((String) aVar.f1948d)) {
                return false;
            }
            try {
                if (!c(aVar) || !d(aVar)) {
                    if (F3.a.b(this.f3468a).f2038c.f2834b) {
                        A1.b.Z("checkCmdInterval false: ignored for now.");
                    }
                    return false;
                }
                if (F3.a.b(this.f3468a).f2038c.f2834b) {
                    A1.b.Z("start handle message:" + aVar);
                }
                return e(aVar);
            } catch (Exception e9) {
                StringWriter stringWriter = new StringWriter();
                e9.printStackTrace(new PrintWriter(stringWriter));
                String str = "系统错误：" + stringWriter.toString();
                H3.a aVar2 = new H3.a(this.f3468a, (String) aVar.f1949e, null);
                aVar2.f2411b = 3;
                aVar2.f2412c = str;
                G3.a.a(aVar2);
                return false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract String b();

    public final boolean d(E.a aVar) {
        F3.a aVarB = F3.a.b(this.f3468a);
        if (aVarB.f2036a.get((String) aVar.f1949e) != Boolean.TRUE || Q3.a.a(F3.a.b(this.f3468a).f2038c.f2835c)) {
            return true;
        }
        A1.b.x(0, this.f3468a, (String) aVar.f1949e, "产物超过阈值，等待WiFi环境执行");
        return false;
    }

    public abstract boolean e(E.a aVar);
}
