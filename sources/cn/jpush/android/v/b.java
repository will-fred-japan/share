package cn.jpush.android.v;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.jpush.android.helper.Logger;
import defpackage.f;

/* JADX INFO: loaded from: classes.dex */
public class b extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f11704b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f11703a = {"_id", "ln_id", "ln_count", "ln_remove", "ln_type", "ln_extra", "ln_trigger_time", "ln_add_time"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f11705c = new Object();

    private b(Context context) {
        super(context, "jpush_local_notification.db", null, 1);
    }

    public int a(long j) {
        if (!a(true)) {
            return 0;
        }
        try {
            return getWritableDatabase().delete("t_localnotification", "ln_id=" + j, null);
        } catch (Exception unused) {
            return 0;
        } finally {
            b(true);
        }
    }

    public long b(long j, int i9, int i10, int i11, String str, long j8, long j9) {
        if (!a(true)) {
            return 0L;
        }
        try {
            String str2 = "ln_id=" + j;
            ContentValues contentValues = new ContentValues();
            contentValues.put("ln_id", Long.valueOf(j));
            contentValues.put("ln_count", Integer.valueOf(i9));
            contentValues.put("ln_remove", Integer.valueOf(i10));
            contentValues.put("ln_type", Integer.valueOf(i11));
            contentValues.put("ln_extra", cn.jpush.android.ad.d.c(str));
            contentValues.put("ln_trigger_time", Long.valueOf(j8));
            contentValues.put("ln_add_time", Long.valueOf(j9));
            return getWritableDatabase().update("t_localnotification", contentValues, str2, null);
        } catch (Exception unused) {
            return 0L;
        } finally {
            b(true);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE t_localnotification (_id INTEGER PRIMARY KEY AUTOINCREMENT ,ln_id long not null,ln_count integer not null,ln_remove integer not null,ln_type integer not null,ln_extra text ,ln_trigger_time long ,ln_add_time long );");
        } catch (Exception unused) {
            Logger.v("LocalNotificationDb", "表已经存在");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i9, int i10) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_localnotification");
        onCreate(sQLiteDatabase);
    }

    public long a(long j, int i9, int i10, int i11, String str, long j8, long j9) {
        if (!a(true)) {
            return 0L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("ln_id", Long.valueOf(j));
            contentValues.put("ln_count", Integer.valueOf(i9));
            contentValues.put("ln_remove", Integer.valueOf(i10));
            contentValues.put("ln_type", Integer.valueOf(i11));
            contentValues.put("ln_extra", cn.jpush.android.ad.d.c(str));
            contentValues.put("ln_trigger_time", Long.valueOf(j8));
            contentValues.put("ln_add_time", Long.valueOf(j9));
            return getWritableDatabase().insert("t_localnotification", null, contentValues);
        } catch (Exception unused) {
            return 0L;
        } finally {
            b(true);
        }
    }

    public Cursor a(int i9, long j) {
        try {
            return getReadableDatabase().query(true, "t_localnotification", f11703a, "ln_count=" + i9 + " and ln_trigger_time<" + j, null, null, null, null, null);
        } catch (Exception e9) {
            Logger.w("LocalNotificationDb", "getOutDatas exception:" + e9.getMessage());
            return null;
        }
    }

    public Cursor a(long j, long j8) {
        StringBuilder sbH = f.h(j8 + j, "ln_count>0 and ln_trigger_time<", " and ln_trigger_time>");
        sbH.append(j);
        try {
            return getReadableDatabase().query(true, "t_localnotification", f11703a, sbH.toString(), null, null, null, null, null);
        } catch (Exception e9) {
            Logger.w("LocalNotificationDb", "getRtcDatas exception:" + e9.getMessage());
            return null;
        }
    }

    public static b a(Context context) {
        if (f11704b == null) {
            synchronized (f11705c) {
                try {
                    if (f11704b == null) {
                        f11704b = new b(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11704b;
    }

    public c a(long j, int i9) throws Exception {
        if (!a(false)) {
            throw new Exception("open database failed");
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = getReadableDatabase().query(true, "t_localnotification", f11703a, "ln_id=" + j + " and ln_type=" + i9, null, null, null, null, null);
            if (cursorQuery != null) {
                cursorQuery.moveToFirst();
            }
            return a(cursorQuery);
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            b(false);
        }
    }

    public static c a(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            Logger.d("LocalNotificationDb", "cursor is null");
            return null;
        }
        try {
            c cVar = new c();
            cVar.a(cursor.getLong(1));
            cVar.a(cursor.getInt(2));
            cVar.b(cursor.getInt(3));
            cVar.c(cursor.getInt(4));
            cVar.a(cn.jpush.android.ad.d.c(cursor.getString(5)));
            cVar.c(cursor.getLong(6));
            cVar.b(cursor.getLong(7));
            Logger.i("LocalNotificationDb", cVar.toString());
            return cVar;
        } catch (Exception e9) {
            e9.getStackTrace();
            Logger.w("LocalNotificationDb", "initLocalNotificationDBData exception:" + e9.getMessage());
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007a  */
    /* JADX WARN: Code duplicated, block: B:38:0x0082  */
    /* JADX WARN: Code duplicated, block: B:41:0x0088  */
    /* JADX WARN: Code duplicated, block: B:44:0x0090  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int[] a() throws Throwable {
        ?? r8;
        int[] iArr;
        ?? r9;
        ?? r10;
        Cursor cursor = null;
        iArr = null;
        iArr = null;
        int[] iArr2 = null;
        Cursor cursor2 = null;
        if (!a(false)) {
            return null;
        }
        try {
            Cursor cursorQuery = getReadableDatabase().query(true, "t_localnotification", new String[]{"ln_id"}, "1", null, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        iArr2 = new int[cursorQuery.getCount()];
                        cursorQuery.moveToFirst();
                        int i9 = 0;
                        do {
                            iArr2[i9] = cursorQuery.getInt(0);
                            i9++;
                        } while (cursorQuery.moveToNext());
                    }
                } catch (Exception unused) {
                    iArr = iArr2;
                    cursor2 = cursorQuery;
                    r8 = false;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    b(false);
                    if (r8 != false) {
                        b(true);
                    }
                    return iArr;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    r9 = false;
                    if (cursor != null) {
                        cursor.close();
                    }
                    b(false);
                    if (r9 != false) {
                        b(true);
                    }
                    throw th;
                }
            }
            if (a(true)) {
                try {
                    getWritableDatabase().execSQL("delete from t_localnotification");
                    r10 = true;
                } catch (Exception unused2) {
                    iArr = iArr2;
                    cursor2 = cursorQuery;
                    r8 = true;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    b(false);
                    if (r8 != false) {
                        b(true);
                    }
                    return iArr;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    r9 = true;
                    if (cursor != null) {
                        cursor.close();
                    }
                    b(false);
                    if (r9 != false) {
                        b(true);
                    }
                    throw th;
                }
            } else {
                r10 = false;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            b(false);
            if (r10 != false) {
                b(true);
            }
            return iArr2;
        } catch (Exception unused3) {
            r8 = false;
            iArr = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
