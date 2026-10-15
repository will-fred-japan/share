package com.vivo.push;

import android.net.Uri;
import com.heytap.msp.push.callback.INotificationPermissionCallback;

/* JADX INFO: compiled from: PushConstants.java */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f16910a = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f16911b = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Uri f16912c = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Uri f16913d = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Uri f16914e = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/agreePrivacyStatement");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Uri f16915f = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/queryAppState");

    public static String a(int i9) {
        switch (i9) {
            case 2002:
                return "method_alias_bind";
            case 2003:
                return "method_alias_unbind";
            case INotificationPermissionCallback.CODE_FREQUENT /* 2004 */:
                return "method_tag_bind";
            case INotificationPermissionCallback.CODE_UNSUPPORT /* 2005 */:
                return "method_tag_unbind";
            case 2006:
                return "method_sdk_bind";
            case 2007:
                return "method_sdk_unbind";
            case 2008:
                return "method_stop";
            default:
                return null;
        }
    }
}
