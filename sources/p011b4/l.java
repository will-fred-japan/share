package p011b4;

import android.text.TextUtils;
import android.util.Printer;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Printer {
    @Override // android.util.Printer
    public final void println(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.charAt(0) == '>') {
            m.a(true, str);
        } else if (str.charAt(0) == '<') {
            m.a(false, str);
        }
    }
}
