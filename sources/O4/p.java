package O4;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p extends n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final WeakReference f3488e = new WeakReference(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference f3489d;

    public p(byte[] bArr) {
        super(bArr);
        this.f3489d = f3488e;
    }

    @Override // O4.n
    public final byte[] Q() {
        byte[] bArrR;
        synchronized (this) {
            try {
                bArrR = (byte[]) this.f3489d.get();
                if (bArrR == null) {
                    bArrR = R();
                    this.f3489d = new WeakReference(bArrR);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrR;
    }

    public abstract byte[] R();
}
