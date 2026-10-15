package p089m;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* JADX INFO: compiled from: ContextThemeWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends ContextWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Configuration f20243f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources.Theme f20245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f20246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Configuration f20247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Resources f20248e;

    public c() {
        super(null);
    }

    public final void a(Configuration configuration) {
        if (this.f20248e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f20247d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f20247d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f20245b == null) {
            this.f20245b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f20245b.setTo(theme);
            }
        }
        this.f20245b.applyStyle(this.f20244a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        if (this.f20248e == null) {
            Configuration configuration = this.f20247d;
            if (configuration == null) {
                this.f20248e = super.getResources();
            } else {
                if (f20243f == null) {
                    Configuration configuration2 = new Configuration();
                    configuration2.fontScale = 0.0f;
                    f20243f = configuration2;
                }
                if (configuration.equals(f20243f)) {
                    this.f20248e = super.getResources();
                } else {
                    this.f20248e = createConfigurationContext(this.f20247d).getResources();
                }
            }
        }
        return this.f20248e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f20246c == null) {
            this.f20246c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f20246c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f20245b;
        if (theme != null) {
            return theme;
        }
        if (this.f20244a == 0) {
            this.f20244a = 2131886662;
        }
        b();
        return this.f20245b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i9) {
        if (this.f20244a != i9) {
            this.f20244a = i9;
            b();
        }
    }

    public c(Context context, int i9) {
        super(context);
        this.f20244a = i9;
    }
}
