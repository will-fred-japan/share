package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.hx;
import com.xiaomi.push.hy;
import com.xiaomi.push.ie;
import com.xiaomi.push.it;
import com.xiaomi.push.je;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f18343a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static SimpleDateFormat f1091a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static AtomicLong f1092a = new AtomicLong(0);

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f1091a = simpleDateFormat;
        f18343a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static synchronized String a() {
        String str;
        try {
            str = f1091a.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(f18343a, str)) {
                f1092a.set(0L);
                f18343a = str;
            }
        } catch (Throwable th) {
            throw th;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f1092a.incrementAndGet();
    }

    public static ArrayList<it> a(List<hy> list, String str, String str2, int i9) {
        int length;
        if (list == null) {
            com.xiaomi.channel.commonutils.logger.c.d("requests can not be null in TinyDataHelper.transToThriftObj().");
            return null;
        }
        if (list.size() == 0) {
            com.xiaomi.channel.commonutils.logger.c.d("requests.length is 0 in TinyDataHelper.transToThriftObj().");
            return null;
        }
        ArrayList<it> arrayList = new ArrayList<>();
        hx hxVar = new hx();
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            hy hyVar = list.get(i11);
            if (hyVar != null) {
                if (hyVar.m487a() == null || !hyVar.m487a().containsKey("item_size")) {
                    length = 0;
                } else {
                    String str3 = hyVar.m487a().get("item_size");
                    if (TextUtils.isEmpty(str3)) {
                        length = 0;
                    } else {
                        try {
                            length = Integer.parseInt(str3);
                        } catch (Exception unused) {
                            length = 0;
                        }
                    }
                    if (hyVar.m487a().size() != 1) {
                        hyVar.m487a().remove("item_size");
                    } else {
                        hyVar.a((Map<String, String>) null);
                    }
                }
                if (length <= 0) {
                    length = je.a(hyVar).length;
                }
                if (length > i9) {
                    com.xiaomi.channel.commonutils.logger.c.d("TinyData is too big, ignore upload request item:" + hyVar.d());
                } else {
                    if (i10 + length > i9) {
                        arrayList.add(a(str, str2, hxVar));
                        hxVar = new hx();
                        i10 = 0;
                    }
                    hxVar.a(hyVar);
                    i10 += length;
                }
            }
        }
        if (hxVar.a() != 0) {
            arrayList.add(a(str, str2, hxVar));
        }
        return arrayList;
    }

    private static it a(String str, String str2, hx hxVar) {
        return new it("-1", false).d(str).b(str2).a(com.xiaomi.push.y.a(je.a(hxVar))).c(ie.UploadTinyData.f611a);
    }

    public static boolean a(hy hyVar, boolean z8) {
        if (hyVar == null) {
            com.xiaomi.channel.commonutils.logger.c.m9a("item is null, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!z8 && TextUtils.isEmpty(hyVar.f583a)) {
            com.xiaomi.channel.commonutils.logger.c.m9a("item.channel is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(hyVar.f590d)) {
            com.xiaomi.channel.commonutils.logger.c.m9a("item.category is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(hyVar.f589c)) {
            com.xiaomi.channel.commonutils.logger.c.m9a("item.name is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!com.xiaomi.push.bm.m127a(hyVar.f590d)) {
            com.xiaomi.channel.commonutils.logger.c.m9a("item.category can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!com.xiaomi.push.bm.m127a(hyVar.f589c)) {
            com.xiaomi.channel.commonutils.logger.c.m9a("item.name can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        String str = hyVar.f588b;
        if (str == null || str.length() <= 30720) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.c.m9a("item.data is too large(" + hyVar.f588b.length() + "), max size for data is 30720 , verfiy ClientUploadDataItem failed.");
        return true;
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        hy hyVar = new hy();
        hyVar.d(str);
        hyVar.c(str2);
        hyVar.a(j);
        hyVar.b(str3);
        hyVar.a("push_sdk_channel");
        hyVar.g(context.getPackageName());
        hyVar.e(context.getPackageName());
        hyVar.a(true);
        hyVar.b(System.currentTimeMillis());
        hyVar.f(a());
        bm.a(context, hyVar);
    }

    public static boolean a(String str) {
        return !com.xiaomi.push.t.m840b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}
