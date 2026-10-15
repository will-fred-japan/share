package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class Guideline extends View {
    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i9) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        aVar.f6847a = i9;
        setLayoutParams(aVar);
    }

    public void setGuidelineEnd(int i9) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        aVar.f6848b = i9;
        setLayoutParams(aVar);
    }

    public void setGuidelinePercent(float f6) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        aVar.f6850c = f6;
        setLayoutParams(aVar);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i9) {
    }
}
