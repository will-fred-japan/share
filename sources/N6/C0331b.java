package N6;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

/* JADX INFO: renamed from: N6.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0331b implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ K7.l f3310b;

    public /* synthetic */ C0331b(K7.l lVar, int i9) {
        this.f3309a = i9;
        this.f3310b = lVar;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f3309a) {
            case 0:
                break;
        }
        return (AtomicLong) ((C0330a) this.f3310b).invoke(obj);
    }
}
