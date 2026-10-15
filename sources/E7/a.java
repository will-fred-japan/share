package E7;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import kotlin.jvm.internal.k;
import y7.b;

/* JADX INFO: compiled from: EnumEntries.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T extends Enum<T>> extends b<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T[] f2009a;

    public a(T[] tArr) {
        this.f2009a = tArr;
    }

    private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Override // y7.a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum element = (Enum) obj;
        k.e(element, "element");
        int iOrdinal = element.ordinal();
        T[] tArr = this.f2009a;
        k.e(tArr, "<this>");
        return ((iOrdinal < 0 || iOrdinal >= tArr.length) ? null : tArr[iOrdinal]) == element;
    }

    @Override // y7.b, java.util.List
    public final Object get(int i9) {
        b.a aVar = b.Companion;
        T[] tArr = this.f2009a;
        int length = tArr.length;
        aVar.getClass();
        b.a.a(i9, length);
        return tArr[i9];
    }

    @Override // y7.b, y7.a
    public final int getSize() {
        return this.f2009a.length;
    }

    @Override // y7.b, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        k.e(element, "element");
        int iOrdinal = element.ordinal();
        T[] tArr = this.f2009a;
        k.e(tArr, "<this>");
        if (((iOrdinal < 0 || iOrdinal >= tArr.length) ? null : tArr[iOrdinal]) == element) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // y7.b, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        k.e(element, "element");
        int iOrdinal = element.ordinal();
        T[] tArr = this.f2009a;
        k.e(tArr, "<this>");
        if (((iOrdinal < 0 || iOrdinal >= tArr.length) ? null : tArr[iOrdinal]) == element) {
            return iOrdinal;
        }
        return -1;
    }
}
