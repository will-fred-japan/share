package A0;

import B0.C0290d;
import B0.C0306u;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebResourceResponse;
import com.starburst.sdk.req.GuiControlRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: WebViewAssetLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1380a;

    /* JADX INFO: compiled from: WebViewAssetLoader.java */
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C0306u f1381a;

        @Override // A0.o.c
        public final WebResourceResponse handle(String str) {
            try {
                C0306u c0306u = this.f1381a;
                c0306u.getClass();
                String strSubstring = (str.length() <= 1 || str.charAt(0) != '/') ? str : str.substring(1);
                InputStream inputStreamOpen = c0306u.f1682a.getAssets().open(strSubstring, 2);
                if (strSubstring.endsWith(".svgz")) {
                    inputStreamOpen = new GZIPInputStream(inputStreamOpen);
                }
                return new WebResourceResponse(C0306u.b(str), null, inputStreamOpen);
            } catch (IOException e9) {
                Log.e("WebViewAssetLoader", "Error opening asset path: " + str, e9);
                return new WebResourceResponse(null, null, null);
            }
        }
    }

    /* JADX INFO: compiled from: WebViewAssetLoader.java */
    public static final class b implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f1382b = {"app_webview/", "databases/", "lib/", "shared_prefs/", "code_cache/"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f1383a;

        public b(Context context, File file) {
            try {
                this.f1383a = new File(C0306u.a(file));
                if (a(context)) {
                    return;
                }
                throw new IllegalArgumentException("The given directory \"" + file + "\" doesn't exist under an allowed app internal storage directory");
            } catch (IOException e9) {
                throw new IllegalArgumentException("Failed to resolve the canonical path for the given directory: " + file.getPath(), e9);
            }
        }

        public final boolean a(Context context) throws IOException {
            String strA = C0306u.a(this.f1383a);
            String strA2 = C0306u.a(context.getCacheDir());
            String strA3 = C0306u.a(C0290d.e(context));
            if ((!strA.startsWith(strA2) && !strA.startsWith(strA3)) || strA.equals(strA2) || strA.equals(strA3)) {
                return false;
            }
            String[] strArr = f1382b;
            for (int i9 = 0; i9 < 5; i9++) {
                if (strA.startsWith(strA3 + strArr[i9])) {
                    return false;
                }
            }
            return true;
        }

        @Override // A0.o.c
        public final WebResourceResponse handle(String str) {
            File file = this.f1383a;
            try {
                String strA = C0306u.a(file);
                String canonicalPath = new File(file, str).getCanonicalPath();
                File file2 = canonicalPath.startsWith(strA) ? new File(canonicalPath) : null;
                if (file2 == null) {
                    Log.e("WebViewAssetLoader", String.format("The requested file: %s is outside the mounted directory: %s", str, file));
                    return new WebResourceResponse(null, null, null);
                }
                InputStream fileInputStream = new FileInputStream(file2);
                if (file2.getPath().endsWith(".svgz")) {
                    fileInputStream = new GZIPInputStream(fileInputStream);
                }
                return new WebResourceResponse(C0306u.b(str), null, fileInputStream);
            } catch (IOException e9) {
                Log.e("WebViewAssetLoader", "Error opening the requested path: " + str, e9);
            }
        }
    }

    /* JADX INFO: compiled from: WebViewAssetLoader.java */
    public interface c {
        WebResourceResponse handle(String str);
    }

    /* JADX INFO: compiled from: WebViewAssetLoader.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f1384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f1386c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f1387d;

        public d(String str, String str2, boolean z8, c cVar) {
            if (str2.isEmpty() || str2.charAt(0) != '/') {
                throw new IllegalArgumentException("Path should start with a slash '/'.");
            }
            if (!str2.endsWith("/")) {
                throw new IllegalArgumentException("Path should end with a slash '/'");
            }
            this.f1385b = str;
            this.f1386c = str2;
            this.f1384a = z8;
            this.f1387d = cVar;
        }
    }

    /* JADX INFO: compiled from: WebViewAssetLoader.java */
    public static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C0306u f1388a;

        @Override // A0.o.c
        public final WebResourceResponse handle(String str) {
            try {
                return new WebResourceResponse(C0306u.b(str), null, this.f1388a.c(str));
            } catch (Resources.NotFoundException e9) {
                Log.e("WebViewAssetLoader", "Resource not found from the path: " + str, e9);
                return new WebResourceResponse(null, null, null);
            } catch (IOException e10) {
                Log.e("WebViewAssetLoader", "Error opening resource from the path: " + str, e10);
                return new WebResourceResponse(null, null, null);
            }
        }
    }

    public o(ArrayList arrayList) {
        this.f1380a = arrayList;
    }

    public final WebResourceResponse a(Uri uri) {
        WebResourceResponse webResourceResponseHandle;
        Iterator it = this.f1380a.iterator();
        while (true) {
            c cVar = null;
            if (!it.hasNext()) {
                return null;
            }
            d dVar = (d) it.next();
            dVar.getClass();
            boolean zEquals = uri.getScheme().equals(GuiControlRequest.IMAGE_TYPE_HTTP);
            String str = dVar.f1386c;
            if ((!zEquals || dVar.f1384a) && ((uri.getScheme().equals(GuiControlRequest.IMAGE_TYPE_HTTP) || uri.getScheme().equals("https")) && uri.getAuthority().equals(dVar.f1385b) && uri.getPath().startsWith(str))) {
                cVar = dVar.f1387d;
            }
            if (cVar != null && (webResourceResponseHandle = cVar.handle(uri.getPath().replaceFirst(str, ""))) != null) {
                return webResourceResponseHandle;
            }
        }
    }
}
