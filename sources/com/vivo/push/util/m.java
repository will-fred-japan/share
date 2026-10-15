package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* JADX INFO: compiled from: DefaultNotifyDataAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class m implements BaseNotifyDataAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f16878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f16879f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Resources f16880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f16883d;

    private static boolean a(int i9) {
        return (i9 == -1 || i9 == 0) ? false : true;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        int iA;
        if (a(f16878e)) {
            return f16878e;
        }
        String str = this.f16883d;
        if (a(str)) {
            iA = a(str, "_notifyicon");
        } else {
            w.d("DefaultNotifyDataAdapter", "getNotifyIconByArdVersion isSystemCodeUsable is false ");
            iA = -1;
        }
        f16878e = iA;
        if (a(iA)) {
            return f16878e;
        }
        String strH = this.f16882c;
        while (true) {
            w.d("DefaultNotifyDataAdapter", "getNotifyIconByRomVersion codeReg = ".concat(String.valueOf(strH)));
            if (TextUtils.isEmpty(strH)) {
                return this.f16880a.getIdentifier("vivo_push_notifyicon", "drawable", this.f16881b);
            }
            int identifier = this.f16880a.getIdentifier(A.a.i("vivo_push_rom", strH, "_notifyicon"), "drawable", this.f16881b);
            if (identifier > 0) {
                w.d("DefaultNotifyDataAdapter", "getNotifyIconByRomVersion find notifyicon = vivo_push_rom" + strH + "_notifyicon");
                return identifier;
            }
            strH = A.a.h(1, 0, strH);
        }
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        int iA;
        if (a(f16879f)) {
            return f16879f;
        }
        String str = this.f16883d;
        if (a(str)) {
            iA = a(str, "_icon");
        } else {
            w.d("DefaultNotifyDataAdapter", "getSmallIconByArdVersion isSystemCodeUsable is false ");
            iA = -1;
        }
        f16879f = iA;
        if (a(iA)) {
            return f16879f;
        }
        String strH = this.f16882c;
        while (true) {
            w.d("DefaultNotifyDataAdapter", "getSmallIconByRomVersion codeReg = ".concat(String.valueOf(strH)));
            if (TextUtils.isEmpty(strH)) {
                return this.f16880a.getIdentifier("vivo_push_icon", "drawable", this.f16881b);
            }
            int identifier = this.f16880a.getIdentifier(A.a.i("vivo_push_rom", strH, "_icon"), "drawable", this.f16881b);
            if (identifier > 0) {
                w.d("DefaultNotifyDataAdapter", "getSmallIconByRomVersion find smallIcon = vivo_push_rom" + strH + "_icon");
                return identifier;
            }
            strH = A.a.h(1, 0, strH);
        }
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return 2;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        this.f16881b = context.getPackageName();
        this.f16880a = context.getResources();
        this.f16882c = o.a();
        this.f16883d = Build.VERSION.RELEASE;
    }

    private static boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        w.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
        return false;
    }

    private int a(String str, String str2) {
        w.d("DefaultNotifyDataAdapter", "getIcon systemVersion = " + str + " suffix= " + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit != null && strArrSplit.length > 0) {
                str = strArrSplit[0];
            }
            try {
                for (int i9 = Integer.parseInt(str); i9 > 0; i9--) {
                    String str3 = "vivo_push_ard" + i9 + str2;
                    w.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(str3)));
                    int identifier = this.f16880a.getIdentifier(str3, "drawable", this.f16881b);
                    if (identifier > 0) {
                        w.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str3)));
                        return identifier;
                    }
                }
            } catch (Exception e9) {
                w.a("DefaultNotifyDataAdapter", e9);
            }
        }
        return -1;
    }
}
