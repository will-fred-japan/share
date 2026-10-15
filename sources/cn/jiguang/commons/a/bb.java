package cn.jiguang.commons.a;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class bb<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final AtomicLong f9711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final String f9712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final long f9713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final String f9714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f9715h;
    private final ConcurrentLinkedQueue<be<T>> j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final CopyOnWriteArrayList<String> f9708a = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final AtomicReference<T> f9709b = new AtomicReference<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final AtomicBoolean f9710c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f9716i = new AtomicBoolean(false);

    public bb(String str, String str2, long j, String str3) {
        AtomicLong atomicLong = new AtomicLong(0L);
        this.f9711d = atomicLong;
        this.j = new ConcurrentLinkedQueue<>();
        this.f9712e = str2;
        this.f9713f = 86400000L;
        this.f9714g = str3;
        this.f9715h = str;
        a();
        long jB = kq.a().b(str3 + "config_last_request_time", 0L);
        atomicLong.set(jB);
        ee.a(this.f9715h, "loaded last request time:" + jB);
    }

    private String e() {
        try {
            if (!jf.c()) {
                ee.d(this.f9715h, "network not available, skipping config request");
                return null;
            }
            JSONObject jSONObjectB = b();
            if (jSONObjectB == null) {
                ee.d(this.f9715h, "failed to build request parameters");
                return null;
            }
            ee.a(this.f9715h, "requesting config with params:" + jSONObjectB.toString());
            Iterator<String> it = this.f9708a.iterator();
            while (it.hasNext()) {
                String strB = b(it.next(), jSONObjectB);
                if (strB != null) {
                    return strB;
                }
            }
            return null;
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("request config failed:"), this.f9715h);
            return null;
        }
    }

    public abstract eh a(String str, JSONObject jSONObject);

    public abstract T a(String str);

    public abstract void a();

    public abstract boolean a(T t);

    public abstract JSONObject b();

    public abstract T c();

    public final void d() {
        try {
            String strB = jq.b(this.f9712e);
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            ee.a(this.f9715h, "recovering config from cache:" + this.f9712e);
            T tA = a(strB);
            if (a(tA)) {
                this.f9709b.set(tA);
                ee.a(this.f9715h, "config recovered from cache successfully");
            } else {
                jq.a(this.f9712e);
                ee.d(this.f9715h, "invalid config recovered from cache");
            }
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("error recovering config from cache:"), this.f9715h);
        }
    }

    public static /* synthetic */ void a(bb bbVar, be beVar) {
        be<T> beVar2;
        Object objC;
        try {
            if (!jf.c()) {
                ee.d(bbVar.f9715h, "network not available, using cached/default config");
                Object objC2 = bbVar.c();
                bbVar.f9709b.set((T) objC2);
                a((be<Object>) beVar, objC2);
                bbVar.f9710c.set(false);
                while (true) {
                    be<T> beVarPoll = bbVar.j.poll();
                    if (beVarPoll == null) {
                        return;
                    } else {
                        beVarPoll.a(bbVar.f9709b.get());
                    }
                }
            } else if (bbVar.f9710c.compareAndSet(false, true)) {
                ee.a(bbVar.f9715h, "requesting config from network");
                if (bbVar.e() != null) {
                    ee.a(bbVar.f9715h, "network config request successful");
                    em.a(bbVar.f9715h);
                    objC = bbVar.f9709b.get();
                } else {
                    objC = bbVar.f9709b.get();
                    if (objC == null) {
                        objC = bbVar.c();
                        bbVar.f9709b.set((T) objC);
                    }
                }
                a((be<Object>) beVar, objC);
                bbVar.f9710c.set(false);
                while (true) {
                    be<T> beVarPoll2 = bbVar.j.poll();
                    if (beVarPoll2 == null) {
                        return;
                    } else {
                        beVarPoll2.a(bbVar.f9709b.get());
                    }
                }
            } else {
                ee.a(bbVar.f9715h, "request already in progress, adding callback to queue");
                if (beVar != null) {
                    bbVar.j.offer(beVar);
                }
                bbVar.f9710c.set(false);
                while (true) {
                    be<T> beVarPoll3 = bbVar.j.poll();
                    if (beVarPoll3 == null) {
                        return;
                    } else {
                        beVarPoll3.a(bbVar.f9709b.get());
                    }
                }
            }
        } catch (Throwable unused) {
            try {
                a((be<Object>) beVar, (Object) null);
                while (true) {
                    if (beVar2 == null) {
                        return;
                    }
                }
            } finally {
                bbVar.f9710c.set(false);
                while (true) {
                    be<T> beVarPoll4 = bbVar.j.poll();
                    if (beVarPoll4 != null) {
                        beVarPoll4.a(bbVar.f9709b.get());
                    }
                }
            }
        }
    }

    private String b(String str, JSONObject jSONObject) {
        String str2;
        String str3;
        try {
            eh ehVarA = a(str, jSONObject);
            if (ehVarA == null) {
                ee.d(this.f9715h, "failed to create config request for " + str);
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            kq.a().a(this.f9714g + "config_last_request_time", jCurrentTimeMillis);
            this.f9711d.set(jCurrentTimeMillis);
            ee.a(this.f9715h, "saved last request time:" + jCurrentTimeMillis);
            ei eiVarA = ej.a(ehVarA);
            if (eiVarA == null) {
                ee.d(this.f9715h, "empty http response from " + str);
                return null;
            }
            int iC = eiVarA.c();
            ee.a(this.f9715h, "response code from " + str + Constants.COLON_SEPARATOR + iC);
            if (iC == 200) {
                String strA = eiVarA.a();
                ee.a(this.f9715h, "ori response=" + strA);
                if (TextUtils.isEmpty(strA)) {
                    str2 = this.f9715h;
                    str3 = "response body is empty from " + str;
                } else {
                    try {
                        T tA = a(strA);
                        if (a(tA)) {
                            jq.a(this.f9712e, strA);
                            this.f9709b.set(tA);
                            return strA;
                        }
                    } catch (Throwable th) {
                        ee.e(this.f9715h, "error parsing config from " + str + Constants.COLON_SEPARATOR + th.getMessage());
                        return null;
                    }
                }
                return null;
            }
            str2 = this.f9715h;
            str3 = "response code is not 200 from " + str + ": " + iC;
            ee.d(str2, str3);
            return null;
        } catch (Throwable th2) {
            W5.f.o(th2, defpackage.f.i("error sending request to ", str, Constants.COLON_SEPARATOR), this.f9715h);
            return null;
        }
    }

    public final void a(be<T> beVar) {
        if (beVar == null) {
            return;
        }
        fe.a().a(new bc(this, beVar), fl.NETWORK);
    }

    private static void a(be<T> beVar, T t) {
        if (beVar != null) {
            beVar.a(t);
        }
    }

    public final void b(be<T> beVar) {
        this.f9716i.set(true);
        a((be) beVar);
    }
}
