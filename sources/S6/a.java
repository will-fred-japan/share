package S6;

import android.content.ContentResolver;
import android.provider.Settings;
import kotlin.jvm.internal.k;
import p096m7.j;
import p096m7.l;

/* JADX INFO: compiled from: AndroidIdPlugin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements p042f7.a, l.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f4222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContentResolver f4223b;

    @Override // p042f7.a
    public final void onAttachedToEngine(f7.a.b flutterPluginBinding) {
        k.e(flutterPluginBinding, "flutterPluginBinding");
        this.f4223b = flutterPluginBinding.f18711a.getContentResolver();
        l lVar = new l(flutterPluginBinding.f18713c, "android_id");
        this.f4222a = lVar;
        lVar.b(this);
    }

    @Override // p042f7.a
    public final void onDetachedFromEngine(f7.a.b binding) {
        k.e(binding, "binding");
        l lVar = this.f4222a;
        if (lVar != null) {
            lVar.b(null);
        } else {
            k.i("channel");
            throw null;
        }
    }

    @Override // m7.l.c
    public final void onMethodCall(j call, l.d dVar) {
        k.e(call, "call");
        if (!k.a(call.f20496a, "getId")) {
            ((p096m7.k) dVar).notImplemented();
            return;
        }
        try {
            ContentResolver contentResolver = this.f4223b;
            if (contentResolver == null) {
                k.i("contentResolver");
                throw null;
            }
            ((p096m7.k) dVar).success(Settings.Secure.getString(contentResolver, "android_id"));
        } catch (Exception e9) {
            ((p096m7.k) dVar).error("ERROR_GETTING_ID", "Failed to get Android ID", e9.getLocalizedMessage());
        }
    }
}
