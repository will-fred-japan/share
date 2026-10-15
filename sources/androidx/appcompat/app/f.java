package androidx.appcompat.app;

import G.G;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.P;
import androidx.appcompat.widget.Toolbar;
import cn.ikaile.ruoshui.client.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: AppCompatActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends androidx.fragment.app.g implements g, G.a {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private i mDelegate;
    private Resources mResources;

    /* JADX INFO: compiled from: AppCompatActivity.java */
    public class a implements p131r0.b.InterfaceC0248b {
        public a() {
        }

        @Override // p131r0.b.InterfaceC0248b
        public final Bundle a() {
            Bundle bundle = new Bundle();
            f.this.getDelegate().getClass();
            return bundle;
        }
    }

    /* JADX INFO: compiled from: AppCompatActivity.java */
    public class b implements p037f.b {
        public b() {
        }

        @Override // p037f.b
        public final void a(p030e.h hVar) {
            f fVar = f.this;
            i delegate = fVar.getDelegate();
            delegate.k();
            fVar.getSavedStateRegistry().a(f.DELEGATE_TAG);
            delegate.o();
        }
    }

    public f() {
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().c(DELEGATE_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private void initViewTreeOwners() {
        p199z2.b.J(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.k.e(decorView, "<this>");
        decorView.setTag(R.id.view_tree_view_model_store_owner, this);
        p011b4.h.G(getWindow().getDecorView(), this);
        A1.b.p1(getWindow().getDecorView(), this);
    }

    private boolean performMenuItemShortcut(KeyEvent keyEvent) {
        return false;
    }

    @Override // p030e.h, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().c(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().d(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.a()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // G.h, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.l(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i9) {
        return (T) getDelegate().e(i9);
    }

    public i getDelegate() {
        if (this.mDelegate == null) {
            i.c cVar = i.f5953a;
            this.mDelegate = new AppCompatDelegateImpl(this, null, this, this);
        }
        return this.mDelegate;
    }

    public androidx.appcompat.app.b getDrawerToggleDelegate() {
        return getDelegate().g();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return getDelegate().i();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.mResources;
        if (resources == null) {
            int i9 = P.f6463a;
        }
        return resources == null ? super.getResources() : resources;
    }

    public androidx.appcompat.app.a getSupportActionBar() {
        return getDelegate().j();
    }

    @Override // G.G.a
    public Intent getSupportParentActivityIntent() {
        return G.j.a(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().l();
    }

    @Override // p030e.h, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getDelegate().n(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(G g4) {
        g4.getClass();
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = G.j.a(this);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            f fVar = g4.f2066b;
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(fVar.getPackageManager());
            }
            ArrayList<Intent> arrayList = g4.f2065a;
            int size = arrayList.size();
            try {
                for (Intent intentB = G.j.b(fVar, component); intentB != null; intentB = G.j.b(fVar, intentB.getComponent())) {
                    arrayList.add(size, intentB);
                }
                arrayList.add(supportParentActivityIntent);
            } catch (PackageManager.NameNotFoundException e9) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e9);
            }
        }
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().p();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i9, KeyEvent keyEvent) {
        if (performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i9, keyEvent);
    }

    @Override // androidx.fragment.app.g, p030e.h, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i9, MenuItem menuItem) {
        if (super.onMenuItemSelected(i9, menuItem)) {
            return true;
        }
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.d() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i9, Menu menu) {
        return super.onMenuOpened(i9, menu);
    }

    @Override // p030e.h, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i9, Menu menu) {
        super.onPanelClosed(i9, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().q();
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().r();
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    public void onStart() {
        super.onStart();
        getDelegate().s();
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    public void onStop() {
        super.onStop();
        getDelegate().t();
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (!supportShouldUpRecreateTask(supportParentActivityIntent)) {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
        G g4 = new G(this);
        onCreateSupportNavigateUpTaskStack(g4);
        onPrepareSupportNavigateUpTaskStack(g4);
        ArrayList<Intent> arrayList = g4.f2065a;
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        g4.f2066b.startActivities(intentArr, null);
        try {
            finishAffinity();
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i9) {
        super.onTitleChanged(charSequence, i9);
        getDelegate().B(charSequence);
    }

    @Override // androidx.appcompat.app.g
    public p089m.a onWindowStartingSupportActionMode(p089m.a.InterfaceC0228a interfaceC0228a) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.m()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // p030e.h, android.app.Activity
    public void setContentView(int i9) {
        initViewTreeOwners();
        getDelegate().w(i9);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().z(toolbar);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i9) {
        super.setTheme(i9);
        getDelegate().A(i9);
    }

    public p089m.a startSupportActionMode(p089m.a.InterfaceC0228a interfaceC0228a) {
        return getDelegate().C(interfaceC0228a);
    }

    @Override // androidx.fragment.app.g
    public void supportInvalidateOptionsMenu() {
        getDelegate().l();
    }

    public void supportNavigateUpTo(Intent intent) {
        navigateUpTo(intent);
    }

    public boolean supportRequestWindowFeature(int i9) {
        return getDelegate().v(i9);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return shouldUpRecreateTask(intent);
    }

    public f(int i9) {
        super(i9);
        initDelegate();
    }

    @Override // p030e.h, android.app.Activity
    public void setContentView(View view) {
        initViewTreeOwners();
        getDelegate().x(view);
    }

    @Override // p030e.h, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().y(view, layoutParams);
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public void onLocalesChanged(P.d dVar) {
    }

    public void onNightModeChanged(int i9) {
    }

    public void onPrepareSupportNavigateUpTaskStack(G g4) {
    }

    @Override // androidx.appcompat.app.g
    public void onSupportActionModeFinished(p089m.a aVar) {
    }

    @Override // androidx.appcompat.app.g
    public void onSupportActionModeStarted(p089m.a aVar) {
    }

    @Deprecated
    public void setSupportProgress(int i9) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z8) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z8) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z8) {
    }
}
