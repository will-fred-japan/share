package M7;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: Random.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3103a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final M7.a f3104b;

    /* JADX INFO: compiled from: Random.kt */
    public static final class a extends c implements Serializable {
        private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Deserialization is supported via proxy only");
        }
    }

    static {
        F7.b.f2051a.getClass();
        Integer num = H7.a.C0021a.f2532a;
        f3104b = (num == null || num.intValue() >= 34) ? new N7.a() : new b();
    }
}
