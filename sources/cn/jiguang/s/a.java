package cn.jiguang.s;

import com.engagelab.privates.common.constants.MTCommonConstants;
import com.heytap.msp.push.callback.INotificationPermissionCallback;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10747a = new a(1000, "load_p");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f10748b = new a(1001, "p_read_conf");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f10749c = new a(1002, "p_file_check");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f10750d = new a(MTCommonConstants.MainWhat.ON_NETWORK_CONNECTED, "p_file_desc");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f10751e = new a(1004, "load_cl");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10752f = new a(2000, "update_p");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f10753g = new a(2001, "get_conf");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f10754h = new a(2002, "down_p");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f10755i = new a(2003, "down_p_check");
    public static final a j = new a(INotificationPermissionCallback.CODE_FREQUENT, "save_conf");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10756k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f10757l;

    public a(int i9, String str) {
        this.f10756k = i9;
        this.f10757l = str;
    }
}
