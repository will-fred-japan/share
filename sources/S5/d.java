package S5;

import U5.l;
import U5.y;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: compiled from: WrappedDeterministicAead.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements L5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y<c> f4219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l.a f4220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l.a f4221d;

    public d(c cVar, y<c> yVar, l.a aVar, l.a aVar2) {
        this.f4218a = cVar;
        this.f4219b = yVar;
        this.f4220c = aVar;
        this.f4221d = aVar2;
    }

    @Override // L5.c
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        l.a aVar = this.f4220c;
        c cVar = this.f4218a;
        try {
            byte[] bArrA = cVar.f4216a.a(bArr, bArr2);
            int i9 = cVar.f4217b;
            int length = bArr.length;
            aVar.getClass();
            return bArrA;
        } catch (GeneralSecurityException e9) {
            aVar.getClass();
            throw e9;
        }
    }

    @Override // L5.c
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Iterator<c> it = this.f4219b.a(bArr).iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            l.a aVar = this.f4221d;
            if (!zHasNext) {
                aVar.getClass();
                throw new GeneralSecurityException("decryption failed");
            }
            try {
                byte[] bArrB = it.next().f4216a.b(bArr, bArr2);
                aVar.getClass();
                return bArrB;
            } catch (GeneralSecurityException unused) {
            }
        }
    }
}
