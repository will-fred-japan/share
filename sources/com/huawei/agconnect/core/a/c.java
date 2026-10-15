package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f14643a;

    public static class a implements Serializable, Comparator<Map.Entry<String, Integer>> {
        private a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    public c(Context context) {
        this.f14643a = context;
    }

    private <T extends ServiceRegistrar> T a(String str) {
        StringBuilder sb;
        String string;
        try {
            Class<?> cls = Class.forName(str);
            if (ServiceRegistrar.class.isAssignableFrom(cls)) {
                return (T) Class.forName(str).newInstance();
            }
            Log.e("AGC_Registrar", cls + " must extends from ServiceRegistrar.");
            return null;
        } catch (ClassNotFoundException e9) {
            string = "Can not found service class, " + e9.getMessage();
            Log.e("AGC_Registrar", string);
            return null;
        } catch (IllegalAccessException e10) {
            e = e10;
            sb = new StringBuilder("instantiate service class exception ");
            sb.append(e.getLocalizedMessage());
            string = sb.toString();
            Log.e("AGC_Registrar", string);
            return null;
        } catch (InstantiationException e11) {
            e = e11;
            sb = new StringBuilder("instantiate service class exception ");
            sb.append(e.getLocalizedMessage());
            string = sb.toString();
            Log.e("AGC_Registrar", string);
            return null;
        }
    }

    private List<String> b() {
        String strConcat;
        ArrayList arrayList = new ArrayList();
        Bundle bundleC = c();
        if (bundleC != null) {
            HashMap map = new HashMap(10);
            for (String str : bundleC.keySet()) {
                if ("com.huawei.agconnect.core.ServiceRegistrar".equals(bundleC.getString(str))) {
                    String[] strArrSplit = str.split(Constants.COLON_SEPARATOR);
                    if (strArrSplit.length == 2) {
                        try {
                            map.put(strArrSplit[0], Integer.valueOf(strArrSplit[1]));
                        } catch (NumberFormatException e9) {
                            strConcat = "registrar configuration format error:" + e9.getMessage();
                            Log.e("AGC_Registrar", strConcat);
                        }
                    } else if (strArrSplit.length == 1) {
                        map.put(strArrSplit[0], 1000);
                    } else {
                        strConcat = "registrar configuration error, ".concat(str);
                        Log.e("AGC_Registrar", strConcat);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList(map.entrySet());
            Collections.sort(arrayList2, new a());
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(((Map.Entry) it.next()).getKey());
            }
        }
        return arrayList;
    }

    private Bundle c() {
        PackageManager packageManager = this.f14643a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(this.f14643a, (Class<?>) ServiceDiscovery.class), 128);
            if (serviceInfo != null) {
                return serviceInfo.metaData;
            }
            Log.e("AGC_Registrar", "Can not found ServiceDiscovery service.");
            return null;
        } catch (PackageManager.NameNotFoundException e9) {
            Log.e("AGC_Registrar", "get ServiceDiscovery exception." + e9.getLocalizedMessage());
        }
    }

    public List<Service> a() {
        Log.i("AGC_Registrar", "getServices");
        List<String> listB = b();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = listB.iterator();
        while (it.hasNext()) {
            ServiceRegistrar serviceRegistrarA = a(it.next());
            if (serviceRegistrarA != null) {
                serviceRegistrarA.initialize(this.f14643a);
                List<Service> services = serviceRegistrarA.getServices(this.f14643a);
                if (services != null) {
                    arrayList.addAll(services);
                }
            }
        }
        Log.i("AGC_Registrar", "services:" + arrayList.size());
        return arrayList;
    }
}
