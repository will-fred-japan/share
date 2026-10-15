package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class cd extends cf {
    public cd(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static cd a(Context context, String str, int i9) {
        com.xiaomi.channel.commonutils.logger.c.b("delete  messages when db size is too bigger");
        String strM156a = cj.a(context).m156a(str);
        if (TextUtils.isEmpty(strM156a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder("rowDataId in (select ");
        sb.append("rowDataId from " + strM156a);
        sb.append(" order by createTimeStamp asc limit ?)");
        return new cd(str, sb.toString(), new String[]{String.valueOf(i9)}, "a job build to delete history message");
    }

    private void a(long j) {
        String[] strArr = ((cj.d) this).f186a;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        strArr[0] = String.valueOf(j);
    }

    @Override // com.xiaomi.push.cj.a
    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long jLongValue = ((Long) obj).longValue();
            long jA = cn.a(m158a());
            long j = cb.f168a;
            if (jA > j) {
                long j8 = (long) ((((jA - j) * 1.2d) / j) * jLongValue);
                a(j8);
                ca caVarA = ca.a(context);
                StringBuilder sbH = defpackage.f.h(j8, "begin delete ", "noUpload messages , because db size is ");
                sbH.append(jA);
                sbH.append("B");
                caVarA.a(sbH.toString());
                super.a(context, obj);
                return;
            }
            com.xiaomi.channel.commonutils.logger.c.b("db size is suitable");
        }
    }
}
