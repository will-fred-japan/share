package V;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.inputmethod.EditorInfo;

/* JADX INFO: compiled from: EditorInfoCompat.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class a {

    /* JADX INFO: renamed from: V.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EditorInfoCompat.java */
    public static class C0061a {
        public static void a(EditorInfo editorInfo, CharSequence charSequence) {
            editorInfo.setInitialSurroundingSubText(charSequence, 0);
        }
    }

    /* JADX INFO: compiled from: EditorInfoCompat.java */
    public static class b {
        public static void a(EditorInfo editorInfo) {
            editorInfo.setStylusHandwritingEnabled(true);
        }
    }

    public static void a(EditorInfo editorInfo, CharSequence charSequence, int i9, int i10) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i9);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i10);
    }
}
