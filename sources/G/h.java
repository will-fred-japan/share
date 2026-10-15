package G;

import T.C0421h;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.AbstractC0544j;
import androidx.lifecycle.InterfaceC0548n;

/* JADX INFO: compiled from: ComponentActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public class h extends Activity implements InterfaceC0548n, C0421h.a {
    private final p155u.g<Class<? extends a>, a> extraDataMap = new p155u.g<>(0);
    private final androidx.lifecycle.o lifecycleRegistry = new androidx.lifecycle.o(this);

    /* JADX INFO: compiled from: ComponentActivity.kt */
    public static class a {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        if (r4.equals("--list-dumpables") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
    
        if (r4.equals("--dump-dumpable") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0043, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 33) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean shouldSkipDump(java.lang.String[] r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L57
            int r1 = r4.length
            if (r1 != 0) goto L7
            goto L57
        L7:
            r4 = r4[r0]
            int r1 = r4.hashCode()
            r2 = 1
            switch(r1) {
                case -645125871: goto L47;
                case 100470631: goto L36;
                case 472614934: goto L2d;
                case 1159329357: goto L1c;
                case 1455016274: goto L12;
                default: goto L11;
            }
        L11:
            goto L57
        L12:
            java.lang.String r1 = "--autofill"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L1b
            goto L57
        L1b:
            return r2
        L1c:
            java.lang.String r1 = "--contentcapture"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L25
            goto L57
        L25:
            int r4 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r4 < r1) goto L2c
            return r2
        L2c:
            return r0
        L2d:
            java.lang.String r1 = "--list-dumpables"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L3f
            goto L57
        L36:
            java.lang.String r1 = "--dump-dumpable"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L3f
            goto L57
        L3f:
            int r4 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            if (r4 < r1) goto L46
            return r2
        L46:
            return r0
        L47:
            java.lang.String r1 = "--translation"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L50
            goto L57
        L50:
            int r4 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            if (r4 < r1) goto L57
            return r2
        L57:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: G.h.shouldSkipDump(java.lang.String[]):boolean");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        kotlin.jvm.internal.k.e(event, "event");
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.k.d(decorView, "getDecorView(...)");
        if (C0421h.a(decorView, event)) {
            return true;
        }
        return C0421h.b(this, decorView, this, event);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        kotlin.jvm.internal.k.e(event, "event");
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.k.d(decorView, "getDecorView(...)");
        if (C0421h.a(decorView, event)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(event);
    }

    public <T extends a> T getExtraData(Class<T> extraDataClass) {
        kotlin.jvm.internal.k.e(extraDataClass, "extraDataClass");
        return (T) this.extraDataMap.get(extraDataClass);
    }

    @Override // androidx.lifecycle.InterfaceC0548n
    public AbstractC0544j getLifecycle() {
        return this.lifecycleRegistry;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i9 = androidx.lifecycle.x.f7779b;
        androidx.lifecycle.x.a.b(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.k.e(outState, "outState");
        this.lifecycleRegistry.h(AbstractC0544j.b.f7736c);
        super.onSaveInstanceState(outState);
    }

    public void putExtraData(a extraData) {
        kotlin.jvm.internal.k.e(extraData, "extraData");
        this.extraDataMap.put(a.class, extraData);
    }

    public final boolean shouldDumpInternalState(String[] strArr) {
        return !shouldSkipDump(strArr);
    }

    @Override // T.C0421h.a
    public boolean superDispatchKeyEvent(KeyEvent event) {
        kotlin.jvm.internal.k.e(event, "event");
        return super.dispatchKeyEvent(event);
    }

    private static /* synthetic */ void getExtraDataMap$annotations() {
    }

    private static /* synthetic */ void getLifecycleRegistry$annotations() {
    }
}
