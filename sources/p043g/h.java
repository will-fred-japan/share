package p043g;

import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import p051h.c;

/* JADX INFO: compiled from: PickVisualMediaRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c.g f18743a = c.C0206c.f18998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.b.a f18745c;

    public h() {
        int i9 = Build.VERSION.SDK_INT;
        this.f18744b = (i9 < 33 && (i9 < 30 || SdkExtensions.getExtensionVersion(30) < 2)) ? Integer.MAX_VALUE : MediaStore.getPickImagesMaxLimit();
        this.f18745c = c.b.a.f18996a;
    }
}
