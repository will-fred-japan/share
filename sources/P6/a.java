package P6;

import A0.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BatchOperation.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f3632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0040a f3633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3634d;

    /* JADX INFO: renamed from: P6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BatchOperation.java */
    public class C0040a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Serializable f3635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f3637c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public HashMap f3638d;

        @Override // P6.c
        public final void a(Serializable serializable) {
            this.f3635a = serializable;
        }

        @Override // P6.c
        public final void c(String str, HashMap map) {
            this.f3636b = "sqlite_error";
            this.f3637c = str;
            this.f3638d = map;
        }
    }

    public a(Map<String, Object> map, boolean z8) {
        super(5);
        this.f3633c = new C0040a();
        this.f3632b = map;
        this.f3634d = z8;
    }

    @Override // A0.h
    public final <T> T f(String str) {
        return (T) this.f3632b.get(str);
    }

    @Override // A0.h
    public final String h() {
        return (String) this.f3632b.get("method");
    }

    @Override // A0.h
    public final boolean i() {
        return this.f3634d;
    }

    @Override // A0.h
    public final c l() {
        return this.f3633c;
    }

    @Override // A0.h
    public final boolean p() {
        return this.f3632b.containsKey("transactionId");
    }

    public final void w(ArrayList arrayList) {
        if (this.f3634d) {
            return;
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        C0040a c0040a = this.f3633c;
        map2.put("code", c0040a.f3636b);
        map2.put("message", c0040a.f3637c);
        map2.put("data", c0040a.f3638d);
        map.put("error", map2);
        arrayList.add(map);
    }

    public final void x(ArrayList arrayList) {
        if (this.f3634d) {
            return;
        }
        HashMap map = new HashMap();
        map.put("result", this.f3633c.f3635a);
        arrayList.add(map);
    }
}
