package cn.jiguang.ae;

/* JADX INFO: loaded from: classes.dex */
public class f extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9023a;

    public f(int i9, String str) {
        super(str);
        this.f9023a = i9;
    }

    public int a() {
        return this.f9023a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "JException(" + this.f9023a + "):" + getLocalizedMessage();
    }
}
