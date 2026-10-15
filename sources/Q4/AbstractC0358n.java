package Q4;

import S4.C0376g;
import com.google.android.gms.common.Feature;

/* JADX INFO: renamed from: Q4.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0358n<A, ResultT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Feature[] f3834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3836c;

    /* JADX INFO: renamed from: Q4.n$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
    public static class a<A, ResultT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InterfaceC0357m f3837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Feature[] f3839c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3840d;

        public final P a() {
            C0376g.a("execute parameter required", this.f3837a != null);
            return new P(this, this.f3839c, this.f3838b, this.f3840d);
        }
    }

    public AbstractC0358n(Feature[] featureArr, boolean z8, int i9) {
        this.f3834a = featureArr;
        boolean z9 = false;
        if (featureArr != null && z8) {
            z9 = true;
        }
        this.f3835b = z9;
        this.f3836c = i9;
    }
}
