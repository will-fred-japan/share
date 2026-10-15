package Q;

import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;

/* JADX INFO: compiled from: FontRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<List<byte[]>> f3659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3662g;

    public f() {
        throw null;
    }

    public f(String str, String str2, String str3, List<List<byte[]>> list, String str4, String str5) {
        str.getClass();
        this.f3656a = str;
        str2.getClass();
        this.f3657b = str2;
        this.f3658c = str3;
        list.getClass();
        this.f3659d = list;
        this.f3660e = str4;
        this.f3661f = str5;
        this.f3662g = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str4 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str5;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f3656a + ", mProviderPackage: " + this.f3657b + ", mQuery: " + this.f3658c + ", mSystemFont: " + this.f3660e + ", mVariationSettings: " + this.f3661f + ", mCertificates:");
        int i9 = 0;
        while (true) {
            List<List<byte[]>> list = this.f3659d;
            if (i9 >= list.size()) {
                sb.append("}mCertificatesArray: 0");
                return sb.toString();
            }
            sb.append(" [");
            List<byte[]> list2 = list.get(i9);
            for (int i10 = 0; i10 < list2.size(); i10++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list2.get(i10), 0));
                sb.append("\"");
            }
            sb.append(" ]");
            i9++;
        }
    }
}
