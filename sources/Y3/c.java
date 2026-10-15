package Y3;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;

/* JADX INFO: compiled from: InitConfig.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T1.d.a f5244d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f5246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5249i;
    public String j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HashMap f5250k;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5245e = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f5251l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5252m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5253n = false;

    public c(String str, String str2, String str3) {
        this.f5241a = str;
        this.f5243c = str3;
        if (TextUtils.isEmpty(str3)) {
            Log.e("InitConfig", "channel is empty, please check!!!");
        }
        this.f5242b = str2;
        if (TextUtils.isEmpty(str2)) {
            Log.e("InitConfig", "token is empty, please check!!!");
        }
    }
}
