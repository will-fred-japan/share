package p136r5;

import U.h;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: BottomSheetBehavior.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f21156b;

    public c(BottomSheetBehavior bottomSheetBehavior, int i9) {
        this.f21156b = bottomSheetBehavior;
        this.f21155a = i9;
    }

    @Override // U.h
    public final boolean c(View view) {
        this.f21156b.E(this.f21155a);
        return true;
    }
}
