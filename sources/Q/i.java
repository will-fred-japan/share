package Q;

import android.content.Context;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FontRequestWorker.java */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Callable<k.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f3669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3671d;

    public i(String str, Context context, ArrayList arrayList, int i9) {
        this.f3668a = str;
        this.f3669b = context;
        this.f3670c = arrayList;
        this.f3671d = i9;
    }

    @Override // java.util.concurrent.Callable
    public final k.a call() {
        try {
            String str = this.f3668a;
            return k.b(this.f3669b, this.f3671d, this.f3670c, str);
        } catch (Throwable unused) {
            return new k.a(-3);
        }
    }
}
