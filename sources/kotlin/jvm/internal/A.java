package kotlin.jvm.internal;

/* JADX INFO: compiled from: ReflectionFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class A {
    public static String a(h hVar) {
        String string = hVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
