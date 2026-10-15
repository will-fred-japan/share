package Q;

import android.net.Uri;
import com.huawei.agconnect.exception.AGCServerException;

/* JADX INFO: compiled from: FontsContractCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f3681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3686f;

    public m(Uri uri, int i9, int i10, boolean z8, String str, int i11) {
        uri.getClass();
        this.f3681a = uri;
        this.f3682b = i9;
        this.f3683c = i10;
        this.f3684d = z8;
        this.f3685e = str;
        this.f3686f = i11;
    }

    public m(String str, String str2) {
        this.f3681a = new Uri.Builder().scheme("systemfont").authority(str).build();
        this.f3682b = 0;
        this.f3683c = AGCServerException.AUTHENTICATION_INVALID;
        this.f3684d = false;
        this.f3685e = str2;
        this.f3686f = 0;
    }
}
