package O4;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f3487d;

    public o(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f3487d = bArr;
    }

    @Override // O4.n
    public final byte[] Q() {
        return this.f3487d;
    }
}
