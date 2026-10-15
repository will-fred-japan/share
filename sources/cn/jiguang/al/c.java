package cn.jiguang.al;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient Thread f9248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f9250c;

    public c() {
        this(null);
    }

    public String a() {
        return this.f9249b;
    }

    public Boolean b() {
        return this.f9250c;
    }

    public c(Thread thread) {
        this.f9248a = thread;
    }

    public void a(Boolean bool) {
        this.f9250c = bool;
    }

    public void a(String str) {
        this.f9249b = str;
    }
}
