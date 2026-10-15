package A6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import com.lzf.easyfloat.data.FloatConfig;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: TouchUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FloatConfig f1512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f1513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1516f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1517g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1518h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1519i;
    public float j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f1520k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1521l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1522m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1523n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1524o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1525p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1526q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int[] f1527r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1528s;
    public int t;

    public h(Context context, FloatConfig config) {
        k.e(config, "config");
        this.f1511a = context;
        this.f1512b = config;
        this.f1513c = new Rect();
        this.f1527r = new int[2];
    }

    public static int a(View view) {
        k.e(view, "view");
        Context applicationContext = view.getContext().getApplicationContext();
        k.d(applicationContext, "view.context.applicationContext");
        Resources resources = applicationContext.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
