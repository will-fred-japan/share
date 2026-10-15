package p154t7;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.Set;
import p142s2.j;

/* JADX INFO: compiled from: StringListObjectInputStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class v extends ObjectInputStream {
    @Override // java.io.ObjectInputStream
    public final Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException {
        Set setX = j.x("java.util.Arrays$ArrayList", "java.util.ArrayList", "java.lang.String", "[Ljava.lang.String;");
        String name = objectStreamClass != null ? objectStreamClass.getName() : null;
        if (name == null || setX.contains(name)) {
            return super.resolveClass(objectStreamClass);
        }
        throw new ClassNotFoundException(objectStreamClass.getName());
    }
}
