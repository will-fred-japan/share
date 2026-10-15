package p051h;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

/* JADX INFO: compiled from: ActivityResultContract.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<I, O> {

    /* JADX INFO: renamed from: h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityResultContract.kt */
    public static final class C0205a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f18994a;

        public C0205a(T t) {
            this.f18994a = t;
        }
    }

    public abstract Intent a(Context context, Parcelable parcelable);

    public C0205a b(Context context, Parcelable parcelable) {
        return null;
    }

    public abstract O c(int i9, Intent intent);
}
