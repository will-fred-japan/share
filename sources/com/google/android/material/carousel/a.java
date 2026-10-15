package com.google.android.material.carousel;

/* JADX INFO: compiled from: CarouselStrategyHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static float a(float f6, float f9, int i9) {
        return (Math.max(0, i9 - 1) * f9) + f6;
    }

    public static float b(float f6, float f9, int i9) {
        return i9 > 0 ? (f9 / 2.0f) + f6 : f6;
    }

    public static float c(int i9, float f6, float f9, float f10) {
        return i9 > 0 ? (f10 / 2.0f) + f9 : f6;
    }
}
