package D0;

import K7.l;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: SpecificationComputer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g<T> extends A0.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f1828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f1830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f1831e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g(Object value, h verificationMode, a aVar) {
        super(2);
        k.e(value, "value");
        k.e(verificationMode, "verificationMode");
        this.f1828b = value;
        this.f1829c = "a";
        this.f1830d = verificationMode;
        this.f1831e = aVar;
    }

    @Override // A0.h
    public final T d() {
        return this.f1828b;
    }

    @Override // A0.h
    public final A0.h u(String str, l<? super T, Boolean> condition) {
        k.e(condition, "condition");
        T t = this.f1828b;
        return condition.invoke(t).booleanValue() ? this : new f(t, this.f1829c, str, this.f1831e, this.f1830d);
    }
}
