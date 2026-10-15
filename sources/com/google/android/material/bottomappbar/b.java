package com.google.android.material.bottomappbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: compiled from: BottomAppBar.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends FloatingActionButton.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f12946b;

    /* JADX INFO: compiled from: BottomAppBar.java */
    public class a extends FloatingActionButton.a {
        public a() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
        public final void b() {
            BottomAppBar bottomAppBar = b.this.f12946b;
            int i9 = BottomAppBar.f12921t0;
        }
    }

    public b(BottomAppBar bottomAppBar, int i9) {
        this.f12946b = bottomAppBar;
        this.f12945a = i9;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
    public final void a(FloatingActionButton floatingActionButton) {
        int i9 = BottomAppBar.f12921t0;
        floatingActionButton.setTranslationX(this.f12946b.B(this.f12945a));
        floatingActionButton.j(new a(), true);
    }
}
