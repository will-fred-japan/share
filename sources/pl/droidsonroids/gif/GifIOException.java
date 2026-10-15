package pl.droidsonroids.gif;

import androidx.datastore.preferences.protobuf.C0524s;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class GifIOException extends IOException {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f20825c = 0;
    private static final long serialVersionUID = 13038402904505L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f20826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20827b;

    public GifIOException(int i9, String str) {
        for (e eVar : e.values()) {
            if (eVar.f20867b == i9) {
                this.f20826a = eVar;
                this.f20827b = str;
            }
        }
        eVar = e.UNKNOWN;
        eVar.f20867b = i9;
        this.f20826a = eVar;
        this.f20827b = str;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        e eVar = this.f20826a;
        String str = this.f20827b;
        if (str == null) {
            eVar.getClass();
            Locale locale = Locale.ENGLISH;
            StringBuilder sbA = C0524s.a(eVar.f20867b, "GifError ", ": ");
            sbA.append(eVar.f20866a);
            return sbA.toString();
        }
        StringBuilder sb = new StringBuilder();
        eVar.getClass();
        Locale locale2 = Locale.ENGLISH;
        StringBuilder sbA2 = C0524s.a(eVar.f20867b, "GifError ", ": ");
        sbA2.append(eVar.f20866a);
        sb.append(sbA2.toString());
        sb.append(": ");
        sb.append(str);
        return sb.toString();
    }
}
