package p051h;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: ActivityResultContracts.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e extends a<Intent, ActivityResult> {
    @Override // p051h.a
    public final Intent a(Context context, Parcelable parcelable) {
        Intent input = (Intent) parcelable;
        k.e(input, "input");
        return input;
    }

    @Override // p051h.a
    public final ActivityResult c(int i9, Intent intent) {
        return new ActivityResult(i9, intent);
    }
}
