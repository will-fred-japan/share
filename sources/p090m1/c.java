package p090m1;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import cc.dd.dd.aa.g;
import com.huawei.hms.actions.SearchIntents;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: MonitorSharedPreferences.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements SharedPreferences {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f20316d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f20317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f20319c;

    /* JADX INFO: compiled from: MonitorSharedPreferences.java */
    public class a implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20320a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, Object> f20321b = new HashMap<>();

        public a() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            c cVar = c.this;
            boolean z8 = this.f20320a;
            HashMap<String, Object> map = this.f20321b;
            if (z8 || !map.isEmpty()) {
                Bundle bundle = new Bundle();
                if (this.f20320a) {
                    bundle.putBoolean("clear", true);
                }
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(map.size());
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    arrayList.add(new g(entry.getValue(), entry.getKey()));
                }
                bundle.putParcelableArrayList("edit", arrayList);
                try {
                    cVar.f20317a.getContentResolver().call(cVar.f20319c, cVar.f20318b, "edit", bundle);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.f20321b.clear();
            this.f20320a = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String str, boolean z8) {
            this.f20321b.put(str, Boolean.valueOf(z8));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String str, float f6) {
            this.f20321b.put(str, Float.valueOf(f6));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String str, int i9) {
            this.f20321b.put(str, Integer.valueOf(i9));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String str, long j) {
            this.f20321b.put(str, Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String str, String str2) {
            this.f20321b.put(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            HashMap<String, Object> map = this.f20321b;
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
            this.f20321b.put(str, null);
            return this;
        }
    }

    public static SharedPreferences a(Context context, String str) {
        int i9 = -1;
        if (f20316d == -1) {
            try {
                Bundle bundleCall = context.getContentResolver().call(Uri.parse("content://" + context.getPackageName() + ".apm"), "getPid", (String) null, (Bundle) null);
                if (bundleCall != null) {
                    i9 = bundleCall.getInt("Pid", -1);
                }
            } catch (Exception unused) {
            }
            f20316d = i9;
        }
        if (f20316d == Process.myPid()) {
            return context.getSharedPreferences("" + str, 0);
        }
        Application application = context instanceof Application ? (Application) context : (Application) context.getApplicationContext();
        c cVar = new c();
        cVar.f20317a = application;
        String str2 = "content://" + application.getPackageName() + ".apm/sp/" + str;
        cVar.f20318b = str2;
        cVar.f20319c = Uri.parse(str2);
        return cVar;
    }

    public final ArrayList b(Object obj, String str) {
        Bundle bundleCall;
        Bundle bundle = new Bundle();
        if (obj != null) {
            bundle.putParcelable("sp", new g(obj, str));
        }
        try {
            ContentResolver contentResolver = this.f20317a.getContentResolver();
            Uri uri = this.f20319c;
            String str2 = this.f20318b;
            if (str != null) {
                str2 = str2 + "/" + str;
            }
            if (obj == null) {
                bundle = null;
            }
            bundleCall = contentResolver.call(uri, str2, SearchIntents.EXTRA_QUERY, bundle);
        } catch (Exception unused) {
            bundleCall = null;
        }
        if (bundleCall == null) {
            return null;
        }
        bundleCall.setClassLoader(c.class.getClassLoader());
        return bundleCall.getParcelableArrayList("sp");
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        Bundle bundleCall = null;
        try {
            ContentResolver contentResolver = this.f20317a.getContentResolver();
            Uri uri = this.f20319c;
            String str2 = this.f20318b;
            if (str != null) {
                str2 = str2 + "/" + str;
            }
            bundleCall = contentResolver.call(uri, str2, "contains", (Bundle) null);
        } catch (Exception unused) {
        }
        return bundleCall != null && bundleCall.getBoolean("contains");
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new a();
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        ArrayList<g> arrayListB = b(null, null);
        if (arrayListB == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (g gVar : arrayListB) {
            map.put(gVar.f8777a, gVar.f8778b);
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z8) {
        ArrayList arrayListB = b(String.valueOf(z8), str);
        if (arrayListB != null) {
            Object obj = ((g) arrayListB.get(0)).f8778b;
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            if (obj instanceof String) {
                return Boolean.valueOf((String) obj).booleanValue();
            }
        }
        return z8;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f6) {
        ArrayList arrayListB = b(String.valueOf(f6), str);
        if (arrayListB != null) {
            Object obj = ((g) arrayListB.get(0)).f8778b;
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            if (obj instanceof String) {
                return Float.valueOf((String) obj).floatValue();
            }
        }
        return f6;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i9) {
        ArrayList arrayListB = b(String.valueOf(i9), str);
        if (arrayListB != null) {
            Object obj = ((g) arrayListB.get(0)).f8778b;
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof String) {
                return Integer.decode((String) obj).intValue();
            }
        }
        return i9;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        ArrayList arrayListB = b(String.valueOf(j), str);
        if (arrayListB != null) {
            Object obj = ((g) arrayListB.get(0)).f8778b;
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            if (obj instanceof String) {
                return Long.decode((String) obj).longValue();
            }
        }
        return j;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        ArrayList arrayListB = b(str2, str);
        if (arrayListB == null) {
            return null;
        }
        return (String) ((g) arrayListB.get(0)).f8778b;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String str, Set<String> set) {
        ArrayList arrayListB = b(set, str);
        if (arrayListB == null || ((g) arrayListB.get(0)).f8778b == null) {
            return null;
        }
        String[] strArr = (String[]) ((g) arrayListB.get(0)).f8778b;
        HashSet hashSet = new HashSet(strArr.length);
        hashSet.addAll(Arrays.asList(strArr));
        return hashSet;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
