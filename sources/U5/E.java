package U5;

import com.google.crypto.tink.shaded.protobuf.AbstractC0569h;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: ProtoKeySerialization.java */
/* JADX INFO: loaded from: classes.dex */
public final class E implements H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p012b6.a f4677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC0569h f4678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Z5.y.b f4679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Z5.I f4680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f4681f;

    public E(String str, p012b6.a aVar, AbstractC0569h abstractC0569h, Z5.y.b bVar, Z5.I i9, Integer num) {
        this.f4676a = str;
        this.f4677b = aVar;
        this.f4678c = abstractC0569h;
        this.f4679d = bVar;
        this.f4680e = i9;
        this.f4681f = num;
    }

    public static E a(String str, AbstractC0569h abstractC0569h, Z5.y.b bVar, Z5.I i9, Integer num) throws GeneralSecurityException {
        if (i9 == Z5.I.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new E(str, J.a(str), abstractC0569h, bVar, i9, num);
    }
}
