package p177w5;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: InsetDialogOnTouchListener.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Dialog f22113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f22116d;

    public a(Dialog dialog, Rect rect) {
        this.f22113a = dialog;
        this.f22114b = rect.left;
        this.f22115c = rect.top;
        this.f22116d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = viewFindViewById.getLeft() + this.f22114b;
        int width = viewFindViewById.getWidth() + left;
        int top = viewFindViewById.getTop() + this.f22115c;
        if (new RectF(left, top, width, viewFindViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            int i9 = this.f22116d;
            motionEventObtain.setLocation((-i9) - 1, (-i9) - 1);
        }
        view.performClick();
        return this.f22113a.onTouchEvent(motionEventObtain);
    }
}
