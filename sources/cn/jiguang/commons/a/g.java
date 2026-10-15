package cn.jiguang.commons.a;

import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class g extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final boolean f10085e = new File("/dev/cpuctl/tasks").exists();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f10086f = Pattern.compile("^([A-Za-z]{1}[A-Za-z0-9_]*[\\.|:])*[A-Za-z][A-Za-z0-9_]*$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10088b;

    public g(int i9) throws h {
        int iA;
        boolean z8;
        super(i9);
        String str = this.f10178c;
        if (str != null && f10086f.matcher(str).matches()) {
            if (new File("/data/data", this.f10178c.split(Constants.COLON_SEPARATOR)[0]).exists()) {
                if (f10085e) {
                    n nVarA = n.a(this.f10179d);
                    p pVarA = nVarA.a("cpuacct");
                    p pVarA2 = nVarA.a("cpu");
                    if (pVarA2 == null || pVarA == null || !pVarA.f10397c.contains("pid_")) {
                        throw new h(i9);
                    }
                    z8 = !pVarA2.f10397c.contains("bg_non_interactive");
                    try {
                        iA = Integer.parseInt(pVarA.f10397c.split("/")[1].replace("uid_", ""));
                    } catch (Throwable unused) {
                        iA = am.a(this.f10179d).a();
                    }
                } else {
                    ak akVarA = ak.a(this.f10179d);
                    am amVarA = am.a(this.f10179d);
                    boolean z9 = akVarA.m() == 0;
                    iA = amVarA.a();
                    z8 = z9;
                }
                this.f10087a = z8;
                this.f10088b = iA;
                return;
            }
        }
        throw new h(i9);
    }
}
