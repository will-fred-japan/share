package p055h3;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.frameworks.core.apm.contentprovider.MonitorContentProvider;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import p047g3.c;
import p047g3.d;
import p061i1.h;

/* JADX INFO: compiled from: BaseDao.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f19027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f19029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f19030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, Integer> f19031e = new HashMap<>();

    /* JADX INFO: renamed from: h3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseDao.java */
    public interface InterfaceC0207a<T> {
        T a(b bVar);
    }

    /* JADX INFO: compiled from: BaseDao.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Cursor f19032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, Integer> f19033b;

        public b(Cursor cursor, HashMap<String, Integer> map) {
            this.f19032a = cursor;
            this.f19033b = map;
        }

        public final int a(String str) {
            HashMap<String, Integer> map = this.f19033b;
            Integer numValueOf = map.get(str);
            if (numValueOf == null) {
                try {
                    numValueOf = Integer.valueOf(this.f19032a.getColumnIndex(str));
                } catch (Throwable unused) {
                    numValueOf = -1;
                }
                map.put(str, numValueOf);
            }
            return numValueOf.intValue();
        }

        public final long b(String str) {
            try {
                return this.f19032a.getLong(a(str));
            } catch (Throwable unused) {
                return -1L;
            }
        }

        public final String c(String str) {
            try {
                return this.f19032a.getString(a(str));
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    public a() {
        Application application = h.f19229a;
        this.f19027a = application;
        this.f19028b = application.getPackageName() + ".apm";
        if (this instanceof p070j3.b) {
            return;
        }
        Application application2 = h.f19229a;
        int i9 = p078k3.a.f19943a;
        String absolutePath = application2.getDatabasePath("apm_monitor_t1.db").getAbsolutePath();
        if (absolutePath == null) {
            HashMap map = c.f18872a;
            return;
        }
        HashMap map2 = c.f18872a;
        HashSet hashSet = (HashSet) map2.get(absolutePath);
        if (hashSet == null) {
            synchronized (map2) {
                try {
                    hashSet = (HashSet) map2.get(absolutePath);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        map2.put(absolutePath, hashSet);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        hashSet.add(this);
    }

    public static void g(Cursor cursor) {
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

    @Override // p047g3.d
    public final String a() {
        return i();
    }

    @Override // p047g3.d
    public final long b() {
        return d(null);
    }

    public final synchronized <I extends T> long c(ContentValues contentValues) {
        try {
            Uri uriInsert = h.f19229a.getContentResolver().insert(j(), contentValues);
            if (uriInsert == null) {
                return -1L;
            }
            try {
                return Long.parseLong(uriInsert.getLastPathSegment());
            } catch (Exception unused) {
                return 1L;
            }
        } catch (Exception unused2) {
            return -1L;
        }
    }

    public final long d(String str) {
        String string;
        long j = -1;
        Cursor cursorQuery = null;
        try {
            try {
                Application application = h.f19229a;
                Uri uriJ = j();
                if (str == null) {
                    if (this.f19030d == null) {
                        this.f19030d = "SELECT count(*) FROM ".concat(i());
                    }
                    string = this.f19030d;
                } else {
                    StringBuilder sb = new StringBuilder();
                    if (this.f19030d == null) {
                        this.f19030d = "SELECT count(*) FROM ".concat(i());
                    }
                    sb.append(this.f19030d);
                    sb.append(" where ");
                    sb.append(str);
                    string = sb.toString();
                }
                String str2 = string;
                int i9 = MonitorContentProvider.f12130b;
                try {
                    cursorQuery = application.getContentResolver().query(uriJ, null, str2, null, "rawQuery");
                } catch (Exception unused) {
                }
                if (cursorQuery != null && cursorQuery.moveToNext()) {
                    j = cursorQuery.getLong(0);
                }
                return j;
            } catch (Exception unused2) {
                g(cursorQuery);
                return -1L;
            }
        } finally {
            g(cursorQuery);
        }
    }

    public abstract ContentValues e(R1.c cVar);

    public final List<T> f(String str, String[] strArr, String str2, InterfaceC0207a<T> interfaceC0207a) {
        Cursor cursorQuery;
        int iIntValue;
        int iIndexOf;
        try {
            cursorQuery = this.f19027a.getContentResolver().query(j(), h(), str, strArr, str2);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        if (TextUtils.isEmpty(str2) || (iIndexOf = str2.indexOf("LIMIT")) <= 0) {
                            iIntValue = Integer.MAX_VALUE;
                        } else {
                            int iIndexOf2 = str2.indexOf("OFF");
                            iIntValue = iIndexOf2 > 0 ? Integer.valueOf(str2.substring(iIndexOf + 5, iIndexOf2).trim()).intValue() : Integer.valueOf(str2.substring(iIndexOf + 5).trim()).intValue();
                        }
                        LinkedList linkedList = new LinkedList();
                        for (int i9 = 0; cursorQuery.moveToNext() && i9 < iIntValue; i9++) {
                            linkedList.add(interfaceC0207a.a(new b(cursorQuery, this.f19031e)));
                        }
                        g(cursorQuery);
                        return linkedList;
                    }
                } catch (Throwable unused) {
                    g(cursorQuery);
                    return Collections.EMPTY_LIST;
                }
            }
            List<T> list = Collections.EMPTY_LIST;
            g(cursorQuery);
            return list;
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
    }

    public abstract String[] h();

    public abstract String i();

    public final Uri j() {
        if (this.f19029c == null) {
            StringBuilder sb = new StringBuilder("content://");
            sb.append(this.f19028b);
            sb.append("/apm_monitor_t1.db/");
            int i9 = p078k3.a.f19943a;
            sb.append(i());
            this.f19029c = Uri.parse(sb.toString());
        }
        return this.f19029c;
    }

    @Override // p047g3.d
    public final void b(long j) {
        try {
            this.f19027a.getContentResolver().delete(j(), "timestamp <=?", new String[]{String.valueOf(j)});
        } catch (Exception unused) {
        }
    }
}
