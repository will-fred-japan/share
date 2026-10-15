package androidx.constraintlayout.utils.widget;

import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class MockView extends View {
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getWidth();
        getHeight();
    }
}
