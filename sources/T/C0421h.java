package T;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import cn.ikaile.ruoshui.client.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: T.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: KeyEventDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0421h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4431a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f4432b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f4433c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f4434d;

    /* JADX INFO: renamed from: T.h$a */
    /* JADX INFO: compiled from: KeyEventDispatcher.java */
    public interface a {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        WeakReference<View> weakReferenceValueAt;
        int iIndexOfKey;
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList<WeakReference<View>> arrayList = G.m.f4327d;
        G.m mVar = (G.m) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (mVar == null) {
            mVar = new G.m();
            view.setTag(R.id.tag_unhandled_key_event_manager, mVar);
        }
        WeakReference<KeyEvent> weakReference = mVar.f4330c;
        if (weakReference != null && weakReference.get() == keyEvent) {
            return false;
        }
        mVar.f4330c = new WeakReference<>(keyEvent);
        if (mVar.f4329b == null) {
            mVar.f4329b = new SparseArray<>();
        }
        SparseArray<WeakReference<View>> sparseArray = mVar.f4329b;
        if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) < 0) {
            weakReferenceValueAt = null;
        } else {
            weakReferenceValueAt = sparseArray.valueAt(iIndexOfKey);
            sparseArray.removeAt(iIndexOfKey);
        }
        if (weakReferenceValueAt == null) {
            weakReferenceValueAt = sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReferenceValueAt == null) {
            return false;
        }
        View view2 = weakReferenceValueAt.get();
        if (view2 != null && view2.isAttachedToWindow()) {
            G.m.b(view2, keyEvent);
        }
        return true;
    }

    @SuppressLint({"LambdaLast"})
    public static boolean b(a aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener;
        boolean zBooleanValue = false;
        if (aVar != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return aVar.superDispatchKeyEvent(keyEvent);
            }
            if (callback instanceof Activity) {
                Activity activity = (Activity) callback;
                activity.onUserInteraction();
                Window window = activity.getWindow();
                if (window.hasFeature(8)) {
                    ActionBar actionBar = activity.getActionBar();
                    if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                        if (!f4431a) {
                            try {
                                f4432b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                            } catch (NoSuchMethodException unused) {
                            }
                            f4431a = true;
                        }
                        Method method = f4432b;
                        if (method != null) {
                            try {
                                Object objInvoke = method.invoke(actionBar, keyEvent);
                                if (objInvoke != null) {
                                    zBooleanValue = ((Boolean) objInvoke).booleanValue();
                                }
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        }
                        if (zBooleanValue) {
                            return true;
                        }
                    }
                }
                if (window.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView = window.getDecorView();
                if (G.c(decorView, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
            }
            if (callback instanceof Dialog) {
                Dialog dialog = (Dialog) callback;
                if (!f4433c) {
                    try {
                        Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                        f4434d = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused3) {
                    }
                    f4433c = true;
                }
                Field field = f4434d;
                if (field != null) {
                    try {
                        onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
                    } catch (IllegalAccessException unused4) {
                        onKeyListener = null;
                    }
                } else {
                    onKeyListener = null;
                }
                if (onKeyListener != null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                    return true;
                }
                Window window2 = dialog.getWindow();
                if (window2.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView2 = window2.getDecorView();
                if (G.c(decorView2, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(dialog, decorView2 != null ? decorView2.getKeyDispatcherState() : null, dialog);
            }
            if ((view != null && G.c(view, keyEvent)) || aVar.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
        }
        return false;
    }
}
