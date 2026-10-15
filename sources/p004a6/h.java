package p004a6;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: compiled from: EngineWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public interface h<T> {

    /* JADX INFO: compiled from: EngineWrapper.java */
    public static class a implements h<Cipher> {
        @Override // p004a6.h
        public final Cipher a(String str, Provider provider) {
            return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
        }
    }

    /* JADX INFO: compiled from: EngineWrapper.java */
    public static class b implements h<KeyAgreement> {
        @Override // p004a6.h
        public final KeyAgreement a(String str, Provider provider) {
            return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
        }
    }

    /* JADX INFO: compiled from: EngineWrapper.java */
    public static class c implements h<KeyFactory> {
        @Override // p004a6.h
        public final KeyFactory a(String str, Provider provider) {
            return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
        }
    }

    /* JADX INFO: compiled from: EngineWrapper.java */
    public static class d implements h<KeyPairGenerator> {
        @Override // p004a6.h
        public final KeyPairGenerator a(String str, Provider provider) {
            return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
        }
    }

    /* JADX INFO: compiled from: EngineWrapper.java */
    public static class e implements h<Mac> {
        @Override // p004a6.h
        public final Mac a(String str, Provider provider) {
            return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
        }
    }

    /* JADX INFO: compiled from: EngineWrapper.java */
    public static class f implements h<MessageDigest> {
        @Override // p004a6.h
        public final MessageDigest a(String str, Provider provider) {
            return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
        }
    }

    /* JADX INFO: compiled from: EngineWrapper.java */
    public static class g implements h<Signature> {
        @Override // p004a6.h
        public final Signature a(String str, Provider provider) {
            return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
        }
    }

    T a(String str, Provider provider);
}
