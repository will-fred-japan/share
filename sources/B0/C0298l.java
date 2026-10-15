package B0;

import android.app.Person;
import android.os.Parcelable;
import android.view.DisplayCutout;
import android.webkit.TracingConfig;

/* JADX INFO: renamed from: B0.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0298l {
    public static /* bridge */ /* synthetic */ boolean A(Object obj) {
        return obj instanceof DisplayCutout;
    }

    public static /* bridge */ /* synthetic */ Person i(Parcelable parcelable) {
        return (Person) parcelable;
    }

    public static /* synthetic */ TracingConfig.Builder o() {
        return new TracingConfig.Builder();
    }
}
