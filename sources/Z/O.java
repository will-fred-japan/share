package Z;

import java.io.FileOutputStream;

/* JADX INFO: compiled from: FileStorage.kt */
/* JADX INFO: loaded from: classes.dex */
@D7.e(c = "androidx.datastore.core.FileWriteScope", f = "FileStorage.kt", l = {201}, m = "writeData")
public final class O extends D7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FileOutputStream f5331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FileOutputStream f5332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f5333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ P<Object> f5334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5335e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O(P p8, D7.c cVar) {
        super(cVar);
        this.f5334d = p8;
    }

    @Override // D7.a
    public final Object invokeSuspend(Object obj) {
        this.f5333c = obj;
        this.f5335e |= Integer.MIN_VALUE;
        return this.f5334d.c(null, this);
    }
}
