package N5;

import U5.J;
import android.os.Build;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: compiled from: AesGcmJceUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3215a = new a();

    /* JADX INFO: compiled from: AesGcmJceUtil.java */
    public class a extends ThreadLocal<Cipher> {
        @Override // java.lang.ThreadLocal
        public final Cipher initialValue() {
            try {
                return p004a6.g.f5707b.f5709a.a("AES/GCM/NoPadding");
            } catch (GeneralSecurityException e9) {
                throw new IllegalStateException(e9);
            }
        }
    }

    public static AlgorithmParameterSpec a(int i9, int i10, byte[] bArr) {
        int i11 = J.f4697a;
        Integer numValueOf = !Objects.equals(System.getProperty("java.vendor"), "The Android Project") ? null : Integer.valueOf(Build.VERSION.SDK_INT);
        return (numValueOf == null || numValueOf.intValue() > 19) ? new GCMParameterSpec(128, bArr, i9, i10) : new IvParameterSpec(bArr, i9, i10);
    }
}
