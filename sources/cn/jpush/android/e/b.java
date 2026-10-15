package cn.jpush.android.e;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11374c;

    public b(int i9, String str, String str2) {
        this.f11372a = i9;
        this.f11373b = str;
        this.f11374c = str2;
    }

    public int a() {
        return this.f11372a;
    }

    public String b() {
        return this.f11373b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TokenResult{code=");
        sb.append(this.f11372a);
        sb.append(", token='");
        sb.append(this.f11373b);
        sb.append("', msg='");
        return A.a.j(sb, this.f11374c, "'}");
    }
}
