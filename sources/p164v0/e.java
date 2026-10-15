package p164v0;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.util.Property;

/* JADX INFO: compiled from: ObjectAnimatorUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static <T, V> ObjectAnimator a(T t, Property<T, V> property, Path path) {
        return ObjectAnimator.ofObject(t, property, (TypeConverter) null, path);
    }
}
