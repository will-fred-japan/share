package p130r;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.TextUtils;
import java.util.ArrayList;
import p142s2.j;

/* JADX INFO: compiled from: CustomTabsIntent.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f21070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f21071b;

    /* JADX INFO: compiled from: CustomTabsIntent.java */
    public static class a {
        public static void a(ActivityOptions activityOptions) {
            activityOptions.setShareIdentityEnabled(false);
        }
    }

    /* JADX INFO: compiled from: CustomTabsIntent.java */
    public static class b {
        public static void a(ActivityOptions activityOptions, boolean z8) {
            activityOptions.setAllowPassThroughOnTouchOutside(z8);
        }
    }

    public e(Intent intent, Bundle bundle) {
        this.f21070a = intent;
        this.f21071b = bundle;
    }

    /* JADX INFO: compiled from: CustomTabsIntent.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f21072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j f21073b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList<Bundle> f21074c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ActivityOptions f21075d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bundle f21076e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f21077f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f21078g;

        public c() {
            this.f21072a = new Intent("android.intent.action.VIEW");
            this.f21073b = new j();
            this.f21077f = 0;
            this.f21078g = true;
        }

        public final e a() {
            Intent intent = this.f21072a;
            if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
                Bundle bundle = new Bundle();
                bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                intent.putExtras(bundle);
            }
            ArrayList<Bundle> arrayList = this.f21074c;
            if (arrayList != null) {
                intent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f21078g);
            this.f21073b.getClass();
            intent.putExtras(new Bundle());
            Bundle bundle2 = this.f21076e;
            if (bundle2 != null) {
                intent.putExtras(bundle2);
            }
            intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f21077f);
            int i9 = Build.VERSION.SDK_INT;
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            String languageTag = adjustedDefault.size() > 0 ? adjustedDefault.get(0).toLanguageTag() : null;
            if (!TextUtils.isEmpty(languageTag)) {
                Bundle bundleExtra = intent.hasExtra("com.android.browser.headers") ? intent.getBundleExtra("com.android.browser.headers") : new Bundle();
                if (!bundleExtra.containsKey("Accept-Language")) {
                    bundleExtra.putString("Accept-Language", languageTag);
                    intent.putExtra("com.android.browser.headers", bundleExtra);
                }
            }
            if (i9 >= 34) {
                if (this.f21075d == null) {
                    this.f21075d = ActivityOptions.makeBasic();
                }
                a.a(this.f21075d);
            }
            if (i9 >= 36) {
                if (this.f21075d == null) {
                    this.f21075d = ActivityOptions.makeBasic();
                }
                b.a(this.f21075d, !intent.getBooleanExtra("androidx.browser.customtabs.extra.DISABLE_BACKGROUND_INTERACTION", false));
            }
            ActivityOptions activityOptions = this.f21075d;
            return new e(intent, activityOptions != null ? activityOptions.toBundle() : null);
        }

        public final void b(int i9) {
            if (i9 < 0 || i9 > 2) {
                throw new IllegalArgumentException("Invalid value for the shareState argument");
            }
            this.f21077f = i9;
            Intent intent = this.f21072a;
            if (i9 == 1) {
                intent.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", true);
            } else if (i9 == 2) {
                intent.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", false);
            } else {
                intent.removeExtra("android.support.customtabs.extra.SHARE_MENU_ITEM");
            }
        }

        public c(j jVar) {
            Intent intent = new Intent("android.intent.action.VIEW");
            this.f21072a = intent;
            this.f21073b = new j();
            this.f21077f = 0;
            this.f21078g = true;
            if (jVar != null) {
                intent.setPackage(jVar.f21088d.getPackageName());
                p130r.c cVar = jVar.f21087c;
                Bundle bundle = new Bundle();
                bundle.putBinder("android.support.customtabs.extra.SESSION", cVar);
                intent.putExtras(bundle);
            }
        }
    }
}
