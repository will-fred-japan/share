package p089m;

import android.view.ActionMode;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* JADX INFO: compiled from: WindowCallbackWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window.Callback f20308a;

    /* JADX INFO: compiled from: WindowCallbackWrapper.java */
    public static class a {
        public static boolean a(Window.Callback callback, SearchEvent searchEvent) {
            return callback.onSearchRequested(searchEvent);
        }

        public static ActionMode b(Window.Callback callback, ActionMode.Callback callback2, int i9) {
            return callback.onWindowStartingActionMode(callback2, i9);
        }
    }

    /* JADX INFO: compiled from: WindowCallbackWrapper.java */
    public static class b {
        public static void a(Window.Callback callback, List<KeyboardShortcutGroup> list, Menu menu, int i9) {
            callback.onProvideKeyboardShortcuts(list, menu, i9);
        }
    }

    /* JADX INFO: compiled from: WindowCallbackWrapper.java */
    public static class c {
        public static void a(Window.Callback callback, boolean z8) {
            callback.onPointerCaptureChanged(z8);
        }
    }

    public h(Window.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f20308a = callback;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f20308a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f20308a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f20308a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f20308a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f20308a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f20308a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f20308a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f20308a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i9, MenuItem menuItem) {
        return this.f20308a.onMenuItemSelected(i9, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i9, Menu menu) {
        return this.f20308a.onMenuOpened(i9, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i9, Menu menu) {
        this.f20308a.onPanelClosed(i9, menu);
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z8) {
        c.a(this.f20308a, z8);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i9) {
        b.a(this.f20308a, list, menu, i9);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return a.a(this.f20308a, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f20308a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z8) {
        this.f20308a.onWindowFocusChanged(z8);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f20308a.onSearchRequested();
    }
}
