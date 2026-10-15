package O6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;
import com.engagelab.privates.core.constants.MTCoreConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SqflitePlugin.java */
/* JADX INFO: loaded from: classes.dex */
public class t implements p042f7.a, m7.l.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f3570h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static j f3573l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f3574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p096m7.l f3575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f3565c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"UseSparseArrays"})
    public static final HashMap f3566d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f3567e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f3568f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f3569g = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f3571i = 0;
    public static int j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f3572k = 0;

    public static void a(t tVar, g gVar) {
        tVar.getClass();
        try {
            if (gVar.f3507d >= 1) {
                Log.d("Sqflite", gVar.i() + "closing database ");
            }
            gVar.b();
        } catch (Exception e9) {
            Log.e("Sqflite", "error " + e9 + " while closing database " + f3572k);
        }
        synchronized (f3567e) {
            try {
                if (f3566d.isEmpty() && f3573l != null) {
                    if (gVar.f3507d >= 1) {
                        Log.d("Sqflite", gVar.i() + "stopping thread");
                    }
                    f3573l.a();
                    f3573l = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static g b(p096m7.j jVar, p096m7.k kVar) {
        Integer num = (Integer) jVar.a("id");
        int iIntValue = num.intValue();
        g gVar = (g) f3566d.get(num);
        if (gVar != null) {
            return gVar;
        }
        kVar.error("sqlite_error", "database_closed " + iIntValue, null);
        return null;
    }

    public static HashMap c(int i9, boolean z8, boolean z9) {
        HashMap map = new HashMap();
        map.put("id", Integer.valueOf(i9));
        if (z8) {
            map.put("recovered", Boolean.TRUE);
        }
        if (z9) {
            map.put("recoveredInTransaction", Boolean.TRUE);
        }
        return map;
    }

    @Override // p042f7.a
    public final void onAttachedToEngine(f7.a.b bVar) {
        this.f3574a = bVar.f18711a;
        p096m7.s sVar = p096m7.s.f20511a;
        m7.c.d dVar = new m7.c.d();
        p096m7.c cVar = bVar.f18713c;
        p096m7.l lVar = new p096m7.l(cVar, "com.tekartik.sqflite", sVar, cVar.c(dVar));
        this.f3575b = lVar;
        lVar.b(this);
    }

    @Override // p042f7.a
    public final void onDetachedFromEngine(f7.a.b bVar) {
        this.f3574a = null;
        this.f3575b.b(null);
        this.f3575b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // m7.l.c
    public final void onMethodCall(final p096m7.j jVar, m7.l.d dVar) {
        final int i9;
        g gVar;
        int i10 = 2;
        String str = jVar.f20496a;
        str.getClass();
        g gVar2 = null;
        final int i11 = 1;
        boolean zExists = false;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        switch (str) {
            case "execute":
                final p096m7.k kVar = (p096m7.k) dVar;
                final g gVarB = b(jVar, kVar);
                if (gVarB == null) {
                    return;
                }
                f3573l.c(gVarB, new Runnable() { // from class: O6.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        final g gVar3 = gVarB;
                        p096m7.k kVar2 = kVar;
                        p096m7.j jVar2 = jVar;
                        switch (i11) {
                            case 0:
                                HashMap map = t.f3565c;
                                final P6.b bVar = new P6.b(jVar2, kVar2);
                                final int i12 = 0;
                                gVar3.m(bVar, new Runnable() { // from class: O6.d
                                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                     */
                                    @Override // java.lang.Runnable
                                    public final void run() throws Throwable {
                                        switch (i12) {
                                            case 0:
                                                gVar3.f(bVar);
                                                break;
                                            default:
                                                g gVar4 = gVar3;
                                                A0.h hVar = bVar;
                                                Object objF = hVar.f("inTransaction");
                                                Boolean bool = objF instanceof Boolean ? (Boolean) objF : null;
                                                boolean z8 = Boolean.TRUE.equals(bool) && hVar.p() && ((Integer) hVar.f("transactionId")) == null;
                                                if (z8) {
                                                    int i13 = gVar4.f3513k + 1;
                                                    gVar4.f3513k = i13;
                                                    gVar4.f3514l = Integer.valueOf(i13);
                                                }
                                                if (!gVar4.h(hVar)) {
                                                    if (z8) {
                                                        gVar4.f3514l = null;
                                                    }
                                                } else if (!z8) {
                                                    if (Boolean.FALSE.equals(bool)) {
                                                        gVar4.f3514l = null;
                                                    }
                                                    hVar.a(null);
                                                } else {
                                                    HashMap map2 = new HashMap();
                                                    map2.put("transactionId", gVar4.f3514l);
                                                    hVar.a(map2);
                                                }
                                                break;
                                        }
                                    }
                                });
                                break;
                            default:
                                HashMap map2 = t.f3565c;
                                final P6.b bVar2 = new P6.b(jVar2, kVar2);
                                final int i13 = 1;
                                gVar3.m(bVar2, new Runnable() { // from class: O6.d
                                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                     */
                                    @Override // java.lang.Runnable
                                    public final void run() throws Throwable {
                                        switch (i13) {
                                            case 0:
                                                gVar3.f(bVar2);
                                                break;
                                            default:
                                                g gVar4 = gVar3;
                                                A0.h hVar = bVar2;
                                                Object objF = hVar.f("inTransaction");
                                                Boolean bool = objF instanceof Boolean ? (Boolean) objF : null;
                                                boolean z8 = Boolean.TRUE.equals(bool) && hVar.p() && ((Integer) hVar.f("transactionId")) == null;
                                                if (z8) {
                                                    int i14 = gVar4.f3513k + 1;
                                                    gVar4.f3513k = i14;
                                                    gVar4.f3514l = Integer.valueOf(i14);
                                                }
                                                if (!gVar4.h(hVar)) {
                                                    if (z8) {
                                                        gVar4.f3514l = null;
                                                    }
                                                } else if (!z8) {
                                                    if (Boolean.FALSE.equals(bool)) {
                                                        gVar4.f3514l = null;
                                                    }
                                                    hVar.a(null);
                                                } else {
                                                    HashMap map3 = new HashMap();
                                                    map3.put("transactionId", gVar4.f3514l);
                                                    hVar.a(map3);
                                                }
                                                break;
                                        }
                                    }
                                });
                                break;
                        }
                    }
                });
                return;
            case "closeDatabase":
                Integer num = (Integer) jVar.a("id");
                int iIntValue = num.intValue();
                p096m7.k kVar2 = (p096m7.k) dVar;
                g gVarB2 = b(jVar, kVar2);
                if (gVarB2 == null) {
                    return;
                }
                if (gVarB2.f3507d >= 1) {
                    Log.d("Sqflite", gVarB2.i() + "closing " + iIntValue + " " + gVarB2.f3505b);
                }
                String str2 = gVarB2.f3505b;
                synchronized (f3567e) {
                    try {
                        f3566d.remove(num);
                        if (gVarB2.f3504a) {
                            f3565c.remove(str2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                f3573l.c(gVarB2, new r(this, gVarB2, kVar2));
                return;
            case "options":
                Object objA = jVar.a("androidThreadPriority");
                if (objA != null) {
                    f3571i = ((Integer) objA).intValue();
                }
                Object objA2 = jVar.a("androidThreadCount");
                if (objA2 != null && !objA2.equals(Integer.valueOf(j))) {
                    j = ((Integer) objA2).intValue();
                    j jVar2 = f3573l;
                    if (jVar2 != null) {
                        jVar2.a();
                        f3573l = null;
                    }
                }
                Integer num2 = (Integer) jVar.a("logLevel");
                if (num2 != null) {
                    f3569g = num2.intValue();
                }
                ((p096m7.k) dVar).success(null);
                return;
            case "insert":
                p096m7.k kVar3 = (p096m7.k) dVar;
                g gVarB3 = b(jVar, kVar3);
                if (gVarB3 == null) {
                    return;
                }
                f3573l.c(gVarB3, new o(jVar, kVar3, gVarB3));
                return;
            case "update":
                p096m7.k kVar4 = (p096m7.k) dVar;
                g gVarB4 = b(jVar, kVar4);
                if (gVarB4 == null) {
                    return;
                }
                f3573l.c(gVarB4, new n(jVar, kVar4, gVarB4, i10));
                return;
            case "androidSetLocale":
                p096m7.k kVar5 = (p096m7.k) dVar;
                g gVarB5 = b(jVar, kVar5);
                if (gVarB5 == null) {
                    return;
                }
                f3573l.c(gVarB5, new n(gVarB5, jVar, kVar5));
                return;
            case "deleteDatabase":
                String str3 = (String) jVar.a("path");
                synchronized (f3567e) {
                    try {
                        if (p199z2.b.D(f3569g)) {
                            Log.d("Sqflite", "Look for " + str3 + " in " + f3565c.keySet());
                        }
                        HashMap map = f3565c;
                        Integer num3 = (Integer) map.get(str3);
                        if (num3 != null) {
                            HashMap map2 = f3566d;
                            g gVar3 = (g) map2.get(num3);
                            if (gVar3 != null && gVar3.f3512i.isOpen()) {
                                if (p199z2.b.D(f3569g)) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(gVar3.i());
                                    sb.append("found single instance ");
                                    sb.append(gVar3.k() ? "(in transaction) " : "");
                                    sb.append(num3);
                                    sb.append(" ");
                                    sb.append(str3);
                                    Log.d("Sqflite", sb.toString());
                                }
                                map2.remove(num3);
                                map.remove(str3);
                                gVar2 = gVar3;
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                    break;
                }
                s sVar = new s(this, gVar2, str3, (p096m7.k) dVar);
                j jVar3 = f3573l;
                if (jVar3 != null) {
                    jVar3.c(gVar2, sVar);
                    return;
                } else {
                    sVar.run();
                    return;
                }
            case "debugMode":
                boolean zEquals = Boolean.TRUE.equals(jVar.f20497b);
                if (!zEquals) {
                    f3569g = 0;
                } else if (zEquals) {
                    f3569g = 1;
                }
                ((p096m7.k) dVar).success(null);
                return;
            case "openDatabase":
                final String str4 = (String) jVar.a("path");
                final Boolean bool = (Boolean) jVar.a("readOnly");
                final boolean z8 = str4 == null || str4.equals(":memory:");
                boolean z9 = (Boolean.FALSE.equals(jVar.a("singleInstance")) || z8) ? false : true;
                if (z9) {
                    synchronized (f3567e) {
                        try {
                            if (p199z2.b.D(f3569g)) {
                                Log.d("Sqflite", "Look for " + str4 + " in " + f3565c.keySet());
                            }
                            Integer num4 = (Integer) f3565c.get(str4);
                            if (num4 != null && (gVar = (g) f3566d.get(num4)) != null) {
                                if (gVar.f3512i.isOpen()) {
                                    if (p199z2.b.D(f3569g)) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(gVar.i());
                                        sb2.append("re-opened single instance ");
                                        sb2.append(gVar.k() ? "(in transaction) " : "");
                                        sb2.append(num4);
                                        sb2.append(" ");
                                        sb2.append(str4);
                                        Log.d("Sqflite", sb2.toString());
                                    }
                                    ((p096m7.k) dVar).success(c(num4.intValue(), true, gVar.k()));
                                    return;
                                }
                                if (p199z2.b.D(f3569g)) {
                                    Log.d("Sqflite", gVar.i() + "single instance database of " + str4 + " not opened");
                                }
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
                Object obj = f3567e;
                synchronized (obj) {
                    i9 = f3572k + 1;
                    f3572k = i9;
                    break;
                }
                final g gVar4 = new g(this.f3574a, str4, i9, z9, f3569g);
                synchronized (obj) {
                    try {
                        if (f3573l == null) {
                            int i12 = j;
                            int i13 = f3571i;
                            j lVar = i12 == 1 ? new l(i13, 0) : new k(i12, i13);
                            f3573l = lVar;
                            lVar.start();
                            if (gVar4.f3507d >= 1) {
                                Log.d("Sqflite", gVar4.i() + "starting worker pool with priority " + f3571i);
                            }
                        }
                        gVar4.f3511h = f3573l;
                        if (gVar4.f3507d >= 1) {
                            Log.d("Sqflite", gVar4.i() + "opened " + i9 + " " + str4);
                        }
                        final p096m7.k kVar6 = (p096m7.k) dVar;
                        final boolean z10 = z9;
                        f3573l.c(gVar4, new Runnable() { // from class: O6.q
                            /* JADX WARN: Code duplicated, block: B:19:0x0057 A[Catch: all -> 0x004b, Exception -> 0x00b8, TryCatch #1 {Exception -> 0x00b8, blocks: (B:17:0x004e, B:19:0x0057, B:20:0x0065), top: B:45:0x004e, outer: #2 }] */
                            /* JADX WARN: Code duplicated, block: B:20:0x0065 A[Catch: all -> 0x004b, Exception -> 0x00b8, TRY_LEAVE, TryCatch #1 {Exception -> 0x00b8, blocks: (B:17:0x004e, B:19:0x0057, B:20:0x0065), top: B:45:0x004e, outer: #2 }] */
                            /* JADX WARN: Code duplicated, block: B:23:0x006b A[DONT_INVERT] */
                            /* JADX WARN: Code duplicated, block: B:27:0x0079 A[Catch: all -> 0x0077, TryCatch #0 {all -> 0x0077, blocks: (B:24:0x006d, B:27:0x0079, B:28:0x0082), top: B:43:0x006d, outer: #2 }] */
                            /* JADX WARN: Code duplicated, block: B:31:0x0087 A[Catch: all -> 0x004b, TryCatch #2 {, blocks: (B:6:0x0018, B:8:0x002c, B:10:0x0032, B:12:0x0038, B:13:0x0049, B:17:0x004e, B:19:0x0057, B:21:0x0068, B:22:0x006a, B:29:0x0083, B:31:0x0087, B:32:0x00ac, B:36:0x00b7, B:20:0x0065, B:38:0x00b9, B:39:0x00c1, B:24:0x006d, B:27:0x0079, B:28:0x0082), top: B:46:0x0018, inners: #0, #1 }] */
                            /* JADX WARN: Code duplicated, block: B:43:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
                            /* JADX WARN: Instruction removed from duplicated block: B:31:0x0087, please report this as an issue */
                            @Override // java.lang.Runnable
                            public final void run() {
                                boolean z11 = z8;
                                String str5 = str4;
                                p096m7.k kVar7 = kVar6;
                                Boolean bool2 = bool;
                                g gVar5 = gVar4;
                                p096m7.j jVar4 = jVar;
                                boolean z12 = z10;
                                int i14 = i9;
                                synchronized (t.f3568f) {
                                    if (z11) {
                                        if (Boolean.TRUE.equals(bool2)) {
                                            gVar5.f3512i = SQLiteDatabase.openDatabase(gVar5.f3505b, null, 1, new f());
                                        } else {
                                            gVar5.l();
                                        }
                                        synchronized (t.f3567e) {
                                            if (!z12) {
                                                t.f3566d.put(Integer.valueOf(i14), gVar5);
                                                if (gVar5.f3507d >= 1) {
                                                    Log.d("Sqflite", gVar5.i() + "opened " + i14 + " " + str5);
                                                }
                                                kVar7.success(t.c(i14, false, false));
                                                return;
                                            }
                                            t.f3565c.put(str5, Integer.valueOf(i14));
                                            t.f3566d.put(Integer.valueOf(i14), gVar5);
                                            if (gVar5.f3507d >= 1) {
                                                Log.d("Sqflite", gVar5.i() + "opened " + i14 + " " + str5);
                                            }
                                            kVar7.success(t.c(i14, false, false));
                                            return;
                                        }
                                    }
                                    File file = new File(new File(str5).getParent());
                                    if (!file.exists() && !file.mkdirs() && !file.exists()) {
                                        kVar7.error("sqlite_error", "open_failed " + str5, null);
                                        return;
                                    }
                                    try {
                                        if (Boolean.TRUE.equals(bool2)) {
                                            gVar5.f3512i = SQLiteDatabase.openDatabase(gVar5.f3505b, null, 1, new f());
                                        } else {
                                            gVar5.l();
                                        }
                                        synchronized (t.f3567e) {
                                            if (!z12) {
                                                try {
                                                    t.f3565c.put(str5, Integer.valueOf(i14));
                                                    t.f3566d.put(Integer.valueOf(i14), gVar5);
                                                } catch (Throwable th4) {
                                                    throw th4;
                                                }
                                            } else {
                                                t.f3566d.put(Integer.valueOf(i14), gVar5);
                                            }
                                        }
                                        if (gVar5.f3507d >= 1) {
                                            Log.d("Sqflite", gVar5.i() + "opened " + i14 + " " + str5);
                                        }
                                        kVar7.success(t.c(i14, false, false));
                                        return;
                                    } catch (Exception e9) {
                                        gVar5.j(e9, new P6.b(jVar4, kVar7));
                                        return;
                                    }
                                    throw th;
                                }
                            }
                        });
                    } catch (Throwable th4) {
                        throw th4;
                    }
                    break;
                }
                return;
            case "batch":
                p096m7.k kVar7 = (p096m7.k) dVar;
                g gVarB6 = b(jVar, kVar7);
                if (gVarB6 == null) {
                    return;
                }
                f3573l.c(gVarB6, new o(gVarB6, jVar, kVar7));
                return;
            case "debug":
                String str5 = (String) jVar.a(MTCoreConstants.Protocol.KEY_CMD);
                HashMap map3 = new HashMap();
                if ("get".equals(str5)) {
                    int i14 = f3569g;
                    if (i14 > 0) {
                        map3.put("logLevel", Integer.valueOf(i14));
                    }
                    HashMap map4 = f3566d;
                    if (!map4.isEmpty()) {
                        HashMap map5 = new HashMap();
                        for (Map.Entry entry : map4.entrySet()) {
                            g gVar5 = (g) entry.getValue();
                            HashMap map6 = new HashMap();
                            map6.put("path", gVar5.f3505b);
                            map6.put("singleInstance", Boolean.valueOf(gVar5.f3504a));
                            int i15 = gVar5.f3507d;
                            if (i15 > 0) {
                                map6.put("logLevel", Integer.valueOf(i15));
                            }
                            map5.put(((Integer) entry.getKey()).toString(), map6);
                        }
                        map3.put("databases", map5);
                    }
                }
                ((p096m7.k) dVar).success(map3);
                return;
            case "query":
                final p096m7.k kVar8 = (p096m7.k) dVar;
                final g gVarB7 = b(jVar, kVar8);
                if (gVarB7 == null) {
                    return;
                }
                j jVar4 = f3573l;
                final Object[] objArr3 = objArr == true ? 1 : 0;
                jVar4.c(gVarB7, new Runnable() { // from class: O6.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        final g gVar6 = gVarB7;
                        p096m7.k kVar9 = kVar8;
                        p096m7.j jVar5 = jVar;
                        switch (objArr3) {
                            case 0:
                                HashMap map7 = t.f3565c;
                                final P6.b bVar = new P6.b(jVar5, kVar9);
                                final int i16 = 0;
                                gVar6.m(bVar, new Runnable() { // from class: O6.d
                                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                     */
                                    @Override // java.lang.Runnable
                                    public final void run() throws Throwable {
                                        switch (i16) {
                                            case 0:
                                                gVar6.f(bVar);
                                                break;
                                            default:
                                                g gVar7 = gVar6;
                                                A0.h hVar = bVar;
                                                Object objF = hVar.f("inTransaction");
                                                Boolean bool2 = objF instanceof Boolean ? (Boolean) objF : null;
                                                boolean z11 = Boolean.TRUE.equals(bool2) && hVar.p() && ((Integer) hVar.f("transactionId")) == null;
                                                if (z11) {
                                                    int i17 = gVar7.f3513k + 1;
                                                    gVar7.f3513k = i17;
                                                    gVar7.f3514l = Integer.valueOf(i17);
                                                }
                                                if (!gVar7.h(hVar)) {
                                                    if (z11) {
                                                        gVar7.f3514l = null;
                                                    }
                                                } else if (!z11) {
                                                    if (Boolean.FALSE.equals(bool2)) {
                                                        gVar7.f3514l = null;
                                                    }
                                                    hVar.a(null);
                                                } else {
                                                    HashMap map8 = new HashMap();
                                                    map8.put("transactionId", gVar7.f3514l);
                                                    hVar.a(map8);
                                                }
                                                break;
                                        }
                                    }
                                });
                                break;
                            default:
                                HashMap map8 = t.f3565c;
                                final P6.b bVar2 = new P6.b(jVar5, kVar9);
                                final int i17 = 1;
                                gVar6.m(bVar2, new Runnable() { // from class: O6.d
                                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                     */
                                    @Override // java.lang.Runnable
                                    public final void run() throws Throwable {
                                        switch (i17) {
                                            case 0:
                                                gVar6.f(bVar2);
                                                break;
                                            default:
                                                g gVar7 = gVar6;
                                                A0.h hVar = bVar2;
                                                Object objF = hVar.f("inTransaction");
                                                Boolean bool2 = objF instanceof Boolean ? (Boolean) objF : null;
                                                boolean z11 = Boolean.TRUE.equals(bool2) && hVar.p() && ((Integer) hVar.f("transactionId")) == null;
                                                if (z11) {
                                                    int i18 = gVar7.f3513k + 1;
                                                    gVar7.f3513k = i18;
                                                    gVar7.f3514l = Integer.valueOf(i18);
                                                }
                                                if (!gVar7.h(hVar)) {
                                                    if (z11) {
                                                        gVar7.f3514l = null;
                                                    }
                                                } else if (!z11) {
                                                    if (Boolean.FALSE.equals(bool2)) {
                                                        gVar7.f3514l = null;
                                                    }
                                                    hVar.a(null);
                                                } else {
                                                    HashMap map9 = new HashMap();
                                                    map9.put("transactionId", gVar7.f3514l);
                                                    hVar.a(map9);
                                                }
                                                break;
                                        }
                                    }
                                });
                                break;
                        }
                    }
                });
                return;
            case "databaseExists":
                try {
                    zExists = new File((String) jVar.a("path")).exists();
                    break;
                } catch (Exception unused) {
                }
                ((p096m7.k) dVar).success(Boolean.valueOf(zExists));
                return;
            case "queryCursorNext":
                p096m7.k kVar9 = (p096m7.k) dVar;
                g gVarB8 = b(jVar, kVar9);
                if (gVarB8 == null) {
                    return;
                }
                f3573l.c(gVarB8, new n(jVar, kVar9, gVarB8, objArr2 == true ? 1 : 0));
                return;
            case "getPlatformVersion":
                ((p096m7.k) dVar).success("Android " + Build.VERSION.RELEASE);
                return;
            case "getDatabasesPath":
                if (f3570h == null) {
                    f3570h = this.f3574a.getDatabasePath("tekartik_sqflite.db").getParent();
                }
                ((p096m7.k) dVar).success(f3570h);
                return;
            default:
                ((p096m7.k) dVar).notImplemented();
                return;
        }
    }
}
