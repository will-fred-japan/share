package com.hihonor.push.sdk;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14491b;

    public g0(String str) {
        String strA = a(str);
        this.f14490a = strA;
        this.f14491b = a(strA);
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static g0 b(String str) {
        return new g0(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g0.class != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.f14490a, ((g0) obj).f14490a);
    }

    public final int hashCode() {
        return this.f14491b;
    }

    public final String a(String str) {
        str.getClass();
        switch (str) {
            case "up_msg_turn_on_push":
            case "up_msg_query_push_status":
            case "up_msg_request_push_token":
            case "up_msg_turn_off_push":
            case "up_msg_unregister_push_token":
                return "push_type_default";
            default:
                return str;
        }
    }
}
