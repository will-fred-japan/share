package P4;

import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends UnsupportedOperationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Feature f3629a;

    public j(Feature feature) {
        this.f3629a = feature;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Missing ".concat(String.valueOf(this.f3629a));
    }
}
