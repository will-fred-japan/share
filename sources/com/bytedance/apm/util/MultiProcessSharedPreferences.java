package com.bytedance.apm.util;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Pair;
import cc.dd.dd.b0.l;
import com.huawei.hms.actions.SearchIntents;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p010b3.b;

/* JADX INFO: loaded from: classes.dex */
public class MultiProcessSharedPreferences extends ContentProvider implements SharedPreferences {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f12124b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ContentResolver f12125a;

    public class a implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12126a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, Object> f12127b = new HashMap<>();

        public a(MultiProcessSharedPreferences multiProcessSharedPreferences) {
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            boolean z8 = this.f12126a;
            HashMap<String, Object> map = this.f12127b;
            if (z8 || !map.isEmpty()) {
                Bundle bundle = new Bundle();
                if (this.f12126a) {
                    bundle.putBoolean("clear", true);
                }
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(map.size());
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    arrayList.add(new l(entry.getValue(), entry.getKey()));
                }
                bundle.putParcelableArrayList("edit", arrayList);
                try {
                    int i9 = MultiProcessSharedPreferences.f12124b;
                    throw null;
                } catch (Exception e9) {
                    b.b("MultiProcessSharedPref", "apply exception: ", e9);
                }
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.f12127b.clear();
            this.f12126a = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String str, boolean z8) {
            this.f12127b.put(str, Boolean.valueOf(z8));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String str, float f6) {
            this.f12127b.put(str, Float.valueOf(f6));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String str, int i9) {
            this.f12127b.put(str, Integer.valueOf(i9));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String str, long j) {
            this.f12127b.put(str, Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String str, String str2) {
            this.f12127b.put(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            HashMap<String, Object> map = this.f12127b;
            String[] strArr = new String[set.size()];
            Iterator<String> it = set.iterator();
            int i9 = 0;
            while (it.hasNext()) {
                strArr[i9] = it.next();
                i9++;
            }
            map.put(str, strArr);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String str) {
            this.f12127b.put(str, null);
            return this;
        }
    }

    public static void a(SharedPreferences sharedPreferences, Bundle bundle) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (bundle.getBoolean("clear")) {
            editorEdit.clear();
        }
        ArrayList<l> parcelableArrayList = bundle.getParcelableArrayList("edit");
        if (parcelableArrayList == null) {
            return;
        }
        for (l lVar : parcelableArrayList) {
            Object obj = lVar.f8780b;
            String str = lVar.f8779a;
            if (obj == null) {
                editorEdit.remove(str);
            } else if (obj instanceof String) {
                editorEdit.putString(str, (String) obj);
            } else if (obj instanceof Integer) {
                editorEdit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                editorEdit.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                editorEdit.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Boolean) {
                editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof String[]) {
                editorEdit.putStringSet(str, new HashSet(Arrays.asList((String[]) obj)));
            }
        }
        editorEdit.commit();
    }

    public static void b(Object obj, String str) {
        Bundle bundle = new Bundle();
        if (obj != null) {
            bundle.putParcelable("sp", new l(obj, str));
        }
        try {
            throw null;
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        int i9;
        Object obj;
        Pair pair;
        l lVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
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
                if (bundle != null && (lVar = (l) bundle.getParcelable("sp")) != null) {
                    obj = lVar.f8780b;
                }
                SharedPreferences sharedPreferences = (SharedPreferences) pair.first;
                String str3 = (String) pair.second;
                Bundle bundle2 = new Bundle();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                if (str3 == null) {
                    for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                        arrayList.add(new l(entry.getValue(), entry.getKey()));
                    }
                    bundle2.putParcelableArrayList("sp", arrayList);
                    return bundle2;
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
                arrayList.add(new l(obj, str3));
                bundle2.putParcelableArrayList("sp", arrayList);
                return bundle2;
            }
            if ("contains".equals(str2)) {
                SharedPreferences sharedPreferences2 = (SharedPreferences) pair.first;
                String str4 = (String) pair.second;
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("contains", sharedPreferences2.contains(str4));
                return bundle3;
            }
            if ("edit".equals(str2) && bundle != null) {
                try {
                    a((SharedPreferences) pair.first, bundle);
                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                    this.f12125a.notifyChange(Uri.parse(str), null);
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                    return null;
                } catch (Throwable th2) {
                    b.b("MultiProcessSharedPref", "edit", th2);
                }
            }
        }
        return null;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        return false;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return -1;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new a(this);
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        b(null, null);
        return null;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z8) {
        b(String.valueOf(z8), str);
        return z8;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f6) {
        b(String.valueOf(f6), str);
        return f6;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i9) {
        b(String.valueOf(i9), str);
        return i9;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        b(String.valueOf(j), str);
        return j;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        b(str2, str);
        return null;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String str, Set<String> set) {
        b(set, str);
        return null;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        this.f12125a = getContext().getContentResolver();
        return false;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return -1;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
