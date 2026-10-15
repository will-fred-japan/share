package cn.jiguang.commons.a;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class dk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Uri f9888b;

    public dk(Context context) {
        this.f9887a = context;
        String strB = km.b("k97muQEI3n3mlJTZdD9q3lC6tvCVkeY7wPOrf0wd0l4zQtrGyn5uq0enBKOySISr", f.f10031c);
        ee.a("NubiaOpenIDHelper", "url: " + strB);
        this.f9888b = Uri.parse(strB);
    }

    public final String a() {
        try {
            return dj.a(this.f9887a, this.f9888b);
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("get Ids-oa error: "), "NubiaOpenIDHelper");
            return "";
        }
    }
}
