package p147s7;

import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;

/* JADX INFO: compiled from: ImagePickerUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q {
    public static int a(f fVar) {
        int i9 = Build.VERSION.SDK_INT;
        int pickImagesMaxLimit = (i9 >= 33 || (i9 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2)) ? MediaStore.getPickImagesMaxLimit() : Integer.MAX_VALUE;
        Long l8 = fVar.f21317c;
        return (l8 == null || l8.longValue() >= ((long) pickImagesMaxLimit)) ? pickImagesMaxLimit : Math.toIntExact(l8.longValue());
    }
}
