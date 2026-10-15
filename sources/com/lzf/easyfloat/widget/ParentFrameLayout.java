package com.lzf.easyfloat.widget;

import A6.c;
import A6.f;
import C6.e;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.lzf.easyfloat.data.FloatConfig;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: ParentFrameLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public final class ParentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FloatConfig f16366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f16367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f16368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16369d;

    /* JADX INFO: compiled from: ParentFrameLayout.kt */
    public interface a {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParentFrameLayout(Context context, FloatConfig config) {
        super(context, null, 0);
        k.e(config, "config");
        this.f16366a = config;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        c cVarB;
        FloatConfig floatConfig = this.f16366a;
        if (floatConfig.getHasEditText() && keyEvent != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && (cVarB = f.b(floatConfig.getFloatTag())) != null) {
            cVarB.c().flags = 40;
            cVarB.d().updateViewLayout(cVarB.f1493e, cVarB.c());
            p188x7.k kVar = p188x7.k.f22364a;
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    public final a getLayoutListener() {
        return this.f16368c;
    }

    public final e getTouchListener() {
        return this.f16367b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        V6.c cVar;
        super.onDetachedFromWindow();
        FloatConfig floatConfig = this.f16366a;
        floatConfig.getCallbacks();
        C6.a floatCallbacks = floatConfig.getFloatCallbacks();
        if (floatCallbacks == null || (cVar = floatCallbacks.a().f1804b) == null) {
            return;
        }
        cVar.invoke();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        e eVar;
        if (motionEvent != null && (eVar = this.f16367b) != null) {
            eVar.a(motionEvent);
        }
        return this.f16366a.isDrag() || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        if (this.f16369d) {
            return;
        }
        this.f16369d = true;
        a aVar = this.f16368c;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        e eVar;
        if (motionEvent != null && (eVar = this.f16367b) != null) {
            eVar.a(motionEvent);
        }
        return this.f16366a.isDrag() || super.onTouchEvent(motionEvent);
    }

    public final void setLayoutListener(a aVar) {
        this.f16368c = aVar;
    }

    public final void setTouchListener(e eVar) {
        this.f16367b = eVar;
    }
}
