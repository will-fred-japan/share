package Z;

import com.alibaba.fastjson.asm.Opcodes;
import java.io.FileInputStream;

/* JADX INFO: compiled from: FileStorage.kt */
/* JADX INFO: loaded from: classes.dex */
@D7.e(c = "androidx.datastore.core.FileReadScope", f = "FileStorage.kt", l = {Opcodes.RET, Opcodes.GETSTATIC}, m = "readData$suspendImpl")
public final class H<T> extends D7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f5298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FileInputStream f5299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f5300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ I<T> f5301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5302e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(I i9, D7.c cVar) {
        super(cVar);
        this.f5301d = i9;
    }

    @Override // D7.a
    public final Object invokeSuspend(Object obj) {
        this.f5300c = obj;
        this.f5302e |= Integer.MIN_VALUE;
        return I.f(this.f5301d, this);
    }
}
