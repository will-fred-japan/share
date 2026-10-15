package cn.jiguang.q;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.aw.j;
import cn.jiguang.aw.x;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f10701a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HashMap<String, cn.jiguang.o.c> f10702b;

    public static Bundle a(HashMap<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }

    public static String b(HashMap<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        for (String str : map.keySet()) {
            builder.appendQueryParameter(str, map.get(str));
        }
        return builder.toString();
    }

    private static List<String> c(cn.jiguang.o.a aVar, List<String> list) {
        return a(aVar.f10653p, list);
    }

    public static cn.jiguang.o.c a(Context context, String str) {
        try {
            return new cn.jiguang.o.c(str, "", context.getPackageManager().getApplicationInfo(str, 0).targetSdkVersion);
        } catch (Throwable th) {
            W5.e.t(th, new StringBuilder("getWakeTarget throwable:"), "JWakeHelper");
            return null;
        }
    }

    private static List<String> b(cn.jiguang.o.a aVar, List<String> list) {
        if (!TextUtils.isEmpty(aVar.f10651n) && !aVar.f10651n.equals("disable")) {
            List<String> list2 = aVar.f10652o;
            String str = aVar.f10651n;
            str.getClass();
            if (str.equals("exclude")) {
                return a(list2, list);
            }
            if (str.equals("include")) {
                return b(list2, list);
            }
        }
        return list;
    }

    public static void c(Context context) {
        j.d("wake_cache_v2.json");
    }

    private static List<String> b(List<String> list, List<String> list2) {
        return a(list, list2, true);
    }

    public static JSONArray b(Context context) {
        JSONObject jSONObjectA;
        synchronized (f10701a) {
            jSONObjectA = j.a("wake_cache_v2.json");
        }
        if (jSONObjectA == null) {
            jSONObjectA = new JSONObject();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("content");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            return a(context, jSONArrayOptJSONArray);
        }
        cn.jiguang.x.f.c("JWakeHelper", "no save data");
        return null;
    }

    private static JSONObject b(List<cn.jiguang.o.b> list) {
        if (list == null || list.size() == 0) {
            cn.jiguang.x.f.c("JWakeHelper", "wakeUpResult is empty, no need report");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (cn.jiguang.o.b bVar : list) {
            try {
                HashMap<Integer, Integer> map = bVar.f10664b;
                if (map != null && !map.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("package", bVar.f10663a);
                    JSONArray jSONArray2 = new JSONArray();
                    HashMap<Integer, Integer> map2 = bVar.f10664b;
                    for (Integer num : map2.keySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("wake_type", num);
                        jSONObject2.put("wake_status", map2.get(num));
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("data", jSONArray2);
                    jSONArray.put(jSONObject);
                }
            } catch (Throwable th) {
                W5.f.m("formatReportData:", "JWakeHelper", th);
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("target", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject3;
    }

    public static String a(List<cn.jiguang.o.c> list) {
        StringBuilder sb = new StringBuilder();
        for (int i9 = 0; i9 < list.size(); i9++) {
            String str = list.get(i9).f10665a;
            String str2 = list.get(i9).f10666b;
            sb.append(str);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(str2);
            sb.append("$");
        }
        return sb.toString();
    }

    public static HashMap<String, cn.jiguang.o.c> a(Context context) {
        cn.jiguang.o.c cVarA;
        try {
            HashMap<String, cn.jiguang.o.c> map = new HashMap<>();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.DaemonService");
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && listQueryIntentServices.size() != 0) {
                for (int i9 = 0; i9 < listQueryIntentServices.size(); i9++) {
                    ServiceInfo serviceInfo = listQueryIntentServices.get(i9).serviceInfo;
                    String str = serviceInfo.name;
                    String str2 = serviceInfo.packageName;
                    if (str != null && str2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && serviceInfo.exported && serviceInfo.enabled && !context.getPackageName().equals(str2) && (cVarA = a.a(context, packageManager, str2, str)) != null) {
                        cn.jiguang.x.f.c("JWakeHelper", "wakeTarget:" + cVarA.toString());
                        map.put(cVarA.f10665a, cVarA);
                    }
                }
                return map;
            }
            return null;
        } catch (Throwable th) {
            W5.e.t(th, new StringBuilder("getWakeTargetMap throwable:"), "JWakeHelper");
            return null;
        }
    }

    public static HashMap<String, cn.jiguang.o.c> a(Context context, HashMap<String, cn.jiguang.o.c> map) {
        try {
            HashMap<String, cn.jiguang.o.c> map2 = f10702b;
            if (map2 != null && !map2.isEmpty()) {
                return f10702b;
            }
            HashMap<String, cn.jiguang.o.c> map3 = new HashMap<>();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.PushService");
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && listQueryIntentServices.size() != 0) {
                for (int i9 = 0; i9 < listQueryIntentServices.size(); i9++) {
                    ServiceInfo serviceInfo = listQueryIntentServices.get(i9).serviceInfo;
                    String str = serviceInfo.name;
                    String str2 = serviceInfo.packageName;
                    if (str != null && str2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && ((map == null || !map.containsKey(str2)) && !context.getPackageName().equals(str2))) {
                        int iCheckPermission = packageManager.checkPermission(str2 + ".permission.JPUSH_MESSAGE", str2);
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str2, 128);
                        if (applicationInfo != null && applicationInfo.metaData != null) {
                            String strA = cn.jiguang.w.a.a(context);
                            if (iCheckPermission == 0 && !TextUtils.isEmpty(strA) && strA.length() == 24 && !context.getPackageName().equals(applicationInfo.packageName)) {
                                cn.jiguang.o.c cVar = new cn.jiguang.o.c(str2, "", applicationInfo.targetSdkVersion);
                                cVar.f10668d = str2 + ".DownloadProvider";
                                map3.put(cVar.f10665a, cVar);
                            }
                        }
                    }
                }
                f10702b = map3;
                cn.jiguang.x.f.c("JWakeHelper", "getWakeAppListWithoutDService:" + map3.toString());
                return map3;
            }
            return null;
        } catch (Throwable th) {
            W5.e.t(th, new StringBuilder("getWakeAppListWithoutDService throwable:"), "JWakeHelper");
            return null;
        }
    }

    public static List<cn.jiguang.o.c> a(Context context, List<cn.jiguang.o.c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (int i9 = 0; i9 < list.size(); i9++) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(list.get(i9).f10665a, 128);
                list.get(i9).f10667c = applicationInfo.targetSdkVersion;
            } catch (Throwable unused) {
            }
        }
        return list;
    }

    public static List<String> a(cn.jiguang.o.a aVar, List<String> list) {
        return aVar == null ? list : c(aVar, b(aVar, list));
    }

    public static List<cn.jiguang.o.c> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("\\$");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split("\\|");
            if (strArrSplit2.length < 2) {
                cn.jiguang.x.f.c("JWakeHelper", "split.length < 2, data:".concat(str2));
            } else {
                String str3 = strArrSplit2[0];
                String str4 = strArrSplit2[1];
                cn.jiguang.o.c cVar = new cn.jiguang.o.c();
                cVar.f10665a = str3;
                cVar.f10666b = str4;
                cVar.j = 1;
                cVar.f10671g = 4;
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    private static List<String> a(List<String> list, List<String> list2) {
        return a(list, list2, false);
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private static java.util.List<java.lang.String> a(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r5v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */

    private static JSONArray a(Context context, JSONArray jSONArray) {
        JSONArray jSONArray2;
        HashMap map;
        int i9;
        Map map2;
        HashMap map3;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    HashMap map4 = new HashMap();
                    int i10 = 0;
                    while (i10 < jSONArray.length()) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i10);
                        String strOptString = jSONObject.optString("type");
                        if ("aa3".equals(strOptString)) {
                            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("target");
                            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                                break;
                            }
                            long jOptLong = jSONObject.optLong("itime");
                            Iterator it = map4.entrySet().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    map = map4;
                                    i9 = i10;
                                    jSONArray2 = null;
                                    map2 = null;
                                    break;
                                }
                                Map.Entry entry = (Map.Entry) it.next();
                                long jLongValue = ((Long) entry.getKey()).longValue();
                                i9 = i10;
                                map = map4;
                                jSONArray2 = null;
                                if (x.a(jOptLong * 1000, jLongValue * 1000)) {
                                    map2 = (Map) entry.getValue();
                                    jOptLong = jLongValue;
                                    break;
                                }
                                i10 = i9;
                                map4 = map;
                            }
                            if (map2 == null) {
                                map2 = new HashMap();
                            }
                            for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i11);
                                JSONArray jSONArray3 = jSONObjectOptJSONObject.getJSONArray("data");
                                if (jSONArray3 != null && jSONArray3.length() > 0) {
                                    String strOptString2 = jSONObjectOptJSONObject.optString("package");
                                    for (int i12 = 0; i12 < jSONArray3.length(); i12++) {
                                        JSONObject jSONObject2 = jSONArray3.getJSONObject(i12);
                                        if (jSONObject2 != null) {
                                            int i13 = jSONObject2.getInt("wake_type");
                                            int i14 = jSONObject2.getInt("wake_status");
                                            if (map2.containsKey(strOptString2)) {
                                                Map map5 = (Map) map2.get(strOptString2);
                                                if (map5.containsKey(Integer.valueOf(i13))) {
                                                    Map map6 = (Map) map5.get(Integer.valueOf(i13));
                                                    if (map6.containsKey(Integer.valueOf(i14))) {
                                                        map6.put(Integer.valueOf(i14), Integer.valueOf(((Integer) map6.get(Integer.valueOf(i14))).intValue() + 1));
                                                    } else {
                                                        map6.put(Integer.valueOf(i14), 1);
                                                    }
                                                    map5.put(Integer.valueOf(i13), map6);
                                                } else {
                                                    HashMap map7 = new HashMap();
                                                    map7.put(Integer.valueOf(i14), 1);
                                                    map5.put(Integer.valueOf(i13), map7);
                                                }
                                                map2.put(strOptString2, map5);
                                            } else {
                                                HashMap map8 = new HashMap();
                                                map8.put(Integer.valueOf(i14), 1);
                                                HashMap map9 = new HashMap();
                                                map9.put(Integer.valueOf(i13), map8);
                                                map2.put(strOptString2, map9);
                                            }
                                        }
                                    }
                                }
                            }
                            map3 = map;
                            map3.put(Long.valueOf(jOptLong), map2);
                        } else {
                            cn.jiguang.x.f.i("JWakeHelper", "unkown type :" + strOptString);
                            map3 = map4;
                            i9 = i10;
                            jSONArray2 = null;
                        }
                        try {
                            i10 = i9 + 1;
                            map4 = map3;
                        } catch (Throwable th) {
                            th = th;
                        }
                    }
                    HashMap map10 = map4;
                    jSONArray2 = null;
                    JSONArray jSONArray4 = new JSONArray();
                    Iterator it2 = map10.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry entry2 = (Map.Entry) it2.next();
                        JSONArray jSONArray5 = new JSONArray();
                        Iterator it3 = ((Map) entry2.getValue()).entrySet().iterator();
                        while (it3.hasNext()) {
                            Map.Entry entry3 = (Map.Entry) it3.next();
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("p", entry3.getKey());
                            JSONArray jSONArray6 = new JSONArray();
                            Iterator it4 = ((Map) entry3.getValue()).entrySet().iterator();
                            while (it4.hasNext()) {
                                Map.Entry entry4 = (Map.Entry) it4.next();
                                Integer num = (Integer) entry4.getKey();
                                Map map11 = (Map) entry4.getValue();
                                int iIntValue = map11.containsKey(1) ? ((Integer) map11.get(1)).intValue() : 0;
                                Iterator it5 = it2;
                                int iIntValue2 = map11.containsKey(101) ? ((Integer) map11.get(101)).intValue() : 0;
                                Map.Entry entry5 = entry2;
                                int iIntValue3 = map11.containsKey(102) ? ((Integer) map11.get(102)).intValue() : 0;
                                Iterator it6 = it3;
                                int iIntValue4 = map11.containsKey(103) ? ((Integer) map11.get(103)).intValue() : 0;
                                jSONArray6.put(num + BundleUtil.UNDERLINE_TAG + (iIntValue + iIntValue2 + iIntValue3 + iIntValue4) + BundleUtil.UNDERLINE_TAG + iIntValue + BundleUtil.UNDERLINE_TAG + iIntValue2 + BundleUtil.UNDERLINE_TAG + iIntValue3 + BundleUtil.UNDERLINE_TAG + iIntValue4);
                                it4 = it4;
                                it2 = it5;
                                entry2 = entry5;
                                it3 = it6;
                            }
                            jSONObject3.put("d", jSONArray6);
                            jSONArray5.put(jSONObject3);
                            it2 = it2;
                            entry2 = entry2;
                            it3 = it3;
                        }
                        Iterator it7 = it2;
                        Map.Entry entry6 = entry2;
                        if (jSONArray5.length() > 0) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("t", jSONArray5);
                            jSONObject4.put("itime", ((Long) entry6.getKey()).longValue());
                            jSONObject4.put("type", "aa3");
                            jSONArray4.put(jSONObject4);
                        }
                        it2 = it7;
                    }
                    return jSONArray4.length() > 0 ? jSONArray4 : jSONArray;
                }
            } catch (Throwable th2) {
                th = th2;
                jSONArray2 = null;
            }
            cn.jiguang.x.f.j("JWakeHelper", "merge wake json failed:" + th.getMessage());
            return jSONArray2;
        }
        return jSONArray;
    }

    public static void a(Context context, cn.jiguang.o.a aVar, List<cn.jiguang.o.b> list) {
        if (!aVar.f10659w) {
            cn.jiguang.x.f.i("JWakeHelper", "server set do not report wake data,give up save");
            return;
        }
        JSONObject jSONObjectB = b(list);
        cn.jiguang.x.f.c("JWakeHelper", "wake json:" + jSONObjectB);
        a(context, jSONObjectB);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x005e */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(android.content.Context r4, org.json.JSONObject r5) {
        /*
            java.lang.String r0 = "save wake data : "
            if (r5 != 0) goto L5
            goto L6b
        L5:
            java.lang.String r1 = "itime"
            long r2 = cn.jiguang.d.b.b(r4)     // Catch: java.lang.Throwable -> L5e
            r5.put(r1, r2)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r4 = "type"
            java.lang.String r1 = "aa3"
            r5.put(r4, r1)     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r4 = cn.jiguang.q.c.f10701a     // Catch: java.lang.Throwable -> L5e
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r1 = "wake_cache_v2.json"
            org.json.JSONObject r1 = cn.jiguang.aw.j.a(r1)     // Catch: java.lang.Throwable -> L28
            if (r1 != 0) goto L2a
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L28
            r1.<init>()     // Catch: java.lang.Throwable -> L28
            goto L2a
        L28:
            r5 = move-exception
            goto L5c
        L2a:
            java.lang.String r2 = "content"
            org.json.JSONArray r2 = r1.optJSONArray(r2)     // Catch: java.lang.Throwable -> L28
            if (r2 != 0) goto L37
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L28
            r2.<init>()     // Catch: java.lang.Throwable -> L28
        L37:
            r2.put(r5)     // Catch: java.lang.Throwable -> L28
            java.lang.String r5 = "content"
            r1.put(r5, r2)     // Catch: java.lang.Throwable -> L28
            java.lang.String r5 = "wake_cache_v2.json"
            cn.jiguang.aw.j.a(r5, r1)     // Catch: java.lang.Throwable -> L28
            java.lang.String r5 = "JWakeHelper"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L28
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L28
            r2.append(r0)     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L28
            cn.jiguang.x.f.c(r5, r0)     // Catch: java.lang.Throwable -> L28
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L28
            return
        L5c:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L28
            throw r5     // Catch: java.lang.Throwable -> L5e
        L5e:
            r4 = move-exception
            java.lang.String r5 = "JWakeHelper"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "saveWakeData failed:"
            r0.<init>(r1)
            W5.e.t(r4, r0, r5)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.q.c.a(android.content.Context, org.json.JSONObject):void");
    }
}
