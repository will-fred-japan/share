package p121p7;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.HashMap;
import p050g7.b;
import p088l7.o;
import p096m7.k;
import p096m7.l;
import p096m7.n;

/* JADX INFO: compiled from: ProcessTextPlugin.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements p042f7.a, p050g7.a, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PackageManager f20814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f20815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f20816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f20817d = new HashMap();

    public a(o oVar) {
        this.f20814a = oVar.f20186a;
        oVar.f20187b = this;
    }

    public final void a(String str, String str2, boolean z8, k kVar) {
        if (this.f20815b == null) {
            kVar.error("error", "Plugin not bound to an Activity", null);
            return;
        }
        HashMap map = this.f20816c;
        if (map == null) {
            kVar.error("error", "Can not process text actions before calling queryTextActions", null);
            return;
        }
        ResolveInfo resolveInfo = (ResolveInfo) map.get(str);
        if (resolveInfo == null) {
            kVar.error("error", "Text processing activity not found", null);
            return;
        }
        int iHashCode = kVar.hashCode();
        this.f20817d.put(Integer.valueOf(iHashCode), kVar);
        Intent intent = new Intent();
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent.setClassName(activityInfo.packageName, activityInfo.name);
        intent.setAction("android.intent.action.PROCESS_TEXT");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.PROCESS_TEXT", str2);
        intent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", z8);
        ((a7.a.b) this.f20815b).f5737a.startActivityForResult(intent, iHashCode);
    }

    public final HashMap b() {
        HashMap map = this.f20816c;
        PackageManager packageManager = this.f20814a;
        if (map == null) {
            this.f20816c = new HashMap();
            Intent type = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
            for (ResolveInfo resolveInfo : Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(type, PackageManager.ResolveInfoFlags.of(0L)) : packageManager.queryIntentActivities(type, 0)) {
                String str = resolveInfo.activityInfo.name;
                resolveInfo.loadLabel(packageManager).toString();
                this.f20816c.put(str, resolveInfo);
            }
        }
        HashMap map2 = new HashMap();
        for (String str2 : this.f20816c.keySet()) {
            map2.put(str2, ((ResolveInfo) this.f20816c.get(str2)).loadLabel(packageManager).toString());
        }
        return map2;
    }

    @Override // p096m7.n
    public final boolean onActivityResult(int i9, int i10, Intent intent) {
        HashMap map = this.f20817d;
        if (!map.containsKey(Integer.valueOf(i9))) {
            return false;
        }
        ((l.d) map.remove(Integer.valueOf(i9))).success(i10 == -1 ? intent.getStringExtra("android.intent.extra.PROCESS_TEXT") : null);
        return true;
    }

    @Override // p050g7.a
    public final void onAttachedToActivity(b bVar) {
        this.f20815b = bVar;
        ((a7.a.b) bVar).a(this);
    }

    @Override // p050g7.a
    public final void onDetachedFromActivity() {
        ((a7.a.b) this.f20815b).c(this);
        this.f20815b = null;
    }

    @Override // p050g7.a
    public final void onDetachedFromActivityForConfigChanges() {
        ((a7.a.b) this.f20815b).c(this);
        this.f20815b = null;
    }

    @Override // p050g7.a
    public final void onReattachedToActivityForConfigChanges(b bVar) {
        this.f20815b = bVar;
        ((a7.a.b) bVar).a(this);
    }

    @Override // p042f7.a
    public final void onAttachedToEngine(f7.a.b bVar) {
    }

    @Override // p042f7.a
    public final void onDetachedFromEngine(f7.a.b bVar) {
    }
}
