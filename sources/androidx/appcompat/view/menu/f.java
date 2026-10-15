package androidx.appcompat.view.menu;

import T.AbstractC0415b;
import T.H;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: MenuBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements M.a {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f6125z = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f6127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f6130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<h> f6131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<h> f6132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<h> f6134i;
    public final ArrayList<h> j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6135k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f6137m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f6138n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f6139o;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public h f6146w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f6148y;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6136l = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f6140p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6141q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6142r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6143s = false;
    public boolean t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList<h> f6144u = new ArrayList<>();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CopyOnWriteArrayList<WeakReference<j>> f6145v = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f6147x = false;

    /* JADX INFO: compiled from: MenuBuilder.java */
    public interface a {
        boolean a(f fVar, MenuItem menuItem);

        void b(f fVar);
    }

    /* JADX INFO: compiled from: MenuBuilder.java */
    public interface b {
        boolean a(h hVar);
    }

    public f(Context context) {
        boolean zA;
        boolean z8 = false;
        this.f6126a = context;
        Resources resources = context.getResources();
        this.f6127b = resources;
        this.f6131f = new ArrayList<>();
        this.f6132g = new ArrayList<>();
        this.f6133h = true;
        this.f6134i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.f6135k = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            if (Build.VERSION.SDK_INT >= 28) {
                zA = H.a(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                zA = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (zA) {
                z8 = true;
            }
        }
        this.f6129d = z8;
    }

    public final h a(int i9, int i10, int i11, CharSequence charSequence) {
        int i12;
        int i13 = ((-65536) & i11) >> 16;
        if (i13 < 0 || i13 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i14 = (f6125z[i13] << 16) | (65535 & i11);
        h hVar = new h(this, i9, i10, i11, i14, charSequence, this.f6136l);
        ArrayList<h> arrayList = this.f6131f;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f6158d <= i14) {
                i12 = size + 1;
                arrayList.add(i12, hVar);
                p(true);
                return hVar;
            }
        }
        i12 = 0;
        arrayList.add(i12, hVar);
        p(true);
        return hVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i9, int i10, int i11, ComponentName componentName, Intent[] intentArr, Intent intent, int i12, MenuItem[] menuItemArr) {
        int i13;
        PackageManager packageManager = this.f6126a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i12 & 1) == 0) {
            removeGroup(i9);
        }
        for (int i14 = 0; i14 < size; i14++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i14);
            int i15 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i15 < 0 ? intent : intentArr[i15]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            h hVarA = a(i9, i10, i11, resolveInfo.loadLabel(packageManager));
            hVarA.setIcon(resolveInfo.loadIcon(packageManager));
            hVarA.f6161g = intent2;
            if (menuItemArr != null && (i13 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i13] = hVarA;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(j jVar, Context context) {
        this.f6145v.add(new WeakReference<>(jVar));
        jVar.e(context, this);
        this.f6135k = true;
    }

    public final void c(boolean z8) {
        if (this.t) {
            return;
        }
        this.t = true;
        CopyOnWriteArrayList<WeakReference<j>> copyOnWriteArrayList = this.f6145v;
        for (WeakReference<j> weakReference : copyOnWriteArrayList) {
            j jVar = weakReference.get();
            if (jVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                jVar.a(this, z8);
            }
        }
        this.t = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        h hVar = this.f6146w;
        if (hVar != null) {
            d(hVar);
        }
        this.f6131f.clear();
        p(true);
    }

    public final void clearHeader() {
        this.f6138n = null;
        this.f6137m = null;
        this.f6139o = null;
        p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(h hVar) {
        CopyOnWriteArrayList<WeakReference<j>> copyOnWriteArrayList = this.f6145v;
        boolean zC = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f6146w == hVar) {
            w();
            for (WeakReference<j> weakReference : copyOnWriteArrayList) {
                j jVar = weakReference.get();
                if (jVar != null) {
                    zC = jVar.c(hVar);
                    if (zC) {
                        break;
                    }
                } else {
                    copyOnWriteArrayList.remove(weakReference);
                }
            }
            v();
            if (zC) {
                this.f6146w = null;
            }
        }
        return zC;
    }

    public boolean e(f fVar, MenuItem menuItem) {
        a aVar = this.f6130e;
        return aVar != null && aVar.a(fVar, menuItem);
    }

    public boolean f(h hVar) {
        CopyOnWriteArrayList<WeakReference<j>> copyOnWriteArrayList = this.f6145v;
        boolean zK = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        w();
        for (WeakReference<j> weakReference : copyOnWriteArrayList) {
            j jVar = weakReference.get();
            if (jVar != null) {
                zK = jVar.k(hVar);
                if (zK) {
                    break;
                }
            } else {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
        v();
        if (zK) {
            this.f6146w = hVar;
        }
        return zK;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i9) {
        MenuItem menuItemFindItem;
        ArrayList<h> arrayList = this.f6131f;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            h hVar = arrayList.get(i10);
            if (hVar.f6155a == i9) {
                return hVar;
            }
            if (hVar.hasSubMenu() && (menuItemFindItem = hVar.f6168o.findItem(i9)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final h g(int i9, KeyEvent keyEvent) {
        ArrayList<h> arrayList = this.f6144u;
        arrayList.clear();
        h(arrayList, i9, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zN = n();
        for (int i10 = 0; i10 < size; i10++) {
            h hVar = arrayList.get(i10);
            char c5 = zN ? hVar.j : hVar.f6162h;
            char[] cArr = keyData.meta;
            if ((c5 == cArr[0] && (metaState & 2) == 0) || ((c5 == cArr[2] && (metaState & 2) != 0) || (zN && c5 == '\b' && i9 == 67))) {
                return hVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i9) {
        return this.f6131f.get(i9);
    }

    public final void h(ArrayList arrayList, int i9, KeyEvent keyEvent) {
        boolean zN = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i9 == 67) {
            ArrayList<h> arrayList2 = this.f6131f;
            int size = arrayList2.size();
            for (int i10 = 0; i10 < size; i10++) {
                h hVar = arrayList2.get(i10);
                if (hVar.hasSubMenu()) {
                    hVar.f6168o.h(arrayList, i9, keyEvent);
                }
                char c5 = zN ? hVar.j : hVar.f6162h;
                if ((modifiers & 69647) == ((zN ? hVar.f6164k : hVar.f6163i) & 69647) && c5 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c5 == cArr[0] || c5 == cArr[2] || (zN && c5 == '\b' && i9 == 67)) && hVar.isEnabled()) {
                        arrayList.add(hVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f6148y) {
            return true;
        }
        ArrayList<h> arrayList = this.f6131f;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            if (arrayList.get(i9).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList<h> arrayListL = l();
        if (this.f6135k) {
            CopyOnWriteArrayList<WeakReference<j>> copyOnWriteArrayList = this.f6145v;
            boolean zI = false;
            for (WeakReference<j> weakReference : copyOnWriteArrayList) {
                j jVar = weakReference.get();
                if (jVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zI |= jVar.i();
                }
            }
            ArrayList<h> arrayList = this.f6134i;
            ArrayList<h> arrayList2 = this.j;
            if (zI) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListL.size();
                for (int i9 = 0; i9 < size; i9++) {
                    h hVar = arrayListL.get(i9);
                    if ((hVar.f6176x & 32) == 32) {
                        arrayList.add(hVar);
                    } else {
                        arrayList2.add(hVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(l());
            }
            this.f6135k = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i9, KeyEvent keyEvent) {
        return g(i9, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public final ArrayList<h> l() {
        boolean z8 = this.f6133h;
        ArrayList<h> arrayList = this.f6132g;
        if (!z8) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList<h> arrayList2 = this.f6131f;
        int size = arrayList2.size();
        for (int i9 = 0; i9 < size; i9++) {
            h hVar = arrayList2.get(i9);
            if (hVar.isVisible()) {
                arrayList.add(hVar);
            }
        }
        this.f6133h = false;
        this.f6135k = true;
        return arrayList;
    }

    public boolean m() {
        return this.f6147x;
    }

    public boolean n() {
        return this.f6128c;
    }

    public boolean o() {
        return this.f6129d;
    }

    public final void p(boolean z8) {
        if (this.f6140p) {
            this.f6141q = true;
            if (z8) {
                this.f6142r = true;
                return;
            }
            return;
        }
        if (z8) {
            this.f6133h = true;
            this.f6135k = true;
        }
        CopyOnWriteArrayList<WeakReference<j>> copyOnWriteArrayList = this.f6145v;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        w();
        for (WeakReference<j> weakReference : copyOnWriteArrayList) {
            j jVar = weakReference.get();
            if (jVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                jVar.f();
            }
        }
        v();
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i9, int i10) {
        return q(findItem(i9), null, i10);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i9, KeyEvent keyEvent, int i10) {
        h hVarG = g(i9, keyEvent);
        boolean zQ = hVarG != null ? q(hVarG, null, i10) : false;
        if ((i10 & 2) != 0) {
            c(true);
        }
        return zQ;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0018  */
    /* JADX WARN: Code duplicated, block: B:32:0x004d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0054  */
    /* JADX WARN: Code duplicated, block: B:37:0x005b  */
    /* JADX WARN: Code duplicated, block: B:38:0x0060  */
    /* JADX WARN: Code duplicated, block: B:45:0x0071  */
    /* JADX WARN: Code duplicated, block: B:47:0x0075  */
    /* JADX WARN: Code duplicated, block: B:50:0x007e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x00c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x00a6 A[SYNTHETIC] */
    public final boolean q(MenuItem menuItem, j jVar, int i9) {
        AbstractC0415b abstractC0415b;
        boolean zExpandActionView;
        AbstractC0415b abstractC0415b2;
        boolean z8;
        m mVar;
        CopyOnWriteArrayList<WeakReference<j>> copyOnWriteArrayList;
        j jVar2;
        h hVar = (h) menuItem;
        boolean zH = false;
        if (hVar == null || !hVar.isEnabled()) {
            return false;
        }
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = hVar.f6169p;
        if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(hVar)) {
            f fVar = hVar.f6167n;
            if (fVar.e(fVar, hVar)) {
                zExpandActionView = true;
            } else {
                Intent intent = hVar.f6161g;
                if (intent != null) {
                    try {
                        fVar.f6126a.startActivity(intent);
                    } catch (ActivityNotFoundException e9) {
                        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e9);
                        abstractC0415b = hVar.f6152A;
                        if (abstractC0415b == null) {
                        }
                        zExpandActionView = false;
                        abstractC0415b2 = hVar.f6152A;
                        if (abstractC0415b2 == null) {
                            z8 = false;
                        } else {
                            z8 = false;
                        }
                        if (hVar.e()) {
                            zExpandActionView |= hVar.expandActionView();
                            if (zExpandActionView) {
                                c(true);
                            }
                        } else if (hVar.hasSubMenu()) {
                            if ((i9 & 4) == 0) {
                                c(false);
                            }
                            if (!hVar.hasSubMenu()) {
                                m mVar2 = new m(this.f6126a, this, hVar);
                                hVar.f6168o = mVar2;
                                mVar2.setHeaderTitle(hVar.f6159e);
                            }
                            mVar = hVar.f6168o;
                            if (z8) {
                                abstractC0415b2.f(mVar);
                            }
                            copyOnWriteArrayList = this.f6145v;
                            if (!copyOnWriteArrayList.isEmpty()) {
                                if (jVar != null) {
                                }
                                for (WeakReference<j> weakReference : copyOnWriteArrayList) {
                                    jVar2 = weakReference.get();
                                    if (jVar2 == null) {
                                        copyOnWriteArrayList.remove(weakReference);
                                    } else if (!zH) {
                                        zH = jVar2.h(mVar);
                                    }
                                }
                            }
                            zExpandActionView |= zH;
                            if (!zExpandActionView) {
                                c(true);
                            }
                        } else {
                            if ((i9 & 4) == 0) {
                                c(false);
                            }
                            if (!hVar.hasSubMenu()) {
                                m mVar3 = new m(this.f6126a, this, hVar);
                                hVar.f6168o = mVar3;
                                mVar3.setHeaderTitle(hVar.f6159e);
                            }
                            mVar = hVar.f6168o;
                            if (z8) {
                                abstractC0415b2.f(mVar);
                            }
                            copyOnWriteArrayList = this.f6145v;
                            if (!copyOnWriteArrayList.isEmpty()) {
                                zH = jVar != null ? jVar.h(mVar) : false;
                                while (r8.hasNext()) {
                                    jVar2 = weakReference.get();
                                    if (jVar2 == null) {
                                        copyOnWriteArrayList.remove(weakReference);
                                    } else if (!zH) {
                                        zH = jVar2.h(mVar);
                                    }
                                }
                            }
                            zExpandActionView |= zH;
                            if (!zExpandActionView) {
                                c(true);
                            }
                        }
                        return zExpandActionView;
                    }
                    zExpandActionView = true;
                } else {
                    abstractC0415b = hVar.f6152A;
                    if (abstractC0415b == null && abstractC0415b.e()) {
                        zExpandActionView = true;
                    } else {
                        zExpandActionView = false;
                    }
                }
            }
        } else {
            zExpandActionView = true;
        }
        abstractC0415b2 = hVar.f6152A;
        if (abstractC0415b2 == null && abstractC0415b2.a()) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (hVar.e()) {
            zExpandActionView |= hVar.expandActionView();
            if (zExpandActionView) {
                c(true);
            }
        } else if (hVar.hasSubMenu() || z8) {
            if ((i9 & 4) == 0) {
                c(false);
            }
            if (!hVar.hasSubMenu()) {
                m mVar4 = new m(this.f6126a, this, hVar);
                hVar.f6168o = mVar4;
                mVar4.setHeaderTitle(hVar.f6159e);
            }
            mVar = hVar.f6168o;
            if (z8) {
                abstractC0415b2.f(mVar);
            }
            copyOnWriteArrayList = this.f6145v;
            if (!copyOnWriteArrayList.isEmpty()) {
                if (jVar != null) {
                }
                while (r8.hasNext()) {
                    jVar2 = weakReference.get();
                    if (jVar2 == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else if (!zH) {
                        zH = jVar2.h(mVar);
                    }
                }
            }
            zExpandActionView |= zH;
            if (!zExpandActionView) {
                c(true);
            }
        } else if ((i9 & 1) == 0) {
            c(true);
        }
        return zExpandActionView;
    }

    public final void r(j jVar) {
        CopyOnWriteArrayList<WeakReference<j>> copyOnWriteArrayList = this.f6145v;
        for (WeakReference<j> weakReference : copyOnWriteArrayList) {
            j jVar2 = weakReference.get();
            if (jVar2 == null || jVar2 == jVar) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i9) {
        ArrayList<h> arrayList = this.f6131f;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (arrayList.get(i11).f6156b == i9) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 >= 0) {
            int size2 = arrayList.size() - i11;
            while (true) {
                int i12 = i10 + 1;
                if (i10 >= size2 || arrayList.get(i11).f6156b != i9) {
                    break;
                }
                if (i11 >= 0) {
                    ArrayList<h> arrayList2 = this.f6131f;
                    if (i11 < arrayList2.size()) {
                        arrayList2.remove(i11);
                    }
                }
                i10 = i12;
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i9) {
        ArrayList<h> arrayList = this.f6131f;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (arrayList.get(i10).f6155a == i9) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0) {
            ArrayList<h> arrayList2 = this.f6131f;
            if (i10 >= arrayList2.size()) {
                return;
            }
            arrayList2.remove(i10);
            p(true);
        }
    }

    public final void s(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
        int size = this.f6131f.size();
        for (int i9 = 0; i9 < size; i9++) {
            MenuItem item = getItem(i9);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).s(bundle);
            }
        }
        int i10 = bundle.getInt("android:menu:expandedactionview");
        if (i10 <= 0 || (menuItemFindItem = findItem(i10)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i9, boolean z8, boolean z9) {
        ArrayList<h> arrayList = this.f6131f;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            h hVar = arrayList.get(i10);
            if (hVar.f6156b == i9) {
                hVar.f6176x = (hVar.f6176x & (-5)) | (z9 ? 4 : 0);
                hVar.setCheckable(z8);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z8) {
        this.f6147x = z8;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i9, boolean z8) {
        ArrayList<h> arrayList = this.f6131f;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            h hVar = arrayList.get(i10);
            if (hVar.f6156b == i9) {
                hVar.setEnabled(z8);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i9, boolean z8) {
        ArrayList<h> arrayList = this.f6131f;
        int size = arrayList.size();
        boolean z9 = false;
        for (int i10 = 0; i10 < size; i10++) {
            h hVar = arrayList.get(i10);
            if (hVar.f6156b == i9) {
                int i11 = hVar.f6176x;
                int i12 = (i11 & (-9)) | (z8 ? 0 : 8);
                hVar.f6176x = i12;
                if (i11 != i12) {
                    z9 = true;
                }
            }
        }
        if (z9) {
            p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z8) {
        this.f6128c = z8;
        p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f6131f.size();
    }

    public final void t(Bundle bundle) {
        int size = this.f6131f.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i9 = 0; i9 < size; i9++) {
            MenuItem item = getItem(i9);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).t(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void u(int i9, CharSequence charSequence, int i10, Drawable drawable, View view) {
        if (view != null) {
            this.f6139o = view;
            this.f6137m = null;
            this.f6138n = null;
        } else {
            if (i9 > 0) {
                this.f6137m = this.f6127b.getText(i9);
            } else if (charSequence != null) {
                this.f6137m = charSequence;
            }
            if (i10 > 0) {
                this.f6138n = this.f6126a.getDrawable(i10);
            } else if (drawable != null) {
                this.f6138n = drawable;
            }
            this.f6139o = null;
        }
        p(false);
    }

    public final void v() {
        this.f6140p = false;
        if (this.f6141q) {
            this.f6141q = false;
            p(this.f6142r);
        }
    }

    public final void w() {
        if (this.f6140p) {
            return;
        }
        this.f6140p = true;
        this.f6141q = false;
        this.f6142r = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i9) {
        return a(0, 0, 0, this.f6127b.getString(i9));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i9) {
        return addSubMenu(0, 0, 0, this.f6127b.getString(i9));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i9, int i10, int i11, CharSequence charSequence) {
        return a(i9, i10, i11, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i9, int i10, int i11, CharSequence charSequence) {
        h hVarA = a(i9, i10, i11, charSequence);
        m mVar = new m(this.f6126a, this, hVarA);
        hVarA.f6168o = mVar;
        mVar.setHeaderTitle(hVarA.f6159e);
        return mVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i9, int i10, int i11, int i12) {
        return a(i9, i10, i11, this.f6127b.getString(i12));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i9, int i10, int i11, int i12) {
        return addSubMenu(i9, i10, i11, this.f6127b.getString(i12));
    }

    public f k() {
        return this;
    }
}
