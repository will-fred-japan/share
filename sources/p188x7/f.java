package p188x7;

import java.io.Serializable;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f22355a;

    /* JADX INFO: compiled from: Result.kt */
    public static final class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f22356a;

        public a(Throwable exception) {
            k.e(exception, "exception");
            this.f22356a = exception;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                return k.a(this.f22356a, ((a) obj).f22356a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f22356a.hashCode();
        }

        public final String toString() {
            return "Failure(" + this.f22356a + ')';
        }
    }

    public /* synthetic */ f(Object obj) {
        this.f22355a = obj;
    }

    public static final Throwable a(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).f22356a;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return k.a(this.f22355a, ((f) obj).f22355a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f22355a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f22355a;
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
