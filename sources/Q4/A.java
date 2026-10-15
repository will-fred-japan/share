package Q4;

import S4.C0375f;
import com.google.android.gms.common.Feature;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0345a f3747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Feature f3748b;

    public /* synthetic */ A(C0345a c0345a, Feature feature) {
        this.f3747a = c0345a;
        this.f3748b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof A)) {
            A a3 = (A) obj;
            if (C0375f.a(this.f3747a, a3.f3747a) && C0375f.a(this.f3748b, a3.f3748b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3747a, this.f3748b});
    }

    public final String toString() {
        C0375f.a aVar = new C0375f.a(this);
        aVar.a(this.f3747a, "key");
        aVar.a(this.f3748b, "feature");
        return aVar.toString();
    }
}
