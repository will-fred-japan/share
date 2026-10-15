package okhttp3;

import K7.a;
import java.security.cert.Certificate;
import java.util.List;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: Handshake.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Handshake$Companion$handshake$1 extends l implements a<List<? extends Certificate>> {
    final /* synthetic */ List $peerCertificatesCopy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Handshake$Companion$handshake$1(List list) {
        super(0);
        this.$peerCertificatesCopy = list;
    }

    @Override // K7.a
    public final List<? extends Certificate> invoke() {
        return this.$peerCertificatesCopy;
    }
}
