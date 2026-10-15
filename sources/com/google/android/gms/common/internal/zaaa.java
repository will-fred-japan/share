package com.google.android.gms.common.internal;

import W5.e;
import android.widget.Button;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zaaa extends Button {
    public static final int a(int i9, int i10, int i11, int i12) {
        if (i9 == 0) {
            return i10;
        }
        if (i9 == 1) {
            return i11;
        }
        if (i9 == 2) {
            return i12;
        }
        throw new IllegalStateException(e.i(i9, "Unknown color scheme: "));
    }
}
