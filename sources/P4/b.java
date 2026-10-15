package P4;

import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class b extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public final Status f3618a;

    /* JADX WARN: Illegal instructions before constructor call */
    public b(Status status) {
        int i9 = status.f12468a;
        String str = status.f12469b;
        super(i9 + ": " + (str == null ? "" : str));
        this.f3618a = status;
    }
}
