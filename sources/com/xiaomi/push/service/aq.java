package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.fw;
import com.xiaomi.push.hz;
import com.xiaomi.push.ia;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile aq f18237a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Context f1042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected final SharedPreferences f1043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HashSet<a> f1044a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final SharedPreferences f18238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final SharedPreferences f18239c;

    public static abstract class a implements Runnable {
        private String mDescription;
        private int mId;

        public a(int i9, String str) {
            this.mId = i9;
            this.mDescription = str;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.mId == ((a) obj).mId;
        }

        public int hashCode() {
            return this.mId;
        }

        public abstract void onCallback();

        @Override // java.lang.Runnable
        public final void run() {
            onCallback();
        }
    }

    private aq(Context context) {
        this.f1043a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.f18238b = context.getSharedPreferences("mipush_oc_custom", 0);
        this.f18239c = context.getSharedPreferences("mipush_oc_update_cache", 0);
        this.f1042a = context;
    }

    public synchronized void a(a aVar) {
        if (!this.f1044a.contains(aVar)) {
            this.f1044a.add(aVar);
        }
    }

    public void b() {
        com.xiaomi.channel.commonutils.logger.c.c("OC_Callback : receive new oc data");
        HashSet<a> hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f1044a);
        }
        for (a aVar : hashSet) {
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }

    public void c() {
        if (!com.xiaomi.push.k.m649a(this.f1042a)) {
            com.xiaomi.channel.commonutils.logger.c.m13a("OnlineConfig", "not xmsf package, not schedule report");
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!this.f18239c.contains("oc_report_start_time")) {
                this.f18239c.edit().putLong("oc_report_start_time", jCurrentTimeMillis).apply();
            }
            long j = (jCurrentTimeMillis - this.f18239c.getLong("oc_last_schedule_report_time", 0L)) / 1000;
            com.xiaomi.push.ah.a(this.f1042a).b(new ap(this.f1042a), (j <= 0 || j >= 1296000) ? 10 : (int) (1296000 - j));
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.b("OnlineConfig", "init oc report error", e9.getMessage());
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m756a() {
        this.f1044a.clear();
    }

    public static aq a(Context context) {
        if (f18237a == null) {
            synchronized (aq.class) {
                try {
                    if (f18237a == null) {
                        f18237a = new aq(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f18237a;
    }

    private void b(List<Pair<ia, Integer>> list) {
        if (!com.xiaomi.push.k.m649a(this.f1042a)) {
            com.xiaomi.channel.commonutils.logger.c.m13a("OnlineConfig", "not xmsf package, not report normal config");
        } else {
            if (com.xiaomi.push.ab.a(list)) {
                return;
            }
            a(2, list, m755a(list) ? 1 : 0);
        }
    }

    public void a(List<Pair<ia, Integer>> list, List<Pair<Integer, Object>> list2) {
        if (com.xiaomi.push.k.m649a(this.f1042a)) {
            try {
                int i9 = this.f18239c.getInt("oc_normal_count", 0);
                if (i9 == Integer.MAX_VALUE) {
                    com.xiaomi.channel.commonutils.logger.c.c("OnlineConfig", "update normal count error, count is max");
                }
                this.f18239c.edit().putInt("oc_normal_count", i9 + 1).apply();
                SharedPreferences.Editor editorEdit = this.f18239c.edit();
                int i10 = this.f1043a.getInt(a(ia.MISC_CONFIG), 0);
                int i11 = this.f1043a.getInt(a(ia.PLUGIN_CONFIG), 0);
                editorEdit.putInt("oc_old_misc_version", i10);
                editorEdit.putInt("oc_old_plugin_version", i11);
                editorEdit.apply();
            } catch (Exception e9) {
                com.xiaomi.channel.commonutils.logger.c.b("OnlineConfig", "update normal cache error", e9.getMessage());
            }
        }
        if (!com.xiaomi.push.ab.a(list) && !com.xiaomi.push.ab.a(list2)) {
            SharedPreferences.Editor editorEdit2 = this.f1043a.edit();
            editorEdit2.clear();
            for (Pair<ia, Integer> pair : list) {
                Object obj = pair.first;
                if (obj != null && pair.second != null) {
                    editorEdit2.putInt(a((ia) obj), ((Integer) pair.second).intValue());
                }
            }
            for (Pair<Integer, Object> pair2 : list2) {
                Object obj2 = pair2.first;
                if (obj2 != null && pair2.second != null) {
                    a(editorEdit2, pair2, a(((Integer) obj2).intValue()));
                }
            }
            editorEdit2.apply();
            b(list);
            return;
        }
        com.xiaomi.channel.commonutils.logger.c.m10a("OnlineConfig", "not update oc, because versions or configs are empty");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m757a(List<Pair<Integer, Object>> list) {
        ArrayList arrayList;
        HashMap map;
        ArrayList arrayList2 = null;
        if (com.xiaomi.push.k.m649a(this.f1042a)) {
            try {
                int i9 = this.f18239c.getInt("oc_custom_count", 0);
                if (i9 == Integer.MAX_VALUE) {
                    com.xiaomi.channel.commonutils.logger.c.c("OnlineConfig", "update custom count error, count is max");
                }
                this.f18239c.edit().putInt("oc_custom_count", i9 + 1).apply();
                ArrayList arrayList3 = new ArrayList(list);
                try {
                    map = new HashMap(this.f18238b.getAll());
                    arrayList2 = arrayList3;
                } catch (Exception e9) {
                    arrayList = arrayList3;
                    e = e9;
                    com.xiaomi.channel.commonutils.logger.c.b("OnlineConfig", "update custom cache error", e.getMessage());
                    map = null;
                    arrayList2 = arrayList;
                }
            } catch (Exception e10) {
                e = e10;
                arrayList = null;
            }
        } else {
            map = null;
        }
        if (com.xiaomi.push.ab.a(list)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f18238b.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null) {
                String strA = a(((Integer) obj).intValue());
                if (pair.second == null) {
                    editorEdit.remove(strA);
                } else {
                    a(editorEdit, pair, strA);
                }
            }
        }
        editorEdit.apply();
        a(arrayList2, map);
    }

    private void a(List<Pair<Integer, Object>> list, Map<String, ?> map) {
        if (!com.xiaomi.push.k.m649a(this.f1042a)) {
            com.xiaomi.channel.commonutils.logger.c.m13a("OnlineConfig", "not xmsf package, not report custom config");
            return;
        }
        if (com.xiaomi.push.ab.a(list) || map == null || map.isEmpty()) {
            return;
        }
        try {
            String strM751a = m751a(a((Map<String, ?>) new HashMap(this.f18238b.getAll())));
            String strM751a2 = m751a(a(map));
            String strM751a3 = m751a(list);
            this.f18239c.edit().putString("oc_custom_config_md5", strM751a).apply();
            boolean zEquals = TextUtils.equals(strM751a3, strM751a);
            if (TextUtils.equals(strM751a2, strM751a3)) {
                return;
            }
            a(3, (List<Pair<ia, Integer>>) null, zEquals ? 1 : 0);
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.b("OnlineConfig", "prepare custom report error", e9.getMessage());
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private String m751a(List<Pair<Integer, Object>> list) {
        return com.xiaomi.push.bl.a(m752a(list).toString());
    }

    private Pair<Integer, Object> a(List<Pair<Integer, Object>> list) {
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null && ((Integer) obj).intValue() == hz.AppIsInstalledList.a()) {
                return pair;
            }
        }
        return null;
    }

    private Object a(Pair<Integer, Object> pair) {
        String[] strArrSplit = ((String) pair.second).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        Arrays.sort(strArrSplit);
        return com.xiaomi.push.bm.a(strArrSplit, Constants.ACCEPT_TIME_SEPARATOR_SP);
    }

    private static List<Pair<Integer, Object>> a(Map<String, ?> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key.startsWith("oc_")) {
                        int i9 = Integer.parseInt(key.substring(3));
                        Integer numValueOf = Integer.valueOf(i9);
                        Object value = entry.getValue();
                        if (i9 == hz.AppIsInstalledList.a()) {
                            value = com.xiaomi.push.bj.b((String) value);
                        }
                        arrayList.add(new Pair(numValueOf, value));
                    }
                }
            } catch (NumberFormatException e9) {
                com.xiaomi.channel.commonutils.logger.c.b("OnlineConfig", "convert list error", e9.getMessage());
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private List<Pair<Integer, Object>> m752a(List<Pair<Integer, Object>> list) {
        if (!com.xiaomi.push.ab.a(list)) {
            try {
                Pair<Integer, Object> pairA = a(list);
                list.remove(pairA);
                list.add(new Pair<>(Integer.valueOf(hz.AppIsInstalledList.a()), a(pairA)));
                Collections.sort(list, new Comparator<Pair<Integer, Object>>() { // from class: com.xiaomi.push.service.aq.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(Pair<Integer, Object> pair, Pair<Integer, Object> pair2) {
                        return Integer.compare(((Integer) pair.first).intValue(), ((Integer) pair2.first).intValue());
                    }
                });
                return list;
            } catch (Exception e9) {
                com.xiaomi.channel.commonutils.logger.c.b("OnlineConfig", "sort config error", e9.getMessage());
            }
        }
        return list;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m755a(List<Pair<ia, Integer>> list) {
        if (com.xiaomi.push.ab.a(list)) {
            return false;
        }
        try {
            for (Pair<ia, Integer> pair : list) {
                Object obj = pair.first;
                if (obj != null && pair.second != null) {
                    if (this.f1043a.getInt(a((ia) obj), 0) != ((Integer) pair.second).intValue()) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.b("OnlineConfig", "compare version error", e9.getMessage());
            return true;
        }
    }

    public void a(int i9, List<Pair<ia, Integer>> list, int i10) {
        try {
            HashMap map = new HashMap();
            long jCurrentTimeMillis = System.currentTimeMillis();
            map.put("uuid", a());
            if (this.f18239c != null) {
                JSONObject jSONObjectM753a = m753a(i9);
                int i11 = this.f18239c.getInt("oc_request_count", 0);
                int i12 = this.f18239c.getInt("oc_normal_count", 0);
                int i13 = this.f18239c.getInt("oc_custom_count", 0);
                long j = this.f18239c.getLong("oc_report_start_time", 0L);
                map.put("oc_data", jSONObjectM753a.toString());
                map.put("oc_request_count", Integer.valueOf(i11));
                map.put("oc_normal_count", Integer.valueOf(i12));
                map.put("oc_custom_count", Integer.valueOf(i13));
                map.put("oc_start_time", Long.valueOf(j));
                map.put("oc_end_time", Long.valueOf(jCurrentTimeMillis));
                if (i9 == 0) {
                    map.put("oc_report_type", 0);
                    m754a((Map<String, Object>) map);
                } else if (i9 == 3) {
                    map.put("oc_report_type", 1);
                    a(map, i10);
                } else {
                    if (i9 != 2) {
                        return;
                    }
                    map.put("oc_report_type", 1);
                    a(map, list, i10);
                }
            }
            fw.a().a("oc_update", map);
            SharedPreferences sharedPreferences = this.f18239c;
            if (sharedPreferences != null) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                long j8 = this.f18239c.getLong("oc_last_schedule_report_time", 0L);
                editorEdit.clear();
                editorEdit.putLong("oc_report_start_time", jCurrentTimeMillis);
                editorEdit.putLong("oc_last_schedule_report_time", j8);
                editorEdit.apply();
            }
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.b("OnlineConfig", "report oc error", e9.getMessage());
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m754a(Map<String, Object> map) {
        SharedPreferences sharedPreferences;
        if (map == null || this.f1043a == null || (sharedPreferences = this.f18239c) == null) {
            return;
        }
        String string = sharedPreferences.getString("oc_custom_config_md5", "");
        int i9 = this.f1043a.getInt(a(ia.MISC_CONFIG), 0);
        int i10 = this.f1043a.getInt(a(ia.PLUGIN_CONFIG), 0);
        map.put("oc_custom_config_md5", string);
        map.put("oc_local_misc_version", Integer.valueOf(i9));
        map.put("oc_local_plugin_version", Integer.valueOf(i10));
    }

    private void a(Map<String, Object> map, List<Pair<ia, Integer>> list, int i9) {
        SharedPreferences sharedPreferences;
        Object obj;
        if (map == null || com.xiaomi.push.ab.a(list) || this.f1043a == null || (sharedPreferences = this.f18239c) == null) {
            return;
        }
        try {
            int i10 = sharedPreferences.getInt("oc_old_misc_version", 0);
            int i11 = this.f18239c.getInt("oc_old_plugin_version", 0);
            int i12 = this.f1043a.getInt(a(ia.MISC_CONFIG), 0);
            int i13 = this.f1043a.getInt(a(ia.PLUGIN_CONFIG), 0);
            int iIntValue = -1;
            int iIntValue2 = -1;
            for (Pair<ia, Integer> pair : list) {
                Object obj2 = pair.first;
                if (obj2 != null && (obj = pair.second) != null) {
                    if (obj2 == ia.MISC_CONFIG) {
                        iIntValue = ((Integer) obj).intValue();
                    } else if (obj2 == ia.PLUGIN_CONFIG) {
                        iIntValue2 = ((Integer) obj).intValue();
                    }
                }
            }
            map.put("oc_update_type", "normal");
            map.put("oc_old_misc_version", Integer.valueOf(i10));
            map.put("oc_old_plugin_version", Integer.valueOf(i11));
            map.put("oc_local_misc_version", Integer.valueOf(i12));
            map.put("oc_local_plugin_version", Integer.valueOf(i13));
            map.put("oc_new_misc_version", Integer.valueOf(iIntValue));
            map.put("oc_new_plugin_version", Integer.valueOf(iIntValue2));
            map.put("oc_update_result", Integer.valueOf(i9));
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.b("OnlineConfig", "add normal update report param error", e9.getMessage());
        }
    }

    private void a(Map<String, Object> map, int i9) {
        SharedPreferences sharedPreferences;
        if (map == null || (sharedPreferences = this.f18239c) == null) {
            return;
        }
        String string = sharedPreferences.getString("oc_custom_config_md5", "");
        map.put("oc_update_type", "custom");
        map.put("oc_custom_config_md5", string);
        map.put("oc_update_result", Integer.valueOf(i9));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private JSONObject m753a(int i9) {
        Map map = Collections.EMPTY_MAP;
        if (i9 == 3) {
            if (this.f18238b != null) {
                map = new HashMap(this.f18238b.getAll());
            }
        } else if (this.f1043a != null) {
            map = new HashMap(this.f1043a.getAll());
        }
        if (map != null && !map.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (str != null && value != null) {
                    try {
                        jSONObject.put(str, value);
                    } catch (JSONException e9) {
                        com.xiaomi.channel.commonutils.logger.c.b("OnlineConfig", "put JSON error", e9.getMessage());
                    }
                }
            }
            return jSONObject;
        }
        return new JSONObject();
    }

    private String a() {
        String string = this.f1042a.getSharedPreferences("mipush_account", 0).getString("uuid", null);
        if (!TextUtils.isEmpty(string)) {
            String[] strArrSplit = string.split("@");
            if (strArrSplit.length > 0) {
                return strArrSplit[0];
            }
        }
        return null;
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        Object obj = pair.second;
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str.equals(a(hz.AppIsInstalledList.a()))) {
                editor.putString(str, com.xiaomi.push.bj.a(str2));
                return;
            } else {
                editor.putString(str, str2);
                return;
            }
        }
        if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
        }
    }

    public int a(int i9, int i10) {
        try {
            String strA = a(i9);
            if (this.f18238b.contains(strA)) {
                return this.f18238b.getInt(strA, 0);
            }
            return this.f1043a.contains(strA) ? this.f1043a.getInt(strA, 0) : i10;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m9a(i9 + " oc int error " + e9.getMessage());
            return i10;
        }
    }

    public long a(int i9, long j) {
        try {
            String strA = a(i9);
            if (this.f18238b.contains(strA)) {
                return this.f18238b.getLong(strA, 0L);
            }
            return this.f1043a.contains(strA) ? this.f1043a.getLong(strA, 0L) : j;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m9a(i9 + " oc long error " + e9.getMessage());
            return j;
        }
    }

    public String a(int i9, String str) {
        try {
            String strA = a(i9);
            if (this.f18238b.contains(strA)) {
                return this.f18238b.getString(strA, null);
            }
            return this.f1043a.contains(strA) ? this.f1043a.getString(strA, null) : str;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m9a(i9 + " oc string error " + e9.getMessage());
            return str;
        }
    }

    public boolean a(int i9, boolean z8) {
        try {
            String strA = a(i9);
            if (this.f18238b.contains(strA)) {
                return this.f18238b.getBoolean(strA, false);
            }
            return this.f1043a.contains(strA) ? this.f1043a.getBoolean(strA, false) : z8;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m9a(i9 + " oc boolean error " + e9.getMessage());
            return z8;
        }
    }

    public int a(ia iaVar, int i9) {
        try {
            return this.f1043a.getInt(a(iaVar), i9);
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m9a(iaVar + " version error " + e9.getMessage());
            return i9;
        }
    }

    private String a(int i9) {
        return W5.e.i(i9, "oc_");
    }

    private String a(ia iaVar) {
        return "oc_version_" + iaVar.a();
    }
}
