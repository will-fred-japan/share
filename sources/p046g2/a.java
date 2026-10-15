package p046g2;

import h2.c.a;
import java.util.Map;
import org.json.JSONObject;
import p054h2.b;
import p054h2.c;
import p054h2.d;
import p061i1.h;

/* JADX INFO: compiled from: BizTrafficStats.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f18846a;

    /* JADX INFO: renamed from: g2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BizTrafficStats.java */
    public static final class C0201a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18847a = new a();
    }

    public a() {
        if (!h.h()) {
            this.f18846a = new d();
            return;
        }
        c cVar = new c();
        cVar.f19014i = 0L;
        cVar.f19015k = 102400.0d;
        cVar.f19016l = cVar.new a();
        this.f18846a = cVar;
    }

    @Override // p054h2.b
    public final void a() {
        this.f18846a.a();
    }

    @Override // p054h2.b
    public final void b(String str) {
        this.f18846a.b(str);
    }

    @Override // p054h2.b
    public final void c(double d9) {
        this.f18846a.c(d9);
    }

    @Override // p054h2.b
    public final void clear() {
        this.f18846a.clear();
    }

    @Override // p054h2.b
    public final void d(long j, String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2) {
        if (h.f19230b) {
            p010b3.b.d("APM-Traffic-Detail", "BizTrafficStats.trafficStats " + j + ", " + str + ", " + str2);
        }
        this.f18846a.d(j, str, str2, str3, jSONObject, jSONObject2);
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> e() {
        return this.f18846a.e();
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> f() {
        return this.f18846a.f();
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> g() {
        return this.f18846a.g();
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> h() {
        return this.f18846a.h();
    }

    @Override // p054h2.b
    @Deprecated
    public final void a(JSONObject jSONObject) {
        this.f18846a.a(jSONObject);
    }

    @Override // p054h2.b
    public final long b() {
        return this.f18846a.b();
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> c(String str) {
        return this.f18846a.c(str);
    }

    @Override // p054h2.b
    public final void e(double d9) {
        this.f18846a.e(d9);
    }

    @Override // p054h2.b
    public final void b(String str, JSONObject jSONObject) {
        this.f18846a.b(str, jSONObject);
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> c() {
        return this.f18846a.c();
    }

    @Override // p054h2.b
    public final void d(String str) {
        this.f18846a.d(str);
    }

    @Override // p054h2.b
    public final Map<String, p054h2.a> d() {
        return this.f18846a.d();
    }
}
