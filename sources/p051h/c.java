package p051h;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.os.ext.SdkExtensions;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.k;
import p043g.h;
import y7.n;
import y7.p;

/* JADX INFO: compiled from: ActivityResultContracts.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c extends p051h.a<h, Uri> {

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    public static final class a {
        public static ResolveInfo a(Context context) {
            k.e(context, "context");
            return context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
        }

        public static String b(g gVar) {
            if (gVar instanceof d) {
                return "image/*";
            }
            if (gVar instanceof f) {
                return "video/*";
            }
            if ((gVar instanceof e) || (gVar instanceof C0206c)) {
                return null;
            }
            throw new L4.b();
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    public static abstract class b {

        /* JADX INFO: compiled from: ActivityResultContracts.kt */
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f18996a = new a();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f18997b = 1;
        }
    }

    /* JADX INFO: renamed from: h.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    public static final class C0206c implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0206c f18998a = new C0206c();
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    public static final class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f18999a = new d();
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    public static final class e implements g {
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    public static final class f implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f19000a = new f();
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    public interface g {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p051h.a
    public final p051h.a.C0205a b(Context context, Parcelable parcelable) {
        h input = (h) parcelable;
        k.e(input, "input");
        return null;
    }

    @Override // p051h.a
    public final Uri c(int i9, Intent intent) {
        List arrayList;
        if (i9 != -1) {
            intent = null;
        }
        if (intent == null) {
            return null;
        }
        Uri data = intent.getData();
        if (data != null) {
            return data;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Uri data2 = intent.getData();
        if (data2 != null) {
            linkedHashSet.add(data2);
        }
        ClipData clipData = intent.getClipData();
        if (clipData == null && linkedHashSet.isEmpty()) {
            arrayList = p.f22408a;
        } else {
            if (clipData != null) {
                int itemCount = clipData.getItemCount();
                for (int i10 = 0; i10 < itemCount; i10++) {
                    Uri uri = clipData.getItemAt(i10).getUri();
                    if (uri != null) {
                        linkedHashSet.add(uri);
                    }
                }
            }
            arrayList = new ArrayList(linkedHashSet);
        }
        return (Uri) n.J(arrayList);
    }

    @Override // p051h.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Intent a(Context context, h input) {
        k.e(context, "context");
        k.e(input, "input");
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 33 || (i9 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2)) {
            Intent intent = new Intent("android.provider.action.PICK_IMAGES");
            intent.setType(a.b(input.f18743a));
            input.f18745c.getClass();
            intent.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", b.a.f18997b);
            return intent;
        }
        if (a.a(context) == null) {
            Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent2.setType(a.b(input.f18743a));
            if (intent2.getType() == null) {
                intent2.setType("*/*");
                intent2.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            }
            return intent2;
        }
        ResolveInfo resolveInfoA = a.a(context);
        if (resolveInfoA == null) {
            throw new IllegalStateException("Required value was null.");
        }
        ActivityInfo activityInfo = resolveInfoA.activityInfo;
        Intent intent3 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
        intent3.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
        intent3.setType(a.b(input.f18743a));
        input.f18745c.getClass();
        intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", b.a.f18997b);
        return intent3;
    }
}
