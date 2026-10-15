package D5;

import T.M;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.google.android.material.textfield.i;
import java.util.ArrayList;

/* JADX INFO: compiled from: DrawableWithAnimatedVisibilityChange.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1926b;

    public /* synthetic */ c(int i9, Object obj) {
        this.f1925a = i9;
        this.f1926b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f1925a) {
            case 1:
                ((M) this.f1926b).c();
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f1925a) {
            case 1:
                ((M) this.f1926b).a();
                break;
            case 2:
            default:
                super.onAnimationEnd(animator);
                break;
            case 3:
                i iVar = (i) this.f1926b;
                iVar.q();
                iVar.f13867r.start();
                break;
            case 4:
                p172w0.d dVar = (p172w0.d) this.f1926b;
                ArrayList arrayList = new ArrayList(dVar.f21974e);
                int size = arrayList.size();
                for (int i9 = 0; i9 < size; i9++) {
                    ((p172w0.c) arrayList.get(i9)).a(dVar);
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f1925a) {
            case 0:
                super.onAnimationStart(animator);
                ArrayList arrayList = ((e) this.f1926b).f1932c;
                break;
            case 1:
                ((M) this.f1926b).b();
                break;
            case 2:
                ((com.google.android.material.textfield.c) this.f1926b).f13896b.h(true);
                break;
            case 3:
            default:
                super.onAnimationStart(animator);
                break;
            case 4:
                p172w0.d dVar = (p172w0.d) this.f1926b;
                ArrayList arrayList2 = new ArrayList(dVar.f21974e);
                int size = arrayList2.size();
                for (int i9 = 0; i9 < size; i9++) {
                    ((p172w0.c) arrayList2.get(i9)).b(dVar);
                }
                break;
        }
    }

    public c(M m8, View view) {
        this.f1925a = 1;
        this.f1926b = m8;
    }
}
