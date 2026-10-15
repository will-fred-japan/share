package p089m;

import M.b;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.f;
import java.util.ArrayList;
import p097n.c;
import p155u.g;

/* JADX INFO: compiled from: SupportActionModeWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p089m.a f20256b;

    /* JADX INFO: compiled from: SupportActionModeWrapper.java */
    public static class a implements p089m.a.InterfaceC0228a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f20257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f20258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<e> f20259c = new ArrayList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final g<Menu, Menu> f20260d = new g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f20258b = context;
            this.f20257a = callback;
        }

        @Override // p089m.a.InterfaceC0228a
        public final boolean a(p089m.a aVar, f fVar) {
            e eVarE = e(aVar);
            g<Menu, Menu> gVar = this.f20260d;
            Menu eVar = gVar.get(fVar);
            if (eVar == null) {
                eVar = new p097n.e(this.f20258b, fVar);
                gVar.put(fVar, eVar);
            }
            return this.f20257a.onCreateActionMode(eVarE, eVar);
        }

        @Override // p089m.a.InterfaceC0228a
        public final void b(p089m.a aVar) {
            this.f20257a.onDestroyActionMode(e(aVar));
        }

        @Override // p089m.a.InterfaceC0228a
        public final boolean c(p089m.a aVar, MenuItem menuItem) {
            return this.f20257a.onActionItemClicked(e(aVar), new c(this.f20258b, (b) menuItem));
        }

        @Override // p089m.a.InterfaceC0228a
        public final boolean d(p089m.a aVar, f fVar) {
            e eVarE = e(aVar);
            g<Menu, Menu> gVar = this.f20260d;
            Menu eVar = gVar.get(fVar);
            if (eVar == null) {
                eVar = new p097n.e(this.f20258b, fVar);
                gVar.put(fVar, eVar);
            }
            return this.f20257a.onPrepareActionMode(eVarE, eVar);
        }

        public final e e(p089m.a aVar) {
            ArrayList<e> arrayList = this.f20259c;
            int size = arrayList.size();
            for (int i9 = 0; i9 < size; i9++) {
                e eVar = arrayList.get(i9);
                if (eVar != null && eVar.f20256b == aVar) {
                    return eVar;
                }
            }
            e eVar2 = new e(this.f20258b, aVar);
            arrayList.add(eVar2);
            return eVar2;
        }
    }

    public e(Context context, p089m.a aVar) {
        this.f20255a = context;
        this.f20256b = aVar;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f20256b.c();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f20256b.d();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new p097n.e(this.f20255a, this.f20256b.e());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f20256b.f();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f20256b.g();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f20256b.f20241a;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f20256b.h();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f20256b.f20242b;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f20256b.i();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f20256b.j();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f20256b.k(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f20256b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f20256b.f20241a = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f20256b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z8) {
        this.f20256b.p(z8);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i9) {
        this.f20256b.l(i9);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i9) {
        this.f20256b.n(i9);
    }
}
