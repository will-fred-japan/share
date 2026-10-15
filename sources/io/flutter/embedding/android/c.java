package io.flutter.embedding.android;

import android.text.Selection;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import io.flutter.plugin.editing.f;
import java.util.HashSet;
import l7.e.a;
import p088l7.e;
import p096m7.l;
import p096m7.s;

/* JADX INFO: compiled from: KeyboardManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements io.flutter.plugin.editing.a.InterfaceC0216a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0212c[] f19387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<KeyEvent> f19388b = new HashSet<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f19389c;

    /* JADX INFO: compiled from: KeyboardManager.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19390a = 0;

        public final Character a(int i9) {
            char c5 = (char) i9;
            if ((Integer.MIN_VALUE & i9) != 0) {
                int i10 = i9 & Integer.MAX_VALUE;
                int i11 = this.f19390a;
                if (i11 != 0) {
                    this.f19390a = KeyCharacterMap.getDeadChar(i11, i10);
                } else {
                    this.f19390a = i10;
                }
            } else {
                int i12 = this.f19390a;
                if (i12 != 0) {
                    int deadChar = KeyCharacterMap.getDeadChar(i12, i9);
                    if (deadChar > 0) {
                        c5 = (char) deadChar;
                    }
                    this.f19390a = 0;
                }
            }
            return Character.valueOf(c5);
        }
    }

    /* JADX INFO: compiled from: KeyboardManager.java */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KeyEvent f19391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f19393c = false;

        /* JADX INFO: compiled from: KeyboardManager.java */
        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f19395a = false;

            public a() {
            }

            public final void a(boolean z8) {
                if (this.f19395a) {
                    throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
                }
                this.f19395a = true;
                b bVar = b.this;
                int i9 = bVar.f19392b - 1;
                bVar.f19392b = i9;
                boolean z9 = z8 | bVar.f19393c;
                bVar.f19393c = z9;
                if (i9 != 0 || z9) {
                    return;
                }
                c.this.b(bVar.f19391a);
            }
        }

        public b(KeyEvent keyEvent) {
            this.f19392b = c.this.f19387a.length;
            this.f19391a = keyEvent;
        }
    }

    /* JADX INFO: renamed from: io.flutter.embedding.android.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: KeyboardManager.java */
    public interface InterfaceC0212c {
        void a(KeyEvent keyEvent, b.a aVar);
    }

    /* JADX INFO: compiled from: KeyboardManager.java */
    public interface d {
        p096m7.c getBinaryMessenger();
    }

    public c(d dVar) {
        this.f19389c = dVar;
        this.f19387a = new InterfaceC0212c[]{new io.flutter.embedding.android.b(dVar.getBinaryMessenger()), new io.flutter.embedding.android.a(new p088l7.d(dVar.getBinaryMessenger()))};
        p096m7.c binaryMessenger = dVar.getBinaryMessenger();
        e eVar = new e();
        new l(binaryMessenger, "flutter/keyboard", s.f20511a, null).b(eVar.new a());
        eVar.f20115a = this;
    }

    public final boolean a(KeyEvent keyEvent) {
        if (this.f19388b.remove(keyEvent)) {
            return false;
        }
        InterfaceC0212c[] interfaceC0212cArr = this.f19387a;
        if (interfaceC0212cArr.length <= 0) {
            b(keyEvent);
            return true;
        }
        b bVar = new b(keyEvent);
        for (InterfaceC0212c interfaceC0212c : interfaceC0212cArr) {
            interfaceC0212c.a(keyEvent, bVar.new a());
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x008e  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b0  */
    public final void b(KeyEvent keyEvent) {
        InputConnection inputConnection;
        io.flutter.plugin.editing.b bVar;
        int selectionStart;
        int selectionEnd;
        int unicodeChar;
        int iMin;
        int iMax;
        d dVar = this.f19389c;
        if (dVar != null) {
            f fVar = ((FlutterView) dVar).f19359m;
            boolean zSendKeyEvent = false;
            if (fVar.f19545b.isAcceptingText() && (inputConnection = fVar.j) != null) {
                if (inputConnection instanceof io.flutter.plugin.editing.a) {
                    io.flutter.plugin.editing.a aVar = (io.flutter.plugin.editing.a) inputConnection;
                    if (keyEvent.getAction() == 0) {
                        if (keyEvent.getKeyCode() == 21) {
                            zSendKeyEvent = aVar.d(true, keyEvent.isShiftPressed());
                        } else if (keyEvent.getKeyCode() == 22) {
                            zSendKeyEvent = aVar.d(false, keyEvent.isShiftPressed());
                        } else if (keyEvent.getKeyCode() == 19) {
                            zSendKeyEvent = aVar.e(true, keyEvent.isShiftPressed());
                        } else if (keyEvent.getKeyCode() == 20) {
                            zSendKeyEvent = aVar.e(false, keyEvent.isShiftPressed());
                        } else if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
                            EditorInfo editorInfo = aVar.f19509e;
                            if ((editorInfo.inputType & 131072) == 0) {
                                aVar.performEditorAction(editorInfo.imeOptions & 255);
                            } else {
                                bVar = aVar.f19508d;
                                selectionStart = Selection.getSelectionStart(bVar);
                                selectionEnd = Selection.getSelectionEnd(bVar);
                                unicodeChar = keyEvent.getUnicodeChar();
                                if (selectionStart >= 0 && selectionEnd >= 0 && unicodeChar != 0) {
                                    iMin = Math.min(selectionStart, selectionEnd);
                                    iMax = Math.max(selectionStart, selectionEnd);
                                    aVar.beginBatchEdit();
                                    if (iMin != iMax) {
                                        bVar.delete(iMin, iMax);
                                    }
                                    bVar.insert(iMin, (CharSequence) String.valueOf((char) unicodeChar));
                                    int i9 = iMin + 1;
                                    aVar.setSelection(i9, i9);
                                    aVar.endBatchEdit();
                                }
                            }
                            zSendKeyEvent = true;
                        } else {
                            bVar = aVar.f19508d;
                            selectionStart = Selection.getSelectionStart(bVar);
                            selectionEnd = Selection.getSelectionEnd(bVar);
                            unicodeChar = keyEvent.getUnicodeChar();
                            if (selectionStart >= 0) {
                                iMin = Math.min(selectionStart, selectionEnd);
                                iMax = Math.max(selectionStart, selectionEnd);
                                aVar.beginBatchEdit();
                                if (iMin != iMax) {
                                    bVar.delete(iMin, iMax);
                                }
                                bVar.insert(iMin, (CharSequence) String.valueOf((char) unicodeChar));
                                int i10 = iMin + 1;
                                aVar.setSelection(i10, i10);
                                aVar.endBatchEdit();
                                zSendKeyEvent = true;
                            }
                        }
                    }
                } else {
                    zSendKeyEvent = inputConnection.sendKeyEvent(keyEvent);
                }
            }
            if (zSendKeyEvent) {
                return;
            }
            HashSet<KeyEvent> hashSet = this.f19388b;
            hashSet.add(keyEvent);
            ((FlutterView) dVar).getRootView().dispatchKeyEvent(keyEvent);
            if (hashSet.remove(keyEvent)) {
                Log.w("KeyboardManager", "A redispatched key event was consumed before reaching KeyboardManager");
            }
        }
    }
}
