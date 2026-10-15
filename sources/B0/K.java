package B0;

import java.util.Objects;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;

/* JADX INFO: compiled from: WebMessagePayloadAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class K implements WebMessagePayloadBoundaryInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f1617c;

    public K(String str) {
        this.f1615a = 0;
        this.f1616b = str;
        this.f1617c = null;
    }

    public final void a(int i9) {
        int i10 = this.f1615a;
        if (i10 != i9) {
            throw new IllegalStateException(W5.e.h(i9, i10, "Expected ", ", but type is "));
        }
    }

    @Override // org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface
    public final byte[] getAsArrayBuffer() {
        a(1);
        byte[] bArr = this.f1617c;
        Objects.requireNonNull(bArr);
        return bArr;
    }

    @Override // org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface
    public final String getAsString() {
        a(0);
        return this.f1616b;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public final String[] getSupportedFeatures() {
        return new String[0];
    }

    @Override // org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface
    public final int getType() {
        return this.f1615a;
    }

    public K(byte[] bArr) {
        this.f1615a = 1;
        this.f1616b = null;
        this.f1617c = bArr;
    }
}
