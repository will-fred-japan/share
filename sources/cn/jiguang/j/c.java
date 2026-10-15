package cn.jiguang.j;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.e.d;
import cn.jiguang.e.f;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static c f10577d = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10580c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f10581a = new c();
    }

    private c() {
    }

    public static c a() {
        return a.f10581a;
    }

    public String b(Context context) {
        if (!TextUtils.isEmpty(this.f10579b)) {
            return this.f10579b;
        }
        String str = (String) f.a(context, d.aU());
        this.f10579b = str;
        if (!TextUtils.isEmpty(str)) {
            return this.f10579b;
        }
        this.f10579b = cn.jiguang.g.b.r();
        f.a(context, (d<?>[]) new d[]{d.aU().a(this.f10579b)});
        return this.f10579b;
    }

    public String c(Context context) {
        if (!TextUtils.isEmpty(this.f10580c)) {
            return this.f10580c;
        }
        String str = (String) f.a(context, d.aV());
        this.f10580c = str;
        if (!TextUtils.isEmpty(str)) {
            return this.f10580c;
        }
        this.f10580c = cn.jiguang.g.b.u();
        f.a(context, (d<?>[]) new d[]{d.aV().a(this.f10580c)});
        return this.f10580c;
    }

    public String a(Context context) {
        if (!TextUtils.isEmpty(this.f10578a)) {
            return this.f10578a;
        }
        String str = (String) f.a(context, d.aT());
        this.f10578a = str;
        if (!TextUtils.isEmpty(str)) {
            return this.f10578a;
        }
        this.f10578a = cn.jiguang.g.b.c();
        f.a(context, (d<?>[]) new d[]{d.aT().a(this.f10578a)});
        return this.f10578a;
    }
}
