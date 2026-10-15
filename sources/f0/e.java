package f0;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: compiled from: EmojiKeyListener.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements KeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyListener f18656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f18657b;

    /* JADX INFO: compiled from: EmojiKeyListener.java */
    public static class a {
    }

    public e(KeyListener keyListener) {
        a aVar = new a();
        this.f18656a = keyListener;
        this.f18657b = aVar;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i9) {
        this.f18656a.clearMetaKeyState(view, editable, i9);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.f18656a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i9, KeyEvent keyEvent) {
        boolean zA;
        boolean z8;
        this.f18657b.getClass();
        if (i9 != 67) {
            zA = i9 != 112 ? false : p022d0.g.a(editable, keyEvent, true);
        } else {
            zA = p022d0.g.a(editable, keyEvent, false);
        }
        if (zA) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z8 = true;
        } else {
            z8 = false;
        }
        return z8 || this.f18656a.onKeyDown(view, editable, i9, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f18656a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i9, KeyEvent keyEvent) {
        return this.f18656a.onKeyUp(view, editable, i9, keyEvent);
    }
}
