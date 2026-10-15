package com.google.android.material.snackbar;

import C5.c;
import T.G;
import T.L;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.ikaile.ruoshui.client.R;
import java.util.WeakHashMap;
import p110o5.a;

/* JADX INFO: loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f13710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Button f13711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13712c;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c.d(context, R.attr.motionEasingEmphasizedInterpolator, a.f20704b);
    }

    public final boolean a(int i9, int i10, int i11) {
        boolean z8;
        if (i9 != getOrientation()) {
            setOrientation(i9);
            z8 = true;
        } else {
            z8 = false;
        }
        if (this.f13710a.getPaddingTop() == i10 && this.f13710a.getPaddingBottom() == i11) {
            return z8;
        }
        TextView textView = this.f13710a;
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        if (textView.isPaddingRelative()) {
            textView.setPaddingRelative(textView.getPaddingStart(), i10, textView.getPaddingEnd(), i11);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i10, textView.getPaddingRight(), i11);
        return true;
    }

    public Button getActionView() {
        return this.f13711b;
    }

    public TextView getMessageView() {
        return this.f13710a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f13710a = (TextView) findViewById(R.id.snackbar_text);
        this.f13711b = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        Layout layout = this.f13710a.getLayout();
        boolean z8 = layout != null && layout.getLineCount() > 1;
        if (!z8 || this.f13712c <= 0 || this.f13711b.getMeasuredWidth() <= this.f13712c) {
            if (!z8) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!a(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i9, i10);
    }

    public void setMaxInlineActionWidth(int i9) {
        this.f13712c = i9;
    }
}
