package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.xiaomi.push.service.XMPushService;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class gp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f17539a = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected gq f509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected XMPushService f511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected int f507a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected long f508a = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    protected volatile long f517b = 0;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    protected volatile long f520c = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f514a = new LinkedList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Collection<gs> f513a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected final Map<gu, a> f515a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    protected final Map<gu, a> f519b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected gy f510a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected String f512a = "";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    protected String f518b = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected AtomicBoolean f516a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17541c = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f17540b = f17539a.getAndIncrement();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17543e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected long f17542d = 0;

    static {
        f506a = false;
        try {
            f506a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        gv.m442a();
    }

    public gp(XMPushService xMPushService, gq gqVar) {
        this.f509a = gqVar;
        this.f511a = xMPushService;
        m435b();
    }

    public abstract void a(hd hdVar);

    public abstract void a(com.xiaomi.push.service.ax.b bVar);

    public abstract void a(String str, String str2);

    public abstract void a(gg[] ggVarArr);

    /* JADX INFO: renamed from: a */
    public boolean mo425a() {
        return false;
    }

    public abstract void b(int i9, Exception exc);

    public abstract void b(gg ggVar);

    public abstract void b(boolean z8);

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m436b() {
        return this.f516a.compareAndSet(true, false);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m437c() {
        return this.f17541c == 0;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m438d() {
        return this.f17541c == 1;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private gu f17544a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private gz f521a;

        public a(gu guVar, gz gzVar) {
            this.f17544a = guVar;
            this.f521a = gzVar;
        }

        public void a(hd hdVar) {
            gz gzVar = this.f521a;
            if (gzVar == null || gzVar.mo220a(hdVar)) {
                this.f17544a.a(hdVar);
            }
        }

        public void a(gg ggVar) {
            this.f17544a.a(ggVar);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public gq m431a() {
        return this.f509a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m434b() {
        return this.f509a.b();
    }

    public synchronized void c() {
        this.f17543e = SystemClock.elapsedRealtime();
    }

    public void d() {
        synchronized (this.f514a) {
            this.f514a.clear();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo432a() {
        return this.f509a.c();
    }

    public void b(gs gsVar) {
        this.f513a.remove(gsVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m430a() {
        return this.f520c;
    }

    public void b(gu guVar, gz gzVar) {
        if (guVar != null) {
            this.f519b.put(guVar, new a(guVar, gzVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    public void a(gs gsVar) {
        if (gsVar == null || this.f513a.contains(gsVar)) {
            return;
        }
        this.f513a.add(gsVar);
    }

    public void a(gu guVar, gz gzVar) {
        if (guVar != null) {
            this.f515a.put(guVar, new a(guVar, gzVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    public void b(gu guVar) {
        this.f519b.remove(guVar);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m435b() {
        String property;
        if (this.f509a.m440a() && this.f510a == null) {
            Class<?> cls = null;
            try {
                property = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                property = null;
            }
            if (property != null) {
                try {
                    cls = Class.forName(property);
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
            }
            if (cls == null) {
                this.f510a = new go(this);
                return;
            }
            try {
                this.f510a = (gy) cls.getConstructor(gp.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e10) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e10);
            }
        }
    }

    public void a(gu guVar) {
        this.f515a.remove(guVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<gu, a> m433a() {
        return this.f515a;
    }

    public int a() {
        return this.f507a;
    }

    public void a(int i9, int i10, Exception exc) {
        int i11 = this.f17541c;
        if (i9 != i11) {
            com.xiaomi.channel.commonutils.logger.c.m9a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i11), a(i9), com.xiaomi.push.service.ay.a(i10)));
        }
        if (ax.m111a((Context) this.f511a)) {
            m429a(i9);
        }
        if (i9 == 1) {
            this.f511a.a(10);
            if (this.f17541c != 0) {
                com.xiaomi.channel.commonutils.logger.c.m9a("try set connected while not connecting.");
            }
            this.f17541c = i9;
            Iterator<gs> it = this.f513a.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
            return;
        }
        if (i9 == 0) {
            if (this.f17541c != 2) {
                com.xiaomi.channel.commonutils.logger.c.m9a("try set connecting while not disconnected.");
            }
            this.f17541c = i9;
            Iterator<gs> it2 = this.f513a.iterator();
            while (it2.hasNext()) {
                it2.next().a(this);
            }
            return;
        }
        if (i9 == 2) {
            this.f511a.a(10);
            int i12 = this.f17541c;
            if (i12 == 0) {
                Iterator<gs> it3 = this.f513a.iterator();
                while (it3.hasNext()) {
                    it3.next().a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i12 == 1) {
                Iterator<gs> it4 = this.f513a.iterator();
                while (it4.hasNext()) {
                    it4.next().a(this, i10, exc);
                }
            }
            this.f17541c = i9;
        }
    }

    public int b() {
        return this.f17541c;
    }

    private String a(int i9) {
        if (i9 == 1) {
            return "connected";
        }
        if (i9 == 0) {
            return "connecting";
        }
        if (i9 == 2) {
            return "disconnected";
        }
        return "unknown";
    }

    public synchronized void a(String str) {
        try {
            if (this.f17541c == 0) {
                com.xiaomi.channel.commonutils.logger.c.m9a("setChallenge hash = " + bl.a(str).substring(0, 8));
                this.f512a = str;
                a(1, 0, null);
            } else {
                com.xiaomi.channel.commonutils.logger.c.m9a("ignore setChallenge because connection was disconnected");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean a(long j) {
        return this.f17543e >= j;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m429a(int i9) {
        synchronized (this.f514a) {
            try {
                if (i9 == 1) {
                    this.f514a.clear();
                } else {
                    this.f514a.add(new Pair<>(Integer.valueOf(i9), Long.valueOf(System.currentTimeMillis())));
                    if (this.f514a.size() > 6) {
                        this.f514a.remove(0);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
