package cn.jiguang.commons.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class df {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9874b;

    public df(Context context) {
        this.f9874b = "";
        this.f9873a = context;
        this.f9874b = km.b("SyfFpc71r1BITMlIo0m1Vt2cR3sdiPGnMd0WMSsF4yU8+J95KN/jHVtZShu2ONYO", f.f10031c);
    }

    public final String a(String str) {
        Cursor cursorQuery;
        Throwable th;
        StringBuilder sb;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String string = null;
        try {
            cursorQuery = this.f9873a.getContentResolver().query(Uri.parse(this.f9874b), null, null, new String[]{str}, null);
            try {
                if (cursorQuery == null) {
                    ee.a("MeizuDB", "return cursor is null,return");
                } else if (cursorQuery.moveToNext()) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                }
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th = th2;
                        sb = new StringBuilder("close cursor error: ");
                        sb.append(th.getMessage());
                        String string2 = sb.toString();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    ee.d("MeizuDB", "getId error: " + th.getMessage());
                    if (cursorQuery != null) {
                        try {
                        } catch (Throwable th4) {
                            th = th4;
                            sb = new StringBuilder("close cursor error: ");
                            sb.append(th.getMessage());
                            String string3 = sb.toString();
                        }
                    }
                } finally {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th5) {
                            ee.a("MeizuDB", "close cursor error: " + th5.getMessage());
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            cursorQuery = null;
        }
        return string;
    }
}
