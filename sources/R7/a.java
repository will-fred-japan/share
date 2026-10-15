package R7;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: Charsets.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4066a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f4067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f4068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Charset f4069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Charset f4070e;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        kotlin.jvm.internal.k.d(charsetForName, "forName(...)");
        f4067b = charsetForName;
        kotlin.jvm.internal.k.d(Charset.forName("UTF-16"), "forName(...)");
        kotlin.jvm.internal.k.d(Charset.forName("UTF-16BE"), "forName(...)");
        kotlin.jvm.internal.k.d(Charset.forName("UTF-16LE"), "forName(...)");
        Charset charsetForName2 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.k.d(charsetForName2, "forName(...)");
        f4068c = charsetForName2;
        kotlin.jvm.internal.k.d(Charset.forName("ISO-8859-1"), "forName(...)");
    }
}
