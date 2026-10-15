package R7;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f4083a;

    public d(String str) {
        Pattern patternCompile = Pattern.compile(str);
        kotlin.jvm.internal.k.d(patternCompile, "compile(...)");
        this.f4083a = patternCompile;
    }

    private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    public final String toString() {
        String string = this.f4083a.toString();
        kotlin.jvm.internal.k.d(string, "toString(...)");
        return string;
    }
}
