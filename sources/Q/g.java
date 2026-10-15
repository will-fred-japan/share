package Q;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FontRequestWorker.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Callable<k.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f3664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f3665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3666d;

    public g(String str, Context context, f fVar, int i9) {
        this.f3663a = str;
        this.f3664b = context;
        this.f3665c = fVar;
        this.f3666d = i9;
    }

    @Override // java.util.concurrent.Callable
    public final k.a call() {
        Object[] objArr = {this.f3665c};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        return k.b(this.f3664b, this.f3666d, Collections.unmodifiableList(arrayList), this.f3663a);
    }
}
