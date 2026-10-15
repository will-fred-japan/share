package S4;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class O {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Uri f4133d = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4136c;

    public O(String str, boolean z8) {
        C0376g.d(str);
        this.f4134a = str;
        C0376g.d("com.google.android.gms");
        this.f4135b = "com.google.android.gms";
        this.f4136c = z8;
    }

    public final Intent a(Context context) {
        Bundle bundleCall;
        Intent intent = null;
        String str = this.f4134a;
        if (str == null) {
            return new Intent().setComponent(null);
        }
        if (this.f4136c) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", str);
            try {
                bundleCall = context.getContentResolver().call(f4133d, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e9) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e9.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(str)));
            }
        }
        return intent == null ? new Intent(str).setPackage(this.f4135b) : intent;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof O)) {
            return false;
        }
        O o2 = (O) obj;
        return C0375f.a(this.f4134a, o2.f4134a) && C0375f.a(this.f4135b, o2.f4135b) && C0375f.a(null, null) && this.f4136c == o2.f4136c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4134a, this.f4135b, null, 4225, Boolean.valueOf(this.f4136c)});
    }

    public final String toString() {
        String str = this.f4134a;
        if (str != null) {
            return str;
        }
        C0376g.e(null);
        throw null;
    }
}
