package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.channel.commonutils.logger.c;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f18136a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f933a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final String[] f934a = {Constants.PACKAGE_NAME, "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};

    public a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, f18136a);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        int i9 = 0;
        while (true) {
            String[] strArr = f934a;
            if (i9 >= strArr.length - 1) {
                sb.append(");");
                sQLiteDatabase.execSQL(sb.toString());
                return;
            }
            if (i9 != 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(strArr[i9]);
            sb.append(" ");
            sb.append(strArr[i9 + 1]);
            i9 += 2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f933a) {
            try {
                a(sQLiteDatabase);
            } catch (SQLException e9) {
                c.m12a((Throwable) e9);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i9, int i10) {
    }
}
