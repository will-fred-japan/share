package p111o6;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.j;
import p096m7.k;
import p096m7.l;
import p120p6.b;

/* JADX INFO: compiled from: MethodCallHandlerImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements b, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f20715a;

    public a(k kVar) {
        this.f20715a = kVar;
    }

    @Override // kotlin.jvm.internal.g
    public final j a() {
        return new j(1, this.f20715a, l.d.class, "success", "success(Ljava/lang/Object;)V", 0);
    }

    public final void b(boolean z8) {
        this.f20715a.success(Boolean.valueOf(z8));
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof b) && (obj instanceof g)) {
            return a().equals(((g) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }
}
