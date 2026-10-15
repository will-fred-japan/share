package p051h;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.k;
import p043g.h;
import y7.p;

/* JADX INFO: compiled from: ActivityResultContracts.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a<h, List<Uri>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18995a;

    public b(int i9) {
        this.f18995a = i9;
        if (i9 <= 1) {
            throw new IllegalArgumentException("Max items must be higher than 1");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p051h.a
    public final a.C0205a b(Context context, Parcelable parcelable) {
        h input = (h) parcelable;
        k.e(input, "input");
        return null;
    }

    @Override // p051h.a
    public final List<Uri> c(int i9, Intent intent) {
        if (i9 != -1) {
            intent = null;
        }
        p pVar = p.f22408a;
        if (intent == null) {
            return pVar;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Uri data = intent.getData();
        if (data != null) {
            linkedHashSet.add(data);
        }
        ClipData clipData = intent.getClipData();
        if (clipData == null && linkedHashSet.isEmpty()) {
            return pVar;
        }
        if (clipData != null) {
            int itemCount = clipData.getItemCount();
            for (int i10 = 0; i10 < itemCount; i10++) {
                Uri uri = clipData.getItemAt(i10).getUri();
                if (uri != null) {
                    linkedHashSet.add(uri);
                }
            }
        }
        return new ArrayList(linkedHashSet);
    }

    @Override // p051h.a
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Intent a(Context context, h input) {
        k.e(context, "context");
        k.e(input, "input");
        int i9 = Build.VERSION.SDK_INT;
        boolean z8 = i9 >= 33 || (i9 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2);
        int i10 = this.f18995a;
        if (z8) {
            Intent intent = new Intent("android.provider.action.PICK_IMAGES");
            intent.setType(c.a.b(input.f18743a));
            int iMin = Math.min(i10, input.f18744b);
            if (iMin <= 1 || iMin > MediaStore.getPickImagesMaxLimit()) {
                throw new IllegalArgumentException("Max items must be greater than 1 and lesser than or equal to MediaStore.getPickImagesMaxLimit()");
            }
            intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", iMin);
            input.f18745c.getClass();
            intent.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", c.b.a.f18997b);
            intent.putExtra("android.provider.extra.PICK_IMAGES_IN_ORDER", false);
            return intent;
        }
        if (c.a.a(context) == null) {
            Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent2.setType(c.a.b(input.f18743a));
            intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            if (intent2.getType() == null) {
                intent2.setType("*/*");
                intent2.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            }
            return intent2;
        }
        ResolveInfo resolveInfoA = c.a.a(context);
        if (resolveInfoA == null) {
            throw new IllegalStateException("Required value was null.");
        }
        ActivityInfo activityInfo = resolveInfoA.activityInfo;
        Intent intent3 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
        intent3.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
        intent3.setType(c.a.b(input.f18743a));
        int iMin2 = Math.min(i10, input.f18744b);
        if (iMin2 <= 1) {
            throw new IllegalArgumentException("Max items must be greater than 1");
        }
        intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_MAX", iMin2);
        input.f18745c.getClass();
        intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", c.b.a.f18997b);
        intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_IN_ORDER", false);
        return intent3;
    }
}
