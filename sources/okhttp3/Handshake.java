package okhttp3;

import K7.a;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import okhttp3.internal.Util;
import p011b4.h;
import p188x7.b;
import y7.i;
import y7.n;
import y7.p;

/* JADX INFO: compiled from: Handshake.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Handshake {
    public static final Companion Companion = new Companion(null);
    private final CipherSuite cipherSuite;
    private final List<Certificate> localCertificates;
    private final b peerCertificates$delegate;
    private final TlsVersion tlsVersion;

    /* JADX INFO: compiled from: Handshake.kt */
    public static final class Companion {
        private Companion() {
        }

        private final List<Certificate> toImmutableList(Certificate[] certificateArr) {
            return certificateArr != null ? Util.immutableListOf((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length)) : p.f22408a;
        }

        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final Handshake m896deprecated_get(SSLSession sslSession) {
            k.e(sslSession, "sslSession");
            return get(sslSession);
        }

        public final Handshake get(SSLSession handshake) throws IOException {
            List<Certificate> immutableList;
            k.e(handshake, "$this$handshake");
            String cipherSuite = handshake.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null");
            }
            int iHashCode = cipherSuite.hashCode();
            if (iHashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : iHashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == ".concat(cipherSuite));
            }
            CipherSuite cipherSuiteForJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
            String protocol = handshake.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            }
            if ("NONE".equals(protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion tlsVersionForJavaName = TlsVersion.Companion.forJavaName(protocol);
            try {
                immutableList = toImmutableList(handshake.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                immutableList = p.f22408a;
            }
            return new Handshake(tlsVersionForJavaName, cipherSuiteForJavaName, toImmutableList(handshake.getLocalCertificates()), new Handshake$Companion$handshake$1(immutableList));
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> peerCertificates, List<? extends Certificate> localCertificates) {
            k.e(tlsVersion, "tlsVersion");
            k.e(cipherSuite, "cipherSuite");
            k.e(peerCertificates, "peerCertificates");
            k.e(localCertificates, "localCertificates");
            return new Handshake(tlsVersion, cipherSuite, Util.toImmutableList(localCertificates), new Handshake$Companion$get$1(Util.toImmutableList(peerCertificates)));
        }
    }

    /* JADX INFO: renamed from: okhttp3.Handshake$peerCertificates$2, reason: invalid class name */
    /* JADX INFO: compiled from: Handshake.kt */
    public static final class AnonymousClass2 extends l implements a<List<? extends Certificate>> {
        final /* synthetic */ a $peerCertificatesFn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(a aVar) {
            super(0);
            this.$peerCertificatesFn = aVar;
        }

        @Override // K7.a
        public final List<? extends Certificate> invoke() {
            try {
                return (List) this.$peerCertificatesFn.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                return p.f22408a;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> localCertificates, a<? extends List<? extends Certificate>> peerCertificatesFn) {
        k.e(tlsVersion, "tlsVersion");
        k.e(cipherSuite, "cipherSuite");
        k.e(localCertificates, "localCertificates");
        k.e(peerCertificatesFn, "peerCertificatesFn");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = localCertificates;
        this.peerCertificates$delegate = h.E(new AnonymousClass2(peerCertificatesFn));
    }

    public static final Handshake get(SSLSession sSLSession) {
        return Companion.get(sSLSession);
    }

    private final String getName(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        k.d(type, "type");
        return type;
    }

    /* JADX INFO: renamed from: -deprecated_cipherSuite, reason: not valid java name */
    public final CipherSuite m890deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    /* JADX INFO: renamed from: -deprecated_localCertificates, reason: not valid java name */
    public final List<Certificate> m891deprecated_localCertificates() {
        return this.localCertificates;
    }

    /* JADX INFO: renamed from: -deprecated_localPrincipal, reason: not valid java name */
    public final Principal m892deprecated_localPrincipal() {
        return localPrincipal();
    }

    /* JADX INFO: renamed from: -deprecated_peerCertificates, reason: not valid java name */
    public final List<Certificate> m893deprecated_peerCertificates() {
        return peerCertificates();
    }

    /* JADX INFO: renamed from: -deprecated_peerPrincipal, reason: not valid java name */
    public final Principal m894deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    /* JADX INFO: renamed from: -deprecated_tlsVersion, reason: not valid java name */
    public final TlsVersion m895deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return handshake.tlsVersion == this.tlsVersion && k.a(handshake.cipherSuite, this.cipherSuite) && k.a(handshake.peerCertificates(), peerCertificates()) && k.a(handshake.localCertificates, this.localCertificates);
    }

    public int hashCode() {
        return this.localCertificates.hashCode() + ((peerCertificates().hashCode() + ((this.cipherSuite.hashCode() + ((this.tlsVersion.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    public final Principal localPrincipal() {
        Object objJ = n.J(this.localCertificates);
        if (!(objJ instanceof X509Certificate)) {
            objJ = null;
        }
        X509Certificate x509Certificate = (X509Certificate) objJ;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    public final List<Certificate> peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    public final Principal peerPrincipal() {
        Object objJ = n.J(peerCertificates());
        if (!(objJ instanceof X509Certificate)) {
            objJ = null;
        }
        X509Certificate x509Certificate = (X509Certificate) objJ;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    public String toString() {
        List<Certificate> listPeerCertificates = peerCertificates();
        ArrayList arrayList = new ArrayList(i.E(listPeerCertificates));
        Iterator<T> it = listPeerCertificates.iterator();
        while (it.hasNext()) {
            arrayList.add(getName((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder("Handshake{tlsVersion=");
        sb.append(this.tlsVersion);
        sb.append(" cipherSuite=");
        sb.append(this.cipherSuite);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List<Certificate> list = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(i.E(list));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(getName((Certificate) it2.next()));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }

    public static final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, List<? extends Certificate> list2) {
        return Companion.get(tlsVersion, cipherSuite, list, list2);
    }
}
