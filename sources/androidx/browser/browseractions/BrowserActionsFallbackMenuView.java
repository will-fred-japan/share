package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6738b;

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6737a = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_min_padding);
        this.f6738b = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_max_width);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f6737a * 2), this.f6738b), 1073741824), i10);
    }
}
