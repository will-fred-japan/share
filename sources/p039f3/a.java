package p039f3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

/* JADX INFO: compiled from: LogDBHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f18672b = {"_id", "value", "type", "timestamp", "retry_count", "retry_time"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f18673c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f18674a;

    public static void c(Cursor cursor) {
        if (cursor != null) {
            try {
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    public final synchronized long a(String str, byte[] bArr) {
        if (d() && bArr != null && bArr.length > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", bArr);
            contentValues.put("type", str);
            contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("retry_count", (Integer) 0);
            contentValues.put("retry_time", (Long) 0L);
            return this.f18674a.insert("queue", null, contentValues);
        }
        return -1L;
    }

    public final synchronized void b(int i9, String str, long j) {
        String str2;
        String[] strArr;
        try {
            if (d()) {
                long jCurrentTimeMillis = System.currentTimeMillis() - j;
                if (TextUtils.isEmpty(str)) {
                    str2 = "timestamp <= ? ";
                    strArr = new String[]{String.valueOf(jCurrentTimeMillis)};
                } else {
                    str2 = "(timestamp <= ? OR retry_count > " + i9 + ") and type = ?";
                    strArr = new String[]{String.valueOf(jCurrentTimeMillis), str};
                }
                try {
                    this.f18674a.delete("queue", str2, strArr);
                } catch (Exception e9) {
                    e9.toString();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean d() {
        SQLiteDatabase sQLiteDatabase = this.f18674a;
        return sQLiteDatabase != null && sQLiteDatabase.isOpen();
    }

    public final synchronized boolean e(boolean z8, long j, long j8, int i9) {
        if (d() && j > 0) {
            String[] strArr = {String.valueOf(j)};
            if (!z8) {
                Cursor cursorQuery = null;
                try {
                    try {
                        cursorQuery = this.f18674a.query("queue", new String[]{"timestamp", "retry_count"}, "_id = ?", strArr, null, null, null);
                        if (!cursorQuery.moveToNext()) {
                            c(cursorQuery);
                            return false;
                        }
                        long j9 = cursorQuery.getLong(0);
                        int i10 = cursorQuery.getInt(1);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (jCurrentTimeMillis - j9 < j8 && i10 < i9) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("retry_count", Integer.valueOf(i10 + 1));
                            contentValues.put("retry_time", Long.valueOf(jCurrentTimeMillis));
                            this.f18674a.update("queue", contentValues, "_id = ?", strArr);
                            c(cursorQuery);
                            return true;
                        }
                        c(cursorQuery);
                    } catch (Exception e9) {
                        e9.toString();
                        c(cursorQuery);
                        return false;
                    }
                } catch (Throwable th) {
                    c(cursorQuery);
                    throw th;
                }
                c(cursorQuery);
                throw th;
            }
            try {
                this.f18674a.delete("queue", "_id = ?", strArr);
            } catch (Throwable unused) {
            }
            return false;
        }
        return false;
    }

    public final synchronized void f() {
        if (d()) {
            try {
                this.f18674a.execSQL("DROP TABLE IF EXISTS queue");
                this.f18674a.execSQL("CREATE TABLE queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value BLOB, type TEXT, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )");
            } catch (Exception e9) {
                e9.toString();
            }
        }
    }

    /* JADX INFO: renamed from: f3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LogDBHelper.java */
    public static class C0198a extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value BLOB, type TEXT, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )");
            } catch (Exception e9) {
                e9.toString();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i9, int i10) {
        }
    }
}
