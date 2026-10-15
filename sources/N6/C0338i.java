package N6;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: N6.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: StarburstBleAuthPlugin.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0338i implements m7.l.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p096m7.k f3341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f3342b = new AtomicBoolean(false);

    public C0338i(p096m7.k kVar) {
        this.f3341a = kVar;
    }

    @Override // m7.l.d
    public final void error(String errorCode, String str, Object obj) {
        kotlin.jvm.internal.k.e(errorCode, "errorCode");
        if (this.f3342b.compareAndSet(false, true)) {
            this.f3341a.error(errorCode, str, obj);
            p188x7.k kVar = p188x7.k.f22364a;
        } else if (p142s2.j.f21198l) {
            Log.w("StarburstBleAuthPlugin", "MethodChannel.Result: duplicate reply ignored");
        }
    }

    @Override // m7.l.d
    public final void notImplemented() {
        if (this.f3342b.compareAndSet(false, true)) {
            this.f3341a.notImplemented();
            p188x7.k kVar = p188x7.k.f22364a;
        } else if (p142s2.j.f21198l) {
            Log.w("StarburstBleAuthPlugin", "MethodChannel.Result: duplicate reply ignored");
        }
    }

    @Override // m7.l.d
    public final void success(Object obj) {
        if (this.f3342b.compareAndSet(false, true)) {
            this.f3341a.success(obj);
            p188x7.k kVar = p188x7.k.f22364a;
        } else if (p142s2.j.f21198l) {
            Log.w("StarburstBleAuthPlugin", "MethodChannel.Result: duplicate reply ignored");
        }
    }
}
