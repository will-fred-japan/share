package O6;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: Database.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Boolean f3503n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f3508e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j f3511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SQLiteDatabase f3512i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f3514l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f3509f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap f3510g = new HashMap();
    public int j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3513k = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3515m = 0;

    public g(Context context, String str, int i9, boolean z8, int i10) {
        this.f3508e = context;
        this.f3505b = str;
        this.f3504a = z8;
        this.f3506c = i9;
        this.f3507d = i10;
    }

    public static void a(SQLiteStatement sQLiteStatement, Object[] objArr) {
        int i9 = 0;
        while (i9 < objArr.length) {
            Object obj = objArr[i9];
            i9++;
            if (obj == null) {
                sQLiteStatement.bindNull(i9);
            } else if (obj instanceof byte[]) {
                sQLiteStatement.bindBlob(i9, (byte[]) obj);
            } else if ((obj instanceof Double) || (obj instanceof Float)) {
                sQLiteStatement.bindDouble(i9, ((Number) obj).doubleValue());
            } else if (obj instanceof Number) {
                sQLiteStatement.bindLong(i9, ((Number) obj).longValue());
            } else if (obj instanceof Boolean) {
                sQLiteStatement.bindLong(i9, ((Boolean) obj).booleanValue() ? 1L : 0L);
            } else {
                sQLiteStatement.bindString(i9, obj.toString());
            }
        }
    }

    public static HashMap d(Cursor cursor, Integer num) {
        Object objValueOf;
        HashMap map = null;
        ArrayList arrayList = null;
        int columnCount = 0;
        while (cursor.moveToNext()) {
            if (map == null) {
                arrayList = new ArrayList();
                map = new HashMap();
                columnCount = cursor.getColumnCount();
                map.put("columns", Arrays.asList(cursor.getColumnNames()));
                map.put("rows", arrayList);
            }
            ArrayList arrayList2 = new ArrayList(columnCount);
            for (int i9 = 0; i9 < columnCount; i9++) {
                int type = cursor.getType(i9);
                if (type == 1) {
                    objValueOf = Long.valueOf(cursor.getLong(i9));
                } else if (type == 2) {
                    objValueOf = Double.valueOf(cursor.getDouble(i9));
                } else if (type != 3) {
                    objValueOf = type != 4 ? null : cursor.getBlob(i9);
                } else {
                    objValueOf = cursor.getString(i9);
                }
                arrayList2.add(objValueOf);
            }
            arrayList.add(arrayList2);
            if (num != null && arrayList.size() >= num.intValue()) {
                break;
            }
        }
        return map == null ? new HashMap() : map;
    }

    public final void b() {
        HashMap map = this.f3510g;
        if (!map.isEmpty() && this.f3507d >= 1) {
            Log.d("Sqflite", i() + map.size() + " cursor(s) are left opened");
        }
        this.f3512i.close();
    }

    public final void c(m mVar) {
        try {
            int i9 = mVar.f3535a;
            if (p199z2.b.D(this.f3507d)) {
                Log.d("Sqflite", i() + "closing cursor " + i9);
            }
            this.f3510g.remove(Integer.valueOf(i9));
            mVar.f3537c.close();
        } catch (Exception unused) {
        }
    }

    public final boolean e(A0.h hVar) {
        u uVarN = hVar.n();
        if (this.f3507d >= 1) {
            Log.d("Sqflite", i() + uVarN);
        }
        try {
            SQLiteStatement sQLiteStatementCompileStatement = this.f3512i.compileStatement(uVarN.f3576a);
            a(sQLiteStatementCompileStatement, uVarN.a());
            long jExecuteInsert = sQLiteStatementCompileStatement.executeInsert();
            if (hVar.i()) {
                hVar.a(null);
                return true;
            }
            hVar.a(Long.valueOf(jExecuteInsert));
            return true;
        } catch (Exception e9) {
            j(e9, hVar);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [O6.u, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v0, types: [A0.h] */
    public final boolean f(A0.h hVar) throws Throwable {
        Integer num = (Integer) hVar.f("cursorPageSize");
        final ?? N8 = hVar.n();
        if (this.f3507d >= 1) {
            Log.d("Sqflite", i() + N8);
        }
        m mVar = null;
        try {
            try {
                N8 = this.f3512i.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: O6.e
                    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                        List<Object> list = N8.f3577b;
                        if (list != null) {
                            int size = list.size();
                            int i9 = 0;
                            while (i9 < size) {
                                Object objB = u.b(list.get(i9));
                                int i10 = i9 + 1;
                                if (objB == null) {
                                    sQLiteQuery.bindNull(i10);
                                } else if (objB instanceof byte[]) {
                                    sQLiteQuery.bindBlob(i10, (byte[]) objB);
                                } else if (objB instanceof Double) {
                                    sQLiteQuery.bindDouble(i10, ((Double) objB).doubleValue());
                                } else if (objB instanceof Integer) {
                                    sQLiteQuery.bindLong(i10, ((Integer) objB).intValue());
                                } else if (objB instanceof Long) {
                                    sQLiteQuery.bindLong(i10, ((Long) objB).longValue());
                                } else if (objB instanceof String) {
                                    sQLiteQuery.bindString(i10, (String) objB);
                                } else {
                                    if (!(objB instanceof Boolean)) {
                                        throw new IllegalArgumentException("Could not bind " + objB + " from index " + i9 + ": Supported types are null, byte[], double, long, boolean and String");
                                    }
                                    sQLiteQuery.bindLong(i10, ((Boolean) objB).booleanValue() ? 1L : 0L);
                                }
                                i9 = i10;
                            }
                        }
                        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
                    }
                }, N8.f3576a, a.f3495a, null);
                try {
                    HashMap mapD = d(N8, num);
                    if (num != null && !N8.isLast() && !N8.isAfterLast()) {
                        int i9 = this.f3515m + 1;
                        this.f3515m = i9;
                        mapD.put("cursorId", Integer.valueOf(i9));
                        m mVar2 = new m(i9, num.intValue(), N8);
                        try {
                            this.f3510g.put(Integer.valueOf(i9), mVar2);
                            mVar = mVar2;
                        } catch (Exception e9) {
                            e = e9;
                            mVar = mVar2;
                            j(e, hVar);
                            if (mVar != null) {
                                c(mVar);
                            }
                            if (mVar != null || N8 == 0) {
                                return false;
                            }
                            N8.close();
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            mVar = mVar2;
                            if (mVar == null && N8 != 0) {
                                N8.close();
                            }
                            throw th;
                        }
                    }
                    hVar.a(mapD);
                    if (mVar == null) {
                        N8.close();
                    }
                    return true;
                } catch (Exception e10) {
                    e = e10;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
            N8 = 0;
        } catch (Throwable th3) {
            th = th3;
            N8 = 0;
        }
    }

    public final boolean g(A0.h hVar) {
        u uVarN = hVar.n();
        if (this.f3507d >= 1) {
            Log.d("Sqflite", i() + uVarN);
        }
        try {
            SQLiteStatement sQLiteStatementCompileStatement = this.f3512i.compileStatement(uVarN.f3576a);
            a(sQLiteStatementCompileStatement, uVarN.a());
            int iExecuteUpdateDelete = sQLiteStatementCompileStatement.executeUpdateDelete();
            if (hVar.i()) {
                hVar.a(null);
                return true;
            }
            hVar.a(Integer.valueOf(iExecuteUpdateDelete));
            return true;
        } catch (Exception e9) {
            j(e9, hVar);
            return false;
        }
    }

    public final boolean h(A0.h hVar) {
        u uVarN = hVar.n();
        if (this.f3507d >= 1) {
            Log.d("Sqflite", i() + uVarN);
        }
        Object objF = hVar.f("inTransaction");
        Boolean bool = objF instanceof Boolean ? (Boolean) objF : null;
        try {
            this.f3512i.execSQL(uVarN.f3576a, uVarN.a());
            synchronized (this) {
                try {
                    if (Boolean.TRUE.equals(bool)) {
                        this.j++;
                    } else if (Boolean.FALSE.equals(bool)) {
                        this.j--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        } catch (Exception e9) {
            j(e9, hVar);
            return false;
        }
    }

    public final String i() {
        StringBuilder sb = new StringBuilder("[");
        Thread threadCurrentThread = Thread.currentThread();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f3506c);
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append(threadCurrentThread.getName());
        sb2.append("(");
        sb2.append(Build.VERSION.SDK_INT >= 36 ? threadCurrentThread.threadId() : threadCurrentThread.getId());
        sb2.append(")");
        sb.append(sb2.toString());
        sb.append("] ");
        return sb.toString();
    }

    public final void j(Exception exc, A0.h hVar) {
        if (exc instanceof SQLiteCantOpenDatabaseException) {
            hVar.c("open_failed " + this.f3505b, null);
        } else {
            if (exc instanceof SQLException) {
                String message = exc.getMessage();
                u uVarN = hVar.n();
                HashMap map = new HashMap();
                map.put("sql", uVarN.f3576a);
                map.put("arguments", uVarN.f3577b);
                hVar.c(message, map);
                return;
            }
            String message2 = exc.getMessage();
            u uVarN2 = hVar.n();
            HashMap map2 = new HashMap();
            map2.put("sql", uVarN2.f3576a);
            map2.put("arguments", uVarN2.f3577b);
            hVar.c(message2, map2);
        }
    }

    public final synchronized boolean k() {
        return this.j > 0;
    }

    public final void l() {
        if (f3503n == null) {
            Context context = this.f3508e;
            boolean z8 = false;
            try {
                String packageName = context.getPackageName();
                if ((Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(128L)) : context.getPackageManager().getApplicationInfo(packageName, 128)).metaData.getBoolean("com.tekartik.sqflite.wal_enabled", false)) {
                    z8 = true;
                }
            } catch (Exception e9) {
                e9.printStackTrace();
            }
            f3503n = Boolean.valueOf(z8);
            if (z8 && p199z2.b.D(this.f3507d)) {
                Log.d("Sqflite", i() + "[sqflite] WAL enabled");
            }
        }
        this.f3512i = SQLiteDatabase.openDatabase(this.f3505b, null, f3503n.booleanValue() ? 805306368 : 268435456);
    }

    public final void m(P6.b bVar, Runnable runnable) {
        Integer num = (Integer) bVar.f("transactionId");
        Integer num2 = this.f3514l;
        if (num2 == null) {
            runnable.run();
            return;
        }
        ArrayList arrayList = this.f3509f;
        if (num == null || !(num.equals(num2) || num.intValue() == -1)) {
            arrayList.add(new P6.d(runnable));
            return;
        }
        runnable.run();
        if (this.f3514l != null || arrayList.isEmpty()) {
            return;
        }
        this.f3511h.c(this, new D6.a(5, this));
    }
}
