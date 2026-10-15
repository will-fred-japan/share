package S4;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f4123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0370a f4125c;

    public F(AbstractC0370a abstractC0370a) {
        Boolean bool = Boolean.TRUE;
        this.f4125c = abstractC0370a;
        this.f4123a = bool;
        this.f4124b = false;
    }

    public abstract void a();

    public final void b() {
        synchronized (this) {
            this.f4123a = null;
        }
        synchronized (this.f4125c.f4161k) {
            this.f4125c.f4161k.remove(this);
        }
    }
}
