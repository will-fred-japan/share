package cn.jiguang.commons.a;

import com.engagelab.privates.common.constants.MTCommonConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f10427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f10428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f10429i;
    public long j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f10430k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String[] f10431l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String[] f10432m;

    private static CharSequence a(CharSequence charSequence, int i9) {
        return (i9 < 0 || i9 >= charSequence.length()) ? charSequence : charSequence.subSequence(0, i9);
    }

    public final JSONObject b(int i9) {
        try {
            return new JSONObject().put("pkg", a(this.f10422b, 128)).put("install_time", this.j).put("update_time", this.f10430k).put("sign_md5", this.f10427g).put("sign_sha1", this.f10428h).put("sign_sha256", this.f10429i);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final JSONObject c(int i9) {
        try {
            return new JSONObject().put(MTCommonConstants.Network.KEY_NAME, this.f10421a).put("pkg", a(this.f10422b, 128)).put("ver_name", this.f10423c).put("ver_code", this.f10424d).put("pers", Arrays.toString(this.f10431l));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final JSONObject d(int i9) {
        try {
            return new JSONObject().put(MTCommonConstants.Network.KEY_NAME, this.f10421a).put("pkg", a(this.f10422b, 128)).put("ver_name", this.f10423c).put("ver_code", this.f10424d).put(HiAnalyticsConstant.BI_KEY_INSTALL_TYPE, this.f10425e).put("install_time", this.j).put("update_time", this.f10430k);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final JSONObject e(int i9) {
        try {
            return new JSONObject().put("pkg", a(this.f10422b, 128)).put("ver_name", this.f10423c).put("third_sdk", this.f10426f);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && w.class == obj.getClass()) {
            w wVar = (w) obj;
            if (this.f10424d != wVar.f10424d) {
                return false;
            }
            String str = this.f10422b;
            String str2 = wVar.f10422b;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return "JAppInfo{appName='" + this.f10421a + "', packageName='" + this.f10422b + "', versionName='" + this.f10423c + "', versionCode=" + this.f10424d + ", installType=" + this.f10425e + ", thirdSdkType=" + this.f10426f + ", signMd5='" + this.f10427g + "', signSha1='" + this.f10428h + "', signSha256='" + this.f10429i + "', firstInstallTime=" + this.j + ", lastUpdateTime=" + this.f10430k + ", requestedPermissions=" + Arrays.toString(this.f10431l) + '}';
    }

    public final JSONObject a(int i9) {
        try {
            return new JSONObject().put("n", this.f10421a).put("p", a(this.f10422b, 128)).put("vn", this.f10423c).put("c", this.f10424d).put("t", this.f10425e).put("it", this.j).put("ut", this.f10430k).put("sm", this.f10427g).put("ss", this.f10428h).put("sa", this.f10429i);
        } catch (JSONException unused) {
            return null;
        }
    }
}
