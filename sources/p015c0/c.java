package p015c0;

import java.util.Map;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Preferences.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: compiled from: Preferences.kt */
    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8671a;

        public a(String name) {
            k.e(name, "name");
            this.f8671a = name;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            return k.a(this.f8671a, ((a) obj).f8671a);
        }

        public final int hashCode() {
            return this.f8671a.hashCode();
        }

        public final String toString() {
            return this.f8671a;
        }
    }

    /* JADX INFO: compiled from: Preferences.kt */
    public static final class b<T> {
    }

    public abstract Map<a<?>, Object> a();

    public abstract <T> T b(a<T> aVar);
}
