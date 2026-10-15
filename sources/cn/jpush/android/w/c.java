package cn.jpush.android.w;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11727b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f11730e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f11732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11733h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private X509TrustManager f11736l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private HostnameVerifier f11737m;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11734i = true;
    private boolean j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11735k = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11728c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11729d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f11731f = new HashMap();

    public c(String str) {
        this.f11726a = str;
    }

    public String a() {
        return this.f11726a;
    }

    public int b() {
        return this.f11728c;
    }

    public int c() {
        return this.f11729d;
    }

    public boolean d() {
        return this.f11733h;
    }

    public boolean e() {
        return this.f11735k;
    }

    public X509TrustManager f() {
        return this.f11736l;
    }

    public HostnameVerifier g() {
        return this.f11737m;
    }

    public byte[] h() {
        Object obj = this.f11732g;
        if (obj != null) {
            if (obj instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) obj)) {
                    return ((String) this.f11732g).getBytes();
                }
            } else if (obj instanceof byte[]) {
                return (byte[]) obj;
            }
        }
        String strA = e.a(this.f11730e);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return strA.getBytes();
    }

    public Map<String, String> i() {
        return this.f11731f;
    }

    public boolean j() {
        return this.f11734i;
    }

    public boolean k() {
        return this.j;
    }

    public String l() {
        return this.f11727b;
    }

    public void a(Object obj) {
        this.f11732g = obj;
    }

    public void a(String str) {
        this.f11727b = str;
    }

    public void a(String str, String str2) {
        this.f11731f.put(str, str2);
    }
}
