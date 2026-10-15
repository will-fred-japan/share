package androidx.constraintlayout.widget;

import A.g;
import C.d;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends ConstraintHelper {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6795i;
    public int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public A.b f6796k;

    public Barrier(Context context) {
        super(context);
        this.f6797a = new int[32];
        this.f6803g = null;
        this.f6804h = new HashMap<>();
        this.f6799c = context;
        g(null);
        super.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        this.f6796k = new A.b();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.f1778b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i9);
                if (index == 15) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == 14) {
                    this.f6796k.f1186o0 = typedArrayObtainStyledAttributes.getBoolean(index, true);
                } else if (index == 16) {
                    this.f6796k.f1187p0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f6800d = this.f6796k;
        k();
    }

    public int getMargin() {
        return this.f6796k.f1187p0;
    }

    public int getType() {
        return this.f6795i;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void h(g gVar, boolean z8) {
        int i9 = this.f6795i;
        this.j = i9;
        if (z8) {
            if (i9 == 5) {
                this.j = 1;
            } else if (i9 == 6) {
                this.j = 0;
            }
        } else if (i9 == 5) {
            this.j = 0;
        } else if (i9 == 6) {
            this.j = 1;
        }
        if (gVar instanceof A.b) {
            ((A.b) gVar).f1185n0 = this.j;
        }
    }

    public void setAllowsGoneWidget(boolean z8) {
        this.f6796k.f1186o0 = z8;
    }

    public void setDpMargin(int i9) {
        this.f6796k.f1187p0 = (int) ((i9 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i9) {
        this.f6796k.f1187p0 = i9;
    }

    public void setType(int i9) {
        this.f6795i = i9;
    }
}
