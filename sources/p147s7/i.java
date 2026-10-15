package p147s7;

import android.app.Activity;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: ImagePickerCache.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f21323a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: ImagePickerCache.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f21324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f21325b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ a[] f21326c;

        static {
            a aVar = new a("IMAGE", 0);
            f21324a = aVar;
            a aVar2 = new a("VIDEO", 1);
            f21325b = aVar2;
            f21326c = new a[]{aVar, aVar2};
        }

        public a() {
            throw null;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f21326c.clone();
        }
    }

    public i(Activity activity) {
        this.f21323a = activity;
    }

    public final void a() {
        this.f21323a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit().clear().apply();
    }

    public final void b(ArrayList<String> arrayList, String str, String str2) {
        SharedPreferences.Editor editorEdit = this.f21323a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit();
        if (arrayList != null) {
            editorEdit.putStringSet("flutter_image_picker_image_path", new HashSet(arrayList));
        }
        if (str != null) {
            editorEdit.putString("flutter_image_picker_error_code", str);
        }
        if (str2 != null) {
            editorEdit.putString("flutter_image_picker_error_message", str2);
        }
        editorEdit.apply();
    }
}
