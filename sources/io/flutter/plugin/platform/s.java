package io.flutter.plugin.platform;

import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowMetrics;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: compiled from: SingleViewWindowManager.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s implements WindowManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowManager f19661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f19662b;

    public s(WindowManager windowManager, r rVar) {
        this.f19661a = windowManager;
        this.f19662b = rVar;
    }

    @Override // android.view.WindowManager
    public final void addCrossWindowBlurEnabledListener(Consumer<Boolean> consumer) {
        this.f19661a.addCrossWindowBlurEnabledListener(consumer);
    }

    @Override // android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        r rVar = this.f19662b;
        if (rVar == null) {
            Log.w("PlatformViewsController", "Embedded view called addView while detached from presentation");
        } else {
            rVar.addView(view, layoutParams);
        }
    }

    @Override // android.view.WindowManager
    public final WindowMetrics getCurrentWindowMetrics() {
        return this.f19661a.getCurrentWindowMetrics();
    }

    @Override // android.view.WindowManager
    @Deprecated
    public final Display getDefaultDisplay() {
        return this.f19661a.getDefaultDisplay();
    }

    @Override // android.view.WindowManager
    public final WindowMetrics getMaximumWindowMetrics() {
        return this.f19661a.getMaximumWindowMetrics();
    }

    @Override // android.view.WindowManager
    public final boolean isCrossWindowBlurEnabled() {
        return this.f19661a.isCrossWindowBlurEnabled();
    }

    @Override // android.view.WindowManager
    public final void removeCrossWindowBlurEnabledListener(Consumer<Boolean> consumer) {
        this.f19661a.removeCrossWindowBlurEnabledListener(consumer);
    }

    @Override // android.view.ViewManager
    public final void removeView(View view) {
        r rVar = this.f19662b;
        if (rVar == null) {
            Log.w("PlatformViewsController", "Embedded view called removeView while detached from presentation");
        } else {
            rVar.removeView(view);
        }
    }

    @Override // android.view.WindowManager
    public final void removeViewImmediate(View view) {
        r rVar = this.f19662b;
        if (rVar == null) {
            Log.w("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
        } else {
            view.clearAnimation();
            rVar.removeView(view);
        }
    }

    @Override // android.view.ViewManager
    public final void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        r rVar = this.f19662b;
        if (rVar == null) {
            Log.w("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
        } else {
            rVar.updateViewLayout(view, layoutParams);
        }
    }

    @Override // android.view.WindowManager
    public final void addCrossWindowBlurEnabledListener(Executor executor, Consumer<Boolean> consumer) {
        this.f19661a.addCrossWindowBlurEnabledListener(executor, consumer);
    }
}
