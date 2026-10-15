package W0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: compiled from: MeizuOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class i implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f5003a;

    /* JADX INFO: compiled from: MeizuOaidImpl.java */
    public class a extends V0.a {
        @Override // V0.a
        public final Object a(Object[] objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception unused) {
            }
            return Boolean.FALSE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    @Override // W0.l
    public final l.a a(Context context) {
        Cursor cursorQuery;
        String string;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
            try {
                l.a aVar = new l.a();
                if (cursorQuery.isClosed()) {
                    string = null;
                } else {
                    cursorQuery.moveToFirst();
                    int columnIndex = cursorQuery.getColumnIndex("value");
                    if (columnIndex >= 0) {
                        string = cursorQuery.getString(columnIndex);
                    } else {
                        string = null;
                    }
                }
                aVar.f5014a = string;
                cursorQuery.close();
                return aVar;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    @Override // W0.l
    public final boolean b(Context context) {
        if (context == null) {
            return false;
        }
        return ((Boolean) this.f5003a.b(context)).booleanValue();
    }
}
