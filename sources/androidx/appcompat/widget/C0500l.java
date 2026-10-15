package androidx.appcompat.widget;

import T.C0416c;
import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: renamed from: androidx.appcompat.widget.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatReceiveContentHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0500l {
    public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        C0416c.b aVar;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                aVar = new C0416c.a(clipData, 3);
            } else {
                C0416c.C0053c c0053c = new C0416c.C0053c();
                c0053c.f4407a = clipData;
                c0053c.f4408b = 3;
                aVar = c0053c;
            }
            T.G.i(textView, aVar.a());
            return true;
        } finally {
            textView.endBatchEdit();
        }
    }

    public static boolean b(DragEvent dragEvent, View view, Activity activity) {
        C0416c.b aVar;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            aVar = new C0416c.a(clipData, 3);
        } else {
            C0416c.C0053c c0053c = new C0416c.C0053c();
            c0053c.f4407a = clipData;
            c0053c.f4408b = 3;
            aVar = c0053c;
        }
        T.G.i(view, aVar.a());
        return true;
    }
}
