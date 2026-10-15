package G;

import android.app.RemoteInput;
import android.os.Bundle;
import java.util.HashSet;

/* JADX INFO: compiled from: RemoteInput.java */
/* JADX INFO: loaded from: classes.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence[] f2060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f2062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet f2063e;

    /* JADX INFO: compiled from: RemoteInput.java */
    public static class a {
        public static void a(RemoteInput.Builder builder) {
            builder.setEditChoicesBeforeSending(0);
        }
    }

    public D(String str, CharSequence[] charSequenceArr, boolean z8, Bundle bundle, HashSet hashSet) {
        this.f2059a = str;
        this.f2060b = charSequenceArr;
        this.f2061c = z8;
        this.f2062d = bundle;
        this.f2063e = hashSet;
    }
}
