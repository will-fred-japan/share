package com.google.android.material.internal;

import T.G;
import T.L;
import android.R;
import android.content.Context;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: compiled from: ViewUtils.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13551c;
    }

    public static float a(Context context, int i9) {
        return TypedValue.applyDimension(1, i9, context.getResources().getDisplayMetrics());
    }

    public static ViewGroup b(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static boolean c(View view) {
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        return view.getLayoutDirection() == 1;
    }

    public static PorterDuff.Mode d(int i9, PorterDuff.Mode mode) {
        if (i9 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i9 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i9 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i9) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
