package p060i0;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Violation.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class d extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f19205a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Fragment fragment, String str) {
        super(str);
        k.e(fragment, "fragment");
        this.f19205a = fragment;
    }
}
