package C2;

import org.json.JSONObject;

/* JADX INFO: compiled from: LogItem.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f1797a;

    public final String toString() {
        try {
            return new JSONObject(new String(this.f1797a)).toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
