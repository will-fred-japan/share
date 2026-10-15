package com.bytedance.frameworks.core.apm.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import cc.dd.dd.aa.g;
import com.huawei.hms.actions.SearchIntents;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p078k3.a;

/* JADX INFO: loaded from: classes.dex */
public class MonitorContentProvider extends ContentProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f12130b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f12131a = new HashMap();

    public final synchronized Pair<SQLiteDatabase, String> a(Uri uri) {
        try {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments != null && pathSegments.size() >= 2) {
                String str = pathSegments.get(0);
                String str2 = pathSegments.get(1);
                if (str == null) {
                    return null;
                }
                SQLiteOpenHelper aVar = (SQLiteOpenHelper) this.f12131a.get(str);
                if (aVar == null) {
                    int i9 = a.f19943a;
                    if (!str.contains("apm_monitor_t1.db")) {
                        return null;
                    }
                    aVar = new a(getContext(), str, null, 1);
                    this.f12131a.put(str, aVar);
                }
                return new Pair<>(aVar.getWritableDatabase(), str2);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        int i9;
        Object obj;
        Pair pair;
        g gVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        if ("getPid".equals(str)) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("Pid", Process.myPid());
            return bundle2;
        }
        Uri.parse(str);
        Uri uri = Uri.parse(str);
        synchronized (this) {
            try {
                List<String> pathSegments = uri.getPathSegments();
                i9 = 0;
                obj = null;
                pair = (pathSegments == null || pathSegments.size() < 2 || !"sp".equals(pathSegments.get(0))) ? null : new Pair(getContext().getSharedPreferences(pathSegments.get(1), 0), pathSegments.size() > 2 ? pathSegments.get(2) : null);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (pair != null) {
            if (SearchIntents.EXTRA_QUERY.equals(str2)) {
                if (bundle != null && (gVar = (g) bundle.getParcelable("sp")) != null) {
                    obj = gVar.f8778b;
                }
                SharedPreferences sharedPreferences = (SharedPreferences) pair.first;
                String str3 = (String) pair.second;
                Bundle bundle3 = new Bundle();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                if (str3 == null) {
                    for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                        arrayList.add(new g(entry.getValue(), entry.getKey()));
                    }
                    bundle3.putParcelableArrayList("sp", arrayList);
                    return bundle3;
                }
                Object obj2 = sharedPreferences.getAll().get(str3);
                if (obj2 != null) {
                    obj = obj2;
                }
                if (obj instanceof Set) {
                    Set set = (Set) obj;
                    String[] strArr = new String[set.size()];
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        strArr[i9] = (String) it.next();
                        i9++;
                    }
                    obj = strArr;
                }
                arrayList.add(new g(obj, str3));
                bundle3.putParcelableArrayList("sp", arrayList);
                return bundle3;
            }
            if ("contains".equals(str2)) {
                SharedPreferences sharedPreferences2 = (SharedPreferences) pair.first;
                String str4 = (String) pair.second;
                Bundle bundle4 = new Bundle();
                bundle4.putBoolean("contains", sharedPreferences2.contains(str4));
                return bundle4;
            }
            if ("edit".equals(str2) && bundle != null) {
                SharedPreferences.Editor editorEdit = ((SharedPreferences) pair.first).edit();
                if (bundle.getBoolean("clear")) {
                    editorEdit.clear();
                }
                ArrayList<g> parcelableArrayList = bundle.getParcelableArrayList("edit");
                if (parcelableArrayList != null) {
                    for (g gVar2 : parcelableArrayList) {
                        Object obj3 = gVar2.f8778b;
                        if (obj3 == null) {
                            editorEdit.remove(gVar2.f8777a);
                        } else {
                            String str5 = gVar2.f8777a;
                            if (obj3 instanceof String) {
                                editorEdit.putString(str5, (String) obj3);
                            } else if (obj3 instanceof Integer) {
                                editorEdit.putInt(str5, ((Integer) obj3).intValue());
                            } else if (obj3 instanceof Long) {
                                editorEdit.putLong(str5, ((Long) obj3).longValue());
                            } else if (obj3 instanceof Float) {
                                editorEdit.putFloat(str5, ((Float) obj3).floatValue());
                            } else if (obj3 instanceof Boolean) {
                                editorEdit.putBoolean(str5, ((Boolean) obj3).booleanValue());
                            } else if (obj3 instanceof String[]) {
                                editorEdit.putStringSet(str5, new HashSet(Arrays.asList((String[]) obj3)));
                            }
                        }
                    }
                    editorEdit.apply();
                }
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase;
        Pair<SQLiteDatabase, String> pairA = a(uri);
        if (pairA == null || (sQLiteDatabase = (SQLiteDatabase) pairA.first) == null) {
            return -1;
        }
        try {
            return sQLiteDatabase.delete((String) pairA.second, str, strArr);
        } catch (Throwable unused) {
            return -1;
        }
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase;
        Pair<SQLiteDatabase, String> pairA = a(uri);
        if (pairA == null || (sQLiteDatabase = (SQLiteDatabase) pairA.first) == null) {
            return null;
        }
        try {
            long jInsert = sQLiteDatabase.insert((String) pairA.second, null, contentValues);
            if (jInsert >= 0) {
                return ContentUris.withAppendedId(uri, jInsert);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        getContext().getPackageName();
        return false;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase sQLiteDatabase;
        Pair<SQLiteDatabase, String> pairA = a(uri);
        if (pairA == null || (sQLiteDatabase = (SQLiteDatabase) pairA.first) == null) {
            return null;
        }
        if (TextUtils.equals(str2, "rawQuery")) {
            return sQLiteDatabase.rawQuery(str, strArr2);
        }
        if (!TextUtils.equals(str2, "execSQL")) {
            SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
            sQLiteQueryBuilder.setTables((String) pairA.second);
            return sQLiteQueryBuilder.query(sQLiteDatabase, strArr, str, strArr2, null, null, str2);
        }
        String[] strArrSplit = str.split(";");
        for (String str3 : strArrSplit) {
            if (!TextUtils.isEmpty(str3)) {
                sQLiteDatabase.execSQL(str3);
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase;
        Pair<SQLiteDatabase, String> pairA = a(uri);
        if (pairA == null || (sQLiteDatabase = (SQLiteDatabase) pairA.first) == null) {
            return -1;
        }
        try {
            return sQLiteDatabase.update((String) pairA.second, contentValues, str, strArr);
        } catch (Throwable unused) {
            return -1;
        }
    }
}
