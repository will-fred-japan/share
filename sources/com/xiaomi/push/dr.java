package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile dr f17269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f278a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f279a;

    public class a extends b {
        public a() {
            super();
        }

        @Override // com.xiaomi.push.dr.b, com.xiaomi.push.ai.b
        public void b() {
            dr.this.b();
        }
    }

    public class b extends ai.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f17274a = System.currentTimeMillis();

        public b() {
        }

        public boolean a() {
            return true;
        }

        @Override // com.xiaomi.push.ai.b
        public void b() {
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public final boolean m249b() {
            return System.currentTimeMillis() - this.f17274a > 172800000;
        }
    }

    private dr(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f279a = concurrentLinkedQueue;
        this.f278a = context;
        concurrentLinkedQueue.add(new a());
        b(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            File file = new File(this.f278a.getFilesDir() + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    private void c() {
        while (!this.f279a.isEmpty()) {
            b bVarPeek = this.f279a.peek();
            if (bVarPeek != null) {
                if (!bVarPeek.m249b() && this.f279a.size() <= 6) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.c.c("remove Expired task");
                this.f279a.remove(bVarPeek);
            }
        }
    }

    public static dr a(Context context) {
        if (f17269a == null) {
            synchronized (dr.class) {
                try {
                    if (f17269a == null) {
                        f17269a = new dr(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        f17269a.f278a = context;
        return f17269a;
    }

    private void b(long j) {
        if (this.f279a.isEmpty()) {
            return;
        }
        hn.a(new ai.b() { // from class: com.xiaomi.push.dr.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            ai.b f17272a;

            @Override // com.xiaomi.push.ai.b
            public void b() {
                b bVar = (b) dr.this.f279a.peek();
                if (bVar == null || !bVar.a()) {
                    return;
                }
                if (dr.this.f279a.remove(bVar)) {
                    this.f17272a = bVar;
                }
                ai.b bVar2 = this.f17272a;
                if (bVar2 != null) {
                    bVar2.b();
                }
            }

            @Override // com.xiaomi.push.ai.b
            /* JADX INFO: renamed from: c */
            public void mo250c() {
                ai.b bVar = this.f17272a;
                if (bVar != null) {
                    bVar.mo250c();
                }
            }
        }, j);
    }

    public class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17276a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        File f288a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f289a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        boolean f290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f17277b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        boolean f291b;

        public c(String str, String str2, File file, boolean z8) {
            super();
            this.f289a = str;
            this.f17277b = str2;
            this.f288a = file;
            this.f291b = z8;
        }

        private boolean c() {
            int i9;
            int i10 = 0;
            SharedPreferences sharedPreferences = dr.this.f278a.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                jCurrentTimeMillis = jSONObject.getLong(CrashHianalyticsData.TIME);
                i9 = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i9 = 0;
            }
            if (System.currentTimeMillis() - jCurrentTimeMillis >= 86400000) {
                jCurrentTimeMillis = System.currentTimeMillis();
            } else {
                if (i9 > 10) {
                    return false;
                }
                i10 = i9;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(CrashHianalyticsData.TIME, jCurrentTimeMillis);
                jSONObject2.put("times", i10 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e9) {
                com.xiaomi.channel.commonutils.logger.c.c("JSONException on put " + e9.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.dr.b
        public boolean a() {
            if (ax.d(dr.this.f278a)) {
                return true;
            }
            return this.f291b && ax.m111a(dr.this.f278a);
        }

        @Override // com.xiaomi.push.dr.b, com.xiaomi.push.ai.b
        public void b() {
            try {
                if (c()) {
                    HashMap map = new HashMap();
                    map.put("uid", com.xiaomi.push.service.bi.m774a());
                    map.put("token", this.f17277b);
                    map.put("net", ax.m106a(dr.this.f278a));
                    ax.a(this.f289a, map, this.f288a, "file");
                }
                this.f290a = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.ai.b
        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public void mo250c() {
            if (!this.f290a) {
                int i9 = this.f17276a + 1;
                this.f17276a = i9;
                if (i9 < 3) {
                    dr.this.f279a.add(this);
                }
            }
            if (this.f290a || this.f17276a >= 3) {
                this.f288a.delete();
            }
            dr.this.a((1 << this.f17276a) * 1000);
        }
    }

    public void a(final String str, final String str2, final Date date, final Date date2, final int i9, final boolean z8) {
        this.f279a.add(new b() { // from class: com.xiaomi.push.dr.1

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            File f281a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.xiaomi.push.dr.b, com.xiaomi.push.ai.b
            public void b() {
                try {
                    File file = new File(dr.this.f278a.getFilesDir() + "/.logcache");
                    if (x.m843a(file)) {
                        file.mkdirs();
                        if (file.isDirectory()) {
                            dq dqVar = new dq();
                            dqVar.a(i9);
                            this.f281a = dqVar.a(dr.this.f278a, date, date2, file);
                        }
                    }
                } catch (NullPointerException unused) {
                }
            }

            @Override // com.xiaomi.push.ai.b
            /* JADX INFO: renamed from: c */
            public void mo250c() {
                File file = this.f281a;
                if (file != null && file.exists()) {
                    dr.this.f279a.add(dr.this.new c(str, str2, this.f281a, z8));
                }
                dr.this.a(0L);
            }
        });
        b(0L);
    }

    public void a() {
        c();
        a(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b bVarPeek = this.f279a.peek();
        if (bVarPeek == null || !bVarPeek.a()) {
            return;
        }
        b(j);
    }
}
