package B0;

import android.net.Uri;
import android.webkit.WebResourceRequest;

/* JADX INFO: renamed from: B0.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ApiHelperForLollipop.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0288b {
    public static Uri a(WebResourceRequest webResourceRequest) {
        return webResourceRequest.getUrl();
    }

    public static boolean b(WebResourceRequest webResourceRequest) {
        return webResourceRequest.isForMainFrame();
    }
}
