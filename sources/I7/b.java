package I7;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public class b extends IOException {
    public b(String str, File file, File file2) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        sb.append(": ".concat(str));
        String string = sb.toString();
        k.d(string, "toString(...)");
        super(string);
    }
}
