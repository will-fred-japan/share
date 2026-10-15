package W0;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;

/* JADX INFO: compiled from: OaidVivoImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class o implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5024a = new a(1);

    /* JADX INFO: compiled from: OaidVivoImpl.java */
    public static class a extends V0.a {
        @Override // V0.a
        public final Object a(Object[] objArr) {
            return Boolean.valueOf("1".equals(o.b()));
        }
    }

    @Override // W0.l
    public final l.a a(Context context) {
        Cursor cursorQuery;
        l.a aVar = new l.a();
        Uri uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        String string = null;
        if (uri != null) {
            try {
                cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToNext()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            V0.m.a("", th);
                            V0.o.c(cursorQuery);
                        } catch (Throwable th2) {
                            V0.o.c(cursorQuery);
                            throw th2;
                        }
                    }
                }
                V0.o.c(cursorQuery);
            } catch (Throwable th3) {
                th = th3;
                cursorQuery = null;
            }
        }
        aVar.f5014a = string;
        return aVar;
    }

    @Override // W0.l
    public final boolean b(Context context) {
        return ((Boolean) f5024a.b(new Object[0])).booleanValue();
    }

    public static /* synthetic */ String b() {
        try {
            return SystemProperties.get("persist.sys.identifierid.supported", "0");
        } catch (Throwable unused) {
            return "0";
        }
    }
}
