package O5;

import N5.e;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import p004a6.g;

/* JADX INFO: compiled from: AesGcmSiv.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements L5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0034a f3494a = new C0034a();

    /* JADX INFO: renamed from: O5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AesGcmSiv.java */
    public class C0034a extends ThreadLocal<Cipher> {
        @Override // java.lang.ThreadLocal
        public final Cipher initialValue() {
            try {
                Cipher cipherA = g.f5707b.f5709a.a("AES/GCM-SIV/NoPadding");
                if (e.c(cipherA)) {
                    return cipherA;
                }
                return null;
            } catch (GeneralSecurityException e9) {
                throw new IllegalStateException(e9);
            }
        }
    }
}
