package cn.jpush.android.v;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f11713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f11714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile SQLiteDatabase f11715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile SQLiteDatabase f11716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f11717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f11718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f11719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f11720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f11721i;
    private final SQLiteDatabase.CursorFactory j;

    public e(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i9) {
        super(context, str, cursorFactory, i9);
        this.f11713a = 0;
        this.f11714b = 0;
        this.f11717e = new Object();
        this.f11718f = new Object();
        this.f11719g = context;
        this.f11720h = str;
        this.f11721i = i9;
        this.j = cursorFactory;
    }

    public boolean a(boolean z8) {
        try {
            if (z8) {
                synchronized (this.f11717e) {
                    getWritableDatabase();
                    this.f11714b++;
                }
                return true;
            }
            synchronized (this.f11718f) {
                getReadableDatabase();
                this.f11713a++;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0024 A[Catch: all -> 0x001c, TryCatch #1 {all -> 0x001c, blocks: (B:6:0x0007, B:8:0x000b, B:10:0x0013, B:19:0x002b, B:15:0x001e, B:17:0x0024, B:18:0x0029), top: B:44:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x004f A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:25:0x0032, B:27:0x0036, B:29:0x003e, B:38:0x0056, B:34:0x0049, B:36:0x004f, B:37:0x0054), top: B:42:0x0032 }] */
    public void b(boolean z8) {
        if (z8) {
            synchronized (this.f11717e) {
                try {
                    if (this.f11716d == null || !this.f11716d.isOpen()) {
                        this.f11714b = 0;
                        if (this.f11716d != null) {
                            this.f11716d.close();
                        }
                        this.f11716d = null;
                    } else {
                        int i9 = this.f11714b - 1;
                        this.f11714b = i9;
                        if (i9 <= 0) {
                            this.f11714b = 0;
                            if (this.f11716d != null) {
                                this.f11716d.close();
                            }
                            this.f11716d = null;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        synchronized (this.f11718f) {
            try {
                if (this.f11715c == null || !this.f11715c.isOpen()) {
                    this.f11713a = 0;
                    if (this.f11715c != null) {
                        this.f11715c.close();
                    }
                    this.f11715c = null;
                } else {
                    int i10 = this.f11713a - 1;
                    this.f11713a = i10;
                    if (i10 <= 0) {
                        this.f11713a = 0;
                        if (this.f11715c != null) {
                            this.f11715c.close();
                        }
                        this.f11715c = null;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        if (this.f11715c == null || !this.f11715c.isOpen()) {
            synchronized (this.f11718f) {
                if (this.f11715c == null || !this.f11715c.isOpen()) {
                    try {
                        getWritableDatabase();
                    } catch (SQLiteException unused) {
                    }
                    String path = this.f11719g.getDatabasePath(this.f11720h).getPath();
                    this.f11715c = SQLiteDatabase.openDatabase(path, this.j, 1);
                    if (this.f11715c.getVersion() != this.f11721i) {
                        throw new SQLiteException("Can't upgrade read-only database from version " + this.f11715c.getVersion() + " to " + this.f11721i + ": " + path);
                    }
                    this.f11713a = 0;
                    onOpen(this.f11715c);
                }
            }
        }
        return this.f11715c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        if (this.f11716d == null || !this.f11716d.isOpen()) {
            synchronized (this.f11717e) {
                try {
                    if (this.f11716d == null || !this.f11716d.isOpen()) {
                        this.f11714b = 0;
                        this.f11716d = super.getWritableDatabase();
                        this.f11716d.enableWriteAheadLogging();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f11716d;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    @Deprecated
    public void close() {
    }
}
