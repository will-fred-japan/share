package Z;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: FileStorage.kt */
/* JADX INFO: loaded from: classes.dex */
public class I<T> implements W<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f5303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p015c0.d f5304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f5305c;

    public I(File file, p015c0.d serializer) {
        kotlin.jvm.internal.k.e(serializer, "serializer");
        this.f5303a = file;
        this.f5304b = serializer;
        this.f5305c = new AtomicBoolean(false);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [Z.I] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r8v0, types: [Z.I, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [Z.I] */
    public static Object f(I i9, D7.c cVar) throws IOException {
        H h9;
        Throwable th;
        Closeable closeable;
        FileInputStream fileInputStream;
        Throwable th2;
        if (cVar instanceof H) {
            h9 = (H) cVar;
            int i10 = h9.f5302e;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                h9.f5302e = i10 - Integer.MIN_VALUE;
            } else {
                h9 = new H(i9, cVar);
            }
        } else {
            h9 = new H(i9, cVar);
        }
        Object obj = h9.f5300c;
        C7.a aVar = C7.a.f1806a;
        ?? r8 = h9.f5302e;
        boolean z8 = true;
        ?? r9 = 1;
        try {
            if (r8 != 0) {
                if (r8 == 1) {
                    fileInputStream = h9.f5299b;
                    r8 = (I) h9.f5298a;
                    try {
                        p188x7.g.b(obj);
                        p199z2.b.r(fileInputStream, null);
                        return obj;
                    } catch (Throwable th3) {
                        th2 = th3;
                        try {
                            throw th2;
                        } catch (Throwable th4) {
                            p199z2.b.r(fileInputStream, th2);
                            throw th4;
                        }
                    }
                }
                if (r8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) h9.f5298a;
                try {
                    p188x7.g.b(obj);
                    p199z2.b.r(closeable, null);
                    return obj;
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        throw th;
                    } catch (Throwable th6) {
                        p199z2.b.r(closeable, th);
                        throw th6;
                    }
                }
            }
            p188x7.g.b(obj);
            if (i9.f5305c.get()) {
                throw new IllegalStateException("This scope has already been closed.");
            }
            try {
                FileInputStream fileInputStream2 = new FileInputStream(i9.f5303a);
                try {
                    p015c0.d dVar = i9.f5304b;
                    h9.f5298a = i9;
                    h9.f5299b = fileInputStream2;
                    h9.f5302e = 1;
                    p015c0.a aVarA = dVar.a(fileInputStream2);
                    if (aVarA != aVar) {
                        fileInputStream = fileInputStream2;
                        obj = aVarA;
                        p199z2.b.r(fileInputStream, null);
                        return obj;
                    }
                    return aVar;
                } catch (Throwable th7) {
                    r8 = i9;
                    fileInputStream = fileInputStream2;
                    th2 = th7;
                    throw th2;
                }
            } catch (FileNotFoundException unused) {
                boolean zExists = i9.f5303a.exists();
                p015c0.d dVar2 = i9.f5304b;
                if (!zExists) {
                    dVar2.getClass();
                    return new p015c0.a(z8, (int) (r9 == true ? 1 : 0));
                }
                FileInputStream fileInputStream3 = new FileInputStream(i9.f5303a);
                try {
                    h9.f5298a = fileInputStream3;
                    h9.f5299b = null;
                    h9.f5302e = 2;
                    p015c0.a aVarA2 = dVar2.a(fileInputStream3);
                    if (aVarA2 != aVar) {
                        obj = aVarA2;
                        closeable = fileInputStream3;
                        p199z2.b.r(closeable, null);
                        return obj;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    closeable = fileInputStream3;
                    throw th;
                }
            }
        } catch (FileNotFoundException unused2) {
            i9 = r8;
        }
    }

    @Override // Z.W
    public final Object b(h0 h0Var) {
        return f(this, h0Var);
    }

    @Override // Z.InterfaceC0449a
    public final void close() {
        this.f5305c.set(true);
    }
}
