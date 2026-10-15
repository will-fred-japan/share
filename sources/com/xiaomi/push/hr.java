package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class hr {
    public static void a(Context context, ht htVar, List<hy> list) {
        HashMap<String, ArrayList<hy>> mapA = a(context, list);
        if (mapA != null && mapA.size() != 0) {
            a(context, htVar, mapA);
            return;
        }
        com.xiaomi.channel.commonutils.logger.c.m9a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
    }

    private static HashMap<String, ArrayList<hy>> a(Context context, List<hy> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<hy>> map = new HashMap<>();
        for (hy hyVar : list) {
            a(context, hyVar);
            ArrayList<hy> arrayList = map.get(hyVar.c());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                map.put(hyVar.c(), arrayList);
            }
            arrayList.add(hyVar);
        }
        return map;
    }

    private static void a(Context context, hy hyVar) {
        if (hyVar.f586a) {
            hyVar.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(hyVar.d())) {
            hyVar.f(com.xiaomi.push.service.bl.a());
        }
        hyVar.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(hyVar.e())) {
            hyVar.e(context.getPackageName());
        }
        if (TextUtils.isEmpty(hyVar.c())) {
            hyVar.e(hyVar.e());
        }
    }

    private static void a(Context context, ht htVar, HashMap<String, ArrayList<hy>> map) {
        for (Map.Entry<String, ArrayList<hy>> entry : map.entrySet()) {
            try {
                ArrayList<hy> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    htVar.a(value, value.get(0).e(), entry.getKey());
                }
            } catch (Exception unused) {
            }
        }
    }
}
