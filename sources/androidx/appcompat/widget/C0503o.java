package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* JADX INFO: renamed from: androidx.appcompat.widget.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatTextClassifierHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0503o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f6634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextClassifier f6635b;

    /* JADX INFO: renamed from: androidx.appcompat.widget.o$a */
    /* JADX INFO: compiled from: AppCompatTextClassifierHelper.java */
    public static final class a {
        public static TextClassifier a(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }
}
