package p022d0;

import android.app.ActivityManager;
import android.text.PrecomputedText;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n {
    public static /* synthetic */ ActivityManager.TaskDescription a(int i9, String str) {
        return new ActivityManager.TaskDescription(str, 0, i9);
    }

    public static /* synthetic */ void e() {
    }

    public static /* bridge */ /* synthetic */ boolean g(CharSequence charSequence) {
        return charSequence instanceof PrecomputedText;
    }
}
