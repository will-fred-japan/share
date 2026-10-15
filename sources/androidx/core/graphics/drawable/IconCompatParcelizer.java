package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.charset.Charset;
import p181x0.a;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f7072a = aVar.j(iconCompat.f7072a, 1);
        byte[] bArrF = iconCompat.f7074c;
        if (aVar.h(2)) {
            bArrF = aVar.f();
        }
        iconCompat.f7074c = bArrF;
        Parcelable parcelableK = iconCompat.f7075d;
        if (aVar.h(3)) {
            parcelableK = aVar.k();
        }
        iconCompat.f7075d = parcelableK;
        iconCompat.f7076e = aVar.j(iconCompat.f7076e, 4);
        iconCompat.f7077f = aVar.j(iconCompat.f7077f, 5);
        Parcelable parcelableK2 = iconCompat.f7078g;
        if (aVar.h(6)) {
            parcelableK2 = aVar.k();
        }
        iconCompat.f7078g = (ColorStateList) parcelableK2;
        String strL = iconCompat.f7080i;
        if (aVar.h(7)) {
            strL = aVar.l();
        }
        iconCompat.f7080i = strL;
        String strL2 = iconCompat.j;
        if (aVar.h(8)) {
            strL2 = aVar.l();
        }
        iconCompat.j = strL2;
        iconCompat.f7079h = PorterDuff.Mode.valueOf(iconCompat.f7080i);
        switch (iconCompat.f7072a) {
            case -1:
                Parcelable parcelable = iconCompat.f7075d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f7073b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f7075d;
                if (parcelable2 != null) {
                    iconCompat.f7073b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr = iconCompat.f7074c;
                iconCompat.f7073b = bArr;
                iconCompat.f7072a = 3;
                iconCompat.f7076e = 0;
                iconCompat.f7077f = bArr.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.f7074c, Charset.forName("UTF-16"));
                iconCompat.f7073b = str;
                if (iconCompat.f7072a == 2 && iconCompat.j == null) {
                    iconCompat.j = str.split(Constants.COLON_SEPARATOR, -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f7073b = iconCompat.f7074c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.getClass();
        iconCompat.f7080i = iconCompat.f7079h.name();
        switch (iconCompat.f7072a) {
            case -1:
                iconCompat.f7075d = (Parcelable) iconCompat.f7073b;
                break;
            case 1:
            case 5:
                iconCompat.f7075d = (Parcelable) iconCompat.f7073b;
                break;
            case 2:
                iconCompat.f7074c = ((String) iconCompat.f7073b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f7074c = (byte[]) iconCompat.f7073b;
                break;
            case 4:
            case 6:
                iconCompat.f7074c = iconCompat.f7073b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i9 = iconCompat.f7072a;
        if (-1 != i9) {
            aVar.s(i9, 1);
        }
        byte[] bArr = iconCompat.f7074c;
        if (bArr != null) {
            aVar.n(2);
            aVar.p(bArr);
        }
        Parcelable parcelable = iconCompat.f7075d;
        if (parcelable != null) {
            aVar.n(3);
            aVar.t(parcelable);
        }
        int i10 = iconCompat.f7076e;
        if (i10 != 0) {
            aVar.s(i10, 4);
        }
        int i11 = iconCompat.f7077f;
        if (i11 != 0) {
            aVar.s(i11, 5);
        }
        ColorStateList colorStateList = iconCompat.f7078g;
        if (colorStateList != null) {
            aVar.n(6);
            aVar.t(colorStateList);
        }
        String str = iconCompat.f7080i;
        if (str != null) {
            aVar.n(7);
            aVar.u(str);
        }
        String str2 = iconCompat.j;
        if (str2 != null) {
            aVar.n(8);
            aVar.u(str2);
        }
    }
}
