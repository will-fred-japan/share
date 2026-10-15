package V3;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import cn.ikaile.ruoshui.client.MainActivity;

/* JADX INFO: compiled from: AndroidSystemActions.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MainActivity f4829a;

    public a(MainActivity mainActivity) {
        this.f4829a = mainActivity;
    }

    public final boolean a() {
        return b(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + this.f4829a.getPackageName())));
    }

    public final boolean b(Intent intent) {
        try {
            intent.addFlags(268435456);
            this.f4829a.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException | SecurityException unused) {
            return false;
        }
    }

    public final boolean c(String str, String str2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        return b(intent);
    }
}
