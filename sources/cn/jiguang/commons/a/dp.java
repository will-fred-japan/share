package cn.jiguang.commons.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class dp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9899a;

    public dp(Context context) {
        this.f9899a = context;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0062 A[Catch: all -> 0x0074, TRY_ENTER, TryCatch #0 {all -> 0x0074, blocks: (B:17:0x0062, B:19:0x0068, B:22:0x007a), top: B:44:0x0060 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0068 A[Catch: all -> 0x0074, TryCatch #0 {all -> 0x0074, blocks: (B:17:0x0062, B:19:0x0068, B:22:0x007a), top: B:44:0x0060 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x007a A[Catch: all -> 0x0074, TRY_LEAVE, TryCatch #0 {all -> 0x0074, blocks: (B:17:0x0062, B:19:0x0068, B:22:0x007a), top: B:44:0x0060 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final String a(int i9, String str) {
        Throwable th;
        Cursor cursor;
        Throwable th2;
        StringBuilder sb;
        String strB;
        Uri uri;
        Cursor cursorQuery;
        String string = null;
        try {
            try {
                if (i9 == 0) {
                    strB = km.b("HDjJBOCwNx0aZi+Z7p83oR6X29bt13JSzReihhERik1zTqeaHqknpahXd0Fww8QTTjy7MHX7/1f2JKNuxQ9omA==", f.f10031c);
                } else {
                    if (i9 != 1) {
                        if (i9 != 2) {
                            uri = null;
                        } else {
                            strB = km.b("HDjJBOCwNx0aZi+Z7p83oR6X29bt13JSzReihhERik1FXRr9EgPkoDQnyVgIu2tARnCHNUAAn6DU1ZkzxwPHKA==", f.f10031c) + str;
                        }
                        cursorQuery = this.f9899a.getContentResolver().query(uri, null, null, null, null);
                        if (cursorQuery != null) {
                            ee.a("VivoDB", "return cursor is null,return");
                        } else if (cursorQuery.moveToNext()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                        }
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Throwable th3) {
                                th2 = th3;
                                sb = new StringBuilder("close cursor error: ");
                                sb.append(th2.getMessage());
                                String string2 = sb.toString();
                            }
                        }
                        return string;
                    }
                    strB = km.b("HDjJBOCwNx0aZi+Z7p83oR6X29bt13JSzReihhERik1mRRRjMzvkebo9eb3zqoVhCi2GjcOItUY/+C68T3lxGg==", f.f10031c) + str;
                }
                if (cursorQuery != null) {
                    ee.a("VivoDB", "return cursor is null,return");
                } else if (cursorQuery.moveToNext()) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th4) {
                cursor = cursorQuery;
                th = th4;
                try {
                    ee.d("VivoDB", "get id error: " + th.getMessage());
                    if (cursor != null) {
                        try {
                        } catch (Throwable th5) {
                            th2 = th5;
                            sb = new StringBuilder("close cursor error: ");
                            sb.append(th2.getMessage());
                            String string3 = sb.toString();
                        }
                    }
                } finally {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable th6) {
                            ee.a("VivoDB", "close cursor error: " + th6.getMessage());
                        }
                    }
                }
            }
            uri = Uri.parse(strB);
            cursorQuery = this.f9899a.getContentResolver().query(uri, null, null, null, null);
        } catch (Throwable th7) {
            th = th7;
            cursor = null;
        }
        return string;
    }
}
