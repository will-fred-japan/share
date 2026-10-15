package androidx.core.view.insets;

import W.a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.ikaile.ruoshui.client.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ProtectionLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f7081a = new Object();

    private a getOrInstallSystemBarStateMonitor() {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(R.id.tag_system_bar_state_monitor);
        if (tag instanceof a) {
            return (a) tag;
        }
        a aVar = new a(viewGroup);
        viewGroup.setTag(R.id.tag_system_bar_state_monitor, aVar);
        return aVar;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i9, ViewGroup.LayoutParams layoutParams) {
        int childCount;
        if (view != null && view.getTag() != f7081a && (i9 > (childCount = getChildCount()) || i9 < 0)) {
            i9 = childCount;
        }
        super.addView(view, i9, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(R.id.tag_system_bar_state_monitor);
        if (tag instanceof a) {
            a aVar = (a) tag;
            if (aVar.f4986b.isEmpty()) {
                aVar.f4985a.post(new D6.a(7, aVar));
                viewGroup.setTag(R.id.tag_system_bar_state_monitor, null);
            }
        }
    }

    public void setProtections(List<Object> list) {
        throw null;
    }
}
