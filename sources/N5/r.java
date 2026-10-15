package N5;

import U5.y;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: compiled from: WrappedAead.java */
/* JADX INFO: loaded from: classes.dex */
public final class r implements L5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f3251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y<q> f3252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final U5.l.a f3253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final U5.l.a f3254d;

    public r(q qVar, y yVar, U5.l.a aVar, U5.l.a aVar2) {
        this.f3251a = qVar;
        this.f3252b = yVar;
        this.f3253c = aVar;
        this.f3254d = aVar2;
    }

    @Override // L5.a
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        U5.l.a aVar = this.f3253c;
        try {
            byte[] bArrA = this.f3251a.f3250a.a(bArr, bArr2);
            int length = bArr.length;
            aVar.getClass();
            return bArrA;
        } catch (GeneralSecurityException e9) {
            aVar.getClass();
            throw e9;
        }
    }

    @Override // L5.a
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Iterator<q> it = this.f3252b.a(bArr).iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            U5.l.a aVar = this.f3254d;
            if (!zHasNext) {
                aVar.getClass();
                throw new GeneralSecurityException("decryption failed");
            }
            try {
                byte[] bArrB = it.next().f3250a.b(bArr, bArr2);
                aVar.getClass();
                return bArrB;
            } catch (GeneralSecurityException unused) {
            }
        }
    }
}
