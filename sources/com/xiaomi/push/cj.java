package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class cj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile cj f17132a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ci f173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final HashMap<String, ch> f175a = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ThreadPoolExecutor f176a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ArrayList<a> f174a = new ArrayList<>();

    public static abstract class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private a f178a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f179a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private WeakReference<Context> f180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected String f17135b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        protected ch f177a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Random f181a = new Random();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f17134a = 0;

        public a(String str) {
            this.f179a = str;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public Object mo157a() {
            return null;
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        @Override // java.lang.Runnable
        public final void run() {
            final Context context;
            WeakReference<Context> weakReference = this.f180a;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f177a == null || TextUtils.isEmpty(this.f179a)) {
                return;
            }
            File file = new File(this.f179a);
            w.a(context, new File(file.getParentFile(), bl.b(file.getAbsolutePath())), new Runnable() { // from class: com.xiaomi.push.cj.a.1
                /* JADX WARN: Code duplicated, block: B:19:0x002f A[Catch: Exception -> 0x0027, DONT_GENERATE, TRY_LEAVE, TryCatch #3 {Exception -> 0x0027, blocks: (B:14:0x0023, B:17:0x0029, B:19:0x002f), top: B:50:0x0023 }] */
                /* JADX WARN: Code duplicated, block: B:30:0x004f A[Catch: Exception -> 0x0047, DONT_GENERATE, TRY_LEAVE, TryCatch #2 {Exception -> 0x0047, blocks: (B:25:0x0043, B:28:0x0049, B:30:0x004f), top: B:48:0x0043 }] */
                /* JADX WARN: Code duplicated, block: B:39:0x0062 A[Catch: Exception -> 0x005a, FINALLY_INSNS, TRY_LEAVE, TryCatch #1 {Exception -> 0x005a, blocks: (B:34:0x0056, B:37:0x005c, B:39:0x0062), top: B:46:0x0056 }] */
                @Override // java.lang.Runnable
                public void run() {
                    ch chVar;
                    SQLiteDatabase sQLiteDatabaseA = null;
                    try {
                        sQLiteDatabaseA = a.this.a();
                        if (sQLiteDatabaseA != null && sQLiteDatabaseA.isOpen()) {
                            sQLiteDatabaseA.beginTransaction();
                            a.this.a(context, sQLiteDatabaseA);
                            sQLiteDatabaseA.setTransactionSuccessful();
                        }
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                                if (a.this.f177a != null) {
                                }
                            } catch (Exception e9) {
                                e = e9;
                                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e);
                            }
                        } else if (a.this.f177a != null) {
                        }
                    } catch (Exception e10) {
                        com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e10);
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                                if (a.this.f177a != null) {
                                }
                            } catch (Exception e11) {
                                e = e11;
                                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e);
                            }
                        } else if (a.this.f177a != null) {
                        }
                    } finally {
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                                chVar = a.this.f177a;
                                if (chVar != null) {
                                    chVar.close();
                                }
                            } catch (Exception e12) {
                                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e12);
                                a.this.a(context);
                            }
                        } else {
                            chVar = a.this.f177a;
                            if (chVar != null) {
                                chVar.close();
                            }
                        }
                        a.this.a(context);
                    }
                }
            });
        }

        public void a(ch chVar, Context context) {
            this.f177a = chVar;
            this.f17135b = chVar.a();
            this.f180a = new WeakReference<>(context);
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m159a() {
            return this.f177a == null || TextUtils.isEmpty(this.f17135b) || this.f180a == null;
        }

        public void a(a aVar) {
            this.f178a = aVar;
        }

        public void a(Context context, Object obj) {
            cj.a(context).a(this);
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m158a() {
            return this.f179a;
        }

        public SQLiteDatabase a() {
            return this.f177a.getWritableDatabase();
        }

        public void a(Context context) {
            a aVar = this.f178a;
            if (aVar != null) {
                aVar.a(context, mo157a());
            }
            b(context);
        }

        public void b(Context context) {
        }
    }

    public static class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f17143a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        protected String[] f186a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f17143a = str2;
            this.f186a = strArr;
        }

        @Override // com.xiaomi.push.cj.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f17135b, this.f17143a, this.f186a);
        }
    }

    public static class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ContentValues f17144a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f17144a = contentValues;
        }

        @Override // com.xiaomi.push.cj.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f17135b, null, this.f17144a);
        }
    }

    private cj(Context context) {
        this.f172a = context;
    }

    public void b(a aVar) {
        ch chVarA;
        if (aVar == null) {
            return;
        }
        if (this.f173a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String strM158a = aVar.m158a();
        synchronized (this.f175a) {
            try {
                chVarA = this.f175a.get(strM158a);
                if (chVarA == null) {
                    chVarA = this.f173a.a(this.f172a, strM158a);
                    this.f175a.put(strM158a, chVarA);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.f176a.isShutdown()) {
            return;
        }
        aVar.a(chVarA, this.f172a);
        a((Runnable) aVar);
    }

    public static class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ArrayList<a> f17142a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.f17142a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.cj.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            for (a aVar : this.f17142a) {
                if (aVar != null) {
                    aVar.a(context, sQLiteDatabase);
                }
            }
        }

        @Override // com.xiaomi.push.cj.a
        public final void a(Context context) {
            super.a(context);
            for (a aVar : this.f17142a) {
                if (aVar != null) {
                    aVar.a(context);
                }
            }
        }
    }

    public static cj a(Context context) {
        if (f17132a == null) {
            synchronized (cj.class) {
                try {
                    if (f17132a == null) {
                        f17132a = new cj(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f17132a;
    }

    private void a() {
        ah.a(this.f172a).b(new ah.a() { // from class: com.xiaomi.push.cj.1
            @Override // com.xiaomi.push.ah.a
            /* JADX INFO: renamed from: a */
            public String mo133a() {
                return "100957";
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (cj.this.f174a) {
                    try {
                        if (cj.this.f174a.size() > 0) {
                            if (cj.this.f174a.size() > 1) {
                                cj cjVar = cj.this;
                                cjVar.a(cjVar.f174a);
                            } else {
                                cj cjVar2 = cj.this;
                                cjVar2.b((a) cjVar2.f174a.get(0));
                            }
                            cj.this.f174a.clear();
                            System.gc();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }, com.xiaomi.push.service.aq.a(this.f172a).a(hz.StatDataProcessFrequency.a(), 5));
    }

    public static abstract class b<T> extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f17137a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f183a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private List<String> f184a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String[] f185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<T> f17138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f17139c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f17140d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f17141e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i9) {
            super(str);
            this.f17138b = new ArrayList();
            this.f184a = list;
            this.f183a = str2;
            this.f185a = strArr;
            this.f17139c = str3;
            this.f17140d = str4;
            this.f17141e = str5;
            this.f17137a = i9;
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cj.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.f17138b.clear();
            List<String> list = this.f184a;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f184a.size()];
                this.f184a.toArray(strArr2);
                strArr = strArr2;
            }
            int i9 = this.f17137a;
            Cursor cursorQuery = sQLiteDatabase.query(super.f17135b, strArr, this.f183a, this.f185a, this.f17139c, this.f17140d, this.f17141e, i9 > 0 ? String.valueOf(i9) : null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                do {
                    T tA = a(context, cursorQuery);
                    if (tA != null) {
                        this.f17138b.add(tA);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
            }
            a(context, (List) this.f17138b);
        }

        public abstract void a(Context context, List<T> list);

        @Override // com.xiaomi.push.cj.a
        public SQLiteDatabase a() {
            return ((a) this).f177a.getReadableDatabase();
        }
    }

    public void a(a aVar) {
        ch chVarA;
        if (aVar == null) {
            return;
        }
        if (this.f173a != null) {
            String strM158a = aVar.m158a();
            synchronized (this.f175a) {
                try {
                    chVarA = this.f175a.get(strM158a);
                    if (chVarA == null) {
                        chVarA = this.f173a.a(this.f172a, strM158a);
                        this.f175a.put(strM158a, chVarA);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f176a.isShutdown()) {
                return;
            }
            aVar.a(chVarA, this.f172a);
            synchronized (this.f174a) {
                this.f174a.add(aVar);
                a();
            }
            return;
        }
        throw new IllegalStateException("should exec init method first!");
    }

    public void a(Runnable runnable) {
        if (this.f176a.isShutdown()) {
            return;
        }
        this.f176a.execute(runnable);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m156a(String str) {
        return a(str).a();
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f173a != null) {
            HashMap map = new HashMap();
            if (this.f176a.isShutdown()) {
                return;
            }
            for (a aVar : arrayList) {
                if (aVar.m159a()) {
                    aVar.a(a(aVar.m158a()), this.f172a);
                }
                ArrayList arrayList2 = (ArrayList) map.get(aVar.m158a());
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    map.put(aVar.m158a(), arrayList2);
                }
                arrayList2.add(aVar);
            }
            for (String str : map.keySet()) {
                ArrayList arrayList3 = (ArrayList) map.get(str);
                if (arrayList3 != null && arrayList3.size() > 0) {
                    c cVar = new c(str, arrayList3);
                    cVar.a(((a) arrayList3.get(0)).f177a, this.f172a);
                    this.f176a.execute(cVar);
                }
            }
            return;
        }
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    private ch a(String str) {
        ch chVarA = this.f175a.get(str);
        if (chVarA != null) {
            return chVarA;
        }
        synchronized (this.f175a) {
            if (chVarA == null) {
                try {
                    chVarA = this.f173a.a(this.f172a, str);
                    this.f175a.put(str, chVarA);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return chVarA;
    }
}
