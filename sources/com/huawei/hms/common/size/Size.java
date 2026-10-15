package com.huawei.hms.common.size;

import W5.e;
import com.huawei.hms.common.internal.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Size {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14991b;

    public Size(int i9, int i10) {
        this.f14990a = i9;
        this.f14991b = i10;
    }

    public static Size parseSize(String str) {
        try {
            int iIndexOf = str.indexOf("x");
            if (iIndexOf < 0) {
                iIndexOf = str.indexOf("*");
            }
            return new Size(Integer.parseInt(str.substring(0, iIndexOf)), Integer.parseInt(str.substring(iIndexOf + 1)));
        } catch (Exception unused) {
            throw new IllegalArgumentException("Size parses failed");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.f14990a == size.f14990a && this.f14991b == size.f14991b) {
                return true;
            }
        }
        return false;
    }

    public final int getHeight() {
        return this.f14991b;
    }

    public final int getWidth() {
        return this.f14990a;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
    }

    public final String toString() {
        return e.h(this.f14990a, this.f14991b, "Width is ", " Height is ");
    }
}
